.class public Laql;
.super Ljava/lang/Object;


# static fields
.field private static g:Laql;


# instance fields
.field private final a:Laqm;

.field private final b:Landroid/content/Context;

.field private final c:Laqg;

.field private final d:Laru;

.field private final e:Ljava/util/concurrent/ConcurrentMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentMap",
            "<",
            "Lasd;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private final f:Lasg;


# direct methods
.method constructor <init>(Landroid/content/Context;Laqm;Laqg;Laru;)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "context cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Laql;->b:Landroid/content/Context;

    iput-object p4, p0, Laql;->d:Laru;

    iput-object p2, p0, Laql;->a:Laqm;

    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Laql;->e:Ljava/util/concurrent/ConcurrentMap;

    iput-object p3, p0, Laql;->c:Laqg;

    iget-object v0, p0, Laql;->c:Laqg;

    new-instance v1, Laql$1;

    invoke-direct {v1, p0}, Laql$1;-><init>(Laql;)V

    invoke-virtual {v0, v1}, Laqg;->a(Laqi;)V

    iget-object v0, p0, Laql;->c:Laqg;

    new-instance v1, Larx;

    iget-object v2, p0, Laql;->b:Landroid/content/Context;

    invoke-direct {v1, v2}, Larx;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Laqg;->a(Laqi;)V

    new-instance v0, Lasg;

    invoke-direct {v0}, Lasg;-><init>()V

    iput-object v0, p0, Laql;->f:Lasg;

    invoke-direct {p0}, Laql;->b()V

    return-void
.end method

.method public static a(Landroid/content/Context;)Laql;
    .locals 5

    const-class v1, Laql;

    monitor-enter v1

    :try_start_0
    sget-object v0, Laql;->g:Laql;

    if-nez v0, :cond_1

    if-nez p0, :cond_0

    const-string v0, "TagManager.getInstance requires non-null context."

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    new-instance v0, Laql$2;

    invoke-direct {v0}, Laql$2;-><init>()V

    new-instance v2, Lasi;

    invoke-direct {v2, p0}, Lasi;-><init>(Landroid/content/Context;)V

    new-instance v3, Laql;

    new-instance v4, Laqg;

    invoke-direct {v4, v2}, Laqg;-><init>(Laqj;)V

    invoke-static {}, Larv;->b()Larv;

    move-result-object v2

    invoke-direct {v3, p0, v0, v4, v2}, Laql;-><init>(Landroid/content/Context;Laqm;Laqg;Laru;)V

    sput-object v3, Laql;->g:Laql;

    :cond_1
    sget-object v0, Laql;->g:Laql;

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v0
.end method

.method static synthetic a(Laql;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Laql;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Laql;->e:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v0}, Ljava/util/concurrent/ConcurrentMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lasd;

    invoke-virtual {v0, p1}, Lasd;->a(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    return-void
.end method

.method private b()V
    .locals 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Laql;->b:Landroid/content/Context;

    new-instance v1, Laql$3;

    invoke-direct {v1, p0}, Laql$3;-><init>(Laql;)V

    invoke-virtual {v0, v1}, Landroid/content/Context;->registerComponentCallbacks(Landroid/content/ComponentCallbacks;)V

    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    iget-object v0, p0, Laql;->d:Laru;

    invoke-virtual {v0}, Laru;->a()V

    return-void
.end method

.method public declared-synchronized a(Landroid/net/Uri;)Z
    .locals 5

    monitor-enter p0

    :try_start_0
    invoke-static {}, Larg;->a()Larg;

    move-result-object v1

    invoke-virtual {v1, p1}, Larg;->a(Landroid/net/Uri;)Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-virtual {v1}, Larg;->d()Ljava/lang/String;

    move-result-object v2

    sget-object v0, Laql$4;->a:[I

    invoke-virtual {v1}, Larg;->b()Larh;

    move-result-object v3

    invoke-virtual {v3}, Larh;->ordinal()I

    move-result v3

    aget v0, v0, v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    packed-switch v0, :pswitch_data_0

    :cond_0
    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :pswitch_0
    :try_start_1
    iget-object v0, p0, Laql;->e:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v0}, Ljava/util/concurrent/ConcurrentMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lasd;

    invoke-virtual {v0}, Lasd;->d()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lasd;->b(Ljava/lang/String;)V

    invoke-virtual {v0}, Lasd;->c()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :pswitch_1
    :try_start_2
    iget-object v0, p0, Laql;->e:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v0}, Ljava/util/concurrent/ConcurrentMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lasd;

    invoke-virtual {v0}, Lasd;->d()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-virtual {v1}, Larg;->c()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lasd;->b(Ljava/lang/String;)V

    invoke-virtual {v0}, Lasd;->c()V

    goto :goto_2

    :cond_3
    invoke-virtual {v0}, Lasd;->e()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_2

    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Lasd;->b(Ljava/lang/String;)V

    invoke-virtual {v0}, Lasd;->c()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    :cond_4
    const/4 v0, 0x0

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method a(Lasd;)Z
    .locals 1

    iget-object v0, p0, Laql;->e:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ConcurrentMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
