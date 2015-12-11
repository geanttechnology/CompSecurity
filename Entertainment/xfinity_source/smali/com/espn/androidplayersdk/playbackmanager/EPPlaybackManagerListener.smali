.class public interface abstract Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;
.super Ljava/lang/Object;
.source "EPPlaybackManagerListener.java"


# virtual methods
.method public abstract shouldWaitForUpdatedAdobePassParams()Z
.end method

.method public abstract shouldWaitForUpdatedAffiliateToken()Z
.end method

.method public abstract streamAuthorizationFailedWithError(Lcom/espn/androidplayersdk/objects/EPAuthError;)V
.end method

.method public abstract streamAuthorizationSucceeded(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
.end method

.method public abstract streamCookieUpdated(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
.end method

.method public abstract streamDidEnterBlackout(Lcom/espn/androidplayersdk/objects/EPAuthError;)V
.end method

.method public abstract streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V
.end method
