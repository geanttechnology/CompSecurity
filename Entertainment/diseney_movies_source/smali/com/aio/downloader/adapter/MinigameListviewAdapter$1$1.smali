.class Lcom/aio/downloader/adapter/MinigameListviewAdapter$1$1;
.super Ljava/lang/Object;
.source "MinigameListviewAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;

.field private final synthetic val$in_fo:Lcom/aio/downloader/model/MiniGameModel;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;Lcom/aio/downloader/model/MiniGameModel;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1$1;->this$1:Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;

    iput-object p2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1$1;->val$in_fo:Lcom/aio/downloader/model/MiniGameModel;

    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 111
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=minigame&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 112
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1$1;->val$in_fo:Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/MiniGameModel;->getSerial()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&title="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 113
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1$1;->val$in_fo:Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/MiniGameModel;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 111
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 115
    return-void
.end method
