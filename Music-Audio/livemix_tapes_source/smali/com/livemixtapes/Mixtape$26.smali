.class Lcom/livemixtapes/Mixtape$26;
.super Ljava/util/TimerTask;
.source "Mixtape.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->checkIfTimerOn()V
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
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    .line 2056
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Mixtape$26;)Lcom/livemixtapes/Mixtape;
    .locals 1

    .prologue
    .line 2056
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 2059
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 2060
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape$26;->cancel()Z

    .line 2061
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    const/4 v4, 0x0

    iput-object v4, v3, Lcom/livemixtapes/Mixtape;->globalTimer:Ljava/util/Timer;

    .line 2097
    :cond_0
    return-void

    .line 2067
    :cond_1
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->mScrollState:I
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$42(Lcom/livemixtapes/Mixtape;)I

    move-result v3

    if-nez v3, :cond_0

    .line 2070
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 2071
    .local v0, "key":Ljava/lang/String;
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->listPosMap:Ljava/util/HashMap;

    invoke-virtual {v3, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 2073
    .local v1, "pos":I
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v3

    if-lt v1, v3, :cond_0

    .line 2074
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ListView;->getLastVisiblePosition()I

    move-result v3

    if-gt v1, v3, :cond_0

    .line 2076
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v3

    .line 2077
    iget-object v5, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v5}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v5

    invoke-virtual {v5}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v5

    sub-int v5, v1, v5

    .line 2076
    invoke-virtual {v3, v5}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 2078
    .local v2, "v":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 2080
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->handler:Landroid/os/Handler;

    new-instance v5, Lcom/livemixtapes/Mixtape$26$1;

    invoke-direct {v5, p0, v0, v2}, Lcom/livemixtapes/Mixtape$26$1;-><init>(Lcom/livemixtapes/Mixtape$26;Ljava/lang/String;Landroid/view/View;)V

    invoke-virtual {v3, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method
