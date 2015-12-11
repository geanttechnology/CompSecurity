.class Lcom/aio/downloader/activity/MiniGamePlayActivity$1;
.super Ljava/lang/Object;
.source "MiniGamePlayActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MiniGamePlayActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MiniGamePlayActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$1;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 80
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 81
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$1;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    # getter for: Lcom/aio/downloader/activity/MiniGamePlayActivity;->sound:Ljava/lang/String;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->access$3(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$1;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    # getter for: Lcom/aio/downloader/activity/MiniGamePlayActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->access$4(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$1;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    # getter for: Lcom/aio/downloader/activity/MiniGamePlayActivity;->sound:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->access$3(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/Player;->playUrl(Ljava/lang/String;)V

    .line 84
    :cond_0
    return-void
.end method
