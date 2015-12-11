.class public interface abstract Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;
.super Ljava/lang/Object;
.source "VPMedia.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "VPMediaAuthorizationListener"
.end annotation


# virtual methods
.method public abstract onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V
.end method

.method public abstract onAuthorizationSuccess(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
.end method

.method public abstract onAuthorizationTokenRequest(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
.end method
