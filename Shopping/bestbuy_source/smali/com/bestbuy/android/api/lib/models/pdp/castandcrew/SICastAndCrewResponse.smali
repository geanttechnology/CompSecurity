.class public Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private response:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;

.field private type:Ljava/lang/String;

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCastAndCrewResponse()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;->response:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setCastAndCrewResponse(Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;->response:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;

    .line 23
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;->type:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;->version:Ljava/lang/String;

    .line 39
    return-void
.end method
