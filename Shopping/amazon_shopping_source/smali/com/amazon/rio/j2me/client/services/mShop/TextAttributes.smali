.class public Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;
.super Ljava/lang/Object;
.source "TextAttributes.java"


# instance fields
.field private allowTruncation:Ljava/lang/Boolean;

.field private color:Ljava/lang/Integer;

.field private linkUrl:Ljava/lang/String;

.field private size:Ljava/lang/Integer;

.field private style:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAllowTruncation()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->allowTruncation:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getColor()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->color:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLinkUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->linkUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->size:Ljava/lang/Integer;

    return-object v0
.end method

.method public getStyle()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->style:Ljava/lang/Integer;

    return-object v0
.end method

.method public setAllowTruncation(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->allowTruncation:Ljava/lang/Boolean;

    .line 82
    return-void
.end method

.method public setColor(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->color:Ljava/lang/Integer;

    .line 56
    return-void
.end method

.method public setLinkUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->linkUrl:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setSize(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->size:Ljava/lang/Integer;

    .line 30
    return-void
.end method

.method public setStyle(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->style:Ljava/lang/Integer;

    .line 43
    return-void
.end method
