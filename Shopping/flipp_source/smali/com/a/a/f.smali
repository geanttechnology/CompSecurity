.class public final Lcom/a/a/f;
.super Ljava/net/ResponseCache;
.source "SourceFile"


# static fields
.field private static final b:[C


# instance fields
.field final a:Lcom/a/a/t;

.field private final c:Lcom/a/a/a/c;

.field private d:I

.field private e:I

.field private f:I

.field private g:I

.field private h:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 122
    const/16 v0, 0x10

    new-array v0, v0, [C

    fill-array-data v0, :array_0

    sput-object v0, Lcom/a/a/f;->b:[C

    return-void

    :array_0
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
    .end array-data
.end method

.method public constructor <init>(Ljava/io/File;J)V
    .locals 2

    .prologue
    .line 174
    invoke-direct {p0}, Ljava/net/ResponseCache;-><init>()V

    .line 146
    new-instance v0, Lcom/a/a/g;

    invoke-direct {v0, p0}, Lcom/a/a/g;-><init>(Lcom/a/a/f;)V

    iput-object v0, p0, Lcom/a/a/f;->a:Lcom/a/a/t;

    .line 175
    invoke-static {p1, p2, p3}, Lcom/a/a/a/c;->a(Ljava/io/File;J)Lcom/a/a/a/c;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/f;->c:Lcom/a/a/a/c;

    .line 176
    return-void
.end method

.method private static a(Ljava/net/URLConnection;)Lcom/a/a/a/a/h;
    .locals 1

    .prologue
    .line 323
    instance-of v0, p0, Lcom/a/a/a/a/o;

    if-eqz v0, :cond_0

    .line 324
    check-cast p0, Lcom/a/a/a/a/o;

    invoke-virtual {p0}, Lcom/a/a/a/a/o;->b()Lcom/a/a/a/a/h;

    move-result-object v0

    .line 328
    :goto_0
    return-object v0

    .line 325
    :cond_0
    instance-of v0, p0, Lcom/a/a/a/a/r;

    if-eqz v0, :cond_1

    .line 326
    check-cast p0, Lcom/a/a/a/a/r;

    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->b()Lcom/a/a/a/a/h;

    move-result-object v0

    goto :goto_0

    .line 328
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic a(Lcom/a/a/a/i;)Ljava/io/InputStream;
    .locals 3

    .prologue
    .line 121
    new-instance v0, Lcom/a/a/h;

    iget-object v1, p0, Lcom/a/a/a/i;->c:[Ljava/io/InputStream;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-direct {v0, v1, p0}, Lcom/a/a/h;-><init>(Ljava/io/InputStream;Lcom/a/a/a/i;)V

    return-object v0
.end method

.method private static a(Ljava/net/URI;)Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v0, 0x0

    .line 180
    :try_start_0
    const-string v1, "MD5"

    invoke-static {v1}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    .line 181
    invoke-virtual {p0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "UTF-8"

    invoke-virtual {v2, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v2

    .line 182
    sget-object v3, Lcom/a/a/f;->b:[C

    array-length v1, v2

    mul-int/lit8 v1, v1, 0x2

    new-array v4, v1, [C

    array-length v5, v2

    move v1, v0

    :goto_0
    if-ge v0, v5, :cond_0

    aget-byte v6, v2, v0

    add-int/lit8 v7, v1, 0x1

    shr-int/lit8 v8, v6, 0x4

    and-int/lit8 v8, v8, 0xf

    aget-char v8, v3, v8

    aput-char v8, v4, v1

    add-int/lit8 v1, v7, 0x1

    and-int/lit8 v6, v6, 0xf

    aget-char v6, v3, v6

    aput-char v6, v4, v7

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v4}, Ljava/lang/String;-><init>([C)V
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1

    return-object v0

    .line 183
    :catch_0
    move-exception v0

    .line 184
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1

    .line 185
    :catch_1
    move-exception v0

    .line 186
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1
.end method

.method private declared-synchronized a()V
    .locals 1

    .prologue
    .line 388
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/a/a/f;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/a/a/f;->g:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 389
    monitor-exit p0

    return-void

    .line 388
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private static a(Lcom/a/a/a/f;)V
    .locals 1

    .prologue
    .line 315
    if-eqz p0, :cond_0

    .line 316
    :try_start_0
    invoke-virtual {p0}, Lcom/a/a/a/f;->b()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 320
    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic a(Lcom/a/a/f;)V
    .locals 0

    .prologue
    .line 121
    invoke-direct {p0}, Lcom/a/a/f;->a()V

    return-void
.end method

.method static synthetic a(Lcom/a/a/f;Lcom/a/a/u;)V
    .locals 0

    .prologue
    .line 121
    invoke-direct {p0, p1}, Lcom/a/a/f;->a(Lcom/a/a/u;)V

    return-void
.end method

.method private declared-synchronized a(Lcom/a/a/u;)V
    .locals 2

    .prologue
    .line 374
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/a/a/f;->h:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/a/a/f;->h:I

    .line 376
    sget-object v0, Lcom/a/a/i;->a:[I

    invoke-virtual {p1}, Lcom/a/a/u;->ordinal()I

    move-result v1

    aget v0, v0, v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    packed-switch v0, :pswitch_data_0

    .line 385
    :goto_0
    monitor-exit p0

    return-void

    .line 378
    :pswitch_0
    :try_start_1
    iget v0, p0, Lcom/a/a/f;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/a/a/f;->g:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 374
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 382
    :pswitch_1
    :try_start_2
    iget v0, p0, Lcom/a/a/f;->f:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/a/a/f;->f:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 376
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method static synthetic a(Ljava/net/CacheResponse;Ljava/net/HttpURLConnection;)V
    .locals 8

    .prologue
    .line 121
    invoke-static {p1}, Lcom/a/a/f;->a(Ljava/net/URLConnection;)Lcom/a/a/a/a/h;

    move-result-object v0

    iget-object v1, v0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->f()Lcom/a/a/a/a/z;

    move-result-object v2

    iget-object v0, v0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    iget-object v2, v2, Lcom/a/a/a/a/z;->q:Ljava/util/Set;

    invoke-virtual {v0, v2}, Lcom/a/a/a/a/v;->a(Ljava/util/Set;)Lcom/a/a/a/a/v;

    move-result-object v0

    new-instance v2, Lcom/a/a/l;

    invoke-direct {v2, v1, v0, p1}, Lcom/a/a/l;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;Ljava/net/HttpURLConnection;)V

    instance-of v0, p0, Lcom/a/a/m;

    if-eqz v0, :cond_1

    check-cast p0, Lcom/a/a/m;

    invoke-static {p0}, Lcom/a/a/m;->a(Lcom/a/a/m;)Lcom/a/a/a/i;

    move-result-object v0

    :goto_0
    const/4 v1, 0x0

    :try_start_0
    iget-object v3, v0, Lcom/a/a/a/i;->d:Lcom/a/a/a/c;

    iget-object v4, v0, Lcom/a/a/a/i;->a:Ljava/lang/String;

    iget-wide v6, v0, Lcom/a/a/a/i;->b:J

    invoke-static {v3, v4, v6, v7}, Lcom/a/a/a/c;->a(Lcom/a/a/a/c;Ljava/lang/String;J)Lcom/a/a/a/f;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    if-eqz v0, :cond_0

    :try_start_1
    invoke-virtual {v2, v0}, Lcom/a/a/l;->a(Lcom/a/a/a/f;)V

    invoke-virtual {v0}, Lcom/a/a/a/f;->a()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    :cond_0
    :goto_1
    return-void

    :cond_1
    check-cast p0, Lcom/a/a/n;

    invoke-static {p0}, Lcom/a/a/n;->a(Lcom/a/a/n;)Lcom/a/a/a/i;

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v0, v1

    :goto_2
    invoke-static {v0}, Lcom/a/a/f;->a(Lcom/a/a/a/f;)V

    goto :goto_1

    :catch_1
    move-exception v1

    goto :goto_2
.end method

.method static synthetic a(Lcom/a/a/f;Ljava/lang/String;Ljava/net/URI;)Z
    .locals 1

    .prologue
    .line 121
    invoke-direct {p0, p1, p2}, Lcom/a/a/f;->a(Ljava/lang/String;Ljava/net/URI;)Z

    move-result v0

    return v0
.end method

.method private a(Ljava/lang/String;Ljava/net/URI;)Z
    .locals 2

    .prologue
    .line 277
    const-string v0, "POST"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "PUT"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "DELETE"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 280
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/a/a/f;->c:Lcom/a/a/a/c;

    invoke-static {p2}, Lcom/a/a/f;->a(Ljava/net/URI;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/a/a/a/c;->b(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 284
    :goto_0
    const/4 v0, 0x1

    .line 286
    :goto_1
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic b(Lcom/a/a/f;)I
    .locals 2

    .prologue
    .line 121
    iget v0, p0, Lcom/a/a/f;->d:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/a/a/f;->d:I

    return v0
.end method

.method static synthetic c(Lcom/a/a/f;)I
    .locals 2

    .prologue
    .line 121
    iget v0, p0, Lcom/a/a/f;->e:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/a/a/f;->e:I

    return v0
.end method


# virtual methods
.method public final get(Ljava/net/URI;Ljava/lang/String;Ljava/util/Map;)Ljava/net/CacheResponse;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)",
            "Ljava/net/CacheResponse;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 203
    invoke-static {p1}, Lcom/a/a/f;->a(Ljava/net/URI;)Ljava/lang/String;

    move-result-object v0

    .line 207
    :try_start_0
    iget-object v4, p0, Lcom/a/a/f;->c:Lcom/a/a/a/c;

    invoke-virtual {v4, v0}, Lcom/a/a/a/c;->a(Ljava/lang/String;)Lcom/a/a/a/i;

    move-result-object v4

    .line 208
    if-nez v4, :cond_0

    move-object v0, v1

    .line 222
    :goto_0
    return-object v0

    .line 211
    :cond_0
    new-instance v5, Lcom/a/a/l;

    iget-object v0, v4, Lcom/a/a/a/i;->c:[Ljava/io/InputStream;

    const/4 v6, 0x0

    aget-object v0, v0, v6

    invoke-direct {v5, v0}, Lcom/a/a/l;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 217
    iget-object v0, v5, Lcom/a/a/l;->a:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, v5, Lcom/a/a/l;->c:Ljava/lang/String;

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    new-instance v0, Lcom/a/a/a/a/z;

    iget-object v6, v5, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    invoke-direct {v0, p1, v6}, Lcom/a/a/a/a/z;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V

    iget-object v6, v5, Lcom/a/a/l;->b:Lcom/a/a/a/a/v;

    invoke-virtual {v6, v3}, Lcom/a/a/a/a/v;->a(Z)Ljava/util/Map;

    move-result-object v6

    iget-object v0, v0, Lcom/a/a/a/a/z;->q:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {v6, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-interface {p3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v8, v0}, Lcom/a/a/a/u;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v3

    :goto_1
    if-eqz v0, :cond_3

    move v0, v2

    :goto_2
    if-nez v0, :cond_4

    .line 218
    invoke-virtual {v4}, Lcom/a/a/a/i;->close()V

    move-object v0, v1

    .line 219
    goto :goto_0

    .line 214
    :catch_0
    move-exception v0

    move-object v0, v1

    goto :goto_0

    :cond_2
    move v0, v2

    .line 217
    goto :goto_1

    :cond_3
    move v0, v3

    goto :goto_2

    .line 222
    :cond_4
    invoke-virtual {v5}, Lcom/a/a/l;->a()Z

    move-result v0

    if-eqz v0, :cond_5

    new-instance v0, Lcom/a/a/n;

    invoke-direct {v0, v5, v4}, Lcom/a/a/n;-><init>(Lcom/a/a/l;Lcom/a/a/a/i;)V

    goto :goto_0

    :cond_5
    new-instance v0, Lcom/a/a/m;

    invoke-direct {v0, v5, v4}, Lcom/a/a/m;-><init>(Lcom/a/a/l;Lcom/a/a/a/i;)V

    goto :goto_0
.end method

.method public final put(Ljava/net/URI;Ljava/net/URLConnection;)Ljava/net/CacheRequest;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 227
    instance-of v1, p2, Ljava/net/HttpURLConnection;

    if-nez v1, :cond_1

    .line 268
    :cond_0
    :goto_0
    return-object v0

    .line 231
    :cond_1
    check-cast p2, Ljava/net/HttpURLConnection;

    .line 232
    invoke-virtual {p2}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v1

    .line 234
    invoke-direct {p0, v1, p1}, Lcom/a/a/f;->a(Ljava/lang/String;Ljava/net/URI;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 237
    const-string v2, "GET"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 244
    invoke-static {p2}, Lcom/a/a/f;->a(Ljava/net/URLConnection;)Lcom/a/a/a/a/h;

    move-result-object v1

    .line 245
    if-eqz v1, :cond_0

    .line 250
    invoke-virtual {v1}, Lcom/a/a/a/a/h;->f()Lcom/a/a/a/a/z;

    move-result-object v2

    .line 251
    iget-object v3, v2, Lcom/a/a/a/a/z;->q:Ljava/util/Set;

    const-string v4, "*"

    invoke-interface {v3, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 255
    iget-object v1, v1, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v1, v1, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    iget-object v2, v2, Lcom/a/a/a/a/z;->q:Ljava/util/Set;

    invoke-virtual {v1, v2}, Lcom/a/a/a/a/v;->a(Ljava/util/Set;)Lcom/a/a/a/a/v;

    move-result-object v1

    .line 257
    new-instance v3, Lcom/a/a/l;

    invoke-direct {v3, p1, v1, p2}, Lcom/a/a/l;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;Ljava/net/HttpURLConnection;)V

    .line 260
    :try_start_0
    iget-object v1, p0, Lcom/a/a/f;->c:Lcom/a/a/a/c;

    invoke-static {p1}, Lcom/a/a/f;->a(Ljava/net/URI;)Ljava/lang/String;

    move-result-object v2

    const-wide/16 v4, -0x1

    invoke-virtual {v1, v2, v4, v5}, Lcom/a/a/a/c;->a(Ljava/lang/String;J)Lcom/a/a/a/f;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 261
    if-eqz v2, :cond_0

    .line 264
    :try_start_1
    invoke-virtual {v3, v2}, Lcom/a/a/l;->a(Lcom/a/a/a/f;)V

    .line 265
    new-instance v1, Lcom/a/a/j;

    invoke-direct {v1, p0, v2}, Lcom/a/a/j;-><init>(Lcom/a/a/f;Lcom/a/a/a/f;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v0, v1

    goto :goto_0

    .line 267
    :catch_0
    move-exception v1

    move-object v1, v0

    :goto_1
    invoke-static {v1}, Lcom/a/a/f;->a(Lcom/a/a/a/f;)V

    goto :goto_0

    :catch_1
    move-exception v1

    move-object v1, v2

    goto :goto_1
.end method
