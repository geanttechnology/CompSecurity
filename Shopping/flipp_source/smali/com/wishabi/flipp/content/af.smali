.class public final Lcom/wishabi/flipp/content/af;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final A:Lb/a/a/d/d;

.field public static final a:Lb/a/a/d/d;

.field public static final b:Lb/a/a/d/d;

.field private static final z:Lb/a/a/i;


# instance fields
.field private B:J

.field private C:Ljava/lang/String;

.field private D:Ljava/lang/String;

.field private E:Lcom/wishabi/flipp/content/ag;

.field private F:Ljava/lang/String;

.field private G:Ljava/lang/String;

.field public c:I

.field public d:Ljava/lang/String;

.field public e:Ljava/lang/String;

.field public f:Ljava/lang/String;

.field public g:Ljava/lang/String;

.field public h:Ljava/lang/String;

.field public i:Ljava/lang/String;

.field public j:Ljava/lang/String;

.field public k:Ljava/lang/String;

.field public l:Ljava/lang/String;

.field public m:Ljava/lang/String;

.field public n:Ljava/lang/String;

.field public o:Z

.field public p:Ljava/lang/String;

.field public q:Ljava/lang/String;

.field public r:Ljava/lang/String;

.field public s:Ljava/lang/String;

.field public t:Ljava/lang/String;

.field public u:Ljava/lang/String;

.field public final v:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/ah;",
            ">;"
        }
    .end annotation
.end field

.field public final w:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field public final x:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public y:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 27
    const-string v0, "America/Toronto"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Lb/a/a/i;->a(Ljava/util/TimeZone;)Lb/a/a/i;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/af;->z:Lb/a/a/i;

    .line 29
    invoke-static {}, Lb/a/a/d/aa;->a()Lb/a/a/d/d;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/af;->a:Lb/a/a/d/d;

    .line 31
    invoke-static {}, Lb/a/a/d/a;->a()Lb/a/a/d/d;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/af;->A:Lb/a/a/d/d;

    .line 33
    const-string v0, "MMM dd, yyyy"

    invoke-static {v0}, Lb/a/a/d/a;->a(Ljava/lang/String;)Lb/a/a/d/d;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/af;->z:Lb/a/a/i;

    invoke-virtual {v0, v1}, Lb/a/a/d/d;->a(Lb/a/a/i;)Lb/a/a/d/d;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/af;->b:Lb/a/a/d/d;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 148
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/af;->v:Ljava/util/List;

    .line 149
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/af;->w:Ljava/util/List;

    .line 150
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/af;->x:Ljava/util/List;

    return-void
.end method

.method public static a(Lorg/json/JSONObject;)Lcom/wishabi/flipp/content/af;
    .locals 11

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 303
    :try_start_0
    new-instance v0, Lcom/wishabi/flipp/content/af;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/af;-><init>()V

    .line 304
    const-string v3, "id"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, v0, Lcom/wishabi/flipp/content/af;->B:J

    .line 305
    const-string v3, "flyer_id"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    iput v3, v0, Lcom/wishabi/flipp/content/af;->c:I

    .line 306
    const-string v3, "brand"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    move-object v3, v1

    :goto_0
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->C:Ljava/lang/String;

    .line 307
    const-string v3, "merchant"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    move-object v3, v1

    :goto_1
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->d:Ljava/lang/String;

    .line 309
    const-string v3, "merchant_logo"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    move-object v3, v1

    :goto_2
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->e:Ljava/lang/String;

    .line 311
    const-string v3, "name"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    move-object v3, v1

    :goto_3
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->f:Ljava/lang/String;

    .line 312
    const-string v3, "short_name"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    move-object v3, v1

    :goto_4
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->D:Ljava/lang/String;

    .line 314
    const-string v3, "image_url"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    move-object v3, v1

    :goto_5
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->g:Ljava/lang/String;

    .line 316
    const-string v3, "cutout_image_url"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_6

    move-object v3, v1

    :goto_6
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->h:Ljava/lang/String;

    .line 318
    const-string v3, "description"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    move-object v3, v1

    :goto_7
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->i:Ljava/lang/String;

    .line 320
    const-string v3, "display_type"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Lcom/wishabi/flipp/content/ag;->a(I)Lcom/wishabi/flipp/content/ag;

    move-result-object v3

    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->E:Lcom/wishabi/flipp/content/ag;

    .line 321
    const-string v3, "current_price"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_8

    move-object v3, v1

    :goto_8
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->j:Ljava/lang/String;

    .line 323
    const-string v3, "pre_price_text"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_9

    move-object v3, v1

    :goto_9
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->k:Ljava/lang/String;

    .line 325
    const-string v3, "category"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_a

    move-object v3, v1

    :goto_a
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->F:Ljava/lang/String;

    .line 327
    const-string v3, "price_text"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_b

    move-object v3, v1

    :goto_b
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->l:Ljava/lang/String;

    .line 329
    const-string v3, "sale_story"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_c

    move-object v3, v1

    :goto_c
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->m:Ljava/lang/String;

    .line 331
    const-string v3, "original_price"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_d

    move-object v3, v1

    :goto_d
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->n:Ljava/lang/String;

    .line 333
    const-string v3, "in_store_only"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_e

    const-string v3, "in_store_only"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_e

    const/4 v3, 0x1

    :goto_e
    iput-boolean v3, v0, Lcom/wishabi/flipp/content/af;->o:Z

    .line 335
    const-string v3, "disclaimer_text"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_f

    move-object v3, v1

    :goto_f
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->G:Ljava/lang/String;

    .line 337
    const-string v3, "valid_to"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_10

    move-object v3, v1

    :goto_10
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->p:Ljava/lang/String;

    .line 339
    const-string v3, "valid_from"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_11

    move-object v3, v1

    :goto_11
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->q:Ljava/lang/String;

    .line 341
    const-string v3, "sku"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_12

    move-object v3, v1

    :goto_12
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->r:Ljava/lang/String;

    .line 343
    const-string v3, "ttm_url"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_13

    move-object v3, v1

    :goto_13
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->s:Ljava/lang/String;

    .line 345
    const-string v3, "ttm_label"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_14

    move-object v3, v1

    :goto_14
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->t:Ljava/lang/String;

    .line 347
    const-string v3, "review_average_rating"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_15

    move-object v3, v1

    :goto_15
    iput-object v3, v0, Lcom/wishabi/flipp/content/af;->u:Ljava/lang/String;

    .line 349
    const-string v3, "show_details"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, v0, Lcom/wishabi/flipp/content/af;->y:Z

    .line 351
    const-string v3, "review_samples"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 352
    if-eqz v5, :cond_1b

    .line 353
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v6

    move v4, v2

    :goto_16
    if-ge v4, v6, :cond_1b

    .line 354
    invoke-virtual {v5, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 355
    new-instance v8, Lcom/wishabi/flipp/content/ah;

    invoke-direct {v8}, Lcom/wishabi/flipp/content/ah;-><init>()V

    .line 356
    const-string v3, "title"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_16

    move-object v3, v1

    :goto_17
    iput-object v3, v8, Lcom/wishabi/flipp/content/ah;->a:Ljava/lang/String;

    .line 358
    const-string v3, "rating"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_17

    move-object v3, v1

    :goto_18
    iput-object v3, v8, Lcom/wishabi/flipp/content/ah;->b:Ljava/lang/String;

    .line 360
    const-string v3, "byline"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_18

    move-object v3, v1

    :goto_19
    iput-object v3, v8, Lcom/wishabi/flipp/content/ah;->c:Ljava/lang/String;

    .line 362
    const-string v3, "date"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_19

    move-object v3, v1

    :goto_1a
    iput-object v3, v8, Lcom/wishabi/flipp/content/ah;->d:Ljava/lang/String;

    .line 364
    const-string v3, "body"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1a

    move-object v3, v1

    :goto_1b
    iput-object v3, v8, Lcom/wishabi/flipp/content/ah;->e:Ljava/lang/String;

    .line 366
    iget-object v3, v0, Lcom/wishabi/flipp/content/af;->v:Ljava/util/List;

    invoke-interface {v3, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 353
    add-int/lit8 v3, v4, 0x1

    move v4, v3

    goto :goto_16

    .line 306
    :cond_0
    const-string v3, "brand"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 307
    :cond_1
    const-string v3, "merchant"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_1

    .line 309
    :cond_2
    const-string v3, "merchant_logo"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_2

    .line 311
    :cond_3
    const-string v3, "name"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_3

    .line 312
    :cond_4
    const-string v3, "short_name"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_4

    .line 314
    :cond_5
    const-string v3, "image_url"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_5

    .line 316
    :cond_6
    const-string v3, "cutout_image_url"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_6

    .line 318
    :cond_7
    const-string v3, "description"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_7

    .line 321
    :cond_8
    const-string v3, "current_price"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_8

    .line 323
    :cond_9
    const-string v3, "pre_price_text"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_9

    .line 325
    :cond_a
    const-string v3, "category"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_a

    .line 327
    :cond_b
    const-string v3, "price_text"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_b

    .line 329
    :cond_c
    const-string v3, "sale_story"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_c

    .line 331
    :cond_d
    const-string v3, "original_price"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_d

    :cond_e
    move v3, v2

    .line 333
    goto/16 :goto_e

    .line 335
    :cond_f
    const-string v3, "disclaimer_text"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_f

    .line 337
    :cond_10
    const-string v3, "valid_to"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_10

    .line 339
    :cond_11
    const-string v3, "valid_from"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_11

    .line 341
    :cond_12
    const-string v3, "sku"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_12

    .line 343
    :cond_13
    const-string v3, "ttm_url"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_13

    .line 345
    :cond_14
    const-string v3, "ttm_label"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_14

    .line 347
    :cond_15
    const-string v3, "review_average_rating"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_15

    .line 356
    :cond_16
    const-string v3, "title"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_17

    .line 358
    :cond_17
    const-string v3, "rating"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_18

    .line 360
    :cond_18
    const-string v3, "byline"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_19

    .line 362
    :cond_19
    const-string v3, "date"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_1a

    .line 364
    :cond_1a
    const-string v3, "body"

    invoke-virtual {v7, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_1b

    .line 370
    :cond_1b
    const-string v3, "specs"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 371
    if-eqz v6, :cond_1e

    .line 372
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v7

    move v5, v2

    :goto_1c
    if-ge v5, v7, :cond_1e

    .line 373
    invoke-virtual {v6, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v8

    .line 374
    iget-object v9, v0, Lcom/wishabi/flipp/content/af;->w:Ljava/util/List;

    new-instance v10, Landroid/util/Pair;

    const-string v3, "name"

    invoke-virtual {v8, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1c

    move-object v4, v1

    :goto_1d
    const-string v3, "value"

    invoke-virtual {v8, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1d

    move-object v3, v1

    :goto_1e
    invoke-direct {v10, v4, v3}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 372
    add-int/lit8 v3, v5, 0x1

    move v5, v3

    goto :goto_1c

    .line 374
    :cond_1c
    const-string v3, "name"

    invoke-virtual {v8, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object v4, v3

    goto :goto_1d

    :cond_1d
    const-string v3, "value"

    invoke-virtual {v8, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto :goto_1e

    .line 380
    :cond_1e
    const-string v3, "features"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 381
    if-eqz v4, :cond_20

    .line 382
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    move v3, v2

    :goto_1f
    if-ge v3, v5, :cond_20

    .line 383
    invoke-virtual {v4, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 384
    iget-object v6, v0, Lcom/wishabi/flipp/content/af;->x:Ljava/util/List;

    const-string v7, "text"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1f

    move-object v2, v1

    :goto_20
    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 382
    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto :goto_1f

    .line 384
    :cond_1f
    const-string v7, "text"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_20

    .line 391
    :catch_0
    move-exception v0

    move-object v0, v1

    :cond_20
    return-object v0
.end method

.method public static synthetic b()Lb/a/a/d/d;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/wishabi/flipp/content/af;->a:Lb/a/a/d/d;

    return-object v0
.end method

.method public static synthetic c()Lb/a/a/d/d;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/wishabi/flipp/content/af;->A:Lb/a/a/d/d;

    return-object v0
.end method


# virtual methods
.method public final a()Ljava/lang/String;
    .locals 6

    .prologue
    .line 297
    const-string v0, "https://share.flipp.com/flipp/items/%d/share?locale=%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-wide v4, p0, Lcom/wishabi/flipp/content/af;->B:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
