.class Lorg/simpleframework/xml/core/MethodPartFactory;
.super Ljava/lang/Object;
.source "MethodPartFactory.java"


# instance fields
.field private final factory:Lorg/simpleframework/xml/core/AnnotationFactory;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/MethodPartFactory;-><init>(Z)V

    .line 57
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 1
    .param p1, "required"    # Z

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    new-instance v0, Lorg/simpleframework/xml/core/AnnotationFactory;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/AnnotationFactory;-><init>(Z)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodPartFactory;->factory:Lorg/simpleframework/xml/core/AnnotationFactory;

    .line 69
    return-void
.end method

.method private getAnnotation(Ljava/lang/reflect/Method;)Ljava/lang/annotation/Annotation;
    .locals 2
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 193
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/core/MethodPartFactory;->getType(Ljava/lang/reflect/Method;)Ljava/lang/Class;

    move-result-object v0

    .line 195
    .local v0, "type":Ljava/lang/Class;
    if-eqz v0, :cond_0

    .line 196
    iget-object v1, p0, Lorg/simpleframework/xml/core/MethodPartFactory;->factory:Lorg/simpleframework/xml/core/AnnotationFactory;

    invoke-virtual {v1, v0}, Lorg/simpleframework/xml/core/AnnotationFactory;->getInstance(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v1

    .line 198
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getMethodType(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/MethodType;
    .locals 2
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 163
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v0

    .line 165
    .local v0, "name":Ljava/lang/String;
    const-string v1, "get"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 166
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->GET:Lorg/simpleframework/xml/core/MethodType;

    .line 174
    :goto_0
    return-object v1

    .line 168
    :cond_0
    const-string v1, "is"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 169
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->IS:Lorg/simpleframework/xml/core/MethodType;

    goto :goto_0

    .line 171
    :cond_1
    const-string v1, "set"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 172
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->SET:Lorg/simpleframework/xml/core/MethodType;

    goto :goto_0

    .line 174
    :cond_2
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->NONE:Lorg/simpleframework/xml/core/MethodType;

    goto :goto_0
.end method

.method private getName(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/MethodName;
    .locals 5
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .param p2, "label"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 137
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/MethodPartFactory;->getMethodType(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/MethodType;

    move-result-object v0

    .line 139
    .local v0, "type":Lorg/simpleframework/xml/core/MethodType;
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->GET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v0, v1, :cond_0

    .line 140
    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/MethodPartFactory;->getRead(Ljava/lang/reflect/Method;Lorg/simpleframework/xml/core/MethodType;)Lorg/simpleframework/xml/core/MethodName;

    move-result-object v1

    .line 146
    :goto_0
    return-object v1

    .line 142
    :cond_0
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->IS:Lorg/simpleframework/xml/core/MethodType;

    if-ne v0, v1, :cond_1

    .line 143
    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/MethodPartFactory;->getRead(Ljava/lang/reflect/Method;Lorg/simpleframework/xml/core/MethodType;)Lorg/simpleframework/xml/core/MethodName;

    move-result-object v1

    goto :goto_0

    .line 145
    :cond_1
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->SET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v0, v1, :cond_2

    .line 146
    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/MethodPartFactory;->getWrite(Ljava/lang/reflect/Method;Lorg/simpleframework/xml/core/MethodType;)Lorg/simpleframework/xml/core/MethodName;

    move-result-object v1

    goto :goto_0

    .line 148
    :cond_2
    new-instance v1, Lorg/simpleframework/xml/core/MethodException;

    const-string v2, "Annotation %s must mark a set or get method"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    invoke-direct {v1, v2, v3}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v1
.end method

.method private getParameterType(Ljava/lang/reflect/Method;)Ljava/lang/Class;
    .locals 3
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 241
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v0

    .line 243
    .local v0, "list":[Ljava/lang/Class;
    array-length v1, v0

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 244
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v1

    const/4 v2, 0x0

    aget-object v1, v1, v2

    .line 246
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getRead(Ljava/lang/reflect/Method;Lorg/simpleframework/xml/core/MethodType;)Lorg/simpleframework/xml/core/MethodName;
    .locals 7
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .param p2, "type"    # Lorg/simpleframework/xml/core/MethodType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 285
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v0

    .line 286
    .local v0, "list":[Ljava/lang/Class;
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v2

    .line 288
    .local v2, "real":Ljava/lang/String;
    array-length v3, v0

    if-eqz v3, :cond_0

    .line 289
    new-instance v3, Lorg/simpleframework/xml/core/MethodException;

    const-string v4, "Get method %s is not a valid property"

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 291
    :cond_0
    invoke-direct {p0, v2, p2}, Lorg/simpleframework/xml/core/MethodPartFactory;->getTypeName(Ljava/lang/String;Lorg/simpleframework/xml/core/MethodType;)Ljava/lang/String;

    move-result-object v1

    .line 293
    .local v1, "name":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 294
    new-instance v3, Lorg/simpleframework/xml/core/MethodException;

    const-string v4, "Could not get name for %s"

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 296
    :cond_1
    new-instance v3, Lorg/simpleframework/xml/core/MethodName;

    invoke-direct {v3, p1, p2, v1}, Lorg/simpleframework/xml/core/MethodName;-><init>(Ljava/lang/reflect/Method;Lorg/simpleframework/xml/core/MethodType;Ljava/lang/String;)V

    return-object v3
.end method

.method private getReturnType(Ljava/lang/reflect/Method;)Ljava/lang/Class;
    .locals 2
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 262
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v0

    .line 264
    .local v0, "list":[Ljava/lang/Class;
    array-length v1, v0

    if-nez v1, :cond_0

    .line 265
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    move-result-object v1

    .line 267
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getTypeName(Ljava/lang/String;Lorg/simpleframework/xml/core/MethodType;)Ljava/lang/String;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Lorg/simpleframework/xml/core/MethodType;

    .prologue
    .line 340
    invoke-virtual {p2}, Lorg/simpleframework/xml/core/MethodType;->getPrefix()I

    move-result v0

    .line 341
    .local v0, "prefix":I
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    .line 343
    .local v1, "size":I
    if-le v1, v0, :cond_0

    .line 344
    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 346
    :cond_0
    invoke-static {p1}, Lorg/simpleframework/xml/core/Reflector;->getName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private getWrite(Ljava/lang/reflect/Method;Lorg/simpleframework/xml/core/MethodType;)Lorg/simpleframework/xml/core/MethodName;
    .locals 7
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .param p2, "type"    # Lorg/simpleframework/xml/core/MethodType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 314
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v0

    .line 315
    .local v0, "list":[Ljava/lang/Class;
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v2

    .line 317
    .local v2, "real":Ljava/lang/String;
    array-length v3, v0

    if-eq v3, v5, :cond_0

    .line 318
    new-instance v3, Lorg/simpleframework/xml/core/MethodException;

    const-string v4, "Set method %s is not a valid property"

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 320
    :cond_0
    invoke-direct {p0, v2, p2}, Lorg/simpleframework/xml/core/MethodPartFactory;->getTypeName(Ljava/lang/String;Lorg/simpleframework/xml/core/MethodType;)Ljava/lang/String;

    move-result-object v1

    .line 322
    .local v1, "name":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 323
    new-instance v3, Lorg/simpleframework/xml/core/MethodException;

    const-string v4, "Could not get name for %s"

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 325
    :cond_1
    new-instance v3, Lorg/simpleframework/xml/core/MethodName;

    invoke-direct {v3, p1, p2, v1}, Lorg/simpleframework/xml/core/MethodName;-><init>(Ljava/lang/reflect/Method;Lorg/simpleframework/xml/core/MethodType;Ljava/lang/String;)V

    return-object v3
.end method


# virtual methods
.method public getInstance(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/MethodPart;
    .locals 3
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .param p2, "label"    # Ljava/lang/annotation/Annotation;
    .param p3, "list"    # [Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 112
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/MethodPartFactory;->getName(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/MethodName;

    move-result-object v0

    .line 113
    .local v0, "name":Lorg/simpleframework/xml/core/MethodName;
    invoke-virtual {v0}, Lorg/simpleframework/xml/core/MethodName;->getType()Lorg/simpleframework/xml/core/MethodType;

    move-result-object v1

    .line 115
    .local v1, "type":Lorg/simpleframework/xml/core/MethodType;
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->SET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_0

    .line 116
    new-instance v2, Lorg/simpleframework/xml/core/SetPart;

    invoke-direct {v2, v0, p2, p3}, Lorg/simpleframework/xml/core/SetPart;-><init>(Lorg/simpleframework/xml/core/MethodName;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 118
    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lorg/simpleframework/xml/core/GetPart;

    invoke-direct {v2, v0, p2, p3}, Lorg/simpleframework/xml/core/GetPart;-><init>(Lorg/simpleframework/xml/core/MethodName;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    goto :goto_0
.end method

.method public getInstance(Ljava/lang/reflect/Method;[Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/MethodPart;
    .locals 2
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .param p2, "list"    # [Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 87
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/MethodPartFactory;->getAnnotation(Ljava/lang/reflect/Method;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    .line 89
    .local v0, "label":Ljava/lang/annotation/Annotation;
    if-eqz v0, :cond_0

    .line 90
    invoke-virtual {p0, p1, v0, p2}, Lorg/simpleframework/xml/core/MethodPartFactory;->getInstance(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/MethodPart;

    move-result-object v1

    .line 92
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getType(Ljava/lang/reflect/Method;)Ljava/lang/Class;
    .locals 2
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 214
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/MethodPartFactory;->getMethodType(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/MethodType;

    move-result-object v0

    .line 216
    .local v0, "type":Lorg/simpleframework/xml/core/MethodType;
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->SET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v0, v1, :cond_0

    .line 217
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/MethodPartFactory;->getParameterType(Ljava/lang/reflect/Method;)Ljava/lang/Class;

    move-result-object v1

    .line 225
    :goto_0
    return-object v1

    .line 219
    :cond_0
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->GET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v0, v1, :cond_1

    .line 220
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/MethodPartFactory;->getReturnType(Ljava/lang/reflect/Method;)Ljava/lang/Class;

    move-result-object v1

    goto :goto_0

    .line 222
    :cond_1
    sget-object v1, Lorg/simpleframework/xml/core/MethodType;->IS:Lorg/simpleframework/xml/core/MethodType;

    if-ne v0, v1, :cond_2

    .line 223
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/MethodPartFactory;->getReturnType(Ljava/lang/reflect/Method;)Ljava/lang/Class;

    move-result-object v1

    goto :goto_0

    .line 225
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method
