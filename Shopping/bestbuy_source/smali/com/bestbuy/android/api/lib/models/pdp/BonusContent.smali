.class public Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private availabilityMessage:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private primaryImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailabilityMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->availabilityMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimaryImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->primaryImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    return-object v0
.end method

.method public setAvailabilityMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->availabilityMessage:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->description:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->displayName:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setPrimaryImage(Lcom/bestbuy/android/api/lib/models/home/ImageType;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->primaryImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    .line 48
    return-void
.end method
