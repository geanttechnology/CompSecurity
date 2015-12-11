.class public Lcom/bestbuy/android/api/lib/models/registry/ProfileResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private userData:Lcom/bestbuy/android/api/lib/models/registry/ProfileUserData;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getUserData()Lcom/bestbuy/android/api/lib/models/registry/ProfileUserData;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/ProfileResponse;->userData:Lcom/bestbuy/android/api/lib/models/registry/ProfileUserData;

    return-object v0
.end method

.method public setUserData(Lcom/bestbuy/android/api/lib/models/registry/ProfileUserData;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/ProfileResponse;->userData:Lcom/bestbuy/android/api/lib/models/registry/ProfileUserData;

    .line 28
    return-void
.end method
