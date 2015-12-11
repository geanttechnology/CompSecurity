.class Lcom/aio/downloader/adapter/AppListviewAdapter$1$1;
.super Ljava/lang/Object;
.source "AppListviewAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppListviewAdapter$1;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/AppListviewAdapter$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppListviewAdapter$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1$1;->this$1:Lcom/aio/downloader/adapter/AppListviewAdapter$1;

    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 87
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=app&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 88
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1$1;->this$1:Lcom/aio/downloader/adapter/AppListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter$1;)Lcom/aio/downloader/adapter/AppListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->sp3:Landroid/content/SharedPreferences;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$4(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "appid"

    const-string v3, "invalid"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 89
    const-string v1, "&from=apk&add_to_list=1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 87
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 90
    return-void
.end method
