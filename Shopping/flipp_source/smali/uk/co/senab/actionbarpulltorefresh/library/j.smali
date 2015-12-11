.class public final Luk/co/senab/actionbarpulltorefresh/library/j;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field a:Luk/co/senab/actionbarpulltorefresh/library/f;

.field b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

.field c:Landroid/app/Activity;

.field d:Landroid/view/View;

.field e:Luk/co/senab/actionbarpulltorefresh/library/a/a;

.field final f:I

.field g:F

.field h:F

.field i:Z

.field j:Z

.field k:Z

.field l:Landroid/view/View;

.field final m:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap",
            "<",
            "Landroid/view/View;",
            "Luk/co/senab/actionbarpulltorefresh/library/b/c;",
            ">;"
        }
    .end annotation
.end field

.field final n:Z

.field final o:Landroid/graphics/Rect;

.field private p:Luk/co/senab/actionbarpulltorefresh/library/e;

.field private final q:F

.field private r:F

.field private s:F

.field private final t:I

.field private final u:Z

.field private v:Z

.field private final w:[I

.field private final x:Ljava/lang/Runnable;


# direct methods
.method protected constructor <init>(Landroid/app/Activity;Luk/co/senab/actionbarpulltorefresh/library/h;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    iput-boolean v3, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->v:Z

    .line 72
    const/4 v0, 0x2

    new-array v0, v0, [I

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->w:[I

    .line 73
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    .line 643
    new-instance v0, Luk/co/senab/actionbarpulltorefresh/library/m;

    invoke-direct {v0, p0}, Luk/co/senab/actionbarpulltorefresh/library/m;-><init>(Luk/co/senab/actionbarpulltorefresh/library/j;)V

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->x:Ljava/lang/Runnable;

    .line 76
    if-nez p1, :cond_0

    .line 77
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "activity cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 79
    :cond_0
    if-nez p2, :cond_1

    .line 80
    const-string v0, "PullToRefreshAttacher"

    const-string v1, "Given null options so using default options."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 81
    new-instance p2, Luk/co/senab/actionbarpulltorefresh/library/h;

    invoke-direct {p2}, Luk/co/senab/actionbarpulltorefresh/library/h;-><init>()V

    .line 84
    :cond_1
    iput-object p1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->c:Landroid/app/Activity;

    .line 85
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->m:Ljava/util/WeakHashMap;

    .line 88
    iget v0, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->d:F

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->q:F

    .line 89
    iget-boolean v0, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->e:Z

    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->n:Z

    .line 90
    iget v0, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->f:I

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->t:I

    .line 91
    iget-boolean v0, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->g:Z

    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->u:Z

    .line 94
    iget-object v0, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->a:Luk/co/senab/actionbarpulltorefresh/library/e;

    if-eqz v0, :cond_2

    iget-object v0, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->a:Luk/co/senab/actionbarpulltorefresh/library/e;

    :goto_0
    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->p:Luk/co/senab/actionbarpulltorefresh/library/e;

    .line 99
    iget-object v0, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->c:Luk/co/senab/actionbarpulltorefresh/library/f;

    if-eqz v0, :cond_3

    iget-object v0, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->c:Luk/co/senab/actionbarpulltorefresh/library/f;

    :goto_1
    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    .line 104
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v0

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->f:I

    .line 107
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 110
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->p:Luk/co/senab/actionbarpulltorefresh/library/e;

    invoke-interface {v1, p1}, Luk/co/senab/actionbarpulltorefresh/library/e;->a(Landroid/app/Activity;)Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    iget v2, p2, Luk/co/senab/actionbarpulltorefresh/library/h;->b:I

    invoke-virtual {v1, v2, v0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    .line 113
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    if-nez v1, :cond_4

    .line 114
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Must supply valid layout id for header."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 94
    :cond_2
    new-instance v0, Luk/co/senab/actionbarpulltorefresh/library/l;

    invoke-direct {v0, p0}, Luk/co/senab/actionbarpulltorefresh/library/l;-><init>(Luk/co/senab/actionbarpulltorefresh/library/j;)V

    goto :goto_0

    .line 99
    :cond_3
    new-instance v0, Luk/co/senab/actionbarpulltorefresh/library/c;

    invoke-direct {v0}, Luk/co/senab/actionbarpulltorefresh/library/c;-><init>()V

    goto :goto_1

    .line 117
    :cond_4
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 120
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    invoke-virtual {v1, p1, v2}, Luk/co/senab/actionbarpulltorefresh/library/f;->a(Landroid/app/Activity;Landroid/view/View;)V

    .line 123
    new-instance v1, Luk/co/senab/actionbarpulltorefresh/library/k;

    invoke-direct {v1, p0, v0}, Luk/co/senab/actionbarpulltorefresh/library/k;-><init>(Luk/co/senab/actionbarpulltorefresh/library/j;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->post(Ljava/lang/Runnable;)Z

    .line 135
    return-void
.end method

.method private a(Z)Z
    .locals 1

    .prologue
    .line 538
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->j:Z

    if-nez v0, :cond_1

    if-eqz p1, :cond_0

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private e()V
    .locals 4

    .prologue
    .line 459
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->c:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    invoke-virtual {v0, v2}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    const/4 v0, 0x0

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    instance-of v2, v2, Landroid/view/WindowManager$LayoutParams;

    if-eqz v2, :cond_2

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager$LayoutParams;

    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    iget v2, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    iget-object v3, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->top:I

    if-eq v2, v3, :cond_1

    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    iput v2, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->c:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v2

    invoke-interface {v2, v1, v0}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 460
    :cond_1
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    invoke-virtual {v0}, Luk/co/senab/actionbarpulltorefresh/library/f;->e()Z

    .line 461
    return-void

    .line 459
    :cond_2
    invoke-virtual {v1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Landroid/view/WindowManager$LayoutParams;

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager$LayoutParams;

    goto :goto_0
.end method

.method private f()V
    .locals 2

    .prologue
    .line 547
    const/4 v0, 0x0

    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->j:Z

    .line 550
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->u:Z

    if-eqz v0, :cond_0

    .line 551
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->x:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 555
    :cond_0
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    invoke-virtual {v0}, Luk/co/senab/actionbarpulltorefresh/library/f;->f()Z

    .line 556
    return-void
.end method


# virtual methods
.method final a(Landroid/view/View;)F
    .locals 2

    .prologue
    .line 542
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v0

    int-to-float v0, v0

    iget v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->q:F

    mul-float/2addr v0, v1

    return v0
.end method

.method final a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 221
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->v:Z

    if-eqz v0, :cond_0

    .line 236
    :goto_0
    return-void

    .line 224
    :cond_0
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->c:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/view/WindowManager;->removeViewImmediate(Landroid/view/View;)V

    .line 227
    :cond_1
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v0}, Ljava/util/WeakHashMap;->clear()V

    .line 229
    iput-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->c:Landroid/app/Activity;

    .line 230
    iput-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    .line 231
    iput-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->e:Luk/co/senab/actionbarpulltorefresh/library/a/a;

    .line 232
    iput-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->p:Luk/co/senab/actionbarpulltorefresh/library/e;

    .line 233
    iput-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    .line 235
    const/4 v0, 0x1

    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->v:Z

    goto :goto_0
.end method

.method final a(ZZ)V
    .locals 4

    .prologue
    .line 515
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/j;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 530
    :cond_0
    :goto_0
    return-void

    .line 519
    :cond_1
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->j:Z

    if-eq v0, p1, :cond_0

    .line 523
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/j;->b()V

    .line 525
    if-eqz p1, :cond_4

    invoke-direct {p0, p2}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(Z)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 526
    const/4 v0, 0x1

    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->j:Z

    if-eqz p2, :cond_2

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

    if-eqz v0, :cond_2

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

    invoke-interface {v0}, Luk/co/senab/actionbarpulltorefresh/library/a/b;->a()V

    :cond_2
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    invoke-virtual {v0}, Luk/co/senab/actionbarpulltorefresh/library/f;->b()V

    invoke-direct {p0}, Luk/co/senab/actionbarpulltorefresh/library/j;->e()V

    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->u:Z

    if-eqz v0, :cond_0

    iget v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->t:I

    if-lez v0, :cond_3

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->x:Ljava/lang/Runnable;

    iget v2, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->t:I

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    :cond_3
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->x:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 528
    :cond_4
    invoke-direct {p0}, Luk/co/senab/actionbarpulltorefresh/library/j;->f()V

    goto :goto_0
.end method

.method final a(Landroid/view/MotionEvent;)Z
    .locals 11

    .prologue
    const/4 v10, 0x1

    const/4 v2, 0x0

    .line 268
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->j:Z

    if-eqz v0, :cond_0

    move v0, v2

    .line 315
    :goto_0
    return v0

    .line 272
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    .line 274
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 315
    :cond_1
    :goto_1
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->i:Z

    goto :goto_0

    .line 278
    :pswitch_0
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->i:Z

    if-nez v0, :cond_1

    iget v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->r:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-lez v0, :cond_1

    .line 279
    iget v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->r:F

    sub-float v0, v4, v0

    .line 280
    iget v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->s:F

    sub-float v1, v3, v1

    .line 282
    cmpl-float v1, v0, v1

    if-lez v1, :cond_2

    iget v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->f:I

    int-to-float v1, v1

    cmpl-float v1, v0, v1

    if-lez v1, :cond_2

    .line 283
    iput-boolean v10, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->i:Z

    .line 284
    invoke-direct {p0}, Luk/co/senab/actionbarpulltorefresh/library/j;->e()V

    iput v4, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->h:F

    goto :goto_1

    .line 285
    :cond_2
    iget v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->f:I

    neg-int v1, v1

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_1

    .line 286
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/j;->b()V

    goto :goto_1

    .line 294
    :pswitch_1
    invoke-direct {p0, v10}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 295
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v0}, Ljava/util/WeakHashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_3
    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 296
    invoke-virtual {v0}, Landroid/view/View;->isShown()Z

    move-result v1

    if-eqz v1, :cond_4

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v1, v0}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->w:[I

    invoke-virtual {v0, v1}, Landroid/view/View;->getLocationOnScreen([I)V

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->w:[I

    aget v1, v1, v2

    iget-object v6, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->w:[I

    aget v6, v6, v10

    iget-object v7, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v8

    add-int/2addr v8, v1

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v9

    add-int/2addr v9, v6

    invoke-virtual {v7, v1, v6, v8, v9}, Landroid/graphics/Rect;->set(IIII)V

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v1

    float-to-int v6, v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v1

    float-to-int v1, v1

    iget-object v7, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    invoke-virtual {v7, v6, v1}, Landroid/graphics/Rect;->contains(II)Z

    move-result v1

    if-eqz v1, :cond_4

    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v1, v0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Luk/co/senab/actionbarpulltorefresh/library/b/c;

    if-eqz v1, :cond_4

    iget-object v7, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->left:I

    sub-int/2addr v6, v7

    int-to-float v6, v6

    iget-object v7, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->top:I

    invoke-interface {v1, v0, v6}, Luk/co/senab/actionbarpulltorefresh/library/b/c;->a(Landroid/view/View;F)Z

    move-result v1

    :goto_3
    if-eqz v1, :cond_3

    .line 297
    iput v3, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->s:F

    .line 298
    iput v4, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->r:F

    .line 299
    iput-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->l:Landroid/view/View;

    goto :goto_2

    :cond_4
    move v1, v2

    .line 296
    goto :goto_3

    .line 308
    :pswitch_2
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/j;->b()V

    goto/16 :goto_1

    .line 274
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method final b()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 417
    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->i:Z

    .line 418
    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->k:Z

    .line 419
    const/high16 v0, -0x40800000    # -1.0f

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->h:F

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->g:F

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->r:F

    .line 420
    return-void
.end method

.method final c()V
    .locals 1

    .prologue
    .line 453
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->j:Z

    if-nez v0, :cond_0

    .line 454
    invoke-direct {p0}, Luk/co/senab/actionbarpulltorefresh/library/j;->f()V

    .line 456
    :cond_0
    return-void
.end method

.method final d()Z
    .locals 2

    .prologue
    .line 586
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->v:Z

    if-eqz v0, :cond_0

    .line 587
    const-string v0, "PullToRefreshAttacher"

    const-string v1, "PullToRefreshAttacher is destroyed."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 589
    :cond_0
    iget-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/j;->v:Z

    return v0
.end method
