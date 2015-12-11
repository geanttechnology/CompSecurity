.class public Lcom/poshmark/data_model/models/inner_models/MakeAnOfferFeature;
.super Ljava/lang/Object;
.source "MakeAnOfferFeature.java"


# instance fields
.field enabled:Z

.field minimum_offer_price_pct:F

.field my_offers_enabled:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/MakeAnOfferFeature;->enabled:Z

    .line 8
    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/MakeAnOfferFeature;->my_offers_enabled:Z

    return-void
.end method


# virtual methods
.method public isEnabled()Z
    .locals 1

    .prologue
    .line 11
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/MakeAnOfferFeature;->enabled:Z

    return v0
.end method
