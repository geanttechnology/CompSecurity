.class public Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ShippingEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Shipping;


# instance fields
.field private addOn:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

.field private additionalStatus:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;",
            ">;"
        }
    .end annotation
.end field

.field private cod:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

.field private fba:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

.field private preOrder:Z

.field private prime:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

.field private sss:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAddOn()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->addOn:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    return-object v0
.end method

.method public getAdditionalStatus()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;",
            ">;"
        }
    .end annotation

    .prologue
    .line 122
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->additionalStatus:Ljava/util/List;

    return-object v0
.end method

.method public getCod()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->cod:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    return-object v0
.end method

.method public getFba()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->fba:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    return-object v0
.end method

.method public getPreOrder()Z
    .locals 1

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->preOrder:Z

    return v0
.end method

.method public getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->prime:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    return-object v0
.end method

.method public getSss()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->sss:Ljava/util/List;

    return-object v0
.end method

.method public setAddOn(Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;)V
    .locals 0
    .param p1, "addOn"    # Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .prologue
    .line 172
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->addOn:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .line 173
    return-void
.end method

.method public setAdditionalStatus(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 132
    .local p1, "additionalStatus":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->additionalStatus:Ljava/util/List;

    .line 133
    return-void
.end method

.method public setCod(Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;)V
    .locals 0
    .param p1, "cod"    # Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->cod:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .line 113
    return-void
.end method

.method public setFba(Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;)V
    .locals 0
    .param p1, "fba"    # Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->fba:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .line 93
    return-void
.end method

.method public setPreOrder(Z)V
    .locals 0
    .param p1, "preOrder"    # Z

    .prologue
    .line 72
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->preOrder:Z

    .line 73
    return-void
.end method

.method public setPrime(Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;)V
    .locals 0
    .param p1, "prime"    # Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->prime:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .line 53
    return-void
.end method

.method public setSss(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 152
    .local p1, "sss":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;->sss:Ljava/util/List;

    .line 153
    return-void
.end method
