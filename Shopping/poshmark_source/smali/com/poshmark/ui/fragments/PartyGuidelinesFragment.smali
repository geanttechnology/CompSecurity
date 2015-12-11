.class public Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "PartyGuidelinesFragment.java"


# instance fields
.field private event:Lcom/poshmark/data_model/models/PartyEvent;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 24
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 51
    const v20, 0x7f0c0236

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Lcom/poshmark/ui/customviews/PMTextView;

    .line 52
    .local v19, "themeTextView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const v21, 0x7f06029b

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 54
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/poshmark/data_model/models/PartyEvent;->getTheme()Lcom/poshmark/data_model/models/inner_models/Theme;

    move-result-object v18

    .line 56
    .local v18, "theme":Lcom/poshmark/data_model/models/inner_models/Theme;
    const v20, 0x7f0c0239

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/LinearLayout;

    .line 57
    .local v6, "categoriesLayout":Landroid/widget/LinearLayout;
    const v20, 0x7f0c023b

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v16

    check-cast v16, Landroid/widget/LinearLayout;

    .line 58
    .local v16, "sizesLayout":Landroid/widget/LinearLayout;
    const v20, 0x7f0c0187

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/LinearLayout;

    .line 60
    .local v13, "pricesLayout":Landroid/widget/LinearLayout;
    if-nez v18, :cond_1

    .line 61
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    const v21, 0x7f020021

    invoke-virtual/range {v20 .. v21}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 62
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    const/high16 v21, 0x41200000    # 10.0f

    invoke-static/range {v20 .. v21}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v20

    move/from16 v0, v20

    float-to-int v12, v0

    .line 63
    .local v12, "padding":I
    invoke-virtual {v6, v12, v12, v12, v12}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 64
    invoke-virtual {v6}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout$LayoutParams;

    .line 65
    .local v9, "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    move/from16 v0, v20

    move/from16 v1, v21

    move/from16 v2, v22

    move/from16 v3, v23

    invoke-virtual {v9, v0, v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 66
    invoke-virtual {v6, v9}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 68
    const/16 v20, 0x8

    move-object/from16 v0, v16

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 69
    const/16 v20, 0x8

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 136
    .end local v9    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v12    # "padding":I
    :cond_0
    :goto_0
    return-void

    .line 74
    :cond_1
    const v20, 0x7f0c0238

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    .line 75
    .local v4, "brandsValueTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Theme;->getCommaSeparatedBrands(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    const v20, 0x7f0c023a

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/poshmark/ui/customviews/PMTextView;

    .line 78
    .local v7, "categoriesValueTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Theme;->getCommaSeparatedCategories(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v7, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 80
    const/4 v5, 0x1

    .line 83
    .local v5, "categoriesIsLast":Z
    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getSizes()Ljava/util/List;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/List;->size()I

    move-result v20

    if-lez v20, :cond_5

    .line 84
    const/4 v5, 0x0

    .line 85
    const v20, 0x7f0c023c

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Lcom/poshmark/ui/customviews/PMTextView;

    .line 86
    .local v17, "sizesValueTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Theme;->getCommaSeparatedSizes(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v17

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    .end local v17    # "sizesValueTextView":Lcom/poshmark/ui/customviews/PMTextView;
    :goto_1
    const/4 v15, 0x1

    .line 95
    .local v15, "sizeIsLast":Z
    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMaxPrice()F

    move-result v20

    const/16 v21, 0x0

    cmpl-float v20, v20, v21

    if-gez v20, :cond_2

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMinPrice()F

    move-result v20

    const/16 v21, 0x0

    cmpl-float v20, v20, v21

    if-ltz v20, :cond_8

    .line 96
    :cond_2
    const/4 v5, 0x0

    .line 97
    const/4 v15, 0x0

    .line 98
    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v8

    .line 100
    .local v8, "currencySymbol":Ljava/lang/String;
    const v20, 0x7f0c023d

    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Lcom/poshmark/ui/customviews/PMTextView;

    .line 101
    .local v14, "pricesValueTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMaxPrice()F

    move-result v20

    const/16 v21, 0x0

    cmpl-float v20, v20, v21

    if-ltz v20, :cond_6

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMinPrice()F

    move-result v20

    const/16 v21, 0x0

    cmpl-float v20, v20, v21

    if-ltz v20, :cond_6

    .line 102
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v20

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMinPrice()F

    move-result v21

    move/from16 v0, v21

    float-to-int v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 103
    .local v11, "minString":Ljava/lang/String;
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v20

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMaxPrice()F

    move-result v21

    move/from16 v0, v21

    float-to-int v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 104
    .local v10, "maxString":Ljava/lang/String;
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v20

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " - "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 119
    .end local v8    # "currencySymbol":Ljava/lang/String;
    .end local v10    # "maxString":Ljava/lang/String;
    .end local v11    # "minString":Ljava/lang/String;
    .end local v14    # "pricesValueTextView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_3
    :goto_2
    if-eqz v5, :cond_4

    .line 120
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    const v21, 0x7f020021

    invoke-virtual/range {v20 .. v21}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 121
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    const/high16 v21, 0x41200000    # 10.0f

    invoke-static/range {v20 .. v21}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v20

    move/from16 v0, v20

    float-to-int v12, v0

    .line 122
    .restart local v12    # "padding":I
    invoke-virtual {v6, v12, v12, v12, v12}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 123
    invoke-virtual {v6}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout$LayoutParams;

    .line 124
    .restart local v9    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    move/from16 v0, v20

    move/from16 v1, v21

    move/from16 v2, v22

    move/from16 v3, v23

    invoke-virtual {v9, v0, v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 125
    invoke-virtual {v6, v9}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 128
    .end local v9    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v12    # "padding":I
    :cond_4
    if-eqz v15, :cond_0

    .line 129
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    const v21, 0x7f020021

    invoke-virtual/range {v20 .. v21}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v20

    move-object/from16 v0, v16

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 130
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    const/high16 v21, 0x41200000    # 10.0f

    invoke-static/range {v20 .. v21}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v20

    move/from16 v0, v20

    float-to-int v12, v0

    .line 131
    .restart local v12    # "padding":I
    move-object/from16 v0, v16

    invoke-virtual {v0, v12, v12, v12, v12}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 132
    invoke-virtual/range {v16 .. v16}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout$LayoutParams;

    .line 133
    .restart local v9    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    move/from16 v0, v20

    move/from16 v1, v21

    move/from16 v2, v22

    move/from16 v3, v23

    invoke-virtual {v9, v0, v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 134
    move-object/from16 v0, v16

    invoke-virtual {v0, v9}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto/16 :goto_0

    .line 89
    .end local v9    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v12    # "padding":I
    .end local v15    # "sizeIsLast":Z
    :cond_5
    const/16 v20, 0x8

    move-object/from16 v0, v16

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_1

    .line 106
    .restart local v8    # "currencySymbol":Ljava/lang/String;
    .restart local v14    # "pricesValueTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .restart local v15    # "sizeIsLast":Z
    :cond_6
    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMaxPrice()F

    move-result v20

    const/16 v21, 0x0

    cmpl-float v20, v20, v21

    if-ltz v20, :cond_7

    .line 107
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v20

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMaxPrice()F

    move-result v21

    move/from16 v0, v21

    float-to-int v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 108
    .restart local v10    # "maxString":Ljava/lang/String;
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const v21, 0x7f060051

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 110
    .end local v10    # "maxString":Ljava/lang/String;
    :cond_7
    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMinPrice()F

    move-result v20

    const/16 v21, 0x0

    cmpl-float v20, v20, v21

    if-ltz v20, :cond_3

    .line 111
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v20

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/inner_models/Theme;->getMinPrice()F

    move-result v21

    move/from16 v0, v21

    float-to-int v0, v0

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 112
    .restart local v11    # "minString":Ljava/lang/String;
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const v21, 0x7f06002d

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 116
    .end local v8    # "currencySymbol":Ljava/lang/String;
    .end local v11    # "minString":Ljava/lang/String;
    .end local v14    # "pricesValueTextView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_8
    const/16 v20, 0x8

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_2
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 44
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 27
    const-class v1, Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 28
    .local v0, "e":Ljava/lang/Object;
    if-eqz v0, :cond_0

    .line 29
    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .end local v0    # "e":Ljava/lang/Object;
    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 31
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 36
    const v1, 0x7f030095

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 37
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->setupView(Landroid/view/View;)V

    .line 38
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 47
    const-string v0, "party_theme_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 48
    return-void
.end method
