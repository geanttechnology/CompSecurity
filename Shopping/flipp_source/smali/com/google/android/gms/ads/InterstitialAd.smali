.class public final Lcom/google/android/gms/ads/InterstitialAd;
.super Ljava/lang/Object;


# instance fields
.field private final ea:Lcom/google/android/gms/internal/r;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/r;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/r;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/gms/ads/InterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    return-void
.end method


# virtual methods
.method public final getAdListener()Lcom/google/android/gms/ads/AdListener;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/InterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    iget-object v0, v0, Lcom/google/android/gms/internal/r;->a:Lcom/google/android/gms/ads/AdListener;

    return-object v0
.end method

.method public final getAdUnitId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/InterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    iget-object v0, v0, Lcom/google/android/gms/internal/r;->c:Ljava/lang/String;

    return-object v0
.end method

.method public final isLoaded()Z
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/InterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/r;->a()Z

    move-result v0

    return v0
.end method

.method public final loadAd(Lcom/google/android/gms/ads/AdRequest;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/ads/InterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {p1}, Lcom/google/android/gms/ads/AdRequest;->v()Lcom/google/android/gms/internal/o;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/r;->a(Lcom/google/android/gms/internal/o;)V

    return-void
.end method

.method public final setAdListener(Lcom/google/android/gms/ads/AdListener;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/InterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/r;->a(Lcom/google/android/gms/ads/AdListener;)V

    return-void
.end method

.method public final setAdUnitId(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/InterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/r;->a(Ljava/lang/String;)V

    return-void
.end method

.method public final show()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/ads/InterstitialAd;->ea:Lcom/google/android/gms/internal/r;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/r;->b()V

    return-void
.end method
