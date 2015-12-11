.class Lcom/aio/downloader/service/BatteryInfoService1$1$1$2$1;
.super Ljava/lang/Thread;
.source "BatteryInfoService1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$3:Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2$1;->this$3:Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;

    .line 153
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 159
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 161
    const-string v0, "http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=battery_apps_click"

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 162
    return-void
.end method
