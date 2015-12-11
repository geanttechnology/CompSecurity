.class public Lif;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

.field private k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 20
    iput-object p3, p0, Lif;->k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 21
    iput-object p4, p0, Lif;->a:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lif;->a:Ljava/lang/String;

    invoke-static {v0}, Lfs;->l(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    move-result-object v0

    iput-object v0, p0, Lif;->j:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    .line 28
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 32
    iget-object v0, p0, Lif;->j:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lif;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lif;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lif;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->f()V

    .line 34
    iget-object v0, p0, Lif;->k:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v1, p0, Lif;->j:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->setMusicResponse(Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;)V

    .line 36
    :cond_0
    return-void
.end method
