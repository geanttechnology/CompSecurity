.class public Lcom/poshmark/ui/PmNotificationRecieverActivity;
.super Landroid/app/Activity;
.source "PmNotificationRecieverActivity.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation build Lcom/newrelic/agent/android/instrumentation/Instrumented;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const-string v4, "PmNotificationRecieverActivity"

    invoke-static {v4}, Lcom/newrelic/agent/android/tracing/TraceMachine;->startTracing(Ljava/lang/String;)V

    :try_start_0
    iget-object v4, p0, Lcom/poshmark/ui/PmNotificationRecieverActivity;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v5, "PmNotificationRecieverActivity#onCreate"

    const/4 v6, 0x0

    invoke-static {v4, v5, v6}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 26
    :goto_0
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v3

    .line 30
    .local v3, "topActivity":Lcom/poshmark/ui/PMActivity;
    invoke-virtual {p0}, Lcom/poshmark/ui/PmNotificationRecieverActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 31
    .local v2, "notificationIntent":Landroid/content/Intent;
    const-string v4, "NOTIFICATION_BUNDLE"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 32
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 34
    new-instance v1, Landroid/content/Intent;

    const-class v4, Lcom/poshmark/ui/MainActivity;

    invoke-direct {v1, p0, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 35
    .local v1, "newIntent":Landroid/content/Intent;
    const-string v4, "NOTIFICATION_BUNDLE"

    invoke-virtual {v1, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 36
    const-string v4, "android.intent.action.MAIN"

    invoke-virtual {v1, v4}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 37
    const-string v4, "android.intent.category.LAUNCHER"

    invoke-virtual {v1, v4}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 38
    const/high16 v4, 0x24000000

    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 40
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/PmNotificationRecieverActivity;->startActivity(Landroid/content/Intent;)V

    .line 42
    .end local v1    # "newIntent":Landroid/content/Intent;
    :cond_0
    invoke-virtual {p0, v2}, Lcom/poshmark/ui/PmNotificationRecieverActivity;->removeStickyBroadcast(Landroid/content/Intent;)V

    .line 43
    invoke-virtual {p0}, Lcom/poshmark/ui/PmNotificationRecieverActivity;->finish()V

    .line 44
    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "notificationIntent":Landroid/content/Intent;
    .end local v3    # "topActivity":Lcom/poshmark/ui/PMActivity;
    :catch_0
    move-exception v4

    const/4 v4, 0x0

    :try_start_1
    const-string v5, "PmNotificationRecieverActivity#onCreate"

    const/4 v6, 0x0

    invoke-static {v4, v5, v6}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 49
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 50
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 20
    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    .line 22
    return-void
.end method

.method protected onStart()V
    .locals 1

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStarted()V

    return-void
.end method

.method protected onStop()V
    .locals 1

    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStopped()V

    return-void
.end method
