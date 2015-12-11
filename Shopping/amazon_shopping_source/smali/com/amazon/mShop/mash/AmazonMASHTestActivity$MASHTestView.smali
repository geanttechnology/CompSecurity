.class Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;
.super Landroid/widget/ScrollView;
.source "AmazonMASHTestActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/amazon/mShop/TitleProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mash/AmazonMASHTestActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MASHTestView"
.end annotation


# instance fields
.field private mAmazonMASHTestActivity:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

.field final synthetic this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)V
    .locals 3
    .param p2, "mashTestActivity"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .line 57
    invoke-direct {p0, p2}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 59
    iput-object p2, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->mAmazonMASHTestActivity:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    .line 60
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->mash_api_test:I

    const/4 v2, 0x0

    invoke-static {p2, v1, v2}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 63
    .local v0, "mashTestView":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->addView(Landroid/view/View;)V

    .line 64
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_1_url_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Url:Landroid/widget/EditText;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$002(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;

    .line 66
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Url:Landroid/widget/EditText;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$000(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    const-string/jumbo v2, "https://mash-test.integ.amazon.com/mash-api-11.html"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 67
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_1_test_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Test:Landroid/widget/Button;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$102(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;

    .line 69
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Test:Landroid/widget/Button;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$100(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_2_url_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Url:Landroid/widget/EditText;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$202(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;

    .line 73
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Url:Landroid/widget/EditText;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$200(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    const-string/jumbo v2, "https://mash-test.integ.amazon.com/mash-api-12.html"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 74
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_2_test_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Test:Landroid/widget/Button;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$302(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;

    .line 76
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Test:Landroid/widget/Button;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$300(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 78
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_3_url_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Url:Landroid/widget/EditText;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$402(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;

    .line 80
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Url:Landroid/widget/EditText;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$400(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    const-string/jumbo v2, "https://mash-test.integ.amazon.com/mash-api-13.html"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 81
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_3_test_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Test:Landroid/widget/Button;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$502(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;

    .line 83
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Test:Landroid/widget/Button;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$500(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 85
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_4_url_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Url:Landroid/widget/EditText;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$602(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;

    .line 87
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Url:Landroid/widget/EditText;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$600(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    const-string/jumbo v2, "https://mash-test.integ.amazon.com/mash-api-14.html"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 88
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_4_test_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Test:Landroid/widget/Button;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$702(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;

    .line 90
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Test:Landroid/widget/Button;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$700(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 92
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_5_url_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Url:Landroid/widget/EditText;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$802(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;

    .line 94
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Url:Landroid/widget/EditText;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$800(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    const-string/jumbo v2, "https://mash-test.integ.amazon.com/mash-api-15.html"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 95
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_5_test_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Test:Landroid/widget/Button;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$902(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;

    .line 97
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Test:Landroid/widget/Button;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$900(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 99
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_6_url_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Url:Landroid/widget/EditText;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1002(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;

    .line 101
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Url:Landroid/widget/EditText;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1000(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    const-string/jumbo v2, "https://mash-test.integ.amazon.com/mash-api-16.html"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 102
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_6_test_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Test:Landroid/widget/Button;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1102(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;

    .line 104
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Test:Landroid/widget/Button;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1100(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 106
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_cookie_url_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieUrl:Landroid/widget/EditText;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1202(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;

    .line 108
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieUrl:Landroid/widget/EditText;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1200(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    const-string/jumbo v2, "https://mash-test.integ.amazon.com/MASHCookie.html"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 109
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_cookie_test_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieTest:Landroid/widget/Button;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1302(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;

    .line 111
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieTest:Landroid/widget/Button;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1300(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_test_home_url_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHomeUrl:Landroid/widget/EditText;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1402(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/EditText;)Landroid/widget/EditText;

    .line 115
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHomeUrl:Landroid/widget/EditText;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1400(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    const-string/jumbo v2, "https://mash-test.integ.amazon.com/mash-test-home.html"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 116
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_test_home_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    # setter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHome:Landroid/widget/Button;
    invoke-static {p1, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1502(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Landroid/widget/Button;)Landroid/widget/Button;

    .line 118
    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHome:Landroid/widget/Button;
    invoke-static {p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1500(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/Button;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView$1;

    invoke-direct {v2, p0, p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView$1;-><init>(Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    return-void
.end method

.method static synthetic access$1600(Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-direct {p0, p1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V

    return-void
.end method

.method private startMASHTestActivity(Ljava/lang/String;)V
    .locals 4
    .param p1, "pageUrl"    # Ljava/lang/String;

    .prologue
    .line 151
    iget-object v1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->mAmazonMASHTestActivity:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    const-class v2, Lcom/amazon/mShop/web/MShopWebActivity;

    const/4 v3, -0x1

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 154
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 155
    iget-object v1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->startActivity(Landroid/content/Intent;)V

    .line 156
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 128
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->mash_api_test:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 133
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_1_test_button:I

    if-ne v0, v1, :cond_1

    .line 134
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash11Url:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$000(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V

    .line 148
    :cond_0
    :goto_0
    return-void

    .line 135
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_2_test_button:I

    if-ne v0, v1, :cond_2

    .line 136
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash12Url:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$200(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V

    goto :goto_0

    .line 137
    :cond_2
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_3_test_button:I

    if-ne v0, v1, :cond_3

    .line 138
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash13Url:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$400(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V

    goto :goto_0

    .line 139
    :cond_3
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_4_test_button:I

    if-ne v0, v1, :cond_4

    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash14Url:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$600(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V

    goto :goto_0

    .line 141
    :cond_4
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_5_test_button:I

    if-ne v0, v1, :cond_5

    .line 142
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash15Url:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$800(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V

    goto :goto_0

    .line 143
    :cond_5
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_api_1_6_test_button:I

    if-ne v0, v1, :cond_6

    .line 144
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mash16Url:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1000(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 145
    :cond_6
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->mash_cookie_test_button:I

    if-ne v0, v1, :cond_0

    .line 146
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashCookieUrl:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1200(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
