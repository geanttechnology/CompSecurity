.class public final Lcom/wishabi/flipp/content/bb;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public a:Ljava/lang/String;

.field public b:Ljava/lang/String;

.field public c:Ljava/lang/String;

.field public d:Ljava/lang/String;

.field public e:Ljava/lang/String;

.field private f:I

.field private g:Ljava/lang/String;

.field private h:I

.field private i:D

.field private j:D

.field private k:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Lorg/json/JSONObject;)Lcom/wishabi/flipp/content/bb;
    .locals 4

    .prologue
    .line 41
    :try_start_0
    new-instance v0, Lcom/wishabi/flipp/content/bb;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/bb;-><init>()V

    .line 42
    const-string v1, "id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/wishabi/flipp/content/bb;->f:I

    .line 43
    const-string v1, "merchant_store_code"

    invoke-static {p0, v1}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/content/bb;->g:Ljava/lang/String;

    .line 44
    const-string v1, "merchant_id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/wishabi/flipp/content/bb;->h:I

    .line 45
    const-string v1, "address"

    invoke-static {p0, v1}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/content/bb;->a:Ljava/lang/String;

    .line 46
    const-string v1, "city"

    invoke-static {p0, v1}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/content/bb;->b:Ljava/lang/String;

    .line 47
    const-string v1, "province"

    invoke-static {p0, v1}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/content/bb;->c:Ljava/lang/String;

    .line 48
    const-string v1, "postal_code"

    invoke-static {p0, v1}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/content/bb;->d:Ljava/lang/String;

    .line 49
    const-string v1, "name"

    invoke-static {p0, v1}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/content/bb;->e:Ljava/lang/String;

    .line 50
    const-string v1, "lat"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/wishabi/flipp/content/bb;->i:D

    .line 51
    const-string v1, "lon"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/wishabi/flipp/content/bb;->j:D

    .line 52
    const-string v1, "source"

    invoke-static {p0, v1}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/content/bb;->k:Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    :goto_0
    return-object v0

    .line 53
    :catch_0
    move-exception v0

    invoke-virtual {v0}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    .line 55
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0, p1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
