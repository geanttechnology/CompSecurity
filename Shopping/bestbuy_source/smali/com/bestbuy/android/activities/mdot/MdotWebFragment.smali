.class public Lcom/bestbuy/android/activities/mdot/MdotWebFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Landroid/view/View$OnClickListener;
.implements Lnd;


# static fields
.field private static a:Ljava/lang/String;


# instance fields
.field private A:F

.field private B:Z

.field private C:Z

.field private b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

.field private c:Landroid/webkit/CookieManager;

.field private g:Ljava/lang/String;

.field private h:Landroid/view/View;

.field private i:Ljava/lang/String;

.field private j:Z

.field private k:Ljava/lang/StringBuffer;

.field private l:Landroid/view/View;

.field private m:Z

.field private n:Z

.field private o:Z

.field private p:Ljava/lang/String;

.field private q:Landroid/widget/LinearLayout;

.field private r:Landroid/widget/LinearLayout;

.field private s:Z

.field private t:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private u:Landroid/widget/FrameLayout;

.field private v:Lnb;

.field private w:Z

.field private x:Landroid/widget/ImageView;

.field private y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

.field private z:F


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 61
    const-string v0, "&sp=&cp=1&scValue=Y&sc=Global&ev=event41%2Cevent1&channel=Enhanced&search=true&usearch=yes&usc=All+Categories&clearImgUrl=http%3A%2F%2Fimages.bestbuy.com%3A80%2FBestBuy_US%2Fmobile%2Fimages%2Fclear.png"

    sput-object v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 88
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 67
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->j:Z

    .line 68
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->k:Ljava/lang/StringBuffer;

    .line 70
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 71
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    .line 72
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->o:Z

    .line 73
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    .line 80
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->w:Z

    .line 85
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->B:Z

    .line 86
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->C:Z

    .line 89
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 91
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 67
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->j:Z

    .line 68
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->k:Ljava/lang/StringBuffer;

    .line 70
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 71
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    .line 72
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->o:Z

    .line 73
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    .line 80
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->w:Z

    .line 85
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->B:Z

    .line 86
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->C:Z

    .line 92
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 93
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 95
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 67
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->j:Z

    .line 68
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->k:Ljava/lang/StringBuffer;

    .line 70
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 71
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    .line 72
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->o:Z

    .line 73
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    .line 80
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->w:Z

    .line 85
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->B:Z

    .line 86
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->C:Z

    .line 96
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 97
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    .line 98
    return-void
.end method

.method public constructor <init>(ZZLjava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 100
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 67
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->j:Z

    .line 68
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->k:Ljava/lang/StringBuffer;

    .line 70
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 71
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    .line 72
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->o:Z

    .line 73
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    .line 80
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->w:Z

    .line 85
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->B:Z

    .line 86
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->C:Z

    .line 101
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 102
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    .line 103
    iput-object p3, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public constructor <init>(ZZZLjava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 112
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 67
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->j:Z

    .line 68
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->k:Ljava/lang/StringBuffer;

    .line 70
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 71
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    .line 72
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->o:Z

    .line 73
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    .line 80
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->w:Z

    .line 85
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->B:Z

    .line 86
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->C:Z

    .line 113
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    .line 114
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    .line 115
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->o:Z

    .line 116
    iput-object p4, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    .line 117
    iput-object p5, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    .line 118
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;F)F
    .locals 0

    .prologue
    .line 58
    iput p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->A:F

    return p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->x:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;Z)Z
    .locals 0

    .prologue
    .line 58
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->B:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)F
    .locals 1

    .prologue
    .line 58
    iget v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->z:F

    return v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;F)F
    .locals 0

    .prologue
    .line 58
    iput p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->z:F

    return p1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)F
    .locals 1

    .prologue
    .line 58
    iget v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->A:F

    return v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Z
    .locals 1

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->B:Z

    return v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    return-object v0
.end method

.method private m()V
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    const v2, 0x7f0c004a

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->u:Landroid/widget/FrameLayout;

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->u:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 199
    new-instance v2, Lcom/bestbuy/android/bbyobjects/BBYWebView;

    iget-object v3, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->l:Landroid/view/View;

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->o:Z

    if-nez v0, :cond_3

    move v0, v1

    :goto_0
    invoke-direct {v2, v3, p0, v4, v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/mdot/MdotWebFragment;Landroid/view/View;Z)V

    iput-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    .line 200
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "http://www.bestbuy.com/site/DSKU/HowItWorks_Games/pcmcat248100050001.c?id=pcmcat248100050001"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "http://www.esrb.org/ratings/ratings_guide_print_sept13.jsp"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "http://bbyoffer.appspot.com/api/v1/offer/"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "http://www.bestbuy.com/site/Help-Topics/California-Privacy-Rights/pcmcat204400050063.c?id=pcmcat204400050063"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "http://www.bestbuy.com/site/Help-Topics/Privacy-Policy/pcmcat204400050062.c?id=pcmcat204400050062"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "http://www.bestbuy.com/site/legal-privacy-policies/conditions-of-use/pcmcat204400050067.c?id=pcmcat204400050067"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "http://www.bestbuy.com/site/olspage.jsp?id=pcat17089&type=page&sellerId="

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "file:///android_asset/"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "Global-Promotions/Product-Recalls"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "http://www.bestbuy.com/site/misc/native-app/"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 209
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 214
    :cond_1
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    invoke-virtual {v0, v1}, Landroid/webkit/CookieManager;->setAcceptCookie(Z)V

    .line 216
    invoke-static {v1}, Landroid/webkit/CookieManager;->setAcceptFileSchemeCookies(Z)V

    .line 217
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->w:Z

    if-eqz v0, :cond_2

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->w:Z

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setCartEmpty(Z)V

    .line 220
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->u:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 221
    return-void

    .line 199
    :cond_3
    const/4 v0, 0x0

    goto/16 :goto_0
.end method


# virtual methods
.method public a(Landroid/webkit/WebView;)V
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->r:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 400
    return-void
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V
    .locals 4

    .prologue
    .line 362
    if-eqz p1, :cond_0

    .line 364
    :try_start_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getRefreshToken()Ljava/lang/String;

    move-result-object v1

    .line 365
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getUsername()Ljava/lang/String;

    move-result-object v0

    .line 366
    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v2, v0}, Lnb;->d(Ljava/lang/String;)V

    .line 367
    const v0, 0x7f080068

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 368
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 369
    const-string v2, "bb.rzTier"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzTierStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 370
    sget-object v0, Llu;->c:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 376
    :cond_0
    :goto_0
    return-void

    .line 372
    :catch_0
    move-exception v0

    .line 373
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 315
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    invoke-static {v0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 316
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    .line 317
    invoke-static {}, Lgw;->a()Lorg/apache/http/impl/client/DefaultHttpClient;

    move-result-object v0

    .line 318
    invoke-virtual {v0}, Lorg/apache/http/impl/client/DefaultHttpClient;->getCookieStore()Lorg/apache/http/client/CookieStore;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/client/CookieStore;->getCookies()Ljava/util/List;

    move-result-object v0

    .line 319
    if-eqz v0, :cond_1

    .line 320
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 321
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 323
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "; Domain="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getDomain()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 324
    if-eqz v0, :cond_0

    if-eqz v3, :cond_0

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 325
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v4, "bby_rdp"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 326
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    const-string v4, ".bestbuy.com"

    invoke-virtual {v0, v4, v3}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    :cond_0
    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 342
    :catch_0
    move-exception v0

    .line 343
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 345
    :goto_1
    return-void

    .line 333
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v2}, Lnb;->L()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v2}, Lnb;->M()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 335
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v2}, Lnb;->N()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 336
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v2}, Lnb;->O()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 337
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 338
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v2}, Lnb;->J()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v2}, Lnb;->K()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 341
    :cond_2
    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 348
    new-instance v0, Lio;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    const/4 v3, 0x0

    move-object v2, p0

    move-object v4, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lio;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lio;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 349
    return-void
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 490
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->C:Z

    .line 491
    return-void
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public b(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 407
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->q:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 408
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->t:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {p1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 409
    return-void
.end method

.method public c()V
    .locals 3

    .prologue
    .line 228
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v1, "file:///android_asset/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v1, "https://secure.opinionlab.com/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v1, "?"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 230
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&appvi="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->r()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    .line 236
    :cond_0
    :goto_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 237
    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    const-string v2, "https://secure.opinionlab.com/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 238
    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Ljava/lang/String;)V

    .line 239
    const v1, 0x7f08008f

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f080090

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 241
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    .line 242
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const/16 v1, 0x82

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->requestFocus(I)Z

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$1;-><init>(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 266
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$2;-><init>(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setOnScrollChangedCallback(Lkj;)V

    .line 296
    return-void

    .line 232
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "?appvi="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->r()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    goto :goto_0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->canGoBack()Z

    move-result v0

    return v0
.end method

.method public e()V
    .locals 2

    .prologue
    .line 303
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b()Ljava/lang/String;

    move-result-object v0

    .line 304
    const-string v1, "pcat17009"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 305
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->f()V

    .line 311
    :goto_0
    return-void

    .line 307
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->x:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 308
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->goBack()V

    goto :goto_0
.end method

.method public f()V
    .locals 1

    .prologue
    .line 448
    const-string v0, "http://www.bestbuy.com/cart"

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    .line 449
    invoke-direct {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m()V

    .line 450
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c()V

    .line 451
    return-void
.end method

.method public g()V
    .locals 2

    .prologue
    .line 473
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 474
    return-void
.end method

.method public h()V
    .locals 2

    .prologue
    .line 477
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 478
    return-void
.end method

.method public i()Z
    .locals 1

    .prologue
    .line 482
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getScrollY()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public j()Z
    .locals 1

    .prologue
    .line 486
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->C:Z

    return v0
.end method

.method public k()Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 494
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->x:Landroid/widget/ImageView;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 155
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 156
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->canGoBack()Z

    move-result v0

    if-nez v0, :cond_0

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Cart"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 160
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 125
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 126
    iput-object p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    .line 127
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    .line 128
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 129
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    move-object v0, p1

    .line 130
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 131
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 133
    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    :cond_0
    move-object v0, p1

    .line 135
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 136
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->n:Z

    if-eqz v0, :cond_3

    move-object v0, p1

    .line 137
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 141
    :goto_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->s:Z

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 142
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    move-object v0, p1

    .line 143
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showSearchBarWithBackButton()V

    .line 146
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->o:Z

    if-eqz v0, :cond_2

    move-object v0, p1

    .line 147
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->p:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 148
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->fragmentHasOptionsMenu(Z)V

    .line 149
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeOptionsVisibility(Z)V

    .line 151
    :cond_2
    return-void

    :cond_3
    move-object v0, p1

    .line 139
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 413
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->q:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_1

    .line 428
    :cond_0
    :goto_0
    return-void

    .line 415
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->r:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 417
    const/4 v1, 0x0

    .line 418
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 419
    const v2, 0x7f0c0033

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 420
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_2

    .line 421
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 423
    :goto_1
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 424
    :catch_0
    move-exception v0

    .line 425
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 121
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 122
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    const/high16 v6, 0x7f0b0000

    const v5, 0x7f080071

    const v4, 0x7f080059

    const v2, 0x7f080055

    const/4 v3, 0x0

    .line 164
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 165
    if-eqz v0, :cond_1

    .line 166
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 167
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g:Ljava/lang/String;

    .line 172
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 173
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->w:Z

    .line 177
    :cond_1
    const v0, 0x7f030066

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->l:Landroid/view/View;

    .line 179
    invoke-direct {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m()V

    .line 180
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->c()V

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    const v1, 0x7f0c006d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->x:Landroid/widget/ImageView;

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    const v1, 0x7f0c006e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const v1, 0x7f0b0063

    const v2, 0x7f0b0063

    invoke-virtual {v0, v6, v1, v6, v2}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setColorScheme(IIII)V

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setFromMDotWebFragment(Z)V

    .line 186
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 187
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    const v1, 0x7f0c016c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->q:Landroid/widget/LinearLayout;

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    const v1, 0x7f0c016d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->t:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    const v1, 0x7f0c0080

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->r:Landroid/widget/LinearLayout;

    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->q:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->r:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->y:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setCanChildScrollUpCallback(Lnd;)V

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h:Landroid/view/View;

    return-object v0

    .line 168
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 169
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->i:Ljava/lang/String;

    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 388
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 389
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->m:Z

    if-eqz v0, :cond_0

    .line 390
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 392
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->v:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 395
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 396
    return-void
.end method

.method public onRefresh()V
    .locals 4

    .prologue
    .line 455
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h()V

    .line 456
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;-><init>(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 470
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 432
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 433
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    if-eqz v0, :cond_0

    .line 434
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 435
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Cart"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 445
    :goto_0
    return-void

    .line 438
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 439
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    if-nez v0, :cond_1

    .line 440
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->g()V

    goto :goto_0

    .line 442
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->h()V

    goto :goto_0
.end method
