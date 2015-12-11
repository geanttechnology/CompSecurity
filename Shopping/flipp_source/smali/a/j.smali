.class final La/j;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements La/g;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "La/g",
        "<TTContinuationResult;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:La/i;


# direct methods
.method constructor <init>(La/i;)V
    .locals 0

    .prologue
    .line 481
    iput-object p1, p0, La/j;->a:La/i;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final synthetic then(La/h;)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 481
    invoke-virtual {p1}, La/h;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, La/j;->a:La/i;

    iget-object v0, v0, La/i;->c:La/o;

    invoke-virtual {v0}, La/o;->a()V

    :goto_0
    const/4 v0, 0x0

    return-object v0

    :cond_0
    invoke-virtual {p1}, La/h;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, La/j;->a:La/i;

    iget-object v0, v0, La/i;->c:La/o;

    invoke-virtual {p1}, La/h;->e()Ljava/lang/Exception;

    move-result-object v1

    invoke-virtual {v0, v1}, La/o;->a(Ljava/lang/Exception;)V

    goto :goto_0

    :cond_1
    iget-object v0, p0, La/j;->a:La/i;

    iget-object v0, v0, La/i;->c:La/o;

    invoke-virtual {p1}, La/h;->d()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, La/o;->a(Ljava/lang/Object;)V

    goto :goto_0
.end method
