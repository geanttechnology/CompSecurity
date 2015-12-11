.class public Lcom/poshmark/data_model/models/PriceInfo;
.super Ljava/lang/Object;
.source "PriceInfo.java"


# instance fields
.field private max:Ljava/lang/String;

.field private min:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "minVal"    # Ljava/lang/String;
    .param p2, "maxVal"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    .line 49
    iput-object p2, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    .line 50
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 12
    if-ne p0, p1, :cond_1

    .line 25
    :cond_0
    :goto_0
    return v1

    .line 13
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 15
    check-cast v0, Lcom/poshmark/data_model/models/PriceInfo;

    .line 17
    .local v0, "priceInfo":Lcom/poshmark/data_model/models/PriceInfo;
    iget-object v3, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    if-eqz v3, :cond_4

    .line 18
    iget-object v3, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    iget-object v4, v0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    goto :goto_0

    .line 21
    :cond_4
    iget-object v3, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    if-eqz v3, :cond_0

    .line 22
    iget-object v3, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    iget-object v4, v0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    goto :goto_0
.end method

.method public getDisplay()Ljava/lang/String;
    .locals 2

    .prologue
    .line 53
    iget-object v0, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 54
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Under $"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 58
    :goto_0
    return-object v0

    .line 55
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 56
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Over $"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 58
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "$"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "$"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getMax()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    return-object v0
.end method

.method public getMin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 30
    const/4 v0, 0x1

    .line 31
    .local v0, "result1":I
    const/4 v1, 0x1

    .line 33
    .local v1, "result2":I
    iget-object v2, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 34
    iget-object v2, p0, Lcom/poshmark/data_model/models/PriceInfo;->min:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 37
    :cond_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 38
    iget-object v2, p0, Lcom/poshmark/data_model/models/PriceInfo;->max:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v1

    .line 41
    :cond_1
    mul-int/lit8 v2, v0, 0x1f

    add-int/2addr v2, v1

    return v2
.end method
