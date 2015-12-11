.class Lcom/amazon/identity/auth/device/DeviceDataLogic$6;
.super Ljava/lang/Object;
.source "DeviceDataLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/DeviceDataLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

.field final synthetic val$deviceKey:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 168
    iput-object p1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$6;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$6;->val$deviceKey:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public makeDeviceDataInfo(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .locals 3
    .param p1, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    .line 172
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$6;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$6;->val$deviceKey:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/DeviceDataLogic;->access$400(Lcom/amazon/identity/auth/device/DeviceDataLogic;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 173
    .local v0, "deviceValue":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 176
    const/4 v1, 0x0

    .line 178
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Lcom/amazon/identity/auth/device/DeviceDataInfo;

    const/4 v2, 0x1

    invoke-direct {v1, v0, v2}, Lcom/amazon/identity/auth/device/DeviceDataInfo;-><init>(Ljava/lang/String;Z)V

    goto :goto_0
.end method
