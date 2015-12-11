.class public Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private characterNames:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CharacterName;",
            ">;"
        }
    .end annotation
.end field

.field private displayName:Ljava/lang/String;

.field private headshotImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCharacterNames()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CharacterName;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->characterNames:Ljava/util/List;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getHeadshotImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->headshotImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    return-object v0
.end method

.method public setCharacterNames(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CharacterName;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->characterNames:Ljava/util/List;

    .line 24
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->displayName:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setHeadshotImage(Lcom/bestbuy/android/api/lib/models/home/ImageType;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->headshotImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    .line 40
    return-void
.end method
