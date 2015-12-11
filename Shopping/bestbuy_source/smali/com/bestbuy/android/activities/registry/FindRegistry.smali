.class public Lcom/bestbuy/android/activities/registry/FindRegistry;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/widget/Button;

.field private b:Landroid/widget/CheckBox;

.field private c:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 30
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/FindRegistry;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/FindRegistry;->c:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    return-object v0
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 34
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 35
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/FindRegistry;->d:Landroid/app/Activity;

    .line 36
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/FindRegistry;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 37
    if-eqz v0, :cond_0

    .line 38
    const-string v1, "data"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/FindRegistry;->c:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 40
    :cond_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    move-object v0, p1

    .line 41
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 43
    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    move-object v0, p1

    .line 44
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08033d

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/FindRegistry;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 45
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 46
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 49
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 50
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 56
    const v0, 0x7f03003d

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 59
    const v0, 0x7f0c0101

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/FindRegistry;->b:Landroid/widget/CheckBox;

    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/FindRegistry;->b:Landroid/widget/CheckBox;

    new-instance v2, Lcom/bestbuy/android/activities/registry/FindRegistry$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/FindRegistry$1;-><init>(Lcom/bestbuy/android/activities/registry/FindRegistry;)V

    invoke-virtual {v0, v2}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    const v0, 0x7f0c0105

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/FindRegistry;->a:Landroid/widget/Button;

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/FindRegistry;->a:Landroid/widget/Button;

    new-instance v2, Lcom/bestbuy/android/activities/registry/FindRegistry$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/FindRegistry$2;-><init>(Lcom/bestbuy/android/activities/registry/FindRegistry;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 85
    return-object v1
.end method
