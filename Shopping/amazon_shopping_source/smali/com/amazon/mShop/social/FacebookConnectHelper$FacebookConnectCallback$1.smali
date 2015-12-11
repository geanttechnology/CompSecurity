.class Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback$1;
.super Ljava/lang/Object;
.source "FacebookConnectHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->callBackWebView(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

.field final synthetic val$callbackUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback$1;->this$1:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    iput-object p2, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback$1;->val$callbackUrl:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback$1;->this$1:Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    # getter for: Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->webView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v0}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->access$100(Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback$1;->val$callbackUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebView;->loadUrl(Ljava/lang/String;)V

    .line 175
    return-void
.end method
