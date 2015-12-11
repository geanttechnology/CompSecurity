.class Lcom/amazon/device/ads/Utils;
.super Ljava/lang/Object;
.source "Utils.java"


# static fields
.field private static final DISABLED_APP_SERVER_MESSAGE:Ljava/lang/String; = "DISABLED_APP"

.field private static final LOG_TAG:Ljava/lang/String;

.field private static rotationArray:[[I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x4

    .line 52
    const-class v0, Lcom/amazon/device/ads/Utils;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/Utils;->LOG_TAG:Ljava/lang/String;

    .line 89
    const/4 v0, 0x2

    new-array v0, v0, [[I

    const/4 v1, 0x0

    new-array v2, v3, [I

    fill-array-data v2, :array_0

    aput-object v2, v0, v1

    const/4 v1, 0x1

    new-array v2, v3, [I

    fill-array-data v2, :array_1

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/device/ads/Utils;->rotationArray:[[I

    return-void

    nop

    :array_0
    .array-data 4
        0x1
        0x0
        0x9
        0x8
    .end array-data

    :array_1
    .array-data 4
        0x0
        0x9
        0x8
        0x1
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final convertToMillisecondsFromNanoseconds(J)J
    .locals 2
    .param p0, "nanoseconds"    # J

    .prologue
    .line 158
    const-wide/32 v0, 0xf4240

    div-long v0, p0, v0

    return-wide v0
.end method

.method public static final convertToNsFromS(J)J
    .locals 2
    .param p0, "seconds"    # J

    .prologue
    .line 162
    const-wide/32 v0, 0x3b9aca00

    mul-long/2addr v0, p0

    return-wide v0
.end method

.method public static determineCanonicalScreenOrientation()I
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v7, 0x0

    const/4 v8, 0x1

    .line 107
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v9

    invoke-interface {v9}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 108
    .local v0, "context":Landroid/content/Context;
    const-string/jumbo v9, "window"

    invoke-virtual {v0, v9}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/WindowManager;

    .line 109
    .local v6, "windowManager":Landroid/view/WindowManager;
    invoke-interface {v6}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 110
    .local v1, "display":Landroid/view/Display;
    invoke-static {v1}, Lcom/amazon/device/ads/AndroidTargetUtils;->getOrientation(Landroid/view/Display;)I

    move-result v4

    .line 111
    .local v4, "rotation":I
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v9

    iget v3, v9, Landroid/content/res/Configuration;->orientation:I

    .line 113
    .local v3, "orientation":I
    const/4 v2, 0x0

    .line 114
    .local v2, "naturalOrientationIsPortrait":Z
    if-ne v3, v8, :cond_2

    .line 115
    if-eqz v4, :cond_0

    if-ne v4, v10, :cond_1

    :cond_0
    move v2, v8

    .line 121
    :goto_0
    if-eqz v2, :cond_6

    move v5, v7

    .line 122
    .local v5, "rotationSelector":I
    :goto_1
    sget-object v7, Lcom/amazon/device/ads/Utils;->rotationArray:[[I

    aget-object v7, v7, v5

    aget v7, v7, v4

    return v7

    .end local v5    # "rotationSelector":I
    :cond_1
    move v2, v7

    .line 115
    goto :goto_0

    .line 116
    :cond_2
    if-ne v3, v10, :cond_5

    .line 117
    if-eq v4, v8, :cond_3

    const/4 v9, 0x3

    if-ne v4, v9, :cond_4

    :cond_3
    move v2, v8

    :goto_2
    goto :goto_0

    :cond_4
    move v2, v7

    goto :goto_2

    .line 119
    :cond_5
    const/4 v2, 0x1

    goto :goto_0

    :cond_6
    move v5, v8

    .line 121
    goto :goto_1
.end method

.method public static final getDisabledAppServerMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 197
    const-string/jumbo v0, "DISABLED_APP"

    return-object v0
.end method

.method public static final getURLDecodedString(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 144
    if-nez p0, :cond_0

    const/4 p0, 0x0

    .line 152
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    :goto_0
    return-object p0

    .line 147
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_0
    :try_start_0
    const-string/jumbo v1, "UTF-8"

    invoke-static {p0, v1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    goto :goto_0

    .line 149
    :catch_0
    move-exception v0

    .line 151
    .restart local v0    # "e":Ljava/io/UnsupportedEncodingException;
    sget-object v1, Lcom/amazon/device/ads/Utils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "getURLDecodedString threw: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static final getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 129
    if-nez p0, :cond_0

    const/4 p0, 0x0

    .line 138
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    :goto_0
    return-object p0

    .line 132
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_0
    :try_start_0
    const-string/jumbo v1, "UTF-8"

    invoke-static {p0, v1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "+"

    const-string/jumbo v3, "%20"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "*"

    const-string/jumbo v3, "%2A"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "%7E"

    const-string/jumbo v3, "~"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    goto :goto_0

    .line 135
    :catch_0
    move-exception v0

    .line 137
    .restart local v0    # "e":Ljava/io/UnsupportedEncodingException;
    sget-object v1, Lcom/amazon/device/ads/Utils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "getURLEncodedString threw: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static isAtLeastAndroidAPI(I)Z
    .locals 1
    .param p0, "api"    # I

    .prologue
    .line 188
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static final isNullOrEmpty(Ljava/lang/String;)Z
    .locals 1
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 170
    if-eqz p0, :cond_0

    const-string/jumbo v0, ""

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static final isNullOrWhiteSpace(Ljava/lang/String;)Z
    .locals 2
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 178
    invoke-static {p0}, Lcom/amazon/device/ads/Utils;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static parseInt(Ljava/lang/String;I)I
    .locals 2
    .param p0, "string"    # Ljava/lang/String;
    .param p1, "defaultValue"    # I

    .prologue
    .line 79
    move v0, p1

    .line 82
    .local v0, "value":I
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 86
    :goto_0
    return v0

    .line 84
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static sha1(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 63
    :try_start_0
    const-string/jumbo v5, "SHA-1"

    invoke-static {v5}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 64
    .local v0, "digest":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/security/MessageDigest;->update([B)V

    .line 65
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v4

    .line 67
    .local v4, "messageDigest":[B
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 68
    .local v2, "hexString":Ljava/lang/StringBuilder;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v5, v4

    if-ge v3, v5, :cond_0

    .line 69
    aget-byte v5, v4, v3

    and-int/lit16 v5, v5, 0xff

    or-int/lit16 v5, v5, 0x100

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 68
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 71
    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 73
    .end local v0    # "digest":Ljava/security/MessageDigest;
    .end local v2    # "hexString":Ljava/lang/StringBuilder;
    .end local v3    # "i":I
    .end local v4    # "messageDigest":[B
    :goto_1
    return-object v5

    .line 72
    :catch_0
    move-exception v1

    .line 73
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    const-string/jumbo v5, ""

    goto :goto_1
.end method
