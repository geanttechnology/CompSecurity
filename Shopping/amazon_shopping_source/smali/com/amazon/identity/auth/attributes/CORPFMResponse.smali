.class public Lcom/amazon/identity/auth/attributes/CORPFMResponse;
.super Ljava/lang/Object;
.source "CORPFMResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    }
.end annotation


# instance fields
.field private final mComputationConfidenceValue:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

.field private final mCor:Ljava/lang/String;

.field private final mPfm:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;)V
    .locals 0
    .param p1, "cor"    # Ljava/lang/String;
    .param p2, "pfm"    # Ljava/lang/String;
    .param p3, "computationConfidenceValue"    # Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mCor:Ljava/lang/String;

    .line 69
    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mPfm:Ljava/lang/String;

    .line 70
    iput-object p3, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mComputationConfidenceValue:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .line 71
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "cor"    # Ljava/lang/String;
    .param p2, "pfm"    # Ljava/lang/String;
    .param p3, "confidenceValue"    # Ljava/lang/String;

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mCor:Ljava/lang/String;

    .line 76
    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mPfm:Ljava/lang/String;

    .line 77
    sget-object v0, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_PROVIDED:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-static {p3, v0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->parseFromValue(Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;)Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mComputationConfidenceValue:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    .line 79
    return-void
.end method

.method private isCustomerProvided()Z
    .locals 2

    .prologue
    .line 118
    invoke-virtual {p0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getComputationConfidenceValue()Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_PROVIDED:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 135
    if-ne p0, p1, :cond_1

    .line 147
    :cond_0
    :goto_0
    return v1

    .line 140
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 142
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 145
    check-cast v0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    .line 147
    .local v0, "other":Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    invoke-virtual {p0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getCOR()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getCOR()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-virtual {p0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getPFM()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getPFM()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mComputationConfidenceValue:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getComputationConfidenceValue()Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v4

    if-eq v3, v4, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public getCOR()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mCor:Ljava/lang/String;

    return-object v0
.end method

.method public getComputationConfidenceValue()Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mComputationConfidenceValue:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    return-object v0
.end method

.method public getCustomerProvidedCOR()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->isCustomerProvided()Z

    move-result v0

    if-nez v0, :cond_0

    .line 90
    const/4 v0, 0x0

    .line 93
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getCOR()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getCustomerProvidedPFM()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->isCustomerProvided()Z

    move-result v0

    if-nez v0, :cond_0

    .line 105
    const/4 v0, 0x0

    .line 108
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getPFM()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getPFM()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mPfm:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 124
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mCor:Ljava/lang/String;

    if-nez v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit8 v0, v1, 0x1f

    .line 127
    .local v0, "result":I
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mPfm:Ljava/lang/String;

    if-nez v1, :cond_1

    move v1, v2

    :goto_1
    add-int v0, v3, v1

    .line 128
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mComputationConfidenceValue:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    if-nez v3, :cond_2

    :goto_2
    add-int/2addr v1, v2

    .line 129
    return v1

    .line 124
    .end local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mCor:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_0

    .line 127
    .restart local v0    # "result":I
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mPfm:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1

    .line 128
    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->mComputationConfidenceValue:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->hashCode()I

    move-result v2

    goto :goto_2
.end method
