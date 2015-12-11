.class Lorg/simpleframework/xml/core/TreeModel;
.super Ljava/lang/Object;
.source "TreeModel.java"

# interfaces
.implements Lorg/simpleframework/xml/core/Model;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/simpleframework/xml/core/TreeModel$OrderList;
    }
.end annotation


# instance fields
.field private attributes:Lorg/simpleframework/xml/core/LabelMap;

.field private elements:Lorg/simpleframework/xml/core/LabelMap;

.field private expression:Lorg/simpleframework/xml/core/Expression;

.field private index:I

.field private models:Lorg/simpleframework/xml/core/ModelMap;

.field private name:Ljava/lang/String;

.field private order:Lorg/simpleframework/xml/core/TreeModel$OrderList;

.field private policy:Lorg/simpleframework/xml/core/Policy;

.field private prefix:Ljava/lang/String;

.field private text:Lorg/simpleframework/xml/core/Label;

.field private type:Ljava/lang/Class;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/Policy;Ljava/lang/Class;)V
    .locals 6
    .param p1, "policy"    # Lorg/simpleframework/xml/core/Policy;
    .param p2, "type"    # Ljava/lang/Class;

    .prologue
    const/4 v3, 0x0

    .line 106
    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, v3

    invoke-direct/range {v0 .. v5}, Lorg/simpleframework/xml/core/TreeModel;-><init>(Lorg/simpleframework/xml/core/Policy;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V

    .line 107
    return-void
.end method

.method public constructor <init>(Lorg/simpleframework/xml/core/Policy;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1
    .param p1, "policy"    # Lorg/simpleframework/xml/core/Policy;
    .param p2, "type"    # Ljava/lang/Class;
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "prefix"    # Ljava/lang/String;
    .param p5, "index"    # I

    .prologue
    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 121
    new-instance v0, Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/LabelMap;-><init>(Lorg/simpleframework/xml/core/Policy;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    .line 122
    new-instance v0, Lorg/simpleframework/xml/core/LabelMap;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/LabelMap;-><init>(Lorg/simpleframework/xml/core/Policy;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    .line 123
    new-instance v0, Lorg/simpleframework/xml/core/ModelMap;

    invoke-direct {v0, p2}, Lorg/simpleframework/xml/core/ModelMap;-><init>(Ljava/lang/Class;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    .line 124
    new-instance v0, Lorg/simpleframework/xml/core/TreeModel$OrderList;

    invoke-direct {v0}, Lorg/simpleframework/xml/core/TreeModel$OrderList;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->order:Lorg/simpleframework/xml/core/TreeModel$OrderList;

    .line 125
    iput-object p1, p0, Lorg/simpleframework/xml/core/TreeModel;->policy:Lorg/simpleframework/xml/core/Policy;

    .line 126
    iput-object p4, p0, Lorg/simpleframework/xml/core/TreeModel;->prefix:Ljava/lang/String;

    .line 127
    iput p5, p0, Lorg/simpleframework/xml/core/TreeModel;->index:I

    .line 128
    iput-object p3, p0, Lorg/simpleframework/xml/core/TreeModel;->name:Ljava/lang/String;

    .line 129
    iput-object p2, p0, Lorg/simpleframework/xml/core/TreeModel;->type:Ljava/lang/Class;

    .line 130
    return-void
.end method

.method private create(Ljava/lang/String;Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "prefix"    # Ljava/lang/String;
    .param p3, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 573
    new-instance v0, Lorg/simpleframework/xml/core/TreeModel;

    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->policy:Lorg/simpleframework/xml/core/Policy;

    iget-object v2, p0, Lorg/simpleframework/xml/core/TreeModel;->type:Ljava/lang/Class;

    move-object v3, p1

    move-object v4, p2

    move v5, p3

    invoke-direct/range {v0 .. v5}, Lorg/simpleframework/xml/core/TreeModel;-><init>(Lorg/simpleframework/xml/core/Policy;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V

    .line 575
    .local v0, "model":Lorg/simpleframework/xml/core/Model;
    if-eqz p1, :cond_0

    .line 576
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v1, p1, v0}, Lorg/simpleframework/xml/core/ModelMap;->register(Ljava/lang/String;Lorg/simpleframework/xml/core/Model;)V

    .line 577
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->order:Lorg/simpleframework/xml/core/TreeModel$OrderList;

    invoke-virtual {v1, p1}, Lorg/simpleframework/xml/core/TreeModel$OrderList;->add(Ljava/lang/Object;)Z

    .line 579
    :cond_0
    return-object v0
.end method

.method private validateAttributes(Ljava/lang/Class;)V
    .locals 8
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 463
    iget-object v4, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v4}, Lorg/simpleframework/xml/core/LabelMap;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 465
    .local v1, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 466
    .local v3, "name":Ljava/lang/String;
    iget-object v4, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v4, v3}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/simpleframework/xml/core/Label;

    .line 468
    .local v2, "label":Lorg/simpleframework/xml/core/Label;
    if-nez v2, :cond_1

    .line 469
    new-instance v4, Lorg/simpleframework/xml/core/AttributeException;

    const-string v5, "Ordered attribute \'%s\' does not exist in %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v3, v6, v7

    const/4 v7, 0x1

    aput-object p1, v6, v7

    invoke-direct {v4, v5, v6}, Lorg/simpleframework/xml/core/AttributeException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v4

    .line 471
    :cond_1
    iget-object v4, p0, Lorg/simpleframework/xml/core/TreeModel;->expression:Lorg/simpleframework/xml/core/Expression;

    if-eqz v4, :cond_0

    .line 472
    iget-object v4, p0, Lorg/simpleframework/xml/core/TreeModel;->expression:Lorg/simpleframework/xml/core/Expression;

    invoke-interface {v4, v3}, Lorg/simpleframework/xml/core/Expression;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 475
    .end local v2    # "label":Lorg/simpleframework/xml/core/Label;
    .end local v3    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method private validateElements(Ljava/lang/Class;)V
    .locals 10
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v7, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 486
    iget-object v5, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v5}, Lorg/simpleframework/xml/core/LabelMap;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 488
    .local v1, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 489
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v5, v4}, Lorg/simpleframework/xml/core/ModelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/simpleframework/xml/core/ModelList;

    .line 490
    .local v3, "list":Lorg/simpleframework/xml/core/ModelList;
    iget-object v5, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v5, v4}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/simpleframework/xml/core/Label;

    .line 492
    .local v2, "label":Lorg/simpleframework/xml/core/Label;
    if-nez v3, :cond_1

    if-nez v2, :cond_1

    .line 493
    new-instance v5, Lorg/simpleframework/xml/core/ElementException;

    const-string v6, "Ordered element \'%s\' does not exist in %s"

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v4, v7, v8

    aput-object p1, v7, v9

    invoke-direct {v5, v6, v7}, Lorg/simpleframework/xml/core/ElementException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v5

    .line 495
    :cond_1
    if-eqz v3, :cond_2

    if-eqz v2, :cond_2

    .line 496
    invoke-virtual {v3}, Lorg/simpleframework/xml/core/ModelList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_2

    .line 497
    new-instance v5, Lorg/simpleframework/xml/core/ElementException;

    const-string v6, "Element \'%s\' is also a path name in %s"

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v4, v7, v8

    aput-object p1, v7, v9

    invoke-direct {v5, v6, v7}, Lorg/simpleframework/xml/core/ElementException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v5

    .line 500
    :cond_2
    iget-object v5, p0, Lorg/simpleframework/xml/core/TreeModel;->expression:Lorg/simpleframework/xml/core/Expression;

    if-eqz v5, :cond_0

    .line 501
    iget-object v5, p0, Lorg/simpleframework/xml/core/TreeModel;->expression:Lorg/simpleframework/xml/core/Expression;

    invoke-interface {v5, v4}, Lorg/simpleframework/xml/core/Expression;->getElement(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 504
    .end local v2    # "label":Lorg/simpleframework/xml/core/Label;
    .end local v3    # "list":Lorg/simpleframework/xml/core/ModelList;
    .end local v4    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method private validateExpression(Lorg/simpleframework/xml/core/Label;)V
    .locals 8
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 409
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getExpression()Lorg/simpleframework/xml/core/Expression;

    move-result-object v1

    .line 411
    .local v1, "location":Lorg/simpleframework/xml/core/Expression;
    iget-object v3, p0, Lorg/simpleframework/xml/core/TreeModel;->expression:Lorg/simpleframework/xml/core/Expression;

    if-eqz v3, :cond_0

    .line 412
    iget-object v3, p0, Lorg/simpleframework/xml/core/TreeModel;->expression:Lorg/simpleframework/xml/core/Expression;

    invoke-interface {v3}, Lorg/simpleframework/xml/core/Expression;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 413
    .local v2, "path":Ljava/lang/String;
    invoke-interface {v1}, Lorg/simpleframework/xml/core/Expression;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 415
    .local v0, "expect":Ljava/lang/String;
    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 416
    new-instance v3, Lorg/simpleframework/xml/core/PathException;

    const-string v4, "Path \'%s\' does not match \'%s\' in %s"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v2, v5, v6

    const/4 v6, 0x1

    aput-object v0, v5, v6

    const/4 v6, 0x2

    iget-object v7, p0, Lorg/simpleframework/xml/core/TreeModel;->type:Ljava/lang/Class;

    aput-object v7, v5, v6

    invoke-direct {v3, v4, v5}, Lorg/simpleframework/xml/core/PathException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3

    .line 419
    .end local v0    # "expect":Ljava/lang/String;
    .end local v2    # "path":Ljava/lang/String;
    :cond_0
    iput-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->expression:Lorg/simpleframework/xml/core/Expression;

    .line 421
    :cond_1
    return-void
.end method

.method private validateExpressions(Ljava/lang/Class;)V
    .locals 3
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 384
    iget-object v2, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v2}, Lorg/simpleframework/xml/core/LabelMap;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Label;

    .line 385
    .local v1, "label":Lorg/simpleframework/xml/core/Label;
    if-eqz v1, :cond_0

    .line 386
    invoke-direct {p0, v1}, Lorg/simpleframework/xml/core/TreeModel;->validateExpression(Lorg/simpleframework/xml/core/Label;)V

    goto :goto_0

    .line 389
    .end local v1    # "label":Lorg/simpleframework/xml/core/Label;
    :cond_1
    iget-object v2, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v2}, Lorg/simpleframework/xml/core/LabelMap;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Label;

    .line 390
    .restart local v1    # "label":Lorg/simpleframework/xml/core/Label;
    if-eqz v1, :cond_2

    .line 391
    invoke-direct {p0, v1}, Lorg/simpleframework/xml/core/TreeModel;->validateExpression(Lorg/simpleframework/xml/core/Label;)V

    goto :goto_1

    .line 394
    .end local v1    # "label":Lorg/simpleframework/xml/core/Label;
    :cond_3
    iget-object v2, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    if-eqz v2, :cond_4

    .line 395
    iget-object v2, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    invoke-direct {p0, v2}, Lorg/simpleframework/xml/core/TreeModel;->validateExpression(Lorg/simpleframework/xml/core/Label;)V

    .line 397
    :cond_4
    return-void
.end method

.method private validateModels(Ljava/lang/Class;)V
    .locals 13
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 437
    iget-object v8, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v8}, Lorg/simpleframework/xml/core/ModelMap;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/simpleframework/xml/core/ModelList;

    .line 438
    .local v5, "list":Lorg/simpleframework/xml/core/ModelList;
    const/4 v0, 0x1

    .line 440
    .local v0, "count":I
    invoke-virtual {v5}, Lorg/simpleframework/xml/core/ModelList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lorg/simpleframework/xml/core/Model;

    .line 441
    .local v6, "model":Lorg/simpleframework/xml/core/Model;
    if-eqz v6, :cond_1

    .line 442
    invoke-interface {v6}, Lorg/simpleframework/xml/core/Model;->getName()Ljava/lang/String;

    move-result-object v7

    .line 443
    .local v7, "name":Ljava/lang/String;
    invoke-interface {v6}, Lorg/simpleframework/xml/core/Model;->getIndex()I

    move-result v4

    .line 445
    .local v4, "index":I
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "count":I
    .local v1, "count":I
    if-eq v4, v0, :cond_2

    .line 446
    new-instance v8, Lorg/simpleframework/xml/core/ElementException;

    const-string v9, "Path section \'%s[%s]\' is out of sequence in %s"

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v7, v10, v11

    const/4 v11, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    aput-object p1, v10, v11

    invoke-direct {v8, v9, v10}, Lorg/simpleframework/xml/core/ElementException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v8

    .line 448
    :cond_2
    invoke-interface {v6, p1}, Lorg/simpleframework/xml/core/Model;->validate(Ljava/lang/Class;)V

    move v0, v1

    .end local v1    # "count":I
    .restart local v0    # "count":I
    goto :goto_0

    .line 452
    .end local v0    # "count":I
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "index":I
    .end local v5    # "list":Lorg/simpleframework/xml/core/ModelList;
    .end local v6    # "model":Lorg/simpleframework/xml/core/Model;
    .end local v7    # "name":Ljava/lang/String;
    :cond_3
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

    .line 364
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    if-eqz v0, :cond_1

    .line 365
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/LabelMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 366
    new-instance v0, Lorg/simpleframework/xml/core/TextException;

    const-string v1, "Text annotation %s used with elements in %s"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    aput-object v3, v2, v4

    aput-object p1, v2, v5

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/TextException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v0

    .line 368
    :cond_0
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/TreeModel;->isComposite()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 369
    new-instance v0, Lorg/simpleframework/xml/core/TextException;

    const-string v1, "Text annotation %s can not be used with paths in %s"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    aput-object v3, v2, v4

    aput-object p1, v2, v5

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/TextException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v0

    .line 372
    :cond_1
    return-void
.end method


# virtual methods
.method public getAttributes()Lorg/simpleframework/xml/core/LabelMap;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 264
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/LabelMap;->getLabels()Lorg/simpleframework/xml/core/LabelMap;

    move-result-object v0

    return-object v0
.end method

.method public getElements()Lorg/simpleframework/xml/core/LabelMap;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 277
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/LabelMap;->getLabels()Lorg/simpleframework/xml/core/LabelMap;

    move-result-object v0

    return-object v0
.end method

.method public getExpression()Lorg/simpleframework/xml/core/Expression;
    .locals 1

    .prologue
    .line 644
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->expression:Lorg/simpleframework/xml/core/Expression;

    return-object v0
.end method

.method public getIndex()I
    .locals 1

    .prologue
    .line 679
    iget v0, p0, Lorg/simpleframework/xml/core/TreeModel;->index:I

    return v0
.end method

.method public getModels()Lorg/simpleframework/xml/core/ModelMap;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 251
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/ModelMap;->getModels()Lorg/simpleframework/xml/core/ModelMap;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 667
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 656
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->prefix:Ljava/lang/String;

    return-object v0
.end method

.method public getText()Lorg/simpleframework/xml/core/Label;
    .locals 1

    .prologue
    .line 633
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    return-object v0
.end method

.method public isAttribute(Ljava/lang/String;)Z
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 316
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/LabelMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isComposite()Z
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 591
    iget-object v5, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v5}, Lorg/simpleframework/xml/core/ModelMap;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/simpleframework/xml/core/ModelList;

    .line 592
    .local v2, "list":Lorg/simpleframework/xml/core/ModelList;
    invoke-virtual {v2}, Lorg/simpleframework/xml/core/ModelList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/simpleframework/xml/core/Model;

    .line 593
    .local v3, "model":Lorg/simpleframework/xml/core/Model;
    if-eqz v3, :cond_1

    .line 594
    invoke-interface {v3}, Lorg/simpleframework/xml/core/Model;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_1

    .line 600
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "list":Lorg/simpleframework/xml/core/ModelList;
    .end local v3    # "model":Lorg/simpleframework/xml/core/Model;
    :cond_2
    :goto_0
    return v4

    :cond_3
    iget-object v5, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v5}, Lorg/simpleframework/xml/core/ModelMap;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v4, 0x0

    goto :goto_0
.end method

.method public isElement(Ljava/lang/String;)Z
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 303
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/LabelMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 612
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    if-eqz v1, :cond_1

    .line 621
    :cond_0
    :goto_0
    return v0

    .line 615
    :cond_1
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v1}, Lorg/simpleframework/xml/core/LabelMap;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 618
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v1}, Lorg/simpleframework/xml/core/LabelMap;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 621
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/TreeModel;->isComposite()Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public isModel(Ljava/lang/String;)Z
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 290
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/ModelMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 329
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 331
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lorg/simpleframework/xml/core/TreeModel;->order:Lorg/simpleframework/xml/core/TreeModel$OrderList;

    invoke-virtual {v3}, Lorg/simpleframework/xml/core/TreeModel$OrderList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 332
    .local v2, "name":Ljava/lang/String;
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 334
    .end local v2    # "name":Ljava/lang/String;
    :cond_0
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    return-object v3
.end method

.method public lookup(Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "index"    # I

    .prologue
    .line 536
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v0, p1, p2}, Lorg/simpleframework/xml/core/ModelMap;->lookup(Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;

    move-result-object v0

    return-object v0
.end method

.method public lookup(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;
    .locals 5
    .param p1, "path"    # Lorg/simpleframework/xml/core/Expression;

    .prologue
    .line 143
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Expression;->getFirst()Ljava/lang/String;

    move-result-object v2

    .line 144
    .local v2, "name":Ljava/lang/String;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Expression;->getIndex()I

    move-result v0

    .line 145
    .local v0, "index":I
    invoke-virtual {p0, v2, v0}, Lorg/simpleframework/xml/core/TreeModel;->lookup(Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;

    move-result-object v1

    .line 147
    .local v1, "model":Lorg/simpleframework/xml/core/Model;
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Expression;->isPath()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 148
    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-interface {p1, v3, v4}, Lorg/simpleframework/xml/core/Expression;->getPath(II)Lorg/simpleframework/xml/core/Expression;

    move-result-object p1

    .line 150
    if-eqz v1, :cond_0

    .line 151
    invoke-interface {v1, p1}, Lorg/simpleframework/xml/core/Model;->lookup(Lorg/simpleframework/xml/core/Expression;)Lorg/simpleframework/xml/core/Model;

    move-result-object v1

    .line 154
    .end local v1    # "model":Lorg/simpleframework/xml/core/Model;
    :cond_0
    return-object v1
.end method

.method public register(Ljava/lang/String;Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "prefix"    # Ljava/lang/String;
    .param p3, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 552
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->models:Lorg/simpleframework/xml/core/ModelMap;

    invoke-virtual {v1, p1, p3}, Lorg/simpleframework/xml/core/ModelMap;->lookup(Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;

    move-result-object v0

    .line 554
    .local v0, "model":Lorg/simpleframework/xml/core/Model;
    if-nez v0, :cond_0

    .line 555
    invoke-direct {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/TreeModel;->create(Ljava/lang/String;Ljava/lang/String;I)Lorg/simpleframework/xml/core/Model;

    move-result-object v0

    .line 557
    .end local v0    # "model":Lorg/simpleframework/xml/core/Model;
    :cond_0
    return-object v0
.end method

.method public register(Lorg/simpleframework/xml/core/Label;)V
    .locals 1
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 516
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isAttribute()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 517
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/core/TreeModel;->registerAttribute(Lorg/simpleframework/xml/core/Label;)V

    .line 523
    :goto_0
    return-void

    .line 518
    :cond_0
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->isText()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 519
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/core/TreeModel;->registerText(Lorg/simpleframework/xml/core/Label;)V

    goto :goto_0

    .line 521
    :cond_1
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/core/TreeModel;->registerElement(Lorg/simpleframework/xml/core/Label;)V

    goto :goto_0
.end method

.method public registerAttribute(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 183
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    return-void
.end method

.method public registerAttribute(Lorg/simpleframework/xml/core/Label;)V
    .locals 5
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 212
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getName()Ljava/lang/String;

    move-result-object v0

    .line 214
    .local v0, "name":Ljava/lang/String;
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v1, v0}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 215
    new-instance v1, Lorg/simpleframework/xml/core/AttributeException;

    const-string v2, "Duplicate annotation of name \'%s\' on %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    invoke-direct {v1, v2, v3}, Lorg/simpleframework/xml/core/AttributeException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v1

    .line 217
    :cond_0
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->attributes:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v1, v0, p1}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    return-void
.end method

.method public registerElement(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 167
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->order:Lorg/simpleframework/xml/core/TreeModel$OrderList;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/TreeModel$OrderList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 168
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->order:Lorg/simpleframework/xml/core/TreeModel$OrderList;

    invoke-virtual {v0, p1}, Lorg/simpleframework/xml/core/TreeModel$OrderList;->add(Ljava/lang/Object;)Z

    .line 170
    :cond_0
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    return-void
.end method

.method public registerElement(Lorg/simpleframework/xml/core/Label;)V
    .locals 5
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 230
    invoke-interface {p1}, Lorg/simpleframework/xml/core/Label;->getName()Ljava/lang/String;

    move-result-object v0

    .line 232
    .local v0, "name":Ljava/lang/String;
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v1, v0}, Lorg/simpleframework/xml/core/LabelMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 233
    new-instance v1, Lorg/simpleframework/xml/core/ElementException;

    const-string v2, "Duplicate annotation of name \'%s\' on %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    invoke-direct {v1, v2, v3}, Lorg/simpleframework/xml/core/ElementException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v1

    .line 235
    :cond_0
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->order:Lorg/simpleframework/xml/core/TreeModel$OrderList;

    invoke-virtual {v1, v0}, Lorg/simpleframework/xml/core/TreeModel$OrderList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 236
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->order:Lorg/simpleframework/xml/core/TreeModel$OrderList;

    invoke-virtual {v1, v0}, Lorg/simpleframework/xml/core/TreeModel$OrderList;->add(Ljava/lang/Object;)Z

    .line 238
    :cond_1
    iget-object v1, p0, Lorg/simpleframework/xml/core/TreeModel;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v1, v0, p1}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    return-void
.end method

.method public registerText(Lorg/simpleframework/xml/core/Label;)V
    .locals 4
    .param p1, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 196
    iget-object v0, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    if-eqz v0, :cond_0

    .line 197
    new-instance v0, Lorg/simpleframework/xml/core/TextException;

    const-string v1, "Duplicate text annotation on %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/TextException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v0

    .line 199
    :cond_0
    iput-object p1, p0, Lorg/simpleframework/xml/core/TreeModel;->text:Lorg/simpleframework/xml/core/Label;

    .line 200
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 690
    const-string v0, "model \'%s[%s]\'"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lorg/simpleframework/xml/core/TreeModel;->name:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget v3, p0, Lorg/simpleframework/xml/core/TreeModel;->index:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public validate(Ljava/lang/Class;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 348
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/TreeModel;->validateExpressions(Ljava/lang/Class;)V

    .line 349
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/TreeModel;->validateAttributes(Ljava/lang/Class;)V

    .line 350
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/TreeModel;->validateElements(Ljava/lang/Class;)V

    .line 351
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/TreeModel;->validateModels(Ljava/lang/Class;)V

    .line 352
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/TreeModel;->validateText(Ljava/lang/Class;)V

    .line 353
    return-void
.end method
