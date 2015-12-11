.class public Lcom/bestbuy/android/api/lib/exceptions/SolrException;
.super Ljava/lang/Exception;
.source "SourceFile"


# static fields
.field private static final serialVersionUID:J = 0x47e4ffc352960f41L


# instance fields
.field private errorCode:Ljava/lang/String;

.field private errorMessage:Ljava/lang/String;

.field private moreInfo:Ljava/lang/String;

.field private statusCode:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 17
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorCode:Ljava/lang/String;

    .line 18
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorMessage:Ljava/lang/String;

    .line 19
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->moreInfo:Ljava/lang/String;

    .line 20
    const/4 v0, 0x0

    iput v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->statusCode:I

    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorCode:Ljava/lang/String;

    .line 45
    iput-object p2, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorMessage:Ljava/lang/String;

    .line 46
    iput-object p3, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->moreInfo:Ljava/lang/String;

    .line 47
    iput p4, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->statusCode:I

    .line 48
    return-void
.end method

.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 17
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorCode:Ljava/lang/String;

    .line 18
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorMessage:Ljava/lang/String;

    .line 19
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->moreInfo:Ljava/lang/String;

    .line 20
    const/4 v0, 0x0

    iput v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->statusCode:I

    .line 56
    const-string v0, "errorCode"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorCode:Ljava/lang/String;

    .line 57
    const-string v0, "errorMessage"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorMessage:Ljava/lang/String;

    .line 58
    const-string v0, "moreInfo"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->moreInfo:Ljava/lang/String;

    .line 59
    const-string v0, "statusCode"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->statusCode:I

    .line 60
    return-void
.end method


# virtual methods
.method public getErrorCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorCode:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->errorMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getMoreInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->moreInfo:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/bestbuy/android/api/lib/exceptions/SolrException;->statusCode:I

    return v0
.end method
