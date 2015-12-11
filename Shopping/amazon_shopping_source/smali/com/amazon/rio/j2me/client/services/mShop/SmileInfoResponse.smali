.class public Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;
.super Ljava/lang/Object;
.source "SmileInfoResponse.java"


# instance fields
.field private charityName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCharityName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;->charityName:Ljava/lang/String;

    return-object v0
.end method

.method public setCharityName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;->charityName:Ljava/lang/String;

    .line 26
    return-void
.end method
