.class final Lcom/amazon/mShop/util/BadgeUtils$1;
.super Ljava/lang/Object;
.source "BadgeUtils.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/BadgeUtils;->updateAddOnMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$linkUrl:Ljava/lang/String;

.field final synthetic val$richMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;


# direct methods
.method constructor <init>(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$richMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    iput-object p2, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    iput-object p3, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$linkUrl:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 163
    iget-object v1, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$richMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 164
    .local v0, "header":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    if-eqz v0, :cond_0

    .line 165
    iget-object v1, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v2, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v3, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v4, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$linkUrl:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 169
    :goto_0
    return-void

    .line 167
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v2, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v3, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v4, p0, Lcom/amazon/mShop/util/BadgeUtils$1;->val$linkUrl:Ljava/lang/String;

    const/4 v5, 0x0

    invoke-direct {v2, v3, v4, v5}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto :goto_0
.end method
