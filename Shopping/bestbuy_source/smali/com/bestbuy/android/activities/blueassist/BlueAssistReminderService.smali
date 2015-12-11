.class public Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;
.super Landroid/app/IntentService;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    const-string v0, "BlueAssistReminerService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 19
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 24
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 25
    new-instance v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService$1;

    invoke-direct {v1, p0, p1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService$1;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;Landroid/content/Intent;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 34
    return-void
.end method
