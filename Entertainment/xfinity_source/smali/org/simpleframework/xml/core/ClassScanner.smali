.class Lorg/simpleframework/xml/core/ClassScanner;
.super Ljava/lang/Object;
.source "ClassScanner.java"


# instance fields
.field private access:Lorg/simpleframework/xml/Default;

.field private commit:Lorg/simpleframework/xml/core/Function;

.field private complete:Lorg/simpleframework/xml/core/Function;

.field private decorator:Lorg/simpleframework/xml/core/NamespaceDecorator;

.field private namespace:Lorg/simpleframework/xml/Namespace;

.field private order:Lorg/simpleframework/xml/Order;

.field private persist:Lorg/simpleframework/xml/core/Function;

.field private replace:Lorg/simpleframework/xml/core/Function;

.field private resolve:Lorg/simpleframework/xml/core/Function;

.field private root:Lorg/simpleframework/xml/Root;

.field private scanner:Lorg/simpleframework/xml/core/ConstructorScanner;

.field private validate:Lorg/simpleframework/xml/core/Function;


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
    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 115
    new-instance v0, Lorg/simpleframework/xml/core/ConstructorScanner;

    invoke-direct {v0, p1, p2}, Lorg/simpleframework/xml/core/ConstructorScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->scanner:Lorg/simpleframework/xml/core/ConstructorScanner;

    .line 116
    new-instance v0, Lorg/simpleframework/xml/core/NamespaceDecorator;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/NamespaceDecorator;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->decorator:Lorg/simpleframework/xml/core/NamespaceDecorator;

    .line 117
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->scan(Ljava/lang/Class;)V

    .line 118
    return-void
.end method

.method private access(Ljava/lang/annotation/Annotation;)V
    .locals 1
    .param p1, "label"    # Ljava/lang/annotation/Annotation;

    .prologue
    .line 403
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->access:Lorg/simpleframework/xml/Default;

    if-nez v0, :cond_0

    .line 404
    check-cast p1, Lorg/simpleframework/xml/Default;

    .end local p1    # "label":Ljava/lang/annotation/Annotation;
    iput-object p1, p0, Lorg/simpleframework/xml/core/ClassScanner;->access:Lorg/simpleframework/xml/Default;

    .line 406
    :cond_0
    return-void
.end method

.method private commit(Ljava/lang/reflect/Method;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 529
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->commit:Lorg/simpleframework/xml/core/Function;

    if-nez v0, :cond_0

    .line 530
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->getFunction(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->commit:Lorg/simpleframework/xml/core/Function;

    .line 532
    :cond_0
    return-void
.end method

.method private complete(Ljava/lang/reflect/Method;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 571
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->complete:Lorg/simpleframework/xml/core/Function;

    if-nez v0, :cond_0

    .line 572
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->getFunction(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->complete:Lorg/simpleframework/xml/core/Function;

    .line 574
    :cond_0
    return-void
.end method

.method private getFunction(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/Function;
    .locals 2
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 586
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->isContextual(Ljava/lang/reflect/Method;)Z

    move-result v0

    .line 588
    .local v0, "contextual":Z
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->isAccessible()Z

    move-result v1

    if-nez v1, :cond_0

    .line 589
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    .line 591
    :cond_0
    new-instance v1, Lorg/simpleframework/xml/core/Function;

    invoke-direct {v1, p1, v0}, Lorg/simpleframework/xml/core/Function;-><init>(Ljava/lang/reflect/Method;Z)V

    return-object v1
.end method

.method private global(Ljava/lang/Class;)V
    .locals 6
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 329
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredAnnotations()[Ljava/lang/annotation/Annotation;

    move-result-object v4

    .line 331
    .local v4, "list":[Ljava/lang/annotation/Annotation;
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/annotation/Annotation;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_5

    aget-object v2, v0, v1

    .line 332
    .local v2, "label":Ljava/lang/annotation/Annotation;
    instance-of v5, v2, Lorg/simpleframework/xml/Namespace;

    if-eqz v5, :cond_0

    .line 333
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/ClassScanner;->namespace(Ljava/lang/annotation/Annotation;)V

    .line 335
    :cond_0
    instance-of v5, v2, Lorg/simpleframework/xml/NamespaceList;

    if-eqz v5, :cond_1

    .line 336
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/ClassScanner;->scope(Ljava/lang/annotation/Annotation;)V

    .line 338
    :cond_1
    instance-of v5, v2, Lorg/simpleframework/xml/Root;

    if-eqz v5, :cond_2

    .line 339
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/ClassScanner;->root(Ljava/lang/annotation/Annotation;)V

    .line 341
    :cond_2
    instance-of v5, v2, Lorg/simpleframework/xml/Order;

    if-eqz v5, :cond_3

    .line 342
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/ClassScanner;->order(Ljava/lang/annotation/Annotation;)V

    .line 344
    :cond_3
    instance-of v5, v2, Lorg/simpleframework/xml/Default;

    if-eqz v5, :cond_4

    .line 345
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/ClassScanner;->access(Ljava/lang/annotation/Annotation;)V

    .line 331
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 348
    .end local v2    # "label":Ljava/lang/annotation/Annotation;
    :cond_5
    return-void
.end method

.method private isContextual(Ljava/lang/reflect/Method;)Z
    .locals 4
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    const/4 v1, 0x0

    .line 604
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v0

    .line 606
    .local v0, "list":[Ljava/lang/Class;
    array-length v2, v0

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 607
    const-class v2, Ljava/util/Map;

    aget-object v1, v0, v1

    invoke-virtual {v2, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    .line 609
    :cond_0
    return v1
.end method

.method private namespace(Ljava/lang/annotation/Annotation;)V
    .locals 2
    .param p1, "label"    # Ljava/lang/annotation/Annotation;

    .prologue
    .line 417
    if-eqz p1, :cond_0

    .line 418
    check-cast p1, Lorg/simpleframework/xml/Namespace;

    .end local p1    # "label":Ljava/lang/annotation/Annotation;
    iput-object p1, p0, Lorg/simpleframework/xml/core/ClassScanner;->namespace:Lorg/simpleframework/xml/Namespace;

    .line 420
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->namespace:Lorg/simpleframework/xml/Namespace;

    if-eqz v0, :cond_0

    .line 421
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->decorator:Lorg/simpleframework/xml/core/NamespaceDecorator;

    iget-object v1, p0, Lorg/simpleframework/xml/core/ClassScanner;->namespace:Lorg/simpleframework/xml/Namespace;

    invoke-virtual {v0, v1}, Lorg/simpleframework/xml/core/NamespaceDecorator;->add(Lorg/simpleframework/xml/Namespace;)V

    .line 424
    :cond_0
    return-void
.end method

.method private order(Ljava/lang/annotation/Annotation;)V
    .locals 1
    .param p1, "label"    # Ljava/lang/annotation/Annotation;

    .prologue
    .line 390
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->order:Lorg/simpleframework/xml/Order;

    if-nez v0, :cond_0

    .line 391
    check-cast p1, Lorg/simpleframework/xml/Order;

    .end local p1    # "label":Ljava/lang/annotation/Annotation;
    iput-object p1, p0, Lorg/simpleframework/xml/core/ClassScanner;->order:Lorg/simpleframework/xml/Order;

    .line 393
    :cond_0
    return-void
.end method

.method private persist(Ljava/lang/reflect/Method;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 557
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->persist:Lorg/simpleframework/xml/core/Function;

    if-nez v0, :cond_0

    .line 558
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->getFunction(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->persist:Lorg/simpleframework/xml/core/Function;

    .line 560
    :cond_0
    return-void
.end method

.method private process(Ljava/lang/Class;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;

    .prologue
    .line 454
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->namespace:Lorg/simpleframework/xml/Namespace;

    if-eqz v0, :cond_0

    .line 455
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->decorator:Lorg/simpleframework/xml/core/NamespaceDecorator;

    iget-object v1, p0, Lorg/simpleframework/xml/core/ClassScanner;->namespace:Lorg/simpleframework/xml/Namespace;

    invoke-virtual {v0, v1}, Lorg/simpleframework/xml/core/NamespaceDecorator;->set(Lorg/simpleframework/xml/Namespace;)V

    .line 457
    :cond_0
    return-void
.end method

.method private replace(Ljava/lang/reflect/Method;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 501
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->replace:Lorg/simpleframework/xml/core/Function;

    if-nez v0, :cond_0

    .line 502
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->getFunction(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->replace:Lorg/simpleframework/xml/core/Function;

    .line 504
    :cond_0
    return-void
.end method

.method private resolve(Ljava/lang/reflect/Method;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 515
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->resolve:Lorg/simpleframework/xml/core/Function;

    if-nez v0, :cond_0

    .line 516
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->getFunction(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->resolve:Lorg/simpleframework/xml/core/Function;

    .line 518
    :cond_0
    return-void
.end method

.method private root(Ljava/lang/annotation/Annotation;)V
    .locals 1
    .param p1, "label"    # Ljava/lang/annotation/Annotation;

    .prologue
    .line 377
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->root:Lorg/simpleframework/xml/Root;

    if-nez v0, :cond_0

    .line 378
    check-cast p1, Lorg/simpleframework/xml/Root;

    .end local p1    # "label":Ljava/lang/annotation/Annotation;
    iput-object p1, p0, Lorg/simpleframework/xml/core/ClassScanner;->root:Lorg/simpleframework/xml/Root;

    .line 380
    :cond_0
    return-void
.end method

.method private scan(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 309
    move-object v0, p1

    .line 311
    .local v0, "real":Ljava/lang/Class;
    :goto_0
    if-eqz p1, :cond_0

    .line 312
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->global(Ljava/lang/Class;)V

    .line 313
    invoke-direct {p0, v0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->scan(Ljava/lang/Class;Ljava/lang/Class;)V

    .line 314
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object p1

    goto :goto_0

    .line 316
    :cond_0
    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/ClassScanner;->process(Ljava/lang/Class;)V

    .line 317
    return-void
.end method

.method private scan(Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 3
    .param p1, "real"    # Ljava/lang/Class;
    .param p2, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 362
    invoke-virtual {p2}, Ljava/lang/Class;->getDeclaredMethods()[Ljava/lang/reflect/Method;

    move-result-object v1

    .line 364
    .local v1, "method":[Ljava/lang/reflect/Method;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 365
    aget-object v2, v1, v0

    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/ClassScanner;->scan(Ljava/lang/reflect/Method;)V

    .line 364
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 367
    :cond_0
    return-void
.end method

.method private scan(Ljava/lang/reflect/Method;)V
    .locals 6
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 468
    invoke-virtual {p1}, Ljava/lang/reflect/Method;->getDeclaredAnnotations()[Ljava/lang/annotation/Annotation;

    move-result-object v4

    .line 470
    .local v4, "list":[Ljava/lang/annotation/Annotation;
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/annotation/Annotation;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_6

    aget-object v2, v0, v1

    .line 471
    .local v2, "label":Ljava/lang/annotation/Annotation;
    instance-of v5, v2, Lorg/simpleframework/xml/core/Commit;

    if-eqz v5, :cond_0

    .line 472
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->commit(Ljava/lang/reflect/Method;)V

    .line 474
    :cond_0
    instance-of v5, v2, Lorg/simpleframework/xml/core/Validate;

    if-eqz v5, :cond_1

    .line 475
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->validate(Ljava/lang/reflect/Method;)V

    .line 477
    :cond_1
    instance-of v5, v2, Lorg/simpleframework/xml/core/Persist;

    if-eqz v5, :cond_2

    .line 478
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->persist(Ljava/lang/reflect/Method;)V

    .line 480
    :cond_2
    instance-of v5, v2, Lorg/simpleframework/xml/core/Complete;

    if-eqz v5, :cond_3

    .line 481
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->complete(Ljava/lang/reflect/Method;)V

    .line 483
    :cond_3
    instance-of v5, v2, Lorg/simpleframework/xml/core/Replace;

    if-eqz v5, :cond_4

    .line 484
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->replace(Ljava/lang/reflect/Method;)V

    .line 486
    :cond_4
    instance-of v5, v2, Lorg/simpleframework/xml/core/Resolve;

    if-eqz v5, :cond_5

    .line 487
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->resolve(Ljava/lang/reflect/Method;)V

    .line 470
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 490
    .end local v2    # "label":Ljava/lang/annotation/Annotation;
    :cond_6
    return-void
.end method

.method private scope(Ljava/lang/annotation/Annotation;)V
    .locals 7
    .param p1, "label"    # Ljava/lang/annotation/Annotation;

    .prologue
    .line 435
    if-eqz p1, :cond_0

    move-object v5, p1

    .line 436
    check-cast v5, Lorg/simpleframework/xml/NamespaceList;

    .line 437
    .local v5, "scope":Lorg/simpleframework/xml/NamespaceList;
    invoke-interface {v5}, Lorg/simpleframework/xml/NamespaceList;->value()[Lorg/simpleframework/xml/Namespace;

    move-result-object v3

    .line 439
    .local v3, "list":[Lorg/simpleframework/xml/Namespace;
    move-object v0, v3

    .local v0, "arr$":[Lorg/simpleframework/xml/Namespace;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v4, v0, v1

    .line 440
    .local v4, "name":Lorg/simpleframework/xml/Namespace;
    iget-object v6, p0, Lorg/simpleframework/xml/core/ClassScanner;->decorator:Lorg/simpleframework/xml/core/NamespaceDecorator;

    invoke-virtual {v6, v4}, Lorg/simpleframework/xml/core/NamespaceDecorator;->add(Lorg/simpleframework/xml/Namespace;)V

    .line 439
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 443
    .end local v0    # "arr$":[Lorg/simpleframework/xml/Namespace;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    .end local v3    # "list":[Lorg/simpleframework/xml/Namespace;
    .end local v4    # "name":Lorg/simpleframework/xml/Namespace;
    .end local v5    # "scope":Lorg/simpleframework/xml/NamespaceList;
    :cond_0
    return-void
.end method

.method private validate(Ljava/lang/reflect/Method;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 543
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->validate:Lorg/simpleframework/xml/core/Function;

    if-nez v0, :cond_0

    .line 544
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ClassScanner;->getFunction(Ljava/lang/reflect/Method;)Lorg/simpleframework/xml/core/Function;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->validate:Lorg/simpleframework/xml/core/Function;

    .line 546
    :cond_0
    return-void
.end method


# virtual methods
.method public getCommit()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->commit:Lorg/simpleframework/xml/core/Function;

    return-object v0
.end method

.method public getComplete()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 253
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->complete:Lorg/simpleframework/xml/core/Function;

    return-object v0
.end method

.method public getDecorator()Lorg/simpleframework/xml/core/Decorator;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->decorator:Lorg/simpleframework/xml/core/NamespaceDecorator;

    return-object v0
.end method

.method public getDefault()Lorg/simpleframework/xml/Default;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->access:Lorg/simpleframework/xml/Default;

    return-object v0
.end method

.method public getOrder()Lorg/simpleframework/xml/Order;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->order:Lorg/simpleframework/xml/Order;

    return-object v0
.end method

.method public getParameters()Lorg/simpleframework/xml/core/ParameterMap;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->scanner:Lorg/simpleframework/xml/core/ConstructorScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ConstructorScanner;->getParameters()Lorg/simpleframework/xml/core/ParameterMap;

    move-result-object v0

    return-object v0
.end method

.method public getPersist()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->persist:Lorg/simpleframework/xml/core/Function;

    return-object v0
.end method

.method public getReplace()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->replace:Lorg/simpleframework/xml/core/Function;

    return-object v0
.end method

.method public getResolve()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->resolve:Lorg/simpleframework/xml/core/Function;

    return-object v0
.end method

.method public getRoot()Lorg/simpleframework/xml/Root;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->root:Lorg/simpleframework/xml/Root;

    return-object v0
.end method

.method public getSignature()Lorg/simpleframework/xml/core/Signature;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->scanner:Lorg/simpleframework/xml/core/ConstructorScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ConstructorScanner;->getSignature()Lorg/simpleframework/xml/core/Signature;

    move-result-object v0

    return-object v0
.end method

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

    .prologue
    .line 141
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->scanner:Lorg/simpleframework/xml/core/ConstructorScanner;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ConstructorScanner;->getSignatures()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getValidate()Lorg/simpleframework/xml/core/Function;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->validate:Lorg/simpleframework/xml/core/Function;

    return-object v0
.end method

.method public isStrict()Z
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->root:Lorg/simpleframework/xml/Root;

    if-eqz v0, :cond_0

    .line 294
    iget-object v0, p0, Lorg/simpleframework/xml/core/ClassScanner;->root:Lorg/simpleframework/xml/Root;

    invoke-interface {v0}, Lorg/simpleframework/xml/Root;->strict()Z

    move-result v0

    .line 296
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method
