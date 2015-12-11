.class Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$2;
.super Lcom/alipay/android/app/IRemoteServiceCallback$Stub;
.source "AlipayServiceConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$2;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    invoke-direct {p0}, Lcom/alipay/android/app/IRemoteServiceCallback$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public isHideLoadingScreen()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 125
    const/4 v0, 0x0

    return v0
.end method

.method public payEnd(ZLjava/lang/String;)V
    .locals 0
    .param p1, "arg0"    # Z
    .param p2, "arg1"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 130
    return-void
.end method

.method public startActivity(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "className"    # Ljava/lang/String;
    .param p3, "callingPid"    # I
    .param p4, "bundle"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 149
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "android.intent.action.MAIN"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 150
    .local v0, "intent":Landroid/content/Intent;
    if-nez p4, :cond_0

    .line 151
    new-instance p4, Landroid/os/Bundle;

    .end local p4    # "bundle":Landroid/os/Bundle;
    invoke-direct {p4}, Landroid/os/Bundle;-><init>()V

    .line 154
    .restart local p4    # "bundle":Landroid/os/Bundle;
    :cond_0
    :try_start_0
    const-string/jumbo v1, "CallingPid"

    invoke-virtual {p4, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 155
    invoke-virtual {v0, p4}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 161
    :goto_0
    invoke-virtual {v0, p1, p2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 162
    iget-object v1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$2;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    # getter for: Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mActivity:Landroid/app/Activity;
    invoke-static {v1}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->access$300(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 163
    return-void

    .line 156
    :catch_0
    move-exception v1

    goto :goto_0
.end method
