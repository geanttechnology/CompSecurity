.class public Lcom/bestbuy/android/api/lib/models/mybby/Points;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private isElite:Z

.field private isElitePlus:Z

.field private memberTier:Ljava/lang/String;

.field private pendingPoints:Ljava/lang/String;

.field private pointsBalance:Ljava/lang/String;

.field private pointsLastUpdDate:Ljava/lang/String;

.field private statusDisplay:Ljava/lang/String;

.field private targetSpend:Ljava/lang/String;

.field private yeartoDateDollarSpend:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElitePlus:Z

    .line 24
    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElite:Z

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Points;
    .locals 2

    .prologue
    .line 87
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/Points;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Points;-><init>()V

    .line 88
    const-string v1, "pendingPoints"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->pendingPoints:Ljava/lang/String;

    .line 89
    const-string v1, "pointsBalance"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->pointsBalance:Ljava/lang/String;

    .line 90
    const-string v1, "pointsLastUpdDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->pointsLastUpdDate:Ljava/lang/String;

    .line 97
    const-string v1, "targetSpend"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->targetSpend:Ljava/lang/String;

    .line 98
    const-string v1, "yeartoDateDollarSpend"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->yeartoDateDollarSpend:Ljava/lang/String;

    .line 99
    const-string v1, "memberTier"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->memberTier:Ljava/lang/String;

    .line 100
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Points;->setElite()V

    .line 101
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Points;->setElitePlus()V

    .line 102
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Points;->setStatusDisplay()V

    .line 104
    return-object v0
.end method


# virtual methods
.method public getMemberTier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->memberTier:Ljava/lang/String;

    return-object v0
.end method

.method public getPendingPoints()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->pendingPoints:Ljava/lang/String;

    return-object v0
.end method

.method public getPointsBalance()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->pointsBalance:Ljava/lang/String;

    return-object v0
.end method

.method public getPointsLastUpdDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->pointsLastUpdDate:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusDisplay()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->statusDisplay:Ljava/lang/String;

    return-object v0
.end method

.method public getTargetSpend()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->targetSpend:Ljava/lang/String;

    return-object v0
.end method

.method public getYeartoDateDollarSpend()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->yeartoDateDollarSpend:Ljava/lang/String;

    return-object v0
.end method

.method public isElite()Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElite:Z

    return v0
.end method

.method public isElitePlus()Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElitePlus:Z

    return v0
.end method

.method public setElite()V
    .locals 2

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->memberTier:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->memberTier:Ljava/lang/String;

    const-string v1, "10067"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElite:Z

    .line 70
    :goto_0
    return-void

    .line 67
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElite:Z

    goto :goto_0
.end method

.method public setElitePlus()V
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->memberTier:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->memberTier:Ljava/lang/String;

    const-string v1, "10150"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElitePlus:Z

    .line 60
    :goto_0
    return-void

    .line 58
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElitePlus:Z

    goto :goto_0
.end method

.method public setStatusDisplay()V
    .locals 1

    .prologue
    .line 77
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElitePlus:Z

    if-eqz v0, :cond_0

    .line 78
    const-string v0, "eliteplus"

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->statusDisplay:Ljava/lang/String;

    .line 79
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->isElite:Z

    if-eqz v0, :cond_1

    .line 80
    const-string v0, "elite"

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->statusDisplay:Ljava/lang/String;

    .line 84
    :goto_0
    return-void

    .line 82
    :cond_1
    const-string v0, "mybestbuy"

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Points;->statusDisplay:Ljava/lang/String;

    goto :goto_0
.end method
