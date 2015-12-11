.class Lcom/aio/downloader/activity/MiniGameDetails$1;
.super Ljava/lang/Object;
.source "MiniGameDetails.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MiniGameDetails;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MiniGameDetails;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MiniGameDetails;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MiniGameDetails$1;->this$0:Lcom/aio/downloader/activity/MiniGameDetails;

    .line 115
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 118
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v0, "http://android.downloadatoz.com/_201409/market/hits.php?type=minigame&id="

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails$1;->this$0:Lcom/aio/downloader/activity/MiniGameDetails;

    # getter for: Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGameDetails;->access$0(Lcom/aio/downloader/activity/MiniGameDetails;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails$1;->this$0:Lcom/aio/downloader/activity/MiniGameDetails;

    # getter for: Lcom/aio/downloader/activity/MiniGameDetails;->id:I
    invoke-static {v2}, Lcom/aio/downloader/activity/MiniGameDetails;->access$1(Lcom/aio/downloader/activity/MiniGameDetails;)I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getSerial()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&title="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails$1;->this$0:Lcom/aio/downloader/activity/MiniGameDetails;

    # getter for: Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGameDetails;->access$0(Lcom/aio/downloader/activity/MiniGameDetails;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails$1;->this$0:Lcom/aio/downloader/activity/MiniGameDetails;

    # getter for: Lcom/aio/downloader/activity/MiniGameDetails;->id:I
    invoke-static {v2}, Lcom/aio/downloader/activity/MiniGameDetails;->access$1(Lcom/aio/downloader/activity/MiniGameDetails;)I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 119
    return-void
.end method
