.class public final Lcom/wishabi/flipp/widget/ct;
.super Landroid/support/v7/widget/bi;
.source "SourceFile"


# instance fields
.field final k:Lcom/wishabi/flipp/widget/CouponCell;

.field final l:Lcom/wishabi/flipp/widget/cv;


# direct methods
.method public constructor <init>(Landroid/view/View;Lcom/wishabi/flipp/widget/cv;)V
    .locals 2

    .prologue
    .line 131
    invoke-direct {p0, p1}, Landroid/support/v7/widget/bi;-><init>(Landroid/view/View;)V

    .line 132
    check-cast p1, Lcom/wishabi/flipp/widget/CouponCell;

    iput-object p1, p0, Lcom/wishabi/flipp/widget/ct;->k:Lcom/wishabi/flipp/widget/CouponCell;

    .line 133
    iput-object p2, p0, Lcom/wishabi/flipp/widget/ct;->l:Lcom/wishabi/flipp/widget/cv;

    .line 135
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ct;->k:Lcom/wishabi/flipp/widget/CouponCell;

    new-instance v1, Lcom/wishabi/flipp/widget/cu;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/cu;-><init>(Lcom/wishabi/flipp/widget/ct;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CouponCell;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    return-void
.end method
