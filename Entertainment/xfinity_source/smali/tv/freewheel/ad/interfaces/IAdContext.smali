.class public interface abstract Ltv/freewheel/ad/interfaces/IAdContext;
.super Ljava/lang/Object;
.source "IAdContext.java"


# virtual methods
.method public abstract addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V
.end method

.method public abstract dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V
.end method

.method public abstract getActivity()Landroid/app/Activity;
.end method

.method public abstract getConstants()Ltv/freewheel/ad/interfaces/IConstants;
.end method

.method public abstract getParameter(Ljava/lang/String;)Ljava/lang/Object;
.end method

.method public abstract getSiteSectionNonTemporalSlots()Ljava/util/ArrayList;
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

.method public abstract getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/ad/interfaces/ISlot;
.end method

.method public abstract getSlotsByTimePositionClass(I)Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/ISlot;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getTemporalSlots()Ljava/util/ArrayList;
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

.method public abstract getVideoPlayerNonTemporalSlots()Ljava/util/ArrayList;
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

.method public abstract setActivity(Landroid/app/Activity;)V
.end method

.method public abstract setParameter(Ljava/lang/String;Ljava/lang/Object;I)V
.end method

.method public abstract setProfile(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract setSiteSection(Ljava/lang/String;IIII)V
.end method

.method public abstract setVideoAsset(Ljava/lang/String;DLjava/lang/String;IIIIII)V
.end method

.method public abstract submitRequest(D)V
.end method
