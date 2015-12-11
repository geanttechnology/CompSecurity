.class public Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
.super Ljava/lang/Object;
.source "MultiImage.java"


# instance fields
.field private hiresUrl:Ljava/lang/String;

.field private standardUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getHiresUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->hiresUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getStandardUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->standardUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setHiresUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->hiresUrl:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setStandardUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->standardUrl:Ljava/lang/String;

    .line 27
    return-void
.end method
