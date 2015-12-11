.class public abstract Lamazon/communication/identity/EndpointIdentity;
.super Ljava/lang/Object;
.source "EndpointIdentity.java"


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static logSafe(Lamazon/communication/identity/EndpointIdentity;)Ljava/lang/String;
    .locals 1
    .param p0, "endpoint"    # Lamazon/communication/identity/EndpointIdentity;

    .prologue
    .line 90
    const/4 v0, 0x0

    .line 92
    .local v0, "result":Ljava/lang/String;
    if-eqz p0, :cond_0

    .line 93
    invoke-virtual {p0}, Lamazon/communication/identity/EndpointIdentity;->toLogSafeString()Ljava/lang/String;

    move-result-object v0

    .line 96
    :cond_0
    return-object v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "other"    # Ljava/lang/Object;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 64
    if-nez p1, :cond_1

    .line 81
    :cond_0
    :goto_0
    return v2

    .line 69
    :cond_1
    invoke-virtual {p0}, Lamazon/communication/identity/EndpointIdentity;->toString()Ljava/lang/String;

    move-result-object v1

    .line 70
    .local v1, "thisString":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 73
    .local v0, "otherString":Ljava/lang/String;
    if-nez v1, :cond_3

    move v5, v3

    :goto_1
    if-nez v0, :cond_4

    move v4, v3

    :goto_2
    xor-int/2addr v4, v5

    if-nez v4, :cond_0

    .line 77
    if-eqz v1, :cond_2

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    :cond_2
    move v2, v3

    .line 81
    goto :goto_0

    :cond_3
    move v5, v2

    .line 73
    goto :goto_1

    :cond_4
    move v4, v2

    goto :goto_2
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 51
    invoke-virtual {p0}, Lamazon/communication/identity/EndpointIdentity;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public abstract toLogSafeString()Ljava/lang/String;
.end method

.method public abstract toString()Ljava/lang/String;
.end method
