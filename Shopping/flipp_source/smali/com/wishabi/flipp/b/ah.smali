.class final Lcom/wishabi/flipp/b/ah;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/common/c;


# instance fields
.field final synthetic a:Landroid/location/Geocoder;

.field final synthetic b:Lcom/wishabi/flipp/b/ag;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/ag;Landroid/location/Geocoder;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/wishabi/flipp/b/ah;->b:Lcom/wishabi/flipp/b/ag;

    iput-object p2, p0, Lcom/wishabi/flipp/b/ah;->a:Landroid/location/Geocoder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a_()V
    .locals 3

    .prologue
    .line 41
    iget-object v0, p0, Lcom/wishabi/flipp/b/ah;->b:Lcom/wishabi/flipp/b/ag;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ag;->b:Lcom/google/android/gms/location/e;

    iget-object v0, v0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/iu;->e()Z

    move-result v0

    if-nez v0, :cond_1

    .line 81
    :cond_0
    :goto_0
    return-void

    .line 44
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/b/ah;->b:Lcom/wishabi/flipp/b/ag;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ag;->b:Lcom/google/android/gms/location/e;

    invoke-virtual {v0}, Lcom/google/android/gms/location/e;->a()Landroid/location/Location;

    move-result-object v0

    .line 45
    iget-object v1, p0, Lcom/wishabi/flipp/b/ah;->b:Lcom/wishabi/flipp/b/ag;

    iget-object v1, v1, Lcom/wishabi/flipp/b/ag;->b:Lcom/google/android/gms/location/e;

    iget-object v1, v1, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/iu;->g()V

    .line 46
    iget-object v1, p0, Lcom/wishabi/flipp/b/ah;->b:Lcom/wishabi/flipp/b/ag;

    const/4 v2, 0x0

    iput-object v2, v1, Lcom/wishabi/flipp/b/ag;->b:Lcom/google/android/gms/location/e;

    .line 48
    if-eqz v0, :cond_0

    .line 51
    new-instance v1, Lcom/wishabi/flipp/b/ai;

    invoke-direct {v1, p0, v0}, Lcom/wishabi/flipp/b/ai;-><init>(Lcom/wishabi/flipp/b/ah;Landroid/location/Location;)V

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Void;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/b/ai;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public final b()V
    .locals 0

    .prologue
    .line 84
    return-void
.end method
