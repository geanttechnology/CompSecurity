.class Lcom/bestbuy/android/bbyobjects/BBYPromoPager$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a(Landroid/content/Context;Ljava/util/List;Landroid/widget/ScrollView;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 75
    invoke-static {}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Landroid/support/v4/view/ViewPager;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->c(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$2;->a:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->b(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 79
    :cond_0
    return-void
.end method
