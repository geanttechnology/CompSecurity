.class public Lcom/bestbuy/android/activities/home/DODHomeCard;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private g:Landroid/view/View;

.field private h:J

.field private i:J

.field private j:Landroid/widget/RelativeLayout;

.field private k:Landroid/widget/LinearLayout;

.field private l:Landroid/view/View;

.field private m:Landroid/support/v4/app/Fragment;

.field private n:Ldu;

.field private o:Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 65
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/DODHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method private a(J)Ljava/lang/String;
    .locals 11

    .prologue
    const-wide/16 v4, 0x3c

    .line 226
    const-wide/16 v0, 0x3e8

    div-long v0, p1, v0

    rem-long/2addr v0, v4

    .line 227
    const-wide/32 v2, 0xea60

    div-long v2, p1, v2

    rem-long/2addr v2, v4

    .line 228
    const-wide/32 v4, 0x36ee80

    div-long v4, p1, v4

    const-wide/16 v6, 0x18

    rem-long/2addr v4, v6

    .line 229
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v6

    const-string v7, "%02d:%02d:%02d"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v8, v9

    const/4 v4, 0x1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v8, v4

    const/4 v2, 0x2

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    aput-object v0, v8, v2

    invoke-static {v6, v7, v8}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 230
    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/DODHomeCard;J)Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/DODHomeCard;Z)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Z)V

    return-void
.end method

.method private a(Z)V
    .locals 3

    .prologue
    .line 219
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 220
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 221
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080170

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 222
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 223
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/home/DODHomeCard;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->j:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method private c()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 190
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 191
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    .line 192
    iget-wide v4, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->h:J

    sub-long v2, v4, v2

    iput-wide v2, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->i:J

    .line 194
    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    .line 195
    invoke-virtual {v0}, Ljava/util/Date;->getHours()I

    move-result v0

    .line 197
    const/4 v1, 0x2

    if-lt v0, v1, :cond_0

    const/16 v1, 0x17

    if-gt v0, v1, :cond_0

    .line 198
    new-instance v0, Lcom/bestbuy/android/activities/home/DODHomeCard$1;

    iget-wide v2, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->i:J

    const-wide/16 v4, 0x3e8

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/home/DODHomeCard$1;-><init>(Lcom/bestbuy/android/activities/home/DODHomeCard;JJ)V

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/DODHomeCard$1;->start()Landroid/os/CountDownTimer;

    .line 216
    :goto_0
    return-void

    .line 211
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->j:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "00:00:00"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 214
    invoke-direct {p0, v6}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Z)V

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    const/4 v6, 0x1

    const/4 v3, 0x0

    .line 140
    .line 141
    if-eqz p1, :cond_3

    .line 142
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;->getDealsOfTheDay()Ljava/util/List;

    move-result-object v0

    move-object v1, v0

    .line 144
    :goto_0
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 145
    const/4 v4, 0x5

    invoke-virtual {v0, v4, v6}, Ljava/util/Calendar;->add(II)V

    .line 146
    const/16 v4, 0xb

    invoke-virtual {v0, v4, v3}, Ljava/util/Calendar;->set(II)V

    .line 147
    const/16 v4, 0xc

    invoke-virtual {v0, v4, v3}, Ljava/util/Calendar;->set(II)V

    .line 148
    const/16 v4, 0xd

    invoke-virtual {v0, v4, v3}, Ljava/util/Calendar;->set(II)V

    .line 150
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->h:J

    .line 152
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->c()V

    .line 155
    if-eqz v1, :cond_2

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 156
    new-instance v0, Lcc;

    invoke-direct {v0, v2}, Lcc;-><init>(Lcom/bestbuy/android/activities/home/DODHomeCard$1;)V

    invoke-static {v1, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 157
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move v2, v3

    .line 158
    :goto_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-ge v2, v0, :cond_0

    .line 159
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getOffers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v4, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 158
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    .line 161
    :cond_0
    new-instance v0, Ldu;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->a:Landroid/app/Activity;

    invoke-direct {v0, v2, v4, p0, v6}, Ldu;-><init>(Landroid/app/Activity;Ljava/util/List;Lcom/bestbuy/android/activities/home/DODHomeCard;Z)V

    .line 162
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->a:Landroid/app/Activity;

    invoke-static {v2}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 164
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v6, :cond_1

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 168
    :cond_1
    :goto_2
    return-void

    .line 167
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->b()V

    goto :goto_2

    :cond_3
    move-object v1, v2

    goto :goto_0
.end method

.method public a(Lgu;)V
    .locals 0

    .prologue
    .line 261
    check-cast p1, Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;

    iput-object p1, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->o:Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;

    .line 262
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v1, 0x1

    .line 234
    const-string v0, "/si/products/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 236
    new-instance v7, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 237
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "Best-Match"

    const-string v3, ""

    const-string v5, ""

    const/16 v6, 0x14

    move-object v4, p1

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 238
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->m:Landroid/support/v4/app/Fragment;

    invoke-virtual {v2}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v7, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 239
    invoke-virtual {v7, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 258
    :cond_0
    :goto_0
    return-void

    .line 241
    :cond_1
    const-string v0, ".p?"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "skuId"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 242
    invoke-static {p1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    const-string v2, "UTF-8"

    invoke-static {v0, v2}, Lorg/apache/http/client/utils/URLEncodedUtils;->parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 243
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/NameValuePair;

    .line 244
    invoke-interface {v0}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "skuId"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 245
    invoke-interface {v0}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v2

    .line 246
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v3, ""

    invoke-virtual {v0, v2, v3, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_0

    .line 251
    :cond_3
    new-instance v2, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 252
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 253
    const-string v3, "mDotURL"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "http://www.bestbuy.com"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    invoke-virtual {v2, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->m:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v2, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->k:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->k:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 122
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 114
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 115
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 69
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->a:Landroid/app/Activity;

    .line 71
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->m:Landroid/support/v4/app/Fragment;

    .line 72
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    if-nez v0, :cond_0

    .line 78
    const v0, 0x7f030036

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->g:Landroid/view/View;

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    const v1, 0x7f0c00e2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    const v1, 0x7f0c00e3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->j:Landroid/widget/RelativeLayout;

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->j:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 90
    check-cast p2, Landroid/widget/LinearLayout;

    iput-object p2, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->k:Landroid/widget/LinearLayout;

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->o:Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;)V

    .line 93
    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Z)V

    .line 96
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    return-object v0

    .line 95
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->l:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 109
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 110
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 101
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->n:Ldu;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard;->n:Ldu;

    invoke-virtual {v0}, Ldu;->notifyDataSetChanged()V

    .line 105
    :cond_0
    return-void
.end method
