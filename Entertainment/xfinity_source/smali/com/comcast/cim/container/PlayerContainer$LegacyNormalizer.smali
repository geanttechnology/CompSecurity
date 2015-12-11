.class Lcom/comcast/cim/container/PlayerContainer$LegacyNormalizer;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/cachelib/Normalizer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/container/PlayerContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LegacyNormalizer"
.end annotation


# instance fields
.field private final namespace:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "namespace"    # Ljava/lang/String;

    .prologue
    .line 1473
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1474
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$LegacyNormalizer;->namespace:Ljava/lang/String;

    .line 1475
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Lcom/comcast/cim/container/PlayerContainer$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Lcom/comcast/cim/container/PlayerContainer$1;

    .prologue
    .line 1469
    invoke-direct {p0, p1}, Lcom/comcast/cim/container/PlayerContainer$LegacyNormalizer;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public normalize(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 1479
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer$LegacyNormalizer;->namespace:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
