.class public Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;
.super Ljava/lang/Object;
.source "PurchaseBundleAction.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/action/ZeroesAction;


# static fields
.field public static final ACTION_NAME:Ljava/lang/String;

.field public static final ACTION_REQUEST:Ljava/lang/String;

.field public static final ACTION_RESPONSE:Ljava/lang/String;

.field public static final EXTRA_BUNDLE_ASIN:Ljava/lang/String;

.field public static final EXTRA_BUNDLE_PRICE_AMOUNT:Ljava/lang/String;

.field public static final EXTRA_BUNDLE_PRICE_UNIT:Ljava/lang/String;


# instance fields
.field private final cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

.field private final decorator:Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;

.field private final masDsCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
            "<",
            "Lcom/amazon/mas/client/http/WebResponse;",
            ">;"
        }
    .end annotation
.end field

.field private final source:Landroid/content/Intent;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 27
    const-class v0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_NAME:Ljava/lang/String;

    .line 30
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".PurchaseBundle"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_REQUEST:Ljava/lang/String;

    .line 33
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".PurchaseBundleResponse"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_RESPONSE:Ljava/lang/String;

    .line 36
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".bundleAsin"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->EXTRA_BUNDLE_ASIN:Ljava/lang/String;

    .line 39
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".bundlePriceAmount"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->EXTRA_BUNDLE_PRICE_AMOUNT:Ljava/lang/String;

    .line 42
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".bundlePriceUnit"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->EXTRA_BUNDLE_PRICE_UNIT:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "client"    # Lcom/amazon/mas/client/deviceservice/MasDsClient;
    .param p3, "cache"    # Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;
    .param p4, "decorator"    # Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 138
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 140
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->source:Landroid/content/Intent;

    .line 141
    iput-object p3, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    .line 142
    iput-object p4, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->decorator:Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;

    .line 144
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->getRequestFromIntent(Landroid/content/Intent;)Lorg/json/JSONObject;

    move-result-object v0

    .line 145
    .local v0, "body":Lorg/json/JSONObject;
    invoke-interface {p4, v0}, Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;->decorateZeroesPurchaseRequest(Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object v0

    .line 146
    new-instance v1, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;

    const-string/jumbo v2, "purchaseItem"

    invoke-direct {v1, v2, v0, p2}, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Lcom/amazon/mas/client/deviceservice/MasDsClient;)V

    iput-object v1, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->masDsCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 147
    return-void
.end method

.method private static getPriceFromIntent(Landroid/content/Intent;)Lorg/json/JSONObject;
    .locals 4
    .param p0, "intent"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 93
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->EXTRA_BUNDLE_PRICE_AMOUNT:Ljava/lang/String;

    invoke-virtual {p0, v3}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    sget-object v3, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->EXTRA_BUNDLE_PRICE_UNIT:Ljava/lang/String;

    invoke-virtual {p0, v3}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 94
    :cond_0
    const/4 v0, 0x0

    .line 102
    :goto_0
    return-object v0

    .line 97
    :cond_1
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->EXTRA_BUNDLE_PRICE_AMOUNT:Ljava/lang/String;

    invoke-virtual {p0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 98
    .local v1, "priceAmount":Ljava/lang/String;
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->EXTRA_BUNDLE_PRICE_UNIT:Ljava/lang/String;

    invoke-virtual {p0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 99
    .local v2, "priceUnit":Ljava/lang/String;
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 100
    .local v0, "price":Lorg/json/JSONObject;
    const-string/jumbo v3, "amount"

    invoke-virtual {v0, v3, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 101
    const-string/jumbo v3, "unit"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0
.end method

.method private static getRequestFromIntent(Landroid/content/Intent;)Lorg/json/JSONObject;
    .locals 5
    .param p0, "intent"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 115
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->EXTRA_BUNDLE_ASIN:Ljava/lang/String;

    invoke-virtual {p0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 116
    .local v0, "asin":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->getPriceFromIntent(Landroid/content/Intent;)Lorg/json/JSONObject;

    move-result-object v2

    .line 117
    .local v2, "price":Lorg/json/JSONObject;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 118
    .local v1, "body":Lorg/json/JSONObject;
    const-string/jumbo v3, "asin"

    invoke-virtual {v1, v3, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 119
    const-string/jumbo v3, "isZeroesBundlePurchase"

    const/4 v4, 0x1

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 120
    const-string/jumbo v3, "currentPrice"

    invoke-virtual {v1, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 121
    return-object v1
.end method


# virtual methods
.method public act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V
    .locals 9
    .param p1, "service"    # Lcom/amazon/zeroes/intentservice/ZeroesService;

    .prologue
    .line 154
    iget-object v6, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->masDsCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v6}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/mas/client/http/WebResponse;

    .line 155
    .local v4, "response":Lcom/amazon/mas/client/http/WebResponse;
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Lcom/amazon/mas/client/http/WebResponse;->wasSuccessful()Z

    move-result v6

    if-nez v6, :cond_2

    .line 156
    :cond_0
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->source:Landroid/content/Intent;

    const-string/jumbo v8, "generic_purchase_error"

    invoke-static {v6, v7, v8}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v6

    invoke-virtual {p1, v6}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 159
    if-nez v4, :cond_1

    .line 160
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v6}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 192
    :goto_0
    return-void

    .line 162
    :cond_1
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v6, v4}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;Lcom/amazon/mas/client/http/WebResponse;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0

    .line 171
    :cond_2
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-virtual {v4}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v0, v6}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 172
    .local v0, "body":Lorg/json/JSONObject;
    const-string/jumbo v6, "purchaseErrors"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 173
    .local v5, "result":Ljava/lang/String;
    const-string/jumbo v6, "displayMessageKey"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 183
    .local v1, "displayKey":Ljava/lang/String;
    const-string/jumbo v6, "NoError"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 184
    iget-object v6, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    const-string/jumbo v7, "balance"

    invoke-interface {v6, v7}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->invalidate(Ljava/lang/String;)Z

    .line 185
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->source:Landroid/content/Intent;

    invoke-static {v6, v7}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v6

    invoke-virtual {p1, v6}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0

    .line 174
    .end local v0    # "body":Lorg/json/JSONObject;
    .end local v1    # "displayKey":Ljava/lang/String;
    .end local v5    # "result":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 176
    .local v2, "e":Lorg/json/JSONException;
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->source:Landroid/content/Intent;

    const-string/jumbo v8, "generic_purchase_error"

    invoke-static {v6, v7, v8}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v6

    invoke-virtual {p1, v6}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 179
    invoke-static {v2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0

    .line 189
    .end local v2    # "e":Lorg/json/JSONException;
    .restart local v0    # "body":Lorg/json/JSONObject;
    .restart local v1    # "displayKey":Ljava/lang/String;
    .restart local v5    # "result":Ljava/lang/String;
    :cond_3
    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesErrorUtils;->getPurchaseErrorCode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 190
    .local v3, "errorKey":Ljava/lang/String;
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->source:Landroid/content/Intent;

    invoke-static {v6, v7, v3}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v6

    invoke-virtual {p1, v6}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 191
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v6, v4}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;Lcom/amazon/mas/client/http/WebResponse;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0
.end method
