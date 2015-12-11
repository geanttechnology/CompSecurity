.class public Lco/vine/android/api/VineUploadParsers;
.super Ljava/lang/Object;
.source "VineUploadParsers.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/api/VineUploadParsers$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    return-void
.end method

.method public static parsePostInfo(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUpload$PostInfo;
    .locals 22
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 14
    const/4 v3, 0x0

    .line 15
    .local v3, "postToTwitter":Z
    const/4 v4, 0x0

    .line 16
    .local v4, "postToFacebook":Z
    const-wide/16 v5, -0x1

    .line 17
    .local v5, "channelId":J
    const-wide/16 v9, -0x1

    .line 18
    .local v9, "postId":J
    const-wide/16 v13, 0x0

    .line 19
    .local v13, "created":J
    const/16 v16, 0x0

    .line 20
    .local v16, "maxLoops":I
    const-string v2, ""

    .line 21
    .local v2, "description":Ljava/lang/String;
    const-string v8, ""

    .line 22
    .local v8, "message":Ljava/lang/String;
    const-string v11, ""

    .line 23
    .local v11, "videoUrl":Ljava/lang/String;
    const-string v12, ""

    .line 24
    .local v12, "thumbUrl":Ljava/lang/String;
    const/4 v7, 0x0

    .line 25
    .local v7, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    const/4 v15, 0x0

    .line 27
    .local v15, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 28
    .local v20, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v20, :cond_e

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v20

    if-eq v0, v1, :cond_e

    .line 29
    sget-object v1, Lco/vine/android/api/VineUploadParsers$1;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v20 .. v20}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v21

    aget v1, v1, v21

    packed-switch v1, :pswitch_data_0

    .line 101
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    goto :goto_0

    .line 31
    :pswitch_0
    const-string v1, "description"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 32
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    .line 34
    :cond_1
    const-string v1, "message"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 35
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v8

    .line 37
    :cond_2
    const-string v1, "videoUrl"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 38
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v11

    .line 40
    :cond_3
    const-string v1, "thumbUrl"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 41
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v12

    goto :goto_1

    .line 47
    :pswitch_1
    const-string v1, "postToTwitter"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 48
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v3

    goto :goto_1

    .line 49
    :cond_4
    const-string v1, "postToFacebook"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 50
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v4

    goto :goto_1

    .line 55
    :pswitch_2
    const-string v1, "channelId"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 56
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    goto/16 :goto_1

    .line 57
    :cond_5
    const-string v1, "created"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 58
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v13

    goto/16 :goto_1

    .line 59
    :cond_6
    const-string v1, "maxLoops"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 60
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v16

    goto/16 :goto_1

    .line 61
    :cond_7
    const-string v1, "postId"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 62
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v9

    goto/16 :goto_1

    .line 67
    :pswitch_3
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v18

    .line 68
    .local v18, "name":Ljava/lang/String;
    const-string v1, "entities"

    move-object/from16 v0, v18

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 69
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 70
    :goto_2
    if-eqz v20, :cond_0

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v20

    if-eq v0, v1, :cond_0

    .line 71
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseEntity(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEntity;

    move-result-object v17

    .line 72
    .local v17, "entity":Lco/vine/android/api/VineEntity;
    if-nez v7, :cond_8

    .line 73
    new-instance v7, Ljava/util/ArrayList;

    .end local v7    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 75
    .restart local v7    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_8
    if-eqz v17, :cond_9

    .line 76
    move-object/from16 v0, v17

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 78
    :cond_9
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 79
    goto :goto_2

    .line 80
    .end local v17    # "entity":Lco/vine/android/api/VineEntity;
    :cond_a
    const-string v1, "recipients"

    move-object/from16 v0, v18

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 81
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 82
    :goto_3
    if-eqz v20, :cond_0

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v20

    if-eq v0, v1, :cond_0

    .line 83
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineRecipient;->fromJson(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineRecipient;

    move-result-object v19

    .line 84
    .local v19, "recipient":Lco/vine/android/api/VineRecipient;
    if-nez v15, :cond_b

    .line 85
    new-instance v15, Ljava/util/ArrayList;

    .end local v15    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    invoke-direct {v15}, Ljava/util/ArrayList;-><init>()V

    .line 87
    .restart local v15    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    :cond_b
    if-eqz v19, :cond_c

    .line 88
    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 90
    :cond_c
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 91
    goto :goto_3

    .line 93
    .end local v19    # "recipient":Lco/vine/android/api/VineRecipient;
    :cond_d
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 103
    .end local v18    # "name":Ljava/lang/String;
    :cond_e
    new-instance v1, Lco/vine/android/api/VineUpload$PostInfo;

    invoke-direct/range {v1 .. v16}, Lco/vine/android/api/VineUpload$PostInfo;-><init>(Ljava/lang/String;ZZJLjava/util/ArrayList;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/util/ArrayList;I)V

    return-object v1

    .line 29
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
