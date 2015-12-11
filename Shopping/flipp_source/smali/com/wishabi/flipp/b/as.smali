.class public Lcom/wishabi/flipp/b/as;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Lcom/wishabi/flipp/content/SimpleSearchResult;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Landroid/content/Context;

.field public d:Z

.field private final e:I

.field private f:Landroid/os/Handler;

.field private g:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/wishabi/flipp/b/as;->a:Ljava/lang/String;

    .line 33
    iput-object p2, p0, Lcom/wishabi/flipp/b/as;->b:Ljava/lang/String;

    .line 34
    iput-object p3, p0, Lcom/wishabi/flipp/b/as;->c:Landroid/content/Context;

    .line 35
    const v0, 0xea60

    iput v0, p0, Lcom/wishabi/flipp/b/as;->e:I

    .line 36
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/as;)Z
    .locals 1

    .prologue
    .line 18
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/b/as;->d:Z

    return v0
.end method


# virtual methods
.method public a(Lcom/wishabi/flipp/content/SimpleSearchResult;)V
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/wishabi/flipp/b/as;->f:Landroid/os/Handler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/b/as;->g:Ljava/lang/Runnable;

    if-nez v0, :cond_1

    .line 58
    :cond_0
    :goto_0
    return-void

    .line 57
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/b/as;->f:Landroid/os/Handler;

    iget-object v1, p0, Lcom/wishabi/flipp/b/as;->g:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 18
    const-string v1, "https://backflipp.wishabi.com/flipp/items/count"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "postal_code"

    iget-object v3, p0, Lcom/wishabi/flipp/b/as;->a:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v2, "locale"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v2, "q"

    iget-object v3, p0, Lcom/wishabi/flipp/b/as;->b:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/wishabi/flipp/b/as;->b:Ljava/lang/String;

    aput-object v4, v2, v3

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-static {v1}, Lcom/wishabi/flipp/b/ak;->a(Landroid/net/Uri;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-static {v1}, Lcom/wishabi/flipp/content/SimpleSearchResult;->a(Lorg/json/JSONObject;)Lcom/wishabi/flipp/content/SimpleSearchResult;

    move-result-object v0

    goto :goto_0
.end method

.method public synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 18
    check-cast p1, Lcom/wishabi/flipp/content/SimpleSearchResult;

    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/b/as;->a(Lcom/wishabi/flipp/content/SimpleSearchResult;)V

    return-void
.end method

.method protected onPreExecute()V
    .locals 4

    .prologue
    .line 40
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/wishabi/flipp/b/as;->c:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/wishabi/flipp/b/as;->f:Landroid/os/Handler;

    .line 41
    new-instance v0, Lcom/wishabi/flipp/b/at;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/b/at;-><init>(Lcom/wishabi/flipp/b/as;)V

    iput-object v0, p0, Lcom/wishabi/flipp/b/as;->g:Ljava/lang/Runnable;

    .line 49
    iget-object v0, p0, Lcom/wishabi/flipp/b/as;->f:Landroid/os/Handler;

    iget-object v1, p0, Lcom/wishabi/flipp/b/as;->g:Ljava/lang/Runnable;

    iget v2, p0, Lcom/wishabi/flipp/b/as;->e:I

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 50
    return-void
.end method
