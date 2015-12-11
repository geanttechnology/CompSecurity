.class public Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;
.super Ljava/lang/Object;
.source "MicrodataPropertyImpl.java"

# interfaces
.implements Lcom/comcast/cim/microdata/model/MicrodataProperty;


# instance fields
.field private collection:Z

.field private context:Lcom/comcast/cim/microdata/model/MicrodataContext;

.field private embedded:Z

.field private name:Ljava/lang/String;

.field private values:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->name:Ljava/lang/String;

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    .line 43
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Object;Z)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "embedded"    # Z

    .prologue
    const/4 v1, 0x0

    .line 22
    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;-><init>(Ljava/lang/String;)V

    .line 23
    iput-boolean p3, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->embedded:Z

    .line 25
    if-nez p2, :cond_0

    .line 26
    iput-boolean v1, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->collection:Z

    .line 34
    .end local p2    # "value":Ljava/lang/Object;
    :goto_0
    return-void

    .line 27
    .restart local p2    # "value":Ljava/lang/Object;
    :cond_0
    instance-of v0, p2, Ljava/util/List;

    if-eqz v0, :cond_1

    .line 28
    check-cast p2, Ljava/util/List;

    .end local p2    # "value":Ljava/lang/Object;
    invoke-virtual {p0, p2}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->addValues(Ljava/util/Collection;)V

    .line 29
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->collection:Z

    goto :goto_0

    .line 31
    .restart local p2    # "value":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p0, p2}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->addValue(Ljava/lang/Object;)V

    .line 32
    iput-boolean v1, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->collection:Z

    goto :goto_0
.end method

.method private asType(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 375
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v0

    .line 376
    .local v0, "value":Ljava/lang/Object;
    invoke-virtual {p1, v0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 377
    invoke-virtual {p1, v0}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 379
    :cond_0
    new-instance v1, Ljava/lang/ClassCastException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Property "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->name:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " value is not a "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ". Is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " instead."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private asType(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;TT;)TT;"
        }
    .end annotation

    .prologue
    .line 385
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "defaultValue":Ljava/lang/Object;, "TT;"
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v0

    .line 386
    .local v0, "value":Ljava/lang/Object;
    if-nez v0, :cond_1

    .line 393
    .end local p2    # "defaultValue":Ljava/lang/Object;, "TT;"
    :cond_0
    :goto_0
    return-object p2

    .line 390
    .restart local p2    # "defaultValue":Ljava/lang/Object;, "TT;"
    :cond_1
    invoke-virtual {p1, v0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 391
    invoke-virtual {p1, v0}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    goto :goto_0
.end method

.method private asTypeList(Ljava/lang/Class;)Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v7, 0x0

    .line 398
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValues()Ljava/util/List;

    move-result-object v3

    .line 400
    .local v3, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    invoke-direct {v1, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 401
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 414
    :cond_0
    return-object v1

    .line 405
    :cond_1
    invoke-interface {v3, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 406
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 407
    .local v2, "value":Ljava/lang/Object;
    invoke-virtual {p1, v2}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 410
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "value":Ljava/lang/Object;
    :cond_2
    new-instance v4, Ljava/lang/ClassCastException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Property "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->name:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " value is not a "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ". Is "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v3, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " instead."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method private convertFormToLink(Lcom/comcast/cim/microdata/model/MicrodataFormValue;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    .locals 9
    .param p1, "formValue"    # Lcom/comcast/cim/microdata/model/MicrodataFormValue;

    .prologue
    const/4 v2, 0x0

    .line 273
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormValue;->getMethod()Lcom/comcast/cim/microdata/http/HttpMethod;

    move-result-object v0

    sget-object v1, Lcom/comcast/cim/microdata/http/HttpMethod;->GET:Lcom/comcast/cim/microdata/http/HttpMethod;

    if-eq v0, v1, :cond_0

    .line 274
    new-instance v0, Ljava/lang/ClassCastException;

    const-string v1, "Cannot convert from non-GET form to Link."

    invoke-direct {v0, v1}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 277
    :cond_0
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 278
    .local v7, "hrefBuilder":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormValue;->getAction()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 280
    const/4 v4, 0x0

    .line 281
    .local v4, "templated":Z
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormValue;->getFields()Ljava/util/List;

    move-result-object v6

    .line 282
    .local v6, "fields":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormField;>;"
    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 283
    const/4 v4, 0x1

    .line 284
    const-string v0, "{?"

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 286
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-ge v8, v0, :cond_2

    .line 287
    invoke-interface {v6, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataFormField;

    invoke-virtual {v0}, Lcom/comcast/cim/microdata/model/MicrodataFormField;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 288
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ge v8, v0, :cond_1

    .line 289
    const-string v0, ","

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 286
    :cond_1
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 292
    :cond_2
    const-string v0, "}"

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 295
    .end local v8    # "i":I
    :cond_3
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getContext()Lcom/comcast/cim/microdata/model/MicrodataContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getModelFactory()Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    move-result-object v0

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormValue;->getTitle()Ljava/lang/String;

    move-result-object v3

    move-object v5, v2

    invoke-interface/range {v0 .. v5}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataLinkValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v0

    return-object v0
.end method

.method private convertItemToLink()Lcom/comcast/cim/microdata/model/MicrodataLink;
    .locals 6

    .prologue
    .line 342
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v3

    instance-of v3, v3, Lcom/comcast/cim/microdata/model/MicrodataItem;

    if-nez v3, :cond_0

    .line 343
    new-instance v3, Ljava/lang/ClassCastException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Property "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->name:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " is not an instance of "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-class v5, Lcom/comcast/cim/microdata/model/MicrodataItem;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 346
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 348
    .local v1, "linkValues":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLinkValue;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValues()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 349
    .local v2, "value":Ljava/lang/Object;
    check-cast v2, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .end local v2    # "value":Ljava/lang/Object;
    invoke-direct {p0, v2}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->convertItemToLinkValue(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 352
    :cond_1
    iget-object v3, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v3}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getModelFactory()Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->name:Ljava/lang/String;

    invoke-interface {v3, v4, v1}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataLink(Ljava/lang/String;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v3

    return-object v3
.end method

.method private convertItemToLinkValue(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    .locals 7
    .param p1, "item"    # Lcom/comcast/cim/microdata/model/MicrodataItem;

    .prologue
    .line 356
    const-string v0, "self"

    invoke-interface {p1, v0}, Lcom/comcast/cim/microdata/model/MicrodataItem;->get(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v6

    .line 358
    .local v6, "itemSelfLink":Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getModelFactory()Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    move-result-object v0

    invoke-interface {v6}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getHref()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v6}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v6}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v6}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->isTemplated()Z

    move-result v4

    invoke-interface {v6}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getContentType()Ljava/lang/String;

    move-result-object v5

    invoke-interface/range {v0 .. v5}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataLinkValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v0

    return-object v0
.end method

.method private convertLinkToItem(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 8
    .param p1, "linkValue"    # Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    .prologue
    const/4 v1, 0x0

    .line 318
    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->isFragmentUri(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 320
    iget-object v1, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v1}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getItemMap()Ljava/util/Map;

    move-result-object v1

    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getFragmentTarget(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 322
    .local v6, "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    if-nez v6, :cond_1

    .line 323
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Fragment link "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getHref()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " did not resolve to item in the document."

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 329
    .end local v6    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getContext()Lcom/comcast/cim/microdata/model/MicrodataContext;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getModelFactory()Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    move-result-object v0

    .line 330
    .local v0, "modelFactory":Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;
    const-string v2, "self"

    invoke-interface {v0, v2, p1}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataLink(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v7

    .line 332
    .local v7, "selfLink":Lcom/comcast/cim/microdata/model/MicrodataLink;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 333
    .local v3, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    invoke-interface {v3, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 335
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    move-object v2, v1

    invoke-interface/range {v0 .. v5}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v6

    .end local v0    # "modelFactory":Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;
    .end local v3    # "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    .end local v7    # "selfLink":Lcom/comcast/cim/microdata/model/MicrodataLink;
    :cond_1
    return-object v6
.end method

.method private convertLinkToItems(Lcom/comcast/cim/microdata/model/MicrodataLink;)Ljava/util/List;
    .locals 4
    .param p1, "link"    # Lcom/comcast/cim/microdata/model/MicrodataLink;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 309
    new-instance v1, Ljava/util/ArrayList;

    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getValues()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 311
    .local v1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getValues()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    .line 312
    .local v2, "value":Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    invoke-direct {p0, v2}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->convertLinkToItem(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 314
    .end local v2    # "value":Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    :cond_0
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    return-object v3
.end method

.method private getFragmentTarget(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Ljava/lang/String;
    .locals 2
    .param p1, "link"    # Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    .prologue
    .line 371
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getHref()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private isFragmentUri(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Z
    .locals 2
    .param p1, "link"    # Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    .prologue
    .line 367
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getHref()Ljava/lang/String;

    move-result-object v0

    const-string v1, "#"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public addValue(Ljava/lang/Object;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    .line 74
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 76
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, v1, :cond_0

    .line 77
    iput-boolean v1, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->collection:Z

    .line 79
    :cond_0
    return-void
.end method

.method public addValues(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 85
    .local p1, "values":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Object;>;"
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 87
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->collection:Z

    .line 88
    return-void
.end method

.method public asBoolean()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 134
    const-class v0, Ljava/lang/Boolean;

    invoke-direct {p0, v0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->asType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    return-object v0
.end method

.method public asBoolean(Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 1
    .param p1, "defaultValue"    # Ljava/lang/Boolean;

    .prologue
    .line 139
    const-class v0, Ljava/lang/Boolean;

    invoke-direct {p0, v0, p1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->asType(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    return-object v0
.end method

.method public asInt()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 144
    const-class v0, Ljava/lang/Integer;

    invoke-direct {p0, v0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->asType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    return-object v0
.end method

.method public asInt(Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 1
    .param p1, "defaultValue"    # Ljava/lang/Integer;

    .prologue
    .line 149
    const-class v0, Ljava/lang/Integer;

    invoke-direct {p0, v0, p1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->asType(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    return-object v0
.end method

.method public asItem()Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 3

    .prologue
    .line 200
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v1

    .line 202
    .local v1, "value":Ljava/lang/Object;
    instance-of v2, v1, Lcom/comcast/cim/microdata/model/MicrodataLink;

    if-eqz v2, :cond_0

    move-object v0, v1

    .line 203
    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataLink;

    .line 205
    .local v0, "link":Lcom/comcast/cim/microdata/model/MicrodataLink;
    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getValue()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->convertLinkToItem(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v2

    .line 208
    .end local v0    # "link":Lcom/comcast/cim/microdata/model/MicrodataLink;
    :goto_0
    return-object v2

    :cond_0
    const-class v2, Lcom/comcast/cim/microdata/model/MicrodataItem;

    invoke-direct {p0, v2}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->asType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/microdata/model/MicrodataItem;

    goto :goto_0
.end method

.method public asItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 214
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/comcast/cim/microdata/model/MicrodataLink;

    if-eqz v0, :cond_0

    .line 215
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataLink;

    invoke-direct {p0, v0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->convertLinkToItems(Lcom/comcast/cim/microdata/model/MicrodataLink;)Ljava/util/List;

    move-result-object v0

    .line 217
    :goto_0
    return-object v0

    :cond_0
    const-class v0, Lcom/comcast/cim/microdata/model/MicrodataItem;

    invoke-direct {p0, v0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->asTypeList(Ljava/lang/Class;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    .locals 2

    .prologue
    .line 224
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lcom/comcast/cim/microdata/model/MicrodataItem;

    if-eqz v1, :cond_0

    .line 225
    invoke-direct {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->convertItemToLink()Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getValue()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v1

    .line 232
    :goto_0
    return-object v1

    .line 226
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lcom/comcast/cim/microdata/model/MicrodataForm;

    if-eqz v1, :cond_1

    .line 227
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataForm;

    .line 229
    .local v0, "form":Lcom/comcast/cim/microdata/model/MicrodataForm;
    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataForm;->getValue()Lcom/comcast/cim/microdata/model/MicrodataFormValue;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->convertFormToLink(Lcom/comcast/cim/microdata/model/MicrodataFormValue;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v1

    goto :goto_0

    .line 232
    .end local v0    # "form":Lcom/comcast/cim/microdata/model/MicrodataForm;
    :cond_1
    const-class v1, Lcom/comcast/cim/microdata/model/MicrodataLink;

    invoke-direct {p0, v1}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->asType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/microdata/model/MicrodataLink;

    invoke-interface {v1}, Lcom/comcast/cim/microdata/model/MicrodataLink;->getValue()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v1

    goto :goto_0
.end method

.method public asList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 172
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public asList(Ljava/util/List;)Ljava/util/List;
    .locals 1
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

    .prologue
    .line 177
    .local p1, "defaultValue":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 178
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    .line 180
    .end local p1    # "defaultValue":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    :cond_0
    return-object p1
.end method

.method public asString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public asString(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 191
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 194
    .end local p1    # "defaultValue":Ljava/lang/String;
    :goto_0
    return-object p1

    .restart local p1    # "defaultValue":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method public getContext()Lcom/comcast/cim/microdata/model/MicrodataContext;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 50
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 52
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getValues()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public isCollection()Z
    .locals 1

    .prologue
    .line 114
    iget-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->collection:Z

    return v0
.end method

.method public isEmbedded()Z
    .locals 1

    .prologue
    .line 106
    iget-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->embedded:Z

    return v0
.end method

.method public isMissing()Z
    .locals 1

    .prologue
    .line 124
    const/4 v0, 0x0

    return v0
.end method

.method public setCollection(Z)V
    .locals 0
    .param p1, "collection"    # Z

    .prologue
    .line 118
    iput-boolean p1, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->collection:Z

    .line 119
    return-void
.end method

.method public setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V
    .locals 0
    .param p1, "context"    # Lcom/comcast/cim/microdata/model/MicrodataContext;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    .line 103
    return-void
.end method

.method public setEmbedded(Z)V
    .locals 0
    .param p1, "embedded"    # Z

    .prologue
    .line 110
    iput-boolean p1, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->embedded:Z

    .line 111
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 423
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 424
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "name"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 425
    const-string v1, "embedded"

    iget-boolean v2, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->embedded:Z

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 426
    const-string v1, "collection"

    iget-boolean v2, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->collection:Z

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 427
    const-string v1, "values"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataPropertyImpl;->values:Ljava/util/List;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 428
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
