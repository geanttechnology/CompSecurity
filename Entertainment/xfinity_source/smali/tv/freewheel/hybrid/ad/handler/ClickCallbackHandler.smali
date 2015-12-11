.class public Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;
.super Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
.source "ClickCallbackHandler.java"


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/EventCallback;)V
    .locals 0
    .param p1, "callback"    # Ltv/freewheel/hybrid/ad/EventCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .line 18
    return-void
.end method

.method private openLink(Ljava/lang/String;)V
    .locals 5
    .param p1, "to"    # Ljava/lang/String;

    .prologue
    .line 21
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/AdInstance;->getActivity()Landroid/app/Activity;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 22
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "will open: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 23
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 24
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 25
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/AdInstance;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 27
    .end local v0    # "intent":Landroid/content/Intent;
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_0
    return-void
.end method


# virtual methods
.method public send(Landroid/os/Bundle;)V
    .locals 12
    .param p1, "info"    # Landroid/os/Bundle;

    .prologue
    const/4 v11, -0x1

    .line 30
    iget-object v9, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    if-eqz v9, :cond_0

    iget-object v9, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v9}, Ltv/freewheel/hybrid/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 31
    const-string v9, "reid"

    iget-object v10, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v10}, Ltv/freewheel/hybrid/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v10

    iget v10, v10, Ltv/freewheel/hybrid/ad/CreativeRendition;->creativeRenditionId:I

    invoke-static {v10}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p0, v9, v10}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    :cond_0
    const/4 v8, 0x0

    .line 35
    .local v8, "skipTracking":Z
    const-string v9, "cr"

    invoke-virtual {p0, v9}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->getUrlParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 36
    .local v7, "redirectUrl":Ljava/lang/String;
    const-string v9, "url"

    invoke-virtual {p1, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 37
    .local v6, "overriddenUrl":Ljava/lang/String;
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getCallbackUrl()Ljava/lang/String;

    move-result-object v0

    .line 38
    .local v0, "callbackUrl":Ljava/lang/String;
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->isShowBrowser()Z

    move-result v4

    .line 40
    .local v4, "needShowBrowser":Z
    if-eqz v6, :cond_2

    invoke-virtual {v6}, Ljava/lang/String;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_2

    .line 41
    const/4 v4, 0x1

    .line 44
    const-string v2, ".fwmrm.net"

    .line 46
    .local v2, "fwServerHost":Ljava/lang/String;
    :try_start_0
    iget-object v9, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v9}, Ltv/freewheel/hybrid/ad/AdInstance;->getAdContext()Ltv/freewheel/hybrid/ad/AdContext;

    move-result-object v9

    iget-object v9, v9, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    const-string v10, "http"

    invoke-virtual {v9, v10}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 47
    new-instance v9, Ljava/net/URL;

    iget-object v10, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v10}, Ltv/freewheel/hybrid/ad/AdInstance;->getAdContext()Ltv/freewheel/hybrid/ad/AdContext;

    move-result-object v10

    iget-object v10, v10, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    invoke-direct {v9, v10}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Ljava/net/URL;->getHost()Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v2

    .line 51
    :cond_1
    :goto_0
    const-string v5, ""

    .line 53
    .local v5, "overriddenServerHost":Ljava/lang/String;
    :try_start_1
    new-instance v9, Ljava/net/URL;

    invoke-direct {v9, v6}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Ljava/net/URL;->getHost()Ljava/lang/String;
    :try_end_1
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v5

    .line 56
    :goto_1
    invoke-virtual {v5, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_5

    const-string v9, "ad/l/1"

    invoke-virtual {v6, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 58
    const/4 v8, 0x1

    .line 60
    move-object v0, v6

    .line 61
    const-string v9, "&cr="

    invoke-virtual {v0, v9}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v3

    .line 62
    .local v3, "idx":I
    if-eq v3, v11, :cond_4

    .line 63
    const-string v9, "&cr="

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    add-int/2addr v9, v3

    invoke-virtual {v0, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 67
    :goto_2
    iget-object v9, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Click through overridden by value: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 87
    .end local v2    # "fwServerHost":Ljava/lang/String;
    .end local v3    # "idx":I
    .end local v5    # "overriddenServerHost":Ljava/lang/String;
    :cond_2
    :goto_3
    const-string v9, "showBrowser"

    invoke-virtual {p1, v9, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    .line 90
    const-string v9, "http://"

    invoke-virtual {v0, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_8

    const-string v9, "https://"

    invoke-virtual {v0, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_8

    .line 92
    :try_start_2
    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->openLink(Ljava/lang/String;)V
    :try_end_2
    .catch Landroid/content/ActivityNotFoundException; {:try_start_2 .. :try_end_2} :catch_0

    .line 109
    :goto_4
    if-nez v8, :cond_3

    .line 110
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->sendTrackingCallback()V

    .line 112
    :cond_3
    return-void

    .line 65
    .restart local v2    # "fwServerHost":Ljava/lang/String;
    .restart local v3    # "idx":I
    .restart local v5    # "overriddenServerHost":Ljava/lang/String;
    :cond_4
    const-string v7, ""

    goto :goto_2

    .line 68
    .end local v3    # "idx":I
    :cond_5
    invoke-virtual {v6, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_6

    const-string v9, "ad/l/1"

    invoke-virtual {v6, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 71
    const/4 v8, 0x1

    .line 72
    move-object v0, v6

    .line 73
    move-object v7, v6

    .line 74
    iget-object v9, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Click through overridden by value: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_3

    .line 77
    :cond_6
    const-string v9, "&cr="

    invoke-virtual {v0, v9}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v3

    .line 78
    .restart local v3    # "idx":I
    if-eq v3, v11, :cond_7

    .line 79
    const/4 v9, 0x0

    invoke-virtual {v0, v9, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 81
    :cond_7
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "&cr="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {v6}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 82
    iget-object v9, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Click through CR: original value: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ", overridden by value: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 83
    move-object v7, v6

    goto/16 :goto_3

    .line 93
    .end local v2    # "fwServerHost":Ljava/lang/String;
    .end local v3    # "idx":I
    .end local v5    # "overriddenServerHost":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 94
    .local v1, "e":Landroid/content/ActivityNotFoundException;
    iget-object v9, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "unknown uri schema:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 96
    .end local v1    # "e":Landroid/content/ActivityNotFoundException;
    :cond_8
    if-eqz v4, :cond_9

    if-eqz v7, :cond_9

    invoke-virtual {v7}, Ljava/lang/String;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_a

    .line 97
    :cond_9
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->sendRequest(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 98
    :cond_a
    const-string v9, "http://"

    invoke-virtual {v7, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_b

    const-string v9, "https://"

    invoke-virtual {v7, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_c

    .line 99
    :cond_b
    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->openLink(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 101
    :cond_c
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->sendRequest(Ljava/lang/String;)V

    .line 103
    :try_start_3
    invoke-direct {p0, v7}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->openLink(Ljava/lang/String;)V
    :try_end_3
    .catch Landroid/content/ActivityNotFoundException; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_4

    .line 104
    :catch_1
    move-exception v1

    .line 105
    .restart local v1    # "e":Landroid/content/ActivityNotFoundException;
    iget-object v9, p0, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "unknown uri schema:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 54
    .end local v1    # "e":Landroid/content/ActivityNotFoundException;
    .restart local v2    # "fwServerHost":Ljava/lang/String;
    .restart local v5    # "overriddenServerHost":Ljava/lang/String;
    :catch_2
    move-exception v9

    goto/16 :goto_1

    .line 49
    .end local v5    # "overriddenServerHost":Ljava/lang/String;
    :catch_3
    move-exception v9

    goto/16 :goto_0
.end method
