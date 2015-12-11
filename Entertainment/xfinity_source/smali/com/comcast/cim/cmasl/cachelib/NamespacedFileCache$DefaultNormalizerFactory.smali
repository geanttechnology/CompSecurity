.class Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizerFactory;
.super Ljava/lang/Object;
.source "NamespacedFileCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DefaultNormalizerFactory"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizerFactory;-><init>()V

    return-void
.end method


# virtual methods
.method public get(Ljava/lang/String;)Lcom/comcast/cim/cmasl/cachelib/Normalizer;
    .locals 2
    .param p1, "namespace"    # Ljava/lang/String;

    .prologue
    .line 100
    new-instance v0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;-><init>(Ljava/lang/String;Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;)V

    return-object v0
.end method
