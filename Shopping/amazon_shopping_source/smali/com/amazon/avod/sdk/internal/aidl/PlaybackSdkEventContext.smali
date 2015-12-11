.class public interface abstract Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
.super Ljava/lang/Object;
.source "PlaybackSdkEventContext.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;
    }
.end annotation


# virtual methods
.method public abstract getAsin()Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract getCurrentPosition()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract getDuration()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method
