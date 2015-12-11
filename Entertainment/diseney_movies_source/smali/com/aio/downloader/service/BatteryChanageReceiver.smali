.class public Lcom/aio/downloader/service/BatteryChanageReceiver;
.super Landroid/content/BroadcastReceiver;
.source "BatteryChanageReceiver.java"


# static fields
.field private static mIntentFilter:Landroid/content/IntentFilter;

.field private static mReceiver:Lcom/aio/downloader/service/BatteryChanageReceiver;


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private battery:[I

.field private changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;

.field private fenzhong:Ljava/lang/String;

.field private isCharging:Z

.field private itemsOnClick4:Landroid/view/View$OnClickListener;

.field private level:I

.field private xiaoshi:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    new-instance v0, Lcom/aio/downloader/service/BatteryChanageReceiver;

    invoke-direct {v0}, Lcom/aio/downloader/service/BatteryChanageReceiver;-><init>()V

    sput-object v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->mReceiver:Lcom/aio/downloader/service/BatteryChanageReceiver;

    .line 32
    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 36
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 37
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 38
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 39
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERY:Ljava/io/File;

    .line 40
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 41
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 42
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 43
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERYAPK:Ljava/io/File;

    .line 44
    const/16 v0, 0x31

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    .line 47
    iput-object v0, p0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    .line 30
    return-void

    .line 44
    nop

    :array_0
    .array-data 4
        0x62
        0x60
        0x5e
        0x5c
        0x5a
        0x58
        0x56
        0x54
        0x52
        0x50
        0x4e
        0x4c
        0x4a
        0x48
        0x46
        0x44
        0x42
        0x40
        0x3e
        0x3c
        0x3a
        0x38
        0x36
        0x34
        0x32
        0x30
        0x2e
        0x2c
        0x2a
        0x28
        0x26
        0x24
        0x22
        0x20
        0x1e
        0x1c
        0x1a
        0x18
        0x16
        0x14
        0x12
        0x10
        0xe
        0xc
        0xa
        0x8
        0x6
        0x4
        0x2
    .end array-data
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/BatteryChanageReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/BatteryChanageReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryChanageReceiver;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/BatteryChanageReceiver;)Lcom/aio/downloader/dialog/ChangeDialog;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryChanageReceiver;->changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;

    return-object v0
.end method

.method public static registerReceiver(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 54
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sput-object v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->mIntentFilter:Landroid/content/IntentFilter;

    .line 55
    sget-object v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->mIntentFilter:Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.ACTION_POWER_CONNECTED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 56
    sget-object v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->mIntentFilter:Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 57
    sget-object v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->mIntentFilter:Landroid/content/IntentFilter;

    const-string v1, "com.aio.downloader.service.BatteryChanageReceiver"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 59
    sget-object v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->mReceiver:Lcom/aio/downloader/service/BatteryChanageReceiver;

    sget-object v1, Lcom/aio/downloader/service/BatteryChanageReceiver;->mIntentFilter:Landroid/content/IntentFilter;

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 60
    return-void
.end method

.method public static unregisterReceiver(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 63
    sget-object v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->mReceiver:Lcom/aio/downloader/service/BatteryChanageReceiver;

    invoke-virtual {p0, v0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 64
    return-void
.end method


# virtual methods
.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 441
    const-wide/16 v1, 0x0

    .line 442
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 443
    const/4 v0, 0x0

    .line 444
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 445
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 449
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 447
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 18
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 92
    :try_start_0
    new-instance v12, Landroid/content/IntentFilter;

    .line 93
    const-string v2, "android.intent.action.BATTERY_CHANGED"

    .line 92
    invoke-direct {v12, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 94
    .local v12, "ifilter":Landroid/content/IntentFilter;
    const/4 v2, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v12}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v9

    .line 95
    .local v9, "batteryStatus":Landroid/content/Intent;
    const-string v2, "level"

    .line 96
    const/4 v3, -0x1

    .line 95
    invoke-virtual {v9, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    move-object/from16 v0, p0

    iput v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    .line 97
    const-string v2, "status"

    .line 98
    const/4 v3, -0x1

    .line 97
    invoke-virtual {v9, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v15

    .line 100
    .local v15, "status":I
    const/4 v2, 0x2

    if-eq v15, v2, :cond_32

    .line 101
    const/4 v2, 0x5

    if-eq v15, v2, :cond_32

    const/4 v2, 0x0

    .line 100
    :goto_0
    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->isCharging:Z

    .line 103
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x30

    aget v3, v3, v4

    if-lt v2, v3, :cond_0

    .line 104
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 105
    const-string v2, "22"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 107
    :cond_0
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x2f

    aget v3, v3, v4

    if-lt v2, v3, :cond_1

    .line 108
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 109
    const-string v2, "21"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 111
    :cond_1
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x2e

    aget v3, v3, v4

    if-lt v2, v3, :cond_2

    .line 112
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 113
    const-string v2, "20"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 115
    :cond_2
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x2d

    aget v3, v3, v4

    if-lt v2, v3, :cond_3

    .line 116
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 117
    const-string v2, "18"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 119
    :cond_3
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x2c

    aget v3, v3, v4

    if-lt v2, v3, :cond_4

    .line 120
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 121
    const-string v2, "17"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 123
    :cond_4
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x2b

    aget v3, v3, v4

    if-lt v2, v3, :cond_5

    .line 124
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 125
    const-string v2, "16"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 127
    :cond_5
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x2a

    aget v3, v3, v4

    if-lt v2, v3, :cond_6

    .line 128
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 129
    const-string v2, "15"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 131
    :cond_6
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x29

    aget v3, v3, v4

    if-lt v2, v3, :cond_7

    .line 132
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 133
    const-string v2, "14"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 135
    :cond_7
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x28

    aget v3, v3, v4

    if-lt v2, v3, :cond_8

    .line 136
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 137
    const-string v2, "13"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 139
    :cond_8
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x27

    aget v3, v3, v4

    if-lt v2, v3, :cond_9

    .line 140
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 141
    const-string v2, "11"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 143
    :cond_9
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x26

    aget v3, v3, v4

    if-lt v2, v3, :cond_a

    .line 144
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 145
    const-string v2, "10"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 147
    :cond_a
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x25

    aget v3, v3, v4

    if-lt v2, v3, :cond_b

    .line 148
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 149
    const-string v2, "09"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 151
    :cond_b
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x24

    aget v3, v3, v4

    if-lt v2, v3, :cond_c

    .line 152
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 153
    const-string v2, "08"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 155
    :cond_c
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x23

    aget v3, v3, v4

    if-lt v2, v3, :cond_d

    .line 156
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 157
    const-string v2, "07"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 159
    :cond_d
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x22

    aget v3, v3, v4

    if-lt v2, v3, :cond_e

    .line 160
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 161
    const-string v2, "06"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 163
    :cond_e
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x21

    aget v3, v3, v4

    if-lt v2, v3, :cond_f

    .line 164
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 165
    const-string v2, "05"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 167
    :cond_f
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x20

    aget v3, v3, v4

    if-lt v2, v3, :cond_10

    .line 168
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 169
    const-string v2, "04"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 171
    :cond_10
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x1f

    aget v3, v3, v4

    if-lt v2, v3, :cond_11

    .line 172
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 173
    const-string v2, "03"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 175
    :cond_11
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x1e

    aget v3, v3, v4

    if-lt v2, v3, :cond_12

    .line 176
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 177
    const-string v2, "02"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 179
    :cond_12
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x1d

    aget v3, v3, v4

    if-lt v2, v3, :cond_13

    .line 180
    const-string v2, "01"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 181
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 183
    :cond_13
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x1c

    aget v3, v3, v4

    if-lt v2, v3, :cond_14

    .line 184
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 185
    const-string v2, "59"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 187
    :cond_14
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x1b

    aget v3, v3, v4

    if-lt v2, v3, :cond_15

    .line 188
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 189
    const-string v2, "58"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 191
    :cond_15
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x1a

    aget v3, v3, v4

    if-lt v2, v3, :cond_16

    .line 192
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 193
    const-string v2, "57"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 195
    :cond_16
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x19

    aget v3, v3, v4

    if-lt v2, v3, :cond_17

    .line 196
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 197
    const-string v2, "56"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 199
    :cond_17
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x18

    aget v3, v3, v4

    if-lt v2, v3, :cond_18

    .line 200
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 201
    const-string v2, "55"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 203
    :cond_18
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x17

    aget v3, v3, v4

    if-lt v2, v3, :cond_19

    .line 204
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 205
    const-string v2, "54"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 207
    :cond_19
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x16

    aget v3, v3, v4

    if-lt v2, v3, :cond_1a

    .line 208
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 209
    const-string v2, "53"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 211
    :cond_1a
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x15

    aget v3, v3, v4

    if-lt v2, v3, :cond_1b

    .line 212
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 213
    const-string v2, "52"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 215
    :cond_1b
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x14

    aget v3, v3, v4

    if-lt v2, v3, :cond_1c

    .line 216
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 217
    const-string v2, "50"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 219
    :cond_1c
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x13

    aget v3, v3, v4

    if-lt v2, v3, :cond_1d

    .line 220
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 221
    const-string v2, "49"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 223
    :cond_1d
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x12

    aget v3, v3, v4

    if-lt v2, v3, :cond_1e

    .line 224
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 225
    const-string v2, "47"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 227
    :cond_1e
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x11

    aget v3, v3, v4

    if-lt v2, v3, :cond_1f

    .line 228
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 229
    const-string v2, "45"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 231
    :cond_1f
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x10

    aget v3, v3, v4

    if-lt v2, v3, :cond_20

    .line 232
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 233
    const-string v2, "42"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 235
    :cond_20
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0xf

    aget v3, v3, v4

    if-lt v2, v3, :cond_21

    .line 236
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 237
    const-string v2, "39"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 239
    :cond_21
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0xe

    aget v3, v3, v4

    if-lt v2, v3, :cond_22

    .line 240
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 241
    const-string v2, "37"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 243
    :cond_22
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0xd

    aget v3, v3, v4

    if-lt v2, v3, :cond_23

    .line 244
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 245
    const-string v2, "35"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 247
    :cond_23
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0xc

    aget v3, v3, v4

    if-lt v2, v3, :cond_24

    .line 248
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 249
    const-string v2, "33"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 251
    :cond_24
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0xb

    aget v3, v3, v4

    if-lt v2, v3, :cond_25

    .line 252
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 253
    const-string v2, "32"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 255
    :cond_25
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0xa

    aget v3, v3, v4

    if-lt v2, v3, :cond_26

    .line 256
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 257
    const-string v2, "30"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 259
    :cond_26
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x9

    aget v3, v3, v4

    if-lt v2, v3, :cond_27

    .line 260
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 261
    const-string v2, "26"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 263
    :cond_27
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/16 v4, 0x8

    aget v3, v3, v4

    if-lt v2, v3, :cond_28

    .line 264
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 265
    const-string v2, "24"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 267
    :cond_28
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/4 v4, 0x7

    aget v3, v3, v4

    if-lt v2, v3, :cond_29

    .line 268
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 269
    const-string v2, "22"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 271
    :cond_29
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/4 v4, 0x6

    aget v3, v3, v4

    if-lt v2, v3, :cond_2a

    .line 272
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 273
    const-string v2, "21"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 275
    :cond_2a
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/4 v4, 0x5

    aget v3, v3, v4

    if-lt v2, v3, :cond_2b

    .line 276
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 277
    const-string v2, "19"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 279
    :cond_2b
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/4 v4, 0x4

    aget v3, v3, v4

    if-lt v2, v3, :cond_2c

    .line 280
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 281
    const-string v2, "15"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 283
    :cond_2c
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/4 v4, 0x3

    aget v3, v3, v4

    if-lt v2, v3, :cond_2d

    .line 284
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 285
    const-string v2, "10"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 287
    :cond_2d
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/4 v4, 0x2

    aget v3, v3, v4

    if-lt v2, v3, :cond_2e

    .line 288
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 289
    const-string v2, "09"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 291
    :cond_2e
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/4 v4, 0x1

    aget v3, v3, v4

    if-lt v2, v3, :cond_2f

    .line 292
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 293
    const-string v2, "07"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    .line 295
    :cond_2f
    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->battery:[I

    const/4 v4, 0x0

    aget v3, v3, v4

    if-lt v2, v3, :cond_30

    .line 296
    const-string v2, "00"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    .line 297
    const-string v2, "05"

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 303
    .end local v9    # "batteryStatus":Landroid/content/Intent;
    .end local v12    # "ifilter":Landroid/content/IntentFilter;
    .end local v15    # "status":I
    :cond_30
    :goto_1
    const/4 v14, 0x0

    .line 305
    .local v14, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_1
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 306
    const-string v3, "com.aioapp.battery"

    const/4 v4, 0x0

    .line 305
    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v14

    .line 310
    :goto_2
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->isCharging:Z

    if-eqz v2, :cond_31

    if-nez v14, :cond_31

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static/range {p1 .. p1}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetChangeTime(Landroid/content/Context;)J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-lez v2, :cond_31

    .line 311
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/32 v4, 0x2932e00

    add-long/2addr v2, v4

    move-object/from16 v0, p1

    invoke-static {v0, v2, v3}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetChangeTime(Landroid/content/Context;J)V

    .line 312
    new-instance v2, Lcom/aio/downloader/service/BatteryChanageReceiver$1;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/aio/downloader/service/BatteryChanageReceiver$1;-><init>(Lcom/aio/downloader/service/BatteryChanageReceiver;)V

    .line 321
    invoke-virtual {v2}, Lcom/aio/downloader/service/BatteryChanageReceiver$1;->start()V

    .line 322
    const-string v2, "batterychange"

    move-object/from16 v0, p1

    invoke-static {v0, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 324
    new-instance v2, Lcom/aio/downloader/service/BatteryChanageReceiver$2;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v2, v0, v1}, Lcom/aio/downloader/service/BatteryChanageReceiver$2;-><init>(Lcom/aio/downloader/service/BatteryChanageReceiver;Landroid/content/Context;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->itemsOnClick4:Landroid/view/View$OnClickListener;

    .line 413
    new-instance v2, Lcom/aio/downloader/dialog/ChangeDialog;

    const v4, 0x7f0c0010

    .line 414
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->itemsOnClick4:Landroid/view/View$OnClickListener;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->xiaoshi:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->fenzhong:Ljava/lang/String;

    move-object/from16 v0, p0

    iget v8, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->level:I

    move-object/from16 v3, p1

    invoke-direct/range {v2 .. v8}, Lcom/aio/downloader/dialog/ChangeDialog;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;I)V

    .line 413
    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;

    .line 415
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/ChangeDialog;->setCanceledOnTouchOutside(Z)V

    .line 416
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/ChangeDialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    .line 417
    const/16 v3, 0x7d3

    .line 416
    invoke-virtual {v2, v3}, Landroid/view/Window;->setType(I)V

    .line 418
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/ChangeDialog;->show()V

    .line 419
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/BatteryChanageReceiver;->changeDialog:Lcom/aio/downloader/dialog/ChangeDialog;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/ChangeDialog;->getWindow()Landroid/view/Window;

    move-result-object v10

    .line 420
    .local v10, "dialogWindow":Landroid/view/Window;
    invoke-virtual {v10}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v13

    .line 421
    .local v13, "lp":Landroid/view/WindowManager$LayoutParams;
    const/16 v2, 0x50

    invoke-virtual {v10, v2}, Landroid/view/Window;->setGravity(I)V

    .line 423
    const-string v2, "window"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v17

    .line 422
    check-cast v17, Landroid/view/WindowManager;

    .line 425
    .local v17, "wm":Landroid/view/WindowManager;
    invoke-interface/range {v17 .. v17}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Display;->getWidth()I

    move-result v16

    .line 428
    .local v16, "width":I
    move/from16 v0, v16

    iput v0, v13, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 434
    invoke-virtual {v10, v13}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 437
    .end local v10    # "dialogWindow":Landroid/view/Window;
    .end local v13    # "lp":Landroid/view/WindowManager$LayoutParams;
    .end local v16    # "width":I
    .end local v17    # "wm":Landroid/view/WindowManager;
    :cond_31
    return-void

    .line 101
    .end local v14    # "packageInfo":Landroid/content/pm/PackageInfo;
    .restart local v9    # "batteryStatus":Landroid/content/Intent;
    .restart local v12    # "ifilter":Landroid/content/IntentFilter;
    .restart local v15    # "status":I
    :cond_32
    const/4 v2, 0x1

    goto/16 :goto_0

    .line 307
    .end local v9    # "batteryStatus":Landroid/content/Intent;
    .end local v12    # "ifilter":Landroid/content/IntentFilter;
    .end local v15    # "status":I
    .restart local v14    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v11

    .line 308
    .local v11, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v11}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_2

    .line 299
    .end local v11    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v14    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_1
    move-exception v2

    goto/16 :goto_1
.end method
