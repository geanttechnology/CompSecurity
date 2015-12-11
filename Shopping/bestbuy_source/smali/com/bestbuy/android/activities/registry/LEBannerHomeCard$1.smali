.class Lcom/bestbuy/android/activities/registry/LEBannerHomeCard$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->a(Ljava/util/List;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/offers/Offer;

.field final synthetic b:Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;Lcom/bestbuy/android/api/lib/models/offers/Offer;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard$1;->b:Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard$1;->a:Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard$1;->b:Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard$1;->a:Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->a(Lcom/bestbuy/android/api/lib/models/offers/Offer;)V

    .line 89
    return-void
.end method
