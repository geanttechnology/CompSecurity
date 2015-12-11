.class Lcom/aio/downloader/activity/VideoActivity$4$1;
.super Ljava/lang/Object;
.source "VideoActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/VideoActivity$4;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/VideoActivity$4;

.field private final synthetic val$list:Ljava/util/ArrayList;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity$4;Ljava/util/ArrayList;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$4$1;->this$1:Lcom/aio/downloader/activity/VideoActivity$4;

    iput-object p2, p0, Lcom/aio/downloader/activity/VideoActivity$4$1;->val$list:Ljava/util/ArrayList;

    iput p3, p0, Lcom/aio/downloader/activity/VideoActivity$4$1;->val$position:I

    .line 514
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 519
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v0, "http://android.downloadatoz.com/_201409/market/hits.php?type=youtube&id="

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 520
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$4$1;->val$list:Ljava/util/ArrayList;

    iget v2, p0, Lcom/aio/downloader/activity/VideoActivity$4$1;->val$position:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/VideoModel;

    .line 521
    invoke-virtual {v0}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_id()Ljava/lang/String;

    move-result-object v0

    .line 520
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 519
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 523
    return-void
.end method
