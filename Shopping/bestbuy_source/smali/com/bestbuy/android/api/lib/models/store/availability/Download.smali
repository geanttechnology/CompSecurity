.class public Lcom/bestbuy/android/api/lib/models/store/availability/Download;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private available:Z

.field private displayMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Download;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 17
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Download;->available:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 21
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Download;->available:Z

    .line 22
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/availability/Download;->displayMessage:Ljava/lang/String;

    .line 30
    return-void
.end method
