.class public Lcom/poshmark/data_model/models/inner_models/Price;
.super Ljava/lang/Object;
.source "Price.java"


# instance fields
.field val:Ljava/math/BigDecimal;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/Price;)V
    .locals 1
    .param p1, "price"    # Lcom/poshmark/data_model/models/inner_models/Price;

    .prologue
    .line 9
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Price;->val:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Price;->val:Ljava/math/BigDecimal;

    .line 10
    return-void
.end method
