.class public final Lcom/google/android/gms/internal/ga;
.super Lcom/google/android/gms/internal/gp;


# instance fields
.field private a:Lcom/google/android/gms/internal/fw;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/fw;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/gp;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/ga;->a:Lcom/google/android/gms/internal/fw;

    return-void
.end method


# virtual methods
.method public final a(ILandroid/os/IBinder;Landroid/os/Bundle;)V
    .locals 5

    const-string v0, "onPostInitComplete can be called only once per call to getServiceFromBroker"

    iget-object v1, p0, Lcom/google/android/gms/internal/ga;->a:Lcom/google/android/gms/internal/fw;

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/ha;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/internal/ga;->a:Lcom/google/android/gms/internal/fw;

    iget-object v1, v0, Lcom/google/android/gms/internal/fw;->b:Landroid/os/Handler;

    iget-object v2, v0, Lcom/google/android/gms/internal/fw;->b:Landroid/os/Handler;

    const/4 v3, 0x1

    new-instance v4, Lcom/google/android/gms/internal/gd;

    invoke-direct {v4, v0, p1, p2, p3}, Lcom/google/android/gms/internal/gd;-><init>(Lcom/google/android/gms/internal/fw;ILandroid/os/IBinder;Landroid/os/Bundle;)V

    invoke-virtual {v2, v3, v4}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/ga;->a:Lcom/google/android/gms/internal/fw;

    return-void
.end method
