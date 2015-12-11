.class Laes$1;
.super Laet;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laes;->a(Lqm;Lcom/google/android/gms/location/GeofencingRequest;Landroid/app/PendingIntent;)Lqq;
.end annotation


# instance fields
.field final synthetic b:Lcom/google/android/gms/location/GeofencingRequest;

.field final synthetic c:Landroid/app/PendingIntent;

.field final synthetic d:Laes;


# direct methods
.method constructor <init>(Laes;Lqm;Lcom/google/android/gms/location/GeofencingRequest;Landroid/app/PendingIntent;)V
    .locals 0

    iput-object p1, p0, Laes$1;->d:Laes;

    iput-object p3, p0, Laes$1;->b:Lcom/google/android/gms/location/GeofencingRequest;

    iput-object p4, p0, Laes$1;->c:Landroid/app/PendingIntent;

    invoke-direct {p0, p2}, Laet;-><init>(Lqm;)V

    return-void
.end method


# virtual methods
.method protected a(Lafd;)V
    .locals 3

    new-instance v0, Laes$1$1;

    invoke-direct {v0, p0}, Laes$1$1;-><init>(Laes$1;)V

    iget-object v1, p0, Laes$1;->b:Lcom/google/android/gms/location/GeofencingRequest;

    iget-object v2, p0, Laes$1;->c:Landroid/app/PendingIntent;

    invoke-virtual {p1, v1, v2, v0}, Lafd;->a(Lcom/google/android/gms/location/GeofencingRequest;Landroid/app/PendingIntent;Laig;)V

    return-void
.end method

.method protected synthetic b(Lqd;)V
    .locals 0

    check-cast p1, Lafd;

    invoke-virtual {p0, p1}, Laes$1;->a(Lafd;)V

    return-void
.end method
