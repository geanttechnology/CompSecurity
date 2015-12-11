.class public Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
.super Ljava/lang/Object;
.source "SearchIntentUriBuilder.java"


# static fields
.field public static final SEARCH_PARAM_ASR_REQUEST_ID:Ljava/lang/String; = "paramAsrRequestId"

.field public static final SEARCH_PARAM_DATA_URL:Ljava/lang/String; = "paramDataUrl"

.field public static final SEARCH_PARAM_DEPARTMENT_FILTER:Ljava/lang/String; = "paramDepartmentFilter"

.field public static final SEARCH_PARAM_DEPARTMENT_NAME:Ljava/lang/String; = "paramDepartmentName"

.field public static final SEARCH_PARAM_INTERPRETATION_NUM:Ljava/lang/String; = "paramInterpretationNum"

.field public static final SEARCH_PARAM_METHOD:Ljava/lang/String; = "paramMethod"

.field public static final SEARCH_PARAM_QUERY_TEXT:Ljava/lang/String; = "paramQueryText"

.field public static final SEARCH_PARAM_UTTERANCE_ID:Ljava/lang/String; = "paramUtteranceId"


# instance fields
.field private asrRequestId:Ljava/lang/String;

.field private categoryName:Ljava/lang/String;

.field private dataUrl:Ljava/lang/String;

.field private filter:Ljava/lang/String;

.field private interpretationNum:I

.field private query:Ljava/lang/String;

.field private searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field private utteranceId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->query:Ljava/lang/String;

    .line 29
    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->filter:Ljava/lang/String;

    .line 30
    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->categoryName:Ljava/lang/String;

    .line 31
    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->dataUrl:Ljava/lang/String;

    .line 32
    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 33
    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->asrRequestId:Ljava/lang/String;

    .line 34
    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->utteranceId:Ljava/lang/String;

    .line 35
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->interpretationNum:I

    return-void
.end method


# virtual methods
.method public asrRequestId(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    .locals 0
    .param p1, "asrRequestId"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->asrRequestId:Ljava/lang/String;

    .line 64
    return-object p0
.end method

.method public build()Landroid/net/Uri;
    .locals 3

    .prologue
    .line 85
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->query:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->filter:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->dataUrl:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 86
    const/4 v1, 0x0

    .line 123
    :goto_0
    return-object v1

    .line 89
    :cond_0
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    .line 90
    .local v0, "uriBuilder":Landroid/net/Uri$Builder;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->query:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 92
    const-string/jumbo v1, "paramQueryText"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->query:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 94
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->filter:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 96
    const-string/jumbo v1, "paramDepartmentFilter"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->filter:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 98
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->categoryName:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 100
    const-string/jumbo v1, "paramDepartmentName"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->categoryName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 102
    :cond_3
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->dataUrl:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 104
    const-string/jumbo v1, "paramDataUrl"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->dataUrl:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 106
    :cond_4
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    if-eqz v1, :cond_5

    .line 107
    const-string/jumbo v1, "paramMethod"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 110
    :cond_5
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->asrRequestId:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 111
    const-string/jumbo v1, "paramAsrRequestId"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->asrRequestId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 114
    :cond_6
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->utteranceId:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_7

    .line 115
    const-string/jumbo v1, "paramUtteranceId"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->utteranceId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 118
    :cond_7
    iget v1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->interpretationNum:I

    if-lez v1, :cond_8

    .line 119
    const-string/jumbo v1, "paramInterpretationNum"

    iget v2, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->interpretationNum:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 123
    :cond_8
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    goto/16 :goto_0
.end method

.method public categoryName(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    .locals 0
    .param p1, "categoryName"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->categoryName:Ljava/lang/String;

    .line 49
    return-object p0
.end method

.method public dataUrl(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    .locals 0
    .param p1, "dataUrl"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->dataUrl:Ljava/lang/String;

    .line 54
    return-object p0
.end method

.method public filter(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    .locals 0
    .param p1, "filter"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->filter:Ljava/lang/String;

    .line 44
    return-object p0
.end method

.method public interpretationNum(I)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    .locals 0
    .param p1, "interpretationNum"    # I

    .prologue
    .line 73
    iput p1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->interpretationNum:I

    .line 74
    return-object p0
.end method

.method public query(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    .locals 0
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->query:Ljava/lang/String;

    .line 39
    return-object p0
.end method

.method public searchMethod(Lcom/amazon/searchapp/retailsearch/client/SearchMethod;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    .locals 0
    .param p1, "searchMethod"    # Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 59
    return-object p0
.end method

.method public utteranceId(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;
    .locals 0
    .param p1, "utteranceId"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->utteranceId:Ljava/lang/String;

    .line 69
    return-object p0
.end method
