.class public Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private directors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;"
        }
    .end annotation
.end field

.field private otherCrew:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;"
        }
    .end annotation
.end field

.field private writers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDirectors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->directors:Ljava/util/List;

    return-object v0
.end method

.method public getOtherCrew()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->otherCrew:Ljava/util/List;

    return-object v0
.end method

.method public getWriters()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->writers:Ljava/util/List;

    return-object v0
.end method

.method public setDirectors(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->directors:Ljava/util/List;

    .line 39
    return-void
.end method

.method public setOtherCrew(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->otherCrew:Ljava/util/List;

    .line 31
    return-void
.end method

.method public setWriters(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->writers:Ljava/util/List;

    .line 23
    return-void
.end method
