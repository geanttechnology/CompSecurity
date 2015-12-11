.class public Lcom/poshmark/data_model/models/PMOffer;
.super Lcom/poshmark/data_model/models/PMOrder;
.source "PMOffer.java"


# instance fields
.field public offer_price:Ljava/math/BigDecimal;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMOrder;-><init>()V

    return-void
.end method


# virtual methods
.method public getBasePrice()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOffer;->offer_price:Ljava/math/BigDecimal;

    return-object v0
.end method
