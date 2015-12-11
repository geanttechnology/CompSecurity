.class public Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;
.super Ljava/lang/Object;
.source "EncodedWatchable.java"


# instance fields
.field private final backingEntity:Lcom/comcast/cim/cmasl/utils/container/Either;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/container/Either",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation
.end field

.field private final watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/comcast/cim/cmasl/utils/container/Either;)V
    .locals 0
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/consumable/WatchableKey;",
            "Lcom/comcast/cim/cmasl/utils/container/Either",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p2, "backingEntity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .line 28
    iput-object p2, p0, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->backingEntity:Lcom/comcast/cim/cmasl/utils/container/Either;

    .line 29
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)V
    .locals 1
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .param p2, "backingEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .prologue
    .line 17
    new-instance v0, Lcom/comcast/cim/cmasl/utils/container/LeftEither;

    invoke-direct {v0, p2}, Lcom/comcast/cim/cmasl/utils/container/LeftEither;-><init>(Ljava/lang/Object;)V

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/comcast/cim/cmasl/utils/container/Either;)V

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V
    .locals 1
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .param p2, "backingEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .prologue
    .line 21
    new-instance v0, Lcom/comcast/cim/cmasl/utils/container/RightEither;

    invoke-direct {v0, p2}, Lcom/comcast/cim/cmasl/utils/container/RightEither;-><init>(Ljava/lang/Object;)V

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/comcast/cim/cmasl/utils/container/Either;)V

    .line 22
    return-void
.end method


# virtual methods
.method public getBackingEntity()Lcom/comcast/cim/cmasl/utils/container/Either;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Either",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->backingEntity:Lcom/comcast/cim/cmasl/utils/container/Either;

    return-object v0
.end method

.method public getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    return-object v0
.end method
