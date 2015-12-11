.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private availabilityType:Ljava/lang/String;

.field private buttonStateID:Ljava/lang/String;

.field private commerceUnavailable:Z

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
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->availabilityType:Ljava/lang/String;

    return-object v0
.end method

.method public getButtonStateID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->buttonStateID:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public isCommerceUnavailable()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->commerceUnavailable:Z

    return v0
.end method

.method public isPurchasable()Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->purchasable:Z

    return v0
.end method

.method public setAvailabilityType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->availabilityType:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setButtonStateID(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->buttonStateID:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setCommerceUnavailable(Z)V
    .locals 0

    .prologue
    .line 31
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->commerceUnavailable:Z

    .line 32
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->displayName:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setPurchasable(Z)V
    .locals 0

    .prologue
    .line 74
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->purchasable:Z

    .line 75
    return-void
.end method
