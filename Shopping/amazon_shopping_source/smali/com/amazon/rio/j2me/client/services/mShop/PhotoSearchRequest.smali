.class public Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;
.super Ljava/lang/Object;
.source "PhotoSearchRequest.java"


# instance fields
.field private image:[B

.field private includeAddOnItems:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getImage()[B
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;->image:[B

    return-object v0
.end method

.method public getIncludeAddOnItems()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;->includeAddOnItems:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setImage([B)V
    .locals 0
    .param p1, "value_"    # [B

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;->image:[B

    .line 24
    return-void
.end method

.method public setIncludeAddOnItems(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;->includeAddOnItems:Ljava/lang/Boolean;

    .line 37
    return-void
.end method
