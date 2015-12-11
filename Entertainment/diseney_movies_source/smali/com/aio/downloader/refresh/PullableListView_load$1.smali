.class Lcom/aio/downloader/refresh/PullableListView_load$1;
.super Ljava/lang/Object;
.source "PullableListView_load.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/refresh/PullableListView_load;->init(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/refresh/PullableListView_load;


# direct methods
.method constructor <init>(Lcom/aio/downloader/refresh/PullableListView_load;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/refresh/PullableListView_load$1;->this$0:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load$1;->this$0:Lcom/aio/downloader/refresh/PullableListView_load;

    # getter for: Lcom/aio/downloader/refresh/PullableListView_load;->state:I
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullableListView_load;->access$0(Lcom/aio/downloader/refresh/PullableListView_load;)I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load$1;->this$0:Lcom/aio/downloader/refresh/PullableListView_load;

    # getter for: Lcom/aio/downloader/refresh/PullableListView_load;->hasMoreData:Z
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullableListView_load;->access$1(Lcom/aio/downloader/refresh/PullableListView_load;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load$1;->this$0:Lcom/aio/downloader/refresh/PullableListView_load;

    # invokes: Lcom/aio/downloader/refresh/PullableListView_load;->load()V
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullableListView_load;->access$2(Lcom/aio/downloader/refresh/PullableListView_load;)V

    .line 75
    :cond_0
    return-void
.end method
