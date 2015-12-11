.class Lorg/simpleframework/xml/core/AnnotationHandler;
.super Ljava/lang/Object;
.source "AnnotationHandler.java"

# interfaces
.implements Ljava/lang/reflect/InvocationHandler;


# static fields
.field private static final CLASS:Ljava/lang/String; = "annotationType"

.field private static final EQUAL:Ljava/lang/String; = "equals"

.field private static final REQUIRED:Ljava/lang/String; = "required"

.field private static final STRING:Ljava/lang/String; = "toString"


# instance fields
.field private final comparer:Lorg/simpleframework/xml/core/Comparer;

.field private final required:Z

.field private final type:Ljava/lang/Class;


# direct methods
.method public constructor <init>(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;

    .prologue
    .line 80
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/AnnotationHandler;-><init>(Ljava/lang/Class;Z)V

    .line 81
    return-void
.end method

.method public constructor <init>(Ljava/lang/Class;Z)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "required"    # Z

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    new-instance v0, Lorg/simpleframework/xml/core/Comparer;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/Comparer;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->comparer:Lorg/simpleframework/xml/core/Comparer;

    .line 93
    iput-boolean p2, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->required:Z

    .line 94
    iput-object p1, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->type:Ljava/lang/Class;

    .line 95
    return-void
.end method

.method private attributes(Ljava/lang/StringBuilder;)V
    .locals 5
    .param p1, "builder"    # Ljava/lang/StringBuilder;

    .prologue
    .line 196
    iget-object v4, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->type:Ljava/lang/Class;

    invoke-virtual {v4}, Ljava/lang/Class;->getDeclaredMethods()[Ljava/lang/reflect/Method;

    move-result-object v2

    .line 198
    .local v2, "list":[Ljava/lang/reflect/Method;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v4, v2

    if-ge v1, v4, :cond_1

    .line 199
    aget-object v4, v2, v1

    invoke-virtual {v4}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v0

    .line 200
    .local v0, "attribute":Ljava/lang/String;
    aget-object v4, v2, v1

    invoke-direct {p0, v4}, Lorg/simpleframework/xml/core/AnnotationHandler;->value(Ljava/lang/reflect/Method;)Ljava/lang/Object;

    move-result-object v3

    .line 202
    .local v3, "value":Ljava/lang/Object;
    if-lez v1, :cond_0

    .line 203
    const/16 v4, 0x2c

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 204
    const/16 v4, 0x20

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 206
    :cond_0
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 207
    const/16 v4, 0x3d

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 208
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 198
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 210
    .end local v0    # "attribute":Ljava/lang/String;
    .end local v3    # "value":Ljava/lang/Object;
    :cond_1
    const/16 v4, 0x29

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 211
    return-void
.end method

.method private equals(Ljava/lang/Object;[Ljava/lang/Object;)Z
    .locals 6
    .param p1, "proxy"    # Ljava/lang/Object;
    .param p2, "list"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 139
    move-object v0, p1

    check-cast v0, Ljava/lang/annotation/Annotation;

    .line 140
    .local v0, "left":Ljava/lang/annotation/Annotation;
    aget-object v1, p2, v5

    check-cast v1, Ljava/lang/annotation/Annotation;

    .line 142
    .local v1, "right":Ljava/lang/annotation/Annotation;
    invoke-interface {v0}, Ljava/lang/annotation/Annotation;->annotationType()Ljava/lang/Class;

    move-result-object v2

    invoke-interface {v1}, Ljava/lang/annotation/Annotation;->annotationType()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_0

    .line 143
    new-instance v2, Lorg/simpleframework/xml/core/PersistenceException;

    const-string v3, "Annotation %s is not the same as %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v0, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    invoke-direct {v2, v3, v4}, Lorg/simpleframework/xml/core/PersistenceException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v2

    .line 145
    :cond_0
    iget-object v2, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->comparer:Lorg/simpleframework/xml/core/Comparer;

    invoke-virtual {v2, v0, v1}, Lorg/simpleframework/xml/core/Comparer;->equals(Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;)Z

    move-result v2

    return v2
.end method

.method private name(Ljava/lang/StringBuilder;)V
    .locals 2
    .param p1, "builder"    # Ljava/lang/StringBuilder;

    .prologue
    .line 177
    iget-object v1, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->type:Ljava/lang/Class;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 179
    .local v0, "name":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 180
    const/16 v1, 0x40

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 181
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 182
    const/16 v1, 0x28

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 184
    :cond_0
    return-void
.end method

.method private value(Ljava/lang/reflect/Method;)Ljava/lang/Object;
    .locals 2
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 224
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v0

    .line 226
    .local v0, "name":Ljava/lang/String;
    const-string v1, "required"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 227
    iget-boolean v1, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->required:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 229
    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getDefaultValue()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "proxy"    # Ljava/lang/Object;
    .param p2, "method"    # Ljava/lang/reflect/Method;
    .param p3, "list"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 111
    invoke-virtual {p2}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v0

    .line 113
    .local v0, "name":Ljava/lang/String;
    const-string v1, "toString"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 114
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/AnnotationHandler;->toString()Ljava/lang/String;

    move-result-object v1

    .line 125
    :goto_0
    return-object v1

    .line 116
    :cond_0
    const-string v1, "equals"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 117
    invoke-direct {p0, p1, p3}, Lorg/simpleframework/xml/core/AnnotationHandler;->equals(Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_0

    .line 119
    :cond_1
    const-string v1, "annotationType"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 120
    iget-object v1, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->type:Ljava/lang/Class;

    goto :goto_0

    .line 122
    :cond_2
    const-string v1, "required"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 123
    iget-boolean v1, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->required:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_0

    .line 125
    :cond_3
    invoke-virtual {p2}, Ljava/lang/reflect/Method;->getDefaultValue()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 158
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 160
    .local v0, "builder":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lorg/simpleframework/xml/core/AnnotationHandler;->type:Ljava/lang/Class;

    if-eqz v1, :cond_0

    .line 161
    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/AnnotationHandler;->name(Ljava/lang/StringBuilder;)V

    .line 162
    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/AnnotationHandler;->attributes(Ljava/lang/StringBuilder;)V

    .line 164
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
