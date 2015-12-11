.class public interface abstract Ltv/freewheel/renderers/interfaces/IRendererContext;
.super Ljava/lang/Object;
.source "IRendererContext.java"


# virtual methods
.method public abstract addOnActivityCallbackListener(Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;)V
.end method

.method public abstract dispatchEvent(Ljava/lang/String;)V
.end method

.method public abstract dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract getActivity()Landroid/app/Activity;
.end method

.method public abstract getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;
.end method

.method public abstract getCompanionSlots()Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getConstants()Ltv/freewheel/ad/interfaces/IConstants;
.end method

.method public abstract getParameter(Ljava/lang/String;)Ljava/lang/Object;
.end method

.method public abstract getVersion()I
.end method

.method public abstract scheduleAdInstances(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ISlot;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation
.end method

.method public abstract setRendererCapability(Ljava/lang/String;I)V
.end method
