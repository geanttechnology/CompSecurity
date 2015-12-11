.class Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;
.super Ljava/lang/Object;
.source "PSNDispatcher.java"


# instance fields
.field private endpoint:Ljava/lang/String;

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 2
    .param p1, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p2, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;-><init>()V

    .line 30
    .local v0, "configHelper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    const-string v1, "PlacementStatusNotificationEndPoint"

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;->endpoint:Ljava/lang/String;

    .line 31
    if-eqz p1, :cond_0

    .end local p1    # "httpClient":Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    :goto_0
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 32
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .line 33
    return-void

    .line 31
    .restart local p1    # "httpClient":Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    :cond_0
    new-instance p1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;

    .end local p1    # "httpClient":Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    invoke-direct {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;-><init>()V

    goto :goto_0
.end method


# virtual methods
.method public dispatchPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;)V
    .locals 9
    .param p1, "event"    # Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;

    .prologue
    .line 37
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->getPsn()Ljava/lang/String;

    move-result-object v1

    .line 39
    .local v1, "psn":Ljava/lang/String;
    const-string v0, "PaukTest"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 41
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v8

    new-instance v0, Lcom/comcast/playerplatform/util/android/XrestHelper;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;->endpoint:Ljava/lang/String;

    const-string v3, "POST"

    const/4 v4, 0x0

    new-instance v5, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher$1;

    invoke-direct {v5, p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher$1;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;)V

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-direct/range {v0 .. v7}, Lcom/comcast/playerplatform/util/android/XrestHelper;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    invoke-virtual {v8, v0}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 63
    return-void
.end method
