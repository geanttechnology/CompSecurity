.class Lcom/amazon/mShop/util/AmazonErrorUtils$1$1;
.super Ljava/lang/Object;
.source "AmazonErrorUtils.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/AmazonErrorUtils$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/util/AmazonErrorUtils$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/util/AmazonErrorUtils$1;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1$1;->this$0:Lcom/amazon/mShop/util/AmazonErrorUtils$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 2
    .param p1, "errorId"    # I

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1$1;->this$0:Lcom/amazon/mShop/util/AmazonErrorUtils$1;

    iget-object v0, v0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$view:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->clearView()V

    .line 66
    iget-object v0, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1$1;->this$0:Lcom/amazon/mShop/util/AmazonErrorUtils$1;

    iget-object v0, v0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$view:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->reload()V

    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$1$1;->this$0:Lcom/amazon/mShop/util/AmazonErrorUtils$1;

    iget-object v0, v0, Lcom/amazon/mShop/util/AmazonErrorUtils$1;->val$view:Landroid/webkit/WebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 69
    return-void
.end method
