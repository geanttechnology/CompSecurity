.class public Lcom/bestbuy/android/api/lib/models/search/Si;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private response:Lcom/bestbuy/android/api/lib/models/search/Response;

.field private type:Ljava/lang/String;

.field private version:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResponse()Lcom/bestbuy/android/api/lib/models/search/Response;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Si;->response:Lcom/bestbuy/android/api/lib/models/search/Response;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Si;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()D
    .locals 2

    .prologue
    .line 31
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/search/Si;->version:D

    return-wide v0
.end method

.method public setResponse(Lcom/bestbuy/android/api/lib/models/search/Response;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Si;->response:Lcom/bestbuy/android/api/lib/models/search/Response;

    .line 56
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Si;->type:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setVersion(D)V
    .locals 1

    .prologue
    .line 49
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/search/Si;->version:D

    .line 50
    return-void
.end method
