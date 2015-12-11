.class Lcom/amazon/identity/auth/device/DeviceDataLogic$5;
.super Ljava/lang/Object;
.source "DeviceDataLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/DeviceDataLogic;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$5;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public makeDeviceDataInfo(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .locals 5
    .param p1, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    .line 114
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 118
    .local v1, "packageName":Ljava/lang/String;
    :try_start_0
    new-instance v0, Lcom/amazon/identity/auth/device/DeviceDataInfo;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$5;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-static {v2, v1}, Lcom/amazon/identity/auth/device/DeviceDataLogic;->access$300(Lcom/amazon/identity/auth/device/DeviceDataLogic;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-direct {v0, v2, v3}, Lcom/amazon/identity/auth/device/DeviceDataInfo;-><init>(Ljava/lang/String;Z)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    .line 125
    .local v0, "deviceDataInfo":Lcom/amazon/identity/auth/device/DeviceDataInfo;
    iget-object v2, v0, Lcom/amazon/identity/auth/device/DeviceDataInfo;->value:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 127
    new-instance v2, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    const-string/jumbo v3, "Value of device type is null.  This is expected on Grover V1 for the central device Type when the device is not registered."

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 122
    .end local v0    # "deviceDataInfo":Lcom/amazon/identity/auth/device/DeviceDataInfo;
    :catch_0
    move-exception v2

    new-instance v2, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Failed to query device type for "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 130
    .restart local v0    # "deviceDataInfo":Lcom/amazon/identity/auth/device/DeviceDataInfo;
    :cond_0
    return-object v0
.end method
