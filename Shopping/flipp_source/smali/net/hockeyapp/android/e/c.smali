.class public final Lnet/hockeyapp/android/e/c;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    return-void
.end method

.method synthetic constructor <init>(B)V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lnet/hockeyapp/android/e/c;-><init>()V

    return-void
.end method

.method public static a(Ljava/lang/String;)Lnet/hockeyapp/android/c/d;
    .locals 24

    .prologue
    .line 41
    const/4 v3, 0x0

    .line 42
    if-eqz p0, :cond_1

    .line 45
    :try_start_0
    new-instance v5, Lorg/json/JSONObject;

    move-object/from16 v0, p0

    invoke-direct {v5, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 47
    const-string v2, "feedback"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 48
    new-instance v7, Lnet/hockeyapp/android/c/b;

    invoke-direct {v7}, Lnet/hockeyapp/android/c/b;-><init>()V

    .line 51
    const-string v2, "messages"

    invoke-virtual {v6, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v8

    .line 52
    const/4 v2, 0x0

    .line 54
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-lez v4, :cond_0

    .line 56
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 58
    const/4 v4, 0x0

    :goto_0
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v9

    if-ge v4, v9, :cond_0

    .line 59
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "subject"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v9

    .line 60
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v10

    const-string v11, "text"

    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v10

    .line 61
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v11

    const-string v12, "oem"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v11

    .line 62
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v12

    const-string v13, "model"

    invoke-virtual {v12, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v12

    .line 63
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v13

    const-string v14, "os_version"

    invoke-virtual {v13, v14}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v13

    .line 64
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "created_at"

    invoke-virtual {v14, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v14

    .line 65
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v15

    const-string v16, "id"

    invoke-virtual/range {v15 .. v16}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v15

    .line 66
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v16

    const-string v17, "token"

    invoke-virtual/range {v16 .. v17}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v16

    .line 67
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v17

    const-string v18, "via"

    invoke-virtual/range {v17 .. v18}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v17

    .line 68
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v18

    const-string v19, "user_string"

    invoke-virtual/range {v18 .. v19}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v18

    .line 69
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v19

    const-string v20, "clean_text"

    invoke-virtual/range {v19 .. v20}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v19

    .line 70
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v20

    const-string v21, "name"

    invoke-virtual/range {v20 .. v21}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v20

    .line 71
    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v21

    const-string v22, "app_id"

    invoke-virtual/range {v21 .. v22}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v21

    .line 73
    new-instance v22, Lnet/hockeyapp/android/c/c;

    invoke-direct/range {v22 .. v22}, Lnet/hockeyapp/android/c/c;-><init>()V

    .line 74
    move-object/from16 v0, v21

    move-object/from16 v1, v22

    iput-object v0, v1, Lnet/hockeyapp/android/c/c;->m:Ljava/lang/String;

    .line 75
    move-object/from16 v0, v19

    move-object/from16 v1, v22

    iput-object v0, v1, Lnet/hockeyapp/android/c/c;->k:Ljava/lang/String;

    .line 76
    move-object/from16 v0, v22

    iput-object v14, v0, Lnet/hockeyapp/android/c/c;->f:Ljava/lang/String;

    .line 77
    move-object/from16 v0, v22

    iput v15, v0, Lnet/hockeyapp/android/c/c;->g:I

    .line 78
    move-object/from16 v0, v22

    iput-object v12, v0, Lnet/hockeyapp/android/c/c;->d:Ljava/lang/String;

    .line 79
    move-object/from16 v0, v20

    move-object/from16 v1, v22

    iput-object v0, v1, Lnet/hockeyapp/android/c/c;->l:Ljava/lang/String;

    .line 80
    move-object/from16 v0, v22

    iput-object v11, v0, Lnet/hockeyapp/android/c/c;->c:Ljava/lang/String;

    .line 81
    move-object/from16 v0, v22

    iput-object v13, v0, Lnet/hockeyapp/android/c/c;->e:Ljava/lang/String;

    .line 82
    move-object/from16 v0, v22

    iput-object v9, v0, Lnet/hockeyapp/android/c/c;->a:Ljava/lang/String;

    .line 83
    move-object/from16 v0, v22

    iput-object v10, v0, Lnet/hockeyapp/android/c/c;->b:Ljava/lang/String;

    .line 84
    move-object/from16 v0, v16

    move-object/from16 v1, v22

    iput-object v0, v1, Lnet/hockeyapp/android/c/c;->h:Ljava/lang/String;

    .line 85
    move-object/from16 v0, v18

    move-object/from16 v1, v22

    iput-object v0, v1, Lnet/hockeyapp/android/c/c;->j:Ljava/lang/String;

    .line 86
    move/from16 v0, v17

    move-object/from16 v1, v22

    iput v0, v1, Lnet/hockeyapp/android/c/c;->i:I

    .line 88
    move-object/from16 v0, v22

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 58
    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_0

    .line 92
    :cond_0
    iput-object v2, v7, Lnet/hockeyapp/android/c/b;->e:Ljava/util/ArrayList;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 95
    :try_start_1
    const-string v2, "name"

    invoke-virtual {v6, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v7, Lnet/hockeyapp/android/c/b;->a:Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    .line 101
    :goto_1
    :try_start_2
    const-string v2, "email"

    invoke-virtual {v6, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v7, Lnet/hockeyapp/android/c/b;->b:Ljava/lang/String;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 107
    :goto_2
    :try_start_3
    const-string v2, "id"

    invoke-virtual {v6, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v7, Lnet/hockeyapp/android/c/b;->c:I
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    .line 113
    :goto_3
    :try_start_4
    const-string v2, "created_at"

    invoke-virtual {v6, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v7, Lnet/hockeyapp/android/c/b;->d:Ljava/lang/String;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_4

    .line 118
    :goto_4
    :try_start_5
    new-instance v2, Lnet/hockeyapp/android/c/d;

    invoke-direct {v2}, Lnet/hockeyapp/android/c/d;-><init>()V
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_1

    .line 119
    :try_start_6
    iput-object v7, v2, Lnet/hockeyapp/android/c/d;->b:Lnet/hockeyapp/android/c/b;
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_6

    .line 121
    :try_start_7
    const-string v3, "status"

    invoke-virtual {v5, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lnet/hockeyapp/android/c/d;->a:Ljava/lang/String;
    :try_end_7
    .catch Lorg/json/JSONException; {:try_start_7 .. :try_end_7} :catch_5

    .line 128
    :goto_5
    :try_start_8
    const-string v3, "token"

    invoke-virtual {v5, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lnet/hockeyapp/android/c/d;->c:Ljava/lang/String;
    :try_end_8
    .catch Lorg/json/JSONException; {:try_start_8 .. :try_end_8} :catch_7

    .line 137
    :goto_6
    return-object v2

    .line 96
    :catch_0
    move-exception v2

    :try_start_9
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_9
    .catch Lorg/json/JSONException; {:try_start_9 .. :try_end_9} :catch_1

    goto :goto_1

    .line 132
    :catch_1
    move-exception v2

    move-object/from16 v23, v2

    move-object v2, v3

    move-object/from16 v3, v23

    :goto_7
    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_6

    .line 102
    :catch_2
    move-exception v2

    :try_start_a
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_2

    .line 108
    :catch_3
    move-exception v2

    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_3

    .line 114
    :catch_4
    move-exception v2

    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_a
    .catch Lorg/json/JSONException; {:try_start_a .. :try_end_a} :catch_1

    goto :goto_4

    .line 122
    :catch_5
    move-exception v3

    :try_start_b
    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_5

    .line 132
    :catch_6
    move-exception v3

    goto :goto_7

    .line 129
    :catch_7
    move-exception v3

    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_b
    .catch Lorg/json/JSONException; {:try_start_b .. :try_end_b} :catch_6

    goto :goto_6

    :cond_1
    move-object v2, v3

    goto :goto_6
.end method
