.class public Lcom/wishabi/flipp/b/z;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/Integer;",
        "Lcom/wishabi/flipp/content/b;",
        ">;>;"
    }
.end annotation


# static fields
.field public static final b:Ljava/lang/String;


# instance fields
.field private final a:[I

.field private final c:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/wishabi/flipp/b/z;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/b/z;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>([ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 31
    iput-object p1, p0, Lcom/wishabi/flipp/b/z;->a:[I

    .line 32
    iput-object p2, p0, Lcom/wishabi/flipp/b/z;->c:Ljava/lang/String;

    .line 33
    return-void
.end method

.method private varargs a()Ljava/util/HashMap;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/wishabi/flipp/content/b;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 37
    iget-object v0, p0, Lcom/wishabi/flipp/b/z;->c:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 67
    :cond_0
    :goto_0
    return-object v1

    .line 40
    :cond_1
    const-string v0, "https://backflipp.wishabi.com/flipp/coupons"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 42
    const-string v2, "ids"

    iget-object v3, p0, Lcom/wishabi/flipp/b/z;->a:[I

    const-string v4, ","

    invoke-static {v3, v4}, Lcom/wishabi/flipp/util/q;->a([ILjava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 44
    const-string v2, "postal_code"

    iget-object v3, p0, Lcom/wishabi/flipp/b/z;->c:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 46
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 47
    if-eqz v0, :cond_0

    .line 50
    invoke-static {v0}, Lcom/wishabi/flipp/b/ak;->a(Landroid/net/Uri;)Lorg/json/JSONObject;

    move-result-object v2

    .line 51
    if-eqz v2, :cond_0

    .line 54
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 56
    :try_start_0
    const-string v3, "coupons"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 57
    const/4 v2, 0x0

    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    :goto_1
    if-ge v2, v4, :cond_2

    .line 58
    invoke-virtual {v3, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 59
    new-instance v6, Lcom/wishabi/flipp/content/b;

    invoke-direct {v6, v5}, Lcom/wishabi/flipp/content/b;-><init>(Lorg/json/JSONObject;)V

    .line 60
    iget v5, v6, Lcom/wishabi/flipp/content/b;->a:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 62
    :catch_0
    move-exception v0

    .line 64
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Error processing coupon details JSON: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object v0, v1

    :cond_2
    move-object v1, v0

    .line 67
    goto :goto_0
.end method


# virtual methods
.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/wishabi/flipp/b/z;->a()Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method
