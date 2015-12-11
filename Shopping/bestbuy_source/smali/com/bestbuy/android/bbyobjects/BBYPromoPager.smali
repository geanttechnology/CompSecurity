.class public Lcom/bestbuy/android/bbyobjects/BBYPromoPager;
.super Landroid/widget/RelativeLayout;
.source "SourceFile"

# interfaces
.implements Lnh;


# static fields
.field private static f:Z


# instance fields
.field private a:Lkh;

.field private b:Lki;

.field private c:Landroid/os/Handler;

.field private d:Ljava/lang/Runnable;

.field private e:Landroid/support/v4/view/ViewPager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->f:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 50
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Landroid/support/v4/view/ViewPager;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->e:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method static synthetic a()Z
    .locals 1

    .prologue
    .line 32
    sget-boolean v0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->f:Z

    return v0
.end method

.method public static synthetic a(Z)Z
    .locals 0

    .prologue
    .line 32
    sput-boolean p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->f:Z

    return p0
.end method

.method static synthetic b(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->d:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->c:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Lkh;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a:Lkh;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/content/Context;Landroid/view/View;ILjava/util/List;)Ljava/lang/Object;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/view/View;",
            "I",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v3, -0x1

    .line 167
    new-instance v1, Landroid/widget/ImageView;

    invoke-direct {v1, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 168
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 169
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 170
    invoke-interface {p4, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p4, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 171
    invoke-interface {p4, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    .line 172
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v3

    invoke-virtual {v3}, Lnb;->u()I

    move-result v3

    const/16 v4, 0x280

    if-le v3, v4, :cond_1

    .line 173
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "=s640"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 179
    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 180
    const/4 v5, 0x0

    move-object v3, p0

    move v4, p3

    invoke-static/range {v0 .. v5}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;ZLjava/lang/Object;ILandroid/widget/RelativeLayout;)V

    .line 183
    :cond_0
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;

    invoke-direct {v0, p0, p4, p3}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;-><init>(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;Ljava/util/List;I)V

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 191
    check-cast p2, Landroid/support/v4/view/ViewPager;

    invoke-virtual {p2, v1, v2}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;I)V

    .line 192
    return-object v1

    .line 175
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "=s"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v3

    invoke-virtual {v3}, Lnb;->u()I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public a(ILandroid/widget/RelativeLayout;)V
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->b:Lki;

    invoke-interface {v0}, Lki;->c()V

    .line 214
    return-void
.end method

.method public a(Landroid/content/Context;Ljava/util/List;Landroid/widget/ScrollView;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;",
            "Landroid/widget/ScrollView;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, -0x1

    const/4 v3, 0x1

    .line 53
    sput-boolean v3, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->f:Z

    .line 54
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 55
    new-instance v1, Landroid/support/v4/view/ViewPager;

    invoke-direct {v1, p1}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->e:Landroid/support/v4/view/ViewPager;

    .line 56
    new-instance v1, Lkg;

    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->e:Landroid/support/v4/view/ViewPager;

    invoke-direct {v1, p0, p1, v2, p2}, Lkg;-><init>(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;Landroid/content/Context;Landroid/support/v4/view/ViewPager;Ljava/util/List;)V

    .line 57
    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->e:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 58
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->e:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1, v3}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 59
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->e:Landroid/support/v4/view/ViewPager;

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->e:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$1;

    invoke-direct {v1, p0, p3}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$1;-><init>(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;Landroid/widget/ScrollView;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 68
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->c:Landroid/os/Handler;

    .line 69
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v3, :cond_0

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->e:Landroid/support/v4/view/ViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 83
    :goto_0
    return-void

    .line 72
    :cond_0
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$2;-><init>(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->d:Ljava/lang/Runnable;

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->c:Landroid/os/Handler;

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->d:Ljava/lang/Runnable;

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method public setPromoPagerListener(Lkh;)V
    .locals 0

    .prologue
    .line 208
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a:Lkh;

    .line 209
    return-void
.end method

.method public setShowPullDownListener(Lki;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->b:Lki;

    .line 205
    return-void
.end method
