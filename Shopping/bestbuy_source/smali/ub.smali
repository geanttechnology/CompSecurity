.class public final Lub;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lwc;

.field private final b:Ltj;

.field private c:Lol;

.field private d:Ltq;

.field private e:[Loo;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Landroid/view/ViewGroup;

.field private i:Lor;

.field private j:Lpg;

.field private k:Lpi;

.field private l:Lou;


# direct methods
.method public constructor <init>(Landroid/view/ViewGroup;)V
    .locals 3

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {}, Ltj;->a()Ltj;

    move-result-object v2

    invoke-direct {p0, p1, v0, v1, v2}, Lub;-><init>(Landroid/view/ViewGroup;Landroid/util/AttributeSet;ZLtj;)V

    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup;Landroid/util/AttributeSet;Z)V
    .locals 1

    invoke-static {}, Ltj;->a()Ltj;

    move-result-object v0

    invoke-direct {p0, p1, p2, p3, v0}, Lub;-><init>(Landroid/view/ViewGroup;Landroid/util/AttributeSet;ZLtj;)V

    return-void
.end method

.method constructor <init>(Landroid/view/ViewGroup;Landroid/util/AttributeSet;ZLtj;)V
    .locals 6

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lub;-><init>(Landroid/view/ViewGroup;Landroid/util/AttributeSet;ZLtj;Ltq;)V

    return-void
.end method

.method constructor <init>(Landroid/view/ViewGroup;Landroid/util/AttributeSet;ZLtj;Ltq;)V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lwc;

    invoke-direct {v0}, Lwc;-><init>()V

    iput-object v0, p0, Lub;->a:Lwc;

    iput-object p1, p0, Lub;->h:Landroid/view/ViewGroup;

    iput-object p4, p0, Lub;->b:Ltj;

    if-eqz p2, :cond_0

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    :try_start_0
    new-instance v0, Lcom/google/android/gms/internal/bb;

    invoke-direct {v0, v1, p2}, Lcom/google/android/gms/internal/bb;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    invoke-virtual {v0, p3}, Lcom/google/android/gms/internal/bb;->a(Z)[Loo;

    move-result-object v2

    iput-object v2, p0, Lub;->e:[Loo;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/bb;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lub;->f:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    invoke-virtual {p1}, Landroid/view/ViewGroup;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/ay;

    iget-object v2, p0, Lub;->e:[Loo;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/internal/ay;-><init>(Landroid/content/Context;Loo;)V

    const-string v1, "Ads by Google"

    invoke-static {p1, v0, v1}, Laca;->a(Landroid/view/ViewGroup;Lcom/google/android/gms/internal/ay;Ljava/lang/String;)V

    :goto_0
    return-void

    :catch_0
    move-exception v0

    new-instance v2, Lcom/google/android/gms/internal/ay;

    sget-object v3, Loo;->a:Loo;

    invoke-direct {v2, v1, v3}, Lcom/google/android/gms/internal/ay;-><init>(Landroid/content/Context;Loo;)V

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v2, v1, v0}, Laca;->a(Landroid/view/ViewGroup;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    iput-object p5, p0, Lub;->d:Ltq;

    goto :goto_0
.end method

.method private e()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lub;->d:Ltq;

    invoke-interface {v0}, Ltq;->a()Lry;

    move-result-object v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Lub;->h:Landroid/view/ViewGroup;

    invoke-static {v0}, Lsb;->a(Lry;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "Failed to get an ad frame."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private f()V
    .locals 4

    iget-object v0, p0, Lub;->e:[Loo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lub;->f:Ljava/lang/String;

    if-nez v0, :cond_1

    :cond_0
    iget-object v0, p0, Lub;->d:Ltq;

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The ad size and ad unit ID must be set before loadAd is called."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iget-object v0, p0, Lub;->h:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/ay;

    iget-object v2, p0, Lub;->e:[Loo;

    invoke-direct {v1, v0, v2}, Lcom/google/android/gms/internal/ay;-><init>(Landroid/content/Context;[Loo;)V

    iget-object v2, p0, Lub;->f:Ljava/lang/String;

    iget-object v3, p0, Lub;->a:Lwc;

    invoke-static {v0, v1, v2, v3}, Lth;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lwc;)Ltq;

    move-result-object v0

    iput-object v0, p0, Lub;->d:Ltq;

    iget-object v0, p0, Lub;->c:Lol;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lub;->d:Ltq;

    new-instance v1, Ltg;

    iget-object v2, p0, Lub;->c:Lol;

    invoke-direct {v1, v2}, Ltg;-><init>(Lol;)V

    invoke-interface {v0, v1}, Ltq;->a(Ltn;)V

    :cond_2
    iget-object v0, p0, Lub;->i:Lor;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lub;->d:Ltq;

    new-instance v1, Ltm;

    iget-object v2, p0, Lub;->i:Lor;

    invoke-direct {v1, v2}, Ltm;-><init>(Lor;)V

    invoke-interface {v0, v1}, Ltq;->a(Ltw;)V

    :cond_3
    iget-object v0, p0, Lub;->j:Lpg;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lub;->d:Ltq;

    new-instance v1, Lyy;

    iget-object v2, p0, Lub;->j:Lpg;

    invoke-direct {v1, v2}, Lyy;-><init>(Lpg;)V

    invoke-interface {v0, v1}, Ltq;->a(Lyj;)V

    :cond_4
    iget-object v0, p0, Lub;->k:Lpi;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lub;->d:Ltq;

    new-instance v1, Lzd;

    iget-object v2, p0, Lub;->k:Lpi;

    invoke-direct {v1, v2}, Lzd;-><init>(Lpi;)V

    iget-object v2, p0, Lub;->g:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ltq;->a(Lyv;Ljava/lang/String;)V

    :cond_5
    iget-object v0, p0, Lub;->l:Lou;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lub;->d:Ltq;

    new-instance v1, Lup;

    iget-object v2, p0, Lub;->l:Lou;

    invoke-direct {v1, v2}, Lup;-><init>(Lou;)V

    invoke-interface {v0, v1}, Ltq;->a(Lum;)V

    :cond_6
    invoke-direct {p0}, Lub;->e()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lub;->d:Ltq;

    invoke-interface {v0}, Ltq;->b()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to destroy AdView."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lub;->f:Ljava/lang/String;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The ad unit ID can only be set once on AdView."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lub;->f:Ljava/lang/String;

    return-void
.end method

.method public a(Lol;)V
    .locals 2

    :try_start_0
    iput-object p1, p0, Lub;->c:Lol;

    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lub;->d:Ltq;

    if-eqz p1, :cond_1

    new-instance v0, Ltg;

    invoke-direct {v0, p1}, Ltg;-><init>(Lol;)V

    :goto_0
    invoke-interface {v1, v0}, Ltq;->a(Ltn;)V
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

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public a(Lor;)V
    .locals 2

    :try_start_0
    iput-object p1, p0, Lub;->i:Lor;

    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lub;->d:Ltq;

    if-eqz p1, :cond_1

    new-instance v0, Ltm;

    invoke-direct {v0, p1}, Ltm;-><init>(Lor;)V

    :goto_0
    invoke-interface {v1, v0}, Ltq;->a(Ltw;)V
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

    const-string v1, "Failed to set the AppEventListener."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public a(Lpg;)V
    .locals 2

    iget-object v0, p0, Lub;->k:Lpi;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Play store purchase parameter has already been set."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    :try_start_0
    iput-object p1, p0, Lub;->j:Lpg;

    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_1

    iget-object v1, p0, Lub;->d:Ltq;

    if-eqz p1, :cond_2

    new-instance v0, Lyy;

    invoke-direct {v0, p1}, Lyy;-><init>(Lpg;)V

    :goto_0
    invoke-interface {v1, v0}, Ltq;->a(Lyj;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_1
    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "Failed to set the InAppPurchaseListener."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public a(Lpi;Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lub;->j:Lpg;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "InAppPurchaseListener has already been set."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    :try_start_0
    iput-object p1, p0, Lub;->k:Lpi;

    iput-object p2, p0, Lub;->g:Ljava/lang/String;

    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_1

    iget-object v1, p0, Lub;->d:Ltq;

    if-eqz p1, :cond_2

    new-instance v0, Lzd;

    invoke-direct {v0, p1}, Lzd;-><init>(Lpi;)V

    :goto_0
    invoke-interface {v1, v0, p2}, Ltq;->a(Lyv;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_1
    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "Failed to set the play store purchase parameter."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public a(Ltz;)V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lub;->d:Ltq;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lub;->f()V

    :cond_0
    iget-object v0, p0, Lub;->d:Ltq;

    iget-object v1, p0, Lub;->b:Ltj;

    iget-object v2, p0, Lub;->h:Landroid/view/ViewGroup;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Ltj;->a(Landroid/content/Context;Ltz;)Lcom/google/android/gms/internal/av;

    move-result-object v1

    invoke-interface {v0, v1}, Ltq;->a(Lcom/google/android/gms/internal/av;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lub;->a:Lwc;

    invoke-virtual {p1}, Ltz;->i()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v0, v1}, Lwc;->a(Ljava/util/Map;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to load ad."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public varargs a([Loo;)V
    .locals 2

    iget-object v0, p0, Lub;->e:[Loo;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The ad size can only be set once on AdView."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p0, p1}, Lub;->b([Loo;)V

    return-void
.end method

.method public b()Loo;
    .locals 2

    :try_start_0
    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lub;->d:Ltq;

    invoke-interface {v0}, Ltq;->i()Lcom/google/android/gms/internal/ay;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ay;->a()Loo;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "Failed to get the current AdSize."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_0
    iget-object v0, p0, Lub;->e:[Loo;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lub;->e:[Loo;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public varargs b([Loo;)V
    .locals 4

    iput-object p1, p0, Lub;->e:[Loo;

    :try_start_0
    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lub;->d:Ltq;

    new-instance v1, Lcom/google/android/gms/internal/ay;

    iget-object v2, p0, Lub;->h:Landroid/view/ViewGroup;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lub;->e:[Loo;

    invoke-direct {v1, v2, v3}, Lcom/google/android/gms/internal/ay;-><init>(Landroid/content/Context;[Loo;)V

    invoke-interface {v0, v1}, Ltq;->a(Lcom/google/android/gms/internal/ay;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    iget-object v0, p0, Lub;->h:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->requestLayout()V

    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to set the ad size."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lub;->d:Ltq;

    invoke-interface {v0}, Ltq;->d()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to call pause."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public d()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lub;->d:Ltq;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lub;->d:Ltq;

    invoke-interface {v0}, Ltq;->e()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to call resume."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
