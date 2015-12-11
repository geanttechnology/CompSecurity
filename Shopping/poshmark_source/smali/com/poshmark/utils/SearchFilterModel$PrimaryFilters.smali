.class public Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;
.super Ljava/lang/Object;
.source "SearchFilterModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/SearchFilterModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PrimaryFilters"
.end annotation


# instance fields
.field availability:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field brand:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field category_feature:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field category_v2:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field color:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field condition:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field creator_id:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field event:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/utils/SearchFilterModel;


# direct methods
.method public constructor <init>(Lcom/poshmark/utils/SearchFilterModel;)V
    .locals 0

    .prologue
    .line 470
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->this$0:Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addAvailability(Ljava/lang/String;)V
    .locals 1
    .param p1, "availabilityName"    # Ljava/lang/String;

    .prologue
    .line 517
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    if-nez v0, :cond_0

    .line 518
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    .line 522
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 523
    return-void

    .line 520
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addBrand(Ljava/lang/String;)V
    .locals 1
    .param p1, "brandName"    # Ljava/lang/String;

    .prologue
    .line 481
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    if-nez v0, :cond_0

    .line 482
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    .line 486
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 487
    return-void

    .line 484
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addCategory(Ljava/lang/String;)V
    .locals 1
    .param p1, "categoryName"    # Ljava/lang/String;

    .prologue
    .line 490
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    if-nez v0, :cond_0

    .line 491
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    .line 495
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 496
    return-void

    .line 493
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addCondition(Ljava/lang/String;)V
    .locals 1
    .param p1, "conditionName"    # Ljava/lang/String;

    .prologue
    .line 508
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    if-nez v0, :cond_0

    .line 509
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    .line 513
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 514
    return-void

    .line 511
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addEvent(Ljava/lang/String;)V
    .locals 1
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 526
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->event:Ljava/util/List;

    if-nez v0, :cond_0

    .line 527
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->event:Ljava/util/List;

    .line 531
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->event:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 532
    return-void

    .line 529
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->event:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addSubCategory(Ljava/lang/String;)V
    .locals 1
    .param p1, "subCategoryName"    # Ljava/lang/String;

    .prologue
    .line 499
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    if-nez v0, :cond_0

    .line 500
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    .line 504
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 505
    return-void

    .line 502
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public addUser(Ljava/lang/String;)V
    .locals 1
    .param p1, "userId"    # Ljava/lang/String;

    .prologue
    .line 535
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->creator_id:Ljava/util/List;

    if-nez v0, :cond_0

    .line 536
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->creator_id:Ljava/util/List;

    .line 540
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->creator_id:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 541
    return-void

    .line 538
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->creator_id:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method public clearAvailabilityList()V
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 610
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 611
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    .line 613
    :cond_0
    return-void
.end method

.method public clearBrandList()V
    .locals 1

    .prologue
    .line 581
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 582
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 583
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    .line 585
    :cond_0
    return-void
.end method

.method public clearCategoryList()V
    .locals 1

    .prologue
    .line 588
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 589
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 590
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    .line 592
    :cond_0
    return-void
.end method

.method public clearColorList()V
    .locals 1

    .prologue
    .line 629
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 630
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 631
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    .line 633
    :cond_0
    return-void
.end method

.method public clearConditionList()V
    .locals 1

    .prologue
    .line 602
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 603
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 604
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->condition:Ljava/util/List;

    .line 606
    :cond_0
    return-void
.end method

.method public clearSubCategoryList()V
    .locals 1

    .prologue
    .line 595
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 596
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 597
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    .line 599
    :cond_0
    return-void
.end method

.method public getAvailability()Ljava/lang/String;
    .locals 2

    .prologue
    .line 564
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 565
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->availability:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 567
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBrand()Ljava/lang/String;
    .locals 2

    .prologue
    .line 573
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 574
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->brand:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 576
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCategory()Ljava/lang/String;
    .locals 2

    .prologue
    .line 545
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 546
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_v2:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 548
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getColors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 625
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    return-object v0
.end method

.method public getSubCategory()Ljava/lang/String;
    .locals 2

    .prologue
    .line 553
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 554
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 556
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSubCategoryList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 561
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->category_feature:Ljava/util/List;

    return-object v0
.end method

.method public setColor(Ljava/lang/String;)V
    .locals 1
    .param p1, "color"    # Ljava/lang/String;

    .prologue
    .line 616
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    if-nez v0, :cond_0

    .line 617
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    .line 621
    :goto_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 622
    return-void

    .line 619
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->color:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method
