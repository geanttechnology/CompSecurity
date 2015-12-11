.class Lahi$4;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lahi;->a(Ljava/lang/String;ZILandroid/content/Intent;Lxy;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/content/Intent;

.field final synthetic b:Lahi;


# direct methods
.method constructor <init>(Lahi;Landroid/content/Intent;)V
    .locals 0

    iput-object p1, p0, Lahi$4;->b:Lahi;

    iput-object p2, p0, Lahi$4;->a:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lahi$4;->a:Landroid/content/Intent;

    invoke-static {v0}, Lyc;->a(Landroid/content/Intent;)I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi$4;->b:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi$4;->b:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi$4;->b:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->d()Lxc;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi$4;->b:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->d()Lxc;

    move-result-object v0

    invoke-virtual {v0}, Lxc;->a()V

    :cond_0
    iget-object v0, p0, Lahi$4;->b:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    const/4 v1, 0x0

    iput-boolean v1, v0, Lahk;->x:Z

    return-void
.end method
