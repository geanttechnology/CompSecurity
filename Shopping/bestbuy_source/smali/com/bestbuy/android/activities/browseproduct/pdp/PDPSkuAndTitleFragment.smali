.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private b:Landroid/view/View;

.field private c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private g:Ljava/lang/String;

.field private h:Z

.field private i:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 45
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)V
    .locals 2

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 48
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 49
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 50
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->h:Z

    .line 53
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 54
    const-string v1, "product"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 55
    const-string v1, "dnmProduct"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 56
    const-string v1, "isFromDNM"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 57
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->setArguments(Landroid/os/Bundle;)V

    .line 58
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->i:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->g:Ljava/lang/String;

    return-object v0
.end method

.method private b()V
    .locals 13

    .prologue
    const/4 v12, 0x0

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getLpn()Ljava/lang/String;

    move-result-object v1

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v2, 0x7f0c02c1

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 118
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    iget-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->h:Z

    if-eqz v2, :cond_0

    .line 119
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getLpn()Ljava/lang/String;

    move-result-object v2

    const-string v3, "null"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 120
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 127
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_a

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v1, 0x7f0c02c5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 129
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v2, 0x7f0c028e

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 130
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v3, 0x7f0c02bc

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 131
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v4, 0x7f0c02c2

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 132
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v5, 0x7f0c02be

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 133
    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v6, 0x7f0c02bf

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 134
    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v7, 0x7f0c02c3

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 135
    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v8, 0x7f0c02c7

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 136
    iget-object v8, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v9, 0x7f0c02c0

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 138
    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v9

    if-eqz v9, :cond_1

    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_1

    .line 139
    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v10, 0x7f0c02bd

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "<span class=\'bold\'>SKU: </span>"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v11}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 141
    :cond_1
    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getManufacturerId()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    move-result-object v9

    if-eqz v9, :cond_2

    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getManufacturerId()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    move-result-object v9

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;->getModelNumber()Ljava/lang/String;

    move-result-object v9

    if-eqz v9, :cond_2

    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getManufacturerId()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    move-result-object v9

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;->getModelNumber()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_2

    .line 142
    invoke-virtual {v2, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 143
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "<span class=\'bold\'>Model: </span>"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v10}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getManufacturerId()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    move-result-object v10

    invoke-virtual {v10}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;->getModelNumber()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 146
    :cond_2
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getPrimaryArtist()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getPrimaryArtist()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PrimaryArtist;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PrimaryArtist;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 148
    invoke-virtual {v3, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 149
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "<span class=\'bold\'>Artist: </span>"

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getPrimaryArtist()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PrimaryArtist;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PrimaryArtist;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 151
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getEsrbRating()Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;

    move-result-object v2

    if-eqz v2, :cond_c

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getEsrbRating()Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;->getRating()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_c

    .line 152
    invoke-virtual {v0, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 153
    invoke-virtual {v1, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 154
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getEsrbRating()Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;->getRating()Ljava/lang/String;

    move-result-object v2

    .line 155
    if-eqz v2, :cond_4

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    .line 156
    const-string v3, "ESRB Rating:"

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 157
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 158
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)V

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 193
    :cond_4
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getFileSize()Ljava/lang/String;

    move-result-object v0

    .line 195
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_5

    .line 196
    invoke-virtual {v4, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 197
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "<span class=\'bold\'>Filesize: </span>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 200
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBrand()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    move-result-object v0

    if-eqz v0, :cond_8

    .line 201
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBrand()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;->getPublisher()Ljava/lang/String;

    move-result-object v0

    .line 202
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBrand()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;->getVendor()Ljava/lang/String;

    move-result-object v1

    .line 203
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBrand()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;->getLabel()Ljava/lang/String;

    move-result-object v2

    .line 205
    if-eqz v0, :cond_6

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_6

    .line 206
    invoke-virtual {v5, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 207
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "<span class=\'bold\'>Publisher: </span>"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 209
    :cond_6
    if-eqz v1, :cond_7

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_7

    .line 210
    invoke-virtual {v8, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 211
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "<span class=\'bold\'>Vendor: </span>"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 213
    :cond_7
    if-eqz v2, :cond_8

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_8

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v1, 0x7f0c02c4

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 215
    invoke-virtual {v0, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 216
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "<span class=\'bold\'>Label: </span>"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 220
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDates()Lcom/bestbuy/android/api/lib/models/pdp/Dates;

    move-result-object v0

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDates()Lcom/bestbuy/android/api/lib/models/pdp/Dates;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Dates;->getStreetDate()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_9

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDates()Lcom/bestbuy/android/api/lib/models/pdp/Dates;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Dates;->getStreetDate()Ljava/lang/String;

    move-result-object v0

    .line 222
    if-eqz v0, :cond_9

    .line 223
    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    .line 224
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_9

    if-eqz v0, :cond_9

    .line 225
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "<span class=\'bold\'>Release: </span>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 226
    invoke-virtual {v6, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 230
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    .line 232
    if-eqz v0, :cond_a

    .line 233
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    move-result-object v1

    .line 234
    if-eqz v1, :cond_a

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getSeller()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_a

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getSellerUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_a

    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v2, 0x7f0c02c6

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 236
    invoke-virtual {v7, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 237
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getSeller()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 238
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;

    invoke-direct {v0, p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;)V

    invoke-virtual {v7, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 249
    :cond_a
    return-void

    .line 122
    :cond_b
    invoke-virtual {v0, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 123
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "<span class=\'bold\'>Open Item ID: </span>"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 166
    :cond_c
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v2

    if-eqz v2, :cond_d

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isParentalAdvisory()Z

    move-result v2

    if-eqz v2, :cond_d

    .line 167
    invoke-virtual {v0, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 168
    invoke-virtual {v1, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 169
    const-string v2, "Parental Advisory"

    .line 170
    const-string v3, "Rating:"

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 171
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 172
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)V

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_1

    .line 179
    :cond_d
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieRatings()Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;

    move-result-object v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieRatings()Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;->getRating()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieRatings()Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;->getRating()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4

    .line 180
    invoke-virtual {v0, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 181
    invoke-virtual {v1, v12}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 182
    const-string v2, "Rating:"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieRatings()Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;->getRating()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 184
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$4;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$4;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)V

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->i:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 7

    .prologue
    const v6, 0x7f0c0033

    const/4 v5, 0x1

    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->d:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 254
    invoke-virtual {v0, v6}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 255
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v1, v5, v5}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 256
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 257
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080055

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 258
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 259
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_0

    .line 260
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 261
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 262
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v5}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 268
    :goto_0
    return-void

    .line 263
    :cond_0
    instance-of v2, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v2, :cond_1

    .line 264
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 266
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "MdotWebFragment"

    invoke-virtual {v0, v6, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 68
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 62
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 63
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->d:Landroid/app/Activity;

    .line 64
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 71
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 72
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 76
    const v0, 0x7f0300b1

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    const v1, 0x7f0c029a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-nez v0, :cond_0

    .line 80
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 81
    const-string v0, "product"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 82
    const-string v0, "dnmProduct"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 83
    const-string v0, "isFromDNM"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->h:Z

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_1

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->g:Ljava/lang/String;

    .line 90
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 106
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b()V

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b:Landroid/view/View;

    return-object v0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 111
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 112
    return-void
.end method
