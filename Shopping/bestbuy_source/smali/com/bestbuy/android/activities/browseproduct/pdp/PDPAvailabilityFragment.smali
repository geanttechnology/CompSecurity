.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/view/View;

.field private c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/widget/LinearLayout;

.field private i:Landroid/widget/LinearLayout;

.field private j:Landroid/widget/LinearLayout;

.field private k:Landroid/widget/LinearLayout;

.field private l:Landroid/widget/LinearLayout;

.field private m:Landroid/widget/LinearLayout;

.field private n:Landroid/widget/LinearLayout;

.field private o:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

.field private p:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 56
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 60
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->o:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 61
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    return-void
.end method

.method private a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V
    .locals 5

    .prologue
    .line 453
    :try_start_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->d:Landroid/app/Activity;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 454
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v1, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const v2, 0x7f0c0033

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 455
    instance-of v1, v2, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_0

    .line 456
    move-object v0, v2

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    move-object v1, v0

    .line 457
    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 458
    check-cast v1, Lcom/bestbuy/android/activities/BaseTabContainer;

    const/4 v3, 0x1

    invoke-virtual {v1, p1, v3}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 461
    :cond_0
    instance-of v1, v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v1, :cond_1

    .line 462
    move-object v0, v2

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    move-object v1, v0

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 463
    instance-of v1, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v1, :cond_1

    .line 464
    check-cast v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    const/4 v1, 0x1

    invoke-virtual {v2, p1, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 471
    :cond_1
    :goto_0
    return-void

    .line 468
    :catch_0
    move-exception v1

    .line 469
    const-string v2, "PDPAvailabilityFragment"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error attempting to open delievery mDot punch out"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private a(Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    const v1, 0x7f0c01f9

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 129
    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 130
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    const v2, 0x7f0c01fa

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 131
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 132
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getStoreName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", Pickup Today"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 133
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->p:I

    const/4 v2, 0x1

    if-le v0, v2, :cond_0

    .line 134
    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 135
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)V

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    const v1, 0x7f0c01f8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 144
    const v1, 0x7f020148

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0200

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 146
    const v1, 0x7f020144

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0201

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 148
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802a1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 149
    return-void
.end method

.method private c()V
    .locals 10

    .prologue
    const v6, 0x7f0c01f9

    const/4 v4, 0x1

    const v9, 0x7f0802ac

    const/16 v8, 0x8

    const/4 v3, 0x0

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    const v1, 0x7f0c01fa

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 153
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 154
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 155
    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 156
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v2, :cond_b

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v2

    if-eqz v2, :cond_b

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v2

    if-eqz v2, :cond_b

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    move-result-object v2

    if-eqz v2, :cond_b

    .line 157
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    move-result-object v5

    .line 158
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->isAvailable()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 159
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v6

    .line 161
    if-eqz v6, :cond_0

    .line 162
    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 163
    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getAvailabilityType()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 164
    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getAvailabilityType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v9}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 165
    if-eqz v5, :cond_1

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    move v2, v3

    .line 171
    :goto_0
    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_c

    .line 172
    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v3

    const v7, 0x7f080029

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_c

    move v3, v4

    .line 179
    :cond_0
    :goto_1
    if-eqz v3, :cond_2

    .line 180
    invoke-virtual {v0, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 181
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getDisplayMessage()Ljava/lang/String;

    move-result-object v0

    .line 182
    const-string v2, "<b>([^<]*)</b>:"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "<b>([^<]*)</b>"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 183
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 255
    :goto_2
    return-void

    :cond_1
    move v2, v4

    .line 168
    goto :goto_0

    .line 185
    :cond_2
    const/4 v2, 0x0

    .line 186
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    move-result-object v3

    if-eqz v3, :cond_5

    .line 187
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;->getStoreName()Ljava/lang/String;

    move-result-object v2

    .line 194
    :cond_3
    :goto_3
    if-eqz v2, :cond_7

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_7

    .line 195
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    move-result-object v3

    if-eqz v3, :cond_6

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;->getPickupMessage()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_6

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;->getPickupMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_6

    .line 196
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/home/availability/InStoreAvailability;->getPickupMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 198
    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 207
    :cond_4
    :goto_4
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;

    invoke-direct {v1, p0, v6, v5}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_2

    .line 188
    :cond_5
    if-eqz v6, :cond_3

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v3

    if-eqz v3, :cond_3

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getAvailabilityType()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_3

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getAvailabilityType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v9}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 190
    if-eqz v5, :cond_3

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v3

    if-eqz v3, :cond_3

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_3

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_3

    .line 191
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getDisplayMessage()Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_3

    .line 199
    :cond_6
    if-eqz v6, :cond_4

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v3

    if-eqz v3, :cond_4

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getAvailabilityType()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_4

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getAvailabilityType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v9}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 200
    if-eqz v5, :cond_4

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v3

    if-eqz v3, :cond_4

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_4

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    .line 201
    const-string v3, "<b>([^<]*)</b>:"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "<b>([^<]*)</b>"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 202
    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    .line 206
    :cond_7
    invoke-virtual {v1, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_4

    .line 238
    :cond_8
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    const v4, 0x7f0c01f8

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 239
    const v4, 0x7f020147

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 240
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 241
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Pickup;->getDisplayMessage()Ljava/lang/String;

    move-result-object v4

    .line 242
    const-string v5, "<b>([^<]*)</b>"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 243
    if-eqz v4, :cond_9

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_a

    .line 244
    :cond_9
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v4, 0x7f0802a1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 247
    :goto_5
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 248
    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 249
    invoke-virtual {v0, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_2

    .line 246
    :cond_a
    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v1, v4

    goto :goto_5

    .line 253
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_2

    :cond_c
    move v3, v2

    goto/16 :goto_1

    :cond_d
    move v2, v3

    goto/16 :goto_0
.end method


# virtual methods
.method public b()V
    .locals 10

    .prologue
    const v9, 0x7f0c0200

    const v8, 0x7f0802a1

    const v7, 0x7f020144

    const/16 v6, 0x8

    const/4 v5, 0x0

    .line 259
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c()V

    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getShip()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;

    move-result-object v2

    .line 262
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0201

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 263
    if-eqz v2, :cond_4

    .line 264
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 265
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_e

    .line 267
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 268
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    const-string v3, "<b>([^<]*)</b>:"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v3, "<b>([^<]*)</b>"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 269
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 271
    :cond_0
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->isSignatureRequired()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 272
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0202

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 273
    invoke-virtual {v1, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 274
    new-instance v3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$3;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)V

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 285
    :cond_1
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getCheckLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getCheckLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getCheckLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_2

    .line 286
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0203

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 287
    invoke-virtual {v1, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 288
    new-instance v3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$4;

    invoke-direct {v3, p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$4;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;)V

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 299
    :cond_2
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->o:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v1, :cond_4

    .line 300
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 301
    invoke-virtual {v1, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 302
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 303
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 321
    :cond_4
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getDelivery()Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 322
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getDelivery()Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;

    move-result-object v0

    .line 324
    if-eqz v0, :cond_5

    .line 325
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_10

    .line 326
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 327
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->getCheckLink()Lcom/bestbuy/android/api/lib/models/home/availability/CheckLink;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 328
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->getCheckLink()Lcom/bestbuy/android/api/lib/models/home/availability/CheckLink;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/availability/CheckLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 329
    if-eqz v1, :cond_5

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 330
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0207

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 331
    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 332
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$5;

    invoke-direct {v2, p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Ljava/lang/String;)V

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 354
    :cond_5
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getDownload()Lcom/bestbuy/android/api/lib/models/home/availability/Download;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 355
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getDownload()Lcom/bestbuy/android/api/lib/models/home/availability/Download;

    move-result-object v3

    .line 356
    if-eqz v3, :cond_7

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/home/availability/Download;->isAvailable()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 357
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 358
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    const v1, 0x7f0c020b

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 359
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    const v2, 0x7f0c020a

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 360
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/home/availability/Download;->isAvailable()Z

    move-result v2

    if-nez v2, :cond_6

    .line 361
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    const v4, 0x7f0c0209

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 362
    const v4, 0x7f02013c

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 363
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/home/availability/Download;->getDisplayMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 365
    :cond_6
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$6;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$6;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 379
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getInStoreOnly()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;

    move-result-object v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getInStoreOnly()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->isAvailable()Z

    move-result v0

    if-eqz v0, :cond_b

    .line 380
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 381
    const/4 v1, 0x0

    .line 382
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->n:Landroid/widget/LinearLayout;

    const v2, 0x7f0c01fe

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 383
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getInStoreOnly()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->getCheckLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v2

    if-eqz v2, :cond_8

    .line 384
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;->getInStoreOnly()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->getCheckLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 386
    :cond_8
    if-eqz v1, :cond_9

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_a

    .line 387
    :cond_9
    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 388
    :cond_a
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$7;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$7;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 408
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_c

    .line 409
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isSpecialOrderDelivery()Z

    move-result v0

    .line 410
    if-eqz v0, :cond_11

    .line 411
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 412
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c020d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 413
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$8;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$8;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 437
    :cond_c
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->l:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 440
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a:Landroid/view/View;

    if-eqz v0, :cond_d

    .line 441
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 443
    :cond_d
    return-void

    .line 307
    :cond_e
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 308
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 309
    invoke-virtual {v1, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 310
    if-eqz v2, :cond_f

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_f

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_f

    .line 311
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    const-string v2, "<b>([^<]*)</b>:"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "<b>([^<]*)</b>"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 312
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 314
    :cond_f
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 345
    :cond_10
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 346
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0205

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 347
    const v1, 0x7f02013a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 348
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0206

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 349
    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 428
    :cond_11
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_2
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 72
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 73
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 121
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 122
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->d:Landroid/app/Activity;

    .line 123
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 64
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 65
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 66
    const-string v1, "NumOfStores"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 67
    const-string v1, "NumOfStores"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->p:I

    .line 69
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    if-nez v0, :cond_1

    .line 88
    const v0, 0x7f030089

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a:Landroid/view/View;

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c01f6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->m:Landroid/widget/LinearLayout;

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c01ff

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->g:Landroid/widget/LinearLayout;

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0204

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0208

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c01f7

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c020c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->k:Landroid/widget/LinearLayout;

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c020e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->l:Landroid/widget/LinearLayout;

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    const v1, 0x7f0c01fb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->n:Landroid/widget/LinearLayout;

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->o:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-nez v0, :cond_0

    .line 99
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b()V

    .line 108
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    return-object v0

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->o:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;)V

    goto :goto_0

    .line 106
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 82
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 83
    return-void
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 77
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroyView()V

    .line 78
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 112
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 117
    return-void
.end method
