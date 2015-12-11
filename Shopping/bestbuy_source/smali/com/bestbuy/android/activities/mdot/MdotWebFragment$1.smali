.class Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V
    .locals 0

    .prologue
    .line 243
    iput-object p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 246
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 263
    :cond_0
    :goto_0
    return v1

    .line 248
    :pswitch_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;F)F

    goto :goto_0

    .line 252
    :pswitch_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 256
    :pswitch_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;F)F

    .line 257
    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)F

    move-result v0

    iget-object v3, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)F

    move-result v3

    sub-float/2addr v0, v3

    const/high16 v3, 0x43960000    # 300.0f

    cmpl-float v0, v0, v3

    if-lez v0, :cond_1

    const/4 v0, 0x1

    :goto_1
    invoke-static {v2, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;Z)Z

    .line 258
    invoke-virtual {p1}, Landroid/view/View;->hasFocus()Z

    move-result v0

    if-nez v0, :cond_0

    .line 259
    invoke-virtual {p1}, Landroid/view/View;->requestFocus()Z

    goto :goto_0

    :cond_1
    move v0, v1

    .line 257
    goto :goto_1

    .line 246
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method
