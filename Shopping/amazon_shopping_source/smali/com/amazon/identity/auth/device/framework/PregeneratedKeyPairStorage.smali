.class public Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;
.super Ljava/lang/Object;
.source "PregeneratedKeyPairStorage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    }
.end annotation


# static fields
.field static final AMZN_SELF_KEY_FORMAT:Ljava/lang/String; = "B64/X.509"

.field static final KEY_PAIR_GENERATION_SERVICE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.KeyPairGenerationService"

.field static final SELF_GENERATED_KEY_PAIR_ALGO_SETTING_NAME:Ljava/lang/String; = "KeyPairGenerationService_Self_Generated_Key_Pair_Algo"

.field static final SELF_GENERATED_KEY_PAIR_CACHE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.KeyPairGenerationService.SHARED_PREFS"

.field private static final TAG:Ljava/lang/String;

.field private static sPregeneratedKeyPairStorage:Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 74
    const-class v0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->mContext:Landroid/content/Context;

    .line 83
    return-void
.end method

.method private declared-synchronized generateKeyPairAndPutToCache(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 4
    .param p1, "prefs"    # Landroid/content/SharedPreferences;
    .param p2, "keyAlgo"    # Ljava/lang/String;

    .prologue
    .line 244
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->getKeyPairFromCache(Landroid/content/SharedPreferences;)Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    move-result-object v1

    if-nez v1, :cond_3

    .line 246
    sget-object v1, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "KeyPairGenerationService found not key pair in cache and tried to generate one with algoritm:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    const-string/jumbo v1, "RSA"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->generateKeyPairRSA()Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    move-result-object v0

    .line 250
    .local v0, "keyPair":Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    :goto_0
    if-eqz v0, :cond_0

    .line 252
    sget-object v1, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "KeyPairGenerationService successfully generated a key pair with algoritm:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 253
    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, "algo"

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getAlgo()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    const-string/jumbo v2, "encoded_pub_key"

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getEncodedPublicKey()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    const-string/jumbo v2, "encoded_priv_key"

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getEncodedPrivateKey()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    const-string/jumbo v2, "format"

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getFormat()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Unable to save self generated key pair to cache."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 260
    .end local v0    # "keyPair":Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    :cond_0
    :goto_1
    monitor-exit p0

    return-void

    .line 249
    :cond_1
    :try_start_1
    const-string/jumbo v1, "EC"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->generateKeyPairEC()Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    move-result-object v0

    goto :goto_0

    :cond_2
    sget-object v1, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Unsupported algorithm: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    goto :goto_0

    .line 258
    :cond_3
    sget-object v1, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "KeyPairGenerationService found a key pair in cache. No need to generate one."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 244
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 87
    const-class v1, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->sPregeneratedKeyPairStorage:Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;

    if-nez v0, :cond_0

    .line 89
    new-instance v0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->sPregeneratedKeyPairStorage:Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;

    .line 92
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->sPregeneratedKeyPairStorage:Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 87
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getKeyPairFromCache(Landroid/content/SharedPreferences;)Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    .locals 6
    .param p1, "prefs"    # Landroid/content/SharedPreferences;

    .prologue
    const/4 v4, 0x0

    .line 156
    const-string/jumbo v5, "algo"

    invoke-interface {p1, v5, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 157
    .local v0, "algo":Ljava/lang/String;
    const-string/jumbo v5, "encoded_pub_key"

    invoke-interface {p1, v5, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 158
    .local v3, "pubKey":Ljava/lang/String;
    const-string/jumbo v5, "encoded_priv_key"

    invoke-interface {p1, v5, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 159
    .local v2, "priKey":Ljava/lang/String;
    const-string/jumbo v5, "format"

    invoke-interface {p1, v5, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 161
    .local v1, "format":Ljava/lang/String;
    if-eqz v0, :cond_0

    if-eqz v3, :cond_0

    if-eqz v2, :cond_0

    if-eqz v1, :cond_0

    .line 163
    new-instance v4, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    invoke-direct {v4, v0, v3, v2, v1}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    :cond_0
    return-object v4
.end method


# virtual methods
.method public declared-synchronized generateKeyPair()V
    .locals 5

    .prologue
    .line 138
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v2

    const-string/jumbo v3, "KeyPairGenerationService_Self_Generated_Key_Pair_Algo"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 141
    .local v0, "keyAlgo":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 143
    sget-object v2, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "KeyPairGenerationService_Self_Generated_Key_Pair_Algo was null or empty when start KeyPairGenerationService."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 152
    :goto_0
    monitor-exit p0

    return-void

    .line 149
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "com.amazon.dcp.sso.KeyPairGenerationService.SHARED_PREFS"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 150
    .local v1, "keyCache":Landroid/content/SharedPreferences;
    invoke-direct {p0, v1, v0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->generateKeyPairAndPutToCache(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 138
    .end local v0    # "keyAlgo":Ljava/lang/String;
    .end local v1    # "keyCache":Landroid/content/SharedPreferences;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method protected generateKeyPairEC()Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    .locals 7

    .prologue
    .line 229
    const-string/jumbo v4, "EC"

    invoke-static {v4}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->getKeyPairSelfGenerationTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v3

    .line 230
    .local v3, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-virtual {v3}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->start()V

    .line 231
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/KeyPairGenHelper;->getECKeyPair()Ljava/security/KeyPair;

    move-result-object v0

    .line 232
    .local v0, "ecKeyPair":Ljava/security/KeyPair;
    invoke-virtual {v0}, Ljava/security/KeyPair;->getPublic()Ljava/security/PublicKey;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/KeyPairGenHelper;->encodePublicKey(Ljava/security/PublicKey;)Ljava/lang/String;

    move-result-object v2

    .line 233
    .local v2, "encodedPublicKey":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/security/KeyPair;->getPrivate()Ljava/security/PrivateKey;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/KeyPairGenHelper;->encodeECPrivateKey(Ljava/security/PrivateKey;)Ljava/lang/String;

    move-result-object v1

    .line 234
    .local v1, "encodedPrivateKey":Ljava/lang/String;
    invoke-virtual {v3}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 236
    new-instance v4, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    const-string/jumbo v5, "EC"

    const-string/jumbo v6, "B64/X.509"

    invoke-direct {v4, v5, v2, v1, v6}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v4
.end method

.method protected generateKeyPairRSA()Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    .locals 7

    .prologue
    .line 214
    const-string/jumbo v4, "RSA"

    invoke-static {v4}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->getKeyPairSelfGenerationTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v3

    .line 215
    .local v3, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-virtual {v3}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->start()V

    .line 216
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/KeyPairGenHelper;->getRSAKeyPair()Ljava/security/KeyPair;

    move-result-object v2

    .line 217
    .local v2, "rsaKeyPair":Ljava/security/KeyPair;
    invoke-virtual {v2}, Ljava/security/KeyPair;->getPublic()Ljava/security/PublicKey;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/KeyPairGenHelper;->encodePublicKey(Ljava/security/PublicKey;)Ljava/lang/String;

    move-result-object v1

    .line 218
    .local v1, "encodedPublicKey":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/security/KeyPair;->getPrivate()Ljava/security/PrivateKey;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/KeyPairGenHelper;->encodeRSAPrivateKey(Ljava/security/PrivateKey;)Ljava/lang/String;

    move-result-object v0

    .line 219
    .local v0, "encodedPrivateKey":Ljava/lang/String;
    invoke-virtual {v3}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 221
    new-instance v4, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    const-string/jumbo v5, "RSA"

    const-string/jumbo v6, "B64/X.509"

    invoke-direct {v4, v5, v1, v0, v6}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v4
.end method

.method public declared-synchronized retrieveSelfGeneratedKeyPair()Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 105
    monitor-enter p0

    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v3

    const-string/jumbo v4, "KeyPairGenerationService_Self_Generated_Key_Pair_Algo"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 108
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 112
    sget-object v3, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v0, v2

    .line 132
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v0

    .line 116
    :cond_1
    :try_start_1
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v4, "com.amazon.dcp.sso.KeyPairGenerationService.SHARED_PREFS"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 119
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->getKeyPairFromCache(Landroid/content/SharedPreferences;)Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    move-result-object v0

    .line 120
    .local v0, "keyPair":Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    if-eqz v0, :cond_3

    .line 122
    sget-object v2, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "KeyPairGenerationService found a key pair In cache when retrieveSelfGeneratedKeyPair."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v2

    if-nez v2, :cond_2

    sget-object v2, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Unable to clear self generated key pair cache."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->mContext:Landroid/content/Context;

    const/4 v3, 0x0

    const-string/jumbo v4, "com.amazon.dcp.sso.KeyPairGenerationService"

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->getBestIntentForService(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v3, v2}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 105
    .end local v0    # "keyPair":Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    .end local v1    # "prefs":Landroid/content/SharedPreferences;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 131
    .restart local v0    # "keyPair":Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    .restart local v1    # "prefs":Landroid/content/SharedPreferences;
    :cond_3
    :try_start_2
    sget-object v3, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "KeyPairGenerationService found no key pair in cache when retrieveSelfGeneratedKeyPair."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-object v0, v2

    .line 132
    goto :goto_0
.end method
