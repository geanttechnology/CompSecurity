.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;
.super Landroid/widget/LinearLayout;
.source "ContentRow.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;",
        ">;"
    }
.end annotation


# instance fields
.field private model:Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 21
    return-void
.end method

.method private add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;III)V
    .locals 8
    .param p1, "viewEntry"    # Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .param p2, "index"    # I
    .param p3, "spacing"    # I
    .param p4, "cols"    # I

    .prologue
    const/4 v5, 0x0

    .line 58
    const/4 v4, 0x0

    .line 60
    .local v4, "view":Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v6, -0x1

    const/high16 v7, 0x3f800000    # 1.0f

    invoke-direct {v1, v5, v6, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    .line 62
    .local v1, "lp":Landroid/widget/LinearLayout$LayoutParams;
    if-nez p2, :cond_0

    move p3, v5

    .end local p3    # "spacing":I
    :cond_0
    invoke-virtual {v1, p3, v5, v5, v5}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 66
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->model:Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    if-eqz v6, :cond_1

    .line 67
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->model:Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->model:Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {v7}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getColumns()I

    move-result v7

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 68
    .local v3, "rowSize":I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->getChildCount()I

    move-result v6

    invoke-static {v3, v6}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 70
    move v0, p2

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_1

    .line 71
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->model:Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    .line 73
    .local v2, "prevEntry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;->getType()I

    move-result v6

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;->getType()I

    move-result v7

    if-ne v6, v7, :cond_4

    .line 74
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 76
    if-le v0, p2, :cond_1

    .line 77
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->removeViewAt(I)V

    .line 78
    invoke-virtual {p0, v4, p2, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 79
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->model:Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v6

    invoke-static {v6, p2, v0}, Ljava/util/Collections;->swap(Ljava/util/List;II)V

    .line 87
    .end local v0    # "i":I
    .end local v2    # "prevEntry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .end local v3    # "rowSize":I
    :cond_1
    if-nez v4, :cond_2

    .line 88
    invoke-virtual {p1, p0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;->createView(Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .line 89
    invoke-virtual {p0, v4, p2, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 92
    :cond_2
    add-int/lit8 v6, p4, -0x1

    if-ge p2, v6, :cond_3

    sget v5, Lcom/amazon/retailsearch/R$drawable;->result_item_right_border:I

    :cond_3
    invoke-virtual {v4, v5}, Landroid/view/View;->setBackgroundResource(I)V

    .line 93
    invoke-virtual {p1, v4}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;->buildView(Landroid/view/View;)V

    .line 94
    return-void

    .line 70
    .restart local v0    # "i":I
    .restart local v2    # "prevEntry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .restart local v3    # "rowSize":I
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public build(Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)V
    .locals 10
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    .prologue
    const/4 v9, 0x0

    .line 25
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->model:Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    if-ne p1, v7, :cond_0

    .line 55
    :goto_0
    return-void

    .line 30
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getColumns()I

    move-result v8

    invoke-static {v7, v8}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 32
    .local v3, "n":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v3, :cond_1

    .line 33
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    .line 34
    .local v6, "viewEntry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getSpacing()I

    move-result v7

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getColumns()I

    move-result v8

    invoke-direct {p0, v6, v0, v7, v8}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;III)V

    .line 32
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 37
    .end local v6    # "viewEntry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->getChildCount()I

    move-result v7

    if-le v7, v0, :cond_2

    .line 38
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->getChildCount()I

    move-result v7

    sub-int/2addr v7, v0

    invoke-virtual {p0, v0, v7}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->removeViews(II)V

    .line 43
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getColumns()I

    move-result v7

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->getChildCount()I

    move-result v8

    sub-int v1, v7, v8

    .line 45
    .local v1, "left":I
    if-lez v1, :cond_4

    .line 46
    new-instance v5, Landroid/widget/FrameLayout;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-direct {v5, v7}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 47
    .local v5, "view":Landroid/widget/FrameLayout;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v7, -0x1

    int-to-float v8, v1

    invoke-direct {v2, v9, v7, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    .line 49
    .local v2, "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getSpacing()I

    move-result v7

    if-nez v0, :cond_3

    add-int/lit8 v1, v1, -0x1

    .end local v1    # "left":I
    :cond_3
    mul-int v4, v7, v1

    .line 50
    .local v4, "spacing":I
    invoke-virtual {v2, v4, v9, v9, v9}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 51
    invoke-virtual {p0, v5, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 54
    .end local v2    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v4    # "spacing":I
    .end local v5    # "view":Landroid/widget/FrameLayout;
    :cond_4
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->model:Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    goto :goto_0
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 16
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ContentRow;->build(Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)V

    return-void
.end method
