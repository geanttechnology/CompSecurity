.class public Lcom/bestbuy/android/api/lib/models/home/GHPBanner;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x10d7eb7a20d4aa23L


# instance fields
.field private large:Lcom/bestbuy/android/api/lib/models/home/GHPLarge;

.field private small:Lcom/bestbuy/android/api/lib/models/home/GHPSmall;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLarge()Lcom/bestbuy/android/api/lib/models/home/GHPLarge;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/GHPBanner;->large:Lcom/bestbuy/android/api/lib/models/home/GHPLarge;

    return-object v0
.end method

.method public getSmall()Lcom/bestbuy/android/api/lib/models/home/GHPSmall;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/GHPBanner;->small:Lcom/bestbuy/android/api/lib/models/home/GHPSmall;

    return-object v0
.end method

.method public setLarge(Lcom/bestbuy/android/api/lib/models/home/GHPLarge;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/GHPBanner;->large:Lcom/bestbuy/android/api/lib/models/home/GHPLarge;

    .line 42
    return-void
.end method

.method public setSmall(Lcom/bestbuy/android/api/lib/models/home/GHPSmall;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/GHPBanner;->small:Lcom/bestbuy/android/api/lib/models/home/GHPSmall;

    .line 30
    return-void
.end method
