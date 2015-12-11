.class public Ltv/freewheel/ad/AdInstance;
.super Ltv/freewheel/ad/EventCallbackHolder;
.source "AdInstance.java"

# interfaces
.implements Ltv/freewheel/ad/interfaces/IAdInstance;
.implements Ltv/freewheel/renderers/interfaces/IRendererContext;


# instance fields
.field public ad:Ltv/freewheel/ad/Ad;

.field public adChain:Ltv/freewheel/ad/AdChain;

.field private adRenderer:Ltv/freewheel/ad/AdRenderer;

.field private additionalErrorInfo:Ljava/lang/String;

.field public callbackManager:Ltv/freewheel/ad/CallbackManager;

.field public companionAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/AdInstance;",
            ">;"
        }
    .end annotation
.end field

.field public creative:Ltv/freewheel/ad/Creative;

.field public creativeRenditionId:I

.field private duration:D

.field private fallbackAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/AdInstance;",
            ">;"
        }
    .end annotation
.end field

.field public imprSent:Z

.field public isCompanionAdOfPauseAd:Z

.field private metrValue:I

.field public pauseWhenLoading:Z

.field private primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

.field public renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

.field protected final rendererLoadHandler:Landroid/os/Handler;

.field public rendererState:Ltv/freewheel/ad/state/RendererState;

.field public replicaId:I

.field private resellerNoAdDispatched:Z

.field public scheduledDrivingAd:Z

.field public slot:Ltv/freewheel/ad/slot/Slot;

.field public state:Ltv/freewheel/ad/state/AdState;

.field private translatedAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdContext;)V
    .locals 3
    .param p1, "context"    # Ltv/freewheel/ad/AdContext;

    .prologue
    const/4 v2, 0x0

    .line 67
    invoke-direct {p0, p1}, Ltv/freewheel/ad/EventCallbackHolder;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 50
    iput-boolean v2, p0, Ltv/freewheel/ad/AdInstance;->isCompanionAdOfPauseAd:Z

    .line 54
    const-string v0, ""

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->additionalErrorInfo:Ljava/lang/String;

    .line 59
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    iput-wide v0, p0, Ltv/freewheel/ad/AdInstance;->duration:D

    .line 60
    iput-boolean v2, p0, Ltv/freewheel/ad/AdInstance;->resellerNoAdDispatched:Z

    .line 62
    iput-boolean v2, p0, Ltv/freewheel/ad/AdInstance;->imprSent:Z

    .line 63
    iput-boolean v2, p0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    .line 64
    iput-boolean v2, p0, Ltv/freewheel/ad/AdInstance;->pauseWhenLoading:Z

    .line 702
    new-instance v0, Ltv/freewheel/ad/AdInstance$2;

    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Ltv/freewheel/ad/AdInstance$2;-><init>(Ltv/freewheel/ad/AdInstance;Landroid/os/Looper;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->rendererLoadHandler:Landroid/os/Handler;

    .line 68
    invoke-static {}, Ltv/freewheel/ad/state/AdInitState;->Instance()Ltv/freewheel/ad/state/AdState;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    .line 69
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->fallbackAds:Ljava/util/ArrayList;

    .line 71
    iput v2, p0, Ltv/freewheel/ad/AdInstance;->metrValue:I

    .line 72
    new-instance v0, Ltv/freewheel/ad/CallbackManager;

    invoke-direct {v0, p0}, Ltv/freewheel/ad/CallbackManager;-><init>(Ltv/freewheel/ad/AdInstance;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    .line 73
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/ad/AdInstance;
    .param p1, "x1"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Ltv/freewheel/ad/AdInstance;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    return-void
.end method

.method static synthetic access$102(Ltv/freewheel/ad/AdInstance;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/ad/AdInstance;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Ltv/freewheel/ad/AdInstance;->additionalErrorInfo:Ljava/lang/String;

    return-object p1
.end method

.method private commitAdInstances()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    .line 859
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " commitAdInstances()"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 861
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    if-eqz v8, :cond_0

    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-nez v8, :cond_1

    .line 862
    :cond_0
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "commitAdInstances() nothing to commit, translatedAds is empty."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 924
    :goto_0
    return-void

    .line 865
    :cond_1
    const/4 v7, 0x0

    .line 867
    .local v7, "translatedDriver":Ltv/freewheel/ad/AdInstance;
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    invoke-virtual {v8}, Ltv/freewheel/ad/AdRenderer;->isTranslator()Z

    move-result v5

    .line 869
    .local v5, "isTranslator":Z
    if-eqz v5, :cond_3

    .line 870
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 871
    .local v6, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    :cond_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 872
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/AdInstance;

    .line 873
    .local v0, "ad":Ltv/freewheel/ad/AdInstance;
    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v8

    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v9

    if-ne v8, v9, :cond_2

    .line 874
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "committing driving ad "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 875
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v8, v0, p0}, Ltv/freewheel/ad/AdChain;->insertAfter(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/AdInstance;)V

    .line 876
    move-object v7, v0

    .line 877
    iput-boolean v11, p0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    .line 883
    .end local v0    # "ad":Ltv/freewheel/ad/AdInstance;
    .end local v6    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    :cond_3
    if-nez v7, :cond_4

    .line 885
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    invoke-virtual {v8}, Ltv/freewheel/ad/AdRenderer;->isTranslator()Z

    move-result v8

    if-eqz v8, :cond_7

    .line 886
    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->cloneForTranslation()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/AdInstance;

    .line 887
    .local v2, "emptyDrivingAd":Ltv/freewheel/ad/AdInstance;
    invoke-virtual {v2}, Ltv/freewheel/ad/AdInstance;->createCreativeRenditionForTranslation()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v3

    check-cast v3, Ltv/freewheel/ad/CreativeRendition;

    .line 888
    .local v3, "emptyRendition":Ltv/freewheel/ad/CreativeRendition;
    const-string v8, "null/null"

    invoke-virtual {v3, v8}, Ltv/freewheel/ad/CreativeRendition;->setContentType(Ljava/lang/String;)V

    .line 889
    iput-object v3, v2, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    .line 890
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v8, v2, p0}, Ltv/freewheel/ad/AdChain;->insertAfter(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/AdInstance;)V

    .line 891
    move-object v7, v2

    .line 892
    iput-boolean v11, p0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    .line 893
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "committing empty driving ad "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, v2, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    iget-boolean v10, v10, Ltv/freewheel/ad/Ad;->noLoad:Z

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 902
    .end local v2    # "emptyDrivingAd":Ltv/freewheel/ad/AdInstance;
    .end local v3    # "emptyRendition":Ltv/freewheel/ad/CreativeRendition;
    :cond_4
    :goto_1
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 903
    .restart local v6    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    :cond_5
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_9

    .line 904
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/AdInstance;

    .line 905
    .local v1, "companionAd":Ltv/freewheel/ad/AdInstance;
    if-eq v7, v1, :cond_5

    .line 906
    iget-object v8, v1, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    invoke-virtual {v8}, Ltv/freewheel/ad/slot/Slot;->getType()I

    move-result v8

    if-eqz v8, :cond_8

    .line 907
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "commitAdInstances: committing companion ad: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 908
    invoke-virtual {v1}, Ltv/freewheel/ad/AdInstance;->getAllCreativeRenditions()Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_6

    .line 909
    iget-object v8, v1, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    iput-boolean v11, v8, Ltv/freewheel/ad/Ad;->noLoad:Z

    .line 910
    :cond_6
    iget-object v8, v7, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 897
    .end local v1    # "companionAd":Ltv/freewheel/ad/AdInstance;
    .end local v6    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    :cond_7
    move-object v7, p0

    goto :goto_1

    .line 912
    .restart local v1    # "companionAd":Ltv/freewheel/ad/AdInstance;
    .restart local v6    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    :cond_8
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v9, "commitAdInstances: got a translated ad which is neither driving nor nontemporal."

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_2

    .line 917
    .end local v1    # "companionAd":Ltv/freewheel/ad/AdInstance;
    :cond_9
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_3
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-ge v4, v8, :cond_b

    .line 918
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/AdInstance;

    .line 919
    .restart local v1    # "companionAd":Ltv/freewheel/ad/AdInstance;
    iget-object v8, v7, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-direct {p0, v8, v1}, Ltv/freewheel/ad/AdInstance;->containsAd(Ljava/util/ArrayList;Ltv/freewheel/ad/AdInstance;)Z

    move-result v8

    if-nez v8, :cond_a

    .line 920
    iget-object v8, v7, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 917
    :cond_a
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 923
    .end local v1    # "companionAd":Ltv/freewheel/ad/AdInstance;
    :cond_b
    const/4 v8, 0x0

    iput-object v8, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    goto/16 :goto_0
.end method

.method private containsAd(Ljava/util/ArrayList;Ltv/freewheel/ad/AdInstance;)Z
    .locals 3
    .param p2, "adInstance"    # Ltv/freewheel/ad/AdInstance;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/AdInstance;",
            ">;",
            "Ltv/freewheel/ad/AdInstance;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 927
    .local p1, "adInstances":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/AdInstance;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 928
    invoke-virtual {p2}, Ltv/freewheel/ad/AdInstance;->getAdId()I

    move-result v2

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v1}, Ltv/freewheel/ad/AdInstance;->getAdId()I

    move-result v1

    if-ne v2, v1, :cond_0

    .line 929
    const/4 v1, 0x1

    .line 932
    :goto_1
    return v1

    .line 927
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 932
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 6
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 622
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v3}, Ltv/freewheel/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v3

    if-nez v3, :cond_2

    .line 623
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v4, "Activity not registered. Run dispatchEvent on current thread."

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 634
    :cond_0
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v0

    .line 635
    .local v0, "eventName":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "process ad event:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 637
    const-string v3, "loaded"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 638
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v3, p0, p1}, Ltv/freewheel/ad/state/RendererState;->notifyLoaded(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 676
    .end local v0    # "eventName":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 624
    :cond_2
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v4}, Ltv/freewheel/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v4

    if-eq v3, v4, :cond_0

    .line 625
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Re-dispatchEvent "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " to main UI thread."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 626
    move-object v1, p1

    .line 627
    .local v1, "eventRef":Ltv/freewheel/ad/interfaces/IEvent;
    new-instance v3, Landroid/os/Handler;

    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v4}, Ltv/freewheel/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v4, Ltv/freewheel/ad/AdInstance$1;

    invoke-direct {v4, p0, v1}, Ltv/freewheel/ad/AdInstance$1;-><init>(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 639
    .end local v1    # "eventRef":Ltv/freewheel/ad/interfaces/IEvent;
    .restart local v0    # "eventName":Ljava/lang/String;
    :cond_3
    const-string v3, "started"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 640
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v3, p0, p1}, Ltv/freewheel/ad/state/RendererState;->notifyStarted(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 641
    :cond_4
    const-string v3, "stopped"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 642
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v3, p0, p1}, Ltv/freewheel/ad/state/RendererState;->notifyStopped(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 643
    :cond_5
    const-string v3, "_e_unknown"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 644
    invoke-direct {p0, p1}, Ltv/freewheel/ad/AdInstance;->onRendererError(Ltv/freewheel/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 645
    :cond_6
    const-string v3, "defaultClick"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 646
    invoke-direct {p0, p1}, Ltv/freewheel/ad/AdInstance;->onRendererClicked(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 647
    invoke-virtual {p0, v0}, Ltv/freewheel/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 648
    :cond_7
    const-string v3, "requestContentVideoPause"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 649
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    iget-boolean v3, v3, Ltv/freewheel/ad/slot/Slot;->requestContentPause:Z

    if-nez v3, :cond_1

    .line 650
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    invoke-virtual {v3, v4}, Ltv/freewheel/ad/AdContext;->requestContentPause(Ltv/freewheel/ad/slot/Slot;)V

    .line 651
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    const/4 v4, 0x1

    iput-boolean v4, v3, Ltv/freewheel/ad/slot/Slot;->requestContentPause:Z

    goto/16 :goto_0

    .line 653
    :cond_8
    const-string v3, "requestContentVideoResume"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 654
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    iget-boolean v3, v3, Ltv/freewheel/ad/slot/Slot;->requestContentPause:Z

    if-eqz v3, :cond_1

    .line 655
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    const/4 v4, 0x0

    iput-boolean v4, v3, Ltv/freewheel/ad/slot/Slot;->requestContentPause:Z

    .line 656
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    invoke-virtual {v3, v4}, Ltv/freewheel/ad/AdContext;->requestContentResume(Ltv/freewheel/ad/slot/Slot;)V

    goto/16 :goto_0

    .line 658
    :cond_9
    const-string v3, "bufferingStart"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    const-string v3, "bufferingEnd"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_b

    .line 661
    :cond_a
    invoke-virtual {p0, v0}, Ltv/freewheel/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 663
    :cond_b
    const-string v3, "firstQuartile"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    const-string v3, "midPoint"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    const-string v3, "thirdQuartile"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    const-string v3, "complete"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_e

    .line 667
    :cond_c
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    const-string v4, "IMPRESSION"

    invoke-virtual {v3, v0, v4}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/handler/QuartileCallbackHandler;

    .line 668
    .local v2, "handler":Ltv/freewheel/ad/handler/QuartileCallbackHandler;
    iget-boolean v3, v2, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->imprSent:Z

    if-nez v3, :cond_d

    .line 669
    invoke-virtual {p0, v0}, Ltv/freewheel/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    .line 674
    .end local v2    # "handler":Ltv/freewheel/ad/handler/QuartileCallbackHandler;
    :cond_d
    :goto_1
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    invoke-virtual {v3, v0}, Ltv/freewheel/ad/CallbackManager;->callback(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 672
    :cond_e
    invoke-virtual {p0, v0}, Ltv/freewheel/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private findRenderer(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/AdRenderer;
    .locals 8
    .param p1, "adUnit"    # Ljava/lang/String;
    .param p2, "soAdUnit"    # Ljava/lang/String;
    .param p3, "contentType"    # Ljava/lang/String;
    .param p4, "slotType"    # I
    .param p5, "creativeAPI"    # Ljava/lang/String;
    .param p6, "wrapperType"    # Ljava/lang/String;

    .prologue
    .line 416
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " findRenderer(adUnit:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ",soAdUnit:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ",contentType:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ",slotType:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ",creativeAPI:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ",wrapperType:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 418
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget-object v1, v1, Ltv/freewheel/ad/AdContext;->adRenderers:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .line 419
    .local v7, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/AdRenderer;>;"
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 420
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/AdRenderer;

    .line 421
    .local v0, "adRenderer":Ltv/freewheel/ad/AdRenderer;
    invoke-static {p4}, Ltv/freewheel/ad/slot/Slot;->slotTypeString(I)Ljava/lang/String;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Ltv/freewheel/ad/AdRenderer;->match(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 425
    .end local v0    # "adRenderer":Ltv/freewheel/ad/AdRenderer;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getAdRenderer()I
    .locals 11

    .prologue
    .line 239
    const/4 v10, -0x1

    .line 240
    .local v10, "ret":I
    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->getAllCreativeRenditions()Ljava/util/ArrayList;

    move-result-object v9

    .line 241
    .local v9, "renditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v8, v0, :cond_2

    .line 242
    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ltv/freewheel/ad/interfaces/ICreativeRendition;

    .line 243
    .local v7, "cr":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v3

    .line 245
    .local v3, "contentType":Ljava/lang/String;
    if-eqz v3, :cond_3

    const-string v0, "null/null"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "test/ad"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 247
    :cond_0
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    if-nez v0, :cond_1

    .line 248
    new-instance v0, Ltv/freewheel/ad/AdRenderer;

    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v0, v1}, Ltv/freewheel/ad/AdRenderer;-><init>(Ltv/freewheel/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    .line 249
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    iput-object v3, v0, Ltv/freewheel/ad/AdRenderer;->name:Ljava/lang/String;

    .line 251
    :cond_1
    const/4 v10, 0x0

    .line 265
    .end local v3    # "contentType":Ljava/lang/String;
    .end local v7    # "cr":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_2
    :goto_1
    return v10

    .line 255
    .restart local v3    # "contentType":Ljava/lang/String;
    .restart local v7    # "cr":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_3
    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getBaseUnit()Ljava/lang/String;

    move-result-object v1

    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    iget-object v2, v0, Ltv/freewheel/ad/Ad;->adUnit:Ljava/lang/String;

    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    iget v4, v0, Ltv/freewheel/ad/slot/Slot;->timePositionClass:I

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getWrapperType()Ljava/lang/String;

    move-result-object v6

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Ltv/freewheel/ad/AdInstance;->findRenderer(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/AdRenderer;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    .line 257
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    if-eqz v0, :cond_5

    .line 258
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    if-eq v7, v0, :cond_4

    .line 259
    invoke-virtual {p0, v7}, Ltv/freewheel/ad/AdInstance;->setActiveCreativeRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;)V

    .line 261
    :cond_4
    const/4 v10, 0x1

    .line 262
    goto :goto_1

    .line 241
    :cond_5
    add-int/lit8 v8, v8, 0x1

    goto :goto_0
.end method

.method private onRendererClicked(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 4
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 396
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "onRendererClicked"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 397
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v2

    const-string v3, "extraInfo"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    .line 398
    .local v1, "info":Landroid/os/Bundle;
    if-nez v1, :cond_0

    .line 399
    new-instance v1, Landroid/os/Bundle;

    .end local v1    # "info":Landroid/os/Bundle;
    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 401
    .restart local v1    # "info":Landroid/os/Bundle;
    :cond_0
    const-string v2, "message"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 402
    .local v0, "eventName":Ljava/lang/String;
    if-eqz v0, :cond_1

    const-string v2, "defaultClick"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 403
    :cond_1
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    if-eqz v2, :cond_2

    .line 404
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    invoke-virtual {v2, v1}, Ltv/freewheel/ad/handler/ClickCallbackHandler;->send(Landroid/os/Bundle;)V

    .line 412
    :goto_0
    return-void

    .line 406
    :cond_2
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "no default click callback"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 410
    :cond_3
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    invoke-virtual {v2, v0, v1}, Ltv/freewheel/ad/CallbackManager;->callback(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private onRendererError(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 4
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 377
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "onRendererError"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 378
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v2

    const-string v3, "extraInfo"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    .line 379
    .local v0, "info":Landroid/os/Bundle;
    const-string v2, "errorCode"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Ltv/freewheel/ad/AdInstance;->sendResellerNoAd(Ljava/lang/String;)V

    .line 382
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    if-eqz v2, :cond_0

    .line 383
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    iget-object v1, v2, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    .line 389
    .local v1, "moduleName":Ljava/lang/String;
    :goto_0
    const-string v2, "errorModule"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 390
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/ad/CallbackManager;->errorHandler:Ltv/freewheel/ad/handler/ErrorCallbackHandler;

    invoke-virtual {v2, v0}, Ltv/freewheel/ad/handler/ErrorCallbackHandler;->send(Landroid/os/Bundle;)V

    .line 391
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v2, p0}, Ltv/freewheel/ad/state/RendererState;->fail(Ltv/freewheel/ad/AdInstance;)V

    .line 392
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v2, p0}, Ltv/freewheel/ad/state/AdState;->fail(Ltv/freewheel/ad/AdInstance;)V

    .line 393
    return-void

    .line 386
    .end local v1    # "moduleName":Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "moduleName":Ljava/lang/String;
    goto :goto_0
.end method

.method private parseCompanionAds(Lorg/w3c/dom/Element;)V
    .locals 10
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 154
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 155
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v7

    if-ge v4, v7, :cond_3

    .line 156
    invoke-interface {v1, v4}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 157
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v7

    const/4 v8, 0x1

    if-ne v7, v8, :cond_1

    .line 158
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    .line 159
    .local v5, "name":Ljava/lang/String;
    iget-object v7, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "parse(), name: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 161
    const-string v7, "adReference"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 162
    new-instance v0, Ltv/freewheel/ad/AdInstance;

    iget-object v7, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v0, v7}, Ltv/freewheel/ad/AdInstance;-><init>(Ltv/freewheel/ad/AdContext;)V

    .local v0, "adInstance":Ltv/freewheel/ad/AdInstance;
    move-object v7, v2

    .line 163
    check-cast v7, Lorg/w3c/dom/Element;

    const-string v8, "adSlotCustomId"

    invoke-interface {v7, v8}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 165
    .local v6, "slotCustomId":Ljava/lang/String;
    iget-object v7, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v7, v6}, Ltv/freewheel/ad/AdContext;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v3

    check-cast v3, Ltv/freewheel/ad/slot/NonTemporalSlot;

    .line 166
    .local v3, "companionSlot":Ltv/freewheel/ad/slot/NonTemporalSlot;
    if-nez v3, :cond_0

    .line 167
    iget-object v7, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    invoke-virtual {v7, v6}, Ltv/freewheel/ad/AdRequest;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/ad/slot/Slot;

    move-result-object v3

    .end local v3    # "companionSlot":Ltv/freewheel/ad/slot/NonTemporalSlot;
    check-cast v3, Ltv/freewheel/ad/slot/NonTemporalSlot;

    .line 168
    .restart local v3    # "companionSlot":Ltv/freewheel/ad/slot/NonTemporalSlot;
    if-eqz v3, :cond_0

    .line 169
    invoke-virtual {v3}, Ltv/freewheel/ad/slot/NonTemporalSlot;->copy()Ltv/freewheel/ad/slot/NonTemporalSlot;

    move-result-object v3

    .line 170
    iget-object v7, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v7, v7, Ltv/freewheel/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v7, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 173
    :cond_0
    if-eqz v3, :cond_1

    .line 174
    iput-object v3, v0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    .line 175
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v0, v2}, Ltv/freewheel/ad/AdInstance;->parse(Lorg/w3c/dom/Element;)V

    .line 176
    iget-object v7, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 155
    .end local v0    # "adInstance":Ltv/freewheel/ad/AdInstance;
    .end local v3    # "companionSlot":Ltv/freewheel/ad/slot/NonTemporalSlot;
    .end local v5    # "name":Ljava/lang/String;
    .end local v6    # "slotCustomId":Ljava/lang/String;
    :cond_1
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 179
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v5    # "name":Ljava/lang/String;
    :cond_2
    iget-object v7, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "ignore node: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 183
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v5    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method private parseFallbackAds(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 123
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 125
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_2

    .line 126
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 127
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 128
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 129
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "parse(), name: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 131
    const-string v5, "adReference"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 132
    new-instance v0, Ltv/freewheel/ad/AdInstance;

    iget-object v5, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v0, v5}, Ltv/freewheel/ad/AdInstance;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 133
    .local v0, "adInstance":Ltv/freewheel/ad/AdInstance;
    iget-object v5, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    iput-object v5, v0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    .line 134
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v0, v2}, Ltv/freewheel/ad/AdInstance;->parse(Lorg/w3c/dom/Element;)V

    .line 135
    iget-object v5, p0, Ltv/freewheel/ad/AdInstance;->fallbackAds:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 125
    .end local v0    # "adInstance":Ltv/freewheel/ad/AdInstance;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 137
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v4    # "name":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ignore node: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 141
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method private playCompanionAds()V
    .locals 5

    .prologue
    .line 936
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " playCompanionAds()"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 937
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 938
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/AdInstance;

    .line 939
    .local v0, "adInstance":Ltv/freewheel/ad/AdInstance;
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    invoke-virtual {v2}, Ltv/freewheel/ad/slot/Slot;->isPauseMidroll()Z

    move-result v2

    iput-boolean v2, v0, Ltv/freewheel/ad/AdInstance;->isCompanionAdOfPauseAd:Z

    .line 940
    iget-object v2, v0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    iget-boolean v2, v2, Ltv/freewheel/ad/Ad;->noLoad:Z

    if-nez v2, :cond_0

    .line 941
    iget-object v2, v0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    check-cast v2, Ltv/freewheel/ad/slot/NonTemporalSlot;

    invoke-virtual {v2, v0}, Ltv/freewheel/ad/slot/NonTemporalSlot;->playCompanionAdInstance(Ltv/freewheel/ad/AdInstance;)V

    .line 937
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 944
    .end local v0    # "adInstance":Ltv/freewheel/ad/AdInstance;
    :cond_1
    return-void
.end method

.method private sendResellerNoAd(Ljava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # Ljava/lang/String;

    .prologue
    .line 365
    const-string v0, "_e_3p-comp"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "_e_parse"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "_e_no-ad"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 368
    :cond_0
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    const-string v1, "resellerNoAd"

    invoke-virtual {v0, v1}, Ltv/freewheel/ad/CallbackManager;->callback(Ljava/lang/String;)V

    .line 369
    iget-boolean v0, p0, Ltv/freewheel/ad/AdInstance;->resellerNoAdDispatched:Z

    if-nez v0, :cond_1

    .line 370
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/ad/AdInstance;->resellerNoAdDispatched:Z

    .line 371
    const-string v0, "resellerNoAd"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    .line 374
    :cond_1
    return-void
.end method


# virtual methods
.method public adFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "errorCode"    # Ljava/lang/String;
    .param p2, "details"    # Ljava/lang/String;

    .prologue
    .line 297
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 298
    .local v0, "info":Landroid/os/Bundle;
    const-string v1, "errorCode"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    const-string v1, "errorInfo"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    const-string v2, "errorModule"

    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    iget-object v1, v1, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    iget-object v1, v1, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    :goto_0
    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 301
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    iget-object v1, v1, Ltv/freewheel/ad/CallbackManager;->errorHandler:Ltv/freewheel/ad/handler/ErrorCallbackHandler;

    invoke-virtual {v1, v0}, Ltv/freewheel/ad/handler/ErrorCallbackHandler;->send(Landroid/os/Bundle;)V

    .line 302
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v1, p0}, Ltv/freewheel/ad/state/AdState;->fail(Ltv/freewheel/ad/AdInstance;)V

    .line 303
    return-void

    .line 300
    :cond_0
    const-string v1, "unknown"

    goto :goto_0
.end method

.method public addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 5
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "eventType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 753
    .local p3, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "eventName:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " eventType:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 754
    invoke-static {p1, p2, p3}, Ltv/freewheel/ad/EventCallback;->validate(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    .line 755
    .local v0, "errors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-nez v2, :cond_1

    .line 756
    const-string v2, "CLICKTRACKING"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 757
    const-string p2, "CLICK"

    .line 759
    :cond_0
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    invoke-virtual {v2, p1, p2}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v1

    .line 760
    .local v1, "handler":Ltv/freewheel/ad/handler/EventCallbackHandler;
    invoke-virtual {v1, p3}, Ltv/freewheel/ad/handler/EventCallbackHandler;->addExternalTrackingURLs(Ljava/util/ArrayList;)V

    .line 765
    .end local v1    # "handler":Ltv/freewheel/ad/handler/EventCallbackHandler;
    :goto_0
    return-void

    .line 763
    :cond_1
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v0}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public addOnActivityCallbackListener(Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;)V
    .locals 1
    .param p1, "listener"    # Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;

    .prologue
    .line 731
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v0, p1}, Ltv/freewheel/ad/AdContext;->addOnActivityCallbackListener(Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;)V

    .line 732
    return-void
.end method

.method public buildAdChain()Ltv/freewheel/ad/AdChain;
    .locals 6

    .prologue
    .line 144
    new-instance v1, Ltv/freewheel/ad/AdChain;

    invoke-direct {v1, p0}, Ltv/freewheel/ad/AdChain;-><init>(Ltv/freewheel/ad/AdInstance;)V

    .line 145
    .local v1, "adChain":Ltv/freewheel/ad/AdChain;
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " build add chain "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 146
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->fallbackAds:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/AdInstance;

    .line 147
    .local v0, "ad":Ltv/freewheel/ad/AdInstance;
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v3, v0}, Ltv/freewheel/ad/AdChain;->append(Ltv/freewheel/ad/AdInstance;)V

    goto :goto_0

    .line 149
    .end local v0    # "ad":Ltv/freewheel/ad/AdInstance;
    :cond_0
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->fallbackAds:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 150
    return-object v1
.end method

.method public cloneForTranslation()Ltv/freewheel/ad/interfaces/IAdInstance;
    .locals 4

    .prologue
    .line 735
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "cloneForTranslation()"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 736
    new-instance v1, Ltv/freewheel/ad/AdInstance;

    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v1, v2}, Ltv/freewheel/ad/AdInstance;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 737
    .local v1, "ret":Ltv/freewheel/ad/AdInstance;
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    invoke-virtual {v2}, Ltv/freewheel/ad/Ad;->cloneForTranslation()Ltv/freewheel/ad/Ad;

    move-result-object v2

    iput-object v2, v1, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    .line 738
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    invoke-virtual {v2}, Ltv/freewheel/ad/Creative;->cloneForTranslation()Ltv/freewheel/ad/Creative;

    move-result-object v2

    iput-object v2, v1, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    .line 739
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    if-eqz v2, :cond_0

    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    iget v2, v2, Ltv/freewheel/ad/CreativeRendition;->creativeRenditionId:I

    :goto_0
    iput v2, v1, Ltv/freewheel/ad/AdInstance;->creativeRenditionId:I

    .line 741
    iget v2, p0, Ltv/freewheel/ad/AdInstance;->replicaId:I

    iput v2, v1, Ltv/freewheel/ad/AdInstance;->replicaId:I

    .line 742
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    iput-object v2, v1, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    .line 743
    iget-object v2, v1, Ltv/freewheel/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 744
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 745
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/EventCallback;>;"
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 746
    iget-object v3, v1, Ltv/freewheel/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/EventCallback;

    invoke-virtual {v2}, Ltv/freewheel/ad/EventCallback;->cloneForTranslation()Ltv/freewheel/ad/EventCallback;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 739
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/EventCallback;>;"
    :cond_0
    iget v2, p0, Ltv/freewheel/ad/AdInstance;->creativeRenditionId:I

    goto :goto_0

    .line 748
    .restart local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/EventCallback;>;"
    :cond_1
    iget-object v2, v1, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    invoke-virtual {v2, v3}, Ltv/freewheel/ad/CallbackManager;->copyOtherHandlers(Ltv/freewheel/ad/CallbackManager;)V

    .line 749
    return-object v1
.end method

.method public createCreativeRenditionForTranslation()Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .locals 4

    .prologue
    .line 613
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v2, "createCreativeRenditionForTranslation()"

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 615
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    invoke-virtual {v1}, Ltv/freewheel/ad/Creative;->createCreativeRendition()Ltv/freewheel/ad/CreativeRendition;

    move-result-object v0

    .line 616
    .local v0, "ret":Ltv/freewheel/ad/CreativeRendition;
    iget v1, p0, Ltv/freewheel/ad/AdInstance;->creativeRenditionId:I

    iput v1, v0, Ltv/freewheel/ad/CreativeRendition;->creativeRenditionId:I

    .line 617
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "createCreativeRenditionForTranslation(): returning "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 618
    return-object v0
.end method

.method public dispatchAdEvent(Ljava/lang/String;)V
    .locals 4
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 691
    new-instance v0, Ltv/freewheel/utils/events/Event;

    invoke-direct {v0, p1}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 692
    .local v0, "event":Ltv/freewheel/utils/events/Event;
    iget-object v1, v0, Ltv/freewheel/utils/events/Event;->data:Ljava/util/HashMap;

    const-string v2, "adId"

    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->getAdId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 693
    iget-object v1, v0, Ltv/freewheel/utils/events/Event;->data:Ljava/util/HashMap;

    const-string v2, "creativeId"

    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    iget v3, v3, Ltv/freewheel/ad/Creative;->creativeId:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 694
    iget-object v1, v0, Ltv/freewheel/utils/events/Event;->data:Ljava/util/HashMap;

    const-string v2, "customId"

    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    iget-object v3, v3, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 695
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v1, v0}, Ltv/freewheel/ad/AdContext;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 696
    return-void
.end method

.method public dispatchEvent(Ljava/lang/String;)V
    .locals 4
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 679
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "dispatchEvent(eventName="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 680
    new-instance v0, Ltv/freewheel/utils/events/Event;

    invoke-direct {v0, p1}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 681
    .local v0, "event":Ltv/freewheel/utils/events/Event;
    invoke-direct {p0, v0}, Ltv/freewheel/ad/AdInstance;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 682
    return-void
.end method

.method public dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 1
    .param p1, "eventName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 685
    .local p2, "extraInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v0, Ltv/freewheel/utils/events/Event;

    invoke-direct {v0, p1}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 686
    .local v0, "event":Ltv/freewheel/utils/events/Event;
    iput-object p2, v0, Ltv/freewheel/utils/events/Event;->data:Ljava/util/HashMap;

    .line 687
    invoke-direct {p0, v0}, Ltv/freewheel/ad/AdInstance;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 688
    return-void
.end method

.method public getActiveCreativeRendition()Ltv/freewheel/ad/CreativeRendition;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    return-object v0
.end method

.method public bridge synthetic getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .locals 1

    .prologue
    .line 39
    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/CreativeRendition;

    move-result-object v0

    return-object v0
.end method

.method public getActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 536
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v0}, Ltv/freewheel/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v0

    return-object v0
.end method

.method public getAdId()I
    .locals 1

    .prologue
    .line 699
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    iget v0, v0, Ltv/freewheel/ad/Ad;->adId:I

    return v0
.end method

.method public getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;
    .locals 0

    .prologue
    .line 458
    return-object p0
.end method

.method public getAllCreativeRenditions()Ljava/util/ArrayList;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ICreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 430
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    iget-object v1, v1, Ltv/freewheel/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 431
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    iget-object v1, v1, Ltv/freewheel/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 432
    .local v0, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    if-eqz v1, :cond_0

    .line 433
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 434
    const/4 v1, 0x0

    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    invoke-virtual {v0, v1, v2}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 436
    :cond_0
    return-object v0
.end method

.method public getCompanionSlots()Ljava/util/ArrayList;
    .locals 6
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
    .line 719
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 720
    .local v2, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 721
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/AdInstance;

    .line 722
    .local v0, "adInstance":Ltv/freewheel/ad/AdInstance;
    iget-object v3, v0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    iget-boolean v3, v3, Ltv/freewheel/ad/Ad;->noLoad:Z

    if-eqz v3, :cond_0

    .line 723
    iget-object v3, v0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 720
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 726
    .end local v0    # "adInstance":Ltv/freewheel/ad/AdInstance;
    :cond_1
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "getCompanionSlots("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 727
    return-object v2
.end method

.method public getConstants()Ltv/freewheel/ad/interfaces/IConstants;
    .locals 1

    .prologue
    .line 532
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v0}, Ltv/freewheel/ad/AdContext;->getConstants()Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v0

    return-object v0
.end method

.method public getDuration()D
    .locals 10

    .prologue
    const-wide/16 v6, 0x0

    .line 548
    iget-boolean v8, p0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    if-eqz v8, :cond_1

    .line 578
    :cond_0
    :goto_0
    return-wide v6

    .line 550
    :cond_1
    const-wide/high16 v4, -0x4010000000000000L    # -1.0

    .line 551
    .local v4, "rendererDuration":D
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

    if-eqz v8, :cond_2

    .line 552
    const-string v3, "The renderer has no getDuration implemented."

    .line 554
    .local v3, "logMsg":Ljava/lang/String;
    :try_start_0
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

    invoke-interface {v8}, Ltv/freewheel/renderers/interfaces/IRenderer;->getDuration()D
    :try_end_0
    .catch Ljava/lang/NoSuchMethodError; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/AbstractMethodError; {:try_start_0 .. :try_end_0} :catch_1

    move-result-wide v4

    .line 564
    .end local v3    # "logMsg":Ljava/lang/String;
    :cond_2
    :goto_1
    cmpl-double v8, v4, v6

    if-ltz v8, :cond_3

    .line 565
    iput-wide v4, p0, Ltv/freewheel/ad/AdInstance;->duration:D

    .line 566
    iget-wide v6, p0, Ltv/freewheel/ad/AdInstance;->duration:D

    goto :goto_0

    .line 555
    .restart local v3    # "logMsg":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 556
    .local v2, "err":Ljava/lang/NoSuchMethodError;
    const-wide/high16 v4, -0x4010000000000000L    # -1.0

    .line 557
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v9, "The renderer has no getDuration implemented."

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 559
    .end local v2    # "err":Ljava/lang/NoSuchMethodError;
    :catch_1
    move-exception v2

    .line 560
    .local v2, "err":Ljava/lang/AbstractMethodError;
    const-wide/high16 v4, -0x4010000000000000L    # -1.0

    .line 561
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v9, "The renderer has no getDuration implemented."

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 567
    .end local v2    # "err":Ljava/lang/AbstractMethodError;
    .end local v3    # "logMsg":Ljava/lang/String;
    :cond_3
    iget-wide v8, p0, Ltv/freewheel/ad/AdInstance;->duration:D

    cmpl-double v8, v8, v6

    if-ltz v8, :cond_4

    .line 568
    iget-wide v6, p0, Ltv/freewheel/ad/AdInstance;->duration:D

    goto :goto_0

    .line 570
    :cond_4
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 571
    .local v0, "creativeDuration":D
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    if-eqz v8, :cond_5

    .line 572
    iget-object v8, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    invoke-virtual {v8}, Ltv/freewheel/ad/CreativeRendition;->getDuration()D

    move-result-wide v0

    .line 574
    :cond_5
    cmpl-double v8, v0, v6

    if-ltz v8, :cond_0

    .line 575
    iput-wide v0, p0, Ltv/freewheel/ad/AdInstance;->duration:D

    .line 576
    iget-wide v6, p0, Ltv/freewheel/ad/AdInstance;->duration:D

    goto :goto_0
.end method

.method public getEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 5
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "eventType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 768
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "getEventCallbackURLs("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 769
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 770
    .local v1, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    invoke-virtual {v2, p1, p2}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v0

    .line 771
    .local v0, "handler":Ltv/freewheel/ad/handler/EventCallbackHandler;
    if-eqz v0, :cond_5

    .line 772
    const-string v2, "ERROR"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 773
    invoke-virtual {v0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getInternalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 794
    :cond_0
    :goto_0
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "getEventCallbackURLs() Returning "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 795
    return-object v1

    .line 775
    :cond_1
    const-string v2, "CLICK"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 776
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    invoke-virtual {v2}, Ltv/freewheel/ad/handler/ClickCallbackHandler;->isShowBrowser()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 777
    invoke-virtual {v0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getInternalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 780
    :cond_2
    const-string v2, "CLICKTRACKING"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 781
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    invoke-virtual {v2}, Ltv/freewheel/ad/handler/ClickCallbackHandler;->isShowBrowser()Z

    move-result v2

    if-nez v2, :cond_3

    .line 782
    invoke-virtual {v0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getInternalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 784
    :cond_3
    invoke-virtual {v0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getTrackingURLs()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 787
    :cond_4
    invoke-virtual {v0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getInternalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 788
    invoke-virtual {v0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getTrackingURLs()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 792
    :cond_5
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "getEventCallbackURLs: failed to get event callback handler!"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getMetrValue()I
    .locals 1

    .prologue
    .line 544
    iget v0, p0, Ltv/freewheel/ad/AdInstance;->metrValue:I

    return v0
.end method

.method public getParameter(Ljava/lang/String;)Ljava/lang/Object;
    .locals 7
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 462
    const/4 v3, 0x0

    .line 463
    .local v3, "value":Ljava/lang/Object;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 464
    .local v1, "paramArray":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->overrideLevelParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 467
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    if-eqz v4, :cond_0

    .line 468
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    iget-object v4, v4, Ltv/freewheel/ad/CreativeRendition;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 471
    :cond_0
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    if-eqz v4, :cond_1

    .line 472
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    iget-object v4, v4, Ltv/freewheel/ad/Creative;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 475
    :cond_1
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    if-eqz v4, :cond_2

    .line 476
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    iget-object v4, v4, Ltv/freewheel/ad/slot/Slot;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 479
    :cond_2
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->profileParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 480
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->globalLevelParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 482
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    if-eqz v4, :cond_3

    .line 483
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    iget-object v4, v4, Ltv/freewheel/ad/AdRenderer;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 486
    :cond_3
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 488
    .end local v3    # "value":Ljava/lang/Object;
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :cond_4
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 489
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/HashMap;

    .line 490
    .local v2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 491
    .restart local v3    # "value":Ljava/lang/Object;
    if-eqz v3, :cond_4

    .line 496
    .end local v2    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v3    # "value":Ljava/lang/Object;
    :cond_5
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "getParameter:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 497
    return-object v3
.end method

.method public getRenderableCreativeRenditions()Ljava/util/ArrayList;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ICreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 441
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    iget-object v0, v0, Ltv/freewheel/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 442
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 443
    .local v9, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    iget-object v0, v0, Ltv/freewheel/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ltv/freewheel/ad/interfaces/ICreativeRendition;

    .line 444
    .local v7, "cr":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getBaseUnit()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    iget-object v2, v2, Ltv/freewheel/ad/Ad;->adUnit:Ljava/lang/String;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    iget v4, v4, Ltv/freewheel/ad/slot/Slot;->timePositionClass:I

    invoke-static {v4}, Ltv/freewheel/ad/slot/Slot;->slotTypeString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getWrapperType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Ltv/freewheel/ad/AdRenderer;->match(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 446
    :cond_1
    invoke-virtual {v9, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 450
    .end local v7    # "cr":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_2
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    if-eqz v0, :cond_3

    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 451
    const/4 v0, 0x0

    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    invoke-virtual {v9, v0, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 453
    :cond_3
    return-object v9
.end method

.method public getSlot()Ltv/freewheel/ad/interfaces/ISlot;
    .locals 1

    .prologue
    .line 501
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .prologue
    .line 540
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    iget v0, v0, Ltv/freewheel/ad/AdContext;->version:I

    return v0
.end method

.method public isPlayable()Z
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 201
    const/4 v0, 0x1

    .line 202
    .local v0, "ret":Z
    if-eqz v0, :cond_1

    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-static {}, Ltv/freewheel/ad/state/AdFailedState;->Instance()Ltv/freewheel/ad/state/AdState;

    move-result-object v5

    if-ne v4, v5, :cond_0

    iget-boolean v4, p0, Ltv/freewheel/ad/AdInstance;->imprSent:Z

    if-eqz v4, :cond_1

    :cond_0
    move v0, v2

    .line 203
    :goto_0
    if-nez v0, :cond_2

    .line 204
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " isPlayable returning false because adState is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " and imprSent is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Ltv/freewheel/ad/AdInstance;->imprSent:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    move v1, v0

    .line 213
    .end local v0    # "ret":Z
    .local v1, "ret":I
    :goto_1
    return v1

    .end local v1    # "ret":I
    .restart local v0    # "ret":Z
    :cond_1
    move v0, v3

    .line 202
    goto :goto_0

    .line 207
    :cond_2
    if-eqz v0, :cond_4

    iget-boolean v4, p0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    if-eqz v4, :cond_3

    iget-boolean v4, p0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    if-eqz v4, :cond_4

    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-static {}, Ltv/freewheel/ad/state/AdLoadedState;->Instance()Ltv/freewheel/ad/state/AdState;

    move-result-object v5

    if-ne v4, v5, :cond_4

    :cond_3
    move v0, v2

    .line 208
    :goto_2
    if-nez v0, :cond_5

    .line 209
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " isPlayable returning false becasue scheduledDrivingAd is true"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    move v1, v0

    .line 210
    .restart local v1    # "ret":I
    goto :goto_1

    .end local v1    # "ret":I
    :cond_4
    move v0, v3

    .line 207
    goto :goto_2

    .line 212
    :cond_5
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " isPlayable returning "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    move v1, v0

    .line 213
    .restart local v1    # "ret":I
    goto :goto_1
.end method

.method public loadRenderer()V
    .locals 3

    .prologue
    .line 220
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v2, "loadRenderer()"

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 221
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    if-nez v1, :cond_0

    .line 222
    invoke-direct {p0}, Ltv/freewheel/ad/AdInstance;->getAdRenderer()I

    .line 225
    :cond_0
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    if-eqz v1, :cond_1

    .line 226
    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->onRendererModuleLoaded()V

    .line 232
    :goto_0
    return-void

    .line 228
    :cond_1
    const-string v0, "no renderer matched"

    .line 229
    .local v0, "errorInfo":Ljava/lang/String;
    const-string v1, "_e_no-renderer"

    invoke-virtual {p0, v1, v0}, Ltv/freewheel/ad/AdInstance;->adFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onRendererLoaded(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 2
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 329
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onRendererLoaded"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 330
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/AdState;->notifyAdLoaded(Ltv/freewheel/ad/AdInstance;)V

    .line 331
    invoke-direct {p0}, Ltv/freewheel/ad/AdInstance;->commitAdInstances()V

    .line 332
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    iget-object v0, v0, Ltv/freewheel/ad/AdChain;->chainBehavior:Ltv/freewheel/ad/ChainBehavior;

    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, v1}, Ltv/freewheel/ad/ChainBehavior;->isDestState(Ltv/freewheel/ad/state/AdState;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 333
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/ad/AdInstance;)V

    .line 342
    :goto_0
    return-void

    .line 335
    :cond_0
    iget-boolean v0, p0, Ltv/freewheel/ad/AdInstance;->pauseWhenLoading:Z

    if-nez v0, :cond_1

    .line 336
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/AdState;->play(Ltv/freewheel/ad/AdInstance;)V

    goto :goto_0

    .line 338
    :cond_1
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "player pause when loaing, ad pause"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 339
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/ad/AdInstance;->pauseWhenLoading:Z

    goto :goto_0
.end method

.method public onRendererModuleLoaded()V
    .locals 5

    .prologue
    .line 269
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    invoke-virtual {v2}, Ltv/freewheel/ad/CreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v0

    .line 270
    .local v0, "asset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    if-eqz v0, :cond_0

    .line 271
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "startPlay: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getURL()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 277
    :goto_0
    :try_start_0
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->adRenderer:Ltv/freewheel/ad/AdRenderer;

    invoke-static {v2}, Ltv/freewheel/ad/AdRenderer;->getRenderer(Ltv/freewheel/ad/AdRenderer;)Ltv/freewheel/renderers/interfaces/IRenderer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/ad/AdInstance;->renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

    .line 278
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

    if-nez v2, :cond_1

    .line 279
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "can not find a renderer to play"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 280
    const-string v2, "_e_renderer-load"

    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->additionalErrorInfo:Ljava/lang/String;

    invoke-virtual {p0, v2, v3}, Ltv/freewheel/ad/AdInstance;->adFailed(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1

    .line 294
    :goto_1
    return-void

    .line 273
    :cond_0
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "startPlay: no assets"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 282
    :cond_1
    :try_start_1
    invoke-static {}, Ltv/freewheel/ad/state/RendererInitState;->Instance()Ltv/freewheel/ad/state/RendererState;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    .line 283
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v2, p0}, Ltv/freewheel/ad/state/RendererState;->load(Ltv/freewheel/ad/AdInstance;)V
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 285
    :catch_0
    move-exception v1

    .line 286
    .local v1, "e":Ljava/lang/IllegalAccessException;
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "IllegalAccessException"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 287
    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    .line 288
    const-string v2, "_e_renderer-load"

    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Ltv/freewheel/ad/AdInstance;->adFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 289
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v1

    .line 290
    .local v1, "e":Ljava/lang/InstantiationException;
    iget-object v2, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "InstantiationException"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 291
    invoke-virtual {v1}, Ljava/lang/InstantiationException;->printStackTrace()V

    .line 292
    const-string v2, "_e_renderer-load"

    invoke-virtual {v1}, Ljava/lang/InstantiationException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Ltv/freewheel/ad/AdInstance;->adFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onRendererStarted(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 3
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 345
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " onRendererStarted()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 346
    invoke-direct {p0}, Ltv/freewheel/ad/AdInstance;->commitAdInstances()V

    .line 348
    iget-boolean v0, p0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    if-nez v0, :cond_0

    .line 349
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ltv/freewheel/ad/CallbackManager;->sendDefaultImpression(Z)V

    .line 350
    invoke-direct {p0}, Ltv/freewheel/ad/AdInstance;->playCompanionAds()V

    .line 352
    :cond_0
    return-void
.end method

.method public onRendererStopped(Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 2
    .param p1, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 355
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onRendererStopped"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 356
    iget-boolean v0, p0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    if-nez v0, :cond_0

    .line 357
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ltv/freewheel/ad/CallbackManager;->sendDefaultImpression(Z)V

    .line 360
    :cond_0
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/RendererState;->dispose(Ltv/freewheel/ad/AdInstance;)V

    .line 361
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/AdState;->complete(Ltv/freewheel/ad/AdInstance;)V

    .line 362
    return-void
.end method

.method public onStartPlay()V
    .locals 2

    .prologue
    .line 970
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onStartPlay()"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 971
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/RendererState;->start(Ltv/freewheel/ad/AdInstance;)V

    .line 972
    return-void
.end method

.method public onStopPlay()V
    .locals 2

    .prologue
    .line 322
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onStopPlay"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 323
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    if-eqz v0, :cond_0

    .line 324
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/RendererState;->stop(Ltv/freewheel/ad/AdInstance;)V

    .line 326
    :cond_0
    return-void
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 9
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 76
    const-string v6, "adId"

    invoke-interface {p1, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ltv/freewheel/ad/AdInstance;->tryParseInt(Ljava/lang/String;)I

    move-result v0

    .line 79
    .local v0, "adId":I
    const-string v6, "creativeId"

    invoke-interface {p1, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ltv/freewheel/ad/AdInstance;->tryParseInt(Ljava/lang/String;)I

    move-result v3

    .line 82
    .local v3, "creativeId":I
    const-string v6, "creativeRenditionId"

    invoke-interface {p1, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ltv/freewheel/ad/AdInstance;->tryParseInt(Ljava/lang/String;)I

    move-result v6

    iput v6, p0, Ltv/freewheel/ad/AdInstance;->creativeRenditionId:I

    .line 85
    const-string v6, "replicaId"

    invoke-interface {p1, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const/4 v7, -0x1

    invoke-static {v6, v7}, Ltv/freewheel/ad/AdInstance;->tryParseInt(Ljava/lang/String;I)I

    move-result v6

    iput v6, p0, Ltv/freewheel/ad/AdInstance;->replicaId:I

    .line 88
    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->getAdResponse()Ltv/freewheel/ad/AdResponse;

    move-result-object v6

    invoke-virtual {v6, v0}, Ltv/freewheel/ad/AdResponse;->getAd(I)Ltv/freewheel/ad/Ad;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    .line 89
    iget-object v6, p0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    if-nez v6, :cond_0

    .line 90
    new-instance v6, Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "bad adId: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 93
    :cond_0
    iget-object v6, p0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    invoke-virtual {v6, v3}, Ltv/freewheel/ad/Ad;->getCreative(I)Ltv/freewheel/ad/Creative;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    .line 94
    iget-object v6, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    if-nez v6, :cond_1

    .line 95
    new-instance v6, Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "bad creativeId: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 98
    :cond_1
    iget-object v6, p0, Ltv/freewheel/ad/AdInstance;->creative:Ltv/freewheel/ad/Creative;

    iget v7, p0, Ltv/freewheel/ad/AdInstance;->creativeRenditionId:I

    iget v8, p0, Ltv/freewheel/ad/AdInstance;->replicaId:I

    invoke-virtual {v6, v7, v8}, Ltv/freewheel/ad/Creative;->getRendition(II)Ltv/freewheel/ad/CreativeRendition;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    .line 101
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 102
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v6

    if-ge v4, v6, :cond_6

    .line 103
    invoke-interface {v1, v4}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 104
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v6

    const/4 v7, 0x1

    if-ne v6, v7, :cond_2

    .line 105
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    .line 106
    .local v5, "name":Ljava/lang/String;
    iget-object v6, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "parse(), name: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 108
    const-string v6, "eventCallbacks"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 109
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v2}, Ltv/freewheel/ad/AdInstance;->parseEventCallbacks(Lorg/w3c/dom/Element;)V

    .line 110
    iget-object v6, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    invoke-virtual {v6}, Ltv/freewheel/ad/CallbackManager;->init()V

    .line 102
    .end local v5    # "name":Ljava/lang/String;
    :cond_2
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 111
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v5    # "name":Ljava/lang/String;
    :cond_3
    const-string v6, "companionAds"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 112
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v2}, Ltv/freewheel/ad/AdInstance;->parseCompanionAds(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 113
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_4
    const-string v6, "fallbackAds"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 114
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v2}, Ltv/freewheel/ad/AdInstance;->parseFallbackAds(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 116
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_5
    iget-object v6, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "ignore node: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 120
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v5    # "name":Ljava/lang/String;
    :cond_6
    return-void
.end method

.method public play()V
    .locals 3

    .prologue
    .line 186
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " play()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 187
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-static {}, Ltv/freewheel/ad/ChainBehavior;->getPlayBehavior()Ltv/freewheel/ad/ChainBehavior;

    move-result-object v1

    iput-object v1, v0, Ltv/freewheel/ad/AdChain;->chainBehavior:Ltv/freewheel/ad/ChainBehavior;

    .line 188
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/AdState;->play(Ltv/freewheel/ad/AdInstance;)V

    .line 189
    return-void
.end method

.method public preload()V
    .locals 3

    .prologue
    .line 964
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " preload()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 965
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-static {}, Ltv/freewheel/ad/ChainBehavior;->getPreloadBehavior()Ltv/freewheel/ad/ChainBehavior;

    move-result-object v1

    iput-object v1, v0, Ltv/freewheel/ad/AdChain;->chainBehavior:Ltv/freewheel/ad/ChainBehavior;

    .line 966
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/AdState;->load(Ltv/freewheel/ad/AdInstance;)V

    .line 967
    return-void
.end method

.method public resume()V
    .locals 2

    .prologue
    .line 527
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "resume"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 528
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/AdState;->play(Ltv/freewheel/ad/AdInstance;)V

    .line 529
    return-void
.end method

.method public scheduleAdInstances(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ISlot;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation

    .prologue
    .line 835
    .local p1, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "scheduleAdInstances("

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

    .line 836
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    .line 837
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v1, v4, :cond_4

    .line 838
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ltv/freewheel/ad/interfaces/ISlot;

    .line 839
    .local v3, "slot":Ltv/freewheel/ad/interfaces/ISlot;
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    if-ne v4, v3, :cond_2

    .line 840
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->cloneForTranslation()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 849
    :cond_0
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-gt v4, v1, :cond_1

    .line 850
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ".scheduleAd: bad slot: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 851
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 837
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 842
    :cond_2
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 843
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/AdInstance;

    .line 844
    .local v0, "companionAd":Ltv/freewheel/ad/AdInstance;
    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v4

    if-ne v3, v4, :cond_3

    iget-object v4, v0, Ltv/freewheel/ad/AdInstance;->ad:Ltv/freewheel/ad/Ad;

    iget-boolean v4, v4, Ltv/freewheel/ad/Ad;->noLoad:Z

    if-eqz v4, :cond_3

    .line 845
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->cloneForTranslation()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 842
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 854
    .end local v0    # "companionAd":Ltv/freewheel/ad/AdInstance;
    .end local v2    # "j":I
    .end local v3    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    :cond_4
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "scheduleAdInstances(): returning "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 855
    iget-object v4, p0, Ltv/freewheel/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    return-object v4
.end method

.method public setActiveCreativeRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;)V
    .locals 1
    .param p1, "rendition"    # Ltv/freewheel/ad/interfaces/ICreativeRendition;

    .prologue
    .line 605
    if-nez p1, :cond_0

    .line 606
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    .line 610
    .end local p1    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :goto_0
    return-void

    .line 609
    .restart local p1    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_0
    check-cast p1, Ltv/freewheel/ad/CreativeRendition;

    .end local p1    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    iput-object p1, p0, Ltv/freewheel/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/ad/CreativeRendition;

    goto :goto_0
.end method

.method public setClickThroughURL(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "clickName"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    .line 799
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "setClickThroughURL("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 800
    if-eqz p2, :cond_0

    const-string v3, ""

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 801
    :cond_0
    const-string p2, "defaultClick"

    .line 803
    :cond_1
    const-string v3, "CLICK"

    invoke-virtual {p0, p2, v3, v6}, Ltv/freewheel/ad/AdInstance;->fetchEventCallback(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/EventCallback;

    move-result-object v0

    .line 805
    .local v0, "evtCbk":Ltv/freewheel/ad/EventCallback;
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    const-string v4, "CLICK"

    invoke-virtual {v3, p2, v4}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/handler/ClickCallbackHandler;

    .line 807
    .local v1, "handler":Ltv/freewheel/ad/handler/ClickCallbackHandler;
    if-eqz v1, :cond_2

    .line 808
    invoke-virtual {v1, v6}, Ltv/freewheel/ad/handler/ClickCallbackHandler;->setShowBrowserValue(Z)V

    .line 809
    const-string v3, "cr"

    invoke-virtual {v1, v3, p1}, Ltv/freewheel/ad/handler/ClickCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 832
    :goto_0
    return-void

    .line 812
    :cond_2
    if-eqz v0, :cond_4

    .line 813
    iget-object v3, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    const-string v4, "GENERIC"

    if-ne v3, v4, :cond_3

    .line 814
    invoke-virtual {v0}, Ltv/freewheel/ad/EventCallback;->cloneForTranslation()Ltv/freewheel/ad/EventCallback;

    move-result-object v2

    .line 815
    .local v2, "newClickCbk":Ltv/freewheel/ad/EventCallback;
    const-string v3, "CLICK"

    iput-object v3, v2, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    .line 816
    iput-object p2, v2, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    .line 817
    iput-boolean v6, v2, Ltv/freewheel/ad/EventCallback;->showBrowser:Z

    .line 818
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 823
    .end local v2    # "newClickCbk":Ltv/freewheel/ad/EventCallback;
    :goto_1
    const-string v3, "CLICK"

    invoke-virtual {p0, p2, v3, v6}, Ltv/freewheel/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v1

    .end local v1    # "handler":Ltv/freewheel/ad/handler/ClickCallbackHandler;
    check-cast v1, Ltv/freewheel/ad/handler/ClickCallbackHandler;

    .line 824
    .restart local v1    # "handler":Ltv/freewheel/ad/handler/ClickCallbackHandler;
    const-string v3, "cr"

    invoke-virtual {v1, v3, p1}, Ltv/freewheel/ad/handler/ClickCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 825
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->callbackManager:Ltv/freewheel/ad/CallbackManager;

    const-string v4, "CLICK"

    invoke-virtual {v3, p2, v4, v1}, Ltv/freewheel/ad/CallbackManager;->addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/ad/handler/EventCallbackHandler;)V

    goto :goto_0

    .line 821
    :cond_3
    iput-boolean v6, v0, Ltv/freewheel/ad/EventCallback;->showBrowser:Z

    goto :goto_1

    .line 829
    :cond_4
    iget-object v3, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    const-string v4, "Failed to find generic callback for template."

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setRendererCapability(Ljava/lang/String;I)V
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "status"    # I

    .prologue
    .line 505
    sget-object v1, Ltv/freewheel/ad/InternalConstants;->METR_MAP:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 506
    .local v0, "mask":Ljava/lang/Integer;
    if-nez v0, :cond_0

    .line 519
    :goto_0
    return-void

    .line 509
    :cond_0
    const-string v1, "defaultClick"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 510
    if-nez p2, :cond_2

    const/4 p2, 0x1

    .line 512
    :cond_1
    :goto_1
    if-nez p2, :cond_3

    .line 513
    iget v1, p0, Ltv/freewheel/ad/AdInstance;->metrValue:I

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    or-int/2addr v1, v2

    iput v1, p0, Ltv/freewheel/ad/AdInstance;->metrValue:I

    .line 518
    :goto_2
    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setRendererCapability metrValue is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Ltv/freewheel/ad/AdInstance;->metrValue:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 510
    :cond_2
    const/4 p2, 0x0

    goto :goto_1

    .line 515
    :cond_3
    iget v1, p0, Ltv/freewheel/ad/AdInstance;->metrValue:I

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    neg-int v2, v2

    xor-int/lit8 v2, v2, -0x1

    and-int/2addr v1, v2

    iput v1, p0, Ltv/freewheel/ad/AdInstance;->metrValue:I

    goto :goto_2
.end method

.method public stop()V
    .locals 3

    .prologue
    .line 192
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " stop()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 193
    iget-object v0, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/AdState;->stop(Ltv/freewheel/ad/AdInstance;)V

    .line 194
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 947
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[AdInst adId:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ltv/freewheel/ad/AdInstance;->getAdId()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " replicaId:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Ltv/freewheel/ad/AdInstance;->replicaId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
