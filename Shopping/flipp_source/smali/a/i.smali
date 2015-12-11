.class final La/i;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:La/g;

.field final synthetic b:La/h;

.field final synthetic c:La/o;


# direct methods
.method constructor <init>(La/g;La/h;La/o;)V
    .locals 0

    .prologue
    .line 473
    iput-object p1, p0, La/i;->a:La/g;

    iput-object p2, p0, La/i;->b:La/h;

    iput-object p3, p0, La/i;->c:La/o;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 477
    :try_start_0
    iget-object v0, p0, La/i;->a:La/g;

    iget-object v1, p0, La/i;->b:La/h;

    invoke-interface {v0, v1}, La/g;->then(La/h;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, La/h;

    .line 478
    if-nez v0, :cond_0

    .line 479
    iget-object v0, p0, La/i;->c:La/o;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, La/o;->a(Ljava/lang/Object;)V

    .line 498
    :goto_0
    return-void

    .line 481
    :cond_0
    new-instance v1, La/j;

    invoke-direct {v1, p0}, La/j;-><init>(La/i;)V

    invoke-virtual {v0, v1}, La/h;->a(La/g;)La/h;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 495
    :catch_0
    move-exception v0

    .line 496
    iget-object v1, p0, La/i;->c:La/o;

    invoke-virtual {v1, v0}, La/o;->a(Ljava/lang/Exception;)V

    goto :goto_0
.end method
