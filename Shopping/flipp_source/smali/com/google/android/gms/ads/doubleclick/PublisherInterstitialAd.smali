.class public final Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;
.super Ljava/lang/Object;


# instance fields
.field private final ea:Lcom/google/android/gms/internal/r;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/r;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/r;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    return-void
.end method


# virtual methods
.method public final getAdListener()Lcom/google/android/gms/ads/AdListener;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    iget-object v0, v0, Lcom/google/android/gms/internal/r;->a:Lcom/google/android/gms/ads/AdListener;

    return-object v0
.end method

.method public final getAdUnitId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    iget-object v0, v0, Lcom/google/android/gms/internal/r;->c:Ljava/lang/String;

    return-object v0
.end method

.method public final getAppEventListener()Lcom/google/android/gms/ads/doubleclick/AppEventListener;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    iget-object v0, v0, Lcom/google/android/gms/internal/r;->d:Lcom/google/android/gms/ads/doubleclick/AppEventListener;

    return-object v0
.end method

.method public final isLoaded()Z
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/r;->a()Z

    move-result v0

    return v0
.end method

.method public final loadAd(Lcom/google/android/gms/ads/doubleclick/PublisherAdRequest;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {p1}, Lcom/google/android/gms/ads/doubleclick/PublisherAdRequest;->v()Lcom/google/android/gms/internal/o;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/r;->a(Lcom/google/android/gms/internal/o;)V

    return-void
.end method

.method public final setAdListener(Lcom/google/android/gms/ads/AdListener;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/r;->a(Lcom/google/android/gms/ads/AdListener;)V

    return-void
.end method

.method public final setAdUnitId(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/r;->a(Ljava/lang/String;)V

    return-void
.end method

.method public final setAppEventListener(Lcom/google/android/gms/ads/doubleclick/AppEventListener;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    :try_start_0
    iput-object p1, v0, Lcom/google/android/gms/internal/r;->d:Lcom/google/android/gms/ads/doubleclick/AppEventListener;

    iget-object v1, v0, Lcom/google/android/gms/internal/r;->b:Lcom/google/android/gms/internal/f;

    if-eqz v1, :cond_0

    iget-object v1, v0, Lcom/google/android/gms/internal/r;->b:Lcom/google/android/gms/internal/f;

    if-eqz p1, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/kz;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/kz;-><init>(Lcom/google/android/gms/ads/doubleclick/AppEventListener;)V

    :goto_0
    invoke-interface {v1, v0}, Lcom/google/android/gms/internal/f;->a(Lcom/google/android/gms/internal/l;)V
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

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public final show()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/doubleclick/PublisherInterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/r;->b()V

    return-void
.end method
