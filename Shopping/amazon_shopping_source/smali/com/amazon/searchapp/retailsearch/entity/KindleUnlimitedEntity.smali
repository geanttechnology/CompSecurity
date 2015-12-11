.class public Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "KindleUnlimitedEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;


# instance fields
.field private badge:Lcom/amazon/searchapp/retailsearch/model/StyledText;

.field private isSubscribed:Z

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private messages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private price:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBadge()Lcom/amazon/searchapp/retailsearch/model/StyledText;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->badge:Lcom/amazon/searchapp/retailsearch/model/StyledText;

    return-object v0
.end method

.method public getIsSubscribed()Z
    .locals 1

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->isSubscribed:Z

    return v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getMessages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->messages:Ljava/util/List;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->price:Ljava/lang/String;

    return-object v0
.end method

.method public setBadge(Lcom/amazon/searchapp/retailsearch/model/StyledText;)V
    .locals 0
    .param p1, "badge"    # Lcom/amazon/searchapp/retailsearch/model/StyledText;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->badge:Lcom/amazon/searchapp/retailsearch/model/StyledText;

    .line 107
    return-void
.end method

.method public setIsSubscribed(Z)V
    .locals 0
    .param p1, "isSubscribed"    # Z

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->isSubscribed:Z

    .line 47
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 67
    return-void
.end method

.method public setMessages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 126
    .local p1, "messages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->messages:Ljava/util/List;

    .line 127
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;->price:Ljava/lang/String;

    .line 87
    return-void
.end method
