.class public Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "DownloadsActivity.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    return-void
.end method

.method private cancelNotificationIfRequested(Landroid/content/Intent;)V
    .locals 6
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/high16 v5, -0x80000000

    .line 45
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.xfinity.playerlib.DOWNLOADS_NOTIFICATION.MANAGE_BUTTON"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 47
    const-string v3, "EXTRA_NOTIFICATION_ID_TO_CANCEL"

    invoke-virtual {p1, v3, v5}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 48
    .local v0, "intentNotificationIdExtra":I
    const-string v3, "EXTRA_NOTIFICATION_TAG_TO_CANCEL"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 49
    .local v1, "intentNotificationTagExtra":Ljava/lang/String;
    if-eq v0, v5, :cond_0

    if-eqz v1, :cond_0

    .line 50
    const-string v3, "notification"

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/NotificationManager;

    .line 51
    .local v2, "notificationManager":Landroid/app/NotificationManager;
    invoke-virtual {v2, v1, v0}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    .line 54
    .end local v0    # "intentNotificationIdExtra":I
    .end local v1    # "intentNotificationTagExtra":Ljava/lang/String;
    .end local v2    # "notificationManager":Landroid/app/NotificationManager;
    :cond_0
    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 19
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_downloads:I

    return v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 24
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_back_downloads:I

    return v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 29
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onCreate(Landroid/os/Bundle;)V

    .line 31
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 33
    .local v0, "intent":Landroid/content/Intent;
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;->cancelNotificationIfRequested(Landroid/content/Intent;)V

    .line 34
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 40
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;->cancelNotificationIfRequested(Landroid/content/Intent;)V

    .line 41
    return-void
.end method
