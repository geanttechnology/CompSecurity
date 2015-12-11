.class final Lcom/google/android/gms/internal/fa;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/cd;

.field final synthetic b:Lcom/google/android/gms/internal/ez;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/ez;Lcom/google/android/gms/internal/cd;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/fa;->b:Lcom/google/android/gms/internal/ez;

    iput-object p2, p0, Lcom/google/android/gms/internal/fa;->a:Lcom/google/android/gms/internal/cd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/fa;->a:Lcom/google/android/gms/internal/cd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/cd;->h()V

    return-void
.end method
