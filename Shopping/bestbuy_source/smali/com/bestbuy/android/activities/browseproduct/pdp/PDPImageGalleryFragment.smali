.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lkm;


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private c:Landroid/view/View;

.field private g:Landroid/widget/FrameLayout;

.field private h:Landroid/widget/FrameLayout;

.field private i:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private j:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private k:Landroid/widget/LinearLayout;

.field private l:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 43
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 47
    return-void
.end method

.method private b()V
    .locals 7

    .prologue
    const v6, 0x7f0c022a

    const/4 v2, 0x0

    const/16 v5, 0x1f4

    .line 105
    new-instance v3, Ljava/util/LinkedHashSet;

    invoke-direct {v3}, Ljava/util/LinkedHashSet;-><init>()V

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 120
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_4

    move v1, v2

    .line 121
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_4

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 121
    :cond_1
    :goto_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 115
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getPath()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 116
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://pisces.bbystatic.com/image2/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ";canvasHeight="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ";canvasWidth="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 117
    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 124
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getPath()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 125
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "http://pisces.bbystatic.com/image2/"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getGalleryImages()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";canvasHeight="

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";canvasWidth="

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 126
    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto/16 :goto_2

    .line 131
    :cond_4
    if-eqz v3, :cond_5

    invoke-interface {v3}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;

    .line 133
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 134
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->a:Landroid/app/Activity;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v1, v3}, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->a(Landroid/content/Context;Ljava/util/List;Lkm;)V

    .line 141
    :goto_3
    return-void

    .line 136
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    const v1, 0x7f0c022b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 138
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 139
    const v1, 0x7f020130

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_3
.end method


# virtual methods
.method public a(I)V
    .locals 3

    .prologue
    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->l:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->l:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;

    .line 158
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->getVideos()Ljava/util/ArrayList;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/product/Product$Video;

    .line 159
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 160
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 161
    const-string v2, "video/*"

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->a:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 164
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 56
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 57
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 51
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->a:Landroid/app/Activity;

    .line 53
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->j:Lcom/bestbuy/android/bbyobjects/BBYButton;

    if-ne p1, v0, :cond_1

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->h:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->g:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 152
    :cond_0
    :goto_0
    return-void

    .line 148
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYButton;

    if-ne p1, v0, :cond_0

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->g:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->h:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 61
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 65
    const v0, 0x7f03008f

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0227

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0228

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->j:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0229

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->g:Landroid/widget/FrameLayout;

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    const v1, 0x7f0c022c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->h:Landroid/widget/FrameLayout;

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0226

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->k:Landroid/widget/LinearLayout;

    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->j:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->b()V

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;->c:Landroid/view/View;

    return-object v0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 83
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 84
    return-void
.end method
