.class final Lcom/amazon/mShop/util/UIUtils$7;
.super Ljava/lang/Object;
.source "UIUtils.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/UIUtils;->createErrorBox(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorInfo;)Lcom/amazon/mShop/error/AmazonErrorBox;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$errorInfo:Lcom/amazon/mShop/error/AmazonErrorInfo;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/error/AmazonErrorInfo;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 588
    iput-object p1, p0, Lcom/amazon/mShop/util/UIUtils$7;->val$errorInfo:Lcom/amazon/mShop/error/AmazonErrorInfo;

    iput-object p2, p0, Lcom/amazon/mShop/util/UIUtils$7;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 592
    iget-object v1, p0, Lcom/amazon/mShop/util/UIUtils$7;->val$errorInfo:Lcom/amazon/mShop/error/AmazonErrorInfo;

    invoke-virtual {v1}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getActionListener()Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;

    move-result-object v0

    .line 595
    .local v0, "listener":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    if-eqz v0, :cond_0

    .line 596
    iget-object v1, p0, Lcom/amazon/mShop/util/UIUtils$7;->val$errorInfo:Lcom/amazon/mShop/error/AmazonErrorInfo;

    invoke-virtual {v1}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getErrorId()I

    move-result v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;->onActionButtonClick(I)V

    .line 599
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/util/UIUtils$7;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->dismissErrorBox()V

    .line 600
    return-void
.end method
