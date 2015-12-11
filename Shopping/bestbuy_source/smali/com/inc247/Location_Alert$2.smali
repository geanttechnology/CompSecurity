.class Lcom/inc247/Location_Alert$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/Location_Alert;->ShowGoogleLocationAlert(Ljava/lang/String;)V
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 42
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alertDialogBuilder:Landroid/app/AlertDialog$Builder;

    .line 43
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 42
    sput-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    .line 45
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 46
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 47
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setCancelable(Z)V

    .line 49
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->setLocationAlertShowingOrNot(Z)V

    .line 50
    return-void
.end method
