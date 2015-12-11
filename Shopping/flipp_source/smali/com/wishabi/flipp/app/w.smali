.class final Lcom/wishabi/flipp/app/w;
.super Landroid/support/v7/widget/v;
.source "SourceFile"


# instance fields
.field final synthetic b:I

.field final synthetic c:I

.field final synthetic d:I

.field final synthetic e:Lcom/wishabi/flipp/app/CouponFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/CouponFragment;III)V
    .locals 0

    .prologue
    .line 202
    iput-object p1, p0, Lcom/wishabi/flipp/app/w;->e:Lcom/wishabi/flipp/app/CouponFragment;

    iput p2, p0, Lcom/wishabi/flipp/app/w;->b:I

    iput p3, p0, Lcom/wishabi/flipp/app/w;->c:I

    iput p4, p0, Lcom/wishabi/flipp/app/w;->d:I

    invoke-direct {p0}, Landroid/support/v7/widget/v;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)I
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/wishabi/flipp/app/w;->e:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/CouponFragment;->a(Lcom/wishabi/flipp/app/CouponFragment;)Lcom/wishabi/flipp/widget/an;

    move-result-object v0

    if-nez v0, :cond_0

    .line 206
    const/4 v0, 0x1

    .line 217
    :goto_0
    return v0

    .line 208
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/w;->e:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/CouponFragment;->a(Lcom/wishabi/flipp/app/CouponFragment;)Lcom/wishabi/flipp/widget/an;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/an;->a(I)I

    move-result v0

    .line 209
    packed-switch v0, :pswitch_data_0

    .line 217
    iget v0, p0, Lcom/wishabi/flipp/app/w;->d:I

    goto :goto_0

    .line 211
    :pswitch_0
    iget v0, p0, Lcom/wishabi/flipp/app/w;->b:I

    goto :goto_0

    .line 213
    :pswitch_1
    iget v0, p0, Lcom/wishabi/flipp/app/w;->c:I

    goto :goto_0

    .line 215
    :pswitch_2
    iget v0, p0, Lcom/wishabi/flipp/app/w;->b:I

    goto :goto_0

    .line 209
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
