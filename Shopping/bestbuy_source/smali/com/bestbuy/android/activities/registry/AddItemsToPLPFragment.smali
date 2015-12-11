.class public Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field a:Landroid/content/Intent;

.field b:Landroid/os/Bundle;

.field private c:Landroid/view/View;

.field private g:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private h:Landroid/widget/RelativeLayout;

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private n:Landroid/widget/LinearLayout;

.field private o:Landroid/widget/Button;

.field private p:Landroid/widget/Button;

.field private q:Z

.field private r:Landroid/app/Activity;

.field private s:Landroid/widget/RelativeLayout;

.field private t:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private u:Landroid/widget/RelativeLayout;

.field private v:Landroid/view/View;

.field private w:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private x:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 49
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->a:Landroid/content/Intent;

    .line 50
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->b:Landroid/os/Bundle;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->w:Ljava/util/ArrayList;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->x:Ljava/util/ArrayList;

    .line 64
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 1

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 49
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->a:Landroid/content/Intent;

    .line 50
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->b:Landroid/os/Bundle;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->w:Ljava/util/ArrayList;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->x:Ljava/util/ArrayList;

    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 68
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->i:Ljava/lang/String;

    .line 69
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->j:Ljava/lang/String;

    .line 70
    iput-object p4, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->k:Ljava/lang/String;

    .line 71
    iput-boolean p5, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->q:Z

    .line 72
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->n:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0039

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->n:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 205
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 208
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->w:Ljava/util/ArrayList;

    .line 209
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->x:Ljava/util/ArrayList;

    .line 210
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 211
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 212
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 213
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->x:Ljava/util/ArrayList;

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 211
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 216
    :cond_0
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 221
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 87
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 88
    new-instance v0, Lji;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->v:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Lji;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lji;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 89
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 77
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    .line 78
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const/4 v3, 0x1

    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->p:Landroid/widget/Button;

    if-ne p1, v0, :cond_1

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->instantiateSearch()V

    .line 200
    :cond_0
    :goto_0
    return-void

    .line 175
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    if-ne p1, v0, :cond_2

    .line 176
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-string v2, "LIFE_EVENTS_PRODUCT_SCAN"

    const-string v3, ""

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->j:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->i:Ljava/lang/String;

    invoke-virtual/range {v0 .. v5}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 178
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->o:Landroid/widget/Button;

    if-ne p1, v0, :cond_3

    .line 179
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 180
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {v1, v3}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;-><init>(Z)V

    .line 181
    invoke-virtual {v0, v1, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 182
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_4

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->m:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 184
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->m:Ljava/util/ArrayList;

    const-string v2, "Scan History"

    invoke-direct {v1, v3, v0, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/util/ArrayList;Ljava/lang/String;Z)V

    .line 185
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 186
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v2, "PLPFragment"

    invoke-virtual {v0, v1, v3, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_0

    .line 188
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->u:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 189
    new-instance v1, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->w:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->x:Ljava/util/ArrayList;

    invoke-direct {v1, v3, v0, v2}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;-><init>(ZLjava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 190
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 191
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v2, :cond_5

    .line 192
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v2, "RecommendationsFragment"

    invoke-virtual {v0, v1, v3, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 196
    :goto_1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 197
    const-string v1, "Need Some Inspiration"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 198
    sget-object v1, Llu;->aA:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 194
    :cond_5
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v2, "RecommendationsFragment"

    invoke-virtual {v0, v1, v3, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 82
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 83
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 11

    .prologue
    const/16 v5, 0x8

    const/4 v2, 0x0

    const/4 v4, 0x0

    .line 98
    invoke-super {p0, p1, p2, p3}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 99
    const v0, 0x7f030004

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->v:Landroid/view/View;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0046

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0040

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->o:Landroid/widget/Button;

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->o:Landroid/widget/Button;

    const v1, 0x7f0800d2

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0041

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->p:Landroid/widget/Button;

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->p:Landroid/widget/Button;

    const v1, 0x7f0802ee

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c003a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->s:Landroid/widget/RelativeLayout;

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0044

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0045

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0038

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->n:Landroid/widget/LinearLayout;

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    const v1, 0x7f0c003c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->u:Landroid/widget/RelativeLayout;

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->u:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    invoke-static {v0}, Lls;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->m:Ljava/util/ArrayList;

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 121
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v1, 0x7f0802e8

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->o:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->p:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 128
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->q:Z

    if-eqz v0, :cond_2

    .line 129
    sget-object v0, Llu;->az:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->u:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->q:Z

    move-object v1, p0

    invoke-static/range {v0 .. v5}, Lmm;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;ZZ)Landroid/view/View;

    move-result-object v0

    .line 137
    :goto_1
    if-eqz v0, :cond_0

    .line 138
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->s:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->removeAllViews()V

    .line 139
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->s:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 142
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 144
    new-instance v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->j:Ljava/lang/String;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->i:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v0, v1, v2, p0, v3}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/app/Activity;)V

    .line 145
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 146
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 147
    const v2, 0x7f0c0048

    const-string v3, "RecentlyViewedListCard"

    invoke-virtual {v1, v2, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 148
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->c:Landroid/view/View;

    return-object v0

    .line 118
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0

    .line 133
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Llu;->y:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->i:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->i:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v1, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->u:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 135
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-boolean v10, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->q:Z

    move-object v6, p0

    move-object v8, v2

    move v9, v4

    invoke-static/range {v5 .. v10}, Lmm;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;ZZ)Landroid/view/View;

    move-result-object v0

    goto :goto_1
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 93
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 94
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 154
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    invoke-static {v0}, Lls;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->m:Ljava/util/ArrayList;

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->r:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 167
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 169
    :cond_0
    return-void

    .line 160
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->h:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method
