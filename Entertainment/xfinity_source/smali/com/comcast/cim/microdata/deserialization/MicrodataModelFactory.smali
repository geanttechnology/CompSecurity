.class public interface abstract Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;
.super Ljava/lang/Object;
.source "MicrodataModelFactory.java"


# virtual methods
.method public abstract createMicrodataForm(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataFormValue;)Lcom/comcast/cim/microdata/model/MicrodataForm;
.end method

.method public abstract createMicrodataForm(Ljava/lang/String;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataForm;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormValue;",
            ">;)",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;"
        }
    .end annotation
.end method

.method public abstract createMicrodataFormValue(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/microdata/http/HttpMethod;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataFormValue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/http/HttpMethod;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormField;",
            ">;)",
            "Lcom/comcast/cim/microdata/model/MicrodataFormValue;"
        }
    .end annotation
.end method

.method public abstract createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;)",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;"
        }
    .end annotation
.end method

.method public abstract createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;Z)",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;"
        }
    .end annotation
.end method

.method public abstract createMicrodataLink(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Lcom/comcast/cim/microdata/model/MicrodataLink;
.end method

.method public abstract createMicrodataLink(Ljava/lang/String;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataLink;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLinkValue;",
            ">;)",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;"
        }
    .end annotation
.end method

.method public abstract createMicrodataLinkValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
.end method

.method public abstract createMicrodataProperty(Ljava/lang/String;Ljava/lang/Object;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;
.end method

.method public abstract setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V
.end method
