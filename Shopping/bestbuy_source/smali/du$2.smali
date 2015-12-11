.class Ldu$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldu;->instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Ldu;


# direct methods
.method constructor <init>(Ldu;I)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Ldu$2;->b:Ldu;

    iput p2, p0, Ldu$2;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const v3, 0x7f080086

    const/4 v4, 0x0

    .line 181
    iget-object v0, p0, Ldu$2;->b:Ldu;

    invoke-static {v0}, Ldu;->c(Ldu;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 186
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 187
    iget-object v1, p0, Ldu$2;->b:Ldu;

    invoke-static {v1}, Ldu;->b(Ldu;)Landroid/app/Activity;

    move-result-object v1

    const v2, 0x7f08003e

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 188
    invoke-interface {v0, v1, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 189
    if-nez v1, :cond_0

    .line 190
    iget-object v1, p0, Ldu$2;->b:Ldu;

    invoke-static {v1}, Ldu;->b(Ldu;)Landroid/app/Activity;

    move-result-object v1

    const v2, 0x7f08004c

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 191
    if-nez v1, :cond_0

    .line 192
    iget-object v1, p0, Ldu$2;->b:Ldu;

    invoke-static {v1}, Ldu;->b(Ldu;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 193
    const/16 v2, 0xa

    if-lt v1, v2, :cond_2

    .line 194
    new-instance v0, Lkt;

    iget-object v1, p0, Ldu$2;->b:Ldu;

    invoke-static {v1}, Ldu;->b(Ldu;)Landroid/app/Activity;

    move-result-object v1

    sget-object v2, Lku;->a:Lku;

    invoke-direct {v0, v1, v2}, Lkt;-><init>(Landroid/content/Context;Lku;)V

    .line 195
    invoke-virtual {v0}, Lkt;->a()V

    .line 203
    :cond_0
    :goto_0
    iget-object v0, p0, Ldu$2;->b:Ldu;

    invoke-static {v0}, Ldu;->a(Ldu;)Ljava/util/List;

    move-result-object v0

    iget v1, p0, Ldu$2;->a:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "customOffer"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 204
    iget-object v0, p0, Ldu$2;->b:Ldu;

    invoke-static {v0}, Ldu;->a(Ldu;)Ljava/util/List;

    move-result-object v0

    iget v1, p0, Ldu$2;->a:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 205
    iget-object v1, p0, Ldu$2;->b:Ldu;

    invoke-static {v1}, Ldu;->d(Ldu;)Lcom/bestbuy/android/activities/home/DODHomeCard;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Ljava/lang/String;)V

    .line 210
    :cond_1
    :goto_1
    return-void

    .line 197
    :cond_2
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 198
    iget-object v2, p0, Ldu$2;->b:Ldu;

    invoke-static {v2}, Ldu;->b(Ldu;)Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    add-int/lit8 v1, v1, 0x1

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 199
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0

    .line 206
    :cond_3
    iget-object v0, p0, Ldu$2;->b:Ldu;

    invoke-static {v0}, Ldu;->a(Ldu;)Ljava/util/List;

    move-result-object v0

    iget v1, p0, Ldu$2;->a:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "product"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 207
    iget-object v0, p0, Ldu$2;->b:Ldu;

    invoke-static {v0}, Ldu;->b(Ldu;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Ldu$2;->b:Ldu;

    invoke-static {v1}, Ldu;->a(Ldu;)Ljava/util/List;

    move-result-object v1

    iget v2, p0, Ldu$2;->a:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getSkuId()Ljava/lang/String;

    move-result-object v2

    iget-object v1, p0, Ldu$2;->b:Ldu;

    invoke-static {v1}, Ldu;->a(Ldu;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Ldu$2;->a:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_1
.end method
