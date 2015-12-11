.class public final Lcom/wishabi/flipp/b/h;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Landroid/content/SharedPreferences;

.field final synthetic b:Lcom/wishabi/flipp/b/a;


# direct methods
.method public constructor <init>(Lcom/wishabi/flipp/b/a;Landroid/content/SharedPreferences;)V
    .locals 0

    .prologue
    .line 332
    iput-object p1, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    iput-object p2, p0, Lcom/wishabi/flipp/b/h;->a:Landroid/content/SharedPreferences;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method private varargs a()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 335
    iget-object v1, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-static {v1}, Lcom/wishabi/flipp/b/a;->f(Lcom/wishabi/flipp/b/a;)Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gms/common/g;->a(Landroid/content/Context;)I

    move-result v1

    if-eqz v1, :cond_0

    .line 344
    :goto_0
    return-object v0

    .line 340
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-static {v1}, Lcom/wishabi/flipp/b/a;->f(Lcom/wishabi/flipp/b/a;)Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;->getAdvertisingIdInfo(Landroid/content/Context;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lcom/google/android/gms/common/e; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/google/android/gms/common/f; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v0

    goto :goto_0

    .line 344
    :catch_0
    move-exception v1

    goto :goto_0

    :catch_1
    move-exception v1

    goto :goto_0

    :catch_2
    move-exception v1

    goto :goto_0
.end method


# virtual methods
.method protected final synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 332
    invoke-direct {p0}, Lcom/wishabi/flipp/b/h;->a()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;

    move-result-object v0

    return-object v0
.end method

.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 4

    .prologue
    .line 332
    check-cast p1, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-virtual {p1}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->b(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)Ljava/lang/String;

    iget-object v0, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-virtual {p1}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;->isLimitAdTrackingEnabled()Z

    move-result v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Z)Z

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "AdvertisingId:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-static {v1}, Lcom/wishabi/flipp/b/a;->g(Lcom/wishabi/flipp/b/a;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " isLat:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-static {v1}, Lcom/wishabi/flipp/b/a;->h(Lcom/wishabi/flipp/b/a;)Z

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    iget-object v0, p0, Lcom/wishabi/flipp/b/h;->a:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "advertising_id"

    iget-object v2, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-static {v2}, Lcom/wishabi/flipp/b/a;->g(Lcom/wishabi/flipp/b/a;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "is_lat"

    iget-object v2, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-static {v2}, Lcom/wishabi/flipp/b/a;->h(Lcom/wishabi/flipp/b/a;)Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/b/h;->a:Landroid/content/SharedPreferences;

    const-string v2, "uuid"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Ljava/util/UUID;)Ljava/util/UUID;

    iget-object v0, p0, Lcom/wishabi/flipp/b/h;->a:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "uuid"

    iget-object v2, p0, Lcom/wishabi/flipp/b/h;->b:Lcom/wishabi/flipp/b/a;

    invoke-static {v2}, Lcom/wishabi/flipp/b/a;->i(Lcom/wishabi/flipp/b/a;)Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method
