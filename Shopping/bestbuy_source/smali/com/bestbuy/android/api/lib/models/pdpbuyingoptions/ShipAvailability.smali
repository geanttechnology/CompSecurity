.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private available:Z

.field private checkLink:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;

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
.method public getCheckLink()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->checkLink:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->available:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 23
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->available:Z

    .line 24
    return-void
.end method

.method public setCheckLink(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->checkLink:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;

    .line 32
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->displayMessage:Ljava/lang/String;

    .line 40
    return-void
.end method
