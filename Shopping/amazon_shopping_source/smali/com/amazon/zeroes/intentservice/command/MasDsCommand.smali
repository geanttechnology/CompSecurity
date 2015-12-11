.class public Lcom/amazon/zeroes/intentservice/command/MasDsCommand;
.super Ljava/lang/Object;
.source "MasDsCommand.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
        "<",
        "Lcom/amazon/mas/client/http/WebResponse;",
        ">;"
    }
.end annotation


# instance fields
.field private final client:Lcom/amazon/mas/client/deviceservice/MasDsClient;

.field private final operationName:Ljava/lang/String;

.field private final requestBody:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Lcom/amazon/mas/client/deviceservice/MasDsClient;)V
    .locals 4
    .param p1, "operationName"    # Ljava/lang/String;
    .param p2, "requestBody"    # Lorg/json/JSONObject;
    .param p3, "client"    # Lcom/amazon/mas/client/deviceservice/MasDsClient;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 41
    new-instance v1, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v2, "operationName must not be empty"

    invoke-direct {v1, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 44
    :cond_0
    if-nez p3, :cond_1

    .line 45
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v2, "client must not be null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 48
    :cond_1
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;->operationName:Ljava/lang/String;

    .line 49
    iput-object p2, p0, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;->requestBody:Lorg/json/JSONObject;

    .line 50
    iput-object p3, p0, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;->client:Lcom/amazon/mas/client/deviceservice/MasDsClient;

    .line 53
    :try_start_0
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;->requestBody:Lorg/json/JSONObject;

    const-string/jumbo v2, "retries"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    :goto_0
    return-void

    .line 54
    :catch_0
    move-exception v0

    .line 55
    .local v0, "e":Lorg/json/JSONException;
    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0
.end method


# virtual methods
.method public perform()Lcom/amazon/mas/client/http/WebResponse;
    .locals 4

    .prologue
    .line 65
    :try_start_0
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;->client:Lcom/amazon/mas/client/deviceservice/MasDsClient;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;->operationName:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;->requestBody:Lorg/json/JSONObject;

    invoke-interface {v1, v2, v3}, Lcom/amazon/mas/client/deviceservice/MasDsClient;->invoke(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/amazon/mas/client/http/WebResponse;
    :try_end_0
    .catch Lcom/amazon/mas/client/deviceservice/MasDsException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 68
    :goto_0
    return-object v1

    .line 66
    :catch_0
    move-exception v0

    .line 67
    .local v0, "e":Lcom/amazon/mas/client/deviceservice/MasDsException;
    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 68
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public bridge synthetic perform()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;->perform()Lcom/amazon/mas/client/http/WebResponse;

    move-result-object v0

    return-object v0
.end method
