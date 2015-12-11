.class public Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lcg;


# instance fields
.field private a:Landroid/widget/EditText;

.field private b:Landroid/widget/EditText;

.field private c:Landroid/widget/EditText;

.field private g:Landroid/widget/EditText;

.field private h:Landroid/widget/EditText;

.field private i:Landroid/widget/Spinner;

.field private j:Landroid/widget/EditText;

.field private k:Landroid/widget/EditText;

.field private l:Landroid/view/View;

.field private m:Landroid/os/Bundle;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 38
    return-void
.end method

.method private b()V
    .locals 10

    .prologue
    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 96
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->b:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 97
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->c:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 98
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->g:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 99
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->h:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 100
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->i:Landroid/widget/Spinner;

    invoke-virtual {v5}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 101
    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->j:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 102
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->k:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 103
    const-string v8, "\\D"

    const-string v9, ""

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 105
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    const-string v9, "newFirstName"

    invoke-virtual {v8, v9, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    const-string v8, "newLastName"

    invoke-virtual {v0, v8, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    const-string v1, "newAddressLine1"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    const-string v1, "newAddressLine2"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    const-string v1, "newZip"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    const-string v1, "newState"

    invoke-virtual {v0, v1, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    const-string v1, "newCity"

    invoke-virtual {v0, v1, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    const-string v1, "newPhoneNumber"

    invoke-virtual {v0, v1, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    new-instance v1, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;-><init>()V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->m:Landroid/os/Bundle;

    invoke-virtual {v1, v0}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 116
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 117
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_0

    .line 118
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 120
    :cond_0
    return-void
.end method


# virtual methods
.method public g()V
    .locals 0

    .prologue
    .line 91
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->b()V

    .line 92
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 55
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 58
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 60
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 44
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 45
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f0802e5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 46
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    move-object v0, p1

    .line 47
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 49
    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    move-object v0, p1

    .line 50
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Change Address"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 51
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 52
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 64
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 65
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 74
    const v0, 0x7f03010f

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 75
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->l:Landroid/view/View;

    .line 76
    const v0, 0x7f0c00a7

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->a:Landroid/widget/EditText;

    .line 77
    const v0, 0x7f0c00a8

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->b:Landroid/widget/EditText;

    .line 78
    const v0, 0x7f0c03e8

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->c:Landroid/widget/EditText;

    .line 79
    const v0, 0x7f0c03e9

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->g:Landroid/widget/EditText;

    .line 80
    const v0, 0x7f0c03ea

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->h:Landroid/widget/EditText;

    .line 81
    const v0, 0x7f0c0377

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->i:Landroid/widget/Spinner;

    .line 82
    const v0, 0x7f0c0374

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->j:Landroid/widget/EditText;

    .line 83
    const v0, 0x7f0c03eb

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->k:Landroid/widget/EditText;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->k:Landroid/widget/EditText;

    const/4 v2, 0x3

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setInputType(I)V

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/UpdateRegistryAddress;->k:Landroid/widget/EditText;

    new-instance v2, Landroid/telephony/PhoneNumberFormattingTextWatcher;

    invoke-direct {v2}, Landroid/telephony/PhoneNumberFormattingTextWatcher;-><init>()V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 86
    return-object v1
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 69
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 70
    return-void
.end method
