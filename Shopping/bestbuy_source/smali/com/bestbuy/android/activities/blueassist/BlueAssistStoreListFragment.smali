.class public Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/widget/ListView;

.field private b:Lea;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private g:Landroid/view/View;

.field private h:Lbu;

.field private i:Z

.field private j:Landroid/app/Activity;

.field private k:I

.field private l:Z

.field private m:Landroid/widget/AbsListView$OnScrollListener;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 31
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    .line 26
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->i:Z

    .line 28
    iput v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->k:I

    .line 29
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->l:Z

    .line 99
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->m:Landroid/widget/AbsListView$OnScrollListener;

    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->j:Landroid/app/Activity;

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 35
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    .line 26
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->i:Z

    .line 28
    iput v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->k:I

    .line 29
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->l:Z

    .line 99
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->m:Landroid/widget/AbsListView$OnScrollListener;

    .line 36
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->j:Landroid/app/Activity;

    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 38
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)Z
    .locals 1

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->i:Z

    return v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;Z)Z
    .locals 0

    .prologue
    .line 19
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->i:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)Z
    .locals 1

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->l:Z

    return v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->k:I

    return v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)Lbu;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->h:Lbu;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/app/Activity;Ljava/util/ArrayList;IZ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;IZ)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 74
    if-gt p3, v3, :cond_0

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 79
    if-gt p3, v3, :cond_3

    .line 80
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->l:Z

    .line 81
    iput v4, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->k:I

    .line 82
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 83
    const v1, 0x7f0300fc

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->g:Landroid/view/View;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1, v2, v4}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 85
    instance-of v0, p1, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_2

    .line 86
    new-instance v0, Lea;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    move-object v1, p1

    move v5, v4

    invoke-direct/range {v0 .. v5}, Lea;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->b:Lea;

    .line 90
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->b:Lea;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 94
    :goto_1
    if-nez p4, :cond_1

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 97
    :cond_1
    return-void

    .line 88
    :cond_2
    new-instance v0, Lea;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    move-object v1, p1

    move v5, v3

    invoke-direct/range {v0 .. v5}, Lea;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->b:Lea;

    goto :goto_0

    .line 92
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->b:Lea;

    invoke-virtual {v0}, Lea;->notifyDataSetChanged()V

    goto :goto_1
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 63
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 64
    instance-of v0, p1, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_0

    .line 65
    check-cast p1, Lbu;

    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->h:Lbu;

    .line 66
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 43
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 47
    const v0, 0x7f03003e

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    .line 48
    const v0, 0x7f0c0106

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a:Landroid/widget/ListView;

    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->j:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_0

    .line 51
    new-instance v0, Lea;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->j:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    move v5, v4

    invoke-direct/range {v0 .. v5}, Lea;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->b:Lea;

    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->m:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 57
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->b:Lea;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 58
    return-object v6

    .line 54
    :cond_0
    new-instance v0, Lea;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->j:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c:Ljava/util/ArrayList;

    move v5, v3

    invoke-direct/range {v0 .. v5}, Lea;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->b:Lea;

    goto :goto_0
.end method

.method public onDetach()V
    .locals 0

    .prologue
    .line 70
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDetach()V

    .line 71
    return-void
.end method
