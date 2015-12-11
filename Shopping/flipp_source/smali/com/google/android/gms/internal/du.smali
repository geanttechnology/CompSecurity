.class public final Lcom/google/android/gms/internal/du;
.super Ljava/lang/Object;


# static fields
.field private static final a:Ljava/text/SimpleDateFormat;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyyMMdd"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/du;->a:Ljava/text/SimpleDateFormat;

    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/google/android/gms/internal/bz;Ljava/lang/String;)Lcom/google/android/gms/internal/cb;
    .locals 16

    :try_start_0
    new-instance v11, Lorg/json/JSONObject;

    move-object/from16 v0, p2

    invoke-direct {v11, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v2, "ad_base_url"

    const/4 v3, 0x0

    invoke-virtual {v11, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v2, "ad_url"

    const/4 v3, 0x0

    invoke-virtual {v11, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v2, "ad_size"

    const/4 v5, 0x0

    invoke-virtual {v11, v2, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    const-string v2, "ad_html"

    const/4 v5, 0x0

    invoke-virtual {v11, v2, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v2, "interstitial_timeout"

    invoke-virtual {v11, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v2, "interstitial_timeout"

    invoke-virtual {v11, v2}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    mul-double/2addr v6, v8

    double-to-long v8, v6

    :goto_0
    const-string v2, "orientation"

    const/4 v6, 0x0

    invoke-virtual {v11, v2, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v14, -0x1

    const-string v6, "portrait"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-static {}, Lcom/google/android/gms/internal/ej;->c()I

    move-result v14

    :cond_0
    :goto_1
    const/4 v2, 0x0

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_3

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_13

    const-string v2, "Could not parse the mediation config: Missing required ad_base_url field"

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    new-instance v3, Lcom/google/android/gms/internal/cb;

    const/4 v2, 0x0

    invoke-direct {v3, v2}, Lcom/google/android/gms/internal/cb;-><init>(I)V

    :goto_2
    return-object v3

    :cond_1
    const-wide/16 v8, -0x1

    goto :goto_0

    :cond_2
    const-string v6, "landscape"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-static {}, Lcom/google/android/gms/internal/ej;->b()I

    move-result v14

    goto :goto_1

    :cond_3
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_5

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gms/internal/bz;->k:Lcom/google/android/gms/internal/cu;

    iget-object v2, v2, Lcom/google/android/gms/internal/cu;->b:Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-static {v0, v2, v3}, Lcom/google/android/gms/internal/dr;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/cb;

    move-result-object v2

    iget-object v4, v2, Lcom/google/android/gms/internal/cb;->b:Ljava/lang/String;

    iget-object v5, v2, Lcom/google/android/gms/internal/cb;->c:Ljava/lang/String;

    move-object v10, v2

    :goto_3
    const-string v2, "click_urls"

    invoke-virtual {v11, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    if-nez v10, :cond_6

    const/4 v2, 0x0

    :goto_4
    if-eqz v6, :cond_12

    if-nez v2, :cond_4

    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    :cond_4
    const/4 v3, 0x0

    :goto_5
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v7

    if-ge v3, v7, :cond_7

    invoke-virtual {v6, v3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v3, v3, 0x1

    goto :goto_5

    :cond_5
    const-string v2, "Could not parse the mediation config: Missing required ad_html or ad_url field."

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    new-instance v3, Lcom/google/android/gms/internal/cb;

    const/4 v2, 0x0

    invoke-direct {v3, v2}, Lcom/google/android/gms/internal/cb;-><init>(I)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    :catch_0
    move-exception v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Could not parse the mediation config: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    new-instance v3, Lcom/google/android/gms/internal/cb;

    const/4 v2, 0x0

    invoke-direct {v3, v2}, Lcom/google/android/gms/internal/cb;-><init>(I)V

    goto :goto_2

    :cond_6
    :try_start_1
    iget-object v2, v10, Lcom/google/android/gms/internal/cb;->d:Ljava/util/List;

    goto :goto_4

    :cond_7
    move-object v6, v2

    :goto_6
    const-string v2, "impression_urls"

    invoke-virtual {v11, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    if-nez v10, :cond_9

    const/4 v2, 0x0

    :goto_7
    if-eqz v7, :cond_11

    if-nez v2, :cond_8

    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    :cond_8
    const/4 v3, 0x0

    :goto_8
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v12

    if-ge v3, v12, :cond_a

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-interface {v2, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v3, v3, 0x1

    goto :goto_8

    :cond_9
    iget-object v2, v10, Lcom/google/android/gms/internal/cb;->f:Ljava/util/List;

    goto :goto_7

    :cond_a
    move-object v7, v2

    :goto_9
    const-string v2, "manual_impression_urls"

    invoke-virtual {v11, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v11

    if-nez v10, :cond_c

    const/4 v2, 0x0

    :goto_a
    if-eqz v11, :cond_10

    if-nez v2, :cond_b

    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    :cond_b
    const/4 v3, 0x0

    :goto_b
    invoke-virtual {v11}, Lorg/json/JSONArray;->length()I

    move-result v12

    if-ge v3, v12, :cond_d

    invoke-virtual {v11, v3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-interface {v2, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v3, v3, 0x1

    goto :goto_b

    :cond_c
    iget-object v2, v10, Lcom/google/android/gms/internal/cb;->j:Ljava/util/List;

    goto :goto_a

    :cond_d
    move-object v11, v2

    :goto_c
    if-eqz v10, :cond_f

    iget v2, v10, Lcom/google/android/gms/internal/cb;->l:I

    const/4 v3, -0x1

    if-eq v2, v3, :cond_e

    iget v14, v10, Lcom/google/android/gms/internal/cb;->l:I

    :cond_e
    iget-wide v2, v10, Lcom/google/android/gms/internal/cb;->g:J

    const-wide/16 v12, 0x0

    cmp-long v2, v2, v12

    if-lez v2, :cond_f

    iget-wide v8, v10, Lcom/google/android/gms/internal/cb;->g:J

    :cond_f
    new-instance v3, Lcom/google/android/gms/internal/cb;

    const/4 v10, 0x0

    const-wide/16 v12, -0x1

    invoke-direct/range {v3 .. v15}, Lcom/google/android/gms/internal/cb;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JZLjava/util/List;JILjava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_2

    :cond_10
    move-object v11, v2

    goto :goto_c

    :cond_11
    move-object v7, v2

    goto :goto_9

    :cond_12
    move-object v6, v2

    goto :goto_6

    :cond_13
    move-object v10, v2

    goto/16 :goto_3
.end method

.method private static a(Z)Ljava/lang/Integer;
    .locals 1

    if-eqz p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static a(I)Ljava/lang/String;
    .locals 5

    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v1, "#%06x"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const v4, 0xffffff

    and-int/2addr v4, p0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/ea;)Ljava/lang/String;
    .locals 14

    const-wide v12, 0x416312d000000000L    # 1.0E7

    const/4 v0, 0x0

    const/4 v11, -0x2

    const/4 v10, 0x2

    const/4 v9, -0x1

    :try_start_0
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->b:Landroid/os/Bundle;

    if-eqz v1, :cond_0

    const-string v1, "ad_pos"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->b:Landroid/os/Bundle;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->c:Lcom/google/android/gms/internal/v;

    invoke-static {}, Lcom/google/android/gms/internal/ed;->a()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    const-string v4, "abf"

    invoke-virtual {v3, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    iget-wide v4, v1, Lcom/google/android/gms/internal/v;->b:J

    const-wide/16 v6, -0x1

    cmp-long v2, v4, v6

    if-eqz v2, :cond_2

    const-string v2, "cust_age"

    sget-object v4, Lcom/google/android/gms/internal/du;->a:Ljava/text/SimpleDateFormat;

    new-instance v5, Ljava/util/Date;

    iget-wide v6, v1, Lcom/google/android/gms/internal/v;->b:J

    invoke-direct {v5, v6, v7}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v4, v5}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    iget-object v2, v1, Lcom/google/android/gms/internal/v;->c:Landroid/os/Bundle;

    if-eqz v2, :cond_3

    const-string v2, "extras"

    iget-object v4, v1, Lcom/google/android/gms/internal/v;->c:Landroid/os/Bundle;

    invoke-virtual {v3, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    iget v2, v1, Lcom/google/android/gms/internal/v;->d:I

    if-eq v2, v9, :cond_4

    const-string v2, "cust_gender"

    iget v4, v1, Lcom/google/android/gms/internal/v;->d:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_4
    iget-object v2, v1, Lcom/google/android/gms/internal/v;->e:Ljava/util/List;

    if-eqz v2, :cond_5

    const-string v2, "kw"

    iget-object v4, v1, Lcom/google/android/gms/internal/v;->e:Ljava/util/List;

    invoke-virtual {v3, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5
    iget v2, v1, Lcom/google/android/gms/internal/v;->g:I

    if-eq v2, v9, :cond_6

    const-string v2, "tag_for_child_directed_treatment"

    iget v4, v1, Lcom/google/android/gms/internal/v;->g:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_6
    iget-boolean v2, v1, Lcom/google/android/gms/internal/v;->f:Z

    if-eqz v2, :cond_7

    const-string v2, "adtest"

    const-string v4, "on"

    invoke-virtual {v3, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_7
    iget v2, v1, Lcom/google/android/gms/internal/v;->a:I

    if-lt v2, v10, :cond_14

    iget-boolean v2, v1, Lcom/google/android/gms/internal/v;->h:Z

    if-eqz v2, :cond_8

    const-string v2, "d_imp_hdr"

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_8
    iget-object v2, v1, Lcom/google/android/gms/internal/v;->i:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_9

    const-string v2, "ppid"

    iget-object v4, v1, Lcom/google/android/gms/internal/v;->i:Ljava/lang/String;

    invoke-virtual {v3, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_9
    iget-object v2, v1, Lcom/google/android/gms/internal/v;->j:Lcom/google/android/gms/internal/ai;

    if-eqz v2, :cond_14

    iget-object v2, v1, Lcom/google/android/gms/internal/v;->j:Lcom/google/android/gms/internal/ai;

    iget v1, v2, Lcom/google/android/gms/internal/ai;->b:I

    invoke-static {v1}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    if-eqz v1, :cond_a

    const-string v1, "acolor"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->b:I

    invoke-static {v4}, Lcom/google/android/gms/internal/du;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_a
    iget v1, v2, Lcom/google/android/gms/internal/ai;->c:I

    invoke-static {v1}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    if-eqz v1, :cond_b

    const-string v1, "bgcolor"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->c:I

    invoke-static {v4}, Lcom/google/android/gms/internal/du;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_b
    iget v1, v2, Lcom/google/android/gms/internal/ai;->d:I

    invoke-static {v1}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    if-eqz v1, :cond_c

    iget v1, v2, Lcom/google/android/gms/internal/ai;->e:I

    invoke-static {v1}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    if-eqz v1, :cond_c

    const-string v1, "gradientto"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->d:I

    invoke-static {v4}, Lcom/google/android/gms/internal/du;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "gradientfrom"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->e:I

    invoke-static {v4}, Lcom/google/android/gms/internal/du;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_c
    iget v1, v2, Lcom/google/android/gms/internal/ai;->f:I

    invoke-static {v1}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    if-eqz v1, :cond_d

    const-string v1, "bcolor"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->f:I

    invoke-static {v4}, Lcom/google/android/gms/internal/du;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_d
    const-string v1, "bthick"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->g:I

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget v1, v2, Lcom/google/android/gms/internal/ai;->h:I

    packed-switch v1, :pswitch_data_0

    move-object v1, v0

    :goto_0
    if-eqz v1, :cond_e

    const-string v4, "btype"

    invoke-virtual {v3, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_e
    iget v1, v2, Lcom/google/android/gms/internal/ai;->i:I

    packed-switch v1, :pswitch_data_1

    move-object v1, v0

    :goto_1
    if-eqz v1, :cond_f

    const-string v4, "callbuttoncolor"

    invoke-virtual {v3, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_f
    iget-object v1, v2, Lcom/google/android/gms/internal/ai;->j:Ljava/lang/String;

    if-eqz v1, :cond_10

    const-string v1, "channel"

    iget-object v4, v2, Lcom/google/android/gms/internal/ai;->j:Ljava/lang/String;

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_10
    iget v1, v2, Lcom/google/android/gms/internal/ai;->k:I

    invoke-static {v1}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    if-eqz v1, :cond_11

    const-string v1, "dcolor"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->k:I

    invoke-static {v4}, Lcom/google/android/gms/internal/du;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_11
    iget-object v1, v2, Lcom/google/android/gms/internal/ai;->l:Ljava/lang/String;

    if-eqz v1, :cond_12

    const-string v1, "font"

    iget-object v4, v2, Lcom/google/android/gms/internal/ai;->l:Ljava/lang/String;

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_12
    iget v1, v2, Lcom/google/android/gms/internal/ai;->m:I

    invoke-static {v1}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    if-eqz v1, :cond_13

    const-string v1, "hcolor"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->m:I

    invoke-static {v4}, Lcom/google/android/gms/internal/du;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_13
    const-string v1, "headersize"

    iget v4, v2, Lcom/google/android/gms/internal/ai;->n:I

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, v2, Lcom/google/android/gms/internal/ai;->o:Ljava/lang/String;

    if-eqz v1, :cond_14

    const-string v1, "q"

    iget-object v2, v2, Lcom/google/android/gms/internal/ai;->o:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_14
    const-string v1, "format"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget-object v2, v2, Lcom/google/android/gms/internal/x;->b:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget v1, v1, Lcom/google/android/gms/internal/x;->f:I

    if-ne v1, v9, :cond_15

    const-string v1, "smart_w"

    const-string v2, "full"

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_15
    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget v1, v1, Lcom/google/android/gms/internal/x;->c:I

    if-ne v1, v11, :cond_16

    const-string v1, "smart_h"

    const-string v2, "auto"

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_16
    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget-object v1, v1, Lcom/google/android/gms/internal/x;->h:[Lcom/google/android/gms/internal/x;

    if-eqz v1, :cond_1b

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget-object v5, v1, Lcom/google/android/gms/internal/x;->h:[Lcom/google/android/gms/internal/x;

    array-length v6, v5

    const/4 v1, 0x0

    move v2, v1

    :goto_2
    if-ge v2, v6, :cond_1a

    aget-object v7, v5, v2

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->length()I

    move-result v1

    if-eqz v1, :cond_17

    const-string v1, "|"

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_17
    iget v1, v7, Lcom/google/android/gms/internal/x;->f:I

    if-ne v1, v9, :cond_18

    iget v1, v7, Lcom/google/android/gms/internal/x;->g:I

    int-to-float v1, v1

    iget v8, p1, Lcom/google/android/gms/internal/ea;->q:F

    div-float/2addr v1, v8

    float-to-int v1, v1

    :goto_3
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, "x"

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, v7, Lcom/google/android/gms/internal/x;->c:I

    if-ne v1, v11, :cond_19

    iget v1, v7, Lcom/google/android/gms/internal/x;->d:I

    int-to-float v1, v1

    iget v7, p1, Lcom/google/android/gms/internal/ea;->q:F

    div-float/2addr v1, v7

    float-to-int v1, v1

    :goto_4
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_2

    :pswitch_0
    const-string v1, "none"

    goto/16 :goto_0

    :pswitch_1
    const-string v1, "dashed"

    goto/16 :goto_0

    :pswitch_2
    const-string v1, "dotted"

    goto/16 :goto_0

    :pswitch_3
    const-string v1, "solid"

    goto/16 :goto_0

    :pswitch_4
    const-string v1, "dark"

    goto/16 :goto_1

    :pswitch_5
    const-string v1, "light"

    goto/16 :goto_1

    :pswitch_6
    const-string v1, "medium"

    goto/16 :goto_1

    :cond_18
    iget v1, v7, Lcom/google/android/gms/internal/x;->f:I

    goto :goto_3

    :cond_19
    iget v1, v7, Lcom/google/android/gms/internal/x;->c:I

    goto :goto_4

    :cond_1a
    const-string v1, "sz"

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1b
    const-string v1, "slotname"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->e:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "pn"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->f:Landroid/content/pm/ApplicationInfo;

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->g:Landroid/content/pm/PackageInfo;

    if-eqz v1, :cond_1c

    const-string v1, "vc"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->g:Landroid/content/pm/PackageInfo;

    iget v2, v2, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1c
    const-string v1, "ms"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->h:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "seq_num"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->i:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "session_id"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->j:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "js"

    iget-object v2, p0, Lcom/google/android/gms/internal/bz;->k:Lcom/google/android/gms/internal/cu;

    iget-object v2, v2, Lcom/google/android/gms/internal/cu;->b:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "am"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "cog"

    iget-boolean v2, p1, Lcom/google/android/gms/internal/ea;->b:Z

    invoke-static {v2}, Lcom/google/android/gms/internal/du;->a(Z)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "coh"

    iget-boolean v2, p1, Lcom/google/android/gms/internal/ea;->c:Z

    invoke-static {v2}, Lcom/google/android/gms/internal/du;->a(Z)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p1, Lcom/google/android/gms/internal/ea;->d:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1d

    const-string v1, "carrier"

    iget-object v2, p1, Lcom/google/android/gms/internal/ea;->d:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1d
    const-string v1, "gl"

    iget-object v2, p1, Lcom/google/android/gms/internal/ea;->e:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-boolean v1, p1, Lcom/google/android/gms/internal/ea;->f:Z

    if-eqz v1, :cond_1e

    const-string v1, "simulator"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1e
    const-string v1, "ma"

    iget-boolean v2, p1, Lcom/google/android/gms/internal/ea;->g:Z

    invoke-static {v2}, Lcom/google/android/gms/internal/du;->a(Z)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "sp"

    iget-boolean v2, p1, Lcom/google/android/gms/internal/ea;->h:Z

    invoke-static {v2}, Lcom/google/android/gms/internal/du;->a(Z)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "hl"

    iget-object v2, p1, Lcom/google/android/gms/internal/ea;->i:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p1, Lcom/google/android/gms/internal/ea;->j:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1f

    const-string v1, "mv"

    iget-object v2, p1, Lcom/google/android/gms/internal/ea;->j:Ljava/lang/String;

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1f
    const-string v1, "muv"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->k:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget v1, p1, Lcom/google/android/gms/internal/ea;->l:I

    if-eq v1, v11, :cond_20

    const-string v1, "cnt"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->l:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_20
    const-string v1, "gnt"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->m:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "pt"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->n:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "rm"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->o:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "riv"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->p:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "u_sd"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->q:F

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "sh"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->s:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "sw"

    iget v2, p1, Lcom/google/android/gms/internal/ea;->r:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->c:Lcom/google/android/gms/internal/v;

    iget v1, v1, Lcom/google/android/gms/internal/v;->a:I

    if-lt v1, v10, :cond_21

    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->c:Lcom/google/android/gms/internal/v;

    iget-object v1, v1, Lcom/google/android/gms/internal/v;->k:Landroid/location/Location;

    if-eqz v1, :cond_21

    iget-object v1, p0, Lcom/google/android/gms/internal/bz;->c:Lcom/google/android/gms/internal/v;

    iget-object v1, v1, Lcom/google/android/gms/internal/v;->k:Landroid/location/Location;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {v1}, Landroid/location/Location;->getAccuracy()F

    move-result v4

    const/high16 v5, 0x447a0000    # 1000.0f

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    invoke-virtual {v1}, Landroid/location/Location;->getTime()J

    move-result-wide v6

    const-wide/16 v8, 0x3e8

    mul-long/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v6

    mul-double/2addr v6, v12

    double-to-long v6, v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v8

    mul-double/2addr v8, v12

    double-to-long v8, v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const-string v7, "radius"

    invoke-virtual {v2, v7, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "lat"

    invoke-virtual {v2, v4, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "long"

    invoke-virtual {v2, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "time"

    invoke-virtual {v2, v1, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "uule"

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_21
    const/4 v1, 0x2

    invoke-static {v1}, Lcom/google/android/gms/internal/et;->a(I)Z

    move-result v1

    if-eqz v1, :cond_22

    invoke-static {v3}, Lcom/google/android/gms/internal/ej;->a(Ljava/util/Map;)Lorg/json/JSONObject;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "Ad Request JSON: "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gms/internal/et;->c(Ljava/lang/String;)V

    :cond_22
    invoke-static {v3}, Lcom/google/android/gms/internal/ej;->a(Ljava/util/Map;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_5
    return-object v0

    :catch_0
    move-exception v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Problem serializing ad request to JSON: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    goto :goto_5

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_5
        :pswitch_6
        :pswitch_4
    .end packed-switch
.end method
