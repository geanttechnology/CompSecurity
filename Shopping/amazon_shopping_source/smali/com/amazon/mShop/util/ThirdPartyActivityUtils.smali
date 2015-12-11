.class public Lcom/amazon/mShop/util/ThirdPartyActivityUtils;
.super Ljava/lang/Object;
.source "ThirdPartyActivityUtils.java"


# static fields
.field private static final ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 156
    const-string/jumbo v0, "content://com.facebook.katana.provider.AttributionIdProvider"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static buildGooglePlayPageUrl()Ljava/lang/String;
    .locals 5

    .prologue
    .line 19
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 20
    .local v0, "context":Landroid/content/Context;
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->upgrade_google_play_url:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method static checkAmazonAppstorePackage()Z
    .locals 4

    .prologue
    .line 122
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 124
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->getAppStoreIntent()Landroid/content/Intent;

    move-result-object v1

    .line 126
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    const/high16 v3, 0x10000

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method static checkGooglePackage()Z
    .locals 4

    .prologue
    .line 131
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 133
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->getGooglePlayIntent()Landroid/content/Intent;

    move-result-object v1

    .line 134
    .local v1, "intent":Landroid/content/Intent;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->upgrade_google_play_package:I

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->upgrade_google_play_activity:I

    invoke-virtual {v0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 138
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    const/high16 v3, 0x10000

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method static getAmazonAppHostPageIntent()Landroid/content/Intent;
    .locals 4

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 34
    .local v0, "context":Landroid/content/Context;
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->upgrade_amazon_app_host_url:I

    invoke-virtual {v0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 36
    .local v1, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 37
    return-object v1
.end method

.method static getAppStoreIntent()Landroid/content/Intent;
    .locals 5

    .prologue
    .line 113
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 114
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->getInstance()Lcom/amazon/mShop/details/AmazonAppStoreProxy;

    move-result-object v2

    const/4 v3, 0x0

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->upgrade_amazon_appstore_asin:I

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v0, v3, v4}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 117
    .local v1, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 118
    return-object v1
.end method

.method public static getFaceBookAttributionId(Landroid/content/Context;)Ljava/lang/String;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v9, 0x0

    .line 161
    const/4 v6, 0x0

    .line 162
    .local v6, "attributionId":Ljava/lang/String;
    const/4 v7, 0x0

    .line 164
    .local v7, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 165
    .local v0, "contentResolver":Landroid/content/ContentResolver;
    const/4 v1, 0x1

    new-array v2, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v3, "aid"

    aput-object v3, v2, v1

    .line 166
    .local v2, "projection":[Ljava/lang/String;
    sget-object v1, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 167
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_2

    .line 174
    :cond_0
    if-eqz v7, :cond_1

    .line 175
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_1
    move-object v1, v9

    .line 179
    .end local v0    # "contentResolver":Landroid/content/ContentResolver;
    .end local v2    # "projection":[Ljava/lang/String;
    :goto_0
    return-object v1

    .line 170
    .restart local v0    # "contentResolver":Landroid/content/ContentResolver;
    .restart local v2    # "projection":[Ljava/lang/String;
    :cond_2
    :try_start_1
    const-string/jumbo v1, "aid"

    invoke-interface {v7, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v7, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v6

    .line 174
    if-eqz v7, :cond_3

    .line 175
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .end local v0    # "contentResolver":Landroid/content/ContentResolver;
    .end local v2    # "projection":[Ljava/lang/String;
    :cond_3
    :goto_1
    move-object v1, v6

    .line 179
    goto :goto_0

    .line 171
    :catch_0
    move-exception v8

    .line 172
    .local v8, "e":Ljava/lang/Throwable;
    :try_start_2
    const-string/jumbo v1, "StartupActivity"

    const-string/jumbo v3, "Can not read attribution id from com.facebook.katana.provider.AttributionIdProvider"

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 174
    if-eqz v7, :cond_3

    .line 175
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 174
    .end local v8    # "e":Ljava/lang/Throwable;
    :catchall_0
    move-exception v1

    if-eqz v7, :cond_4

    .line 175
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v1
.end method

.method static getGeneralMarketIntent()Landroid/content/Intent;
    .locals 7

    .prologue
    .line 61
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 62
    .local v0, "context":Landroid/content/Context;
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->upgrade_general_market_url:I

    invoke-virtual {v0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 65
    .local v1, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 67
    return-object v1
.end method

.method static getGooglePlayIntent()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 26
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "android.intent.action.VIEW"

    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->buildGooglePlayPageUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 28
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 29
    return-object v0
.end method

.method public static installAmazonAppStore()V
    .locals 3

    .prologue
    .line 184
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 185
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->getInstance()Lcom/amazon/mShop/details/AmazonAppStoreProxy;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->getIntentForInstall(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    .line 186
    .local v1, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 187
    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 191
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 188
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public static isCnPackage()Z
    .locals 3

    .prologue
    .line 81
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 82
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "cn"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method static openAmazonAppHostPage()V
    .locals 2

    .prologue
    .line 52
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->getAmazonAppHostPageIntent()Landroid/content/Intent;

    move-result-object v0

    .line 53
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 58
    :goto_0
    return-void

    .line 55
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method static openGeneralMarketApp()V
    .locals 3

    .prologue
    .line 72
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->getGeneralMarketIntent()Landroid/content/Intent;

    move-result-object v1

    .line 73
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    :goto_0
    return-void

    .line 75
    :catch_0
    move-exception v0

    .line 76
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->openGooglePlayPage()V

    goto :goto_0
.end method

.method static openGooglePlayPage()V
    .locals 2

    .prologue
    .line 42
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->getGooglePlayIntent()Landroid/content/Intent;

    move-result-object v0

    .line 43
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 48
    :goto_0
    return-void

    .line 45
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method static startAmazonAppStore()V
    .locals 3

    .prologue
    .line 104
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->getAppStoreIntent()Landroid/content/Intent;

    move-result-object v1

    .line 105
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 110
    :goto_0
    return-void

    .line 107
    :catch_0
    move-exception v0

    .line 108
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->installAmazonAppStore()V

    goto :goto_0
.end method

.method static startGooglePlay()V
    .locals 5

    .prologue
    .line 86
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 88
    .local v0, "context":Landroid/content/Context;
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->getGeneralMarketIntent()Landroid/content/Intent;

    move-result-object v2

    .line 89
    .local v2, "intent":Landroid/content/Intent;
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->upgrade_google_play_package:I

    invoke-virtual {v0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->upgrade_google_play_activity:I

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 92
    invoke-virtual {v0, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 100
    .end local v2    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 93
    :catch_0
    move-exception v1

    .line 94
    .local v1, "e":Landroid/content/ActivityNotFoundException;
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->isCnPackage()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 95
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->openAmazonAppHostPage()V

    goto :goto_0

    .line 97
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->openGeneralMarketApp()V

    goto :goto_0
.end method
