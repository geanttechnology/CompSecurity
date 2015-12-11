.class public Ldq;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/view/View$OnLongClickListener;
.implements Llg;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
        ">;",
        "Landroid/view/View$OnClickListener;",
        "Landroid/view/View$OnLongClickListener;",
        "Llg;"
    }
.end annotation


# instance fields
.field private a:Landroid/view/LayoutInflater;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private c:Lnb;

.field private d:Landroid/app/Activity;

.field private e:Z

.field private f:Z

.field private g:Z

.field private h:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private i:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZLcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;ZZ",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 52
    const v0, 0x7f030107

    invoke-direct {p0, p1, v0, p2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 45
    iput-boolean v1, p0, Ldq;->e:Z

    .line 47
    iput-boolean v1, p0, Ldq;->g:Z

    .line 53
    iput-object p2, p0, Ldq;->b:Ljava/util/ArrayList;

    .line 54
    iput-object p1, p0, Ldq;->d:Landroid/app/Activity;

    .line 55
    iput-boolean p4, p0, Ldq;->g:Z

    .line 56
    iput-boolean p3, p0, Ldq;->f:Z

    .line 57
    iput-object p5, p0, Ldq;->h:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 58
    iput-object p6, p0, Ldq;->i:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 59
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldq;->a:Landroid/view/LayoutInflater;

    .line 60
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Ldq;->c:Lnb;

    .line 61
    return-void
.end method

.method static synthetic a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Ldq;->h:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method private a(Landroid/net/Uri;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 207
    new-instance v0, Llf;

    iget-object v1, p0, Ldq;->d:Landroid/app/Activity;

    invoke-direct {v0, v1, p1, p2, p0}, Llf;-><init>(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Llg;)V

    .line 208
    invoke-virtual {v0}, Llf;->show()V

    .line 209
    return-void
.end method

.method private a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 195
    iget-object v0, p0, Ldq;->c:Lnb;

    const-string v1, "Background"

    invoke-virtual {v0, v1}, Lnb;->c(Ljava/lang/String;)V

    .line 196
    new-instance v1, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    const/4 v0, 0x0

    invoke-direct {v1, p1, p2, v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;-><init>(Lcom/bestbuy/android/api/lib/models/store/BBYStore;Ljava/lang/String;Z)V

    .line 197
    iget-object v0, p0, Ldq;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 198
    const v2, 0x7f0c0033

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 199
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_0

    .line 200
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 201
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v2, "STORES"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 202
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 204
    :cond_0
    return-void
.end method

.method static synthetic b(Ldq;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Ldq;->i:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method

.method static synthetic c(Ldq;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Ldq;->d:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)I
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Ldq;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(Z)V
    .locals 1

    .prologue
    .line 243
    const/4 v0, 0x0

    iput-boolean v0, p0, Ldq;->e:Z

    .line 244
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Ldq;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 39
    check-cast p1, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {p0, p1}, Ldq;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8

    .prologue
    const v3, 0x7f0d0006

    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 94
    if-nez p2, :cond_3

    .line 95
    new-instance v1, Ldr;

    invoke-direct {v1}, Ldr;-><init>()V

    .line 96
    iget-object v0, p0, Ldq;->a:Landroid/view/LayoutInflater;

    const v2, 0x7f030107

    invoke-virtual {v0, v2, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 97
    const v0, 0x7f0c0024

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Ldr;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 98
    const v0, 0x7f0c0025

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Ldr;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 99
    const v0, 0x7f0c0026

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Ldr;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 100
    const v0, 0x7f0c0027

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Ldr;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 101
    const v0, 0x7f0c0028

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Ldr;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 102
    const v0, 0x7f0c03dd

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Ldr;->g:Landroid/widget/ImageView;

    .line 103
    const v0, 0x7f0c004c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Ldr;->h:Landroid/widget/ImageView;

    .line 104
    const v0, 0x7f0c0233

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, v1, Ldr;->i:Landroid/widget/RelativeLayout;

    .line 105
    const v0, 0x7f0c0220

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Ldr;->j:Landroid/widget/LinearLayout;

    .line 106
    const v0, 0x7f0c03de

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Ldr;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 107
    invoke-virtual {p2, v3, v1}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 111
    :goto_0
    iget-object v0, p0, Ldq;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 112
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v3

    .line 113
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 114
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v4, "Best Buy Mobile - "

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 115
    iget-object v4, v1, Ldr;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 116
    iget-object v2, v1, Ldr;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 117
    iget-object v2, v1, Ldr;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 118
    iget-object v2, v1, Ldr;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 119
    iget-object v2, v1, Ldr;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {v0}, Lnr;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 120
    iget-object v2, v1, Ldr;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getDistance()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "mi"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 121
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v4

    .line 122
    const/4 v2, 0x0

    .line 123
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 124
    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v4

    .line 125
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 126
    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;->getPickupMessage()Ljava/lang/String;

    move-result-object v2

    .line 129
    :cond_0
    if-eqz v2, :cond_1

    .line 130
    iget-object v4, v1, Ldr;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 132
    :cond_1
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Mobile"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 133
    iget-object v2, v1, Ldr;->g:Landroid/widget/ImageView;

    invoke-virtual {v2, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 137
    :goto_1
    iget-boolean v2, p0, Ldq;->f:Z

    if-eqz v2, :cond_5

    .line 138
    iget-object v2, v1, Ldr;->h:Landroid/widget/ImageView;

    invoke-virtual {v2, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 142
    :goto_2
    iget-boolean v2, p0, Ldq;->g:Z

    if-eqz v2, :cond_8

    .line 143
    iget-object v2, p0, Ldq;->i:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Ldq;->i:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 144
    iget-object v2, p0, Ldq;->i:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ldq;->d:Landroid/app/Activity;

    const v4, 0x7f080029

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 145
    iget-object v0, v1, Ldr;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 146
    iget-object v0, v1, Ldr;->j:Landroid/widget/LinearLayout;

    new-instance v1, Ldq$1;

    invoke-direct {v1, p0}, Ldq$1;-><init>(Ldq;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 177
    :cond_2
    :goto_3
    invoke-virtual {p2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 178
    return-object p2

    .line 109
    :cond_3
    invoke-virtual {p2, v3}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ldr;

    move-object v1, v0

    goto/16 :goto_0

    .line 135
    :cond_4
    iget-object v2, v1, Ldr;->g:Landroid/widget/ImageView;

    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1

    .line 140
    :cond_5
    iget-object v2, v1, Ldr;->h:Landroid/widget/ImageView;

    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2

    .line 155
    :cond_6
    iget-object v2, v1, Ldr;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 156
    iget-object v2, p0, Ldq;->i:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isCommerceUnavailable()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 157
    iget-object v2, v1, Ldr;->i:Landroid/widget/RelativeLayout;

    const v3, 0x7f020009

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 159
    :cond_7
    iget-object v1, v1, Ldr;->i:Landroid/widget/RelativeLayout;

    new-instance v2, Ldq$2;

    invoke-direct {v2, p0, v0}, Ldq$2;-><init>(Ldq;Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_3

    .line 175
    :cond_8
    iget-object v0, v1, Ldr;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_3
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 230
    iget-boolean v0, p0, Ldq;->f:Z

    if-eqz v0, :cond_0

    .line 231
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 232
    if-eqz v0, :cond_0

    .line 233
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    const v2, 0x7f0c03dc

    if-ne v1, v2, :cond_0

    .line 234
    iget-boolean v1, p0, Ldq;->e:Z

    if-nez v1, :cond_0

    .line 235
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Ldq;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;Ljava/lang/String;)V

    .line 239
    :cond_0
    return-void
.end method

.method public onLongClick(Landroid/view/View;)Z
    .locals 4

    .prologue
    .line 213
    const/4 v0, 0x1

    iput-boolean v0, p0, Ldq;->e:Z

    .line 214
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/remix/Store;

    .line 215
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    const v2, 0x7f0c0025

    if-eq v1, v2, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    const v2, 0x7f0c0026

    if-ne v1, v2, :cond_1

    .line 216
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getCity()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getRegion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getPostalCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 217
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 218
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Ldq;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801d0

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ldq;->c:Lnb;

    invoke-virtual {v2}, Lnb;->y()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ldq;->c:Lnb;

    invoke-virtual {v2}, Lnb;->z()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&daddr="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&hl=en"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 223
    invoke-direct {p0, v1, v0}, Ldq;->a(Landroid/net/Uri;Ljava/lang/String;)V

    .line 225
    :cond_1
    const/4 v0, 0x0

    return v0
.end method
