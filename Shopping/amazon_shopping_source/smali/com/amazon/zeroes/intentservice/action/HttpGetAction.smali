.class public Lcom/amazon/zeroes/intentservice/action/HttpGetAction;
.super Ljava/lang/Object;
.source "HttpGetAction.java"

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

.field public static final EXTRA_URL:Ljava/lang/String;


# instance fields
.field private final retryingHttpGetCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;
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
    .line 20
    const-class v0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->ACTION_NAME:Ljava/lang/String;

    .line 23
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".HttpGet"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->ACTION_REQUEST:Ljava/lang/String;

    .line 26
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".HttpGetResponse"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->ACTION_RESPONSE:Ljava/lang/String;

    .line 29
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".url"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->EXTRA_URL:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;Lcom/amazon/mas/client/http/WebHttpClient;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "client"    # Lcom/amazon/mas/client/http/WebHttpClient;

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->source:Landroid/content/Intent;

    .line 50
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->EXTRA_URL:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 51
    .local v2, "url":Ljava/lang/String;
    new-instance v0, Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;

    invoke-direct {v0, v2, p2}, Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;-><init>(Ljava/lang/String;Lcom/amazon/mas/client/http/WebHttpClient;)V

    .line 52
    .local v0, "httpGetCommand":Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->getRetryCount(Landroid/content/Intent;)I

    move-result v1

    .line 53
    .local v1, "retryCount":I
    new-instance v3, Lcom/amazon/zeroes/intentservice/command/RetryCommand;

    invoke-direct {v3, v1, v0, p0}, Lcom/amazon/zeroes/intentservice/command/RetryCommand;-><init>(ILcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;)V

    iput-object v3, p0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->retryingHttpGetCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 54
    return-void
.end method


# virtual methods
.method public act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V
    .locals 4
    .param p1, "service"    # Lcom/amazon/zeroes/intentservice/ZeroesService;

    .prologue
    .line 69
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->retryingHttpGetCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v1}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mas/client/http/WebResponse;

    .line 70
    .local v0, "response":Lcom/amazon/mas/client/http/WebResponse;
    if-eqz v0, :cond_0

    invoke-virtual {p0, v0}, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 71
    :cond_0
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->source:Landroid/content/Intent;

    invoke-static {v1, v2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 72
    if-nez v0, :cond_1

    .line 73
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 84
    :goto_0
    return-void

    .line 75
    :cond_1
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;Lcom/amazon/mas/client/http/WebResponse;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0

    .line 81
    :cond_2
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->source:Landroid/content/Intent;

    invoke-virtual {v0}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public validate(Lcom/amazon/mas/client/http/WebResponse;)Z
    .locals 1
    .param p1, "result"    # Lcom/amazon/mas/client/http/WebResponse;

    .prologue
    .line 61
    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->wasSuccessful()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic validate(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 18
    check-cast p1, Lcom/amazon/mas/client/http/WebResponse;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v0

    return v0
.end method
