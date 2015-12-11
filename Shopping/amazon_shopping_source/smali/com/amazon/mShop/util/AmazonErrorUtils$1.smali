.class final Lcom/amazon/mShop/util/AmazonErrorUtils$1;
.super Ljava/lang/Object;
.source "AmazonErrorUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/AmazonErrorUtils;->showWebPageRetryDialog(Lcom/amazon/mShop/AmazonActivity;Landroid/webkit/WebView;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$errorCode:I

.field final synthetic val$reportOnView:Landroid/view/View;

.field final synthetic val$view:Landroid/webkit/WebView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonActivity;ILandroid/webkit/WebView;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iput p2, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$errorCode:I

    iput-object p3, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$view:Landroid/webkit/WebView;

    iput-object p4, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$reportOnView:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget v1, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$errorCode:I

    new-instance v2, Lcom/amazon/mShop/util/AmazonErrorUtils$1$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/util/AmazonErrorUtils$1$1;-><init>(Lcom/amazon/mShop/util/AmazonErrorUtils$1;)V

    iget-object v3, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$reportOnView:Landroid/view/View;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;)V

    .line 71
    return-void
.end method
