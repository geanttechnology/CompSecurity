.class public Lic;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

.field private k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 23
    iput-object p3, p0, Lic;->k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 24
    iput-object p4, p0, Lic;->a:Ljava/lang/String;

    .line 25
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lic;->a:Ljava/lang/String;

    invoke-static {v0}, Lfs;->j(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

    move-result-object v0

    iput-object v0, p0, Lic;->j:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

    .line 31
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 35
    iget-object v0, p0, Lic;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lic;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 36
    iget-object v0, p0, Lic;->j:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lic;->j:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lic;->j:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponseChild;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 37
    iget-object v0, p0, Lic;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->e()V

    .line 38
    iget-object v0, p0, Lic;->k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v1, p0, Lic;->j:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponseChild;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponseChild;->getEpisodes()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->setEpisodesList(Ljava/util/List;)V

    .line 41
    :cond_0
    return-void
.end method
