.class public Lorg/json/simple/parser/JSONParser;
.super Ljava/lang/Object;
.source "JSONParser.java"


# instance fields
.field private handlerStatusStack:Ljava/util/LinkedList;

.field private lexer:Lorg/json/simple/parser/Yylex;

.field private status:I

.field private token:Lorg/json/simple/parser/Yytoken;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v2, Lorg/json/simple/parser/Yylex;

    move-object v0, v1

    check-cast v0, Ljava/io/Reader;

    invoke-direct {v2, v0}, Lorg/json/simple/parser/Yylex;-><init>(Ljava/io/Reader;)V

    iput-object v2, p0, Lorg/json/simple/parser/JSONParser;->lexer:Lorg/json/simple/parser/Yylex;

    .line 35
    iput-object v1, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    .line 36
    const/4 v0, 0x0

    iput v0, p0, Lorg/json/simple/parser/JSONParser;->status:I

    return-void
.end method

.method private createArrayContainer(Lorg/json/simple/parser/ContainerFactory;)Ljava/util/List;
    .locals 1
    .param p1, "containerFactory"    # Lorg/json/simple/parser/ContainerFactory;

    .prologue
    .line 285
    if-nez p1, :cond_1

    .line 286
    new-instance v0, Lorg/json/simple/JSONArray;

    invoke-direct {v0}, Lorg/json/simple/JSONArray;-><init>()V

    .line 291
    :cond_0
    :goto_0
    return-object v0

    .line 287
    :cond_1
    invoke-interface {p1}, Lorg/json/simple/parser/ContainerFactory;->creatArrayContainer()Ljava/util/List;

    move-result-object v0

    .line 289
    .local v0, "l":Ljava/util/List;
    if-nez v0, :cond_0

    .line 290
    new-instance v0, Lorg/json/simple/JSONArray;

    .end local v0    # "l":Ljava/util/List;
    invoke-direct {v0}, Lorg/json/simple/JSONArray;-><init>()V

    goto :goto_0
.end method

.method private createObjectContainer(Lorg/json/simple/parser/ContainerFactory;)Ljava/util/Map;
    .locals 1
    .param p1, "containerFactory"    # Lorg/json/simple/parser/ContainerFactory;

    .prologue
    .line 275
    if-nez p1, :cond_1

    .line 276
    new-instance v0, Lorg/json/simple/JSONObject;

    invoke-direct {v0}, Lorg/json/simple/JSONObject;-><init>()V

    .line 281
    :cond_0
    :goto_0
    return-object v0

    .line 277
    :cond_1
    invoke-interface {p1}, Lorg/json/simple/parser/ContainerFactory;->createObjectContainer()Ljava/util/Map;

    move-result-object v0

    .line 279
    .local v0, "m":Ljava/util/Map;
    if-nez v0, :cond_0

    .line 280
    new-instance v0, Lorg/json/simple/JSONObject;

    .end local v0    # "m":Ljava/util/Map;
    invoke-direct {v0}, Lorg/json/simple/JSONObject;-><init>()V

    goto :goto_0
.end method

.method private nextToken()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/simple/parser/ParseException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 269
    iget-object v0, p0, Lorg/json/simple/parser/JSONParser;->lexer:Lorg/json/simple/parser/Yylex;

    invoke-virtual {v0}, Lorg/json/simple/parser/Yylex;->yylex()Lorg/json/simple/parser/Yytoken;

    move-result-object v0

    iput-object v0, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    .line 270
    iget-object v0, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    if-nez v0, :cond_0

    .line 271
    new-instance v0, Lorg/json/simple/parser/Yytoken;

    const/4 v1, -0x1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/json/simple/parser/Yytoken;-><init>(ILjava/lang/Object;)V

    iput-object v0, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    .line 272
    :cond_0
    return-void
.end method

.method private peekStatus(Ljava/util/LinkedList;)I
    .locals 2
    .param p1, "statusStack"    # Ljava/util/LinkedList;

    .prologue
    .line 39
    invoke-virtual {p1}, Ljava/util/LinkedList;->size()I

    move-result v1

    if-nez v1, :cond_0

    .line 40
    const/4 v1, -0x1

    .line 42
    :goto_0
    return v1

    .line 41
    :cond_0
    invoke-virtual {p1}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 42
    .local v0, "status":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_0
.end method


# virtual methods
.method public getPosition()I
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lorg/json/simple/parser/JSONParser;->lexer:Lorg/json/simple/parser/Yylex;

    invoke-virtual {v0}, Lorg/json/simple/parser/Yylex;->getPosition()I

    move-result v0

    return v0
.end method

.method public parse(Ljava/io/Reader;)Ljava/lang/Object;
    .locals 1
    .param p1, "in"    # Ljava/io/Reader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/json/simple/parser/ParseException;
        }
    .end annotation

    .prologue
    .line 92
    const/4 v0, 0x0

    check-cast v0, Lorg/json/simple/parser/ContainerFactory;

    invoke-virtual {p0, p1, v0}, Lorg/json/simple/parser/JSONParser;->parse(Ljava/io/Reader;Lorg/json/simple/parser/ContainerFactory;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public parse(Ljava/io/Reader;Lorg/json/simple/parser/ContainerFactory;)Ljava/lang/Object;
    .locals 12
    .param p1, "in"    # Ljava/io/Reader;
    .param p2, "containerFactory"    # Lorg/json/simple/parser/ContainerFactory;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/json/simple/parser/ParseException;
        }
    .end annotation

    .prologue
    const/4 v10, -0x1

    const/4 v11, 0x1

    .line 112
    invoke-virtual {p0, p1}, Lorg/json/simple/parser/JSONParser;->reset(Ljava/io/Reader;)V

    .line 113
    new-instance v5, Ljava/util/LinkedList;

    invoke-direct {v5}, Ljava/util/LinkedList;-><init>()V

    .line 114
    .local v5, "statusStack":Ljava/util/LinkedList;
    new-instance v7, Ljava/util/LinkedList;

    invoke-direct {v7}, Ljava/util/LinkedList;-><init>()V

    .line 118
    .local v7, "valueStack":Ljava/util/LinkedList;
    :cond_0
    :try_start_0
    invoke-direct {p0}, Lorg/json/simple/parser/JSONParser;->nextToken()V

    .line 119
    iget v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    packed-switch v8, :pswitch_data_0

    .line 256
    :goto_0
    :pswitch_0
    iget v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    if-ne v8, v10, :cond_5

    .line 257
    new-instance v8, Lorg/json/simple/parser/ParseException;

    invoke-virtual {p0}, Lorg/json/simple/parser/JSONParser;->getPosition()I

    move-result v9

    const/4 v10, 0x1

    iget-object v11, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    invoke-direct {v8, v9, v10, v11}, Lorg/json/simple/parser/ParseException;-><init>(IILjava/lang/Object;)V

    throw v8
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 261
    :catch_0
    move-exception v0

    .line 262
    .local v0, "ie":Ljava/io/IOException;
    throw v0

    .line 121
    .end local v0    # "ie":Ljava/io/IOException;
    :pswitch_1
    :try_start_1
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget v8, v8, Lorg/json/simple/parser/Yytoken;->type:I

    packed-switch v8, :pswitch_data_1

    .line 138
    :pswitch_2
    const/4 v8, -0x1

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto :goto_0

    .line 123
    :pswitch_3
    const/4 v8, 0x1

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 124
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/json/simple/parser/JSONParser;->status:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 125
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget-object v8, v8, Lorg/json/simple/parser/Yytoken;->value:Ljava/lang/Object;

    invoke-virtual {v7, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto :goto_0

    .line 128
    :pswitch_4
    const/4 v8, 0x2

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 129
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/json/simple/parser/JSONParser;->status:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 130
    invoke-direct {p0, p2}, Lorg/json/simple/parser/JSONParser;->createObjectContainer(Lorg/json/simple/parser/ContainerFactory;)Ljava/util/Map;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto :goto_0

    .line 133
    :pswitch_5
    const/4 v8, 0x3

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 134
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/json/simple/parser/JSONParser;->status:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 135
    invoke-direct {p0, p2}, Lorg/json/simple/parser/JSONParser;->createArrayContainer(Lorg/json/simple/parser/ContainerFactory;)Ljava/util/List;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto :goto_0

    .line 143
    :pswitch_6
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget v8, v8, Lorg/json/simple/parser/Yytoken;->type:I

    if-ne v8, v10, :cond_1

    .line 144
    invoke-virtual {v7}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v8

    return-object v8

    .line 146
    :cond_1
    new-instance v8, Lorg/json/simple/parser/ParseException;

    invoke-virtual {p0}, Lorg/json/simple/parser/JSONParser;->getPosition()I

    move-result v9

    const/4 v10, 0x1

    iget-object v11, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    invoke-direct {v8, v9, v10, v11}, Lorg/json/simple/parser/ParseException;-><init>(IILjava/lang/Object;)V

    throw v8

    .line 149
    :pswitch_7
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget v8, v8, Lorg/json/simple/parser/Yytoken;->type:I

    packed-switch v8, :pswitch_data_2

    .line 174
    :pswitch_8
    const/4 v8, -0x1

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto :goto_0

    .line 153
    :pswitch_9
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget-object v8, v8, Lorg/json/simple/parser/Yytoken;->value:Ljava/lang/Object;

    instance-of v8, v8, Ljava/lang/String;

    if-eqz v8, :cond_2

    .line 154
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget-object v1, v8, Lorg/json/simple/parser/Yytoken;->value:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    .line 155
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v7, v1}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 156
    const/4 v8, 0x4

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 157
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/json/simple/parser/JSONParser;->status:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 160
    .end local v1    # "key":Ljava/lang/String;
    :cond_2
    const/4 v8, -0x1

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto/16 :goto_0

    .line 164
    :pswitch_a
    invoke-virtual {v7}, Ljava/util/LinkedList;->size()I

    move-result v8

    if-le v8, v11, :cond_3

    .line 165
    invoke-virtual {v5}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    .line 166
    invoke-virtual {v7}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    .line 167
    invoke-direct {p0, v5}, Lorg/json/simple/parser/JSONParser;->peekStatus(Ljava/util/LinkedList;)I

    move-result v8

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto/16 :goto_0

    .line 170
    :cond_3
    const/4 v8, 0x1

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto/16 :goto_0

    .line 180
    :pswitch_b
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget v8, v8, Lorg/json/simple/parser/Yytoken;->type:I

    packed-switch v8, :pswitch_data_3

    .line 211
    :pswitch_c
    const/4 v8, -0x1

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto/16 :goto_0

    .line 184
    :pswitch_d
    invoke-virtual {v5}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    .line 185
    invoke-virtual {v7}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 186
    .restart local v1    # "key":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 187
    .local v4, "parent":Ljava/util/Map;
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget-object v8, v8, Lorg/json/simple/parser/Yytoken;->value:Ljava/lang/Object;

    invoke-interface {v4, v1, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    invoke-direct {p0, v5}, Lorg/json/simple/parser/JSONParser;->peekStatus(Ljava/util/LinkedList;)I

    move-result v8

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto/16 :goto_0

    .line 191
    .end local v1    # "key":Ljava/lang/String;
    .end local v4    # "parent":Ljava/util/Map;
    :pswitch_e
    invoke-virtual {v5}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    .line 192
    invoke-virtual {v7}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 193
    .restart local v1    # "key":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 194
    .restart local v4    # "parent":Ljava/util/Map;
    invoke-direct {p0, p2}, Lorg/json/simple/parser/JSONParser;->createArrayContainer(Lorg/json/simple/parser/ContainerFactory;)Ljava/util/List;

    move-result-object v2

    .line 195
    .local v2, "newArray":Ljava/util/List;
    invoke-interface {v4, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 196
    const/4 v8, 0x3

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 197
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/json/simple/parser/JSONParser;->status:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 198
    invoke-virtual {v7, v2}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 201
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "newArray":Ljava/util/List;
    .end local v4    # "parent":Ljava/util/Map;
    :pswitch_f
    invoke-virtual {v5}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    .line 202
    invoke-virtual {v7}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 203
    .restart local v1    # "key":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 204
    .restart local v4    # "parent":Ljava/util/Map;
    invoke-direct {p0, p2}, Lorg/json/simple/parser/JSONParser;->createObjectContainer(Lorg/json/simple/parser/ContainerFactory;)Ljava/util/Map;

    move-result-object v3

    .line 205
    .local v3, "newObject":Ljava/util/Map;
    invoke-interface {v4, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 206
    const/4 v8, 0x2

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 207
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/json/simple/parser/JSONParser;->status:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 208
    invoke-virtual {v7, v3}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 216
    .end local v1    # "key":Ljava/lang/String;
    .end local v3    # "newObject":Ljava/util/Map;
    .end local v4    # "parent":Ljava/util/Map;
    :pswitch_10
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget v8, v8, Lorg/json/simple/parser/Yytoken;->type:I

    packed-switch v8, :pswitch_data_4

    .line 250
    :pswitch_11
    const/4 v8, -0x1

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto/16 :goto_0

    .line 220
    :pswitch_12
    invoke-virtual {v7}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 221
    .local v6, "val":Ljava/util/List;
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget-object v8, v8, Lorg/json/simple/parser/Yytoken;->value:Ljava/lang/Object;

    invoke-interface {v6, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 224
    .end local v6    # "val":Ljava/util/List;
    :pswitch_13
    invoke-virtual {v7}, Ljava/util/LinkedList;->size()I

    move-result v8

    if-le v8, v11, :cond_4

    .line 225
    invoke-virtual {v5}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    .line 226
    invoke-virtual {v7}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    .line 227
    invoke-direct {p0, v5}, Lorg/json/simple/parser/JSONParser;->peekStatus(Ljava/util/LinkedList;)I

    move-result v8

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto/16 :goto_0

    .line 230
    :cond_4
    const/4 v8, 0x1

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    goto/16 :goto_0

    .line 234
    :pswitch_14
    invoke-virtual {v7}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 235
    .restart local v6    # "val":Ljava/util/List;
    invoke-direct {p0, p2}, Lorg/json/simple/parser/JSONParser;->createObjectContainer(Lorg/json/simple/parser/ContainerFactory;)Ljava/util/Map;

    move-result-object v3

    .line 236
    .restart local v3    # "newObject":Ljava/util/Map;
    invoke-interface {v6, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 237
    const/4 v8, 0x2

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 238
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/json/simple/parser/JSONParser;->status:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 239
    invoke-virtual {v7, v3}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 242
    .end local v3    # "newObject":Ljava/util/Map;
    .end local v6    # "val":Ljava/util/List;
    :pswitch_15
    invoke-virtual {v7}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 243
    .restart local v6    # "val":Ljava/util/List;
    invoke-direct {p0, p2}, Lorg/json/simple/parser/JSONParser;->createArrayContainer(Lorg/json/simple/parser/ContainerFactory;)Ljava/util/List;

    move-result-object v2

    .line 244
    .restart local v2    # "newArray":Ljava/util/List;
    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 245
    const/4 v8, 0x3

    iput v8, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 246
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/json/simple/parser/JSONParser;->status:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v8}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 247
    invoke-virtual {v7, v2}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 254
    .end local v2    # "newArray":Ljava/util/List;
    .end local v6    # "val":Ljava/util/List;
    :pswitch_16
    new-instance v8, Lorg/json/simple/parser/ParseException;

    invoke-virtual {p0}, Lorg/json/simple/parser/JSONParser;->getPosition()I

    move-result v9

    const/4 v10, 0x1

    iget-object v11, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    invoke-direct {v8, v9, v10, v11}, Lorg/json/simple/parser/ParseException;-><init>(IILjava/lang/Object;)V

    throw v8

    .line 259
    :cond_5
    iget-object v8, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    iget v8, v8, Lorg/json/simple/parser/Yytoken;->type:I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    if-ne v8, v10, :cond_0

    .line 265
    new-instance v8, Lorg/json/simple/parser/ParseException;

    invoke-virtual {p0}, Lorg/json/simple/parser/JSONParser;->getPosition()I

    move-result v9

    iget-object v10, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    invoke-direct {v8, v9, v11, v10}, Lorg/json/simple/parser/ParseException;-><init>(IILjava/lang/Object;)V

    throw v8

    .line 119
    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_16
        :pswitch_1
        :pswitch_6
        :pswitch_7
        :pswitch_10
        :pswitch_b
    .end packed-switch

    .line 121
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_3
        :pswitch_4
        :pswitch_2
        :pswitch_5
    .end packed-switch

    .line 149
    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_9
        :pswitch_8
        :pswitch_a
        :pswitch_8
        :pswitch_8
        :pswitch_0
    .end packed-switch

    .line 180
    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_d
        :pswitch_f
        :pswitch_c
        :pswitch_e
        :pswitch_c
        :pswitch_c
        :pswitch_0
    .end packed-switch

    .line 216
    :pswitch_data_4
    .packed-switch 0x0
        :pswitch_12
        :pswitch_14
        :pswitch_11
        :pswitch_15
        :pswitch_13
        :pswitch_0
    .end packed-switch
.end method

.method public reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 50
    iput-object v1, p0, Lorg/json/simple/parser/JSONParser;->token:Lorg/json/simple/parser/Yytoken;

    .line 51
    const/4 v0, 0x0

    iput v0, p0, Lorg/json/simple/parser/JSONParser;->status:I

    .line 52
    iput-object v1, p0, Lorg/json/simple/parser/JSONParser;->handlerStatusStack:Ljava/util/LinkedList;

    .line 53
    return-void
.end method

.method public reset(Ljava/io/Reader;)V
    .locals 1
    .param p1, "in"    # Ljava/io/Reader;

    .prologue
    .line 63
    iget-object v0, p0, Lorg/json/simple/parser/JSONParser;->lexer:Lorg/json/simple/parser/Yylex;

    invoke-virtual {v0, p1}, Lorg/json/simple/parser/Yylex;->yyreset(Ljava/io/Reader;)V

    .line 64
    invoke-virtual {p0}, Lorg/json/simple/parser/JSONParser;->reset()V

    .line 65
    return-void
.end method
