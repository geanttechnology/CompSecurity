.class Lcom/amazon/mShop/collect/BiMap$1;
.super Ljava/util/AbstractSet;
.source "BiMap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/collect/BiMap;->entrySet()Ljava/util/Set;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/AbstractSet",
        "<",
        "Ljava/util/Map$Entry",
        "<TK;TV;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/collect/BiMap;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/collect/BiMap;)V
    .locals 0

    .prologue
    .line 67
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1;, "Lcom/amazon/mShop/collect/BiMap.1;"
    iput-object p1, p0, Lcom/amazon/mShop/collect/BiMap$1;->this$0:Lcom/amazon/mShop/collect/BiMap;

    invoke-direct {p0}, Ljava/util/AbstractSet;-><init>()V

    return-void
.end method


# virtual methods
.method public contains(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 98
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1;, "Lcom/amazon/mShop/collect/BiMap.1;"
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap$1;->this$0:Lcom/amazon/mShop/collect/BiMap;

    # invokes: Ljava/util/HashMap;->entrySet()Ljava/util/Set;
    invoke-static {v0}, Lcom/amazon/mShop/collect/BiMap;->access$201(Lcom/amazon/mShop/collect/BiMap;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public containsAll(Ljava/util/Collection;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 103
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1;, "Lcom/amazon/mShop/collect/BiMap.1;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap$1;->this$0:Lcom/amazon/mShop/collect/BiMap;

    # invokes: Ljava/util/HashMap;->entrySet()Ljava/util/Set;
    invoke-static {v0}, Lcom/amazon/mShop/collect/BiMap;->access$301(Lcom/amazon/mShop/collect/BiMap;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Set;->containsAll(Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;>;"
        }
    .end annotation

    .prologue
    .line 71
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1;, "Lcom/amazon/mShop/collect/BiMap.1;"
    new-instance v0, Lcom/amazon/mShop/collect/BiMap$1$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/collect/BiMap$1$1;-><init>(Lcom/amazon/mShop/collect/BiMap$1;)V

    return-object v0
.end method

.method public size()I
    .locals 1

    .prologue
    .line 93
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1;, "Lcom/amazon/mShop/collect/BiMap.1;"
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap$1;->this$0:Lcom/amazon/mShop/collect/BiMap;

    # invokes: Ljava/util/HashMap;->entrySet()Ljava/util/Set;
    invoke-static {v0}, Lcom/amazon/mShop/collect/BiMap;->access$101(Lcom/amazon/mShop/collect/BiMap;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    return v0
.end method
