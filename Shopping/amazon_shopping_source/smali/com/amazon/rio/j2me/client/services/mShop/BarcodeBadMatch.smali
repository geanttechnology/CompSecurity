.class public Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;
.super Ljava/lang/Object;
.source "BarcodeBadMatch.java"


# instance fields
.field private asins:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private barcode:Ljava/lang/String;

.field private barcodeType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsins()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->asins:Ljava/util/List;

    return-object v0
.end method

.method public getBarcode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->barcode:Ljava/lang/String;

    return-object v0
.end method

.method public getBarcodeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->barcodeType:Ljava/lang/String;

    return-object v0
.end method

.method public setAsins(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 47
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->asins:Ljava/util/List;

    .line 48
    return-void
.end method

.method public setBarcode(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->barcode:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setBarcodeType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->barcodeType:Ljava/lang/String;

    .line 38
    return-void
.end method
