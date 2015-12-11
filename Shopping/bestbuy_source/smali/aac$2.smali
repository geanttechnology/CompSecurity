.class Laac$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laac;->a()V
.end annotation


# instance fields
.field final synthetic a:Labd;

.field final synthetic b:Laac;


# direct methods
.method constructor <init>(Laac;Labd;)V
    .locals 0

    iput-object p1, p0, Laac$2;->b:Laac;

    iput-object p2, p0, Laac$2;->a:Labd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Laac$2;->b:Laac;

    invoke-static {v0}, Laac;->a(Laac;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Laac$2;->b:Laac;

    invoke-static {v0}, Laac;->b(Laac;)Laab;

    move-result-object v0

    iget-object v2, p0, Laac$2;->a:Labd;

    invoke-interface {v0, v2}, Laab;->a(Labd;)V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
