.class public Lcom/wishabi/flipp/app/AdmBroadcastReceiver;
.super Lcom/amazon/device/messaging/ADMMessageReceiver;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/wishabi/flipp/app/AdmBroadcastReceiver$AdmMessageHandler;

    invoke-direct {p0, v0}, Lcom/amazon/device/messaging/ADMMessageReceiver;-><init>(Ljava/lang/Class;)V

    .line 35
    return-void
.end method
