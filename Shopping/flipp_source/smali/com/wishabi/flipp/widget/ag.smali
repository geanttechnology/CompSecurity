.class final Lcom/wishabi/flipp/widget/ag;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/af;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/af;)V
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ag;->a:Lcom/wishabi/flipp/widget/af;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 253
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ag;->a:Lcom/wishabi/flipp/widget/af;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/af;->a(Lcom/wishabi/flipp/widget/af;)Lcom/wishabi/flipp/widget/ak;

    move-result-object v0

    if-nez v0, :cond_0

    .line 257
    :goto_0
    return-void

    .line 256
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ag;->a:Lcom/wishabi/flipp/widget/af;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/af;->a(Lcom/wishabi/flipp/widget/af;)Lcom/wishabi/flipp/widget/ak;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ag;->a:Lcom/wishabi/flipp/widget/af;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/ak;->a(Lcom/wishabi/flipp/widget/af;)V

    goto :goto_0
.end method
