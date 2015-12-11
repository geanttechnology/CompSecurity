.class public final Lcom/a/b/ad;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final a:Landroid/os/Handler;

.field static b:Lcom/a/b/ad;


# instance fields
.field public final c:Landroid/content/Context;

.field final d:Lcom/a/b/n;

.field final e:Lcom/a/b/h;

.field final f:Lcom/a/b/as;

.field final g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Lcom/a/b/a;",
            ">;"
        }
    .end annotation
.end field

.field final h:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Landroid/widget/ImageView;",
            "Lcom/a/b/m;",
            ">;"
        }
    .end annotation
.end field

.field final i:Ljava/lang/ref/ReferenceQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/ReferenceQueue",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field j:Z

.field k:Z

.field private final l:Lcom/a/b/ai;

.field private final m:Lcom/a/b/ak;

.field private final n:Lcom/a/b/ag;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 83
    new-instance v0, Lcom/a/b/ae;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/a/b/ae;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lcom/a/b/ad;->a:Landroid/os/Handler;

    .line 104
    const/4 v0, 0x0

    sput-object v0, Lcom/a/b/ad;->b:Lcom/a/b/ad;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/ai;Lcom/a/b/ak;Lcom/a/b/as;Z)V
    .locals 3

    .prologue
    .line 122
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    iput-object p1, p0, Lcom/a/b/ad;->c:Landroid/content/Context;

    .line 124
    iput-object p2, p0, Lcom/a/b/ad;->d:Lcom/a/b/n;

    .line 125
    iput-object p3, p0, Lcom/a/b/ad;->e:Lcom/a/b/h;

    .line 126
    iput-object p4, p0, Lcom/a/b/ad;->l:Lcom/a/b/ai;

    .line 127
    iput-object p5, p0, Lcom/a/b/ad;->m:Lcom/a/b/ak;

    .line 128
    iput-object p6, p0, Lcom/a/b/ad;->f:Lcom/a/b/as;

    .line 129
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    iput-object v0, p0, Lcom/a/b/ad;->g:Ljava/util/Map;

    .line 130
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    iput-object v0, p0, Lcom/a/b/ad;->h:Ljava/util/Map;

    .line 131
    iput-boolean p7, p0, Lcom/a/b/ad;->j:Z

    .line 132
    new-instance v0, Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0}, Ljava/lang/ref/ReferenceQueue;-><init>()V

    iput-object v0, p0, Lcom/a/b/ad;->i:Ljava/lang/ref/ReferenceQueue;

    .line 133
    new-instance v0, Lcom/a/b/ag;

    iget-object v1, p0, Lcom/a/b/ad;->i:Ljava/lang/ref/ReferenceQueue;

    sget-object v2, Lcom/a/b/ad;->a:Landroid/os/Handler;

    invoke-direct {v0, v1, v2}, Lcom/a/b/ag;-><init>(Ljava/lang/ref/ReferenceQueue;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/a/b/ad;->n:Lcom/a/b/ag;

    .line 134
    iget-object v0, p0, Lcom/a/b/ad;->n:Lcom/a/b/ag;

    invoke-virtual {v0}, Lcom/a/b/ag;->start()V

    .line 135
    return-void
.end method

.method public static a(Landroid/content/Context;)Lcom/a/b/ad;
    .locals 15

    .prologue
    .line 389
    sget-object v0, Lcom/a/b/ad;->b:Lcom/a/b/ad;

    if-nez v0, :cond_4

    .line 390
    new-instance v8, Lcom/a/b/af;

    invoke-direct {v8, p0}, Lcom/a/b/af;-><init>(Landroid/content/Context;)V

    iget-object v1, v8, Lcom/a/b/af;->a:Landroid/content/Context;

    iget-object v0, v8, Lcom/a/b/af;->b:Lcom/a/b/s;

    if-nez v0, :cond_0

    invoke-static {v1}, Lcom/a/b/ba;->a(Landroid/content/Context;)Lcom/a/b/s;

    move-result-object v0

    iput-object v0, v8, Lcom/a/b/af;->b:Lcom/a/b/s;

    :cond_0
    iget-object v0, v8, Lcom/a/b/af;->d:Lcom/a/b/h;

    if-nez v0, :cond_1

    new-instance v0, Lcom/a/b/x;

    invoke-direct {v0, v1}, Lcom/a/b/x;-><init>(Landroid/content/Context;)V

    iput-object v0, v8, Lcom/a/b/af;->d:Lcom/a/b/h;

    :cond_1
    iget-object v0, v8, Lcom/a/b/af;->c:Ljava/util/concurrent/ExecutorService;

    if-nez v0, :cond_2

    new-instance v0, Lcom/a/b/an;

    invoke-direct {v0}, Lcom/a/b/an;-><init>()V

    iput-object v0, v8, Lcom/a/b/af;->c:Ljava/util/concurrent/ExecutorService;

    :cond_2
    iget-object v0, v8, Lcom/a/b/af;->f:Lcom/a/b/ak;

    if-nez v0, :cond_3

    sget-object v0, Lcom/a/b/ak;->a:Lcom/a/b/ak;

    iput-object v0, v8, Lcom/a/b/af;->f:Lcom/a/b/ak;

    :cond_3
    new-instance v6, Lcom/a/b/as;

    iget-object v0, v8, Lcom/a/b/af;->d:Lcom/a/b/h;

    invoke-direct {v6, v0}, Lcom/a/b/as;-><init>(Lcom/a/b/h;)V

    new-instance v0, Lcom/a/b/n;

    iget-object v2, v8, Lcom/a/b/af;->c:Ljava/util/concurrent/ExecutorService;

    sget-object v3, Lcom/a/b/ad;->a:Landroid/os/Handler;

    iget-object v4, v8, Lcom/a/b/af;->b:Lcom/a/b/s;

    iget-object v5, v8, Lcom/a/b/af;->d:Lcom/a/b/h;

    invoke-direct/range {v0 .. v6}, Lcom/a/b/n;-><init>(Landroid/content/Context;Ljava/util/concurrent/ExecutorService;Landroid/os/Handler;Lcom/a/b/s;Lcom/a/b/h;Lcom/a/b/as;)V

    new-instance v7, Lcom/a/b/ad;

    iget-object v10, v8, Lcom/a/b/af;->d:Lcom/a/b/h;

    iget-object v11, v8, Lcom/a/b/af;->e:Lcom/a/b/ai;

    iget-object v12, v8, Lcom/a/b/af;->f:Lcom/a/b/ak;

    iget-boolean v14, v8, Lcom/a/b/af;->g:Z

    move-object v8, v1

    move-object v9, v0

    move-object v13, v6

    invoke-direct/range {v7 .. v14}, Lcom/a/b/ad;-><init>(Landroid/content/Context;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/ai;Lcom/a/b/ak;Lcom/a/b/as;Z)V

    sput-object v7, Lcom/a/b/ad;->b:Lcom/a/b/ad;

    .line 392
    :cond_4
    sget-object v0, Lcom/a/b/ad;->b:Lcom/a/b/ad;

    return-object v0
.end method

.method static synthetic a(Lcom/a/b/ad;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final a(Lcom/a/b/ao;)Lcom/a/b/ao;
    .locals 3

    .prologue
    .line 253
    iget-object v0, p0, Lcom/a/b/ad;->m:Lcom/a/b/ak;

    invoke-interface {v0, p1}, Lcom/a/b/ak;->a(Lcom/a/b/ao;)Lcom/a/b/ao;

    move-result-object v0

    .line 254
    if-nez v0, :cond_0

    .line 255
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Request transformer "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/a/b/ad;->m:Lcom/a/b/ak;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " returned null for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 260
    :cond_0
    return-object v0
.end method

.method public final a(Ljava/lang/String;)Lcom/a/b/aq;
    .locals 2

    .prologue
    .line 177
    if-nez p1, :cond_0

    .line 178
    new-instance v0, Lcom/a/b/aq;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/a/b/aq;-><init>(Lcom/a/b/ad;Landroid/net/Uri;)V

    .line 183
    :goto_0
    return-object v0

    .line 180
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 181
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Path must not be empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 183
    :cond_1
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    new-instance v0, Lcom/a/b/aq;

    invoke-direct {v0, p0, v1}, Lcom/a/b/aq;-><init>(Lcom/a/b/ad;Landroid/net/Uri;)V

    goto :goto_0
.end method

.method public final a(Lcom/a/b/a;)V
    .locals 3

    .prologue
    .line 268
    iget-object v0, p1, Lcom/a/b/a;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    .line 269
    if-eqz v0, :cond_0

    .line 270
    invoke-virtual {p0, v0}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    .line 271
    iget-object v1, p0, Lcom/a/b/ad;->g:Ljava/util/Map;

    invoke-interface {v1, v0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 273
    :cond_0
    iget-object v0, p0, Lcom/a/b/ad;->d:Lcom/a/b/n;

    iget-object v1, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    iget-object v0, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    const/4 v2, 0x1

    invoke-virtual {v0, v2, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 274
    return-void
.end method

.method public final a(Ljava/lang/Object;)V
    .locals 4

    .prologue
    .line 322
    iget-object v0, p0, Lcom/a/b/ad;->g:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/b/a;

    .line 323
    if-eqz v0, :cond_0

    .line 324
    invoke-virtual {v0}, Lcom/a/b/a;->b()V

    .line 325
    iget-object v1, p0, Lcom/a/b/ad;->d:Lcom/a/b/n;

    iget-object v2, v1, Lcom/a/b/n;->f:Landroid/os/Handler;

    iget-object v1, v1, Lcom/a/b/n;->f:Landroid/os/Handler;

    const/4 v3, 0x2

    invoke-virtual {v1, v3, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 327
    :cond_0
    instance-of v0, p1, Landroid/widget/ImageView;

    if-eqz v0, :cond_1

    .line 328
    check-cast p1, Landroid/widget/ImageView;

    .line 329
    iget-object v0, p0, Lcom/a/b/ad;->h:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/b/m;

    .line 331
    if-eqz v0, :cond_1

    .line 332
    const/4 v1, 0x0

    iput-object v1, v0, Lcom/a/b/m;->c:Lcom/a/b/j;

    iget-object v1, v0, Lcom/a/b/m;->b:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Landroid/widget/ImageView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual {v1, v0}, Landroid/view/ViewTreeObserver;->removeOnPreDrawListener(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V

    .line 335
    :cond_1
    return-void
.end method

.method public final b(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 3

    .prologue
    .line 281
    iget-object v0, p0, Lcom/a/b/ad;->e:Lcom/a/b/h;

    invoke-interface {v0, p1}, Lcom/a/b/h;->a(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 282
    if-eqz v0, :cond_0

    .line 283
    iget-object v1, p0, Lcom/a/b/ad;->f:Lcom/a/b/as;

    invoke-virtual {v1}, Lcom/a/b/as;->a()V

    .line 287
    :goto_0
    return-object v0

    .line 285
    :cond_0
    iget-object v1, p0, Lcom/a/b/ad;->f:Lcom/a/b/as;

    iget-object v1, v1, Lcom/a/b/as;->c:Landroid/os/Handler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_0
.end method
