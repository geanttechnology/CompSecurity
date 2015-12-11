.class Lahi$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/ComponentCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lahi;
.end annotation


# instance fields
.field final synthetic a:Lahi;


# direct methods
.method constructor <init>(Lahi;)V
    .locals 0

    iput-object p1, p0, Lahi$1;->a:Lahi;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1

    iget-object v0, p0, Lahi$1;->a:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi$1;->a:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi$1;->a:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi$1;->a:Lahi;

    invoke-static {v0}, Lahi;->a(Lahi;)Lahk;

    move-result-object v0

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->a()V

    :cond_0
    return-void
.end method

.method public onLowMemory()V
    .locals 0

    return-void
.end method
