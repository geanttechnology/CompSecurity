.class final Lcom/a/a/a/b/w;
.super Lcom/a/a/a/l;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/a/a/a/b/x;

.field final synthetic b:Lcom/a/a/a/b/v;


# direct methods
.method varargs constructor <init>(Lcom/a/a/a/b/v;Ljava/lang/String;[Ljava/lang/Object;Lcom/a/a/a/b/x;)V
    .locals 0

    .prologue
    .line 470
    iput-object p1, p0, Lcom/a/a/a/b/w;->b:Lcom/a/a/a/b/v;

    iput-object p4, p0, Lcom/a/a/a/b/w;->a:Lcom/a/a/a/b/x;

    invoke-direct {p0, p2, p3}, Lcom/a/a/a/l;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 473
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/b/w;->b:Lcom/a/a/a/b/v;

    iget-object v0, v0, Lcom/a/a/a/b/v;->a:Lcom/a/a/a/b/q;

    invoke-static {v0}, Lcom/a/a/a/b/q;->e(Lcom/a/a/a/b/q;)Lcom/a/a/a/b/h;

    move-result-object v0

    iget-object v1, p0, Lcom/a/a/a/b/w;->a:Lcom/a/a/a/b/x;

    invoke-interface {v0, v1}, Lcom/a/a/a/b/h;->a(Lcom/a/a/a/b/x;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 476
    return-void

    .line 474
    :catch_0
    move-exception v0

    .line 475
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
