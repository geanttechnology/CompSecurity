.class public Lcom/google/android/gms/internal/zzkf;
.super Ljava/lang/Object;


# static fields
.field private static final zzTy:Lcom/google/android/gms/cast/internal/zzl;


# instance fields
.field protected final zzVU:Lcom/google/android/gms/internal/zzke;

.field protected final zzWA:Ljava/lang/String;

.field protected final zzWB:Ljava/lang/String;

.field protected final zzWn:Ljava/lang/String;

.field protected final zzWo:J

.field protected final zzWp:Lorg/json/JSONObject;

.field protected final zzWt:I

.field protected final zzWu:I

.field protected final zzWv:Ljava/lang/String;

.field protected final zzWw:I

.field protected final zzWx:I

.field protected final zzWy:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/zzkj;",
            ">;"
        }
    .end annotation
.end field

.field protected final zzWz:Lorg/json/JSONObject;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/google/android/gms/cast/internal/zzl;

    const-string v1, "GameManagerMessage"

    invoke-direct {v0, v1}, Lcom/google/android/gms/cast/internal/zzl;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/zzkf;->zzTy:Lcom/google/android/gms/cast/internal/zzl;

    return-void
.end method

.method public constructor <init>(IILjava/lang/String;Lorg/json/JSONObject;IILjava/util/List;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/google/android/gms/internal/zzke;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "II",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/zzkj;",
            ">;",
            "Lorg/json/JSONObject;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "J",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/zzke;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/zzkf;->zzWt:I

    iput p2, p0, Lcom/google/android/gms/internal/zzkf;->zzWu:I

    iput-object p3, p0, Lcom/google/android/gms/internal/zzkf;->zzWv:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzkf;->zzWp:Lorg/json/JSONObject;

    iput p5, p0, Lcom/google/android/gms/internal/zzkf;->zzWw:I

    iput p6, p0, Lcom/google/android/gms/internal/zzkf;->zzWx:I

    iput-object p7, p0, Lcom/google/android/gms/internal/zzkf;->zzWy:Ljava/util/List;

    iput-object p8, p0, Lcom/google/android/gms/internal/zzkf;->zzWz:Lorg/json/JSONObject;

    iput-object p9, p0, Lcom/google/android/gms/internal/zzkf;->zzWA:Ljava/lang/String;

    iput-object p10, p0, Lcom/google/android/gms/internal/zzkf;->zzWn:Ljava/lang/String;

    iput-wide p11, p0, Lcom/google/android/gms/internal/zzkf;->zzWo:J

    iput-object p13, p0, Lcom/google/android/gms/internal/zzkf;->zzWB:Ljava/lang/String;

    iput-object p14, p0, Lcom/google/android/gms/internal/zzkf;->zzVU:Lcom/google/android/gms/internal/zzke;

    return-void
.end method

.method private static zza(Lorg/json/JSONArray;)Ljava/util/List;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/zzkj;",
            ">;"
        }
    .end annotation

    const/4 v1, 0x0

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    if-nez p0, :cond_0

    move-object v0, v2

    :goto_0
    return-object v0

    :cond_0
    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_2

    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_1

    const/4 v4, 0x0

    :try_start_0
    new-instance v3, Lcom/google/android/gms/internal/zzkj;

    invoke-direct {v3, v5}, Lcom/google/android/gms/internal/zzkj;-><init>(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_2
    if-eqz v3, :cond_1

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :catch_0
    move-exception v3

    sget-object v5, Lcom/google/android/gms/internal/zzkf;->zzTy:Lcom/google/android/gms/cast/internal/zzl;

    const-string v6, "Exception when attempting to parse PlayerInfoMessageComponent at index %d"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v1

    invoke-virtual {v5, v3, v6, v7}, Lcom/google/android/gms/cast/internal/zzl;->zzc(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    move-object v3, v4

    goto :goto_2

    :cond_2
    move-object v0, v2

    goto :goto_0
.end method

.method protected static zzh(Lorg/json/JSONObject;)Lcom/google/android/gms/internal/zzkf;
    .locals 15

    const-string v0, "type"

    const/4 v1, -0x1

    invoke-virtual {p0, v0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v1

    packed-switch v1, :pswitch_data_0

    :try_start_0
    sget-object v0, Lcom/google/android/gms/internal/zzkf;->zzTy:Lcom/google/android/gms/cast/internal/zzl;

    const-string v2, "Unrecognized Game Message type %d"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v3, v4

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/cast/internal/zzl;->zzf(Ljava/lang/String;[Ljava/lang/Object;)V

    :goto_0
    const/4 v0, 0x0

    :goto_1
    return-object v0

    :pswitch_0
    new-instance v0, Lcom/google/android/gms/internal/zzkf;

    const-string v2, "statusCode"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v2

    const-string v3, "errorDescription"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "extraMessageData"

    invoke-virtual {p0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "gameplayState"

    invoke-virtual {p0, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v5

    const-string v6, "lobbyState"

    invoke-virtual {p0, v6}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v6

    const-string v7, "players"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    invoke-static {v7}, Lcom/google/android/gms/internal/zzkf;->zza(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v7

    const-string v8, "gameData"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    const-string v9, "gameStatusText"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    const-string v10, "playerId"

    invoke-virtual {p0, v10}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const-wide/16 v11, -0x1

    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-direct/range {v0 .. v14}, Lcom/google/android/gms/internal/zzkf;-><init>(IILjava/lang/String;Lorg/json/JSONObject;IILjava/util/List;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/google/android/gms/internal/zzke;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    sget-object v1, Lcom/google/android/gms/internal/zzkf;->zzTy:Lcom/google/android/gms/cast/internal/zzl;

    const-string v2, "Exception while parsing GameManagerMessage from json"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v1, v0, v2, v3}, Lcom/google/android/gms/cast/internal/zzl;->zzc(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    :pswitch_1
    const/4 v14, 0x0

    :try_start_1
    const-string v0, "gameManagerConfig"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v14, Lcom/google/android/gms/internal/zzke;

    invoke-direct {v14, v0}, Lcom/google/android/gms/internal/zzke;-><init>(Lorg/json/JSONObject;)V

    :cond_0
    new-instance v0, Lcom/google/android/gms/internal/zzkf;

    const-string v2, "statusCode"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v2

    const-string v3, "errorDescription"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "extraMessageData"

    invoke-virtual {p0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "gameplayState"

    invoke-virtual {p0, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v5

    const-string v6, "lobbyState"

    invoke-virtual {p0, v6}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v6

    const-string v7, "players"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    invoke-static {v7}, Lcom/google/android/gms/internal/zzkf;->zza(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v7

    const-string v8, "gameData"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    const-string v9, "gameStatusText"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    const-string v10, "playerId"

    invoke-virtual {p0, v10}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const-string v11, "requestId"

    invoke-virtual {p0, v11}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v11

    const-string v13, "playerToken"

    invoke-virtual {p0, v13}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-direct/range {v0 .. v14}, Lcom/google/android/gms/internal/zzkf;-><init>(IILjava/lang/String;Lorg/json/JSONObject;IILjava/util/List;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/google/android/gms/internal/zzke;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public final getExtraMessageData()Lorg/json/JSONObject;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWp:Lorg/json/JSONObject;

    return-object v0
.end method

.method public final getGameData()Lorg/json/JSONObject;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWz:Lorg/json/JSONObject;

    return-object v0
.end method

.method public final getGameplayState()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWw:I

    return v0
.end method

.method public final getLobbyState()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWx:I

    return v0
.end method

.method public final getPlayerId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWn:Ljava/lang/String;

    return-object v0
.end method

.method public final getRequestId()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWo:J

    return-wide v0
.end method

.method public final getStatusCode()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWu:I

    return v0
.end method

.method public final zzmm()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWt:I

    return v0
.end method

.method public final zzmn()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWv:Ljava/lang/String;

    return-object v0
.end method

.method public final zzmo()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/zzkj;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWy:Ljava/util/List;

    return-object v0
.end method

.method public final zzmp()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWA:Ljava/lang/String;

    return-object v0
.end method

.method public final zzmq()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkf;->zzWB:Ljava/lang/String;

    return-object v0
.end method

.method public final zzmr()Lcom/google/android/gms/internal/zzke;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkf;->zzVU:Lcom/google/android/gms/internal/zzke;

    return-object v0
.end method
