.class public interface abstract Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;
.super Ljava/lang/Object;
.source "ITrackable.java"


# virtual methods
.method public abstract addContext(Ljava/lang/String;Ljava/lang/Object;)V
.end method

.method public abstract addEvar(ILjava/lang/String;)V
.end method

.method public abstract addEvent(Ljava/lang/String;)V
.end method

.method public abstract addProp(ILjava/lang/String;)V
.end method

.method public abstract getContextData()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getEvars()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getEvents()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getName()Ljava/lang/String;
.end method

.method public abstract getProps()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation
.end method
