.class final Lcom/google/android/gms/internal/iv;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/ix;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/ix",
        "<",
        "Lcom/google/android/gms/internal/io;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/iu;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/iu;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/iv;->a:Lcom/google/android/gms/internal/iu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/iu;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/iv;-><init>(Lcom/google/android/gms/internal/iu;)V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/iv;->a:Lcom/google/android/gms/internal/iu;

    invoke-static {v0}, Lcom/google/android/gms/internal/iu;->a(Lcom/google/android/gms/internal/iu;)V

    return-void
.end method

.method public final synthetic b()Landroid/os/IInterface;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/iv;->a:Lcom/google/android/gms/internal/iu;

    invoke-static {v0}, Lcom/google/android/gms/internal/iu;->b(Lcom/google/android/gms/internal/iu;)Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/io;

    return-object v0
.end method
