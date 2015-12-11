.class public Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;
.super Ljava/lang/Object;
.source "GetBundleDetailsAction.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/action/ZeroesAction;
.implements Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;
.implements Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;
.implements Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/zeroes/intentservice/action/ZeroesAction;",
        "Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter",
        "<",
        "Lorg/json/JSONArray;",
        ">;",
        "Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator",
        "<",
        "Lcom/amazon/mas/client/http/WebResponse;",
        ">;",
        "Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator",
        "<",
        "Lcom/amazon/mas/client/http/WebResponse;",
        "Lorg/json/JSONArray;",
        ">;"
    }
.end annotation


# static fields
.field public static final ACTION_NAME:Ljava/lang/String;

.field public static final ACTION_REQUEST:Ljava/lang/String;

.field public static final ACTION_RESPONSE:Ljava/lang/String;


# instance fields
.field private final command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
            "<",
            "Lorg/json/JSONArray;",
            ">;"
        }
    .end annotation
.end field

.field private final source:Landroid/content/Intent;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 32
    const-class v0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->ACTION_NAME:Ljava/lang/String;

    .line 35
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".GetBundleDetails"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->ACTION_REQUEST:Ljava/lang/String;

    .line 38
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".GetBundleDetailsResponse"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->ACTION_RESPONSE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V
    .locals 10
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "client"    # Lcom/amazon/mas/client/deviceservice/MasDsClient;
    .param p3, "cache"    # Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->source:Landroid/content/Intent;

    .line 70
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->getRetryCount(Landroid/content/Intent;)I

    move-result v9

    .line 71
    .local v9, "retryCount":I
    new-instance v7, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;

    const-string/jumbo v0, "getZeroesAsinDetails"

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    invoke-direct {v7, v0, v1, p2}, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Lcom/amazon/mas/client/deviceservice/MasDsClient;)V

    .line 72
    .local v7, "masDsCommand":Lcom/amazon/zeroes/intentservice/command/MasDsCommand;
    new-instance v8, Lcom/amazon/zeroes/intentservice/command/RetryCommand;

    invoke-direct {v8, v9, v7, p0}, Lcom/amazon/zeroes/intentservice/command/RetryCommand;-><init>(ILcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;)V

    .line 73
    .local v8, "retryCommand":Lcom/amazon/zeroes/intentservice/command/RetryCommand;, "Lcom/amazon/zeroes/intentservice/command/RetryCommand<Lcom/amazon/mas/client/http/WebResponse;>;"
    new-instance v5, Lcom/amazon/zeroes/intentservice/command/TranslateCommand;

    invoke-direct {v5, v8, p0}, Lcom/amazon/zeroes/intentservice/command/TranslateCommand;-><init>(Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;)V

    .line 76
    .local v5, "translateCommand":Lcom/amazon/zeroes/intentservice/command/TranslateCommand;, "Lcom/amazon/zeroes/intentservice/command/TranslateCommand<Lcom/amazon/mas/client/http/WebResponse;Lorg/json/JSONArray;>;"
    new-instance v0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;

    const-string/jumbo v1, "bundles"

    const-wide/32 v2, 0x5265c00

    move-object v4, p3

    move-object v6, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/zeroes/intentservice/command/CachedCommand;-><init>(Ljava/lang/String;JLcom/amazon/zeroes/intentservice/persistence/ZeroesCache;Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;)V

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 78
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->source:Landroid/content/Intent;

    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->shouldInvalidateCache(Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 79
    const-string/jumbo v0, "bundles"

    invoke-interface {p3, v0}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->invalidate(Ljava/lang/String;)Z

    .line 81
    :cond_0
    return-void
.end method


# virtual methods
.method public act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V
    .locals 3
    .param p1, "service"    # Lcom/amazon/zeroes/intentservice/ZeroesService;

    .prologue
    .line 105
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v1}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    .line 106
    .local v0, "bundles":Lorg/json/JSONArray;
    if-nez v0, :cond_0

    .line 107
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->source:Landroid/content/Intent;

    invoke-static {v1, v2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 108
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 113
    :goto_0
    return-void

    .line 112
    :cond_0
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->source:Landroid/content/Intent;

    invoke-static {v1, v2, v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public bridge synthetic fromString(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;
        }
    .end annotation

    .prologue
    .line 28
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->fromString(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    return-object v0
.end method

.method public fromString(Ljava/lang/String;)Lorg/json/JSONArray;
    .locals 2
    .param p1, "input"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;
        }
    .end annotation

    .prologue
    .line 142
    :try_start_0
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1, p1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 143
    :catch_0
    move-exception v0

    .line 144
    .local v0, "e":Lorg/json/JSONException;
    new-instance v1, Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;

    invoke-direct {v1}, Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;-><init>()V

    throw v1
.end method

.method public bridge synthetic toString(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p1, Lorg/json/JSONArray;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->toString(Lorg/json/JSONArray;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString(Lorg/json/JSONArray;)Ljava/lang/String;
    .locals 1
    .param p1, "input"    # Lorg/json/JSONArray;

    .prologue
    .line 153
    invoke-virtual {p1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic translate(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p1, Lcom/amazon/mas/client/http/WebResponse;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->translate(Lcom/amazon/mas/client/http/WebResponse;)Lorg/json/JSONArray;

    move-result-object v0

    return-object v0
.end method

.method public translate(Lcom/amazon/mas/client/http/WebResponse;)Lorg/json/JSONArray;
    .locals 4
    .param p1, "input"    # Lcom/amazon/mas/client/http/WebResponse;

    .prologue
    const/4 v2, 0x0

    .line 121
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 122
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v3, p1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;Lcom/amazon/mas/client/http/WebResponse;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 132
    :goto_0
    return-object v2

    .line 127
    :cond_0
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 128
    .local v0, "body":Lorg/json/JSONObject;
    const-string/jumbo v3, "asinDetailList"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 129
    .end local v0    # "body":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 131
    .local v1, "e":Lorg/json/JSONException;
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

    .line 88
    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->wasSuccessful()Z

    move-result v3

    if-nez v3, :cond_1

    .line 96
    :cond_0
    :goto_0
    return v2

    .line 93
    :cond_1
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 94
    .local v1, "response":Lorg/json/JSONObject;
    const-string/jumbo v3, "asinDetailList"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    if-eqz v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    .line 95
    .end local v1    # "response":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 96
    .local v0, "e":Lorg/json/JSONException;
    goto :goto_0
.end method

.method public bridge synthetic validate(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p1, Lcom/amazon/mas/client/http/WebResponse;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v0

    return v0
.end method
