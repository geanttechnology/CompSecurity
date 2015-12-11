.class public Lea;
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

.field private h:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

.field private i:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZZ)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;ZZZ)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 58
    const v0, 0x7f030107

    invoke-direct {p0, p1, v0, p2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 40
    iput-boolean v1, p0, Lea;->e:Z

    .line 42
    iput-boolean v1, p0, Lea;->g:Z

    .line 59
    iput-object p2, p0, Lea;->b:Ljava/util/ArrayList;

    .line 60
    iput-object p1, p0, Lea;->d:Landroid/app/Activity;

    .line 61
    iput-boolean p4, p0, Lea;->g:Z

    .line 62
    iput-boolean p3, p0, Lea;->f:Z

    .line 63
    iput-boolean p5, p0, Lea;->i:Z

    .line 64
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lea;->a:Landroid/view/LayoutInflater;

    .line 65
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lea;->c:Lnb;

    .line 66
    return-void
.end method

.method static synthetic a(Lea;)Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lea;->h:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    return-object v0
.end method

.method private a(Landroid/net/Uri;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 173
    new-instance v0, Llf;

    iget-object v1, p0, Lea;->d:Landroid/app/Activity;

    invoke-direct {v0, v1, p1, p2, p0}, Llf;-><init>(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Llg;)V

    .line 174
    invoke-virtual {v0}, Llf;->show()V

    .line 175
    return-void
.end method

.method private a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 161
    iget-object v0, p0, Lea;->c:Lnb;

    const-string v1, "Background"

    invoke-virtual {v0, v1}, Lnb;->c(Ljava/lang/String;)V

    .line 162
    new-instance v1, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    const/4 v0, 0x0

    invoke-direct {v1, p1, p2, v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;-><init>(Lcom/bestbuy/android/api/lib/models/store/BBYStore;Ljava/lang/String;Z)V

    .line 163
    iget-object v0, p0, Lea;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 164
    const v2, 0x7f0c0033

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 165
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_0

    .line 166
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 167
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v2, "STORES"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 168
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 170
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)I
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lea;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(Z)V
    .locals 1

    .prologue
    .line 222
    const/4 v0, 0x0

    iput-boolean v0, p0, Lea;->e:Z

    .line 223
    return-void
.end method

.method public getCount()I
    .locals 2

    .prologue
    const/16 v0, 0xa

    .line 70
    iget-boolean v1, p0, Lea;->g:Z

    if-eqz v1, :cond_1

    .line 71
    iget-object v1, p0, Lea;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-le v1, v0, :cond_0

    .line 77
    :goto_0
    return v0

    .line 74
    :cond_0
    iget-object v0, p0, Lea;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    goto :goto_0

    .line 77
    :cond_1
    iget-object v0, p0, Lea;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    goto :goto_0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 34
    check-cast p1, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {p0, p1}, Lea;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7

    .prologue
    const v4, 0x7f0d0006

    const v3, 0x7f0c004c

    const/16 v6, 0x8

    const/4 v5, 0x0

    .line 88
    if-nez p2, :cond_1

    .line 89
    new-instance v1, Leb;

    invoke-direct {v1}, Leb;-><init>()V

    .line 90
    iget-object v0, p0, Lea;->a:Landroid/view/LayoutInflater;

    const v2, 0x7f030107

    invoke-virtual {v0, v2, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 91
    const v0, 0x7f0c0024

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leb;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 92
    const v0, 0x7f0c0025

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leb;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 93
    const v0, 0x7f0c0026

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leb;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 94
    const v0, 0x7f0c0027

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leb;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 95
    const v0, 0x7f0c0028

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leb;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 96
    const v0, 0x7f0c03dd

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Leb;->f:Landroid/widget/ImageView;

    .line 97
    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Leb;->g:Landroid/widget/ImageView;

    .line 98
    const v0, 0x7f0c0233

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, v1, Leb;->h:Landroid/widget/RelativeLayout;

    .line 99
    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Leb;->i:Landroid/widget/ImageView;

    .line 100
    invoke-virtual {p2, v4, v1}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 104
    :goto_0
    iget-object v0, p0, Lea;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 105
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 106
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Best Buy Mobile - "

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 107
    iget-object v3, v1, Leb;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 108
    iget-object v2, v1, Leb;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 109
    iget-object v2, v1, Leb;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 110
    iget-object v2, v1, Leb;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 111
    iget-object v2, v1, Leb;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {v0}, Lnr;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 112
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getDistance()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 113
    iget-object v2, v1, Leb;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getDistance()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "mi"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 116
    :goto_1
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLocationSubType()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Mobile Store"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 117
    iget-object v2, v1, Leb;->f:Landroid/widget/ImageView;

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 121
    :goto_2
    iget-boolean v2, p0, Lea;->f:Z

    if-eqz v2, :cond_4

    .line 122
    iget-object v2, v1, Leb;->g:Landroid/widget/ImageView;

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 126
    :goto_3
    iget-boolean v2, p0, Lea;->g:Z

    if-eqz v2, :cond_5

    .line 127
    iget-object v2, v1, Leb;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 128
    iget-object v2, v1, Leb;->h:Landroid/widget/RelativeLayout;

    new-instance v3, Lea$1;

    invoke-direct {v3, p0, v0}, Lea$1;-><init>(Lea;Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    :goto_4
    iget-object v0, p0, Lea;->d:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_0

    .line 141
    iget-object v0, v1, Leb;->i:Landroid/widget/ImageView;

    const v1, 0x7f020075

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 144
    :cond_0
    invoke-virtual {p2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 145
    return-object p2

    .line 102
    :cond_1
    invoke-virtual {p2, v4}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Leb;

    move-object v1, v0

    goto/16 :goto_0

    .line 115
    :cond_2
    iget-object v2, v1, Leb;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_1

    .line 119
    :cond_3
    iget-object v2, v1, Leb;->f:Landroid/widget/ImageView;

    invoke-virtual {v2, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2

    .line 124
    :cond_4
    iget-object v2, v1, Leb;->g:Landroid/widget/ImageView;

    invoke-virtual {v2, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_3

    .line 137
    :cond_5
    iget-object v0, v1, Leb;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_4
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 196
    iget-boolean v0, p0, Lea;->f:Z

    if-eqz v0, :cond_0

    .line 197
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 198
    if-eqz v0, :cond_0

    .line 199
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    const v2, 0x7f0c03dc

    if-ne v1, v2, :cond_0

    .line 200
    iget-boolean v1, p0, Lea;->e:Z

    if-nez v1, :cond_0

    .line 201
    iget-boolean v1, p0, Lea;->i:Z

    if-eqz v1, :cond_1

    .line 202
    iget-object v1, p0, Lea;->d:Landroid/app/Activity;

    instance-of v1, v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    if-eqz v1, :cond_0

    .line 203
    iget-object v1, p0, Lea;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    .line 218
    :cond_0
    :goto_0
    return-void

    .line 206
    :cond_1
    iget-object v1, p0, Lea;->d:Landroid/app/Activity;

    instance-of v1, v1, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v1, :cond_2

    .line 207
    const v1, 0x7f0d0006

    invoke-virtual {p1, v1}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Leb;

    .line 208
    iget-object v1, v1, Leb;->i:Landroid/widget/ImageView;

    const v2, 0x7f020074

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 209
    iget-object v1, p0, Lea;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    goto :goto_0

    .line 211
    :cond_2
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lea;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onLongClick(Landroid/view/View;)Z
    .locals 4

    .prologue
    .line 179
    const/4 v0, 0x1

    iput-boolean v0, p0, Lea;->e:Z

    .line 180
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 181
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    const v2, 0x7f0c0025

    if-eq v1, v2, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    const v2, 0x7f0c0026

    if-ne v1, v2, :cond_1

    .line 182
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 183
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 184
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lea;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801d0

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lea;->c:Lnb;

    invoke-virtual {v2}, Lnb;->y()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lea;->c:Lnb;

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

    .line 189
    invoke-direct {p0, v1, v0}, Lea;->a(Landroid/net/Uri;Ljava/lang/String;)V

    .line 191
    :cond_1
    const/4 v0, 0x0

    return v0
.end method
