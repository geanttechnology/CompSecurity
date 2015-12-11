.class Lcom/comcast/cim/container/PlayerContainer$14;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getLegacyNormalizerFactory()Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 1458
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$14;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get(Ljava/lang/String;)Lcom/comcast/cim/cmasl/cachelib/Normalizer;
    .locals 2
    .param p1, "namespace"    # Ljava/lang/String;

    .prologue
    .line 1461
    new-instance v0, Lcom/comcast/cim/container/PlayerContainer$LegacyNormalizer;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/comcast/cim/container/PlayerContainer$LegacyNormalizer;-><init>(Ljava/lang/String;Lcom/comcast/cim/container/PlayerContainer$1;)V

    return-object v0
.end method
