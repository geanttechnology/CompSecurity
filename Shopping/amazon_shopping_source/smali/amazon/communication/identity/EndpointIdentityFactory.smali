.class public Lamazon/communication/identity/EndpointIdentityFactory;
.super Ljava/lang/Object;
.source "EndpointIdentityFactory.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 326
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createFromUrn(Ljava/lang/String;)Lamazon/communication/identity/EndpointIdentity;
    .locals 4
    .param p0, "urn"    # Ljava/lang/String;

    .prologue
    .line 57
    if-eqz p0, :cond_0

    const-string/jumbo v1, ""

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 58
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "URN must be non-empty"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 61
    :cond_1
    invoke-static {p0}, Lamazon/communication/identity/DeviceIdentity;->matchesUrn(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 62
    new-instance v1, Lamazon/communication/identity/DeviceIdentity;

    invoke-direct {v1, p0}, Lamazon/communication/identity/DeviceIdentity;-><init>(Ljava/lang/String;)V

    .line 70
    :goto_0
    return-object v1

    .line 63
    :cond_2
    invoke-static {p0}, Lamazon/communication/identity/ServiceIdentity;->matchesUrn(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 64
    new-instance v1, Lamazon/communication/identity/ServiceIdentity;

    invoke-direct {v1, p0}, Lamazon/communication/identity/ServiceIdentity;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 69
    :cond_3
    :try_start_0
    invoke-static {p0}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    .line 70
    new-instance v1, Lamazon/communication/identity/UrlEndpointIdentity;

    invoke-direct {v1, p0}, Lamazon/communication/identity/UrlEndpointIdentity;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 71
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Invalid URN: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " Urn should map to one of the sub-classes of EndpointIdentity."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static createServiceIdentity(Ljava/lang/String;)Lamazon/communication/identity/ServiceIdentity;
    .locals 1
    .param p0, "serviceName"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 176
    invoke-static {p0, v0, v0, v0, v0}, Lamazon/communication/identity/EndpointIdentityFactory;->createServiceIdentity(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lamazon/communication/identity/ServiceIdentity;

    move-result-object v0

    return-object v0
.end method

.method public static createServiceIdentity(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lamazon/communication/identity/ServiceIdentity;
    .locals 6
    .param p0, "serviceName"    # Ljava/lang/String;
    .param p1, "domain"    # Ljava/lang/String;
    .param p2, "realm"    # Ljava/lang/String;
    .param p3, "hostname"    # Ljava/lang/String;
    .param p4, "port"    # Ljava/lang/Integer;

    .prologue
    .line 229
    new-instance v0, Lamazon/communication/identity/ServiceIdentity;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lamazon/communication/identity/ServiceIdentity;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    return-object v0
.end method

.method public static createUrlEndpointIdentity(Ljava/lang/String;)Lamazon/communication/identity/UrlEndpointIdentity;
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 258
    new-instance v0, Lamazon/communication/identity/UrlEndpointIdentity;

    invoke-direct {v0, p0}, Lamazon/communication/identity/UrlEndpointIdentity;-><init>(Ljava/lang/String;)V

    return-object v0
.end method
