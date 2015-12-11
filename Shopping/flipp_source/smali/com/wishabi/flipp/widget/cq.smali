.class final Lcom/wishabi/flipp/widget/cq;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/cn;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/cn;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/wishabi/flipp/widget/cq;->a:Lcom/wishabi/flipp/widget/cn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cq;->a:Lcom/wishabi/flipp/widget/cn;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/cn;->n:Lcom/wishabi/flipp/widget/cw;

    if-eqz v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cq;->a:Lcom/wishabi/flipp/widget/cn;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/cn;->n:Lcom/wishabi/flipp/widget/cw;

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/cw;->b()V

    .line 93
    :cond_0
    return-void
.end method
