.class public Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private bookABlueShirt:Z

.field private bookABlueShirtStores:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private chat:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBookABlueShirtStores()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->bookABlueShirtStores:Ljava/util/ArrayList;

    return-object v0
.end method

.method public isBookABlueShirt()Z
    .locals 1

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->bookABlueShirt:Z

    return v0
.end method

.method public isChat()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->chat:Z

    return v0
.end method

.method public setBookABlueShirt(Z)V
    .locals 0

    .prologue
    .line 23
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->bookABlueShirt:Z

    .line 24
    return-void
.end method

.method public setBookABlueShirtStores(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->bookABlueShirtStores:Ljava/util/ArrayList;

    .line 40
    return-void
.end method

.method public setChat(Z)V
    .locals 0

    .prologue
    .line 31
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->chat:Z

    .line 32
    return-void
.end method
