.class public Lcom/poshmark/data_model/models/Referral;
.super Ljava/lang/Object;
.source "Referral.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    }
.end annotation


# instance fields
.field campaign_id:Ljava/lang/String;

.field created_at:Ljava/lang/String;

.field default_messages:Lcom/poshmark/data_model/models/Referral$DefaultMessages;

.field id:Ljava/lang/String;

.field max_uses:I

.field num_used:I

.field program:Ljava/lang/String;

.field referred_incentive:Ljava/math/BigDecimal;

.field referrer_id:Ljava/lang/String;

.field referrer_incentive:Ljava/math/BigDecimal;

.field status:Ljava/lang/String;

.field trigger_event:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    return-void
.end method


# virtual methods
.method public getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/poshmark/data_model/models/Referral;->default_messages:Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/poshmark/data_model/models/Referral;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getProgram()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/poshmark/data_model/models/Referral;->program:Ljava/lang/String;

    return-object v0
.end method

.method public getReferredIncentiveFormattedString()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 48
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/Referral;->referred_incentive:Ljava/math/BigDecimal;

    invoke-static {v1, v2, v2}, Lcom/poshmark/utils/NumberUtils;->getBigDecimalAsGroupedString(Ljava/math/BigDecimal;II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getReferredIncentiveString()Ljava/lang/String;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 52
    iget-object v0, p0, Lcom/poshmark/data_model/models/Referral;->referred_incentive:Ljava/math/BigDecimal;

    invoke-static {v0, v1, v1}, Lcom/poshmark/utils/NumberUtils;->getBigDecimalAsGroupedString(Ljava/math/BigDecimal;II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getReferrerIncentiveFormattedString()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 44
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/Referral;->referrer_incentive:Ljava/math/BigDecimal;

    invoke-static {v1, v2, v2}, Lcom/poshmark/utils/NumberUtils;->getBigDecimalAsGroupedString(Ljava/math/BigDecimal;II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getReferrerIncentiveString()Ljava/lang/String;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 40
    iget-object v0, p0, Lcom/poshmark/data_model/models/Referral;->referrer_incentive:Ljava/math/BigDecimal;

    invoke-static {v0, v1, v1}, Lcom/poshmark/utils/NumberUtils;->getBigDecimalAsGroupedString(Ljava/math/BigDecimal;II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
