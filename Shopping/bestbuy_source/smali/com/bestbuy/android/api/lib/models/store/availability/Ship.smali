.class public Lcom/bestbuy/android/api/lib/models/store/availability/Ship;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private available:Ljava/lang/String;

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
.method public getAvailable()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->available:Ljava/lang/String;

    return-object v0
.end method

.method public getCheckLink()Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->checkLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;

    return-object v0
.end method

.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public setAvailable(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->available:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setCheckLink(Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->checkLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;

    .line 34
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->displayMessage:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 46
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [displayMessage = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->displayMessage:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", checkLink = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->checkLink:Lcom/bestbuy/android/api/lib/models/store/availability/CheckLink;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", available = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Ship;->available:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
