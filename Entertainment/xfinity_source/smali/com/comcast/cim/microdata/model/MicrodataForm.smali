.class public interface abstract Lcom/comcast/cim/microdata/model/MicrodataForm;
.super Ljava/lang/Object;
.source "MicrodataForm.java"


# virtual methods
.method public abstract getId()Ljava/lang/String;
.end method

.method public abstract getValue()Lcom/comcast/cim/microdata/model/MicrodataFormValue;
.end method

.method public abstract getValues()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormValue;",
            ">;"
        }
    .end annotation
.end method

.method public abstract isCollection()Z
.end method
