.class public final Lcom/google/android/gms/internal/ir;
.super Ljava/lang/Object;


# instance fields
.field public final a:Lcom/google/android/gms/internal/ix;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/ix",
            "<",
            "Lcom/google/android/gms/internal/io;",
            ">;"
        }
    .end annotation
.end field

.field public final b:Landroid/content/Context;

.field c:Z

.field public d:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/google/android/gms/location/g;",
            "Lcom/google/android/gms/internal/it;",
            ">;"
        }
    .end annotation
.end field

.field private e:Landroid/content/ContentProviderClient;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/ix;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/google/android/gms/internal/ix",
            "<",
            "Lcom/google/android/gms/internal/io;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/ir;->e:Landroid/content/ContentProviderClient;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/ir;->c:Z

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/ir;->d:Ljava/util/HashMap;

    iput-object p1, p0, Lcom/google/android/gms/internal/ir;->b:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/ir;->a:Lcom/google/android/gms/internal/ix;

    return-void
.end method


# virtual methods
.method public final a()Landroid/location/Location;
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/ir;->a:Lcom/google/android/gms/internal/ix;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ix;->a()V

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/ir;->a:Lcom/google/android/gms/internal/ix;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ix;->b()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/io;

    iget-object v1, p0, Lcom/google/android/gms/internal/ir;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/io;->a(Ljava/lang/String;)Landroid/location/Location;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
