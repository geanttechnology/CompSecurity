.class public Lcom/amazon/mShop/StandardViewWithUrlContent;
.super Lcom/amazon/mShop/StandardView;
.source "StandardViewWithUrlContent.java"


# instance fields
.field private final mTitle:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/Integer;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "titleResourceId"    # Ljava/lang/Integer;
    .param p3, "urlContentResourceId"    # I

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/StandardView;-><init>(Landroid/content/Context;Ljava/lang/Integer;)V

    .line 28
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/StandardViewWithUrlContent;->mTitle:Ljava/lang/String;

    .line 29
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 30
    .local v0, "url":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v2, p0, Lcom/amazon/mShop/StandardViewWithUrlContent;->mTitle:Ljava/lang/String;

    invoke-direct {v1, p1, v0, v2}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/StandardViewWithUrlContent;->setContentView(Landroid/view/View;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "url"    # Ljava/lang/String;

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/StandardView;-><init>(Landroid/content/Context;Ljava/lang/Integer;)V

    .line 35
    iput-object p2, p0, Lcom/amazon/mShop/StandardViewWithUrlContent;->mTitle:Ljava/lang/String;

    .line 36
    new-instance v0, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v1, p0, Lcom/amazon/mShop/StandardViewWithUrlContent;->mTitle:Ljava/lang/String;

    invoke-direct {v0, p1, p3, v1}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/StandardViewWithUrlContent;->setContentView(Landroid/view/View;)V

    .line 37
    return-void
.end method


# virtual methods
.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/mShop/StandardViewWithUrlContent;->mTitle:Ljava/lang/String;

    return-object v0
.end method
