.class public Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;
.super Ljava/lang/Object;
.source "BarcodeSearchRequest.java"


# instance fields
.field private barcode:Ljava/lang/String;

.field private barcodeType:Ljava/lang/String;

.field private clickStreamOrigin:Ljava/lang/String;

.field private includeAddOnItems:Ljava/lang/Boolean;

.field private maxImageDimension:I

.field private size:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBarcode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->barcode:Ljava/lang/String;

    return-object v0
.end method

.method public getBarcodeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->barcodeType:Ljava/lang/String;

    return-object v0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getIncludeAddOnItems()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->includeAddOnItems:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getMaxImageDimension()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->maxImageDimension:I

    return v0
.end method

.method public getSize()I
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->size:I

    return v0
.end method

.method public setBarcode(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->barcode:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setBarcodeType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->barcodeType:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->clickStreamOrigin:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public setIncludeAddOnItems(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->includeAddOnItems:Ljava/lang/Boolean;

    .line 87
    return-void
.end method

.method public setMaxImageDimension(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 60
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->maxImageDimension:I

    .line 61
    return-void
.end method

.method public setSize(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 50
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->size:I

    .line 51
    return-void
.end method
