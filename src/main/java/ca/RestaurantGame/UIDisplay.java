package ca.RestaurantGame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UIDisplay extends JFrame {
    TimeClass timer = new TimeClass(this);
    GameData game;
    JPanel mainPanel;
    DefaultListModel<String> menuList = new DefaultListModel<>();
    DefaultListModel<String> itemsList = new DefaultListModel<>();
    DefaultListModel<String> ingredients = new DefaultListModel<>();
    DefaultListModel<String> recipePacks = new DefaultListModel<String>();
    DefaultListModel<String> recipesInPack = new DefaultListModel<>();
    DefaultListModel<String> recipes = new DefaultListModel<>();
    DefaultListModel<String> recipeIngredients = new DefaultListModel<>();
    Map<String, Customer> customersByName = new HashMap<>();
    DefaultListModel<String> customers = new DefaultListModel<>();

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
        JPanel ServiceFront = getServiceFrontJPanel();

        JPanel ServiceKitchen = new JPanel();
        ServiceKitchen.setPreferredSize(new java.awt.Dimension(650, 400));

        JLabel jLabel14, jLabel15, jLabel16;
        JList<String> jList7, jList8;
        JScrollPane jScrollPane8, jScrollPane9;
        JButton jButton17, jButton18, jButton19, jButton20, jButton21, jButton22, jButton26;

        jLabel14 = new JLabel("KITCHEN");
        jLabel14.setFont(
                new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jList7 = new JList<>();
        jScrollPane8 = new JScrollPane();
        jScrollPane8.setViewportView(jList7);

        jLabel15 = new JLabel("ORDERS");
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton17 = new JButton("View Order");
        jButton17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Complete
            }
        });

        jButton18 = new JButton("View Recipes");
        jButton18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Complete
            }
        });

        jList8 = new JList<>();
        jScrollPane9 = new JScrollPane();
        jScrollPane9.setViewportView(jList8);

        jLabel16 = new JLabel("EQUIPMENT");
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton20 = new JButton("Use Equipment");
        jButton20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Complete
            }
        });

        jButton21 = new JButton("Assemble Meal");
        jButton21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Complete
            }
        });

        jButton22 = new JButton("To Front");
        jButton22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(UINames.SERVICE_FRONT_OF_HOUSE);
            }
        });

        jButton26 = new JButton("Ingredients");
        jButton26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Complete
            }
        });

        javax.swing.GroupLayout ServiceKitchenLayout = new javax.swing.GroupLayout(ServiceKitchen);
        ServiceKitchen.setLayout(ServiceKitchenLayout);
        ServiceKitchenLayout.setHorizontalGroup(
                ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ServiceKitchenLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane8)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addGroup(ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ServiceKitchenLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                                                .addGroup(ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServiceKitchenLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)))
                                .addGap(60, 60, 60))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServiceKitchenLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                        .addGroup(ServiceKitchenLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ServiceKitchenLayout.setVerticalGroup(
                ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ServiceKitchenLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton17)
                                        .addComponent(jButton20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton21)
                                .addGap(37, 37, 37)
                                .addGroup(ServiceKitchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton18)
                                        .addComponent(jButton26))
                                .addGap(25, 25, 25))
        );

        mainPanel.add(ServiceKitchen, UINames.SERVICE_KITCHEN.name());
        mainPanel.add(RecipeView, UINames.RECIPE_VIEW.name());
        mainPanel.add(MenuSetup, UINames.MENU_SETUP.name());
        mainPanel.add(ServiceFront, UINames.SERVICE_FRONT_OF_HOUSE.name());
        mainPanel.add(RecipePackPurchasing, UINames.RECIPE_PACK_PURCHASING.name());
        mainPanel.add(IngredientPurchasing, UINames.INGREDIENT_PURCHASING.name());
        mainPanel.add(PreServiceScreen, UINames.PRE_SERVICE_SCREEN.name());

    }

    private JPanel getServiceFrontJPanel() {
        JPanel ServiceFront = new JPanel();
        ServiceFront.setPreferredSize(new Dimension(750, 450));

        JList<String> jList6;
        JTextArea jTextArea1;
        JScrollPane jScrollPane6, jScrollPane7;
        JLabel jLabel11, jLabel12, jLabel13;
        JButton jButton13, jButton14, jButton15, jButton16;

        //TODO: Fix
        jList6 = new JList<>(customers);
        jList6.setMaximumSize(new Dimension(45, 100));
        jScrollPane6 = new JScrollPane();
        jScrollPane6.setViewportView(jList6);

        jLabel11 = new JLabel("CUSTOMERS");
        jLabel11.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel12 = new JLabel("FRONT OF HOUSE");
        jLabel12.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);

        jTextArea1 = new JTextArea(5, 20);
        jTextArea1.setPreferredSize(new Dimension(200, 100));
        jTextArea1.setEditable(false);
        jScrollPane7 = new JScrollPane();
        jScrollPane7.setViewportView(jTextArea1);

        jButton13 = new JButton("Check Customer");
        jButton13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Complete
                String custName = jList6.getSelectedValue();
                Customer c = customersByName.get(custName);
                if (c != null) {
                    jTextArea1.setText("");
                    jTextArea1.append("Order Taken: " + (c.orderTaken ? "YES" : "NO") + "\n");
                    if (c.orderTaken) {
                        jTextArea1.append("\nORDER DETAILS:\n");
                        for (String n : c.order.mealsOrdered) {
                            jTextArea1.append("- " + DataTranslator.recipe_IDToName(n) + "\n");
                        }
                    }
                }
            }
        });

        jLabel13 = new JLabel("CUSTOMER DETAILS");
        jLabel13.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(SwingConstants.CENTER);

        jButton14 = new JButton("Take Order");
        jButton14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Complete
                String custName = jList6.getSelectedValue();
                Customer c = customersByName.get(custName);
                if (c != null) {
                    if (c.orderTaken) {
                        JOptionPane.showMessageDialog(null, "You already took this customer's order!", "ORDER ALREADY TAKEN", JOptionPane.ERROR_MESSAGE);
                    } else {
                        c.orderTaken = true;
                        jTextArea1.setText("");
                        jTextArea1.append("Order Taken: " + (c.orderTaken ? "YES" : "NO") + "\n");
                        if (c.orderTaken) {
                            jTextArea1.append("\nORDER DETAILS:\n");
                            for (String n : c.order.mealsOrdered) {
                                jTextArea1.append("- " + DataTranslator.recipe_IDToName(n) + "\n");
                            }
                        }
                    }
                }
            }
        });

        jButton15 = new JButton("Serve");
        jButton15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> options = new ArrayList<>();
                for (Meal m : game.completeMeals) {
                    options.add(m.struct.name);
                }
                if (options.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You don't have anything to serve!", "EMPTY INVENTORY", JOptionPane.ERROR_MESSAGE);
                } else {
                    String selection = (String) JOptionPane.showInputDialog(null, "Select the meal that you will serve this Customer.", "SERVICE SELECTION", JOptionPane.QUESTION_MESSAGE, null, options.toArray(), options.getFirst());
                    if (selection != null) {
                        Meal m = null;
                        //Check if the meal is in your "inventory"
                        for (Meal x : game.completeMeals) {
                            if (m == null && Objects.equals(x.struct.name, selection)) {
                                m = x;
                            }
                        }
                        //Check if the customer ordered the meal
                        String custName = jList6.getSelectedValue();
                        Customer c = customersByName.get(custName);
                        if (c != null) {
                            if (c.orderTaken && c.order.mealsOrdered.contains(m.struct.name)) {
                                //Correct order - serve meal
                                JOptionPane.showMessageDialog(null, custName + " served " + m.struct.name + "!", "CUSTOMER SERVED", JOptionPane.INFORMATION_MESSAGE);
                                c.order.receiveMeal(m);
                                game.completeMeals.remove(m);
                            }
                        }
                    }
                }
            }
        });

        jButton16 = new JButton("To Kitchen");
        jButton16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setText("");
                showPanel(UINames.SERVICE_KITCHEN);
            }
        });

        GroupLayout ServiceFrontLayout = new GroupLayout(ServiceFront);
        ServiceFront.setLayout(ServiceFrontLayout);
        ServiceFrontLayout.setHorizontalGroup(
                ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ServiceFrontLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(ServiceFrontLayout.createSequentialGroup()
                                                .addGroup(ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane6)
                                                        .addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                .addGap(100, 100, 100)
                                                .addGroup(ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane7, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                        .addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, ServiceFrontLayout.createSequentialGroup()
                                                                .addComponent(jButton14)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton15)))
                                                .addGap(0, 75, Short.MAX_VALUE))
                                        .addGroup(ServiceFrontLayout.createSequentialGroup()
                                                .addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))
                        .addGroup(GroupLayout.Alignment.TRAILING, ServiceFrontLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200))
        );
        ServiceFrontLayout.setVerticalGroup(
                ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ServiceFrontLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(ServiceFrontLayout.createSequentialGroup()
                                                .addComponent(jScrollPane7, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                .addGap(25, 25, 25)
                                                .addGroup(ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton14)
                                                        .addComponent(jButton15)))
                                        .addComponent(jScrollPane6))
                                .addGap(27, 27, 27)
                                .addGroup(ServiceFrontLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton13)
                                        .addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
        );
        return ServiceFront;
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
                //Export selected menu items if possible
                if (menuList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Your menu doesn't contain any items!", "EMPTY MENU", JOptionPane.ERROR_MESSAGE);
                } else if (menuList.size() > 6) {
                    JOptionPane.showMessageDialog(null, "Your menu can't have more than 6 items!", "LENGTHY MENU", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < menuList.size(); i++) {
                        game.currentMenu.add(menuList.get(i));
                    }
                    showPanel(UINames.SERVICE_FRONT_OF_HOUSE);
                    game.customerNumber = 0;
                    timer.serviceTimer.start();
                }
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
    public void addCustomer() {
        Customer c = new Customer(game);
        if (c.order != null && c.order.mealsOrdered.size() > 0) {
            game.customerNumber++;
            customersByName.put("Customer #" + game.customerNumber, c);
            customers.addElement("Customer #" + game.customerNumber);
        }
    }
}
