.class public Lcom/poshmark/utils/FeedDeserializer;
.super Ljava/lang/Object;
.source "FeedDeserializer.java"

# interfaces
.implements Lcom/google/gson/JsonDeserializer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/gson/JsonDeserializer",
        "<",
        "Lcom/poshmark/data_model/models/Feed;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private createActor(Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/poshmark/data_model/models/FeedItem;Lcom/google/gson/Gson;)V
    .locals 3
    .param p1, "actorTypeString"    # Ljava/lang/String;
    .param p2, "element"    # Lcom/google/gson/JsonElement;
    .param p3, "item"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p4, "gson"    # Lcom/google/gson/Gson;

    .prologue
    .line 131
    if-eqz p1, :cond_0

    .line 132
    const-string v1, "user"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 133
    const-class v1, Lcom/poshmark/data_model/models/ActorUser;

    instance-of v2, p4, Lcom/google/gson/Gson;

    if-nez v2, :cond_1

    invoke-virtual {p4, p2, v1}, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .end local p4    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v0, Lcom/poshmark/data_model/models/ActorUser;

    .line 134
    .local v0, "ac":Lcom/poshmark/data_model/models/ActorUser;
    invoke-virtual {p3, v0}, Lcom/poshmark/data_model/models/FeedItem;->setActor(Lcom/poshmark/data_model/models/Actor;)V

    .line 143
    .end local v0    # "ac":Lcom/poshmark/data_model/models/ActorUser;
    :cond_0
    :goto_1
    return-void

    .line 133
    .restart local p4    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast p4, Lcom/google/gson/Gson;

    .end local p4    # "gson":Lcom/google/gson/Gson;
    invoke-static {p4, p2, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 135
    .restart local p4    # "gson":Lcom/google/gson/Gson;
    :cond_2
    const-string v1, "post"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 137
    const-string v1, "brand"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 138
    const-class v1, Lcom/poshmark/data_model/models/ActorBrand;

    instance-of v2, p4, Lcom/google/gson/Gson;

    if-nez v2, :cond_3

    invoke-virtual {p4, p2, v1}, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .end local p4    # "gson":Lcom/google/gson/Gson;
    :goto_2
    check-cast v0, Lcom/poshmark/data_model/models/ActorBrand;

    .line 139
    .local v0, "ac":Lcom/poshmark/data_model/models/ActorBrand;
    invoke-virtual {p3, v0}, Lcom/poshmark/data_model/models/FeedItem;->setActor(Lcom/poshmark/data_model/models/Actor;)V

    goto :goto_1

    .line 138
    .end local v0    # "ac":Lcom/poshmark/data_model/models/ActorBrand;
    .restart local p4    # "gson":Lcom/google/gson/Gson;
    :cond_3
    check-cast p4, Lcom/google/gson/Gson;

    .end local p4    # "gson":Lcom/google/gson/Gson;
    invoke-static {p4, p2, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_2
.end method

.method private createContent(Lcom/google/gson/JsonElement;Lcom/poshmark/data_model/models/FeedItem;Lcom/google/gson/Gson;)V
    .locals 9
    .param p1, "element"    # Lcom/google/gson/JsonElement;
    .param p2, "item"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p3, "gson"    # Lcom/google/gson/Gson;

    .prologue
    .line 108
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;

    move-result-object v7

    const-string v8, "type"

    invoke-virtual {v7, v8}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v6

    .line 109
    .local v6, "contentTypeString":Ljava/lang/String;
    new-instance v5, Lcom/poshmark/data_model/models/FeedItemContentType;

    invoke-direct {v5, v6}, Lcom/poshmark/data_model/models/FeedItemContentType;-><init>(Ljava/lang/String;)V

    .line 110
    .local v5, "contentType":Lcom/poshmark/data_model/models/FeedItemContentType;
    iput-object v5, p2, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    .line 111
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;

    move-result-object v7

    const-string v8, "count"

    invoke-virtual {v7, v8}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/google/gson/JsonElement;->getAsInt()I

    move-result v7

    iput v7, p2, Lcom/poshmark/data_model/models/FeedItem;->contentTotalCount:I

    .line 112
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;

    move-result-object v7

    const-string v8, "data"

    invoke-virtual {v7, v8}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v4

    .line 113
    .local v4, "contentArrayElement":Lcom/google/gson/JsonElement;
    iget-object v7, v5, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v8, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v7, v8, :cond_2

    .line 114
    new-instance v7, Lcom/poshmark/utils/FeedDeserializer$1;

    invoke-direct {v7, p0}, Lcom/poshmark/utils/FeedDeserializer$1;-><init>(Lcom/poshmark/utils/FeedDeserializer;)V

    invoke-virtual {v7}, Lcom/poshmark/utils/FeedDeserializer$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v7

    instance-of v8, p3, Lcom/google/gson/Gson;

    if-nez v8, :cond_1

    invoke-virtual {p3, v4, v7}, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    .end local p3    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v1, Ljava/util/List;

    .line 115
    .local v1, "contentArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSocial;>;"
    iput-object v1, p2, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    .line 127
    .end local v1    # "contentArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSocial;>;"
    :cond_0
    :goto_1
    return-void

    .line 114
    .restart local p3    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast p3, Lcom/google/gson/Gson;

    .end local p3    # "gson":Lcom/google/gson/Gson;
    invoke-static {p3, v4, v7}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 116
    .restart local p3    # "gson":Lcom/google/gson/Gson;
    :cond_2
    iget-object v7, v5, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v8, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v7, v8, :cond_4

    .line 117
    new-instance v7, Lcom/poshmark/utils/FeedDeserializer$2;

    invoke-direct {v7, p0}, Lcom/poshmark/utils/FeedDeserializer$2;-><init>(Lcom/poshmark/utils/FeedDeserializer;)V

    invoke-virtual {v7}, Lcom/poshmark/utils/FeedDeserializer$2;->getType()Ljava/lang/reflect/Type;

    move-result-object v7

    instance-of v8, p3, Lcom/google/gson/Gson;

    if-nez v8, :cond_3

    invoke-virtual {p3, v4, v7}, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v3

    .end local p3    # "gson":Lcom/google/gson/Gson;
    :goto_2
    check-cast v3, Ljava/util/List;

    .line 118
    .local v3, "contentArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    iput-object v3, p2, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    goto :goto_1

    .line 117
    .end local v3    # "contentArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    .restart local p3    # "gson":Lcom/google/gson/Gson;
    :cond_3
    check-cast p3, Lcom/google/gson/Gson;

    .end local p3    # "gson":Lcom/google/gson/Gson;
    invoke-static {p3, v4, v7}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v3

    goto :goto_2

    .line 119
    .restart local p3    # "gson":Lcom/google/gson/Gson;
    :cond_4
    iget-object v7, v5, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v8, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v7, v8, :cond_6

    .line 120
    new-instance v7, Lcom/poshmark/utils/FeedDeserializer$3;

    invoke-direct {v7, p0}, Lcom/poshmark/utils/FeedDeserializer$3;-><init>(Lcom/poshmark/utils/FeedDeserializer;)V

    invoke-virtual {v7}, Lcom/poshmark/utils/FeedDeserializer$3;->getType()Ljava/lang/reflect/Type;

    move-result-object v7

    instance-of v8, p3, Lcom/google/gson/Gson;

    if-nez v8, :cond_5

    invoke-virtual {p3, v4, v7}, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    .end local p3    # "gson":Lcom/google/gson/Gson;
    :goto_3
    check-cast v0, Ljava/util/List;

    .line 121
    .local v0, "contentArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Brand;>;"
    iput-object v0, p2, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    goto :goto_1

    .line 120
    .end local v0    # "contentArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Brand;>;"
    .restart local p3    # "gson":Lcom/google/gson/Gson;
    :cond_5
    check-cast p3, Lcom/google/gson/Gson;

    .end local p3    # "gson":Lcom/google/gson/Gson;
    invoke-static {p3, v4, v7}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_3

    .line 122
    .restart local p3    # "gson":Lcom/google/gson/Gson;
    :cond_6
    iget-object v7, v5, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v8, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v7, v8, :cond_0

    .line 123
    new-instance v7, Lcom/poshmark/utils/FeedDeserializer$4;

    invoke-direct {v7, p0}, Lcom/poshmark/utils/FeedDeserializer$4;-><init>(Lcom/poshmark/utils/FeedDeserializer;)V

    invoke-virtual {v7}, Lcom/poshmark/utils/FeedDeserializer$4;->getType()Ljava/lang/reflect/Type;

    move-result-object v7

    instance-of v8, p3, Lcom/google/gson/Gson;

    if-nez v8, :cond_7

    invoke-virtual {p3, v4, v7}, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v2

    .end local p3    # "gson":Lcom/google/gson/Gson;
    :goto_4
    check-cast v2, Ljava/util/List;

    .line 124
    .local v2, "contentArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PoshmarkPost;>;"
    iput-object v2, p2, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    goto :goto_1

    .line 123
    .end local v2    # "contentArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PoshmarkPost;>;"
    .restart local p3    # "gson":Lcom/google/gson/Gson;
    :cond_7
    check-cast p3, Lcom/google/gson/Gson;

    .end local p3    # "gson":Lcom/google/gson/Gson;
    invoke-static {p3, v4, v7}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v2

    goto :goto_4
.end method

.method private getStringValue(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "jsonObject"    # Lcom/google/gson/JsonObject;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 99
    invoke-virtual {p1, p2}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    .line 100
    .local v0, "element":Lcom/google/gson/JsonElement;
    if-eqz v0, :cond_0

    .line 101
    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    .line 103
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/poshmark/data_model/models/Feed;
    .locals 18
    .param p1, "jsonElement"    # Lcom/google/gson/JsonElement;
    .param p2, "type"    # Ljava/lang/reflect/Type;
    .param p3, "jsonDeserializationContext"    # Lcom/google/gson/JsonDeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/gson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 34
    new-instance v4, Lcom/google/gson/GsonBuilder;

    invoke-direct {v4}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 35
    .local v4, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v4}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v9

    .line 38
    .local v9, "gson":Lcom/google/gson/Gson;
    new-instance v7, Lcom/poshmark/data_model/models/Feed;

    invoke-direct {v7}, Lcom/poshmark/data_model/models/Feed;-><init>()V

    .line 40
    .local v7, "feed":Lcom/poshmark/data_model/models/Feed;
    invoke-virtual/range {p1 .. p1}, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;

    move-result-object v5

    .line 41
    .local v5, "completeObj":Lcom/google/gson/JsonObject;
    const-string v16, "data"

    move-object/from16 v0, v16

    invoke-virtual {v5, v0}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;

    move-result-object v3

    .line 42
    .local v3, "array":Lcom/google/gson/JsonArray;
    invoke-virtual {v3}, Lcom/google/gson/JsonArray;->size()I

    move-result v15

    .line 43
    .local v15, "size":I
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    if-ge v11, v15, :cond_5

    .line 44
    new-instance v12, Lcom/poshmark/data_model/models/FeedItem;

    invoke-direct {v12}, Lcom/poshmark/data_model/models/FeedItem;-><init>()V

    .line 45
    .local v12, "item":Lcom/poshmark/data_model/models/FeedItem;
    invoke-virtual {v3, v11}, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;

    move-result-object v8

    .line 47
    .local v8, "feedItemJson":Lcom/google/gson/JsonObject;
    new-instance v16, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    const-string v17, "story_type"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v8, v1}, Lcom/poshmark/utils/FeedDeserializer;->getStringValue(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v16 .. v17}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    iput-object v0, v12, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    .line 48
    const-string v16, "action"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v8, v1}, Lcom/poshmark/utils/FeedDeserializer;->getStringValue(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    iput-object v0, v12, Lcom/poshmark/data_model/models/FeedItem;->action:Ljava/lang/String;

    .line 49
    const-string v16, "header"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v8, v1}, Lcom/poshmark/utils/FeedDeserializer;->getStringValue(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    iput-object v0, v12, Lcom/poshmark/data_model/models/FeedItem;->header:Ljava/lang/String;

    .line 50
    const-string v16, "footer"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v8, v1}, Lcom/poshmark/utils/FeedDeserializer;->getStringValue(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    iput-object v0, v12, Lcom/poshmark/data_model/models/FeedItem;->footer:Ljava/lang/String;

    .line 51
    const-string v16, "created_at"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v8, v1}, Lcom/poshmark/utils/FeedDeserializer;->getStringValue(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    iput-object v0, v12, Lcom/poshmark/data_model/models/FeedItem;->createdAt:Ljava/lang/String;

    .line 53
    const-string v16, "view"

    move-object/from16 v0, v16

    invoke-virtual {v8, v0}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v6

    .line 54
    .local v6, "element":Lcom/google/gson/JsonElement;
    if-eqz v6, :cond_1

    .line 55
    invoke-virtual {v6}, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;

    move-result-object v16

    const-string v17, "layout"

    invoke-virtual/range {v16 .. v17}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v14

    .line 56
    .local v14, "itemLayoutString":Ljava/lang/String;
    new-instance v13, Lcom/poshmark/data_model/models/FeedItemImageLayout;

    invoke-direct {v13, v14}, Lcom/poshmark/data_model/models/FeedItemImageLayout;-><init>(Ljava/lang/String;)V

    .line 57
    .local v13, "itemLayout":Lcom/poshmark/data_model/models/FeedItemImageLayout;
    invoke-virtual {v13}, Lcom/poshmark/data_model/models/FeedItemImageLayout;->isLayoutValid()Z

    move-result v16

    if-eqz v16, :cond_0

    .line 58
    iput-object v13, v12, Lcom/poshmark/data_model/models/FeedItem;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    .line 62
    :cond_0
    invoke-virtual {v6}, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;

    move-result-object v16

    const-string v17, "header_icon"

    invoke-virtual/range {v16 .. v17}, Lcom/google/gson/JsonObject;->getAsJsonObject(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v10

    .line 63
    .local v10, "headerIcon":Lcom/google/gson/JsonObject;
    if-eqz v10, :cond_1

    .line 64
    const-string v16, "url"

    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v12, v0}, Lcom/poshmark/data_model/models/FeedItem;->setHeaderIconUrl(Ljava/lang/String;)V

    .line 70
    .end local v10    # "headerIcon":Lcom/google/gson/JsonObject;
    .end local v13    # "itemLayout":Lcom/poshmark/data_model/models/FeedItemImageLayout;
    .end local v14    # "itemLayoutString":Ljava/lang/String;
    :cond_1
    const-string v16, "from"

    move-object/from16 v0, v16

    invoke-virtual {v8, v0}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v6

    .line 71
    if-eqz v6, :cond_2

    .line 72
    invoke-virtual {v6}, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;

    move-result-object v16

    const-string v17, "type"

    invoke-virtual/range {v16 .. v17}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v2

    .line 73
    .local v2, "actorTypeString":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-direct {v0, v2, v6, v12, v9}, Lcom/poshmark/utils/FeedDeserializer;->createActor(Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/poshmark/data_model/models/FeedItem;Lcom/google/gson/Gson;)V

    .line 77
    .end local v2    # "actorTypeString":Ljava/lang/String;
    :cond_2
    const-string v16, "content"

    move-object/from16 v0, v16

    invoke-virtual {v8, v0}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v6

    .line 78
    if-eqz v6, :cond_3

    .line 79
    move-object/from16 v0, p0

    invoke-direct {v0, v6, v12, v9}, Lcom/poshmark/utils/FeedDeserializer;->createContent(Lcom/google/gson/JsonElement;Lcom/poshmark/data_model/models/FeedItem;Lcom/google/gson/Gson;)V

    .line 83
    :cond_3
    invoke-virtual {v12}, Lcom/poshmark/data_model/models/FeedItem;->computeFeedItemLayout()V

    .line 86
    invoke-virtual {v12}, Lcom/poshmark/data_model/models/FeedItem;->validate()Z

    move-result v16

    if-eqz v16, :cond_4

    .line 87
    iget-object v0, v7, Lcom/poshmark/data_model/models/Feed;->data:Ljava/util/List;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-interface {v0, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 43
    :cond_4
    add-int/lit8 v11, v11, 0x1

    goto/16 :goto_0

    .line 91
    .end local v6    # "element":Lcom/google/gson/JsonElement;
    .end local v8    # "feedItemJson":Lcom/google/gson/JsonObject;
    .end local v12    # "item":Lcom/poshmark/data_model/models/FeedItem;
    :cond_5
    const-string v16, "more"

    move-object/from16 v0, v16

    invoke-virtual {v5, v0}, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v6

    .line 92
    .restart local v6    # "element":Lcom/google/gson/JsonElement;
    if-eqz v6, :cond_6

    .line 93
    const-class v16, Lcom/poshmark/data_model/models/PMData$NextMaxID;

    instance-of v0, v9, Lcom/google/gson/Gson;

    move/from16 v17, v0

    if-nez v17, :cond_7

    move-object/from16 v0, v16

    invoke-virtual {v9, v6, v0}, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v16

    .end local v9    # "gson":Lcom/google/gson/Gson;
    :goto_1
    check-cast v16, Lcom/poshmark/data_model/models/PMData$NextMaxID;

    move-object/from16 v0, v16

    iput-object v0, v7, Lcom/poshmark/data_model/models/Feed;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    .line 95
    :cond_6
    return-object v7

    .line 93
    .restart local v9    # "gson":Lcom/google/gson/Gson;
    :cond_7
    check-cast v9, Lcom/google/gson/Gson;

    .end local v9    # "gson":Lcom/google/gson/Gson;
    move-object/from16 v0, v16

    invoke-static {v9, v6, v0}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v16

    goto :goto_1
.end method

.method public bridge synthetic deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/google/gson/JsonElement;
    .param p2, "x1"    # Ljava/lang/reflect/Type;
    .param p3, "x2"    # Lcom/google/gson/JsonDeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/gson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-virtual {p0, p1, p2, p3}, Lcom/poshmark/utils/FeedDeserializer;->deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/poshmark/data_model/models/Feed;

    move-result-object v0

    return-object v0
.end method
