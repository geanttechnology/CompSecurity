.class public Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;
.super Ljava/lang/Object;
.source "GetTaxPreviewAction.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/action/ZeroesAction;
.implements Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/zeroes/intentservice/action/ZeroesAction;",
        "Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator",
        "<",
        "Lcom/amazon/mas/client/http/WebResponse;",
        ">;"
    }
.end annotation


# static fields
.field public static final ACTION_NAME:Ljava/lang/String;

.field public static final ACTION_REQUEST:Ljava/lang/String;

.field public static final ACTION_RESPONSE:Ljava/lang/String;

.field public static final EXTRA_ASIN:Ljava/lang/String;

.field public static final EXTRA_CURRENCY_CODE:Ljava/lang/String;

.field public static final EXTRA_PRICE:Ljava/lang/String;


# instance fields
.field private final retryingMasDsCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;
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
    .line 24
    const-class v0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_NAME:Ljava/lang/String;

    .line 27
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".GetTaxPreview"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_REQUEST:Ljava/lang/String;

    .line 30
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".GetTaxPreviewResponse"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_RESPONSE:Ljava/lang/String;

    .line 33
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".asin"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->EXTRA_ASIN:Ljava/lang/String;

    .line 36
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".price"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->EXTRA_PRICE:Ljava/lang/String;

    .line 39
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".currencyCode"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->EXTRA_CURRENCY_CODE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "client"    # Lcom/amazon/mas/client/deviceservice/MasDsClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 103
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->source:Landroid/content/Intent;

    .line 105
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->getRequestFromIntent(Landroid/content/Intent;)Lorg/json/JSONObject;

    move-result-object v0

    .line 106
    .local v0, "body":Lorg/json/JSONObject;
    new-instance v1, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;

    const-string/jumbo v3, "getZeroesPreviewTax"

    invoke-direct {v1, v3, v0, p2}, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Lcom/amazon/mas/client/deviceservice/MasDsClient;)V

    .line 107
    .local v1, "masDsCommand":Lcom/amazon/zeroes/intentservice/command/MasDsCommand;
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->getRetryCount(Landroid/content/Intent;)I

    move-result v2

    .line 108
    .local v2, "retryCount":I
    new-instance v3, Lcom/amazon/zeroes/intentservice/command/RetryCommand;

    invoke-direct {v3, v2, v1, p0}, Lcom/amazon/zeroes/intentservice/command/RetryCommand;-><init>(ILcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;)V

    iput-object v3, p0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->retryingMasDsCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 109
    return-void
.end method

.method private static getRequestFromIntent(Landroid/content/Intent;)Lorg/json/JSONObject;
    .locals 9
    .param p0, "intent"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 81
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->EXTRA_ASIN:Ljava/lang/String;

    invoke-virtual {p0, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 82
    .local v1, "extraAsin":Ljava/lang/String;
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->EXTRA_PRICE:Ljava/lang/String;

    const-wide/16 v7, 0x0

    invoke-virtual {p0, v6, v7, v8}, Landroid/content/Intent;->getDoubleExtra(Ljava/lang/String;D)D

    move-result-wide v3

    .line 83
    .local v3, "extraPrice":D
    sget-object v6, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->EXTRA_CURRENCY_CODE:Ljava/lang/String;

    invoke-virtual {p0, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 84
    .local v2, "extraCurrencyCode":Ljava/lang/String;
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    .line 85
    .local v5, "price":Lorg/json/JSONObject;
    const-string/jumbo v6, "amount"

    invoke-static {v3, v4}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 86
    const-string/jumbo v6, "unit"

    invoke-virtual {v5, v6, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 87
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 88
    .local v0, "body":Lorg/json/JSONObject;
    const-string/jumbo v6, "asin"

    invoke-virtual {v0, v6, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 89
    const-string/jumbo v6, "price"

    invoke-virtual {v0, v6, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 90
    return-object v0
.end method


# virtual methods
.method public act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V
    .locals 5
    .param p1, "service"    # Lcom/amazon/zeroes/intentservice/ZeroesService;

    .prologue
    .line 135
    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->retryingMasDsCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v3}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mas/client/http/WebResponse;

    .line 136
    .local v2, "response":Lcom/amazon/mas/client/http/WebResponse;
    if-eqz v2, :cond_0

    invoke-virtual {p0, v2}, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 137
    :cond_0
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->source:Landroid/content/Intent;

    invoke-static {v3, v4}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {p1, v3}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 138
    if-nez v2, :cond_1

    .line 139
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 155
    :goto_0
    return-void

    .line 141
    :cond_1
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v3, v2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;Lcom/amazon/mas/client/http/WebResponse;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0

    .line 148
    :cond_2
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-virtual {v2}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 149
    .local v0, "body":Lorg/json/JSONObject;
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->source:Landroid/content/Intent;

    invoke-static {v3, v4, v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {p1, v3}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 151
    .end local v0    # "body":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 153
    .local v1, "e":Lorg/json/JSONException;
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->source:Landroid/content/Intent;

    invoke-static {v3, v4}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {p1, v3}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 154
    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0
.end method

.method public validate(Lcom/amazon/mas/client/http/WebResponse;)Z
    .locals 4
    .param p1, "result"    # Lcom/amazon/mas/client/http/WebResponse;

    .prologue
    const/4 v2, 0x0

    .line 116
    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->wasSuccessful()Z

    move-result v3

    if-nez v3, :cond_1

    .line 126
    :cond_0
    :goto_0
    return v2

    .line 121
    :cond_1
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 122
    .local v1, "response":Lorg/json/JSONObject;
    const-string/jumbo v3, "success"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string/jumbo v3, "zeroesTotalPrice"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string/jumbo v3, "zeroesTaxAmount"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    if-eqz v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    .line 125
    .end local v1    # "response":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 126
    .local v0, "e":Lorg/json/JSONException;
    goto :goto_0
.end method

.method public bridge synthetic validate(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 22
    check-cast p1, Lcom/amazon/mas/client/http/WebResponse;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v0

    return v0
.end method
