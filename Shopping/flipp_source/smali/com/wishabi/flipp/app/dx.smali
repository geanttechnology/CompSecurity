.class final Lcom/wishabi/flipp/app/dx;
.super Lcom/wishabi/flipp/b/ao;
.source "SourceFile"


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/wishabi/flipp/app/PrintCouponFragment;


# direct methods
.method varargs constructor <init>(Lcom/wishabi/flipp/app/PrintCouponFragment;Ljava/lang/String;[II)V
    .locals 0

    .prologue
    .line 360
    iput-object p1, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    iput p4, p0, Lcom/wishabi/flipp/app/dx;->a:I

    invoke-direct {p0, p2, p3}, Lcom/wishabi/flipp/b/ao;-><init>(Ljava/lang/String;[I)V

    return-void
.end method


# virtual methods
.method protected final onCancelled()V
    .locals 1

    .prologue
    .line 395
    iget-object v0, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->c(Lcom/wishabi/flipp/app/PrintCouponFragment;)V

    .line 396
    return-void
.end method

.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 360
    check-cast p1, Lcom/wishabi/flipp/b/ap;

    iget-object v0, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->c(Lcom/wishabi/flipp/app/PrintCouponFragment;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_1

    sget-object v1, Lcom/wishabi/flipp/b/ap;->a:Lcom/wishabi/flipp/b/ap;

    if-ne p1, v1, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/b/ao;->c:[I

    array-length v1, v1

    new-array v1, v1, [I

    iget-object v2, p0, Lcom/wishabi/flipp/b/ao;->c:[I

    iget-object v3, p0, Lcom/wishabi/flipp/b/ao;->c:[I

    array-length v3, v3

    invoke-static {v2, v7, v1, v7, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {v1}, Lcom/wishabi/flipp/content/a;->a([I)Z

    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "print_coupon_user_email"

    iget-object v3, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-static {v3}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Lcom/wishabi/flipp/app/PrintCouponFragment;)Lcom/wishabi/flipp/widget/ck;

    move-result-object v3

    iget-object v3, v3, Lcom/wishabi/flipp/widget/ck;->e:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    iget-object v2, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-virtual {v2}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0d0009

    iget v4, p0, Lcom/wishabi/flipp/app/dx;->a:I

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    iget v6, p0, Lcom/wishabi/flipp/app/dx;->a:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Lcom/wishabi/flipp/app/PrintCouponFragment;Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    iget-object v1, p0, Lcom/wishabi/flipp/app/dx;->b:Lcom/wishabi/flipp/app/PrintCouponFragment;

    const v2, 0x7f0e0124

    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Lcom/wishabi/flipp/app/PrintCouponFragment;Ljava/lang/String;)V

    goto :goto_0
.end method
