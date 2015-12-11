.class public Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private castMembers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;",
            ">;"
        }
    .end annotation
.end field

.field private crewMembers:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCastMembers()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->castMembers:Ljava/util/List;

    return-object v0
.end method

.method public getCrewMembers()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->crewMembers:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;

    return-object v0
.end method

.method public setCastMembers(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->castMembers:Ljava/util/List;

    .line 23
    return-void
.end method

.method public setCrewMembers(Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->crewMembers:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;

    .line 31
    return-void
.end method
