.class public Lcom/comcast/playerplatform/drm/java/service/SessionService;
.super Ljava/lang/Object;
.source "SessionService.java"


# instance fields
.field private clientSessionRequest:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

.field private clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

.field protected drmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

.field private listeners:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 2
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;

    .line 26
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;-><init>(Lcom/comcast/playerplatform/drm/java/service/SessionService;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService;->drmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .line 84
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    .line 85
    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService;->drmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    invoke-direct {v0, p1, p3, v1, p2}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService;->clientSessionRequest:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .line 86
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/service/SessionService;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;

    return-object v0
.end method


# virtual methods
.method public addEventListeners(Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;)V
    .locals 1
    .param p1, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 124
    return-void
.end method

.method public create()V
    .locals 1

    .prologue
    .line 92
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->create(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 93
    return-void
.end method

.method public create(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 1
    .param p1, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 100
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService;->clientSessionRequest:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->create(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 101
    return-void
.end method
