.class public Lcom/poshmark/controllers/RecentBrandsController;
.super Ljava/lang/Object;
.source "RecentBrandsController.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field private static final DEFAULT_RECENT_BRANDS:[Ljava/lang/String;

.field public static final GLOBAL_RECENT_BRANDS:Ljava/lang/String; = "global_recent_brands"

.field private static final GLOBAL_RECENT_ITEMS_SIZE:I = 0x1e

.field public static final RECENT_BRANDS:Ljava/lang/String; = "recent_brands"

.field public static final RECENT_ITEMS_SIZE:I = 0x6

.field static recentBrandsStore:Lcom/poshmark/controllers/RecentBrandsController;


# instance fields
.field public globalRecentItems:Lcom/poshmark/utils/MetaItemList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/poshmark/utils/MetaItemList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field public recentItems:Lcom/poshmark/utils/MetaItemList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/poshmark/utils/MetaItemList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 24
    const/16 v0, 0xb

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "Tory Burch"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Michael Kors"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "Coach"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "Louis Vuitton"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "Gucci"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "kate spade"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "J. Crew"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "Steve Madden"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "Juicy Couture"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "Free People"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "lululemon athletica"

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/controllers/RecentBrandsController;->DEFAULT_RECENT_BRANDS:[Ljava/lang/String;

    .line 29
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/controllers/RecentBrandsController;->recentBrandsStore:Lcom/poshmark/controllers/RecentBrandsController;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/controllers/RecentBrandsController;->retrieveRecentBrands(Z)Lcom/poshmark/utils/MetaItemList;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    .line 44
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/controllers/RecentBrandsController;->retrieveRecentBrands(Z)Lcom/poshmark/utils/MetaItemList;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    .line 47
    return-void
.end method

.method public static globalRecentBrandsController()Lcom/poshmark/controllers/RecentBrandsController;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/poshmark/controllers/RecentBrandsController;->recentBrandsStore:Lcom/poshmark/controllers/RecentBrandsController;

    if-nez v0, :cond_0

    .line 33
    new-instance v0, Lcom/poshmark/controllers/RecentBrandsController;

    invoke-direct {v0}, Lcom/poshmark/controllers/RecentBrandsController;-><init>()V

    sput-object v0, Lcom/poshmark/controllers/RecentBrandsController;->recentBrandsStore:Lcom/poshmark/controllers/RecentBrandsController;

    .line 35
    :cond_0
    sget-object v0, Lcom/poshmark/controllers/RecentBrandsController;->recentBrandsStore:Lcom/poshmark/controllers/RecentBrandsController;

    return-object v0
.end method


# virtual methods
.method public actualGlobalItemCount()I
    .locals 3

    .prologue
    .line 196
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v2}, Lcom/poshmark/utils/MetaItemList;->getLimit()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 198
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v2, v1}, Lcom/poshmark/utils/MetaItemList;->get(I)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    if-nez v2, :cond_0

    .line 199
    add-int/lit8 v1, v1, 0x1

    .line 204
    .end local v1    # "i":I
    :goto_1
    return v1

    .line 200
    .restart local v1    # "i":I
    :catch_0
    move-exception v0

    .line 201
    .local v0, "e":Ljava/lang/IndexOutOfBoundsException;
    goto :goto_1

    .line 196
    .end local v0    # "e":Ljava/lang/IndexOutOfBoundsException;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 204
    :cond_1
    iget-object v2, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v2}, Lcom/poshmark/utils/MetaItemList;->getLimit()I

    move-result v1

    goto :goto_1
.end method

.method public actualRecentItemCount()I
    .locals 3

    .prologue
    .line 184
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v2}, Lcom/poshmark/utils/MetaItemList;->getLimit()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 186
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v2, v1}, Lcom/poshmark/utils/MetaItemList;->get(I)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    if-nez v2, :cond_0

    .line 187
    add-int/lit8 v1, v1, 0x1

    .line 192
    .end local v1    # "i":I
    :goto_1
    return v1

    .line 188
    .restart local v1    # "i":I
    :catch_0
    move-exception v0

    .line 189
    .local v0, "e":Ljava/lang/IndexOutOfBoundsException;
    goto :goto_1

    .line 184
    .end local v0    # "e":Ljava/lang/IndexOutOfBoundsException;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 192
    :cond_1
    iget-object v2, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v2}, Lcom/poshmark/utils/MetaItemList;->getLimit()I

    move-result v1

    goto :goto_1
.end method

.method public addToGlobalBrands(Lcom/poshmark/data_model/models/MetaItem;)Z
    .locals 2
    .param p1, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    const/4 v0, 0x0

    .line 221
    invoke-virtual {p0, p1}, Lcom/poshmark/controllers/RecentBrandsController;->isDuplicateInGlobalRecent(Lcom/poshmark/data_model/models/MetaItem;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 228
    :goto_0
    return v0

    .line 224
    :cond_0
    iget-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v1, p1}, Lcom/poshmark/utils/MetaItemList;->addToGlobalList(Lcom/poshmark/data_model/models/MetaItem;)Z

    .line 226
    iget-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {p0, v1, v0}, Lcom/poshmark/controllers/RecentBrandsController;->storeRecentBrands(Lcom/poshmark/utils/MetaItemList;Z)V

    .line 228
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public addToGlobalTop(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 0
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 59
    invoke-virtual {p0, p1}, Lcom/poshmark/controllers/RecentBrandsController;->addToGlobalBrands(Lcom/poshmark/data_model/models/MetaItem;)Z

    .line 60
    return-void
.end method

.method public addToRecentBrands(Lcom/poshmark/data_model/models/MetaItem;)Z
    .locals 2
    .param p1, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    const/4 v0, 0x1

    .line 210
    invoke-virtual {p0, p1}, Lcom/poshmark/controllers/RecentBrandsController;->isDuplicateInRecent(Lcom/poshmark/data_model/models/MetaItem;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 211
    const/4 v0, 0x0

    .line 217
    :goto_0
    return v0

    .line 213
    :cond_0
    iget-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v1, p1}, Lcom/poshmark/utils/MetaItemList;->addToRecentList(Lcom/poshmark/data_model/models/MetaItem;)Z

    .line 215
    iget-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {p0, v1, v0}, Lcom/poshmark/controllers/RecentBrandsController;->storeRecentBrands(Lcom/poshmark/utils/MetaItemList;Z)V

    goto :goto_0
.end method

.method public addToTop(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 0
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 52
    invoke-virtual {p0, p1}, Lcom/poshmark/controllers/RecentBrandsController;->addToRecentBrands(Lcom/poshmark/data_model/models/MetaItem;)Z

    .line 54
    invoke-virtual {p0, p1}, Lcom/poshmark/controllers/RecentBrandsController;->addToGlobalTop(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 55
    return-void
.end method

.method public clearGlobalRecentBrands()V
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v0}, Lcom/poshmark/utils/MetaItemList;->clear()V

    .line 75
    return-void
.end method

.method public clearGlobalRecentBrandsPref()V
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v0}, Lcom/poshmark/utils/MetaItemList;->clear()V

    .line 79
    invoke-static {}, Lcom/poshmark/controllers/SharedPreferencesController;->getSharedPreferencesController()Lcom/poshmark/controllers/SharedPreferencesController;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    .line 80
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    const-string v1, "global_recent_brands"

    invoke-virtual {v0, v1}, Lcom/poshmark/controllers/SharedPreferencesController;->removePreference(Ljava/lang/String;)V

    .line 81
    return-void
.end method

.method public clearRecentBrands()V
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v0}, Lcom/poshmark/utils/MetaItemList;->clear()V

    .line 64
    return-void
.end method

.method public clearRecentBrandsPref()V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v0}, Lcom/poshmark/utils/MetaItemList;->clear()V

    .line 68
    invoke-static {}, Lcom/poshmark/controllers/SharedPreferencesController;->getSharedPreferencesController()Lcom/poshmark/controllers/SharedPreferencesController;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    .line 69
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    const-string v1, "recent_brands"

    invoke-virtual {v0, v1}, Lcom/poshmark/controllers/SharedPreferencesController;->removePreference(Ljava/lang/String;)V

    .line 70
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v0}, Lcom/poshmark/utils/MetaItemList;->size()I

    move-result v0

    return v0
.end method

.method public getFilteredList()V
    .locals 5

    .prologue
    .line 108
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 109
    .local v2, "set":Ljava/util/Set;, "Ljava/util/Set<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4}, Lcom/poshmark/utils/MetaItemList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 110
    .local v1, "obj":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v2, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 113
    .end local v1    # "obj":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4}, Lcom/poshmark/utils/MetaItemList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    .line 114
    .local v3, "subItem":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 115
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4, v3}, Lcom/poshmark/utils/MetaItemList;->remove(Ljava/lang/Object;)Z

    .line 119
    .end local v3    # "subItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_2
    return-void
.end method

.method public getGlobalCount()I
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v0}, Lcom/poshmark/utils/MetaItemList;->size()I

    move-result v0

    return v0
.end method

.method public getGlobalRecentItems()Lcom/poshmark/utils/MetaItemList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/poshmark/utils/MetaItemList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 141
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    return-object v0
.end method

.method public getGlobalTop()Lcom/poshmark/data_model/models/MetaItem;
    .locals 2

    .prologue
    .line 88
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/MetaItemList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public getRecentItems()Lcom/poshmark/utils/MetaItemList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/poshmark/utils/MetaItemList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 124
    :try_start_0
    iget-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    if-eqz v1, :cond_0

    .line 125
    iget-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    .line 136
    :goto_0
    return-object v1

    .line 128
    :cond_0
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/poshmark/controllers/RecentBrandsController;->retrieveRecentBrands(Z)Lcom/poshmark/utils/MetaItemList;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    .line 129
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/poshmark/controllers/RecentBrandsController;->retrieveRecentBrands(Z)Lcom/poshmark/utils/MetaItemList;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    .line 130
    iget-object v1, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 133
    :catch_0
    move-exception v0

    .line 135
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 136
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getTop()Lcom/poshmark/data_model/models/MetaItem;
    .locals 2

    .prologue
    .line 84
    iget-object v0, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/MetaItemList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 103
    return-void
.end method

.method public isDuplicateInGlobalRecent(Lcom/poshmark/data_model/models/MetaItem;)Z
    .locals 5
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    const/4 v3, 0x0

    .line 165
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/controllers/RecentBrandsController;->actualGlobalItemCount()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 167
    :try_start_0
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4, v2}, Lcom/poshmark/utils/MetaItemList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p1, v4}, Lcom/poshmark/data_model/models/MetaItem;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 169
    move-object v0, p1

    .line 170
    .local v0, "copyMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4, p1}, Lcom/poshmark/utils/MetaItemList;->remove(Ljava/lang/Object;)Z

    .line 171
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4, v0}, Lcom/poshmark/utils/MetaItemList;->addToRecentList(Lcom/poshmark/data_model/models/MetaItem;)Z
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 173
    const/4 v3, 0x1

    .line 179
    .end local v0    # "copyMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    :goto_1
    return v3

    .line 175
    :catch_0
    move-exception v1

    .line 176
    .local v1, "e":Ljava/lang/IndexOutOfBoundsException;
    goto :goto_1

    .line 165
    .end local v1    # "e":Ljava/lang/IndexOutOfBoundsException;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public isDuplicateInRecent(Lcom/poshmark/data_model/models/MetaItem;)Z
    .locals 5
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    const/4 v3, 0x0

    .line 146
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/controllers/RecentBrandsController;->actualRecentItemCount()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 148
    :try_start_0
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4, v2}, Lcom/poshmark/utils/MetaItemList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p1, v4}, Lcom/poshmark/data_model/models/MetaItem;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 150
    move-object v0, p1

    .line 151
    .local v0, "copyMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4, p1}, Lcom/poshmark/utils/MetaItemList;->remove(Ljava/lang/Object;)Z

    .line 152
    iget-object v4, p0, Lcom/poshmark/controllers/RecentBrandsController;->recentItems:Lcom/poshmark/utils/MetaItemList;

    invoke-virtual {v4, v0}, Lcom/poshmark/utils/MetaItemList;->addToRecentList(Lcom/poshmark/data_model/models/MetaItem;)Z
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 154
    const/4 v3, 0x1

    .line 160
    .end local v0    # "copyMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    :goto_1
    return v3

    .line 156
    :catch_0
    move-exception v1

    .line 157
    .local v1, "e":Ljava/lang/IndexOutOfBoundsException;
    goto :goto_1

    .line 146
    .end local v1    # "e":Ljava/lang/IndexOutOfBoundsException;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public retrieveRecentBrands(Z)Lcom/poshmark/utils/MetaItemList;
    .locals 11
    .param p1, "isRecentBrands"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/poshmark/utils/MetaItemList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 256
    invoke-static {}, Lcom/poshmark/controllers/SharedPreferencesController;->getSharedPreferencesController()Lcom/poshmark/controllers/SharedPreferencesController;

    move-result-object v9

    iput-object v9, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    .line 257
    if-eqz p1, :cond_1

    .line 258
    new-instance v5, Lcom/poshmark/utils/MetaItemList;

    const/4 v9, 0x6

    invoke-direct {v5, v9}, Lcom/poshmark/utils/MetaItemList;-><init>(I)V

    .line 259
    .local v5, "retrievedResult":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v9, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    const-string v10, "recent_brands"

    invoke-virtual {v9, v10}, Lcom/poshmark/controllers/SharedPreferencesController;->getStringSet(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v8

    .line 261
    .local v8, "set":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-eqz v8, :cond_0

    .line 262
    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 264
    .local v7, "s":Ljava/lang/String;
    :try_start_0
    new-instance v4, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v4, v7, v7}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    .local v4, "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v5, v4}, Lcom/poshmark/utils/MetaItemList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 266
    .end local v4    # "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    :catch_0
    move-exception v1

    .line 267
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v7    # "s":Ljava/lang/String;
    :cond_0
    move-object v6, v5

    .line 294
    .end local v5    # "retrievedResult":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    .local v6, "retrievedResult":Ljava/lang/Object;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_1
    return-object v6

    .line 273
    .end local v6    # "retrievedResult":Ljava/lang/Object;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v8    # "set":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_1
    new-instance v5, Lcom/poshmark/utils/MetaItemList;

    const/16 v9, 0x1e

    invoke-direct {v5, v9}, Lcom/poshmark/utils/MetaItemList;-><init>(I)V

    .line 274
    .restart local v5    # "retrievedResult":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v9, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    const-string v10, "global_recent_brands"

    invoke-virtual {v9, v10}, Lcom/poshmark/controllers/SharedPreferencesController;->getStringSet(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v8

    .line 275
    .restart local v8    # "set":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-eqz v8, :cond_3

    .line 276
    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 278
    .restart local v7    # "s":Ljava/lang/String;
    :try_start_1
    new-instance v4, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v4, v7, v7}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 279
    .restart local v4    # "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v5, v4}, Lcom/poshmark/utils/MetaItemList;->addToGlobalList(Lcom/poshmark/data_model/models/MetaItem;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_2

    .line 280
    .end local v4    # "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    :catch_1
    move-exception v1

    .line 281
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2

    .end local v1    # "e":Ljava/lang/Exception;
    .end local v7    # "s":Ljava/lang/String;
    :cond_2
    move-object v6, v5

    .line 284
    .restart local v6    # "retrievedResult":Ljava/lang/Object;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    goto :goto_1

    .line 286
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v6    # "retrievedResult":Ljava/lang/Object;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_3
    sget-object v0, Lcom/poshmark/controllers/RecentBrandsController;->DEFAULT_RECENT_BRANDS:[Ljava/lang/String;

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_3
    if-ge v2, v3, :cond_4

    aget-object v7, v0, v2

    .line 288
    .restart local v7    # "s":Ljava/lang/String;
    :try_start_2
    new-instance v4, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v4, v7, v7}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 289
    .restart local v4    # "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v5, v4}, Lcom/poshmark/utils/MetaItemList;->addToGlobalList(Lcom/poshmark/data_model/models/MetaItem;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 286
    .end local v4    # "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    :goto_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 290
    :catch_2
    move-exception v1

    .line 291
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_4

    .end local v1    # "e":Ljava/lang/Exception;
    .end local v7    # "s":Ljava/lang/String;
    :cond_4
    move-object v6, v5

    .line 294
    .restart local v6    # "retrievedResult":Ljava/lang/Object;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    goto :goto_1
.end method

.method public storeRecentBrands(Lcom/poshmark/utils/MetaItemList;Z)V
    .locals 4
    .param p2, "isRecentBrands"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/utils/MetaItemList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 238
    .local p1, "brands":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 239
    .local v1, "set":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Lcom/poshmark/utils/MetaItemList;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 240
    invoke-virtual {p1, v0}, Lcom/poshmark/utils/MetaItemList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 239
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 242
    :cond_0
    if-eqz p2, :cond_1

    .line 243
    iget-object v2, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    const-string v3, "recent_brands"

    invoke-virtual {v2, v3, v1}, Lcom/poshmark/controllers/SharedPreferencesController;->putStringSet(Ljava/lang/String;Ljava/util/Set;)V

    .line 248
    :goto_1
    return-void

    .line 245
    :cond_1
    iget-object v2, p0, Lcom/poshmark/controllers/RecentBrandsController;->sharedPreferencesController:Lcom/poshmark/controllers/SharedPreferencesController;

    const-string v3, "global_recent_brands"

    invoke-virtual {v2, v3, v1}, Lcom/poshmark/controllers/SharedPreferencesController;->putStringSet(Ljava/lang/String;Ljava/util/Set;)V

    goto :goto_1
.end method
