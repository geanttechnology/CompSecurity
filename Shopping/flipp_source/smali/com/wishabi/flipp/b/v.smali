.class final Lcom/wishabi/flipp/b/v;
.super Lcom/wishabi/flipp/b/y;
.source "SourceFile"


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/wishabi/flipp/b/x;

.field final synthetic c:Lcom/wishabi/flipp/b/u;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/u;Ljava/lang/String;ILcom/wishabi/flipp/b/x;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/wishabi/flipp/b/v;->c:Lcom/wishabi/flipp/b/u;

    iput p3, p0, Lcom/wishabi/flipp/b/v;->a:I

    iput-object p4, p0, Lcom/wishabi/flipp/b/v;->b:Lcom/wishabi/flipp/b/x;

    invoke-direct {p0, p2}, Lcom/wishabi/flipp/b/y;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final a(Ljava/lang/Boolean;)V
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->b:Lcom/wishabi/flipp/b/x;

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->b:Lcom/wishabi/flipp/b/x;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/x;->a(Z)V

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->c:Lcom/wishabi/flipp/b/u;

    invoke-static {v0}, Lcom/wishabi/flipp/b/u;->a(Lcom/wishabi/flipp/b/u;)Ljava/util/HashMap;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/b/v;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    return-void
.end method

.method protected final onCancelled()V
    .locals 2

    .prologue
    .line 75
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->b:Lcom/wishabi/flipp/b/x;

    if-eqz v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->b:Lcom/wishabi/flipp/b/x;

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/x;->a()V

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->c:Lcom/wishabi/flipp/b/u;

    invoke-static {v0}, Lcom/wishabi/flipp/b/u;->a(Lcom/wishabi/flipp/b/u;)Ljava/util/HashMap;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/b/v;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    return-void
.end method

.method protected final onPreExecute()V
    .locals 2

    .prologue
    .line 61
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->c:Lcom/wishabi/flipp/b/u;

    invoke-static {v0}, Lcom/wishabi/flipp/b/u;->a(Lcom/wishabi/flipp/b/u;)Ljava/util/HashMap;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/b/v;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->b:Lcom/wishabi/flipp/b/x;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lcom/wishabi/flipp/b/v;->b:Lcom/wishabi/flipp/b/x;

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/x;->b()V

    .line 64
    :cond_0
    return-void
.end method
