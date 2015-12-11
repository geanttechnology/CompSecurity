.class Lcom/amazon/identity/auth/device/DeviceDataLogic$3;
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
    .line 84
    iput-object p1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$3;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public makeDeviceDataInfo(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .locals 7
    .param p1, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    .line 88
    iget-object v2, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$3;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/DeviceDataLogic;->access$100(Lcom/amazon/identity/auth/device/DeviceDataLogic;)Ljava/lang/String;

    move-result-object v1

    .line 89
    .local v1, "dsn":Ljava/lang/String;
    const-string/jumbo v2, "%s#%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    iget-object v4, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$3;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    # getter for: Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;
    invoke-static {v4}, Lcom/amazon/identity/auth/device/DeviceDataLogic;->access$200(Lcom/amazon/identity/auth/device/DeviceDataLogic;)Landroid/content/Context;

    move-result-object v4

    sget-object v5, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 95
    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/StringHelpers;->convertToHex(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 96
    .local v0, "clientIdHex":Ljava/lang/String;
    new-instance v2, Lcom/amazon/identity/auth/device/DeviceDataInfo;

    invoke-direct {v2, v0, v6}, Lcom/amazon/identity/auth/device/DeviceDataInfo;-><init>(Ljava/lang/String;Z)V

    return-object v2
.end method
