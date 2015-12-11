.class public Lcom/poshmark/data_model/models/PMDiscount;
.super Ljava/lang/Object;
.source "PMDiscount.java"


# static fields
.field public static final TargetTypeItemPrice:Ljava/lang/String; = "iprc"

.field public static final TargetTypeShipping:Ljava/lang/String; = "shp"


# instance fields
.field amount:Lcom/poshmark/data_model/models/inner_models/Amount;

.field discount_price:Ljava/math/BigDecimal;

.field discount_title:Ljava/lang/String;

.field discount_type:Ljava/lang/String;

.field target_type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDiscountPriceString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 27
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMDiscount;->discount_price:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTargetType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMDiscount;->target_type:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMDiscount;->discount_title:Ljava/lang/String;

    return-object v0
.end method
