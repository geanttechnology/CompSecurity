.class Lcom/aio/downloader/fragments/Mp3SearchFragment$6$1;
.super Ljava/lang/Object;
.source "Mp3SearchFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/Mp3SearchFragment$6;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/fragments/Mp3SearchFragment$6;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Mp3SearchFragment$6;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$6$1;->this$1:Lcom/aio/downloader/fragments/Mp3SearchFragment$6;

    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 120
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/report_fail.php?type="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 121
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$6$1;->this$1:Lcom/aio/downloader/fragments/Mp3SearchFragment$6;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment$6;->type:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3SearchFragment$6;->access$0(Lcom/aio/downloader/fragments/Mp3SearchFragment$6;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$6$1;->this$1:Lcom/aio/downloader/fragments/Mp3SearchFragment$6;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment$6;->id:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3SearchFragment$6;->access$1(Lcom/aio/downloader/fragments/Mp3SearchFragment$6;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 120
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 123
    return-void
.end method
