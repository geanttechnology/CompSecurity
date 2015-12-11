.class public Lamazon/communication/identity/DeviceIdentity;
.super Lamazon/communication/identity/EndpointIdentity;
.source "DeviceIdentity.java"


# static fields
.field private static final SEED:I


# instance fields
.field private final mCustomerId:Ljava/lang/String;

.field private final mDeviceAccountId:Ljava/lang/String;

.field private final mDeviceSerialNumber:Ljava/lang/String;

.field private final mDeviceType:Ljava/lang/String;

.field private final mDirectedId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    invoke-virtual {v0}, Ljava/security/SecureRandom;->nextInt()I

    move-result v0

    sput v0, Lamazon/communication/identity/DeviceIdentity;->SEED:I

    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .locals 6
    .param p1, "deviceEndpointUrn"    # Ljava/lang/String;

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x6

    const/4 v3, 0x4

    const/4 v2, 0x0

    .line 110
    invoke-direct {p0}, Lamazon/communication/identity/EndpointIdentity;-><init>()V

    .line 112
    if-nez p1, :cond_0

    .line 113
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Device endpoint must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 116
    :cond_0
    const-string/jumbo v1, ":"

    invoke-virtual {p1, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 120
    .local v0, "fields":[Ljava/lang/String;
    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->hasValidHeader([Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 121
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Device endpoint URN is not valid: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 124
    :cond_1
    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->isDeviceOnlyEndpoint([Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 125
    iput-object v2, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceAccountId:Ljava/lang/String;

    .line 126
    iput-object v2, p0, Lamazon/communication/identity/DeviceIdentity;->mCustomerId:Ljava/lang/String;

    .line 127
    iput-object v2, p0, Lamazon/communication/identity/DeviceIdentity;->mDirectedId:Ljava/lang/String;

    .line 128
    aget-object v1, v0, v3

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceType:Ljava/lang/String;

    .line 129
    aget-object v1, v0, v4

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceSerialNumber:Ljava/lang/String;

    .line 151
    :goto_0
    return-void

    .line 130
    :cond_2
    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->isLegacyCustomerDeviceEndpoint([Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 131
    aget-object v1, v0, v3

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceAccountId:Ljava/lang/String;

    .line 132
    aget-object v1, v0, v4

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mCustomerId:Ljava/lang/String;

    .line 133
    iput-object v2, p0, Lamazon/communication/identity/DeviceIdentity;->mDirectedId:Ljava/lang/String;

    .line 134
    aget-object v1, v0, v5

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceType:Ljava/lang/String;

    .line 135
    const/16 v1, 0xa

    aget-object v1, v0, v1

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceSerialNumber:Ljava/lang/String;

    goto :goto_0

    .line 136
    :cond_3
    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->isNewCustomerDeviceEndpoint([Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 137
    iput-object v2, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceAccountId:Ljava/lang/String;

    .line 138
    aget-object v1, v0, v3

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mCustomerId:Ljava/lang/String;

    .line 139
    iput-object v2, p0, Lamazon/communication/identity/DeviceIdentity;->mDirectedId:Ljava/lang/String;

    .line 140
    aget-object v1, v0, v4

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceType:Ljava/lang/String;

    .line 141
    aget-object v1, v0, v5

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceSerialNumber:Ljava/lang/String;

    goto :goto_0

    .line 142
    :cond_4
    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->isDirectedIdDeviceEndpoint([Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 143
    iput-object v2, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceAccountId:Ljava/lang/String;

    .line 144
    iput-object v2, p0, Lamazon/communication/identity/DeviceIdentity;->mCustomerId:Ljava/lang/String;

    .line 145
    aget-object v1, v0, v3

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDirectedId:Ljava/lang/String;

    .line 146
    aget-object v1, v0, v4

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceType:Ljava/lang/String;

    .line 147
    aget-object v1, v0, v5

    iput-object v1, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceSerialNumber:Ljava/lang/String;

    goto :goto_0

    .line 149
    :cond_5
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Device endpoint URN is not valid: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static hasValidHeader([Ljava/lang/String;)Z
    .locals 4
    .param p0, "fields"    # [Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 317
    array-length v2, p0

    const/4 v3, 0x3

    if-lt v2, v3, :cond_0

    const/4 v2, 0x2

    aget-object v2, p0, v2

    const-string/jumbo v3, "device"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    aget-object v2, p0, v0

    const-string/jumbo v3, "tcomm-endpoint"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    aget-object v2, p0, v1

    const-string/jumbo v3, "urn"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method private static isDeviceOnlyEndpoint([Ljava/lang/String;)Z
    .locals 2
    .param p0, "fields"    # [Ljava/lang/String;

    .prologue
    .line 348
    array-length v0, p0

    const/4 v1, 0x7

    if-ne v0, v1, :cond_0

    const/4 v0, 0x3

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceType"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x4

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x5

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceSerialNumber"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x6

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isDirectedIdDeviceEndpoint([Ljava/lang/String;)Z
    .locals 2
    .param p0, "fields"    # [Ljava/lang/String;

    .prologue
    .line 400
    array-length v0, p0

    const/16 v1, 0x9

    if-ne v0, v1, :cond_0

    const/4 v0, 0x3

    aget-object v0, p0, v0

    const-string/jumbo v1, "directedId"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x4

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x5

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceType"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x6

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x7

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceSerialNumber"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/16 v0, 0x8

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isLegacyCustomerDeviceEndpoint([Ljava/lang/String;)Z
    .locals 2
    .param p0, "fields"    # [Ljava/lang/String;

    .prologue
    .line 364
    array-length v0, p0

    const/16 v1, 0xb

    if-ne v0, v1, :cond_0

    const/4 v0, 0x3

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceAccountId"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x4

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x5

    aget-object v0, p0, v0

    const-string/jumbo v1, "customerId"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x6

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x7

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceType"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/16 v0, 0x8

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/16 v0, 0x9

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceSerialNumber"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/16 v0, 0xa

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isNewCustomerDeviceEndpoint([Ljava/lang/String;)Z
    .locals 2
    .param p0, "fields"    # [Ljava/lang/String;

    .prologue
    .line 383
    array-length v0, p0

    const/16 v1, 0x9

    if-ne v0, v1, :cond_0

    const/4 v0, 0x3

    aget-object v0, p0, v0

    const-string/jumbo v1, "customerId"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x4

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x5

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceType"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x6

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x7

    aget-object v0, p0, v0

    const-string/jumbo v1, "deviceSerialNumber"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/16 v0, 0x8

    aget-object v0, p0, v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static matchesUrn(Ljava/lang/String;)Z
    .locals 2
    .param p0, "urn"    # Ljava/lang/String;

    .prologue
    .line 307
    const-string/jumbo v1, ":"

    invoke-virtual {p0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 309
    .local v0, "fields":[Ljava/lang/String;
    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->hasValidHeader([Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->isDeviceOnlyEndpoint([Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->isLegacyCustomerDeviceEndpoint([Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->isNewCustomerDeviceEndpoint([Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lamazon/communication/identity/DeviceIdentity;->isDirectedIdDeviceEndpoint([Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getCustomerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lamazon/communication/identity/DeviceIdentity;->mCustomerId:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceSerialNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceSerialNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lamazon/communication/identity/DeviceIdentity;->mDeviceType:Ljava/lang/String;

    return-object v0
.end method

.method public getDirectedId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lamazon/communication/identity/DeviceIdentity;->mDirectedId:Ljava/lang/String;

    return-object v0
.end method

.method public toLogSafeString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 225
    const-string/jumbo v2, "urn:tcomm-endpoint:device"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, "deviceType"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, "deviceSerialNumber"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    sget v3, Lamazon/communication/identity/DeviceIdentity;->SEED:I

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    add-int/2addr v3, v4

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int v0, v2, v3

    .line 229
    .local v0, "length":I
    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getCustomerId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 230
    const-string/jumbo v2, ":"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, "customerId"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    sget v3, Lamazon/communication/identity/DeviceIdentity;->SEED:I

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getCustomerId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    add-int/2addr v3, v4

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 232
    :cond_0
    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 233
    const-string/jumbo v2, ":"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, "directedId"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    sget v3, Lamazon/communication/identity/DeviceIdentity;->SEED:I

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDirectedId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    add-int/2addr v3, v4

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 236
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 238
    .local v1, "safe":Ljava/lang/StringBuilder;
    const-string/jumbo v2, "urn:tcomm-endpoint:device"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 240
    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getCustomerId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 241
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "customerId"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget v3, Lamazon/communication/identity/DeviceIdentity;->SEED:I

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getCustomerId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    add-int/2addr v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 243
    :cond_2
    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 244
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "directedId"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget v3, Lamazon/communication/identity/DeviceIdentity;->SEED:I

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDirectedId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    add-int/2addr v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 247
    :cond_3
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "deviceType"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 248
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "deviceSerialNumber"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget v3, Lamazon/communication/identity/DeviceIdentity;->SEED:I

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    add-int/2addr v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 250
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 271
    const-string/jumbo v2, "urn:tcomm-endpoint:device"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, "deviceType"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, "deviceSerialNumber"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int v0, v2, v3

    .line 275
    .local v0, "length":I
    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getCustomerId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 276
    const-string/jumbo v2, ":"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, "customerId"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getCustomerId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 278
    :cond_0
    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 279
    const-string/jumbo v2, ":"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, "directedId"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 282
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 285
    .local v1, "urn":Ljava/lang/StringBuilder;
    const-string/jumbo v2, "urn:tcomm-endpoint:device"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 287
    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getCustomerId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 288
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "customerId"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getCustomerId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 290
    :cond_2
    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 291
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "directedId"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 295
    :cond_3
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "deviceType"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 296
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "deviceSerialNumber"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/DeviceIdentity;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 298
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
