.class public Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;
.super Ljava/lang/Object;
.source "MedialetsExtension.java"

# interfaces
.implements Ltv/freewheel/hybrid/extension/IExtension;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$5;,
        Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;
    }
.end annotation


# static fields
.field private static sAdContextCounter:I

.field private static sFailedToBuildReflection:Z

.field private static sPauseCounter:I

.field private static sServiceConnected:Z


# instance fields
.field private activityStateChangedEventListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

.field private constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private medialetsAdmanager:Ljava/lang/Object;

.field private medialetsAdmanagerClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private medialetsAdmanagerServiceListenerInterface:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private medialetsAdmanagerServiceProxy:Ljava/lang/Object;

.field private requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private setServiceListenerMethod:Ljava/lang/reflect/Method;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 32
    sput-boolean v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sFailedToBuildReflection:Z

    .line 36
    sput v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sAdContextCounter:I

    .line 37
    sput v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I

    .line 38
    const/4 v0, 0x1

    sput-boolean v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sFailedToBuildReflection:Z

    .line 39
    sput-boolean v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sServiceConnected:Z

    .line 40
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 160
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 162
    new-instance v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$2;-><init>(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->activityStateChangedEventListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 54
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 55
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;Z)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;
    .param p1, "x1"    # Z

    .prologue
    .line 24
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->performListener(Z)V

    return-void
.end method

.method static synthetic access$1000(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Z
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    .prologue
    .line 24
    invoke-direct {p0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->anyMedialetsAdInResponse()Z

    move-result v0

    return v0
.end method

.method static synthetic access$102(Z)Z
    .locals 0
    .param p0, "x0"    # Z

    .prologue
    .line 24
    sput-boolean p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sServiceConnected:Z

    return p0
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    .prologue
    .line 24
    invoke-direct {p0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->turnOnServiceConnected()V

    return-void
.end method

.method static synthetic access$300(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    return-object v0
.end method

.method static synthetic access$400(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IEventListener;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->activityStateChangedEventListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    return-object v0
.end method

.method static synthetic access$500(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    return-object v0
.end method

.method static synthetic access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method static synthetic access$700()I
    .locals 1

    .prologue
    .line 24
    sget v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I

    return v0
.end method

.method static synthetic access$702(I)I
    .locals 0
    .param p0, "x0"    # I

    .prologue
    .line 24
    sput p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I

    return p0
.end method

.method static synthetic access$708()I
    .locals 2

    .prologue
    .line 24
    sget v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I

    return v0
.end method

.method static synthetic access$710()I
    .locals 2

    .prologue
    .line 24
    sget v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I

    add-int/lit8 v1, v0, -0x1

    sput v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I

    return v0
.end method

.method static synthetic access$800(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;
    .param p1, "x1"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    .prologue
    .line 24
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->preformMethod(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;)V

    return-void
.end method

.method static synthetic access$900(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    .prologue
    .line 24
    invoke-direct {p0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->onServiceConnected()V

    return-void
.end method

.method private anyMedialetsAdInResponse()Z
    .locals 8

    .prologue
    .line 58
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 59
    .local v5, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getSiteSectionNonTemporalSlots()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 60
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getVideoPlayerNonTemporalSlots()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 61
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getTemporalSlots()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 62
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 63
    .local v4, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    check-cast v4, Ltv/freewheel/hybrid/ad/slot/Slot;

    .end local v4    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-virtual {v4}, Ltv/freewheel/hybrid/ad/slot/Slot;->getAdInstancesInPlayPlan()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 64
    .local v0, "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v1

    .line 65
    .local v1, "cr":Ltv/freewheel/hybrid/ad/CreativeRendition;
    if-eqz v1, :cond_1

    const-string v6, "external/medialets"

    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/CreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 66
    const/4 v6, 0x1

    .line 70
    .end local v0    # "adInstance":Ltv/freewheel/hybrid/ad/AdInstance;
    .end local v1    # "cr":Ltv/freewheel/hybrid/ad/CreativeRendition;
    .end local v3    # "i$":Ljava/util/Iterator;
    :goto_0
    return v6

    :cond_2
    const/4 v6, 0x0

    goto :goto_0
.end method

.method private onServiceConnected()V
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onServiceConnected"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 79
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;-><init>(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 87
    return-void
.end method

.method private performListener(Z)V
    .locals 7
    .param p1, "bind"    # Z

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 90
    new-array v0, v6, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v4, v0, v5

    .line 91
    .local v0, "args":[Ljava/lang/Object;
    if-eqz p1, :cond_0

    .line 92
    new-array v0, v6, [Ljava/lang/Object;

    .end local v0    # "args":[Ljava/lang/Object;
    iget-object v4, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerServiceProxy:Ljava/lang/Object;

    aput-object v4, v0, v5

    .line 94
    .restart local v0    # "args":[Ljava/lang/Object;
    :cond_0
    const-string v2, ""

    .line 95
    .local v2, "logMsg":Ljava/lang/String;
    const/4 v3, 0x0

    .line 97
    .local v3, "succeed":Z
    :try_start_0
    iget-object v4, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->setServiceListenerMethod:Ljava/lang/reflect/Method;

    iget-object v5, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanager:Ljava/lang/Object;

    invoke-virtual {v4, v5, v0}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_2

    .line 98
    const/4 v3, 0x1

    .line 106
    :goto_0
    if-nez v3, :cond_1

    .line 107
    iget-object v4, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v4, v2}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 109
    :cond_1
    return-void

    .line 99
    :catch_0
    move-exception v1

    .line 100
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v1}, Ljava/lang/IllegalArgumentException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 105
    goto :goto_0

    .line 101
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v1

    .line 102
    .local v1, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 105
    goto :goto_0

    .line 103
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v1

    .line 104
    .local v1, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v1}, Ljava/lang/reflect/InvocationTargetException;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method private preformMethod(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;)V
    .locals 11
    .param p1, "state"    # Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    .prologue
    .line 112
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "preformMethod("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 113
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 114
    .local v1, "host":Landroid/app/Activity;
    if-nez v1, :cond_1

    .line 115
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v7, "The activity is not set in ad context"

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 158
    :cond_0
    :goto_0
    return-void

    .line 118
    :cond_1
    const/4 v5, 0x0

    .line 119
    .local v5, "succeed":Z
    const-string v2, ""

    .line 120
    .local v2, "logMsg":Ljava/lang/String;
    const/4 v4, 0x0

    .line 122
    .local v4, "stateMethod":Ljava/lang/reflect/Method;
    :try_start_0
    sget-object v6, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$5;->$SwitchMap$tv$freewheel$hybrid$extension$medialets$MedialetsExtension$MedialetsAdmanagerState:[I

    invoke-virtual {p1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->ordinal()I

    move-result v7

    aget v6, v6, v7
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_4

    packed-switch v6, :pswitch_data_0

    .line 136
    :goto_1
    :try_start_1
    sget-object v6, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->START:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    if-ne v6, p1, :cond_2

    .line 137
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "setCurrentActivity, at state "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 138
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerClass:Ljava/lang/Class;

    const-string v7, "setCurrentActivity"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Class;

    const/4 v9, 0x0

    const-class v10, Landroid/app/Activity;

    aput-object v10, v8, v9

    invoke-virtual {v6, v7, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 139
    .local v3, "setCurrentActivity":Ljava/lang/reflect/Method;
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanager:Ljava/lang/Object;

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v1, v7, v8

    invoke-virtual {v3, v6, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    .end local v3    # "setCurrentActivity":Ljava/lang/reflect/Method;
    :cond_2
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanager:Ljava/lang/Object;

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v1, v7, v8

    invoke-virtual {v4, v6, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_4

    .line 142
    const/4 v5, 0x1

    .line 155
    :goto_2
    if-nez v5, :cond_0

    .line 156
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v6, v2}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 124
    :pswitch_0
    :try_start_2
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerClass:Ljava/lang/Class;

    const-string v7, "start"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Class;

    const/4 v9, 0x0

    const-class v10, Landroid/app/Activity;

    aput-object v10, v8, v9

    invoke-virtual {v6, v7, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 125
    goto :goto_1

    .line 127
    :pswitch_1
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerClass:Ljava/lang/Class;

    const-string v7, "resume"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Class;

    const/4 v9, 0x0

    const-class v10, Landroid/app/Activity;

    aput-object v10, v8, v9

    invoke-virtual {v6, v7, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 128
    goto :goto_1

    .line 130
    :pswitch_2
    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerClass:Ljava/lang/Class;

    const-string v7, "stop"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Class;

    const/4 v9, 0x0

    const-class v10, Landroid/app/Activity;

    aput-object v10, v8, v9

    invoke-virtual {v6, v7, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 131
    goto/16 :goto_1

    .line 143
    :catch_0
    move-exception v0

    .line 144
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 149
    goto :goto_2

    .line 145
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v0

    .line 146
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 149
    goto :goto_2

    .line 147
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v0

    .line 148
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/SecurityException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_2 .. :try_end_2} :catch_4

    move-result-object v2

    goto :goto_2

    .line 150
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_3
    move-exception v0

    .line 151
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-virtual {v0}, Ljava/lang/SecurityException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 154
    goto :goto_2

    .line 152
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_4
    move-exception v0

    .line 153
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " method is not available , exception:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_2

    .line 122
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private turnOnServiceConnected()V
    .locals 4

    .prologue
    .line 74
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    const-string v1, "extension.medialets.service_connected"

    const-string v2, "true"

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->PARAMETER_LEVEL_OVERRIDE()I

    move-result v3

    invoke-interface {v0, v1, v2, v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->setParameter(Ljava/lang/String;Ljava/lang/Object;I)V

    .line 75
    return-void
.end method


# virtual methods
.method public init(Ltv/freewheel/hybrid/ad/interfaces/IAdContext;)V
    .locals 8
    .param p1, "adContext"    # Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    .prologue
    const/4 v5, 0x1

    .line 184
    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "init"

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 185
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    .line 186
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .line 188
    sget v3, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sAdContextCounter:I

    add-int/lit8 v3, v3, 0x1

    sput v3, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sAdContextCounter:I

    .line 189
    sget v3, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sAdContextCounter:I

    if-eq v3, v5, :cond_1

    .line 190
    sget-boolean v3, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sServiceConnected:Z

    if-eqz v3, :cond_0

    .line 191
    invoke-direct {p0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->turnOnServiceConnected()V

    .line 257
    :cond_0
    :goto_0
    return-void

    .line 196
    :cond_1
    const-string v2, ""

    .line 198
    .local v2, "logMsg":Ljava/lang/String;
    :try_start_0
    const-string v3, "com.medialets.advertising.AdManager"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerClass:Ljava/lang/Class;

    .line 199
    const-string v3, "com.medialets.advertising.AdManager$ServiceListener"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerServiceListenerInterface:Ljava/lang/Class;

    .line 200
    iget-object v4, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerClass:Ljava/lang/Class;

    const-string v5, "getInstance"

    const/4 v3, 0x0

    check-cast v3, [Ljava/lang/Class;

    invoke-virtual {v4, v5, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 201
    .local v1, "getInstance":Ljava/lang/reflect/Method;
    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerClass:Ljava/lang/Class;

    const-string v4, "setServiceListener"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Class;

    const/4 v6, 0x0

    iget-object v7, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerServiceListenerInterface:Ljava/lang/Class;

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->setServiceListenerMethod:Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_5

    .line 203
    const/4 v3, 0x0

    :try_start_1
    check-cast v3, [Ljava/lang/Object;

    invoke-virtual {v1, p0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanager:Ljava/lang/Object;

    .line 204
    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerServiceListenerInterface:Ljava/lang/Class;

    invoke-virtual {v3}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    iget-object v6, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerServiceListenerInterface:Ljava/lang/Class;

    aput-object v6, v4, v5

    new-instance v5, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$3;

    invoke-direct {v5, p0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$3;-><init>(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V

    invoke-static {v3, v4, v5}, Ljava/lang/reflect/Proxy;->newProxyInstance(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->medialetsAdmanagerServiceProxy:Ljava/lang/Object;

    .line 215
    const/4 v3, 0x0

    sput-boolean v3, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sFailedToBuildReflection:Z
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_5

    .line 231
    .end local v1    # "getInstance":Ljava/lang/reflect/Method;
    :goto_1
    sget-boolean v3, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sFailedToBuildReflection:Z

    if-eqz v3, :cond_2

    .line 232
    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v3, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 216
    .restart local v1    # "getInstance":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v0

    .line 217
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 222
    goto :goto_1

    .line 218
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v0

    .line 219
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 222
    goto :goto_1

    .line 220
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v0

    .line 221
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/ClassNotFoundException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/SecurityException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/lang/NoSuchMethodException; {:try_start_2 .. :try_end_2} :catch_5

    move-result-object v2

    goto :goto_1

    .line 223
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    .end local v1    # "getInstance":Ljava/lang/reflect/Method;
    :catch_3
    move-exception v0

    .line 224
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "com.medialets.advertising.AdManager is not available , exception:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 229
    goto :goto_1

    .line 225
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_4
    move-exception v0

    .line 226
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-virtual {v0}, Ljava/lang/SecurityException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 229
    goto :goto_1

    .line 227
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_5
    move-exception v0

    .line 228
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "getInstance is not available , exception:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 236
    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :cond_2
    new-instance v3, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;

    invoke-direct {v3, p0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$4;-><init>(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V

    iput-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 256
    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v4, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_REQUEST_COMPLETE()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v3, v4, v5}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    goto/16 :goto_0
.end method

.method public stop()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 264
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 265
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    const-string v1, "extension.medialets.service_connected"

    const-string v2, "false"

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->PARAMETER_LEVEL_OVERRIDE()I

    move-result v3

    invoke-interface {v0, v1, v2, v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->setParameter(Ljava/lang/String;Ljava/lang/Object;I)V

    .line 266
    sget v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sAdContextCounter:I

    add-int/lit8 v0, v0, -0x1

    sput v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sAdContextCounter:I

    .line 267
    sget v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sAdContextCounter:I

    if-eqz v0, :cond_1

    .line 280
    :cond_0
    :goto_0
    return-void

    .line 270
    :cond_1
    sget-boolean v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sFailedToBuildReflection:Z

    if-nez v0, :cond_0

    .line 273
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_REQUEST_COMPLETE()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->removeEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 274
    sget-boolean v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sServiceConnected:Z

    if-eqz v0, :cond_0

    .line 275
    sput-boolean v4, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sServiceConnected:Z

    .line 276
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ACTIVITY_STATE_CHANGED()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->activityStateChangedEventListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->removeEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 277
    sput v4, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sPauseCounter:I

    .line 278
    sget-object v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->STOP:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->preformMethod(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;)V

    goto :goto_0
.end method
