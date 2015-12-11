.class final Lcom/wishabi/flipp/widget/x;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/wishabi/flipp/widget/CouponCell;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/CouponCell;I)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/wishabi/flipp/widget/x;->b:Lcom/wishabi/flipp/widget/CouponCell;

    iput p2, p0, Lcom/wishabi/flipp/widget/x;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 193
    iget-object v0, p0, Lcom/wishabi/flipp/widget/x;->b:Lcom/wishabi/flipp/widget/CouponCell;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CouponCell;->a(Lcom/wishabi/flipp/widget/CouponCell;)Lcom/wishabi/flipp/app/dn;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 194
    iget-object v0, p0, Lcom/wishabi/flipp/widget/x;->b:Lcom/wishabi/flipp/widget/CouponCell;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CouponCell;->a(Lcom/wishabi/flipp/widget/CouponCell;)Lcom/wishabi/flipp/app/dn;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/widget/x;->a:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/dn;->b(I)V

    .line 195
    :cond_0
    return-void
.end method
