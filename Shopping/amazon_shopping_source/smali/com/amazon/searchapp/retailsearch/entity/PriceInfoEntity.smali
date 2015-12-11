.class public Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PriceInfoEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/PriceInfo;


# instance fields
.field private appLink:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

.field private availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

.field private issuePrice:Ljava/lang/String;

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private listPrice:Ljava/lang/String;

.field private map:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private marketplaceLabel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private offerCount:J

.field private postLinkStyleText:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private postLinkText:Ljava/lang/String;

.field private preLinkStyleText:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private preLinkText:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

.field private shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

.field private styledLabel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private unitPrice:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->appLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getAudienceRating()Lcom/amazon/searchapp/retailsearch/model/AudienceRating;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    return-object v0
.end method

.method public getAvailability()Lcom/amazon/searchapp/retailsearch/model/Availability;
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

    return-object v0
.end method

.method public getIssuePrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 339
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->issuePrice:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getListPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->listPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getMap()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->map:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getMarketplaceLabel()Ljava/util/List;
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
    .line 199
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->marketplaceLabel:Ljava/util/List;

    return-object v0
.end method

.method public getOfferCount()J
    .locals 2

    .prologue
    .line 159
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->offerCount:J

    return-wide v0
.end method

.method public getPostLinkStyleText()Ljava/util/List;
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
    .line 319
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->postLinkStyleText:Ljava/util/List;

    return-object v0
.end method

.method public getPostLinkText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->postLinkText:Ljava/lang/String;

    return-object v0
.end method

.method public getPreLinkStyleText()Ljava/util/List;
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
    .line 419
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->preLinkStyleText:Ljava/util/List;

    return-object v0
.end method

.method public getPreLinkText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->preLinkText:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getRatings()Lcom/amazon/searchapp/retailsearch/model/Ratings;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    return-object v0
.end method

.method public getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;
    .locals 1

    .prologue
    .line 359
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    return-object v0
.end method

.method public getStyledLabel()Ljava/util/List;
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
    .line 379
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->styledLabel:Ljava/util/List;

    return-object v0
.end method

.method public getUnitPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->unitPrice:Ljava/lang/String;

    return-object v0
.end method

.method public setAppLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "appLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 229
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->appLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 230
    return-void
.end method

.method public setAudienceRating(Lcom/amazon/searchapp/retailsearch/model/AudienceRating;)V
    .locals 0
    .param p1, "audienceRating"    # Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    .line 150
    return-void
.end method

.method public setAvailability(Lcom/amazon/searchapp/retailsearch/model/Availability;)V
    .locals 0
    .param p1, "availability"    # Lcom/amazon/searchapp/retailsearch/model/Availability;

    .prologue
    .line 309
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

    .line 310
    return-void
.end method

.method public setIssuePrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "issuePrice"    # Ljava/lang/String;

    .prologue
    .line 349
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->issuePrice:Ljava/lang/String;

    .line 350
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 249
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 250
    return-void
.end method

.method public setListPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "listPrice"    # Ljava/lang/String;

    .prologue
    .line 409
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->listPrice:Ljava/lang/String;

    .line 410
    return-void
.end method

.method public setMap(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "map"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->map:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 90
    return-void
.end method

.method public setMarketplaceLabel(Ljava/util/List;)V
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
    .line 209
    .local p1, "marketplaceLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->marketplaceLabel:Ljava/util/List;

    .line 210
    return-void
.end method

.method public setOfferCount(J)V
    .locals 0
    .param p1, "offerCount"    # J

    .prologue
    .line 169
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->offerCount:J

    .line 170
    return-void
.end method

.method public setPostLinkStyleText(Ljava/util/List;)V
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
    .line 329
    .local p1, "postLinkStyleText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->postLinkStyleText:Ljava/util/List;

    .line 330
    return-void
.end method

.method public setPostLinkText(Ljava/lang/String;)V
    .locals 0
    .param p1, "postLinkText"    # Ljava/lang/String;

    .prologue
    .line 189
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->postLinkText:Ljava/lang/String;

    .line 190
    return-void
.end method

.method public setPreLinkStyleText(Ljava/util/List;)V
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
    .line 429
    .local p1, "preLinkStyleText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->preLinkStyleText:Ljava/util/List;

    .line 430
    return-void
.end method

.method public setPreLinkText(Ljava/lang/String;)V
    .locals 0
    .param p1, "preLinkText"    # Ljava/lang/String;

    .prologue
    .line 269
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->preLinkText:Ljava/lang/String;

    .line 270
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 129
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->price:Ljava/lang/String;

    .line 130
    return-void
.end method

.method public setRatings(Lcom/amazon/searchapp/retailsearch/model/Ratings;)V
    .locals 0
    .param p1, "ratings"    # Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .line 110
    return-void
.end method

.method public setShipping(Lcom/amazon/searchapp/retailsearch/model/Shipping;)V
    .locals 0
    .param p1, "shipping"    # Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .prologue
    .line 369
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .line 370
    return-void
.end method

.method public setStyledLabel(Ljava/util/List;)V
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
    .line 389
    .local p1, "styledLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->styledLabel:Ljava/util/List;

    .line 390
    return-void
.end method

.method public setUnitPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "unitPrice"    # Ljava/lang/String;

    .prologue
    .line 289
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;->unitPrice:Ljava/lang/String;

    .line 290
    return-void
.end method
