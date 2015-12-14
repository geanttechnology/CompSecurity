.class Lcom/livemixtapes/Mixtape$8;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    .line 612
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 11
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    const-wide/16 v9, 0x0

    const-wide v7, 0x3fd999999999999aL    # 0.4

    const/4 v6, 0x4

    const/4 v5, 0x0

    .line 618
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->measured:Ljava/lang/Boolean;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$20(Lcom/livemixtapes/Mixtape;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    .line 671
    :goto_0
    return-void

    .line 640
    :cond_0
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-virtual {v3}, Lcom/livemixtapes/Mixtape;->getScrollY()I

    move-result v2

    .line 642
    .local v2, "scrollY":I
    if-lez v2, :cond_3

    .line 643
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->views:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$21(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 644
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->release_seconds:J
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$22(Lcom/livemixtapes/Mixtape;)J

    move-result-wide v3

    cmp-long v3, v3, v9

    if-nez v3, :cond_1

    .line 645
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->date:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$23(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 647
    :cond_1
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->mixtapeBtns:Landroid/view/View;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$24(Lcom/livemixtapes/Mixtape;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/view/View;->setVisibility(I)V

    .line 655
    :goto_1
    if-gez v2, :cond_2

    .line 656
    const/4 v2, 0x0

    .line 657
    :cond_2
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->maxCoverSize:I
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$25(Lcom/livemixtapes/Mixtape;)I

    move-result v3

    .line 658
    int-to-double v4, v2

    mul-double/2addr v4, v7

    double-to-int v4, v4

    .line 657
    sub-int/2addr v3, v4

    .line 658
    iget-object v4, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->minCoverSize:I
    invoke-static {v4}, Lcom/livemixtapes/Mixtape;->access$26(Lcom/livemixtapes/Mixtape;)I

    move-result v4

    .line 657
    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 659
    .local v0, "newCoverSize":I
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->maxHeaderSize:I
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$27(Lcom/livemixtapes/Mixtape;)I

    move-result v3

    int-to-double v4, v2

    mul-double/2addr v4, v7

    double-to-int v4, v4

    sub-int/2addr v3, v4

    .line 660
    iget-object v4, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->minHeaderSize:I
    invoke-static {v4}, Lcom/livemixtapes/Mixtape;->access$28(Lcom/livemixtapes/Mixtape;)I

    move-result v4

    .line 659
    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 662
    .local v1, "newHeaderSize":I
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$29(Lcom/livemixtapes/Mixtape;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iput v0, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 663
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$29(Lcom/livemixtapes/Mixtape;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iput v0, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 667
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->header:Landroid/view/View;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$30(Lcom/livemixtapes/Mixtape;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iput v1, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 669
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$29(Lcom/livemixtapes/Mixtape;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ImageView;->requestLayout()V

    .line 670
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->header:Landroid/view/View;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$30(Lcom/livemixtapes/Mixtape;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->requestLayout()V

    goto/16 :goto_0

    .line 649
    .end local v0    # "newCoverSize":I
    .end local v1    # "newHeaderSize":I
    :cond_3
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->views:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$21(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 650
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->release_seconds:J
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$22(Lcom/livemixtapes/Mixtape;)J

    move-result-wide v3

    cmp-long v3, v3, v9

    if-nez v3, :cond_4

    .line 651
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->date:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$23(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 652
    :cond_4
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->mixtapeBtns:Landroid/view/View;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$24(Lcom/livemixtapes/Mixtape;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 675
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$8;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-static {v0, p2}, Lcom/livemixtapes/Mixtape;->access$31(Lcom/livemixtapes/Mixtape;I)V

    .line 676
    return-void
.end method
