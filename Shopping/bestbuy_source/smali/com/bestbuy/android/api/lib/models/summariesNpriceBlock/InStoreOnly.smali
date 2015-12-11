.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private available:Z

.field private checkStoresLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

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
.method public getCheckLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->available:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 49
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->available:Z

    .line 50
    return-void
.end method

.method public setCheckLink(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->checkStoresLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    .line 26
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/InStoreOnly;->displayMessage:Ljava/lang/String;

    .line 40
    return-void
.end method
