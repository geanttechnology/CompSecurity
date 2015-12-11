.class public abstract Lcom/wishabi/flipp/app/dl;
.super Landroid/app/Fragment;
.source "SourceFile"


# instance fields
.field b:Lcom/wishabi/flipp/app/dm;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected final a(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    if-eqz v0, :cond_0

    .line 23
    iget-object v0, p0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    invoke-interface {v0, p1, p2}, Lcom/wishabi/flipp/app/dm;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 24
    :cond_0
    return-void
.end method

.method protected final a()Z
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    if-nez v0, :cond_0

    .line 28
    const/4 v0, 0x0

    .line 30
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    invoke-interface {v0}, Lcom/wishabi/flipp/app/dm;->a()Z

    move-result v0

    goto :goto_0
.end method

.method protected final b(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    if-eqz v0, :cond_0

    .line 18
    iget-object v0, p0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    invoke-interface {v0, p1}, Lcom/wishabi/flipp/app/dm;->a(Ljava/lang/String;)V

    .line 19
    :cond_0
    return-void
.end method
