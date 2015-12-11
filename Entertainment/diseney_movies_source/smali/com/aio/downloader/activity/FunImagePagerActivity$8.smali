.class Lcom/aio/downloader/activity/FunImagePagerActivity$8;
.super Ljava/lang/Thread;
.source "FunImagePagerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity;->onPageSelected(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$8;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    .line 497
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 502
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 503
    const-string v0, "www"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "url="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$8;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->url_gallery:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$19(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 504
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$8;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->url_gallery:Ljava/lang/String;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$19(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 505
    return-void
.end method
