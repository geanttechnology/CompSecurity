.class public Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
.super Ljava/lang/Object;
.source "VisualBucket.java"


# instance fields
.field private attributes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private bestImage:[B

.field private bestImageUrl:Ljava/lang/String;

.field private sameAsBucket:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
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
.method public getAttributes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->attributes:Ljava/util/List;

    return-object v0
.end method

.method public getBestImage()[B
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->bestImage:[B

    return-object v0
.end method

.method public getBestImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->bestImageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSameAsBucket()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->sameAsBucket:Ljava/util/List;

    return-object v0
.end method

.method public setAttributes(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->attributes:Ljava/util/List;

    .line 26
    return-void
.end method

.method public setBestImage([B)V
    .locals 0
    .param p1, "value_"    # [B

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->bestImage:[B

    .line 46
    return-void
.end method

.method public setBestImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->bestImageUrl:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setSameAsBucket(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->sameAsBucket:Ljava/util/List;

    .line 36
    return-void
.end method
