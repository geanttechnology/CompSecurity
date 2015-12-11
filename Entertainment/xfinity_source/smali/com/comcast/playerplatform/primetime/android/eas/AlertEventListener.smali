.class public abstract Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
.super Ljava/lang/Object;
.source "AlertEventListener.java"

# interfaces
.implements Ljava/util/EventListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public emergencyAlertCompleted(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;
    .param p2, "isTextAlert"    # Z

    .prologue
    .line 35
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;
    .param p2, "errorCode"    # Ljava/lang/String;
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "isTextAlert"    # Z

    .prologue
    .line 39
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;
    .param p2, "isTextAlert"    # Z

    .prologue
    .line 31
    return-void
.end method

.method public fipsCodeFound(Ljava/lang/String;)V
    .locals 0
    .param p1, "fipsCode"    # Ljava/lang/String;

    .prologue
    .line 20
    return-void
.end method

.method public requestFailed(Ljava/lang/String;)V
    .locals 0
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 25
    return-void
.end method

.method public updateAlertsReceived(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/eas/Alert;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p1, "alerts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/eas/Alert;>;"
    return-void
.end method
