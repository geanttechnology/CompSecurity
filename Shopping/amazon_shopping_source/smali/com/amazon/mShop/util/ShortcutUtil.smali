.class public Lcom/amazon/mShop/util/ShortcutUtil;
.super Ljava/lang/Object;
.source "ShortcutUtil.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/mShop/util/ShortcutUtil;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/util/ShortcutUtil;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAppStartCountInCurrentVersion(Landroid/content/Context;)I
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->isVersionUpToDate(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 71
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->updateVersion(Landroid/content/Context;)V

    .line 75
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 76
    .local v0, "datastore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "app_start_count_of_current_version"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v1

    return v1
.end method

.method public static increaseAppStartCountInCurrentVersion(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 58
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->isVersionUpToDate(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 59
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->updateVersion(Landroid/content/Context;)V

    .line 62
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 63
    .local v0, "datastore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "app_start_count_of_current_version"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 64
    .local v1, "startCount":I
    const-string/jumbo v2, "app_start_count_of_current_version"

    add-int/lit8 v3, v1, 0x1

    invoke-interface {v0, v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 65
    return-void
.end method

.method public static installShortcut(Landroid/app/Activity;)V
    .locals 8
    .param p0, "targetActivity"    # Landroid/app/Activity;

    .prologue
    .line 94
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Landroid/app/Activity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v6

    if-nez v6, :cond_1

    .line 118
    :cond_0
    :goto_0
    return-void

    .line 97
    :cond_1
    invoke-virtual {p0}, Landroid/app/Activity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v6

    iget v3, v6, Landroid/content/pm/ApplicationInfo;->labelRes:I

    .line 99
    .local v3, "labelRes":I
    invoke-virtual {p0}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 100
    .local v4, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 101
    .local v0, "actionIntent":Landroid/content/Intent;
    const/high16 v6, 0x10200000

    invoke-virtual {v0, v6}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 103
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 104
    .local v1, "addIntent":Landroid/content/Intent;
    const-string/jumbo v6, "android.intent.extra.shortcut.INTENT"

    invoke-virtual {v1, v6, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 105
    const-string/jumbo v6, "android.intent.extra.shortcut.NAME"

    invoke-virtual {p0, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 107
    sget v6, Lcom/amazon/mShop/android/lib/R$drawable;->amzn_icon_android:I

    invoke-static {p0, v6}, Landroid/content/Intent$ShortcutIconResource;->fromContext(Landroid/content/Context;I)Landroid/content/Intent$ShortcutIconResource;

    move-result-object v5

    .line 109
    .local v5, "resource":Landroid/content/Intent$ShortcutIconResource;
    const-string/jumbo v6, "android.intent.extra.shortcut.ICON_RESOURCE"

    invoke-virtual {v1, v6, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 110
    const-string/jumbo v6, "com.android.launcher.action.INSTALL_SHORTCUT"

    invoke-virtual {v1, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 113
    invoke-virtual {p0, v1}, Landroid/app/Activity;->sendBroadcast(Landroid/content/Intent;)V

    .line 116
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    .line 117
    .local v2, "datastore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v6, "is_shortcut_installed"

    const/4 v7, 0x1

    invoke-interface {v2, v6, v7}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public static isAbleToInstallShortcut(Landroid/content/Context;)Z
    .locals 15
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 128
    if-nez p0, :cond_0

    .line 129
    const/4 v2, 0x0

    .line 176
    :goto_0
    return v2

    .line 131
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v12

    .line 132
    .local v12, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v11

    .line 134
    .local v11, "packageName":Ljava/lang/String;
    const/4 v13, 0x0

    .line 137
    .local v13, "title":Ljava/lang/String;
    const/16 v2, 0x80

    :try_start_0
    invoke-virtual {v12, v11, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 143
    .local v6, "appInfo":Landroid/content/pm/ApplicationInfo;
    invoke-virtual {v12, v6}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v14

    .line 144
    .local v14, "titleCharSeq":Ljava/lang/CharSequence;
    if-eqz v14, :cond_1

    .line 145
    invoke-virtual {v14}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v13

    .line 148
    :cond_1
    invoke-static {v13}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 149
    const/4 v2, 0x0

    goto :goto_0

    .line 139
    .end local v6    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v14    # "titleCharSeq":Ljava/lang/CharSequence;
    :catch_0
    move-exception v9

    .line 140
    .local v9, "exception":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v2, 0x0

    goto :goto_0

    .line 152
    .end local v9    # "exception":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v6    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v14    # "titleCharSeq":Ljava/lang/CharSequence;
    :cond_2
    const-string/jumbo v2, "content://com.android.launcher2.settings/favorites?notify=true"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 153
    .local v1, "contentURI":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 154
    .local v0, "resolver":Landroid/content/ContentResolver;
    const/4 v10, 0x0

    .line 155
    .local v10, "foundShortcutOnHomeScreen":Z
    const/4 v7, 0x0

    .line 157
    .local v7, "cursor":Landroid/database/Cursor;
    const/4 v2, 0x0

    :try_start_1
    const-string/jumbo v3, "title=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v13, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 159
    if-eqz v7, :cond_4

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_4

    .line 160
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 161
    sget-object v2, Lcom/amazon/mShop/util/ShortcutUtil;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "found shortcut in launcher home screen"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 164
    :cond_3
    const/4 v10, 0x1

    .line 170
    :cond_4
    if-eqz v7, :cond_5

    .line 171
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 176
    :cond_5
    :goto_1
    if-nez v10, :cond_7

    const/4 v2, 0x1

    goto :goto_0

    .line 166
    :catch_1
    move-exception v8

    .line 167
    .local v8, "e":Ljava/lang/Exception;
    const/4 v10, 0x0

    .line 168
    :try_start_2
    invoke-virtual {v8}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 170
    if-eqz v7, :cond_5

    .line 171
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 170
    .end local v8    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    if-eqz v7, :cond_6

    .line 171
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_6
    throw v2

    .line 176
    :cond_7
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static isShortcutInstalled(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 82
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->isVersionUpToDate(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 83
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->updateVersion(Landroid/content/Context;)V

    .line 87
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 88
    .local v0, "datastore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "is_shortcut_installed"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    return v1
.end method

.method private static isVersionUpToDate(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 35
    .local v2, "versionNumber":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 36
    .local v1, "datastore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "shortcut_install_current_version"

    invoke-interface {v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 37
    .local v0, "currentVersion":Ljava/lang/String;
    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 38
    const/4 v3, 0x0

    .line 40
    :goto_0
    return v3

    :cond_0
    const/4 v3, 0x1

    goto :goto_0
.end method

.method private static updateVersion(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 45
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "versionNumber":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 47
    .local v0, "datastore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "shortcut_install_current_version"

    invoke-interface {v0, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 48
    .local v1, "oldVersionNumber":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 50
    const-string/jumbo v3, "app_start_count_of_current_version"

    const/4 v4, 0x0

    invoke-interface {v0, v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 52
    :cond_0
    const-string/jumbo v3, "shortcut_install_current_version"

    invoke-interface {v0, v3, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    return-void
.end method
