.class public Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;
.super Ljava/lang/Object;
.source "RequestListItem.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private listId:Ljava/lang/String;

.field private listItemId:Ljava/lang/String;

.field private listType:Ljava/lang/String;

.field private subtype:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->listId:Ljava/lang/String;

    return-object v0
.end method

.method public getListItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->listItemId:Ljava/lang/String;

    return-object v0
.end method

.method public getListType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->listType:Ljava/lang/String;

    return-object v0
.end method

.method public getSubtype()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->subtype:Ljava/lang/Integer;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->asin:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setListId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->listId:Ljava/lang/String;

    .line 70
    return-void
.end method

.method public setListItemId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->listItemId:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setListType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;->listType:Ljava/lang/String;

    .line 27
    return-void
.end method
