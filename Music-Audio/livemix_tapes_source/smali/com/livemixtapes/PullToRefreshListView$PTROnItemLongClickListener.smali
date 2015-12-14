.class Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;
.super Ljava/lang/Object;
.source "PullToRefreshListView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/PullToRefreshListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PTROnItemLongClickListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemLongClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/PullToRefreshListView;


# direct methods
.method private constructor <init>(Lcom/livemixtapes/PullToRefreshListView;)V
    .locals 0

    .prologue
    .line 576
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/PullToRefreshListView;Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;)V
    .locals 0

    .prologue
    .line 576
    invoke-direct {p0, p1}, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;-><init>(Lcom/livemixtapes/PullToRefreshListView;)V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v0, 0x0

    .line 580
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-static {v1, v0}, Lcom/livemixtapes/PullToRefreshListView;->access$11(Lcom/livemixtapes/PullToRefreshListView;Z)V

    .line 582
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->onItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;
    invoke-static {v1}, Lcom/livemixtapes/PullToRefreshListView;->access$13(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/AdapterView$OnItemLongClickListener;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;
    invoke-static {v1}, Lcom/livemixtapes/PullToRefreshListView;->access$0(Lcom/livemixtapes/PullToRefreshListView;)Lcom/livemixtapes/PullToRefreshListView$State;

    move-result-object v1

    sget-object v2, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v1, v2, :cond_0

    .line 585
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->onItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;
    invoke-static {v0}, Lcom/livemixtapes/PullToRefreshListView;->access$13(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/AdapterView$OnItemLongClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView;->getHeaderViewsCount()I

    move-result v1

    sub-int v3, p3, v1

    move-object v1, p1

    move-object v2, p2

    move-wide v4, p4

    invoke-interface/range {v0 .. v5}, Landroid/widget/AdapterView$OnItemLongClickListener;->onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z

    move-result v0

    .line 588
    :cond_0
    return v0
.end method
