.class public final enum Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
.super Ljava/lang/Enum;
.source "WebViewOrderHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/order/WebViewOrderHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "OrderActionParams"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

.field public static final enum ORDER_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

.field public static final enum SHIP_METHOD:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

.field public static final enum TRACKING_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;


# instance fields
.field private mKey:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 23
    new-instance v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    const-string/jumbo v1, "ORDER_ID"

    const-string/jumbo v2, "oid"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->ORDER_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    .line 24
    new-instance v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    const-string/jumbo v1, "TRACKING_ID"

    const-string/jumbo v2, "tn"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->TRACKING_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    .line 25
    new-instance v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    const-string/jumbo v1, "SHIP_METHOD"

    const-string/jumbo v2, "sm"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->SHIP_METHOD:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    .line 22
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    sget-object v1, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->ORDER_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->TRACKING_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->SHIP_METHOD:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->$VALUES:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 34
    iput-object p3, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->mKey:Ljava/lang/String;

    .line 35
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->mKey:Ljava/lang/String;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 22
    const-class v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->$VALUES:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    invoke-virtual {v0}, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    return-object v0
.end method
