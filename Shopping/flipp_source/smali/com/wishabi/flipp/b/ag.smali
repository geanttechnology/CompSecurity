.class public abstract Lcom/wishabi/flipp/b/ag;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Landroid/content/Context;

.field b:Lcom/google/android/gms/location/e;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/b/ag;->a:Landroid/content/Context;

    .line 26
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    .prologue
    .line 29
    iget-object v0, p0, Lcom/wishabi/flipp/b/ag;->b:Lcom/google/android/gms/location/e;

    if-nez v0, :cond_0

    invoke-static {}, Landroid/location/Geocoder;->isPresent()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/b/ag;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/common/g;->a(Landroid/content/Context;)I

    move-result v0

    if-eqz v0, :cond_1

    .line 32
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/b/ag;->a(Ljava/lang/String;)V

    .line 92
    :goto_0
    return-void

    .line 36
    :cond_1
    new-instance v0, Landroid/location/Geocoder;

    iget-object v1, p0, Lcom/wishabi/flipp/b/ag;->a:Landroid/content/Context;

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/location/Geocoder;-><init>(Landroid/content/Context;Ljava/util/Locale;)V

    .line 37
    new-instance v1, Lcom/google/android/gms/location/e;

    iget-object v2, p0, Lcom/wishabi/flipp/b/ag;->a:Landroid/content/Context;

    new-instance v3, Lcom/wishabi/flipp/b/ah;

    invoke-direct {v3, p0, v0}, Lcom/wishabi/flipp/b/ah;-><init>(Lcom/wishabi/flipp/b/ag;Landroid/location/Geocoder;)V

    new-instance v0, Lcom/wishabi/flipp/b/aj;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/b/aj;-><init>(Lcom/wishabi/flipp/b/ag;)V

    invoke-direct {v1, v2, v3, v0}, Lcom/google/android/gms/location/e;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;)V

    iput-object v1, p0, Lcom/wishabi/flipp/b/ag;->b:Lcom/google/android/gms/location/e;

    .line 91
    iget-object v0, p0, Lcom/wishabi/flipp/b/ag;->b:Lcom/google/android/gms/location/e;

    iget-object v0, v0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/iu;->d()V

    goto :goto_0
.end method

.method public abstract a(Ljava/lang/String;)V
.end method
