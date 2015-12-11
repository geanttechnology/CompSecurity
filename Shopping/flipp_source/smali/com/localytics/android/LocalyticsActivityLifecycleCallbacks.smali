.class public Lcom/localytics/android/LocalyticsActivityLifecycleCallbacks;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/localytics/android/LocalyticsActivityLifecycleCallbacks;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    invoke-static {p1, p2}, Lcom/localytics/android/Localytics;->integrate(Landroid/content/Context;Ljava/lang/String;)V

    .line 38
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/localytics/android/Localytics;->setIsAutoIntegrate(Z)V

    .line 39
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 44
    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 92
    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 68
    instance-of v0, p1, Landroid/support/v4/app/ac;

    if-eqz v0, :cond_0

    .line 70
    invoke-static {}, Lcom/localytics/android/Localytics;->dismissCurrentInAppMessage()V

    .line 71
    invoke-static {}, Lcom/localytics/android/Localytics;->clearInAppMessageDisplayActivity()V

    .line 74
    :cond_0
    invoke-static {}, Lcom/localytics/android/Localytics;->closeSession()V

    .line 75
    invoke-static {}, Lcom/localytics/android/Localytics;->upload()V

    .line 76
    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 55
    invoke-static {}, Lcom/localytics/android/Localytics;->openSession()V

    .line 56
    invoke-static {}, Lcom/localytics/android/Localytics;->upload()V

    .line 57
    instance-of v0, p1, Landroid/support/v4/app/ac;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 59
    check-cast v0, Landroid/support/v4/app/ac;

    invoke-static {v0}, Lcom/localytics/android/Localytics;->setInAppMessageDisplayActivity(Landroid/support/v4/app/ac;)V

    .line 61
    :cond_0
    invoke-virtual {p1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics;->handleTestMode(Landroid/content/Intent;)V

    .line 62
    invoke-virtual {p1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics;->handlePushNotificationOpened(Landroid/content/Intent;)V

    .line 63
    return-void
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 87
    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 49
    invoke-static {}, Lcom/localytics/android/Localytics;->incrementActivityCounter()V

    .line 50
    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 81
    invoke-static {}, Lcom/localytics/android/Localytics;->decrementActivityCounter()V

    .line 82
    return-void
.end method
