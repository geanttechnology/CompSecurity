.class public Lcom/amazon/mShop/cvsd/CVSDRefinementsView;
.super Landroid/widget/ScrollView;
.source "CVSDRefinementsView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# static fields
.field public static final KEY_REFINEMENTS_SELECTED_INDEX:Ljava/lang/String; = "com.amazon.mShop.cvsd.CVSDRefinementsView.KEY_REFINEMENTS_SELECTED_INDEX"


# instance fields
.field final amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field final layoutInflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 14
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 31
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 32
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v11

    iput-object v11, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->layoutInflater:Landroid/view/LayoutInflater;

    .line 34
    new-instance v3, Landroid/widget/LinearLayout;

    iget-object v11, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v3, v11}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 35
    .local v3, "content":Landroid/widget/LinearLayout;
    const/4 v11, 0x1

    invoke-virtual {v3, v11}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 36
    new-instance v11, Landroid/widget/FrameLayout$LayoutParams;

    const/4 v12, -0x1

    const/4 v13, -0x2

    invoke-direct {v11, v12, v13}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v11}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 38
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->addView(Landroid/view/View;)V

    .line 40
    sget-object v11, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->message:Ljava/lang/String;

    invoke-static {v11}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_0

    .line 41
    new-instance v7, Landroid/widget/TextView;

    iget-object v11, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v7, v11}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 42
    .local v7, "message":Landroid/widget/TextView;
    sget-object v11, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->message:Ljava/lang/String;

    invoke-virtual {v7, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 43
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    sget v12, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v11

    float-to-int v8, v11

    .line 44
    .local v8, "padding":I
    invoke-virtual {v7, v8, v8, v8, v8}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 45
    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 48
    .end local v7    # "message":Landroid/widget/TextView;
    .end local v8    # "padding":I
    :cond_0
    sget-object v11, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    if-eqz v11, :cond_1

    .line 49
    sget-object v1, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    .line 51
    .local v1, "addresses":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Address;>;"
    const/4 v4, 0x0

    .line 52
    .local v4, "count":I
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 53
    .local v0, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    iget-object v11, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->layoutInflater:Landroid/view/LayoutInflater;

    sget v12, Lcom/amazon/mShop/android/lib/R$layout;->cvsd_refinement_option_item:I

    const/4 v13, 0x0

    invoke-virtual {v11, v12, v13}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v9

    .line 54
    .local v9, "refinementOptionView":Landroid/view/View;
    sget v11, Lcom/amazon/mShop/android/lib/R$id;->opl_cvsd_refinement_option_item_button:I

    invoke-virtual {v9, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 56
    .local v2, "btn":Landroid/widget/Button;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v2, v11}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 58
    add-int/lit8 v5, v4, 0x1

    .end local v4    # "count":I
    .local v5, "count":I
    move v10, v4

    .line 60
    .local v10, "selectedIndex":I
    new-instance v11, Lcom/amazon/mShop/cvsd/CVSDRefinementsView$1;

    invoke-direct {v11, p0, v10}, Lcom/amazon/mShop/cvsd/CVSDRefinementsView$1;-><init>(Lcom/amazon/mShop/cvsd/CVSDRefinementsView;I)V

    invoke-virtual {v2, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 78
    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    move v4, v5

    .line 80
    .end local v5    # "count":I
    .restart local v4    # "count":I
    goto :goto_0

    .line 84
    .end local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v1    # "addresses":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Address;>;"
    .end local v2    # "btn":Landroid/widget/Button;
    .end local v4    # "count":I
    .end local v6    # "i$":Ljava/util/Iterator;
    .end local v9    # "refinementOptionView":Landroid/view/View;
    .end local v10    # "selectedIndex":I
    :cond_1
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 88
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_for_a_convenience_store:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
