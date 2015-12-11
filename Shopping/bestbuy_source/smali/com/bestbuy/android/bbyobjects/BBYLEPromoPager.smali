.class public Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;
.super Landroid/widget/RelativeLayout;
.source "SourceFile"


# static fields
.field private static e:Z


# instance fields
.field private a:Lke;

.field private b:Landroid/os/Handler;

.field private c:Ljava/lang/Runnable;

.field private d:Landroid/support/v4/view/ViewPager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->e:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 34
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 38
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 42
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)Landroid/support/v4/view/ViewPager;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->d:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method static synthetic a()Z
    .locals 1

    .prologue
    .line 25
    sget-boolean v0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->e:Z

    return v0
.end method

.method public static synthetic a(Z)Z
    .locals 0

    .prologue
    .line 25
    sput-boolean p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->e:Z

    return p0
.end method

.method static synthetic b(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->c:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->b:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)Lke;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a:Lke;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/content/Context;Landroid/view/View;ILjava/util/List;)Ljava/lang/Object;
    .locals 5
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
    const/4 v4, 0x0

    const/4 v2, -0x1

    .line 155
    new-instance v1, Landroid/widget/ImageView;

    invoke-direct {v1, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 156
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 157
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 158
    invoke-interface {p4, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    .line 159
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v2

    invoke-virtual {v2}, Lnb;->u()I

    move-result v2

    const/16 v3, 0x280

    if-le v2, v3, :cond_1

    .line 160
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "=s640"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 165
    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 166
    invoke-static {v0, v1, v4}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 168
    :cond_0
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$3;

    invoke-direct {v0, p0, p4, p3}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$3;-><init>(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;Ljava/util/List;I)V

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 174
    check-cast p2, Landroid/support/v4/view/ViewPager;

    invoke-virtual {p2, v1, v4}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;I)V

    .line 175
    return-object v1

    .line 162
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "=s"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v2

    invoke-virtual {v2}, Lnb;->u()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
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

    .line 45
    sput-boolean v3, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->e:Z

    .line 46
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 47
    new-instance v1, Landroid/support/v4/view/ViewPager;

    invoke-direct {v1, p1}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->d:Landroid/support/v4/view/ViewPager;

    .line 48
    new-instance v1, Lkd;

    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->d:Landroid/support/v4/view/ViewPager;

    invoke-direct {v1, p0, p1, v2, p2}, Lkd;-><init>(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;Landroid/content/Context;Landroid/support/v4/view/ViewPager;Ljava/util/List;)V

    .line 49
    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->d:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 50
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->d:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1, v3}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 51
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->d:Landroid/support/v4/view/ViewPager;

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->d:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$1;

    invoke-direct {v1, p0, p3}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$1;-><init>(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;Landroid/widget/ScrollView;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 60
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->b:Landroid/os/Handler;

    .line 61
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v3, :cond_0

    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->d:Landroid/support/v4/view/ViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 75
    :goto_0
    return-void

    .line 64
    :cond_0
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager$2;-><init>(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;)V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->c:Ljava/lang/Runnable;

    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->b:Landroid/os/Handler;

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->c:Ljava/lang/Runnable;

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method public setPromoPagerListener(Lke;)V
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a:Lke;

    .line 184
    return-void
.end method
