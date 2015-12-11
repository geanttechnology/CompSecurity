.class public Lcom/bestbuy/android/activities/home/HomeTabFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Landroid/support/v4/app/FragmentTabHost;

.field private c:I

.field private g:Landroid/widget/RelativeLayout;

.field private h:Lnb;

.field private i:Landroid/widget/RelativeLayout;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 40
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a:Ljava/lang/String;

    .line 43
    const/4 v0, -0x1

    iput v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->c:I

    .line 50
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/HomeTabFragment;)Lnb;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->h:Lnb;

    return-object v0
.end method

.method private a(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;Landroid/support/v4/app/FragmentTabHost;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/support/v4/app/FragmentTabHost;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 157
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f030059

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 158
    const v0, 0x7f0c0141

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 159
    const v1, 0x7f0c0142

    invoke-virtual {v2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 160
    invoke-virtual {v1, p2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 161
    invoke-virtual {v0, p3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 162
    invoke-virtual {v2, p2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 163
    const-string v0, "CART"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    const v0, 0x7f0c0143

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    .line 171
    :cond_0
    invoke-virtual {v2, p0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 172
    invoke-virtual {p5, p2}, Landroid/support/v4/app/FragmentTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v0

    .line 173
    invoke-virtual {v0, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    .line 174
    invoke-virtual {p5, v0, p4, v3}, Landroid/support/v4/app/FragmentTabHost;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 175
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/FragmentTabHost;->setCurrentTab(I)V

    .line 232
    return-void
.end method

.method public b()Landroid/support/v4/app/FragmentTabHost;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    return-object v0
.end method

.method public c()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 178
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080031

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 179
    if-lez v1, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_1

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    const v2, 0x7f0c0144

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 182
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 192
    :cond_0
    :goto_0
    return-void

    .line 184
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    .line 186
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "CART"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 187
    instance-of v1, v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    if-eqz v1, :cond_0

    .line 188
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    new-instance v1, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/cart/MyCartFragment;-><init>()V

    invoke-virtual {v0, v1, v3}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method public d()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 195
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080031

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 196
    if-lez v1, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_0

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    const v2, 0x7f0c0144

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 199
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 203
    :goto_0
    return-void

    .line 201
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->g:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public e()Landroid/support/v4/app/Fragment;
    .locals 3

    .prologue
    .line 235
    const/4 v0, 0x0

    .line 236
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v1

    .line 237
    const-string v2, "HOME"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 238
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "HOME"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 246
    :cond_0
    :goto_0
    return-object v0

    .line 239
    :cond_1
    const-string v2, "PRODUCTS"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 240
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "PRODUCTS"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    goto :goto_0

    .line 241
    :cond_2
    const-string v2, "STORES"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 242
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "STORES"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    goto :goto_0

    .line 243
    :cond_3
    const-string v2, "CART"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 244
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "CART"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 138
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 139
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    .line 140
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 58
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 59
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->h:Lnb;

    .line 60
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    const v3, 0x7f0200e6

    .line 64
    const v0, 0x7f030058

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 65
    const v0, 0x7f0c013d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->i:Landroid/widget/RelativeLayout;

    .line 67
    const v0, 0x1020012

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/FragmentTabHost;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    const v4, 0x7f0c013c

    invoke-virtual {v0, v1, v2, v4}, Landroid/support/v4/app/FragmentTabHost;->setup(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;I)V

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TabWidget;->setDividerDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 70
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    const-string v2, "HOME"

    const-class v4, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    iget-object v5, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;Landroid/support/v4/app/FragmentTabHost;)V

    .line 71
    iget-object v5, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    const-string v6, "PRODUCTS"

    const v7, 0x7f02015e

    const-class v8, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    iget-object v9, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    move-object v4, p0

    invoke-direct/range {v4 .. v9}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;Landroid/support/v4/app/FragmentTabHost;)V

    .line 72
    iget-object v5, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    const-string v6, "STORES"

    const v7, 0x7f0201aa

    const-class v8, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    iget-object v9, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    move-object v4, p0

    invoke-direct/range {v4 .. v9}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;Landroid/support/v4/app/FragmentTabHost;)V

    .line 73
    iget-object v5, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    const-string v6, "CART"

    const v7, 0x7f02006b

    const-class v8, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    iget-object v9, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    move-object v4, p0

    invoke-direct/range {v4 .. v9}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;Landroid/support/v4/app/FragmentTabHost;)V

    .line 74
    iget v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->c:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    iget v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->c:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTabHost;->setCurrentTab(I)V

    .line 76
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TabWidget;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 77
    const v1, 0x7f0c0141

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 79
    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "Home"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->h:Lnb;

    const-string v1, "Home"

    invoke-virtual {v0, v1}, Lnb;->h(Ljava/lang/String;)V

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeTabFragment$1;-><init>(Lcom/bestbuy/android/activities/home/HomeTabFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    return-object v0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 143
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->h:Lnb;

    invoke-virtual {v0}, Lnb;->U()Ljava/util/Stack;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Stack;->clear()V

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->h:Lnb;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->h:Lnb;

    invoke-virtual {v1}, Lnb;->S()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnb;->i(Ljava/lang/String;)V

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->h:Lnb;

    invoke-virtual {v1}, Lnb;->S()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcl;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->i:Landroid/widget/RelativeLayout;

    invoke-interface {v0, v1}, Lcl;->sendActivateLayout(Landroid/widget/RelativeLayout;)V

    .line 150
    return-void
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    .line 251
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b:Landroid/support/v4/app/FragmentTabHost;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v0

    .line 252
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 253
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_0

    .line 254
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 255
    instance-of v1, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v1, :cond_0

    .line 256
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->c()V

    .line 259
    :cond_0
    const/4 v0, 0x1

    .line 261
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
