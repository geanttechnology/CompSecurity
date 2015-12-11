.class public Lcom/amazon/mShop/share/SocialAppConfig;
.super Ljava/lang/Object;
.source "SocialAppConfig.java"


# static fields
.field private static final STATIC_CONFIG_PACKAGE_IDS:[Ljava/lang/String;

.field private static final STATIC_CONFIG_PRIORITIES:[I

.field private static final STATIC_CONFIG_REFTAGS:[Ljava/lang/String;

.field private static sAppConfigMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/share/SocialAppConfig;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mPriority:I

.field private mRefTag:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    const/16 v3, 0xa

    .line 27
    new-array v0, v3, [Ljava/lang/String;

    const-string/jumbo v1, "com.sina.weibo"

    aput-object v1, v0, v4

    const-string/jumbo v1, "com.tencent.mm.timeline"

    aput-object v1, v0, v5

    const-string/jumbo v1, "com.tencent.mm"

    aput-object v1, v0, v6

    const-string/jumbo v1, "com.qzone"

    aput-object v1, v0, v7

    const/4 v1, 0x4

    const-string/jumbo v2, "com.tencent.WBlog"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "com.douban.shuo"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "com.renren"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "com.kaixin001.activity"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "email"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "com.android.mms"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_PACKAGE_IDS:[Ljava/lang/String;

    .line 40
    new-array v0, v3, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_PRIORITIES:[I

    .line 52
    new-array v0, v3, [Ljava/lang/String;

    const-string/jumbo v1, "si_upd_awd_weibo"

    aput-object v1, v0, v4

    const-string/jumbo v1, "we_upd_awd_wechat"

    aput-object v1, v0, v5

    const-string/jumbo v1, "we_upd_awd_wechat"

    aput-object v1, v0, v6

    const-string/jumbo v1, "qz_upd_awd_qzone"

    aput-object v1, v0, v7

    const/4 v1, 0x4

    const-string/jumbo v2, "tc_upd_awd_wblog"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "db_upd_awd_douban"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "re_upd_awd_renren"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "kx_upd_awd_kaixin"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "upd_awd_email"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "other_upd_awd_sms"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_REFTAGS:[Ljava/lang/String;

    return-void

    .line 40
    :array_0
    .array-data 4
        0x14
        0x19
        0x1e
        0x28
        0x64
        0x64
        0x64
        0x64
        0x55
        0x5a
    .end array-data
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "refTag"    # Ljava/lang/String;
    .param p2, "priority"    # I

    .prologue
    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    iput-object p1, p0, Lcom/amazon/mShop/share/SocialAppConfig;->mRefTag:Ljava/lang/String;

    .line 127
    iput p2, p0, Lcom/amazon/mShop/share/SocialAppConfig;->mPriority:I

    .line 128
    return-void
.end method

.method public static buildWechatTimelineInfo(Landroid/content/Context;Landroid/content/pm/ResolveInfo;)Lcom/amazon/mShop/share/SharableAppInfo;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resolveInfo"    # Landroid/content/pm/ResolveInfo;

    .prologue
    .line 100
    sget-object v0, Lcom/amazon/mShop/share/SocialAppConfig;->sAppConfigMap:Ljava/util/Map;

    const-string/jumbo v3, "com.tencent.mm.timeline"

    invoke-interface {v0, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 101
    const/4 v0, 0x0

    .line 109
    :goto_0
    return-object v0

    .line 104
    :cond_0
    sget-object v0, Lcom/amazon/mShop/share/SocialAppConfig;->sAppConfigMap:Ljava/util/Map;

    const-string/jumbo v3, "com.tencent.mm.timeline"

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/mShop/share/SocialAppConfig;

    .line 105
    .local v7, "timelineConfig":Lcom/amazon/mShop/share/SocialAppConfig;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sharing_friends:I

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 108
    .local v1, "label":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->tencent_timeline:I

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 109
    .local v2, "icon":Landroid/graphics/drawable/Drawable;
    new-instance v0, Lcom/amazon/mShop/share/SharableAppInfo;

    const-string/jumbo v3, "com.tencent.mm.timeline"

    invoke-virtual {v7}, Lcom/amazon/mShop/share/SocialAppConfig;->getRefTag()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7}, Lcom/amazon/mShop/share/SocialAppConfig;->getPriority()I

    move-result v5

    move-object v6, p1

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/share/SharableAppInfo;-><init>(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;ILandroid/content/pm/ResolveInfo;)V

    goto :goto_0
.end method

.method public static getDefaultPriority()I
    .locals 1

    .prologue
    .line 118
    const/16 v0, 0x64

    return v0
.end method

.method public static getDefaultRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    const-string/jumbo v0, "other_upd_awd_other"

    return-object v0
.end method

.method public static getEmailPackageId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    const-string/jumbo v0, "email"

    return-object v0
.end method

.method public static declared-synchronized getStaticConfig()Ljava/util/Map;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/share/SocialAppConfig;",
            ">;"
        }
    .end annotation

    .prologue
    .line 69
    const-class v4, Lcom/amazon/mShop/share/SocialAppConfig;

    monitor-enter v4

    :try_start_0
    sget-object v3, Lcom/amazon/mShop/share/SocialAppConfig;->sAppConfigMap:Ljava/util/Map;

    if-nez v3, :cond_0

    .line 70
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    sput-object v3, Lcom/amazon/mShop/share/SocialAppConfig;->sAppConfigMap:Ljava/util/Map;

    .line 72
    sget-object v3, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_PACKAGE_IDS:[Ljava/lang/String;

    array-length v3, v3

    sget-object v5, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_PRIORITIES:[I

    array-length v5, v5

    invoke-static {v3, v5}, Ljava/lang/Math;->min(II)I

    move-result v3

    sget-object v5, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_REFTAGS:[Ljava/lang/String;

    array-length v5, v5

    invoke-static {v3, v5}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 76
    .local v2, "numberOfConfigs":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 77
    new-instance v0, Lcom/amazon/mShop/share/SocialAppConfig;

    sget-object v3, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_REFTAGS:[Ljava/lang/String;

    aget-object v3, v3, v1

    sget-object v5, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_PRIORITIES:[I

    aget v5, v5, v1

    invoke-direct {v0, v3, v5}, Lcom/amazon/mShop/share/SocialAppConfig;-><init>(Ljava/lang/String;I)V

    .line 79
    .local v0, "appConfig":Lcom/amazon/mShop/share/SocialAppConfig;
    sget-object v3, Lcom/amazon/mShop/share/SocialAppConfig;->sAppConfigMap:Ljava/util/Map;

    sget-object v5, Lcom/amazon/mShop/share/SocialAppConfig;->STATIC_CONFIG_PACKAGE_IDS:[Ljava/lang/String;

    aget-object v5, v5, v1

    invoke-interface {v3, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 82
    .end local v0    # "appConfig":Lcom/amazon/mShop/share/SocialAppConfig;
    :cond_0
    sget-object v3, Lcom/amazon/mShop/share/SocialAppConfig;->sAppConfigMap:Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v4

    return-object v3

    .line 69
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3
.end method

.method public static getWechatAddFavoriteActivityName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    const-string/jumbo v0, "com.tencent.mm.ui.tools.AddFavoriteUI"

    return-object v0
.end method

.method public static getWechatPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    const-string/jumbo v0, "com.tencent.mm"

    return-object v0
.end method

.method public static getWechatTimelinePackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    const-string/jumbo v0, "com.tencent.mm.timeline"

    return-object v0
.end method


# virtual methods
.method public getPriority()I
    .locals 1

    .prologue
    .line 135
    iget v0, p0, Lcom/amazon/mShop/share/SocialAppConfig;->mPriority:I

    return v0
.end method

.method public getRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/mShop/share/SocialAppConfig;->mRefTag:Ljava/lang/String;

    return-object v0
.end method
