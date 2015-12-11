.class public Lcom/wishabi/flipp/b/aa;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Lcom/wishabi/flipp/content/FlyerInfo;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:I

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/Double;

.field private final d:Ljava/lang/Double;


# direct methods
.method public constructor <init>(ILjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 24
    iput p1, p0, Lcom/wishabi/flipp/b/aa;->a:I

    .line 25
    iput-object p2, p0, Lcom/wishabi/flipp/b/aa;->b:Ljava/lang/String;

    .line 26
    iput-object p3, p0, Lcom/wishabi/flipp/b/aa;->c:Ljava/lang/Double;

    .line 27
    iput-object p4, p0, Lcom/wishabi/flipp/b/aa;->d:Ljava/lang/Double;

    .line 28
    return-void
.end method


# virtual methods
.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 15
    const-string v1, "https://backflipp.wishabi.com/flipp/flyers"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    iget v2, p0, Lcom/wishabi/flipp/b/aa;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v2, "info"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v2, "postal_code"

    iget-object v3, p0, Lcom/wishabi/flipp/b/aa;->b:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v2, "locale"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    iget-object v2, p0, Lcom/wishabi/flipp/b/aa;->c:Ljava/lang/Double;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/b/aa;->d:Ljava/lang/Double;

    if-eqz v2, :cond_0

    const-string v2, "lat"

    iget-object v3, p0, Lcom/wishabi/flipp/b/aa;->c:Ljava/lang/Double;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v2, "lon"

    iget-object v3, p0, Lcom/wishabi/flipp/b/aa;->d:Ljava/lang/Double;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    :cond_0
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    if-nez v1, :cond_2

    :cond_1
    :goto_0
    return-object v0

    :cond_2
    invoke-static {v1}, Lcom/wishabi/flipp/b/ak;->a(Landroid/net/Uri;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_1

    const-string v2, "info"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-static {v1}, Lcom/wishabi/flipp/content/FlyerInfo;->a(Lorg/json/JSONObject;)Lcom/wishabi/flipp/content/FlyerInfo;

    move-result-object v0

    goto :goto_0
.end method
