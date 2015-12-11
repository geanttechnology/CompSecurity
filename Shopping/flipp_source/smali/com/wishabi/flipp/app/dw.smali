.class final Lcom/wishabi/flipp/app/dw;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/cw;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/PrintCouponFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/PrintCouponFragment;)V
    .locals 0

    .prologue
    .line 252
    iput-object p1, p0, Lcom/wishabi/flipp/app/dw;->a:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/wishabi/flipp/app/dw;->a:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->b(Lcom/wishabi/flipp/app/PrintCouponFragment;)V

    .line 256
    return-void
.end method

.method public final b()V
    .locals 3

    .prologue
    .line 260
    iget-object v0, p0, Lcom/wishabi/flipp/app/dw;->a:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 261
    if-nez v0, :cond_0

    .line 269
    :goto_0
    return-void

    .line 264
    :cond_0
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/wishabi/flipp/app/CouponHelpActivity;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 266
    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 267
    const v1, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0
.end method
