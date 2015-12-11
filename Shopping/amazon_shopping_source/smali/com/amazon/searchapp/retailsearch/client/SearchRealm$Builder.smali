.class public final Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
.super Ljava/lang/Object;
.source "SearchRealm.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private completionServiceUrl:Ljava/lang/String;

.field private encodingParam:Ljava/lang/String;

.field private encodingValue:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private inputEncoding:Ljava/lang/String;

.field private locale:Ljava/lang/String;

.field private marketplaceId:I

.field private obfuscatedMarketplaceId:Ljava/lang/String;

.field private searchServiceUrl:Ljava/lang/String;

.field private secureCompletionServiceUrl:Ljava/lang/String;

.field private secureSearchServiceUrl:Ljava/lang/String;

.field private secureSiteUrl:Ljava/lang/String;

.field private siteUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 166
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->id:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->locale:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->encodingParam:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->encodingValue:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->marketplaceId:I

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->obfuscatedMarketplaceId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->siteUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureSiteUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->searchServiceUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureSearchServiceUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureCompletionServiceUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->inputEncoding:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 2

    .prologue
    .line 399
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;-><init>(Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;Lcom/amazon/searchapp/retailsearch/client/SearchRealm$1;)V

    return-object v0
.end method

.method public setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "completionServiceUrl"    # Ljava/lang/String;

    .prologue
    .line 323
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->completionServiceUrl:Ljava/lang/String;

    .line 324
    return-object p0
.end method

.method public setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "encodingParam"    # Ljava/lang/String;

    .prologue
    .line 373
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->encodingParam:Ljava/lang/String;

    .line 374
    return-object p0
.end method

.method public setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "encodingValue"    # Ljava/lang/String;

    .prologue
    .line 389
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->encodingValue:Ljava/lang/String;

    .line 390
    return-object p0
.end method

.method public setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 193
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->id:Ljava/lang/String;

    .line 194
    return-object p0
.end method

.method public setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "inputEncoding"    # Ljava/lang/String;

    .prologue
    .line 357
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->inputEncoding:Ljava/lang/String;

    .line 358
    return-object p0
.end method

.method public setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "locale"    # Ljava/lang/String;

    .prologue
    .line 209
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->locale:Ljava/lang/String;

    .line 210
    return-object p0
.end method

.method public setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "marketplaceId"    # I

    .prologue
    .line 225
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->marketplaceId:I

    .line 226
    return-object p0
.end method

.method public setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "obfuscatedMarketplaceId"    # Ljava/lang/String;

    .prologue
    .line 241
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->obfuscatedMarketplaceId:Ljava/lang/String;

    .line 242
    return-object p0
.end method

.method public setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "searchServiceUrl"    # Ljava/lang/String;

    .prologue
    .line 289
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->searchServiceUrl:Ljava/lang/String;

    .line 290
    return-object p0
.end method

.method public setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "secureCompletionServiceUrl"    # Ljava/lang/String;

    .prologue
    .line 341
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureCompletionServiceUrl:Ljava/lang/String;

    .line 342
    return-object p0
.end method

.method public setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "secureSearchServiceUrl"    # Ljava/lang/String;

    .prologue
    .line 305
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureSearchServiceUrl:Ljava/lang/String;

    .line 306
    return-object p0
.end method

.method public setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "secureSiteUrl"    # Ljava/lang/String;

    .prologue
    .line 273
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->secureSiteUrl:Ljava/lang/String;

    .line 274
    return-object p0
.end method

.method public setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;
    .locals 0
    .param p1, "siteUrl"    # Ljava/lang/String;

    .prologue
    .line 257
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->siteUrl:Ljava/lang/String;

    .line 258
    return-object p0
.end method
