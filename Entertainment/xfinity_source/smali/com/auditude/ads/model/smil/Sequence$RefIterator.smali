.class Lcom/auditude/ads/model/smil/Sequence$RefIterator;
.super Ljava/lang/Object;
.source "Sequence.java"

# interfaces
.implements Ljava/lang/Iterable;
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/model/smil/Sequence;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "RefIterator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Iterable",
        "<",
        "Lcom/auditude/ads/model/smil/Ref;",
        ">;",
        "Ljava/util/Iterator",
        "<",
        "Lcom/auditude/ads/model/smil/Ref;",
        ">;"
    }
.end annotation


# instance fields
.field private index:I

.field private refs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Ref;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/auditude/ads/model/smil/Sequence;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/model/smil/Sequence;Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Par;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 333
    .local p2, "pars":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Par;>;"
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->this$0:Lcom/auditude/ads/model/smil/Sequence;

    .line 332
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 329
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->refs:Ljava/util/ArrayList;

    .line 330
    const/4 v3, 0x0

    iput v3, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->index:I

    .line 334
    if-eqz p2, :cond_1

    .line 336
    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_2

    .line 351
    :cond_1
    return-void

    .line 336
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Par;

    .line 338
    .local v0, "par":Lcom/auditude/ads/model/smil/Par;
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getRefList()Ljava/util/ArrayList;

    move-result-object v1

    .line 339
    .local v1, "refList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Ref;>;"
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 341
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_3
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/model/smil/Ref;

    .line 343
    .local v2, "reff":Lcom/auditude/ads/model/smil/Ref;
    invoke-virtual {v2}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 345
    iget-object v5, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->refs:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method


# virtual methods
.method public hasNext()Z
    .locals 1

    .prologue
    .line 353
    const/4 v0, 0x1

    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/auditude/ads/model/smil/Ref;",
            ">;"
        }
    .end annotation

    .prologue
    .line 372
    return-object p0
.end method

.method public next()Lcom/auditude/ads/model/smil/Ref;
    .locals 3

    .prologue
    .line 357
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->refs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget v1, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->index:I

    if-le v0, v1, :cond_0

    .line 359
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->refs:Ljava/util/ArrayList;

    iget v1, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->index:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->index:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Ref;

    .line 362
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic next()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->next()Lcom/auditude/ads/model/smil/Ref;

    move-result-object v0

    return-object v0
.end method

.method public remove()V
    .locals 0

    .prologue
    .line 368
    return-void
.end method
