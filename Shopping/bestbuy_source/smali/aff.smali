.class final Laff;
.super Laev;


# instance fields
.field private a:Laig;

.field private b:Laih;

.field private c:Lafd;


# direct methods
.method public constructor <init>(Laig;Lafd;)V
    .locals 1

    invoke-direct {p0}, Laev;-><init>()V

    iput-object p1, p0, Laff;->a:Laig;

    const/4 v0, 0x0

    iput-object v0, p0, Laff;->b:Laih;

    iput-object p2, p0, Laff;->c:Lafd;

    return-void
.end method

.method public constructor <init>(Laih;Lafd;)V
    .locals 1

    invoke-direct {p0}, Laev;-><init>()V

    iput-object p1, p0, Laff;->b:Laih;

    const/4 v0, 0x0

    iput-object v0, p0, Laff;->a:Laig;

    iput-object p2, p0, Laff;->c:Lafd;

    return-void
.end method


# virtual methods
.method public a(ILandroid/app/PendingIntent;)V
    .locals 8

    const/4 v7, 0x0

    iget-object v0, p0, Laff;->c:Lafd;

    if-nez v0, :cond_0

    const-string v0, "LocationClientImpl"

    const-string v1, "onRemoveGeofencesByPendingIntentResult called multiple times"

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    return-void

    :cond_0
    iget-object v6, p0, Laff;->c:Lafd;

    new-instance v0, Lafg;

    iget-object v1, p0, Laff;->c:Lafd;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v2, 0x1

    iget-object v3, p0, Laff;->b:Laih;

    move v4, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lafg;-><init>(Lafd;ILaih;ILandroid/app/PendingIntent;)V

    invoke-virtual {v6, v0}, Lafd;->a(Lada;)V

    iput-object v7, p0, Laff;->c:Lafd;

    iput-object v7, p0, Laff;->a:Laig;

    iput-object v7, p0, Laff;->b:Laih;

    goto :goto_0
.end method

.method public a(I[Ljava/lang/String;)V
    .locals 5

    const/4 v4, 0x0

    iget-object v0, p0, Laff;->c:Lafd;

    if-nez v0, :cond_0

    const-string v0, "LocationClientImpl"

    const-string v1, "onAddGeofenceResult called multiple times"

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Laff;->c:Lafd;

    new-instance v1, Lafe;

    iget-object v2, p0, Laff;->c:Lafd;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget-object v3, p0, Laff;->a:Laig;

    invoke-direct {v1, v2, v3, p1, p2}, Lafe;-><init>(Lafd;Laig;I[Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lafd;->a(Lada;)V

    iput-object v4, p0, Laff;->c:Lafd;

    iput-object v4, p0, Laff;->a:Laig;

    iput-object v4, p0, Laff;->b:Laih;

    goto :goto_0
.end method

.method public b(I[Ljava/lang/String;)V
    .locals 8

    const/4 v7, 0x0

    iget-object v0, p0, Laff;->c:Lafd;

    if-nez v0, :cond_0

    const-string v0, "LocationClientImpl"

    const-string v1, "onRemoveGeofencesByRequestIdsResult called multiple times"

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    return-void

    :cond_0
    iget-object v6, p0, Laff;->c:Lafd;

    new-instance v0, Lafg;

    iget-object v1, p0, Laff;->c:Lafd;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v2, 0x2

    iget-object v3, p0, Laff;->b:Laih;

    move v4, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lafg;-><init>(Lafd;ILaih;I[Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Lafd;->a(Lada;)V

    iput-object v7, p0, Laff;->c:Lafd;

    iput-object v7, p0, Laff;->a:Laig;

    iput-object v7, p0, Laff;->b:Laih;

    goto :goto_0
.end method
