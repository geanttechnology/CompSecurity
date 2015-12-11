.class public final Lcom/google/android/gms/internal/it;
.super Lcom/google/android/gms/location/k;


# instance fields
.field private a:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/location/g;)V
    .locals 1

    invoke-direct {p0}, Lcom/google/android/gms/location/k;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/is;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/is;-><init>(Lcom/google/android/gms/location/g;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/it;->a:Landroid/os/Handler;

    return-void
.end method


# virtual methods
.method public final a(Landroid/location/Location;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/it;->a:Landroid/os/Handler;

    if-nez v0, :cond_0

    const-string v0, "LocationClientHelper"

    const-string v1, "Received a location in client after calling removeLocationUpdates."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    return-void

    :cond_0
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    const/4 v1, 0x1

    iput v1, v0, Landroid/os/Message;->what:I

    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/internal/it;->a:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method
