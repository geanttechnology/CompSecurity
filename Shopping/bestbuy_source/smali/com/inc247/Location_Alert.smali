.class public Lcom/inc247/Location_Alert;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static ShowGoogleLocationAlert(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 22
    new-instance v0, Landroid/app/AlertDialog$Builder;

    .line 23
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 22
    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    .line 24
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 25
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    .line 26
    invoke-virtual {v0, p0}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 27
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 28
    const-string v1, "OK, Allow"

    .line 29
    new-instance v2, Lcom/inc247/Location_Alert$1;

    invoke-direct {v2}, Lcom/inc247/Location_Alert$1;-><init>()V

    .line 28
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 38
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 39
    new-instance v1, Lcom/inc247/Location_Alert$2;

    invoke-direct {v1}, Lcom/inc247/Location_Alert$2;-><init>()V

    .line 51
    const-wide/16 v2, 0xc8

    .line 39
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 53
    return-void
.end method

.method public static showGPSDisabledAlertToUser(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 56
    new-instance v0, Landroid/app/AlertDialog$Builder;

    .line 57
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 56
    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    .line 58
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 59
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    .line 60
    invoke-virtual {v0, p0}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 61
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 62
    const-string v1, "Yes"

    .line 63
    new-instance v2, Lcom/inc247/Location_Alert$3;

    invoke-direct {v2}, Lcom/inc247/Location_Alert$3;-><init>()V

    .line 62
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 73
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    const-string v1, "No"

    .line 74
    new-instance v2, Lcom/inc247/Location_Alert$4;

    invoke-direct {v2}, Lcom/inc247/Location_Alert$4;-><init>()V

    .line 73
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 83
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 84
    new-instance v1, Lcom/inc247/Location_Alert$5;

    invoke-direct {v1}, Lcom/inc247/Location_Alert$5;-><init>()V

    .line 107
    const-wide/16 v2, 0x320

    .line 84
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 108
    return-void
.end method
