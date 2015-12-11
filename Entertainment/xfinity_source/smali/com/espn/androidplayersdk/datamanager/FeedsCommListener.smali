.class public interface abstract Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;
.super Ljava/lang/Object;
.source "FeedsCommListener.java"


# virtual methods
.method public abstract handleError(I)V
.end method

.method public abstract update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V
.end method

.method public abstract update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation
.end method
