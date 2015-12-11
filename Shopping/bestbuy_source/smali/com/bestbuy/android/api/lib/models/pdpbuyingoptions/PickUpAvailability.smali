.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private available:Z

.field private checkStoresLink:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckStoresLink;

.field private displayMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCheckStoresLink()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckStoresLink;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckStoresLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->available:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 23
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->available:Z

    .line 24
    return-void
.end method

.method public setCheckStoresLink(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckStoresLink;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckStoresLink;

    .line 40
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->displayMessage:Ljava/lang/String;

    .line 32
    return-void
.end method
