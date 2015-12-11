.class public interface abstract Lcom/comcast/cim/microdata/model/MicrodataLink;
.super Ljava/lang/Object;
.source "MicrodataLink.java"


# virtual methods
.method public abstract getRelation()Ljava/lang/String;
.end method

.method public abstract getValue()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
.end method

.method public abstract getValues()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLinkValue;",
            ">;"
        }
    .end annotation
.end method

.method public abstract isCollection()Z
.end method
