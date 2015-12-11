.class final Lcom/wishabi/flipp/widget/ad;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ab;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ab;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ad;->a:Lcom/wishabi/flipp/widget/ab;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 92
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ad;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    if-nez v0, :cond_0

    .line 98
    :goto_0
    return-void

    .line 95
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ad;->a:Lcom/wishabi/flipp/widget/ab;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ab;->c()I

    move-result v1

    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ad;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    iget-object v0, v2, Lcom/wishabi/flipp/widget/af;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    const/4 v0, 0x0

    :goto_1
    if-ge v0, v3, :cond_2

    iget-object v4, v2, Lcom/wishabi/flipp/widget/af;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    if-ne p1, v4, :cond_1

    .line 97
    :goto_2
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ad;->a:Lcom/wishabi/flipp/widget/ab;

    iget-object v2, v2, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    invoke-interface {v2, v1, v0}, Lcom/wishabi/flipp/widget/ae;->a(II)V

    goto :goto_0

    .line 96
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    const/4 v0, -0x1

    goto :goto_2
.end method
