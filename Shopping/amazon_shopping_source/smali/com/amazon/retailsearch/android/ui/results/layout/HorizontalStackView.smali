.class public Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;
.super Lcom/amazon/retailsearch/android/ui/HorizontalListView;
.source "HorizontalStackView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/layout/StackView;


# instance fields
.field private itemWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;-><init>(Landroid/content/Context;)V

    .line 27
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->init()V

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 33
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->init()V

    .line 34
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .prologue
    .line 38
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 39
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->init()V

    .line 40
    return-void
.end method

.method private init()V
    .locals 2

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_port_item_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->itemWidth:I

    .line 45
    return-void
.end method


# virtual methods
.method protected getItemWidth()I
    .locals 1

    .prologue
    .line 56
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->itemWidth:I

    return v0
.end method

.method public getView()Landroid/view/View;
    .locals 0

    .prologue
    .line 50
    return-object p0
.end method
