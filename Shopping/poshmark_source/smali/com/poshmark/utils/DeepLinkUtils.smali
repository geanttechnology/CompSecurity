.class public Lcom/poshmark/utils/DeepLinkUtils;
.super Ljava/lang/Object;
.source "DeepLinkUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/DeepLinkUtils$1;,
        Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;,
        Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 623
    return-void
.end method

.method public static constructMappDestinationUrl(Landroid/net/Uri;)Ljava/lang/String;
    .locals 8
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 415
    const/4 v5, 0x0

    .line 416
    .local v5, "url":Ljava/lang/String;
    new-instance v2, Ljava/lang/String;

    const-string v6, ""

    invoke-direct {v2, v6}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 417
    .local v2, "params":Ljava/lang/String;
    if-eqz p0, :cond_2

    .line 418
    invoke-virtual {p0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v3

    .line 420
    .local v3, "path":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/net/Uri;->getQueryParameterNames()Ljava/util/Set;

    move-result-object v4

    .line 421
    .local v4, "queryParams":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-eqz v4, :cond_1

    .line 422
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 423
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 424
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "?"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 426
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 427
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 428
    .local v1, "key":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 429
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 430
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 431
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 432
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "&"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 437
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "https://www.poshmark.com/mapp"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 439
    .end local v3    # "path":Ljava/lang/String;
    .end local v4    # "queryParams":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_2
    return-object v5
.end method

.method public static extractIdFromString(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    const/4 v5, -0x1

    .line 382
    const/4 v0, 0x0

    .line 383
    .local v0, "Id":Ljava/lang/String;
    const-string v4, "_"

    invoke-virtual {p0, v4}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v3

    .line 384
    .local v3, "underscoreIndex":I
    const-string v4, "-"

    invoke-virtual {p0, v4}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    .line 385
    .local v1, "hyphenIndex":I
    const/4 v2, -0x1

    .line 387
    .local v2, "index":I
    if-eq v3, v5, :cond_3

    if-eq v1, v5, :cond_3

    .line 388
    if-le v3, v1, :cond_2

    .line 389
    move v2, v3

    .line 402
    :cond_0
    :goto_0
    if-eq v2, v5, :cond_1

    .line 403
    add-int/lit8 v4, v2, 0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 404
    if-nez v0, :cond_5

    .line 410
    .end local p0    # "source":Ljava/lang/String;
    :cond_1
    :goto_1
    return-object p0

    .line 391
    .restart local p0    # "source":Ljava/lang/String;
    :cond_2
    move v2, v1

    goto :goto_0

    .line 394
    :cond_3
    if-eq v3, v5, :cond_4

    .line 396
    move v2, v3

    .line 397
    add-int/lit8 v4, v3, 0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 398
    :cond_4
    if-eq v1, v5, :cond_0

    .line 399
    move v2, v1

    goto :goto_0

    :cond_5
    move-object p0, v0

    .line 407
    goto :goto_1
.end method

.method public static fixCategorySubCategoryInfoInModel(Lcom/poshmark/utils/SearchFilterModel;)V
    .locals 8
    .param p0, "model"    # Lcom/poshmark/utils/SearchFilterModel;

    .prologue
    .line 484
    if-eqz p0, :cond_3

    .line 485
    const/4 v1, 0x0

    .line 486
    .local v1, "categoryMeta":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {p0}, Lcom/poshmark/utils/SearchFilterModel;->getCategory()Ljava/lang/String;

    move-result-object v0

    .line 487
    .local v0, "category":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 488
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getCurrentCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    .line 489
    if-nez v1, :cond_0

    .line 490
    invoke-static {v0}, Lcom/poshmark/db/DbApi;->getCurrentCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    .line 494
    :cond_0
    if-eqz v1, :cond_3

    .line 495
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, v7}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 497
    invoke-virtual {p0}, Lcom/poshmark/utils/SearchFilterModel;->getSubCategories()Ljava/util/List;

    move-result-object v6

    .line 498
    .local v6, "subCategories":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v6, :cond_3

    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_3

    .line 500
    const/4 v7, 0x0

    invoke-interface {v6, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 501
    .local v3, "subCat":Ljava/lang/String;
    invoke-static {v3}, Lcom/poshmark/db/DbApi;->getSubCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v5

    .line 502
    .local v5, "subCatMeta":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v5, :cond_4

    .line 504
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 505
    .local v4, "subCatIdList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v4, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 506
    const/4 v2, 0x1

    .local v2, "i":I
    :goto_0
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v7

    if-ge v2, v7, :cond_2

    .line 507
    invoke-interface {v6, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "subCat":Ljava/lang/String;
    check-cast v3, Ljava/lang/String;

    .line 508
    .restart local v3    # "subCat":Ljava/lang/String;
    invoke-static {v3}, Lcom/poshmark/db/DbApi;->getSubCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v5

    .line 509
    if-eqz v5, :cond_1

    .line 510
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v4, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 506
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 513
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/utils/SearchFilterModel;->clearSubCategories()V

    .line 514
    invoke-virtual {p0, v4}, Lcom/poshmark/utils/SearchFilterModel;->setSubCategoryList(Ljava/util/List;)V

    .line 536
    .end local v0    # "category":Ljava/lang/String;
    .end local v1    # "categoryMeta":Lcom/poshmark/data_model/models/MetaItem;
    .end local v2    # "i":I
    .end local v3    # "subCat":Ljava/lang/String;
    .end local v4    # "subCatIdList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v5    # "subCatMeta":Lcom/poshmark/data_model/models/MetaItem;
    .end local v6    # "subCategories":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_3
    :goto_1
    return-void

    .line 517
    .restart local v0    # "category":Ljava/lang/String;
    .restart local v1    # "categoryMeta":Lcom/poshmark/data_model/models/MetaItem;
    .restart local v3    # "subCat":Ljava/lang/String;
    .restart local v5    # "subCatMeta":Lcom/poshmark/data_model/models/MetaItem;
    .restart local v6    # "subCategories":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_4
    invoke-static {v3}, Lcom/poshmark/db/DbApi;->getSubCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v5

    .line 518
    if-eqz v5, :cond_3

    .line 520
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 521
    .restart local v4    # "subCatIdList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v4, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 522
    const/4 v2, 0x1

    .restart local v2    # "i":I
    :goto_2
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v7

    if-ge v2, v7, :cond_6

    .line 523
    invoke-interface {v6, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "subCat":Ljava/lang/String;
    check-cast v3, Ljava/lang/String;

    .line 524
    .restart local v3    # "subCat":Ljava/lang/String;
    invoke-static {v3}, Lcom/poshmark/db/DbApi;->getSubCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v5

    .line 525
    if-eqz v5, :cond_5

    .line 526
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v4, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 522
    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 529
    :cond_6
    invoke-virtual {p0}, Lcom/poshmark/utils/SearchFilterModel;->clearSubCategories()V

    .line 530
    invoke-virtual {p0, v4}, Lcom/poshmark/utils/SearchFilterModel;->setSubCategoryList(Ljava/util/List;)V

    goto :goto_1
.end method

.method public static getDeepLinkDestination(Landroid/net/Uri;)Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;
    .locals 5
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v4, 0x1

    .line 554
    invoke-virtual {p0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 555
    .local v0, "destination":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v1

    .line 557
    .local v1, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const v2, 0x7f0600a5

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    const v2, 0x7f0600a6

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 558
    :cond_0
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->LISTING_DETAILS:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 615
    :goto_0
    return-object v2

    .line 559
    :cond_1
    const v2, 0x7f0600ad

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 560
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->PARTY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto :goto_0

    .line 561
    :cond_2
    const v2, 0x7f0600ab

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 562
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->PARTIES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto :goto_0

    .line 563
    :cond_3
    const v2, 0x7f0600ac

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 564
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_4

    .line 565
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->PARTIES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto :goto_0

    .line 567
    :cond_4
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->PARTY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto :goto_0

    .line 569
    :cond_5
    const v2, 0x7f0600b3

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 570
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHOP:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto :goto_0

    .line 571
    :cond_6
    const v2, 0x7f0600a4

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 572
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->CLOSET:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto :goto_0

    .line 573
    :cond_7
    const v2, 0x7f0602ba

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 574
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-ne v2, v4, :cond_8

    .line 575
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->CLOSET:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto :goto_0

    .line 576
    :cond_8
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_16

    .line 577
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const v3, 0x7f060218

    invoke-static {v3}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 578
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->CLOSET:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 579
    :cond_9
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const v3, 0x7f06025b

    invoke-static {v3}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_16

    .line 580
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHARES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 583
    :cond_a
    const v2, 0x7f0600aa

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 584
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->NEWS:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 585
    :cond_b
    const v2, 0x7f0600b4

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 586
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHOWROOM:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 587
    :cond_c
    const v2, 0x7f0600b5

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 588
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-ne v2, v4, :cond_16

    .line 589
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHOWROOM:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 591
    :cond_d
    const v2, 0x7f0600b2

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_e

    .line 592
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SEARCH_KEYWORD:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 593
    :cond_e
    const v2, 0x7f0600b0

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_f

    .line 594
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->BRAND_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 595
    :cond_f
    const v2, 0x7f0600b1

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_10

    .line 596
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SEARCH_CATEGORY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 597
    :cond_10
    const v2, 0x7f0600a3

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_12

    .line 598
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lt v2, v4, :cond_11

    .line 599
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->BRAND_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 601
    :cond_11
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->BRAND_PICKER:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 603
    :cond_12
    const v2, 0x7f0600ae

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_13

    .line 604
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-ne v2, v4, :cond_16

    .line 605
    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const v3, 0x7f0600af

    invoke-static {v3}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_16

    .line 606
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->FIND_PEOPLE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 608
    :cond_13
    const v2, 0x7f0600a7

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_14

    .line 609
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MAPP_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 610
    :cond_14
    const v2, 0x7f0600a9

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_15

    .line 611
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MYLIKES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 612
    :cond_15
    const v2, 0x7f0600a8

    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getStringResource(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_16

    .line 613
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MYBUNDLES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0

    .line 615
    :cond_16
    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->INVALID:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    goto/16 :goto_0
.end method

.method public static getDeepLinkHash()Ljava/util/Map;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 628
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 630
    .local v1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->getCurrentDeepLinkProcessingState()Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    move-result-object v2

    sget-object v3, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;->DL_EXPIRED:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    if-eq v2, v3, :cond_0

    .line 631
    sget-object v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->getDeepLinkUrl()Ljava/lang/String;

    move-result-object v0

    .line 632
    .local v0, "deepLink":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 633
    const-string v2, "fbdl"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 637
    .end local v0    # "deepLink":Ljava/lang/String;
    :cond_0
    sget-object v2, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/DeferredDeepLinkManager;->getCurrentDeepLinkProcessingState()Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    move-result-object v2

    sget-object v3, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_EXPIRED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    if-eq v2, v3, :cond_1

    .line 638
    sget-object v2, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/DeferredDeepLinkManager;->getBranchDeepLinkJson()Ljava/lang/String;

    move-result-object v0

    .line 639
    .restart local v0    # "deepLink":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 640
    const-string v2, "brhdl"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 644
    .end local v0    # "deepLink":Ljava/lang/String;
    :cond_1
    sget-object v2, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/DeferredDeepLinkManager;->getCurrentDeepLinkProcessingState()Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    move-result-object v2

    sget-object v3, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_EXPIRED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    if-eq v2, v3, :cond_2

    .line 645
    sget-object v2, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/DeferredDeepLinkManager;->getDirectDeepLinkJson()Ljava/lang/String;

    move-result-object v0

    .line 646
    .restart local v0    # "deepLink":Ljava/lang/String;
    if-eqz v0, :cond_2

    .line 647
    const-string v2, "drct"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 650
    .end local v0    # "deepLink":Ljava/lang/String;
    :cond_2
    return-object v1
.end method

.method public static getDeepLinkLaunchInfo(Landroid/net/Uri;)Lcom/poshmark/utils/DeepLinkLaunchInfo;
    .locals 28
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 108
    const/4 v14, 0x0

    .line 110
    .local v14, "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const/4 v3, 0x0

    .line 111
    .local v3, "b":Landroid/os/Bundle;
    const/16 v22, 0x0

    .line 112
    .local v22, "searchTrigger":Landroid/os/Bundle;
    const/16 v17, 0x0

    .line 113
    .local v17, "model":Lcom/poshmark/utils/SearchFilterModel;
    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v21

    .line 114
    .local v21, "scheme":Ljava/lang/String;
    invoke-virtual/range {v21 .. v21}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v26

    const v27, 0x7f0600b6

    invoke-virtual/range {v26 .. v27}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v25 .. v26}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_0

    .line 116
    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v20

    .line 118
    .local v20, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static/range {p0 .. p0}, Lcom/poshmark/utils/DeepLinkUtils;->getDeepLinkDestination(Landroid/net/Uri;)Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    move-result-object v10

    .line 119
    .local v10, "destination":Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;
    sget-object v25, Lcom/poshmark/utils/DeepLinkUtils$1;->$SwitchMap$com$poshmark$utils$DeepLinkUtils$DEEPLINK_DESTINATION:[I

    invoke-virtual {v10}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->ordinal()I

    move-result v26

    aget v25, v25, v26

    packed-switch v25, :pswitch_data_0

    .line 378
    .end local v10    # "destination":Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;
    .end local v20    # "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    return-object v14

    .line 121
    .restart local v10    # "destination":Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;
    .restart local v20    # "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :pswitch_0
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 122
    .local v15, "listingId":Ljava/lang/String;
    const-string v25, "banner"

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 123
    .local v4, "bannerJson":Ljava/lang/String;
    if-eqz v15, :cond_0

    .line 124
    invoke-static {v15}, Lcom/poshmark/utils/DeepLinkUtils;->extractIdFromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 125
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 126
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "ID"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    if-eqz v4, :cond_1

    .line 128
    const-string v25, "banner_json"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    :cond_1
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const/16 v26, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto :goto_0

    .line 135
    .end local v4    # "bannerJson":Ljava/lang/String;
    .end local v15    # "listingId":Ljava/lang/String;
    :pswitch_1
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    .line 136
    .local v19, "partyId":Ljava/lang/String;
    if-eqz v19, :cond_0

    .line 137
    invoke-static/range {v19 .. v19}, Lcom/poshmark/utils/DeepLinkUtils;->extractIdFromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 138
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/poshmark/controllers/GlobalPartiesController;->getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v11

    .line 139
    .local v11, "event":Lcom/poshmark/data_model/models/PartyEvent;
    if-eqz v11, :cond_0

    .line 140
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 141
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "ID"

    move-object/from16 v0, v25

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    invoke-virtual {v11}, Lcom/poshmark/data_model/models/PartyEvent;->isFutureEvent()Z

    move-result v25

    if-eqz v25, :cond_2

    .line 144
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/PartyInviteFragment;

    move-object/from16 v0, v25

    invoke-direct {v14, v3, v0, v11}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto :goto_0

    .line 146
    :cond_2
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/PartyFragment;

    move-object/from16 v0, v25

    invoke-direct {v14, v3, v0, v11}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 153
    .end local v11    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    .end local v19    # "partyId":Ljava/lang/String;
    :pswitch_2
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    invoke-direct {v14}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>()V

    .line 154
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const/16 v25, 0x1

    move/from16 v0, v25

    invoke-virtual {v14, v0}, Lcom/poshmark/utils/DeepLinkLaunchInfo;->setTabSwitch(I)V

    goto/16 :goto_0

    .line 157
    :pswitch_3
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    invoke-direct {v14}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>()V

    .line 158
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const/16 v25, 0x1

    move/from16 v0, v25

    invoke-virtual {v14, v0}, Lcom/poshmark/utils/DeepLinkLaunchInfo;->setTabSwitch(I)V

    goto/16 :goto_0

    .line 161
    :pswitch_4
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/lang/String;

    .line 162
    .local v24, "userId":Ljava/lang/String;
    if-eqz v24, :cond_0

    .line 163
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 164
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "NAME"

    move-object/from16 v0, v25

    move-object/from16 v1, v24

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/ClosetFragment;

    const/16 v26, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 170
    .end local v24    # "userId":Ljava/lang/String;
    :pswitch_5
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    invoke-direct {v14}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>()V

    .line 171
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const/16 v25, 0x3

    move/from16 v0, v25

    invoke-virtual {v14, v0}, Lcom/poshmark/utils/DeepLinkLaunchInfo;->setTabSwitch(I)V

    goto/16 :goto_0

    .line 174
    :pswitch_6
    const-string v25, "request"

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 175
    .local v13, "json":Ljava/lang/String;
    if-eqz v13, :cond_3

    .line 176
    invoke-static {v13}, Lcom/poshmark/utils/DeepLinkUtils;->handleSearchJSON(Ljava/lang/String;)Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v17

    .line 177
    invoke-static/range {v17 .. v17}, Lcom/poshmark/utils/DeepLinkUtils;->fixCategorySubCategoryInfoInModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 179
    :cond_3
    if-eqz v17, :cond_4

    .line 180
    const-string v25, "brand"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 181
    const-string v25, "category_v2"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 182
    const-string v25, "size"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 185
    :cond_4
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Ljava/lang/String;

    .line 186
    .local v23, "showroomId":Ljava/lang/String;
    if-eqz v23, :cond_0

    .line 187
    invoke-static/range {v23 .. v23}, Lcom/poshmark/utils/DeepLinkUtils;->extractIdFromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 188
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 189
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "ID"

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/ShowroomFragment;

    move-object/from16 v0, v25

    move-object/from16 v1, v17

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 194
    .end local v13    # "json":Ljava/lang/String;
    .end local v23    # "showroomId":Ljava/lang/String;
    :pswitch_7
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/lang/String;

    .line 195
    .restart local v24    # "userId":Ljava/lang/String;
    if-eqz v24, :cond_0

    .line 196
    invoke-static/range {v24 .. v24}, Lcom/poshmark/utils/DeepLinkUtils;->extractIdFromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 197
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 198
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "NAME"

    move-object/from16 v0, v25

    move-object/from16 v1, v24

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/UserSharesFragment;

    const/16 v26, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 204
    .end local v24    # "userId":Ljava/lang/String;
    :pswitch_8
    const-string v25, "request"

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 205
    .restart local v13    # "json":Ljava/lang/String;
    if-eqz v13, :cond_0

    .line 206
    invoke-static {v13}, Lcom/poshmark/utils/DeepLinkUtils;->handleSearchJSON(Ljava/lang/String;)Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v17

    .line 207
    invoke-static/range {v17 .. v17}, Lcom/poshmark/utils/DeepLinkUtils;->fixCategorySubCategoryInfoInModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 208
    if-eqz v17, :cond_0

    .line 209
    new-instance v22, Landroid/os/Bundle;

    .end local v22    # "searchTrigger":Landroid/os/Bundle;
    invoke-direct/range {v22 .. v22}, Landroid/os/Bundle;-><init>()V

    .line 210
    .restart local v22    # "searchTrigger":Landroid/os/Bundle;
    const-string v25, "SEARCH_TRIGGER"

    const-string v26, "sl"

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    const-string v25, "KEYWORD_SOURCE"

    const-string v26, "dl"

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;->getQueryText()Ljava/lang/String;

    move-result-object v25

    if-eqz v25, :cond_5

    .line 213
    new-instance v18, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    invoke-direct/range {v18 .. v18}, Lcom/poshmark/data_model/models/SuggestedSearchItem;-><init>()V

    .line 214
    .local v18, "newSearchItem":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;->getQueryText()Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, v18

    iput-object v0, v1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    .line 215
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v25

    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    move-object/from16 v26, v0

    invoke-virtual/range {v25 .. v26}, Lcom/poshmark/controllers/GlobalDbController;->addNewSearchToSavedSearches(Ljava/lang/String;)V

    .line 217
    .end local v18    # "newSearchItem":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    :cond_5
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    move-object/from16 v2, v17

    invoke-direct {v14, v0, v1, v2}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 218
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const/16 v25, 0x1

    move/from16 v0, v25

    invoke-virtual {v14, v0}, Lcom/poshmark/utils/DeepLinkLaunchInfo;->setTabSwitch(I)V

    goto/16 :goto_0

    .line 224
    .end local v13    # "json":Ljava/lang/String;
    :pswitch_9
    const-string v25, "request"

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 225
    .restart local v13    # "json":Ljava/lang/String;
    if-eqz v13, :cond_6

    .line 226
    invoke-static {v13}, Lcom/poshmark/utils/DeepLinkUtils;->handleSearchJSON(Ljava/lang/String;)Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v17

    .line 227
    invoke-static/range {v17 .. v17}, Lcom/poshmark/utils/DeepLinkUtils;->fixCategorySubCategoryInfoInModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 232
    :goto_1
    if-eqz v17, :cond_0

    .line 233
    const-string v25, "br"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 234
    const-string v25, "category_v2"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 235
    const-string v25, "size"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 238
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 239
    .local v6, "brandName":Ljava/lang/String;
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 240
    .local v5, "brandList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v5, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 241
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;->clearBrand()V

    .line 242
    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Lcom/poshmark/utils/SearchFilterModel;->setBrand(Ljava/util/List;)V

    .line 243
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearBrandList()V

    .line 245
    invoke-static {v6}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 246
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 247
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "NAME"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/BrandFragment;

    move-object/from16 v0, v25

    move-object/from16 v1, v17

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 249
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 229
    .end local v5    # "brandList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "brandName":Ljava/lang/String;
    :cond_6
    new-instance v17, Lcom/poshmark/utils/SearchFilterModel;

    .end local v17    # "model":Lcom/poshmark/utils/SearchFilterModel;
    invoke-direct/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 230
    .restart local v17    # "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v25, "available"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    goto :goto_1

    .line 253
    .end local v13    # "json":Ljava/lang/String;
    :pswitch_a
    const-string v25, "request"

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 254
    .restart local v13    # "json":Ljava/lang/String;
    if-eqz v13, :cond_7

    .line 255
    invoke-static {v13}, Lcom/poshmark/utils/DeepLinkUtils;->handleSearchJSON(Ljava/lang/String;)Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v17

    .line 260
    :goto_2
    if-eqz v17, :cond_0

    .line 261
    const-string v25, "ct"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 262
    const-string v25, "brand"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 263
    const-string v25, "size"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 267
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 268
    .local v9, "categoryName":Ljava/lang/String;
    invoke-static {v9}, Lcom/poshmark/db/DbApi;->getCurrentCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v8

    .line 269
    .local v8, "category":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v8, :cond_8

    .line 270
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;->clearCategory()V

    .line 271
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 276
    :goto_3
    invoke-static/range {v17 .. v17}, Lcom/poshmark/utils/DeepLinkUtils;->fixCategorySubCategoryInfoInModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 277
    new-instance v22, Landroid/os/Bundle;

    .end local v22    # "searchTrigger":Landroid/os/Bundle;
    invoke-direct/range {v22 .. v22}, Landroid/os/Bundle;-><init>()V

    .line 278
    .restart local v22    # "searchTrigger":Landroid/os/Bundle;
    const-string v25, "SEARCH_TRIGGER"

    const-string v26, "ct"

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 279
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    move-object/from16 v2, v17

    invoke-direct {v14, v0, v1, v2}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 280
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const/16 v25, 0x1

    move/from16 v0, v25

    invoke-virtual {v14, v0}, Lcom/poshmark/utils/DeepLinkLaunchInfo;->setTabSwitch(I)V

    goto/16 :goto_0

    .line 257
    .end local v8    # "category":Lcom/poshmark/data_model/models/MetaItem;
    .end local v9    # "categoryName":Ljava/lang/String;
    :cond_7
    new-instance v17, Lcom/poshmark/utils/SearchFilterModel;

    .end local v17    # "model":Lcom/poshmark/utils/SearchFilterModel;
    invoke-direct/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 258
    .restart local v17    # "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v25, "available"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    goto :goto_2

    .line 273
    .restart local v8    # "category":Lcom/poshmark/data_model/models/MetaItem;
    .restart local v9    # "categoryName":Ljava/lang/String;
    :cond_8
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;->clearCategory()V

    .line 274
    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    goto :goto_3

    .line 285
    .end local v8    # "category":Lcom/poshmark/data_model/models/MetaItem;
    .end local v9    # "categoryName":Ljava/lang/String;
    .end local v13    # "json":Ljava/lang/String;
    :pswitch_b
    invoke-static/range {p0 .. p0}, Lcom/poshmark/utils/DeepLinkUtils;->constructMappDestinationUrl(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v16

    .line 286
    .local v16, "mappUrl":Ljava/lang/String;
    if-eqz v16, :cond_0

    .line 287
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 288
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "URL"

    move-object/from16 v0, v25

    move-object/from16 v1, v16

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 289
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/16 v26, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 295
    .end local v16    # "mappUrl":Ljava/lang/String;
    :pswitch_c
    const-string v25, "request"

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 296
    .restart local v13    # "json":Ljava/lang/String;
    if-eqz v13, :cond_9

    .line 297
    invoke-static {v13}, Lcom/poshmark/utils/DeepLinkUtils;->handleSearchJSON(Ljava/lang/String;)Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v17

    .line 298
    invoke-static/range {v17 .. v17}, Lcom/poshmark/utils/DeepLinkUtils;->fixCategorySubCategoryInfoInModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 303
    :goto_4
    if-eqz v17, :cond_0

    .line 304
    const-string v25, "category_v2"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 305
    const-string v25, "size"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 306
    const-string v25, "brand"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 307
    const-string v25, "mlk"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 309
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/MyLikesFragment;

    move-object/from16 v0, v25

    move-object/from16 v1, v17

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 300
    :cond_9
    new-instance v17, Lcom/poshmark/utils/SearchFilterModel;

    .end local v17    # "model":Lcom/poshmark/utils/SearchFilterModel;
    invoke-direct/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 301
    .restart local v17    # "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v25, "available"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    goto :goto_4

    .line 314
    .end local v13    # "json":Ljava/lang/String;
    :pswitch_d
    new-instance v12, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    invoke-direct {v12}, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;-><init>()V

    .line 315
    .local v12, "initInfo":Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;
    iget-object v0, v12, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    move-object/from16 v25, v0

    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Lcom/poshmark/controllers/GlobalDbController;->getAllBrands()Ljava/util/List;

    move-result-object v26

    invoke-interface/range {v25 .. v26}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 316
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 317
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "SHOW_ALL"

    const/16 v26, 0x0

    move-object/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 318
    const-string v25, "META_ITEM_MODE"

    sget-object v26, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->BRAND_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual/range {v26 .. v26}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v26

    move-object/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 319
    const-string v25, "SEARCH_ENABLED"

    const/16 v26, 0x1

    move-object/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 320
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    move-object/from16 v0, v25

    invoke-direct {v14, v3, v0, v12}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 321
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 324
    .end local v12    # "initInfo":Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;
    :pswitch_e
    invoke-interface/range {v20 .. v20}, Ljava/util/List;->size()I

    move-result v25

    const/16 v26, 0x2

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_a

    .line 325
    const/16 v25, 0x1

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 326
    .local v7, "bundleUser":Ljava/lang/String;
    if-eqz v7, :cond_0

    .line 327
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 328
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "ID"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/ViewBundleFragment;

    const/16 v26, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 332
    .end local v7    # "bundleUser":Ljava/lang/String;
    :cond_a
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 333
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "MODE"

    sget-object v26, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    invoke-virtual/range {v26 .. v26}, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->name()Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/MyLikesFragment;

    move-object/from16 v0, v25

    move-object/from16 v1, v17

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 336
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 339
    :pswitch_f
    const-string v25, "request"

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 340
    .restart local v13    # "json":Ljava/lang/String;
    if-eqz v13, :cond_b

    .line 341
    invoke-static {v13}, Lcom/poshmark/utils/DeepLinkUtils;->handleSearchJSON(Ljava/lang/String;)Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v17

    .line 342
    invoke-static/range {v17 .. v17}, Lcom/poshmark/utils/DeepLinkUtils;->fixCategorySubCategoryInfoInModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 344
    :cond_b
    if-eqz v17, :cond_c

    .line 345
    const-string v25, "br"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 346
    const-string v25, "category_v2"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 347
    const-string v25, "size"

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 350
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 351
    .restart local v6    # "brandName":Ljava/lang/String;
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 352
    .restart local v5    # "brandList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v5, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 353
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;->clearBrand()V

    .line 354
    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Lcom/poshmark/utils/SearchFilterModel;->setBrand(Ljava/util/List;)V

    .line 355
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->clearBrandList()V

    .line 357
    invoke-static {v6}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 358
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 359
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "NAME"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 360
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/BrandFragment;

    move-object/from16 v0, v25

    move-object/from16 v1, v17

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 361
    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 362
    .end local v5    # "brandList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "brandName":Ljava/lang/String;
    :cond_c
    const/16 v25, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v25

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 363
    .restart local v6    # "brandName":Ljava/lang/String;
    if-eqz v6, :cond_0

    .line 364
    invoke-static {v6}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 365
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 366
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v25, "NAME"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 367
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const-class v25, Lcom/poshmark/ui/fragments/BrandFragment;

    const/16 v26, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v14, v3, v0, v1}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 373
    .end local v6    # "brandName":Ljava/lang/String;
    .end local v13    # "json":Ljava/lang/String;
    :pswitch_10
    new-instance v14, Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .end local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    const/16 v25, 0x0

    const-class v26, Lcom/poshmark/ui/fragments/FindPeopleFragment;

    const/16 v27, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    move-object/from16 v2, v27

    invoke-direct {v14, v0, v1, v2}, Lcom/poshmark/utils/DeepLinkLaunchInfo;-><init>(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .restart local v14    # "launchInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    goto/16 :goto_0

    .line 119
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
    .end packed-switch
.end method

.method public static getStringResource(I)Ljava/lang/String;
    .locals 1
    .param p0, "id"    # I

    .prologue
    .line 620
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static handleFbDeferredDeepLinkJSON(Ljava/lang/String;)Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;
    .locals 6
    .param p0, "json"    # Ljava/lang/String;

    .prologue
    .line 541
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 542
    .local v2, "lastChar":C
    const/16 v4, 0x2f

    if-ne v2, v4, :cond_0

    .line 543
    const/4 v4, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {p0, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    .line 545
    :cond_0
    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    .line 546
    .local v1, "gson":Lcom/google/gson/Gson;
    const-class v4, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;

    instance-of v5, v1, Lcom/google/gson/Gson;

    if-nez v5, :cond_1

    invoke-virtual {v1, p0, v4}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    .end local v1    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v3, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;

    .line 549
    .end local v2    # "lastChar":C
    :goto_1
    return-object v3

    .line 546
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    .restart local v2    # "lastChar":C
    :cond_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, p0, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Lcom/google/gson/JsonSyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 548
    .end local v2    # "lastChar":C
    :catch_0
    move-exception v0

    .line 549
    .local v0, "exception":Lcom/google/gson/JsonSyntaxException;
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static handleSearchJSON(Ljava/lang/String;)Lcom/poshmark/utils/SearchFilterModel;
    .locals 11
    .param p0, "json"    # Ljava/lang/String;

    .prologue
    .line 445
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-virtual {p0, v9}, Ljava/lang/String;->charAt(I)C

    move-result v5

    .line 446
    .local v5, "lastChar":C
    const/16 v9, 0x2f

    if-ne v5, v9, :cond_0

    .line 447
    const/4 v9, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v10

    add-int/lit8 v10, v10, -0x1

    invoke-virtual {p0, v9, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    .line 449
    :cond_0
    new-instance v4, Lcom/google/gson/Gson;

    invoke-direct {v4}, Lcom/google/gson/Gson;-><init>()V

    .line 450
    .local v4, "gson":Lcom/google/gson/Gson;
    const-class v9, Lcom/poshmark/utils/SearchFilterModel;

    instance-of v10, v4, Lcom/google/gson/Gson;

    if-nez v10, :cond_4

    invoke-virtual {v4, p0, v9}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    .end local v4    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v6, Lcom/poshmark/utils/SearchFilterModel;

    .line 454
    .local v6, "model":Lcom/poshmark/utils/SearchFilterModel;
    invoke-virtual {v6}, Lcom/poshmark/utils/SearchFilterModel;->getCondition()Ljava/lang/String;

    move-result-object v2

    .line 455
    .local v2, "condition":Ljava/lang/String;
    if-eqz v2, :cond_1

    const-string v9, "nwt"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_1

    const-string v9, "ret"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 456
    invoke-virtual {v6}, Lcom/poshmark/utils/SearchFilterModel;->clearCondition()V

    .line 459
    :cond_1
    invoke-virtual {v6}, Lcom/poshmark/utils/SearchFilterModel;->getAvailability()Ljava/lang/String;

    move-result-object v0

    .line 460
    .local v0, "availability":Ljava/lang/String;
    const-string v1, "available"

    .line 461
    .local v1, "available":Ljava/lang/String;
    const-string v7, "sold_out"

    .line 462
    .local v7, "soldOut":Ljava/lang/String;
    if-eqz v0, :cond_6

    .line 463
    const-string v9, "all"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 464
    invoke-virtual {v6}, Lcom/poshmark/utils/SearchFilterModel;->clearAvailability()V

    .line 472
    :cond_2
    :goto_1
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v8

    .line 473
    .local v8, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v8, :cond_3

    iget-object v9, v8, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v9

    if-eqz v9, :cond_3

    .line 474
    const/4 v9, 0x1

    invoke-virtual {v6, v9}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 478
    .end local v0    # "availability":Ljava/lang/String;
    .end local v1    # "available":Ljava/lang/String;
    .end local v2    # "condition":Ljava/lang/String;
    .end local v5    # "lastChar":C
    .end local v6    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .end local v7    # "soldOut":Ljava/lang/String;
    .end local v8    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    :cond_3
    :goto_2
    return-object v6

    .line 450
    .restart local v4    # "gson":Lcom/google/gson/Gson;
    .restart local v5    # "lastChar":C
    :cond_4
    check-cast v4, Lcom/google/gson/Gson;

    .end local v4    # "gson":Lcom/google/gson/Gson;
    invoke-static {v4, p0, v9}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    goto :goto_0

    .line 465
    .restart local v0    # "availability":Ljava/lang/String;
    .restart local v1    # "available":Ljava/lang/String;
    .restart local v2    # "condition":Ljava/lang/String;
    .restart local v6    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .restart local v7    # "soldOut":Ljava/lang/String;
    :cond_5
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_2

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_2

    const-string v9, "all"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 466
    const-string v9, "available"

    invoke-virtual {v6, v9}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    goto :goto_1

    .line 477
    .end local v0    # "availability":Ljava/lang/String;
    .end local v1    # "available":Ljava/lang/String;
    .end local v2    # "condition":Ljava/lang/String;
    .end local v5    # "lastChar":C
    .end local v6    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .end local v7    # "soldOut":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 478
    .local v3, "exception":Lcom/google/gson/JsonSyntaxException;
    const/4 v6, 0x0

    goto :goto_2

    .line 469
    .end local v3    # "exception":Lcom/google/gson/JsonSyntaxException;
    .restart local v0    # "availability":Ljava/lang/String;
    .restart local v1    # "available":Ljava/lang/String;
    .restart local v2    # "condition":Ljava/lang/String;
    .restart local v5    # "lastChar":C
    .restart local v6    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .restart local v7    # "soldOut":Ljava/lang/String;
    :cond_6
    const-string v9, "available"

    invoke-virtual {v6, v9}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/google/gson/JsonSyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1
.end method

.method public static isValidDeepLink(Landroid/net/Uri;)Z
    .locals 4
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 99
    invoke-virtual {p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v0

    .line 100
    .local v0, "scheme":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0600b6

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 101
    const/4 v1, 0x1

    .line 103
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
