.class public Lcom/amazon/mShop/ui/BottomToolBar;
.super Landroid/widget/LinearLayout;
.source "BottomToolBar.java"

# interfaces
.implements Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;,
        Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;,
        Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;
    }
.end annotation


# instance fields
.field mToolBarItemsList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;",
            ">;"
        }
    .end annotation
.end field

.field private mToolBarParent:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 39
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/ui/BottomToolBar;)Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/BottomToolBar;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/ui/BottomToolBar;->mToolBarParent:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;

    return-object v0
.end method

.method private addViews(ZZLandroid/widget/TextView;I)V
    .locals 5
    .param p1, "hasOneActionButton"    # Z
    .param p2, "isFirstActionButton"    # Z
    .param p3, "textView"    # Landroid/widget/TextView;
    .param p4, "orientation"    # I

    .prologue
    const/4 v4, 0x0

    .line 153
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->vertical_separator_with_padding:I

    .line 154
    .local v1, "dividerLayout":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v1, v4}, Lcom/amazon/mShop/ui/BottomToolBar;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 156
    .local v2, "firstDivider":Landroid/view/View;
    const/4 v3, 0x2

    if-ne v3, p4, :cond_2

    .line 161
    if-eqz p2, :cond_0

    .line 162
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->addView(Landroid/view/View;)V

    .line 164
    :cond_0
    invoke-virtual {p0, p3}, Lcom/amazon/mShop/ui/BottomToolBar;->addView(Landroid/view/View;)V

    .line 166
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v1, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 167
    .local v0, "divider":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->addView(Landroid/view/View;)V

    .line 184
    .end local v0    # "divider":Landroid/view/View;
    :cond_1
    :goto_0
    return-void

    .line 173
    :cond_2
    if-nez p1, :cond_3

    if-nez p2, :cond_4

    .line 174
    :cond_3
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/BottomToolBar;->addView(Landroid/view/View;)V

    .line 177
    :cond_4
    invoke-virtual {p0, p3}, Lcom/amazon/mShop/ui/BottomToolBar;->addView(Landroid/view/View;)V

    .line 179
    if-eqz p1, :cond_1

    .line 180
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v1, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 181
    .restart local v0    # "divider":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->addView(Landroid/view/View;)V

    goto :goto_0
.end method

.method private initForLandScape(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "toolBarItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;>;"
    const/4 v0, 0x1

    .line 74
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-ne v5, v0, :cond_0

    .line 76
    .local v0, "hasOneActionButton":Z
    :goto_0
    const/4 v2, 0x1

    .line 78
    .local v2, "isFirstActionButton":Z
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .line 79
    .local v3, "item":Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    new-instance v4, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 80
    .local v4, "textView":Landroid/widget/TextView;
    invoke-direct {p0, v4, v3, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->setTextViewSettings(Landroid/widget/TextView;Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V

    .line 81
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v5

    iget v5, v5, Landroid/content/res/Configuration;->orientation:I

    invoke-direct {p0, v0, v2, v4, v5}, Lcom/amazon/mShop/ui/BottomToolBar;->addViews(ZZLandroid/widget/TextView;I)V

    .line 82
    const/4 v2, 0x0

    .line 83
    goto :goto_1

    .line 74
    .end local v0    # "hasOneActionButton":Z
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "isFirstActionButton":Z
    .end local v3    # "item":Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    .end local v4    # "textView":Landroid/widget/TextView;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 84
    .restart local v0    # "hasOneActionButton":Z
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "isFirstActionButton":Z
    :cond_1
    return-void
.end method

.method private initForPortrait(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "toolBarItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;>;"
    const/4 v0, 0x1

    .line 61
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-ne v5, v0, :cond_0

    .line 63
    .local v0, "hasOneActionButton":Z
    :goto_0
    const/4 v2, 0x1

    .line 65
    .local v2, "isFirstActionButton":Z
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .line 66
    .local v3, "item":Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    new-instance v4, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 67
    .local v4, "textView":Landroid/widget/TextView;
    invoke-direct {p0, v4, v3, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->setTextViewSettings(Landroid/widget/TextView;Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V

    .line 68
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v5

    iget v5, v5, Landroid/content/res/Configuration;->orientation:I

    invoke-direct {p0, v0, v2, v4, v5}, Lcom/amazon/mShop/ui/BottomToolBar;->addViews(ZZLandroid/widget/TextView;I)V

    .line 69
    const/4 v2, 0x0

    .line 70
    goto :goto_1

    .line 61
    .end local v0    # "hasOneActionButton":Z
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "isFirstActionButton":Z
    .end local v3    # "item":Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    .end local v4    # "textView":Landroid/widget/TextView;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 71
    .restart local v0    # "hasOneActionButton":Z
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "isFirstActionButton":Z
    :cond_1
    return-void
.end method

.method private setTextViewSettings(Landroid/widget/TextView;Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V
    .locals 10
    .param p1, "textView"    # Landroid/widget/TextView;
    .param p2, "item"    # Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    .param p3, "hasOneActionButton"    # Z

    .prologue
    .line 93
    const/4 v5, 0x0

    .line 95
    .local v5, "textViewPaddingLeftRight":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$dimen;->padding_small:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    .line 96
    sget v6, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_icon_selector:I

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 97
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$color;->bottom_toolbar_text_selector:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v6

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 99
    const/4 v6, 0x1

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setFocusable(Z)V

    .line 101
    invoke-virtual {p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getItemName()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 103
    invoke-virtual {p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getItemName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 108
    :goto_0
    invoke-virtual {p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getItemId()I

    move-result v6

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setId(I)V

    .line 109
    new-instance v6, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;

    invoke-direct {v6, p0, p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;-><init>(Lcom/amazon/mShop/ui/BottomToolBar;Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;)V

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 111
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$dimen;->padding_extra_small:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v6

    float-to-int v2, v6

    .line 112
    .local v2, "padding":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$dimen;->padding_double:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v6

    float-to-int v0, v6

    .line 113
    .local v0, "doublePadding":I
    const/4 v3, 0x0

    .line 115
    .local v3, "params":Landroid/widget/LinearLayout$LayoutParams;
    if-nez p3, :cond_1

    .line 116
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    .end local v3    # "params":Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -0x1

    const/4 v7, -0x1

    invoke-direct {v3, v6, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 118
    .restart local v3    # "params":Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v6, 0x3f800000    # 1.0f

    iput v6, v3, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 126
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$dimen;->separator_height:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 127
    .local v4, "separatorHeight":I
    neg-int v6, v4

    const/4 v7, 0x0

    neg-int v8, v4

    const/4 v9, 0x0

    invoke-virtual {v3, v6, v7, v8, v9}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 129
    const/16 v6, 0x11

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setGravity(I)V

    .line 130
    invoke-virtual {p1, v3}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 132
    invoke-virtual {p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getIconId()I

    move-result v6

    const/4 v7, -0x1

    if-eq v6, v7, :cond_2

    .line 133
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getIconId()I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 134
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual {p1, v6, v7, v1, v8}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 135
    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setCompoundDrawablePadding(I)V

    .line 136
    add-int v6, v5, v0

    add-int v7, v5, v2

    invoke-virtual {p1, v6, v2, v7, v2}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 141
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    :goto_2
    invoke-virtual {p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->isEnabled()Z

    move-result v6

    invoke-direct {p0, p1, v6}, Lcom/amazon/mShop/ui/BottomToolBar;->updateItemView(Landroid/widget/TextView;Z)V

    .line 142
    return-void

    .line 105
    .end local v0    # "doublePadding":I
    .end local v2    # "padding":I
    .end local v3    # "params":Landroid/widget/LinearLayout$LayoutParams;
    .end local v4    # "separatorHeight":I
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getItemNameId()I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 120
    .restart local v0    # "doublePadding":I
    .restart local v2    # "padding":I
    .restart local v3    # "params":Landroid/widget/LinearLayout$LayoutParams;
    :cond_1
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    .end local v3    # "params":Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -0x2

    const/4 v7, -0x1

    invoke-direct {v3, v6, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 124
    .restart local v3    # "params":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/UIUtils;->getPortraitWidth(Landroid/content/Context;)I

    move-result v6

    int-to-double v6, v6

    const-wide v8, 0x3fd6666666666666L    # 0.35

    mul-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    long-to-int v6, v6

    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setMinimumWidth(I)V

    goto :goto_1

    .line 138
    .restart local v4    # "separatorHeight":I
    :cond_2
    add-int v6, v5, v2

    add-int v7, v5, v2

    invoke-virtual {p1, v6, v2, v7, v2}, Landroid/widget/TextView;->setPadding(IIII)V

    goto :goto_2
.end method

.method private updateItemView(Landroid/widget/TextView;Z)V
    .locals 0
    .param p1, "view"    # Landroid/widget/TextView;
    .param p2, "enabled"    # Z

    .prologue
    .line 237
    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setClickable(Z)V

    .line 238
    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 239
    return-void
.end method


# virtual methods
.method public getToolBarParent()Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/ui/BottomToolBar;->mToolBarParent:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;

    return-object v0
.end method

.method public handleConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 378
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 379
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->removeAllViews()V

    .line 380
    iget-object v0, p0, Lcom/amazon/mShop/ui/BottomToolBar;->mToolBarItemsList:Ljava/util/List;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->init(Ljava/util/List;)V

    .line 382
    :cond_0
    return-void
.end method

.method public init(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p1, "toolBarItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;>;"
    iput-object p1, p0, Lcom/amazon/mShop/ui/BottomToolBar;->mToolBarItemsList:Ljava/util/List;

    .line 52
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 53
    invoke-direct {p0, p1}, Lcom/amazon/mShop/ui/BottomToolBar;->initForPortrait(Ljava/util/List;)V

    .line 57
    :goto_0
    return-void

    .line 55
    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/mShop/ui/BottomToolBar;->initForLandScape(Ljava/util/List;)V

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 361
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 362
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v0, :cond_0

    .line 363
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->registerConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 365
    :cond_0
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 369
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 370
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v0, :cond_0

    .line 371
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->unregisterConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 374
    :cond_0
    return-void
.end method

.method public setToolBarEnabled(Z)V
    .locals 3
    .param p1, "enabled"    # Z

    .prologue
    .line 228
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getChildCount()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 229
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 230
    .local v1, "view":Landroid/view/View;
    instance-of v2, v1, Landroid/widget/TextView;

    if-eqz v2, :cond_0

    .line 231
    check-cast v1, Landroid/widget/TextView;

    .end local v1    # "view":Landroid/view/View;
    invoke-direct {p0, v1, p1}, Lcom/amazon/mShop/ui/BottomToolBar;->updateItemView(Landroid/widget/TextView;Z)V

    .line 228
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 234
    :cond_1
    return-void
.end method

.method public setToolBarItemEnabled(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V
    .locals 4
    .param p1, "toolBarItem"    # Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    .param p2, "enabled"    # Z

    .prologue
    .line 214
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BottomToolBar;->getChildCount()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 215
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ui/BottomToolBar;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 216
    .local v1, "view":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {p1}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->getItemId()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 217
    invoke-virtual {p1, p2}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->setEnabled(Z)V

    .line 218
    check-cast v1, Landroid/widget/TextView;

    .end local v1    # "view":Landroid/view/View;
    invoke-direct {p0, v1, p2}, Lcom/amazon/mShop/ui/BottomToolBar;->updateItemView(Landroid/widget/TextView;Z)V

    .line 214
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 221
    :cond_1
    return-void
.end method

.method public setToolBarParent(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;)V
    .locals 0
    .param p1, "parent"    # Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;

    .prologue
    .line 262
    iput-object p1, p0, Lcom/amazon/mShop/ui/BottomToolBar;->mToolBarParent:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;

    .line 263
    return-void
.end method
