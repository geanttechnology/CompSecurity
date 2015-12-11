.class public Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private characterName:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private imageUrl:Ljava/lang/String;

.field private role:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2630
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2631
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;->displayName:Ljava/lang/String;

    .line 2632
    iput-object p2, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;->characterName:Ljava/lang/String;

    .line 2633
    iput-object p3, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;->imageUrl:Ljava/lang/String;

    .line 2634
    iput-object p4, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;->role:Ljava/lang/String;

    .line 2635
    return-void
.end method


# virtual methods
.method public getCharacterName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2642
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;->characterName:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2638
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2646
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getRole()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2650
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;->role:Ljava/lang/String;

    return-object v0
.end method
