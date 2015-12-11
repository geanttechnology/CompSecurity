.class Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity$1;->a:Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity$1;->a:Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->finish()V

    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity$1;->a:Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;

    const v1, 0x7f040005

    const v2, 0x7f040008

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/cart/PriceAndShippingDetailsActivity;->overridePendingTransition(II)V

    .line 36
    return-void
.end method
