.class Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;
.super Lcom/AmazonDevice/Authentication/DefaultAmazonWebserviceCallListener;
.source "AmazonOODMSUserIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->callWebService()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;

.field final synthetic val$callSuccessful:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic val$latch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;Ljava/util/concurrent/CountDownLatch;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->this$0:Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;

    iput-object p2, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->val$latch:Ljava/util/concurrent/CountDownLatch;

    iput-object p3, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->val$callSuccessful:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p0}, Lcom/AmazonDevice/Authentication/DefaultAmazonWebserviceCallListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 2

    .prologue
    .line 163
    # getter for: Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->LOGTAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Authentication failure calling MobileAdsService"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->val$latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 165
    return-void
.end method

.method public onNetworkFailure()V
    .locals 2

    .prologue
    .line 156
    # getter for: Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->LOGTAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Network failure calling MobileAdsService"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->val$latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 158
    return-void
.end method

.method public onParseError(Lcom/AmazonDevice/Identity/Common/ParseError;)V
    .locals 2
    .param p1, "error"    # Lcom/AmazonDevice/Identity/Common/ParseError;

    .prologue
    .line 170
    # getter for: Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->LOGTAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Parse error getting response from MobileAdsService"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->val$latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 172
    return-void
.end method

.method public onResponseComplete(Ljava/lang/Object;)V
    .locals 7
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    .line 179
    :try_start_0
    move-object v0, p1

    check-cast v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;

    move-object v1, v0

    .line 180
    .local v1, "resp":Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;
    iget-wide v2, v1, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;->httpCode:J

    const-wide/16 v4, 0xc8

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    .line 181
    # getter for: Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->LOGTAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Calling MobileAdsService was not successful: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, v1, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;->response:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 187
    :goto_0
    iget-object v2, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->val$latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 189
    return-void

    .line 183
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->val$callSuccessful:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 187
    .end local v1    # "resp":Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;->val$latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v3}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v2
.end method
