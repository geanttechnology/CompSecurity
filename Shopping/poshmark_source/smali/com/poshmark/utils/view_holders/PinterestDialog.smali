.class public Lcom/poshmark/utils/view_holders/PinterestDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "PinterestDialog.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation build Lcom/newrelic/agent/android/instrumentation/Instrumented;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/view_holders/PinterestDialog$2;,
        Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;
    }
.end annotation


# instance fields
.field clickListener:Landroid/view/View$OnClickListener;

.field current_mode:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 33
    new-instance v0, Lcom/poshmark/utils/view_holders/PinterestDialog$1;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/view_holders/PinterestDialog$1;-><init>(Lcom/poshmark/utils/view_holders/PinterestDialog;)V

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/PinterestDialog;->clickListener:Landroid/view/View$OnClickListener;

    .line 39
    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 5
    .param p1, "dialoglayout"    # Landroid/view/View;

    .prologue
    .line 59
    sget-object v3, Lcom/poshmark/utils/view_holders/PinterestDialog$2;->$SwitchMap$com$poshmark$utils$view_holders$PinterestDialog$PINTEREST_DIALOG_MODE:[I

    iget-object v4, p0, Lcom/poshmark/utils/view_holders/PinterestDialog;->current_mode:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    invoke-virtual {v4}, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 71
    :goto_0
    return-void

    .line 61
    :pswitch_0
    const v3, 0x7f0c0262

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 62
    .local v0, "connect_now":Landroid/widget/Button;
    const v3, 0x7f0c0263

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    .line 63
    .local v2, "proceedListing_button":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v3, p0, Lcom/poshmark/utils/view_holders/PinterestDialog;->clickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    iget-object v3, p0, Lcom/poshmark/utils/view_holders/PinterestDialog;->clickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 67
    .end local v0    # "connect_now":Landroid/widget/Button;
    .end local v2    # "proceedListing_button":Lcom/poshmark/ui/customviews/PMTextView;
    :pswitch_1
    const v3, 0x7f0c0260

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 68
    .local v1, "gotIt":Landroid/widget/Button;
    iget-object v3, p0, Lcom/poshmark/utils/view_holders/PinterestDialog;->clickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 59
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 80
    invoke-super {p0, p1}, Landroid/support/v4/app/DialogFragment;->onCancel(Landroid/content/DialogInterface;)V

    .line 81
    const-string v0, "com.poshmark.intents.PINTEREST_FIRST_TIME_DIALOG_BACK"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 82
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x0

    .line 43
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/utils/view_holders/PinterestDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v1, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 45
    .local v1, "alertDialogBuilder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {p0}, Lcom/poshmark/utils/view_holders/PinterestDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v3

    .line 47
    .local v3, "inflater":Landroid/view/LayoutInflater;
    iget-object v4, p0, Lcom/poshmark/utils/view_holders/PinterestDialog;->current_mode:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    sget-object v5, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->POST_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    if-ne v4, v5, :cond_0

    .line 48
    const v4, 0x7f0300a0

    invoke-virtual {v3, v4, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 51
    .local v2, "dialoglayout":Landroid/view/View;
    :goto_0
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 53
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 54
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    invoke-direct {p0, v2}, Lcom/poshmark/utils/view_holders/PinterestDialog;->setupView(Landroid/view/View;)V

    .line 55
    return-object v0

    .line 50
    .end local v0    # "alertDialog":Landroid/app/AlertDialog;
    .end local v2    # "dialoglayout":Landroid/view/View;
    :cond_0
    const v4, 0x7f0300a1

    invoke-virtual {v3, v4, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .restart local v2    # "dialoglayout":Landroid/view/View;
    goto :goto_0
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

.method public setClickListener(Landroid/view/View$OnClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/poshmark/utils/view_holders/PinterestDialog;->clickListener:Landroid/view/View$OnClickListener;

    .line 76
    return-void
.end method

.method public setCurrent_mode(Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;)V
    .locals 0
    .param p1, "current_mode"    # Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/poshmark/utils/view_holders/PinterestDialog;->current_mode:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    .line 29
    return-void
.end method
