.class public Lcom/poshmark/utils/PMLoveDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "PMLoveDialog.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation build Lcom/newrelic/agent/android/instrumentation/Instrumented;
.end annotation


# instance fields
.field trigger:Lcom/poshmark/triggers/PMTrigger;


# direct methods
.method public constructor <init>(Lcom/poshmark/triggers/PMTrigger;)V
    .locals 0
    .param p1, "trigger"    # Lcom/poshmark/triggers/PMTrigger;

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/poshmark/utils/PMLoveDialog;->trigger:Lcom/poshmark/triggers/PMTrigger;

    .line 27
    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/poshmark/utils/PMLoveDialog;->trigger:Lcom/poshmark/triggers/PMTrigger;

    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->IGNORED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v0, v1}, Lcom/poshmark/triggers/PMTrigger;->setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V

    .line 74
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 31
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/utils/PMLoveDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-direct {v1, v6}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 33
    .local v1, "alertDialogBuilder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {p0}, Lcom/poshmark/utils/PMLoveDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v3

    .line 34
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v6, 0x7f0300a3

    const/4 v7, 0x0

    invoke-virtual {v3, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 35
    .local v2, "dialoglayout":Landroid/view/View;
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 37
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 39
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    const v6, 0x7f0c0268

    invoke-virtual {v2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    .line 40
    .local v4, "noButton":Landroid/widget/Button;
    const v6, 0x7f0c026a

    invoke-virtual {v2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    .line 42
    .local v5, "yesButton":Landroid/widget/Button;
    if-eqz v4, :cond_0

    .line 43
    new-instance v6, Lcom/poshmark/utils/PMLoveDialog$1;

    invoke-direct {v6, p0}, Lcom/poshmark/utils/PMLoveDialog$1;-><init>(Lcom/poshmark/utils/PMLoveDialog;)V

    invoke-virtual {v4, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 56
    :cond_0
    if-eqz v5, :cond_1

    .line 57
    new-instance v6, Lcom/poshmark/utils/PMLoveDialog$2;

    invoke-direct {v6, p0}, Lcom/poshmark/utils/PMLoveDialog$2;-><init>(Lcom/poshmark/utils/PMLoveDialog;)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 68
    :cond_1
    return-object v0
.end method

.method protected onStart()V
    .locals 1

    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onStart()V

    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStarted()V

    return-void
.end method

.method protected onStop()V
    .locals 1

    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onStop()V

    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStopped()V

    return-void
.end method
