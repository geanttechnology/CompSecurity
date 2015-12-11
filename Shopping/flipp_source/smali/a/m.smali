.class public final La/m;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements La/g;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "La/g",
        "<TTResult;",
        "La/h",
        "<TTContinuationResult;>;>;"
    }
.end annotation


# instance fields
.field final synthetic a:La/g;

.field final synthetic b:La/h;


# direct methods
.method public constructor <init>(La/h;La/g;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, La/m;->b:La/h;

    iput-object p2, p0, La/m;->a:La/g;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final synthetic then(La/h;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 369
    invoke-virtual {p1}, La/h;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, La/h;->e()Ljava/lang/Exception;

    move-result-object v0

    invoke-static {v0}, La/h;->a(Ljava/lang/Exception;)La/h;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, La/h;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, La/h;->f()La/h;

    move-result-object v0

    goto :goto_0

    :cond_1
    iget-object v0, p0, La/m;->a:La/g;

    invoke-virtual {p1, v0}, La/h;->a(La/g;)La/h;

    move-result-object v0

    goto :goto_0
.end method
