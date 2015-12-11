.class public Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private requirements:Lcom/bestbuy/android/api/lib/models/pdp/Requirement;

.field private specifications:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getRequirements()Lcom/bestbuy/android/api/lib/models/pdp/Requirement;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->requirements:Lcom/bestbuy/android/api/lib/models/pdp/Requirement;

    return-object v0
.end method

.method public getSpecifications()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->specifications:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setRequirements(Lcom/bestbuy/android/api/lib/models/pdp/Requirement;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->requirements:Lcom/bestbuy/android/api/lib/models/pdp/Requirement;

    .line 26
    return-void
.end method

.method public setSpecifications(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->specifications:Ljava/util/ArrayList;

    .line 34
    return-void
.end method
