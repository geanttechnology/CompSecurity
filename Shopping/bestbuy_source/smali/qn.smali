.class public final Lqn;
.super Ljava/lang/Object;


# instance fields
.field private a:Ljava/lang/String;

.field private final b:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private c:I

.field private d:Landroid/view/View;

.field private e:Ljava/lang/String;

.field private final f:Landroid/content/Context;

.field private final g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lpx",
            "<*>;",
            "Lpy;",
            ">;"
        }
    .end annotation
.end field

.field private h:Landroid/support/v4/app/FragmentActivity;

.field private i:I

.field private j:Lqp;

.field private k:Landroid/os/Looper;

.field private final l:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lqo;",
            ">;"
        }
    .end annotation
.end field

.field private final m:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lqp;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lqn;->b:Ljava/util/Set;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lqn;->g:Ljava/util/Map;

    const/4 v0, -0x1

    iput v0, p0, Lqn;->i:I

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lqn;->l:Ljava/util/Set;

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lqn;->m:Ljava/util/Set;

    iput-object p1, p0, Lqn;->f:Landroid/content/Context;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    iput-object v0, p0, Lqn;->k:Landroid/os/Looper;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lqn;->e:Ljava/lang/String;

    return-void
.end method

.method private c()Lqm;
    .locals 9

    iget-object v0, p0, Lqn;->h:Landroid/support/v4/app/FragmentActivity;

    invoke-static {v0}, Lcom/google/android/gms/common/api/g;->a(Landroid/support/v4/app/FragmentActivity;)Lcom/google/android/gms/common/api/g;

    move-result-object v8

    iget v0, p0, Lqn;->i:I

    invoke-virtual {v8, v0}, Lcom/google/android/gms/common/api/g;->a(I)Lqm;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Lqw;

    iget-object v1, p0, Lqn;->f:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lqn;->k:Landroid/os/Looper;

    invoke-virtual {p0}, Lqn;->a()Lcom/google/android/gms/internal/jg;

    move-result-object v3

    iget-object v4, p0, Lqn;->g:Ljava/util/Map;

    iget-object v5, p0, Lqn;->l:Ljava/util/Set;

    iget-object v6, p0, Lqn;->m:Ljava/util/Set;

    iget v7, p0, Lqn;->i:I

    invoke-direct/range {v0 .. v7}, Lqw;-><init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;I)V

    :cond_0
    iget v1, p0, Lqn;->i:I

    iget-object v2, p0, Lqn;->j:Lqp;

    invoke-virtual {v8, v1, v0, v2}, Lcom/google/android/gms/common/api/g;->a(ILqm;Lqp;)V

    return-object v0
.end method


# virtual methods
.method public a()Lcom/google/android/gms/internal/jg;
    .locals 6

    new-instance v0, Lcom/google/android/gms/internal/jg;

    iget-object v1, p0, Lqn;->a:Ljava/lang/String;

    iget-object v2, p0, Lqn;->b:Ljava/util/Set;

    iget v3, p0, Lqn;->c:I

    iget-object v4, p0, Lqn;->d:Landroid/view/View;

    iget-object v5, p0, Lqn;->e:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/jg;-><init>(Ljava/lang/String;Ljava/util/Collection;ILandroid/view/View;Ljava/lang/String;)V

    return-object v0
.end method

.method public a(Lpx;)Lqn;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lpx",
            "<+",
            "Lqb;",
            ">;)",
            "Lqn;"
        }
    .end annotation

    iget-object v0, p0, Lqn;->g:Ljava/util/Map;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p1}, Lpx;->b()Ljava/util/List;

    move-result-object v2

    const/4 v0, 0x0

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    iget-object v4, p0, Lqn;->b:Ljava/util/Set;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/Scope;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/Scope;->a()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v4, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_0
    return-object p0
.end method

.method public a(Lqo;)Lqn;
    .locals 1

    iget-object v0, p0, Lqn;->l:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-object p0
.end method

.method public a(Lqp;)Lqn;
    .locals 1

    iget-object v0, p0, Lqn;->m:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-object p0
.end method

.method public b()Lqm;
    .locals 8

    iget-object v0, p0, Lqn;->g:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v1, "must call addApi() to add at least one API"

    invoke-static {v0, v1}, Lady;->b(ZLjava/lang/Object;)V

    iget v0, p0, Lqn;->i:I

    if-ltz v0, :cond_1

    invoke-direct {p0}, Lqn;->c()Lqm;

    move-result-object v0

    :goto_1
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    new-instance v0, Lqw;

    iget-object v1, p0, Lqn;->f:Landroid/content/Context;

    iget-object v2, p0, Lqn;->k:Landroid/os/Looper;

    invoke-virtual {p0}, Lqn;->a()Lcom/google/android/gms/internal/jg;

    move-result-object v3

    iget-object v4, p0, Lqn;->g:Ljava/util/Map;

    iget-object v5, p0, Lqn;->l:Ljava/util/Set;

    iget-object v6, p0, Lqn;->m:Ljava/util/Set;

    const/4 v7, -0x1

    invoke-direct/range {v0 .. v7}, Lqw;-><init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;I)V

    goto :goto_1
.end method
