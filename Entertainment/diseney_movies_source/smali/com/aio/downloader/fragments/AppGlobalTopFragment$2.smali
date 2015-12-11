.class Lcom/aio/downloader/fragments/AppGlobalTopFragment$2;
.super Landroid/content/BroadcastReceiver;
.source "AppGlobalTopFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/AppGlobalTopFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/AppGlobalTopFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/AppGlobalTopFragment$2;->this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    .line 60
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/aio/downloader/fragments/AppGlobalTopFragment$2;->this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    # getter for: Lcom/aio/downloader/fragments/AppGlobalTopFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/AppGlobalTopFragment;->access$0(Lcom/aio/downloader/fragments/AppGlobalTopFragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 65
    return-void
.end method
