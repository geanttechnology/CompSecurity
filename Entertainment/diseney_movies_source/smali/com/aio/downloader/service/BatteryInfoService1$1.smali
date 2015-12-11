.class Lcom/aio/downloader/service/BatteryInfoService1$1;
.super Landroid/content/BroadcastReceiver;
.source "BatteryInfoService1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/BatteryInfoService1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private batterylow:Lcom/aio/downloader/dialog/Batterylow;

.field private itemsOnClick4:Landroid/view/View$OnClickListener;

.field final synthetic this$0:Lcom/aio/downloader/service/BatteryInfoService1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/BatteryInfoService1;)V
    .locals 3

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;

    .line 76
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 80
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 81
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 82
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 83
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->AIOBATTERY:Ljava/io/File;

    .line 84
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 85
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 86
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 87
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->AIOBATTERYAPK:Ljava/io/File;

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/dialog/Batterylow;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->batterylow:Lcom/aio/downloader/dialog/Batterylow;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/BatteryInfoService1$1;Landroid/view/View$OnClickListener;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->itemsOnClick4:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/BatteryInfoService1$1;)Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->itemsOnClick4:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/BatteryInfoService1$1;Lcom/aio/downloader/dialog/Batterylow;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->batterylow:Lcom/aio/downloader/dialog/Batterylow;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 95
    const-string v2, "notification"

    .line 97
    .local v2, "ns":Ljava/lang/String;
    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 96
    check-cast v1, Landroid/app/NotificationManager;

    .line 99
    .local v1, "mNotificationManager":Landroid/app/NotificationManager;
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string v4, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 101
    const-string v3, "level"

    const/4 v4, 0x0

    invoke-virtual {p2, v3, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 103
    .local v0, "level":I
    const/16 v3, 0x1e

    if-gt v0, v3, :cond_0

    iget-object v3, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1;->author:I
    invoke-static {v3}, Lcom/aio/downloader/service/BatteryInfoService1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1;)I

    move-result v3

    if-nez v3, :cond_0

    .line 104
    iget-object v3, p0, Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1;->author:I
    invoke-static {v3}, Lcom/aio/downloader/service/BatteryInfoService1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1;)I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v3, v4}, Lcom/aio/downloader/service/BatteryInfoService1;->access$1(Lcom/aio/downloader/service/BatteryInfoService1;I)V

    .line 105
    const-string v3, "asd"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "level="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    new-instance v4, Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    invoke-direct {v4, p0, p1}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;-><init>(Lcom/aio/downloader/service/BatteryInfoService1$1;Landroid/content/Context;)V

    .line 261
    const-wide/16 v5, 0x4e20

    .line 106
    invoke-virtual {v3, v4, v5, v6}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 265
    .end local v0    # "level":I
    :cond_0
    return-void
.end method
