.class public final Lcom/google/android/gms/internal/dr;
.super Lcom/google/android/gms/internal/dp;


# static fields
.field private static final a:Ljava/lang/Object;

.field private static b:Lcom/google/android/gms/internal/dr;


# instance fields
.field private final c:Landroid/content/Context;

.field private final d:Lcom/google/android/gms/internal/aj;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/dr;->a:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/aj;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/dp;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/dr;->c:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/dr;->d:Lcom/google/android/gms/internal/aj;

    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/cb;
    .locals 16

    :try_start_0
    new-instance v15, Lcom/google/android/gms/internal/dz;

    invoke-direct {v15}, Lcom/google/android/gms/internal/dz;-><init>()V

    new-instance v3, Ljava/net/URL;

    move-object/from16 v0, p2

    invoke-direct {v3, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    move-object v4, v3

    move v3, v2

    :goto_0
    invoke-virtual {v4}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    check-cast v2, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v5, 0x0

    :try_start_1
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-static {v0, v1, v5, v2}, Lcom/google/android/gms/internal/ej;->a(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v5

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v6

    const/16 v7, 0xc8

    if-lt v5, v7, :cond_0

    const/16 v7, 0x12c

    if-ge v5, v7, :cond_0

    invoke-virtual {v4}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/io/InputStreamReader;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v7

    invoke-direct {v4, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-static {v4}, Lcom/google/android/gms/internal/ej;->a(Ljava/lang/Readable;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v6, v4, v5}, Lcom/google/android/gms/internal/dr;->a(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V

    iput-object v3, v15, Lcom/google/android/gms/internal/dz;->b:Ljava/lang/String;

    iput-object v4, v15, Lcom/google/android/gms/internal/dz;->c:Ljava/lang/String;

    invoke-virtual {v15, v6}, Lcom/google/android/gms/internal/dz;->a(Ljava/util/Map;)V

    new-instance v3, Lcom/google/android/gms/internal/cb;

    iget-object v4, v15, Lcom/google/android/gms/internal/dz;->b:Ljava/lang/String;

    iget-object v5, v15, Lcom/google/android/gms/internal/dz;->c:Ljava/lang/String;

    iget-object v6, v15, Lcom/google/android/gms/internal/dz;->d:Ljava/util/List;

    iget-object v7, v15, Lcom/google/android/gms/internal/dz;->e:Ljava/util/List;

    iget-wide v8, v15, Lcom/google/android/gms/internal/dz;->f:J

    iget-boolean v10, v15, Lcom/google/android/gms/internal/dz;->g:Z

    iget-object v11, v15, Lcom/google/android/gms/internal/dz;->h:Ljava/util/List;

    iget-wide v12, v15, Lcom/google/android/gms/internal/dz;->i:J

    iget v14, v15, Lcom/google/android/gms/internal/dz;->j:I

    iget-object v15, v15, Lcom/google/android/gms/internal/dz;->a:Ljava/lang/String;

    invoke-direct/range {v3 .. v15}, Lcom/google/android/gms/internal/cb;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JZLjava/util/List;JILjava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    :goto_1
    return-object v3

    :cond_0
    :try_start_3
    invoke-virtual {v4}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v7, 0x0

    invoke-static {v4, v6, v7, v5}, Lcom/google/android/gms/internal/dr;->a(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V

    const/16 v4, 0x12c

    if-lt v5, v4, :cond_2

    const/16 v4, 0x190

    if-ge v5, v4, :cond_2

    const-string v4, "Location"

    invoke-virtual {v2, v4}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    const-string v3, "No location header to follow redirect."

    invoke-static {v3}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    new-instance v3, Lcom/google/android/gms/internal/cb;

    const/4 v4, 0x0

    invoke-direct {v3, v4}, Lcom/google/android/gms/internal/cb;-><init>(I)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    goto :goto_1

    :catch_0
    move-exception v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Error while connecting to ad server: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    new-instance v3, Lcom/google/android/gms/internal/cb;

    const/4 v2, 0x2

    invoke-direct {v3, v2}, Lcom/google/android/gms/internal/cb;-><init>(I)V

    goto :goto_1

    :cond_1
    :try_start_5
    new-instance v4, Ljava/net/URL;

    invoke-direct {v4, v5}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    add-int/lit8 v3, v3, 0x1

    const/4 v5, 0x5

    if-le v3, v5, :cond_3

    const-string v3, "Too many redirects."

    invoke-static {v3}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    new-instance v3, Lcom/google/android/gms/internal/cb;

    const/4 v4, 0x0

    invoke-direct {v3, v4}, Lcom/google/android/gms/internal/cb;-><init>(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0

    goto :goto_1

    :cond_2
    :try_start_7
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Received error HTTP response code: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    new-instance v3, Lcom/google/android/gms/internal/cb;

    const/4 v4, 0x0

    invoke-direct {v3, v4}, Lcom/google/android/gms/internal/cb;-><init>(I)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    :try_start_8
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_0

    goto :goto_1

    :cond_3
    :try_start_9
    invoke-virtual {v15, v6}, Lcom/google/android/gms/internal/dz;->a(Ljava/util/Map;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    :try_start_a
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_0

    :catchall_0
    move-exception v3

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v3
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_0
.end method

.method public static a(Landroid/content/Context;Lcom/google/android/gms/internal/aj;)Lcom/google/android/gms/internal/dr;
    .locals 3

    sget-object v1, Lcom/google/android/gms/internal/dr;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/google/android/gms/internal/dr;->b:Lcom/google/android/gms/internal/dr;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/dr;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2, p1}, Lcom/google/android/gms/internal/dr;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/aj;)V

    sput-object v0, Lcom/google/android/gms/internal/dr;->b:Lcom/google/android/gms/internal/dr;

    :cond_0
    sget-object v0, Lcom/google/android/gms/internal/dr;->b:Lcom/google/android/gms/internal/dr;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static a(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    const/4 v0, 0x2

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->a(I)Z

    move-result v0

    if-eqz v0, :cond_4

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Http Response: {\n  URL:\n    "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n  Headers:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->c(Ljava/lang/String;)V

    if-eqz p1, :cond_1

    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "    "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->c(Ljava/lang/String;)V

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "      "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->c(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    const-string v0, "  Body:"

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->c(Ljava/lang/String;)V

    if-eqz p2, :cond_2

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    const v2, 0x186a0

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    if-ge v0, v1, :cond_3

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit16 v2, v0, 0x3e8

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gms/internal/et;->c(Ljava/lang/String;)V

    add-int/lit16 v0, v0, 0x3e8

    goto :goto_1

    :cond_2
    const-string v0, "    null"

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->c(Ljava/lang/String;)V

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "  Response Code:\n    "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->c(Ljava/lang/String;)V

    :cond_4
    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/internal/bz;)Lcom/google/android/gms/internal/cb;
    .locals 5

    iget-object v0, p0, Lcom/google/android/gms/internal/dr;->c:Landroid/content/Context;

    const-string v1, "Starting ad request from service."

    invoke-static {v1}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    new-instance v1, Lcom/google/android/gms/internal/ea;

    invoke-direct {v1, v0}, Lcom/google/android/gms/internal/ea;-><init>(Landroid/content/Context;)V

    iget v2, v1, Lcom/google/android/gms/internal/ea;->l:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    const-string v0, "Device is offline."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    new-instance v0, Lcom/google/android/gms/internal/cb;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cb;-><init>(I)V

    :goto_0
    return-object v0

    :cond_0
    new-instance v2, Lcom/google/android/gms/internal/dw;

    iget-object v3, p1, Lcom/google/android/gms/internal/bz;->f:Landroid/content/pm/ApplicationInfo;

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-direct {v2, v3}, Lcom/google/android/gms/internal/dw;-><init>(Ljava/lang/String;)V

    iget-object v3, p1, Lcom/google/android/gms/internal/bz;->c:Lcom/google/android/gms/internal/v;

    iget-object v3, v3, Lcom/google/android/gms/internal/v;->c:Landroid/os/Bundle;

    if-eqz v3, :cond_1

    iget-object v3, p1, Lcom/google/android/gms/internal/bz;->c:Lcom/google/android/gms/internal/v;

    iget-object v3, v3, Lcom/google/android/gms/internal/v;->c:Landroid/os/Bundle;

    const-string v4, "_ad"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-static {v0, p1, v3}, Lcom/google/android/gms/internal/du;->a(Landroid/content/Context;Lcom/google/android/gms/internal/bz;Ljava/lang/String;)Lcom/google/android/gms/internal/cb;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-static {p1, v1}, Lcom/google/android/gms/internal/du;->a(Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/ea;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_2

    new-instance v0, Lcom/google/android/gms/internal/cb;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cb;-><init>(I)V

    goto :goto_0

    :cond_2
    sget-object v3, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    new-instance v4, Lcom/google/android/gms/internal/ds;

    invoke-direct {v4, v0, p1, v2, v1}, Lcom/google/android/gms/internal/ds;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/dw;Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    invoke-virtual {v2}, Lcom/google/android/gms/internal/dw;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_3

    new-instance v0, Lcom/google/android/gms/internal/cb;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/dw;->a()I

    move-result v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cb;-><init>(I)V

    goto :goto_0

    :cond_3
    iget-object v2, p1, Lcom/google/android/gms/internal/bz;->k:Lcom/google/android/gms/internal/cu;

    iget-object v2, v2, Lcom/google/android/gms/internal/cu;->b:Ljava/lang/String;

    invoke-static {v0, v2, v1}, Lcom/google/android/gms/internal/dr;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/internal/cb;

    move-result-object v0

    goto :goto_0
.end method
