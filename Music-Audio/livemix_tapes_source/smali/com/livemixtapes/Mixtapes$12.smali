.class Lcom/livemixtapes/Mixtapes$12;
.super Ljava/lang/Object;
.source "Mixtapes.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtapes;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtapes;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtapes;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$12;->this$0:Lcom/livemixtapes/Mixtapes;

    .line 378
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 4
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    const/4 v3, 0x0

    .line 382
    add-int v0, p2, p3

    if-lt v0, p4, :cond_0

    .line 385
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$12;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/16 v1, 0xa

    if-le v0, v1, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$12;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->dataloading:Ljava/lang/Boolean;
    invoke-static {v0}, Lcom/livemixtapes/Mixtapes;->access$9(Lcom/livemixtapes/Mixtapes;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 386
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$12;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->lastPosition:I
    invoke-static {v0}, Lcom/livemixtapes/Mixtapes;->access$10(Lcom/livemixtapes/Mixtapes;)I

    move-result v1

    add-int/lit8 v1, v1, 0xa

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtapes;->access$11(Lcom/livemixtapes/Mixtapes;I)V

    .line 387
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$12;->this$0:Lcom/livemixtapes/Mixtapes;

    invoke-static {v0, v3}, Lcom/livemixtapes/Mixtapes;->access$12(Lcom/livemixtapes/Mixtapes;I)V

    .line 389
    const-string v0, "hserp"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "GRABBING: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lcom/livemixtapes/Mixtapes;->url:Ljava/lang/String;
    invoke-static {}, Lcom/livemixtapes/Mixtapes;->access$4()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 390
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$12;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->footerView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 391
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$12;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->Btngetdata:Landroid/widget/Button;

    invoke-virtual {v0}, Landroid/widget/Button;->performClick()Z

    .line 393
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 398
    return-void
.end method
