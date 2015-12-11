.class public Lcom/bestbuy/android/api/lib/models/registry/TokenResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private refreshToken:Lcom/bestbuy/android/api/lib/models/registry/RefreshToken;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getRefreshToken()Lcom/bestbuy/android/api/lib/models/registry/RefreshToken;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/TokenResponse;->refreshToken:Lcom/bestbuy/android/api/lib/models/registry/RefreshToken;

    return-object v0
.end method

.method public setRefreshToken(Lcom/bestbuy/android/api/lib/models/registry/RefreshToken;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/TokenResponse;->refreshToken:Lcom/bestbuy/android/api/lib/models/registry/RefreshToken;

    .line 29
    return-void
.end method
