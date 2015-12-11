.class public Ltv/freewheel/hybrid/ad/AdInstance;
.super Ltv/freewheel/hybrid/ad/EventCallbackHolder;
.source "AdInstance.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
.implements Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;


# instance fields
.field public ad:Ltv/freewheel/hybrid/ad/Ad;

.field public adChain:Ltv/freewheel/hybrid/ad/AdChain;

.field private adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

.field private additionalErrorInfo:Ljava/lang/String;

.field public callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

.field public companionAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/AdInstance;",
            ">;"
        }
    .end annotation
.end field

.field public creative:Ltv/freewheel/hybrid/ad/Creative;

.field public creativeRenditionId:I

.field private duration:D

.field private fallbackAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/AdInstance;",
            ">;"
        }
    .end annotation
.end field

.field public imprSent:Z

.field public isCompanionAdOfPauseAd:Z

.field private metrValue:I

.field private primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

.field public renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

.field protected final rendererLoadHandler:Landroid/os/Handler;

.field public rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

.field public replicaId:I

.field private resellerNoAdDispatched:Z

.field public scheduledDrivingAd:Z

.field public slot:Ltv/freewheel/hybrid/ad/slot/Slot;

.field public state:Ltv/freewheel/hybrid/ad/state/AdState;

.field private translatedAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 3
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    const/4 v2, 0x0

    .line 66
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/EventCallbackHolder;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 50
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->isCompanionAdOfPauseAd:Z

    .line 54
    const-string v0, ""

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->additionalErrorInfo:Ljava/lang/String;

    .line 59
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    iput-wide v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->duration:D

    .line 60
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->resellerNoAdDispatched:Z

    .line 62
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->imprSent:Z

    .line 63
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->scheduledDrivingAd:Z

    .line 705
    new-instance v0, Ltv/freewheel/hybrid/ad/AdInstance$2;

    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Ltv/freewheel/hybrid/ad/AdInstance$2;-><init>(Ltv/freewheel/hybrid/ad/AdInstance;Landroid/os/Looper;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererLoadHandler:Landroid/os/Handler;

    .line 67
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdInitState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 68
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    .line 69
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->fallbackAds:Ljava/util/ArrayList;

    .line 70
    iput v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->metrValue:I

    .line 71
    new-instance v0, Ltv/freewheel/hybrid/ad/CallbackManager;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/ad/CallbackManager;-><init>(Ltv/freewheel/hybrid/ad/AdInstance;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    .line 72
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdInstance;
    .param p1, "x1"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    return-void
.end method

.method static synthetic access$102(Ltv/freewheel/hybrid/ad/AdInstance;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/AdInstance;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->additionalErrorInfo:Ljava/lang/String;

    return-object p1
.end method

.method private commitAdInstances()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    .line 862
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " commitAdInstances()"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 864
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    if-eqz v8, :cond_0

    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-nez v8, :cond_1

    .line 865
    :cond_0
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "commitAdInstances() nothing to commit, translatedAds is empty."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 927
    :goto_0
    return-void

    .line 868
    :cond_1
    const/4 v7, 0x0

    .line 870
    .local v7, "translatedDriver":Ltv/freewheel/hybrid/ad/AdInstance;
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    invoke-virtual {v8}, Ltv/freewheel/hybrid/ad/AdRenderer;->isTranslator()Z

    move-result v5

    .line 872
    .local v5, "isTranslator":Z
    if-eqz v5, :cond_3

    .line 873
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 874
    .local v6, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    :cond_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 875
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 876
    .local v0, "ad":Ltv/freewheel/hybrid/ad/AdInstance;
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v8

    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v9

    if-ne v8, v9, :cond_2

    .line 877
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "committing driving ad "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 878
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adChain:Ltv/freewheel/hybrid/ad/AdChain;

    invoke-virtual {v8, v0, p0}, Ltv/freewheel/hybrid/ad/AdChain;->insertAfter(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 879
    move-object v7, v0

    .line 880
    iput-boolean v11, p0, Ltv/freewheel/hybrid/ad/AdInstance;->scheduledDrivingAd:Z

    .line 886
    .end local v0    # "ad":Ltv/freewheel/hybrid/ad/AdInstance;
    .end local v6    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    :cond_3
    if-nez v7, :cond_4

    .line 888
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    invoke-virtual {v8}, Ltv/freewheel/hybrid/ad/AdRenderer;->isTranslator()Z

    move-result v8

    if-eqz v8, :cond_7

    .line 889
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->cloneForTranslation()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 890
    .local v2, "emptyDrivingAd":Ltv/freewheel/hybrid/ad/AdInstance;
    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/AdInstance;->createCreativeRenditionForTranslation()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v3

    check-cast v3, Ltv/freewheel/hybrid/ad/CreativeRendition;

    .line 891
    .local v3, "emptyRendition":Ltv/freewheel/hybrid/ad/CreativeRendition;
    const-string v8, "null/null"

    invoke-virtual {v3, v8}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setContentType(Ljava/lang/String;)V

    .line 892
    iput-object v3, v2, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    .line 893
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adChain:Ltv/freewheel/hybrid/ad/AdChain;

    invoke-virtual {v8, v2, p0}, Ltv/freewheel/hybrid/ad/AdChain;->insertAfter(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 894
    move-object v7, v2

    .line 895
    iput-boolean v11, p0, Ltv/freewheel/hybrid/ad/AdInstance;->scheduledDrivingAd:Z

    .line 896
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "committing empty driving ad "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, v2, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iget-boolean v10, v10, Ltv/freewheel/hybrid/ad/Ad;->noLoad:Z

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 905
    .end local v2    # "emptyDrivingAd":Ltv/freewheel/hybrid/ad/AdInstance;
    .end local v3    # "emptyRendition":Ltv/freewheel/hybrid/ad/CreativeRendition;
    :cond_4
    :goto_1
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 906
    .restart local v6    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    :cond_5
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_9

    .line 907
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 908
    .local v1, "companionAd":Ltv/freewheel/hybrid/ad/AdInstance;
    if-eq v7, v1, :cond_5

    .line 909
    iget-object v8, v1, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v8}, Ltv/freewheel/hybrid/ad/slot/Slot;->getType()I

    move-result v8

    if-eqz v8, :cond_8

    .line 910
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "commitAdInstances: committing companion ad: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 911
    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/AdInstance;->getAllCreativeRenditions()Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_6

    .line 912
    iget-object v8, v1, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iput-boolean v11, v8, Ltv/freewheel/hybrid/ad/Ad;->noLoad:Z

    .line 913
    :cond_6
    iget-object v8, v7, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 900
    .end local v1    # "companionAd":Ltv/freewheel/hybrid/ad/AdInstance;
    .end local v6    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    :cond_7
    move-object v7, p0

    goto :goto_1

    .line 915
    .restart local v1    # "companionAd":Ltv/freewheel/hybrid/ad/AdInstance;
    .restart local v6    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    :cond_8
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v9, "commitAdInstances: got a translated ad which is neither driving nor nontemporal."

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_2

    .line 920
    .end local v1    # "companionAd":Ltv/freewheel/hybrid/ad/AdInstance;
    :cond_9
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_3
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-ge v4, v8, :cond_b

    .line 921
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 922
    .restart local v1    # "companionAd":Ltv/freewheel/hybrid/ad/AdInstance;
    iget-object v8, v7, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-direct {p0, v8, v1}, Ltv/freewheel/hybrid/ad/AdInstance;->containsAd(Ljava/util/ArrayList;Ltv/freewheel/hybrid/ad/AdInstance;)Z

    move-result v8

    if-nez v8, :cond_a

    .line 923
    iget-object v8, v7, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 920
    :cond_a
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 926
    .end local v1    # "companionAd":Ltv/freewheel/hybrid/ad/AdInstance;
    :cond_b
    const/4 v8, 0x0

    iput-object v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    goto/16 :goto_0
.end method

.method private containsAd(Ljava/util/ArrayList;Ltv/freewheel/hybrid/ad/AdInstance;)Z
    .locals 3
    .param p2, "adInstance"    # Ltv/freewheel/hybrid/ad/AdInstance;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/AdInstance;",
            ">;",
            "Ltv/freewheel/hybrid/ad/AdInstance;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 930
    .local p1, "adInstances":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/AdInstance;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 931
    invoke-virtual {p2}, Ltv/freewheel/hybrid/ad/AdInstance;->getAdId()I

    move-result v2

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/AdInstance;->getAdId()I

    move-result v1

    if-ne v2, v1, :cond_0

    .line 932
    const/4 v1, 0x1

    .line 935
    :goto_1
    return v1

    .line 930
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 935
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 6
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 622
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v3}, Ltv/freewheel/hybrid/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v3

    if-nez v3, :cond_2

    .line 623
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "Activity not registered. Run dispatchEvent on current thread."

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 635
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "process ad event:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 636
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v0

    .line 637
    .local v0, "eventName":Ljava/lang/String;
    const-string v3, "loaded"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 638
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v3, p0, p1}, Ltv/freewheel/hybrid/ad/state/RendererState;->notifyLoaded(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 674
    .end local v0    # "eventName":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 624
    :cond_2
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v4

    if-eq v3, v4, :cond_0

    .line 625
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Re-dispatchEvent "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " to main UI thread."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 626
    move-object v1, p1

    .line 627
    .local v1, "eventRef":Ltv/freewheel/hybrid/ad/interfaces/IEvent;
    new-instance v3, Landroid/os/Handler;

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v4, Ltv/freewheel/hybrid/ad/AdInstance$1;

    invoke-direct {v4, p0, v1}, Ltv/freewheel/hybrid/ad/AdInstance$1;-><init>(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 639
    .end local v1    # "eventRef":Ltv/freewheel/hybrid/ad/interfaces/IEvent;
    .restart local v0    # "eventName":Ljava/lang/String;
    :cond_3
    const-string v3, "started"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 640
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v3, p0, p1}, Ltv/freewheel/hybrid/ad/state/RendererState;->notifyStarted(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 641
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto :goto_0

    .line 642
    :cond_4
    const-string v3, "stopped"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 643
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v3, p0, p1}, Ltv/freewheel/hybrid/ad/state/RendererState;->notifyStopped(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 644
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto :goto_0

    .line 645
    :cond_5
    const-string v3, "_e_unknown"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 646
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/AdInstance;->onRendererError(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 647
    :cond_6
    const-string v3, "defaultClick"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 648
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/AdInstance;->onRendererClicked(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 649
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 650
    :cond_7
    const-string v3, "requestContentVideoPause"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 651
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    iget-boolean v3, v3, Ltv/freewheel/hybrid/ad/slot/Slot;->requestContentPause:Z

    if-nez v3, :cond_1

    .line 652
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/ad/AdContext;->requestContentPause(Ltv/freewheel/hybrid/ad/slot/Slot;)V

    .line 653
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    const/4 v4, 0x1

    iput-boolean v4, v3, Ltv/freewheel/hybrid/ad/slot/Slot;->requestContentPause:Z

    goto/16 :goto_0

    .line 655
    :cond_8
    const-string v3, "requestContentVideoResume"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 656
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    iget-boolean v3, v3, Ltv/freewheel/hybrid/ad/slot/Slot;->requestContentPause:Z

    if-eqz v3, :cond_1

    .line 657
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    const/4 v4, 0x0

    iput-boolean v4, v3, Ltv/freewheel/hybrid/ad/slot/Slot;->requestContentPause:Z

    .line 658
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/ad/AdContext;->requestContentResume(Ltv/freewheel/hybrid/ad/slot/Slot;)V

    goto/16 :goto_0

    .line 661
    :cond_9
    const-string v3, "firstQuartile"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    const-string v3, "midPoint"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    const-string v3, "thirdQuartile"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    const-string v3, "complete"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_c

    .line 665
    :cond_a
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    const-string v4, "IMPRESSION"

    invoke-virtual {v3, v0, v4}, Ltv/freewheel/hybrid/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/handler/QuartileCallbackHandler;

    .line 666
    .local v2, "handler":Ltv/freewheel/hybrid/ad/handler/QuartileCallbackHandler;
    iget-boolean v3, v2, Ltv/freewheel/hybrid/ad/handler/QuartileCallbackHandler;->imprSent:Z

    if-nez v3, :cond_b

    .line 667
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    .line 672
    .end local v2    # "handler":Ltv/freewheel/hybrid/ad/handler/QuartileCallbackHandler;
    :cond_b
    :goto_1
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    invoke-virtual {v3, v0}, Ltv/freewheel/hybrid/ad/CallbackManager;->callback(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 670
    :cond_c
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private findRenderer(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ltv/freewheel/hybrid/ad/AdRenderer;
    .locals 8
    .param p1, "adUnit"    # Ljava/lang/String;
    .param p2, "soAdUnit"    # Ljava/lang/String;
    .param p3, "contentType"    # Ljava/lang/String;
    .param p4, "slotType"    # I
    .param p5, "creativeAPI"    # Ljava/lang/String;
    .param p6, "wrapperType"    # Ljava/lang/String;

    .prologue
    .line 410
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 412
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v1, v1, Ltv/freewheel/hybrid/ad/AdContext;->adRenderers:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .line 413
    .local v7, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/AdRenderer;>;"
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 414
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdRenderer;

    .line 415
    .local v0, "adRenderer":Ltv/freewheel/hybrid/ad/AdRenderer;
    invoke-static {p4}, Ltv/freewheel/hybrid/ad/slot/Slot;->slotTypeString(I)Ljava/lang/String;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Ltv/freewheel/hybrid/ad/AdRenderer;->match(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 419
    .end local v0    # "adRenderer":Ltv/freewheel/hybrid/ad/AdRenderer;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getAdRenderer()I
    .locals 11

    .prologue
    .line 238
    const/4 v10, -0x1

    .line 239
    .local v10, "ret":I
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->getAllCreativeRenditions()Ljava/util/ArrayList;

    move-result-object v9

    .line 240
    .local v9, "renditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v8, v0, :cond_2

    .line 241
    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    .line 242
    .local v7, "cr":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v3

    .line 244
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

    .line 246
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    if-nez v0, :cond_1

    .line 247
    new-instance v0, Ltv/freewheel/hybrid/ad/AdRenderer;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v0, v1}, Ltv/freewheel/hybrid/ad/AdRenderer;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    .line 248
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    iput-object v3, v0, Ltv/freewheel/hybrid/ad/AdRenderer;->name:Ljava/lang/String;

    .line 250
    :cond_1
    const/4 v10, 0x0

    .line 264
    .end local v3    # "contentType":Ljava/lang/String;
    .end local v7    # "cr":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_2
    :goto_1
    return v10

    .line 254
    .restart local v3    # "contentType":Ljava/lang/String;
    .restart local v7    # "cr":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_3
    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getBaseUnit()Ljava/lang/String;

    move-result-object v1

    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iget-object v2, v0, Ltv/freewheel/hybrid/ad/Ad;->adUnit:Ljava/lang/String;

    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    iget v4, v0, Ltv/freewheel/hybrid/ad/slot/Slot;->timePositionClass:I

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWrapperType()Ljava/lang/String;

    move-result-object v6

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Ltv/freewheel/hybrid/ad/AdInstance;->findRenderer(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ltv/freewheel/hybrid/ad/AdRenderer;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    .line 256
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    if-eqz v0, :cond_5

    .line 257
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    if-eq v7, v0, :cond_4

    .line 258
    invoke-virtual {p0, v7}, Ltv/freewheel/hybrid/ad/AdInstance;->setActiveCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;)V

    .line 260
    :cond_4
    const/4 v10, 0x1

    .line 261
    goto :goto_1

    .line 240
    :cond_5
    add-int/lit8 v8, v8, 0x1

    goto :goto_0
.end method

.method private onRendererClicked(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 4
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 390
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "onRendererClicked"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 391
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v2

    const-string v3, "extraInfo"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    .line 392
    .local v1, "info":Landroid/os/Bundle;
    if-nez v1, :cond_0

    .line 393
    new-instance v1, Landroid/os/Bundle;

    .end local v1    # "info":Landroid/os/Bundle;
    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 395
    .restart local v1    # "info":Landroid/os/Bundle;
    :cond_0
    const-string v2, "message"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 396
    .local v0, "eventName":Ljava/lang/String;
    if-eqz v0, :cond_1

    const-string v2, "defaultClick"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 397
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;

    if-eqz v2, :cond_2

    .line 398
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;

    invoke-virtual {v2, v1}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->send(Landroid/os/Bundle;)V

    .line 406
    :goto_0
    return-void

    .line 400
    :cond_2
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "no default click callback"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 404
    :cond_3
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    invoke-virtual {v2, v0, v1}, Ltv/freewheel/hybrid/ad/CallbackManager;->callback(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private onRendererError(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 4
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 371
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "onRendererError"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 372
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IEvent;->getData()Ljava/util/HashMap;

    move-result-object v2

    const-string v3, "extraInfo"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    .line 373
    .local v0, "info":Landroid/os/Bundle;
    const-string v2, "errorCode"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Ltv/freewheel/hybrid/ad/AdInstance;->sendResellerNoAd(Ljava/lang/String;)V

    .line 376
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    if-eqz v2, :cond_0

    .line 377
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    iget-object v1, v2, Ltv/freewheel/hybrid/ad/AdRenderer;->url:Ljava/lang/String;

    .line 383
    .local v1, "moduleName":Ljava/lang/String;
    :goto_0
    const-string v2, "errorModule"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 384
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/CallbackManager;->errorHandler:Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;

    invoke-virtual {v2, v0}, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;->send(Landroid/os/Bundle;)V

    .line 385
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v2, p0}, Ltv/freewheel/hybrid/ad/state/RendererState;->fail(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 386
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v2, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->fail(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 387
    return-void

    .line 380
    .end local v1    # "moduleName":Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

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
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 153
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 154
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v7

    if-ge v4, v7, :cond_3

    .line 155
    invoke-interface {v1, v4}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 156
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v7

    const/4 v8, 0x1

    if-ne v7, v8, :cond_1

    .line 157
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    .line 158
    .local v5, "name":Ljava/lang/String;
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "parse(), name: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 160
    const-string v7, "adReference"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 161
    new-instance v0, Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v0, v7}, Ltv/freewheel/hybrid/ad/AdInstance;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .local v0, "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    move-object v7, v2

    .line 162
    check-cast v7, Lorg/w3c/dom/Element;

    const-string v8, "adSlotCustomId"

    invoke-interface {v7, v8}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 164
    .local v6, "slotCustomId":Ljava/lang/String;
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v7, v6}, Ltv/freewheel/hybrid/ad/AdContext;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v3

    check-cast v3, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    .line 165
    .local v3, "companionSlot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    if-nez v3, :cond_0

    .line 166
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-virtual {v7, v6}, Ltv/freewheel/hybrid/ad/AdRequest;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/slot/Slot;

    move-result-object v3

    .end local v3    # "companionSlot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    check-cast v3, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    .line 167
    .restart local v3    # "companionSlot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    if-eqz v3, :cond_0

    .line 168
    invoke-virtual {v3}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->copy()Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    move-result-object v3

    .line 169
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v7, v7, Ltv/freewheel/hybrid/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v7, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 172
    :cond_0
    if-eqz v3, :cond_1

    .line 173
    iput-object v3, v0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    .line 174
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v0, v2}, Ltv/freewheel/hybrid/ad/AdInstance;->parse(Lorg/w3c/dom/Element;)V

    .line 175
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 154
    .end local v0    # "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    .end local v3    # "companionSlot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    .end local v5    # "name":Ljava/lang/String;
    .end local v6    # "slotCustomId":Ljava/lang/String;
    :cond_1
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 178
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v5    # "name":Ljava/lang/String;
    :cond_2
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "ignore node: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 182
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
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 122
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 124
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_2

    .line 125
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 126
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 127
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 128
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "parse(), name: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 130
    const-string v5, "adReference"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 131
    new-instance v0, Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v0, v5}, Ltv/freewheel/hybrid/ad/AdInstance;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 132
    .local v0, "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    iput-object v5, v0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    .line 133
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v0, v2}, Ltv/freewheel/hybrid/ad/AdInstance;->parse(Lorg/w3c/dom/Element;)V

    .line 134
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdInstance;->fallbackAds:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 124
    .end local v0    # "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 136
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v4    # "name":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ignore node: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 140
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method private playCompanionAds()V
    .locals 5

    .prologue
    .line 939
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " playCompanionAds()"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 940
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 941
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 942
    .local v0, "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/slot/Slot;->isPauseMidroll()Z

    move-result v2

    iput-boolean v2, v0, Ltv/freewheel/hybrid/ad/AdInstance;->isCompanionAdOfPauseAd:Z

    .line 943
    iget-object v2, v0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iget-boolean v2, v2, Ltv/freewheel/hybrid/ad/Ad;->noLoad:Z

    if-nez v2, :cond_0

    .line 944
    iget-object v2, v0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    check-cast v2, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    invoke-virtual {v2, v0}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->playCompanionAdInstance(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 940
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 947
    .end local v0    # "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    :cond_1
    return-void
.end method

.method private sendResellerNoAd(Ljava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # Ljava/lang/String;

    .prologue
    .line 359
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

    .line 362
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    const-string v1, "resellerNoAd"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/ad/CallbackManager;->callback(Ljava/lang/String;)V

    .line 363
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->resellerNoAdDispatched:Z

    if-nez v0, :cond_1

    .line 364
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->resellerNoAdDispatched:Z

    .line 365
    const-string v0, "resellerNoAd"

    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    .line 368
    :cond_1
    return-void
.end method


# virtual methods
.method public adFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "errorCode"    # Ljava/lang/String;
    .param p2, "details"    # Ljava/lang/String;

    .prologue
    .line 296
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 297
    .local v0, "info":Landroid/os/Bundle;
    const-string v1, "errorCode"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    const-string v1, "errorInfo"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    const-string v2, "errorModule"

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    iget-object v1, v1, Ltv/freewheel/hybrid/ad/AdRenderer;->url:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    iget-object v1, v1, Ltv/freewheel/hybrid/ad/AdRenderer;->url:Ljava/lang/String;

    :goto_0
    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    iget-object v1, v1, Ltv/freewheel/hybrid/ad/CallbackManager;->errorHandler:Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;

    invoke-virtual {v1, v0}, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;->send(Landroid/os/Bundle;)V

    .line 301
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v1, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->fail(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 302
    return-void

    .line 299
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
    .line 756
    .local p3, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 757
    invoke-static {p1, p2, p3}, Ltv/freewheel/hybrid/ad/EventCallback;->validate(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    .line 758
    .local v0, "errors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-nez v2, :cond_1

    .line 759
    const-string v2, "CLICKTRACKING"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 760
    const-string p2, "CLICK"

    .line 762
    :cond_0
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    invoke-virtual {v2, p1, p2}, Ltv/freewheel/hybrid/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;

    move-result-object v1

    .line 763
    .local v1, "handler":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    invoke-virtual {v1, p3}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->addExternalTrackingURLs(Ljava/util/ArrayList;)V

    .line 768
    .end local v1    # "handler":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    :goto_0
    return-void

    .line 766
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v0}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public addOnActivityCallbackListener(Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;)V
    .locals 1
    .param p1, "listener"    # Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;

    .prologue
    .line 734
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/ad/AdContext;->addOnActivityCallbackListener(Ltv/freewheel/hybrid/renderers/interfaces/IActivityCallbackListener;)V

    .line 735
    return-void
.end method

.method public buildAdChain()Ltv/freewheel/hybrid/ad/AdChain;
    .locals 6

    .prologue
    .line 143
    new-instance v1, Ltv/freewheel/hybrid/ad/AdChain;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/ad/AdChain;-><init>(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 144
    .local v1, "adChain":Ltv/freewheel/hybrid/ad/AdChain;
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 145
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->fallbackAds:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 146
    .local v0, "ad":Ltv/freewheel/hybrid/ad/AdInstance;
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adChain:Ltv/freewheel/hybrid/ad/AdChain;

    invoke-virtual {v3, v0}, Ltv/freewheel/hybrid/ad/AdChain;->append(Ltv/freewheel/hybrid/ad/AdInstance;)V

    goto :goto_0

    .line 148
    .end local v0    # "ad":Ltv/freewheel/hybrid/ad/AdInstance;
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->fallbackAds:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 149
    return-object v1
.end method

.method public cloneForTranslation()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .locals 4

    .prologue
    .line 738
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "cloneForTranslation()"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 739
    new-instance v1, Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v1, v2}, Ltv/freewheel/hybrid/ad/AdInstance;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 740
    .local v1, "ret":Ltv/freewheel/hybrid/ad/AdInstance;
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/Ad;->cloneForTranslation()Ltv/freewheel/hybrid/ad/Ad;

    move-result-object v2

    iput-object v2, v1, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    .line 741
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/Creative;->cloneForTranslation()Ltv/freewheel/hybrid/ad/Creative;

    move-result-object v2

    iput-object v2, v1, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    .line 742
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    if-eqz v2, :cond_0

    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    iget v2, v2, Ltv/freewheel/hybrid/ad/CreativeRendition;->creativeRenditionId:I

    :goto_0
    iput v2, v1, Ltv/freewheel/hybrid/ad/AdInstance;->creativeRenditionId:I

    .line 744
    iget v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->replicaId:I

    iput v2, v1, Ltv/freewheel/hybrid/ad/AdInstance;->replicaId:I

    .line 745
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    iput-object v2, v1, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    .line 746
    iget-object v2, v1, Ltv/freewheel/hybrid/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 747
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 748
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/EventCallback;>;"
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 749
    iget-object v3, v1, Ltv/freewheel/hybrid/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/EventCallback;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/EventCallback;->cloneForTranslation()Ltv/freewheel/hybrid/ad/EventCallback;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 742
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/EventCallback;>;"
    :cond_0
    iget v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creativeRenditionId:I

    goto :goto_0

    .line 751
    .restart local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/EventCallback;>;"
    :cond_1
    iget-object v2, v1, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/ad/CallbackManager;->copyOtherHandlers(Ltv/freewheel/hybrid/ad/CallbackManager;)V

    .line 752
    return-object v1
.end method

.method public createCreativeRenditionForTranslation()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .locals 4

    .prologue
    .line 613
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "createCreativeRenditionForTranslation()"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 615
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/Creative;->createCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v0

    .line 616
    .local v0, "ret":Ltv/freewheel/hybrid/ad/CreativeRendition;
    iget v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creativeRenditionId:I

    iput v1, v0, Ltv/freewheel/hybrid/ad/CreativeRendition;->creativeRenditionId:I

    .line 617
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "createCreativeRenditionForTranslation(): returning "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 618
    return-object v0
.end method

.method public dispatchAdEvent(Ljava/lang/String;)V
    .locals 4
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 689
    new-instance v0, Ltv/freewheel/hybrid/utils/events/Event;

    invoke-direct {v0, p1}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 690
    .local v0, "event":Ltv/freewheel/hybrid/utils/events/Event;
    iget-object v1, v0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    const-string v2, "adId"

    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->getAdId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 691
    iget-object v1, v0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    const-string v2, "creativeId"

    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    iget v3, v3, Ltv/freewheel/hybrid/ad/Creative;->creativeId:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 692
    iget-object v1, v0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    const-string v2, "customId"

    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 693
    iget-object v1, v0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    const-string v2, "replicaId"

    iget v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->replicaId:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 694
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v1, v0}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 695
    return-void
.end method

.method public dispatchEvent(Ljava/lang/String;)V
    .locals 4
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 677
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 678
    new-instance v0, Ltv/freewheel/hybrid/utils/events/Event;

    invoke-direct {v0, p1}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 679
    .local v0, "event":Ltv/freewheel/hybrid/utils/events/Event;
    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 680
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
    .line 683
    .local p2, "extraInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v0, Ltv/freewheel/hybrid/utils/events/Event;

    invoke-direct {v0, p1}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 684
    .local v0, "event":Ltv/freewheel/hybrid/utils/events/Event;
    iput-object p2, v0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    .line 685
    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 686
    return-void
.end method

.method public getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    return-object v0
.end method

.method public bridge synthetic getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .locals 1

    .prologue
    .line 39
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v0

    return-object v0
.end method

.method public getActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 536
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v0

    return-object v0
.end method

.method public getAdId()I
    .locals 1

    .prologue
    .line 698
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iget v0, v0, Ltv/freewheel/hybrid/ad/Ad;->adId:I

    return v0
.end method

.method public getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .locals 0

    .prologue
    .line 452
    return-object p0
.end method

.method public getAllCreativeRenditions()Ljava/util/ArrayList;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 424
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    iget-object v1, v1, Ltv/freewheel/hybrid/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 425
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    iget-object v1, v1, Ltv/freewheel/hybrid/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 426
    .local v0, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    if-eqz v1, :cond_0

    .line 427
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 428
    const/4 v1, 0x0

    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    invoke-virtual {v0, v1, v2}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 430
    :cond_0
    return-object v0
.end method

.method public getCompanionAdInstances()Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation

    .prologue
    .line 978
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 979
    .local v2, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 980
    .local v0, "ad":Ltv/freewheel/hybrid/ad/AdInstance;
    iget-object v3, v0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iget-boolean v3, v3, Ltv/freewheel/hybrid/ad/Ad;->noLoad:Z

    if-nez v3, :cond_0

    .line 981
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 984
    .end local v0    # "ad":Ltv/freewheel/hybrid/ad/AdInstance;
    :cond_1
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " getCompanionAdInstances() "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 985
    return-object v2
.end method

.method public getCompanionSlots()Ljava/util/ArrayList;
    .locals 6
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
    .line 722
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 723
    .local v2, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 724
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 725
    .local v0, "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    iget-object v3, v0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iget-boolean v3, v3, Ltv/freewheel/hybrid/ad/Ad;->noLoad:Z

    if-eqz v3, :cond_0

    .line 726
    iget-object v3, v0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 723
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 729
    .end local v0    # "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    :cond_1
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 730
    return-object v2
.end method

.method public getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .locals 1

    .prologue
    .line 532
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v0

    return-object v0
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
    .line 771
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 772
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 773
    .local v1, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    invoke-virtual {v2, p1, p2}, Ltv/freewheel/hybrid/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;

    move-result-object v0

    .line 774
    .local v0, "handler":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    if-eqz v0, :cond_5

    .line 775
    const-string v2, "ERROR"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 776
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getInternalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 797
    :cond_0
    :goto_0
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "getEventCallbackURLs() Returning "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 798
    return-object v1

    .line 778
    :cond_1
    const-string v2, "CLICK"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 779
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->isShowBrowser()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 780
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getInternalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 783
    :cond_2
    const-string v2, "CLICKTRACKING"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 784
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->isShowBrowser()Z

    move-result v2

    if-nez v2, :cond_3

    .line 785
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getInternalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 787
    :cond_3
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getTrackingURLs()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 790
    :cond_4
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getInternalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 791
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getTrackingURLs()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 795
    :cond_5
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "getEventCallbackURLs: failed to get event callback handler!"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getMetrValue()I
    .locals 1

    .prologue
    .line 544
    iget v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->metrValue:I

    return v0
.end method

.method public getParameter(Ljava/lang/String;)Ljava/lang/Object;
    .locals 7
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 456
    const/4 v3, 0x0

    .line 457
    .local v3, "value":Ljava/lang/Object;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 458
    .local v1, "paramArray":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdRequest;->overrideLevelParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 461
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    if-eqz v4, :cond_0

    .line 462
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/CreativeRendition;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 465
    :cond_0
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    if-eqz v4, :cond_1

    .line 466
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/Creative;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 469
    :cond_1
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    if-eqz v4, :cond_2

    .line 470
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/slot/Slot;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 473
    :cond_2
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdResponse;->profileParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 474
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdRequest;->globalLevelParameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 476
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    if-eqz v4, :cond_3

    .line 477
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdRenderer;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 480
    :cond_3
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 482
    .end local v3    # "value":Ljava/lang/Object;
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :cond_4
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 483
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/HashMap;

    .line 484
    .local v2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 485
    .restart local v3    # "value":Ljava/lang/Object;
    if-eqz v3, :cond_4

    .line 490
    .end local v2    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v3    # "value":Ljava/lang/Object;
    :cond_5
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 491
    return-object v3
.end method

.method public getRenderableCreativeRenditions()Ljava/util/ArrayList;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 435
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 436
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 437
    .local v9, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

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

    check-cast v7, Ltv/freewheel/hybrid/ad/CreativeRendition;

    .line 438
    .local v7, "cr":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getBaseUnit()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/Ad;->adUnit:Ljava/lang/String;

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    iget v4, v4, Ltv/freewheel/hybrid/ad/slot/Slot;->timePositionClass:I

    invoke-static {v4}, Ltv/freewheel/hybrid/ad/slot/Slot;->slotTypeString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWrapperType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Ltv/freewheel/hybrid/ad/AdRenderer;->match(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 440
    :cond_1
    invoke-virtual {v9, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 444
    .end local v7    # "cr":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_2
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    if-eqz v0, :cond_3

    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 445
    const/4 v0, 0x0

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    invoke-virtual {v9, v0, v1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 447
    :cond_3
    return-object v9
.end method

.method public getReplicaId()I
    .locals 1

    .prologue
    .line 702
    iget v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->replicaId:I

    return v0
.end method

.method public getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .locals 1

    .prologue
    .line 495
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .prologue
    .line 540
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget v0, v0, Ltv/freewheel/hybrid/ad/AdContext;->version:I

    return v0
.end method

.method public isPlayable()Z
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 200
    const/4 v0, 0x1

    .line 201
    .local v0, "ret":Z
    if-eqz v0, :cond_1

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v5

    if-ne v4, v5, :cond_0

    iget-boolean v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->imprSent:Z

    if-eqz v4, :cond_1

    :cond_0
    move v0, v2

    .line 202
    :goto_0
    if-nez v0, :cond_2

    .line 203
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " isPlayable returning false because adState is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " and imprSent is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->imprSent:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    move v1, v0

    .line 212
    .end local v0    # "ret":Z
    .local v1, "ret":I
    :goto_1
    return v1

    .end local v1    # "ret":I
    .restart local v0    # "ret":Z
    :cond_1
    move v0, v3

    .line 201
    goto :goto_0

    .line 206
    :cond_2
    if-eqz v0, :cond_4

    iget-boolean v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->scheduledDrivingAd:Z

    if-eqz v4, :cond_3

    iget-boolean v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->scheduledDrivingAd:Z

    if-eqz v4, :cond_4

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdLoadedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v5

    if-ne v4, v5, :cond_4

    :cond_3
    move v0, v2

    .line 207
    :goto_2
    if-nez v0, :cond_5

    .line 208
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " isPlayable returning false becasue scheduledDrivingAd is true"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    move v1, v0

    .line 209
    .restart local v1    # "ret":I
    goto :goto_1

    .end local v1    # "ret":I
    :cond_4
    move v0, v3

    .line 206
    goto :goto_2

    .line 211
    :cond_5
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    move v1, v0

    .line 212
    .restart local v1    # "ret":I
    goto :goto_1
.end method

.method public loadRenderer()V
    .locals 3

    .prologue
    .line 219
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "loadRenderer()"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 220
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    if-nez v1, :cond_0

    .line 221
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->getAdRenderer()I

    .line 224
    :cond_0
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    if-eqz v1, :cond_1

    .line 225
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->onRendererModuleLoaded()V

    .line 231
    :goto_0
    return-void

    .line 227
    :cond_1
    const-string v0, "no renderer matched"

    .line 228
    .local v0, "errorInfo":Ljava/lang/String;
    const-string v1, "_e_no-renderer"

    invoke-virtual {p0, v1, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->adFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onRendererLoaded(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 2
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 328
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onRendererLoaded"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 329
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->notifyAdLoaded(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 330
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->commitAdInstances()V

    .line 331
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adChain:Ltv/freewheel/hybrid/ad/AdChain;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/AdChain;->chainBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/ad/ChainBehavior;->isDestState(Ltv/freewheel/hybrid/ad/state/AdState;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 332
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 336
    :goto_0
    return-void

    .line 334
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->play(Ltv/freewheel/hybrid/ad/AdInstance;)V

    goto :goto_0
.end method

.method public onRendererModuleLoaded()V
    .locals 5

    .prologue
    .line 268
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/CreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v0

    .line 269
    .local v0, "asset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    if-eqz v0, :cond_0

    .line 270
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "startPlay: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getURL()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 276
    :goto_0
    :try_start_0
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adRenderer:Ltv/freewheel/hybrid/ad/AdRenderer;

    invoke-static {v2}, Ltv/freewheel/hybrid/ad/AdRenderer;->getRenderer(Ltv/freewheel/hybrid/ad/AdRenderer;)Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    .line 277
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    if-nez v2, :cond_1

    .line 278
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "can not find a renderer to play"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 279
    const-string v2, "_e_renderer-load"

    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->additionalErrorInfo:Ljava/lang/String;

    invoke-virtual {p0, v2, v3}, Ltv/freewheel/hybrid/ad/AdInstance;->adFailed(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1

    .line 293
    :goto_1
    return-void

    .line 272
    :cond_0
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "startPlay: no assets"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 281
    :cond_1
    :try_start_1
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/RendererInitState;->Instance()Ltv/freewheel/hybrid/ad/state/RendererState;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    .line 282
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v2, p0}, Ltv/freewheel/hybrid/ad/state/RendererState;->load(Ltv/freewheel/hybrid/ad/AdInstance;)V
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 284
    :catch_0
    move-exception v1

    .line 285
    .local v1, "e":Ljava/lang/IllegalAccessException;
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "IllegalAccessException"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 286
    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    .line 287
    const-string v2, "_e_renderer-load"

    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Ltv/freewheel/hybrid/ad/AdInstance;->adFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 288
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v1

    .line 289
    .local v1, "e":Ljava/lang/InstantiationException;
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "InstantiationException"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 290
    invoke-virtual {v1}, Ljava/lang/InstantiationException;->printStackTrace()V

    .line 291
    const-string v2, "_e_renderer-load"

    invoke-virtual {v1}, Ljava/lang/InstantiationException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Ltv/freewheel/hybrid/ad/AdInstance;->adFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onRendererStarted(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 3
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 339
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " onRendererStarted()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 340
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->commitAdInstances()V

    .line 342
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->scheduledDrivingAd:Z

    if-nez v0, :cond_0

    .line 343
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/ad/CallbackManager;->sendDefaultImpression(Z)V

    .line 344
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->playCompanionAds()V

    .line 346
    :cond_0
    return-void
.end method

.method public onRendererStopped(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 2
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 349
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onRendererStopped"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 350
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->scheduledDrivingAd:Z

    if-nez v0, :cond_0

    .line 351
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/ad/CallbackManager;->sendDefaultImpression(Z)V

    .line 354
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/RendererState;->dispose(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 355
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->complete(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 356
    return-void
.end method

.method public onStartPlay()V
    .locals 2

    .prologue
    .line 973
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onStartPlay()"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 974
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/RendererState;->start(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 975
    return-void
.end method

.method public onStopPlay()V
    .locals 2

    .prologue
    .line 321
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onStopPlay"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 322
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    if-eqz v0, :cond_0

    .line 323
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/RendererState;->stop(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 325
    :cond_0
    return-void
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 9
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 75
    const-string v6, "adId"

    invoke-interface {p1, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ltv/freewheel/hybrid/ad/AdInstance;->tryParseInt(Ljava/lang/String;)I

    move-result v0

    .line 78
    .local v0, "adId":I
    const-string v6, "creativeId"

    invoke-interface {p1, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ltv/freewheel/hybrid/ad/AdInstance;->tryParseInt(Ljava/lang/String;)I

    move-result v3

    .line 81
    .local v3, "creativeId":I
    const-string v6, "creativeRenditionId"

    invoke-interface {p1, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ltv/freewheel/hybrid/ad/AdInstance;->tryParseInt(Ljava/lang/String;)I

    move-result v6

    iput v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creativeRenditionId:I

    .line 84
    const-string v6, "replicaId"

    invoke-interface {p1, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const/4 v7, -0x1

    invoke-static {v6, v7}, Ltv/freewheel/hybrid/ad/AdInstance;->tryParseInt(Ljava/lang/String;I)I

    move-result v6

    iput v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->replicaId:I

    .line 87
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->getAdResponse()Ltv/freewheel/hybrid/ad/AdResponse;

    move-result-object v6

    invoke-virtual {v6, v0}, Ltv/freewheel/hybrid/ad/AdResponse;->getAd(I)Ltv/freewheel/hybrid/ad/Ad;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    .line 88
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    if-nez v6, :cond_0

    .line 89
    new-instance v6, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "bad adId: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 92
    :cond_0
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    invoke-virtual {v6, v3}, Ltv/freewheel/hybrid/ad/Ad;->getCreative(I)Ltv/freewheel/hybrid/ad/Creative;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    .line 93
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    if-nez v6, :cond_1

    .line 94
    new-instance v6, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "bad creativeId: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 97
    :cond_1
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creative:Ltv/freewheel/hybrid/ad/Creative;

    iget v7, p0, Ltv/freewheel/hybrid/ad/AdInstance;->creativeRenditionId:I

    iget v8, p0, Ltv/freewheel/hybrid/ad/AdInstance;->replicaId:I

    invoke-virtual {v6, v7, v8}, Ltv/freewheel/hybrid/ad/Creative;->getRendition(II)Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    .line 100
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 101
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v6

    if-ge v4, v6, :cond_6

    .line 102
    invoke-interface {v1, v4}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 103
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v6

    const/4 v7, 0x1

    if-ne v6, v7, :cond_2

    .line 104
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    .line 105
    .local v5, "name":Ljava/lang/String;
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "parse(), name: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 107
    const-string v6, "eventCallbacks"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 108
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v2}, Ltv/freewheel/hybrid/ad/AdInstance;->parseEventCallbacks(Lorg/w3c/dom/Element;)V

    .line 109
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    invoke-virtual {v6}, Ltv/freewheel/hybrid/ad/CallbackManager;->init()V

    .line 101
    .end local v5    # "name":Ljava/lang/String;
    :cond_2
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 110
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v5    # "name":Ljava/lang/String;
    :cond_3
    const-string v6, "companionAds"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 111
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v2}, Ltv/freewheel/hybrid/ad/AdInstance;->parseCompanionAds(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 112
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_4
    const-string v6, "fallbackAds"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 113
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v2}, Ltv/freewheel/hybrid/ad/AdInstance;->parseFallbackAds(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 115
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_5
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "ignore node: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 119
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v5    # "name":Ljava/lang/String;
    :cond_6
    return-void
.end method

.method public play()V
    .locals 3

    .prologue
    .line 185
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " play()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 186
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adChain:Ltv/freewheel/hybrid/ad/AdChain;

    invoke-static {}, Ltv/freewheel/hybrid/ad/ChainBehavior;->getPlayBehavior()Ltv/freewheel/hybrid/ad/ChainBehavior;

    move-result-object v1

    iput-object v1, v0, Ltv/freewheel/hybrid/ad/AdChain;->chainBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    .line 187
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->play(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 188
    return-void
.end method

.method public play2()V
    .locals 2

    .prologue
    .line 994
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    const/4 v1, 0x0

    iput-object v1, v0, Ltv/freewheel/hybrid/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    .line 995
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->play()V

    .line 996
    return-void
.end method

.method public preload()V
    .locals 3

    .prologue
    .line 967
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " preload()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 968
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->adChain:Ltv/freewheel/hybrid/ad/AdChain;

    invoke-static {}, Ltv/freewheel/hybrid/ad/ChainBehavior;->getPreloadBehavior()Ltv/freewheel/hybrid/ad/ChainBehavior;

    move-result-object v1

    iput-object v1, v0, Ltv/freewheel/hybrid/ad/AdChain;->chainBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    .line 969
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->load(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 970
    return-void
.end method

.method public resume()V
    .locals 2

    .prologue
    .line 527
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "resume"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 528
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->play(Ltv/freewheel/hybrid/ad/AdInstance;)V

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
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation

    .prologue
    .line 838
    .local p1, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 839
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    .line 840
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v1, v4, :cond_4

    .line 841
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 842
    .local v3, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    if-ne v4, v3, :cond_2

    .line 843
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->cloneForTranslation()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 852
    :cond_0
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-gt v4, v1, :cond_1

    .line 853
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ".scheduleAd: bad slot: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 854
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 840
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 845
    :cond_2
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 846
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 847
    .local v0, "companionAd":Ltv/freewheel/hybrid/ad/AdInstance;
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v4

    if-ne v3, v4, :cond_3

    iget-object v4, v0, Ltv/freewheel/hybrid/ad/AdInstance;->ad:Ltv/freewheel/hybrid/ad/Ad;

    iget-boolean v4, v4, Ltv/freewheel/hybrid/ad/Ad;->noLoad:Z

    if-eqz v4, :cond_3

    .line 848
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdInstance;->cloneForTranslation()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 845
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 857
    .end local v0    # "companionAd":Ltv/freewheel/hybrid/ad/AdInstance;
    .end local v2    # "j":I
    .end local v3    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_4
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "scheduleAdInstances(): returning "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 858
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdInstance;->translatedAds:Ljava/util/ArrayList;

    return-object v4
.end method

.method public setActiveCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;)V
    .locals 1
    .param p1, "rendition"    # Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    .prologue
    .line 605
    if-nez p1, :cond_0

    .line 606
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    .line 610
    .end local p1    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :goto_0
    return-void

    .line 609
    .restart local p1    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_0
    check-cast p1, Ltv/freewheel/hybrid/ad/CreativeRendition;

    .end local p1    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->primaryCreativeRendition:Ltv/freewheel/hybrid/ad/CreativeRendition;

    goto :goto_0
.end method

.method public setClickThroughURL(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "clickName"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    .line 802
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 803
    if-eqz p2, :cond_0

    const-string v3, ""

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 804
    :cond_0
    const-string p2, "defaultClick"

    .line 806
    :cond_1
    const-string v3, "CLICK"

    invoke-virtual {p0, p2, v3, v6}, Ltv/freewheel/hybrid/ad/AdInstance;->fetchEventCallback(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/EventCallback;

    move-result-object v0

    .line 808
    .local v0, "evtCbk":Ltv/freewheel/hybrid/ad/EventCallback;
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    const-string v4, "CLICK"

    invoke-virtual {v3, p2, v4}, Ltv/freewheel/hybrid/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;

    .line 810
    .local v1, "handler":Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;
    if-eqz v1, :cond_2

    .line 811
    invoke-virtual {v1, v6}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->setShowBrowserValue(Z)V

    .line 812
    const-string v3, "cr"

    invoke-virtual {v1, v3, p1}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 835
    :goto_0
    return-void

    .line 815
    :cond_2
    if-eqz v0, :cond_4

    .line 816
    iget-object v3, v0, Ltv/freewheel/hybrid/ad/EventCallback;->type:Ljava/lang/String;

    const-string v4, "GENERIC"

    if-ne v3, v4, :cond_3

    .line 817
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/EventCallback;->cloneForTranslation()Ltv/freewheel/hybrid/ad/EventCallback;

    move-result-object v2

    .line 818
    .local v2, "newClickCbk":Ltv/freewheel/hybrid/ad/EventCallback;
    const-string v3, "CLICK"

    iput-object v3, v2, Ltv/freewheel/hybrid/ad/EventCallback;->type:Ljava/lang/String;

    .line 819
    iput-object p2, v2, Ltv/freewheel/hybrid/ad/EventCallback;->name:Ljava/lang/String;

    .line 820
    iput-boolean v6, v2, Ltv/freewheel/hybrid/ad/EventCallback;->showBrowser:Z

    .line 821
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 826
    .end local v2    # "newClickCbk":Ltv/freewheel/hybrid/ad/EventCallback;
    :goto_1
    const-string v3, "CLICK"

    invoke-virtual {p0, p2, v3, v6}, Ltv/freewheel/hybrid/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;

    move-result-object v1

    .end local v1    # "handler":Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;
    check-cast v1, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;

    .line 827
    .restart local v1    # "handler":Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;
    const-string v3, "cr"

    invoke-virtual {v1, v3, p1}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 828
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->callbackManager:Ltv/freewheel/hybrid/ad/CallbackManager;

    const-string v4, "CLICK"

    invoke-virtual {v3, p2, v4, v1}, Ltv/freewheel/hybrid/ad/CallbackManager;->addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;)V

    goto :goto_0

    .line 824
    :cond_3
    iput-boolean v6, v0, Ltv/freewheel/hybrid/ad/EventCallback;->showBrowser:Z

    goto :goto_1

    .line 832
    :cond_4
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "Failed to find generic callback for template."

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setRendererCapability(Ljava/lang/String;I)V
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "status"    # I

    .prologue
    .line 499
    sget-object v1, Ltv/freewheel/hybrid/ad/InternalConstants;->METR_MAP:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 500
    .local v0, "mask":Ljava/lang/Integer;
    if-nez v0, :cond_0

    .line 513
    :goto_0
    return-void

    .line 503
    :cond_0
    const-string v1, "defaultClick"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 504
    if-nez p2, :cond_2

    const/4 p2, 0x1

    .line 506
    :cond_1
    :goto_1
    if-nez p2, :cond_3

    .line 507
    iget v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->metrValue:I

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    or-int/2addr v1, v2

    iput v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->metrValue:I

    .line 512
    :goto_2
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setRendererCapability metrValue is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Ltv/freewheel/hybrid/ad/AdInstance;->metrValue:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 504
    :cond_2
    const/4 p2, 0x0

    goto :goto_1

    .line 509
    :cond_3
    iget v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->metrValue:I

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    neg-int v2, v2

    xor-int/lit8 v2, v2, -0x1

    and-int/2addr v1, v2

    iput v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->metrValue:I

    goto :goto_2
.end method

.method public stop()V
    .locals 3

    .prologue
    .line 191
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " stop()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 192
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/AdState;->stop(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 193
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 950
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[AdInst adId:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/AdInstance;->getAdId()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " replicaId:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->replicaId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
