.class public Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private response:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

.field private type:Ljava/lang/String;

.field private version:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResponse()Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;->response:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()D
    .locals 2

    .prologue
    .line 27
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;->version:D

    return-wide v0
.end method

.method public setResponse(Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;->response:Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    .line 40
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;->type:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setVersion(D)V
    .locals 1

    .prologue
    .line 31
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;->version:D

    .line 32
    return-void
.end method
