.class public Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
.super Ljava/lang/Object;
.source "VPCatalogManager.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$VPLocationRequestListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$VPLocationRequestListener;
    }
.end annotation


# static fields
.field private static TAG:Ljava/lang/String;


# instance fields
.field private configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

.field private context:Landroid/content/Context;

.field private onLocationRequestListener:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$VPLocationRequestListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const-string v0, "VPCatalogManager"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 104
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .line 105
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->setContext(Landroid/content/Context;)V

    .line 106
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V

    .line 107
    return-void
.end method

.method static synthetic access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    return-object v0
.end method

.method static synthetic access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;Ljava/util/List;Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    .param p1, "x1"    # Ljava/util/List;
    .param p2, "x2"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->collectionFromChannels(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;Ljava/util/List;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    .param p1, "x1"    # Ljava/util/List;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->collectionFromVideos(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private collectionFromChannels(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;
    .locals 13
    .param p2, "affiliate"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .local p1, "channels":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;>;"
    const/4 v11, 0x0

    .line 728
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 730
    .local v8, "mediaCollection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    const/4 v0, 0x0

    .line 731
    .local v0, "affiliateArray":[Ljava/lang/String;
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 732
    const-string v10, ","

    invoke-virtual {p2, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 733
    :cond_0
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v10

    if-ge v5, v10, :cond_9

    .line 735
    invoke-interface {p1, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    .line 736
    .local v3, "channel":Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;

    invoke-direct {v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;-><init>()V

    .line 737
    .local v9, "vm":Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setMediaId(Ljava/lang/String;)V

    .line 738
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v10

    if-eqz v10, :cond_3

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v10

    if-eqz v10, :cond_3

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v10

    if-eqz v10, :cond_3

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v2

    .line 739
    .local v2, "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    :goto_1
    if-eqz v2, :cond_4

    .line 740
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_4

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;

    .line 741
    .local v1, "asset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getFormat()Ljava/lang/String;

    move-result-object v10

    sget-object v12, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->ULNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    invoke-virtual {v12}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 742
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setContentUrl(Ljava/lang/String;)V

    .line 744
    :cond_2
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getAccesslevel()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_1

    .line 748
    :try_start_0
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getAccesslevel()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setAccessWindow(I)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 749
    :catch_0
    move-exception v10

    goto :goto_2

    .end local v1    # "asset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    .end local v2    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    .end local v6    # "i$":Ljava/util/Iterator;
    :cond_3
    move-object v2, v11

    .line 738
    goto :goto_1

    .line 753
    .restart local v2    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    :cond_4
    if-eqz v0, :cond_5

    array-length v10, v0

    if-le v10, v5, :cond_5

    .line 755
    aget-object v10, v0, v5

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setAffiliateId(Ljava/lang/String;)V

    .line 757
    :cond_5
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getDescription()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setMediaDesc(Ljava/lang/String;)V

    .line 758
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v10

    if-eqz v10, :cond_7

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;->getRating()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_7

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;->getRating()Ljava/lang/String;

    move-result-object v10

    :goto_3
    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setMediaRating(Ljava/lang/String;)V

    .line 759
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getTitle()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setMediaTitle(Ljava/lang/String;)V

    .line 760
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getWorkflowid()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setWorkflowId(Ljava/lang/String;)V

    .line 761
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v10

    if-eqz v10, :cond_8

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;->getThumbnail()Ljava/util/ArrayList;

    move-result-object v10

    if-eqz v10, :cond_8

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;->getThumbnail()Ljava/util/ArrayList;

    move-result-object v4

    .line 762
    .local v4, "epiThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    :goto_4
    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->EPISODE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    invoke-virtual {v9, v10, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->addThumbnail(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;Ljava/util/List;)V

    .line 764
    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->getAccessWindow()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    move-result-object v10

    sget-object v12, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    if-ne v10, v12, :cond_6

    .line 765
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAccesslevel()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_6

    .line 767
    :try_start_1
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAccesslevel()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setAccessWindow(I)V
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_3

    .line 771
    :cond_6
    :goto_5
    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 733
    add-int/lit8 v5, v5, 0x1

    goto/16 :goto_0

    .line 758
    .end local v4    # "epiThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    :cond_7
    const-string v10, ""

    goto :goto_3

    :cond_8
    move-object v4, v11

    .line 761
    goto :goto_4

    .line 774
    .end local v2    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    .end local v3    # "channel":Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;
    .end local v9    # "vm":Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;
    :cond_9
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_6
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_11

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    .line 776
    .restart local v3    # "channel":Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;

    invoke-direct {v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;-><init>()V

    .line 777
    .restart local v9    # "vm":Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setMediaId(Ljava/lang/String;)V

    .line 779
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v10

    if-eqz v10, :cond_c

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v10

    if-eqz v10, :cond_c

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v10

    if-eqz v10, :cond_c

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v2

    .line 780
    .restart local v2    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    :goto_7
    if-eqz v2, :cond_d

    .line 781
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_a
    :goto_8
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_d

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;

    .line 782
    .restart local v1    # "asset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getFormat()Ljava/lang/String;

    move-result-object v10

    sget-object v12, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->ULNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    invoke-virtual {v12}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_b

    .line 783
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setContentUrl(Ljava/lang/String;)V

    .line 785
    :cond_b
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getAccesslevel()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_a

    .line 789
    :try_start_2
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getAccesslevel()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setAccessWindow(I)V
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_8

    .line 790
    :catch_1
    move-exception v10

    goto :goto_8

    .end local v1    # "asset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    .end local v2    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    .end local v7    # "i$":Ljava/util/Iterator;
    :cond_c
    move-object v2, v11

    .line 779
    goto :goto_7

    .line 794
    .restart local v2    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    :cond_d
    invoke-virtual {v9, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setAffiliateId(Ljava/lang/String;)V

    .line 795
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getDescription()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setMediaDesc(Ljava/lang/String;)V

    .line 796
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v10

    if-eqz v10, :cond_f

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;->getRating()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_f

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;->getRating()Ljava/lang/String;

    move-result-object v10

    :goto_9
    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setMediaRating(Ljava/lang/String;)V

    .line 797
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getTitle()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setMediaTitle(Ljava/lang/String;)V

    .line 798
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getWorkflowid()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setWorkflowId(Ljava/lang/String;)V

    .line 799
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v10

    if-eqz v10, :cond_10

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;->getThumbnail()Ljava/util/ArrayList;

    move-result-object v10

    if-eqz v10, :cond_10

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v10

    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;->getThumbnail()Ljava/util/ArrayList;

    move-result-object v4

    .line 800
    .restart local v4    # "epiThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    :goto_a
    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->EPISODE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    invoke-virtual {v9, v10, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->addThumbnail(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;Ljava/util/List;)V

    .line 802
    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->getAccessWindow()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    move-result-object v10

    sget-object v12, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    if-ne v10, v12, :cond_e

    .line 803
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAccesslevel()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_e

    .line 805
    :try_start_3
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAccesslevel()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->setAccessWindow(I)V
    :try_end_3
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_2

    .line 809
    :cond_e
    :goto_b
    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_6

    .line 796
    .end local v4    # "epiThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    :cond_f
    const-string v10, ""

    goto :goto_9

    :cond_10
    move-object v4, v11

    .line 799
    goto :goto_a

    .line 812
    .end local v2    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    .end local v3    # "channel":Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;
    .end local v9    # "vm":Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;
    :cond_11
    return-object v8

    .line 806
    .restart local v2    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    .restart local v3    # "channel":Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;
    .restart local v4    # "epiThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    .restart local v9    # "vm":Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;
    :catch_2
    move-exception v10

    goto :goto_b

    .line 768
    :catch_3
    move-exception v10

    goto/16 :goto_5
.end method

.method private collectionFromVideos(Ljava/util/List;)Ljava/util/List;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Video;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .local p1, "videos":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Video;>;"
    const/4 v10, 0x0

    .line 622
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 623
    .local v5, "mediaCollection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_14

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;

    .line 624
    .local v7, "video":Lcom/disney/datg/videoplatforms/sdk/models/api/Video;
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-direct {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;-><init>()V

    .line 625
    .local v8, "vm":Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setMediaId(Ljava/lang/String;)V

    .line 627
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v9

    if-eqz v9, :cond_3

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v9

    if-eqz v9, :cond_3

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v9

    if-eqz v9, :cond_3

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v1

    .line 628
    .local v1, "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    :goto_1
    if-eqz v1, :cond_4

    .line 629
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;

    .line 630
    .local v0, "asset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getFormat()Ljava/lang/String;

    move-result-object v9

    sget-object v11, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->ULNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    invoke-virtual {v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 631
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setContentUrl(Ljava/lang/String;)V

    .line 635
    :cond_1
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getStorageid()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 636
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getStorageid()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setStorageId(Ljava/lang/String;)V

    .line 639
    :cond_2
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getAccesslevel()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 643
    :try_start_0
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getAccesslevel()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setAccessWindow(I)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 644
    :catch_0
    move-exception v9

    goto :goto_2

    .end local v0    # "asset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    .end local v1    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_3
    move-object v1, v10

    .line 627
    goto :goto_1

    .line 648
    .restart local v1    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    :cond_4
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getDescription()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setMediaDesc(Ljava/lang/String;)V

    .line 649
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v9

    if-eqz v9, :cond_11

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;->getRating()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_11

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;->getRating()Ljava/lang/String;

    move-result-object v9

    :goto_3
    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setMediaRating(Ljava/lang/String;)V

    .line 650
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getTitle()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setMediaTitle(Ljava/lang/String;)V

    .line 651
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getWorkflowid()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setWorkflowId(Ljava/lang/String;)V

    .line 652
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    if-eqz v9, :cond_12

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v9

    if-eqz v9, :cond_12

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;->getThumbnail()Ljava/util/ArrayList;

    move-result-object v6

    .line 653
    .local v6, "showThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    :goto_4
    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->SHOW:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    invoke-virtual {v8, v9, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->addThumbnail(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;Ljava/util/List;)V

    .line 654
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v9

    if-eqz v9, :cond_13

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;->getThumbnail()Ljava/util/ArrayList;

    move-result-object v9

    if-eqz v9, :cond_13

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;->getThumbnail()Ljava/util/ArrayList;

    move-result-object v2

    .line 655
    .local v2, "epiThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    :goto_5
    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->EPISODE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    invoke-virtual {v8, v9, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->addThumbnail(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;Ljava/util/List;)V

    .line 656
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getDuration()Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;

    move-result-object v9

    if-eqz v9, :cond_5

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getDuration()Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;->getValue()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_5

    .line 658
    :try_start_1
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getDuration()Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;->getValue()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v12

    invoke-virtual {v8, v12, v13}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setDuration(J)V
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_2

    .line 663
    :cond_5
    :goto_6
    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getAccessWindow()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    move-result-object v9

    sget-object v11, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    if-ne v9, v11, :cond_6

    .line 664
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAccesslevel()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_6

    .line 666
    :try_start_2
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAccesslevel()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setAccessWindow(I)V
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1

    .line 671
    :cond_6
    :goto_7
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAirdates()Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;

    move-result-object v9

    if-eqz v9, :cond_7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAirdates()Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;->getAirdate()Ljava/util/ArrayList;

    move-result-object v9

    if-eqz v9, :cond_7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAirdates()Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;->getAirdate()Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lez v9, :cond_7

    .line 672
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAirdates()Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;->getAirdate()Ljava/util/ArrayList;

    move-result-object v9

    const/4 v11, 0x0

    invoke-virtual {v9, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/disney/datg/videoplatforms/sdk/models/api/AirDate;

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setAirDate(Ljava/lang/String;)V

    .line 674
    :cond_7
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getExpiredate()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_8

    .line 675
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getExpiredate()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setExpireDate(Ljava/lang/String;)V

    .line 677
    :cond_8
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getNumber()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_9

    .line 678
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getNumber()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setEpisodeNumber(Ljava/lang/String;)V

    .line 680
    :cond_9
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAvaildate()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_a

    .line 681
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAvaildate()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setAvailableDate(Ljava/lang/String;)V

    .line 683
    :cond_a
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getSeason()Lcom/disney/datg/videoplatforms/sdk/models/api/Season;

    move-result-object v9

    if-eqz v9, :cond_b

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getSeason()Lcom/disney/datg/videoplatforms/sdk/models/api/Season;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Season;->getNum()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_b

    .line 684
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getSeason()Lcom/disney/datg/videoplatforms/sdk/models/api/Season;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Season;->getNum()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setSeasonNumber(Ljava/lang/String;)V

    .line 686
    :cond_b
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    if-eqz v9, :cond_c

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    if-eqz v9, :cond_c

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    if-eqz v9, :cond_c

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->getCprogram()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_c

    .line 690
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->getCprogram()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setDayPart(Ljava/lang/String;)V

    .line 693
    :cond_c
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    if-eqz v9, :cond_d

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    if-eqz v9, :cond_d

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    if-eqz v9, :cond_d

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->getCgenre()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_d

    .line 697
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->getCgenre()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setCGenre(Ljava/lang/String;)V

    .line 700
    :cond_d
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    if-eqz v9, :cond_e

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    if-eqz v9, :cond_e

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    if-eqz v9, :cond_e

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->getCshow()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_e

    .line 704
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->getCshow()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setCShowName(Ljava/lang/String;)V

    .line 707
    :cond_e
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    if-eqz v9, :cond_f

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    if-eqz v9, :cond_f

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    if-eqz v9, :cond_f

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->getCshow()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_f

    .line 711
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->getCshow()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setCShowName(Ljava/lang/String;)V

    .line 714
    :cond_f
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAdtarget()Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;

    move-result-object v9

    if-eqz v9, :cond_10

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAdtarget()Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;->getAbcdvas()Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;

    move-result-object v9

    if-eqz v9, :cond_10

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAdtarget()Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;->getAbcdvas()Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;->getCvideo()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_10

    .line 717
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAdtarget()Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;->getAbcdvas()Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;->getCvideo()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->setCVideo(Ljava/lang/String;)V

    .line 719
    :cond_10
    invoke-interface {v5, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 649
    .end local v2    # "epiThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    .end local v6    # "showThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    :cond_11
    const-string v9, ""

    goto/16 :goto_3

    :cond_12
    move-object v6, v10

    .line 652
    goto/16 :goto_4

    .restart local v6    # "showThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    :cond_13
    move-object v2, v10

    .line 654
    goto/16 :goto_5

    .line 722
    .end local v1    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    .end local v6    # "showThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    .end local v7    # "video":Lcom/disney/datg/videoplatforms/sdk/models/api/Video;
    .end local v8    # "vm":Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;
    :cond_14
    return-object v5

    .line 667
    .restart local v1    # "assets":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;>;"
    .restart local v2    # "epiThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    .restart local v6    # "showThum":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    .restart local v7    # "video":Lcom/disney/datg/videoplatforms/sdk/models/api/Video;
    .restart local v8    # "vm":Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;
    :catch_1
    move-exception v9

    goto/16 :goto_7

    .line 659
    :catch_2
    move-exception v9

    goto/16 :goto_6
.end method

.method protected static getCatalogManager(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .prologue
    .line 88
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    invoke-direct {v0, p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;-><init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V

    return-object v0
.end method


# virtual methods
.method public getChannelCatalog(Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;",
            ">;"
        }
    .end annotation

    .prologue
    .line 352
    .local p1, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;>;"
    const/4 v1, 0x0

    .line 354
    .local v1, "affiliateString":Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v5

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->context:Landroid/content/Context;

    invoke-virtual {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->doLBS(Landroid/content/Context;)Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    move-result-object v3

    .line 355
    .local v3, "geolocation":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v5

    const-string v6, "001"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v5

    const-string v6, "abc"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 357
    :cond_0
    if-eqz v3, :cond_1

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 358
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;

    .line 359
    .local v0, "affiliate":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 360
    goto :goto_0

    .line 368
    .end local v0    # "affiliate":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_0
    invoke-virtual {p0, v1, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->getChannelCatalog(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 373
    :goto_1
    return-object v5

    .line 369
    :catch_0
    move-exception v2

    .line 370
    .local v2, "e":Ljava/util/concurrent/RejectedExecutionException;
    if-eqz p1, :cond_2

    .line 371
    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v6, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v5, v6, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {p1, v5}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 373
    :cond_2
    const/4 v5, 0x0

    goto :goto_1
.end method

.method public getChannelCatalog(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .param p1, "affiliate"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;",
            ">;"
        }
    .end annotation

    .prologue
    .line 416
    .local p2, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;>;"
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;

    invoke-direct {v1, p0, p2, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->execute(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public getVideoCatalog(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .param p1, "videoId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;",
            ">;"
        }
    .end annotation

    .prologue
    .line 491
    .local p2, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;>;"
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;

    invoke-direct {v1, p0, p2, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->execute(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public onLocationRequest()V
    .locals 1

    .prologue
    .line 827
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->onLocationRequestListener:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$VPLocationRequestListener;

    invoke-interface {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$VPLocationRequestListener;->onLocationRequest()V

    .line 828
    return-void
.end method

.method public setContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 840
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->context:Landroid/content/Context;

    .line 841
    return-void
.end method
