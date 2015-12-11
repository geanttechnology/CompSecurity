.class public final Lcom/a/b/ax;
.super Lcom/a/b/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/a/b/a",
        "<",
        "Lcom/a/b/aw;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/a/b/ad;Lcom/a/b/aw;Lcom/a/b/ao;ZLjava/lang/String;)V
    .locals 9

    .prologue
    const/4 v5, 0x0

    .line 23
    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move v6, v5

    move-object v8, p5

    invoke-direct/range {v0 .. v8}, Lcom/a/b/a;-><init>(Lcom/a/b/ad;Ljava/lang/Object;Lcom/a/b/ao;ZZILandroid/graphics/drawable/Drawable;Ljava/lang/String;)V

    .line 24
    return-void
.end method


# virtual methods
.method final a()V
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/a/b/a;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/b/aw;

    .line 42
    if-eqz v0, :cond_0

    .line 43
    invoke-interface {v0}, Lcom/a/b/aw;->b()V

    .line 45
    :cond_0
    return-void
.end method

.method final a(Landroid/graphics/Bitmap;Lcom/a/b/aj;)V
    .locals 4

    .prologue
    .line 27
    if-nez p1, :cond_0

    .line 28
    new-instance v0, Ljava/lang/AssertionError;

    const-string v1, "Attempted to complete action with no result!\n%s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0

    .line 31
    :cond_0
    iget-object v0, p0, Lcom/a/b/a;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/b/aw;

    .line 32
    if-eqz v0, :cond_1

    .line 33
    invoke-interface {v0}, Lcom/a/b/aw;->a()V

    .line 34
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 35
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Target callback must not recycle bitmap!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 38
    :cond_1
    return-void
.end method
