.class final Lcom/google/android/gms/internal/ds;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:Lcom/google/android/gms/internal/bz;

.field final synthetic c:Lcom/google/android/gms/internal/dw;

.field final synthetic d:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/dw;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/ds;->a:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/ds;->b:Lcom/google/android/gms/internal/bz;

    iput-object p3, p0, Lcom/google/android/gms/internal/ds;->c:Lcom/google/android/gms/internal/dw;

    iput-object p4, p0, Lcom/google/android/gms/internal/ds;->d:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 11

    const/4 v4, 0x0

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/ds;->a:Landroid/content/Context;

    new-instance v1, Lcom/google/android/gms/internal/x;

    invoke-direct {v1}, Lcom/google/android/gms/internal/x;-><init>()V

    iget-object v3, p0, Lcom/google/android/gms/internal/ds;->b:Lcom/google/android/gms/internal/bz;

    iget-object v5, v3, Lcom/google/android/gms/internal/bz;->k:Lcom/google/android/gms/internal/cu;

    move v3, v2

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/ew;->a(Landroid/content/Context;Lcom/google/android/gms/internal/x;ZZLcom/google/android/gms/internal/jg;Lcom/google/android/gms/internal/cu;)Lcom/google/android/gms/internal/ew;

    move-result-object v5

    const/4 v0, 0x1

    invoke-virtual {v5, v0}, Lcom/google/android/gms/internal/ew;->setWillNotDraw(Z)V

    iget-object v0, p0, Lcom/google/android/gms/internal/ds;->c:Lcom/google/android/gms/internal/dw;

    iget-object v1, v0, Lcom/google/android/gms/internal/dw;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput-object v5, v0, Lcom/google/android/gms/internal/dw;->b:Lcom/google/android/gms/internal/ew;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, v5, Lcom/google/android/gms/internal/ew;->a:Lcom/google/android/gms/internal/ez;

    const-string v1, "/invalidRequest"

    iget-object v2, p0, Lcom/google/android/gms/internal/ds;->c:Lcom/google/android/gms/internal/dw;

    iget-object v2, v2, Lcom/google/android/gms/internal/dw;->f:Lcom/google/android/gms/internal/af;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/ez;->a(Ljava/lang/String;Lcom/google/android/gms/internal/af;)V

    const-string v1, "/loadAdURL"

    iget-object v2, p0, Lcom/google/android/gms/internal/ds;->c:Lcom/google/android/gms/internal/dw;

    iget-object v2, v2, Lcom/google/android/gms/internal/dw;->g:Lcom/google/android/gms/internal/af;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/ez;->a(Ljava/lang/String;Lcom/google/android/gms/internal/af;)V

    const-string v1, "/log"

    sget-object v2, Lcom/google/android/gms/internal/w;->f:Lcom/google/android/gms/internal/af;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/ez;->a(Ljava/lang/String;Lcom/google/android/gms/internal/af;)V

    const-string v0, "Getting the ad request URL."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    const-string v6, "http://googleads.g.doubleclick.net"

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL("

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/ds;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ");</script></head><body></body></html>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const-string v8, "text/html"

    const-string v9, "UTF-8"

    move-object v10, v4

    invoke-virtual/range {v5 .. v10}, Lcom/google/android/gms/internal/ew;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
