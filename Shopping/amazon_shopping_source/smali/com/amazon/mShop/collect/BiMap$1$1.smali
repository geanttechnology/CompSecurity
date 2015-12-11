.class Lcom/amazon/mShop/collect/BiMap$1$1;
.super Ljava/lang/Object;
.source "BiMap.java"

# interfaces
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/collect/BiMap$1;->iterator()Ljava/util/Iterator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Iterator",
        "<",
        "Ljava/util/Map$Entry",
        "<TK;TV;>;>;"
    }
.end annotation


# instance fields
.field it:Ljava/util/Iterator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Iterator",
            "<",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;>;"
        }
    .end annotation
.end field

.field final synthetic this$1:Lcom/amazon/mShop/collect/BiMap$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/collect/BiMap$1;)V
    .locals 1

    .prologue
    .line 71
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1$1;, "Lcom/amazon/mShop/collect/BiMap$1.1;"
    iput-object p1, p0, Lcom/amazon/mShop/collect/BiMap$1$1;->this$1:Lcom/amazon/mShop/collect/BiMap$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap$1$1;->this$1:Lcom/amazon/mShop/collect/BiMap$1;

    iget-object v0, v0, Lcom/amazon/mShop/collect/BiMap$1;->this$0:Lcom/amazon/mShop/collect/BiMap;

    # invokes: Ljava/util/HashMap;->entrySet()Ljava/util/Set;
    invoke-static {v0}, Lcom/amazon/mShop/collect/BiMap;->access$001(Lcom/amazon/mShop/collect/BiMap;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/collect/BiMap$1$1;->it:Ljava/util/Iterator;

    return-void
.end method


# virtual methods
.method public hasNext()Z
    .locals 1

    .prologue
    .line 76
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1$1;, "Lcom/amazon/mShop/collect/BiMap$1.1;"
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap$1$1;->it:Ljava/util/Iterator;

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic next()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 71
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1$1;, "Lcom/amazon/mShop/collect/BiMap$1.1;"
    invoke-virtual {p0}, Lcom/amazon/mShop/collect/BiMap$1$1;->next()Ljava/util/Map$Entry;

    move-result-object v0

    return-object v0
.end method

.method public next()Ljava/util/Map$Entry;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 81
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1$1;, "Lcom/amazon/mShop/collect/BiMap$1.1;"
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap$1$1;->it:Ljava/util/Iterator;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    return-object v0
.end method

.method public remove()V
    .locals 1

    .prologue
    .line 86
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap$1$1;, "Lcom/amazon/mShop/collect/BiMap$1.1;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
