.class public Lcom/exacttarget/etpushsdk/location/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/location/a;


# instance fields
.field protected a:Landroid/app/PendingIntent;

.field protected b:Landroid/location/LocationListener;

.field protected c:Landroid/location/LocationManager;

.field protected d:Landroid/content/Context;

.field protected e:Landroid/location/Criteria;

.field protected f:Landroid/content/BroadcastReceiver;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 106
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    new-instance v0, Lcom/exacttarget/etpushsdk/location/d;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/location/d;-><init>(Lcom/exacttarget/etpushsdk/location/c;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/location/c;->f:Landroid/content/BroadcastReceiver;

    .line 107
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/location/c;->d:Landroid/content/Context;

    .line 108
    const-string v0, "location"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/location/c;->c:Landroid/location/LocationManager;

    .line 109
    new-instance v0, Landroid/location/Criteria;

    invoke-direct {v0}, Landroid/location/Criteria;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/location/c;->e:Landroid/location/Criteria;

    .line 110
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/c;->e:Landroid/location/Criteria;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/location/Criteria;->setAccuracy(I)V

    .line 114
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.exacttarget.etpushsdk.SINGLE_LOCATION_UPDATE_ACTION"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 115
    const/4 v1, 0x0

    const/high16 v2, 0x8000000

    invoke-static {p1, v1, v0, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/location/c;->a:Landroid/app/PendingIntent;

    .line 116
    return-void
.end method


# virtual methods
.method public a(IJ)Landroid/location/Location;
    .locals 12

    .prologue
    const v8, 0x7f7fffff    # Float.MAX_VALUE

    .line 129
    const/4 v7, 0x0

    .line 131
    const-wide/high16 v2, -0x8000000000000000L

    .line 136
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/c;->c:Landroid/location/LocationManager;

    invoke-virtual {v0}, Landroid/location/LocationManager;->getAllProviders()Ljava/util/List;

    move-result-object v0

    .line 137
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

    .line 138
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/c;->c:Landroid/location/LocationManager;

    invoke-virtual {v1, v0}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v6

    .line 139
    if-eqz v6, :cond_4

    .line 140
    invoke-virtual {v6}, Landroid/location/Location;->getAccuracy()F

    move-result v4

    .line 141
    invoke-virtual {v6}, Landroid/location/Location;->getTime()J

    move-result-wide v0

    .line 147
    cmp-long v10, v0, p2

    if-lez v10, :cond_0

    cmpg-float v10, v4, v5

    if-gtz v10, :cond_0

    cmp-long v10, v0, v2

    if-lez v10, :cond_0

    move v2, v4

    move-object v3, v6

    :goto_1
    move v5, v2

    move-object v7, v3

    move-wide v2, v0

    .line 156
    goto :goto_0

    .line 151
    :cond_0
    cmp-long v4, v0, p2

    if-gez v4, :cond_4

    cmpl-float v4, v5, v8

    if-nez v4, :cond_4

    cmp-long v4, v0, v2

    if-lez v4, :cond_4

    move v2, v5

    move-object v3, v6

    .line 153
    goto :goto_1

    .line 164
    :cond_1
    cmp-long v0, v2, p2

    if-ltz v0, :cond_2

    int-to-float v0, p1

    cmpl-float v0, v5, v0

    if-lez v0, :cond_3

    .line 165
    :cond_2
    const-string v0, "~!lc"

    const-string v1, "starting singleUpdateReceiver"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "com.exacttarget.etpushsdk.SINGLE_LOCATION_UPDATE_ACTION"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 167
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/c;->d:Landroid/content/Context;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/location/c;->f:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 169
    :try_start_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/c;->c:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/c;->e:Landroid/location/Criteria;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/location/c;->a:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1, v2}, Landroid/location/LocationManager;->requestSingleUpdate(Landroid/location/Criteria;Landroid/app/PendingIntent;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 178
    :goto_2
    return-object v7

    .line 170
    :catch_0
    move-exception v0

    .line 171
    const-string v1, "~!lc"

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2

    .line 175
    :cond_3
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v1, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-direct {v1, v7}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;-><init>(Landroid/location/Location;)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->b(Ljava/lang/Object;)V

    goto :goto_2

    :cond_4
    move-wide v0, v2

    move v2, v5

    move-object v3, v7

    goto :goto_1
.end method

.method public a()V
    .locals 2

    .prologue
    .line 192
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/c;->c:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/c;->a:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/app/PendingIntent;)V

    .line 193
    return-void
.end method
