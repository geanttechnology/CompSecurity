.class Lcom/inc247/Location_Alert$4;
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
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 76
    const/4 v0, 0x0

    sput-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    .line 77
    sput-boolean v1, Lcom/inc247/constants/ChatSDKConstants;->isUserPermitGps:Z

    .line 78
    invoke-static {v1}, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->setLocationAlertShowingOrNot(Z)V

    .line 79
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 80
    return-void
.end method
