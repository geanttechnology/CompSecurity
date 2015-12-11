.class Liq$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Liq;->c()V
.end annotation


# instance fields
.field final synthetic a:Liq;


# direct methods
.method constructor <init>(Liq;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Liq$2;->a:Liq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 89
    const/4 v0, 0x0

    invoke-static {v0}, Liq;->a(I)I

    .line 90
    iget-object v0, p0, Liq$2;->a:Liq;

    invoke-static {v0}, Liq;->n(Liq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 91
    const-string v1, ""

    .line 92
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    .line 93
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v2, :cond_1

    .line 94
    const-string v1, "HOME"

    .line 100
    :cond_0
    :goto_0
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Ljava/lang/String;)Z

    .line 103
    return-void

    .line 95
    :cond_1
    instance-of v2, v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v2, :cond_2

    .line 96
    const-string v1, "PRODUCTS"

    goto :goto_0

    .line 97
    :cond_2
    instance-of v2, v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    if-eqz v2, :cond_0

    .line 98
    const-string v1, "CART"

    goto :goto_0
.end method
