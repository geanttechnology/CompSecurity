.class Lcom/aio/downloader/fragments/PaidHotGamesFragment$1;
.super Landroid/content/BroadcastReceiver;
.source "PaidHotGamesFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/PaidHotGamesFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/PaidHotGamesFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/PaidHotGamesFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/PaidHotGamesFragment$1;->this$0:Lcom/aio/downloader/fragments/PaidHotGamesFragment;

    .line 49
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/fragments/PaidHotGamesFragment$1;->this$0:Lcom/aio/downloader/fragments/PaidHotGamesFragment;

    # getter for: Lcom/aio/downloader/fragments/PaidHotGamesFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/PaidHotGamesFragment;->access$0(Lcom/aio/downloader/fragments/PaidHotGamesFragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 55
    return-void
.end method
