.class public Ltv/freewheel/extension/pausead/PauseAdExtension;
.super Ljava/lang/Object;
.source "PauseAdExtension.java"

# interfaces
.implements Ltv/freewheel/extension/IExtension;


# instance fields
.field private adContext:Ltv/freewheel/ad/interfaces/IAdContext;

.field adErrorListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field adImpressionListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field private constants:Ltv/freewheel/ad/interfaces/IConstants;

.field private currentPlayingPauseSlotCustomId:Ljava/lang/String;

.field private enabled:Ljava/lang/Boolean;

.field private linearSlotToPauseSlotsMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private logger:Ltv/freewheel/utils/Logger;

.field private needDispatchContentResumeEvent:Ljava/lang/Boolean;

.field requestCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field slotEndedListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field slotStartedListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field private toBePlayedPauseSlotCustomId:Ljava/lang/String;

.field userActionNotified:Ltv/freewheel/ad/interfaces/IEventListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->needDispatchContentResumeEvent:Ljava/lang/Boolean;

    .line 37
    new-instance v0, Ltv/freewheel/extension/pausead/PauseAdExtension$1;

    invoke-direct {v0, p0}, Ltv/freewheel/extension/pausead/PauseAdExtension$1;-><init>(Ltv/freewheel/extension/pausead/PauseAdExtension;)V

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->requestCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 94
    new-instance v0, Ltv/freewheel/extension/pausead/PauseAdExtension$2;

    invoke-direct {v0, p0}, Ltv/freewheel/extension/pausead/PauseAdExtension$2;-><init>(Ltv/freewheel/extension/pausead/PauseAdExtension;)V

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->userActionNotified:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 121
    new-instance v0, Ltv/freewheel/extension/pausead/PauseAdExtension$3;

    invoke-direct {v0, p0}, Ltv/freewheel/extension/pausead/PauseAdExtension$3;-><init>(Ltv/freewheel/extension/pausead/PauseAdExtension;)V

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->slotStartedListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 136
    new-instance v0, Ltv/freewheel/extension/pausead/PauseAdExtension$4;

    invoke-direct {v0, p0}, Ltv/freewheel/extension/pausead/PauseAdExtension$4;-><init>(Ltv/freewheel/extension/pausead/PauseAdExtension;)V

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->slotEndedListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 151
    new-instance v0, Ltv/freewheel/extension/pausead/PauseAdExtension$5;

    invoke-direct {v0, p0}, Ltv/freewheel/extension/pausead/PauseAdExtension$5;-><init>(Ltv/freewheel/extension/pausead/PauseAdExtension;)V

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->adImpressionListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 161
    new-instance v0, Ltv/freewheel/extension/pausead/PauseAdExtension$6;

    invoke-direct {v0, p0}, Ltv/freewheel/extension/pausead/PauseAdExtension$6;-><init>(Ltv/freewheel/extension/pausead/PauseAdExtension;)V

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->adErrorListener:Ltv/freewheel/ad/interfaces/IEventListener;

    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/extension/pausead/PauseAdExtension;)Ltv/freewheel/ad/interfaces/IConstants;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;

    .prologue
    .line 17
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    return-object v0
.end method

.method static synthetic access$100(Ltv/freewheel/extension/pausead/PauseAdExtension;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;

    .prologue
    .line 17
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/utils/Logger;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/extension/pausead/PauseAdExtension;)Ltv/freewheel/ad/interfaces/IAdContext;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;

    .prologue
    .line 17
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/extension/pausead/PauseAdExtension;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;

    .prologue
    .line 17
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->enabled:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$302(Ltv/freewheel/extension/pausead/PauseAdExtension;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 17
    iput-object p1, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->enabled:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic access$400(Ltv/freewheel/extension/pausead/PauseAdExtension;)Ljava/util/HashMap;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;

    .prologue
    .line 17
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->linearSlotToPauseSlotsMap:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$500(Ltv/freewheel/extension/pausead/PauseAdExtension;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;

    .prologue
    .line 17
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$502(Ltv/freewheel/extension/pausead/PauseAdExtension;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 17
    iput-object p1, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->toBePlayedPauseSlotCustomId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$600(Ltv/freewheel/extension/pausead/PauseAdExtension;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;

    .prologue
    .line 17
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$602(Ltv/freewheel/extension/pausead/PauseAdExtension;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 17
    iput-object p1, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$700(Ltv/freewheel/extension/pausead/PauseAdExtension;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;

    .prologue
    .line 17
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->needDispatchContentResumeEvent:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$702(Ltv/freewheel/extension/pausead/PauseAdExtension;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 17
    iput-object p1, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->needDispatchContentResumeEvent:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic access$800(Ltv/freewheel/extension/pausead/PauseAdExtension;Ltv/freewheel/ad/interfaces/IEvent;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/extension/pausead/PauseAdExtension;
    .param p1, "x1"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Ltv/freewheel/extension/pausead/PauseAdExtension;->isEventFromCurrentPlayingPauseSlot(Ltv/freewheel/ad/interfaces/IEvent;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method private isEventFromCurrentPlayingPauseSlot(Ltv/freewheel/ad/interfaces/IEvent;)Ljava/lang/Boolean;
    .locals 3
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 172
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->currentPlayingPauseSlotCustomId:Ljava/lang/String;

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_CUSTOM_ID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 174
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 176
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public init(Ltv/freewheel/ad/interfaces/IAdContext;)V
    .locals 3
    .param p1, "adContext"    # Ltv/freewheel/ad/interfaces/IAdContext;

    .prologue
    .line 29
    iput-object p1, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    .line 30
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IAdContext;->getConstants()Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 31
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/utils/Logger;

    .line 32
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "init"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 33
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->linearSlotToPauseSlotsMap:Ljava/util/HashMap;

    .line 34
    iget-object v0, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_REQUEST_COMPLETE()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/extension/pausead/PauseAdExtension;->requestCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 35
    return-void
.end method
