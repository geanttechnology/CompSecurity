.class public Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;
.super Ljava/lang/Object;
.source "NavMenuItem.java"


# instance fields
.field private itemId:Ljava/lang/String;

.field private parentId:Ljava/lang/String;

.field private refMarker:Ljava/lang/String;

.field private target:Ljava/lang/String;

.field private targetUrl:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private type:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->itemId:Ljava/lang/String;

    return-object v0
.end method

.method public getParentId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->parentId:Ljava/lang/String;

    return-object v0
.end method

.method public getRefMarker()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->refMarker:Ljava/lang/String;

    return-object v0
.end method

.method public getTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->target:Ljava/lang/String;

    return-object v0
.end method

.method public getTargetUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->targetUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 33
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->type:I

    return v0
.end method

.method public setItemId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->itemId:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setParentId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->parentId:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setRefMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->refMarker:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public setTarget(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->target:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setTargetUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->targetUrl:Ljava/lang/String;

    .line 91
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->title:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 38
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;->type:I

    .line 39
    return-void
.end method
