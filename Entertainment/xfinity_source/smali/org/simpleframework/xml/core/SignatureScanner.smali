.class Lorg/simpleframework/xml/core/SignatureScanner;
.super Ljava/lang/Object;
.source "SignatureScanner.java"


# instance fields
.field private final builder:Lorg/simpleframework/xml/core/SignatureBuilder;

.field private final factory:Ljava/lang/reflect/Constructor;

.field private final format:Lorg/simpleframework/xml/stream/Format;

.field private final registry:Lorg/simpleframework/xml/core/ParameterMap;

.field private final type:Ljava/lang/Class;


# direct methods
.method public constructor <init>(Ljava/lang/reflect/Constructor;Lorg/simpleframework/xml/core/ParameterMap;Lorg/simpleframework/xml/stream/Format;)V
    .locals 1
    .param p1, "factory"    # Ljava/lang/reflect/Constructor;
    .param p2, "registry"    # Lorg/simpleframework/xml/core/ParameterMap;
    .param p3, "format"    # Lorg/simpleframework/xml/stream/Format;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    new-instance v0, Lorg/simpleframework/xml/core/SignatureBuilder;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/SignatureBuilder;-><init>(Ljava/lang/reflect/Constructor;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/SignatureScanner;->builder:Lorg/simpleframework/xml/core/SignatureBuilder;

    .line 91
    invoke-virtual {p1}, Ljava/lang/reflect/Constructor;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/SignatureScanner;->type:Ljava/lang/Class;

    .line 92
    iput-object p2, p0, Lorg/simpleframework/xml/core/SignatureScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    .line 93
    iput-object p1, p0, Lorg/simpleframework/xml/core/SignatureScanner;->factory:Ljava/lang/reflect/Constructor;

    .line 94
    iput-object p3, p0, Lorg/simpleframework/xml/core/SignatureScanner;->format:Lorg/simpleframework/xml/stream/Format;

    .line 95
    iget-object v0, p0, Lorg/simpleframework/xml/core/SignatureScanner;->type:Ljava/lang/Class;

    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/SignatureScanner;->scan(Ljava/lang/Class;)V

    .line 96
    return-void
.end method

.method private create(Ljava/lang/annotation/Annotation;I)Ljava/util/List;
    .locals 3
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .param p2, "ordinal"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/annotation/Annotation;",
            "I)",
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Parameter;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 239
    iget-object v1, p0, Lorg/simpleframework/xml/core/SignatureScanner;->factory:Ljava/lang/reflect/Constructor;

    iget-object v2, p0, Lorg/simpleframework/xml/core/SignatureScanner;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-static {v1, p1, v2, p2}, Lorg/simpleframework/xml/core/ParameterFactory;->getInstance(Ljava/lang/reflect/Constructor;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;I)Lorg/simpleframework/xml/core/Parameter;

    move-result-object v0

    .line 241
    .local v0, "parameter":Lorg/simpleframework/xml/core/Parameter;
    if-eqz v0, :cond_0

    .line 242
    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/SignatureScanner;->register(Lorg/simpleframework/xml/core/Parameter;)V

    .line 244
    :cond_0
    invoke-static {v0}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    return-object v1
.end method

.method private extract(Ljava/lang/annotation/Annotation;)[Ljava/lang/annotation/Annotation;
    .locals 9
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 257
    invoke-interface {p1}, Ljava/lang/annotation/Annotation;->annotationType()Ljava/lang/Class;

    move-result-object v2

    .line 258
    .local v2, "union":Ljava/lang/Class;
    invoke-virtual {v2}, Ljava/lang/Class;->getDeclaredMethods()[Ljava/lang/reflect/Method;

    move-result-object v0

    .line 260
    .local v0, "list":[Ljava/lang/reflect/Method;
    array-length v4, v0

    if-eq v4, v8, :cond_0

    .line 261
    new-instance v4, Lorg/simpleframework/xml/core/UnionException;

    const-string v5, "Annotation \'%s\' is not a valid union for %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    aput-object p1, v6, v7

    iget-object v7, p0, Lorg/simpleframework/xml/core/SignatureScanner;->type:Ljava/lang/Class;

    aput-object v7, v6, v8

    invoke-direct {v4, v5, v6}, Lorg/simpleframework/xml/core/UnionException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v4

    .line 263
    :cond_0
    aget-object v1, v0, v7

    .line 264
    .local v1, "method":Ljava/lang/reflect/Method;
    new-array v4, v7, [Ljava/lang/Object;

    invoke-virtual {v1, p1, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 266
    .local v3, "value":Ljava/lang/Object;
    check-cast v3, [Ljava/lang/annotation/Annotation;

    .end local v3    # "value":Ljava/lang/Object;
    check-cast v3, [Ljava/lang/annotation/Annotation;

    return-object v3
.end method

.method private process(Ljava/lang/annotation/Annotation;I)Ljava/util/List;
    .locals 1
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .param p2, "ordinal"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/annotation/Annotation;",
            "I)",
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Parameter;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 170
    instance-of v0, p1, Lorg/simpleframework/xml/Attribute;

    if-eqz v0, :cond_0

    .line 171
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->create(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    .line 197
    :goto_0
    return-object v0

    .line 173
    :cond_0
    instance-of v0, p1, Lorg/simpleframework/xml/Element;

    if-eqz v0, :cond_1

    .line 174
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->create(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 176
    :cond_1
    instance-of v0, p1, Lorg/simpleframework/xml/ElementList;

    if-eqz v0, :cond_2

    .line 177
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->create(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 179
    :cond_2
    instance-of v0, p1, Lorg/simpleframework/xml/ElementArray;

    if-eqz v0, :cond_3

    .line 180
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->create(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 182
    :cond_3
    instance-of v0, p1, Lorg/simpleframework/xml/ElementMap;

    if-eqz v0, :cond_4

    .line 183
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->create(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 185
    :cond_4
    instance-of v0, p1, Lorg/simpleframework/xml/ElementListUnion;

    if-eqz v0, :cond_5

    .line 186
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->union(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 188
    :cond_5
    instance-of v0, p1, Lorg/simpleframework/xml/ElementMapUnion;

    if-eqz v0, :cond_6

    .line 189
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->union(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 191
    :cond_6
    instance-of v0, p1, Lorg/simpleframework/xml/ElementUnion;

    if-eqz v0, :cond_7

    .line 192
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->union(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 194
    :cond_7
    instance-of v0, p1, Lorg/simpleframework/xml/Text;

    if-eqz v0, :cond_8

    .line 195
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->create(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 197
    :cond_8
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method private register(Lorg/simpleframework/xml/core/Parameter;)V
    .locals 3
    .param p1, "parameter"    # Lorg/simpleframework/xml/core/Parameter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 278
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 279
    .local v1, "path":Ljava/lang/String;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->getKey()Ljava/lang/Object;

    move-result-object v0

    .line 281
    .local v0, "key":Ljava/lang/Object;
    iget-object v2, p0, Lorg/simpleframework/xml/core/SignatureScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    invoke-virtual {v2, v0}, Lorg/simpleframework/xml/core/ParameterMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 282
    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/SignatureScanner;->validate(Lorg/simpleframework/xml/core/Parameter;Ljava/lang/Object;)V

    .line 284
    :cond_0
    iget-object v2, p0, Lorg/simpleframework/xml/core/SignatureScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    invoke-virtual {v2, v1}, Lorg/simpleframework/xml/core/ParameterMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 285
    invoke-direct {p0, p1, v1}, Lorg/simpleframework/xml/core/SignatureScanner;->validate(Lorg/simpleframework/xml/core/Parameter;Ljava/lang/Object;)V

    .line 287
    :cond_1
    iget-object v2, p0, Lorg/simpleframework/xml/core/SignatureScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    invoke-virtual {v2, v1, p1}, Lorg/simpleframework/xml/core/ParameterMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 288
    iget-object v2, p0, Lorg/simpleframework/xml/core/SignatureScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    invoke-virtual {v2, v0, p1}, Lorg/simpleframework/xml/core/ParameterMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 289
    return-void
.end method

.method private scan(Ljava/lang/Class;)V
    .locals 3
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 131
    iget-object v2, p0, Lorg/simpleframework/xml/core/SignatureScanner;->factory:Ljava/lang/reflect/Constructor;

    invoke-virtual {v2}, Ljava/lang/reflect/Constructor;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v1

    .line 133
    .local v1, "types":[Ljava/lang/Class;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 134
    aget-object v2, v1, v0

    invoke-direct {p0, v2, v0}, Lorg/simpleframework/xml/core/SignatureScanner;->scan(Ljava/lang/Class;I)V

    .line 133
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 136
    :cond_0
    return-void
.end method

.method private scan(Ljava/lang/Class;I)V
    .locals 6
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 148
    iget-object v5, p0, Lorg/simpleframework/xml/core/SignatureScanner;->factory:Ljava/lang/reflect/Constructor;

    invoke-virtual {v5}, Ljava/lang/reflect/Constructor;->getParameterAnnotations()[[Ljava/lang/annotation/Annotation;

    move-result-object v2

    .line 150
    .local v2, "labels":[[Ljava/lang/annotation/Annotation;
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_0
    aget-object v5, v2, p2

    array-length v5, v5

    if-ge v1, v5, :cond_1

    .line 151
    aget-object v5, v2, p2

    aget-object v5, v5, v1

    invoke-direct {p0, v5, p2}, Lorg/simpleframework/xml/core/SignatureScanner;->process(Ljava/lang/annotation/Annotation;I)Ljava/util/List;

    move-result-object v4

    .line 153
    .local v4, "value":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/simpleframework/xml/core/Parameter;>;"
    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/simpleframework/xml/core/Parameter;

    .line 154
    .local v3, "parameter":Lorg/simpleframework/xml/core/Parameter;
    iget-object v5, p0, Lorg/simpleframework/xml/core/SignatureScanner;->builder:Lorg/simpleframework/xml/core/SignatureBuilder;

    invoke-virtual {v5, v3, p2}, Lorg/simpleframework/xml/core/SignatureBuilder;->insert(Lorg/simpleframework/xml/core/Parameter;I)V

    goto :goto_1

    .line 150
    .end local v3    # "parameter":Lorg/simpleframework/xml/core/Parameter;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 157
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v4    # "value":Ljava/util/Collection;, "Ljava/util/Collection<Lorg/simpleframework/xml/core/Parameter;>;"
    :cond_1
    return-void
.end method

.method private union(Ljava/lang/annotation/Annotation;I)Ljava/util/List;
    .locals 13
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .param p2, "ordinal"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/annotation/Annotation;",
            "I)",
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Parameter;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 211
    new-instance v6, Lorg/simpleframework/xml/core/Signature;

    iget-object v8, p0, Lorg/simpleframework/xml/core/SignatureScanner;->factory:Ljava/lang/reflect/Constructor;

    invoke-direct {v6, v8}, Lorg/simpleframework/xml/core/Signature;-><init>(Ljava/lang/reflect/Constructor;)V

    .line 212
    .local v6, "signature":Lorg/simpleframework/xml/core/Signature;
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/SignatureScanner;->extract(Ljava/lang/annotation/Annotation;)[Ljava/lang/annotation/Annotation;

    move-result-object v3

    .line 214
    .local v3, "list":[Ljava/lang/annotation/Annotation;
    move-object v0, v3

    .local v0, "arr$":[Ljava/lang/annotation/Annotation;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v7, v0, v1

    .line 215
    .local v7, "value":Ljava/lang/annotation/Annotation;
    iget-object v8, p0, Lorg/simpleframework/xml/core/SignatureScanner;->factory:Ljava/lang/reflect/Constructor;

    iget-object v9, p0, Lorg/simpleframework/xml/core/SignatureScanner;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-static {v8, p1, v7, v9, p2}, Lorg/simpleframework/xml/core/ParameterFactory;->getInstance(Ljava/lang/reflect/Constructor;Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;I)Lorg/simpleframework/xml/core/Parameter;

    move-result-object v4

    .line 216
    .local v4, "parameter":Lorg/simpleframework/xml/core/Parameter;
    invoke-interface {v4}, Lorg/simpleframework/xml/core/Parameter;->getPath()Ljava/lang/String;

    move-result-object v5

    .line 218
    .local v5, "path":Ljava/lang/String;
    invoke-virtual {v6, v5}, Lorg/simpleframework/xml/core/Signature;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 219
    new-instance v8, Lorg/simpleframework/xml/core/UnionException;

    const-string v9, "Annotation name \'%s\' used more than once in %s for %s"

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v5, v10, v11

    const/4 v11, 0x1

    aput-object p1, v10, v11

    const/4 v11, 0x2

    iget-object v12, p0, Lorg/simpleframework/xml/core/SignatureScanner;->type:Ljava/lang/Class;

    aput-object v12, v10, v11

    invoke-direct {v8, v9, v10}, Lorg/simpleframework/xml/core/UnionException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v8

    .line 221
    :cond_0
    invoke-virtual {v6, v5, v4}, Lorg/simpleframework/xml/core/Signature;->set(Ljava/lang/Object;Lorg/simpleframework/xml/core/Parameter;)V

    .line 223
    invoke-direct {p0, v4}, Lorg/simpleframework/xml/core/SignatureScanner;->register(Lorg/simpleframework/xml/core/Parameter;)V

    .line 214
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 225
    .end local v4    # "parameter":Lorg/simpleframework/xml/core/Parameter;
    .end local v5    # "path":Ljava/lang/String;
    .end local v7    # "value":Ljava/lang/annotation/Annotation;
    :cond_1
    invoke-virtual {v6}, Lorg/simpleframework/xml/core/Signature;->getAll()Ljava/util/List;

    move-result-object v8

    return-object v8
.end method

.method private validate(Lorg/simpleframework/xml/core/Parameter;Ljava/lang/Object;)V
    .locals 10
    .param p1, "parameter"    # Lorg/simpleframework/xml/core/Parameter;
    .param p2, "key"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v7, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 301
    iget-object v5, p0, Lorg/simpleframework/xml/core/SignatureScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    invoke-virtual {v5, p2}, Lorg/simpleframework/xml/core/ParameterMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/simpleframework/xml/core/Parameter;

    .line 303
    .local v2, "other":Lorg/simpleframework/xml/core/Parameter;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->isText()Z

    move-result v5

    invoke-interface {v2}, Lorg/simpleframework/xml/core/Parameter;->isText()Z

    move-result v6

    if-eq v5, v6, :cond_1

    .line 304
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v1

    .line 305
    .local v1, "expect":Ljava/lang/annotation/Annotation;
    invoke-interface {v2}, Lorg/simpleframework/xml/core/Parameter;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v0

    .line 306
    .local v0, "actual":Ljava/lang/annotation/Annotation;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->getPath()Ljava/lang/String;

    move-result-object v3

    .line 308
    .local v3, "path":Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 309
    new-instance v5, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v6, "Annotations do not match for \'%s\' in %s"

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v3, v7, v8

    iget-object v8, p0, Lorg/simpleframework/xml/core/SignatureScanner;->type:Ljava/lang/Class;

    aput-object v8, v7, v9

    invoke-direct {v5, v6, v7}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v5

    .line 311
    :cond_0
    invoke-interface {v2}, Lorg/simpleframework/xml/core/Parameter;->getType()Ljava/lang/Class;

    move-result-object v4

    .line 313
    .local v4, "real":Ljava/lang/Class;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Parameter;->getType()Ljava/lang/Class;

    move-result-object v5

    if-eq v4, v5, :cond_1

    .line 314
    new-instance v5, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v6, "Parameter types do not match for \'%s\' in %s"

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v3, v7, v8

    iget-object v8, p0, Lorg/simpleframework/xml/core/SignatureScanner;->type:Ljava/lang/Class;

    aput-object v8, v7, v9

    invoke-direct {v5, v6, v7}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v5

    .line 317
    .end local v0    # "actual":Ljava/lang/annotation/Annotation;
    .end local v1    # "expect":Ljava/lang/annotation/Annotation;
    .end local v3    # "path":Ljava/lang/String;
    .end local v4    # "real":Ljava/lang/Class;
    :cond_1
    return-void
.end method


# virtual methods
.method public getSignatures()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Signature;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 119
    iget-object v0, p0, Lorg/simpleframework/xml/core/SignatureScanner;->builder:Lorg/simpleframework/xml/core/SignatureBuilder;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/SignatureBuilder;->build()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public isValid()Z
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lorg/simpleframework/xml/core/SignatureScanner;->builder:Lorg/simpleframework/xml/core/SignatureBuilder;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/SignatureBuilder;->isValid()Z

    move-result v0

    return v0
.end method
