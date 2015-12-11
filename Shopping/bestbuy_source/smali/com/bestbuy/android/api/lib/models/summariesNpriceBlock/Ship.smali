.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private available:Z

.field private checkLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

.field private displayMessage:Ljava/lang/String;

.field private signatureRequired:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCheckLink()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->checkLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 29
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->available:Z

    return v0
.end method

.method public isSignatureRequired()Z
    .locals 1

    .prologue
    .line 63
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->signatureRequired:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 47
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->available:Z

    .line 48
    return-void
.end method

.method public setCheckLink(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->checkLink:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;

    .line 54
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->displayMessage:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setSignatureRequired(Z)V
    .locals 0

    .prologue
    .line 67
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Ship;->signatureRequired:Z

    .line 68
    return-void
.end method
