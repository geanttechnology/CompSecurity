.class final Lcom/amazon/mShop/util/UIUtils$11;
.super Landroid/text/style/ClickableSpan;
.source "UIUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/UIUtils;->addEmbeddedLink(Lcom/amazon/mShop/AmazonActivity;Landroid/text/SpannableString;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$linkText:Ljava/lang/String;

.field final synthetic val$linkUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 992
    iput-object p1, p0, Lcom/amazon/mShop/util/UIUtils$11;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iput-object p2, p0, Lcom/amazon/mShop/util/UIUtils$11;->val$linkUrl:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/util/UIUtils$11;->val$linkText:Ljava/lang/String;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "widget"    # Landroid/view/View;

    .prologue
    .line 996
    iget-object v0, p0, Lcom/amazon/mShop/util/UIUtils$11;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v2, p0, Lcom/amazon/mShop/util/UIUtils$11;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v3, p0, Lcom/amazon/mShop/util/UIUtils$11;->val$linkUrl:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/mShop/util/UIUtils$11;->val$linkText:Ljava/lang/String;

    invoke-direct {v1, v2, v3, v4}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 997
    return-void
.end method
