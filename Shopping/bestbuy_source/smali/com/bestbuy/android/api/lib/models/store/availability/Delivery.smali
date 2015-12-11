.class public Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private available:Z

.field private checkLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;

.field private displayMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCheckLink()Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;->checkLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;->available:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 40
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;->available:Z

    .line 41
    return-void
.end method

.method public setCheckLink(Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;->checkLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;

    .line 25
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Delivery;->displayMessage:Ljava/lang/String;

    .line 33
    return-void
.end method
