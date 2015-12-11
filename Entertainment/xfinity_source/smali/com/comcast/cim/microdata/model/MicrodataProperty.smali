.class public interface abstract Lcom/comcast/cim/microdata/model/MicrodataProperty;
.super Ljava/lang/Object;
.source "MicrodataProperty.java"


# virtual methods
.method public abstract asBoolean()Ljava/lang/Boolean;
.end method

.method public abstract asBoolean(Ljava/lang/Boolean;)Ljava/lang/Boolean;
.end method

.method public abstract asInt()Ljava/lang/Integer;
.end method

.method public abstract asInt(Ljava/lang/Integer;)Ljava/lang/Integer;
.end method

.method public abstract asItem()Lcom/comcast/cim/microdata/model/MicrodataItem;
.end method

.method public abstract asItems()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;",
            ">;"
        }
    .end annotation
.end method

.method public abstract asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
.end method

.method public abstract asList()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end method

.method public abstract asList(Ljava/util/List;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end method

.method public abstract asString()Ljava/lang/String;
.end method

.method public abstract asString(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract getName()Ljava/lang/String;
.end method

.method public abstract getValue()Ljava/lang/Object;
.end method

.method public abstract getValues()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end method

.method public abstract isCollection()Z
.end method

.method public abstract isEmbedded()Z
.end method

.method public abstract isMissing()Z
.end method
