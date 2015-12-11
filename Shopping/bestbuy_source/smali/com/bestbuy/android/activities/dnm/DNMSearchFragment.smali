.class public Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/app/Activity;

.field private c:Landroid/view/View;

.field private g:Landroid/widget/ImageView;

.field private h:Ljava/lang/String;

.field private i:Landroid/widget/EditText;

.field private j:Landroid/view/View;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private l:Landroid/widget/LinearLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 43
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->h:Ljava/lang/String;

    .line 47
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 119
    new-instance v0, Lip;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->j:Landroid/view/View;

    iget-object v5, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->l:Landroid/widget/LinearLayout;

    move-object v2, p0

    move-object v4, p1

    invoke-direct/range {v0 .. v5}, Lip;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Landroid/widget/LinearLayout;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lip;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 120
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->i:Landroid/widget/EditText;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/String;Landroid/location/Address;)V
    .locals 7

    .prologue
    .line 123
    invoke-virtual {p2}, Landroid/location/Address;->getLatitude()D

    move-result-wide v2

    .line 124
    invoke-virtual {p2}, Landroid/location/Address;->getLongitude()D

    move-result-wide v4

    .line 125
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    iget-object v6, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->h:Ljava/lang/String;

    move-object v1, p1

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;-><init>(Ljava/lang/String;DDLjava/lang/String;)V

    .line 126
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 127
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 63
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->h:Ljava/lang/String;

    const v1, 0x7f08006c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08006e

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 69
    :goto_0
    return-void

    .line 68
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f080038

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 7

    .prologue
    .line 108
    const/16 v0, 0xd05

    if-ne p1, v0, :cond_0

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 110
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 111
    if-eqz v0, :cond_0

    .line 112
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    const-string v1, "current location"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->y()D

    move-result-wide v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->f:Lnb;

    invoke-virtual {v4}, Lnb;->z()D

    move-result-wide v4

    iget-object v6, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->h:Ljava/lang/String;

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;-><init>(Ljava/lang/String;DDLjava/lang/String;)V

    .line 113
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 116
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 50
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    .line 52
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    if-ne p1, v0, :cond_0

    .line 132
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 133
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b:Landroid/app/Activity;

    const/16 v2, 0xd05

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 135
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 56
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 57
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 73
    const v0, 0x7f030032

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->c:Landroid/view/View;

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->j:Landroid/view/View;

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->c:Landroid/view/View;

    const v1, 0x7f0c00c6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->i:Landroid/widget/EditText;

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->c:Landroid/view/View;

    const v1, 0x7f0c00da

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->g:Landroid/widget/ImageView;

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->c:Landroid/view/View;

    const v1, 0x7f0c00c0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->l:Landroid/widget/LinearLayout;

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0037

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->h:Ljava/lang/String;

    const-string v1, "OpenBox"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->g:Landroid/widget/ImageView;

    const v1, 0x7f020043

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 84
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->i:Landroid/widget/EditText;

    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment$1;-><init>(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->c:Landroid/view/View;

    return-object v0

    .line 83
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->g:Landroid/widget/ImageView;

    const v1, 0x7f020042

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 139
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 140
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 104
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 105
    return-void
.end method
