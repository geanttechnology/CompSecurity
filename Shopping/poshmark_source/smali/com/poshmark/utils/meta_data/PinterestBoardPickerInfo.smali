.class public Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;
.super Ljava/lang/Object;
.source "PinterestBoardPickerInfo.java"


# instance fields
.field public allboards:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/utils/meta_data/PinterestBoard;",
            ">;"
        }
    .end annotation
.end field

.field public currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->allboards:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public getAllboards()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/utils/meta_data/PinterestBoard;",
            ">;"
        }
    .end annotation

    .prologue
    .line 14
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->allboards:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentSelection()Lcom/poshmark/utils/meta_data/PinterestBoard;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    return-object v0
.end method

.method public setAllboards(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/utils/meta_data/PinterestBoard;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 18
    .local p1, "allboards":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/utils/meta_data/PinterestBoard;>;"
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->allboards:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 19
    return-void
.end method

.method public setCurrentSelection(Lcom/poshmark/utils/meta_data/PinterestBoard;)V
    .locals 0
    .param p1, "currentSelection"    # Lcom/poshmark/utils/meta_data/PinterestBoard;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 27
    return-void
.end method
