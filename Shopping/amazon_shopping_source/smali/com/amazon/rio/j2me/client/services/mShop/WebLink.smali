.class public Lcom/amazon/rio/j2me/client/services/mShop/WebLink;
.super Ljava/lang/Object;
.source "WebLink.java"


# instance fields
.field private imageUrl:Ljava/lang/String;

.field private linkUrl:Ljava/lang/String;

.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLinkUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->linkUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->name:Ljava/lang/String;

    return-object v0
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->imageUrl:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setLinkUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->linkUrl:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->name:Ljava/lang/String;

    .line 28
    return-void
.end method
