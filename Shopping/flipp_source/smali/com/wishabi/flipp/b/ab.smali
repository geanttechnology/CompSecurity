.class public abstract Lcom/wishabi/flipp/b/ab;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Landroid/content/Context;

.field b:Lcom/google/android/gms/location/e;

.field final c:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-object p1, p0, Lcom/wishabi/flipp/b/ab;->a:Landroid/content/Context;

    .line 41
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/b/ab;->c:Landroid/os/Handler;

    .line 42
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/ab;Landroid/location/Location;I)V
    .locals 9

    .prologue
    const/4 v4, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 25
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    if-eqz v0, :cond_1

    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "EEE MMM dd HH:mm:ss zzz yyyy a"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    const-string v1, "Canada/Eastern"

    invoke-static {v1}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    if-eqz p1, :cond_2

    new-instance v1, Ljava/util/Date;

    invoke-virtual {p1}, Landroid/location/Location;->getTime()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    packed-switch p2, :pswitch_data_0

    :cond_0
    :goto_1
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/b/ab;->a(Landroid/location/Location;I)V

    invoke-virtual {p0}, Lcom/wishabi/flipp/b/ab;->a()V

    :cond_1
    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    :pswitch_0
    if-eqz p1, :cond_0

    const-string v1, "Found cached location: %f %f %s"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    aput-object v3, v2, v7

    aput-object v0, v2, v8

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_1

    :pswitch_1
    if-eqz p1, :cond_0

    const-string v1, "Found active location: %f %f %s"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    aput-object v3, v2, v7

    aput-object v0, v2, v8

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 138
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    if-eqz v0, :cond_0

    .line 139
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    iget-object v0, v0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/iu;->g()V

    .line 140
    iput-object v1, p0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->c:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 144
    return-void
.end method

.method public final a(J)V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 46
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    if-eqz v0, :cond_0

    .line 47
    invoke-virtual {p0}, Lcom/wishabi/flipp/b/ab;->a()V

    .line 49
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->a:Landroid/content/Context;

    if-nez v0, :cond_2

    .line 50
    const/4 v0, 0x5

    invoke-virtual {p0, v2, v0}, Lcom/wishabi/flipp/b/ab;->a(Landroid/location/Location;I)V

    .line 135
    :cond_1
    :goto_0
    return-void

    .line 54
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->a:Landroid/content/Context;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 57
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "network"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 59
    const/4 v0, 0x2

    invoke-virtual {p0, v2, v0}, Lcom/wishabi/flipp/b/ab;->a(Landroid/location/Location;I)V

    goto :goto_0

    .line 63
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/common/g;->a(Landroid/content/Context;)I

    move-result v1

    .line 66
    if-eqz v1, :cond_4

    .line 67
    const/4 v0, 0x3

    invoke-virtual {p0, v2, v0}, Lcom/wishabi/flipp/b/ab;->a(Landroid/location/Location;I)V

    .line 68
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->a:Landroid/content/Context;

    instance-of v0, v0, Landroid/app/Activity;

    if-eqz v0, :cond_1

    .line 71
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->a:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-static {v1, v0}, Lcom/google/android/gms/common/g;->a(ILandroid/app/Activity;)Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    goto :goto_0

    .line 77
    :cond_4
    new-instance v0, Lcom/google/android/gms/location/e;

    iget-object v1, p0, Lcom/wishabi/flipp/b/ab;->a:Landroid/content/Context;

    new-instance v2, Lcom/wishabi/flipp/b/ac;

    invoke-direct {v2, p0, p1, p2}, Lcom/wishabi/flipp/b/ac;-><init>(Lcom/wishabi/flipp/b/ab;J)V

    new-instance v3, Lcom/wishabi/flipp/b/af;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/b/af;-><init>(Lcom/wishabi/flipp/b/ab;)V

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/location/e;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;)V

    iput-object v0, p0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    .line 134
    iget-object v0, p0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    iget-object v0, v0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/iu;->d()V

    goto :goto_0
.end method

.method public abstract a(Landroid/location/Location;I)V
.end method
