.class public Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;
.super Landroid/widget/LinearLayout;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private b:Lcom/wishabi/flipp/widget/dv;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 39
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 43
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 44
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->setOrientation(I)V

    .line 45
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->setGravity(I)V

    .line 46
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;)Lcom/wishabi/flipp/widget/dv;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->b:Lcom/wishabi/flipp/widget/dv;

    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;II)V
    .locals 12

    .prologue
    const v11, 0x7f030057

    const/high16 v6, 0x42340000    # 45.0f

    const/4 v8, 0x1

    const/4 v10, -0x2

    const/4 v3, 0x0

    .line 20
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->removeAllViews()V

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    const/high16 v0, -0x80000000

    invoke-static {p1, v0}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-static {v3, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {v8, v6, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v5, v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {v8, v6, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v6, v0

    const/high16 v0, 0x40e00000    # 7.0f

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v7

    invoke-static {v8, v0, v7}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v7, v0

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v10, v10}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iput v5, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    new-instance v8, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-direct {v8, v9}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    const/high16 v0, 0x41a00000    # 20.0f

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setTextSize(F)V

    const v0, 0x7f0e0130

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setText(I)V

    invoke-virtual {v8, v1, v2}, Landroid/widget/TextView;->measure(II)V

    invoke-virtual {p0, v8, v3}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->addView(Landroid/view/View;I)V

    invoke-virtual {v4, v11, p0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const-string v9, "DUMMY"

    invoke-virtual {v0, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    invoke-virtual {v0, v1, v2}, Landroid/widget/TextView;->measure(II)V

    sub-int v1, p2, v5

    sub-int/2addr v1, v6

    invoke-virtual {v8}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v0

    add-int/2addr v0, v7

    div-int v5, v1, v0

    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v6, v10, v10}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iput v7, v6, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->a:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v0, v5, :cond_1

    :cond_0
    return-void

    :cond_1
    move v2, v3

    :goto_0
    if-ge v2, v5, :cond_0

    invoke-virtual {v4, v11, p0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Landroid/widget/TextView;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->a:Ljava/util/List;

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->b:Lcom/wishabi/flipp/widget/dv;

    if-eqz v0, :cond_2

    new-instance v0, Lcom/wishabi/flipp/widget/du;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/widget/du;-><init>(Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;)V

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_2
    add-int/lit8 v0, v2, 0x1

    invoke-virtual {p0, v1, v0, v6}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0
.end method


# virtual methods
.method protected onSizeChanged(IIII)V
    .locals 1

    .prologue
    .line 58
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/LinearLayout;->onSizeChanged(IIII)V

    .line 60
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->a:Ljava/util/List;

    if-nez v0, :cond_0

    .line 72
    :goto_0
    return-void

    .line 63
    :cond_0
    new-instance v0, Lcom/wishabi/flipp/widget/dt;

    invoke-direct {v0, p0, p1, p2}, Lcom/wishabi/flipp/widget/dt;-><init>(Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;II)V

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlippApplication;->a(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public setItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 53
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->a:Ljava/util/List;

    .line 54
    return-void
.end method

.method public setListener(Lcom/wishabi/flipp/widget/dv;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->b:Lcom/wishabi/flipp/widget/dv;

    .line 50
    return-void
.end method
