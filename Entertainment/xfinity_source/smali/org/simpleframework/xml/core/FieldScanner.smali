.class Lorg/simpleframework/xml/core/FieldScanner;
.super Lorg/simpleframework/xml/core/ContactList;
.source "FieldScanner.java"


# instance fields
.field private final access:Lorg/simpleframework/xml/DefaultType;

.field private final done:Lorg/simpleframework/xml/core/ContactMap;

.field private final factory:Lorg/simpleframework/xml/core/AnnotationFactory;

.field private final hierarchy:Lorg/simpleframework/xml/core/Hierarchy;


# direct methods
.method public constructor <init>(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 80
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/FieldScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;)V

    .line 81
    return-void
.end method

.method public constructor <init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "access"    # Lorg/simpleframework/xml/DefaultType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 92
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/FieldScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;Z)V

    .line 93
    return-void
.end method

.method public constructor <init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;Z)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "access"    # Lorg/simpleframework/xml/DefaultType;
    .param p3, "required"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 104
    invoke-direct {p0}, Lorg/simpleframework/xml/core/ContactList;-><init>()V

    .line 105
    new-instance v0, Lorg/simpleframework/xml/core/AnnotationFactory;

    invoke-direct {v0, p3}, Lorg/simpleframework/xml/core/AnnotationFactory;-><init>(Z)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/FieldScanner;->factory:Lorg/simpleframework/xml/core/AnnotationFactory;

    .line 106
    new-instance v0, Lorg/simpleframework/xml/core/Hierarchy;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/Hierarchy;-><init>(Ljava/lang/Class;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/FieldScanner;->hierarchy:Lorg/simpleframework/xml/core/Hierarchy;

    .line 107
    new-instance v0, Lorg/simpleframework/xml/core/ContactMap;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/ContactMap;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/FieldScanner;->done:Lorg/simpleframework/xml/core/ContactMap;

    .line 108
    iput-object p2, p0, Lorg/simpleframework/xml/core/FieldScanner;->access:Lorg/simpleframework/xml/DefaultType;

    .line 109
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/FieldScanner;->scan(Ljava/lang/Class;)V

    .line 110
    return-void
.end method

.method private build()V
    .locals 3

    .prologue
    .line 292
    iget-object v2, p0, Lorg/simpleframework/xml/core/FieldScanner;->done:Lorg/simpleframework/xml/core/ContactMap;

    invoke-virtual {v2}, Lorg/simpleframework/xml/core/ContactMap;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/core/Contact;

    .line 293
    .local v0, "contact":Lorg/simpleframework/xml/core/Contact;
    invoke-virtual {p0, v0}, Lorg/simpleframework/xml/core/FieldScanner;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 295
    .end local v0    # "contact":Lorg/simpleframework/xml/core/Contact;
    :cond_0
    return-void
.end method

.method private isStatic(Ljava/lang/reflect/Field;)Z
    .locals 2
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 307
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getModifiers()I

    move-result v0

    .line 309
    .local v0, "modifier":I
    invoke-static {v0}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 310
    const/4 v1, 0x1

    .line 312
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private process(Ljava/lang/reflect/Field;Ljava/lang/Class;[Ljava/lang/annotation/Annotation;)V
    .locals 2
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "type"    # Ljava/lang/Class;
    .param p3, "list"    # [Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 246
    iget-object v1, p0, Lorg/simpleframework/xml/core/FieldScanner;->factory:Lorg/simpleframework/xml/core/AnnotationFactory;

    invoke-virtual {v1, p2}, Lorg/simpleframework/xml/core/AnnotationFactory;->getInstance(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    .line 248
    .local v0, "label":Ljava/lang/annotation/Annotation;
    if-eqz v0, :cond_0

    .line 249
    invoke-direct {p0, p1, v0, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 251
    :cond_0
    return-void
.end method

.method private process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V
    .locals 2
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "label"    # Ljava/lang/annotation/Annotation;
    .param p3, "list"    # [Ljava/lang/annotation/Annotation;

    .prologue
    .line 264
    new-instance v0, Lorg/simpleframework/xml/core/FieldContact;

    invoke-direct {v0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldContact;-><init>(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 266
    .local v0, "contact":Lorg/simpleframework/xml/core/Contact;
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->isAccessible()Z

    move-result v1

    if-nez v1, :cond_0

    .line 267
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 269
    :cond_0
    iget-object v1, p0, Lorg/simpleframework/xml/core/FieldScanner;->done:Lorg/simpleframework/xml/core/ContactMap;

    invoke-virtual {v1, p1, v0}, Lorg/simpleframework/xml/core/ContactMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 270
    return-void
.end method

.method private remove(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "label"    # Ljava/lang/annotation/Annotation;

    .prologue
    .line 282
    iget-object v0, p0, Lorg/simpleframework/xml/core/FieldScanner;->done:Lorg/simpleframework/xml/core/ContactMap;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/ContactMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 283
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
    .line 123
    iget-object v2, p0, Lorg/simpleframework/xml/core/FieldScanner;->hierarchy:Lorg/simpleframework/xml/core/Hierarchy;

    invoke-virtual {v2}, Lorg/simpleframework/xml/core/Hierarchy;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Class;

    .line 124
    .local v1, "next":Ljava/lang/Class;
    iget-object v2, p0, Lorg/simpleframework/xml/core/FieldScanner;->access:Lorg/simpleframework/xml/DefaultType;

    invoke-direct {p0, v1, v2}, Lorg/simpleframework/xml/core/FieldScanner;->scan(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;)V

    goto :goto_0

    .line 126
    .end local v1    # "next":Ljava/lang/Class;
    :cond_0
    iget-object v2, p0, Lorg/simpleframework/xml/core/FieldScanner;->hierarchy:Lorg/simpleframework/xml/core/Hierarchy;

    invoke-virtual {v2}, Lorg/simpleframework/xml/core/Hierarchy;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Class;

    .line 127
    .restart local v1    # "next":Ljava/lang/Class;
    invoke-direct {p0, v1, p1}, Lorg/simpleframework/xml/core/FieldScanner;->scan(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_1

    .line 129
    .end local v1    # "next":Ljava/lang/Class;
    :cond_1
    invoke-direct {p0}, Lorg/simpleframework/xml/core/FieldScanner;->build()V

    .line 130
    return-void
.end method

.method private scan(Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 5
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "real"    # Ljava/lang/Class;

    .prologue
    .line 142
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v4

    .line 144
    .local v4, "list":[Ljava/lang/reflect/Field;
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/reflect/Field;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 145
    .local v1, "field":Ljava/lang/reflect/Field;
    invoke-direct {p0, v1}, Lorg/simpleframework/xml/core/FieldScanner;->scan(Ljava/lang/reflect/Field;)V

    .line 144
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 147
    .end local v1    # "field":Ljava/lang/reflect/Field;
    :cond_0
    return-void
.end method

.method private scan(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;)V
    .locals 8
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "access"    # Lorg/simpleframework/xml/DefaultType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 175
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    .line 177
    .local v2, "fields":[Ljava/lang/reflect/Field;
    sget-object v7, Lorg/simpleframework/xml/DefaultType;->FIELD:Lorg/simpleframework/xml/DefaultType;

    if-ne p2, v7, :cond_1

    .line 178
    move-object v0, v2

    .local v0, "arr$":[Ljava/lang/reflect/Field;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v1, v0, v3

    .line 179
    .local v1, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getDeclaredAnnotations()[Ljava/lang/annotation/Annotation;

    move-result-object v5

    .line 180
    .local v5, "list":[Ljava/lang/annotation/Annotation;
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v6

    .line 182
    .local v6, "real":Ljava/lang/Class;
    invoke-direct {p0, v1}, Lorg/simpleframework/xml/core/FieldScanner;->isStatic(Ljava/lang/reflect/Field;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 183
    invoke-direct {p0, v1, v6, v5}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/Class;[Ljava/lang/annotation/Annotation;)V

    .line 178
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 187
    .end local v0    # "arr$":[Ljava/lang/reflect/Field;
    .end local v1    # "field":Ljava/lang/reflect/Field;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    .end local v5    # "list":[Ljava/lang/annotation/Annotation;
    .end local v6    # "real":Ljava/lang/Class;
    :cond_1
    return-void
.end method

.method private scan(Ljava/lang/reflect/Field;)V
    .locals 5
    .param p1, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 158
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getDeclaredAnnotations()[Ljava/lang/annotation/Annotation;

    move-result-object v4

    .line 160
    .local v4, "list":[Ljava/lang/annotation/Annotation;
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/annotation/Annotation;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v2, v0, v1

    .line 161
    .local v2, "label":Ljava/lang/annotation/Annotation;
    invoke-direct {p0, p1, v2, v4}, Lorg/simpleframework/xml/core/FieldScanner;->scan(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 160
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 163
    .end local v2    # "label":Ljava/lang/annotation/Annotation;
    :cond_0
    return-void
.end method

.method private scan(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "label"    # Ljava/lang/annotation/Annotation;
    .param p3, "list"    # [Ljava/lang/annotation/Annotation;

    .prologue
    .line 200
    instance-of v0, p2, Lorg/simpleframework/xml/Attribute;

    if-eqz v0, :cond_0

    .line 201
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 203
    :cond_0
    instance-of v0, p2, Lorg/simpleframework/xml/ElementUnion;

    if-eqz v0, :cond_1

    .line 204
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 206
    :cond_1
    instance-of v0, p2, Lorg/simpleframework/xml/ElementListUnion;

    if-eqz v0, :cond_2

    .line 207
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 209
    :cond_2
    instance-of v0, p2, Lorg/simpleframework/xml/ElementMapUnion;

    if-eqz v0, :cond_3

    .line 210
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 212
    :cond_3
    instance-of v0, p2, Lorg/simpleframework/xml/ElementList;

    if-eqz v0, :cond_4

    .line 213
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 215
    :cond_4
    instance-of v0, p2, Lorg/simpleframework/xml/ElementArray;

    if-eqz v0, :cond_5

    .line 216
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 218
    :cond_5
    instance-of v0, p2, Lorg/simpleframework/xml/ElementMap;

    if-eqz v0, :cond_6

    .line 219
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 221
    :cond_6
    instance-of v0, p2, Lorg/simpleframework/xml/Element;

    if-eqz v0, :cond_7

    .line 222
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 224
    :cond_7
    instance-of v0, p2, Lorg/simpleframework/xml/Version;

    if-eqz v0, :cond_8

    .line 225
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 227
    :cond_8
    instance-of v0, p2, Lorg/simpleframework/xml/Text;

    if-eqz v0, :cond_9

    .line 228
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/FieldScanner;->process(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 230
    :cond_9
    instance-of v0, p2, Lorg/simpleframework/xml/Transient;

    if-eqz v0, :cond_a

    .line 231
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/FieldScanner;->remove(Ljava/lang/reflect/Field;Ljava/lang/annotation/Annotation;)V

    .line 233
    :cond_a
    return-void
.end method
