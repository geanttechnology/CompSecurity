.class public Laes;
.super Ljava/lang/Object;

# interfaces
.implements Lahu;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lqm;Landroid/app/PendingIntent;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Landroid/app/PendingIntent;",
            ")",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    new-instance v0, Laes$2;

    invoke-direct {v0, p0, p1, p2}, Laes$2;-><init>(Laes;Lqm;Landroid/app/PendingIntent;)V

    invoke-interface {p1, v0}, Lqm;->b(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method

.method public a(Lqm;Lcom/google/android/gms/location/GeofencingRequest;Landroid/app/PendingIntent;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Lcom/google/android/gms/location/GeofencingRequest;",
            "Landroid/app/PendingIntent;",
            ")",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    new-instance v0, Laes$1;

    invoke-direct {v0, p0, p1, p2, p3}, Laes$1;-><init>(Laes;Lqm;Lcom/google/android/gms/location/GeofencingRequest;Landroid/app/PendingIntent;)V

    invoke-interface {p1, v0}, Lqm;->b(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method

.method public a(Lqm;Ljava/util/List;)Lqq;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    new-instance v0, Laes$3;

    invoke-direct {v0, p0, p1, p2}, Laes$3;-><init>(Laes;Lqm;Ljava/util/List;)V

    invoke-interface {p1, v0}, Lqm;->b(Lqj;)Lqj;

    move-result-object v0

    return-object v0
.end method

.method public a(Lqm;Ljava/util/List;Landroid/app/PendingIntent;)Lqq;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqm;",
            "Ljava/util/List",
            "<",
            "Lahs;",
            ">;",
            "Landroid/app/PendingIntent;",
            ")",
            "Lqq",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance v0, Lahw;

    invoke-direct {v0}, Lahw;-><init>()V

    invoke-virtual {v0, p2}, Lahw;->a(Ljava/util/List;)Lahw;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lahw;->a(I)Lahw;

    invoke-virtual {v0}, Lahw;->a()Lcom/google/android/gms/location/GeofencingRequest;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p3}, Laes;->a(Lqm;Lcom/google/android/gms/location/GeofencingRequest;Landroid/app/PendingIntent;)Lqq;

    move-result-object v0

    return-object v0
.end method
