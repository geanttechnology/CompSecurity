.class Lcom/aio/downloader/service/BatteryChanageReceiver$1;
.super Ljava/lang/Thread;
.source "BatteryChanageReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/BatteryChanageReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/BatteryChanageReceiver;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/BatteryChanageReceiver$1;->this$0:Lcom/aio/downloader/service/BatteryChanageReceiver;

    .line 312
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 317
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 319
    const-string v0, "http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=battery_charging"

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 320
    return-void
.end method
