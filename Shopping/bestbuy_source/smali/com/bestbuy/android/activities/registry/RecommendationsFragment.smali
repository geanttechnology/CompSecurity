.class public Lcom/bestbuy/android/activities/registry/RecommendationsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private c:Z

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/widget/ListView;

.field private i:Landroid/view/View;

.field private j:Lcw;

.field private k:Ljava/lang/String;

.field private l:Landroid/support/v4/app/Fragment;


# direct methods
.method public constructor <init>(ZLjava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 38
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->c:Z

    .line 39
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->a:Ljava/util/ArrayList;

    .line 40
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->b:Ljava/util/ArrayList;

    .line 41
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->k:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->b:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->k:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->a:Ljava/util/ArrayList;

    return-object v0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 51
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 52
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Llu;->aA:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": Promotions"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 53
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 46
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->l:Landroid/support/v4/app/Fragment;

    .line 47
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 57
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 58
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 76
    const v0, 0x7f0300e0

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 77
    const v0, 0x7f0c0364

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->g:Landroid/widget/LinearLayout;

    .line 78
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->i:Landroid/view/View;

    .line 79
    const v0, 0x7f0c0365

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->h:Landroid/widget/ListView;

    .line 80
    new-instance v0, Lcw;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->a:Ljava/util/ArrayList;

    invoke-direct {v0, v2, v4, v3}, Lcw;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->j:Lcw;

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->h:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->j:Lcw;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->h:Landroid/widget/ListView;

    new-instance v2, Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/RecommendationsFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 90
    return-object v1
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 71
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 72
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 62
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Promotions"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 67
    return-void
.end method
