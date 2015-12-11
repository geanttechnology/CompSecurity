.class Lorg/simpleframework/xml/core/StructureBuilder;
.super Ljava/lang/Object;
.source "StructureBuilder.java"


# instance fields
.field private assembler:Lorg/simpleframework/xml/core/ModelAssembler;

.field private attributes:Lorg/simpleframework/xml/core/LabelMap;

.field private builder:Lorg/simpleframework/xml/core/ExpressionBuilder;

.field private elements:Lorg/simpleframework/xml/core/LabelMap;

.field private factory:Lorg/simpleframework/xml/core/Instantiator;

.field private format:Lorg/simpleframework/xml/stream/Format;

.field private primitive:Z

.field private resolver:Lorg/simpleframework/xml/core/InstantiatorBuilder;

.field private root:Lorg/simpleframework/xml/core/Model;

.field private scanner:Lorg/simpleframework/xml/core/Scanner;

.field private text:Lorg/simpleframework/xml/core/Label;

.field private texts:Lorg/simpleframework/xml/core/LabelMap;

.field private type:Ljava/lang/Class;

.field private version:Lorg/simpleframework/xml/core/Label;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/Scanner;Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V
    .locals 2
    .param p1, "scanner"    # Lorg/simpleframework/xml/core/Scanner;
    .param p2, "type"    # Ljava/lang/Class;
    .param p3, "format"    # Lorg/simpleframework/xml/stream/Format;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 138
    new-instance v0, Lorg/simpleframework/xml/core/ExpressionBuilder;

    invoke-direct {v0, p2, p3}, Lorg/simpleframework/xml/core/ExpressionBuilder;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->builder:Lorg/simpleframework/xml/core/ExpressionBuilder;

    .line 139
    new-instance v0, Lorg/simpleframework/xml/core/ModelAssembler;

    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->builder:Lorg/simpleframework/xml/core/ExpressionBuilder;

    invoke-direct {v0, v1, p2, p3}, Lorg/simpleframework/xml/core/ModelAssembler;-><init>(Lorg/simpleframework/xml/core/ExpressionBuilder;Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->assembler:Lorg/simpleframework/xml/core/ModelAssembler;

    .line 140
    new-instance v0, Lorg/simpleframework/xml/core/InstantiatorBuilder;

    invoke-direct {v0, p1, p2}, Lorg/simpleframework/xml/core/InstantiatorBuilder;-><init>(Lorg/simpleframework/xml/core/Scanner;Ljava/lang/Class;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->resolver:Lorg/simpleframework/xml/core/InstantiatorBuilder;

    .line 141
    new-instance v0, Lorg/simpleframework/xml/core/TreeModel;

    invoke-direct {v0, p1, p2}, Lorg/simpleframework/xml/core/TreeModel;-><init>(Lorg/simpleframework/xml/core/Policy;Ljava/lang/Class;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    .line 142
    new-instance v0, Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/LabelMap;-><init>(Lorg/simpleframework/xml/core/Policy;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    .line 143
    new-instance v0, Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/LabelMap;-><init>(Lorg/simpleframework/xml/core/Policy;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    .line 144
    new-instance v0, Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/LabelMap;-><init>(Lorg/simpleframework/xml/core/Policy;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->texts:Lorg/simpleframework/xml/core/LabelMap;

    .line 145
    iput-object p1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    .line 146
    iput-object p3, p0, Lorg/simpleframework/xml/core/StructureBuilder;->format:Lorg/simpleframework/xml/stream/Format;

    .line 147
    iput-object p2, p0, Lorg/simpleframework/xml/core/StructureBuilder;->type:Ljava/lang/Class;

    .line 148
    return-void
.end method

.method private create(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;
    .locals 5
    .param p1, "path"    # Lorg/simpleframework/xml/core/Expression;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 484
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    .line 486
    .local v1, "model":Lorg/simpleframework/xml/core/Model;
    :goto_0
    if-eqz v1, :cond_1

    .line 487
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Expression;->getPrefix()Ljava/lang/String;

    move-result-object v3

    .line 488
    .local v3, "prefix":Ljava/lang/String;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Expression;->getFirst()Ljava/lang/String;

    move-result-object v2

    .line 489
    .local v2, "name":Ljava/lang/String;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Expression;->getIndex()I

    move-result v0

    .line 491
    .local v0, "index":I
    if-eqz v2, :cond_0

    .line 492
    invoke-interface {v1, v2, v3, v0}, Lorg/simpleframework/xml/core/Model;->register(Ljava/lang/String;Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;

    move-result-object v1

    .line 494
    :cond_0
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Expression;->isPath()Z

    move-result v4

    if-nez v4, :cond_2

    .line 499
    .end local v0    # "index":I
    .end local v2    # "name":Ljava/lang/String;
    .end local v3    # "prefix":Ljava/lang/String;
    :cond_1
    return-object v1

    .line 497
    .restart local v0    # "index":I
    .restart local v2    # "name":Ljava/lang/String;
    .restart local v3    # "prefix":Ljava/lang/String;
    :cond_2
    const/4 v4, 0x1

    invoke-interface {p1, v4}, Lorg/simpleframework/xml/core/Expression;->getPath(I)Lorg/simpleframework/xml/core/Expression;

    move-result-object p1

    .line 498
    goto :goto_0
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

    .line 346
    invoke-interface {p1}, Ljava/lang/annotation/Annotation;->annotationType()Ljava/lang/Class;

    move-result-object v2

    .line 347
    .local v2, "union":Ljava/lang/Class;
    invoke-virtual {v2}, Ljava/lang/Class;->getDeclaredMethods()[Ljava/lang/reflect/Method;

    move-result-object v0

    .line 349
    .local v0, "list":[Ljava/lang/reflect/Method;
    array-length v4, v0

    if-eq v4, v8, :cond_0

    .line 350
    new-instance v4, Lorg/simpleframework/xml/core/UnionException;

    const-string v5, "Annotation \'%s\' is not a valid union for %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    aput-object p1, v6, v7

    iget-object v7, p0, Lorg/simpleframework/xml/core/StructureBuilder;->type:Ljava/lang/Class;

    aput-object v7, v6, v8

    invoke-direct {v4, v5, v6}, Lorg/simpleframework/xml/core/UnionException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v4

    .line 352
    :cond_0
    aget-object v1, v0, v7

    .line 353
    .local v1, "method":Ljava/lang/reflect/Method;
    new-array v4, v7, [Ljava/lang/Object;

    invoke-virtual {v1, p1, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 355
    .local v3, "value":Ljava/lang/Object;
    check-cast v3, [Ljava/lang/annotation/Annotation;

    .end local v3    # "value":Ljava/lang/Object;
    check-cast v3, [Ljava/lang/annotation/Annotation;

    return-object v3
.end method

.method private isAttribute(Ljava/lang/String;)Z
    .locals 4
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 421
    iget-object v3, p0, Lorg/simpleframework/xml/core/StructureBuilder;->builder:Lorg/simpleframework/xml/core/ExpressionBuilder;

    invoke-virtual {v3, p1}, Lorg/simpleframework/xml/core/ExpressionBuilder;->build(Ljava/lang/String;)Lorg/simpleframework/xml/core/Expression;

    move-result-object v2

    .line 422
    .local v2, "target":Lorg/simpleframework/xml/core/Expression;
    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/StructureBuilder;->lookup(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;

    move-result-object v0

    .line 424
    .local v0, "model":Lorg/simpleframework/xml/core/Model;
    if-eqz v0, :cond_1

    .line 425
    invoke-interface {v2}, Lorg/simpleframework/xml/core/Expression;->getLast()Ljava/lang/String;

    move-result-object v1

    .line 427
    .local v1, "name":Ljava/lang/String;
    invoke-interface {v2}, Lorg/simpleframework/xml/core/Expression;->isPath()Z

    move-result v3

    if-nez v3, :cond_0

    .line 428
    invoke-interface {v0, p1}, Lorg/simpleframework/xml/core/Model;->isAttribute(Ljava/lang/String;)Z

    move-result v3

    .line 432
    .end local v1    # "name":Ljava/lang/String;
    :goto_0
    return v3

    .line 430
    .restart local v1    # "name":Ljava/lang/String;
    :cond_0
    invoke-interface {v0, v1}, Lorg/simpleframework/xml/core/Model;->isAttribute(Ljava/lang/String;)Z

    move-result v3

    goto :goto_0

    .line 432
    .end local v1    # "name":Ljava/lang/String;
    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method private isElement(Ljava/lang/String;)Z
    .locals 8
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 389
    iget-object v7, p0, Lorg/simpleframework/xml/core/StructureBuilder;->builder:Lorg/simpleframework/xml/core/ExpressionBuilder;

    invoke-virtual {v7, p1}, Lorg/simpleframework/xml/core/ExpressionBuilder;->build(Ljava/lang/String;)Lorg/simpleframework/xml/core/Expression;

    move-result-object v4

    .line 390
    .local v4, "target":Lorg/simpleframework/xml/core/Expression;
    invoke-direct {p0, v4}, Lorg/simpleframework/xml/core/StructureBuilder;->lookup(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;

    move-result-object v2

    .line 392
    .local v2, "model":Lorg/simpleframework/xml/core/Model;
    if-eqz v2, :cond_2

    .line 393
    invoke-interface {v4}, Lorg/simpleframework/xml/core/Expression;->getLast()Ljava/lang/String;

    move-result-object v3

    .line 394
    .local v3, "name":Ljava/lang/String;
    invoke-interface {v4}, Lorg/simpleframework/xml/core/Expression;->getIndex()I

    move-result v1

    .line 396
    .local v1, "index":I
    invoke-interface {v2, v3}, Lorg/simpleframework/xml/core/Model;->isElement(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 408
    .end local v1    # "index":I
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    :goto_0
    return v5

    .line 399
    .restart local v1    # "index":I
    .restart local v3    # "name":Ljava/lang/String;
    :cond_1
    invoke-interface {v2, v3}, Lorg/simpleframework/xml/core/Model;->isModel(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 400
    invoke-interface {v2, v3, v1}, Lorg/simpleframework/xml/core/Model;->lookup(Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;

    move-result-object v0

    .line 402
    .local v0, "element":Lorg/simpleframework/xml/core/Model;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Model;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_0

    move v5, v6

    .line 403
    goto :goto_0

    .end local v0    # "element":Lorg/simpleframework/xml/core/Model;
    .end local v1    # "index":I
    .end local v3    # "name":Ljava/lang/String;
    :cond_2
    move v5, v6

    .line 408
    goto :goto_0
.end method

.method private isEmpty()Z
    .locals 1

    .prologue
    .line 641
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->text:Lorg/simpleframework/xml/core/Label;

    if-eqz v0, :cond_0

    .line 642
    const/4 v0, 0x0

    .line 644
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    invoke-interface {v0}, Lorg/simpleframework/xml/core/Model;->isEmpty()Z

    move-result v0

    goto :goto_0
.end method

.method private lookup(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;
    .locals 3
    .param p1, "path"    # Lorg/simpleframework/xml/core/Expression;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 446
    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-interface {p1, v1, v2}, Lorg/simpleframework/xml/core/Expression;->getPath(II)Lorg/simpleframework/xml/core/Expression;

    move-result-object v0

    .line 448
    .local v0, "target":Lorg/simpleframework/xml/core/Expression;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Expression;->isPath()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 449
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    invoke-interface {v1, v0}, Lorg/simpleframework/xml/core/Model;->lookup(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;

    move-result-object v1

    .line 451
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    goto :goto_0
.end method

.method private process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V
    .locals 7
    .param p1, "field"    # Lorg/simpleframework/xml/core/Contact;
    .param p2, "type"    # Ljava/lang/annotation/Annotation;
    .param p3, "map"    # Lorg/simpleframework/xml/core/LabelMap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 252
    iget-object v3, p0, Lorg/simpleframework/xml/core/StructureBuilder;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-static {p1, p2, v3}, Lorg/simpleframework/xml/core/LabelFactory;->getInstance(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    .line 253
    .local v0, "label":Lorg/simpleframework/xml/core/Label;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Label;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 254
    .local v2, "path":Ljava/lang/String;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Label;->getName()Ljava/lang/String;

    move-result-object v1

    .line 256
    .local v1, "name":Ljava/lang/String;
    invoke-virtual {p3, v2}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 257
    new-instance v3, Lorg/simpleframework/xml/core/PersistenceException;

    const-string v4, "Duplicate annotation of name \'%s\' on %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v1, v5, v6

    const/4 v6, 0x1

    aput-object p1, v5, v6

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/PersistenceException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 259
    :cond_0
    invoke-direct {p0, p1, v0, p3}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 260
    return-void
.end method

.method private process(Lorg/simpleframework/xml/core/Contact;Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/LabelMap;)V
    .locals 4
    .param p1, "field"    # Lorg/simpleframework/xml/core/Contact;
    .param p2, "label"    # Lorg/simpleframework/xml/core/Label;
    .param p3, "map"    # Lorg/simpleframework/xml/core/LabelMap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 276
    invoke-interface {p2}, Lorg/simpleframework/xml/core/Label;->getExpression()Lorg/simpleframework/xml/core/Expression;

    move-result-object v0

    .line 277
    .local v0, "expression":Lorg/simpleframework/xml/core/Expression;
    invoke-interface {p2}, Lorg/simpleframework/xml/core/Label;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 278
    .local v2, "path":Ljava/lang/String;
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    .line 280
    .local v1, "model":Lorg/simpleframework/xml/core/Model;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Expression;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 281
    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->register(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;

    move-result-object v1

    .line 283
    :cond_0
    iget-object v3, p0, Lorg/simpleframework/xml/core/StructureBuilder;->resolver:Lorg/simpleframework/xml/core/InstantiatorBuilder;

    invoke-virtual {v3, p2}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->register(Lorg/simpleframework/xml/core/Label;)V

    .line 284
    invoke-interface {v1, p2}, Lorg/simpleframework/xml/core/Model;->register(Lorg/simpleframework/xml/core/Label;)V

    .line 285
    invoke-virtual {p3, v2, p2}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 286
    return-void
.end method

.method private register(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;
    .locals 2
    .param p1, "path"    # Lorg/simpleframework/xml/core/Expression;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 465
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    invoke-interface {v1, p1}, Lorg/simpleframework/xml/core/Model;->lookup(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;

    move-result-object v0

    .line 467
    .local v0, "model":Lorg/simpleframework/xml/core/Model;
    if-eqz v0, :cond_0

    .line 470
    .end local v0    # "model":Lorg/simpleframework/xml/core/Model;
    :goto_0
    return-object v0

    .restart local v0    # "model":Lorg/simpleframework/xml/core/Model;
    :cond_0
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/StructureBuilder;->create(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;

    move-result-object v0

    goto :goto_0
.end method

.method private text(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;)V
    .locals 8
    .param p1, "field"    # Lorg/simpleframework/xml/core/Contact;
    .param p2, "type"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 300
    iget-object v4, p0, Lorg/simpleframework/xml/core/StructureBuilder;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-static {p1, p2, v4}, Lorg/simpleframework/xml/core/LabelFactory;->getInstance(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;

    move-result-object v1

    .line 301
    .local v1, "label":Lorg/simpleframework/xml/core/Label;
    invoke-interface {v1}, Lorg/simpleframework/xml/core/Label;->getExpression()Lorg/simpleframework/xml/core/Expression;

    move-result-object v0

    .line 302
    .local v0, "expression":Lorg/simpleframework/xml/core/Expression;
    invoke-interface {v1}, Lorg/simpleframework/xml/core/Label;->getPath()Ljava/lang/String;

    move-result-object v3

    .line 303
    .local v3, "path":Ljava/lang/String;
    iget-object v2, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    .line 305
    .local v2, "model":Lorg/simpleframework/xml/core/Model;
    invoke-interface {v0}, Lorg/simpleframework/xml/core/Expression;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 306
    invoke-direct {p0, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->register(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;

    move-result-object v2

    .line 308
    :cond_0
    iget-object v4, p0, Lorg/simpleframework/xml/core/StructureBuilder;->texts:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v4, v3}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 309
    new-instance v4, Lorg/simpleframework/xml/core/TextException;

    const-string v5, "Multiple text annotations in %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p2, v6, v7

    invoke-direct {v4, v5, v6}, Lorg/simpleframework/xml/core/TextException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v4

    .line 311
    :cond_1
    iget-object v4, p0, Lorg/simpleframework/xml/core/StructureBuilder;->resolver:Lorg/simpleframework/xml/core/InstantiatorBuilder;

    invoke-virtual {v4, v1}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->register(Lorg/simpleframework/xml/core/Label;)V

    .line 312
    invoke-interface {v2, v1}, Lorg/simpleframework/xml/core/Model;->register(Lorg/simpleframework/xml/core/Label;)V

    .line 313
    iget-object v4, p0, Lorg/simpleframework/xml/core/StructureBuilder;->texts:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v4, v3, v1}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 314
    return-void
.end method

.method private union(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V
    .locals 12
    .param p1, "field"    # Lorg/simpleframework/xml/core/Contact;
    .param p2, "type"    # Ljava/lang/annotation/Annotation;
    .param p3, "map"    # Lorg/simpleframework/xml/core/LabelMap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 224
    invoke-direct {p0, p2}, Lorg/simpleframework/xml/core/StructureBuilder;->extract(Ljava/lang/annotation/Annotation;)[Ljava/lang/annotation/Annotation;

    move-result-object v4

    .line 226
    .local v4, "list":[Ljava/lang/annotation/Annotation;
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/annotation/Annotation;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v7, v0, v1

    .line 227
    .local v7, "value":Ljava/lang/annotation/Annotation;
    iget-object v8, p0, Lorg/simpleframework/xml/core/StructureBuilder;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-static {p1, p2, v7, v8}, Lorg/simpleframework/xml/core/LabelFactory;->getInstance(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;

    move-result-object v2

    .line 228
    .local v2, "label":Lorg/simpleframework/xml/core/Label;
    invoke-interface {v2}, Lorg/simpleframework/xml/core/Label;->getPath()Ljava/lang/String;

    move-result-object v6

    .line 229
    .local v6, "path":Ljava/lang/String;
    invoke-interface {v2}, Lorg/simpleframework/xml/core/Label;->getName()Ljava/lang/String;

    move-result-object v5

    .line 231
    .local v5, "name":Ljava/lang/String;
    invoke-virtual {p3, v6}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    if-eqz v8, :cond_0

    .line 232
    new-instance v8, Lorg/simpleframework/xml/core/PersistenceException;

    const-string v9, "Duplicate annotation of name \'%s\' on %s"

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v5, v10, v11

    const/4 v11, 0x1

    aput-object v2, v10, v11

    invoke-direct {v8, v9, v10}, Lorg/simpleframework/xml/core/PersistenceException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v8

    .line 234
    :cond_0
    invoke-direct {p0, p1, v2, p3}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 226
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 236
    .end local v2    # "label":Lorg/simpleframework/xml/core/Label;
    .end local v5    # "name":Ljava/lang/String;
    .end local v6    # "path":Ljava/lang/String;
    .end local v7    # "value":Ljava/lang/annotation/Annotation;
    :cond_1
    return-void
.end method

.method private validateAttributes(Ljava/lang/Class;Lorg/simpleframework/xml/Order;)V
    .locals 8
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "order"    # Lorg/simpleframework/xml/Order;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 623
    if-eqz p2, :cond_1

    .line 624
    invoke-interface {p2}, Lorg/simpleframework/xml/Order;->attributes()[Ljava/lang/String;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/String;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 625
    .local v3, "name":Ljava/lang/String;
    invoke-direct {p0, v3}, Lorg/simpleframework/xml/core/StructureBuilder;->isAttribute(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 626
    new-instance v4, Lorg/simpleframework/xml/core/AttributeException;

    const-string v5, "Ordered attribute \'%s\' missing in %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v3, v6, v7

    const/4 v7, 0x1

    aput-object p1, v6, v7

    invoke-direct {v4, v5, v6}, Lorg/simpleframework/xml/core/AttributeException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v4

    .line 624
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 630
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    .end local v3    # "name":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private validateElements(Ljava/lang/Class;Lorg/simpleframework/xml/Order;)V
    .locals 8
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "order"    # Lorg/simpleframework/xml/Order;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 605
    if-eqz p2, :cond_1

    .line 606
    invoke-interface {p2}, Lorg/simpleframework/xml/Order;->elements()[Ljava/lang/String;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/String;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 607
    .local v3, "name":Ljava/lang/String;
    invoke-direct {p0, v3}, Lorg/simpleframework/xml/core/StructureBuilder;->isElement(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 608
    new-instance v4, Lorg/simpleframework/xml/core/ElementException;

    const-string v5, "Ordered element \'%s\' missing for %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v3, v6, v7

    const/4 v7, 0x1

    aput-object p1, v6, v7

    invoke-direct {v4, v5, v6}, Lorg/simpleframework/xml/core/ElementException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v4

    .line 606
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 612
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "i$":I
    .end local v2    # "len$":I
    .end local v3    # "name":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private validateModel(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 542
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    invoke-interface {v0}, Lorg/simpleframework/xml/core/Model;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 543
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    invoke-interface {v0, p1}, Lorg/simpleframework/xml/core/Model;->validate(Ljava/lang/Class;)V

    .line 545
    :cond_0
    return-void
.end method

.method private validateText(Ljava/lang/Class;)V
    .locals 6
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v2, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 555
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    invoke-interface {v0}, Lorg/simpleframework/xml/core/Model;->getText()Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 556
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/LabelMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 557
    new-instance v0, Lorg/simpleframework/xml/core/TextException;

    const-string v1, "Elements used with %s in %s"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lorg/simpleframework/xml/core/StructureBuilder;->text:Lorg/simpleframework/xml/core/Label;

    aput-object v3, v2, v4

    aput-object p1, v2, v5

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/TextException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v0

    .line 559
    :cond_0
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    invoke-interface {v0}, Lorg/simpleframework/xml/core/Model;->isComposite()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 560
    new-instance v0, Lorg/simpleframework/xml/core/TextException;

    const-string v1, "Paths used with %s in %s"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lorg/simpleframework/xml/core/StructureBuilder;->text:Lorg/simpleframework/xml/core/Label;

    aput-object v3, v2, v4

    aput-object p1, v2, v5

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/TextException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v0

    .line 563
    :cond_1
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    invoke-interface {v0}, Lorg/simpleframework/xml/core/Scanner;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 564
    invoke-direct {p0}, Lorg/simpleframework/xml/core/StructureBuilder;->isEmpty()Z

    move-result v0

    iput-boolean v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->primitive:Z

    .line 567
    :cond_2
    return-void
.end method

.method private validateUnions(Ljava/lang/Class;)V
    .locals 14
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 578
    iget-object v10, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v10}, Lorg/simpleframework/xml/core/LabelMap;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/simpleframework/xml/core/Label;

    .line 579
    .local v4, "label":Lorg/simpleframework/xml/core/Label;
    invoke-interface {v4}, Lorg/simpleframework/xml/core/Label;->getPaths()[Ljava/lang/String;

    move-result-object v7

    .line 580
    .local v7, "options":[Ljava/lang/String;
    invoke-interface {v4}, Lorg/simpleframework/xml/core/Label;->getContact()Lorg/simpleframework/xml/core/Contact;

    move-result-object v1

    .line 582
    .local v1, "contact":Lorg/simpleframework/xml/core/Contact;
    move-object v0, v7

    .local v0, "arr$":[Ljava/lang/String;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v6, v0, v3

    .line 583
    .local v6, "option":Ljava/lang/String;
    invoke-interface {v1}, Lorg/simpleframework/xml/core/Contact;->getAnnotation()Ljava/lang/annotation/Annotation;

    move-result-object v9

    .line 584
    .local v9, "union":Ljava/lang/annotation/Annotation;
    iget-object v10, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v10, v6}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lorg/simpleframework/xml/core/Label;

    .line 586
    .local v8, "other":Lorg/simpleframework/xml/core/Label;
    invoke-interface {v4}, Lorg/simpleframework/xml/core/Label;->isInline()Z

    move-result v10

    invoke-interface {v8}, Lorg/simpleframework/xml/core/Label;->isInline()Z

    move-result v11

    if-eq v10, v11, :cond_1

    .line 587
    new-instance v10, Lorg/simpleframework/xml/core/UnionException;

    const-string v11, "Inline must be consistent in %s for %s"

    const/4 v12, 0x2

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v9, v12, v13

    const/4 v13, 0x1

    aput-object v1, v12, v13

    invoke-direct {v10, v11, v12}, Lorg/simpleframework/xml/core/UnionException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v10

    .line 589
    :cond_1
    invoke-interface {v4}, Lorg/simpleframework/xml/core/Label;->isRequired()Z

    move-result v10

    invoke-interface {v8}, Lorg/simpleframework/xml/core/Label;->isRequired()Z

    move-result v11

    if-eq v10, v11, :cond_2

    .line 590
    new-instance v10, Lorg/simpleframework/xml/core/UnionException;

    const-string v11, "Required must be consistent in %s for %s"

    const/4 v12, 0x2

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v9, v12, v13

    const/4 v13, 0x1

    aput-object v1, v12, v13

    invoke-direct {v10, v11, v12}, Lorg/simpleframework/xml/core/UnionException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v10

    .line 582
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 594
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "contact":Lorg/simpleframework/xml/core/Contact;
    .end local v3    # "i$":I
    .end local v4    # "label":Lorg/simpleframework/xml/core/Label;
    .end local v5    # "len$":I
    .end local v6    # "option":Ljava/lang/String;
    .end local v7    # "options":[Ljava/lang/String;
    .end local v8    # "other":Lorg/simpleframework/xml/core/Label;
    .end local v9    # "union":Ljava/lang/annotation/Annotation;
    :cond_3
    return-void
.end method

.method private version(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;)V
    .locals 5
    .param p1, "field"    # Lorg/simpleframework/xml/core/Contact;
    .param p2, "type"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 328
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-static {p1, p2, v1}, Lorg/simpleframework/xml/core/LabelFactory;->getInstance(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    .line 330
    .local v0, "label":Lorg/simpleframework/xml/core/Label;
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->version:Lorg/simpleframework/xml/core/Label;

    if-eqz v1, :cond_0

    .line 331
    new-instance v1, Lorg/simpleframework/xml/core/AttributeException;

    const-string v2, "Multiple version annotations in %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    invoke-direct {v1, v2, v3}, Lorg/simpleframework/xml/core/AttributeException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v1

    .line 333
    :cond_0
    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->version:Lorg/simpleframework/xml/core/Label;

    .line 334
    return-void
.end method


# virtual methods
.method public assemble(Ljava/lang/Class;)V
    .locals 3
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 159
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    invoke-interface {v1}, Lorg/simpleframework/xml/core/Scanner;->getOrder()Lorg/simpleframework/xml/Order;

    move-result-object v0

    .line 161
    .local v0, "order":Lorg/simpleframework/xml/Order;
    if-eqz v0, :cond_0

    .line 162
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->assembler:Lorg/simpleframework/xml/core/ModelAssembler;

    iget-object v2, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    invoke-virtual {v1, v2, v0}, Lorg/simpleframework/xml/core/ModelAssembler;->assemble(Lorg/simpleframework/xml/core/Model;Lorg/simpleframework/xml/Order;)V

    .line 164
    :cond_0
    return-void
.end method

.method public build(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Structure;
    .locals 6
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 370
    new-instance v0, Lorg/simpleframework/xml/core/Structure;

    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    iget-object v2, p0, Lorg/simpleframework/xml/core/StructureBuilder;->root:Lorg/simpleframework/xml/core/Model;

    iget-object v3, p0, Lorg/simpleframework/xml/core/StructureBuilder;->version:Lorg/simpleframework/xml/core/Label;

    iget-object v4, p0, Lorg/simpleframework/xml/core/StructureBuilder;->text:Lorg/simpleframework/xml/core/Label;

    iget-boolean v5, p0, Lorg/simpleframework/xml/core/StructureBuilder;->primitive:Z

    invoke-direct/range {v0 .. v5}, Lorg/simpleframework/xml/core/Structure;-><init>(Lorg/simpleframework/xml/core/Instantiator;Lorg/simpleframework/xml/core/Model;Lorg/simpleframework/xml/core/Label;Lorg/simpleframework/xml/core/Label;Z)V

    return-object v0
.end method

.method public commit(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 511
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    if-nez v0, :cond_0

    .line 512
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->resolver:Lorg/simpleframework/xml/core/InstantiatorBuilder;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/InstantiatorBuilder;->build()Lorg/simpleframework/xml/core/Instantiator;

    move-result-object v0

    iput-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->factory:Lorg/simpleframework/xml/core/Instantiator;

    .line 514
    :cond_0
    return-void
.end method

.method public process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;)V
    .locals 1
    .param p1, "field"    # Lorg/simpleframework/xml/core/Contact;
    .param p2, "label"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 178
    instance-of v0, p2, Lorg/simpleframework/xml/Attribute;

    if-eqz v0, :cond_0

    .line 179
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 181
    :cond_0
    instance-of v0, p2, Lorg/simpleframework/xml/ElementUnion;

    if-eqz v0, :cond_1

    .line 182
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->union(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 184
    :cond_1
    instance-of v0, p2, Lorg/simpleframework/xml/ElementListUnion;

    if-eqz v0, :cond_2

    .line 185
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->union(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 187
    :cond_2
    instance-of v0, p2, Lorg/simpleframework/xml/ElementMapUnion;

    if-eqz v0, :cond_3

    .line 188
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->union(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 190
    :cond_3
    instance-of v0, p2, Lorg/simpleframework/xml/ElementList;

    if-eqz v0, :cond_4

    .line 191
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 193
    :cond_4
    instance-of v0, p2, Lorg/simpleframework/xml/ElementArray;

    if-eqz v0, :cond_5

    .line 194
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 196
    :cond_5
    instance-of v0, p2, Lorg/simpleframework/xml/ElementMap;

    if-eqz v0, :cond_6

    .line 197
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 199
    :cond_6
    instance-of v0, p2, Lorg/simpleframework/xml/Element;

    if-eqz v0, :cond_7

    .line 200
    iget-object v0, p0, Lorg/simpleframework/xml/core/StructureBuilder;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {p0, p1, p2, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->process(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/core/LabelMap;)V

    .line 202
    :cond_7
    instance-of v0, p2, Lorg/simpleframework/xml/Version;

    if-eqz v0, :cond_8

    .line 203
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/StructureBuilder;->version(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;)V

    .line 205
    :cond_8
    instance-of v0, p2, Lorg/simpleframework/xml/Text;

    if-eqz v0, :cond_9

    .line 206
    invoke-direct {p0, p1, p2}, Lorg/simpleframework/xml/core/StructureBuilder;->text(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;)V

    .line 208
    :cond_9
    return-void
.end method

.method public validate(Ljava/lang/Class;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 524
    iget-object v1, p0, Lorg/simpleframework/xml/core/StructureBuilder;->scanner:Lorg/simpleframework/xml/core/Scanner;

    invoke-interface {v1}, Lorg/simpleframework/xml/core/Scanner;->getOrder()Lorg/simpleframework/xml/Order;

    move-result-object v0

    .line 526
    .local v0, "order":Lorg/simpleframework/xml/Order;
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/StructureBuilder;->validateUnions(Ljava/lang/Class;)V

    .line 527
    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->validateElements(Ljava/lang/Class;Lorg/simpleframework/xml/Order;)V

    .line 528
    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/core/StructureBuilder;->validateAttributes(Ljava/lang/Class;Lorg/simpleframework/xml/Order;)V

    .line 529
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/StructureBuilder;->validateModel(Ljava/lang/Class;)V

    .line 530
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/StructureBuilder;->validateText(Ljava/lang/Class;)V

    .line 531
    return-void
.end method
