.class public Lcom/aio/downloader/jpush/JpushMainActivity;
.super Landroid/app/Activity;
.source "JpushMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;
    }
.end annotation


# static fields
.field public static final KEY_EXTRAS:Ljava/lang/String; = "extras"

.field public static final KEY_MESSAGE:Ljava/lang/String; = "message"

.field public static final KEY_TITLE:Ljava/lang/String; = "title"

.field public static final MESSAGE_RECEIVED_ACTION:Ljava/lang/String; = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION"

.field public static isForeground:Z


# instance fields
.field private mMessageReceiver:Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    sput-boolean v0, Lcom/aio/downloader/jpush/JpushMainActivity;->isForeground:Z

    .line 54
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 20
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 21
    const v0, 0x7f030063

    invoke-virtual {p0, v0}, Lcom/aio/downloader/jpush/JpushMainActivity;->setContentView(I)V

    .line 23
    invoke-virtual {p0}, Lcom/aio/downloader/jpush/JpushMainActivity;->registerMessageReceiver()V

    .line 25
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/jpush/JpushMainActivity;->mMessageReceiver:Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/jpush/JpushMainActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 47
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 48
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x0

    sput-boolean v0, Lcom/aio/downloader/jpush/JpushMainActivity;->isForeground:Z

    .line 39
    invoke-static {p0}, Lcn/jpush/android/api/JPushInterface;->init(Landroid/content/Context;)V

    .line 40
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 41
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 42
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 29
    const/4 v0, 0x1

    sput-boolean v0, Lcom/aio/downloader/jpush/JpushMainActivity;->isForeground:Z

    .line 31
    invoke-static {p0}, Lcn/jpush/android/api/JPushInterface;->onResume(Landroid/content/Context;)V

    .line 32
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 33
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 34
    return-void
.end method

.method public registerMessageReceiver()V
    .locals 2

    .prologue
    .line 57
    new-instance v1, Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;

    invoke-direct {v1, p0}, Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;-><init>(Lcom/aio/downloader/jpush/JpushMainActivity;)V

    iput-object v1, p0, Lcom/aio/downloader/jpush/JpushMainActivity;->mMessageReceiver:Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;

    .line 58
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 59
    .local v0, "filter":Landroid/content/IntentFilter;
    const/16 v1, 0x3e8

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->setPriority(I)V

    .line 60
    const-string v1, "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 61
    iget-object v1, p0, Lcom/aio/downloader/jpush/JpushMainActivity;->mMessageReceiver:Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/aio/downloader/jpush/JpushMainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 62
    return-void
.end method
