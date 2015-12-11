.class public Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsResponse;
.super Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
.source "UpdateDeviceCredentialsResponse.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V
    .locals 0
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "deviceName"    # Ljava/lang/String;
    .param p3, "privateKey"    # Ljava/lang/String;
    .param p4, "userName"    # Ljava/lang/String;
    .param p5, "emailAlias"    # Ljava/lang/String;
    .param p6, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    .prologue
    .line 15
    invoke-direct/range {p0 .. p6}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    .line 16
    return-void
.end method
