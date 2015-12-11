.class final Lcom/amazon/mShop/util/TextUtils$2;
.super Landroid/text/style/ClickableSpan;
.source "TextUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/TextUtils;->makeLinkClickable(Landroid/text/SpannableStringBuilder;Landroid/text/style/URLSpan;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$title:Ljava/lang/String;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/mShop/util/TextUtils$2;->val$url:Ljava/lang/String;

    iput-object p2, p0, Lcom/amazon/mShop/util/TextUtils$2;->val$title:Ljava/lang/String;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 64
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 65
    .local v1, "context":Landroid/content/Context;
    instance-of v2, v1, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v2, :cond_0

    move-object v0, v1

    .line 66
    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 67
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    new-instance v2, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v3, p0, Lcom/amazon/mShop/util/TextUtils$2;->val$url:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/mShop/util/TextUtils$2;->val$title:Ljava/lang/String;

    const/4 v5, 0x1

    invoke-direct {v2, v0, v3, v4, v5}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 69
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    :cond_0
    return-void
.end method
