.class public Lamazon/communication/identity/ServiceIdentity;
.super Lamazon/communication/identity/EndpointIdentity;
.source "ServiceIdentity.java"


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private mDomain:Ljava/lang/String;

.field private mHostname:Ljava/lang/String;

.field private mPort:Ljava/lang/Integer;

.field private mRealm:Ljava/lang/String;

.field private final mServiceName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 36
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.ServiceIdentity"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lamazon/communication/identity/ServiceIdentity;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .locals 9
    .param p1, "urn"    # Ljava/lang/String;

    .prologue
    .line 80
    invoke-direct {p0}, Lamazon/communication/identity/EndpointIdentity;-><init>()V

    .line 82
    invoke-static {p1}, Lamazon/communication/identity/ServiceIdentity;->matchesUrn(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 83
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "ServiceIdentity urn is invalid: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 86
    :cond_0
    const-string/jumbo v3, ":"

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 89
    .local v1, "fields":[Ljava/lang/String;
    array-length v3, v1

    const/4 v4, 0x5

    if-ge v3, v4, :cond_1

    .line 90
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Too few fields in service urn "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 93
    :cond_1
    array-length v3, v1

    rem-int/lit8 v3, v3, 0x2

    if-nez v3, :cond_2

    .line 94
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Expecting odd number of fields in service urn: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 97
    :cond_2
    const-string/jumbo v3, "serviceName"

    const/4 v4, 0x3

    aget-object v4, v1, v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 98
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Expecting first field in urn to be serviceName, urn: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 102
    :cond_3
    const/4 v3, 0x4

    aget-object v3, v1, v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lamazon/communication/identity/ServiceIdentity;->mServiceName:Ljava/lang/String;

    .line 103
    const-string/jumbo v3, ""

    iget-object v4, p0, Lamazon/communication/identity/ServiceIdentity;->mServiceName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 104
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "serviceName field is empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 107
    :cond_4
    const/4 v2, 0x5

    .local v2, "i":I
    :goto_0
    array-length v3, v1

    if-ge v2, v3, :cond_a

    .line 108
    const-string/jumbo v3, "domain"

    aget-object v4, v1, v2

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 110
    add-int/lit8 v3, v2, 0x1

    aget-object v3, v1, v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lamazon/communication/identity/ServiceIdentity;->mDomain:Ljava/lang/String;

    .line 111
    const-string/jumbo v3, ""

    iget-object v4, p0, Lamazon/communication/identity/ServiceIdentity;->mDomain:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 112
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "domain field is empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 114
    :cond_5
    const-string/jumbo v3, "realm"

    aget-object v4, v1, v2

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 115
    add-int/lit8 v3, v2, 0x1

    aget-object v3, v1, v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lamazon/communication/identity/ServiceIdentity;->mRealm:Ljava/lang/String;

    .line 116
    const-string/jumbo v3, ""

    iget-object v4, p0, Lamazon/communication/identity/ServiceIdentity;->mRealm:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 117
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "realm field is empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 119
    :cond_6
    const-string/jumbo v3, "hostname"

    aget-object v4, v1, v2

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 120
    add-int/lit8 v3, v2, 0x1

    aget-object v3, v1, v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lamazon/communication/identity/ServiceIdentity;->mHostname:Ljava/lang/String;

    .line 121
    const-string/jumbo v3, ""

    iget-object v4, p0, Lamazon/communication/identity/ServiceIdentity;->mHostname:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 122
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "hostname field is empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 124
    :cond_7
    const-string/jumbo v3, "port"

    aget-object v4, v1, v2

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 126
    add-int/lit8 v3, v2, 0x1

    :try_start_0
    aget-object v3, v1, v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, p0, Lamazon/communication/identity/ServiceIdentity;->mPort:Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 107
    :cond_8
    :goto_1
    add-int/lit8 v2, v2, 0x2

    goto/16 :goto_0

    .line 127
    :catch_0
    move-exception v0

    .line 128
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Invalid port field, expecting integer. urn: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 132
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_9
    sget-object v3, Lamazon/communication/identity/ServiceIdentity;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "ServiceIdentity(urn)"

    const-string/jumbo v5, "unexpected field"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "field"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    aget-object v8, v1, v2

    aput-object v8, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 135
    :cond_a
    return-void
.end method

.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 2
    .param p1, "serviceName"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "realm"    # Ljava/lang/String;
    .param p4, "hostname"    # Ljava/lang/String;
    .param p5, "port"    # Ljava/lang/Integer;

    .prologue
    const/4 v0, 0x0

    .line 62
    invoke-direct {p0}, Lamazon/communication/identity/EndpointIdentity;-><init>()V

    .line 64
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 65
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "ServiceName cannot be null when constructing ServiceIdentity"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 67
    :cond_1
    iput-object p1, p0, Lamazon/communication/identity/ServiceIdentity;->mServiceName:Ljava/lang/String;

    .line 68
    if-eqz p2, :cond_2

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_2

    move-object p2, v0

    .end local p2    # "domain":Ljava/lang/String;
    :cond_2
    iput-object p2, p0, Lamazon/communication/identity/ServiceIdentity;->mDomain:Ljava/lang/String;

    .line 69
    if-eqz p3, :cond_3

    invoke-virtual {p3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_3

    move-object p3, v0

    .end local p3    # "realm":Ljava/lang/String;
    :cond_3
    iput-object p3, p0, Lamazon/communication/identity/ServiceIdentity;->mRealm:Ljava/lang/String;

    .line 70
    if-eqz p4, :cond_6

    invoke-virtual {p4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_6

    :goto_0
    iput-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mHostname:Ljava/lang/String;

    .line 71
    iput-object p5, p0, Lamazon/communication/identity/ServiceIdentity;->mPort:Ljava/lang/Integer;

    .line 73
    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mHostname:Ljava/lang/String;

    if-nez v0, :cond_4

    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mPort:Ljava/lang/Integer;

    if-eqz v0, :cond_7

    .line 74
    :cond_4
    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mHostname:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mPort:Ljava/lang/Integer;

    if-nez v0, :cond_7

    .line 75
    :cond_5
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Both hostname and port must be specified together"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_6
    move-object v0, p4

    .line 70
    goto :goto_0

    .line 78
    :cond_7
    return-void
.end method

.method public static matchesUrn(Ljava/lang/String;)Z
    .locals 1
    .param p0, "urn"    # Ljava/lang/String;

    .prologue
    .line 183
    if-eqz p0, :cond_0

    const-string/jumbo v0, "urn:tcomm-endpoint:service"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mDomain:Ljava/lang/String;

    return-object v0
.end method

.method public getHostname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mHostname:Ljava/lang/String;

    return-object v0
.end method

.method public getPort()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mPort:Ljava/lang/Integer;

    return-object v0
.end method

.method public getRealm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mRealm:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lamazon/communication/identity/ServiceIdentity;->mServiceName:Ljava/lang/String;

    return-object v0
.end method

.method public toLogSafeString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 191
    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 200
    const-string/jumbo v2, "urn:tcomm-endpoint:service"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, "serviceName"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getServiceName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int v0, v2, v3

    .line 202
    .local v0, "length":I
    iget-object v2, p0, Lamazon/communication/identity/ServiceIdentity;->mDomain:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 203
    const-string/jumbo v2, ":"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, "domain"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getDomain()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 205
    :cond_0
    iget-object v2, p0, Lamazon/communication/identity/ServiceIdentity;->mRealm:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 206
    const-string/jumbo v2, ":"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, "realm"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getRealm()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 208
    :cond_1
    iget-object v2, p0, Lamazon/communication/identity/ServiceIdentity;->mHostname:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lamazon/communication/identity/ServiceIdentity;->mPort:Ljava/lang/Integer;

    if-eqz v2, :cond_2

    .line 209
    const-string/jumbo v2, ":"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, "hostname"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getHostname()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, "port"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    const-string/jumbo v3, ":"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getPort()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 213
    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 216
    .local v1, "urn":Ljava/lang/StringBuilder;
    const-string/jumbo v2, "urn:tcomm-endpoint:service"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 219
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "serviceName"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getServiceName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 220
    iget-object v2, p0, Lamazon/communication/identity/ServiceIdentity;->mDomain:Ljava/lang/String;

    if-eqz v2, :cond_3

    .line 221
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "domain"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getDomain()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 223
    :cond_3
    iget-object v2, p0, Lamazon/communication/identity/ServiceIdentity;->mRealm:Ljava/lang/String;

    if-eqz v2, :cond_4

    .line 224
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "realm"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getRealm()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 226
    :cond_4
    iget-object v2, p0, Lamazon/communication/identity/ServiceIdentity;->mHostname:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lamazon/communication/identity/ServiceIdentity;->mPort:Ljava/lang/Integer;

    if-eqz v2, :cond_5

    .line 227
    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "hostname"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getHostname()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "port"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lamazon/communication/identity/ServiceIdentity;->getPort()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 231
    :cond_5
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
