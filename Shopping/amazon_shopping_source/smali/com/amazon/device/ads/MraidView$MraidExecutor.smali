.class Lcom/amazon/device/ads/MraidView$MraidExecutor;
.super Ljava/lang/Object;
.source "MraidView.java"

# interfaces
.implements Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MraidExecutor"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/MraidView;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidView;)V
    .locals 0

    .prologue
    .line 636
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidExecutor;->this$0:Lcom/amazon/device/ads/MraidView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;)Z
    .locals 9
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 641
    invoke-static {p1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v6

    .line 642
    .local v6, "uri":Ljava/net/URI;
    invoke-virtual {v6}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 643
    .local v1, "commandType":Ljava/lang/String;
    const-string/jumbo v7, "UTF-8"

    invoke-static {v6, v7}, Lorg/apache/http/client/utils/URLEncodedUtils;->parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 644
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 645
    .local v5, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/apache/http/NameValuePair;

    .line 647
    .local v4, "pair":Lorg/apache/http/NameValuePair;
    invoke-interface {v4}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v4}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 650
    .end local v4    # "pair":Lorg/apache/http/NameValuePair;
    :cond_0
    iget-object v7, p0, Lcom/amazon/device/ads/MraidView$MraidExecutor;->this$0:Lcom/amazon/device/ads/MraidView;

    invoke-static {v1, v5, v7}, Lcom/amazon/device/ads/MraidCommandRegistry;->createCommand(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)Lcom/amazon/device/ads/MraidCommand;

    move-result-object v0

    .line 651
    .local v0, "command":Lcom/amazon/device/ads/MraidCommand;
    if-nez v0, :cond_1

    .line 653
    iget-object v7, p0, Lcom/amazon/device/ads/MraidView$MraidExecutor;->this$0:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v7, v1}, Lcom/amazon/device/ads/MraidView;->fireNativeCommandCompleteEvent(Ljava/lang/String;)V

    .line 654
    const/4 v7, 0x0

    .line 660
    :goto_1
    return v7

    .line 658
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidCommand;->execute()V

    .line 659
    iget-object v7, p0, Lcom/amazon/device/ads/MraidView$MraidExecutor;->this$0:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v7, v1}, Lcom/amazon/device/ads/MraidView;->fireNativeCommandCompleteEvent(Ljava/lang/String;)V

    .line 660
    const/4 v7, 0x1

    goto :goto_1
.end method
