.class public final Lcom/amazon/zeroes/intentservice/utils/ZeroesErrorUtils;
.super Ljava/lang/Object;
.source "ZeroesErrorUtils.java"


# static fields
.field private static final PURCHASE_ERROR_MAPPING:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 17
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 20
    .local v0, "mapping":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "mas.device.purchase.error.failure_bad_payment_method"

    const-string/jumbo v2, "bad_payment_method"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 21
    const-string/jumbo v1, "mas.device.purchase.error.failure_insufficent_gc_balance_gc_only_order"

    const-string/jumbo v2, "insufficient_gc_funds"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 22
    const-string/jumbo v1, "mas.device.purchase.error.failure_no_address"

    const-string/jumbo v2, "no_address"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    const-string/jumbo v1, "mas.device.purchase.error.failure_no_default_payment_method"

    const-string/jumbo v2, "no_payment_method"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    const-string/jumbo v1, "mas.device.purchase.error.duplicate_order"

    const-string/jumbo v2, "duplicate_order"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    const-string/jumbo v1, "mas.device.purchase.error.failure_price_changed"

    const-string/jumbo v2, "price_changed"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    const-string/jumbo v1, "com.amazon.zeroes.payment.exceptions.ZeroesInvalidLocationException"

    const-string/jumbo v2, "invalid_location"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    const-string/jumbo v1, "mas.device.purchase.error.failure_zeroes_daily_buy_limit_reached"

    const-string/jumbo v2, "buy_coins_limit"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 29
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    sput-object v1, Lcom/amazon/zeroes/intentservice/utils/ZeroesErrorUtils;->PURCHASE_ERROR_MAPPING:Ljava/util/Map;

    .line 30
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    return-void
.end method

.method public static getPurchaseErrorCode(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "errorKey"    # Ljava/lang/String;

    .prologue
    .line 40
    sget-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesErrorUtils;->PURCHASE_ERROR_MAPPING:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 41
    sget-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesErrorUtils;->PURCHASE_ERROR_MAPPING:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 44
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "generic_purchase_error"

    goto :goto_0
.end method
