.class Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a(Landroid/content/Context;Ljava/util/List;Landroid/widget/ScrollView;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 67
    invoke-static {}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)Landroid/support/v4/view/ViewPager;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->c(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->b(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 71
    :cond_0
    return-void
.end method
