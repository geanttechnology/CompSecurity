.class final Lcom/google/android/gms/internal/hu;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/ro;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/ho;

.field final synthetic b:Lcom/google/android/gms/internal/hs;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/hs;Lcom/google/android/gms/internal/ho;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/hu;->b:Lcom/google/android/gms/internal/hs;

    iput-object p2, p0, Lcom/google/android/gms/internal/hu;->a:Lcom/google/android/gms/internal/ho;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 1

    const-string v0, "Rejecting reference for JS Engine."

    invoke-static {v0}, Lcom/google/android/gms/ads/internal/util/client/zzb;->v(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/hu;->a:Lcom/google/android/gms/internal/ho;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ho;->d()V

    return-void
.end method
