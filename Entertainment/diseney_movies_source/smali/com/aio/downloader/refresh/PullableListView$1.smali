.class Lcom/aio/downloader/refresh/PullableListView$1;
.super Ljava/lang/Object;
.source "PullableListView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/refresh/PullableListView;->init(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/refresh/PullableListView;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/refresh/PullableListView;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/refresh/PullableListView$1;->this$0:Lcom/aio/downloader/refresh/PullableListView;

    iput-object p2, p0, Lcom/aio/downloader/refresh/PullableListView$1;->val$context:Landroid/content/Context;

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 70
    iget-object v1, p0, Lcom/aio/downloader/refresh/PullableListView$1;->this$0:Lcom/aio/downloader/refresh/PullableListView;

    # getter for: Lcom/aio/downloader/refresh/PullableListView;->state:I
    invoke-static {v1}, Lcom/aio/downloader/refresh/PullableListView;->access$0(Lcom/aio/downloader/refresh/PullableListView;)I

    move-result v1

    const/4 v2, 0x1

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/refresh/PullableListView$1;->this$0:Lcom/aio/downloader/refresh/PullableListView;

    # getter for: Lcom/aio/downloader/refresh/PullableListView;->hasMoreData:Z
    invoke-static {v1}, Lcom/aio/downloader/refresh/PullableListView;->access$1(Lcom/aio/downloader/refresh/PullableListView;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 71
    new-instance v0, Landroid/content/Intent;

    const-string v1, "load_more"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 72
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/refresh/PullableListView$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 75
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    return-void
.end method
