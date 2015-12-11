.class public Lcom/bestbuy/android/api/lib/models/store/StoreDetails;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private address:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "addr1"
    .end annotation
.end field

.field private city:Ljava/lang/String;

.field private country:Ljava/lang/String;

.field private detailedHours:[Lcom/bestbuy/android/api/lib/models/store/DetailedHours;

.field private fri_close:Ljava/lang/String;

.field private fri_open:Ljava/lang/String;

.field private hasLimitedShipToStore:Z

.field private hasPickupAndShipToStore:Z

.field private latitude:Ljava/lang/String;

.field private locationSubType:Ljava/lang/String;

.field private locationType:Ljava/lang/String;

.field private longitude:Ljava/lang/String;

.field private mon_close:Ljava/lang/String;

.field private mon_open:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private phone:Ljava/lang/String;

.field private sat_close:Ljava/lang/String;

.field private sat_open:Ljava/lang/String;

.field private state:Ljava/lang/String;

.field private status:Ljava/lang/String;

.field private sun_close:Ljava/lang/String;

.field private sun_open:Ljava/lang/String;

.field private thu_close:Ljava/lang/String;

.field private thu_open:Ljava/lang/String;

.field private tue_close:Ljava/lang/String;

.field private tue_open:Ljava/lang/String;

.field private wed_close:Ljava/lang/String;

.field private wed_open:Ljava/lang/String;

.field private zipCode:Ljava/lang/String;

.field private zipPlusFour:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->country:Ljava/lang/String;

    return-object v0
.end method

.method public getDetailedHours()[Lcom/bestbuy/android/api/lib/models/store/DetailedHours;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->detailedHours:[Lcom/bestbuy/android/api/lib/models/store/DetailedHours;

    return-object v0
.end method

.method public getFri_close()Ljava/lang/String;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->fri_close:Ljava/lang/String;

    return-object v0
.end method

.method public getFri_open()Ljava/lang/String;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->fri_open:Ljava/lang/String;

    return-object v0
.end method

.method public getLatitude()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->latitude:Ljava/lang/String;

    return-object v0
.end method

.method public getLocationSubType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->locationSubType:Ljava/lang/String;

    return-object v0
.end method

.method public getLocationType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->locationType:Ljava/lang/String;

    return-object v0
.end method

.method public getLongitude()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->longitude:Ljava/lang/String;

    return-object v0
.end method

.method public getMon_close()Ljava/lang/String;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->mon_close:Ljava/lang/String;

    return-object v0
.end method

.method public getMon_open()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->mon_open:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPhone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->phone:Ljava/lang/String;

    return-object v0
.end method

.method public getSat_close()Ljava/lang/String;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->sat_close:Ljava/lang/String;

    return-object v0
.end method

.method public getSat_open()Ljava/lang/String;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->sat_open:Ljava/lang/String;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->status:Ljava/lang/String;

    return-object v0
.end method

.method public getSun_close()Ljava/lang/String;
    .locals 1

    .prologue
    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->sun_close:Ljava/lang/String;

    return-object v0
.end method

.method public getSun_open()Ljava/lang/String;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->sun_open:Ljava/lang/String;

    return-object v0
.end method

.method public getThu_close()Ljava/lang/String;
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->thu_close:Ljava/lang/String;

    return-object v0
.end method

.method public getThu_open()Ljava/lang/String;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->thu_open:Ljava/lang/String;

    return-object v0
.end method

.method public getTue_close()Ljava/lang/String;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->tue_close:Ljava/lang/String;

    return-object v0
.end method

.method public getTue_open()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->tue_open:Ljava/lang/String;

    return-object v0
.end method

.method public getWed_close()Ljava/lang/String;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->wed_close:Ljava/lang/String;

    return-object v0
.end method

.method public getWed_open()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->wed_open:Ljava/lang/String;

    return-object v0
.end method

.method public getZipCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->zipCode:Ljava/lang/String;

    return-object v0
.end method

.method public getZipPlusFour()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->zipPlusFour:Ljava/lang/String;

    return-object v0
.end method

.method public isHasLimitedShipToStore()Z
    .locals 1

    .prologue
    .line 135
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->hasLimitedShipToStore:Z

    return v0
.end method

.method public isHasPickupAndShipToStore()Z
    .locals 1

    .prologue
    .line 143
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->hasPickupAndShipToStore:Z

    return v0
.end method

.method public setAddress(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->address:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setCity(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->city:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setCountry(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->country:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setDetailedHours([Lcom/bestbuy/android/api/lib/models/store/DetailedHours;)V
    .locals 0

    .prologue
    .line 283
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->detailedHours:[Lcom/bestbuy/android/api/lib/models/store/DetailedHours;

    .line 284
    return-void
.end method

.method public setFri_close(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 243
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->fri_close:Ljava/lang/String;

    .line 244
    return-void
.end method

.method public setFri_open(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 235
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->fri_open:Ljava/lang/String;

    .line 236
    return-void
.end method

.method public setHasLimitedShipToStore(Z)V
    .locals 0

    .prologue
    .line 139
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->hasLimitedShipToStore:Z

    .line 140
    return-void
.end method

.method public setHasPickupAndShipToStore(Z)V
    .locals 0

    .prologue
    .line 147
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->hasPickupAndShipToStore:Z

    .line 148
    return-void
.end method

.method public setLatitude(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 155
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->latitude:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setLocationSubType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->locationSubType:Ljava/lang/String;

    .line 124
    return-void
.end method

.method public setLocationType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->locationType:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setLongitude(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->longitude:Ljava/lang/String;

    .line 164
    return-void
.end method

.method public setMon_close(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->mon_close:Ljava/lang/String;

    .line 180
    return-void
.end method

.method public setMon_open(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->mon_open:Ljava/lang/String;

    .line 172
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->name:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setPhone(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->phone:Ljava/lang/String;

    .line 108
    return-void
.end method

.method public setSat_close(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 259
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->sat_close:Ljava/lang/String;

    .line 260
    return-void
.end method

.method public setSat_open(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 251
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->sat_open:Ljava/lang/String;

    .line 252
    return-void
.end method

.method public setState(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->state:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setStatus(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->status:Ljava/lang/String;

    .line 132
    return-void
.end method

.method public setSun_close(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 275
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->sun_close:Ljava/lang/String;

    .line 276
    return-void
.end method

.method public setSun_open(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 267
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->sun_open:Ljava/lang/String;

    .line 268
    return-void
.end method

.method public setThu_close(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 227
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->thu_close:Ljava/lang/String;

    .line 228
    return-void
.end method

.method public setThu_open(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->thu_open:Ljava/lang/String;

    .line 220
    return-void
.end method

.method public setTue_close(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->tue_close:Ljava/lang/String;

    .line 196
    return-void
.end method

.method public setTue_open(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 187
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->tue_open:Ljava/lang/String;

    .line 188
    return-void
.end method

.method public setWed_close(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 211
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->wed_close:Ljava/lang/String;

    .line 212
    return-void
.end method

.method public setWed_open(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 203
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->wed_open:Ljava/lang/String;

    .line 204
    return-void
.end method

.method public setZipCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->zipCode:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setZipPlusFour(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->zipPlusFour:Ljava/lang/String;

    .line 100
    return-void
.end method
