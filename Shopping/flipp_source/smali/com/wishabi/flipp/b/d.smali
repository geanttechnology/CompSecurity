.class final Lcom/wishabi/flipp/b/d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/common/c;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/a;)V
    .locals 0

    .prologue
    .line 1190
    iput-object p1, p0, Lcom/wishabi/flipp/b/d;->a:Lcom/wishabi/flipp/b/a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a_()V
    .locals 6

    .prologue
    .line 1193
    iget-object v0, p0, Lcom/wishabi/flipp/b/d;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->l(Lcom/wishabi/flipp/b/a;)Lcom/google/android/gms/location/e;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/iu;->e()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1213
    :cond_0
    :goto_0
    return-void

    .line 1196
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/b/d;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->l(Lcom/wishabi/flipp/b/a;)Lcom/google/android/gms/location/e;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/location/e;->a()Landroid/location/Location;

    move-result-object v0

    .line 1197
    iget-object v1, p0, Lcom/wishabi/flipp/b/d;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v1}, Lcom/wishabi/flipp/b/a;->l(Lcom/wishabi/flipp/b/a;)Lcom/google/android/gms/location/e;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/iu;->g()V

    .line 1198
    iget-object v1, p0, Lcom/wishabi/flipp/b/d;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v1}, Lcom/wishabi/flipp/b/a;->m(Lcom/wishabi/flipp/b/a;)Lcom/google/android/gms/location/e;

    .line 1200
    if-eqz v0, :cond_0

    .line 1203
    iget-object v1, p0, Lcom/wishabi/flipp/b/d;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v1, v0}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Landroid/location/Location;)Landroid/location/Location;

    .line 1205
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1206
    const-string v2, "lat"

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1207
    const-string v2, "lon"

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1208
    const-string v2, "accuracy"

    invoke-virtual {v0}, Landroid/location/Location;->getAccuracy()F

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1209
    const-string v2, "postal_code"

    iget-object v3, p0, Lcom/wishabi/flipp/b/d;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v3}, Lcom/wishabi/flipp/b/a;->n(Lcom/wishabi/flipp/b/a;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1210
    iget-object v2, p0, Lcom/wishabi/flipp/b/d;->a:Lcom/wishabi/flipp/b/a;

    const-string v3, "location"

    invoke-static {v2, v3, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Ljava/lang/String;Ljava/util/Map;)V

    .line 1212
    invoke-static {v0}, Lcom/localytics/android/Localytics;->setLocation(Landroid/location/Location;)V

    goto :goto_0
.end method

.method public final b()V
    .locals 0

    .prologue
    .line 1216
    return-void
.end method
