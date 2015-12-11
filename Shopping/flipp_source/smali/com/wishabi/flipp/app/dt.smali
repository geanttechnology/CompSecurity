.class final Lcom/wishabi/flipp/app/dt;
.super Landroid/support/v7/widget/v;
.source "SourceFile"


# instance fields
.field final synthetic b:I

.field final synthetic c:Lcom/wishabi/flipp/app/PrintCouponFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/PrintCouponFragment;I)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/wishabi/flipp/app/dt;->c:Lcom/wishabi/flipp/app/PrintCouponFragment;

    iput p2, p0, Lcom/wishabi/flipp/app/dt;->b:I

    invoke-direct {p0}, Landroid/support/v7/widget/v;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)I
    .locals 2

    .prologue
    .line 107
    iget-object v0, p0, Lcom/wishabi/flipp/app/dt;->c:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Lcom/wishabi/flipp/app/PrintCouponFragment;)Lcom/wishabi/flipp/widget/ck;

    move-result-object v0

    if-nez v0, :cond_0

    .line 108
    iget v0, p0, Lcom/wishabi/flipp/app/dt;->b:I

    .line 114
    :goto_0
    return v0

    .line 110
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/dt;->c:Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Lcom/wishabi/flipp/app/PrintCouponFragment;)Lcom/wishabi/flipp/widget/ck;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ck;->a(I)I

    move-result v0

    .line 111
    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 112
    const/4 v0, 0x1

    goto :goto_0

    .line 114
    :cond_1
    iget v0, p0, Lcom/wishabi/flipp/app/dt;->b:I

    goto :goto_0
.end method
