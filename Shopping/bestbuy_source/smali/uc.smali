.class public Luc;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lwc;

.field private final b:Landroid/content/Context;

.field private final c:Ltj;

.field private d:Lol;

.field private e:Ltq;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Lor;

.field private i:Lpi;

.field private j:Lpg;

.field private k:Los;

.field private l:Lou;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    invoke-static {}, Ltj;->a()Ltj;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Luc;-><init>(Landroid/content/Context;Ltj;Los;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ltj;Los;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lwc;

    invoke-direct {v0}, Lwc;-><init>()V

    iput-object v0, p0, Luc;->a:Lwc;

    iput-object p1, p0, Luc;->b:Landroid/content/Context;

    iput-object p2, p0, Luc;->c:Ltj;

    iput-object p3, p0, Luc;->k:Los;

    return-void
.end method

.method private b(Ljava/lang/String;)V
    .locals 4

    iget-object v0, p0, Luc;->f:Ljava/lang/String;

    if-nez v0, :cond_0

    invoke-direct {p0, p1}, Luc;->c(Ljava/lang/String;)V

    :cond_0
    iget-object v0, p0, Luc;->b:Landroid/content/Context;

    new-instance v1, Lcom/google/android/gms/internal/ay;

    invoke-direct {v1}, Lcom/google/android/gms/internal/ay;-><init>()V

    iget-object v2, p0, Luc;->f:Ljava/lang/String;

    iget-object v3, p0, Luc;->a:Lwc;

    invoke-static {v0, v1, v2, v3}, Lth;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lwc;)Ltq;

    move-result-object v0

    iput-object v0, p0, Luc;->e:Ltq;

    iget-object v0, p0, Luc;->d:Lol;

    if-eqz v0, :cond_1

    iget-object v0, p0, Luc;->e:Ltq;

    new-instance v1, Ltg;

    iget-object v2, p0, Luc;->d:Lol;

    invoke-direct {v1, v2}, Ltg;-><init>(Lol;)V

    invoke-interface {v0, v1}, Ltq;->a(Ltn;)V

    :cond_1
    iget-object v0, p0, Luc;->h:Lor;

    if-eqz v0, :cond_2

    iget-object v0, p0, Luc;->e:Ltq;

    new-instance v1, Ltm;

    iget-object v2, p0, Luc;->h:Lor;

    invoke-direct {v1, v2}, Ltm;-><init>(Lor;)V

    invoke-interface {v0, v1}, Ltq;->a(Ltw;)V

    :cond_2
    iget-object v0, p0, Luc;->j:Lpg;

    if-eqz v0, :cond_3

    iget-object v0, p0, Luc;->e:Ltq;

    new-instance v1, Lyy;

    iget-object v2, p0, Luc;->j:Lpg;

    invoke-direct {v1, v2}, Lyy;-><init>(Lpg;)V

    invoke-interface {v0, v1}, Ltq;->a(Lyj;)V

    :cond_3
    iget-object v0, p0, Luc;->i:Lpi;

    if-eqz v0, :cond_4

    iget-object v0, p0, Luc;->e:Ltq;

    new-instance v1, Lzd;

    iget-object v2, p0, Luc;->i:Lpi;

    invoke-direct {v1, v2}, Lzd;-><init>(Lpi;)V

    iget-object v2, p0, Luc;->g:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ltq;->a(Lyv;Ljava/lang/String;)V

    :cond_4
    iget-object v0, p0, Luc;->l:Lou;

    if-eqz v0, :cond_5

    iget-object v0, p0, Luc;->e:Ltq;

    new-instance v1, Lup;

    iget-object v2, p0, Luc;->l:Lou;

    invoke-direct {v1, v2}, Lup;-><init>(Lou;)V

    invoke-interface {v0, v1}, Ltq;->a(Lum;)V

    :cond_5
    return-void
.end method

.method private c(Ljava/lang/String;)V
    .locals 3

    iget-object v0, p0, Luc;->e:Ltq;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "The ad unit ID must be set on InterstitialAd before "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is called."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    :try_start_0
    const-string v0, "show"

    invoke-direct {p0, v0}, Luc;->c(Ljava/lang/String;)V

    iget-object v0, p0, Luc;->e:Ltq;

    invoke-interface {v0}, Ltq;->f()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Failed to show interstitial."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Luc;->f:Ljava/lang/String;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The ad unit ID can only be set once on InterstitialAd."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Luc;->f:Ljava/lang/String;

    return-void
.end method

.method public a(Lol;)V
    .locals 2

    :try_start_0
    iput-object p1, p0, Luc;->d:Lol;

    iget-object v0, p0, Luc;->e:Ltq;

    if-eqz v0, :cond_0

    iget-object v1, p0, Luc;->e:Ltq;

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

.method public a(Ltz;)V
    .locals 3

    :try_start_0
    iget-object v0, p0, Luc;->e:Ltq;

    if-nez v0, :cond_0

    const-string v0, "loadAd"

    invoke-direct {p0, v0}, Luc;->b(Ljava/lang/String;)V

    :cond_0
    iget-object v0, p0, Luc;->e:Ltq;

    iget-object v1, p0, Luc;->c:Ltj;

    iget-object v2, p0, Luc;->b:Landroid/content/Context;

    invoke-virtual {v1, v2, p1}, Ltj;->a(Landroid/content/Context;Ltz;)Lcom/google/android/gms/internal/av;

    move-result-object v1

    invoke-interface {v0, v1}, Ltq;->a(Lcom/google/android/gms/internal/av;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Luc;->a:Lwc;

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
