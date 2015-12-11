.class public Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Lnb;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 27
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;)Lnb;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->a:Lnb;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 73
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    const/4 v0, 0x0

    invoke-direct {v1, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 74
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 75
    const-string v0, "mDotURL"

    invoke-virtual {v2, v0, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->d:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 77
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 78
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 79
    const v2, 0x7f0c0033

    const-string v3, "MdotWebFragment"

    invoke-virtual {v0, v2, v1, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 80
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 81
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 82
    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 31
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->d:Landroid/app/Activity;

    .line 33
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->a:Lnb;

    .line 34
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 42
    const v0, 0x7f0300cb

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 43
    new-instance v2, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v2, v3}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 44
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 45
    const-string v3, "mDotURL"

    const-string v4, "file:///android_asset/tandc-android.html"

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    invoke-virtual {v2, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->d:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 48
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 49
    const v3, 0x7f0c032c

    const-string v4, "TermsFragment"

    invoke-virtual {v0, v3, v2, v4}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 51
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 53
    const v0, 0x7f0c032b

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v2, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment$1;-><init>(Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 61
    const v0, 0x7f0c032a

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v2, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment$2;-><init>(Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    return-object v1
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 87
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;->a:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 91
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 37
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 38
    return-void
.end method
