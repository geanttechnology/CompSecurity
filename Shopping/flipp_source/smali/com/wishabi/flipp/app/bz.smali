.class final Lcom/wishabi/flipp/app/bz;
.super Lcom/wishabi/flipp/b/aa;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/by;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/by;ILjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/wishabi/flipp/app/bz;->a:Lcom/wishabi/flipp/app/by;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/wishabi/flipp/b/aa;-><init>(ILjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V

    return-void
.end method


# virtual methods
.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 6

    .prologue
    .line 191
    check-cast p1, Lcom/wishabi/flipp/content/FlyerInfo;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bz;->a:Lcom/wishabi/flipp/app/by;

    iget-object v0, v0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bx;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    if-nez p1, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/bz;->a:Lcom/wishabi/flipp/app/by;

    iget-object v0, v0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bz;->a:Lcom/wishabi/flipp/app/by;

    iget-object v1, v1, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    const v2, 0x7f0e00ce

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/wishabi/flipp/util/q;->a()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Lcom/wishabi/flipp/app/bx;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/bx;->a(Lcom/wishabi/flipp/app/bx;Ljava/lang/String;)V

    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/bz;->a:Lcom/wishabi/flipp/app/by;

    iget-object v0, v0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bx;->c(Lcom/wishabi/flipp/app/bx;)Lcom/wishabi/flipp/b/ab;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bz;->a:Lcom/wishabi/flipp/app/by;

    iget-object v0, v0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bx;->d(Lcom/wishabi/flipp/app/bx;)Lcom/wishabi/flipp/b/aa;

    :cond_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bz;->a:Lcom/wishabi/flipp/app/by;

    iget-object v0, v0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/bx;->a(Lcom/wishabi/flipp/app/bx;Lcom/wishabi/flipp/content/FlyerInfo;)V

    goto :goto_0
.end method
