.class final Lcom/wishabi/flipp/widget/cp;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/cn;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/cn;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/wishabi/flipp/widget/cp;->a:Lcom/wishabi/flipp/widget/cn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onFocusChange(Landroid/view/View;Z)V
    .locals 2

    .prologue
    .line 79
    if-eqz p2, :cond_0

    .line 80
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cp;->a:Lcom/wishabi/flipp/widget/cn;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/cn;->k:Landroid/widget/TextView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setActivated(Z)V

    .line 85
    :goto_0
    return-void

    .line 82
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cp;->a:Lcom/wishabi/flipp/widget/cn;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/cn;->k:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setActivated(Z)V

    .line 83
    invoke-static {p1}, Lcom/wishabi/flipp/util/g;->a(Landroid/view/View;)V

    goto :goto_0
.end method
