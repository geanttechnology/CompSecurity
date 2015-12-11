.class public Lio;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:I

.field private k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

.field private l:Lnb;

.field private m:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 26
    const/4 v0, 0x0

    iput v0, p0, Lio;->j:I

    .line 33
    iput-object p4, p0, Lio;->a:Ljava/lang/String;

    .line 34
    iput-object p5, p0, Lio;->m:Ljava/lang/String;

    .line 35
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lio;->l:Lnb;

    .line 36
    return-void
.end method

.method static synthetic a(Lio;I)I
    .locals 0

    .prologue
    .line 23
    iput p1, p0, Lio;->j:I

    return p1
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 47
    iget-object v0, p0, Lio;->a:Ljava/lang/String;

    iget-object v1, p0, Lio;->m:Ljava/lang/String;

    invoke-static {v0, v1}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    move-result-object v0

    iput-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    .line 48
    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isHasError()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getErrorCode()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    .line 50
    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-static {v0}, Lfr;->a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V

    .line 51
    iget-object v0, p0, Lio;->l:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->m(Z)V

    .line 54
    :cond_0
    return-void
.end method

.method public b()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 58
    const/4 v0, 0x1

    iput v0, p0, Lio;->j:I

    .line 59
    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    if-eqz v0, :cond_8

    .line 60
    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isHasError()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getErrorCode()Ljava/lang/String;

    move-result-object v0

    const-string v1, "403"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getErrorCode()Ljava/lang/String;

    move-result-object v0

    const-string v1, "401"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getErrorCode()Ljava/lang/String;

    move-result-object v0

    const-string v1, "409"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 61
    :cond_0
    invoke-virtual {p0}, Lio;->c()V

    .line 103
    :cond_1
    :goto_0
    return-void

    .line 62
    :cond_2
    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isHasError()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getErrorCode()Ljava/lang/String;

    move-result-object v0

    const-string v1, "499"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 63
    iget-object v0, p0, Lio;->l:Lnb;

    invoke-virtual {v0}, Lnb;->Z()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 64
    iget-object v0, p0, Lio;->l:Lnb;

    invoke-virtual {v0, v2}, Lnb;->m(Z)V

    .line 66
    :cond_3
    iget-object v0, p0, Lio;->f:Landroid/app/Activity;

    new-instance v1, Lio$1;

    invoke-direct {v1, p0}, Lio$1;-><init>(Lio;)V

    new-instance v2, Lio$2;

    invoke-direct {v2, p0}, Lio$2;-><init>(Lio;)V

    iget-boolean v3, p0, Lio;->e:Z

    iget v4, p0, Lio;->j:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    goto :goto_0

    .line 79
    :cond_4
    iget-object v0, p0, Lio;->l:Lnb;

    invoke-virtual {v0}, Lnb;->w()Lmr;

    move-result-object v0

    .line 80
    iget-object v1, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0, v1}, Lmr;->a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V

    .line 81
    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 82
    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v1, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V

    .line 83
    new-instance v0, Lhs;

    invoke-direct {v0}, Lhs;-><init>()V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhs;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 96
    :cond_5
    :goto_1
    iget-object v0, p0, Lio;->l:Lnb;

    invoke-virtual {v0}, Lnb;->Z()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 97
    iget-object v0, p0, Lio;->l:Lnb;

    invoke-virtual {v0, v2}, Lnb;->m(Z)V

    goto :goto_0

    .line 84
    :cond_6
    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 86
    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    iget-object v1, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V

    .line 87
    new-instance v0, Lhs;

    invoke-direct {v0}, Lhs;-><init>()V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhs;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 88
    iget-object v0, p0, Lio;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->recreateHomeScreen(Z)V

    .line 89
    iget-object v0, p0, Lio;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    .line 90
    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Z)V

    goto :goto_1

    .line 91
    :cond_7
    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 92
    iget-object v0, p0, Lio;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    iget-object v1, p0, Lio;->k:Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V

    .line 93
    new-instance v0, Lhs;

    invoke-direct {v0}, Lhs;-><init>()V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhs;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 102
    :cond_8
    invoke-virtual {p0}, Lio;->c()V

    goto/16 :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 111
    iget-object v0, p0, Lio;->l:Lnb;

    invoke-virtual {v0}, Lnb;->Z()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 112
    iget-object v0, p0, Lio;->l:Lnb;

    invoke-virtual {v0, v1}, Lnb;->m(Z)V

    .line 114
    :cond_0
    iput v1, p0, Lio;->j:I

    .line 115
    iget-object v0, p0, Lio;->g:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 116
    iget-object v0, p0, Lio;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 118
    :cond_1
    return-void
.end method

.method public d()V
    .locals 1

    .prologue
    .line 107
    iget v0, p0, Lio;->j:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lio;->j:I

    .line 108
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 40
    iget-object v0, p0, Lio;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 41
    iget-object v0, p0, Lio;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 43
    :cond_0
    return-void
.end method
