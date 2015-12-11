.class Lsk$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsk;-><init>(Lahi;Lsl;)V
.end annotation


# instance fields
.field final synthetic a:Lahi;

.field final synthetic b:Lsk;

.field private final c:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lahi;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lsk;Lahi;)V
    .locals 2

    iput-object p1, p0, Lsk$1;->b:Lsk;

    iput-object p2, p0, Lsk$1;->a:Lahi;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/ref/WeakReference;

    iget-object v1, p0, Lsk$1;->a:Lahi;

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lsk$1;->c:Ljava/lang/ref/WeakReference;

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lsk$1;->b:Lsk;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lsk;->a(Lsk;Z)Z

    iget-object v0, p0, Lsk$1;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lahi;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lsk$1;->b:Lsk;

    invoke-static {v1}, Lsk;->a(Lsk;)Lcom/google/android/gms/internal/av;

    move-result-object v1

    invoke-virtual {v0, v1}, Lahi;->b(Lcom/google/android/gms/internal/av;)V

    :cond_0
    return-void
.end method
