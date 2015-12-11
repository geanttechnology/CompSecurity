.class Lorg/simpleframework/xml/core/MethodScanner;
.super Lorg/simpleframework/xml/core/ContactList;
.source "MethodScanner.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/simpleframework/xml/core/MethodScanner$1;,
        Lorg/simpleframework/xml/core/MethodScanner$PartMap;
    }
.end annotation


# instance fields
.field private final access:Lorg/simpleframework/xml/DefaultType;

.field private final factory:Lorg/simpleframework/xml/core/MethodPartFactory;

.field private final hierarchy:Lorg/simpleframework/xml/core/Hierarchy;

.field private final read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

.field private final type:Ljava/lang/Class;

.field private final write:Lorg/simpleframework/xml/core/MethodScanner$PartMap;


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
    .line 106
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/MethodScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;)V

    .line 107
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
    .line 121
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/MethodScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;Z)V

    .line 122
    return-void
.end method

.method public constructor <init>(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;Z)V
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "access"    # Lorg/simpleframework/xml/DefaultType;
    .param p3, "required"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 136
    invoke-direct {p0}, Lorg/simpleframework/xml/core/ContactList;-><init>()V

    .line 137
    new-instance v0, Lorg/simpleframework/xml/core/MethodPartFactory;

    invoke-direct {v0, p3}, Lorg/simpleframework/xml/core/MethodPartFactory;-><init>(Z)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodScanner;->factory:Lorg/simpleframework/xml/core/MethodPartFactory;

    .line 138
    new-instance v0, Lorg/simpleframework/xml/core/Hierarchy;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/Hierarchy;-><init>(Ljava/lang/Class;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodScanner;->hierarchy:Lorg/simpleframework/xml/core/Hierarchy;

    .line 139
    new-instance v0, Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {v0, v1}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;-><init>(Lorg/simpleframework/xml/core/MethodScanner$1;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodScanner;->write:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    .line 140
    new-instance v0, Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {v0, v1}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;-><init>(Lorg/simpleframework/xml/core/MethodScanner$1;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    .line 141
    iput-object p2, p0, Lorg/simpleframework/xml/core/MethodScanner;->access:Lorg/simpleframework/xml/DefaultType;

    .line 142
    iput-object p1, p0, Lorg/simpleframework/xml/core/MethodScanner;->type:Ljava/lang/Class;

    .line 143
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/MethodScanner;->scan(Ljava/lang/Class;)V

    .line 144
    return-void
.end method

.method private build()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 400
    iget-object v3, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-virtual {v3}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 401
    .local v1, "name":Ljava/lang/String;
    iget-object v3, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-virtual {v3, v1}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/simpleframework/xml/core/MethodPart;

    .line 403
    .local v2, "part":Lorg/simpleframework/xml/core/MethodPart;
    if-eqz v2, :cond_0

    .line 404
    invoke-direct {p0, v2, v1}, Lorg/simpleframework/xml/core/MethodScanner;->build(Lorg/simpleframework/xml/core/MethodPart;Ljava/lang/String;)V

    goto :goto_0

    .line 407
    .end local v1    # "name":Ljava/lang/String;
    .end local v2    # "part":Lorg/simpleframework/xml/core/MethodPart;
    :cond_1
    return-void
.end method

.method private build(Lorg/simpleframework/xml/core/MethodPart;)V
    .locals 1
    .param p1, "read"    # Lorg/simpleframework/xml/core/MethodPart;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 442
    new-instance v0, Lorg/simpleframework/xml/core/MethodContact;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/MethodContact;-><init>(Lorg/simpleframework/xml/core/MethodPart;)V

    invoke-virtual {p0, v0}, Lorg/simpleframework/xml/core/MethodScanner;->add(Ljava/lang/Object;)Z

    .line 443
    return-void
.end method

.method private build(Lorg/simpleframework/xml/core/MethodPart;Ljava/lang/String;)V
    .locals 2
    .param p1, "read"    # Lorg/simpleframework/xml/core/MethodPart;
    .param p2, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 422
    iget-object v1, p0, Lorg/simpleframework/xml/core/MethodScanner;->write:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-virtual {v1, p2}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;->take(Ljava/lang/String;)Lorg/simpleframework/xml/core/MethodPart;

    move-result-object v0

    .line 424
    .local v0, "match":Lorg/simpleframework/xml/core/MethodPart;
    if-eqz v0, :cond_0

    .line 425
    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/MethodScanner;->build(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodPart;)V

    .line 429
    :goto_0
    return-void

    .line 427
    :cond_0
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/MethodScanner;->build(Lorg/simpleframework/xml/core/MethodPart;)V

    goto :goto_0
.end method

.method private build(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodPart;)V
    .locals 8
    .param p1, "read"    # Lorg/simpleframework/xml/core/MethodPart;
    .param p2, "write"    # Lorg/simpleframework/xml/core/MethodPart;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 458
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v0

    .line 459
    .local v0, "label":Ljava/lang/annotation/Annotation;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getName()Ljava/lang/String;

    move-result-object v1

    .line 461
    .local v1, "name":Ljava/lang/String;
    invoke-interface {p2}, Lorg/simpleframework/xml/core/MethodPart;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 462
    new-instance v3, Lorg/simpleframework/xml/core/MethodException;

    const-string v4, "Annotations do not match for \'%s\' in %s"

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v1, v5, v6

    iget-object v6, p0, Lorg/simpleframework/xml/core/MethodScanner;->type:Ljava/lang/Class;

    aput-object v6, v5, v7

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 464
    :cond_0
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getType()Ljava/lang/Class;

    move-result-object v2

    .line 466
    .local v2, "type":Ljava/lang/Class;
    invoke-interface {p2}, Lorg/simpleframework/xml/core/MethodPart;->getType()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_1

    .line 467
    new-instance v3, Lorg/simpleframework/xml/core/MethodException;

    const-string v4, "Method types do not match for %s in %s"

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v2, v5, v7

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 469
    :cond_1
    new-instance v3, Lorg/simpleframework/xml/core/MethodContact;

    invoke-direct {v3, p1, p2}, Lorg/simpleframework/xml/core/MethodContact;-><init>(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodPart;)V

    invoke-virtual {p0, v3}, Lorg/simpleframework/xml/core/MethodScanner;->add(Ljava/lang/Object;)Z

    .line 470
    return-void
.end method

.method private process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V
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
    .line 290
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->factory:Lorg/simpleframework/xml/core/MethodPartFactory;

    invoke-virtual {v2, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodPartFactory;->getInstance(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/MethodPart;

    move-result-object v0

    .line 291
    .local v0, "part":Lorg/simpleframework/xml/core/MethodPart;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/MethodPart;->getMethodType()Lorg/simpleframework/xml/core/MethodType;

    move-result-object v1

    .line 293
    .local v1, "type":Lorg/simpleframework/xml/core/MethodType;
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->GET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_0

    .line 294
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->process(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 296
    :cond_0
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->IS:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_1

    .line 297
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->process(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 299
    :cond_1
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->SET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_2

    .line 300
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->write:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->process(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 302
    :cond_2
    return-void
.end method

.method private process(Ljava/lang/reflect/Method;[Ljava/lang/annotation/Annotation;)V
    .locals 3
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .param p2, "list"    # [Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 316
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->factory:Lorg/simpleframework/xml/core/MethodPartFactory;

    invoke-virtual {v2, p1, p2}, Lorg/simpleframework/xml/core/MethodPartFactory;->getInstance(Ljava/lang/reflect/Method;[Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/MethodPart;

    move-result-object v0

    .line 317
    .local v0, "part":Lorg/simpleframework/xml/core/MethodPart;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/MethodPart;->getMethodType()Lorg/simpleframework/xml/core/MethodType;

    move-result-object v1

    .line 319
    .local v1, "type":Lorg/simpleframework/xml/core/MethodType;
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->GET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_0

    .line 320
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->process(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 322
    :cond_0
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->IS:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_1

    .line 323
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->process(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 325
    :cond_1
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->SET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_2

    .line 326
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->write:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->process(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 328
    :cond_2
    return-void
.end method

.method private process(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V
    .locals 1
    .param p1, "method"    # Lorg/simpleframework/xml/core/MethodPart;
    .param p2, "map"    # Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    .prologue
    .line 340
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getName()Ljava/lang/String;

    move-result-object v0

    .line 342
    .local v0, "name":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 343
    invoke-virtual {p2, v0, p1}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 345
    :cond_0
    return-void
.end method

.method private remove(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V
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
    .line 359
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->factory:Lorg/simpleframework/xml/core/MethodPartFactory;

    invoke-virtual {v2, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodPartFactory;->getInstance(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/MethodPart;

    move-result-object v0

    .line 360
    .local v0, "part":Lorg/simpleframework/xml/core/MethodPart;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/MethodPart;->getMethodType()Lorg/simpleframework/xml/core/MethodType;

    move-result-object v1

    .line 362
    .local v1, "type":Lorg/simpleframework/xml/core/MethodType;
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->GET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_0

    .line 363
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->remove(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 365
    :cond_0
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->IS:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_1

    .line 366
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->remove(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 368
    :cond_1
    sget-object v2, Lorg/simpleframework/xml/core/MethodType;->SET:Lorg/simpleframework/xml/core/MethodType;

    if-ne v1, v2, :cond_2

    .line 369
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->write:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-direct {p0, v0, v2}, Lorg/simpleframework/xml/core/MethodScanner;->remove(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V

    .line 371
    :cond_2
    return-void
.end method

.method private remove(Lorg/simpleframework/xml/core/MethodPart;Lorg/simpleframework/xml/core/MethodScanner$PartMap;)V
    .locals 1
    .param p1, "part"    # Lorg/simpleframework/xml/core/MethodPart;
    .param p2, "map"    # Lorg/simpleframework/xml/core/MethodScanner$PartMap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 383
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getName()Ljava/lang/String;

    move-result-object v0

    .line 385
    .local v0, "name":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 386
    invoke-virtual {p2, v0}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 388
    :cond_0
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
    .line 157
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->hierarchy:Lorg/simpleframework/xml/core/Hierarchy;

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

    .line 158
    .local v1, "next":Ljava/lang/Class;
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->access:Lorg/simpleframework/xml/DefaultType;

    invoke-direct {p0, v1, v2}, Lorg/simpleframework/xml/core/MethodScanner;->scan(Ljava/lang/Class;Lorg/simpleframework/xml/DefaultType;)V

    goto :goto_0

    .line 160
    .end local v1    # "next":Ljava/lang/Class;
    :cond_0
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->hierarchy:Lorg/simpleframework/xml/core/Hierarchy;

    invoke-virtual {v2}, Lorg/simpleframework/xml/core/Hierarchy;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Class;

    .line 161
    .restart local v1    # "next":Ljava/lang/Class;
    invoke-direct {p0, v1, p1}, Lorg/simpleframework/xml/core/MethodScanner;->scan(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_1

    .line 163
    .end local v1    # "next":Ljava/lang/Class;
    :cond_1
    invoke-direct {p0}, Lorg/simpleframework/xml/core/MethodScanner;->build()V

    .line 164
    invoke-direct {p0}, Lorg/simpleframework/xml/core/MethodScanner;->validate()V

    .line 165
    return-void
.end method

.method private scan(Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 5
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "real"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 179
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredMethods()[Ljava/lang/reflect/Method;

    move-result-object v3

    .line 181
    .local v3, "list":[Ljava/lang/reflect/Method;
    move-object v0, v3

    .local v0, "arr$":[Ljava/lang/reflect/Method;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v4, v0, v1

    .line 182
    .local v4, "method":Ljava/lang/reflect/Method;
    invoke-direct {p0, v4}, Lorg/simpleframework/xml/core/MethodScanner;->scan(Ljava/lang/reflect/Method;)V

    .line 181
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 184
    .end local v4    # "method":Ljava/lang/reflect/Method;
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
    .line 215
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredMethods()[Ljava/lang/reflect/Method;

    move-result-object v5

    .line 217
    .local v5, "methods":[Ljava/lang/reflect/Method;
    sget-object v7, Lorg/simpleframework/xml/DefaultType;->PROPERTY:Lorg/simpleframework/xml/DefaultType;

    if-ne p2, v7, :cond_1

    .line 218
    move-object v0, v5

    .local v0, "arr$":[Ljava/lang/reflect/Method;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v4, v0, v1

    .line 219
    .local v4, "method":Ljava/lang/reflect/Method;
    invoke-virtual {v4}, Ljava/lang/reflect/Method;->getDeclaredAnnotations()[Ljava/lang/annotation/Annotation;

    move-result-object v3

    .line 220
    .local v3, "list":[Ljava/lang/annotation/Annotation;
    iget-object v7, p0, Lorg/simpleframework/xml/core/MethodScanner;->factory:Lorg/simpleframework/xml/core/MethodPartFactory;

    invoke-virtual {v7, v4}, Lorg/simpleframework/xml/core/MethodPartFactory;->getType(Ljava/lang/reflect/Method;)Ljava/lang/Class;

    move-result-object v6

    .line 222
    .local v6, "value":Ljava/lang/Class;
    if-eqz v6, :cond_0

    .line 223
    invoke-direct {p0, v4, v3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;[Ljava/lang/annotation/Annotation;)V

    .line 218
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 227
    .end local v0    # "arr$":[Ljava/lang/reflect/Method;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    .end local v3    # "list":[Ljava/lang/annotation/Annotation;
    .end local v4    # "method":Ljava/lang/reflect/Method;
    .end local v6    # "value":Ljava/lang/Class;
    :cond_1
    return-void
.end method

.method private scan(Ljava/lang/reflect/Method;)V
    .locals 5
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 198
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getDeclaredAnnotations()[Ljava/lang/annotation/Annotation;

    move-result-object v4

    .line 200
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

    .line 201
    .local v2, "label":Ljava/lang/annotation/Annotation;
    invoke-direct {p0, p1, v2, v4}, Lorg/simpleframework/xml/core/MethodScanner;->scan(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 200
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 203
    .end local v2    # "label":Ljava/lang/annotation/Annotation;
    :cond_0
    return-void
.end method

.method private scan(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .param p2, "label"    # Ljava/lang/annotation/Annotation;
    .param p3, "list"    # [Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 242
    instance-of v0, p2, Lorg/simpleframework/xml/Attribute;

    if-eqz v0, :cond_0

    .line 243
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 245
    :cond_0
    instance-of v0, p2, Lorg/simpleframework/xml/ElementUnion;

    if-eqz v0, :cond_1

    .line 246
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 248
    :cond_1
    instance-of v0, p2, Lorg/simpleframework/xml/ElementListUnion;

    if-eqz v0, :cond_2

    .line 249
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 251
    :cond_2
    instance-of v0, p2, Lorg/simpleframework/xml/ElementMapUnion;

    if-eqz v0, :cond_3

    .line 252
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 254
    :cond_3
    instance-of v0, p2, Lorg/simpleframework/xml/ElementList;

    if-eqz v0, :cond_4

    .line 255
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 257
    :cond_4
    instance-of v0, p2, Lorg/simpleframework/xml/ElementArray;

    if-eqz v0, :cond_5

    .line 258
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 260
    :cond_5
    instance-of v0, p2, Lorg/simpleframework/xml/ElementMap;

    if-eqz v0, :cond_6

    .line 261
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 263
    :cond_6
    instance-of v0, p2, Lorg/simpleframework/xml/Element;

    if-eqz v0, :cond_7

    .line 264
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 266
    :cond_7
    instance-of v0, p2, Lorg/simpleframework/xml/Version;

    if-eqz v0, :cond_8

    .line 267
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 269
    :cond_8
    instance-of v0, p2, Lorg/simpleframework/xml/Text;

    if-eqz v0, :cond_9

    .line 270
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->process(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 272
    :cond_9
    instance-of v0, p2, Lorg/simpleframework/xml/Transient;

    if-eqz v0, :cond_a

    .line 273
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/MethodScanner;->remove(Ljava/lang/reflect/Method;Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)V

    .line 275
    :cond_a
    return-void
.end method

.method private validate()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 481
    iget-object v3, p0, Lorg/simpleframework/xml/core/MethodScanner;->write:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-virtual {v3}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 482
    .local v1, "name":Ljava/lang/String;
    iget-object v3, p0, Lorg/simpleframework/xml/core/MethodScanner;->write:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-virtual {v3, v1}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/simpleframework/xml/core/MethodPart;

    .line 484
    .local v2, "part":Lorg/simpleframework/xml/core/MethodPart;
    if-eqz v2, :cond_0

    .line 485
    invoke-direct {p0, v2, v1}, Lorg/simpleframework/xml/core/MethodScanner;->validate(Lorg/simpleframework/xml/core/MethodPart;Ljava/lang/String;)V

    goto :goto_0

    .line 488
    .end local v1    # "name":Ljava/lang/String;
    .end local v2    # "part":Lorg/simpleframework/xml/core/MethodPart;
    :cond_1
    return-void
.end method

.method private validate(Lorg/simpleframework/xml/core/MethodPart;Ljava/lang/String;)V
    .locals 7
    .param p1, "write"    # Lorg/simpleframework/xml/core/MethodPart;
    .param p2, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 502
    iget-object v2, p0, Lorg/simpleframework/xml/core/MethodScanner;->read:Lorg/simpleframework/xml/core/MethodScanner$PartMap;

    invoke-virtual {v2, p2}, Lorg/simpleframework/xml/core/MethodScanner$PartMap;->take(Ljava/lang/String;)Lorg/simpleframework/xml/core/MethodPart;

    move-result-object v0

    .line 503
    .local v0, "match":Lorg/simpleframework/xml/core/MethodPart;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/MethodPart;->getMethod()Ljava/lang/reflect/Method;

    move-result-object v1

    .line 505
    .local v1, "method":Ljava/lang/reflect/Method;
    if-nez v0, :cond_0

    .line 506
    new-instance v2, Lorg/simpleframework/xml/core/MethodException;

    const-string v3, "No matching get method for %s in %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    const/4 v5, 0x1

    iget-object v6, p0, Lorg/simpleframework/xml/core/MethodScanner;->type:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-direct {v2, v3, v4}, Lorg/simpleframework/xml/core/MethodException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v2

    .line 508
    :cond_0
    return-void
.end method
