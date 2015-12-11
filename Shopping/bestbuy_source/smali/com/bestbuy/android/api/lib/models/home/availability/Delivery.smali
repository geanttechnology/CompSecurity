.class public Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private available:Z

.field private checkLink:Lcom/bestbuy/android/api/lib/models/home/availability/CheckLink;

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
.method public getCheckLink()Lcom/bestbuy/android/api/lib/models/home/availability/CheckLink;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->checkLink:Lcom/bestbuy/android/api/lib/models/home/availability/CheckLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->available:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 41
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->available:Z

    .line 42
    return-void
.end method

.method public setCheckLink(Lcom/bestbuy/android/api/lib/models/home/availability/CheckLink;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->checkLink:Lcom/bestbuy/android/api/lib/models/home/availability/CheckLink;

    .line 26
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Delivery;->displayMessage:Ljava/lang/String;

    .line 34
    return-void
.end method
