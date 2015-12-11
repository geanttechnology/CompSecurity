.class public Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;
.super Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;
.source "PlaybackEventResponseDelegate.java"


# instance fields
.field private final mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;


# direct methods
.method public constructor <init>(Lcom/amazon/avod/sdk/PlaybackStateEventListener;)V
    .locals 0
    .param p1, "eventListener"    # Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    .line 19
    return-void
.end method


# virtual methods
.method public onPause(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .locals 1
    .param p1, "eventContext"    # Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    if-eqz v0, :cond_0

    .line 38
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    invoke-interface {v0, p1}, Lcom/amazon/avod/sdk/PlaybackStateEventListener;->onPause(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 40
    :cond_0
    return-void
.end method

.method public onResume(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .locals 1
    .param p1, "eventContext"    # Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    if-eqz v0, :cond_0

    .line 31
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    invoke-interface {v0, p1}, Lcom/amazon/avod/sdk/PlaybackStateEventListener;->onResume(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 33
    :cond_0
    return-void
.end method

.method public onSeekEnd(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .locals 1
    .param p1, "eventContext"    # Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    invoke-interface {v0, p1}, Lcom/amazon/avod/sdk/PlaybackStateEventListener;->onSeekEnd(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 61
    :cond_0
    return-void
.end method

.method public onSeekStart(JLcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .locals 1
    .param p1, "newPosition"    # J
    .param p3, "eventContext"    # Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/avod/sdk/PlaybackStateEventListener;->onSeekStart(JLcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 54
    :cond_0
    return-void
.end method

.method public onStart(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .locals 1
    .param p1, "eventContext"    # Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    if-eqz v0, :cond_0

    .line 24
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    invoke-interface {v0, p1}, Lcom/amazon/avod/sdk/PlaybackStateEventListener;->onStart(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 26
    :cond_0
    return-void
.end method

.method public onStop(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V
    .locals 1
    .param p1, "eventContext"    # Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    invoke-interface {v0, p1}, Lcom/amazon/avod/sdk/PlaybackStateEventListener;->onStop(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 47
    :cond_0
    return-void
.end method
