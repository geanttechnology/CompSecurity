.class final Lcom/wishabi/flipp/app/ba;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/net/URL;

.field final synthetic b:Lcom/wishabi/flipp/app/FlippApplication;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlippApplication;Ljava/net/URL;)V
    .locals 0

    .prologue
    .line 397
    iput-object p1, p0, Lcom/wishabi/flipp/app/ba;->b:Lcom/wishabi/flipp/app/FlippApplication;

    iput-object p2, p0, Lcom/wishabi/flipp/app/ba;->a:Ljava/net/URL;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method private varargs a()Ljava/lang/Void;
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 401
    :try_start_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ba;->a:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 403
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 404
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 405
    const-string v1, "PUT"

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 406
    const-string v1, "Platform"

    const-string v3, "Android"

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 408
    iget-object v1, p0, Lcom/wishabi/flipp/app/ba;->b:Lcom/wishabi/flipp/app/FlippApplication;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FlippApplication;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 409
    iget-object v3, p0, Lcom/wishabi/flipp/app/ba;->b:Lcom/wishabi/flipp/app/FlippApplication;

    invoke-virtual {v3}, Lcom/wishabi/flipp/app/FlippApplication;->getPackageName()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    .line 411
    if-eqz v1, :cond_2

    .line 413
    const/4 v4, 0x0

    :try_start_1
    invoke-virtual {v1, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 417
    :goto_0
    if-eqz v1, :cond_0

    .line 418
    :try_start_2
    const-string v3, "App-Version"

    invoke-virtual {v0, v3, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    :cond_0
    const-string v1, ""

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 421
    const-string v1, "Authorization"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Basic "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ""

    invoke-virtual {v4}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    const/4 v5, 0x2

    invoke-static {v4, v5}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 425
    :cond_1
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 430
    :goto_1
    return-object v2

    :catch_0
    move-exception v1

    :cond_2
    move-object v1, v2

    goto :goto_0

    :catch_1
    move-exception v0

    goto :goto_1
.end method


# virtual methods
.method protected final synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 397
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ba;->a()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method
