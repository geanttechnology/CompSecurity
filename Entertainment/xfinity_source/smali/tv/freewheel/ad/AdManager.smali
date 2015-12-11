.class public Ltv/freewheel/ad/AdManager;
.super Ljava/lang/Object;
.source "AdManager.java"

# interfaces
.implements Ltv/freewheel/ad/interfaces/IAdManager;


# static fields
.field private static instance:Ltv/freewheel/ad/interfaces/IAdManager;


# instance fields
.field public adManagerVersion:Ljava/lang/String;

.field protected geoLocation:Landroid/location/Location;

.field protected networkId:I

.field protected serverUrl:Ljava/lang/String;

.field private version:I


# direct methods
.method private constructor <init>(Landroid/content/Context;I)V
    .locals 3
    .param p1, "appContext"    # Landroid/content/Context;
    .param p2, "logLevel"    # I

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, -0x1

    iput v0, p0, Ltv/freewheel/ad/AdManager;->version:I

    .line 16
    const-string v0, "5.19.0-r10748-1501191104"

    iput-object v0, p0, Ltv/freewheel/ad/AdManager;->adManagerVersion:Ljava/lang/String;

    .line 20
    const-string v0, "http://g1.v.fwmrm.net"

    iput-object v0, p0, Ltv/freewheel/ad/AdManager;->serverUrl:Ljava/lang/String;

    .line 21
    const/4 v0, 0x0

    iput v0, p0, Ltv/freewheel/ad/AdManager;->networkId:I

    .line 33
    invoke-static {p2}, Ltv/freewheel/utils/Logger;->setLogLevel(I)V

    .line 34
    invoke-static {p1}, Ltv/freewheel/utils/cookie/AndroidCookieStore;->initialize(Landroid/content/Context;)V

    .line 36
    const-string v0, "AdManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Version:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/ad/AdManager;->adManagerVersion:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 37
    return-void
.end method

.method public static getInstance(Landroid/content/Context;)Ltv/freewheel/ad/interfaces/IAdManager;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 134
    sget-object v0, Ltv/freewheel/ad/AdManager;->instance:Ltv/freewheel/ad/interfaces/IAdManager;

    if-nez v0, :cond_0

    .line 135
    new-instance v0, Ltv/freewheel/ad/AdManager;

    invoke-static {}, Ltv/freewheel/utils/Logger;->getLogLevel()I

    move-result v1

    invoke-direct {v0, p0, v1}, Ltv/freewheel/ad/AdManager;-><init>(Landroid/content/Context;I)V

    sput-object v0, Ltv/freewheel/ad/AdManager;->instance:Ltv/freewheel/ad/interfaces/IAdManager;

    .line 137
    :cond_0
    sget-object v0, Ltv/freewheel/ad/AdManager;->instance:Ltv/freewheel/ad/interfaces/IAdManager;

    return-object v0
.end method


# virtual methods
.method public getStringVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Ltv/freewheel/ad/AdManager;->adManagerVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()I
    .locals 12

    .prologue
    const/4 v11, 0x0

    .line 48
    iget v9, p0, Ltv/freewheel/ad/AdManager;->version:I

    if-gez v9, :cond_2

    .line 49
    const v9, 0x7fffffff

    iput v9, p0, Ltv/freewheel/ad/AdManager;->version:I

    .line 50
    iget-object v9, p0, Ltv/freewheel/ad/AdManager;->adManagerVersion:Ljava/lang/String;

    const-string v10, "-"

    invoke-virtual {v9, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 51
    .local v0, "component":[Ljava/lang/String;
    array-length v9, v0

    if-lez v9, :cond_2

    .line 52
    aget-object v7, v0, v11

    .line 53
    .local v7, "mainPart":Ljava/lang/String;
    const-string v9, "trunk"

    invoke-virtual {v7, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 54
    iput v11, p0, Ltv/freewheel/ad/AdManager;->version:I

    .line 55
    const-string v9, "\\."

    invoke-virtual {v7, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 56
    .local v8, "n":[Ljava/lang/String;
    array-length v5, v8

    .line 57
    .local v5, "length":I
    const/4 v9, 0x4

    if-le v5, v9, :cond_0

    .line 58
    const/4 v5, 0x4

    .line 60
    :cond_0
    const/4 v6, 0x3

    .line 61
    .local v6, "level":S
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v5, :cond_2

    .line 62
    const/4 v2, 0x1

    .line 63
    .local v2, "factor":I
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_1
    if-ge v4, v6, :cond_1

    .line 64
    mul-int/lit16 v2, v2, 0x100

    .line 63
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 67
    :cond_1
    :try_start_0
    iget v9, p0, Ltv/freewheel/ad/AdManager;->version:I

    aget-object v10, v8, v3

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    mul-int/2addr v10, v2

    add-int/2addr v9, v10

    iput v9, p0, Ltv/freewheel/ad/AdManager;->version:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 61
    :goto_2
    add-int/lit8 v3, v3, 0x1

    add-int/lit8 v9, v6, -0x1

    int-to-short v6, v9

    goto :goto_0

    .line 68
    :catch_0
    move-exception v1

    .line 69
    .local v1, "e":Ljava/lang/NumberFormatException;
    iget v9, p0, Ltv/freewheel/ad/AdManager;->version:I

    mul-int/lit8 v10, v2, 0x9

    add-int/2addr v9, v10

    iput v9, p0, Ltv/freewheel/ad/AdManager;->version:I

    goto :goto_2

    .line 75
    .end local v0    # "component":[Ljava/lang/String;
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .end local v2    # "factor":I
    .end local v3    # "i":I
    .end local v4    # "j":I
    .end local v5    # "length":I
    .end local v6    # "level":S
    .end local v7    # "mainPart":Ljava/lang/String;
    .end local v8    # "n":[Ljava/lang/String;
    :cond_2
    iget v9, p0, Ltv/freewheel/ad/AdManager;->version:I

    return v9
.end method

.method public newContext()Ltv/freewheel/ad/interfaces/IAdContext;
    .locals 1

    .prologue
    .line 40
    new-instance v0, Ltv/freewheel/ad/AdContext;

    invoke-direct {v0, p0}, Ltv/freewheel/ad/AdContext;-><init>(Ltv/freewheel/ad/AdManager;)V

    return-object v0
.end method

.method public setNetwork(I)V
    .locals 1
    .param p1, "networkId"    # I

    .prologue
    .line 116
    iget v0, p0, Ltv/freewheel/ad/AdManager;->networkId:I

    if-lez v0, :cond_0

    .line 120
    :goto_0
    return-void

    .line 119
    :cond_0
    iput p1, p0, Ltv/freewheel/ad/AdManager;->networkId:I

    goto :goto_0
.end method

.method public setServer(Ljava/lang/String;)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 83
    const-string v4, "/"

    invoke-virtual {p1, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 84
    iput-object p1, p0, Ltv/freewheel/ad/AdManager;->serverUrl:Ljava/lang/String;

    .line 113
    :goto_0
    return-void

    .line 88
    :cond_0
    const-string v1, ""

    .line 89
    .local v1, "protocol":Ljava/lang/String;
    const-string v4, "http://"

    invoke-virtual {p1, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v4, "https://"

    invoke-virtual {p1, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 90
    const-string v1, "http://"

    .line 92
    :cond_1
    const-string v4, "\\?"

    invoke-virtual {p1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 94
    .local v3, "urlComponents":[Ljava/lang/String;
    const-string v0, ""

    .line 95
    .local v0, "path":Ljava/lang/String;
    aget-object v4, v3, v6

    const-string v5, "ad/p/1"

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 96
    const-string v0, ""

    .line 107
    :goto_1
    const-string v2, "?"

    .line 108
    .local v2, "query":Ljava/lang/String;
    array-length v4, v3

    if-le v4, v7, :cond_2

    .line 109
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget-object v5, v3, v7

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 112
    :cond_2
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget-object v5, v3, v6

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/ad/AdManager;->serverUrl:Ljava/lang/String;

    goto :goto_0

    .line 97
    .end local v2    # "query":Ljava/lang/String;
    :cond_3
    aget-object v4, v3, v6

    const-string v5, "ad/p/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 98
    const-string v0, "1"

    goto :goto_1

    .line 99
    :cond_4
    aget-object v4, v3, v6

    const-string v5, "ad/p"

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 100
    const-string v0, "/1"

    goto :goto_1

    .line 101
    :cond_5
    aget-object v4, v3, v6

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 102
    const-string v0, "ad/p/1"

    goto :goto_1

    .line 104
    :cond_6
    const-string v0, "/ad/p/1"

    goto :goto_1
.end method
