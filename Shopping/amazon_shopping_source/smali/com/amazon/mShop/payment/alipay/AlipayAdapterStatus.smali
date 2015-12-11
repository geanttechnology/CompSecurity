.class public final enum Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
.super Ljava/lang/Enum;
.source "AlipayAdapterStatus.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

.field public static final enum ADAPTER_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

.field public static final enum ALIPAY_UAVAILABLE:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

.field public static final enum SERVICE_BIND_FAILURE:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

.field public static final enum SERVICE_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

.field public static final enum UNDEFINED:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 8
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    const-string/jumbo v1, "UNDEFINED"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->UNDEFINED:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    .line 11
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    const-string/jumbo v1, "ALIPAY_UAVAILABLE"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->ALIPAY_UAVAILABLE:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    .line 14
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    const-string/jumbo v1, "ADAPTER_INVOKE_SUCCESS"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->ADAPTER_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    .line 17
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    const-string/jumbo v1, "SERVICE_BIND_FAILURE"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->SERVICE_BIND_FAILURE:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    .line 20
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    const-string/jumbo v1, "SERVICE_INVOKE_SUCCESS"

    invoke-direct {v0, v1, v6}, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->SERVICE_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    .line 6
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->UNDEFINED:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->ALIPAY_UAVAILABLE:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->ADAPTER_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->SERVICE_BIND_FAILURE:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->SERVICE_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->$VALUES:[Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 6
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->$VALUES:[Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    invoke-virtual {v0}, [Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    return-object v0
.end method
