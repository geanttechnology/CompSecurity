.class public interface abstract Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
.super Ljava/lang/Object;
.source "PlayerAnalytics.java"


# virtual methods
.method public abstract adProgress(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract bitrateChanged(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract fragmentWarning(IIILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract heartBeat(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;)V
.end method

.method public abstract mediaEnded(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract mediaFailed(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract mediaInfo(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract mediaOpened(Ljava/lang/String;JLjava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract openingMedia(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract playStateChanged(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract pluginInitialized(Landroid/content/Context;)V
.end method

.method public abstract retryAttempt(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract scrubEnded(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract scrubStarted(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method

.method public abstract trickPlay(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
.end method
