.class final Lorg/simpleframework/xml/core/ParameterFactory;
.super Ljava/lang/Object;
.source "ParameterFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 147
    return-void
.end method

.method private static getBuilder(Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;
    .locals 4
    .param p0, "label"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 109
    instance-of v0, p0, Lorg/simpleframework/xml/Element;

    if-eqz v0, :cond_0

    .line 110
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementParameter;

    const-class v2, Lorg/simpleframework/xml/Element;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    .line 134
    :goto_0
    return-object v0

    .line 112
    :cond_0
    instance-of v0, p0, Lorg/simpleframework/xml/ElementList;

    if-eqz v0, :cond_1

    .line 113
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementListParameter;

    const-class v2, Lorg/simpleframework/xml/ElementList;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 115
    :cond_1
    instance-of v0, p0, Lorg/simpleframework/xml/ElementArray;

    if-eqz v0, :cond_2

    .line 116
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementArrayParameter;

    const-class v2, Lorg/simpleframework/xml/ElementArray;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 118
    :cond_2
    instance-of v0, p0, Lorg/simpleframework/xml/ElementMapUnion;

    if-eqz v0, :cond_3

    .line 119
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementMapUnionParameter;

    const-class v2, Lorg/simpleframework/xml/ElementMapUnion;

    const-class v3, Lorg/simpleframework/xml/ElementMap;

    invoke-direct {v0, v1, v2, v3}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 121
    :cond_3
    instance-of v0, p0, Lorg/simpleframework/xml/ElementListUnion;

    if-eqz v0, :cond_4

    .line 122
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementListUnionParameter;

    const-class v2, Lorg/simpleframework/xml/ElementListUnion;

    const-class v3, Lorg/simpleframework/xml/ElementList;

    invoke-direct {v0, v1, v2, v3}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 124
    :cond_4
    instance-of v0, p0, Lorg/simpleframework/xml/ElementUnion;

    if-eqz v0, :cond_5

    .line 125
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementUnionParameter;

    const-class v2, Lorg/simpleframework/xml/ElementUnion;

    const-class v3, Lorg/simpleframework/xml/Element;

    invoke-direct {v0, v1, v2, v3}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 127
    :cond_5
    instance-of v0, p0, Lorg/simpleframework/xml/ElementMap;

    if-eqz v0, :cond_6

    .line 128
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementMapParameter;

    const-class v2, Lorg/simpleframework/xml/ElementMap;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 130
    :cond_6
    instance-of v0, p0, Lorg/simpleframework/xml/Attribute;

    if-eqz v0, :cond_7

    .line 131
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/AttributeParameter;

    const-class v2, Lorg/simpleframework/xml/Attribute;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 133
    :cond_7
    instance-of v0, p0, Lorg/simpleframework/xml/Text;

    if-eqz v0, :cond_8

    .line 134
    new-instance v0, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    const-class v1, Lorg/simpleframework/xml/core/TextParameter;

    const-class v2, Lorg/simpleframework/xml/Text;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 136
    :cond_8
    new-instance v0, Lorg/simpleframework/xml/core/PersistenceException;

    const-string v1, "Annotation %s not supported"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/PersistenceException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v0
.end method

.method private static getConstructor(Ljava/lang/annotation/Annotation;)Ljava/lang/reflect/Constructor;
    .locals 3
    .param p0, "label"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 89
    invoke-static {p0}, Lorg/simpleframework/xml/core/ParameterFactory;->getBuilder(Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;

    move-result-object v0

    .line 90
    .local v0, "builder":Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;
    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ParameterFactory$ParameterBuilder;->getConstructor()Ljava/lang/reflect/Constructor;

    move-result-object v1

    .line 92
    .local v1, "factory":Ljava/lang/reflect/Constructor;
    invoke-virtual {v1}, Ljava/lang/reflect/Constructor;->isAccessible()Z

    move-result v2

    if-nez v2, :cond_0

    .line 93
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Constructor;->setAccessible(Z)V

    .line 95
    :cond_0
    return-object v1
.end method

.method public static getInstance(Ljava/lang/reflect/Constructor;Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;I)Lorg/simpleframework/xml/core/Parameter;
    .locals 7
    .param p0, "method"    # Ljava/lang/reflect/Constructor;
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .param p2, "entry"    # Ljava/lang/annotation/Annotation;
    .param p3, "format"    # Lorg/simpleframework/xml/stream/Format;
    .param p4, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 68
    invoke-static {p1}, Lorg/simpleframework/xml/core/ParameterFactory;->getConstructor(Ljava/lang/annotation/Annotation;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    .line 70
    .local v0, "factory":Ljava/lang/reflect/Constructor;
    if-eqz p2, :cond_0

    .line 71
    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p0, v1, v2

    aput-object p1, v1, v3

    aput-object p2, v1, v4

    aput-object p3, v1, v5

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Parameter;

    .line 73
    :goto_0
    return-object v1

    :cond_0
    new-array v1, v6, [Ljava/lang/Object;

    aput-object p0, v1, v2

    aput-object p1, v1, v3

    aput-object p3, v1, v4

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Parameter;

    goto :goto_0
.end method

.method public static getInstance(Ljava/lang/reflect/Constructor;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;I)Lorg/simpleframework/xml/core/Parameter;
    .locals 1
    .param p0, "method"    # Ljava/lang/reflect/Constructor;
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .param p2, "format"    # Lorg/simpleframework/xml/stream/Format;
    .param p3, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 64
    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2, p3}, Lorg/simpleframework/xml/core/ParameterFactory;->getInstance(Ljava/lang/reflect/Constructor;Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;I)Lorg/simpleframework/xml/core/Parameter;

    move-result-object v0

    return-object v0
.end method
