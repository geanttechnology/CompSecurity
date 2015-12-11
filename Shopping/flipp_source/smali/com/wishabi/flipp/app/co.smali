.class final Lcom/wishabi/flipp/app/co;
.super Lcom/wishabi/flipp/b/x;
.source "SourceFile"


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/wishabi/flipp/app/cn;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cn;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 196
    iput-object p1, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    iput-object p2, p0, Lcom/wishabi/flipp/app/co;->a:Ljava/lang/String;

    invoke-direct {p0}, Lcom/wishabi/flipp/b/x;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 199
    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->a(Lcom/wishabi/flipp/app/cn;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 203
    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->b(Lcom/wishabi/flipp/app/cn;)Lcom/wishabi/flipp/app/cv;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cn;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 204
    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->b(Lcom/wishabi/flipp/app/cn;)Lcom/wishabi/flipp/app/cv;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/app/cv;->a(Ljava/lang/String;)V

    .line 205
    :cond_0
    return-void
.end method

.method public final a(Z)V
    .locals 4

    .prologue
    .line 209
    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->a(Lcom/wishabi/flipp/app/cn;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 213
    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->b(Lcom/wishabi/flipp/app/cn;)Lcom/wishabi/flipp/app/cv;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 214
    if-eqz p1, :cond_1

    .line 215
    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->b(Lcom/wishabi/flipp/app/cn;)Lcom/wishabi/flipp/app/cv;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/co;->a:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/app/cv;->a(Ljava/lang/String;)V

    .line 221
    :cond_0
    :goto_0
    new-instance v0, Lcom/wishabi/flipp/b/an;

    invoke-direct {v0}, Lcom/wishabi/flipp/b/an;-><init>()V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/an;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 223
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-wide/16 v2, 0x0

    iput-wide v2, v0, Lcom/wishabi/flipp/b/a;->s:J

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/a;->c()V

    .line 224
    return-void

    .line 216
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cn;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 217
    iget-object v0, p0, Lcom/wishabi/flipp/app/co;->b:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->b(Lcom/wishabi/flipp/app/cn;)Lcom/wishabi/flipp/app/cv;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/app/cv;->a(Ljava/lang/String;)V

    goto :goto_0
.end method
