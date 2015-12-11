.class public Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "AmazonMASHTestActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;
    }
.end annotation


# instance fields
.field private final MASH11_TEST_PAGE_URL:Ljava/lang/String;

.field private final MASH12_TEST_PAGE_URL:Ljava/lang/String;

.field private final MASH13_TEST_PAGE_URL:Ljava/lang/String;

.field private final MASH14_TEST_PAGE_URL:Ljava/lang/String;

.field private final MASH15_TEST_PAGE_URL:Ljava/lang/String;

.field private final MASH16_TEST_PAGE_URL:Ljava/lang/String;

.field private final MASH_COOKIE_TEST_PAGE_URL:Ljava/lang/String;

.field private final MASH_TEST_HOME_PAGE_URL:Ljava/lang/String;

.field private mash11Test:Landroid/widget/Button;

.field private mash11Url:Landroid/widget/EditText;

.field private mash12Test:Landroid/widget/Button;

.field private mash12Url:Landroid/widget/EditText;

.field private mash13Test:Landroid/widget/Button;

.field private mash13Url:Landroid/widget/EditText;

.field private mash14Test:Landroid/widget/Button;

.field private mash14Url:Landroid/widget/EditText;

.field private mash15Test:Landroid/widget/Button;

.field private mash15Url:Landroid/widget/EditText;

.field private mash16Test:Landroid/widget/Button;

.field private mash16Url:Landroid/widget/EditText;

.field private mashCookieTest:Landroid/widget/Button;

.field private mashCookieUrl:Landroid/widget/EditText;

.field private mashTestHome:Landroid/widget/Button;

.field private mashTestHomeUrl:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 19
    const-string/jumbo v0, "https://mash-test.integ.amazon.com/mash-api-11.html"

    iput-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->MASH11_TEST_PAGE_URL:Ljava/lang/String;

    .line 20
    const-string/jumbo v0, "https://mash-test.integ.amazon.com/mash-api-12.html"

    iput-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->MASH12_TEST_PAGE_URL:Ljava/lang/String;

    .line 21
    const-string/jumbo v0, "https://mash-test.integ.amazon.com/mash-api-13.html"

    iput-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->MASH13_TEST_PAGE_URL:Ljava/lang/String;

    .line 22
    const-string/jumbo v0, "https://mash-test.integ.amazon.com/mash-api-14.html"

    iput-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->MASH14_TEST_PAGE_URL:Ljava/lang/String;

    .line 23
    const-string/jumbo v0, "https://mash-test.integ.amazon.com/mash-api-15.html"

    iput-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->MASH15_TEST_PAGE_URL:Ljava/lang/String;

    .line 24
    const-string/jumbo v0, "https://mash-test.integ.amazon.com/mash-api-16.html"

    iput-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->MASH16_TEST_PAGE_URL:Ljava/lang/String;

    .line 25
    const-string/jumbo v0, "https://mash-test.integ.amazon.com/MASHCookie.html"

    iput-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->MASH_COOKIE_TEST_PAGE_URL:Ljava/lang/String;

    .line 26
    const-string/jumbo v0, "https://mash-test.integ.amazon.com/mash-test-home.html"

    iput-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->MASH_TEST_HOME_PAGE_URL:Ljava/lang/String;

    .line 51
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Url:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/EditText;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Url:Landroid/widget/EditText;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Test:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Url:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1002(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/EditText;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Url:Landroid/widget/EditText;

    return-object p1
.end method

.method static synthetic access$102(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/Button;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Test:Landroid/widget/Button;

    return-object p1
.end method

.method static synthetic access$1100(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Test:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$1102(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/Button;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Test:Landroid/widget/Button;

    return-object p1
.end method

.method static synthetic access$1200(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieUrl:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1202(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/EditText;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieUrl:Landroid/widget/EditText;

    return-object p1
.end method

.method static synthetic access$1300(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieTest:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$1302(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/Button;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieTest:Landroid/widget/Button;

    return-object p1
.end method

.method static synthetic access$1400(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHomeUrl:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1402(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/EditText;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHomeUrl:Landroid/widget/EditText;

    return-object p1
.end method

.method static synthetic access$1500(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHome:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$1502(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/Button;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHome:Landroid/widget/Button;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Url:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$202(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/EditText;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Url:Landroid/widget/EditText;

    return-object p1
.end method

.method static synthetic access$300(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Test:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/Button;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Test:Landroid/widget/Button;

    return-object p1
.end method

.method static synthetic access$400(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Url:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/EditText;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Url:Landroid/widget/EditText;

    return-object p1
.end method

.method static synthetic access$500(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Test:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$502(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/Button;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Test:Landroid/widget/Button;

    return-object p1
.end method

.method static synthetic access$600(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Url:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$602(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/EditText;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Url:Landroid/widget/EditText;

    return-object p1
.end method

.method static synthetic access$700(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Test:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$702(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/Button;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Test:Landroid/widget/Button;

    return-object p1
.end method

.method static synthetic access$800(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Url:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$802(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/EditText;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Url:Landroid/widget/EditText;

    return-object p1
.end method

.method static synthetic access$900(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Test:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$902(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
    .param p1, "x1"    # Landroid/widget/Button;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Test:Landroid/widget/Button;

    return-object p1
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 47
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 48
    new-instance v0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;

    invoke-direct {v0, p0, p0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;-><init>(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->setRootView(Landroid/view/View;)V

    .line 49
    return-void
.end method
