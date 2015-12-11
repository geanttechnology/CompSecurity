.class Laac$3;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laac;->b(J)V
.end annotation


# instance fields
.field final synthetic a:Laac;


# direct methods
.method constructor <init>(Laac;)V
    .locals 0

    iput-object p1, p0, Laac$3;->a:Laac;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    iget-object v0, p0, Laac$3;->a:Laac;

    invoke-static {v0}, Laac;->a(Laac;)Ljava/lang/Object;

    move-result-object v6

    monitor-enter v6

    :try_start_0
    iget-object v0, p0, Laac$3;->a:Laac;

    invoke-static {v0}, Laac;->c(Laac;)Lcom/google/android/gms/internal/fj;

    move-result-object v0

    iget v0, v0, Lcom/google/android/gms/internal/fj;->e:I

    const/4 v1, -0x2

    if-eq v0, v1, :cond_0

    monitor-exit v6

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Laac$3;->a:Laac;

    invoke-static {v0}, Laac;->d(Laac;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    iget-object v1, p0, Laac$3;->a:Laac;

    invoke-virtual {v0, v1}, Lace;->a(Lacf;)V

    iget-object v0, p0, Laac$3;->a:Laac;

    invoke-static {v0}, Laac;->c(Laac;)Lcom/google/android/gms/internal/fj;

    move-result-object v0

    iget v0, v0, Lcom/google/android/gms/internal/fj;->e:I

    const/4 v1, -0x3

    if-ne v0, v1, :cond_1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Loading URL in WebView: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Laac$3;->a:Laac;

    invoke-static {v1}, Laac;->c(Laac;)Lcom/google/android/gms/internal/fj;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/fj;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->d(Ljava/lang/String;)V

    iget-object v0, p0, Laac$3;->a:Laac;

    invoke-static {v0}, Laac;->d(Laac;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    iget-object v1, p0, Laac$3;->a:Laac;

    invoke-static {v1}, Laac;->c(Laac;)Lcom/google/android/gms/internal/fj;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/fj;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/gu;->loadUrl(Ljava/lang/String;)V

    :goto_1
    monitor-exit v6

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    const-string v0, "Loading HTML in WebView."

    invoke-static {v0}, Lacb;->d(Ljava/lang/String;)V

    iget-object v0, p0, Laac$3;->a:Laac;

    invoke-static {v0}, Laac;->d(Laac;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    iget-object v1, p0, Laac$3;->a:Laac;

    invoke-static {v1}, Laac;->c(Laac;)Lcom/google/android/gms/internal/fj;

    move-result-object v1

    iget-object v1, v1, Lcom/google/android/gms/internal/fj;->b:Ljava/lang/String;

    invoke-static {v1}, Labq;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Laac$3;->a:Laac;

    invoke-static {v2}, Laac;->c(Laac;)Lcom/google/android/gms/internal/fj;

    move-result-object v2

    iget-object v2, v2, Lcom/google/android/gms/internal/fj;->c:Ljava/lang/String;

    const-string v3, "text/html"

    const-string v4, "UTF-8"

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/internal/gu;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method
