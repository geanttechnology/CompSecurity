.class public interface abstract Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
.super Ljava/lang/Object;
.source "MicrodataLinkValue.java"


# virtual methods
.method public abstract getBaseUrl()Ljava/lang/String;
.end method

.method public abstract getContentType()Ljava/lang/String;
.end method

.method public abstract getHref()Ljava/lang/String;
.end method

.method public abstract getName()Ljava/lang/String;
.end method

.method public abstract getTitle()Ljava/lang/String;
.end method

.method public abstract isTemplated()Z
.end method

.method public abstract resolve()Ljava/net/URI;
.end method

.method public abstract resolve(Ljava/util/Map;)Ljava/net/URI;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/net/URI;"
        }
    .end annotation
.end method
