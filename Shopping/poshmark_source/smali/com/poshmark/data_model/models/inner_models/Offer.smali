.class public Lcom/poshmark/data_model/models/inner_models/Offer;
.super Ljava/lang/Object;
.source "Offer.java"


# instance fields
.field private description:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/Offer;)V
    .locals 1
    .param p1, "offer"    # Lcom/poshmark/data_model/models/inner_models/Offer;

    .prologue
    .line 10
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Offer;->id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Offer;->id:Ljava/lang/String;

    .line 11
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Offer;->type:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Offer;->type:Ljava/lang/String;

    .line 12
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Offer;->description:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Offer;->description:Ljava/lang/String;

    .line 13
    return-void
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Offer;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Offer;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Offer;->type:Ljava/lang/String;

    return-object v0
.end method
