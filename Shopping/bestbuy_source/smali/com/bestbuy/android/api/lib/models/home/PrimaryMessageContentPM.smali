.class public Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContentPM;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x36bdf215f792db74L


# instance fields
.field private GHP:Lcom/bestbuy/android/api/lib/models/home/GHPBanner;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getGHP()Lcom/bestbuy/android/api/lib/models/home/GHPBanner;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContentPM;->GHP:Lcom/bestbuy/android/api/lib/models/home/GHPBanner;

    return-object v0
.end method

.method public setGHP(Lcom/bestbuy/android/api/lib/models/home/GHPBanner;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContentPM;->GHP:Lcom/bestbuy/android/api/lib/models/home/GHPBanner;

    .line 30
    return-void
.end method
