.class public interface abstract Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;
.super Ljava/lang/Object;
.source "PlaybackSdkEventResponse.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;
    }
.end annotation


# virtual methods
.method public abstract onPause(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract onResume(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract onSeekEnd(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract onSeekStart(JLcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract onStart(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract onStop(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method
