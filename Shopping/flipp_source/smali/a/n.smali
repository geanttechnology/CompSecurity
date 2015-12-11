.class final La/n;
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
    .line 440
    iput-object p1, p0, La/n;->a:La/g;

    iput-object p2, p0, La/n;->b:La/h;

    iput-object p3, p0, La/n;->c:La/o;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 444
    :try_start_0
    iget-object v0, p0, La/n;->a:La/g;

    iget-object v1, p0, La/n;->b:La/h;

    invoke-interface {v0, v1}, La/g;->then(La/h;)Ljava/lang/Object;

    move-result-object v0

    .line 445
    iget-object v1, p0, La/n;->c:La/o;

    invoke-virtual {v1, v0}, La/o;->a(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 449
    :goto_0
    return-void

    .line 446
    :catch_0
    move-exception v0

    .line 447
    iget-object v1, p0, La/n;->c:La/o;

    invoke-virtual {v1, v0}, La/o;->a(Ljava/lang/Exception;)V

    goto :goto_0
.end method
