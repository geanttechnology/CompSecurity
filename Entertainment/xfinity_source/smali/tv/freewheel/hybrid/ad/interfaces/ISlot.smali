.class public interface abstract Ltv/freewheel/hybrid/ad/interfaces/ISlot;
.super Ljava/lang/Object;
.source "ISlot.java"


# virtual methods
.method public abstract getAdInstances()Ljava/util/ArrayList;
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

.method public abstract getBase()Landroid/view/ViewGroup;
.end method

.method public abstract getCustomId()Ljava/lang/String;
.end method

.method public abstract getHeight()I
.end method

.method public abstract getTimePosition()D
.end method

.method public abstract getTimePositionClass()I
.end method

.method public abstract getType()I
.end method

.method public abstract getWidth()I
.end method

.method public abstract play()V
.end method

.method public abstract processSlotEvent(Ljava/lang/String;)V
.end method

.method public abstract stop()V
.end method
