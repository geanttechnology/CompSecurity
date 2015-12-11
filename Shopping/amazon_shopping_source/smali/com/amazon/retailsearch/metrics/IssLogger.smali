.class public Lcom/amazon/retailsearch/metrics/IssLogger;
.super Ljava/lang/Object;
.source "IssLogger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;,
        Lcom/amazon/retailsearch/metrics/IssLogger$Field;
    }
.end annotation


# instance fields
.field private dataMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getSearchBoxLogger()Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    .line 77
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    .line 81
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 82
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->DataSet:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "Prod"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 83
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Marketplace:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 84
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->SourceSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "aps"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 85
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->TargetSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "aps"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 86
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->ServiceName:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "ISS"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 87
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Source:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, "mobile-app"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 88
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->explicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 89
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Pos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 90
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatPos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 91
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Size:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 92
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatSize:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 93
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsSpellCorrected:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 94
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsXcat:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 95
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsFallback:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 96
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsMidquery:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 97
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsNonPrefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 98
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsRobot:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 99
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Weblabs:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 100
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Prefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 101
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suffix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 102
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suggestion:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 103
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->RequestId:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 104
    return-void
.end method

.method public constructor <init>(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 107
    .local p1, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getSearchBoxLogger()Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    .line 77
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    .line 108
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 109
    iput-object p1, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    .line 110
    return-void
.end method

.method public static createLogData(Landroid/database/Cursor;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    .locals 9
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "position"    # I
    .param p2, "sourceSearchAlias"    # Ljava/lang/String;
    .param p3, "targetSearchAlias"    # Ljava/lang/String;
    .param p4, "keywords"    # Ljava/lang/String;
    .param p5, "rawInput"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 181
    if-eqz p0, :cond_0

    if-ltz p1, :cond_0

    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    :cond_0
    move-object v5, v6

    .line 238
    :goto_0
    return-object v5

    .line 185
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger;

    invoke-direct {v0}, Lcom/amazon/retailsearch/metrics/IssLogger;-><init>()V

    .line 186
    .local v0, "issLogger":Lcom/amazon/retailsearch/metrics/IssLogger;
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v1

    .line 187
    .local v1, "realm":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    if-eqz v1, :cond_2

    .line 189
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Marketplace:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getMarketplaceId()I

    move-result v7

    invoke-virtual {v0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 191
    :cond_2
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 193
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->SourceSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v5, p2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 195
    :cond_3
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 197
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->TargetSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v5, p3}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 200
    :cond_4
    invoke-interface {p0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 201
    const-string/jumbo v5, "suggest_intent_extra_data"

    invoke-static {p0, v5, v6}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 202
    .local v3, "type":Ljava/lang/String;
    sget-object v5, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->A9_SUGGESTION:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    sget-object v5, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->MERGED:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 204
    :cond_5
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v7, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->explicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v7}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 205
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Pos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v7, "suggest_log_pos"

    const-string/jumbo v8, "0"

    invoke-static {p0, v7, v8}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 206
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatPos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v7, "suggest_log_xcat_pos"

    const-string/jumbo v8, "0"

    invoke-static {p0, v7, v8}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 207
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsSpellCorrected:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v7, "suggest_log_is_spell_corrected"

    const-string/jumbo v8, "0"

    invoke-static {p0, v7, v8}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 208
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsXcat:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v7, "suggest_log_is_xcat"

    const-string/jumbo v8, "0"

    invoke-static {p0, v7, v8}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 209
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsFallback:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v7, "suggest_log_is_fallback"

    const-string/jumbo v8, "0"

    invoke-static {p0, v7, v8}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 210
    sget-object v7, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsNonPrefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p4, p5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_8

    const/4 v5, 0x1

    :goto_1
    invoke-virtual {v0, v7, v5}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 211
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suggestion:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v5, p4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 218
    :goto_2
    const/4 v2, 0x0

    .line 219
    .local v2, "size":I
    const/4 v4, 0x0

    .line 220
    .local v4, "xcatSize":I
    invoke-interface {p0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 221
    :goto_3
    invoke-interface {p0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v5

    if-nez v5, :cond_a

    .line 223
    const-string/jumbo v5, "suggest_intent_extra_data"

    invoke-static {p0, v5, v6}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 224
    sget-object v5, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->A9_SUGGESTION:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_6

    sget-object v5, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->MERGED:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 226
    :cond_6
    add-int/lit8 v2, v2, 0x1

    .line 227
    const-string/jumbo v5, "suggest_log_is_xcat"

    const-string/jumbo v7, "0"

    invoke-static {p0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v7, "1"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 229
    add-int/lit8 v4, v4, 0x1

    .line 232
    :cond_7
    invoke-interface {p0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_3

    .line 210
    .end local v2    # "size":I
    .end local v4    # "xcatSize":I
    :cond_8
    const/4 v5, 0x0

    goto :goto_1

    .line 215
    :cond_9
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v7, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->rejection:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v7}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v5, v7}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    goto :goto_2

    .line 234
    .restart local v2    # "size":I
    .restart local v4    # "xcatSize":I
    :cond_a
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Size:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v5, v2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 235
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatSize:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v5, v4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 236
    sget-object v5, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Prefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v5, p5}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 238
    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/IssLogger;->getIssEngagementData()Ljava/util/Map;

    move-result-object v5

    goto/16 :goto_0
.end method

.method public static createLogData(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    .locals 12
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "sourceSearchAlias"    # Ljava/lang/String;
    .param p2, "rawInput"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 305
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 307
    const/4 v10, 0x0

    .line 377
    :goto_0
    return-object v10

    .line 309
    :cond_0
    new-instance v3, Lcom/amazon/retailsearch/metrics/IssLogger;

    invoke-direct {v3}, Lcom/amazon/retailsearch/metrics/IssLogger;-><init>()V

    .line 311
    .local v3, "issLogger":Lcom/amazon/retailsearch/metrics/IssLogger;
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v5

    .line 312
    .local v5, "realm":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    if-eqz v5, :cond_1

    .line 314
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Marketplace:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getMarketplaceId()I

    move-result v11

    invoke-virtual {v3, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 316
    :cond_1
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_2

    .line 318
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->SourceSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v3, v10, p1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 321
    :cond_2
    const/4 v0, 0x0

    .line 322
    .local v0, "hasA9Suggestion":Z
    const/4 v2, 0x0

    .line 323
    .local v2, "isMismatch":Z
    const/4 v1, 0x0

    .line 324
    .local v1, "isImplicitAcceptance":Z
    const/4 v6, 0x0

    .line 325
    .local v6, "size":I
    const/4 v9, 0x0

    .line 326
    .local v9, "xcatSize":I
    if-eqz p0, :cond_8

    .line 328
    invoke-interface {p0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 329
    :goto_1
    invoke-interface {p0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v10

    if-nez v10, :cond_8

    .line 331
    const-string/jumbo v10, "suggest_intent_extra_data"

    const/4 v11, 0x0

    invoke-static {p0, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 332
    .local v8, "type":Ljava/lang/String;
    sget-object v10, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->A9_SUGGESTION:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v10}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_3

    sget-object v10, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->MERGED:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v10}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_6

    .line 334
    :cond_3
    const/4 v0, 0x1

    .line 335
    add-int/lit8 v6, v6, 0x1

    .line 336
    const-string/jumbo v10, "suggest_log_is_xcat"

    const-string/jumbo v11, "0"

    invoke-static {p0, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const-string/jumbo v11, "1"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 338
    add-int/lit8 v9, v9, 0x1

    .line 340
    :cond_4
    const/4 v10, 0x1

    if-ne v6, v10, :cond_5

    .line 342
    const-string/jumbo v10, "suggest_log_query"

    const-string/jumbo v11, ""

    invoke-static {p0, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 343
    .local v4, "query":Ljava/lang/String;
    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_7

    const/4 v2, 0x1

    .line 345
    .end local v4    # "query":Ljava/lang/String;
    :cond_5
    :goto_2
    if-nez v2, :cond_6

    if-nez v1, :cond_6

    .line 347
    const-string/jumbo v10, "suggest_text_1"

    const-string/jumbo v11, ""

    invoke-static {p0, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 348
    .local v7, "suggestion":Ljava/lang/String;
    invoke-virtual {v7, p2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    .line 351
    .end local v7    # "suggestion":Ljava/lang/String;
    :cond_6
    invoke-interface {p0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_1

    .line 343
    .restart local v4    # "query":Ljava/lang/String;
    :cond_7
    const/4 v2, 0x0

    goto :goto_2

    .line 355
    .end local v4    # "query":Ljava/lang/String;
    .end local v8    # "type":Ljava/lang/String;
    :cond_8
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Prefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v3, v10, p2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 356
    if-nez v0, :cond_9

    .line 358
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v11, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->zero_impression:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v11}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v3, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 374
    :goto_3
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Size:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v3, v10, v6}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 375
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatSize:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v3, v10, v9}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 377
    invoke-virtual {v3}, Lcom/amazon/retailsearch/metrics/IssLogger;->getIssEngagementData()Ljava/util/Map;

    move-result-object v10

    goto/16 :goto_0

    .line 360
    :cond_9
    if-eqz v2, :cond_a

    .line 362
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v11, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->mismatch:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v11}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v3, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 363
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Prefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    const-string/jumbo v11, ""

    invoke-virtual {v3, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    goto :goto_3

    .line 365
    :cond_a
    if-eqz v1, :cond_b

    .line 367
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v11, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->implicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v11}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v3, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 368
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suggestion:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v3, v10, p2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    goto :goto_3

    .line 372
    :cond_b
    sget-object v10, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v11, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->rejection:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v11}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v3, v10, v11}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    goto :goto_3
.end method

.method public static createLogData(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    .locals 5
    .param p0, "row"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    .param p1, "sourceSearchAlias"    # Ljava/lang/String;
    .param p2, "targetSearchAlias"    # Ljava/lang/String;
    .param p3, "keywords"    # Ljava/lang/String;
    .param p4, "rawInput"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 253
    if-eqz p0, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 255
    :cond_0
    const/4 v3, 0x0

    .line 293
    :goto_0
    return-object v3

    .line 257
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger;

    invoke-direct {v0}, Lcom/amazon/retailsearch/metrics/IssLogger;-><init>()V

    .line 258
    .local v0, "issLogger":Lcom/amazon/retailsearch/metrics/IssLogger;
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v1

    .line 259
    .local v1, "realm":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    if-eqz v1, :cond_2

    .line 261
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Marketplace:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getMarketplaceId()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 263
    :cond_2
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 265
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->SourceSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v3, p1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 267
    :cond_3
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 269
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->TargetSearchAlias:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v3, p2}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 272
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getSuggestionType()Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    move-result-object v2

    .line 273
    .local v2, "type":Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;
    sget-object v3, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->A9_SUGGESTION:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v3, v2}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    sget-object v3, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->MERGED:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v3, v2}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 275
    :cond_5
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v4, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->explicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 276
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Pos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getPos()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 277
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatPos:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getXcatPos()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 278
    sget-object v4, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsSpellCorrected:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isSpellCorrected()Z

    move-result v3

    if-eqz v3, :cond_6

    const-string/jumbo v3, "1"

    :goto_1
    invoke-virtual {v0, v4, v3}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 279
    sget-object v4, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsXcat:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isXcat()Z

    move-result v3

    if-eqz v3, :cond_7

    const-string/jumbo v3, "1"

    :goto_2
    invoke-virtual {v0, v4, v3}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 280
    sget-object v4, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsFallback:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isFallBack()Z

    move-result v3

    if-eqz v3, :cond_8

    const-string/jumbo v3, "1"

    :goto_3
    invoke-virtual {v0, v4, v3}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 281
    sget-object v4, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->IsNonPrefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p3, p4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_9

    const/4 v3, 0x1

    :goto_4
    invoke-virtual {v0, v4, v3}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 282
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Suggestion:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v3, p3}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 289
    :goto_5
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Size:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getA9SuggestionSize()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 290
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->XcatSize:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getXcatSize()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 291
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->Prefix:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {v0, v3, p4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 293
    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/IssLogger;->getIssEngagementData()Ljava/util/Map;

    move-result-object v3

    goto/16 :goto_0

    .line 278
    :cond_6
    const-string/jumbo v3, "0"

    goto :goto_1

    .line 279
    :cond_7
    const-string/jumbo v3, "0"

    goto :goto_2

    .line 280
    :cond_8
    const-string/jumbo v3, "0"

    goto :goto_3

    .line 281
    :cond_9
    const/4 v3, 0x0

    goto :goto_4

    .line 286
    :cond_a
    sget-object v3, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->UserAction:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    sget-object v4, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->rejection:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    goto :goto_5
.end method

.method public static getCursorValue(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "columnName"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 397
    if-eqz p0, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 406
    .end local p2    # "defaultValue":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p2

    .line 401
    .restart local p2    # "defaultValue":Ljava/lang/String;
    :cond_1
    invoke-interface {p0, p1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 402
    .local v0, "columnIndex":I
    if-ltz v0, :cond_0

    .line 406
    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object p2

    goto :goto_0
.end method


# virtual methods
.method public getIssEngagementData()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 165
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    return-object v0
.end method

.method public set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;I)Lcom/amazon/retailsearch/metrics/IssLogger;
    .locals 3
    .param p1, "field"    # Lcom/amazon/retailsearch/metrics/IssLogger$Field;
    .param p2, "value"    # I

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->name()Ljava/lang/String;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    return-object p0
.end method

.method public set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;
    .locals 2
    .param p1, "field"    # Lcom/amazon/retailsearch/metrics/IssLogger$Field;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->name()Ljava/lang/String;

    move-result-object v1

    if-nez p2, :cond_0

    const-string/jumbo p2, ""

    .end local p2    # "value":Ljava/lang/String;
    :cond_0
    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 121
    return-object p0
.end method

.method public set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Z)Lcom/amazon/retailsearch/metrics/IssLogger;
    .locals 3
    .param p1, "field"    # Lcom/amazon/retailsearch/metrics/IssLogger$Field;
    .param p2, "value"    # Z

    .prologue
    .line 144
    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->name()Ljava/lang/String;

    move-result-object v2

    if-eqz p2, :cond_0

    const-string/jumbo v0, "1"

    :goto_0
    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    return-object p0

    .line 144
    :cond_0
    const-string/jumbo v0, "0"

    goto :goto_0
.end method

.method public setRequestId(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;
    .locals 1
    .param p1, "requestId"    # Ljava/lang/String;

    .prologue
    .line 155
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$Field;->RequestId:Lcom/amazon/retailsearch/metrics/IssLogger$Field;

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/IssLogger;->set(Lcom/amazon/retailsearch/metrics/IssLogger$Field;Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger;

    .line 156
    return-object p0
.end method

.method public submitLog()V
    .locals 2

    .prologue
    .line 385
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;->searchSuggestionsEngagment(Ljava/util/Map;)V

    .line 386
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/IssLogger;->dataMap:Ljava/util/Map;

    .line 387
    return-void
.end method
