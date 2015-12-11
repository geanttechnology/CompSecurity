.class public Lcom/amazon/mShop/voice/VoiceSearchInitializer$VoiceSearchListener;
.super Ljava/lang/Object;
.source "VoiceSearchInitializer.java"

# interfaces
.implements Lcom/amazon/shopapp/voice/module/VoiceSearchActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/voice/VoiceSearchInitializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "VoiceSearchListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/voice/VoiceSearchInitializer;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/amazon/mShop/voice/VoiceSearchInitializer$VoiceSearchListener;->this$0:Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public search(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "query"    # Ljava/lang/String;
    .param p3, "asrRequestId"    # Ljava/lang/String;
    .param p4, "utteranceId"    # Ljava/lang/String;
    .param p5, "interpretationNum"    # I
    .param p6, "refMarker"    # Ljava/lang/String;
    .param p7, "clickStreamOrigin"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 76
    :try_start_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    instance-of v3, p1, Lcom/amazon/mShop/AmazonActivity;

    if-nez v3, :cond_1

    .line 109
    .end local p1    # "context":Landroid/content/Context;
    :cond_0
    :goto_0
    return-void

    .line 81
    .restart local p1    # "context":Landroid/content/Context;
    :cond_1
    invoke-static {p6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 82
    const-string/jumbo p6, "vos_search_query"

    .line 85
    :cond_2
    invoke-static {p7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 86
    sget-object v3, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH_VOICE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object p7

    .line 89
    :cond_3
    new-instance v5, Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-object v0, p1

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    move-object v3, v0

    invoke-direct {v5, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v5, p2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    sget-object v5, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->VOICE:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-virtual {v3, v5}, Lcom/amazon/mShop/search/SearchIntentBuilder;->searchMethod(Lcom/amazon/searchapp/retailsearch/client/SearchMethod;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lcom/amazon/mShop/search/SearchIntentBuilder;->showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3, p7}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->asrRequestId(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3, p4}, Lcom/amazon/mShop/search/SearchIntentBuilder;->utteranceId(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v5

    if-ltz p5, :cond_4

    add-int/lit8 v3, p5, 0x1

    :goto_1
    invoke-virtual {v5, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->interpretationNum(I)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v2

    .line 99
    .local v2, "intent":Landroid/content/Intent;
    instance-of v3, p1, Lcom/amazon/mShop/search/SearchActivity;

    if-eqz v3, :cond_5

    .line 100
    check-cast p1, Lcom/amazon/mShop/search/SearchActivity;

    .end local p1    # "context":Landroid/content/Context;
    invoke-virtual {p1, v2}, Lcom/amazon/mShop/search/SearchActivity;->doSearch(Landroid/content/Intent;)V

    .line 105
    :goto_2
    invoke-static {p6}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 106
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 107
    .local v1, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/mShop/voice/VoiceSearchInitializer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->access$000()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Failed to execute search"

    invoke-static {v3, v4, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .end local v1    # "e":Ljava/lang/Exception;
    .restart local p1    # "context":Landroid/content/Context;
    :cond_4
    move v3, v4

    .line 89
    goto :goto_1

    .line 102
    .restart local v2    # "intent":Landroid/content/Intent;
    :cond_5
    :try_start_1
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    invoke-static {p1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method
