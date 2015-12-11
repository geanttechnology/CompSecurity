.class abstract Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRenditionCollection;
.super Ljava/lang/Object;
.source "AbstractCreativeRenditionCollection.java"

# interfaces
.implements Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected searchAll(Ljava/util/ArrayList;Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;
    .locals 5
    .param p2, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p3, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            "Ltv/freewheel/hybrid/ad/interfaces/IConstants;",
            ")",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    .local p1, "renditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 24
    .local v2, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 38
    :cond_0
    return-object v2

    .line 26
    :cond_1
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;

    .line 27
    .local v3, "vv":Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;
    invoke-virtual {v3, p2, p3}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 28
    instance-of v4, p0, Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    if-eqz v4, :cond_3

    move-object v0, v3

    .line 29
    check-cast v0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;

    .line 30
    .local v0, "comp":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    invoke-virtual {v0, p2, p3}, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->isValidCompanion(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 31
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 34
    .end local v0    # "comp":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    :cond_3
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method protected validate(Ljava/util/ArrayList;Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z
    .locals 4
    .param p2, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p3, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;",
            ">;",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            "Ltv/freewheel/hybrid/ad/interfaces/IConstants;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "renditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;>;"
    const/4 v2, 0x0

    .line 11
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 19
    :cond_0
    :goto_0
    return v2

    .line 14
    :cond_1
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;

    .line 15
    .local v1, "vv":Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;
    invoke-interface {v1, p2, p3}, Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 16
    const/4 v2, 0x1

    goto :goto_0
.end method
