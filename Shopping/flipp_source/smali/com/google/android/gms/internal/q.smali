.class public final Lcom/google/android/gms/internal/q;
.super Ljava/lang/Object;


# instance fields
.field public a:Lcom/google/android/gms/ads/AdListener;

.field public b:Lcom/google/android/gms/internal/f;

.field public c:[Lcom/google/android/gms/ads/AdSize;

.field public d:Ljava/lang/String;

.field public e:Lcom/google/android/gms/ads/doubleclick/AppEventListener;

.field private final f:Lcom/google/android/gms/internal/bl;

.field private g:Landroid/view/ViewGroup;


# direct methods
.method public constructor <init>(Landroid/view/ViewGroup;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/bl;

    invoke-direct {v0}, Lcom/google/android/gms/internal/bl;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/q;->f:Lcom/google/android/gms/internal/bl;

    iput-object p1, p0, Lcom/google/android/gms/internal/q;->g:Landroid/view/ViewGroup;

    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup;Landroid/util/AttributeSet;Z)V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/bl;

    invoke-direct {v0}, Lcom/google/android/gms/internal/bl;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/q;->f:Lcom/google/android/gms/internal/bl;

    iput-object p1, p0, Lcom/google/android/gms/internal/q;->g:Landroid/view/ViewGroup;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    :try_start_0
    new-instance v0, Lcom/google/android/gms/internal/b;

    invoke-direct {v0, v1, p2}, Lcom/google/android/gms/internal/b;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    if-nez p3, :cond_1

    iget-object v2, v0, Lcom/google/android/gms/internal/b;->a:[Lcom/google/android/gms/ads/AdSize;

    array-length v2, v2

    const/4 v3, 0x1

    if-eq v2, v3, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v2, "The adSizes XML attribute is only allowed on PublisherAdViews."

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    new-instance v2, Lcom/google/android/gms/internal/x;

    sget-object v3, Lcom/google/android/gms/ads/AdSize;->BANNER:Lcom/google/android/gms/ads/AdSize;

    invoke-direct {v2, v1, v3}, Lcom/google/android/gms/internal/x;-><init>(Landroid/content/Context;Lcom/google/android/gms/ads/AdSize;)V

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v2, v1, v0}, Lcom/google/android/gms/internal/er;->a(Landroid/view/ViewGroup;Lcom/google/android/gms/internal/x;Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    :try_start_1
    iget-object v2, v0, Lcom/google/android/gms/internal/b;->a:[Lcom/google/android/gms/ads/AdSize;

    iput-object v2, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    iget-object v0, v0, Lcom/google/android/gms/internal/b;->b:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/android/gms/internal/q;->d:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    invoke-virtual {p1}, Landroid/view/ViewGroup;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/x;

    iget-object v2, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/internal/x;-><init>(Landroid/content/Context;Lcom/google/android/gms/ads/AdSize;)V

    const-string v1, "Ads by Google"

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/er;->a(Landroid/view/ViewGroup;Lcom/google/android/gms/internal/x;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    invoke-interface {v0}, Lcom/google/android/gms/internal/f;->b()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to destroy AdView."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public final a(Lcom/google/android/gms/ads/AdListener;)V
    .locals 2

    :try_start_0
    iput-object p1, p0, Lcom/google/android/gms/internal/q;->a:Lcom/google/android/gms/ads/AdListener;

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-eqz p1, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/kv;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/kv;-><init>(Lcom/google/android/gms/ads/AdListener;)V

    :goto_0
    invoke-interface {v1, v0}, Lcom/google/android/gms/internal/f;->a(Lcom/google/android/gms/internal/c;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_1
    return-void

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "Failed to set the AdListener."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public final a(Lcom/google/android/gms/internal/o;)V
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->d:Ljava/lang/String;

    if-nez v0, :cond_2

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The ad size and ad unit ID must be set before loadAd is called."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    const-string v1, "Failed to load ad."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->g:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/x;

    iget-object v2, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    invoke-direct {v1, v0, v2}, Lcom/google/android/gms/internal/x;-><init>(Landroid/content/Context;[Lcom/google/android/gms/ads/AdSize;)V

    iget-object v2, p0, Lcom/google/android/gms/internal/q;->d:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/android/gms/internal/q;->f:Lcom/google/android/gms/internal/bl;

    invoke-static {v0, v1, v2, v3}, Lcom/google/android/gms/internal/kw;->a(Landroid/content/Context;Lcom/google/android/gms/internal/x;Ljava/lang/String;Lcom/google/android/gms/internal/bl;)Lcom/google/android/gms/internal/f;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->a:Lcom/google/android/gms/ads/AdListener;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    new-instance v1, Lcom/google/android/gms/internal/kv;

    iget-object v2, p0, Lcom/google/android/gms/internal/q;->a:Lcom/google/android/gms/ads/AdListener;

    invoke-direct {v1, v2}, Lcom/google/android/gms/internal/kv;-><init>(Lcom/google/android/gms/ads/AdListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/f;->a(Lcom/google/android/gms/internal/c;)V

    :cond_3
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->e:Lcom/google/android/gms/ads/doubleclick/AppEventListener;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    new-instance v1, Lcom/google/android/gms/internal/kz;

    iget-object v2, p0, Lcom/google/android/gms/internal/q;->e:Lcom/google/android/gms/ads/doubleclick/AppEventListener;

    invoke-direct {v1, v2}, Lcom/google/android/gms/internal/kz;-><init>(Lcom/google/android/gms/ads/doubleclick/AppEventListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/f;->a(Lcom/google/android/gms/internal/l;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0

    :cond_4
    :try_start_2
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    invoke-interface {v0}, Lcom/google/android/gms/internal/f;->a()Lcom/google/android/gms/a/a;
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v0

    if-nez v0, :cond_6

    :cond_5
    :goto_1
    :try_start_3
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    new-instance v1, Lcom/google/android/gms/internal/v;

    iget-object v2, p0, Lcom/google/android/gms/internal/q;->g:Landroid/view/ViewGroup;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lcom/google/android/gms/internal/v;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/o;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/f;->a(Lcom/google/android/gms/internal/v;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->f:Lcom/google/android/gms/internal/bl;

    iget-object v1, p1, Lcom/google/android/gms/internal/o;->g:Ljava/util/Map;

    iput-object v1, v0, Lcom/google/android/gms/internal/bl;->a:Ljava/util/Map;
    :try_end_3
    .catch Landroid/os/RemoteException; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_0

    :cond_6
    :try_start_4
    iget-object v1, p0, Lcom/google/android/gms/internal/q;->g:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/google/android/gms/a/d;->a(Lcom/google/android/gms/a/a;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    :try_end_4
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_1

    :catch_1
    move-exception v0

    :try_start_5
    const-string v1, "Failed to get an ad frame."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_5 .. :try_end_5} :catch_0

    goto :goto_1
.end method

.method public final a(Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->d:Ljava/lang/String;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The ad unit ID can only be set once on AdView."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/google/android/gms/internal/q;->d:Ljava/lang/String;

    return-void
.end method

.method public final varargs a([Lcom/google/android/gms/ads/AdSize;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The ad size can only be set once on AdView."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/q;->b([Lcom/google/android/gms/ads/AdSize;)V

    return-void
.end method

.method public final b()Lcom/google/android/gms/ads/AdSize;
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    invoke-interface {v0}, Lcom/google/android/gms/internal/f;->i()Lcom/google/android/gms/internal/x;

    move-result-object v0

    iget v1, v0, Lcom/google/android/gms/internal/x;->f:I

    iget v2, v0, Lcom/google/android/gms/internal/x;->c:I

    iget-object v0, v0, Lcom/google/android/gms/internal/x;->b:Ljava/lang/String;

    invoke-static {v1, v2, v0}, Lcom/google/android/gms/ads/a;->a(IILjava/lang/String;)Lcom/google/android/gms/ads/AdSize;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "Failed to get the current AdSize."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final varargs b([Lcom/google/android/gms/ads/AdSize;)V
    .locals 4

    iput-object p1, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    new-instance v1, Lcom/google/android/gms/internal/x;

    iget-object v2, p0, Lcom/google/android/gms/internal/q;->g:Landroid/view/ViewGroup;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/q;->c:[Lcom/google/android/gms/ads/AdSize;

    invoke-direct {v1, v2, v3}, Lcom/google/android/gms/internal/x;-><init>(Landroid/content/Context;[Lcom/google/android/gms/ads/AdSize;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/f;->a(Lcom/google/android/gms/internal/x;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->g:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->requestLayout()V

    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to set the ad size."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public final c()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    invoke-interface {v0}, Lcom/google/android/gms/internal/f;->d()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to call pause."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public final d()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/q;->b:Lcom/google/android/gms/internal/f;

    invoke-interface {v0}, Lcom/google/android/gms/internal/f;->e()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to call resume."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
