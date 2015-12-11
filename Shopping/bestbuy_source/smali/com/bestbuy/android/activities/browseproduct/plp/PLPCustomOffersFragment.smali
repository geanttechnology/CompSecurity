.class public Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/widget/ListView;

.field private c:Landroid/view/View;

.field private g:Lhf;

.field private h:Ldw;

.field private i:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private j:Ljava/lang/String;

.field private k:Lnb;

.field private l:Landroid/widget/RelativeLayout;

.field private m:Landroid/widget/LinearLayout;

.field private n:Landroid/widget/LinearLayout;

.field private o:Landroid/widget/ImageView;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;


# direct methods
.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->i:Ljava/util/ArrayList;

    return-object v0
.end method

.method private a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V
    .locals 4

    .prologue
    .line 171
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 173
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_0

    .line 174
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 175
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 176
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 181
    :cond_0
    :goto_0
    return-void

    .line 178
    :catch_0
    move-exception v0

    .line 179
    const-string v1, "PLPCustomOffersFragment"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error attempting to open delievery mDot punch out"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 10

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 144
    const-string v0, "/si/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 145
    new-instance v0, Lhf;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    const-string v4, "Best-Match"

    const/16 v5, 0x14

    const/4 v8, 0x0

    move-object v2, p0

    move-object v3, p1

    move v9, v7

    invoke-direct/range {v0 .. v9}, Lhf;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;IIZLandroid/view/View;Z)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->g:Lhf;

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->g:Lhf;

    new-array v1, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhf;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 166
    :cond_0
    :goto_0
    return-void

    .line 147
    :cond_1
    const-string v0, "/site/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 149
    const-string v0, ".p?"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "skuId"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 150
    invoke-static {p1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    const-string v1, "UTF-8"

    invoke-static {v0, v1}, Lorg/apache/http/client/utils/URLEncodedUtils;->parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 151
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/NameValuePair;

    .line 152
    invoke-interface {v0}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "skuId"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 153
    invoke-interface {v0}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, ""

    invoke-virtual {v0, v1, v2, v6}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_0

    .line 159
    :cond_3
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v7}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 160
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 161
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "http://www.bestbuy.com"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 163
    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    goto :goto_0
.end method

.method public a(Ljava/util/List;Z)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->p:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->p:Ljava/lang/String;

    const v1, 0x7f080077

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->o:Landroid/widget/ImageView;

    const v1, 0x7f020168

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 135
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->l:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 137
    new-instance v0, Ldw;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    const v2, 0x7f0300bb

    invoke-direct {v0, v1, p0, v2, p1}, Ldw;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/List;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->h:Ldw;

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->h:Ldw;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 140
    return-void

    .line 126
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->p:Ljava/lang/String;

    const v1, 0x7f080075

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->o:Landroid/widget/ImageView;

    const v1, 0x7f020158

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 128
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->p:Ljava/lang/String;

    const v1, 0x7f08012a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->o:Landroid/widget/ImageView;

    const v1, 0x7f02007a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 130
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->p:Ljava/lang/String;

    const v1, 0x7f08006c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->o:Landroid/widget/ImageView;

    const v1, 0x7f020133

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 133
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 85
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 63
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 64
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 65
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 66
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->k:Lnb;

    .line 67
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 78
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 79
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    if-nez v0, :cond_0

    .line 95
    const v0, 0x7f0300ba

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->c:Landroid/view/View;

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00bd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->m:Landroid/widget/LinearLayout;

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0075

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->b:Landroid/widget/ListView;

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00b9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->l:Landroid/widget/RelativeLayout;

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00be

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 101
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00c2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->o:Landroid/widget/ImageView;

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00c1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->n:Landroid/widget/LinearLayout;

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->b:Landroid/widget/ListView;

    const/high16 v1, -0x80000000

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 105
    new-instance v0, Lhh;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->c:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->q:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Lhh;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    .line 106
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhh;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 109
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->b:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    return-object v0

    .line 108
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 89
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 90
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 71
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 73
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->k:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 75
    return-void
.end method
