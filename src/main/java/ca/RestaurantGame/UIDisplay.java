package ca.RestaurantGame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIDisplay extends JFrame {
    GameData game;
    JPanel mainPanel;
    DefaultListModel<String> menuList = new DefaultListModel<>();
    DefaultListModel<String> itemsList = new DefaultListModel<>();
    DefaultListModel<String> ingredients = new DefaultListModel<>();
    DefaultListModel<String> recipePacks = new DefaultListModel<String>();
    DefaultListModel<String> recipesInPack = new DefaultListModel<>();
    DefaultListModel<String> recipes = new DefaultListModel<>();
    DefaultListModel<String> recipeIngredients = new DefaultListModel<>();

    public UIDisplay(GameData g) {
        game = g;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 450));
        mainPanel = new JPanel(new CardLayout());
        setupCards();
        add(mainPanel);
        pack();
    }

    public void setupCards() {
        JPanel PreServiceScreen = getPSSJPanel();
        JPanel MenuSetup = getMenuJPanel();
        JPanel IngredientPurchasing = getIngredientJPanel();
        JPanel RecipePackPurchasing = getRecipePackJPanel();
        JPanel RecipeView = getRecipeViewJPanel();

        mainPanel.add(RecipeView, UINames.RECIPE_VIEW.name());
        mainPanel.add(MenuSetup, UINames.MENU_SETUP.name());
        mainPanel.add(RecipePackPurchasing, UINames.RECIPE_PACK_PURCHASING.name());
        mainPanel.add(IngredientPurchasing, UINames.INGREDIENT_PURCHASING.name());
        mainPanel.add(PreServiceScreen, UINames.PRE_SERVICE_SCREEN.name());

    }

    private JPanel getRecipeViewJPanel() {
        JPanel RecipeView = new JPanel();
        RecipeView.setPreferredSize(new Dimension(750, 450));

        JLabel jLabel21, jLabel22, jLabel23, jLabel24;
        JList<String> jList9, jList10;
        JTextArea jTextArea2;
        JScrollPane jScrollPane10, jScrollPane11, jScrollPane12;
        JButton jButton25;

        jLabel21 = new JLabel("RECIPES");
        jLabel21.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel21.setPreferredSize(new Dimension(350, 30));

        jList9 = new JList<>(recipes);
        jScrollPane10 = new JScrollPane();
        jScrollPane10.setViewportView(jList9);

        jList10 = new JList<>(recipeIngredients);
        jScrollPane11 = new JScrollPane();
        jScrollPane11.setViewportView(jList10);

        jTextArea2 = new JTextArea(5, 20);
        jScrollPane12 = new JScrollPane();
        jScrollPane12.setViewportView(jTextArea2);

        jList9.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selection = jList9.getSelectedValue();
                Recipe recipe = DataTranslator.recipe_NameToRecipe(selection);
                if (recipe != null) {
                    //Display meal cooking instructions
                    jTextArea2.setText("");
                    for (String a : recipe.instructions) {
                        jTextArea2.append(a + "\n");
                    }
                    //List all ingredients
                    recipeIngredients.clear();
                    for (String ingredientID : recipe.ingredients) {
                        recipeIngredients.addElement(DataTranslator.ingredient_IDToName(ingredientID));
                    }
                }
            }
        });

        jLabel22 = new JLabel("RECIPE");
        jLabel22.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel22.setPreferredSize(new Dimension(100, 25));

        jLabel23 = new JLabel("INGREDIENTS");
        jLabel23.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel23.setPreferredSize(new Dimension(100, 25));

        jLabel24 = new JLabel("COOKING INSTRUCTIONS");
        jLabel24.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel24.setPreferredSize(new Dimension(100, 25));

        jButton25 = new JButton("Exit");
        jButton25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(UINames.MENU_SETUP);
                jList9.clearSelection();
            }
        });

        javax.swing.GroupLayout RecipeViewLayout = new javax.swing.GroupLayout(RecipeView);
        RecipeView.setLayout(RecipeViewLayout);
        RecipeViewLayout.setHorizontalGroup(
                RecipeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RecipeViewLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(RecipeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(RecipeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(RecipeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane11, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100))
                        .addGroup(RecipeViewLayout.createSequentialGroup()
                                .addGroup(RecipeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(RecipeViewLayout.createSequentialGroup()
                                                .addGap(350, 350, 350)
                                                .addComponent(jButton25))
                                        .addGroup(RecipeViewLayout.createSequentialGroup()
                                                .addGap(200, 200, 200)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RecipeViewLayout.setVerticalGroup(
                RecipeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RecipeViewLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addGroup(RecipeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(RecipeViewLayout.createSequentialGroup()
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane12))
                                        .addGroup(RecipeViewLayout.createSequentialGroup()
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(RecipeViewLayout.createSequentialGroup()
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane10)))
                                .addGap(46, 46, 46)
                                .addComponent(jButton25)
                                .addGap(34, 34, 34))
        );
        return RecipeView;
    }
    private JPanel getRecipePackJPanel() {
        JPanel RecipePackPurchasing = new JPanel();
        RecipePackPurchasing.setPreferredSize(new Dimension(750, 450));

        JLabel jLabel6, jLabel7, jLabel8, jLabel9;
        JList<String> jList4, jList5;
        JScrollPane jScrollPane4, jScrollPane5;
        JButton jButton6, jButton7;

        jLabel6 = new JLabel("RECIPE PACK PURCHASING");
        jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel9 = new JLabel("Cost: $0.00");
        jLabel9.setPreferredSize(new java.awt.Dimension(90, 20));

        jList4 = new JList<>(recipePacks);
        jList4.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selection = jList4.getSelectedValue();
                if (selection != null) {
                    recipesInPack.clear();
                    RecipePack pack = DataLoader.recipePacks.get(DataLoader.recipePacks.indexOf(DataTranslator.recipePack_NameToRecipePack(selection)));
                    for (String r : pack.recipes) {
                        recipesInPack.addElement(DataTranslator.recipe_IDToName(r));
                    }
                    jLabel9.setText("Cost: $" + String.format("%.2f", pack.cost));
                }
            }
        });
        jScrollPane4 = new JScrollPane();
        jScrollPane4.setViewportView(jList4);

        jLabel7 = new JLabel("AVAILABLE RECIPE PACKS");
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel8 = new JLabel("RECIPES CONTAINED");
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);


        jList5 = new JList<>(recipesInPack);
        jList5.setPreferredSize(new Dimension(50, 90));
        jScrollPane5 = new JScrollPane();
        jScrollPane5.setViewportView(jList5);

        jButton6 = new JButton("Purchase Pack");
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = jList4.getSelectedValue();
                if (selection != null) {
                    //TODO: Complete purchase availability - infinite for now
                    recipesInPack.clear();
                    jLabel9.setText("Cost: $0.00");
                    RecipePack pack = DataLoader.recipePacks.get(DataLoader.recipePacks.indexOf(DataTranslator.recipePack_NameToRecipePack(selection)));
                    game.unlocked_packs.add(pack.id);
                    for (String r : pack.recipes) {
                        itemsList.addElement(DataTranslator.recipe_IDToRecipe(r).name);
                    }
                    recipePacks.removeElement(pack.name);
                }
            }
        });

        jButton7 = new JButton("Complete Purchasing");
        jButton7.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(UINames.PRE_SERVICE_SCREEN);
            }
        });


        GroupLayout RecipePackPurchasingLayout = new GroupLayout(RecipePackPurchasing);
        RecipePackPurchasing.setLayout(RecipePackPurchasingLayout);
        RecipePackPurchasingLayout.setHorizontalGroup(
                RecipePackPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, RecipePackPurchasingLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(RecipePackPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(RecipePackPurchasingLayout.createSequentialGroup()
                                                .addGroup(RecipePackPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane4)
                                                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                                .addGroup(RecipePackPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane5)
                                                        .addComponent(jButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(100, 100, 100))
                        .addGroup(GroupLayout.Alignment.TRAILING, RecipePackPurchasingLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250))
        );
        RecipePackPurchasingLayout.setVerticalGroup(
                RecipePackPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(RecipePackPurchasingLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel6)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(RecipePackPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(RecipePackPurchasingLayout.createSequentialGroup()
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane5, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton6))
                                        .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jButton7)
                                .addGap(15, 15, 15))
        );
        return RecipePackPurchasing;
    }
    private JPanel getIngredientJPanel() {
        JPanel IngredientPurchasing = new JPanel();
        IngredientPurchasing.setPreferredSize(new Dimension(750, 450));


        JList<String> jList3;
        JScrollPane jScrollPane3 = new JScrollPane();
        JLabel jLabel4, jLabel5, jLabel6, jLabel7;
        JTextField jTextField2;
        JButton jButton4, jButton5;

        jLabel7 = new JLabel("Cost per Unit: $0.00");
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);

        jList3 = new JList<>(ingredients);
        jList3.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selection = jList3.getSelectedValue();
                if (selection != null) {
                    jLabel7.setText("Cost per Unit: $" + String.format("%.2f", DataTranslator.ingredient_NameToIngredient(selection).purchasePrice));
                }
            }
        });
        jScrollPane3.setViewportView(jList3);

        jLabel4 = new JLabel("AVAILABLE INGREDIENTS");
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setPreferredSize(new Dimension(150, 30));
        jLabel4.setRequestFocusEnabled(false);

        jLabel5 = new JLabel("INGREDIENT PURCHASING");
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        jLabel5.setPreferredSize(new Dimension(300, 30));

        jLabel6 = new JLabel("Quantity:");

        jTextField2 = new JTextField("Amount Here...");

        jButton4 = new JButton("Purchase");
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = jList3.getSelectedValue();
                if (selection == null) {
                    JOptionPane.showMessageDialog(null, "You haven't selected an ingredient to purchase!", "NO SELECTED INGREDIENT", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    int quantity = Integer.parseInt(jTextField2.getText());
                    if (quantity > 0) {
                        Ingredient i = DataTranslator.ingredient_NameToIngredient(selection);
                        double cost = (double) Math.round((quantity * i.purchasePrice) * 100) / 100;
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to purchase " + quantity + " units of " + i.name + " for $" + String.format("%.2f", cost) + "?", "CONFIRM PURCHASE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (result == JOptionPane.YES_OPTION) {
                            if (game.money < cost) {
                                JOptionPane.showMessageDialog(null, "You can't afford it!", "INSUFFICIENT BALANCE", JOptionPane.ERROR_MESSAGE);
                            } else {
                                game.money -= cost;
                                if (game.ingredientStock.keySet().contains(i.id)) {
                                    game.ingredientStock.replace(i.id, game.ingredientStock.get(i.id) + quantity);
                                } else {
                                    game.ingredientStock.put(i.id, quantity);
                                }
                                JOptionPane.showMessageDialog(null, "Purchase complete", "PURCHASE COMPLETE", JOptionPane.INFORMATION_MESSAGE);
                                jTextField2.setText("");
                                jList3.clearSelection();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Purchase cancelled", "PURCHASE CANCELLED", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "You haven't entered a valid quantity to purchase!", "INVALID QUANTITY", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, "You haven't entered a valid value!", "INVALID QUANTITY", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        jButton5 = new JButton("Complete Purchasing");
        jButton5.setFont(new Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(UINames.PRE_SERVICE_SCREEN);
            }
        });

        GroupLayout IngredientPurchasingLayout = new GroupLayout(IngredientPurchasing);
        IngredientPurchasing.setLayout(IngredientPurchasingLayout);
        IngredientPurchasingLayout.setHorizontalGroup(
                IngredientPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(IngredientPurchasingLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(IngredientPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane3)
                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                                .addGroup(IngredientPurchasingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(IngredientPurchasingLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(IngredientPurchasingLayout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(IngredientPurchasingLayout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(86, 86, 86))
                                )
                        )
                        .addGroup(IngredientPurchasingLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, IngredientPurchasingLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250)
                        )

        );
        IngredientPurchasingLayout.setVerticalGroup(
                IngredientPurchasingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IngredientPurchasingLayout.createSequentialGroup()
                                .addContainerGap(46, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(IngredientPurchasingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IngredientPurchasingLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(44, 44, 44)
                                                .addGroup(IngredientPurchasingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)
                                                .addComponent(jButton4))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );
        return IngredientPurchasing;
    }
    private JPanel getMenuJPanel() {
        JPanel MenuSetup = new JPanel();
        MenuSetup.setPreferredSize(new Dimension(750, 450));

        JList<String> jList1, jList2;
        JScrollPane jScrollPane1, jScrollPane2;
        JLabel jLabel1, jLabel2, jLabel3;
        JButton jButton1, jButton2, jButton3, jButton4;

        jList1 = new JList<>();
        jList1.setModel(menuList);
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(jList1);

        jLabel1 = new JLabel("Current Menu");
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setPreferredSize(new Dimension(100, 25));

        jList2 = new JList<>();
        jList2.setModel(itemsList);
        jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(jList2);

        jLabel2 = new JLabel("Available Items");
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setPreferredSize(new Dimension(100, 25));

        jLabel3 = new JLabel("MENU SELECTION");
        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        jButton1 = new JButton("Add Item");
        jButton1.setPreferredSize(new Dimension(90, 20));
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jList2.getSelectedIndex() > -1) {
                    menuList.addElement(jList2.getSelectedValue());
                    itemsList.remove(jList2.getSelectedIndex());
                }
            }
        });

        jButton2 = new JButton("Remove item");
        jButton2.setPreferredSize(new Dimension(90, 20));
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jList1.getSelectedIndex() > -1) {
                    itemsList.addElement(jList1.getSelectedValue());
                    menuList.remove(jList1.getSelectedIndex());
                }
            }
        });

        jButton3 = new JButton("Confirm Menu");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(UINames.PRE_SERVICE_SCREEN);
            }
        });

        jButton4 = new JButton("View Recipes");
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recipes.clear();
                for (String pack_name : game.unlocked_packs) {
                    RecipePack pack = DataTranslator.recipePack_IDToRecipePack(pack_name);
                    for (String recipe_ID : pack.recipes) {
                        recipes.addElement(DataTranslator.recipe_IDToName(recipe_ID));
                    }
                }
                showPanel(UINames.RECIPE_VIEW);
            }
        });

        GroupLayout MenuSetupLayout = new GroupLayout(MenuSetup);
        MenuSetup.setLayout(MenuSetupLayout);
        MenuSetupLayout.setHorizontalGroup(
                MenuSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MenuSetupLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(MenuSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MenuSetupLayout.createSequentialGroup()
                                                .addGroup(MenuSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(MenuSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(50, 50, 50))
                        .addGroup(MenuSetupLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(275, 275, 275))
        );
        MenuSetupLayout.setVerticalGroup(
                MenuSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MenuSetupLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(MenuSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(MenuSetupLayout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(MenuSetupLayout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(MenuSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(MenuSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MenuSetupLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(30, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSetupLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton4)
                                                .addGap(25, 25, 25))))
        );
        return MenuSetup;
    }
    private JPanel getPSSJPanel() {
        JPanel PreServiceScreen = new JPanel();
        PreServiceScreen.setPreferredSize(new Dimension(750, 450));

        JButton jButton8, jButton9, jButton10, jButton11;
        JLabel jLabel9, jLabel10;

        jLabel9 = new JLabel("PRE-SERVICE SETUP");
        jLabel9.setFont(new Font("Segoe UI", Font.PLAIN, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel10 = new JLabel("""
                <html>
                Your next service is coming up, and you need to set up shop!<br>
                Purchase recipe packs to unlock new recipes to use!<br>
                Set up the menu for certain dishes for the service!<br>
                Purchase ingredients for each menu item to prepare for the service!<br>
                Spend wisely!</html>
                """);
        jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel10.setPreferredSize(new Dimension(300, 100));

        jButton8 = new JButton("Purchase Recipe Packs");
        jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(UINames.RECIPE_PACK_PURCHASING);
            }
        });

        jButton9 = new JButton("Purchase Ingredients");
        jButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(UINames.INGREDIENT_PURCHASING);
            }
        });

        jButton10 = new JButton("Setup Menu");
        jButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(UINames.MENU_SETUP);
            }
        });

        jButton11 = new JButton("Start Service");
        jButton11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Complete
            }
        });

        GroupLayout PreServiceScreenLayout = new GroupLayout(PreServiceScreen);
        PreServiceScreen.setLayout(PreServiceScreenLayout);
        PreServiceScreenLayout.setHorizontalGroup(
                PreServiceScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PreServiceScreenLayout.createSequentialGroup()
                                .addGroup(PreServiceScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, PreServiceScreenLayout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PreServiceScreenLayout.createSequentialGroup()
                                                .addGap(225, 225, 225)
                                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 25, Short.MAX_VALUE)))
                                .addGap(200, 200, 200))
                        .addGroup(PreServiceScreenLayout.createSequentialGroup()
                                .addGroup(PreServiceScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(PreServiceScreenLayout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PreServiceScreenLayout.createSequentialGroup()
                                                .addGap(300, 300, 300)
                                                .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PreServiceScreenLayout.setVerticalGroup(
                PreServiceScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PreServiceScreenLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(PreServiceScreenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
        );
        return PreServiceScreen;
    }

    public void showPanel(UINames name) {
        CardLayout cl = ((CardLayout) mainPanel.getLayout());
        cl.show(mainPanel, String.valueOf(name));
        pack();
    }
}
