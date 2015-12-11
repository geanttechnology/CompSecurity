.class public Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;
.super Ljava/lang/Object;
.source "NWTOptionsMetaData.java"


# static fields
.field public static final NOT_NWT:Ljava/lang/String; = "not_nwt"

.field public static final NWT:Ljava/lang/String; = "nwt"

.field public static final RETAIL:Ljava/lang/String; = "ret"

.field public static nwtFilterOptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field public static nwtListingOptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    .line 15
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtFilterOptions:Ljava/util/List;

    .line 16
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtListingOptions:Ljava/util/List;

    .line 23
    sget-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtFilterOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "not_nwt"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f060040

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 24
    sget-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtFilterOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "nwt"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f06026b

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 25
    sget-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtFilterOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "ret"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f06026a

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 28
    sget-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtListingOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "not_nwt"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0601ce

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 29
    sget-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtListingOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "nwt"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0602cd

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 30
    sget-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtListingOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "ret"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0602ce

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 32
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method

.method public static getConditionMetaItemForFilters(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 3
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 37
    sget-object v2, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtFilterOptions:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 38
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 39
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 40
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 45
    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getConditionMetaItemForListingFlow(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 3
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 49
    sget-object v2, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtListingOptions:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 50
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 51
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 52
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 57
    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getConditionMetaItemsForFilters()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    sget-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtFilterOptions:Ljava/util/List;

    return-object v0
.end method

.method public static getConditionMetaItemsForListingFlow()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 65
    sget-object v0, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->nwtFilterOptions:Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method public getAllConditionMetaItemForFilters()Lcom/poshmark/data_model/models/MetaItem;
    .locals 4

    .prologue
    .line 69
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    const-string v1, "not_nwt"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060040

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public getAllConditionMetaItemForListingFlow()Lcom/poshmark/data_model/models/MetaItem;
    .locals 4

    .prologue
    .line 73
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    const-string v1, "not_nwt"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f0601ce

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method
