.class public Lcom/bestbuy/android/api/lib/models/remix/Store;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static ADDRESS:Ljava/lang/String;

.field public static CITY:Ljava/lang/String;

.field public static COUNTRY:Ljava/lang/String;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/bestbuy/android/api/lib/models/remix/Store;",
            ">;"
        }
    .end annotation
.end field

.field public static DETAILED_HOURS:Ljava/lang/String;

.field public static DISTANCE:Ljava/lang/String;

.field public static HOURS:Ljava/lang/String;

.field public static LAT:Ljava/lang/String;

.field public static LNG:Ljava/lang/String;

.field public static LONG_NAME:Ljava/lang/String;

.field public static NAME:Ljava/lang/String;

.field public static PHONE:Ljava/lang/String;

.field public static POSTAL_CODE:Ljava/lang/String;

.field public static REGION:Ljava/lang/String;

.field public static SERVICES:Ljava/lang/String;

.field public static STORE_ID:Ljava/lang/String;

.field public static STORE_IMAGE:Ljava/lang/String;

.field public static STORE_TYPE:Ljava/lang/String;


# instance fields
.field private address:Ljava/lang/String;

.field private availabilityMessage:Ljava/lang/String;

.field private city:Ljava/lang/String;

.field private distance:Ljava/lang/String;

.field private hours:Ljava/lang/String;

.field private lat:D

.field private lng:D

.field private longName:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private phone:Ljava/lang/String;

.field private postalCode:Ljava/lang/String;

.field private region:Ljava/lang/String;

.field private services:Ljava/lang/String;

.field private shipToStore:Z

.field private storeHours:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/remix/StoreHours;",
            ">;"
        }
    .end annotation
.end field

.field private storeId:Ljava/lang/String;

.field private storeImage:Ljava/lang/String;

.field private storeLink:Ljava/lang/String;

.field private storeType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-string v0, "storeId"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->STORE_ID:Ljava/lang/String;

    .line 15
    const-string v0, "storeType"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->STORE_TYPE:Ljava/lang/String;

    .line 16
    const-string v0, "name"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->NAME:Ljava/lang/String;

    .line 17
    const-string v0, "longName"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->LONG_NAME:Ljava/lang/String;

    .line 18
    const-string v0, "address"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->ADDRESS:Ljava/lang/String;

    .line 19
    const-string v0, "city"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->CITY:Ljava/lang/String;

    .line 20
    const-string v0, "region"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->REGION:Ljava/lang/String;

    .line 21
    const-string v0, "postalCode"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->POSTAL_CODE:Ljava/lang/String;

    .line 22
    const-string v0, "country "

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->COUNTRY:Ljava/lang/String;

    .line 23
    const-string v0, "lat"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->LAT:Ljava/lang/String;

    .line 24
    const-string v0, "lng"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->LNG:Ljava/lang/String;

    .line 25
    const-string v0, "phone"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->PHONE:Ljava/lang/String;

    .line 26
    const-string v0, "hoursAmPm"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->HOURS:Ljava/lang/String;

    .line 27
    const-string v0, "distance"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->DISTANCE:Ljava/lang/String;

    .line 28
    const-string v0, "storeimage"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->STORE_IMAGE:Ljava/lang/String;

    .line 29
    const-string v0, "services"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->SERVICES:Ljava/lang/String;

    .line 30
    const-string v0, "detailedHours"

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->DETAILED_HOURS:Ljava/lang/String;

    .line 218
    new-instance v0, Lcom/bestbuy/android/api/lib/models/remix/Store$1;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/remix/Store$1;-><init>()V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeHours:Ljava/util/ArrayList;

    .line 72
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeId:Ljava/lang/String;

    .line 73
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeType:Ljava/lang/String;

    .line 74
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->name:Ljava/lang/String;

    .line 75
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->address:Ljava/lang/String;

    .line 76
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->longName:Ljava/lang/String;

    .line 77
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->city:Ljava/lang/String;

    .line 78
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->region:Ljava/lang/String;

    .line 79
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->postalCode:Ljava/lang/String;

    .line 80
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->lat:D

    .line 81
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->lng:D

    .line 82
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->phone:Ljava/lang/String;

    .line 83
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->hours:Ljava/lang/String;

    .line 84
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->distance:Ljava/lang/String;

    .line 85
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->availabilityMessage:Ljava/lang/String;

    .line 86
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeLink:Ljava/lang/String;

    .line 87
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeImage:Ljava/lang/String;

    .line 88
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->services:Ljava/lang/String;

    .line 89
    return-void
.end method

.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeHours:Ljava/util/ArrayList;

    .line 53
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->STORE_ID:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeId:Ljava/lang/String;

    .line 54
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->STORE_TYPE:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeType:Ljava/lang/String;

    .line 55
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->NAME:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->name:Ljava/lang/String;

    .line 56
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->LONG_NAME:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->longName:Ljava/lang/String;

    .line 57
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->ADDRESS:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->address:Ljava/lang/String;

    .line 58
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->CITY:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->city:Ljava/lang/String;

    .line 59
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->REGION:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->region:Ljava/lang/String;

    .line 60
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->POSTAL_CODE:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->postalCode:Ljava/lang/String;

    .line 61
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->PHONE:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->phone:Ljava/lang/String;

    .line 62
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->LAT:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->lat:D

    .line 63
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->LNG:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->lng:D

    .line 64
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->HOURS:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->hours:Ljava/lang/String;

    .line 65
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->DISTANCE:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->distance:Ljava/lang/String;

    .line 66
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->STORE_IMAGE:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeImage:Ljava/lang/String;

    .line 67
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->SERVICES:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->loadServices(Lorg/json/JSONArray;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->services:Ljava/lang/String;

    .line 68
    sget-object v0, Lcom/bestbuy/android/api/lib/models/remix/Store;->DETAILED_HOURS:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->loadStoreTiming(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeHours:Ljava/util/ArrayList;

    .line 69
    return-void
.end method

.method private loadServices(Lorg/json/JSONArray;)Ljava/lang/String;
    .locals 5

    .prologue
    .line 92
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 93
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 94
    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 95
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "service"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 93
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 97
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private loadStoreTiming(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/remix/StoreHours;",
            ">;"
        }
    .end annotation

    .prologue
    .line 101
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 102
    if-eqz p1, :cond_0

    .line 103
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 104
    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 105
    new-instance v3, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;-><init>()V

    .line 106
    const-string v4, "close"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->setClose(Ljava/lang/String;)V

    .line 107
    const-string v4, "open"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->setOpen(Ljava/lang/String;)V

    .line 108
    const-string v4, "date"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->setDate(Ljava/lang/String;)V

    .line 109
    const-string v4, "day"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->setDay(Ljava/lang/String;)V

    .line 110
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 103
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 113
    :cond_0
    return-object v1
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 182
    const/4 v0, 0x0

    return v0
.end method

.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getAvailabilityMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->availabilityMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getDistance()Ljava/lang/String;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->distance:Ljava/lang/String;

    return-object v0
.end method

.method public getHours()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->hours:Ljava/lang/String;

    return-object v0
.end method

.method public getLat()D
    .locals 2

    .prologue
    .line 145
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->lat:D

    return-wide v0
.end method

.method public getLng()D
    .locals 2

    .prologue
    .line 149
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->lng:D

    return-wide v0
.end method

.method public getLongName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->longName:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPhone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->phone:Ljava/lang/String;

    return-object v0
.end method

.method public getPostalCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->postalCode:Ljava/lang/String;

    return-object v0
.end method

.method public getRegion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->region:Ljava/lang/String;

    return-object v0
.end method

.method public getServices()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->services:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreHours()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/remix/StoreHours;",
            ">;"
        }
    .end annotation

    .prologue
    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeHours:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getStoreId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeId:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeImage:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeLink:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeType:Ljava/lang/String;

    return-object v0
.end method

.method public isShipToStore()Z
    .locals 1

    .prologue
    .line 173
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->shipToStore:Z

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2

    .prologue
    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 200
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeType:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 201
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->name:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 202
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->address:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->longName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->longName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->region:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->postalCode:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 207
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->lat:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 208
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->lng:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 209
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->phone:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->hours:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->distance:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->availabilityMessage:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeLink:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->storeImage:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/Store;->services:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 216
    return-void
.end method
