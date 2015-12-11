.class public Lcom/exacttarget/etpushsdk/location/e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/location/a;


# instance fields
.field protected a:Landroid/location/LocationListener;

.field protected b:Landroid/location/LocationManager;

.field protected c:Landroid/location/Criteria;

.field protected d:Landroid/content/Context;

.field protected e:Landroid/location/LocationListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 146
    new-instance v0, Lcom/exacttarget/etpushsdk/location/f;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/location/f;-><init>(Lcom/exacttarget/etpushsdk/location/e;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->e:Landroid/location/LocationListener;

    .line 63
    const-string v0, "location"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->b:Landroid/location/LocationManager;

    .line 64
    new-instance v0, Landroid/location/Criteria;

    invoke-direct {v0}, Landroid/location/Criteria;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->c:Landroid/location/Criteria;

    .line 68
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->c:Landroid/location/Criteria;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/location/Criteria;->setAccuracy(I)V

    .line 69
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/location/e;->d:Landroid/content/Context;

    .line 70
    return-void
.end method


# virtual methods
.method public a(IJ)Landroid/location/Location;
    .locals 12

    .prologue
    const v8, 0x7f7fffff    # Float.MAX_VALUE

    .line 83
    const/4 v7, 0x0

    .line 85
    const-wide v2, 0x7fffffffffffffffL

    .line 90
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->b:Landroid/location/LocationManager;

    invoke-virtual {v0}, Landroid/location/LocationManager;->getAllProviders()Ljava/util/List;

    move-result-object v0

    .line 91
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    move v5, v8

    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 92
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/e;->b:Landroid/location/LocationManager;

    invoke-virtual {v1, v0}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v6

    .line 93
    if-eqz v6, :cond_4

    .line 94
    invoke-virtual {v6}, Landroid/location/Location;->getAccuracy()F

    move-result v4

    .line 95
    invoke-virtual {v6}, Landroid/location/Location;->getTime()J

    move-result-wide v0

    .line 97
    cmp-long v10, v0, p2

    if-gez v10, :cond_0

    cmpg-float v10, v4, v5

    if-gez v10, :cond_0

    move v2, v4

    move-object v3, v6

    :goto_1
    move v5, v2

    move-object v7, v3

    move-wide v2, v0

    .line 106
    goto :goto_0

    .line 101
    :cond_0
    cmp-long v4, v0, p2

    if-lez v4, :cond_4

    cmpl-float v4, v5, v8

    if-nez v4, :cond_4

    cmp-long v4, v0, v2

    if-gez v4, :cond_4

    move v2, v5

    move-object v3, v6

    .line 103
    goto :goto_1

    .line 117
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->a:Landroid/location/LocationListener;

    if-eqz v0, :cond_3

    cmp-long v0, v2, p2

    if-gtz v0, :cond_2

    int-to-float v0, p1

    cmpl-float v0, v5, v0

    if-lez v0, :cond_3

    .line 118
    :cond_2
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->b:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/e;->c:Landroid/location/Criteria;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/location/LocationManager;->getBestProvider(Landroid/location/Criteria;Z)Ljava/lang/String;

    move-result-object v1

    .line 119
    if-eqz v1, :cond_3

    .line 120
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->b:Landroid/location/LocationManager;

    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/exacttarget/etpushsdk/location/e;->e:Landroid/location/LocationListener;

    iget-object v6, p0, Lcom/exacttarget/etpushsdk/location/e;->d:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V

    .line 124
    :cond_3
    return-object v7

    :cond_4
    move-wide v0, v2

    move v2, v5

    move-object v3, v7

    goto :goto_1
.end method

.method public a()V
    .locals 2

    .prologue
    .line 138
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/e;->b:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/e;->e:Landroid/location/LocationListener;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 139
    return-void
.end method
