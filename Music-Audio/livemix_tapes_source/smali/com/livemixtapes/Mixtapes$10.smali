.class Lcom/livemixtapes/Mixtapes$10;
.super Ljava/lang/Object;
.source "Mixtapes.java"

# interfaces
.implements Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;


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
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    .line 339
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRefresh()V
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 343
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v1, v1, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 344
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    invoke-static {v1, v3}, Lcom/livemixtapes/Mixtapes;->access$5(Lcom/livemixtapes/Mixtapes;I)V

    .line 345
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    const/4 v2, -0x1

    invoke-static {v1, v2}, Lcom/livemixtapes/Mixtapes;->access$11(Lcom/livemixtapes/Mixtapes;I)V

    .line 346
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    invoke-static {v1, v3}, Lcom/livemixtapes/Mixtapes;->access$12(Lcom/livemixtapes/Mixtapes;I)V

    .line 347
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v1, v1, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView;->setRefreshing()V

    .line 350
    :try_start_0
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    new-instance v2, Lcom/livemixtapes/Mixtapes$JSONParse;

    iget-object v3, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    const/4 v4, 0x0

    invoke-direct {v2, v3, v4}, Lcom/livemixtapes/Mixtapes$JSONParse;-><init>(Lcom/livemixtapes/Mixtapes;Lcom/livemixtapes/Mixtapes$JSONParse;)V

    iput-object v2, v1, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    .line 351
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v1, v1, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/livemixtapes/Mixtapes$JSONParse;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 357
    :goto_0
    return-void

    .line 353
    :catch_0
    move-exception v0

    .line 355
    .local v0, "e":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$10;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v1, v1, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/livemixtapes/Mixtapes$JSONParse;->cancel(Z)Z

    goto :goto_0
.end method
