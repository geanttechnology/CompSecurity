.class Lcom/inc247/Location_Alert$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/Location_Alert;->showGPSDisabledAlertToUser(Ljava/lang/String;)V
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 65
    new-instance v0, Landroid/content/Intent;

    .line 66
    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    .line 65
    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 67
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 68
    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 69
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->setLocationAlertShowingOrNot(Z)V

    .line 70
    return-void
.end method
