.class public Lcom/poshmark/utils/PoshLearnDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "PoshLearnDialog.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation build Lcom/newrelic/agent/android/instrumentation/Instrumented;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 28
    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 55
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalPartiesController;->enablePartyAlerts()V

    .line 56
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 32
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/utils/PoshLearnDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-direct {v1, v5}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 34
    .local v1, "alertDialogBuilder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {p0}, Lcom/poshmark/utils/PoshLearnDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v4

    .line 35
    .local v4, "inflater":Landroid/view/LayoutInflater;
    const v5, 0x7f0300a4

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 37
    .local v3, "dialoglayout":Landroid/view/View;
    const v5, 0x7f0c026e

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 38
    .local v2, "button":Landroid/widget/Button;
    new-instance v5, Lcom/poshmark/utils/PoshLearnDialog$1;

    invoke-direct {v5, p0}, Lcom/poshmark/utils/PoshLearnDialog$1;-><init>(Lcom/poshmark/utils/PoshLearnDialog;)V

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 46
    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 48
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 50
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    return-object v0
.end method

.method public onStart()V
    .locals 8

    .prologue
    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v5

    invoke-virtual {v5}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStarted()V

    .line 60
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onStart()V

    .line 63
    invoke-virtual {p0}, Lcom/poshmark/utils/PoshLearnDialog;->getDialog()Landroid/app/Dialog;

    move-result-object v5

    if-nez v5, :cond_0

    .line 74
    .local v0, "display":Landroid/view/Display;
    .local v1, "height":I
    .local v2, "size":Landroid/graphics/Point;
    .local v3, "width":I
    .local v4, "wm":Landroid/view/WindowManager;
    :goto_0
    return-void

    .line 67
    .end local v0    # "display":Landroid/view/Display;
    .end local v1    # "height":I
    .end local v2    # "size":Landroid/graphics/Point;
    .end local v3    # "width":I
    .end local v4    # "wm":Landroid/view/WindowManager;
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/utils/PoshLearnDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    const-string v6, "window"

    invoke-virtual {v5, v6}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/WindowManager;

    .line 68
    .restart local v4    # "wm":Landroid/view/WindowManager;
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 69
    .restart local v0    # "display":Landroid/view/Display;
    new-instance v2, Landroid/graphics/Point;

    invoke-direct {v2}, Landroid/graphics/Point;-><init>()V

    .line 70
    .restart local v2    # "size":Landroid/graphics/Point;
    invoke-virtual {v0, v2}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 71
    iget v5, v2, Landroid/graphics/Point;->x:I

    invoke-virtual {p0}, Lcom/poshmark/utils/PoshLearnDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    const/high16 v7, 0x41700000    # 15.0f

    invoke-static {v6, v7}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v6

    float-to-int v6, v6

    sub-int v3, v5, v6

    .line 72
    .restart local v3    # "width":I
    iget v5, v2, Landroid/graphics/Point;->y:I

    invoke-virtual {p0}, Lcom/poshmark/utils/PoshLearnDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    const/high16 v7, 0x42f00000    # 120.0f

    invoke-static {v6, v7}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v6

    float-to-int v6, v6

    sub-int v1, v5, v6

    .line 73
    .restart local v1    # "height":I
    invoke-virtual {p0}, Lcom/poshmark/utils/PoshLearnDialog;->getDialog()Landroid/app/Dialog;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v5

    invoke-virtual {v5, v3, v1}, Landroid/view/Window;->setLayout(II)V

    goto :goto_0
.end method

.method protected onStop()V
    .locals 1

    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onStop()V

    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStopped()V

    return-void
.end method
