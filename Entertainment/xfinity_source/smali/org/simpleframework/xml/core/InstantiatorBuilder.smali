.class Lorg/simpleframework/xml/core/InstantiatorBuilder;
.super Ljava/lang/Object;
.source "InstantiatorBuilder.java"


# instance fields
.field private attributes:Lorg/simpleframework/xml/core/LabelMap;

.field private comparer:Lorg/simpleframework/xml/core/Comparer;

.field private elements:Lorg/simpleframework/xml/core/LabelMap;

.field private factory:Lorg/simpleframework/xml/core/Instantiator;

.field private options:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Creator;",
            ">;"
        }
    .end annotation
.end field

.field private scanner:Lorg/simpleframework/xml/core/Scanner;

.field private texts:Lorg/simpleframework/xml/core/LabelMap;

.field private type:Ljava/lang/Class;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/Scanner;Ljava/lang/Class;)V
    .locals 1
    .param p1, "scanner"    # Lorg/simpleframework/xml/core/Scanner;
    .param p2, "type"    # Ljava/lang/Class;

    .prologue
    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->options:Ljava/util/List;

    .line 94
    new-instance v0, Lorg/simpleframework/xml/core/Comparer;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/Comparer;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->comparer:Lorg/simpleframework/xml/core/Comparer;

    .line 95
    new-instance v0, Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/LabelMap;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    .line 96
    new-instance v0, Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/LabelMap;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    .line 97
    new-instance v0, Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/LabelMap;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->texts:Lorg/simpleframework/xml/core/LabelMap;

    .line 98
    iput-object p1, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    .line 99
    iput-object p2, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->type:Ljava/lang/Class;

    .line 100
    return-void
.end method

.method private build(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Instantiator;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 132
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    if-nez v0, :cond_0

    .line 133
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->create(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Instantiator;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    .line 135
    :cond_0
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    return-object v0
.end method

.method private contains([Ljava/lang/String;Ljava/lang/String;)Z
    .locals 6
    .param p1, "list"    # [Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 523
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_2

    aget-object v1, v0, v2

    .line 524
    .local v1, "entry":Ljava/lang/String;
    if-ne v1, p2, :cond_1

    .line 531
    .end local v1    # "entry":Ljava/lang/String;
    :cond_0
    :goto_1
    return v4

    .line 527
    .restart local v1    # "entry":Ljava/lang/String;
    :cond_1
    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 523
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 531
    .end local v1    # "entry":Ljava/lang/String;
    :cond_2
    const/4 v4, 0x0

    goto :goto_1
.end method

.method private create(Lorg/simpleframework/xml/core/Signature;)Lorg/simpleframework/xml/core/Creator;
    .locals 2
    .param p1, "signature"    # Lorg/simpleframework/xml/core/Signature;

    .prologue
    .line 171
    new-instance v0, Lorg/simpleframework/xml/core/SignatureCreator;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/SignatureCreator;-><init>(Lorg/simpleframework/xml/core/Signature;)V

    .line 173
    .local v0, "creator":Lorg/simpleframework/xml/core/Creator;
    if-eqz p1, :cond_0

    .line 174
    iget-object v1, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->options:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 176
    :cond_0
    return-object v0
.end method

.method private create(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Instantiator;
    .locals 5
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 150
    iget-object v3, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    invoke-interface {v3}, Lorg/simpleframework/xml/core/Scanner;->getSignature()Lorg/simpleframework/xml/core/Signature;

    move-result-object v1

    .line 151
    .local v1, "primary":Lorg/simpleframework/xml/core/Signature;
    iget-object v3, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    invoke-interface {v3}, Lorg/simpleframework/xml/core/Scanner;->getParameters()Lorg/simpleframework/xml/core/ParameterMap;

    move-result-object v2

    .line 152
    .local v2, "registry":Lorg/simpleframework/xml/core/ParameterMap;
    const/4 v0, 0x0

    .line 154
    .local v0, "creator":Lorg/simpleframework/xml/core/Creator;
    if-eqz v1, :cond_0

    .line 155
    new-instance v0, Lorg/simpleframework/xml/core/SignatureCreator;

    .end local v0    # "creator":Lorg/simpleframework/xml/core/Creator;
    invoke-direct {v0, v1}, Lorg/simpleframework/xml/core/SignatureCreator;-><init>(Lorg/simpleframework/xml/core/Signature;)V

    .line 157
    .restart local v0    # "creator":Lorg/simpleframework/xml/core/Creator;
    :cond_0
    new-instance v3, Lorg/simpleframework/xml/core/ClassInstantiator;

    iget-object v4, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->options:Ljava/util/List;

    invoke-direct {v3, v4, v0, v2, p1}, Lorg/simpleframework/xml/core/ClassInstantiator;-><init>(Ljava/util/List;Lorg/simpleframework/xml/core/Creator;Lorg/simpleframework/xml/core/ParameterMap;Ljava/lang/Class;)V

    return-object v3
.end method

.method private create(Lorg/simpleframework/xml/core/Parameter;)Lorg/simpleframework/xml/core/Parameter;
    .locals 2
    .param p1, "original"    # Lorg/simpleframework/xml/core/Parameter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 190
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->resolve(Lorg/simpleframework/xml/core/Parameter;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    .line 192
    .local v0, "label":Lorg/simpleframework/xml/core/Label;
    if-eqz v0, :cond_0

    .line 193
    new-instance v1, Lorg/simpleframework/xml/core/CacheParameter;

    invoke-direct {v1, p1, v0}, Lorg/simpleframework/xml/core/CacheParameter;-><init>(Lorg/simpleframework/xml/core/Parameter;Lorg/simpleframework/xml/core/Label;)V

    .line 195
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private populate(Ljava/lang/Class;)V
    .locals 4
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 207
    iget-object v3, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    invoke-interface {v3}, Lorg/simpleframework/xml/core/Scanner;->getSignatures()Ljava/util/List;

    move-result-object v1

    .line 209
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Lorg/simpleframework/xml/core/Signature;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/simpleframework/xml/core/Signature;

    .line 210
    .local v2, "signature":Lorg/simpleframework/xml/core/Signature;
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->populate(Lorg/simpleframework/xml/core/Signature;)V

    goto :goto_0

    .line 212
    .end local v2    # "signature":Lorg/simpleframework/xml/core/Signature;
    :cond_0
    return-void
.end method

.method private populate(Lorg/simpleframework/xml/core/Signature;)V
    .locals 5
    .param p1, "signature"    # Lorg/simpleframework/xml/core/Signature;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 223
    new-instance v3, Lorg/simpleframework/xml/core/Signature;

    invoke-direct {v3, p1}, Lorg/simpleframework/xml/core/Signature;-><init>(Lorg/simpleframework/xml/core/Signature;)V

    .line 225
    .local v3, "substitute":Lorg/simpleframework/xml/core/Signature;
    invoke-virtual {p1}, Lorg/simpleframework/xml/core/Signature;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Parameter;

    .line 226
    .local v1, "parameter":Lorg/simpleframework/xml/core/Parameter;
    invoke-direct {p0, v1}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->create(Lorg/simpleframework/xml/core/Parameter;)Lorg/simpleframework/xml/core/Parameter;

    move-result-object v2

    .line 228
    .local v2, "replace":Lorg/simpleframework/xml/core/Parameter;
    if-eqz v2, :cond_0

    .line 229
    invoke-virtual {v3, v2}, Lorg/simpleframework/xml/core/Signature;->add(Lorg/simpleframework/xml/core/Parameter;)V

    goto :goto_0

    .line 232
    .end local v1    # "parameter":Lorg/simpleframework/xml/core/Parameter;
    .end local v2    # "replace":Lorg/simpleframework/xml/core/Parameter;
    :cond_1
    invoke-direct {p0, v3}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->create(Lorg/simpleframework/xml/core/Signature;)Lorg/simpleframework/xml/core/Creator;

    .line 233
    return-void
.end method

.method private register(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/LabelMap;)V
    .locals 5
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .param p2, "map"    # Lorg/simpleframework/xml/core/LabelMap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 456
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getName()Ljava/lang/String;

    move-result-object v2

    .line 457
    .local v2, "name":Ljava/lang/String;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getPath()Ljava/lang/String;

    move-result-object v3

    .line 459
    .local v3, "path":Ljava/lang/String;
    invoke-virtual {p2, v2}, Lorg/simpleframework/xml/core/LabelMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 460
    invoke-virtual {p2, v2}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/core/Label;

    .line 461
    .local v0, "current":Lorg/simpleframework/xml/core/Label;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Label;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 463
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 464
    invoke-virtual {p2, v2}, Lorg/simpleframework/xml/core/LabelMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 469
    .end local v0    # "current":Lorg/simpleframework/xml/core/Label;
    .end local v1    # "key":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-virtual {p2, v3, p1}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 470
    return-void

    .line 467
    :cond_1
    invoke-virtual {p2, v2, p1}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private resolve(Lorg/simpleframework/xml/core/Parameter;)Lorg/simpleframework/xml/core/Label;
    .locals 1
    .param p1, "parameter"    # Lorg/simpleframework/xml/core/Parameter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 482
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->isAttribute()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 483
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->resolve(Lorg/simpleframework/xml/core/Parameter;Lorg/simpleframework/xml/core/LabelMap;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    .line 487
    :goto_0
    return-object v0

    .line 484
    :cond_0
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->isText()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 485
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->texts:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->resolve(Lorg/simpleframework/xml/core/Parameter;Lorg/simpleframework/xml/core/LabelMap;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    goto :goto_0

    .line 487
    :cond_1
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->resolve(Lorg/simpleframework/xml/core/Parameter;Lorg/simpleframework/xml/core/LabelMap;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    goto :goto_0
.end method

.method private resolve(Lorg/simpleframework/xml/core/Parameter;Lorg/simpleframework/xml/core/LabelMap;)Lorg/simpleframework/xml/core/Label;
    .locals 4
    .param p1, "parameter"    # Lorg/simpleframework/xml/core/Parameter;
    .param p2, "map"    # Lorg/simpleframework/xml/core/LabelMap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 502
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->getName()Ljava/lang/String;

    move-result-object v1

    .line 503
    .local v1, "name":Ljava/lang/String;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 504
    .local v2, "path":Ljava/lang/String;
    invoke-virtual {p2, v2}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/core/Label;

    .line 506
    .local v0, "label":Lorg/simpleframework/xml/core/Label;
    if-nez v0, :cond_0

    .line 507
    invoke-virtual {p2, v1}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/simpleframework/xml/core/Label;

    .line 509
    :goto_0
    return-object v3

    :cond_0
    move-object v3, v0

    goto :goto_0
.end method

.method private validate(Ljava/lang/Class;)V
    .locals 10
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 244
    iget-object v6, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    invoke-interface {v6}, Lorg/simpleframework/xml/core/Scanner;->getParameters()Lorg/simpleframework/xml/core/ParameterMap;

    move-result-object v5

    .line 245
    .local v5, "registry":Lorg/simpleframework/xml/core/ParameterMap;
    invoke-virtual {v5}, Lorg/simpleframework/xml/core/ParameterMap;->getAll()Ljava/util/List;

    move-result-object v2

    .line 247
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lorg/simpleframework/xml/core/Parameter;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/simpleframework/xml/core/Parameter;

    .line 248
    .local v3, "parameter":Lorg/simpleframework/xml/core/Parameter;
    invoke-direct {p0, v3}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->resolve(Lorg/simpleframework/xml/core/Parameter;)Lorg/simpleframework/xml/core/Label;

    move-result-object v1

    .line 249
    .local v1, "label":Lorg/simpleframework/xml/core/Label;
    invoke-interface {v3}, Lorg/simpleframework/xml/core/Parameter;->getPath()Ljava/lang/String;

    move-result-object v4

    .line 251
    .local v4, "path":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 252
    new-instance v6, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v7, "Parameter \'%s\' does not have a match in %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v4, v8, v9

    const/4 v9, 0x1

    aput-object p1, v8, v9

    invoke-direct {v6, v7, v8}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v6

    .line 254
    :cond_0
    invoke-direct {p0, v1, v3}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateParameter(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/Parameter;)V

    goto :goto_0

    .line 256
    .end local v1    # "label":Lorg/simpleframework/xml/core/Label;
    .end local v3    # "parameter":Lorg/simpleframework/xml/core/Parameter;
    .end local v4    # "path":Ljava/lang/String;
    :cond_1
    invoke-direct {p0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateConstructors()V

    .line 257
    return-void
.end method

.method private validateAnnotations(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/Parameter;)V
    .locals 9
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .param p2, "parameter"    # Lorg/simpleframework/xml/core/Parameter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 318
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v3

    .line 319
    .local v3, "field":Ljava/lang/annotation/Annotation;
    invoke-interface {p2}, Lorg/simpleframework/xml/core/Parameter;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v1

    .line 320
    .local v1, "argument":Ljava/lang/annotation/Annotation;
    invoke-interface {p2}, Lorg/simpleframework/xml/core/Parameter;->getName()Ljava/lang/String;

    move-result-object v4

    .line 322
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->comparer:Lorg/simpleframework/xml/core/Comparer;

    invoke-virtual {v5, v3, v1}, Lorg/simpleframework/xml/core/Comparer;->equals(Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 323
    invoke-interface {v3}, Ljava/lang/annotation/Annotation;->annotationType()Ljava/lang/Class;

    move-result-object v2

    .line 324
    .local v2, "expect":Ljava/lang/Class;
    invoke-interface {v1}, Ljava/lang/annotation/Annotation;->annotationType()Ljava/lang/Class;

    move-result-object v0

    .line 326
    .local v0, "actual":Ljava/lang/Class;
    invoke-virtual {v2, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 327
    new-instance v5, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v6, "Annotation %s does not match %s for \'%s\' in %s"

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v0, v7, v8

    const/4 v8, 0x1

    aput-object v2, v7, v8

    const/4 v8, 0x2

    aput-object v4, v7, v8

    const/4 v8, 0x3

    aput-object p2, v7, v8

    invoke-direct {v5, v6, v7}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v5

    .line 330
    .end local v0    # "actual":Ljava/lang/Class;
    .end local v2    # "expect":Ljava/lang/Class;
    :cond_0
    return-void
.end method

.method private validateConstructor(Lorg/simpleframework/xml/core/Label;Ljava/util/List;)V
    .locals 7
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/simpleframework/xml/core/Label;",
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Creator;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 401
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lorg/simpleframework/xml/core/Creator;>;"
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 403
    .local v2, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lorg/simpleframework/xml/core/Creator;>;"
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 404
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Creator;

    .line 405
    .local v1, "instantiator":Lorg/simpleframework/xml/core/Creator;
    invoke-interface {v1}, Lorg/simpleframework/xml/core/Creator;->getSignature()Lorg/simpleframework/xml/core/Signature;

    move-result-object v4

    .line 406
    .local v4, "signature":Lorg/simpleframework/xml/core/Signature;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getContact()Lorg/simpleframework/xml/core/Contact;

    move-result-object v0

    .line 407
    .local v0, "contact":Lorg/simpleframework/xml/core/Contact;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getKey()Ljava/lang/Object;

    move-result-object v3

    .line 409
    .local v3, "key":Ljava/lang/Object;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Contact;->isReadOnly()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 410
    invoke-virtual {v4, v3}, Lorg/simpleframework/xml/core/Signature;->get(Ljava/lang/Object;)Lorg/simpleframework/xml/core/Parameter;

    move-result-object v5

    .line 412
    .local v5, "value":Lorg/simpleframework/xml/core/Parameter;
    if-nez v5, :cond_0

    .line 413
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 417
    .end local v0    # "contact":Lorg/simpleframework/xml/core/Contact;
    .end local v1    # "instantiator":Lorg/simpleframework/xml/core/Creator;
    .end local v3    # "key":Ljava/lang/Object;
    .end local v4    # "signature":Lorg/simpleframework/xml/core/Signature;
    .end local v5    # "value":Lorg/simpleframework/xml/core/Parameter;
    :cond_1
    return-void
.end method

.method private validateConstructors()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 339
    iget-object v1, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    invoke-interface {v1}, Lorg/simpleframework/xml/core/Instantiator;->getCreators()Ljava/util/List;

    move-result-object v0

    .line 341
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Lorg/simpleframework/xml/core/Creator;>;"
    iget-object v1, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    invoke-interface {v1}, Lorg/simpleframework/xml/core/Instantiator;->isDefault()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 342
    iget-object v1, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, v1}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateConstructors(Lorg/simpleframework/xml/core/LabelMap;)V

    .line 343
    iget-object v1, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, v1}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateConstructors(Lorg/simpleframework/xml/core/LabelMap;)V

    .line 345
    :cond_0
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 346
    iget-object v1, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, v1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateConstructors(Lorg/simpleframework/xml/core/LabelMap;Ljava/util/List;)V

    .line 347
    iget-object v1, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, v1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateConstructors(Lorg/simpleframework/xml/core/LabelMap;Ljava/util/List;)V

    .line 349
    :cond_1
    return-void
.end method

.method private validateConstructors(Lorg/simpleframework/xml/core/LabelMap;)V
    .locals 8
    .param p1, "map"    # Lorg/simpleframework/xml/core/LabelMap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 360
    invoke-virtual {p1}, Lorg/simpleframework/xml/core/LabelMap;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/simpleframework/xml/core/Label;

    .line 361
    .local v2, "label":Lorg/simpleframework/xml/core/Label;
    if-eqz v2, :cond_0

    .line 362
    invoke-interface {v2}, Lorg/simpleframework/xml/core/Label;->getContact()Lorg/simpleframework/xml/core/Contact;

    move-result-object v0

    .line 364
    .local v0, "contact":Lorg/simpleframework/xml/core/Contact;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Contact;->isReadOnly()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 365
    new-instance v3, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v4, "Default constructor can not accept read only %s in %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v2, v5, v6

    const/4 v6, 0x1

    iget-object v7, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->type:Ljava/lang/Class;

    aput-object v7, v5, v6

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 369
    .end local v0    # "contact":Lorg/simpleframework/xml/core/Contact;
    .end local v2    # "label":Lorg/simpleframework/xml/core/Label;
    :cond_1
    return-void
.end method

.method private validateConstructors(Lorg/simpleframework/xml/core/LabelMap;Ljava/util/List;)V
    .locals 7
    .param p1, "map"    # Lorg/simpleframework/xml/core/LabelMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/simpleframework/xml/core/LabelMap;",
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Creator;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 381
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lorg/simpleframework/xml/core/Creator;>;"
    invoke-virtual {p1}, Lorg/simpleframework/xml/core/LabelMap;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Label;

    .line 382
    .local v1, "label":Lorg/simpleframework/xml/core/Label;
    if-eqz v1, :cond_0

    .line 383
    invoke-direct {p0, v1, p2}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateConstructor(Lorg/simpleframework/xml/core/Label;Ljava/util/List;)V

    goto :goto_0

    .line 386
    .end local v1    # "label":Lorg/simpleframework/xml/core/Label;
    :cond_1
    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 387
    new-instance v2, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v3, "No constructor accepts all read only values in %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->type:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-direct {v2, v3, v4}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v2

    .line 389
    :cond_2
    return-void
.end method

.method private validateNames(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/Parameter;)V
    .locals 9
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .param p2, "parameter"    # Lorg/simpleframework/xml/core/Parameter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 291
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getNames()[Ljava/lang/String;

    move-result-object v1

    .line 292
    .local v1, "options":[Ljava/lang/String;
    invoke-interface {p2}, Lorg/simpleframework/xml/core/Parameter;->getName()Ljava/lang/String;

    move-result-object v0

    .line 294
    .local v0, "name":Ljava/lang/String;
    invoke-direct {p0, v1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->contains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 295
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getName()Ljava/lang/String;

    move-result-object v2

    .line 297
    .local v2, "require":Ljava/lang/String;
    if-eq v0, v2, :cond_2

    .line 298
    if-eqz v0, :cond_0

    if-nez v2, :cond_1

    .line 299
    :cond_0
    new-instance v3, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v4, "Annotation does not match %s for \'%s\' in %s"

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    aput-object v0, v5, v7

    aput-object p2, v5, v8

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 301
    :cond_1
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 302
    new-instance v3, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v4, "Annotation does not match %s for \'%s\' in %s"

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    aput-object v0, v5, v7

    aput-object p2, v5, v8

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 306
    .end local v2    # "require":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method private validateParameter(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/Parameter;)V
    .locals 8
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .param p2, "parameter"    # Lorg/simpleframework/xml/core/Parameter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 268
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getContact()Lorg/simpleframework/xml/core/Contact;

    move-result-object v1

    .line 269
    .local v1, "contact":Lorg/simpleframework/xml/core/Contact;
    invoke-interface {p2}, Lorg/simpleframework/xml/core/Parameter;->getName()Ljava/lang/String;

    move-result-object v3

    .line 270
    .local v3, "name":Ljava/lang/String;
    invoke-interface {p2}, Lorg/simpleframework/xml/core/Parameter;->getType()Ljava/lang/Class;

    move-result-object v2

    .line 271
    .local v2, "expect":Ljava/lang/Class;
    invoke-interface {v1}, Lorg/simpleframework/xml/core/Contact;->getType()Ljava/lang/Class;

    move-result-object v0

    .line 273
    .local v0, "actual":Ljava/lang/Class;
    invoke-static {v2, v0}, Lorg/simpleframework/xml/core/Support;->isAssignable(Ljava/lang/Class;Ljava/lang/Class;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 274
    new-instance v4, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v5, "Type is not compatible with %s for \'%s\' in %s"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    aput-object v3, v6, v7

    const/4 v7, 0x2

    aput-object p2, v6, v7

    invoke-direct {v4, v5, v6}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v4

    .line 276
    :cond_0
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateNames(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/Parameter;)V

    .line 277
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validateAnnotations(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/Parameter;)V

    .line 278
    return-void
.end method


# virtual methods
.method public build()Lorg/simpleframework/xml/core/Instantiator;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 112
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    if-nez v0, :cond_0

    .line 113
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->type:Ljava/lang/Class;

    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->populate(Ljava/lang/Class;)V

    .line 114
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->type:Ljava/lang/Class;

    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->build(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Instantiator;

    .line 115
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->type:Ljava/lang/Class;

    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->validate(Ljava/lang/Class;)V

    .line 117
    :cond_0
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    return-object v0
.end method

.method public register(Lorg/simpleframework/xml/core/Label;)V
    .locals 1
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 428
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isAttribute()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 429
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->register(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 435
    :goto_0
    return-void

    .line 430
    :cond_0
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isText()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 431
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->texts:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->register(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/LabelMap;)V

    goto :goto_0

    .line 433
    :cond_1
    iget-object v0, p0, Lorg/simpleframework/xml/core/InstantiatorBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->register(Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/LabelMap;)V

    goto :goto_0
.end method
