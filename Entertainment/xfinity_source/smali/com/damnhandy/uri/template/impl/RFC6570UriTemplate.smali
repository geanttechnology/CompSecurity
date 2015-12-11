.class public final Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;
.super Lcom/damnhandy/uri/template/UriTemplate;
.source "RFC6570UriTemplate.java"


# static fields
.field private static final URI_TEMPLATE_REGEX:Ljava/util/regex/Pattern;

.field static final VARNAME_REGEX:Ljava/util/regex/Pattern;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-string v0, "\\{[^{}]+\\}"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->URI_TEMPLATE_REGEX:Ljava/util/regex/Pattern;

    .line 37
    const-string v0, "([\\w\\_\\.]|%[A-Fa-f0-9]{2})+"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->VARNAME_REGEX:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "template"    # Ljava/lang/String;

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/damnhandy/uri/template/UriTemplate;-><init>()V

    .line 46
    invoke-virtual {p0, p1}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->setTemplate(Ljava/lang/String;)V

    .line 47
    return-void
.end method

.method private arrayToList(Ljava/lang/Object;)Ljava/util/List;
    .locals 6
    .param p1, "array"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 550
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 551
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    invoke-static {p1}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result v2

    .line 552
    .local v2, "length":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_1

    .line 554
    invoke-static {p1, v1}, Ljava/lang/reflect/Array;->get(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v0

    .line 555
    .local v0, "element":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->isArray()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 557
    new-instance v4, Lcom/damnhandy/uri/template/impl/VariableExpansionException;

    const-string v5, "Multi-dimenesional arrays are not supported."

    invoke-direct {v4, v5}, Lcom/damnhandy/uri/template/impl/VariableExpansionException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 559
    :cond_0
    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 552
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 561
    .end local v0    # "element":Ljava/lang/Object;
    :cond_1
    return-object v3
.end method

.method private buildVarSpecs(Ljava/lang/String;)Ljava/lang/String;
    .locals 16
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 478
    sget-object v6, Lcom/damnhandy/uri/template/impl/Operator;->NUL:Lcom/damnhandy/uri/template/impl/Operator;

    .line 479
    .local v6, "operator":Lcom/damnhandy/uri/template/impl/Operator;
    const/4 v13, 0x0

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v13, v14}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 480
    .local v3, "firstChar":Ljava/lang/String;
    invoke-static {v3}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->containsOperator(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_0

    .line 482
    invoke-static {v3}, Lcom/damnhandy/uri/template/impl/Operator;->fromOpCode(Ljava/lang/String;)Lcom/damnhandy/uri/template/impl/Operator;

    move-result-object v6

    .line 483
    const/4 v13, 0x1

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v13, v14}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 486
    :cond_0
    const-string v13, ","

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 487
    .local v11, "varspecStrings":[Ljava/lang/String;
    new-instance v12, Ljava/util/ArrayList;

    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    .line 489
    .local v12, "varspecs":Ljava/util/List;, "Ljava/util/List<Lcom/damnhandy/uri/template/impl/VarSpec;>;"
    move-object v1, v11

    .local v1, "arr$":[Ljava/lang/String;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_3

    aget-object v10, v1, v4

    .line 491
    .local v10, "varname":Ljava/lang/String;
    sget-object v13, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-virtual {v13}, Lcom/damnhandy/uri/template/impl/Modifier;->getValue()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v10, v13}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v9

    .line 495
    .local v9, "subStrPos":I
    if-lez v9, :cond_1

    .line 497
    sget-object v13, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-virtual {v13}, Lcom/damnhandy/uri/template/impl/Modifier;->getValue()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v10, v13}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 500
    .local v7, "pair":[Ljava/lang/String;
    const/4 v13, 0x0

    :try_start_0
    aget-object v13, v7, v13

    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->validateVarname(Ljava/lang/String;)V

    .line 501
    add-int/lit8 v13, v9, 0x1

    invoke-virtual {v10, v13}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v8

    .line 502
    .local v8, "pos":Ljava/lang/Integer;
    new-instance v13, Lcom/damnhandy/uri/template/impl/VarSpec;

    const/4 v14, 0x0

    aget-object v14, v7, v14

    sget-object v15, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-direct {v13, v14, v15, v8}, Lcom/damnhandy/uri/template/impl/VarSpec;-><init>(Ljava/lang/String;Lcom/damnhandy/uri/template/impl/Modifier;Ljava/lang/Integer;)V

    invoke-interface {v12, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 489
    .end local v7    # "pair":[Ljava/lang/String;
    .end local v8    # "pos":Ljava/lang/Integer;
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 504
    .restart local v7    # "pair":[Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 506
    .local v2, "e":Ljava/lang/NumberFormatException;
    new-instance v13, Lcom/damnhandy/uri/template/impl/ExpressionParseException;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "The prefix value for "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const/4 v15, 0x0

    aget-object v15, v7, v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " was not a number"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-direct {v13, v14, v2}, Lcom/damnhandy/uri/template/impl/ExpressionParseException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v13

    .line 513
    .end local v2    # "e":Ljava/lang/NumberFormatException;
    .end local v7    # "pair":[Ljava/lang/String;
    :cond_1
    sget-object v13, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-virtual {v13}, Lcom/damnhandy/uri/template/impl/Modifier;->getValue()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v10, v13}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v13

    if-lez v13, :cond_2

    .line 515
    const/4 v13, 0x0

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v14

    add-int/lit8 v14, v14, -0x1

    invoke-virtual {v10, v13, v14}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->validateVarname(Ljava/lang/String;)V

    .line 516
    new-instance v13, Lcom/damnhandy/uri/template/impl/VarSpec;

    sget-object v14, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-direct {v13, v10, v14}, Lcom/damnhandy/uri/template/impl/VarSpec;-><init>(Ljava/lang/String;Lcom/damnhandy/uri/template/impl/Modifier;)V

    invoke-interface {v12, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 523
    :cond_2
    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->validateVarname(Ljava/lang/String;)V

    .line 524
    new-instance v13, Lcom/damnhandy/uri/template/impl/VarSpec;

    sget-object v14, Lcom/damnhandy/uri/template/impl/Modifier;->NONE:Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-direct {v13, v10, v14}, Lcom/damnhandy/uri/template/impl/VarSpec;-><init>(Ljava/lang/String;Lcom/damnhandy/uri/template/impl/Modifier;)V

    invoke-interface {v12, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 527
    .end local v9    # "subStrPos":I
    .end local v10    # "varname":Ljava/lang/String;
    :cond_3
    move-object/from16 v0, p0

    invoke-direct {v0, v6, v12}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->findExpressions(Lcom/damnhandy/uri/template/impl/Operator;Ljava/util/List;)Ljava/lang/String;

    move-result-object v13

    return-object v13
.end method

.method private checkValue(Ljava/lang/Object;)V
    .locals 2
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 326
    instance-of v0, p1, Ljava/util/Collection;

    if-nez v0, :cond_0

    instance-of v0, p1, Ljava/util/Map;

    if-nez v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 328
    :cond_0
    new-instance v0, Lcom/damnhandy/uri/template/impl/VariableExpansionException;

    const-string v1, "Nested data structures are not supported."

    invoke-direct {v0, v1}, Lcom/damnhandy/uri/template/impl/VariableExpansionException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 330
    :cond_1
    return-void
.end method

.method private expandCollection(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/util/Collection;)Ljava/lang/String;
    .locals 8
    .param p1, "operator"    # Lcom/damnhandy/uri/template/impl/Operator;
    .param p2, "varSpec"    # Lcom/damnhandy/uri/template/impl/VarSpec;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/damnhandy/uri/template/impl/Operator;",
            "Lcom/damnhandy/uri/template/impl/VarSpec;",
            "Ljava/util/Collection",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 293
    .local p3, "variable":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 294
    .local v3, "stringValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 295
    .local v0, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getSeparator()Ljava/lang/String;

    move-result-object v2

    .line 296
    .local v2, "separator":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v6

    sget-object v7, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    if-eq v6, v7, :cond_0

    .line 298
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getListSeparator()Ljava/lang/String;

    move-result-object v2

    .line 300
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 302
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 303
    .local v1, "obj":Ljava/lang/Object;
    invoke-direct {p0, v1}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->checkValue(Ljava/lang/Object;)V

    .line 304
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 305
    .local v4, "value":Ljava/lang/String;
    sget-object v6, Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;->ARRAY:Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;

    invoke-direct {p0, p1, p2, v4, v6}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandStringValue(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/lang/String;Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 308
    .end local v1    # "obj":Ljava/lang/Object;
    .end local v4    # "value":Ljava/lang/String;
    :cond_1
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v6

    sget-object v7, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    if-eq v6, v7, :cond_3

    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->useVarNameWhenExploded()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 310
    invoke-direct {p0, v2, v3}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->joinParts(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object v5

    .line 311
    .local v5, "values":Ljava/lang/String;
    sget-object v6, Lcom/damnhandy/uri/template/impl/Operator;->QUERY:Lcom/damnhandy/uri/template/impl/Operator;

    if-ne p1, v6, :cond_2

    if-nez v5, :cond_2

    .line 313
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getVariableName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 317
    .end local v5    # "values":Ljava/lang/String;
    :goto_1
    return-object v6

    .line 315
    .restart local v5    # "values":Ljava/lang/String;
    :cond_2
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getVariableName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 317
    .end local v5    # "values":Ljava/lang/String;
    :cond_3
    invoke-direct {p0, v2, v3}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->joinParts(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object v6

    goto :goto_1
.end method

.method private expandMap(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/util/Map;)Ljava/lang/String;
    .locals 11
    .param p1, "operator"    # Lcom/damnhandy/uri/template/impl/Operator;
    .param p2, "varSpec"    # Lcom/damnhandy/uri/template/impl/VarSpec;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/damnhandy/uri/template/impl/Operator;",
            "Lcom/damnhandy/uri/template/impl/VarSpec;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 342
    .local p3, "variable":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 343
    .local v7, "stringValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v6, "="

    .line 344
    .local v6, "pairJoiner":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v8

    sget-object v9, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    if-eq v8, v9, :cond_0

    .line 346
    const-string v6, ","

    .line 348
    :cond_0
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getSeparator()Ljava/lang/String;

    move-result-object v3

    .line 349
    .local v3, "joiner":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v8

    sget-object v9, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    if-eq v8, v9, :cond_1

    .line 351
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getListSeparator()Ljava/lang/String;

    move-result-object v3

    .line 353
    :cond_1
    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 356
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 357
    .local v4, "key":Ljava/lang/String;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    invoke-direct {p0, v8}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->checkValue(Ljava/lang/Object;)V

    .line 358
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v9, Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;->PAIRS:Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;

    invoke-direct {p0, p1, p2, v4, v9}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandStringValue(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/lang/String;Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    sget-object v10, Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;->PAIRS:Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;

    invoke-direct {p0, p1, p2, v9, v10}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandStringValue(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/lang/String;Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 361
    .local v5, "pair":Ljava/lang/String;
    invoke-interface {v7, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 364
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v4    # "key":Ljava/lang/String;
    .end local v5    # "pair":Ljava/lang/String;
    :cond_2
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v8

    sget-object v9, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    if-eq v8, v9, :cond_5

    sget-object v8, Lcom/damnhandy/uri/template/impl/Operator;->MATRIX:Lcom/damnhandy/uri/template/impl/Operator;

    if-eq p1, v8, :cond_3

    sget-object v8, Lcom/damnhandy/uri/template/impl/Operator;->QUERY:Lcom/damnhandy/uri/template/impl/Operator;

    if-eq p1, v8, :cond_3

    sget-object v8, Lcom/damnhandy/uri/template/impl/Operator;->CONTINUATION:Lcom/damnhandy/uri/template/impl/Operator;

    if-ne p1, v8, :cond_5

    .line 367
    :cond_3
    invoke-direct {p0, v3, v7}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->joinParts(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object v2

    .line 368
    .local v2, "joinedValues":Ljava/lang/String;
    sget-object v8, Lcom/damnhandy/uri/template/impl/Operator;->QUERY:Lcom/damnhandy/uri/template/impl/Operator;

    if-ne p1, v8, :cond_4

    if-nez v2, :cond_4

    .line 370
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getVariableName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 375
    .end local v2    # "joinedValues":Ljava/lang/String;
    :goto_1
    return-object v8

    .line 372
    .restart local v2    # "joinedValues":Ljava/lang/String;
    :cond_4
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getVariableName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    goto :goto_1

    .line 375
    .end local v2    # "joinedValues":Ljava/lang/String;
    :cond_5
    invoke-direct {p0, v3, v7}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->joinParts(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object v8

    goto :goto_1
.end method

.method private expandStringValue(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/lang/String;Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;)Ljava/lang/String;
    .locals 4
    .param p1, "operator"    # Lcom/damnhandy/uri/template/impl/Operator;
    .param p2, "varSpec"    # Lcom/damnhandy/uri/template/impl/VarSpec;
    .param p3, "variable"    # Ljava/lang/String;
    .param p4, "format"    # Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;

    .prologue
    .line 389
    const-string v0, ""

    .line 391
    .local v0, "expanded":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v2

    sget-object v3, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    if-ne v2, v3, :cond_0

    .line 393
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getPosition()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 394
    .local v1, "position":I
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 396
    const/4 v2, 0x0

    invoke-virtual {p3, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p3

    .line 400
    .end local v1    # "position":I
    :cond_0
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getEncoding()Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move-result-object v2

    sget-object v3, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->UR:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    if-ne v2, v3, :cond_2

    .line 401
    invoke-static {p3}, Lcom/damnhandy/uri/template/UriUtil;->encodeReserved(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 408
    :goto_0
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->isNamed()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 410
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getSeparator()Ljava/lang/String;

    move-result-object v2

    const-string v3, "&"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 412
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getValue()Ljava/lang/String;

    move-result-object v0

    .line 430
    :cond_1
    :goto_1
    return-object v0

    .line 402
    :cond_2
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getEncoding()Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    move-result-object v2

    sget-object v3, Lcom/damnhandy/uri/template/UriTemplate$Encoding;->UF:Lcom/damnhandy/uri/template/UriTemplate$Encoding;

    if-ne v2, v3, :cond_3

    .line 403
    invoke-static {p3}, Lcom/damnhandy/uri/template/UriUtil;->encodeFragment(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 405
    :cond_3
    invoke-static {p3}, Lcom/damnhandy/uri/template/UriUtil;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 414
    :cond_4
    sget-object v2, Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;->SINGLE:Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;

    if-ne p4, v2, :cond_5

    .line 416
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getVariableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 421
    :cond_5
    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v2

    sget-object v3, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    if-ne v2, v3, :cond_1

    .line 423
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->useVarNameWhenExploded()Z

    move-result v2

    if-eqz v2, :cond_1

    sget-object v2, Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;->PAIRS:Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;

    if-eq p4, v2, :cond_1

    .line 425
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/damnhandy/uri/template/impl/VarSpec;->getVariableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method private expandVariables(Lcom/damnhandy/uri/template/impl/Operator;Ljava/util/List;)Ljava/util/List;
    .locals 20
    .param p1, "operator"    # Lcom/damnhandy/uri/template/impl/Operator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/damnhandy/uri/template/impl/Operator;",
            "Ljava/util/List",
            "<",
            "Lcom/damnhandy/uri/template/impl/VarSpec;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 126
    .local p2, "varSpecs":Ljava/util/List;, "Ljava/util/List<Lcom/damnhandy/uri/template/impl/VarSpec;>;"
    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    .line 128
    .local v14, "replacements":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface/range {p2 .. p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :cond_0
    :goto_0
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_d

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/damnhandy/uri/template/impl/VarSpec;

    .line 130
    .local v17, "varSpec":Lcom/damnhandy/uri/template/impl/VarSpec;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->values:Ljava/util/Map;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v17}, Lcom/damnhandy/uri/template/impl/VarSpec;->getVariableName()Ljava/lang/String;

    move-result-object v19

    invoke-interface/range {v18 .. v19}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_0

    .line 132
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->values:Ljava/util/Map;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v17}, Lcom/damnhandy/uri/template/impl/VarSpec;->getVariableName()Ljava/lang/String;

    move-result-object v19

    invoke-interface/range {v18 .. v19}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    .line 133
    .local v16, "value":Ljava/lang/Object;
    const/4 v8, 0x0

    .line 136
    .local v8, "expanded":Ljava/lang/String;
    if-eqz v16, :cond_2

    .line 138
    invoke-virtual/range {v16 .. v16}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Class;->isArray()Z

    move-result v18

    if-eqz v18, :cond_2

    .line 140
    move-object/from16 v0, v16

    instance-of v0, v0, [[C

    move/from16 v18, v0

    if-eqz v18, :cond_3

    .line 142
    check-cast v16, [[C

    .end local v16    # "value":Ljava/lang/Object;
    move-object/from16 v7, v16

    check-cast v7, [[C

    .line 143
    .local v7, "chars":[[C
    new-instance v15, Ljava/util/ArrayList;

    invoke-direct {v15}, Ljava/util/ArrayList;-><init>()V

    .line 144
    .local v15, "strings":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object v5, v7

    .local v5, "arr$":[[C
    array-length v13, v5

    .local v13, "len$":I
    const/4 v12, 0x0

    .local v12, "i$":I
    :goto_1
    if-ge v12, v13, :cond_1

    aget-object v6, v5, v12

    .line 146
    .local v6, "c":[C
    invoke-static {v6}, Ljava/lang/String;->valueOf([C)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-interface {v15, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 144
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 148
    .end local v6    # "c":[C
    :cond_1
    move-object/from16 v16, v15

    .line 161
    .end local v5    # "arr$":[[C
    .end local v7    # "chars":[[C
    .end local v12    # "i$":I
    .end local v13    # "len$":I
    .end local v15    # "strings":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_2
    :goto_2
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v1}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->isExplodable(Ljava/lang/Object;)Z

    move-result v9

    .line 162
    .local v9, "explodable":Z
    if-eqz v9, :cond_5

    invoke-virtual/range {v17 .. v17}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v18

    sget-object v19, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-ne v0, v1, :cond_5

    .line 164
    new-instance v18, Lcom/damnhandy/uri/template/impl/VariableExpansionException;

    const-string v19, "Prefix modifiers are not applicable to variables that have composite values."

    invoke-direct/range {v18 .. v19}, Lcom/damnhandy/uri/template/impl/VariableExpansionException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 150
    .end local v9    # "explodable":Z
    .restart local v16    # "value":Ljava/lang/Object;
    :cond_3
    move-object/from16 v0, v16

    instance-of v0, v0, [C

    move/from16 v18, v0

    if-eqz v18, :cond_4

    .line 152
    check-cast v16, [C

    .end local v16    # "value":Ljava/lang/Object;
    check-cast v16, [C

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf([C)Ljava/lang/String;

    move-result-object v16

    .local v16, "value":Ljava/lang/String;
    goto :goto_2

    .line 156
    .local v16, "value":Ljava/lang/Object;
    :cond_4
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v1}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->arrayToList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v16

    .local v16, "value":Ljava/util/List;
    goto :goto_2

    .line 167
    .end local v16    # "value":Ljava/util/List;
    .restart local v9    # "explodable":Z
    :cond_5
    if-eqz v9, :cond_6

    .line 169
    move-object/from16 v0, v16

    instance-of v0, v0, Lcom/damnhandy/uri/template/VarExploder;

    move/from16 v18, v0

    if-eqz v18, :cond_8

    move-object/from16 v10, v16

    .line 171
    check-cast v10, Lcom/damnhandy/uri/template/VarExploder;

    .line 177
    .local v10, "exploder":Lcom/damnhandy/uri/template/VarExploder;
    :goto_3
    invoke-virtual/range {v17 .. v17}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v18

    sget-object v19, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-ne v0, v1, :cond_9

    .line 179
    invoke-interface {v10}, Lcom/damnhandy/uri/template/VarExploder;->getNameValuePairs()Ljava/util/Map;

    move-result-object v18

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v17

    move-object/from16 v3, v18

    invoke-direct {v0, v1, v2, v3}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandMap(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v8

    .line 194
    .end local v10    # "exploder":Lcom/damnhandy/uri/template/VarExploder;
    :cond_6
    :goto_4
    move-object/from16 v0, v16

    instance-of v0, v0, Ljava/util/Date;

    move/from16 v18, v0

    if-eqz v18, :cond_e

    .line 196
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->defaultDateFormat:Ljava/text/DateFormat;

    move-object/from16 v18, v0

    check-cast v16, Ljava/util/Date;

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v16

    .local v16, "value":Ljava/lang/String;
    move-object/from16 v18, v16

    .line 201
    .end local v16    # "value":Ljava/lang/String;
    :goto_5
    move-object/from16 v0, v18

    instance-of v0, v0, Ljava/util/Collection;

    move/from16 v19, v0

    if-eqz v19, :cond_a

    .line 203
    check-cast v18, Ljava/util/Collection;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v17

    move-object/from16 v3, v18

    invoke-direct {v0, v1, v2, v3}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandCollection(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v8

    .line 223
    :cond_7
    :goto_6
    if-eqz v8, :cond_0

    .line 225
    invoke-interface {v14, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 175
    :cond_8
    invoke-static/range {v16 .. v17}, Lcom/damnhandy/uri/template/impl/VarExploderFactory;->getExploder(Ljava/lang/Object;Lcom/damnhandy/uri/template/impl/VarSpec;)Lcom/damnhandy/uri/template/VarExploder;

    move-result-object v10

    .restart local v10    # "exploder":Lcom/damnhandy/uri/template/VarExploder;
    goto :goto_3

    .line 181
    :cond_9
    invoke-virtual/range {v17 .. v17}, Lcom/damnhandy/uri/template/impl/VarSpec;->getModifier()Lcom/damnhandy/uri/template/impl/Modifier;

    move-result-object v18

    sget-object v19, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-eq v0, v1, :cond_6

    .line 183
    invoke-interface {v10}, Lcom/damnhandy/uri/template/VarExploder;->getValues()Ljava/util/Collection;

    move-result-object v18

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v17

    move-object/from16 v3, v18

    invoke-direct {v0, v1, v2, v3}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandCollection(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v8

    goto :goto_4

    .line 208
    .end local v10    # "exploder":Lcom/damnhandy/uri/template/VarExploder;
    :cond_a
    move-object/from16 v0, v18

    instance-of v0, v0, Ljava/util/Map;

    move/from16 v19, v0

    if-eqz v19, :cond_b

    .line 210
    check-cast v18, Ljava/util/Map;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v17

    move-object/from16 v3, v18

    invoke-direct {v0, v1, v2, v3}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandMap(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v8

    goto :goto_6

    .line 215
    :cond_b
    if-nez v18, :cond_c

    .line 217
    const/4 v8, 0x0

    goto :goto_6

    .line 219
    :cond_c
    if-nez v8, :cond_7

    .line 221
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v18

    sget-object v19, Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;->SINGLE:Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v17

    move-object/from16 v3, v18

    move-object/from16 v4, v19

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandStringValue(Lcom/damnhandy/uri/template/impl/Operator;Lcom/damnhandy/uri/template/impl/VarSpec;Ljava/lang/String;Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;)Ljava/lang/String;

    move-result-object v8

    goto :goto_6

    .line 230
    .end local v8    # "expanded":Ljava/lang/String;
    .end local v9    # "explodable":Z
    .end local v17    # "varSpec":Lcom/damnhandy/uri/template/impl/VarSpec;
    :cond_d
    return-object v14

    .restart local v8    # "expanded":Ljava/lang/String;
    .restart local v9    # "explodable":Z
    .restart local v17    # "varSpec":Lcom/damnhandy/uri/template/impl/VarSpec;
    :cond_e
    move-object/from16 v18, v16

    goto :goto_5
.end method

.method private findExpressions(Lcom/damnhandy/uri/template/impl/Operator;Ljava/util/List;)Ljava/lang/String;
    .locals 4
    .param p1, "operator"    # Lcom/damnhandy/uri/template/impl/Operator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/damnhandy/uri/template/impl/Operator;",
            "Ljava/util/List",
            "<",
            "Lcom/damnhandy/uri/template/impl/VarSpec;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 100
    .local p2, "varSpecs":Ljava/util/List;, "Ljava/util/List<Lcom/damnhandy/uri/template/impl/VarSpec;>;"
    invoke-direct {p0, p1, p2}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expandVariables(Lcom/damnhandy/uri/template/impl/Operator;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 101
    .local v0, "replacements":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getSeparator()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2, v0}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->joinParts(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    .line 102
    .local v1, "result":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 104
    sget-object v2, Lcom/damnhandy/uri/template/impl/Operator;->RESERVED:Lcom/damnhandy/uri/template/impl/Operator;

    if-ne p1, v2, :cond_0

    .line 113
    .end local v1    # "result":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 110
    .restart local v1    # "result":Ljava/lang/String;
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/damnhandy/uri/template/impl/Operator;->getPrefix()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 113
    :cond_1
    const-string v1, ""

    goto :goto_0
.end method

.method private isExplodable(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 241
    if-nez p1, :cond_1

    .line 253
    :cond_0
    :goto_0
    return v0

    .line 245
    :cond_1
    instance-of v2, p1, Ljava/util/Collection;

    if-nez v2, :cond_2

    instance-of v2, p1, Ljava/util/Map;

    if-nez v2, :cond_2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->isArray()Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_2
    move v0, v1

    .line 247
    goto :goto_0

    .line 249
    :cond_3
    invoke-direct {p0, p1}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->isSimpleType(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    .line 251
    goto :goto_0
.end method

.method private isSimpleType(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 272
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->isPrimitive()Z

    move-result v0

    if-nez v0, :cond_0

    instance-of v0, p1, Ljava/lang/Number;

    if-nez v0, :cond_0

    instance-of v0, p1, Ljava/lang/CharSequence;

    if-nez v0, :cond_0

    instance-of v0, p1, Ljava/util/Date;

    if-nez v0, :cond_0

    instance-of v0, p1, Ljava/lang/Boolean;

    if-eqz v0, :cond_1

    .line 278
    :cond_0
    const/4 v0, 0x1

    .line 281
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private joinParts(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    .locals 5
    .param p1, "joiner"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 442
    .local p2, "parts":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    if-nez v3, :cond_0

    .line 444
    const/4 v3, 0x0

    .line 466
    :goto_0
    return-object v3

    .line 447
    :cond_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    .line 449
    const/4 v3, 0x0

    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    goto :goto_0

    .line 452
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 453
    .local v0, "builder":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    if-ge v1, v3, :cond_3

    .line 455
    invoke-interface {p2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 456
    .local v2, "part":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 458
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 459
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_2

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-eq v1, v3, :cond_2

    .line 461
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 453
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 466
    .end local v2    # "part":Ljava/lang/String;
    :cond_3
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method private validateVarname(Ljava/lang/String;)V
    .locals 4
    .param p1, "varname"    # Ljava/lang/String;

    .prologue
    .line 531
    sget-object v1, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->VARNAME_REGEX:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 532
    .local v0, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-nez v1, :cond_0

    .line 534
    new-instance v1, Lcom/damnhandy/uri/template/impl/ExpressionParseException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "The variable name "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " contains invalid characters"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/damnhandy/uri/template/impl/ExpressionParseException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 537
    :cond_0
    const-string v1, " "

    invoke-virtual {p1, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 539
    new-instance v1, Lcom/damnhandy/uri/template/impl/ExpressionParseException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "The variable name "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " cannot contain spaces (leading or trailing)"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/damnhandy/uri/template/impl/ExpressionParseException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 541
    :cond_1
    return-void
.end method


# virtual methods
.method public expand()Ljava/lang/String;
    .locals 8

    .prologue
    .line 70
    invoke-virtual {p0}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->getTemplate()Ljava/lang/String;

    move-result-object v3

    .line 71
    .local v3, "template":Ljava/lang/String;
    sget-object v6, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->URI_TEMPLATE_REGEX:Ljava/util/regex/Pattern;

    invoke-virtual {v6, v3}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 72
    .local v2, "matcher":Ljava/util/regex/Matcher;
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 73
    .local v0, "buffer":Ljava/lang/StringBuffer;
    const/4 v1, 0x0

    .line 74
    .local v1, "count":I
    :goto_0
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->find()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 77
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->group()Ljava/lang/String;

    move-result-object v4

    .line 78
    .local v4, "token":Ljava/lang/String;
    const/4 v6, 0x1

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->buildVarSpecs(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 79
    .local v5, "value":Ljava/lang/String;
    invoke-virtual {v2, v0, v5}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    .line 80
    add-int/lit8 v1, v1, 0x1

    .line 81
    goto :goto_0

    .line 82
    .end local v4    # "token":Ljava/lang/String;
    .end local v5    # "value":Ljava/lang/String;
    :cond_0
    if-nez v1, :cond_1

    .line 84
    new-instance v6, Lcom/damnhandy/uri/template/impl/ExpressionParseException;

    const-string v7, "no variables found"

    invoke-direct {v6, v7}, Lcom/damnhandy/uri/template/impl/ExpressionParseException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 86
    :cond_1
    invoke-virtual {v2, v0}, Ljava/util/regex/Matcher;->appendTail(Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;

    .line 87
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method public expand(Ljava/util/Map;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 58
    .local p1, "vars":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iput-object p1, p0, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->values:Ljava/util/Map;

    .line 59
    invoke-virtual {p0}, Lcom/damnhandy/uri/template/impl/RFC6570UriTemplate;->expand()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
