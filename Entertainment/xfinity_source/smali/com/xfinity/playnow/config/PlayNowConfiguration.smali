.class public Lcom/xfinity/playnow/config/PlayNowConfiguration;
.super Lcom/xfinity/playerlib/config/PlayerConfiguration;
.source "PlayNowConfiguration.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;-><init>()V

    return-void
.end method


# virtual methods
.method public getFlyinMenuOptions()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;",
            ">;>;"
        }
    .end annotation

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 14
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 16
    .local v0, "menuGroups":Ljava/util/List;, "Ljava/util/List<Ljava/util/List<Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;>;>;"
    const/4 v1, 0x6

    new-array v1, v1, [Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->FEATURED:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v1, v4

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->TV_SERIES:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v1, v5

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->MOVIES:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v1, v6

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->LIVE:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v1, v7

    const/4 v2, 0x4

    sget-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->KIDS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v3, v1, v2

    const/4 v2, 0x5

    sget-object v3, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->NETWORKS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 23
    new-array v1, v7, [Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->DOWNLOADS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v1, v4

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->HISTORY:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v1, v5

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->FAVORITE:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v1, v6

    invoke-static {v1}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 27
    new-array v1, v5, [Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    sget-object v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->SETTINGS:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    aput-object v2, v1, v4

    invoke-static {v1}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 28
    return-object v0
.end method

.method public shouldSuppressNetworkLogos()Z
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    return v0
.end method
