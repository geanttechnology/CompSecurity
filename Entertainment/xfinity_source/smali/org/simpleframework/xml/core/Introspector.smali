.class Lorg/simpleframework/xml/core/Introspector;
.super Ljava/lang/Object;
.source "Introspector.java"


# instance fields
.field private final contact:Lorg/simpleframework/xml/core/Contact;

.field private final format:Lorg/simpleframework/xml/stream/Format;

.field private final label:Lorg/simpleframework/xml/core/Label;

.field private final marker:Ljava/lang/annotation/Annotation;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/Contact;Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/stream/Format;)V
    .locals 1
    .param p1, "contact"    # Lorg/simpleframework/xml/core/Contact;
    .param p2, "label"    # Lorg/simpleframework/xml/core/Label;
    .param p3, "format"    # Lorg/simpleframework/xml/stream/Format;

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Contact;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/Introspector;->marker:Ljava/lang/annotation/Annotation;

    .line 71
    iput-object p1, p0, Lorg/simpleframework/xml/core/Introspector;->contact:Lorg/simpleframework/xml/core/Contact;

    .line 72
    iput-object p3, p0, Lorg/simpleframework/xml/core/Introspector;->format:Lorg/simpleframework/xml/stream/Format;

    .line 73
    iput-object p2, p0, Lorg/simpleframework/xml/core/Introspector;->label:Lorg/simpleframework/xml/core/Label;

    .line 74
    return-void
.end method

.method private getDefault()Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 222
    iget-object v1, p0, Lorg/simpleframework/xml/core/Introspector;->label:Lorg/simpleframework/xml/core/Label;

    invoke-interface {v1}, Lorg/simpleframework/xml/core/Label;->getOverride()Ljava/lang/String;

    move-result-object v0

    .line 224
    .local v0, "name":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lorg/simpleframework/xml/core/Introspector;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 227
    .end local v0    # "name":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "name":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lorg/simpleframework/xml/core/Introspector;->contact:Lorg/simpleframework/xml/core/Contact;

    invoke-interface {v1}, Lorg/simpleframework/xml/core/Contact;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getName(Ljava/lang/Class;)Ljava/lang/String;
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 136
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/Introspector;->getRoot(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    .line 138
    .local v0, "name":Ljava/lang/String;
    if-eqz v0, :cond_0

    move-object v1, v0

    .line 143
    :goto_0
    return-object v1

    .line 141
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    .line 143
    invoke-static {v0}, Lorg/simpleframework/xml/core/Reflector;->getName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private getRoot(Ljava/lang/Class;)Ljava/lang/String;
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;

    .prologue
    .line 157
    move-object v1, p1

    .line 159
    .local v1, "real":Ljava/lang/Class;
    :goto_0
    if-eqz p1, :cond_1

    .line 160
    invoke-direct {p0, v1, p1}, Lorg/simpleframework/xml/core/Introspector;->getRoot(Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    .line 162
    .local v0, "name":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 167
    .end local v0    # "name":Ljava/lang/String;
    :goto_1
    return-object v0

    .line 165
    .restart local v0    # "name":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object p1

    .line 166
    goto :goto_0

    .line 167
    .end local v0    # "name":Ljava/lang/String;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private getRoot(Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 182
    .local p1, "real":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    .line 183
    .local v0, "name":Ljava/lang/String;
    const-class v3, Lorg/simpleframework/xml/Root;

    invoke-virtual {p2, v3}, Ljava/lang/Class;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/Root;

    .line 185
    .local v1, "root":Lorg/simpleframework/xml/Root;
    if-eqz v1, :cond_1

    .line 186
    invoke-interface {v1}, Lorg/simpleframework/xml/Root;->name()Ljava/lang/String;

    move-result-object v2

    .line 188
    .local v2, "text":Ljava/lang/String;
    invoke-virtual {p0, v2}, Lorg/simpleframework/xml/core/Introspector;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 193
    .end local v2    # "text":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 191
    .restart local v2    # "text":Ljava/lang/String;
    :cond_0
    invoke-static {v0}, Lorg/simpleframework/xml/core/Reflector;->getName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 193
    .end local v2    # "text":Ljava/lang/String;
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getContact()Lorg/simpleframework/xml/core/Contact;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lorg/simpleframework/xml/core/Introspector;->contact:Lorg/simpleframework/xml/core/Contact;

    return-object v0
.end method

.method public getDependent()Lorg/simpleframework/xml/strategy/Type;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lorg/simpleframework/xml/core/Introspector;->label:Lorg/simpleframework/xml/core/Label;

    invoke-interface {v0}, Lorg/simpleframework/xml/core/Label;->getDependent()Lorg/simpleframework/xml/strategy/Type;

    move-result-object v0

    return-object v0
.end method

.method public getEntry()Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 108
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/Introspector;->getDependent()Lorg/simpleframework/xml/strategy/Type;

    move-result-object v0

    .line 109
    .local v0, "depend":Lorg/simpleframework/xml/strategy/Type;
    invoke-interface {v0}, Lorg/simpleframework/xml/strategy/Type;->getType()Ljava/lang/Class;

    move-result-object v2

    .line 111
    .local v2, "type":Ljava/lang/Class;
    invoke-virtual {v2}, Ljava/lang/Class;->isArray()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 112
    invoke-virtual {v2}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v2

    .line 114
    :cond_0
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/Introspector;->getName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    .line 116
    .local v1, "name":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 117
    const/4 v3, 0x0

    .line 119
    :goto_0
    return-object v3

    :cond_1
    invoke-virtual {v1}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public getExpression()Lorg/simpleframework/xml/core/Expression;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 239
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/Introspector;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 241
    .local v0, "path":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 242
    new-instance v1, Lorg/simpleframework/xml/core/PathParser;

    iget-object v2, p0, Lorg/simpleframework/xml/core/Introspector;->contact:Lorg/simpleframework/xml/core/Contact;

    iget-object v3, p0, Lorg/simpleframework/xml/core/Introspector;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-direct {v1, v0, v2, v3}, Lorg/simpleframework/xml/core/PathParser;-><init>(Ljava/lang/String;Lorg/simpleframework/xml/strategy/Type;Lorg/simpleframework/xml/stream/Format;)V

    .line 244
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Lorg/simpleframework/xml/core/EmptyExpression;

    iget-object v2, p0, Lorg/simpleframework/xml/core/Introspector;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-direct {v1, v2}, Lorg/simpleframework/xml/core/EmptyExpression;-><init>(Lorg/simpleframework/xml/stream/Format;)V

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 205
    iget-object v1, p0, Lorg/simpleframework/xml/core/Introspector;->label:Lorg/simpleframework/xml/core/Label;

    invoke-interface {v1}, Lorg/simpleframework/xml/core/Label;->getEntry()Ljava/lang/String;

    move-result-object v0

    .line 207
    .local v0, "entry":Ljava/lang/String;
    iget-object v1, p0, Lorg/simpleframework/xml/core/Introspector;->label:Lorg/simpleframework/xml/core/Label;

    invoke-interface {v1}, Lorg/simpleframework/xml/core/Label;->isInline()Z

    move-result v1

    if-nez v1, :cond_0

    .line 208
    invoke-direct {p0}, Lorg/simpleframework/xml/core/Introspector;->getDefault()Ljava/lang/String;

    move-result-object v0

    .line 210
    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getPath()Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 256
    iget-object v1, p0, Lorg/simpleframework/xml/core/Introspector;->contact:Lorg/simpleframework/xml/core/Contact;

    const-class v2, Lorg/simpleframework/xml/Path;

    invoke-interface {v1, v2}, Lorg/simpleframework/xml/core/Contact;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/Path;

    .line 258
    .local v0, "path":Lorg/simpleframework/xml/Path;
    if-nez v0, :cond_0

    .line 259
    const/4 v1, 0x0

    .line 261
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {v0}, Lorg/simpleframework/xml/Path;->value()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public isEmpty(Ljava/lang/String;)Z
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    .line 275
    if-eqz p1, :cond_0

    .line 276
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 278
    :cond_0
    :goto_0
    return v0

    .line 276
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 291
    const-string v0, "%s on %s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lorg/simpleframework/xml/core/Introspector;->marker:Ljava/lang/annotation/Annotation;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Lorg/simpleframework/xml/core/Introspector;->contact:Lorg/simpleframework/xml/core/Contact;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
