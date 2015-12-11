.class Lcom/bestbuy/android/activities/home/GHPBannersHomeCard$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->a(Ljava/util/List;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/offers/Offer;

.field final synthetic b:Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;Lcom/bestbuy/android/api/lib/models/offers/Offer;)V
    .locals 0

    .prologue
    .line 481
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard$1;->b:Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    iput-object p2, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard$1;->a:Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 485
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard$1;->b:Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard$1;->a:Lcom/bestbuy/android/api/lib/models/offers/Offer;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard$1;->b:Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    invoke-static {v2}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->a(Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->a(Lcom/bestbuy/android/api/lib/models/offers/Offer;I)V

    .line 487
    return-void
.end method
