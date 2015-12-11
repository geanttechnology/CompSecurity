.class public Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;
.super Ljava/lang/Object;
.source "DefaultMicrodataModelFactory.java"

# interfaces
.implements Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;


# instance fields
.field protected context:Lcom/comcast/cim/microdata/model/MicrodataContext;


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataContext;

    const/4 v1, 0x0

    const-string v2, ""

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    invoke-direct {v0, v1, v2, p0, v3}, Lcom/comcast/cim/microdata/model/MicrodataContext;-><init>(Lcom/comcast/cim/microdata/client/HypermediaClient;Ljava/lang/String;Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;Ljava/util/Map;)V

    iput-object v0, p0, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    .line 19
    return-void
.end method


# virtual methods
.method public createMicrodataForm(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataFormValue;)Lcom/comcast/cim/microdata/model/MicrodataForm;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "formValue"    # Lcom/comcast/cim/microdata/model/MicrodataFormValue;

    .prologue
    .line 82
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;-><init>(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataFormValue;)V

    .line 83
    .local v0, "form":Lcom/comcast/cim/microdata/model/MicrodataFormImpl;
    return-object v0
.end method

.method public createMicrodataForm(Ljava/lang/String;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataForm;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
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

    .prologue
    .line 88
    .local p2, "formValues":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormValue;>;"
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;-><init>(Ljava/lang/String;Ljava/util/List;)V

    .line 89
    .local v0, "form":Lcom/comcast/cim/microdata/model/MicrodataFormImpl;
    return-object v0
.end method

.method public createMicrodataFormValue(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/microdata/http/HttpMethod;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataFormValue;
    .locals 2
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "action"    # Ljava/lang/String;
    .param p3, "method"    # Lcom/comcast/cim/microdata/http/HttpMethod;
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

    .prologue
    .line 94
    .local p4, "fields":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormField;>;"
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/microdata/http/HttpMethod;Ljava/util/List;)V

    .line 95
    .local v0, "formValue":Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;
    iget-object v1, p0, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V

    .line 97
    return-object v0
.end method

.method public createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 2
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
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

    .prologue
    .line 31
    .local p3, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    .local p4, "forms":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataForm;>;"
    .local p5, "properties":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;

    invoke-direct {v0, p1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;-><init>(Ljava/lang/String;)V

    .line 32
    .local v0, "item":Lcom/comcast/cim/microdata/model/MicrodataItemImpl;
    invoke-virtual {v0, p2}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->setId(Ljava/lang/String;)V

    .line 33
    invoke-virtual {v0, p5}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->addProperties(Ljava/util/List;)V

    .line 34
    invoke-virtual {v0, p3}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->addLinks(Ljava/util/List;)V

    .line 35
    invoke-virtual {v0, p4}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->addForms(Ljava/util/List;)V

    .line 36
    iget-object v1, p0, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataItemImpl;->setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V

    .line 38
    return-object v0
.end method

.method public createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
    .param p6, "root"    # Z
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

    .prologue
    .line 49
    .local p3, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    .local p4, "forms":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataForm;>;"
    .local p5, "properties":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    invoke-virtual/range {p0 .. p5}, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;->createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v0

    return-object v0
.end method

.method public createMicrodataLink(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Lcom/comcast/cim/microdata/model/MicrodataLink;
    .locals 1
    .param p1, "relation"    # Ljava/lang/String;
    .param p2, "linkValue"    # Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    .prologue
    .line 62
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataLinkImpl;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/microdata/model/MicrodataLinkImpl;-><init>(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)V

    .line 63
    .local v0, "link":Lcom/comcast/cim/microdata/model/MicrodataLinkImpl;
    return-object v0
.end method

.method public createMicrodataLink(Ljava/lang/String;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataLink;
    .locals 1
    .param p1, "relation"    # Ljava/lang/String;
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

    .prologue
    .line 68
    .local p2, "linkValues":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLinkValue;>;"
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataLinkImpl;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/microdata/model/MicrodataLinkImpl;-><init>(Ljava/lang/String;Ljava/util/List;)V

    .line 69
    .local v0, "link":Lcom/comcast/cim/microdata/model/MicrodataLinkImpl;
    return-object v0
.end method

.method public createMicrodataLinkValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    .locals 6
    .param p1, "href"    # Ljava/lang/String;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "templated"    # Z
    .param p5, "contentType"    # Ljava/lang/String;

    .prologue
    .line 74
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V

    .line 75
    .local v0, "linkValue":Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;
    iget-object v1, p0, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V

    .line 77
    return-object v0
.end method

.method public createMicrodataProperty(Ljava/lang/String;Ljava/lang/Object;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 2
    .param p1, "fieldName"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "embedded"    # Z

    .prologue
    .line 54
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;-><init>(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 55
    .local v0, "property":Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;
    iget-object v1, p0, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V

    .line 57
    return-object v0
.end method

.method public setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V
    .locals 0
    .param p1, "context"    # Lcom/comcast/cim/microdata/model/MicrodataContext;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/comcast/cim/microdata/deserialization/DefaultMicrodataModelFactory;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    .line 103
    return-void
.end method
