.class public Ltv/freewheel/hybrid/ad/AdContext;
.super Ltv/freewheel/hybrid/utils/events/EventDispatcher;
.source "AdContext.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IAdContext;


# static fields
.field private static constants:Ltv/freewheel/hybrid/ad/Constants;


# instance fields
.field private final adLoadCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private final adLoadFailedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field public final adManager:Ltv/freewheel/hybrid/ad/AdManager;

.field public final adManagerVersion:Ljava/lang/String;

.field public adRenderers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/AdRenderer;",
            ">;"
        }
    .end annotation
.end field

.field public adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

.field public adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

.field private autoloadExtensions:Ljava/util/Map;
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

.field public capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

.field public defaultSiteSectionSlotProfile:Ljava/lang/String;

.field public defaultTemporalSlotProfile:Ljava/lang/String;

.field public defaultVideoPlayerSlotProfile:Ljava/lang/String;

.field protected geoLocation:Landroid/location/Location;

.field private hostActivity:Landroid/app/Activity;

.field public loadedExtensions:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ltv/freewheel/hybrid/extension/IExtension;",
            ">;"
        }
    .end annotation
.end field

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field public mOnActivityCallbackListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;",
            ">;>;"
        }
    .end annotation
.end field

.field public final networkId:I

.field public playerProfile:Ljava/lang/String;

.field private requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

.field private requestSubmitted:Z

.field protected screenDimensionStr:Ljava/lang/String;

.field public final serverUrl:Ljava/lang/String;

.field private temporalSlotBase:Landroid/widget/FrameLayout;

.field private userAgent:Ljava/lang/String;

.field public final version:I

.field public visitor:Ltv/freewheel/hybrid/ad/Visitor;


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 5
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 140
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->adManager:Ltv/freewheel/hybrid/ad/AdManager;

    invoke-direct {p0, v3}, Ltv/freewheel/hybrid/ad/AdContext;-><init>(Ltv/freewheel/hybrid/ad/AdManager;)V

    .line 142
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/ad/AdRequest;->setAdRequest(Ltv/freewheel/hybrid/ad/AdRequest;)V

    .line 144
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/Visitor;->customId:Ljava/lang/String;

    iput-object v4, v3, Ltv/freewheel/hybrid/ad/Visitor;->customId:Ljava/lang/String;

    .line 145
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/Visitor;->ipV4Address:Ljava/lang/String;

    iput-object v4, v3, Ltv/freewheel/hybrid/ad/Visitor;->ipV4Address:Ljava/lang/String;

    .line 146
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget v4, v4, Ltv/freewheel/hybrid/ad/Visitor;->bandwidth:I

    iput v4, v3, Ltv/freewheel/hybrid/ad/Visitor;->bandwidth:I

    .line 147
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/Visitor;->bandwidthSource:Ljava/lang/String;

    iput-object v4, v3, Ltv/freewheel/hybrid/ad/Visitor;->bandwidthSource:Ljava/lang/String;

    .line 148
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/Visitor;->httpHeaders:Ljava/util/TreeMap;

    invoke-virtual {v3}, Ljava/util/TreeMap;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 149
    .local v1, "name":Ljava/lang/String;
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/Visitor;->httpHeaders:Ljava/util/TreeMap;

    invoke-virtual {v3, v1}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 150
    .local v2, "value":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    invoke-virtual {v3, v1, v2}, Ltv/freewheel/hybrid/ad/Visitor;->setVisitorHttpHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 153
    .end local v1    # "name":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/ad/Capabilities;->setCapabilities(Ltv/freewheel/hybrid/ad/Capabilities;)V

    .line 154
    const-string v3, "resetExclusivity"

    const/4 v4, 0x2

    invoke-virtual {p0, v3, v4}, Ltv/freewheel/hybrid/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    .line 156
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->playerProfile:Ljava/lang/String;

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->playerProfile:Ljava/lang/String;

    .line 157
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->defaultTemporalSlotProfile:Ljava/lang/String;

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->defaultTemporalSlotProfile:Ljava/lang/String;

    .line 158
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->defaultVideoPlayerSlotProfile:Ljava/lang/String;

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->defaultVideoPlayerSlotProfile:Ljava/lang/String;

    .line 159
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->defaultSiteSectionSlotProfile:Ljava/lang/String;

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->defaultSiteSectionSlotProfile:Ljava/lang/String;

    .line 161
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->screenDimensionStr:Ljava/lang/String;

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->screenDimensionStr:Ljava/lang/String;

    .line 163
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;

    .line 165
    iget-object v3, p1, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    .line 167
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    iput-object v4, v3, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    .line 168
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/VideoAsset;->timer:Ltv/freewheel/hybrid/utils/RecordTimer;

    iput-object v4, v3, Ltv/freewheel/hybrid/ad/VideoAsset;->timer:Ltv/freewheel/hybrid/utils/RecordTimer;

    .line 169
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v4, p1, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/VideoAsset;->callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    iput-object v4, v3, Ltv/freewheel/hybrid/ad/VideoAsset;->callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    .line 170
    return-void
.end method

.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdManager;)V
    .locals 4
    .param p1, "adManager"    # Ltv/freewheel/hybrid/ad/AdManager;

    .prologue
    const/4 v3, 0x0

    .line 107
    invoke-direct {p0}, Ltv/freewheel/hybrid/utils/events/EventDispatcher;-><init>()V

    .line 66
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestSubmitted:Z

    .line 68
    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->playerProfile:Ljava/lang/String;

    .line 69
    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->defaultTemporalSlotProfile:Ljava/lang/String;

    .line 70
    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->defaultVideoPlayerSlotProfile:Ljava/lang/String;

    .line 71
    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->defaultSiteSectionSlotProfile:Ljava/lang/String;

    .line 78
    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    .line 461
    new-instance v0, Ltv/freewheel/hybrid/ad/AdContext$1;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/ad/AdContext$1;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adLoadCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 495
    new-instance v0, Ltv/freewheel/hybrid/ad/AdContext$2;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/ad/AdContext$2;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adLoadFailedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 109
    const/4 v0, 0x1

    invoke-static {p0, v0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 110
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "new "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 111
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext;->adManager:Ltv/freewheel/hybrid/ad/AdManager;

    .line 112
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdManager;->serverUrl:Ljava/lang/String;

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    .line 113
    iget v0, p1, Ltv/freewheel/hybrid/ad/AdManager;->networkId:I

    iput v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->networkId:I

    .line 114
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/AdManager;->getStringVersion()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adManagerVersion:Ljava/lang/String;

    .line 115
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/AdManager;->getVersion()I

    move-result v0

    iput v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->version:I

    .line 116
    new-instance v0, Ltv/freewheel/hybrid/ad/Visitor;

    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdContext;->getVersion()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ltv/freewheel/hybrid/ad/Visitor;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    .line 117
    new-instance v0, Ltv/freewheel/hybrid/ad/Capabilities;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/Capabilities;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    .line 118
    new-instance v0, Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/ad/AdRequest;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    .line 119
    new-instance v0, Ltv/freewheel/hybrid/ad/AdResponse;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/ad/AdResponse;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    .line 120
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRenderers:Ljava/util/ArrayList;

    .line 121
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Mozilla/5.0 ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/AdContext;->getCurrentUserAgent()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") FreeWheelAdManager/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdContext;->adManagerVersion:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->userAgent:Ljava/lang/String;

    .line 122
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->mOnActivityCallbackListeners:Ljava/util/ArrayList;

    .line 123
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adManager:Ltv/freewheel/hybrid/ad/AdManager;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/AdManager;->geoLocation:Landroid/location/Location;

    if-eqz v0, :cond_0

    .line 128
    new-instance v0, Landroid/location/Location;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdContext;->adManager:Ltv/freewheel/hybrid/ad/AdManager;

    iget-object v1, v1, Ltv/freewheel/hybrid/ad/AdManager;->geoLocation:Landroid/location/Location;

    invoke-direct {v0, v1}, Landroid/location/Location;-><init>(Landroid/location/Location;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->geoLocation:Landroid/location/Location;

    .line 133
    :goto_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    .line 134
    return-void

    .line 130
    :cond_0
    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->geoLocation:Landroid/location/Location;

    goto :goto_0
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/ad/AdContext;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdContext;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/AdContext;->logResponse(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Ltv/freewheel/hybrid/ad/AdContext;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 55
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->autoloadExtensions:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$102(Ltv/freewheel/hybrid/ad/AdContext;Ljava/util/Map;)Ljava/util/Map;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdContext;
    .param p1, "x1"    # Ljava/util/Map;

    .prologue
    .line 55
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext;->autoloadExtensions:Ljava/util/Map;

    return-object p1
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/ad/AdContext;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 55
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/AdContext;->getNeedLoadedExtensions()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 55
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/AdContext;->notifyRequestComplete()V

    return-void
.end method

.method static synthetic access$400(Ltv/freewheel/hybrid/ad/AdContext;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 55
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method static synthetic access$500(Ltv/freewheel/hybrid/ad/AdContext;)Landroid/widget/FrameLayout;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 55
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method static synthetic access$601(Ltv/freewheel/hybrid/ad/AdContext;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdContext;
    .param p1, "x1"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 55
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/utils/events/EventDispatcher;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    return-void
.end method

.method private getAutoLoadExtensions(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 10
    .param p1, "parameterName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1054
    const-string v0, ","

    .line 1056
    .local v0, "EXTENSION_URL_SEPARATOR":Ljava/lang/String;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1057
    .local v1, "_autoLoadExtensions":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, p1}, Ltv/freewheel/hybrid/ad/AdContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 1058
    .local v2, "autoloadExtensionsValue":Ljava/lang/Object;
    if-eqz v2, :cond_3

    .line 1059
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 1060
    .local v5, "extensionUrls":[Ljava/lang/String;
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    array-length v7, v5

    if-ge v6, v7, :cond_3

    .line 1061
    aget-object v7, v5, v6

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 1062
    .local v4, "extensionUrl":Ljava/lang/String;
    const-string v7, ""

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 1060
    :cond_0
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 1065
    :cond_1
    const/4 v3, 0x0

    .line 1066
    .local v3, "extensionName":Ljava/lang/String;
    const-string v7, "."

    invoke-virtual {v4, v7}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v7

    const/4 v8, -0x1

    if-le v7, v8, :cond_2

    .line 1067
    const-string v7, "/"

    invoke-virtual {v4, v7}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v7

    add-int/lit8 v7, v7, 0x1

    const-string v8, "."

    invoke-virtual {v4, v8}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v4, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 1070
    :cond_2
    if-eqz v3, :cond_0

    .line 1071
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "getAutoLoadExtensions() add extension, name:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " url:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 1073
    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 1077
    .end local v3    # "extensionName":Ljava/lang/String;
    .end local v4    # "extensionUrl":Ljava/lang/String;
    .end local v5    # "extensionUrls":[Ljava/lang/String;
    .end local v6    # "i":I
    :cond_3
    return-object v1
.end method

.method private getCurrentUserAgent()Ljava/lang/String;
    .locals 11

    .prologue
    .line 178
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v5

    .line 179
    .local v5, "locale":Ljava/util/Locale;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 182
    .local v1, "buffer":Ljava/lang/StringBuffer;
    sget-object v7, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 183
    .local v7, "version":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_3

    .line 184
    invoke-virtual {v1, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 189
    :goto_0
    const-string v8, "; "

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 191
    invoke-virtual {v5}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v4

    .line 192
    .local v4, "language":Ljava/lang/String;
    if-eqz v4, :cond_4

    .line 193
    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 194
    invoke-virtual {v5}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v2

    .line 195
    .local v2, "country":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 196
    const-string v8, "-"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 197
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 205
    .end local v2    # "country":Ljava/lang/String;
    :cond_0
    :goto_1
    const-string v8, "REL"

    sget-object v9, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 206
    sget-object v6, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 207
    .local v6, "model":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_1

    .line 208
    const-string v8, "; "

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 209
    invoke-virtual {v1, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 213
    .end local v6    # "model":Ljava/lang/String;
    :cond_1
    sget-object v3, Landroid/os/Build;->ID:Ljava/lang/String;

    .line 214
    .local v3, "id":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_2

    .line 215
    const-string v8, " Build/"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 216
    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 219
    :cond_2
    const-string v0, "Android %s"

    .line 220
    .local v0, "base":Ljava/lang/String;
    const-string v8, "Android %s"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v1, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 187
    .end local v0    # "base":Ljava/lang/String;
    .end local v3    # "id":Ljava/lang/String;
    .end local v4    # "language":Ljava/lang/String;
    :cond_3
    const-string v8, "1.0"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 201
    .restart local v4    # "language":Ljava/lang/String;
    :cond_4
    const-string v8, "en"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1
.end method

.method private getNeedLoadedExtensions()Ljava/util/Map;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1035
    new-instance v4, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v4}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    .line 1037
    .local v4, "ret":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v5, "autoloadExtensions"

    invoke-direct {p0, v5}, Ltv/freewheel/hybrid/ad/AdContext;->getAutoLoadExtensions(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1038
    const-string v5, "autoloadExtensionsInternal"

    invoke-direct {p0, v5}, Ltv/freewheel/hybrid/ad/AdContext;->getAutoLoadExtensions(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1039
    sget-object v5, Ltv/freewheel/hybrid/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 1040
    .local v3, "name":Ljava/lang/String;
    const-string v5, ""

    invoke-interface {v4, v3, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1042
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    new-instance v0, Ljava/util/HashSet;

    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-direct {v0, v5}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 1043
    .local v0, "autoloadExtensionNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1044
    .local v1, "extensionName":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v5, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1045
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "remove extension("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ") since it has been loaded"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 1046
    invoke-interface {v4, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 1050
    .end local v1    # "extensionName":Ljava/lang/String;
    :cond_2
    return-object v4
.end method

.method private logResponse(Ljava/lang/String;)V
    .locals 5
    .param p1, "responseStr"    # Ljava/lang/String;

    .prologue
    .line 453
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 454
    .local v1, "msgList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-direct {p0, p1, v1}, Ltv/freewheel/hybrid/ad/AdContext;->splitStringIntoArray(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 455
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "got response: "

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 456
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 457
    .local v2, "s":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v3, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 459
    .end local v2    # "s":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private notifyRequestComplete()V
    .locals 3

    .prologue
    .line 431
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 432
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "message"

    const-string v2, "request succeeded"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 433
    const-string v1, "success"

    const-string v2, "true"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 434
    new-instance v1, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v2, "requestComplete"

    invoke-direct {v1, v2, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 435
    return-void
.end method

.method private splitStringIntoArray(Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "msgList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/16 v1, 0xfa0

    .line 438
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-le v0, v1, :cond_0

    .line 439
    const/4 v0, 0x0

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 440
    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Ltv/freewheel/hybrid/ad/AdContext;->splitStringIntoArray(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 444
    :goto_0
    return-void

    .line 442
    :cond_0
    invoke-virtual {p2, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method


# virtual methods
.method public addKeyValue(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 246
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "addKeyValue "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 247
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/ad/AdRequest;->addKeyValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    return-void
.end method

.method addOnActivityCallbackListener(Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;)V
    .locals 2
    .param p1, "listener"    # Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;

    .prologue
    .line 859
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->mOnActivityCallbackListeners:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 860
    return-void
.end method

.method public buildRequest()Ltv/freewheel/hybrid/utils/URLRequest;
    .locals 10

    .prologue
    const/4 v2, 0x0

    .line 512
    iget v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->networkId:I

    const/4 v6, -0x1

    if-eq v5, v6, :cond_1

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    if-eqz v5, :cond_1

    .line 514
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v4, v5, Landroid/util/DisplayMetrics;->density:F

    .line 515
    .local v4, "scale":F
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v5, "0.##"

    invoke-direct {v0, v5}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 516
    .local v0, "decimalFormat":Ljava/text/DecimalFormat;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    const-string v6, "_fw_dpr"

    float-to-double v8, v4

    invoke-virtual {v0, v8, v9}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ltv/freewheel/hybrid/ad/AdRequest;->addKeyValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 518
    const-string v3, ""

    .line 520
    .local v3, "requestStr":Ljava/lang/String;
    :try_start_0
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/ad/AdRequest;->toXML()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 526
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "request is: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 528
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "submitRequest: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 530
    new-instance v2, Ltv/freewheel/hybrid/utils/URLRequest;

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdContext;->userAgent:Ljava/lang/String;

    invoke-direct {v2, v5, v6}, Ltv/freewheel/hybrid/utils/URLRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 532
    .local v2, "req":Ltv/freewheel/hybrid/utils/URLRequest;
    const-string v5, "_fw_request_alternative_url"

    invoke-virtual {p0, v5}, Ltv/freewheel/hybrid/ad/AdContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 533
    const/4 v5, 0x1

    iput v5, v2, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    .line 537
    :goto_0
    const-string v5, "text/xml"

    iput-object v5, v2, Ltv/freewheel/hybrid/utils/URLRequest;->contentType:Ljava/lang/String;

    .line 538
    iput-object v3, v2, Ltv/freewheel/hybrid/utils/URLRequest;->data:Ljava/lang/String;

    .line 543
    .end local v0    # "decimalFormat":Ljava/text/DecimalFormat;
    .end local v2    # "req":Ltv/freewheel/hybrid/utils/URLRequest;
    .end local v3    # "requestStr":Ljava/lang/String;
    .end local v4    # "scale":F
    :goto_1
    return-object v2

    .line 521
    .restart local v0    # "decimalFormat":Ljava/text/DecimalFormat;
    .restart local v3    # "requestStr":Ljava/lang/String;
    .restart local v4    # "scale":F
    :catch_0
    move-exception v1

    .line 522
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 523
    new-instance v5, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v6, "requestComplete"

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v5}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_1

    .line 535
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "req":Ltv/freewheel/hybrid/utils/URLRequest;
    :cond_0
    const/4 v5, 0x0

    iput v5, v2, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    goto :goto_0

    .line 542
    .end local v0    # "decimalFormat":Ljava/text/DecimalFormat;
    .end local v2    # "req":Ltv/freewheel/hybrid/utils/URLRequest;
    .end local v3    # "requestStr":Ljava/lang/String;
    .end local v4    # "scale":F
    :cond_1
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v6, "invalid networkId or serverUrl"

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 3
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 997
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    if-nez v0, :cond_0

    .line 998
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "The activity is not registered yet. The dispatchEvent will be done on current thread."

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 999
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/utils/events/EventDispatcher;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 1011
    :goto_0
    return-void

    .line 1000
    :cond_0
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_1

    .line 1001
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Need re-dispatchEvent "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " on main UI thread."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 1002
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Ltv/freewheel/hybrid/ad/AdContext$5;

    invoke-direct {v1, p0, p1}, Ltv/freewheel/hybrid/ad/AdContext$5;-><init>(Ltv/freewheel/hybrid/ad/AdContext;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 1009
    :cond_1
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/utils/events/EventDispatcher;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_0
.end method

.method public dispose()V
    .locals 6

    .prologue
    .line 874
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v5, "dispose"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 875
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdContext;->removeAllListeners()V

    .line 876
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    if-eqz v4, :cond_0

    .line 877
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/utils/URLLoader;->removeAllListeners()V

    .line 879
    :cond_0
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->mOnActivityCallbackListeners:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    .line 881
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 882
    .local v1, "n_iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 883
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    .line 884
    .local v2, "n_slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->stop()V

    goto :goto_0

    .line 887
    .end local v2    # "n_slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    :cond_1
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 888
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/TemporalSlot;>;"
    :cond_2
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 889
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;

    .line 890
    .local v3, "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    invoke-virtual {v3}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->isPlaying()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 891
    invoke-virtual {v3}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->stop()V

    goto :goto_1

    .line 895
    .end local v3    # "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    :cond_3
    const/4 v4, 0x0

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    .line 896
    invoke-static {p0}, Ltv/freewheel/hybrid/extension/ExtensionManager;->unregisterAdContext(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 897
    return-void
.end method

.method public getActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 785
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    return-object v0
.end method

.method public getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .locals 1

    .prologue
    .line 225
    sget-object v0, Ltv/freewheel/hybrid/ad/AdContext;->constants:Ltv/freewheel/hybrid/ad/Constants;

    if-nez v0, :cond_0

    .line 226
    new-instance v0, Ltv/freewheel/hybrid/ad/Constants;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/Constants;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/AdContext;->constants:Ltv/freewheel/hybrid/ad/Constants;

    .line 229
    :cond_0
    sget-object v0, Ltv/freewheel/hybrid/ad/AdContext;->constants:Ltv/freewheel/hybrid/ad/Constants;

    return-object v0
.end method

.method public getParameter(Ljava/lang/String;)Ljava/lang/Object;
    .locals 5
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 920
    const/4 v3, 0x0

    .line 921
    .local v3, "value":Ljava/lang/Object;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 922
    .local v1, "paramArray":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdRequest;->overrideLevelParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 923
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->profileParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 924
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdRequest;->globalLevelParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 926
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 928
    .end local v3    # "value":Ljava/lang/Object;
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 929
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/HashMap;

    .line 930
    .local v2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 931
    .restart local v3    # "value":Ljava/lang/Object;
    if-eqz v3, :cond_0

    .line 936
    .end local v2    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v3    # "value":Ljava/lang/Object;
    :cond_1
    return-object v3
.end method

.method protected getScreenDimensionStr()Ljava/lang/String;
    .locals 7

    .prologue
    .line 758
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->screenDimensionStr:Ljava/lang/String;

    if-nez v3, :cond_0

    .line 759
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    const-string v4, "window"

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/WindowManager;

    invoke-interface {v3}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 760
    .local v0, "display":Landroid/view/Display;
    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v2

    .line 761
    .local v2, "width":I
    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 762
    .local v1, "height":I
    const-string v3, "%d,%d"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->screenDimensionStr:Ljava/lang/String;

    .line 764
    .end local v0    # "display":Landroid/view/Display;
    .end local v1    # "height":I
    .end local v2    # "width":I
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->screenDimensionStr:Ljava/lang/String;

    return-object v3
.end method

.method public getSiteSectionNonTemporalSlots()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 721
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 723
    .local v2, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 724
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 725
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 726
    .local v1, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v3

    const/4 v4, 0x2

    if-ne v3, v4, :cond_0

    .line 727
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 731
    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_1
    return-object v2
.end method

.method public getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .locals 4
    .param p1, "customId"    # Ljava/lang/String;

    .prologue
    .line 387
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 388
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/TemporalSlot;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 389
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/slot/Slot;

    .line 390
    .local v2, "slot":Ltv/freewheel/hybrid/ad/slot/Slot;
    iget-object v3, v2, Ltv/freewheel/hybrid/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 403
    .end local v2    # "slot":Ltv/freewheel/hybrid/ad/slot/Slot;
    :goto_0
    return-object v2

    .line 395
    :cond_1
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 396
    .local v1, "iter2":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;>;"
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 397
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/slot/Slot;

    .line 398
    .restart local v2    # "slot":Ltv/freewheel/hybrid/ad/slot/Slot;
    iget-object v3, v2, Ltv/freewheel/hybrid/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    goto :goto_0

    .line 403
    .end local v2    # "slot":Ltv/freewheel/hybrid/ad/slot/Slot;
    :cond_3
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getSlotsByTimePositionClass(I)Ljava/util/ArrayList;
    .locals 5
    .param p1, "timePositionClass"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 408
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 410
    .local v3, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    const/4 v4, 0x5

    if-ne p1, v4, :cond_0

    .line 411
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 412
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 414
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 418
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;>;"
    :cond_0
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 419
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/TemporalSlot;>;"
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 420
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 421
    .local v2, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v4

    if-ne p1, v4, :cond_1

    .line 422
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 427
    .end local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/TemporalSlot;>;"
    .end local v2    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_2
    return-object v3
.end method

.method public getTemporalSlotBase()Landroid/widget/FrameLayout;
    .locals 1

    .prologue
    .line 701
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method public getTemporalSlots()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 706
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 708
    .local v2, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 709
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/TemporalSlot;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 710
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 711
    .local v1, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v3

    const/4 v4, 0x6

    if-eq v3, v4, :cond_0

    .line 712
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 716
    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_1
    return-object v2
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 508
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 233
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adManagerVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoPlayerNonTemporalSlots()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 736
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 738
    .local v2, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 739
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 740
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 741
    .local v1, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 742
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 746
    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_1
    return-object v2
.end method

.method public loadExtension(Ljava/lang/String;)V
    .locals 7
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 549
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "loadExtension: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 550
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v4, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 551
    const/4 v3, 0x1

    .line 552
    .local v3, "success":Z
    const-string v2, "load successful"

    .line 554
    .local v2, "msg":Ljava/lang/String;
    :try_start_0
    invoke-static {p1, p0}, Ltv/freewheel/hybrid/extension/ExtensionManager;->loadExtension(Ljava/lang/String;Ltv/freewheel/hybrid/ad/AdContext;)Ltv/freewheel/hybrid/extension/IExtension;

    move-result-object v1

    .line 555
    .local v1, "ext":Ltv/freewheel/hybrid/extension/IExtension;
    if-nez v1, :cond_0

    .line 556
    const/4 v3, 0x0

    .line 557
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "can not get a instance for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    .line 566
    .end local v1    # "ext":Ltv/freewheel/hybrid/extension/IExtension;
    :cond_0
    :goto_0
    invoke-virtual {p0, v3, v2, p1}, Ltv/freewheel/hybrid/ad/AdContext;->onExtensionLoaded(ZLjava/lang/String;Ljava/lang/String;)V

    .line 570
    .end local v2    # "msg":Ljava/lang/String;
    .end local v3    # "success":Z
    :goto_1
    return-void

    .line 559
    .restart local v2    # "msg":Ljava/lang/String;
    .restart local v3    # "success":Z
    :catch_0
    move-exception v0

    .line 560
    .local v0, "e":Ljava/lang/IllegalAccessException;
    const/4 v3, 0x0

    .line 561
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 565
    goto :goto_0

    .line 562
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v0

    .line 563
    .local v0, "e":Ljava/lang/InstantiationException;
    const/4 v3, 0x0

    .line 564
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->getMessage()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 568
    .end local v0    # "e":Ljava/lang/InstantiationException;
    .end local v2    # "msg":Ljava/lang/String;
    .end local v3    # "success":Z
    :cond_1
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "already have extension "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " loaded before, ignore the action"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onExtensionLoaded(ZLjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "success"    # Z
    .param p2, "msg"    # Ljava/lang/String;
    .param p3, "moduleName"    # Ljava/lang/String;

    .prologue
    .line 1022
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1023
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "moduleName"

    invoke-virtual {v0, v1, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1024
    if-eqz p1, :cond_0

    .line 1025
    const-string v1, "message"

    const-string v2, "extension loaded"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1026
    const-string v1, "success"

    const-string v2, "true"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1031
    :goto_0
    new-instance v1, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v2, "extensionLoaded"

    invoke-direct {v1, v2, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 1032
    return-void

    .line 1028
    :cond_0
    const-string v1, "message"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1029
    const-string v1, "success"

    const-string v2, "false"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public registerVideoDisplayBase(Landroid/widget/FrameLayout;)V
    .locals 2
    .param p1, "videoDisplayBase"    # Landroid/widget/FrameLayout;

    .prologue
    .line 682
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;

    .line 683
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Ltv/freewheel/hybrid/ad/AdContext$4;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/ad/AdContext$4;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 698
    return-void
.end method

.method public requestContentPause(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 3
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 955
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "requestContentPause(slot="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 956
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    invoke-static {}, Ltv/freewheel/hybrid/ad/state/VideoPlayingState;->Instance()Ltv/freewheel/hybrid/ad/state/VideoState;

    move-result-object v1

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    invoke-static {}, Ltv/freewheel/hybrid/ad/state/VideoPendingState;->Instance()Ltv/freewheel/hybrid/ad/state/VideoState;

    move-result-object v1

    if-ne v0, v1, :cond_1

    .line 958
    :cond_0
    new-instance v0, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v1, "requestContentVideoPause"

    iget-object v2, p1, Ltv/freewheel/hybrid/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 962
    :goto_0
    return-void

    .line 960
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "ignore since main video is not in playing state"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public requestContentResume(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 7
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 965
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "requestContentResume(slot="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 966
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 968
    .local v3, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/slot/Slot;>;"
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdContext;->getTemporalSlots()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 969
    .local v2, "s":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    check-cast v2, Ltv/freewheel/hybrid/ad/slot/Slot;

    .end local v2    # "s":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 971
    :cond_0
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdContext;->getVideoPlayerNonTemporalSlots()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 972
    .restart local v2    # "s":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    check-cast v2, Ltv/freewheel/hybrid/ad/slot/Slot;

    .end local v2    # "s":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 974
    :cond_1
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdContext;->getSiteSectionNonTemporalSlots()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 975
    .restart local v2    # "s":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    check-cast v2, Ltv/freewheel/hybrid/ad/slot/Slot;

    .end local v2    # "s":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 977
    :cond_2
    const/4 v0, 0x0

    .line 978
    .local v0, "hasOtherSlotPauseContent":Z
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/slot/Slot;

    .line 979
    .local v2, "s":Ltv/freewheel/hybrid/ad/slot/Slot;
    iget-boolean v4, v2, Ltv/freewheel/hybrid/ad/slot/Slot;->requestContentPause:Z

    if-eqz v4, :cond_3

    .line 980
    const/4 v0, 0x1

    .line 984
    .end local v2    # "s":Ltv/freewheel/hybrid/ad/slot/Slot;
    :cond_4
    if-nez v0, :cond_6

    .line 985
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    invoke-static {}, Ltv/freewheel/hybrid/ad/state/VideoPausedState;->Instance()Ltv/freewheel/hybrid/ad/state/VideoState;

    move-result-object v5

    if-ne v4, v5, :cond_5

    .line 986
    new-instance v4, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v5, "requestContentVideoResume"

    iget-object v6, p1, Ltv/freewheel/hybrid/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-direct {v4, v5, v6}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 993
    :goto_3
    return-void

    .line 988
    :cond_5
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v5, "ignore since main video is in playing state"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_3

    .line 991
    :cond_6
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v5, "ignore since other slot need content video pause"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_3
.end method

.method public setActivity(Landroid/app/Activity;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 769
    if-eqz p1, :cond_0

    .line 770
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext;->hostActivity:Landroid/app/Activity;

    .line 773
    :try_start_0
    invoke-virtual {p1}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p1}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    iget v2, v2, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 778
    .local v0, "appVersion":Ljava/lang/String;
    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->userAgent:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/ad/AdContext;->userAgent:Ljava/lang/String;

    .line 779
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "UserAgent:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->userAgent:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 781
    .end local v0    # "appVersion":Ljava/lang/String;
    :cond_0
    return-void

    .line 775
    :catch_0
    move-exception v1

    .line 776
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v0, "unknown"

    .restart local v0    # "appVersion":Ljava/lang/String;
    goto :goto_0
.end method

.method public setCapability(Ljava/lang/String;I)V
    .locals 3
    .param p1, "capability"    # Ljava/lang/String;
    .param p2, "status"    # I

    .prologue
    .line 279
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "setCapability "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 280
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/ad/Capabilities;->setCapability(Ljava/lang/String;I)V

    .line 281
    return-void
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/Object;I)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "level"    # I

    .prologue
    .line 382
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-virtual {v0, p1, p2, p3}, Ltv/freewheel/hybrid/ad/AdRequest;->setParameter(Ljava/lang/String;Ljava/lang/Object;I)V

    .line 383
    return-void
.end method

.method public submitRequest(D)V
    .locals 3
    .param p1, "timeoutSeconds"    # D

    .prologue
    .line 574
    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Ltv/freewheel/hybrid/ad/AdContext;->submitRequest(DD)V

    .line 575
    return-void
.end method

.method public submitRequest(DD)V
    .locals 11
    .param p1, "timeoutSeconds"    # D
    .param p3, "maxDelayBeforeRequest"    # D

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 578
    const-wide v4, 0x408f400000000000L    # 1000.0

    mul-double/2addr v4, p3

    double-to-long v0, v4

    .line 579
    .local v0, "delayMs":J
    iget-boolean v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestSubmitted:Z

    if-eqz v3, :cond_1

    .line 580
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "Each AdContext instance can only submit ad request once."

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 655
    :cond_0
    :goto_0
    return-void

    .line 583
    :cond_1
    iput-boolean v8, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestSubmitted:Z

    .line 585
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    const-string v4, "^\\w+:.*"

    invoke-virtual {v3, v4}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 586
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "submitRequest to local file: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 587
    new-instance v3, Ltv/freewheel/hybrid/ad/AdContext$3;

    invoke-direct {v3, p0, v0, v1}, Ltv/freewheel/hybrid/ad/AdContext$3;-><init>(Ltv/freewheel/hybrid/ad/AdContext;J)V

    invoke-virtual {v3}, Ltv/freewheel/hybrid/ad/AdContext$3;->start()V

    goto :goto_0

    .line 620
    :cond_2
    const-string v3, "skipsAdSelection"

    invoke-virtual {p0, v3, v8}, Ltv/freewheel/hybrid/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    .line 622
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-virtual {v3}, Ltv/freewheel/hybrid/ad/AdRequest;->hasVideoAsset()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 623
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    iget-boolean v3, v3, Ltv/freewheel/hybrid/ad/AdRequest;->videoViewCallbackRequested:Z

    if-eqz v3, :cond_4

    .line 624
    const-string v3, "requiresVideoCallbackUrl"

    invoke-virtual {p0, v3, v8}, Ltv/freewheel/hybrid/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    .line 635
    :goto_1
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->geoLocation:Landroid/location/Location;

    if-eqz v3, :cond_3

    .line 636
    const-string v3, "ltlg"

    const-string v4, "%.4f,%.4f"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdContext;->geoLocation:Landroid/location/Location;

    invoke-virtual {v6}, Landroid/location/Location;->getLatitude()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    aput-object v6, v5, v9

    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdContext;->geoLocation:Landroid/location/Location;

    invoke-virtual {v6}, Landroid/location/Location;->getLongitude()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Ltv/freewheel/hybrid/ad/AdContext;->addKeyValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 640
    :cond_3
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdContext;->buildRequest()Ltv/freewheel/hybrid/utils/URLRequest;

    move-result-object v2

    .line 642
    .local v2, "req":Ltv/freewheel/hybrid/utils/URLRequest;
    if-eqz v2, :cond_0

    .line 643
    iput-wide v0, v2, Ltv/freewheel/hybrid/utils/URLRequest;->delayMs:J

    .line 644
    new-instance v3, Ltv/freewheel/hybrid/utils/URLLoader;

    invoke-direct {v3}, Ltv/freewheel/hybrid/utils/URLLoader;-><init>()V

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    .line 646
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    const-string v4, "URLLoader.Load.Complete"

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->adLoadCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-virtual {v3, v4, v5}, Ltv/freewheel/hybrid/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 647
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    const-string v4, "URLLoader.Load.Error"

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdContext;->adLoadFailedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-virtual {v3, v4, v5}, Ltv/freewheel/hybrid/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 649
    const-wide/16 v4, 0x0

    cmpg-double v3, p1, v4

    if-gtz v3, :cond_6

    .line 650
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    invoke-virtual {v3, v2}, Ltv/freewheel/hybrid/utils/URLLoader;->load(Ltv/freewheel/hybrid/utils/URLRequest;)V

    goto/16 :goto_0

    .line 627
    .end local v2    # "req":Ltv/freewheel/hybrid/utils/URLRequest;
    :cond_4
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    iput-boolean v8, v3, Ltv/freewheel/hybrid/ad/AdRequest;->videoViewCallbackRequested:Z

    .line 628
    const-string v3, "requiresVideoCallbackUrl"

    invoke-virtual {p0, v3, v9}, Ltv/freewheel/hybrid/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    goto :goto_1

    .line 632
    :cond_5
    const-string v3, "requiresVideoCallbackUrl"

    invoke-virtual {p0, v3, v8}, Ltv/freewheel/hybrid/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    goto :goto_1

    .line 652
    .restart local v2    # "req":Ltv/freewheel/hybrid/utils/URLRequest;
    :cond_6
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext;->requestLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    invoke-virtual {v3, v2, p1, p2}, Ltv/freewheel/hybrid/utils/URLLoader;->load(Ltv/freewheel/hybrid/utils/URLRequest;D)V

    goto/16 :goto_0
.end method
