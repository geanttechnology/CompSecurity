.class public Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
.super Ljava/lang/Object;
.source "HomeShoveler.java"


# instance fields
.field private clickStreamOrigin:Ljava/lang/String;

.field private displayType:Ljava/lang/Integer;

.field private items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;",
            ">;"
        }
    .end annotation
.end field

.field private itemsSubtitle:Ljava/lang/String;

.field private moreLink:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

.field private moreLinkText:Ljava/lang/String;

.field private seedItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;",
            ">;"
        }
    .end annotation
.end field

.field private seedSubtitle:Ljava/lang/String;

.field private slotToken:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayType()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->displayType:Ljava/lang/Integer;

    return-object v0
.end method

.method public getItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->items:Ljava/util/List;

    return-object v0
.end method

.method public getMoreLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->moreLink:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    return-object v0
.end method

.method public getMoreLinkText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->moreLinkText:Ljava/lang/String;

    return-object v0
.end method

.method public getSlotToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->slotToken:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 138
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->clickStreamOrigin:Ljava/lang/String;

    .line 139
    return-void
.end method

.method public setDisplayType(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->displayType:Ljava/lang/Integer;

    .line 152
    return-void
.end method

.method public setItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 86
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->items:Ljava/util/List;

    .line 87
    return-void
.end method

.method public setItemsSubtitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->itemsSubtitle:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setMoreLink(Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->moreLink:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .line 113
    return-void
.end method

.method public setMoreLinkText(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->moreLinkText:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setSeedItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 73
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->seedItems:Ljava/util/List;

    .line 74
    return-void
.end method

.method public setSeedSubtitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->seedSubtitle:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setSlotToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->slotToken:Ljava/lang/String;

    .line 126
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->title:Ljava/lang/String;

    .line 35
    return-void
.end method
