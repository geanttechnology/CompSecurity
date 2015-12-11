.class public Lcom/auditude/ads/network/vast/model/VASTDocument;
.super Ljava/lang/Object;
.source "VASTDocument.java"


# instance fields
.field public adTagURI:Ljava/lang/String;

.field private ads:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTAd;",
            ">;"
        }
    .end annotation
.end field

.field public parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

.field private podAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTAd;",
            ">;"
        }
    .end annotation
.end field

.field public reachedMaxWrapper:Z

.field private standAloneAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTAd;",
            ">;"
        }
    .end annotation
.end field

.field private ununsedAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTAd;",
            ">;"
        }
    .end annotation
.end field

.field private usedAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTAd;",
            ">;"
        }
    .end annotation
.end field

.field public version:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/network/vast/model/VASTAd;)V
    .locals 1
    .param p1, "parentAd"    # Lcom/auditude/ads/network/vast/model/VASTAd;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    const-string v0, "2.0"

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->version:Ljava/lang/String;

    .line 21
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 22
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->reachedMaxWrapper:Z

    .line 26
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 27
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ads:Ljava/util/ArrayList;

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    .line 30
    return-void
.end method


# virtual methods
.method public final addVASTAd(Lcom/auditude/ads/network/vast/model/VASTAd;)V
    .locals 4
    .param p1, "ad"    # Lcom/auditude/ads/network/vast/model/VASTAd;

    .prologue
    .line 92
    if-eqz p1, :cond_0

    .line 95
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v2

    iget-object v2, v2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->followAdditionalWrappers:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_1

    .line 133
    :cond_0
    :goto_0
    return-void

    .line 101
    :cond_1
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 102
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v2

    iget-object v2, v2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v2

    iget-object v2, v2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    const-string v3, "false"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 104
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v2

    const-string v3, "false"

    iput-object v3, v2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    .line 107
    :cond_2
    invoke-virtual {p1, p0}, Lcom/auditude/ads/network/vast/model/VASTAd;->setDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 108
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ads:Ljava/util/ArrayList;

    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 110
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getSequence()I

    move-result v2

    if-ltz v2, :cond_5

    .line 113
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 114
    .local v1, "inserted":Ljava/lang/Boolean;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lt v0, v2, :cond_3

    .line 123
    :goto_2
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    .line 125
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 116
    :cond_3
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->getSequence()I

    move-result v2

    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getSequence()I

    move-result v3

    if-le v2, v3, :cond_4

    .line 118
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 119
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v2, v0, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    goto :goto_2

    .line 114
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 130
    .end local v0    # "i":I
    .end local v1    # "inserted":Ljava/lang/Boolean;
    :cond_5
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0
.end method

.method public final getAds()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTAd;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 34
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ads:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_1

    .line 36
    :cond_0
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ads:Ljava/util/ArrayList;

    .line 86
    :goto_0
    return-object v1

    .line 40
    :cond_1
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    goto :goto_0

    .line 43
    :cond_2
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    .line 44
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ununsedAds:Ljava/util/ArrayList;

    .line 47
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v1

    iget-object v1, v1, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v1

    iget-object v1, v1, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    const-string v2, "false"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 49
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_4

    .line 51
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_3

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 79
    :cond_3
    :goto_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lt v0, v1, :cond_9

    .line 86
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    goto :goto_0

    .line 53
    .end local v0    # "i":I
    :cond_4
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_5

    .line 55
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 59
    :cond_5
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 62
    :cond_6
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v1

    iget-object v1, v1, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v1

    iget-object v1, v1, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    const-string v2, "true"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 64
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_7

    .line 66
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->podAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_1

    .line 68
    :cond_7
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_3

    .line 70
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 75
    :cond_8
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ads:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_1

    .line 81
    .restart local v0    # "i":I
    :cond_9
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v1

    if-gez v1, :cond_a

    .line 83
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ununsedAds:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->standAloneAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 79
    :cond_a
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_2
.end method

.method public final getNextUnusedAd()Lcom/auditude/ads/network/vast/model/VASTAd;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 137
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ununsedAds:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ununsedAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    const/4 v0, 0x0

    .line 140
    :goto_0
    return-object v0

    .line 138
    :cond_1
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ununsedAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 139
    .local v0, "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->ununsedAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_0
.end method

.method public final replaceAd(Lcom/auditude/ads/network/vast/model/VASTAd;Lcom/auditude/ads/network/vast/model/VASTAd;)V
    .locals 2
    .param p1, "adToReplace"    # Lcom/auditude/ads/network/vast/model/VASTAd;
    .param p2, "targetAd"    # Lcom/auditude/ads/network/vast/model/VASTAd;

    .prologue
    .line 146
    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    .line 148
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    .line 150
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 151
    .local v0, "index":I
    if-ltz v0, :cond_0

    .line 153
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTDocument;->usedAds:Ljava/util/ArrayList;

    invoke-virtual {v1, v0, p2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 157
    .end local v0    # "index":I
    :cond_0
    return-void
.end method
