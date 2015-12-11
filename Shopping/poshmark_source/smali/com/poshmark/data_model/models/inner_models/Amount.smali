.class public Lcom/poshmark/data_model/models/inner_models/Amount;
.super Ljava/lang/Object;
.source "Amount.java"


# instance fields
.field val:Ljava/math/BigDecimal;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/Price;)V
    .locals 1
    .param p1, "price"    # Lcom/poshmark/data_model/models/inner_models/Price;

    .prologue
    .line 8
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Price;->val:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Amount;->val:Ljava/math/BigDecimal;

    .line 9
    return-void
.end method
