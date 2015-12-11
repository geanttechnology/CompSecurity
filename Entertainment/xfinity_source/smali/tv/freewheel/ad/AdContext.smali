.class public Ltv/freewheel/ad/AdContext;
.super Ltv/freewheel/utils/events/EventDispatcher;
.source "AdContext.java"

# interfaces
.implements Ltv/freewheel/ad/interfaces/IAdContext;


# static fields
.field private static constants:Ltv/freewheel/ad/Constants;


# instance fields
.field private adLoadCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field private adLoadFailedListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field public final adManager:Ltv/freewheel/ad/AdManager;

.field public final adManagerVersion:Ljava/lang/String;

.field public adRenderers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/AdRenderer;",
            ">;"
        }
    .end annotation
.end field

.field public adRequest:Ltv/freewheel/ad/AdRequest;

.field public adResponse:Ltv/freewheel/ad/AdResponse;

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

.field public capabilities:Ltv/freewheel/ad/Capabilities;

.field public defaultSiteSectionSlotProfile:Ljava/lang/String;

.field public defaultTemporalSlotProfile:Ljava/lang/String;

.field public defaultVideoPlayerSlotProfile:Ljava/lang/String;

.field private deviceIdAdded:Z

.field protected geoLocation:Landroid/location/Location;

.field private hostActivity:Landroid/app/Activity;

.field public loadedExtensions:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ltv/freewheel/extension/IExtension;",
            ">;"
        }
    .end annotation
.end field

.field private logger:Ltv/freewheel/utils/Logger;

.field public mOnActivityCallbackListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;",
            ">;>;"
        }
    .end annotation
.end field

.field public final networkId:I

.field public playerProfile:Ljava/lang/String;

.field private requestLoader:Ltv/freewheel/utils/URLLoader;

.field private requestSubmitted:Z

.field protected screenDimensionStr:Ljava/lang/String;

.field public final serverUrl:Ljava/lang/String;

.field private temporalSlotBase:Landroid/widget/FrameLayout;

.field private userAgent:Ljava/lang/String;

.field public final version:I

.field public visitor:Ltv/freewheel/ad/Visitor;


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdManager;)V
    .locals 4
    .param p1, "adManager"    # Ltv/freewheel/ad/AdManager;

    .prologue
    const/4 v0, 0x0

    const/4 v3, 0x0

    .line 108
    invoke-direct {p0}, Ltv/freewheel/utils/events/EventDispatcher;-><init>()V

    .line 63
    iput-boolean v0, p0, Ltv/freewheel/ad/AdContext;->requestSubmitted:Z

    .line 64
    iput-boolean v0, p0, Ltv/freewheel/ad/AdContext;->deviceIdAdded:Z

    .line 66
    iput-object v3, p0, Ltv/freewheel/ad/AdContext;->playerProfile:Ljava/lang/String;

    .line 67
    iput-object v3, p0, Ltv/freewheel/ad/AdContext;->defaultTemporalSlotProfile:Ljava/lang/String;

    .line 68
    iput-object v3, p0, Ltv/freewheel/ad/AdContext;->defaultVideoPlayerSlotProfile:Ljava/lang/String;

    .line 69
    iput-object v3, p0, Ltv/freewheel/ad/AdContext;->defaultSiteSectionSlotProfile:Ljava/lang/String;

    .line 76
    iput-object v3, p0, Ltv/freewheel/ad/AdContext;->requestLoader:Ltv/freewheel/utils/URLLoader;

    .line 458
    new-instance v0, Ltv/freewheel/ad/AdContext$1;

    invoke-direct {v0, p0}, Ltv/freewheel/ad/AdContext$1;-><init>(Ltv/freewheel/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->adLoadCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 492
    new-instance v0, Ltv/freewheel/ad/AdContext$2;

    invoke-direct {v0, p0}, Ltv/freewheel/ad/AdContext$2;-><init>(Ltv/freewheel/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->adLoadFailedListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 110
    const/4 v0, 0x1

    invoke-static {p0, v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    .line 111
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 112
    iput-object p1, p0, Ltv/freewheel/ad/AdContext;->adManager:Ltv/freewheel/ad/AdManager;

    .line 113
    iget-object v0, p1, Ltv/freewheel/ad/AdManager;->serverUrl:Ljava/lang/String;

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    .line 114
    iget v0, p1, Ltv/freewheel/ad/AdManager;->networkId:I

    iput v0, p0, Ltv/freewheel/ad/AdContext;->networkId:I

    .line 115
    invoke-virtual {p1}, Ltv/freewheel/ad/AdManager;->getStringVersion()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->adManagerVersion:Ljava/lang/String;

    .line 116
    invoke-virtual {p1}, Ltv/freewheel/ad/AdManager;->getVersion()I

    move-result v0

    iput v0, p0, Ltv/freewheel/ad/AdContext;->version:I

    .line 117
    new-instance v0, Ltv/freewheel/ad/Visitor;

    invoke-virtual {p0}, Ltv/freewheel/ad/AdContext;->getVersion()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ltv/freewheel/ad/Visitor;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->visitor:Ltv/freewheel/ad/Visitor;

    .line 118
    new-instance v0, Ltv/freewheel/ad/Capabilities;

    invoke-direct {v0}, Ltv/freewheel/ad/Capabilities;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->capabilities:Ltv/freewheel/ad/Capabilities;

    .line 119
    new-instance v0, Ltv/freewheel/ad/AdRequest;

    invoke-direct {v0, p0}, Ltv/freewheel/ad/AdRequest;-><init>(Ltv/freewheel/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    .line 120
    new-instance v0, Ltv/freewheel/ad/AdResponse;

    invoke-direct {v0, p0}, Ltv/freewheel/ad/AdResponse;-><init>(Ltv/freewheel/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    .line 121
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->adRenderers:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Mozilla/5.0 ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Ltv/freewheel/ad/AdContext;->getCurrentUserAgent()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") FreeWheelAdManager/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/ad/AdContext;->adManagerVersion:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->userAgent:Ljava/lang/String;

    .line 126
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->mOnActivityCallbackListeners:Ljava/util/ArrayList;

    .line 127
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->adManager:Ltv/freewheel/ad/AdManager;

    iget-object v0, v0, Ltv/freewheel/ad/AdManager;->geoLocation:Landroid/location/Location;

    if-eqz v0, :cond_0

    .line 132
    new-instance v0, Landroid/location/Location;

    iget-object v1, p0, Ltv/freewheel/ad/AdContext;->adManager:Ltv/freewheel/ad/AdManager;

    iget-object v1, v1, Ltv/freewheel/ad/AdManager;->geoLocation:Landroid/location/Location;

    invoke-direct {v0, v1}, Landroid/location/Location;-><init>(Landroid/location/Location;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->geoLocation:Landroid/location/Location;

    .line 137
    :goto_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    .line 138
    return-void

    .line 134
    :cond_0
    iput-object v3, p0, Ltv/freewheel/ad/AdContext;->geoLocation:Landroid/location/Location;

    goto :goto_0
.end method

.method static synthetic access$000(Ltv/freewheel/ad/AdContext;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/ad/AdContext;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-direct {p0, p1}, Ltv/freewheel/ad/AdContext;->logResponse(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Ltv/freewheel/ad/AdContext;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/ad/AdContext;

    .prologue
    .line 52
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->autoloadExtensions:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$102(Ltv/freewheel/ad/AdContext;Ljava/util/Map;)Ljava/util/Map;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/ad/AdContext;
    .param p1, "x1"    # Ljava/util/Map;

    .prologue
    .line 52
    iput-object p1, p0, Ltv/freewheel/ad/AdContext;->autoloadExtensions:Ljava/util/Map;

    return-object p1
.end method

.method static synthetic access$200(Ltv/freewheel/ad/AdContext;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/ad/AdContext;

    .prologue
    .line 52
    invoke-direct {p0}, Ltv/freewheel/ad/AdContext;->getNeedLoadedExtensions()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/ad/AdContext;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/ad/AdContext;

    .prologue
    .line 52
    invoke-direct {p0}, Ltv/freewheel/ad/AdContext;->notifyRequestComplete()V

    return-void
.end method

.method static synthetic access$400(Ltv/freewheel/ad/AdContext;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/ad/AdContext;

    .prologue
    .line 52
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    return-object v0
.end method

.method static synthetic access$601(Ltv/freewheel/ad/AdContext;Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/ad/AdContext;
    .param p1, "x1"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 52
    invoke-super {p0, p1}, Ltv/freewheel/utils/events/EventDispatcher;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    return-void
.end method

.method private checkIdType(I)I
    .locals 1
    .param p1, "type"    # I

    .prologue
    .line 740
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    const/4 v0, 0x2

    if-eq p1, v0, :cond_0

    .line 742
    const/4 p1, 0x0

    .line 744
    .end local p1    # "type":I
    :cond_0
    return p1
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
    .line 1006
    const-string v0, ","

    .line 1008
    .local v0, "EXTENSION_URL_SEPARATOR":Ljava/lang/String;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1009
    .local v1, "_autoLoadExtensions":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, p1}, Ltv/freewheel/ad/AdContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 1010
    .local v2, "autoloadExtensionsValue":Ljava/lang/Object;
    if-eqz v2, :cond_3

    .line 1011
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 1012
    .local v5, "extensionUrls":[Ljava/lang/String;
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    array-length v7, v5

    if-ge v6, v7, :cond_3

    .line 1013
    aget-object v7, v5, v6

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 1014
    .local v4, "extensionUrl":Ljava/lang/String;
    const-string v7, ""

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 1012
    :cond_0
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 1017
    :cond_1
    const/4 v3, 0x0

    .line 1018
    .local v3, "extensionName":Ljava/lang/String;
    const-string v7, "."

    invoke-virtual {v4, v7}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v7

    const/4 v8, -0x1

    if-le v7, v8, :cond_2

    .line 1019
    const-string v7, "/"

    invoke-virtual {v4, v7}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v7

    add-int/lit8 v7, v7, 0x1

    const-string v8, "."

    invoke-virtual {v4, v8}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v4, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 1021
    :cond_2
    if-eqz v3, :cond_0

    .line 1022
    iget-object v7, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v7, v8}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 1023
    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 1027
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
    .line 181
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v5

    .line 182
    .local v5, "locale":Ljava/util/Locale;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 185
    .local v1, "buffer":Ljava/lang/StringBuffer;
    sget-object v7, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 186
    .local v7, "version":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_3

    .line 187
    invoke-virtual {v1, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 192
    :goto_0
    const-string v8, "; "

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 194
    invoke-virtual {v5}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v4

    .line 195
    .local v4, "language":Ljava/lang/String;
    if-eqz v4, :cond_4

    .line 196
    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 197
    invoke-virtual {v5}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v2

    .line 198
    .local v2, "country":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 199
    const-string v8, "-"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 200
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 208
    .end local v2    # "country":Ljava/lang/String;
    :cond_0
    :goto_1
    const-string v8, "REL"

    sget-object v9, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 209
    sget-object v6, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 210
    .local v6, "model":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_1

    .line 211
    const-string v8, "; "

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 212
    invoke-virtual {v1, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 216
    .end local v6    # "model":Ljava/lang/String;
    :cond_1
    sget-object v3, Landroid/os/Build;->ID:Ljava/lang/String;

    .line 217
    .local v3, "id":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_2

    .line 218
    const-string v8, " Build/"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 219
    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 222
    :cond_2
    const-string v0, "Android %s"

    .line 223
    .local v0, "base":Ljava/lang/String;
    const-string v8, "Android %s"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v1, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 190
    .end local v0    # "base":Ljava/lang/String;
    .end local v3    # "id":Ljava/lang/String;
    .end local v4    # "language":Ljava/lang/String;
    :cond_3
    const-string v8, "1.0"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 204
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
    .line 987
    new-instance v4, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v4}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    .line 989
    .local v4, "ret":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v5, "autoloadExtensions"

    invoke-direct {p0, v5}, Ltv/freewheel/ad/AdContext;->getAutoLoadExtensions(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 990
    const-string v5, "autoloadExtensionsInternal"

    invoke-direct {p0, v5}, Ltv/freewheel/ad/AdContext;->getAutoLoadExtensions(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 991
    sget-object v5, Ltv/freewheel/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

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

    .line 992
    .local v3, "name":Ljava/lang/String;
    const-string v5, ""

    invoke-interface {v4, v3, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 994
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    new-instance v0, Ljava/util/HashSet;

    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-direct {v0, v5}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 995
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

    .line 996
    .local v1, "extensionName":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v5, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 997
    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 998
    invoke-interface {v4, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 1002
    .end local v1    # "extensionName":Ljava/lang/String;
    :cond_2
    return-object v4
.end method

.method private logResponse(Ljava/lang/String;)V
    .locals 5
    .param p1, "responseStr"    # Ljava/lang/String;

    .prologue
    .line 450
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 451
    .local v1, "msgList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-direct {p0, p1, v1}, Ltv/freewheel/ad/AdContext;->splitStringIntoArray(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 452
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    const-string v4, "got response: "

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 453
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

    .line 454
    .local v2, "s":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v3, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 456
    .end local v2    # "s":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private notifyRequestComplete()V
    .locals 3

    .prologue
    .line 430
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 431
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "message"

    const-string v2, "request succeeded"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 432
    const-string v1, "success"

    const-string v2, "true"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 433
    new-instance v1, Ltv/freewheel/utils/events/Event;

    const-string v2, "requestComplete"

    invoke-direct {v1, v2, v0}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {p0, v1}, Ltv/freewheel/ad/AdContext;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 434
    return-void
.end method

.method private setDeviceIdentifier()V
    .locals 5

    .prologue
    .line 1031
    iget-boolean v3, p0, Ltv/freewheel/ad/AdContext;->deviceIdAdded:Z

    if-eqz v3, :cond_1

    .line 1041
    :cond_0
    :goto_0
    return-void

    .line 1032
    :cond_1
    const/4 v3, 0x1

    iput-boolean v3, p0, Ltv/freewheel/ad/AdContext;->deviceIdAdded:Z

    .line 1033
    const-string v3, "_fw_did_android_id"

    invoke-virtual {p0, v3}, Ltv/freewheel/ad/AdContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1034
    .local v2, "paramValue":Ljava/lang/String;
    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v2, v3}, Ltv/freewheel/utils/CommonUtil;->parseBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v1

    .line 1035
    .local v1, "enableDeviceIdentifier":Ljava/lang/Boolean;
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1036
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->hostActivity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "android_id"

    invoke-static {v3, v4}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1037
    .local v0, "androidId":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 1038
    const-string v3, "_fw_did_android_id"

    invoke-static {v0}, Ltv/freewheel/utils/CommonUtil;->md5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Ltv/freewheel/ad/AdContext;->addKeyValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
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

    .line 437
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-le v0, v1, :cond_0

    .line 438
    const/4 v0, 0x0

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 439
    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Ltv/freewheel/ad/AdContext;->splitStringIntoArray(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 443
    :goto_0
    return-void

    .line 441
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
    .line 247
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 248
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/ad/AdRequest;->addKeyValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    return-void
.end method

.method addOnActivityCallbackListener(Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;)V
    .locals 2
    .param p1, "listener"    # Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;

    .prologue
    .line 821
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->mOnActivityCallbackListeners:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 822
    return-void
.end method

.method public buildRequest()Ltv/freewheel/utils/URLRequest;
    .locals 10

    .prologue
    const/4 v2, 0x0

    .line 508
    iget v5, p0, Ltv/freewheel/ad/AdContext;->networkId:I

    const/4 v6, -0x1

    if-eq v5, v6, :cond_0

    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    if-eqz v5, :cond_0

    .line 510
    invoke-virtual {p0}, Ltv/freewheel/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v4, v5, Landroid/util/DisplayMetrics;->density:F

    .line 511
    .local v4, "scale":F
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v5, "0.##"

    invoke-direct {v0, v5}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 512
    .local v0, "decimalFormat":Ljava/text/DecimalFormat;
    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    const-string v6, "_fw_dpr"

    float-to-double v8, v4

    invoke-virtual {v0, v8, v9}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ltv/freewheel/ad/AdRequest;->addKeyValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 513
    invoke-direct {p0}, Ltv/freewheel/ad/AdContext;->setDeviceIdentifier()V

    .line 515
    const-string v3, ""

    .line 517
    .local v3, "requestStr":Ljava/lang/String;
    :try_start_0
    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    invoke-virtual {v5}, Ltv/freewheel/ad/AdRequest;->toXML()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 524
    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "request is: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 526
    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "submitRequest: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 528
    new-instance v2, Ltv/freewheel/utils/URLRequest;

    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    iget-object v6, p0, Ltv/freewheel/ad/AdContext;->userAgent:Ljava/lang/String;

    invoke-direct {v2, v5, v6}, Ltv/freewheel/utils/URLRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 530
    .local v2, "req":Ltv/freewheel/utils/URLRequest;
    const/4 v5, 0x0

    iput v5, v2, Ltv/freewheel/utils/URLRequest;->method:I

    .line 531
    const-string v5, "text/xml"

    iput-object v5, v2, Ltv/freewheel/utils/URLRequest;->contentType:Ljava/lang/String;

    .line 532
    iput-object v3, v2, Ltv/freewheel/utils/URLRequest;->data:Ljava/lang/String;

    .line 537
    .end local v0    # "decimalFormat":Ljava/text/DecimalFormat;
    .end local v2    # "req":Ltv/freewheel/utils/URLRequest;
    .end local v3    # "requestStr":Ljava/lang/String;
    .end local v4    # "scale":F
    :goto_0
    return-object v2

    .line 518
    .restart local v0    # "decimalFormat":Ljava/text/DecimalFormat;
    .restart local v3    # "requestStr":Ljava/lang/String;
    .restart local v4    # "scale":F
    :catch_0
    move-exception v1

    .line 519
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 520
    new-instance v5, Ltv/freewheel/utils/events/Event;

    const-string v6, "requestComplete"

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v5}, Ltv/freewheel/ad/AdContext;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 536
    .end local v0    # "decimalFormat":Ljava/text/DecimalFormat;
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v3    # "requestStr":Ljava/lang/String;
    .end local v4    # "scale":F
    :cond_0
    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    const-string v6, "invalid networkId or serverUrl"

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 3
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 951
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->hostActivity:Landroid/app/Activity;

    if-nez v0, :cond_0

    .line 952
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "The activity is not registered yet. The dispatchEvent will be done on current thread."

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 953
    invoke-super {p0, p1}, Ltv/freewheel/utils/events/EventDispatcher;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 964
    :goto_0
    return-void

    .line 954
    :cond_0
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/ad/AdContext;->hostActivity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_1

    .line 955
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Need re-dispatchEvent "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " on main UI thread."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 956
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Ltv/freewheel/ad/AdContext;->hostActivity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Ltv/freewheel/ad/AdContext$5;

    invoke-direct {v1, p0, p1}, Ltv/freewheel/ad/AdContext$5;-><init>(Ltv/freewheel/ad/AdContext;Ltv/freewheel/ad/interfaces/IEvent;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 962
    :cond_1
    invoke-super {p0, p1}, Ltv/freewheel/utils/events/EventDispatcher;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    goto :goto_0
.end method

.method public getActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 774
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->hostActivity:Landroid/app/Activity;

    return-object v0
.end method

.method public getConstants()Ltv/freewheel/ad/interfaces/IConstants;
    .locals 1

    .prologue
    .line 227
    sget-object v0, Ltv/freewheel/ad/AdContext;->constants:Ltv/freewheel/ad/Constants;

    if-nez v0, :cond_0

    .line 228
    new-instance v0, Ltv/freewheel/ad/Constants;

    invoke-direct {v0}, Ltv/freewheel/ad/Constants;-><init>()V

    sput-object v0, Ltv/freewheel/ad/AdContext;->constants:Ltv/freewheel/ad/Constants;

    .line 231
    :cond_0
    sget-object v0, Ltv/freewheel/ad/AdContext;->constants:Ltv/freewheel/ad/Constants;

    return-object v0
.end method

.method public getParameter(Ljava/lang/String;)Ljava/lang/Object;
    .locals 5
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 877
    const/4 v3, 0x0

    .line 878
    .local v3, "value":Ljava/lang/Object;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 879
    .local v1, "paramArray":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->overrideLevelParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 880
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->profileParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 881
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->globalLevelParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 883
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 885
    .end local v3    # "value":Ljava/lang/Object;
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 886
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/HashMap;

    .line 887
    .local v2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 888
    .restart local v3    # "value":Ljava/lang/Object;
    if-eqz v3, :cond_0

    .line 893
    .end local v2    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v3    # "value":Ljava/lang/Object;
    :cond_1
    return-object v3
.end method

.method protected getScreenDimensionStr()Ljava/lang/String;
    .locals 7

    .prologue
    .line 749
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->screenDimensionStr:Ljava/lang/String;

    if-nez v3, :cond_0

    .line 750
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->hostActivity:Landroid/app/Activity;

    const-string v4, "window"

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/WindowManager;

    invoke-interface {v3}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 751
    .local v0, "display":Landroid/view/Display;
    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v2

    .line 752
    .local v2, "width":I
    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 753
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

    iput-object v3, p0, Ltv/freewheel/ad/AdContext;->screenDimensionStr:Ljava/lang/String;

    .line 755
    .end local v0    # "display":Landroid/view/Display;
    .end local v1    # "height":I
    .end local v2    # "width":I
    :cond_0
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->screenDimensionStr:Ljava/lang/String;

    return-object v3
.end method

.method public getSiteSectionNonTemporalSlots()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 712
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 714
    .local v2, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 715
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 716
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/interfaces/ISlot;

    .line 717
    .local v1, "slot":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/ISlot;->getType()I

    move-result v3

    const/4 v4, 0x2

    if-ne v3, v4, :cond_0

    .line 718
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 722
    .end local v1    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    :cond_1
    return-object v2
.end method

.method public getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/ad/interfaces/ISlot;
    .locals 4
    .param p1, "customId"    # Ljava/lang/String;

    .prologue
    .line 387
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 388
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 389
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/slot/Slot;

    .line 390
    .local v2, "slot":Ltv/freewheel/ad/slot/Slot;
    iget-object v3, v2, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 403
    .end local v2    # "slot":Ltv/freewheel/ad/slot/Slot;
    :goto_0
    return-object v2

    .line 395
    :cond_1
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 396
    .local v1, "iter2":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 397
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/slot/Slot;

    .line 398
    .restart local v2    # "slot":Ltv/freewheel/ad/slot/Slot;
    iget-object v3, v2, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    goto :goto_0

    .line 403
    .end local v2    # "slot":Ltv/freewheel/ad/slot/Slot;
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
            "Ltv/freewheel/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 407
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 409
    .local v3, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    const/4 v4, 0x5

    if-ne p1, v4, :cond_0

    .line 410
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 411
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 413
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ltv/freewheel/ad/interfaces/ISlot;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 417
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    :cond_0
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 418
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 419
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/interfaces/ISlot;

    .line 420
    .local v2, "slot":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v4

    if-ne p1, v4, :cond_1

    .line 421
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 426
    .end local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    .end local v2    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    :cond_2
    return-object v3
.end method

.method public getTemporalSlotBase()Landroid/widget/FrameLayout;
    .locals 1

    .prologue
    .line 694
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->temporalSlotBase:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method public getTemporalSlots()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 698
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 700
    .local v2, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 701
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 702
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/interfaces/ISlot;

    .line 703
    .local v1, "slot":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v3

    const/4 v4, 0x6

    if-eq v3, v4, :cond_0

    .line 704
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 708
    .end local v1    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    :cond_1
    return-object v2
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 504
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->adManagerVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoPlayerNonTemporalSlots()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 726
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 728
    .local v2, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v3, v3, Ltv/freewheel/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 729
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 730
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/interfaces/ISlot;

    .line 731
    .local v1, "slot":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/ISlot;->getType()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 732
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 736
    .end local v1    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    :cond_1
    return-object v2
.end method

.method public loadExtension(Ljava/lang/String;)V
    .locals 7
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 542
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "loadExtension: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 543
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v4, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 544
    const/4 v3, 0x1

    .line 545
    .local v3, "success":Z
    const-string v2, "load successful"

    .line 547
    .local v2, "msg":Ljava/lang/String;
    :try_start_0
    invoke-static {p1, p0}, Ltv/freewheel/extension/ExtensionManager;->loadExtension(Ljava/lang/String;Ltv/freewheel/ad/AdContext;)Ltv/freewheel/extension/IExtension;

    move-result-object v1

    .line 548
    .local v1, "ext":Ltv/freewheel/extension/IExtension;
    if-nez v1, :cond_0

    .line 549
    const/4 v3, 0x0

    .line 550
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

    .line 559
    .end local v1    # "ext":Ltv/freewheel/extension/IExtension;
    :cond_0
    :goto_0
    invoke-virtual {p0, v3, v2, p1}, Ltv/freewheel/ad/AdContext;->onExtensionLoaded(ZLjava/lang/String;Ljava/lang/String;)V

    .line 563
    .end local v2    # "msg":Ljava/lang/String;
    .end local v3    # "success":Z
    :goto_1
    return-void

    .line 552
    .restart local v2    # "msg":Ljava/lang/String;
    .restart local v3    # "success":Z
    :catch_0
    move-exception v0

    .line 553
    .local v0, "e":Ljava/lang/IllegalAccessException;
    const/4 v3, 0x0

    .line 554
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 558
    goto :goto_0

    .line 555
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v0

    .line 556
    .local v0, "e":Ljava/lang/InstantiationException;
    const/4 v3, 0x0

    .line 557
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->getMessage()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 561
    .end local v0    # "e":Ljava/lang/InstantiationException;
    .end local v2    # "msg":Ljava/lang/String;
    .end local v3    # "success":Z
    :cond_1
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onExtensionLoaded(ZLjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "success"    # Z
    .param p2, "msg"    # Ljava/lang/String;
    .param p3, "moduleName"    # Ljava/lang/String;

    .prologue
    .line 974
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 975
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "moduleName"

    invoke-virtual {v0, v1, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 976
    if-eqz p1, :cond_0

    .line 977
    const-string v1, "message"

    const-string v2, "extension loaded"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 978
    const-string v1, "success"

    const-string v2, "true"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 983
    :goto_0
    new-instance v1, Ltv/freewheel/utils/events/Event;

    const-string v2, "extensionLoaded"

    invoke-direct {v1, v2, v0}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {p0, v1}, Ltv/freewheel/ad/AdContext;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 984
    return-void

    .line 980
    :cond_0
    const-string v1, "message"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 981
    const-string v1, "success"

    const-string v2, "false"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public requestContentPause(Ltv/freewheel/ad/slot/Slot;)V
    .locals 3
    .param p1, "slot"    # Ltv/freewheel/ad/slot/Slot;

    .prologue
    .line 910
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 911
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v0, v0, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    iget-object v0, v0, Ltv/freewheel/ad/VideoAsset;->state:Ltv/freewheel/ad/state/VideoState;

    invoke-static {}, Ltv/freewheel/ad/state/VideoPlayingState;->Instance()Ltv/freewheel/ad/state/VideoState;

    move-result-object v1

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v0, v0, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    iget-object v0, v0, Ltv/freewheel/ad/VideoAsset;->state:Ltv/freewheel/ad/state/VideoState;

    invoke-static {}, Ltv/freewheel/ad/state/VideoPendingState;->Instance()Ltv/freewheel/ad/state/VideoState;

    move-result-object v1

    if-ne v0, v1, :cond_1

    .line 912
    :cond_0
    new-instance v0, Ltv/freewheel/utils/events/Event;

    const-string v1, "requestContentVideoPause"

    iget-object v2, p1, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/AdContext;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 916
    :goto_0
    return-void

    .line 914
    :cond_1
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "ignore since main video is not in playing state"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public requestContentResume(Ltv/freewheel/ad/slot/Slot;)V
    .locals 7
    .param p1, "slot"    # Ltv/freewheel/ad/slot/Slot;

    .prologue
    .line 919
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 920
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 922
    .local v3, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/slot/Slot;>;"
    invoke-virtual {p0}, Ltv/freewheel/ad/AdContext;->getTemporalSlots()Ljava/util/ArrayList;

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

    check-cast v2, Ltv/freewheel/ad/interfaces/ISlot;

    .line 923
    .local v2, "s":Ltv/freewheel/ad/interfaces/ISlot;
    check-cast v2, Ltv/freewheel/ad/slot/Slot;

    .end local v2    # "s":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 925
    :cond_0
    invoke-virtual {p0}, Ltv/freewheel/ad/AdContext;->getVideoPlayerNonTemporalSlots()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/interfaces/ISlot;

    .line 926
    .restart local v2    # "s":Ltv/freewheel/ad/interfaces/ISlot;
    check-cast v2, Ltv/freewheel/ad/slot/Slot;

    .end local v2    # "s":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 928
    :cond_1
    invoke-virtual {p0}, Ltv/freewheel/ad/AdContext;->getSiteSectionNonTemporalSlots()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/interfaces/ISlot;

    .line 929
    .restart local v2    # "s":Ltv/freewheel/ad/interfaces/ISlot;
    check-cast v2, Ltv/freewheel/ad/slot/Slot;

    .end local v2    # "s":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 931
    :cond_2
    const/4 v0, 0x0

    .line 932
    .local v0, "hasOtherSlotPauseContent":Z
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/slot/Slot;

    .line 933
    .local v2, "s":Ltv/freewheel/ad/slot/Slot;
    iget-boolean v4, v2, Ltv/freewheel/ad/slot/Slot;->requestContentPause:Z

    if-eqz v4, :cond_3

    .line 934
    const/4 v0, 0x1

    .line 938
    .end local v2    # "s":Ltv/freewheel/ad/slot/Slot;
    :cond_4
    if-nez v0, :cond_6

    .line 939
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    iget-object v4, v4, Ltv/freewheel/ad/VideoAsset;->state:Ltv/freewheel/ad/state/VideoState;

    invoke-static {}, Ltv/freewheel/ad/state/VideoPausedState;->Instance()Ltv/freewheel/ad/state/VideoState;

    move-result-object v5

    if-ne v4, v5, :cond_5

    .line 940
    new-instance v4, Ltv/freewheel/utils/events/Event;

    const-string v5, "requestContentVideoResume"

    iget-object v6, p1, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-direct {v4, v5, v6}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v4}, Ltv/freewheel/ad/AdContext;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 947
    :goto_3
    return-void

    .line 942
    :cond_5
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "ignore since main video is in playing state"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_3

    .line 945
    :cond_6
    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "ignore since other slot need content video pause"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_3
.end method

.method public setActivity(Landroid/app/Activity;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 759
    if-eqz p1, :cond_0

    .line 760
    invoke-static {p1}, Ltv/freewheel/utils/Logger;->overrideLogLevel(Landroid/app/Activity;)V

    .line 761
    iput-object p1, p0, Ltv/freewheel/ad/AdContext;->hostActivity:Landroid/app/Activity;

    .line 764
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

    .line 768
    .local v0, "appVersion":Ljava/lang/String;
    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->userAgent:Ljava/lang/String;

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

    iput-object v2, p0, Ltv/freewheel/ad/AdContext;->userAgent:Ljava/lang/String;

    .line 769
    iget-object v2, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "UserAgent:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/ad/AdContext;->userAgent:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 771
    .end local v0    # "appVersion":Ljava/lang/String;
    :cond_0
    return-void

    .line 765
    :catch_0
    move-exception v1

    .line 766
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
    .line 273
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 274
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->capabilities:Ltv/freewheel/ad/Capabilities;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/ad/Capabilities;->setCapability(Ljava/lang/String;I)V

    .line 275
    return-void
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/Object;I)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "level"    # I

    .prologue
    .line 383
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    invoke-virtual {v0, p1, p2, p3}, Ltv/freewheel/ad/AdRequest;->setParameter(Ljava/lang/String;Ljava/lang/Object;I)V

    .line 384
    return-void
.end method

.method public setProfile(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "playerProfile"    # Ljava/lang/String;
    .param p2, "defaultTemporalSlotProfile"    # Ljava/lang/String;
    .param p3, "defaultVideoPlayerSlotProfile"    # Ljava/lang/String;
    .param p4, "defaultSiteSectionSlotProfile"    # Ljava/lang/String;

    .prologue
    .line 252
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "setProfile "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 253
    iput-object p1, p0, Ltv/freewheel/ad/AdContext;->playerProfile:Ljava/lang/String;

    .line 254
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .end local p2    # "defaultTemporalSlotProfile":Ljava/lang/String;
    :goto_0
    iput-object p2, p0, Ltv/freewheel/ad/AdContext;->defaultTemporalSlotProfile:Ljava/lang/String;

    .line 255
    iput-object p3, p0, Ltv/freewheel/ad/AdContext;->defaultVideoPlayerSlotProfile:Ljava/lang/String;

    .line 256
    iput-object p4, p0, Ltv/freewheel/ad/AdContext;->defaultSiteSectionSlotProfile:Ljava/lang/String;

    .line 257
    return-void

    .restart local p2    # "defaultTemporalSlotProfile":Ljava/lang/String;
    :cond_0
    move-object p2, p1

    .line 254
    goto :goto_0
.end method

.method public setSiteSection(Ljava/lang/String;IIII)V
    .locals 6
    .param p1, "siteSectionId"    # Ljava/lang/String;
    .param p2, "pageViewRandom"    # I
    .param p3, "networkId"    # I
    .param p4, "idType"    # I
    .param p5, "fallbackId"    # I

    .prologue
    .line 279
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "setSiteSection "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 281
    invoke-direct {p0, p4}, Ltv/freewheel/ad/AdContext;->checkIdType(I)I

    move-result p4

    .line 282
    iget-object v0, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Ltv/freewheel/ad/AdRequest;->setSiteSection(Ljava/lang/String;IIII)V

    .line 284
    return-void
.end method

.method public setVideoAsset(Ljava/lang/String;DLjava/lang/String;IIIIII)V
    .locals 14
    .param p1, "videoAssetId"    # Ljava/lang/String;
    .param p2, "duration"    # D
    .param p4, "videoLocation"    # Ljava/lang/String;
    .param p5, "autoPlayType"    # I
    .param p6, "videoPlayRandom"    # I
    .param p7, "networkId"    # I
    .param p8, "idType"    # I
    .param p9, "fallbackId"    # I
    .param p10, "durationType"    # I

    .prologue
    .line 294
    iget-object v2, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "setVideoAsset "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-wide/from16 v0, p2

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p4

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p5

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p6

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p7

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p8

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p9

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p10

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 297
    move/from16 v0, p8

    invoke-direct {p0, v0}, Ltv/freewheel/ad/AdContext;->checkIdType(I)I

    move-result p8

    .line 298
    iget-object v2, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    if-eqz p5, :cond_0

    const/4 v7, 0x1

    :goto_0
    move-object v3, p1

    move-wide/from16 v4, p2

    move-object/from16 v6, p4

    move/from16 v8, p6

    move/from16 v9, p7

    move/from16 v10, p8

    move/from16 v11, p9

    move/from16 v12, p10

    move/from16 v13, p5

    invoke-virtual/range {v2 .. v13}, Ltv/freewheel/ad/AdRequest;->setVideoAsset(Ljava/lang/String;DLjava/lang/String;ZIIIIII)V

    .line 301
    return-void

    .line 298
    :cond_0
    const/4 v7, 0x0

    goto :goto_0
.end method

.method public submitRequest(D)V
    .locals 3
    .param p1, "timeoutSeconds"    # D

    .prologue
    .line 566
    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Ltv/freewheel/ad/AdContext;->submitRequest(DD)V

    .line 567
    return-void
.end method

.method public submitRequest(DD)V
    .locals 11
    .param p1, "timeoutSeconds"    # D
    .param p3, "maxDelayBeforeRequest"    # D

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 570
    const-wide v4, 0x408f400000000000L    # 1000.0

    mul-double/2addr v4, p3

    double-to-long v0, v4

    .line 571
    .local v0, "delayMs":J
    iget-boolean v3, p0, Ltv/freewheel/ad/AdContext;->requestSubmitted:Z

    if-eqz v3, :cond_1

    .line 572
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    const-string v4, "Each AdContext instance can only submit ad request once."

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 650
    :cond_0
    :goto_0
    return-void

    .line 575
    :cond_1
    iput-boolean v8, p0, Ltv/freewheel/ad/AdContext;->requestSubmitted:Z

    .line 577
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    const-string v4, "^\\w+:.*"

    invoke-virtual {v3, v4}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 578
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "submitRequest to local file: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 579
    new-instance v3, Ltv/freewheel/ad/AdContext$3;

    invoke-direct {v3, p0, v0, v1}, Ltv/freewheel/ad/AdContext$3;-><init>(Ltv/freewheel/ad/AdContext;J)V

    invoke-virtual {v3}, Ltv/freewheel/ad/AdContext$3;->start()V

    goto :goto_0

    .line 615
    :cond_2
    const-string v3, "skipsAdSelection"

    invoke-virtual {p0, v3, v8}, Ltv/freewheel/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    .line 617
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    invoke-virtual {v3}, Ltv/freewheel/ad/AdRequest;->hasVideoAsset()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 618
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    iget-boolean v3, v3, Ltv/freewheel/ad/AdRequest;->videoViewCallbackRequested:Z

    if-eqz v3, :cond_4

    .line 619
    const-string v3, "requiresVideoCallbackUrl"

    invoke-virtual {p0, v3, v8}, Ltv/freewheel/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    .line 629
    :goto_1
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->geoLocation:Landroid/location/Location;

    if-eqz v3, :cond_3

    .line 630
    const-string v3, "ltlg"

    const-string v4, "%.4f,%.4f"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p0, Ltv/freewheel/ad/AdContext;->geoLocation:Landroid/location/Location;

    invoke-virtual {v6}, Landroid/location/Location;->getLatitude()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    aput-object v6, v5, v9

    iget-object v6, p0, Ltv/freewheel/ad/AdContext;->geoLocation:Landroid/location/Location;

    invoke-virtual {v6}, Landroid/location/Location;->getLongitude()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Ltv/freewheel/ad/AdContext;->addKeyValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 633
    :cond_3
    invoke-virtual {p0}, Ltv/freewheel/ad/AdContext;->buildRequest()Ltv/freewheel/utils/URLRequest;

    move-result-object v2

    .line 635
    .local v2, "req":Ltv/freewheel/utils/URLRequest;
    if-eqz v2, :cond_0

    .line 636
    iput-wide v0, v2, Ltv/freewheel/utils/URLRequest;->delayMs:J

    .line 637
    new-instance v3, Ltv/freewheel/utils/URLLoader;

    invoke-direct {v3}, Ltv/freewheel/utils/URLLoader;-><init>()V

    iput-object v3, p0, Ltv/freewheel/ad/AdContext;->requestLoader:Ltv/freewheel/utils/URLLoader;

    .line 639
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->requestLoader:Ltv/freewheel/utils/URLLoader;

    const-string v4, "URLLoader.Load.Complete"

    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->adLoadCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    invoke-virtual {v3, v4, v5}, Ltv/freewheel/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 641
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->requestLoader:Ltv/freewheel/utils/URLLoader;

    const-string v4, "URLLoader.Load.Error"

    iget-object v5, p0, Ltv/freewheel/ad/AdContext;->adLoadFailedListener:Ltv/freewheel/ad/interfaces/IEventListener;

    invoke-virtual {v3, v4, v5}, Ltv/freewheel/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 644
    const-wide/16 v4, 0x0

    cmpg-double v3, p1, v4

    if-gtz v3, :cond_6

    .line 645
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->requestLoader:Ltv/freewheel/utils/URLLoader;

    invoke-virtual {v3, v2}, Ltv/freewheel/utils/URLLoader;->load(Ltv/freewheel/utils/URLRequest;)V

    goto/16 :goto_0

    .line 621
    .end local v2    # "req":Ltv/freewheel/utils/URLRequest;
    :cond_4
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    iput-boolean v8, v3, Ltv/freewheel/ad/AdRequest;->videoViewCallbackRequested:Z

    .line 622
    const-string v3, "requiresVideoCallbackUrl"

    invoke-virtual {p0, v3, v9}, Ltv/freewheel/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    goto :goto_1

    .line 625
    :cond_5
    const-string v3, "requiresVideoCallbackUrl"

    invoke-virtual {p0, v3, v8}, Ltv/freewheel/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    goto :goto_1

    .line 647
    .restart local v2    # "req":Ltv/freewheel/utils/URLRequest;
    :cond_6
    iget-object v3, p0, Ltv/freewheel/ad/AdContext;->requestLoader:Ltv/freewheel/utils/URLLoader;

    invoke-virtual {v3, v2, p1, p2}, Ltv/freewheel/utils/URLLoader;->load(Ltv/freewheel/utils/URLRequest;D)V

    goto/16 :goto_0
.end method
