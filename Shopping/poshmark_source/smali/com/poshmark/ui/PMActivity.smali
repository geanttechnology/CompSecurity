.class public abstract Lcom/poshmark/ui/PMActivity;
.super Landroid/support/v4/app/FragmentActivity;
.source "PMActivity.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation build Lcom/newrelic/agent/android/instrumentation/Instrumented;
.end annotation


# instance fields
.field bIsInForeground:Z

.field bSaveStateCalled:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 20
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 22
    iput-boolean v0, p0, Lcom/poshmark/ui/PMActivity;->bIsInForeground:Z

    .line 23
    iput-boolean v0, p0, Lcom/poshmark/ui/PMActivity;->bSaveStateCalled:Z

    return-void
.end method


# virtual methods
.method public abstract getFragmentStack()Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Stack",
            "<",
            "Lcom/poshmark/ui/fragments/PMFragment;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getFragmentStackCount()I
.end method

.method public abstract getScreenNavigationStack()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getVisibleFragment()Lcom/poshmark/ui/fragments/PMFragment;
.end method

.method public abstract isActivityInForeground()Z
.end method

.method public abstract launchDialogFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V
.end method

.method public abstract launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
.end method

.method public abstract launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V
.end method

.method public abstract launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
.end method

.method public abstract launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V
.end method

.method public abstract launchSearchActivity()V
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const-string v0, "PMActivity"

    invoke-static {v0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->startTracing(Ljava/lang/String;)V

    :try_start_0
    iget-object v0, p0, Lcom/poshmark/ui/PMActivity;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "PMActivity#onCreate"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    :goto_0
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 47
    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "PMActivity#onCreate"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 51
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onDestroy()V

    .line 53
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/PMActivity;->bSaveStateCalled:Z

    .line 54
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 78
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 79
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/PMActivity;->bIsInForeground:Z

    .line 80
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 70
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 71
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/PMActivity;->bIsInForeground:Z

    .line 72
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/application/PMApplication;->setTopActivity(Lcom/poshmark/ui/PMActivity;)V

    .line 73
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/PMActivity;->bSaveStateCalled:Z

    .line 74
    return-void
.end method

.method protected onStart()V
    .locals 1

    .prologue
    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStarted()V

    .line 58
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onStart()V

    .line 60
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStopped()V

    .line 64
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onStop()V

    .line 65
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/PMActivity;->bSaveStateCalled:Z

    .line 66
    return-void
.end method

.method public abstract popTopFragment()V
.end method

.method public abstract popTopNFragments(IZ)V
.end method

.method public abstract replaceFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
.end method

.method public abstract setScreenNavigationStack(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method public startActivityForResult(Landroid/content/Intent;I)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "requestCode"    # I

    .prologue
    .line 84
    const-string v0, "requestCode"

    invoke-virtual {p1, v0, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 85
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 86
    return-void
.end method
