.class public Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lke;


# instance fields
.field private a:Landroid/widget/FrameLayout;

.field private b:Landroid/widget/FrameLayout;

.field private c:Lhp;

.field private g:Landroid/widget/LinearLayout;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

.field private i:Landroid/view/View;

.field private j:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 38
    return-void
.end method

.method private c()V
    .locals 3

    .prologue
    .line 61
    new-instance v0, Lhp;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->a:Landroid/widget/FrameLayout;

    invoke-direct {v0, v1, p0, v2}, Lhp;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->c:Lhp;

    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->c:Lhp;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhp;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 63
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/offers/Offer;)V
    .locals 4

    .prologue
    .line 109
    new-instance v1, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;

    invoke-direct {v1, p1}, Lcom/bestbuy/android/activities/registry/WebWrapperContainer;-><init>(Lcom/bestbuy/android/api/lib/models/offers/Offer;)V

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 111
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 112
    const v2, 0x7f0c0033

    const-string v3, "WebWrapperContainer"

    invoke-virtual {v0, v2, v1, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 113
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 114
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 115
    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->g:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 76
    :cond_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->j:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->setVisibility(I)V

    .line 79
    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    .line 80
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    .line 81
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 82
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->j:Landroid/widget/ImageView;

    invoke-static {v1, v2, v3}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 84
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->j:Landroid/widget/ImageView;

    new-instance v2, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard$1;

    invoke-direct {v2, p0, v0}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard$1;-><init>(Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;Lcom/bestbuy/android/api/lib/models/offers/Offer;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->a:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v4}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 98
    return-void

    .line 92
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a(Landroid/content/Context;Ljava/util/List;Landroid/widget/ScrollView;)V

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->setPromoPagerListener(Lke;)V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->j:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->setVisibility(I)V

    goto :goto_0
.end method

.method public b()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->g:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->g:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->b:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->a:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 106
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->d:Landroid/app/Activity;

    .line 44
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    :cond_0
    const v0, 0x7f03005e

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->a:Landroid/widget/FrameLayout;

    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    const v1, 0x7f0c010a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->b:Landroid/widget/FrameLayout;

    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->b:Landroid/widget/FrameLayout;

    const v1, 0x7f0c010b

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    const v1, 0x7f0c010c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->j:Landroid/widget/ImageView;

    .line 53
    check-cast p2, Landroid/widget/LinearLayout;

    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->g:Landroid/widget/LinearLayout;

    .line 54
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->c()V

    .line 57
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    return-object v0

    .line 56
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->i:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 66
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 67
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->c()V

    .line 70
    :cond_0
    return-void
.end method
