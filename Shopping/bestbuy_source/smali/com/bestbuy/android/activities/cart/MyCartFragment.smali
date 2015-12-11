.class public Lcom/bestbuy/android/activities/cart/MyCartFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Lnb;

.field private b:Landroid/view/View;

.field private c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private g:Landroid/widget/Button;

.field private h:Landroid/view/View;

.field private i:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private j:Landroid/widget/LinearLayout;

.field private k:Landroid/widget/LinearLayout;

.field private l:Landroid/widget/LinearLayout;

.field private m:Landroid/widget/LinearLayout;

.field private n:Lhg;

.field private o:Landroid/widget/LinearLayout;

.field private p:Ldy;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 47
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    .line 64
    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->h:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 186
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    const-string v5, "Checkout: Cart \u2013 Empty"

    move-object v2, p1

    move-object v3, p0

    invoke-direct/range {v0 .. v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->p:Ldy;

    .line 187
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->p:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 189
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v4, :cond_0

    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 192
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "cart"

    const-string v2, "cartloadmostpopular"

    invoke-virtual {v0, v1, v2, p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->loadMostPopularRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 193
    return-void
.end method

.method public b()V
    .locals 9

    .prologue
    const/4 v6, 0x1

    const/4 v8, 0x0

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->o:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c005c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "MOST POPULAR"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 144
    new-instance v0, Lhg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->h:Landroid/view/View;

    const-string v4, "all"

    const/4 v5, 0x0

    const/16 v7, 0xa

    move-object v2, p0

    invoke-direct/range {v0 .. v8}, Lhg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;IIZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->n:Lhg;

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->n:Lhg;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 148
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->a:Lnb;

    .line 149
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    .line 150
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 151
    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 152
    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->g:Landroid/widget/Button;

    const v1, 0x7f08025a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->g:Landroid/widget/Button;

    invoke-virtual {v0, v6}, Landroid/widget/Button;->setEnabled(Z)V

    .line 158
    :goto_0
    return-void

    .line 156
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->m:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public c()V
    .locals 3

    .prologue
    .line 162
    invoke-static {}, Lfr;->a()V

    .line 163
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const-string v1, ".bestbuy.com"

    iget-object v2, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lnb;->a(Ljava/lang/String;Landroid/content/Context;)V

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->m:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_0

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    .line 167
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->f(Z)V

    .line 170
    :cond_0
    return-void
.end method

.method public d()V
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->o:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->o:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 180
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 116
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 117
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 110
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 111
    iput-object p1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    .line 112
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 10

    .prologue
    const v9, 0x7f0c0033

    const/4 v1, 0x1

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->j:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_1

    .line 198
    new-instance v8, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 199
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "MostPopular"

    const-string v3, "Most Popular"

    const-string v4, "all"

    const/4 v5, 0x0

    const-string v6, "Cart"

    const/16 v7, 0x32

    invoke-direct/range {v0 .. v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 200
    iget-object v2, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    check-cast v2, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2, v9}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 201
    instance-of v3, v2, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v3, :cond_0

    .line 202
    check-cast v2, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 203
    invoke-virtual {v2}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 209
    :goto_0
    :pswitch_0
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;

    invoke-direct {v3, p0, v2, v8, v0}, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;-><init>(Lcom/bestbuy/android/activities/cart/MyCartFragment;Lcom/bestbuy/android/activities/home/HomeTabFragment;Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    const-wide/16 v4, 0x1f4

    invoke-virtual {v1, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 234
    :cond_0
    :goto_1
    return-void

    .line 206
    :pswitch_1
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    goto :goto_0

    .line 218
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->k:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_2

    .line 219
    new-instance v2, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v2, v1, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 220
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 221
    const-string v1, "mDotURL"

    iget-object v3, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->a:Lnb;

    invoke-virtual {v3}, Lnb;->i()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    invoke-virtual {v2, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 223
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "MdotWebFragment"

    invoke-virtual {v0, v9, v2, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_1

    .line 224
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->l:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_3

    .line 225
    new-instance v2, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v2, v1, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 226
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 227
    const-string v1, "mDotURL"

    iget-object v3, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->a:Lnb;

    invoke-virtual {v3}, Lnb;->j()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    invoke-virtual {v2, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "MdotWebFragment"

    invoke-virtual {v0, v9, v2, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_1

    .line 230
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->g:Landroid/widget/Button;

    if-ne p1, v0, :cond_0

    .line 231
    new-instance v0, Lle;

    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1, p0}, Lle;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;)V

    .line 232
    invoke-virtual {v0}, Lle;->a()V

    goto :goto_1

    .line 203
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 68
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 69
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->a:Lnb;

    .line 70
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    if-nez v0, :cond_3

    .line 75
    const v0, 0x7f030069

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0173

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->o:Landroid/widget/LinearLayout;

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->h:Landroid/view/View;

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0178

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->m:Landroid/widget/LinearLayout;

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0179

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c017a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->g:Landroid/widget/Button;

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0073

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->j:Landroid/widget/LinearLayout;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0175

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->k:Landroid/widget/LinearLayout;

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0177

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->l:Landroid/widget/LinearLayout;

    .line 86
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b()V

    .line 90
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->g:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->k:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->l:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_1

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->l:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 100
    :cond_1
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080031

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 101
    if-lez v0, :cond_2

    .line 102
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->e()V

    .line 104
    :cond_2
    sput-boolean v3, Lnu;->a:Z

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    return-object v0

    .line 88
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDetach()V
    .locals 0

    .prologue
    .line 121
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDetach()V

    .line 122
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 126
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 127
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 128
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->b()V

    .line 130
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->p:Ldy;

    if-eqz v0, :cond_1

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment;->p:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 133
    :cond_1
    return-void
.end method
