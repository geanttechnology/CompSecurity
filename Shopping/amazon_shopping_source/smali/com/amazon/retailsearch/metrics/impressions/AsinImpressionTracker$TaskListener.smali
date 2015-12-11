.class Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;
.super Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;
.source "AsinImpressionTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TaskListener"
.end annotation


# instance fields
.field private activeRid:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->this$0:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    invoke-direct {p0}, Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
    .param p2, "x1"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$1;

    .prologue
    .line 138
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;-><init>(Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)V

    return-void
.end method

.method private save(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 191
    .local p1, "products":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/Product;

    .line 193
    .local v1, "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    iget-object v2, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->this$0:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    # getter for: Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->asinToRid:Ljava/util/Map;
    invoke-static {v2}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->access$100(Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAsin()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->activeRid:Ljava/lang/String;

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 195
    .end local v1    # "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    :cond_0
    return-void
.end method


# virtual methods
.method public categoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
    .locals 1
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 180
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->save(Ljava/util/List;)V

    .line 181
    return-void
.end method

.method public fkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
    .locals 1
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    .line 162
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->save(Ljava/util/List;)V

    .line 163
    return-void
.end method

.method public noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 1
    .param p1, "noResultsSet"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 186
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;->getFallbackResults()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->save(Ljava/util/List;)V

    .line 187
    return-void
.end method

.method public product(Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 3
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->this$0:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    # getter for: Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->asinToRid:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->access$100(Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAsin()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->activeRid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 157
    return-void
.end method

.method reset()V
    .locals 1

    .prologue
    .line 144
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->activeRid:Ljava/lang/String;

    .line 145
    return-void
.end method

.method public spellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 1
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 168
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->save(Ljava/util/List;)V

    .line 169
    return-void
.end method

.method public trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V
    .locals 1
    .param p1, "trackingInfo"    # Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    .prologue
    .line 150
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;->getRid()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->activeRid:Ljava/lang/String;

    .line 151
    return-void
.end method

.method public wordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 1
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 174
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->save(Ljava/util/List;)V

    .line 175
    return-void
.end method
