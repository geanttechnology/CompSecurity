.class Lcom/inc247/Location_Alert$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/Location_Alert;->showGPSDisabledAlertToUser(Ljava/lang/String;)V
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 87
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    .line 88
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 87
    sput-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    .line 89
    sget-boolean v0, Lcom/inc247/constants/ChatSDKConstants;->isUserPermitGps:Z

    if-eqz v0, :cond_1

    .line 90
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 91
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 93
    :cond_0
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->getLocationAlertStatus()Z

    move-result v0

    if-nez v0, :cond_2

    .line 94
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 95
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 96
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setCancelable(Z)V

    .line 98
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->setLocationAlertShowingOrNot(Z)V

    .line 106
    :cond_1
    :goto_0
    return-void

    .line 100
    :cond_2
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 101
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    goto :goto_0
.end method
