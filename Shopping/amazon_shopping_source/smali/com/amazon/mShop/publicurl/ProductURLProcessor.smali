.class public Lcom/amazon/mShop/publicurl/ProductURLProcessor;
.super Lcom/amazon/mShop/publicurl/PublicURLProcessor;
.source "ProductURLProcessor.java"


# instance fields
.field private mMetricIdentity:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/net/Uri;)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;-><init>(Landroid/net/Uri;)V

    .line 27
    const-string/jumbo v0, "PD"

    iput-object v0, p0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mMetricIdentity:Ljava/lang/String;

    .line 31
    return-void
.end method


# virtual methods
.method protected doProcess(Landroid/content/Context;)V
    .locals 20
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 47
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->getRefmarker()Ljava/lang/String;

    move-result-object v16

    .line 48
    .local v16, "refmarker":Ljava/lang/String;
    invoke-static/range {v16 .. v16}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_3

    sget-object v6, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_PUBLIC_URL:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 50
    .local v6, "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mPathSegments:Ljava/util/List;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->size()I

    move-result v18

    const/16 v19, 0x2

    move/from16 v0, v18

    move/from16 v1, v19

    if-lt v0, v1, :cond_4

    .line 53
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mPathSegments:Ljava/util/List;

    move-object/from16 v18, v0

    const/16 v19, 0x1

    invoke-interface/range {v18 .. v19}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 54
    .local v5, "asin":Ljava/lang/String;
    const/4 v14, 0x0

    .line 55
    .local v14, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v18

    if-nez v18, :cond_0

    .line 56
    new-instance v14, Lcom/amazon/mShop/control/item/ProductController;

    .end local v14    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-direct {v14, v5, v6}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 57
    .restart local v14    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    const-string/jumbo v18, "PD"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mMetricIdentity:Ljava/lang/String;

    .line 60
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mPathSegments:Ljava/util/List;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->size()I

    move-result v18

    const/16 v19, 0x4

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mPathSegments:Ljava/util/List;

    move-object/from16 v18, v0

    const/16 v19, 0x2

    invoke-interface/range {v18 .. v19}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/String;

    const-string/jumbo v19, "merchants"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_0

    .line 61
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mPathSegments:Ljava/util/List;

    move-object/from16 v18, v0

    const/16 v19, 0x3

    invoke-interface/range {v18 .. v19}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 62
    .local v13, "merchantId":Ljava/lang/String;
    invoke-virtual {v14, v13}, Lcom/amazon/mShop/control/item/ProductController;->setMerchantId(Ljava/lang/String;)V

    .line 63
    const-string/jumbo v18, "PD_M"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mMetricIdentity:Ljava/lang/String;

    .line 67
    .end local v13    # "merchantId":Ljava/lang/String;
    :cond_0
    if-eqz v14, :cond_2

    .line 68
    sget-object v18, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->getOrigin()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_1

    .line 69
    const-string/jumbo v18, "pn_product_detail_t"

    invoke-static/range {v18 .. v18}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 71
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->getParams()Ljava/util/Map;

    move-result-object v18

    const/high16 v19, 0x80000

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-static {v0, v14, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;I)Z

    .line 142
    .end local v5    # "asin":Ljava/lang/String;
    .end local v14    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :cond_2
    :goto_1
    return-void

    .line 48
    .end local v6    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :cond_3
    new-instance v6, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v18, ""

    move-object/from16 v0, v18

    invoke-direct {v6, v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 73
    .restart local v6    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mPathSegments:Ljava/util/List;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->size()I

    move-result v18

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_2

    .line 77
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mUri:Landroid/net/Uri;

    move-object/from16 v18, v0

    const-string/jumbo v19, "q"

    invoke-virtual/range {v18 .. v19}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 78
    .local v15, "query":Ljava/lang/String;
    invoke-static {v15}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v18

    if-nez v18, :cond_7

    .line 79
    const-string/jumbo v18, "\\+"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 80
    .local v11, "keywords":[Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    .line 81
    .local v10, "keyword":Ljava/lang/StringBuilder;
    move-object v4, v11

    .local v4, "arr$":[Ljava/lang/String;
    array-length v12, v4

    .local v12, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    :goto_2
    if-ge v7, v12, :cond_5

    aget-object v9, v4, v7

    .line 82
    .local v9, "k":Ljava/lang/String;
    invoke-virtual {v10, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, " "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 84
    .end local v9    # "k":Ljava/lang/String;
    :cond_5
    const-string/jumbo v18, "SEARCH"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mMetricIdentity:Ljava/lang/String;

    .line 86
    sget-object v18, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->getOrigin()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_6

    .line 87
    const-string/jumbo v18, "pn_search_t"

    invoke-static/range {v18 .. v18}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    :cond_6
    move-object/from16 v3, p1

    .line 89
    check-cast v3, Lcom/amazon/mShop/AmazonActivity;

    .line 90
    .local v3, "activity":Lcom/amazon/mShop/AmazonActivity;
    new-instance v18, Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-object/from16 v0, v18

    invoke-direct {v0, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    invoke-virtual {v6}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->refmarker(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    const/high16 v19, 0x80000

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/search/SearchIntentBuilder;->extraFlag(I)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v17

    .line 96
    .local v17, "searchIntent":Landroid/content/Intent;
    move-object/from16 v0, v17

    invoke-static {v3, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    goto/16 :goto_1

    .line 103
    .end local v3    # "activity":Lcom/amazon/mShop/AmazonActivity;
    .end local v4    # "arr$":[Ljava/lang/String;
    .end local v7    # "i$":I
    .end local v10    # "keyword":Ljava/lang/StringBuilder;
    .end local v11    # "keywords":[Ljava/lang/String;
    .end local v12    # "len$":I
    .end local v17    # "searchIntent":Landroid/content/Intent;
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mUri:Landroid/net/Uri;

    move-object/from16 v18, v0

    const-string/jumbo v19, "searchtype"

    invoke-virtual/range {v18 .. v19}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 104
    invoke-static {v15}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v18

    if-nez v18, :cond_2

    .line 105
    new-instance v8, Landroid/content/Intent;

    const-class v18, Lcom/amazon/mShop/search/SearchActivity;

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-direct {v8, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 106
    .local v8, "intent":Landroid/content/Intent;
    const-string/jumbo v18, "android.intent.action.VIEW"

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 107
    const-string/jumbo v18, "barcode"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_9

    .line 108
    const-string/jumbo v18, "barcode"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mMetricIdentity:Ljava/lang/String;

    .line 109
    sget-object v18, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->getOrigin()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_8

    .line 110
    const-string/jumbo v18, "pn_barcode_t"

    invoke-static/range {v18 .. v18}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 112
    :cond_8
    const-string/jumbo v18, "barcodeActivatedFromDeepLink"

    const/16 v19, 0x1

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v8, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 113
    const-string/jumbo v18, "BARCODE_SEARCH_QUERY_KEYWORD"

    invoke-static/range {v18 .. v18}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 114
    move-object/from16 v0, p1

    invoke-virtual {v0, v8}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 115
    :cond_9
    const-string/jumbo v18, "flow"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_c

    .line 116
    const-string/jumbo v18, "flow"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mMetricIdentity:Ljava/lang/String;

    .line 117
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/util/ActivityUtils;->isFlowEnabled(Landroid/content/Context;)Z

    move-result v18

    if-eqz v18, :cond_b

    .line 118
    sget-object v18, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->getOrigin()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_a

    .line 119
    const-string/jumbo v18, "pn_flow_t"

    invoke-static/range {v18 .. v18}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 121
    :cond_a
    const-string/jumbo v18, "flowActivatedFromDeepLink"

    const/16 v19, 0x1

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v8, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 122
    const-string/jumbo v18, "IMAGE_SEARCH_QUERY_KEYWORD"

    invoke-static/range {v18 .. v18}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 123
    move-object/from16 v0, p1

    invoke-virtual {v0, v8}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 125
    :cond_b
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    sget v19, Lcom/amazon/mShop/android/lib/R$string;->view_it_flow_not_support:I

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v18

    const/16 v19, 0x1

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/widget/Toast;->show()V

    goto/16 :goto_1

    .line 127
    :cond_c
    const-string/jumbo v18, "searchEntry"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_2

    .line 128
    const-string/jumbo v18, "searchEntry"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mMetricIdentity:Ljava/lang/String;

    move-object/from16 v3, p1

    .line 129
    check-cast v3, Lcom/amazon/mShop/AmazonActivity;

    .line 130
    .restart local v3    # "activity":Lcom/amazon/mShop/AmazonActivity;
    new-instance v18, Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-object/from16 v0, v18

    invoke-direct {v0, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    const/16 v19, 0x1

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/search/SearchIntentBuilder;->showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    const/16 v19, 0x0

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/search/SearchIntentBuilder;->selectInitialQuery(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    invoke-virtual {v6}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->refmarker(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    const/high16 v19, 0x80000

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/search/SearchIntentBuilder;->extraFlag(I)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v17

    .line 137
    .restart local v17    # "searchIntent":Landroid/content/Intent;
    move-object/from16 v0, v17

    invoke-static {v3, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    goto/16 :goto_1
.end method

.method public getMetricIdentity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/ProductURLProcessor;->mMetricIdentity:Ljava/lang/String;

    return-object v0
.end method
