.class public Lcom/poshmark/ui/customviews/CollectionSortWidget;
.super Landroid/widget/LinearLayout;
.source "CollectionSortWidget.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;,
        Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;
    }
.end annotation


# instance fields
.field centerButton:Lcom/poshmark/ui/customviews/PMButton;

.field currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

.field leftButton:Lcom/poshmark/ui/customviews/PMButton;

.field listener:Lcom/poshmark/utils/CollectionSortWidgetListener;

.field parentScreenName:Ljava/lang/String;

.field rightButton:Lcom/poshmark/ui/customviews/PMButton;

.field widget_type:Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 32
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 33
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->getContext()Landroid/content/Context;

    move-result-object v4

    sget-object v5, Lcom/poshmark/app/R$styleable;->CollectionSortWidget:[I

    invoke-virtual {v4, p2, v5}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 34
    .local v0, "array":Landroid/content/res/TypedArray;
    const/4 v4, 0x2

    invoke-virtual {v0, v7, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    .line 35
    .local v2, "type":I
    if-ne v2, v7, :cond_0

    .line 37
    sget-object v4, Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;->two_button:Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;

    iput-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->widget_type:Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;

    .line 43
    :goto_0
    const-string v4, "layout_inflater"

    invoke-virtual {p1, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    .line 45
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v4, 0x7f03002b

    invoke-virtual {v1, v4, p0, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 46
    .local v3, "v":Landroid/view/View;
    const v4, 0x7f0c00cd

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 47
    const v4, 0x7f0c00ce

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->centerButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 48
    const v4, 0x7f0c00cf

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 51
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    sget-object v5, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->Left:Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMButton;->setTag(Ljava/lang/Object;)V

    .line 52
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->centerButton:Lcom/poshmark/ui/customviews/PMButton;

    sget-object v5, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->Center:Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMButton;->setTag(Ljava/lang/Object;)V

    .line 53
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    sget-object v5, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->Right:Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMButton;->setTag(Ljava/lang/Object;)V

    .line 55
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v5, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;-><init>(Lcom/poshmark/ui/customviews/CollectionSortWidget;)V

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->centerButton:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v5, Lcom/poshmark/ui/customviews/CollectionSortWidget$2;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/customviews/CollectionSortWidget$2;-><init>(Lcom/poshmark/ui/customviews/CollectionSortWidget;)V

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 83
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v5, Lcom/poshmark/ui/customviews/CollectionSortWidget$3;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/customviews/CollectionSortWidget$3;-><init>(Lcom/poshmark/ui/customviews/CollectionSortWidget;)V

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->widget_type:Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;

    sget-object v5, Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;->two_button:Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;

    if-ne v4, v5, :cond_1

    .line 98
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v4, v6}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 99
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v4, v6}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 105
    :goto_1
    return-void

    .line 40
    .end local v1    # "inflater":Landroid/view/LayoutInflater;
    .end local v3    # "v":Landroid/view/View;
    :cond_0
    sget-object v4, Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;->three_button:Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;

    iput-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->widget_type:Lcom/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE;

    goto :goto_0

    .line 101
    .restart local v1    # "inflater":Landroid/view/LayoutInflater;
    .restart local v3    # "v":Landroid/view/View;
    :cond_1
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v4, v6}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 102
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->centerButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v4, v6}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 103
    iget-object v4, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v4, v6}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    goto :goto_1
.end method

.method static synthetic access$000(Lcom/poshmark/ui/customviews/CollectionSortWidget;Lcom/poshmark/ui/customviews/PMButton;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/CollectionSortWidget;
    .param p1, "x1"    # Lcom/poshmark/ui/customviews/PMButton;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->unselectButton(Lcom/poshmark/ui/customviews/PMButton;)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/customviews/CollectionSortWidget;Lcom/poshmark/ui/customviews/PMButton;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/CollectionSortWidget;
    .param p1, "x1"    # Lcom/poshmark/ui/customviews/PMButton;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectButton(Lcom/poshmark/ui/customviews/PMButton;)V

    return-void
.end method

.method private selectButton(Lcom/poshmark/ui/customviews/PMButton;)V
    .locals 2
    .param p1, "currentActiveButton"    # Lcom/poshmark/ui/customviews/PMButton;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    if-ne p1, v0, :cond_0

    .line 121
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02002d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 128
    :goto_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090037

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMButton;->setTextColor(I)V

    .line 129
    return-void

    .line 123
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    if-ne p1, v0, :cond_1

    .line 124
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02002b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 126
    :cond_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020029

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private unselectButton(Lcom/poshmark/ui/customviews/PMButton;)V
    .locals 2
    .param p1, "currentActiveButton"    # Lcom/poshmark/ui/customviews/PMButton;

    .prologue
    .line 108
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    if-ne p1, v0, :cond_0

    .line 109
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02002c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 116
    :goto_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090040

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMButton;->setTextColor(I)V

    .line 117
    return-void

    .line 111
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    if-ne p1, v0, :cond_1

    .line 112
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02002a

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 114
    :cond_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020028

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method


# virtual methods
.method public selectCenterButton()V
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->centerButton:Lcom/poshmark/ui/customviews/PMButton;

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->centerButton:Lcom/poshmark/ui/customviews/PMButton;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 145
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-direct {p0, v0}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectButton(Lcom/poshmark/ui/customviews/PMButton;)V

    .line 147
    :cond_0
    return-void
.end method

.method public selectLeftButton()V
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 138
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-direct {p0, v0}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectButton(Lcom/poshmark/ui/customviews/PMButton;)V

    .line 140
    :cond_0
    return-void
.end method

.method public selectRightButton()V
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 152
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-direct {p0, v0}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectButton(Lcom/poshmark/ui/customviews/PMButton;)V

    .line 154
    :cond_0
    return-void
.end method

.method public setCenterButtonText(Ljava/lang/String;)V
    .locals 1
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 163
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->centerButton:Lcom/poshmark/ui/customviews/PMButton;

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->centerButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMButton;->setText(Ljava/lang/CharSequence;)V

    .line 166
    :cond_0
    return-void
.end method

.method public setLeftButtonText(Ljava/lang/String;)V
    .locals 1
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMButton;->setText(Ljava/lang/CharSequence;)V

    .line 160
    :cond_0
    return-void
.end method

.method public setRightButtonText(Ljava/lang/String;)V
    .locals 1
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 169
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    if-eqz v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->rightButton:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMButton;->setText(Ljava/lang/CharSequence;)V

    .line 172
    :cond_0
    return-void
.end method

.method public setSortSelectionListener(Lcom/poshmark/utils/CollectionSortWidgetListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/CollectionSortWidgetListener;

    .prologue
    .line 132
    iput-object p1, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->listener:Lcom/poshmark/utils/CollectionSortWidgetListener;

    .line 133
    return-void
.end method
