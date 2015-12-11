.class public Lcom/aio/downloader/service/ScreenReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ScreenReceiver.java"


# static fields
.field static launched:Z


# instance fields
.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private handler:Landroid/os/Handler;

.field private mContext:Landroid/content/Context;

.field private status:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x0

    sput-boolean v0, Lcom/aio/downloader/service/ScreenReceiver;->launched:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 39
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 40
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR_FOME:Ljava/io/File;

    .line 41
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 42
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR_TO:Ljava/io/File;

    .line 43
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 44
    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR:Ljava/io/File;

    .line 45
    new-instance v0, Lcom/aio/downloader/service/ScreenReceiver$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/ScreenReceiver$1;-><init>(Lcom/aio/downloader/service/ScreenReceiver;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver;->handler:Landroid/os/Handler;

    .line 34
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ScreenReceiver;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/ScreenReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/ScreenReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/ScreenReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/aio/downloader/service/ScreenReceiver;->mContext:Landroid/content/Context;

    .line 129
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 131
    .local v0, "action":Ljava/lang/String;
    const/4 v2, 0x0

    .line 133
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 134
    const-string v4, "com.evzapp.cleanmaster"

    const/4 v5, 0x0

    .line 133
    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 187
    :goto_0
    const-string v3, "android.intent.action.SCREEN_OFF"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 190
    const-string v3, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 193
    return-void

    .line 135
    :catch_0
    move-exception v1

    .line 136
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0
.end method
