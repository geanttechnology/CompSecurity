.class public Lcom/bestbuy/android/api/lib/models/home/availability/Download;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


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
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Download;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailable()Z
    .locals 1

    .prologue
    .line 18
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Download;->available:Z

    return v0
.end method

.method public setAvailable(Z)V
    .locals 0

    .prologue
    .line 22
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Download;->available:Z

    .line 23
    return-void
.end method

.method public setDisplayMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/availability/Download;->displayMessage:Ljava/lang/String;

    .line 31
    return-void
.end method
