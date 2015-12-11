.class final Lcom/wishabi/flipp/b/k;
.super Ljava/util/TimerTask;
.source "SourceFile"


# instance fields
.field final synthetic a:Ljava/util/HashMap;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Ljava/lang/String;

.field final synthetic e:Ljava/lang/String;

.field final synthetic f:Lcom/wishabi/flipp/b/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/a;Ljava/util/HashMap;Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 495
    iput-object p1, p0, Lcom/wishabi/flipp/b/k;->f:Lcom/wishabi/flipp/b/a;

    iput-object p2, p0, Lcom/wishabi/flipp/b/k;->a:Ljava/util/HashMap;

    iput-object v0, p0, Lcom/wishabi/flipp/b/k;->b:Ljava/lang/String;

    iput-object v0, p0, Lcom/wishabi/flipp/b/k;->c:Ljava/lang/String;

    iput-object v0, p0, Lcom/wishabi/flipp/b/k;->d:Ljava/lang/String;

    iput-object p3, p0, Lcom/wishabi/flipp/b/k;->e:Ljava/lang/String;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .prologue
    .line 498
    iget-object v0, p0, Lcom/wishabi/flipp/b/k;->f:Lcom/wishabi/flipp/b/a;

    const-string v1, "listing"

    iget-object v2, p0, Lcom/wishabi/flipp/b/k;->a:Ljava/util/HashMap;

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Ljava/lang/String;Ljava/util/Map;)V

    .line 500
    iget-object v0, p0, Lcom/wishabi/flipp/b/k;->b:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/b/k;->c:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/b/k;->d:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 501
    iget-object v0, p0, Lcom/wishabi/flipp/b/k;->f:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/b/k;->b:Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/b/k;->c:Ljava/lang/String;

    iget-object v3, p0, Lcom/wishabi/flipp/b/k;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 503
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/k;->f:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/b/k;->e:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->c(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)Ljava/lang/String;

    .line 504
    return-void
.end method
