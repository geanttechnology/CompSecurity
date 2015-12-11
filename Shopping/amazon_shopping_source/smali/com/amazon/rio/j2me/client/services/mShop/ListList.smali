.class public Lcom/amazon/rio/j2me/client/services/mShop/ListList;
.super Ljava/lang/Object;
.source "ListList.java"


# instance fields
.field private isDefault:Ljava/lang/Boolean;

.field private isPrivate:Ljava/lang/Boolean;

.field private isSearchable:Ljava/lang/Boolean;

.field private lastModified:Ljava/lang/String;

.field private listId:Ljava/lang/String;

.field private listTitle:Ljava/lang/String;

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
.method public getListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->listId:Ljava/lang/String;

    return-object v0
.end method

.method public getListTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->listTitle:Ljava/lang/String;

    return-object v0
.end method

.method public setIsDefault(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->isDefault:Ljava/lang/Boolean;

    .line 65
    return-void
.end method

.method public setIsPrivate(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->isPrivate:Ljava/lang/Boolean;

    .line 78
    return-void
.end method

.method public setIsSearchable(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->isSearchable:Ljava/lang/Boolean;

    .line 91
    return-void
.end method

.method public setLastModified(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->lastModified:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public setListId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->listId:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setListTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->listTitle:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setSubtype(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->subtype:Ljava/lang/Integer;

    .line 52
    return-void
.end method
