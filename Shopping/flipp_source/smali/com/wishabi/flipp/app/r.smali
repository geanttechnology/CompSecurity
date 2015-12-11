.class final Lcom/wishabi/flipp/app/r;
.super Lcom/wishabi/flipp/b/z;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/n;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/n;[ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 436
    iput-object p1, p0, Lcom/wishabi/flipp/app/r;->a:Lcom/wishabi/flipp/app/n;

    invoke-direct {p0, p2, p3}, Lcom/wishabi/flipp/b/z;-><init>([ILjava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 436
    check-cast p1, Ljava/util/HashMap;

    iget-object v0, p0, Lcom/wishabi/flipp/app/r;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;Ljava/util/HashMap;)Ljava/util/HashMap;

    iget-object v0, p0, Lcom/wishabi/flipp/app/r;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->c(Lcom/wishabi/flipp/app/n;)Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/r;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->d(Lcom/wishabi/flipp/app/n;)V

    :cond_0
    return-void
.end method
