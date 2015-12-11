.class public Lcom/bestbuy/android/api/lib/models/cart/GiftItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private eventDate:Ljava/lang/String;

.field private eventDescription:Ljava/lang/String;

.field private firstName:Ljava/lang/String;

.field private giftListId:Ljava/lang/String;

.field private giftListItemId:Ljava/lang/String;

.field private giftListType:Ljava/lang/String;

.field private lastName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getEventDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->eventDate:Ljava/lang/String;

    return-object v0
.end method

.method public getEventDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->eventDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getGiftListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->giftListId:Ljava/lang/String;

    return-object v0
.end method

.method public getGiftListItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->giftListItemId:Ljava/lang/String;

    return-object v0
.end method

.method public getGiftListType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->giftListType:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public setEventDate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->eventDate:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setEventDescription(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->eventDescription:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public setFirstName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->firstName:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setGiftListId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->giftListId:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setGiftListItemId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->giftListItemId:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setGiftListType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->giftListType:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setLastName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->lastName:Ljava/lang/String;

    .line 25
    return-void
.end method
