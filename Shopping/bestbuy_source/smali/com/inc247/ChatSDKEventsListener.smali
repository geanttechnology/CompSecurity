.class public interface abstract Lcom/inc247/ChatSDKEventsListener;
.super Ljava/lang/Object;
.source "SourceFile"


# virtual methods
.method public abstract onAgentMessage(Lorg/json/JSONObject;)V
.end method

.method public abstract onChatAgentAvailability(Z)V
.end method

.method public abstract onChatEnded(Lorg/json/JSONObject;)V
.end method

.method public abstract onChatError(Lcom/inc247/errors/ChatSDKError;)V
.end method

.method public abstract onChatMaximized(Lorg/json/JSONObject;)V
.end method

.method public abstract onChatMinimized(Lorg/json/JSONObject;)V
.end method

.method public abstract onChatStarted(Lorg/json/JSONObject;)V
.end method

.method public abstract onNavigationRequest(Lorg/json/JSONObject;)V
.end method

.method public abstract onQueueIdParamRetrievalFinished()V
.end method

.method public abstract onQueueIdParamRetrievalStarted()V
.end method
