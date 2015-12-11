.class final Lcom/wishabi/flipp/b/w;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/x;

.field final synthetic b:Lcom/wishabi/flipp/b/u;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/u;Lcom/wishabi/flipp/b/x;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/wishabi/flipp/b/w;->b:Lcom/wishabi/flipp/b/u;

    iput-object p2, p0, Lcom/wishabi/flipp/b/w;->a:Lcom/wishabi/flipp/b/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/wishabi/flipp/b/w;->a:Lcom/wishabi/flipp/b/x;

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/x;->a()V

    .line 104
    return-void
.end method
