.class Lcom/aio/downloader/cleaner/RubActivity$1$1$1;
.super Ljava/lang/Thread;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity$1$1;->onPostExecute(Ljava/lang/Void;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity$1$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$1;->this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

    .line 175
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 180
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 181
    const-string v0, "http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install"

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 182
    return-void
.end method
