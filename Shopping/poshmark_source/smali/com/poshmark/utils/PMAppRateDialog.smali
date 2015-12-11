.class public Lcom/poshmark/utils/PMAppRateDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "PMAppRateDialog.java"

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
    .line 26
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/poshmark/utils/PMAppRateDialog;->trigger:Lcom/poshmark/triggers/PMTrigger;

    .line 28
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/utils/PMAppRateDialog;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/PMAppRateDialog;

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/poshmark/utils/PMAppRateDialog;->launchPlayStore()V

    return-void
.end method

.method private launchPlayStore()V
    .locals 6

    .prologue
    .line 82
    invoke-virtual {p0}, Lcom/poshmark/utils/PMAppRateDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 84
    .local v0, "appPackageName":Ljava/lang/String;
    :try_start_0
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "market://details?id="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v2}, Lcom/poshmark/utils/PMAppRateDialog;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 88
    :goto_0
    return-void

    .line 85
    :catch_0
    move-exception v1

    .line 86
    .local v1, "ex":Landroid/content/ActivityNotFoundException;
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "http://play.google.com/store/apps/details?id="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v2}, Lcom/poshmark/utils/PMAppRateDialog;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/poshmark/utils/PMAppRateDialog;->trigger:Lcom/poshmark/triggers/PMTrigger;

    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->IGNORED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v0, v1}, Lcom/poshmark/triggers/PMTrigger;->setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V

    .line 93
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 32
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/utils/PMAppRateDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    invoke-direct {v1, v7}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 34
    .local v1, "alertDialogBuilder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {p0}, Lcom/poshmark/utils/PMAppRateDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    invoke-virtual {v7}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v3

    .line 35
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v7, 0x7f03000f

    const/4 v8, 0x0

    invoke-virtual {v3, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 36
    .local v2, "dialoglayout":Landroid/view/View;
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 38
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 40
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    const v7, 0x7f0c005d

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMButton;

    .line 41
    .local v4, "rateAppButton":Lcom/poshmark/ui/customviews/PMButton;
    const v7, 0x7f0c005e

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/customviews/PMButton;

    .line 42
    .local v6, "rateLaterButton":Lcom/poshmark/ui/customviews/PMButton;
    const v7, 0x7f0c005f

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMButton;

    .line 44
    .local v5, "rateCancelButton":Lcom/poshmark/ui/customviews/PMButton;
    if-eqz v4, :cond_0

    .line 45
    new-instance v7, Lcom/poshmark/utils/PMAppRateDialog$1;

    invoke-direct {v7, p0}, Lcom/poshmark/utils/PMAppRateDialog$1;-><init>(Lcom/poshmark/utils/PMAppRateDialog;)V

    invoke-virtual {v4, v7}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 56
    :cond_0
    if-eqz v6, :cond_1

    .line 57
    new-instance v7, Lcom/poshmark/utils/PMAppRateDialog$2;

    invoke-direct {v7, p0}, Lcom/poshmark/utils/PMAppRateDialog$2;-><init>(Lcom/poshmark/utils/PMAppRateDialog;)V

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 67
    :cond_1
    if-eqz v5, :cond_2

    .line 68
    new-instance v7, Lcom/poshmark/utils/PMAppRateDialog$3;

    invoke-direct {v7, p0}, Lcom/poshmark/utils/PMAppRateDialog$3;-><init>(Lcom/poshmark/utils/PMAppRateDialog;)V

    invoke-virtual {v5, v7}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 78
    :cond_2
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
