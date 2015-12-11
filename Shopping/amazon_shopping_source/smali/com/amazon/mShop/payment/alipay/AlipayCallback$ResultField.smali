.class public final enum Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;
.super Ljava/lang/Enum;
.source "AlipayCallback.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/payment/alipay/AlipayCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ResultField"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

.field public static final enum memo:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

.field public static final enum result:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

.field public static final enum resultStatus:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 22
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    const-string/jumbo v1, "resultStatus"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->resultStatus:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    .line 23
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    const-string/jumbo v1, "result"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->result:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    .line 24
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    const-string/jumbo v1, "memo"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->memo:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    .line 21
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->resultStatus:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->result:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->memo:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->$VALUES:[Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

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
    .line 21
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 21
    const-class v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->$VALUES:[Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    invoke-virtual {v0}, [Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    return-object v0
.end method
