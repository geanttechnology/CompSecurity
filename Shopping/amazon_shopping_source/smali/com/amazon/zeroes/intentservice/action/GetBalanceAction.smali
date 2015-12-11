.class public Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;
.super Ljava/lang/Object;
.source "GetBalanceAction.java"

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
        "Ljava/lang/Long;",
        ">;",
        "Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator",
        "<",
        "Lcom/amazon/mas/client/http/WebResponse;",
        ">;",
        "Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator",
        "<",
        "Lcom/amazon/mas/client/http/WebResponse;",
        "Ljava/lang/Long;",
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
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final source:Landroid/content/Intent;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    const-class v0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->ACTION_NAME:Ljava/lang/String;

    .line 34
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".GetBalance"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->ACTION_REQUEST:Ljava/lang/String;

    .line 37
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".GetBalanceResponse"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->ACTION_RESPONSE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V
    .locals 10
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "client"    # Lcom/amazon/mas/client/deviceservice/MasDsClient;
    .param p3, "cache"    # Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->source:Landroid/content/Intent;

    .line 69
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->getRetryCount(Landroid/content/Intent;)I

    move-result v9

    .line 70
    .local v9, "retryCount":I
    new-instance v7, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;

    const-string/jumbo v0, "getZeroesBalance"

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    invoke-direct {v7, v0, v1, p2}, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Lcom/amazon/mas/client/deviceservice/MasDsClient;)V

    .line 71
    .local v7, "masDsCommand":Lcom/amazon/zeroes/intentservice/command/MasDsCommand;
    new-instance v8, Lcom/amazon/zeroes/intentservice/command/RetryCommand;

    invoke-direct {v8, v9, v7, p0}, Lcom/amazon/zeroes/intentservice/command/RetryCommand;-><init>(ILcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;)V

    .line 72
    .local v8, "retryCommand":Lcom/amazon/zeroes/intentservice/command/RetryCommand;, "Lcom/amazon/zeroes/intentservice/command/RetryCommand<Lcom/amazon/mas/client/http/WebResponse;>;"
    new-instance v5, Lcom/amazon/zeroes/intentservice/command/TranslateCommand;

    invoke-direct {v5, v8, p0}, Lcom/amazon/zeroes/intentservice/command/TranslateCommand;-><init>(Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/TranslateCommand$Translator;)V

    .line 75
    .local v5, "translateCommand":Lcom/amazon/zeroes/intentservice/command/TranslateCommand;, "Lcom/amazon/zeroes/intentservice/command/TranslateCommand<Lcom/amazon/mas/client/http/WebResponse;Ljava/lang/Long;>;"
    new-instance v0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;

    const-string/jumbo v1, "balance"

    const-wide/32 v2, 0x1b7740

    move-object v4, p3

    move-object v6, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/zeroes/intentservice/command/CachedCommand;-><init>(Ljava/lang/String;JLcom/amazon/zeroes/intentservice/persistence/ZeroesCache;Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;)V

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 77
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->source:Landroid/content/Intent;

    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->shouldInvalidateCache(Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    const-string/jumbo v0, "balance"

    invoke-interface {p3, v0}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->invalidate(Ljava/lang/String;)Z

    .line 80
    :cond_0
    return-void
.end method


# virtual methods
.method public act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V
    .locals 3
    .param p1, "service"    # Lcom/amazon/zeroes/intentservice/ZeroesService;

    .prologue
    .line 104
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v1}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 105
    .local v0, "balance":Ljava/lang/Long;
    if-nez v0, :cond_0

    .line 106
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->source:Landroid/content/Intent;

    invoke-static {v1, v2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 107
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 112
    :goto_0
    return-void

    .line 111
    :cond_0
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->source:Landroid/content/Intent;

    invoke-static {v1, v2, v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public fromString(Ljava/lang/String;)Ljava/lang/Long;
    .locals 3
    .param p1, "input"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;
        }
    .end annotation

    .prologue
    .line 141
    :try_start_0
    invoke-static {p1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 142
    :catch_0
    move-exception v0

    .line 143
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v1, Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;

    invoke-direct {v1}, Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;-><init>()V

    throw v1
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
    .line 27
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->fromString(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method public toString(Ljava/lang/Long;)Ljava/lang/String;
    .locals 2
    .param p1, "input"    # Ljava/lang/Long;

    .prologue
    .line 152
    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic toString(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 27
    check-cast p1, Ljava/lang/Long;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->toString(Ljava/lang/Long;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public translate(Lcom/amazon/mas/client/http/WebResponse;)Ljava/lang/Long;
    .locals 5
    .param p1, "input"    # Lcom/amazon/mas/client/http/WebResponse;

    .prologue
    const/4 v2, 0x0

    .line 120
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 121
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v3, p1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;Lcom/amazon/mas/client/http/WebResponse;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 131
    :goto_0
    return-object v2

    .line 126
    :cond_0
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 127
    .local v0, "body":Lorg/json/JSONObject;
    const-string/jumbo v3, "balance"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 128
    .end local v0    # "body":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 130
    .local v1, "e":Lorg/json/JSONException;
    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0
.end method

.method public bridge synthetic translate(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 27
    check-cast p1, Lcom/amazon/mas/client/http/WebResponse;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->translate(Lcom/amazon/mas/client/http/WebResponse;)Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method public validate(Lcom/amazon/mas/client/http/WebResponse;)Z
    .locals 8
    .param p1, "result"    # Lcom/amazon/mas/client/http/WebResponse;

    .prologue
    const-wide/high16 v6, -0x8000000000000000L

    const/4 v2, 0x0

    .line 87
    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->wasSuccessful()Z

    move-result v3

    if-nez v3, :cond_1

    .line 95
    :cond_0
    :goto_0
    return v2

    .line 92
    :cond_1
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 93
    .local v1, "response":Lorg/json/JSONObject;
    const-string/jumbo v3, "balance"

    const-wide/high16 v4, -0x8000000000000000L

    invoke-virtual {v1, v3, v4, v5}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v3

    cmp-long v3, v3, v6

    if-eqz v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    .line 94
    .end local v1    # "response":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 95
    .local v0, "e":Lorg/json/JSONException;
    goto :goto_0
.end method

.method public bridge synthetic validate(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 27
    check-cast p1, Lcom/amazon/mas/client/http/WebResponse;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v0

    return v0
.end method
