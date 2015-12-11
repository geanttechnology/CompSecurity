.class public Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;
.super Ljava/lang/Object;
.source "GetListListsRequest.java"


# instance fields
.field private regType:Ljava/lang/String;

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
.method public getRegType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;->regType:Ljava/lang/String;

    return-object v0
.end method

.method public getSubtype()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;->subtype:Ljava/lang/Integer;

    return-object v0
.end method

.method public setRegType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;->regType:Ljava/lang/String;

    .line 24
    return-void
.end method
