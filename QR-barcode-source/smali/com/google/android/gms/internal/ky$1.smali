.class Lcom/google/android/gms/internal/ky$1;
.super Lcom/google/android/gms/internal/kk$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/ky;->createCustomDataType(Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/fitness/request/DataTypeCreateRequest;)Lcom/google/android/gms/common/api/PendingResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/kk$a",
        "<",
        "Lcom/google/android/gms/fitness/result/DataTypeResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic TE:Lcom/google/android/gms/fitness/request/DataTypeCreateRequest;

.field final synthetic TF:Lcom/google/android/gms/internal/ky;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/ky;Lcom/google/android/gms/fitness/request/DataTypeCreateRequest;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/ky$1;->TF:Lcom/google/android/gms/internal/ky;

    iput-object p2, p0, Lcom/google/android/gms/internal/ky$1;->TE:Lcom/google/android/gms/fitness/request/DataTypeCreateRequest;

    invoke-direct {p0}, Lcom/google/android/gms/internal/kk$a;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic a(Lcom/google/android/gms/common/api/Api$a;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    check-cast p1, Lcom/google/android/gms/internal/kk;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/ky$1;->a(Lcom/google/android/gms/internal/kk;)V

    return-void
.end method

.method protected a(Lcom/google/android/gms/internal/kk;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/ky$a;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/ky$a;-><init>(Lcom/google/android/gms/common/api/BaseImplementation$b;Lcom/google/android/gms/internal/ky$1;)V

    invoke-interface {p1}, Lcom/google/android/gms/internal/kk;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1}, Lcom/google/android/gms/internal/kk;->jb()Lcom/google/android/gms/internal/kp;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/ky$1;->TE:Lcom/google/android/gms/fitness/request/DataTypeCreateRequest;

    invoke-interface {v2, v3, v0, v1}, Lcom/google/android/gms/internal/kp;->a(Lcom/google/android/gms/fitness/request/DataTypeCreateRequest;Lcom/google/android/gms/internal/ko;Ljava/lang/String;)V

    return-void
.end method

.method protected synthetic c(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Result;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/ky$1;->x(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/fitness/result/DataTypeResult;

    move-result-object v0

    return-object v0
.end method

.method protected x(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/fitness/result/DataTypeResult;
    .locals 1

    invoke-static {p1}, Lcom/google/android/gms/fitness/result/DataTypeResult;->F(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/fitness/result/DataTypeResult;

    move-result-object v0

    return-object v0
.end method
