.class Labn$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Labn;
.end annotation


# instance fields
.field final synthetic a:Labn;


# direct methods
.method constructor <init>(Labn;)V
    .locals 0

    iput-object p1, p0, Labn$1;->a:Labn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Labn$1;->a:Labn;

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-static {v0, v1}, Labn;->a(Labn;Ljava/lang/Thread;)Ljava/lang/Thread;

    iget-object v0, p0, Labn$1;->a:Labn;

    invoke-virtual {v0}, Labn;->a()V

    return-void
.end method
