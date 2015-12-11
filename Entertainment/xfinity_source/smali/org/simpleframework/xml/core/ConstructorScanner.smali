.class Lorg/simpleframework/xml/core/ConstructorScanner;
.super Ljava/lang/Object;
.source "ConstructorScanner.java"


# instance fields
.field private format:Lorg/simpleframework/xml/stream/Format;

.field private primary:Lorg/simpleframework/xml/core/Signature;

.field private registry:Lorg/simpleframework/xml/core/ParameterMap;

.field private signatures:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Signature;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "format"    # Lorg/simpleframework/xml/stream/Format;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->signatures:Ljava/util/List;

    .line 73
    new-instance v0, Lorg/simpleframework/xml/core/ParameterMap;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/ParameterMap;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    .line 74
    iput-object p2, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->format:Lorg/simpleframework/xml/stream/Format;

    .line 75
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ConstructorScanner;->scan(Ljava/lang/Class;)V

    .line 76
    return-void
.end method

.method private isInstantiable(Ljava/lang/Class;)Z
    .locals 3
    .param p1, "type"    # Ljava/lang/Class;

    .prologue
    const/4 v1, 0x1

    .line 168
    invoke-virtual {p1}, Ljava/lang/Class;->getModifiers()I

    move-result v0

    .line 170
    .local v0, "modifiers":I
    invoke-static {v0}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 173
    :cond_0
    :goto_0
    return v1

    :cond_1
    invoke-virtual {p1}, Ljava/lang/Class;->isMemberClass()Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x0

    goto :goto_0
.end method

.method private scan(Ljava/lang/Class;)V
    .locals 9
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 121
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredConstructors()[Ljava/lang/reflect/Constructor;

    move-result-object v1

    .line 123
    .local v1, "array":[Ljava/lang/reflect/Constructor;
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ConstructorScanner;->isInstantiable(Ljava/lang/Class;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 124
    new-instance v5, Lorg/simpleframework/xml/core/ConstructorException;

    const-string v6, "Can not construct inner %s"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p1, v7, v8

    invoke-direct {v5, v6, v7}, Lorg/simpleframework/xml/core/ConstructorException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v5

    .line 126
    :cond_0
    move-object v0, v1

    .local v0, "arr$":[Ljava/lang/reflect/Constructor;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_2

    aget-object v2, v0, v3

    .line 127
    .local v2, "factory":Ljava/lang/reflect/Constructor;
    invoke-virtual {p1}, Ljava/lang/Class;->isPrimitive()Z

    move-result v5

    if-nez v5, :cond_1

    .line 128
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/ConstructorScanner;->scan(Ljava/lang/reflect/Constructor;)V

    .line 126
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 131
    .end local v2    # "factory":Ljava/lang/reflect/Constructor;
    :cond_2
    return-void
.end method

.method private scan(Ljava/lang/reflect/Constructor;)V
    .locals 7
    .param p1, "factory"    # Ljava/lang/reflect/Constructor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 141
    new-instance v2, Lorg/simpleframework/xml/core/SignatureScanner;

    iget-object v5, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    iget-object v6, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-direct {v2, p1, v5, v6}, Lorg/simpleframework/xml/core/SignatureScanner;-><init>(Ljava/lang/reflect/Constructor;Lorg/simpleframework/xml/core/ParameterMap;Lorg/simpleframework/xml/stream/Format;)V

    .line 143
    .local v2, "scanner":Lorg/simpleframework/xml/core/SignatureScanner;
    invoke-virtual {v2}, Lorg/simpleframework/xml/core/SignatureScanner;->isValid()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 144
    invoke-virtual {v2}, Lorg/simpleframework/xml/core/SignatureScanner;->getSignatures()Ljava/util/List;

    move-result-object v1

    .line 146
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Lorg/simpleframework/xml/core/Signature;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/simpleframework/xml/core/Signature;

    .line 147
    .local v3, "signature":Lorg/simpleframework/xml/core/Signature;
    invoke-virtual {v3}, Lorg/simpleframework/xml/core/Signature;->size()I

    move-result v4

    .line 149
    .local v4, "size":I
    if-nez v4, :cond_0

    .line 150
    iput-object v3, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->primary:Lorg/simpleframework/xml/core/Signature;

    .line 152
    :cond_0
    iget-object v5, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->signatures:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 155
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "list":Ljava/util/List;, "Ljava/util/List<Lorg/simpleframework/xml/core/Signature;>;"
    .end local v3    # "signature":Lorg/simpleframework/xml/core/Signature;
    .end local v4    # "size":I
    :cond_1
    return-void
.end method


# virtual methods
.method public getParameters()Lorg/simpleframework/xml/core/ParameterMap;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->registry:Lorg/simpleframework/xml/core/ParameterMap;

    return-object v0
.end method

.method public getSignature()Lorg/simpleframework/xml/core/Signature;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->primary:Lorg/simpleframework/xml/core/Signature;

    return-object v0
.end method

.method public getSignatures()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lorg/simpleframework/xml/core/Signature;",
            ">;"
        }
    .end annotation

    .prologue
    .line 99
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lorg/simpleframework/xml/core/ConstructorScanner;->signatures:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method
