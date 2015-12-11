.class public Lcom/amazon/device/ads/AdTargetingOptions;
.super Ljava/lang/Object;
.source "AdTargetingOptions.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdTargetingOptions$Gender;
    }
.end annotation


# static fields
.field private static final LOGTAG:Ljava/lang/String;


# instance fields
.field private advanced:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private age:I

.field private enableGeoTargeting:Z

.field private floorPrice:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/amazon/device/ads/AdTargetingOptions;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AdTargetingOptions;->LOGTAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const/high16 v0, -0x80000000

    iput v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->age:I

    .line 32
    const-wide/high16 v0, -0x8000000000000000L

    iput-wide v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->floorPrice:J

    .line 33
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->enableGeoTargeting:Z

    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->advanced:Ljava/util/Map;

    .line 35
    return-void
.end method


# virtual methods
.method public containsAdvancedOption(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->advanced:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public enableGeoLocation(Z)Lcom/amazon/device/ads/AdTargetingOptions;
    .locals 0
    .param p1, "enable"    # Z

    .prologue
    .line 132
    iput-boolean p1, p0, Lcom/amazon/device/ads/AdTargetingOptions;->enableGeoTargeting:Z

    .line 133
    return-object p0
.end method

.method public getAdvancedOption(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->advanced:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getAge()I
    .locals 1

    .prologue
    .line 188
    iget v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->age:I

    return v0
.end method

.method getCopyOfAdvancedOptions()Ljava/util/HashMap;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 113
    new-instance v0, Ljava/util/HashMap;

    iget-object v1, p0, Lcom/amazon/device/ads/AdTargetingOptions;->advanced:Ljava/util/Map;

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 114
    .local v0, "ret":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    return-object v0
.end method

.method public getFloorPrice()J
    .locals 2

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->floorPrice:J

    return-wide v0
.end method

.method public getGender()Lcom/amazon/device/ads/AdTargetingOptions$Gender;
    .locals 1

    .prologue
    .line 163
    sget-object v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->UNKNOWN:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    return-object v0
.end method

.method hasAge()Z
    .locals 2

    .prologue
    .line 193
    iget v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->age:I

    const/4 v1, -0x1

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method hasFloorPrice()Z
    .locals 4

    .prologue
    .line 62
    iget-wide v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->floorPrice:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isGeoLocationEnabled()Z
    .locals 1

    .prologue
    .line 143
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->enableGeoTargeting:Z

    return v0
.end method

.method public setAdvancedOption(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/device/ads/AdTargetingOptions;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 77
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 79
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Option Key must not be null or empty string"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 81
    :cond_0
    if-eqz p2, :cond_1

    .line 82
    iget-object v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->advanced:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    :goto_0
    return-object p0

    .line 84
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/ads/AdTargetingOptions;->advanced:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public setAge(I)Lcom/amazon/device/ads/AdTargetingOptions;
    .locals 0
    .param p1, "age"    # I

    .prologue
    .line 177
    iput p1, p0, Lcom/amazon/device/ads/AdTargetingOptions;->age:I

    .line 178
    return-object p0
.end method

.method public setFloorPrice(J)Lcom/amazon/device/ads/AdTargetingOptions;
    .locals 0
    .param p1, "floorPrice"    # J

    .prologue
    .line 47
    iput-wide p1, p0, Lcom/amazon/device/ads/AdTargetingOptions;->floorPrice:J

    .line 48
    return-object p0
.end method

.method public setGender(Lcom/amazon/device/ads/AdTargetingOptions$Gender;)Lcom/amazon/device/ads/AdTargetingOptions;
    .locals 2
    .param p1, "gender"    # Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    .prologue
    .line 151
    sget-object v0, Lcom/amazon/device/ads/AdTargetingOptions;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v1, "Gender information has been deprecated and is no longer used for targeting."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    return-object p0
.end method
