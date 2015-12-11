.class public Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;
.super Lcom/poshmark/data_model/models/inner_models/Feature;
.source "ShopTabLuxuryFeature.java"


# instance fields
.field enabled:Z

.field target_url:Ljava/lang/String;

.field title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/poshmark/data_model/models/inner_models/Feature;-><init>()V

    .line 7
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;->enabled:Z

    return-void
.end method


# virtual methods
.method public getMappPageTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;->target_url:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;->title:Ljava/lang/String;

    return-object v0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 13
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;->enabled:Z

    return v0
.end method
