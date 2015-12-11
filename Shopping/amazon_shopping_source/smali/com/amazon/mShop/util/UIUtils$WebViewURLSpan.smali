.class Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;
.super Landroid/text/style/URLSpan;
.source "UIUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/util/UIUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "WebViewURLSpan"
.end annotation


# instance fields
.field private final amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private final title:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;

    .prologue
    .line 784
    invoke-direct {p0, p2}, Landroid/text/style/URLSpan;-><init>(Ljava/lang/String;)V

    .line 785
    iput-object p1, p0, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 786
    iput-object p3, p0, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;->title:Ljava/lang/String;

    .line 787
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "widget"    # Landroid/view/View;

    .prologue
    .line 791
    iget-object v0, p0, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v2, p0, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {p0}, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;->getURL()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;->title:Ljava/lang/String;

    invoke-direct {v1, v2, v3, v4}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 792
    return-void
.end method
