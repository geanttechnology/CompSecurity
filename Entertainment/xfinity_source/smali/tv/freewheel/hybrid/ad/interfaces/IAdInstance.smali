.class public interface abstract Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
.super Ljava/lang/Object;
.source "IAdInstance.java"


# virtual methods
.method public abstract addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract createCreativeRenditionForTranslation()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
.end method

.method public abstract getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
.end method

.method public abstract getAdId()I
.end method

.method public abstract getCompanionAdInstances()Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getParameter(Ljava/lang/String;)Ljava/lang/Object;
.end method

.method public abstract getRenderableCreativeRenditions()Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getReplicaId()I
.end method

.method public abstract getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;
.end method

.method public abstract play2()V
.end method

.method public abstract setActiveCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;)V
.end method

.method public abstract setClickThroughURL(Ljava/lang/String;Ljava/lang/String;)V
.end method
