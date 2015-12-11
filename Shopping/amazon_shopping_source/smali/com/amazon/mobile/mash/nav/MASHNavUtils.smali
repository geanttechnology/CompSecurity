.class public final Lcom/amazon/mobile/mash/nav/MASHNavUtils;
.super Ljava/lang/Object;
.source "MASHNavUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static computeBackAmount(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation;)I
    .locals 6
    .param p0, "webView"    # Lcom/amazon/mobile/mash/MASHWebView;
    .param p1, "mashNavOperation"    # Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    .prologue
    .line 55
    const/4 v0, -0x1

    .line 57
    .local v0, "backAmount":I
    const-string/jumbo v4, "back"

    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 58
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getBackAmount()I

    move-result v0

    .line 76
    :cond_0
    :goto_0
    return v0

    .line 59
    :cond_1
    const-string/jumbo v4, "backToBookmark"

    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 60
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->getMASHWebBackForwardList()Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

    move-result-object v1

    .line 61
    .local v1, "backForwardList":Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;
    invoke-virtual {v1}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->getCurrentIndex()I

    move-result v4

    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getBookmark()Ljava/lang/String;

    move-result-object v5

    invoke-static {v1, v4, v5}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->getTargetPageIndex(Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;ILjava/lang/String;)I

    move-result v3

    .line 63
    .local v3, "targetIndex":I
    if-ltz v3, :cond_0

    .line 64
    invoke-virtual {v1}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->getCurrentIndex()I

    move-result v4

    sub-int v0, v4, v3

    goto :goto_0

    .line 66
    .end local v1    # "backForwardList":Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;
    .end local v3    # "targetIndex":I
    :cond_2
    const-string/jumbo v4, "backToModalRoot"

    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 67
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->getContext()Landroid/content/Context;

    move-result-object v4

    instance-of v4, v4, Lcom/amazon/mobile/mash/nav/MASHNavInterface;

    if-eqz v4, :cond_0

    .line 68
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/amazon/mobile/mash/nav/MASHNavInterface;

    .line 69
    .local v2, "mashNavInterface":Lcom/amazon/mobile/mash/nav/MASHNavInterface;
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-interface {v2}, Lcom/amazon/mobile/mash/nav/MASHNavInterface;->getModalActivityClass()Ljava/lang/Class;

    move-result-object v5

    if-ne v4, v5, :cond_0

    .line 70
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/MASHWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    .line 71
    .local v1, "backForwardList":Landroid/webkit/WebBackForwardList;
    invoke-virtual {v1}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v0

    goto :goto_0
.end method

.method public static getFullUrlForGetRequest(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 6
    .param p0, "baseUrl"    # Ljava/lang/String;
    .param p1, "postDataJSON"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 87
    move-object v1, p0

    .line 88
    .local v1, "fullUrl":Ljava/lang/String;
    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v5}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 89
    .local v0, "builder":Landroid/net/Uri$Builder;
    if-eqz p1, :cond_1

    .line 92
    invoke-virtual {p1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v2

    .line 93
    .local v2, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 94
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 95
    .local v3, "key":Ljava/lang/String;
    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 96
    .local v4, "value":Ljava/lang/String;
    invoke-virtual {v0, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_0

    .line 98
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "value":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 101
    .end local v2    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_1
    return-object v1
.end method

.method public static getTargetPageIndex(Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;ILjava/lang/String;)I
    .locals 5
    .param p0, "list"    # Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;
    .param p1, "currentIndex"    # I
    .param p2, "targetBookMark"    # Ljava/lang/String;

    .prologue
    .line 35
    const/4 v3, -0x1

    .line 36
    .local v3, "targetIndex":I
    add-int/lit8 v1, p1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_0

    .line 37
    invoke-virtual {p0, v1}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->getItemAtIndex(I)Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;

    move-result-object v2

    .line 38
    .local v2, "item":Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
    invoke-virtual {v2}, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;->getBookmark()Ljava/lang/String;

    move-result-object v0

    .line 39
    .local v0, "bookmark":Ljava/lang/String;
    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 40
    move v3, v1

    .line 44
    .end local v0    # "bookmark":Ljava/lang/String;
    .end local v2    # "item":Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
    :cond_0
    return v3

    .line 36
    .restart local v0    # "bookmark":Ljava/lang/String;
    .restart local v2    # "item":Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
    :cond_1
    add-int/lit8 v1, v1, -0x1

    goto :goto_0
.end method

.method public static goBackAndForward(Lcom/amazon/mobile/mash/MASHWebView;ILcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V
    .locals 1
    .param p0, "webview"    # Lcom/amazon/mobile/mash/MASHWebView;
    .param p1, "backAmount"    # I
    .param p2, "request"    # Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    .prologue
    .line 133
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/MASHWebView;->setShouldHideProgressIndicator(Z)V

    .line 134
    rsub-int/lit8 v0, p1, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/MASHWebView;->goBackOrForward(I)V

    .line 135
    invoke-virtual {p0, p2}, Lcom/amazon/mobile/mash/MASHWebView;->setPendingNavRequest(Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    .line 136
    return-void
.end method

.method public static issuePageRequest(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V
    .locals 6
    .param p0, "webView"    # Lcom/amazon/mobile/mash/MASHWebView;
    .param p1, "request"    # Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    .prologue
    .line 112
    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 113
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getMethod()Ljava/lang/String;

    move-result-object v1

    .line 114
    .local v1, "method":Ljava/lang/String;
    const-string/jumbo v3, "POST"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 115
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getParams()Lorg/json/JSONObject;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mobile/mash/util/Util;->getPostDataAsByteArray(Lorg/json/JSONObject;)[B

    move-result-object v2

    .line 116
    .local v2, "postParameters":[B
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3, v2}, Lcom/amazon/mobile/mash/MASHWebView;->postUrl(Ljava/lang/String;[B)V

    .line 124
    .end local v1    # "method":Ljava/lang/String;
    .end local v2    # "postParameters":[B
    :cond_0
    :goto_0
    return-void

    .line 118
    .restart local v1    # "method":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getParams()Lorg/json/JSONObject;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->getFullUrlForGetRequest(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/amazon/mobile/mash/MASHWebView;->loadUrl(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 121
    .end local v1    # "method":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 122
    .local v0, "e":Lorg/json/JSONException;
    const-string/jumbo v3, "Amazon"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "JSONException "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
