.class final Lcom/wishabi/flipp/b/j;
.super Ljava/util/TimerTask;
.source "SourceFile"


# instance fields
.field final synthetic a:Ljava/util/HashMap;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/wishabi/flipp/b/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/a;Ljava/util/HashMap;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 472
    iput-object p1, p0, Lcom/wishabi/flipp/b/j;->c:Lcom/wishabi/flipp/b/a;

    iput-object p2, p0, Lcom/wishabi/flipp/b/j;->a:Ljava/util/HashMap;

    iput-object p3, p0, Lcom/wishabi/flipp/b/j;->b:Ljava/lang/String;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .prologue
    .line 475
    iget-object v0, p0, Lcom/wishabi/flipp/b/j;->c:Lcom/wishabi/flipp/b/a;

    const-string v1, "listing"

    iget-object v2, p0, Lcom/wishabi/flipp/b/j;->a:Ljava/util/HashMap;

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Ljava/lang/String;Ljava/util/Map;)V

    .line 476
    iget-object v0, p0, Lcom/wishabi/flipp/b/j;->c:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/b/j;->b:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->c(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)Ljava/lang/String;

    .line 477
    return-void
.end method
