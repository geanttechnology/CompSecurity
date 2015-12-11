.class public final Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
.super Ljava/lang/Object;
.source "SearchRealm.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/SearchRealm$1;,
        Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    }
.end annotation


# instance fields
.field private final completionServiceUrl:Ljava/lang/String;

.field private final country:Ljava/lang/String;

.field private final encodingParam:Ljava/lang/String;

.field private final encodingValue:Ljava/lang/String;

.field private final id:Ljava/lang/String;

.field private final inputEncoding:Ljava/lang/String;

.field private final language:Ljava/lang/String;

.field private final locale:Ljava/lang/String;

.field private final marketplaceId:I

.field private final obfuscatedMarketplaceId:Ljava/lang/String;

.field private final searchServiceUrl:Ljava/lang/String;

.field private final secureCompletionServiceUrl:Ljava/lang/String;

.field private final secureSearchServiceUrl:Ljava/lang/String;

.field private final secureSiteUrl:Ljava/lang/String;

.field private final siteUrl:Ljava/lang/String;

.field private final variant:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)V
    .locals 7
    .param p1, "builder"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v2, 0x0

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->id:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$000(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->id:Ljava/lang/String;

    .line 29
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->locale:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$100(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->locale:Ljava/lang/String;

    .line 30
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->marketplaceId:I
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$200(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)I

    move-result v1

    iput v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->marketplaceId:I

    .line 31
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->obfuscatedMarketplaceId:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$300(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->obfuscatedMarketplaceId:Ljava/lang/String;

    .line 33
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->locale:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->locale:Ljava/lang/String;

    const-string/jumbo v3, "_"

    const/4 v4, -0x1

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    .line 34
    .local v0, "arr":[Ljava/lang/String;
    :goto_0
    if-eqz v0, :cond_2

    array-length v1, v0

    if-lez v1, :cond_2

    const/4 v1, 0x0

    aget-object v1, v0, v1

    :goto_1
    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->language:Ljava/lang/String;

    .line 35
    if-eqz v0, :cond_3

    array-length v1, v0

    if-le v1, v5, :cond_3

    aget-object v1, v0, v5

    :goto_2
    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->country:Ljava/lang/String;

    .line 36
    if-eqz v0, :cond_0

    array-length v1, v0

    if-le v1, v6, :cond_0

    aget-object v2, v0, v6

    :cond_0
    iput-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->variant:Ljava/lang/String;

    .line 38
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->siteUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$400(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->siteUrl:Ljava/lang/String;

    .line 39
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureSiteUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$500(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->secureSiteUrl:Ljava/lang/String;

    .line 40
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->searchServiceUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$600(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->searchServiceUrl:Ljava/lang/String;

    .line 41
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureSearchServiceUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$700(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->secureSearchServiceUrl:Ljava/lang/String;

    .line 42
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureCompletionServiceUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$800(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->completionServiceUrl:Ljava/lang/String;

    .line 43
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureCompletionServiceUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$800(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->secureCompletionServiceUrl:Ljava/lang/String;

    .line 44
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->inputEncoding:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$900(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->inputEncoding:Ljava/lang/String;

    .line 45
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->encodingParam:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$1000(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->encodingParam:Ljava/lang/String;

    .line 46
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->encodingValue:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->access$1100(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->encodingValue:Ljava/lang/String;

    .line 47
    return-void

    .end local v0    # "arr":[Ljava/lang/String;
    :cond_1
    move-object v0, v2

    .line 33
    goto :goto_0

    .restart local v0    # "arr":[Ljava/lang/String;
    :cond_2
    move-object v1, v2

    .line 34
    goto :goto_1

    :cond_3
    move-object v1, v2

    .line 35
    goto :goto_2
.end method

.method synthetic constructor <init>(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;Lcom/amazon/searchapp/retailsearch/client/SearchRealm$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .param p2, "x1"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$1;

    .prologue
    .line 9
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;-><init>(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)V

    return-void
.end method


# virtual methods
.method public getCompletionServiceUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->completionServiceUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->country:Ljava/lang/String;

    return-object v0
.end method

.method public getEncodingParam()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->encodingParam:Ljava/lang/String;

    return-object v0
.end method

.method public getEncodingValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->encodingValue:Ljava/lang/String;

    return-object v0
.end method

.method public getInputEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->inputEncoding:Ljava/lang/String;

    return-object v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->language:Ljava/lang/String;

    return-object v0
.end method

.method public getLocale()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->locale:Ljava/lang/String;

    return-object v0
.end method

.method public getMarketplaceId()I
    .locals 1

    .prologue
    .line 67
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->marketplaceId:I

    return v0
.end method

.method public getSearchServiceUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->searchServiceUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSecureCompletionServiceUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->secureCompletionServiceUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSecureSearchServiceUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->secureSearchServiceUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getVariant()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->variant:Ljava/lang/String;

    return-object v0
.end method
