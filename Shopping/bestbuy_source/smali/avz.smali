.class final Lavz;
.super Lavx;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lavx",
        "<",
        "Latu;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lqk;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqk",
            "<",
            "Latu;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lavx;-><init>(Lqk;)V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/wearable/internal/z;)V
    .locals 3

    new-instance v0, Lawk;

    iget v1, p1, Lcom/google/android/gms/wearable/internal/z;->b:I

    invoke-static {v1}, Lavt;->a(I)Lcom/google/android/gms/common/api/Status;

    move-result-object v1

    iget-object v2, p1, Lcom/google/android/gms/wearable/internal/z;->c:Landroid/os/ParcelFileDescriptor;

    invoke-direct {v0, v1, v2}, Lawk;-><init>(Lcom/google/android/gms/common/api/Status;Landroid/os/ParcelFileDescriptor;)V

    invoke-virtual {p0, v0}, Lavz;->a(Ljava/lang/Object;)V

    return-void
.end method
