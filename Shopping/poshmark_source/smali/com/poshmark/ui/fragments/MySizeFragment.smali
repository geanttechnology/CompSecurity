.class public Lcom/poshmark/ui/fragments/MySizeFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "MySizeFragment.java"


# instance fields
.field currentDressSizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field currentJeansSizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field currentPantsSizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field currentShoeSizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field currentSweaterSizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field private denimLayout:Landroid/widget/RelativeLayout;

.field private dressesLayout:Landroid/widget/RelativeLayout;

.field isDataChanged:Z

.field private pantsLayout:Landroid/widget/RelativeLayout;

.field private shoesLayout:Landroid/widget/RelativeLayout;

.field sizeData:Lcom/poshmark/data_model/models/MySize;

.field sizeLayoutListener:Landroid/view/View$OnClickListener;

.field private sweatersLayout:Landroid/widget/RelativeLayout;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentDressSizes:Ljava/util/List;

    .line 46
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentJeansSizes:Ljava/util/List;

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentPantsSizes:Ljava/util/List;

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentShoeSizes:Ljava/util/List;

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentSweaterSizes:Ljava/util/List;

    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->isDataChanged:Z

    .line 270
    new-instance v0, Lcom/poshmark/ui/fragments/MySizeFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/MySizeFragment$3;-><init>(Lcom/poshmark/ui/fragments/MySizeFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeLayoutListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/MySizeFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MySizeFragment;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->setCurrentSelectionLists()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/MySizeFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MySizeFragment;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->setSizeValues()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/MySizeFragment;Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MySizeFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/MySizeFragment;->getCurrentSelectionsListForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private getCurrentSelectionsListForCategory(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "categoryId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 303
    const/4 v0, 0x0

    .line 305
    .local v0, "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    sget-object v1, Lcom/poshmark/db/DbApi;->DRESSES_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 306
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentDressSizes:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 316
    .restart local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    :goto_0
    return-object v0

    .line 307
    :cond_1
    sget-object v1, Lcom/poshmark/db/DbApi;->PANTS_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 308
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentPantsSizes:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .restart local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    goto :goto_0

    .line 309
    :cond_2
    sget-object v1, Lcom/poshmark/db/DbApi;->JEANS_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 310
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentJeansSizes:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .restart local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    goto :goto_0

    .line 311
    :cond_3
    sget-object v1, Lcom/poshmark/db/DbApi;->SWEATERS_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 312
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentSweaterSizes:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .restart local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    goto :goto_0

    .line 313
    :cond_4
    sget-object v1, Lcom/poshmark/db/DbApi;->SHOES_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 314
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentShoeSizes:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .restart local v0    # "newList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    goto :goto_0
.end method

.method private getMySizes()V
    .locals 3

    .prologue
    .line 115
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeData:Lcom/poshmark/data_model/models/MySize;

    if-nez v1, :cond_1

    .line 116
    const v1, 0x7f060190

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 117
    new-instance v1, Lcom/poshmark/ui/fragments/MySizeFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MySizeFragment$1;-><init>(Lcom/poshmark/ui/fragments/MySizeFragment;)V

    invoke-static {v1}, Lcom/poshmark/http/api/PMApi;->getMySize(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 168
    :cond_0
    :goto_0
    return-void

    .line 135
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->setupViews()V

    .line 136
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->setSizeValues()V

    .line 137
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->isDataChanged:Z

    if-eqz v1, :cond_0

    .line 138
    const v1, 0x7f060232

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 140
    new-instance v0, Lcom/poshmark/utils/view_holders/MultiMap;

    invoke-direct {v0}, Lcom/poshmark/utils/view_holders/MultiMap;-><init>()V

    .line 143
    .local v0, "changes":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentShoeSizes:Ljava/util/List;

    const-string v2, "shoes"

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->populateHash(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V

    .line 144
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentJeansSizes:Ljava/util/List;

    const-string v2, "denim"

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->populateHash(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V

    .line 145
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentDressSizes:Ljava/util/List;

    const-string v2, "dresses"

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->populateHash(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V

    .line 146
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentSweaterSizes:Ljava/util/List;

    const-string v2, "sweaters"

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->populateHash(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V

    .line 147
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentPantsSizes:Ljava/util/List;

    const-string v2, "pants"

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->populateHash(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V

    .line 149
    new-instance v1, Lcom/poshmark/ui/fragments/MySizeFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MySizeFragment$2;-><init>(Lcom/poshmark/ui/fragments/MySizeFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->setMySize(Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private populateHash(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V
    .locals 4
    .param p3, "label"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 320
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "changeList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 321
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 322
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 323
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "[]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 325
    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    return-void
.end method

.method private setCurrentSelectionLists()V
    .locals 3

    .prologue
    .line 205
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeData:Lcom/poshmark/data_model/models/MySize;

    iget-object v0, v0, Lcom/poshmark/data_model/models/MySize;->dresses:[Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentDressSizes:Ljava/util/List;

    sget-object v2, Lcom/poshmark/db/DbApi;->DRESSES_ID:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setSizeValues([Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V

    .line 206
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeData:Lcom/poshmark/data_model/models/MySize;

    iget-object v0, v0, Lcom/poshmark/data_model/models/MySize;->shoes:[Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentShoeSizes:Ljava/util/List;

    sget-object v2, Lcom/poshmark/db/DbApi;->SHOES_ID:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setSizeValues([Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V

    .line 207
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeData:Lcom/poshmark/data_model/models/MySize;

    iget-object v0, v0, Lcom/poshmark/data_model/models/MySize;->pants:[Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentPantsSizes:Ljava/util/List;

    sget-object v2, Lcom/poshmark/db/DbApi;->PANTS_ID:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setSizeValues([Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V

    .line 208
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeData:Lcom/poshmark/data_model/models/MySize;

    iget-object v0, v0, Lcom/poshmark/data_model/models/MySize;->sweaters:[Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentSweaterSizes:Ljava/util/List;

    sget-object v2, Lcom/poshmark/db/DbApi;->SWEATERS_ID:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setSizeValues([Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V

    .line 209
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeData:Lcom/poshmark/data_model/models/MySize;

    iget-object v0, v0, Lcom/poshmark/data_model/models/MySize;->denim:[Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentJeansSizes:Ljava/util/List;

    sget-object v2, Lcom/poshmark/db/DbApi;->JEANS_ID:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setSizeValues([Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V

    .line 210
    return-void
.end method

.method private setSizeValues()V
    .locals 2

    .prologue
    .line 213
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->dressesLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentDressSizes:Ljava/util/List;

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->setValues(Landroid/widget/RelativeLayout;Ljava/util/List;)V

    .line 214
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->denimLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentJeansSizes:Ljava/util/List;

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->setValues(Landroid/widget/RelativeLayout;Ljava/util/List;)V

    .line 215
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->pantsLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentPantsSizes:Ljava/util/List;

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->setValues(Landroid/widget/RelativeLayout;Ljava/util/List;)V

    .line 216
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sweatersLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentSweaterSizes:Ljava/util/List;

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->setValues(Landroid/widget/RelativeLayout;Ljava/util/List;)V

    .line 217
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->shoesLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentShoeSizes:Ljava/util/List;

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->setValues(Landroid/widget/RelativeLayout;Ljava/util/List;)V

    .line 218
    return-void
.end method

.method private setSizeValues([Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V
    .locals 6
    .param p1, "sizes"    # [Ljava/lang/String;
    .param p3, "categoryId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 243
    .local p2, "currentSelectedSizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-interface {p2}, Ljava/util/List;->clear()V

    .line 244
    if-eqz p1, :cond_1

    .line 245
    const-string v0, ""

    .line 248
    .local v0, "finalString":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v4, p1

    if-ge v1, v4, :cond_1

    .line 249
    aget-object v3, p1, v1

    .line 250
    .local v3, "size":Ljava/lang/String;
    invoke-static {p3, v3}, Lcom/poshmark/db/DbApi;->getSizeForCategoryFromLabel(Ljava/lang/String;Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    .line 251
    .local v2, "item":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v2, :cond_0

    .line 252
    invoke-interface {p2, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 253
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v3

    .line 255
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 256
    array-length v4, p1

    add-int/lit8 v4, v4, -0x1

    if-ge v1, v4, :cond_0

    .line 257
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 248
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 262
    .end local v0    # "finalString":Ljava/lang/String;
    .end local v1    # "i":I
    .end local v2    # "item":Lcom/poshmark/data_model/models/MetaItem;
    .end local v3    # "size":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private setTitleOfItem(Landroid/widget/RelativeLayout;Ljava/lang/String;)V
    .locals 2
    .param p1, "itemLayout"    # Landroid/widget/RelativeLayout;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 266
    const v1, 0x7f0c020c

    invoke-virtual {p1, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTextView;

    .line 267
    .local v0, "textView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v0, p2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 268
    return-void
.end method

.method private setValues(Landroid/widget/RelativeLayout;Ljava/util/List;)V
    .locals 7
    .param p1, "layout"    # Landroid/widget/RelativeLayout;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/RelativeLayout;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 220
    .local p2, "currentSizeSelections":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    const v5, 0x7f0c020d

    invoke-virtual {p1, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    .line 221
    .local v4, "textView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_2

    .line 222
    const-string v0, ""

    .line 225
    .local v0, "finalString":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v5

    if-ge v1, v5, :cond_1

    .line 226
    invoke-interface {p2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 227
    .local v2, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v3

    .line 229
    .local v3, "size":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 230
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    if-ge v1, v5, :cond_0

    .line 231
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 225
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 234
    .end local v2    # "item":Lcom/poshmark/data_model/models/MetaItem;
    .end local v3    # "size":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f090038

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 235
    invoke-virtual {v4, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 240
    .end local v0    # "finalString":Ljava/lang/String;
    .end local v1    # "i":I
    :goto_1
    return-void

    .line 237
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f09003c

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 238
    const v5, 0x7f060147

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method

.method private updateSizes(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "categoryId"    # Ljava/lang/String;
    .param p2, "jsonString"    # Ljava/lang/String;
    .param p3, "b"    # Landroid/os/Bundle;

    .prologue
    .line 288
    new-instance v0, Lcom/poshmark/ui/fragments/MySizeFragment$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/MySizeFragment$4;-><init>(Lcom/poshmark/ui/fragments/MySizeFragment;)V

    .line 289
    .local v0, "listOfObject":Lcom/google/gson/reflect/TypeToken;
    sget-object v1, Lcom/poshmark/db/DbApi;->DRESSES_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 290
    invoke-static {p2, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentDressSizes:Ljava/util/List;

    .line 300
    :cond_0
    :goto_0
    return-void

    .line 291
    :cond_1
    sget-object v1, Lcom/poshmark/db/DbApi;->PANTS_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 292
    invoke-static {p2, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentPantsSizes:Ljava/util/List;

    goto :goto_0

    .line 293
    :cond_2
    sget-object v1, Lcom/poshmark/db/DbApi;->JEANS_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 294
    invoke-static {p2, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentJeansSizes:Ljava/util/List;

    goto :goto_0

    .line 295
    :cond_3
    sget-object v1, Lcom/poshmark/db/DbApi;->SWEATERS_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 296
    invoke-static {p2, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentSweaterSizes:Ljava/util/List;

    goto :goto_0

    .line 297
    :cond_4
    sget-object v1, Lcom/poshmark/db/DbApi;->SHOES_ID:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 298
    invoke-static {p2, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->currentShoeSizes:Ljava/util/List;

    goto :goto_0
.end method


# virtual methods
.method public handleBack()Z
    .locals 1

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->isDataChanged:Z

    if-eqz v0, :cond_0

    .line 83
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 68
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 69
    const v0, 0x7f0601ba

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MySizeFragment;->setTitle(I)V

    .line 70
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 5
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 89
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 90
    const-string v3, "RETURNED_RESULTS"

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 91
    .local v0, "b":Landroid/os/Bundle;
    const/4 v3, 0x3

    if-ne p1, v3, :cond_0

    .line 92
    const-string v3, "SIZE_CHANGED"

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->isDataChanged:Z

    .line 93
    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->isDataChanged:Z

    if-eqz v3, :cond_0

    .line 95
    const-string v3, "DATA_SELECTED"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 96
    .local v2, "jsonString":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 97
    const-class v3, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v2, v3}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 98
    .local v1, "categoryMeta":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v4

    const-string v3, "SIZE_LIST"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-direct {p0, v4, v3, v0}, Lcom/poshmark/ui/fragments/MySizeFragment;->updateSizes(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 102
    .end local v1    # "categoryMeta":Lcom/poshmark/data_model/models/MetaItem;
    .end local v2    # "jsonString":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 56
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 57
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 61
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 62
    const v1, 0x7f03008e

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 63
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 1
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 106
    const/4 v0, 0x3

    if-ne p2, v0, :cond_0

    .line 107
    const-string v0, "SIZE_CHANGED"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->isDataChanged:Z

    .line 109
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 74
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onResume()V

    .line 75
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getMySizes()V

    .line 76
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 111
    const-string v0, "my_size_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 112
    return-void
.end method

.method public setupViews()V
    .locals 4

    .prologue
    .line 172
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0210

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->dressesLayout:Landroid/widget/RelativeLayout;

    .line 173
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->dressesLayout:Landroid/widget/RelativeLayout;

    const v2, 0x7f0600c1

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setTitleOfItem(Landroid/widget/RelativeLayout;Ljava/lang/String;)V

    .line 174
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->dressesLayout:Landroid/widget/RelativeLayout;

    sget-object v2, Lcom/poshmark/db/DbApi;->DRESSES_ID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setTag(Ljava/lang/Object;)V

    .line 175
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->dressesLayout:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeLayoutListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 176
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->dressesLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020024

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 178
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0213

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->shoesLayout:Landroid/widget/RelativeLayout;

    .line 179
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->shoesLayout:Landroid/widget/RelativeLayout;

    const v2, 0x7f060264

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setTitleOfItem(Landroid/widget/RelativeLayout;Ljava/lang/String;)V

    .line 180
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->shoesLayout:Landroid/widget/RelativeLayout;

    sget-object v2, Lcom/poshmark/db/DbApi;->SHOES_ID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setTag(Ljava/lang/Object;)V

    .line 181
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->shoesLayout:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeLayoutListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 183
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0212

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->pantsLayout:Landroid/widget/RelativeLayout;

    .line 184
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->pantsLayout:Landroid/widget/RelativeLayout;

    const v2, 0x7f0601ea

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setTitleOfItem(Landroid/widget/RelativeLayout;Ljava/lang/String;)V

    .line 185
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->pantsLayout:Landroid/widget/RelativeLayout;

    sget-object v2, Lcom/poshmark/db/DbApi;->PANTS_ID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setTag(Ljava/lang/Object;)V

    .line 186
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->pantsLayout:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeLayoutListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 188
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0214

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sweatersLayout:Landroid/widget/RelativeLayout;

    .line 189
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sweatersLayout:Landroid/widget/RelativeLayout;

    const v2, 0x7f060294

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setTitleOfItem(Landroid/widget/RelativeLayout;Ljava/lang/String;)V

    .line 190
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sweatersLayout:Landroid/widget/RelativeLayout;

    sget-object v2, Lcom/poshmark/db/DbApi;->SWEATERS_ID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setTag(Ljava/lang/Object;)V

    .line 191
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sweatersLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020021

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 192
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sweatersLayout:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeLayoutListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 194
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizeFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0211

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->denimLayout:Landroid/widget/RelativeLayout;

    .line 195
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->denimLayout:Landroid/widget/RelativeLayout;

    const v2, 0x7f0600bb

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->setTitleOfItem(Landroid/widget/RelativeLayout;Ljava/lang/String;)V

    .line 196
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->denimLayout:Landroid/widget/RelativeLayout;

    sget-object v2, Lcom/poshmark/db/DbApi;->JEANS_ID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setTag(Ljava/lang/Object;)V

    .line 197
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->denimLayout:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sizeLayoutListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 199
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->pantsLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v0

    .line 200
    .local v0, "padding":I
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->dressesLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0, v0, v0, v0}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 201
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment;->sweatersLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0, v0, v0, v0}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 202
    return-void
.end method
