.class public Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;
.super Ljava/lang/Object;
.source "SetPreferencesAction.java"

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

.field public static final EXTRA_PREFERENCES:Ljava/lang/String;


# instance fields
.field private final cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

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
    .line 25
    const-class v0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->ACTION_NAME:Ljava/lang/String;

    .line 28
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".SetPreferences"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->ACTION_REQUEST:Ljava/lang/String;

    .line 31
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".SetPreferencesResponse"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->ACTION_RESPONSE:Ljava/lang/String;

    .line 34
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".preferences"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->EXTRA_PREFERENCES:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "client"    # Lcom/amazon/mas/client/deviceservice/MasDsClient;
    .param p3, "cache"    # Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->source:Landroid/content/Intent;

    .line 86
    iput-object p3, p0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    .line 88
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->getRequestFromIntent(Landroid/content/Intent;)Lorg/json/JSONObject;

    move-result-object v0

    .line 89
    .local v0, "body":Lorg/json/JSONObject;
    new-instance v1, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;

    const-string/jumbo v3, "setZeroesPreferences"

    invoke-direct {v1, v3, v0, p2}, Lcom/amazon/zeroes/intentservice/command/MasDsCommand;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Lcom/amazon/mas/client/deviceservice/MasDsClient;)V

    .line 90
    .local v1, "masDsCommand":Lcom/amazon/zeroes/intentservice/command/MasDsCommand;
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->getRetryCount(Landroid/content/Intent;)I

    move-result v2

    .line 91
    .local v2, "retryCount":I
    new-instance v3, Lcom/amazon/zeroes/intentservice/command/RetryCommand;

    invoke-direct {v3, v2, v1, p0}, Lcom/amazon/zeroes/intentservice/command/RetryCommand;-><init>(ILcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;)V

    iput-object v3, p0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->retryingMasDsCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 92
    return-void
.end method

.method private static getRequestFromIntent(Landroid/content/Intent;)Lorg/json/JSONObject;
    .locals 4
    .param p0, "intent"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 64
    sget-object v3, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->EXTRA_PREFERENCES:Ljava/lang/String;

    invoke-virtual {p0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 65
    .local v1, "extraPrefs":Ljava/lang/String;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 66
    .local v2, "prefs":Lorg/json/JSONObject;
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 67
    .local v0, "body":Lorg/json/JSONObject;
    const-string/jumbo v3, "preferences"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 68
    return-object v0
.end method


# virtual methods
.method public act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V
    .locals 3
    .param p1, "service"    # Lcom/amazon/zeroes/intentservice/ZeroesService;

    .prologue
    .line 116
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->retryingMasDsCommand:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v1}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mas/client/http/WebResponse;

    .line 117
    .local v0, "response":Lcom/amazon/mas/client/http/WebResponse;
    if-eqz v0, :cond_0

    invoke-virtual {p0, v0}, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 118
    :cond_0
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->source:Landroid/content/Intent;

    invoke-static {v1, v2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    .line 119
    if-nez v0, :cond_1

    .line 120
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 130
    :goto_0
    return-void

    .line 122
    :cond_1
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->ACTION_NAME:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->actionFailedMeasurement(Ljava/lang/String;Lcom/amazon/mas/client/http/WebResponse;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0

    .line 128
    :cond_2
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    const-string/jumbo v2, "preferences"

    invoke-interface {v1, v2}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->invalidate(Ljava/lang/String;)Z

    .line 129
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->ACTION_RESPONSE:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->source:Landroid/content/Intent;

    invoke-static {v1, v2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public validate(Lcom/amazon/mas/client/http/WebResponse;)Z
    .locals 4
    .param p1, "result"    # Lcom/amazon/mas/client/http/WebResponse;

    .prologue
    const/4 v2, 0x0

    .line 99
    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->wasSuccessful()Z

    move-result v3

    if-nez v3, :cond_0

    .line 107
    :goto_0
    return v2

    .line 104
    :cond_0
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lcom/amazon/mas/client/http/WebResponse;->getEntityBody()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 105
    .local v1, "response":Lorg/json/JSONObject;
    const-string/jumbo v3, "success"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 106
    .end local v1    # "response":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 107
    .local v0, "e":Lorg/json/JSONException;
    goto :goto_0
.end method

.method public bridge synthetic validate(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p1, Lcom/amazon/mas/client/http/WebResponse;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->validate(Lcom/amazon/mas/client/http/WebResponse;)Z

    move-result v0

    return v0
.end method
