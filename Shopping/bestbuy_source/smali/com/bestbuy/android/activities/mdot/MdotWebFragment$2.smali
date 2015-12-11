.class Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lkj;


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
    .line 266
    iput-object p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(II)V
    .locals 8

    .prologue
    const/16 v2, 0x8

    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 269
    const/16 v0, 0xc8

    if-ge p2, v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 270
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0, v4}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;Z)Z

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Ljava/lang/String;

    move-result-object v0

    const-string v1, ".bestbuy.com/cart"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 294
    :goto_0
    return-void

    .line 274
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    if-ne v0, v2, :cond_1

    .line 275
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 277
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->f(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setPullDownEvent(Z)V

    .line 278
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .line 279
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    const-wide/16 v6, 0x64

    add-long/2addr v2, v6

    move v6, v5

    move v7, v4

    .line 282
    invoke-static/range {v0 .. v7}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v0

    .line 290
    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->f(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    goto :goto_0

    .line 292
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method
