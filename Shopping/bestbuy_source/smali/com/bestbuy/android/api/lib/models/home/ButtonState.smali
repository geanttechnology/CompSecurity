.class public Lcom/bestbuy/android/api/lib/models/home/ButtonState;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x6e550511554b4303L


# instance fields
.field private availabilityType:Ljava/lang/String;

.field private buttonStateID:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private purchasable:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailabilityType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ButtonState;->availabilityType:Ljava/lang/String;

    return-object v0
.end method

.method public getButtonStateID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ButtonState;->buttonStateID:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ButtonState;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public isPurchasable()Z
    .locals 1

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/ButtonState;->purchasable:Z

    return v0
.end method

.method public setAvailabilityType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ButtonState;->availabilityType:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setButtonStateID(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ButtonState;->buttonStateID:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ButtonState;->displayName:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setPurchasable(Z)V
    .locals 0

    .prologue
    .line 61
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/ButtonState;->purchasable:Z

    .line 62
    return-void
.end method
