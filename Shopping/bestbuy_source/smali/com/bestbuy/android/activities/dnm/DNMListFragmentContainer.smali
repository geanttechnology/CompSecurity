.class public Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;
.super Lcom/bestbuy/android/base/BaseFragmentContainer;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Lqo;
.implements Lqp;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/app/Activity;

.field private c:Ljava/lang/String;

.field private g:Lnb;

.field private h:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private i:Lqm;

.field private j:Landroid/view/View;

.field private k:Landroid/view/View;

.field private l:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-class v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 44
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 40
    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->j:Landroid/view/View;

    .line 41
    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->k:Landroid/view/View;

    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->l:Z

    .line 46
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 48
    invoke-direct {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;-><init>()V

    .line 40
    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->j:Landroid/view/View;

    .line 41
    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->k:Landroid/view/View;

    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->l:Z

    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->c:Ljava/lang/String;

    .line 50
    iput-object p2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->h:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 51
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;)Lqm;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->i:Lqm;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;Lqm;)Lqm;
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->i:Lqm;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;Z)Z
    .locals 0

    .prologue
    .line 30
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->l:Z

    return p1
.end method

.method private f()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->h:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-nez v0, :cond_0

    .line 109
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    const v1, 0x7f080156

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g:Lnb;

    invoke-virtual {v2}, Lnb;->y()D

    move-result-wide v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g:Lnb;

    invoke-virtual {v4}, Lnb;->z()D

    move-result-wide v4

    iget-object v6, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->c:Ljava/lang/String;

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;-><init>(Ljava/lang/String;DDLjava/lang/String;)V

    invoke-virtual {p0, v0, v7}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 113
    :goto_0
    return-void

    .line 111
    :cond_0
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->h:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Store"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->h:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->c:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0, v7}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method private g()Z
    .locals 2

    .prologue
    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b:Landroid/app/Activity;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 155
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 130
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 131
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 99
    invoke-direct {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 100
    invoke-direct {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->f()V

    .line 105
    :goto_0
    return-void

    .line 103
    :cond_0
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->c:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 88
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->h(Z)V

    .line 90
    const-string v0, ""

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->c:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->c:Ljava/lang/String;

    const v1, 0x7f08006c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 92
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08028d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 95
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->updateSearchHint(Ljava/lang/String;)V

    .line 96
    return-void

    .line 94
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080129

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 54
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onAttach(Landroid/app/Activity;)V

    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b:Landroid/app/Activity;

    .line 56
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g:Lnb;

    .line 57
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;

    invoke-direct {v1, p0, p1}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;-><init>(Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;Landroid/app/Activity;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 68
    return-void
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 176
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->l:Z

    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->j:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->k:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 179
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->i:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 180
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 160
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->l:Z

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->j:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->k:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 163
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 165
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b:Landroid/app/Activity;

    const/16 v1, 0x2328

    invoke-virtual {p1, v0, v1}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 172
    :goto_0
    return-void

    .line 166
    :catch_0
    move-exception v0

    .line 167
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 170
    :cond_0
    sget-object v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services connection failed with code "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lpp;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onConnectionSuspended(I)V
    .locals 3

    .prologue
    .line 184
    sget-object v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services suspended cause:  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 72
    const v0, 0x7f03002e

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 73
    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->j:Landroid/view/View;

    .line 74
    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->k:Landroid/view/View;

    .line 75
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->l:Z

    if-eqz v1, :cond_0

    .line 76
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->k:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 77
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->j:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 79
    :cond_0
    return-object v0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 136
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroy()V

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->h(Z)V

    .line 138
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0802ef

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->updateSearchHint(Ljava/lang/String;)V

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 143
    return-void
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 147
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onDestroyView()V

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->i:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->i:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    .line 151
    :cond_0
    return-void
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 189
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->l:Z

    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->j:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->k:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 192
    if-eqz p1, :cond_1

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->a(D)V

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->b(D)V

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->i:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 197
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->i:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 198
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->c()V

    .line 200
    :cond_1
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 117
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onResume()V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 119
    invoke-direct {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->g()Z

    move-result v0

    if-nez v0, :cond_0

    .line 120
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->c:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 126
    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 83
    invoke-super {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->onStart()V

    .line 84
    return-void
.end method
