.class Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;
.super Ljava/lang/Object;
.source "ListingFeature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/ListingFeature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Fee"
.end annotation


# instance fields
.field commission:Ljava/math/BigDecimal;

.field minimum_fee:Ljava/math/BigDecimal;

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/ListingFeature;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/inner_models/ListingFeature;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;->this$0:Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method getCommission()Ljava/math/BigDecimal;
    .locals 4

    .prologue
    .line 80
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;->commission:Ljava/math/BigDecimal;

    if-nez v0, :cond_0

    .line 81
    new-instance v0, Ljava/math/BigDecimal;

    const-wide/high16 v2, 0x4034000000000000L    # 20.0

    invoke-direct {v0, v2, v3}, Ljava/math/BigDecimal;-><init>(D)V

    .line 83
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;->commission:Ljava/math/BigDecimal;

    goto :goto_0
.end method

.method getMinimumFee()Ljava/math/BigDecimal;
    .locals 2

    .prologue
    .line 73
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;->minimum_fee:Ljava/math/BigDecimal;

    if-nez v0, :cond_0

    .line 74
    new-instance v0, Ljava/math/BigDecimal;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(I)V

    .line 76
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;->minimum_fee:Ljava/math/BigDecimal;

    goto :goto_0
.end method
