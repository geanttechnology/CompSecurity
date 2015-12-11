.class public interface abstract Lcom/igexin/sdk/action/AbstractPushMessageAction;
.super Ljava/lang/Object;
.source "AbstractPushMessageAction.java"


# virtual methods
.method public abstract executeAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Z
.end method

.method public abstract parseAction(Lorg/json/JSONObject;)Lcom/igexin/sdk/bean/BaseBean;
.end method

.method public abstract prepareExecuteAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;
.end method
