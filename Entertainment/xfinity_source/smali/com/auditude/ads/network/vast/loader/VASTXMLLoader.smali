.class public Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;
.super Lcom/auditude/ads/util/event/EventDispatcher;
.source "VASTXMLLoader.java"

# interfaces
.implements Lcom/auditude/ads/util/event/IEventListener;


# instance fields
.field public State:Ljava/lang/Object;

.field private document:Lcom/auditude/ads/network/vast/model/VASTDocument;

.field private error:Ljava/lang/Throwable;

.field private fallbackOnInvalidCreative:Ljava/lang/Boolean;

.field private httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

.field private maxNumWrapperRedirects:I

.field private mimeTypes:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

.field private vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;


# direct methods
.method public constructor <init>(ILjava/util/ArrayList;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;Ljava/lang/Boolean;)V
    .locals 2
    .param p1, "maxNumWrapperRedirects"    # I
    .param p3, "vastAssetRepackagerInfo"    # Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;
    .param p4, "fallbackOnInvalidCreative"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;",
            "Ljava/lang/Boolean;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 35
    invoke-direct {p0}, Lcom/auditude/ads/util/event/EventDispatcher;-><init>()V

    .line 27
    const/4 v0, 0x6

    iput v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->maxNumWrapperRedirects:I

    .line 28
    iput-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->mimeTypes:Ljava/util/ArrayList;

    .line 29
    iput-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    .line 30
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    .line 37
    iput p1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->maxNumWrapperRedirects:I

    .line 38
    iput-object p2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->mimeTypes:Ljava/util/ArrayList;

    .line 39
    iput-object p3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    .line 40
    iput-object p4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    .line 41
    return-void
.end method

.method static synthetic access$0(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->maxNumWrapperRedirects:I

    return v0
.end method

.method static synthetic access$1(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->mimeTypes:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$2(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    return-object v0
.end method

.method static synthetic access$3(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$4(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    return-void
.end method

.method static synthetic access$5(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    return-object v0
.end method

.method static synthetic access$6(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->error:Ljava/lang/Throwable;

    return-void
.end method

.method static synthetic access$7(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;)V
    .locals 0

    .prologue
    .line 106
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->notifyRequestFailed()V

    return-void
.end method

.method private notifyRequestFailed()V
    .locals 2

    .prologue
    .line 108
    const-string v0, "failed"

    new-instance v1, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v1, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 109
    return-void
.end method

.method private onDocumentProcessComplete(Ljava/lang/Object;)V
    .locals 3
    .param p1, "sender"    # Ljava/lang/Object;

    .prologue
    .line 136
    instance-of v1, p1, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    if-eqz v1, :cond_1

    move-object v0, p1

    :goto_0
    check-cast v0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    .line 137
    .local v0, "processor":Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
    if-eqz v0, :cond_0

    .line 139
    const-string v1, "processComplete"

    invoke-virtual {v0, v1, p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 140
    const-string v1, "processFailed"

    invoke-virtual {v0, v1, p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 141
    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v1

    iput-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 143
    :cond_0
    const-string v1, "complete"

    new-instance v2, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v2, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v1, v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 144
    return-void

    .line 136
    .end local v0    # "processor":Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private onDocumentProcessFailed(Ljava/lang/Object;)V
    .locals 3
    .param p1, "sender"    # Ljava/lang/Object;

    .prologue
    .line 148
    instance-of v1, p1, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    if-eqz v1, :cond_0

    move-object v0, p1

    :goto_0
    check-cast v0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    .line 150
    .local v0, "processor":Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
    const-string v1, "processComplete"

    invoke-virtual {v0, v1, p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 151
    const-string v1, "processFailed"

    invoke-virtual {v0, v1, p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 153
    const-string v1, "complete"

    new-instance v2, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v2, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v1, v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 154
    return-void

    .line 148
    .end local v0    # "processor":Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    return-object v0
.end method

.method public final init(Ljava/lang/Object;)V
    .locals 7
    .param p1, "source"    # Ljava/lang/Object;

    .prologue
    .line 49
    instance-of v2, p1, Ljava/lang/String;

    if-eqz v2, :cond_0

    move-object v2, p1

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 51
    move-object v1, p0

    .line 52
    .local v1, "that":Lcom/auditude/ads/util/event/IEventListener;
    new-instance v0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;

    invoke-direct {v0, p0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader$1;-><init>(Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 84
    .local v0, "handler":Landroid/os/Handler;
    new-instance v2, Lcom/auditude/ads/util/http/AsyncHttpConnection;

    invoke-direct {v2, v0}, Lcom/auditude/ads/util/http/AsyncHttpConnection;-><init>(Landroid/os/Handler;)V

    iput-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

    .line 85
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

    check-cast p1, Ljava/lang/String;

    .end local p1    # "source":Ljava/lang/Object;
    invoke-static {p1}, Lcom/auditude/ads/util/AuditudeUtil;->substituteTags(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v4

    invoke-virtual {v4}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/auditude/ads/core/AdSettings;->getPassThroughParams()Ljava/util/HashMap;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/auditude/ads/util/AuditudeUtil;->substituteCustomPublisherTags(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->get(Ljava/lang/String;)V

    .line 104
    .end local v0    # "handler":Landroid/os/Handler;
    .end local v1    # "that":Lcom/auditude/ads/util/event/IEventListener;
    :goto_0
    return-void

    .line 87
    .restart local p1    # "source":Ljava/lang/Object;
    :cond_0
    instance-of v2, p1, Lcom/auditude/ads/network/vast/model/VASTDocument;

    if-eqz v2, :cond_2

    if-eqz p1, :cond_2

    .line 89
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    instance-of v2, v2, Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v2, :cond_1

    move-object v2, p1

    .line 91
    check-cast v2, Lcom/auditude/ads/network/vast/model/VASTDocument;

    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    check-cast v3, Lcom/auditude/ads/network/vast/model/VASTAd;

    iput-object v3, v2, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 93
    :cond_1
    move-object v1, p0

    .line 94
    .restart local v1    # "that":Lcom/auditude/ads/util/event/IEventListener;
    new-instance v2, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    iget v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->maxNumWrapperRedirects:I

    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->mimeTypes:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;-><init>(ILjava/util/ArrayList;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;Ljava/lang/Boolean;)V

    iput-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    .line 95
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    const-string v3, "processComplete"

    invoke-virtual {v2, v3, v1}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 96
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    const-string v3, "processFailed"

    invoke-virtual {v2, v3, v1}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 97
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->processor:Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;

    check-cast p1, Lcom/auditude/ads/network/vast/model/VASTDocument;

    .end local p1    # "source":Ljava/lang/Object;
    invoke-virtual {v2, p1}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->process(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    goto :goto_0

    .line 102
    .end local v1    # "that":Lcom/auditude/ads/util/event/IEventListener;
    .restart local p1    # "source":Ljava/lang/Object;
    :cond_2
    const/4 v2, 0x0

    invoke-direct {p0, v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->onDocumentProcessComplete(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 113
    instance-of v0, p2, Lcom/auditude/ads/util/event/Event;

    if-eqz v0, :cond_2

    .line 115
    const-string v0, "processComplete"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 117
    check-cast p2, Lcom/auditude/ads/util/event/Event;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-virtual {p2}, Lcom/auditude/ads/util/event/Event;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->onDocumentProcessComplete(Ljava/lang/Object;)V

    .line 132
    :goto_0
    return-void

    .line 119
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_0
    const-string v0, "processFailed"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 121
    check-cast p2, Lcom/auditude/ads/util/event/Event;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-virtual {p2}, Lcom/auditude/ads/util/event/Event;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->onDocumentProcessFailed(Ljava/lang/Object;)V

    goto :goto_0

    .line 125
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_1
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->notifyRequestFailed()V

    goto :goto_0

    .line 130
    :cond_2
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->notifyRequestFailed()V

    goto :goto_0
.end method
