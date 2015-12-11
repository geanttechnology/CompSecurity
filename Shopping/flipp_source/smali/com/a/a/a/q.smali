.class final Lcom/a/a/a/q;
.super Lcom/a/a/a/p;
.source "SourceFile"


# instance fields
.field private final a:Ljava/lang/reflect/Method;

.field private final b:Ljava/lang/reflect/Method;

.field private final c:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private final d:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/Method;",
            "Ljava/lang/reflect/Method;",
            "Ljava/lang/reflect/Method;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 331
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/a/a/a/p;-><init>(Ljava/lang/reflect/Method;B)V

    .line 332
    iput-object p2, p0, Lcom/a/a/a/q;->b:Ljava/lang/reflect/Method;

    .line 333
    iput-object p3, p0, Lcom/a/a/a/q;->a:Ljava/lang/reflect/Method;

    .line 334
    iput-object p4, p0, Lcom/a/a/a/q;->c:Ljava/lang/Class;

    .line 335
    iput-object p5, p0, Lcom/a/a/a/q;->d:Ljava/lang/Class;

    .line 336
    return-void
.end method


# virtual methods
.method public final a(Ljavax/net/ssl/SSLSocket;[B)V
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 340
    :try_start_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 341
    :goto_0
    array-length v2, p2

    if-ge v0, v2, :cond_0

    .line 342
    add-int/lit8 v2, v0, 0x1

    aget-byte v0, p2, v0

    .line 343
    new-instance v3, Ljava/lang/String;

    const-string v4, "US-ASCII"

    invoke-direct {v3, p2, v2, v0, v4}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 344
    add-int/2addr v0, v2

    .line 345
    goto :goto_0

    .line 346
    :cond_0
    const-class v0, Lcom/a/a/a/m;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/a/a/a/q;->c:Ljava/lang/Class;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/a/a/a/q;->d:Ljava/lang/Class;

    aput-object v4, v2, v3

    new-instance v3, Lcom/a/a/a/r;

    invoke-direct {v3, v1}, Lcom/a/a/a/r;-><init>(Ljava/util/List;)V

    invoke-static {v0, v2, v3}, Ljava/lang/reflect/Proxy;->newProxyInstance(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;

    move-result-object v0

    .line 349
    iget-object v1, p0, Lcom/a/a/a/q;->b:Ljava/lang/reflect/Method;

    const/4 v2, 0x0

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    .line 356
    return-void

    .line 350
    :catch_0
    move-exception v0

    .line 351
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1

    .line 352
    :catch_1
    move-exception v0

    .line 353
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1

    .line 354
    :catch_2
    move-exception v0

    .line 355
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1
.end method

.method public final b(Ljavax/net/ssl/SSLSocket;)[B
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 361
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/q;->a:Ljava/lang/reflect/Method;

    const/4 v2, 0x0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-virtual {v0, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/reflect/Proxy;->getInvocationHandler(Ljava/lang/Object;)Ljava/lang/reflect/InvocationHandler;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/r;

    .line 363
    invoke-static {v0}, Lcom/a/a/a/r;->a(Lcom/a/a/a/r;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {v0}, Lcom/a/a/a/r;->b(Lcom/a/a/a/r;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    .line 364
    const-string v0, "com.squareup.okhttp.OkHttpClient"

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    .line 365
    sget-object v2, Ljava/util/logging/Level;->INFO:Ljava/util/logging/Level;

    const-string v3, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?"

    invoke-virtual {v0, v2, v3}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;)V

    move-object v0, v1

    .line 369
    :goto_0
    return-object v0

    :cond_0
    invoke-static {v0}, Lcom/a/a/a/r;->a(Lcom/a/a/a/r;)Z

    move-result v2

    if-eqz v2, :cond_1

    move-object v0, v1

    goto :goto_0

    :cond_1
    invoke-static {v0}, Lcom/a/a/a/r;->b(Lcom/a/a/a/r;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "US-ASCII"

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v0

    goto :goto_0

    .line 371
    :catch_0
    move-exception v0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 373
    :catch_1
    move-exception v0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 375
    :catch_2
    move-exception v0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0
.end method
