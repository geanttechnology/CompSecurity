.class public Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static onClick(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Landroid/view/View;)V
    .locals 11

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x3

    const/4 v7, 0x1

    .line 37
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 38
    check-cast p0, Landroid/app/Activity;

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v1

    .line 39
    invoke-virtual {v1}, Landroid/app/Dialog;->show()V

    .line 833
    :cond_0
    :goto_0
    return-void

    .line 43
    :cond_1
    if-eqz p3, :cond_c

    .line 45
    :try_start_0
    const-string v1, "ref"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "ref"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 46
    const-string v1, "ref"

    const-string v3, "ref"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 47
    :cond_2
    const-string v1, "owner"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string v1, "owner"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 48
    const-string v1, "owner"

    const-string v3, "owner"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 49
    :cond_3
    const-string v1, "size"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    const-string v1, "size"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 50
    const-string v1, "size"

    const-string v3, "size"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 51
    :cond_4
    const-string v1, "thumbnail"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    const-string v1, "thumbnail"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 52
    const-string v1, "thumbnail"

    const-string v3, "thumbnail"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 53
    :cond_5
    const-string v1, "thumbnailHQ"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    const-string v1, "thumbnailHQ"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 54
    const-string v1, "thumbnailHQ"

    const-string v3, "thumbnailHQ"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 55
    :cond_6
    const-string v1, "title"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_7

    const-string v1, "title"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_7

    .line 56
    const-string v1, "title"

    const-string v3, "title"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 57
    :cond_7
    const-string v1, "_id"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_8

    const-string v1, "_id"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_8

    .line 58
    const-string v1, "_id"

    const-string v3, "_id"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 59
    :cond_8
    const-string v1, "f"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_9

    const-string v1, "f"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_9

    .line 60
    const-string v1, "f"

    const-string v3, "f"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 61
    :cond_9
    const-string v1, "tm"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a

    const-string v1, "tm"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_a

    .line 62
    const-string v1, "tm"

    const-string v3, "tm"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 63
    :cond_a
    const-string v1, "tt"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_b

    const-string v1, "tt"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_b

    .line 64
    const-string v1, "tt"

    const-string v3, "tt"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 65
    :cond_b
    const-string v1, "title"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_c

    const-string v1, "title"

    invoke-virtual {p3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_c

    .line 66
    const-string v1, "ptitle"

    const-string v3, "title"

    invoke-virtual {p3, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 74
    :cond_c
    :goto_1
    :try_start_1
    const-string v1, "type"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_d

    .line 75
    const-string v1, "type"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    move-object v2, v1

    .line 77
    :cond_d
    if-eqz v2, :cond_0

    .line 78
    const-string v1, "ON CLICK LISTENER"

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 79
    const-string v1, "web"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 80
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 81
    const-string v2, "url"

    const-string v3, "ref"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    const-string v2, "page:web"

    invoke-static {v2, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 83
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v1, "ref"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setWeb(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 827
    :catch_0
    move-exception v1

    .line 828
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_0

    .line 67
    :catch_1
    move-exception v1

    .line 68
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 84
    :cond_e
    :try_start_2
    const-string v1, "vector"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_f

    const-string v1, "more"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 85
    :cond_f
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "vector"

    const/4 v4, 0x0

    const-string v5, "title"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v1

    .line 87
    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "vector"

    const-string v4, "title"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v2, v1, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getVector(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 88
    :cond_10
    const-string v1, "dj"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_12

    .line 89
    const-string v1, "pageTitle"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 90
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "dj"

    const/4 v4, 0x0

    const-string v5, "title"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v1

    .line 92
    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "dj"

    const-string v4, "title"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v2, v1, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getVector(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    :goto_2
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 100
    const-string v2, "id"

    const-string v3, "ref"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    const-string v2, "page:user"

    invoke-static {v2, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 95
    :cond_11
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "dj"

    const/4 v4, 0x0

    const-string v5, "pageTitle"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v1

    .line 97
    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "dj"

    const-string v4, "pageTitle"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v2, v1, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getVector(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 102
    :cond_12
    const-string v1, "playlist"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1d

    .line 103
    const-string v1, "ref"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_18

    .line 106
    const-string v6, "0"

    const-string v5, ""

    const-string v8, ""

    const-string v4, ""

    .line 107
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 108
    const-string v2, "size"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_13

    .line 109
    const-string v2, "size"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 110
    :cond_13
    const-string v2, "owner"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_14

    .line 111
    const-string v2, "owner"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 112
    :cond_14
    const-string v2, "ownerName"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_15

    .line 113
    const-string v2, "ownerName"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 114
    :cond_15
    const-string v2, "thumbnail"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_16

    .line 115
    const-string v2, "thumbnail"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 116
    :cond_16
    const-string v2, "ownerId"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_17

    .line 117
    const-string v2, "ownerId"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 118
    :cond_17
    const-string v2, "isAlbum"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_75

    .line 119
    const-string v1, "isAlbum"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    move-object v10, v1

    .line 120
    :goto_3
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v7, "0"

    const/4 v9, 0x3

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    move-object v2, v1

    .line 140
    :goto_4
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 141
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v6

    .line 142
    iput-object v2, v6, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 143
    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, -0x1

    move-object v1, p0

    invoke-static/range {v1 .. v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    goto/16 :goto_0

    .line 124
    :cond_18
    const-string v6, "0"

    const-string v5, ""

    const-string v8, ""

    const-string v4, ""

    .line 125
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 126
    const-string v2, "itemCount"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_19

    .line 127
    const-string v2, "itemCount"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 128
    :cond_19
    const-string v2, "ownerName"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1a

    .line 129
    const-string v2, "ownerName"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 130
    :cond_1a
    const-string v2, "cover"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1b

    .line 131
    const-string v2, "cover"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 132
    :cond_1b
    const-string v2, "owner"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1c

    .line 133
    const-string v2, "owner"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 134
    :cond_1c
    const-string v2, "isAlbum"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_74

    .line 135
    const-string v1, "isAlbum"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    move-object v10, v1

    .line 136
    :goto_5
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "_id"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "name"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v7, "0"

    const/4 v9, 0x3

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    move-object v2, v1

    goto/16 :goto_4

    .line 144
    :cond_1d
    const-string v1, "music"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_27

    .line 146
    const-string v1, ""

    .line 147
    const-string v4, ""

    .line 148
    const-string v3, ""

    .line 149
    const-string v2, ""

    .line 150
    const-string v8, ""

    .line 152
    const-string v6, "f"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1e

    .line 153
    const-string v1, "f"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 154
    :cond_1e
    const-string v6, "tm"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_23

    .line 155
    const-string v4, "tm"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 158
    :cond_1f
    :goto_6
    const-string v6, "tt"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_24

    .line 159
    const-string v3, "tt"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 162
    :cond_20
    :goto_7
    const-string v6, "_id"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_21

    .line 163
    const-string v2, "_id"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 164
    :cond_21
    const-string v6, "thumbnail"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_22

    .line 165
    const-string v6, "thumbnail"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 168
    :cond_22
    const-string v6, "source"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_25

    move-object v5, v1

    .line 177
    :goto_8
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const/4 v6, 0x0

    invoke-direct/range {v1 .. v8}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 179
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 180
    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 182
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v2, v0

    iput-object v3, v2, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    .line 183
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v2, v0

    iput-object v1, v2, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 184
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const/4 v2, 0x0

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 185
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const/4 v2, 0x0

    iput v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 186
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto/16 :goto_0

    .line 156
    :cond_23
    const-string v6, "duration"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1f

    .line 157
    const-string v4, "duration"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_6

    .line 160
    :cond_24
    const-string v6, "title"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_20

    .line 161
    const-string v3, "title"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto :goto_7

    .line 170
    :cond_25
    const-string v6, "source"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v9, "youtube"

    invoke-virtual {v6, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_26

    move-object v5, v1

    .line 171
    goto :goto_8

    .line 172
    :cond_26
    const-string v6, "source"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v9, "soundcloud"

    invoke-virtual {v6, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_73

    .line 174
    const-string v1, "trackId"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    move v7, v5

    move-object v5, v1

    goto :goto_8

    .line 188
    :cond_27
    const-string v1, "followInfo"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_28

    .line 189
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v3, "ref"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const-string v5, ""

    invoke-virtual {v1, v3, v2, v4, v5}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v1

    .line 190
    const-string v3, "ref"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "title"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v3, v1, v2, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getVector(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 191
    :cond_28
    const-string v1, "button"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 192
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_29

    .line 193
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080103

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 195
    :cond_29
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "follow"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2a

    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "unfollow"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3e

    .line 197
    :cond_2a
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-nez v1, :cond_2b

    .line 198
    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/16 v2, 0x9

    invoke-direct {v1, p0, v2}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;-><init>(Landroid/content/Context;I)V

    .line 199
    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->show()Landroid/app/AlertDialog;

    goto/16 :goto_0

    .line 203
    :cond_2b
    new-instance v1, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 204
    const-string v2, "switch"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_72

    .line 205
    const-string v1, "switch"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    move-object v2, v1

    .line 207
    :goto_9
    const-string v1, "title"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2c

    .line 208
    const-string v1, "title"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 212
    :goto_a
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 213
    const-string v3, "title"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2e

    .line 214
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 217
    const-string v1, "ref"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 218
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "follow"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2d

    .line 219
    const-string v3, "true"

    .line 220
    invoke-static {v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->followUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    move-object v7, v1

    .line 226
    :goto_b
    const/4 v8, 0x0

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;

    move-object v2, p0

    move-object v5, p4

    move-object v6, p1

    invoke-direct/range {v1 .. v6}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$1;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lorg/json/JSONObject;)V

    invoke-static {v7, v8, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto/16 :goto_0

    .line 210
    :cond_2c
    const-string v6, ""

    goto :goto_a

    .line 223
    :cond_2d
    const-string v3, "false"

    .line 224
    invoke-static {v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->unfollowUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    move-object v7, v1

    goto :goto_b

    .line 263
    :cond_2e
    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_30

    .line 264
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v3, "title"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 267
    const-string v1, "ref"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 268
    const-string v1, "action"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "follow"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2f

    .line 269
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->followUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 270
    const-string v4, "true"

    move-object v7, v1

    .line 276
    :goto_c
    const/4 v8, 0x0

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;

    move-object v2, p0

    move-object v5, p4

    invoke-direct/range {v1 .. v6}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Ljava/lang/String;)V

    invoke-static {v7, v8, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto/16 :goto_0

    .line 273
    :cond_2f
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->unfollowUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 274
    const-string v4, "false"

    move-object v7, v1

    goto :goto_c

    .line 297
    :cond_30
    if-eqz p2, :cond_0

    .line 298
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v2, ""

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 299
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_32

    .line 301
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_35

    .line 303
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 304
    const-string v2, "obj1IsSwitch"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 305
    const-string v2, "obj1IsSwitch"

    const/4 v3, 0x1

    invoke-virtual {p2, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 306
    const-string v2, "object1"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "switch"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 307
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 308
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 312
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "ref"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 313
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "action"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "follow"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_34

    .line 314
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->followUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 315
    const-string v2, "true"

    .line 321
    :goto_d
    const/4 v4, 0x0

    new-instance v5, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$3;

    invoke-direct {v5, p0, v3, v2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$3;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v1, v4, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 399
    :cond_31
    :goto_e
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v2, " "

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 402
    :cond_32
    const-string v1, "mainText"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_33

    .line 403
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v2, "mainText"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 406
    :cond_33
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 408
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v2, " "

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 410
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3a

    .line 412
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 413
    const-string v2, "obj2IsSwitch"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 414
    const-string v2, "obj2IsSwitch"

    const/4 v3, 0x1

    invoke-virtual {p2, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 415
    const-string v2, "object2"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "switch"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 416
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 417
    check-cast p4, Landroid/widget/TextView;

    invoke-static {p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 421
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "ref"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 422
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "action"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "follow"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_39

    .line 423
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->followUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 424
    const-string v2, "true"

    .line 430
    :goto_f
    const/4 v4, 0x0

    new-instance v5, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$5;

    invoke-direct {v5, p0, v3, v2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$5;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v1, v4, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto/16 :goto_0

    .line 318
    :cond_34
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->unfollowUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 319
    const-string v2, "false"

    goto/16 :goto_d

    .line 342
    :cond_35
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_37

    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_37

    .line 344
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 345
    const-string v2, "obj1IsSwitch"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 346
    const-string v2, "obj1IsSwitch"

    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 347
    const-string v2, "object1"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 348
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 349
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 353
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "ref"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 354
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "action"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "follow"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_36

    .line 355
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->followUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 356
    const-string v2, "true"

    .line 362
    :goto_10
    const/4 v4, 0x0

    new-instance v5, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$4;

    invoke-direct {v5, p0, v3, v2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$4;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v1, v4, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto/16 :goto_e

    .line 359
    :cond_36
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->unfollowUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 360
    const-string v2, "false"

    goto :goto_10

    .line 383
    :cond_37
    const-string v1, "obj1IsSwitch"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_31

    .line 384
    const-string v1, "obj1IsSwitch"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 385
    if-eqz v1, :cond_38

    .line 386
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 387
    const-string v2, "object1"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "switch"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 388
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 389
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    goto/16 :goto_e

    .line 392
    :cond_38
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 393
    const-string v2, "object1"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 394
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 395
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    goto/16 :goto_e

    .line 427
    :cond_39
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->unfollowUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 428
    const-string v2, "false"

    goto/16 :goto_f

    .line 451
    :cond_3a
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3c

    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3c

    .line 453
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 454
    const-string v2, "obj2IsSwitch"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 455
    const-string v2, "obj2IsSwitch"

    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 456
    const-string v2, "object2"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 457
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 458
    check-cast p4, Landroid/widget/TextView;

    invoke-static {p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 462
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "ref"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 463
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "action"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "follow"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3b

    .line 464
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->followUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 465
    const-string v2, "true"

    .line 471
    :goto_11
    const/4 v4, 0x0

    new-instance v5, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;

    invoke-direct {v5, p0, v3, v2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v1, v4, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto/16 :goto_0

    .line 468
    :cond_3b
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->unfollowUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 469
    const-string v2, "false"

    goto :goto_11

    .line 492
    :cond_3c
    const-string v1, "obj2IsSwitch"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 493
    const-string v1, "obj2IsSwitch"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 494
    if-eqz v1, :cond_3d

    .line 495
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 496
    const-string v2, "object2"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "switch"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 497
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 498
    check-cast p4, Landroid/widget/TextView;

    invoke-static {p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    goto/16 :goto_0

    .line 501
    :cond_3d
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 502
    const-string v2, "object2"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 503
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 504
    check-cast p4, Landroid/widget/TextView;

    invoke-static {p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    goto/16 :goto_0

    .line 513
    :cond_3e
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "subscribe"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3f

    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "unsubscribe"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_58

    .line 515
    :cond_3f
    new-instance v1, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 516
    const-string v2, "switch"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_71

    .line 517
    const-string v1, "switch"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    move-object v3, v1

    .line 519
    :goto_12
    const-string v1, "title"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_40

    .line 520
    const-string v1, "title"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    move-object v2, v1

    .line 524
    :goto_13
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 525
    const-string v4, "title"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_43

    .line 526
    check-cast p4, Landroid/widget/TextView;

    invoke-virtual {p4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 528
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "subscribe"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_41

    .line 529
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 530
    const-string v2, "isAlbum"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_70

    .line 531
    const-string v1, "isAlbum"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    move-object v10, v1

    .line 532
    :goto_14
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ptitle"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, "owner"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "size"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const-string v8, "thumbnail"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x3

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 533
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    goto/16 :goto_0

    .line 522
    :cond_40
    const-string v1, ""

    move-object v2, v1

    goto :goto_13

    .line 536
    :cond_41
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v1, :cond_42

    .line 537
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v1, "ref"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 539
    :cond_42
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deletePlaylist(Ljava/lang/String;)I

    .line 540
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 541
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0

    .line 545
    :cond_43
    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_46

    .line 546
    check-cast p4, Landroid/widget/TextView;

    const-string v1, "title"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p4, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 547
    const-string v1, "action"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "subscribe"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_44

    .line 548
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 549
    const-string v2, "isAlbum"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6f

    .line 550
    const-string v1, "isAlbum"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    move-object v10, v1

    .line 551
    :goto_15
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ptitle"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, "owner"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "size"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const-string v8, "thumbnail"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x3

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 552
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    goto/16 :goto_0

    .line 555
    :cond_44
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v1, :cond_45

    .line 556
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v1, "ref"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 558
    :cond_45
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deletePlaylist(Ljava/lang/String;)I

    .line 559
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 560
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0

    .line 564
    :cond_46
    if-eqz p2, :cond_0

    .line 565
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v2, ""

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 566
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_48

    .line 568
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4c

    .line 570
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 571
    const-string v2, "obj1IsSwitch"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 572
    const-string v2, "obj1IsSwitch"

    const/4 v3, 0x1

    invoke-virtual {p2, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 573
    const-string v2, "object1"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "switch"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 574
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 575
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 577
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "action"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "subscribe"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4a

    .line 578
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 579
    const-string v2, "isAlbum"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6e

    .line 580
    const-string v1, "isAlbum"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    move-object v10, v1

    .line 581
    :goto_16
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ptitle"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, "owner"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "size"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const-string v8, "thumbnail"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x3

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 582
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v2, v0

    const/4 v3, 0x1

    invoke-virtual {v2, v1, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    .line 638
    :cond_47
    :goto_17
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v2, " "

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 641
    :cond_48
    const-string v1, "mainText"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_49

    .line 642
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v2, "mainText"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 645
    :cond_49
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 647
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    const-string v2, " "

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 649
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_53

    .line 651
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 652
    const-string v2, "obj2IsSwitch"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 653
    const-string v2, "obj2IsSwitch"

    const/4 v3, 0x1

    invoke-virtual {p2, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 654
    const-string v2, "object2"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "switch"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 655
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 656
    check-cast p4, Landroid/widget/TextView;

    invoke-static {p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 658
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "action"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "subscribe"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_51

    .line 659
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 660
    const-string v2, "isAlbum"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6c

    .line 661
    const-string v1, "isAlbum"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    move-object v10, v1

    .line 662
    :goto_18
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ptitle"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, "owner"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "size"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const-string v8, "thumbnail"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x3

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 663
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    goto/16 :goto_0

    .line 585
    :cond_4a
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v1, :cond_4b

    .line 586
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_17

    .line 588
    :cond_4b
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deletePlaylist(Ljava/lang/String;)I

    .line 589
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 590
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_17

    .line 595
    :cond_4c
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4f

    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4f

    .line 597
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 598
    const-string v2, "obj1IsSwitch"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 599
    const-string v2, "obj1IsSwitch"

    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 600
    const-string v2, "object1"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 601
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 602
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 604
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "action"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "subscribe"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4d

    .line 605
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 606
    const-string v2, "isAlbum"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6d

    .line 607
    const-string v1, "isAlbum"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    move-object v10, v1

    .line 608
    :goto_19
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ptitle"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, "owner"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "size"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const-string v8, "thumbnail"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x3

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 609
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v2, v0

    const/4 v3, 0x1

    invoke-virtual {v2, v1, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    goto/16 :goto_17

    .line 612
    :cond_4d
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v1, :cond_4e

    .line 613
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_17

    .line 615
    :cond_4e
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deletePlaylist(Ljava/lang/String;)I

    .line 616
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 617
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_17

    .line 622
    :cond_4f
    const-string v1, "obj1IsSwitch"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_47

    .line 623
    const-string v1, "obj1IsSwitch"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 624
    if-eqz v1, :cond_50

    .line 625
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 626
    const-string v2, "object1"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "switch"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 627
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 628
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    goto/16 :goto_17

    .line 631
    :cond_50
    const-string v1, "object1"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 632
    const-string v2, "object1"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 633
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 634
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    goto/16 :goto_17

    .line 666
    :cond_51
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v1, :cond_52

    .line 667
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v1, "ref"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 669
    :cond_52
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deletePlaylist(Ljava/lang/String;)I

    .line 670
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 671
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0

    .line 676
    :cond_53
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_56

    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_56

    .line 678
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 679
    const-string v2, "obj2IsSwitch"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 680
    const-string v2, "obj2IsSwitch"

    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 681
    const-string v2, "object2"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 682
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 683
    check-cast p4, Landroid/widget/TextView;

    invoke-static {p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 685
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "action"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "subscribe"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_54

    .line 686
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 687
    const-string v2, "isAlbum"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6b

    .line 688
    const-string v1, "isAlbum"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    move-object v10, v1

    .line 689
    :goto_1a
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ptitle"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, "owner"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "size"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const-string v8, "thumbnail"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x3

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 690
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    goto/16 :goto_0

    .line 693
    :cond_54
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v1, :cond_55

    .line 694
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v1, "ref"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 696
    :cond_55
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deletePlaylist(Ljava/lang/String;)I

    .line 697
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 698
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0

    .line 703
    :cond_56
    const-string v1, "obj2IsSwitch"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 704
    const-string v1, "obj2IsSwitch"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 705
    if-eqz v1, :cond_57

    .line 706
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "switch"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 707
    const-string v2, "object2"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "switch"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 708
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 709
    check-cast p4, Landroid/widget/TextView;

    invoke-static {p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    goto/16 :goto_0

    .line 712
    :cond_57
    const-string v1, "object2"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 713
    const-string v2, "object2"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    invoke-direct {v3, p0, v1, p3, p2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-static {v2, v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v2

    .line 714
    move-object v0, p4

    check-cast v0, Landroid/widget/TextView;

    move-object v1, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 715
    check-cast p4, Landroid/widget/TextView;

    invoke-static {p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    goto/16 :goto_0

    .line 723
    :cond_58
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "shareMusic"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5a

    .line 724
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://www.mixerbox.com/music/0/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "f"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 725
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800ba

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800b8

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 726
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800b9

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 727
    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.intent.action.SEND"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 728
    const-string v5, "text/plain"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 729
    const-string v5, "android.intent.extra.SUBJECT"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "tt"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 730
    const-string v5, "android.intent.extra.TEXT"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v6, "tt"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v5, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 731
    const/4 v1, 0x0

    invoke-static {v4, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 733
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 734
    const-string v2, "f"

    const-string v3, "f"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 735
    const-string v2, "_id"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_59

    .line 736
    const-string v2, "id"

    const-string v3, "_id"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 737
    :cond_59
    const-string v2, "playlist"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 738
    const-string v2, "t"

    const-string v3, "yt"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 739
    const-string v2, "action:music_share"

    invoke-static {v2, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 741
    :cond_5a
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "sharePlaylist"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5b

    .line 742
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 743
    const-string v2, "id"

    const-string v3, "ref"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 744
    const-string v2, "action:share_playlist"

    invoke-static {v2, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 745
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://www.mixerbox.com/list/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 746
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800ba

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800b8

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 747
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800b9

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 748
    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.intent.action.SEND"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 749
    const-string v5, "text/plain"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 750
    const-string v5, "android.intent.extra.SUBJECT"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "ptitle"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 751
    const-string v5, "android.intent.extra.TEXT"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v6, "ptitle"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v5, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 752
    const/4 v1, 0x0

    invoke-static {v4, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 754
    :cond_5b
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "addMusic"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_64

    .line 755
    const-string v1, ""

    .line 756
    const-string v4, ""

    .line 757
    const-string v3, ""

    .line 758
    const-string v2, ""

    .line 759
    const-string v8, ""

    .line 761
    const-string v6, "f"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_5c

    .line 762
    const-string v1, "f"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 763
    :cond_5c
    const-string v6, "tm"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_60

    .line 764
    const-string v4, "tm"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 767
    :cond_5d
    :goto_1b
    const-string v6, "tt"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_61

    .line 768
    const-string v3, "tt"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 771
    :cond_5e
    :goto_1c
    const-string v6, "_id"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_5f

    .line 772
    const-string v2, "_id"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 775
    :cond_5f
    const-string v6, "source"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_62

    move-object v5, v1

    .line 786
    :goto_1d
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const/4 v6, 0x0

    invoke-direct/range {v1 .. v8}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 788
    new-instance v2, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    invoke-direct {v2, p0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V

    .line 789
    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->show()Landroid/app/AlertDialog;

    move-result-object v1

    .line 790
    invoke-virtual {v1}, Landroid/app/AlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/16 v2, 0x10

    invoke-virtual {v1, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    goto/16 :goto_0

    .line 765
    :cond_60
    const-string v6, "duration"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_5d

    .line 766
    const-string v4, "duration"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_1b

    .line 769
    :cond_61
    const-string v6, "title"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_5e

    .line 770
    const-string v3, "title"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto :goto_1c

    .line 777
    :cond_62
    const-string v6, "source"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v9, "youtube"

    invoke-virtual {v6, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_63

    move-object v5, v1

    .line 778
    goto :goto_1d

    .line 779
    :cond_63
    const-string v6, "source"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v9, "soundcloud"

    invoke-virtual {v6, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6a

    .line 781
    const-string v1, "trackId"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 782
    const-string v6, "thumbnail"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_69

    .line 783
    const-string v6, "thumbnail"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    move v7, v5

    move-object v5, v1

    goto :goto_1d

    .line 792
    :cond_64
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "more"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_66

    .line 793
    const-string v1, "pageType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_65

    const-string v1, "pageType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "dj"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_65

    .line 794
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "dj"

    const/4 v4, 0x0

    const-string v5, "pageTitle"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v1

    .line 796
    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "dj"

    const-string v4, "pageTitle"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v2, v1, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getVector(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 797
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 798
    const-string v2, "id"

    const-string v3, "ref"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 799
    const-string v2, "page:user"

    invoke-static {v2, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 802
    :cond_65
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "vector"

    const/4 v4, 0x0

    const-string v5, "pageTitle"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v1

    .line 804
    const-string v2, "ref"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "vector"

    const-string v4, "pageTitle"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v2, v1, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getVector(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 807
    :cond_66
    const-string v1, "action"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "api"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_68

    .line 808
    const-string v1, "apiInfo"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 809
    const-string v2, "funcName"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "searchVideo"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_67

    const-string v2, "method"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "GET"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_67

    .line 810
    const-string v2, "arguments"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 811
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    const-string v3, "VECTORIDSEARCH"

    const-string v4, "category"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x3

    const-string v6, "q"

    invoke-virtual {v2, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v3, v4, v5, v6}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v1

    .line 813
    const-string v3, "q"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "category"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v3, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->setSearchCategory(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 816
    :cond_67
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080103

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 820
    :cond_68
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080103

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    :cond_69
    move v7, v5

    move-object v5, v1

    goto/16 :goto_1d

    :cond_6a
    move-object v5, v1

    goto/16 :goto_1d

    :cond_6b
    move-object v10, v1

    goto/16 :goto_1a

    :cond_6c
    move-object v10, v1

    goto/16 :goto_18

    :cond_6d
    move-object v10, v1

    goto/16 :goto_19

    :cond_6e
    move-object v10, v1

    goto/16 :goto_16

    :cond_6f
    move-object v10, v1

    goto/16 :goto_15

    :cond_70
    move-object v10, v1

    goto/16 :goto_14

    :cond_71
    move-object v3, v1

    goto/16 :goto_12

    :cond_72
    move-object v2, v1

    goto/16 :goto_9

    :cond_73
    move-object v5, v1

    goto/16 :goto_8

    :cond_74
    move-object v10, v1

    goto/16 :goto_5

    :cond_75
    move-object v10, v1

    goto/16 :goto_3
.end method
