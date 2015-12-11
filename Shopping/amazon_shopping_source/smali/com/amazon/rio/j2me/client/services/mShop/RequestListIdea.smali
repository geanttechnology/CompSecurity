.class public Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;
.super Ljava/lang/Object;
.source "RequestListIdea.java"


# instance fields
.field private idea:Ljava/lang/String;

.field private listId:Ljava/lang/String;

.field private listSubtype:Ljava/lang/Integer;

.field private listType:Ljava/lang/String;

.field private vendorId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getIdea()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->idea:Ljava/lang/String;

    return-object v0
.end method

.method public getListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->listId:Ljava/lang/String;

    return-object v0
.end method

.method public getListSubtype()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->listSubtype:Ljava/lang/Integer;

    return-object v0
.end method

.method public getListType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->listType:Ljava/lang/String;

    return-object v0
.end method

.method public getVendorId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->vendorId:Ljava/lang/String;

    return-object v0
.end method

.method public setIdea(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->idea:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setListId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->listId:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setListType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->listType:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setVendorId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListIdea;->vendorId:Ljava/lang/String;

    .line 70
    return-void
.end method
