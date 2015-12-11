.class public Lcom/bestbuy/android/api/lib/models/mybby/Profile;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private accountInfo:Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;

.field private certs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/Certificate;",
            ">;"
        }
    .end annotation
.end field

.field private points:Lcom/bestbuy/android/api/lib/models/mybby/Points;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Profile;
    .locals 5

    .prologue
    .line 35
    new-instance v1, Lcom/bestbuy/android/api/lib/models/mybby/Profile;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Profile;-><init>()V

    .line 36
    const-string v0, "accountInfo"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 37
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->accountInfo:Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;

    .line 38
    const-string v0, "points"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 39
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Points;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Points;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->points:Lcom/bestbuy/android/api/lib/models/mybby/Points;

    .line 40
    const-string v0, "certs"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 41
    const-string v2, "certificates"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->certs:Ljava/util/ArrayList;

    .line 43
    if-eqz v2, :cond_0

    .line 45
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 46
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 47
    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/mybby/Certificate;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Certificate;

    move-result-object v3

    .line 48
    iget-object v4, v1, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->certs:Ljava/util/ArrayList;

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 45
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 51
    :cond_0
    return-object v1
.end method


# virtual methods
.method public getAccountInfo()Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->accountInfo:Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;

    return-object v0
.end method

.method public getCertTotal()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 55
    move v1, v0

    move v2, v0

    .line 56
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->certs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->certs:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/mybby/Certificate;

    .line 58
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Certificate;->getAmount()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    add-int/2addr v2, v0

    .line 56
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 60
    :cond_0
    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCertificates()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/Certificate;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->certs:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getPoints()Lcom/bestbuy/android/api/lib/models/mybby/Points;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Profile;->points:Lcom/bestbuy/android/api/lib/models/mybby/Points;

    return-object v0
.end method
