.class Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5$1;
.super Ljava/lang/Object;
.source "Ringtone_Recent_Fragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;

    .line 105
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 110
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/report_fail.php?type="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;->type:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;->access$0(Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;->id:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;->access$1(Lcom/aio/downloader/fragments/Ringtone_Recent_Fragment$5;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 115
    return-void
.end method
