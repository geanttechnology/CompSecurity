.class Lorg/simpleframework/xml/core/MethodContact;
.super Ljava/lang/Object;
.source "MethodContact.java"

# interfaces
.implements Lorg/simpleframework/xml/core/Contact;


# instance fields
.field private get:Lorg/simpleframework/xml/core/MethodPart;

.field private item:Ljava/lang/Class;

.field private items:[Ljava/lang/Class;

.field private label:Ljava/lang/annotation/Annotation;

.field private name:Ljava/lang/String;

.field private set:Lorg/simpleframework/xml/core/MethodPart;

.field private type:Ljava/lang/Class;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/MethodPart;)V
    .locals 1
    .param p1, "get"    # Lorg/simpleframework/xml/core/MethodPart;

    .prologue
    .line 80
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/MethodContact;-><init>(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodPart;)V

    .line 81
    return-void
.end method

.method public constructor <init>(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodPart;)V
    .locals 1
    .param p1, "get"    # Lorg/simpleframework/xml/core/MethodPart;
    .param p2, "set"    # Lorg/simpleframework/xml/core/MethodPart;

    .prologue
    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->label:Ljava/lang/annotation/Annotation;

    .line 94
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getDependents()[Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->items:[Ljava/lang/Class;

    .line 95
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getDependent()Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->item:Ljava/lang/Class;

    .line 96
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getType()Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->type:Ljava/lang/Class;

    .line 97
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->name:Ljava/lang/String;

    .line 98
    iput-object p2, p0, Lorg/simpleframework/xml/core/MethodContact;->set:Lorg/simpleframework/xml/core/MethodPart;

    .line 99
    iput-object p1, p0, Lorg/simpleframework/xml/core/MethodContact;->get:Lorg/simpleframework/xml/core/MethodPart;

    .line 100
    return-void
.end method


# virtual methods
.method public get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "source"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 223
    iget-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->get:Lorg/simpleframework/xml/core/MethodPart;

    invoke-interface {v0}, Lorg/simpleframework/xml/core/MethodPart;->getMethod()Ljava/lang/reflect/Method;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {v0, p1, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getAnnotation()Ljava/lang/annotation/Annotation;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->label:Ljava/lang/annotation/Annotation;

    return-object v0
.end method

.method public getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Ljava/lang/annotation/Annotation;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 135
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    iget-object v1, p0, Lorg/simpleframework/xml/core/MethodContact;->get:Lorg/simpleframework/xml/core/MethodPart;

    invoke-interface {v1, p1}, Lorg/simpleframework/xml/core/MethodPart;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    .line 137
    .local v0, "result":Ljava/lang/annotation/Annotation;, "TT;"
    iget-object v1, p0, Lorg/simpleframework/xml/core/MethodContact;->label:Ljava/lang/annotation/Annotation;

    invoke-interface {v1}, Ljava/lang/annotation/Annotation;->annotationType()Ljava/lang/Class;

    move-result-object v1

    if-ne p1, v1, :cond_1

    .line 138
    iget-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->label:Ljava/lang/annotation/Annotation;

    .line 143
    .end local v0    # "result":Ljava/lang/annotation/Annotation;, "TT;"
    :cond_0
    :goto_0
    return-object v0

    .line 140
    .restart local v0    # "result":Ljava/lang/annotation/Annotation;, "TT;"
    :cond_1
    if-nez v0, :cond_0

    iget-object v1, p0, Lorg/simpleframework/xml/core/MethodContact;->set:Lorg/simpleframework/xml/core/MethodPart;

    if-eqz v1, :cond_0

    .line 141
    iget-object v1, p0, Lorg/simpleframework/xml/core/MethodContact;->set:Lorg/simpleframework/xml/core/MethodPart;

    invoke-interface {v1, p1}, Lorg/simpleframework/xml/core/MethodPart;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    goto :goto_0
.end method

.method public getDependent()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->item:Ljava/lang/Class;

    return-object v0
.end method

.method public getDependents()[Ljava/lang/Class;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->items:[Ljava/lang/Class;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->type:Ljava/lang/Class;

    return-object v0
.end method

.method public isReadOnly()Z
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lorg/simpleframework/xml/core/MethodContact;->set:Lorg/simpleframework/xml/core/MethodPart;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public set(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 8
    .param p1, "source"    # Ljava/lang/Object;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 203
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodContact;->get:Lorg/simpleframework/xml/core/MethodPart;

    invoke-interface {v2}, Lorg/simpleframework/xml/core/MethodPart;->getMethod()Ljava/lang/reflect/Method;

    move-result-object v0

    .line 204
    .local v0, "method":Ljava/lang/reflect/Method;
    invoke-virtual {v0}, Ljava/lang/reflect/Method;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v1

    .line 206
    .local v1, "type":Ljava/lang/Class;
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodContact;->set:Lorg/simpleframework/xml/core/MethodPart;

    if-nez v2, :cond_0

    .line 207
    new-instance v2, Lorg/simpleframework/xml/core/MethodException;

    const-string v3, "Property \'%s\' is read only in %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lorg/simpleframework/xml/core/MethodContact;->name:Ljava/lang/String;

    aput-object v5, v4, v6

    aput-object v1, v4, v7

    invoke-direct {v2, v3, v4}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v2

    .line 209
    :cond_0
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodContact;->set:Lorg/simpleframework/xml/core/MethodPart;

    invoke-interface {v2}, Lorg/simpleframework/xml/core/MethodPart;->getMethod()Ljava/lang/reflect/Method;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/Object;

    aput-object p2, v3, v6

    invoke-virtual {v2, p1, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 210
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 235
    const-string v0, "method \'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lorg/simpleframework/xml/core/MethodContact;->name:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
