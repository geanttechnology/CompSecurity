.class final Lcom/wishabi/flipp/widget/ac;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/ak;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ab;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ab;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 56
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    if-nez v0, :cond_0

    .line 60
    :goto_0
    return-void

    .line 59
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/ab;->c()I

    move-result v1

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/ae;->a(I)V

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/widget/af;)V
    .locals 3

    .prologue
    .line 48
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    if-nez v0, :cond_0

    .line 52
    :goto_0
    return-void

    .line 51
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v1, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ab;->c()I

    move-result v2

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/af;->getIsClipped()Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_1
    invoke-interface {v1, v2, v0}, Lcom/wishabi/flipp/widget/ae;->a(IZ)V

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 64
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    if-nez v0, :cond_0

    .line 68
    :goto_0
    return-void

    .line 67
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/ab;->c()I

    move-result v1

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/ae;->b(I)V

    goto :goto_0
.end method

.method public final c()V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    if-nez v0, :cond_0

    .line 76
    :goto_0
    return-void

    .line 75
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/ae;->a()V

    goto :goto_0
.end method

.method public final d()V
    .locals 2

    .prologue
    .line 80
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    if-nez v0, :cond_0

    .line 84
    :goto_0
    return-void

    .line 83
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ac;->a:Lcom/wishabi/flipp/widget/ab;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/ab;->c()I

    move-result v1

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/ae;->c(I)V

    goto :goto_0
.end method
