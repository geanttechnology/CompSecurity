.class public final Lcom/wishabi/flipp/widget/ab;
.super Landroid/support/v7/widget/bi;
.source "SourceFile"


# instance fields
.field public final k:Lcom/wishabi/flipp/widget/af;

.field final l:Lcom/wishabi/flipp/widget/ae;

.field final m:Lcom/wishabi/flipp/widget/ak;

.field final n:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Lcom/wishabi/flipp/widget/af;Lcom/wishabi/flipp/widget/ae;)V
    .locals 1

    .prologue
    .line 102
    invoke-direct {p0, p1}, Landroid/support/v7/widget/bi;-><init>(Landroid/view/View;)V

    .line 44
    new-instance v0, Lcom/wishabi/flipp/widget/ac;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/widget/ac;-><init>(Lcom/wishabi/flipp/widget/ab;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ab;->m:Lcom/wishabi/flipp/widget/ak;

    .line 88
    new-instance v0, Lcom/wishabi/flipp/widget/ad;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/widget/ad;-><init>(Lcom/wishabi/flipp/widget/ab;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ab;->n:Landroid/view/View$OnClickListener;

    .line 103
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ab;->k:Lcom/wishabi/flipp/widget/af;

    .line 104
    iput-object p2, p0, Lcom/wishabi/flipp/widget/ab;->l:Lcom/wishabi/flipp/widget/ae;

    .line 105
    return-void
.end method
