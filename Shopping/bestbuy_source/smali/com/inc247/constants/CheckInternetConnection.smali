.class public Lcom/inc247/constants/CheckInternetConnection;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static ShowInternetConnectionLossAlert(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 30
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    .line 31
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 32
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    .line 33
    const-string v1, "Check Internet Connection!!"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 34
    const-string v1, "OK"

    new-instance v2, Lcom/inc247/constants/CheckInternetConnection$1;

    invoke-direct {v2}, Lcom/inc247/constants/CheckInternetConnection$1;-><init>()V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 43
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    sput-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    .line 45
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 47
    return-void
.end method

.method public static isConnected(Landroid/app/Activity;)Z
    .locals 1

    .prologue
    .line 19
    .line 20
    const-string v0, "connectivity"

    invoke-virtual {p0, v0}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 19
    check-cast v0, Landroid/net/ConnectivityManager;

    .line 21
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 22
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 23
    const/4 v0, 0x1

    .line 25
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
