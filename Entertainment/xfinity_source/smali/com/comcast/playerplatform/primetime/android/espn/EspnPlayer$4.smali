.class Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;
.super Ljava/lang/Object;
.source "EspnPlayer.java"

# interfaces
.implements Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V
    .locals 0

    .prologue
    .line 407
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public shouldWaitForUpdatedAdobePassParams()Z
    .locals 2

    .prologue
    .line 485
    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$600()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "shouldWaitForUpdatedAdobePass"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 486
    const/4 v0, 0x0

    return v0
.end method

.method public shouldWaitForUpdatedAffiliateToken()Z
    .locals 2

    .prologue
    .line 491
    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$600()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "shouldWaitForUpdatedAffiliateToken"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 493
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDisneyEspnTokenDelegate()Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$400(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 494
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->tokenRefreshRunnable:Ljava/lang/Runnable;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 497
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$400(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public streamAuthorizationFailedWithError(Lcom/espn/androidplayersdk/objects/EPAuthError;)V
    .locals 5
    .param p1, "epAuthError"    # Lcom/espn/androidplayersdk/objects/EPAuthError;

    .prologue
    .line 439
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    const/4 v3, 0x0

    # setter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z
    invoke-static {v2, v3}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$402(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Z)Z

    .line 440
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 441
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/objects/EPAuthError;->geterrorCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    .line 442
    .local v1, "errorCode":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/objects/EPAuthError;->getMessage()Ljava/lang/String;

    move-result-object v0

    .line 443
    .local v0, "description":Ljava/lang/String;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v2

    const-string v3, ""

    const/4 v4, 0x0

    invoke-virtual {v2, v1, v0, v3, v4}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    .line 444
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-virtual {v2, v1, v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 446
    .end local v0    # "description":Ljava/lang/String;
    .end local v1    # "errorCode":Ljava/lang/String;
    :cond_0
    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$600()Lorg/slf4j/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Stream Authorization failed with error:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/objects/EPAuthError;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 448
    return-void
.end method

.method public streamAuthorizationSucceeded(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    .locals 6
    .param p1, "epStream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;

    .prologue
    const/4 v5, 0x0

    .line 452
    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$600()Lorg/slf4j/Logger;

    move-result-object v3

    const-string v4, "AuthorizationSucceeded"

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 453
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # setter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z
    invoke-static {v3, v5}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$402(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Z)Z

    .line 455
    move-object v1, p1

    .line 458
    .local v1, "ourStream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    new-instance v0, Ljava/net/HttpCookie;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getAuthCookieName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getToken()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v3, v4}, Ljava/net/HttpCookie;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 459
    .local v0, "cookie":Ljava/net/HttpCookie;
    const-string v3, "https://broadband.espn.go.com/"

    invoke-static {v3}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v2

    .line 460
    .local v2, "playbackUri":Ljava/net/URI;
    invoke-virtual {v2}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/net/HttpCookie;->setDomain(Ljava/lang/String;)V

    .line 461
    invoke-virtual {v2}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/net/HttpCookie;->setPath(Ljava/lang/String;)V

    .line 462
    invoke-virtual {v0, v5}, Ljava/net/HttpCookie;->setVersion(I)V

    .line 463
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->cookieManager:Ljava/net/CookieManager;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$800(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Ljava/net/CookieManager;

    move-result-object v3

    invoke-virtual {v3}, Ljava/net/CookieManager;->getCookieStore()Ljava/net/CookieStore;

    move-result-object v3

    invoke-interface {v3}, Ljava/net/CookieStore;->removeAll()Z

    .line 464
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->cookieManager:Ljava/net/CookieManager;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$800(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Ljava/net/CookieManager;

    move-result-object v3

    invoke-virtual {v3}, Ljava/net/CookieManager;->getCookieStore()Ljava/net/CookieStore;

    move-result-object v3

    invoke-interface {v3, v2, v0}, Ljava/net/CookieStore;->add(Ljava/net/URI;Ljava/net/HttpCookie;)V

    .line 466
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->updatePrimetime(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    invoke-static {v3, p1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$900(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    .line 467
    return-void
.end method

.method public streamCookieUpdated(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    .locals 4
    .param p1, "epStream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;

    .prologue
    .line 471
    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$600()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "CookieUpdated"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 473
    new-instance v0, Ljava/net/HttpCookie;

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getAuthCookieName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getToken()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Ljava/net/HttpCookie;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 474
    .local v0, "cookie":Ljava/net/HttpCookie;
    const-string v2, "https://broadband.espn.go.com/"

    invoke-static {v2}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v1

    .line 475
    .local v1, "playbackUri":Ljava/net/URI;
    invoke-virtual {v1}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/net/HttpCookie;->setDomain(Ljava/lang/String;)V

    .line 476
    invoke-virtual {v1}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/net/HttpCookie;->setPath(Ljava/lang/String;)V

    .line 477
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/net/HttpCookie;->setVersion(I)V

    .line 478
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->cookieManager:Ljava/net/CookieManager;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$800(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Ljava/net/CookieManager;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/CookieManager;->getCookieStore()Ljava/net/CookieStore;

    move-result-object v2

    invoke-interface {v2}, Ljava/net/CookieStore;->removeAll()Z

    .line 479
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->cookieManager:Ljava/net/CookieManager;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$800(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Ljava/net/CookieManager;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/CookieManager;->getCookieStore()Ljava/net/CookieStore;

    move-result-object v2

    invoke-interface {v2, v1, v0}, Ljava/net/CookieStore;->add(Ljava/net/URI;Ljava/net/HttpCookie;)V

    .line 480
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->updatePrimetime(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    invoke-static {v2, p1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$900(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    .line 481
    return-void
.end method

.method public streamDidEnterBlackout(Lcom/espn/androidplayersdk/objects/EPAuthError;)V
    .locals 5
    .param p1, "epAuthError"    # Lcom/espn/androidplayersdk/objects/EPAuthError;

    .prologue
    .line 426
    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$600()Lorg/slf4j/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Stream Entered Blackout:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/objects/EPAuthError;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 427
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    const/4 v1, 0x0

    # setter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$402(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Z)Z

    .line 428
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 429
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v0

    const-string v1, "7101"

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/objects/EPAuthError;->getMessage()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    .line 430
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    const-string v1, "7101"

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/objects/EPAuthError;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 431
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$700(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$700(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_1

    .line 432
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$700(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->stop()V

    .line 435
    :cond_1
    return-void
.end method

.method public streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V
    .locals 4
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 410
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    const/4 v2, 0x0

    # setter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z
    invoke-static {v1, v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$402(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Z)Z

    .line 411
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 412
    const/4 v1, 0x7

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    .line 413
    .local v0, "errorCode":Ljava/lang/String;
    const-string v1, "Unable to retrive live event for linear network"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 414
    const/16 v1, 0x8

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    .line 417
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v1

    const-string v2, ""

    const/4 v3, 0x0

    invoke-virtual {v1, v0, p1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    .line 418
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-virtual {v1, v0, p1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    .end local v0    # "errorCode":Ljava/lang/String;
    :cond_1
    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$600()Lorg/slf4j/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Authorization failed with message:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 422
    return-void
.end method
