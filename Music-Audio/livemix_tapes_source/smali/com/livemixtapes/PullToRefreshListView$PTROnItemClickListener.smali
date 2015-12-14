.class Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;
.super Ljava/lang/Object;
.source "PullToRefreshListView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/PullToRefreshListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PTROnItemClickListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/PullToRefreshListView;


# direct methods
.method private constructor <init>(Lcom/livemixtapes/PullToRefreshListView;)V
    .locals 0

    .prologue
    .line 562
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/PullToRefreshListView;Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;)V
    .locals 0

    .prologue
    .line 562
    invoke-direct {p0, p1}, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;-><init>(Lcom/livemixtapes/PullToRefreshListView;)V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
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
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 566
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/livemixtapes/PullToRefreshListView;->access$11(Lcom/livemixtapes/PullToRefreshListView;Z)V

    .line 568
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->onItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;
    invoke-static {v0}, Lcom/livemixtapes/PullToRefreshListView;->access$12(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;
    invoke-static {v0}, Lcom/livemixtapes/PullToRefreshListView;->access$0(Lcom/livemixtapes/PullToRefreshListView;)Lcom/livemixtapes/PullToRefreshListView$State;

    move-result-object v0

    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v0, v1, :cond_0

    .line 571
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->onItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;
    invoke-static {v0}, Lcom/livemixtapes/PullToRefreshListView;->access$12(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView;->getHeaderViewsCount()I

    move-result v1

    sub-int v3, p3, v1

    move-object v1, p1

    move-object v2, p2

    move-wide v4, p4

    invoke-interface/range {v0 .. v5}, Landroid/widget/AdapterView$OnItemClickListener;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V

    .line 573
    :cond_0
    return-void
.end method
