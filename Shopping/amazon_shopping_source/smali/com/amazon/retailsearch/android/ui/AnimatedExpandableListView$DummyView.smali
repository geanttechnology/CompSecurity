.class Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;
.super Landroid/view/View;
.source "AnimatedExpandableListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DummyView"
.end annotation


# instance fields
.field private divider:Landroid/graphics/drawable/Drawable;

.field private dividerHeight:I

.field private dividerWidth:I

.field private views:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 477
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 471
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->views:Ljava/util/List;

    .line 478
    return-void
.end method


# virtual methods
.method public addFakeView(Landroid/view/View;)V
    .locals 3
    .param p1, "childView"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 493
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->getHeight()I

    move-result v1

    invoke-virtual {p1, v2, v2, v0, v1}, Landroid/view/View;->layout(IIII)V

    .line 494
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->views:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 495
    return-void
.end method

.method public clearViews()V
    .locals 1

    .prologue
    .line 508
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->views:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 509
    return-void
.end method

.method public dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 513
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 515
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->divider:Landroid/graphics/drawable/Drawable;

    iget v4, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->dividerWidth:I

    iget v5, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->dividerHeight:I

    invoke-virtual {v3, v7, v7, v4, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 517
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->views:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v1

    .line 518
    .local v1, "len":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 519
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->views:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    .line 520
    .local v2, "v":Landroid/view/View;
    invoke-virtual {v2, p1}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    .line 521
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p1, v6, v3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 522
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->divider:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 523
    iget v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->dividerHeight:I

    int-to-float v3, v3

    invoke-virtual {p1, v6, v3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 518
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 526
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 527
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 4
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 499
    invoke-super/range {p0 .. p5}, Landroid/view/View;->onLayout(ZIIII)V

    .line 500
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->views:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v1

    .line 501
    .local v1, "len":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 502
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->views:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    .line 503
    .local v2, "v":Landroid/view/View;
    invoke-virtual {v2, p2, p3, p4, p5}, Landroid/view/View;->layout(IIII)V

    .line 501
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 505
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method

.method public setDivider(Landroid/graphics/drawable/Drawable;II)V
    .locals 1
    .param p1, "divider"    # Landroid/graphics/drawable/Drawable;
    .param p2, "dividerWidth"    # I
    .param p3, "dividerHeight"    # I

    .prologue
    const/4 v0, 0x0

    .line 481
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->divider:Landroid/graphics/drawable/Drawable;

    .line 482
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->dividerWidth:I

    .line 483
    iput p3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->dividerHeight:I

    .line 485
    invoke-virtual {p1, v0, v0, p2, p3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 486
    return-void
.end method
