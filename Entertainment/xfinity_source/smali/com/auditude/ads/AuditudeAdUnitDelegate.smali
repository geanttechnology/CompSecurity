.class public Lcom/auditude/ads/AuditudeAdUnitDelegate;
.super Ljava/lang/Object;
.source "AuditudeAdUnitDelegate.java"

# interfaces
.implements Lcom/auditude/ads/response/AdResponse$AdResponseListener;
.implements Lcom/auditude/ads/util/event/IEventListener;


# instance fields
.field private adRequest:Lcom/auditude/ads/loader/AdRequest;

.field private adResponse:Lcom/auditude/ads/response/AdResponse;

.field private adResponseListener:Lcom/auditude/ads/response/AdResponse$AdResponseListener;

.field private adSettings:Lcom/auditude/ads/core/AdSettings;

.field private apiBridge:Lcom/auditude/ads/core/APIBridge;

.field private creationTime:J

.field private error:Ljava/lang/Throwable;

.field private listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

.field private reporting:Lcom/auditude/ads/reporting/ReportingHelper;


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->creationTime:J

    .line 47
    new-instance v0, Lcom/auditude/ads/core/AuditudeEnv;

    invoke-direct {v0}, Lcom/auditude/ads/core/AuditudeEnv;-><init>()V

    invoke-static {v0}, Lcom/auditude/ads/core/AuditudeEnv;->setEnvironment(Lcom/auditude/ads/core/AuditudeEnv;)V

    .line 48
    new-instance v0, Lcom/auditude/ads/core/APIBridge;

    invoke-direct {v0}, Lcom/auditude/ads/core/APIBridge;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    .line 49
    new-instance v0, Lcom/auditude/ads/reporting/ReportingHelper;

    iget-object v1, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    invoke-direct {v0, v1}, Lcom/auditude/ads/reporting/ReportingHelper;-><init>(Lcom/auditude/ads/core/APIBridge;)V

    iput-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    .line 50
    new-instance v0, Lcom/auditude/ads/core/AdSettings;

    invoke-direct {v0}, Lcom/auditude/ads/core/AdSettings;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    .line 52
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    const-string v1, "apiEvent"

    const/16 v2, 0x64

    invoke-virtual {v0, v1, p0, v2}, Lcom/auditude/ads/core/APIBridge;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;I)V

    .line 53
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v0

    iget-object v1, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    iget-object v2, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    iget-object v3, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    invoke-virtual {v0, v1, v2, v3}, Lcom/auditude/ads/core/AuditudeEnv;->init(Lcom/auditude/ads/core/APIBridge;Lcom/auditude/ads/reporting/ReportingHelper;Lcom/auditude/ads/core/AdSettings;)V

    .line 54
    return-void
.end method

.method private reset()V
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    if-eqz v0, :cond_0

    .line 270
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v0}, Lcom/auditude/ads/response/AdResponse;->cancel()V

    .line 272
    :cond_0
    return-void
.end method


# virtual methods
.method public final getAdResponse()Lcom/auditude/ads/response/AdResponse;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    return-object v0
.end method

.method public final getReportingEngine()Lcom/auditude/ads/reporting/ReportingHelper;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    return-object v0
.end method

.method public final init(Ljava/lang/String;Ljava/lang/Object;ILjava/util/HashMap;I)V
    .locals 8
    .param p1, "domain"    # Ljava/lang/String;
    .param p2, "mediaId"    # Ljava/lang/Object;
    .param p3, "zoneId"    # I
    .param p5, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            "I",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 96
    .local p4, "customParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct {p0}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->reset()V

    .line 98
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    const-string v1, "apiEvent"

    .line 102
    new-instance v2, Lcom/auditude/ads/event/AdPluginErrorEvent;

    const-string v3, "initFailed"

    .line 103
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "invalid domain"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 102
    invoke-direct {v2, v3, v4}, Lcom/auditude/ads/event/AdPluginErrorEvent;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 101
    invoke-virtual {v0, v1, v2}, Lcom/auditude/ads/core/APIBridge;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 156
    :goto_0
    return-void

    .line 107
    :cond_0
    if-nez p2, :cond_1

    .line 110
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    const-string v1, "apiEvent"

    .line 111
    new-instance v2, Lcom/auditude/ads/event/AdPluginErrorEvent;

    const-string v3, "initFailed"

    .line 112
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "invalid media id"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 111
    invoke-direct {v2, v3, v4}, Lcom/auditude/ads/event/AdPluginErrorEvent;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 110
    invoke-virtual {v0, v1, v2}, Lcom/auditude/ads/core/APIBridge;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 116
    :cond_1
    if-gtz p3, :cond_2

    .line 119
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    const-string v1, "apiEvent"

    .line 120
    new-instance v2, Lcom/auditude/ads/event/AdPluginErrorEvent;

    const-string v3, "initFailed"

    .line 121
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "invalid zone"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 120
    invoke-direct {v2, v3, v4}, Lcom/auditude/ads/event/AdPluginErrorEvent;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 119
    invoke-virtual {v0, v1, v2}, Lcom/auditude/ads/core/APIBridge;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 126
    :cond_2
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    invoke-virtual {v0, p1}, Lcom/auditude/ads/core/AdSettings;->setDomain(Ljava/lang/String;)V

    .line 127
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    invoke-virtual {v0, p3}, Lcom/auditude/ads/core/AdSettings;->setZoneId(I)V

    .line 128
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    invoke-virtual {v0, p4}, Lcom/auditude/ads/core/AdSettings;->setCustomParams(Ljava/util/HashMap;)V

    .line 131
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    if-eqz v0, :cond_3

    .line 134
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    .line 136
    :cond_3
    new-instance v0, Lcom/auditude/ads/loader/AdRequest;

    move-object v1, p2

    move v2, p3

    move-object v3, p1

    move-object v4, p4

    move v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/loader/AdRequest;-><init>(Ljava/lang/Object;ILjava/lang/String;Ljava/util/HashMap;I)V

    iput-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    .line 137
    iget-object v1, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    const-string v2, "useSSL"

    invoke-virtual {v0, v2}, Lcom/auditude/ads/core/AdSettings;->hasProperty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 138
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    const-string v2, "useSSL"

    invoke-virtual {v0, v2}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 137
    :goto_1
    invoke-static {v0}, Ljava/lang/Boolean;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    invoke-virtual {v1, v0}, Lcom/auditude/ads/loader/AdRequest;->setUseSSL(Z)V

    .line 141
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    .line 142
    .local v6, "currentCreationTime":J
    iget-wide v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->creationTime:J

    sub-long v0, v6, v0

    const-wide/16 v2, 0x3e8

    cmp-long v0, v0, v2

    if-gez v0, :cond_5

    .line 145
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Ad Requested too soon. Requests must be at least 1000ms apart."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->error:Ljava/lang/Throwable;

    .line 147
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->error:Ljava/lang/Throwable;

    invoke-virtual {p0, v0}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->onRequestFailed(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 138
    .end local v6    # "currentCreationTime":J
    :cond_4
    const-string v0, "false"

    goto :goto_1

    .line 150
    .restart local v6    # "currentCreationTime":J
    :cond_5
    iput-wide v6, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->creationTime:J

    .line 153
    new-instance v0, Lcom/auditude/ads/response/AdResponse;

    iget-object v1, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    invoke-direct {v0, v1}, Lcom/auditude/ads/response/AdResponse;-><init>(Lcom/auditude/ads/core/AdSettings;)V

    iput-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    .line 154
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v0, p0}, Lcom/auditude/ads/response/AdResponse;->setAdResponseListener(Lcom/auditude/ads/response/AdResponse$AdResponseListener;)V

    .line 155
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v1, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    invoke-virtual {v0, v1, p5}, Lcom/auditude/ads/response/AdResponse;->loadAdRequest(Lcom/auditude/ads/loader/AdRequest;I)V

    goto/16 :goto_0
.end method

.method final logError(ILjava/lang/String;)V
    .locals 5
    .param p1, "id"    # I
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 262
    new-instance v0, Lcom/auditude/ads/exception/AssetException;

    invoke-direct {v0, p1, p2}, Lcom/auditude/ads/exception/AssetException;-><init>(ILjava/lang/String;)V

    .line 263
    .local v0, "exception":Lcom/auditude/ads/exception/AssetException;
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/core/AuditudeEnv;->getAPI()Lcom/auditude/ads/core/APIBridge;

    move-result-object v1

    const-string v2, "playerError"

    new-instance v3, Lcom/auditude/ads/event/PlayerErrorEvent;

    const/4 v4, 0x0

    invoke-direct {v3, v4, v0}, Lcom/auditude/ads/event/PlayerErrorEvent;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;Lcom/auditude/ads/exception/PlayerException;)V

    invoke-virtual {v1, v2, v3}, Lcom/auditude/ads/core/APIBridge;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 264
    return-void
.end method

.method public onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 286
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    const-string v0, "apiEvent"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 287
    instance-of v0, p2, Lcom/auditude/ads/event/AdPluginEvent;

    if-nez v0, :cond_1

    .line 305
    .end local p2    # "event":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-void

    .line 289
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_1
    instance-of v0, p2, Lcom/auditude/ads/event/AdPluginErrorEvent;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    check-cast p2, Lcom/auditude/ads/event/AdPluginErrorEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-interface {v0, p2}, Lcom/auditude/ads/event/AuditudePluginEventListener;->onAdPluginErrorEvent(Lcom/auditude/ads/event/AdPluginErrorEvent;)V

    goto :goto_0

    .line 290
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_2
    instance-of v0, p2, Lcom/auditude/ads/event/LinearAdEvent;

    if-eqz v0, :cond_3

    .line 292
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    check-cast p2, Lcom/auditude/ads/event/LinearAdEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-interface {v0, p2}, Lcom/auditude/ads/event/AuditudePluginEventListener;->onLinearAdEvent(Lcom/auditude/ads/event/LinearAdEvent;)V

    goto :goto_0

    .line 294
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_3
    instance-of v0, p2, Lcom/auditude/ads/event/NonLinearAdEvent;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    check-cast p2, Lcom/auditude/ads/event/NonLinearAdEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-interface {v0, p2}, Lcom/auditude/ads/event/AuditudePluginEventListener;->onNonLinearAdEvent(Lcom/auditude/ads/event/NonLinearAdEvent;)V

    goto :goto_0

    .line 295
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_4
    instance-of v0, p2, Lcom/auditude/ads/event/OnPageEvent;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    check-cast p2, Lcom/auditude/ads/event/OnPageEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-interface {v0, p2}, Lcom/auditude/ads/event/AuditudePluginEventListener;->onOnPageAdEvent(Lcom/auditude/ads/event/OnPageEvent;)V

    goto :goto_0

    .line 296
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_5
    instance-of v0, p2, Lcom/auditude/ads/event/AdProgressEvent;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    check-cast p2, Lcom/auditude/ads/event/AdProgressEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-interface {v0, p2}, Lcom/auditude/ads/event/AuditudePluginEventListener;->onAdProgressEvent(Lcom/auditude/ads/event/AdProgressEvent;)V

    goto :goto_0

    .line 297
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_6
    instance-of v0, p2, Lcom/auditude/ads/event/AdClickThroughEvent;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    check-cast p2, Lcom/auditude/ads/event/AdClickThroughEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-interface {v0, p2}, Lcom/auditude/ads/event/AuditudePluginEventListener;->onAdClickEvent(Lcom/auditude/ads/event/AdClickThroughEvent;)V

    goto :goto_0

    .line 298
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_7
    instance-of v0, p2, Lcom/auditude/ads/event/AdPluginErrorEvent;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    check-cast p2, Lcom/auditude/ads/event/AdPluginErrorEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-interface {v0, p2}, Lcom/auditude/ads/event/AuditudePluginEventListener;->onAdPluginErrorEvent(Lcom/auditude/ads/event/AdPluginErrorEvent;)V

    goto :goto_0

    .line 303
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_8
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    check-cast p2, Lcom/auditude/ads/event/AdPluginEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-interface {v0, p2}, Lcom/auditude/ads/event/AuditudePluginEventListener;->onAdPluginEvent(Lcom/auditude/ads/event/AdPluginEvent;)V

    goto :goto_0
.end method

.method public onRequestComplete(Ljava/util/ArrayList;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/exception/AssetException;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 197
    .local p1, "exceptions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/exception/AssetException;>;"
    iget-object v4, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponseListener:Lcom/auditude/ads/response/AdResponse$AdResponseListener;

    if-eqz v4, :cond_0

    .line 199
    iget-object v4, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponseListener:Lcom/auditude/ads/response/AdResponse$AdResponseListener;

    invoke-interface {v4, p1}, Lcom/auditude/ads/response/AdResponse$AdResponseListener;->onRequestComplete(Ljava/util/ArrayList;)V

    .line 203
    :cond_0
    iget-object v4, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    invoke-virtual {v4}, Lcom/auditude/ads/reporting/ReportingHelper;->init()V

    .line 205
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 206
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v4, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    if-eqz v4, :cond_2

    .line 209
    iget-object v4, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    iget-object v5, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v5}, Lcom/auditude/ads/response/AdResponse;->getSubmissions()Lcom/auditude/ads/model/tracking/Submissions;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->setSubmissions(Lcom/auditude/ads/model/tracking/Submissions;)V

    .line 211
    const-string v4, "breaks"

    iget-object v5, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v5}, Lcom/auditude/ads/response/AdResponse;->GetBreakData()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 213
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 214
    .local v2, "errors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_1
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_3

    .line 225
    const-string v4, "errors"

    invoke-virtual {v0, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 227
    iget-object v4, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    const-string v5, "apiEvent"

    new-instance v6, Lcom/auditude/ads/event/AdPluginEvent;

    const-string v7, "initComplete"

    invoke-direct {v6, v7, v0}, Lcom/auditude/ads/event/AdPluginEvent;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {v4, v5, v6}, Lcom/auditude/ads/core/APIBridge;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 229
    .end local v2    # "errors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :cond_2
    return-void

    .line 214
    .restart local v2    # "errors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :cond_3
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/exception/AssetException;

    .line 216
    .local v3, "exception":Lcom/auditude/ads/exception/AssetException;
    if-eqz v3, :cond_1

    .line 218
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 219
    .local v1, "error":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v5, "AdId"

    iget-object v6, v3, Lcom/auditude/ads/exception/AssetException;->adId:Ljava/lang/String;

    invoke-virtual {v1, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 220
    const-string v5, "InternalErrorId"

    iget v6, v3, Lcom/auditude/ads/exception/AssetException;->id:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 221
    const-string v5, "Description"

    invoke-virtual {v3}, Lcom/auditude/ads/exception/AssetException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public onRequestFailed(Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 234
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponseListener:Lcom/auditude/ads/response/AdResponse$AdResponseListener;

    if-eqz v0, :cond_0

    .line 236
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponseListener:Lcom/auditude/ads/response/AdResponse$AdResponseListener;

    invoke-interface {v0, p1}, Lcom/auditude/ads/response/AdResponse$AdResponseListener;->onRequestFailed(Ljava/lang/Throwable;)V

    .line 240
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    invoke-virtual {v0}, Lcom/auditude/ads/reporting/ReportingHelper;->init()V

    .line 242
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    if-eqz v0, :cond_1

    .line 244
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    iget-object v1, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v1}, Lcom/auditude/ads/response/AdResponse;->getSubmissions()Lcom/auditude/ads/model/tracking/Submissions;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->setSubmissions(Lcom/auditude/ads/model/tracking/Submissions;)V

    .line 247
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    const-string v1, "apiEvent"

    new-instance v2, Lcom/auditude/ads/event/AdPluginErrorEvent;

    const-string v3, "initFailed"

    invoke-direct {v2, v3, p1}, Lcom/auditude/ads/event/AdPluginErrorEvent;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-virtual {v0, v1, v2}, Lcom/auditude/ads/core/APIBridge;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 249
    instance-of v0, p1, Ljava/net/SocketTimeoutException;

    if-eqz v0, :cond_2

    .line 251
    const/16 v0, 0x44c

    const-string v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->logError(ILjava/lang/String;)V

    .line 257
    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adResponse:Lcom/auditude/ads/response/AdResponse;

    .line 258
    return-void

    .line 255
    :cond_2
    const/16 v0, 0x44d

    const-string v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->logError(ILjava/lang/String;)V

    goto :goto_0
.end method

.method public setPluginEventListener(Lcom/auditude/ads/event/AuditudePluginEventListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/auditude/ads/event/AuditudePluginEventListener;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->listener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    .line 72
    return-void
.end method

.method public final setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 186
    iget-object v0, p0, Lcom/auditude/ads/AuditudeAdUnitDelegate;->adSettings:Lcom/auditude/ads/core/AdSettings;

    invoke-virtual {v0, p1, p2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    .line 187
    return-void
.end method
