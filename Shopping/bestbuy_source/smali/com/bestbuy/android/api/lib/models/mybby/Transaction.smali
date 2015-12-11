.class public Lcom/bestbuy/android/api/lib/models/mybby/Transaction;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private adjustmentCode:Ljava/lang/String;

.field private ccStatementDate:Ljava/lang/String;

.field private code:Ljava/lang/String;

.field private date:Ljava/util/Date;

.field private description:Ljava/lang/String;

.field private eligibleRevenue:Ljava/lang/String;

.field private isVisible:Z

.field private lineItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;",
            ">;"
        }
    .end annotation
.end field

.field private location:Ljava/lang/String;

.field private memberVisitNumber:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private offerCode:Ljava/lang/String;

.field private pending:Z

.field private points:Ljava/lang/String;

.field private sourceCode:Ljava/lang/String;

.field private sourceTranKey:Ljava/lang/String;

.field private storeID:Ljava/lang/String;

.field private storeLocation:Ljava/lang/String;

.field private subClubCode:Ljava/lang/String;

.field private totalRevenue:Ljava/lang/String;

.field private totalTax:Ljava/lang/String;

.field private tranNumber:Ljava/lang/String;

.field private transactionID:Ljava/lang/String;

.field private type:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 242
    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Transaction;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 194
    new-instance v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;-><init>()V

    .line 195
    const-string v0, "id"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->transactionID:Ljava/lang/String;

    .line 196
    const-string v0, "code"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->code:Ljava/lang/String;

    .line 197
    const-string v0, "type"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->type:Ljava/lang/String;

    .line 198
    const-string v0, "description"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->description:Ljava/lang/String;

    .line 199
    const-string v0, "memberVisitNumber"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->memberVisitNumber:Ljava/lang/String;

    .line 201
    :try_start_0
    sget-object v0, Lgv;->a:Ljava/text/SimpleDateFormat;

    const-string v3, "date"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->date:Ljava/util/Date;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 205
    :goto_0
    const-string v0, "location"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->location:Ljava/lang/String;

    .line 207
    iget-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->location:Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->setStoreID(Ljava/lang/String;)V

    .line 209
    const-string v0, "offerCode"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->offerCode:Ljava/lang/String;

    .line 210
    const-string v0, "points"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->points:Ljava/lang/String;

    .line 211
    const-string v0, "sourceTranKey"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->sourceTranKey:Ljava/lang/String;

    .line 212
    const-string v0, "adjustmentCode"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->adjustmentCode:Ljava/lang/String;

    .line 213
    const-string v0, "subClubCode"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->subClubCode:Ljava/lang/String;

    .line 214
    const-string v0, "eligibleRevenue"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->eligibleRevenue:Ljava/lang/String;

    .line 215
    const-string v0, "totalRevenue"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->totalRevenue:Ljava/lang/String;

    .line 216
    const-string v0, "totalTax"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->totalTax:Ljava/lang/String;

    .line 217
    const-string v0, "ccStatementDate"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->ccStatementDate:Ljava/lang/String;

    .line 218
    const-string v0, "tranNumber"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->tranNumber:Ljava/lang/String;

    .line 219
    const-string v0, "sourceCode"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->sourceCode:Ljava/lang/String;

    .line 220
    iput-boolean v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->isVisible:Z

    .line 221
    const-string v0, "pending"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->pending:Z

    .line 222
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->lineItems:Ljava/util/ArrayList;

    .line 224
    :try_start_1
    const-string v0, "details"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v3, "detail"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    move v0, v1

    .line 226
    :goto_1
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 227
    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    # invokes: Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;
    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->access$000(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;

    move-result-object v1

    .line 229
    if-eqz v1, :cond_0

    .line 230
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->lineItems:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 226
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 202
    :catch_0
    move-exception v0

    .line 203
    sget-object v3, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not parse date(Skipping): "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 235
    :catch_1
    move-exception v0

    .line 236
    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Cannot create JSONArray from transaction details (Skipping): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    :cond_1
    return-object v2
.end method


# virtual methods
.method public clicked(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 306
    return-void
.end method

.method public getAdjustmentCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->adjustmentCode:Ljava/lang/String;

    return-object v0
.end method

.method public getCcStatementDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->ccStatementDate:Ljava/lang/String;

    return-object v0
.end method

.method public getCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->code:Ljava/lang/String;

    return-object v0
.end method

.method public getDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->date:Ljava/util/Date;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getEligibleRevenue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->eligibleRevenue:Ljava/lang/String;

    return-object v0
.end method

.method public getLineItems()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->lineItems:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->location:Ljava/lang/String;

    return-object v0
.end method

.method public getMemberVisitNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->memberVisitNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->offerCode:Ljava/lang/String;

    return-object v0
.end method

.method public getPoints()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->points:Ljava/lang/String;

    return-object v0
.end method

.method public getSaleLineItems()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 148
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 149
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->lineItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->lineItems:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getProductSku()Ljava/lang/String;

    move-result-object v0

    const-string v3, "RZ CARD"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->lineItems:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 149
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 156
    :cond_1
    return-object v2
.end method

.method public getSourceCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->sourceCode:Ljava/lang/String;

    return-object v0
.end method

.method public getSourceTranKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->sourceTranKey:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->storeID:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->storeLocation:Ljava/lang/String;

    return-object v0
.end method

.method public getSubClubCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->subClubCode:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalRevenue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->totalRevenue:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalTax()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->totalTax:Ljava/lang/String;

    return-object v0
.end method

.method public getTranNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->tranNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getTransactionID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->transactionID:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->type:Ljava/lang/String;

    return-object v0
.end method

.method public isPending()Z
    .locals 1

    .prologue
    .line 135
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->pending:Z

    return v0
.end method

.method public isVisible()Z
    .locals 1

    .prologue
    .line 139
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->isVisible:Z

    return v0
.end method

.method public setName()V
    .locals 4

    .prologue
    .line 167
    :try_start_0
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "MM/dd/yy"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 168
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getSaleLineItems()Ljava/util/ArrayList;

    move-result-object v1

    .line 169
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getDate()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " RECEIPT "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " - "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->name:Ljava/lang/String;

    .line 172
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 173
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " item"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->name:Ljava/lang/String;

    .line 180
    :goto_0
    return-void

    .line 175
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " items"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->name:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 177
    :catch_0
    move-exception v0

    .line 178
    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setStoreID(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 186
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "STORE #"

    invoke-virtual {p1, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    add-int/lit8 v1, v1, 0x7

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->storeID:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 191
    :goto_0
    return-void

    .line 188
    :catch_0
    move-exception v0

    .line 189
    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
