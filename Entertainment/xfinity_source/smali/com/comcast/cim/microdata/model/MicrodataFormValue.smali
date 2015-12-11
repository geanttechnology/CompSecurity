.class public interface abstract Lcom/comcast/cim/microdata/model/MicrodataFormValue;
.super Ljava/lang/Object;
.source "MicrodataFormValue.java"


# virtual methods
.method public abstract getAction()Ljava/lang/String;
.end method

.method public abstract getFields()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormField;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getMethod()Lcom/comcast/cim/microdata/http/HttpMethod;
.end method

.method public abstract getTitle()Ljava/lang/String;
.end method
