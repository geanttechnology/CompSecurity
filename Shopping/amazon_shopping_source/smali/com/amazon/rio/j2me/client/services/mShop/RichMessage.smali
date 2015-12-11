.class public Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
.super Ljava/lang/Object;
.source "RichMessage.java"


# instance fields
.field private backgroundColor:Ljava/lang/Integer;

.field private borderColor:Ljava/lang/Integer;

.field private imageLink:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

.field private imageUrl:Ljava/lang/String;

.field private messages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBackgroundColor()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->backgroundColor:Ljava/lang/Integer;

    return-object v0
.end method

.method public getImageLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->imageLink:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    return-object v0
.end method

.method public getMessages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->messages:Ljava/util/List;

    return-object v0
.end method

.method public setBackgroundColor(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->backgroundColor:Ljava/lang/Integer;

    .line 66
    return-void
.end method

.method public setBorderColor(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->borderColor:Ljava/lang/Integer;

    .line 79
    return-void
.end method

.method public setImageLink(Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->imageLink:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .line 53
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->imageUrl:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public setMessages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->messages:Ljava/util/List;

    .line 40
    return-void
.end method
