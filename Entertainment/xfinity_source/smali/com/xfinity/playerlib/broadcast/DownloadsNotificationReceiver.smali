.class public Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;
.super Landroid/content/BroadcastReceiver;
.source "DownloadsNotificationReceiver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field private static prevId:Lcom/xfinity/playerlib/model/MerlinId;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    const-class v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 63
    return-void
.end method

.method static synthetic access$000()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 47
    sget-object v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->prevId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method static synthetic access$002(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/MerlinId;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 47
    sput-object p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->prevId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object p0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aIntent"    # Landroid/content/Intent;

    .prologue
    .line 58
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 59
    invoke-static {p1, p2}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->createIntent(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 61
    :cond_0
    return-void
.end method
