.class Lid$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lid;->c()V
.end annotation


# instance fields
.field final synthetic a:Lid;


# direct methods
.method constructor <init>(Lid;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lid$2;->a:Lid;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 99
    const/4 v0, 0x0

    invoke-static {v0}, Lid;->a(I)I

    .line 100
    iget-object v0, p0, Lid$2;->a:Lid;

    invoke-static {v0}, Lid;->a(Lid;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 101
    instance-of v1, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v1, :cond_3

    .line 102
    const-string v1, ""

    .line 103
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    .line 104
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v2, :cond_1

    .line 105
    const-string v1, "HOME"

    .line 111
    :cond_0
    :goto_0
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Ljava/lang/String;)Z

    .line 115
    :goto_1
    return-void

    .line 106
    :cond_1
    instance-of v2, v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v2, :cond_2

    .line 107
    const-string v1, "PRODUCTS"

    goto :goto_0

    .line 108
    :cond_2
    instance-of v2, v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    if-eqz v2, :cond_0

    .line 109
    const-string v1, "CART"

    goto :goto_0

    .line 113
    :cond_3
    iget-object v0, p0, Lid$2;->a:Lid;

    invoke-static {v0}, Lid;->b(Lid;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    goto :goto_1
.end method
