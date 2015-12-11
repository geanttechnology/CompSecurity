.class public Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;
.super Ljava/util/LinkedHashMap;
.source "LruLinkedHashMap.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/LinkedHashMap",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field private final cacheSize:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "cacheSize"    # I

    .prologue
    .line 10
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;, "Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap<TK;TV;>;"
    invoke-direct {p0, p1}, Ljava/util/LinkedHashMap;-><init>(I)V

    .line 11
    iput p1, p0, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;->cacheSize:I

    .line 12
    return-void
.end method


# virtual methods
.method protected removeEldestEntry(Ljava/util/Map$Entry;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;)Z"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;, "Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap<TK;TV;>;"
    .local p1, "eldest":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;->size()I

    move-result v0

    iget v1, p0, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;->cacheSize:I

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
