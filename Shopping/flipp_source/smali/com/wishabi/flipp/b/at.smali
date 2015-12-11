.class final Lcom/wishabi/flipp/b/at;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/as;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/as;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/wishabi/flipp/b/at;->a:Lcom/wishabi/flipp/b/as;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 44
    iget-object v0, p0, Lcom/wishabi/flipp/b/at;->a:Lcom/wishabi/flipp/b/as;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/as;->cancel(Z)Z

    .line 45
    iget-object v0, p0, Lcom/wishabi/flipp/b/at;->a:Lcom/wishabi/flipp/b/as;

    invoke-static {v0}, Lcom/wishabi/flipp/b/as;->a(Lcom/wishabi/flipp/b/as;)Z

    .line 46
    return-void
.end method
