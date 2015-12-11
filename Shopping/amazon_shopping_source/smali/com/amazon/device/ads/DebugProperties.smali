.class Lcom/amazon/device/ads/DebugProperties;
.super Ljava/lang/Object;
.source "DebugProperties.java"


# static fields
.field public static final DEBUG_AAX_AD_HOSTNAME:Ljava/lang/String; = "debug.aaxHostname"

.field public static final DEBUG_AAX_AD_PARAMS:Ljava/lang/String; = "debug.aaxAdParams"

.field public static final DEBUG_AAX_CONFIG_HOSTNAME:Ljava/lang/String; = "debug.aaxConfigHostname"

.field public static final DEBUG_AAX_CONFIG_PARAMS:Ljava/lang/String; = "debug.aaxConfigParams"

.field public static final DEBUG_AAX_CONFIG_USE_SECURE:Ljava/lang/String; = "debug.aaxConfigUseSecure"

.field public static final DEBUG_ADID:Ljava/lang/String; = "debug.adid"

.field public static final DEBUG_AD_PREF_URL:Ljava/lang/String; = "debug.adPrefURL"

.field public static final DEBUG_APPID:Ljava/lang/String; = "debug.appid"

.field public static final DEBUG_CHANNEL:Ljava/lang/String; = "debug.channel"

.field public static final DEBUG_CONFIG_FEATURE_USE_GPS_ADVERTISING_ID:Ljava/lang/String; = "debug.fUseGPSAID"

.field public static final DEBUG_DINFO:Ljava/lang/String; = "debug.dinfo"

.field public static final DEBUG_ECPM:Ljava/lang/String; = "debug.ec"

.field public static final DEBUG_GEOLOC:Ljava/lang/String; = "debug.geoloc"

.field public static final DEBUG_IDFA:Ljava/lang/String; = "debug.idfa"

.field public static final DEBUG_LOGGING:Ljava/lang/String; = "debug.logging"

.field public static final DEBUG_MADS_HOSTNAME:Ljava/lang/String; = "debug.madsHostname"

.field public static final DEBUG_MADS_USE_SECURE:Ljava/lang/String; = "debug.madsUseSecure"

.field public static final DEBUG_MD5UDID:Ljava/lang/String; = "debug.md5udid"

.field public static final DEBUG_MXSZ:Ljava/lang/String; = "debug.mxsz"

.field public static final DEBUG_NORETRYTTL:Ljava/lang/String; = "debug.noRetryTTL"

.field public static final DEBUG_NORETRYTTL_MAX:Ljava/lang/String; = "debug.noRetryTTLMax"

.field public static final DEBUG_ON:Ljava/lang/String; = "debug.mode"

.field public static final DEBUG_OPT_OUT:Ljava/lang/String; = "debug.optOut"

.field public static final DEBUG_PA:Ljava/lang/String; = "debug.pa"

.field public static final DEBUG_PK:Ljava/lang/String; = "debug.pk"

.field public static final DEBUG_PKG:Ljava/lang/String; = "debug.pkg"

.field public static final DEBUG_PT:Ljava/lang/String; = "debug.pt"

.field public static final DEBUG_SEND_GEO:Ljava/lang/String; = "debug.sendGeo"

.field public static final DEBUG_SHA1UDID:Ljava/lang/String; = "debug.sha1udid"

.field public static final DEBUG_SHOULD_FETCH_CONFIG:Ljava/lang/String; = "debug.shouldFetchConfig"

.field public static final DEBUG_SHOULD_IDENTIFY_USER:Ljava/lang/String; = "debug.shouldIdentifyUser"

.field public static final DEBUG_SHOULD_REGISTER_SIS:Ljava/lang/String; = "debug.shouldRegisterSIS"

.field public static final DEBUG_SIS_DOMAIN:Ljava/lang/String; = "debug.sisDomain"

.field public static final DEBUG_SIS_URL:Ljava/lang/String; = "debug.sisURL"

.field public static final DEBUG_SIZE:Ljava/lang/String; = "debug.size"

.field public static final DEBUG_SLOT:Ljava/lang/String; = "debug.slot"

.field public static final DEBUG_SLOTS:Ljava/lang/String; = "debug.slots"

.field public static final DEBUG_SLOT_ID:Ljava/lang/String; = "debug.slotId"

.field public static final DEBUG_SP:Ljava/lang/String; = "debug.sp"

.field public static final DEBUG_TEST:Ljava/lang/String; = "debug.test"

.field public static final DEBUG_TLS_ENABLED:Ljava/lang/String; = "debug.tlsEnabled"

.field public static final DEBUG_UA:Ljava/lang/String; = "debug.ua"

.field public static final DEBUG_UI:Ljava/lang/String; = "debug.ui"

.field public static final DEBUG_VER:Ljava/lang/String; = "debug.ver"

.field private static final FILE_PREFIX:Ljava/lang/String; = "/com.amazon.device.ads.debug"

.field private static final LOG_TAG:Ljava/lang/String;

.field private static debugModeOn:Z

.field private static debugProperties:Ljava/util/Properties;

.field private static final privExponent:Ljava/math/BigInteger;

.field private static final privModulus:Ljava/math/BigInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 25
    const-class v0, Lcom/amazon/device/ads/DebugProperties;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/DebugProperties;->LOG_TAG:Ljava/lang/String;

    .line 77
    new-instance v0, Ljava/math/BigInteger;

    const-string/jumbo v1, "22425945969293236512819607281747202268852113345956851069545419503178249900977203670147638322801582881051882957295768557918356441519366172126884608406316888515239296504501830280664879549133570276792155151832332847188532369002492210234019359186842709493620665119919750832332220777141369255943445578381285984064028865613478676828533273460580467686485184132743895959747097454385452868408957601246667523882372216446056029831689133478714597838700864119273209955182548633182248700235085802575904827859971001196599005060045450779595767759943984991630413046800554347791145167910883355627096118148593841261053098773337592734097"

    invoke-direct {v0, v1}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/DebugProperties;->privModulus:Ljava/math/BigInteger;

    .line 78
    new-instance v0, Ljava/math/BigInteger;

    const-string/jumbo v1, "5599215006722084151841970702827860151139465197978118529242591197804380779249736540498127864809226859371835159226553869008622098243456195347852554241917744888762998133926842072150379542281041403163862165638226686887497980590930009552760406707269286898150890998325325890252103828011111664174475487114957696526157790937869377570600085450453371238028811033168218737171144699577236108423054506552958366535341910569552237227686862748056351625445281035713423043506793107235726047151346608576583081807969458368853010104969843563629579750936551771756389538574062221915919980316992216032119182896925094308799622409361028579777"

    invoke-direct {v0, v1}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/DebugProperties;->privExponent:Ljava/math/BigInteger;

    .line 80
    new-instance v0, Ljava/util/Properties;

    invoke-direct {v0}, Ljava/util/Properties;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    .line 81
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static containsDebugProperty(Ljava/lang/String;)Z
    .locals 1
    .param p0, "property"    # Ljava/lang/String;

    .prologue
    .line 223
    sget-boolean v0, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    if-nez v0, :cond_0

    .line 225
    const/4 v0, 0x0

    .line 229
    :goto_0
    return v0

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    invoke-virtual {v0, p0}, Ljava/util/Properties;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method protected static decrypt([B)[B
    .locals 9
    .param p0, "data"    # [B

    .prologue
    .line 239
    const/4 v1, 0x0

    .line 242
    .local v1, "decryptedData":[B
    :try_start_0
    new-instance v5, Ljava/security/spec/RSAPrivateKeySpec;

    sget-object v6, Lcom/amazon/device/ads/DebugProperties;->privModulus:Ljava/math/BigInteger;

    sget-object v7, Lcom/amazon/device/ads/DebugProperties;->privExponent:Ljava/math/BigInteger;

    invoke-direct {v5, v6, v7}, Ljava/security/spec/RSAPrivateKeySpec;-><init>(Ljava/math/BigInteger;Ljava/math/BigInteger;)V

    .line 243
    .local v5, "keySpec":Ljava/security/spec/RSAPrivateKeySpec;
    const-string/jumbo v6, "RSA"

    invoke-static {v6}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v4

    .line 244
    .local v4, "keyFactory":Ljava/security/KeyFactory;
    invoke-virtual {v4, v5}, Ljava/security/KeyFactory;->generatePrivate(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;

    move-result-object v3

    .line 246
    .local v3, "key":Ljava/security/PrivateKey;
    const-string/jumbo v6, "RSA"

    invoke-static {v6}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 247
    .local v0, "cipher":Ljavax/crypto/Cipher;
    const/4 v6, 0x2

    invoke-virtual {v0, v6, v3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 248
    invoke-virtual {v0, p0}, Ljavax/crypto/Cipher;->doFinal([B)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 255
    .end local v0    # "cipher":Ljavax/crypto/Cipher;
    .end local v3    # "key":Ljava/security/PrivateKey;
    .end local v4    # "keyFactory":Ljava/security/KeyFactory;
    .end local v5    # "keySpec":Ljava/security/spec/RSAPrivateKeySpec;
    :goto_0
    return-object v1

    .line 250
    :catch_0
    move-exception v2

    .line 252
    .local v2, "e":Ljava/lang/Exception;
    sget-object v6, Lcom/amazon/device/ads/DebugProperties;->LOG_TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Exception "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, " trying to decrypt debug file"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static disableDebugging()V
    .locals 1

    .prologue
    .line 270
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    .line 271
    return-void
.end method

.method static enableDebugging()V
    .locals 1

    .prologue
    .line 265
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    .line 266
    return-void
.end method

.method public static getDebugPropertyAsBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 6
    .param p0, "property"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Ljava/lang/Boolean;

    .prologue
    .line 173
    sget-boolean v2, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    if-nez v2, :cond_1

    .line 189
    .end local p1    # "defaultValue":Ljava/lang/Boolean;
    :cond_0
    :goto_0
    return-object p1

    .line 177
    .restart local p1    # "defaultValue":Ljava/lang/Boolean;
    :cond_1
    sget-object v2, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    invoke-virtual {v2, p0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 178
    .local v1, "propertyValue":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 184
    :try_start_0
    invoke-static {v1}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    goto :goto_0

    .line 186
    :catch_0
    move-exception v0

    .line 188
    .local v0, "e":Ljava/lang/NumberFormatException;
    sget-object v2, Lcom/amazon/device/ads/DebugProperties;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "Unable to parse boolean debug property - property: %s, value: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p0, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z
    .locals 1
    .param p0, "property"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Z

    .prologue
    .line 169
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public static getDebugPropertyAsInteger(Ljava/lang/String;I)I
    .locals 1
    .param p0, "property"    # Ljava/lang/String;
    .param p1, "defaultValue"    # I

    .prologue
    .line 142
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsInteger(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public static getDebugPropertyAsInteger(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 6
    .param p0, "property"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Ljava/lang/Integer;

    .prologue
    .line 146
    sget-boolean v2, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    if-nez v2, :cond_1

    .line 162
    .end local p1    # "defaultValue":Ljava/lang/Integer;
    :cond_0
    :goto_0
    return-object p1

    .line 150
    .restart local p1    # "defaultValue":Ljava/lang/Integer;
    :cond_1
    sget-object v2, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    invoke-virtual {v2, p0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 151
    .local v1, "propertyValue":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 157
    :try_start_0
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    goto :goto_0

    .line 159
    :catch_0
    move-exception v0

    .line 161
    .local v0, "e":Ljava/lang/NumberFormatException;
    sget-object v2, Lcom/amazon/device/ads/DebugProperties;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "Unable to parse integer debug property - property: %s, value: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p0, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static getDebugPropertyAsLong(Ljava/lang/String;J)J
    .locals 2
    .param p0, "property"    # Ljava/lang/String;
    .param p1, "defaultValue"    # J

    .prologue
    .line 196
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsLong(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public static getDebugPropertyAsLong(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;
    .locals 6
    .param p0, "property"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Ljava/lang/Long;

    .prologue
    .line 200
    sget-boolean v2, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    if-nez v2, :cond_1

    .line 216
    .end local p1    # "defaultValue":Ljava/lang/Long;
    :cond_0
    :goto_0
    return-object p1

    .line 204
    .restart local p1    # "defaultValue":Ljava/lang/Long;
    :cond_1
    sget-object v2, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    invoke-virtual {v2, p0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 205
    .local v1, "propertyValue":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 211
    :try_start_0
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    goto :goto_0

    .line 213
    :catch_0
    move-exception v0

    .line 215
    .local v0, "e":Ljava/lang/NumberFormatException;
    sget-object v2, Lcom/amazon/device/ads/DebugProperties;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "Unable to parse long debug property - property: %s, value: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p0, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "property"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 135
    sget-boolean v0, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    if-nez v0, :cond_0

    .line 138
    .end local p1    # "defaultValue":Ljava/lang/String;
    :goto_0
    return-object p1

    .restart local p1    # "defaultValue":Ljava/lang/String;
    :cond_0
    sget-object v0, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    invoke-virtual {v0, p0, p1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method public static isDebugModeOn()Z
    .locals 1

    .prologue
    .line 234
    sget-boolean v0, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z

    return v0
.end method

.method public static readDebugProperties()V
    .locals 16

    .prologue
    .line 85
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v10

    .line 86
    .local v10, "storageState":Ljava/lang/String;
    const-string/jumbo v12, "mounted"

    invoke-virtual {v12, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_0

    .line 88
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string/jumbo v13, "/com.amazon.device.ads.debug"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 90
    .local v6, "filename":Ljava/lang/String;
    new-instance v5, Ljava/io/File;

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 91
    .local v5, "file":Ljava/io/File;
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v12

    if-eqz v12, :cond_0

    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v12

    const-wide/32 v14, 0x7fffffff

    cmp-long v12, v12, v14

    if-lez v12, :cond_1

    .line 132
    .end local v5    # "file":Ljava/io/File;
    .end local v6    # "filename":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 96
    .restart local v5    # "file":Ljava/io/File;
    .restart local v6    # "filename":Ljava/lang/String;
    :cond_1
    const/4 v7, 0x0

    .line 99
    .local v7, "input":Ljava/io/InputStream;
    const/4 v11, 0x0

    .line 100
    .local v11, "totalBytesRead":I
    :try_start_0
    new-instance v8, Ljava/io/BufferedInputStream;

    new-instance v12, Ljava/io/FileInputStream;

    invoke-direct {v12, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v8, v12}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 101
    .end local v7    # "input":Ljava/io/InputStream;
    .local v8, "input":Ljava/io/InputStream;
    :try_start_1
    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v12

    long-to-int v12, v12

    new-array v9, v12, [B

    .line 102
    .local v9, "res":[B
    :cond_2
    :goto_1
    array-length v12, v9

    if-ge v11, v12, :cond_3

    .line 104
    array-length v12, v9

    sub-int v2, v12, v11

    .line 105
    .local v2, "bytesRemaining":I
    invoke-virtual {v8, v9, v11, v2}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    .line 106
    .local v1, "bytesRead":I
    if-lez v1, :cond_2

    .line 107
    add-int/2addr v11, v1

    goto :goto_1

    .line 110
    .end local v1    # "bytesRead":I
    .end local v2    # "bytesRemaining":I
    :cond_3
    invoke-static {v9}, Lcom/amazon/device/ads/DebugProperties;->decrypt([B)[B

    move-result-object v4

    .line 111
    .local v4, "decrypted":[B
    if-eqz v4, :cond_4

    .line 113
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, v4}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 116
    .local v0, "bais":Ljava/io/ByteArrayInputStream;
    sget-object v12, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    invoke-virtual {v12}, Ljava/util/Properties;->clear()V

    .line 117
    sget-object v12, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    invoke-virtual {v12, v0}, Ljava/util/Properties;->load(Ljava/io/InputStream;)V

    .line 118
    sget-object v12, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    const-string/jumbo v13, "debug.mode"

    const-string/jumbo v14, "false"

    invoke-virtual {v12, v13, v14}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 119
    .local v3, "debug":Ljava/lang/String;
    const-string/jumbo v12, "true"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_4

    .line 120
    const/4 v12, 0x1

    sput-boolean v12, Lcom/amazon/device/ads/DebugProperties;->debugModeOn:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 125
    .end local v0    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "debug":Ljava/lang/String;
    :cond_4
    if-eqz v8, :cond_0

    .line 126
    :try_start_2
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 129
    :catch_0
    move-exception v12

    move-object v7, v8

    .end local v8    # "input":Ljava/io/InputStream;
    .restart local v7    # "input":Ljava/io/InputStream;
    goto :goto_0

    .line 125
    .end local v4    # "decrypted":[B
    .end local v9    # "res":[B
    :catchall_0
    move-exception v12

    :goto_2
    if-eqz v7, :cond_5

    .line 126
    :try_start_3
    invoke-virtual {v7}, Ljava/io/InputStream;->close()V

    :cond_5
    throw v12
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .line 129
    :catch_1
    move-exception v12

    goto :goto_0

    .line 125
    .end local v7    # "input":Ljava/io/InputStream;
    .restart local v8    # "input":Ljava/io/InputStream;
    :catchall_1
    move-exception v12

    move-object v7, v8

    .end local v8    # "input":Ljava/io/InputStream;
    .restart local v7    # "input":Ljava/io/InputStream;
    goto :goto_2
.end method

.method static setDebugProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "property"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 260
    sget-object v0, Lcom/amazon/device/ads/DebugProperties;->debugProperties:Ljava/util/Properties;

    invoke-virtual {v0, p0, p1}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 261
    return-void
.end method
