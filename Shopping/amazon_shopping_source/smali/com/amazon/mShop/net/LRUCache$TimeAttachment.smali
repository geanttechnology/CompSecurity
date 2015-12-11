.class Lcom/amazon/mShop/net/LRUCache$TimeAttachment;
.super Ljava/lang/Object;
.source "LRUCache.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/LRUCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "TimeAttachment"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/amazon/mShop/net/LRUCache$TimeAttachment;",
        ">;"
    }
.end annotation


# instance fields
.field private key:Ljava/lang/String;

.field private time:Ljava/lang/Long;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Long;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "time"    # Ljava/lang/Long;

    .prologue
    .line 355
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 356
    iput-object p2, p0, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->time:Ljava/lang/Long;

    .line 357
    iput-object p1, p0, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->key:Ljava/lang/String;

    .line 358
    return-void
.end method


# virtual methods
.method public compareTo(Lcom/amazon/mShop/net/LRUCache$TimeAttachment;)I
    .locals 2
    .param p1, "another"    # Lcom/amazon/mShop/net/LRUCache$TimeAttachment;

    .prologue
    .line 374
    if-nez p1, :cond_0

    .line 376
    const/4 v0, -0x1

    .line 379
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->time:Ljava/lang/Long;

    invoke-virtual {p1}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->getTime()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v0

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 351
    check-cast p1, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->compareTo(Lcom/amazon/mShop/net/LRUCache$TimeAttachment;)I

    move-result v0

    return v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 361
    iget-object v0, p0, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getTime()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 365
    iget-object v0, p0, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->time:Ljava/lang/Long;

    return-object v0
.end method

.method public setTime(Ljava/lang/Long;)V
    .locals 0
    .param p1, "time"    # Ljava/lang/Long;

    .prologue
    .line 369
    iput-object p1, p0, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->time:Ljava/lang/Long;

    .line 370
    return-void
.end method
