.class public Lcom/amazon/mShop/share/SharableAppInfoManager;
.super Ljava/lang/Object;
.source "SharableAppInfoManager.java"


# static fields
.field private static sAppInfoList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/mShop/share/SharableAppInfo;",
            ">;"
        }
    .end annotation
.end field

.field private static sInterestedApps:I

.field private static sPackageName:Ljava/lang/String;

.field private static sStaticAppConfigs:Ljava/util/Map;
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

.field private static sTimelineIconAdded:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 18
    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getStaticConfig()Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/share/SharableAppInfoManager;->sStaticAppConfigs:Ljava/util/Map;

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/share/SharableAppInfoManager;->sAppInfoList:Ljava/util/ArrayList;

    .line 20
    sput v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sInterestedApps:I

    .line 21
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/share/SharableAppInfoManager;->sPackageName:Ljava/lang/String;

    .line 22
    sput-boolean v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sTimelineIconAdded:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static collectAppInfo(Landroid/app/Activity;)Ljava/util/List;
    .locals 15
    .param p0, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/share/SharableAppInfo;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 30
    sget-object v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sAppInfoList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 31
    sget-object v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sAppInfoList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 32
    sput v2, Lcom/amazon/mShop/share/SharableAppInfoManager;->sInterestedApps:I

    .line 33
    sput-boolean v2, Lcom/amazon/mShop/share/SharableAppInfoManager;->sTimelineIconAdded:Z

    .line 36
    :cond_0
    new-instance v13, Landroid/content/Intent;

    const-string/jumbo v1, "android.intent.action.SEND"

    invoke-direct {v13, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 37
    .local v13, "shareIntent":Landroid/content/Intent;
    const-string/jumbo v1, "text/plain"

    invoke-virtual {v13, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 38
    invoke-virtual {p0}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v11

    .line 39
    .local v11, "packageManager":Landroid/content/pm/PackageManager;
    invoke-virtual {v11, v13, v2}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v12

    .line 41
    .local v12, "resolveInfoList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v12}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_1
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ResolveInfo;

    .line 44
    .local v6, "resolveInfo":Landroid/content/pm/ResolveInfo;
    iget-object v1, v6, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v1, v1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getWechatAddFavoriteActivityName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 48
    iget-object v1, v6, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v3, v1, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    .line 49
    .local v3, "packageName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getDefaultRefTag()Ljava/lang/String;

    move-result-object v4

    .line 50
    .local v4, "refTag":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getDefaultPriority()I

    move-result v5

    .line 53
    .local v5, "priority":I
    sget-object v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sStaticAppConfigs:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 54
    .local v10, "packageKey":Ljava/lang/String;
    invoke-virtual {v3, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 55
    sget-object v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sStaticAppConfigs:Ljava/util/Map;

    invoke-interface {v1, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/mShop/share/SocialAppConfig;

    .line 56
    .local v7, "config":Lcom/amazon/mShop/share/SocialAppConfig;
    invoke-virtual {v7}, Lcom/amazon/mShop/share/SocialAppConfig;->getRefTag()Ljava/lang/String;

    move-result-object v4

    .line 57
    invoke-virtual {v7}, Lcom/amazon/mShop/share/SocialAppConfig;->getPriority()I

    move-result v5

    goto :goto_1

    .line 63
    .end local v7    # "config":Lcom/amazon/mShop/share/SocialAppConfig;
    .end local v10    # "packageKey":Ljava/lang/String;
    :cond_3
    new-instance v0, Lcom/amazon/mShop/share/SharableAppInfo;

    invoke-virtual {v6, v11}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/share/SharableAppInfo;-><init>(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;ILandroid/content/pm/ResolveInfo;)V

    .line 69
    .local v0, "appInfo":Lcom/amazon/mShop/share/SharableAppInfo;
    sget-object v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sAppInfoList:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 71
    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getDefaultPriority()I

    move-result v1

    if-eq v5, v1, :cond_4

    .line 72
    sget v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sInterestedApps:I

    add-int/lit8 v1, v1, 0x1

    sput v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sInterestedApps:I

    .line 81
    :cond_4
    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getWechatPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {p0}, Lcom/amazon/mShop/share/WechatSDKManager;->timelineSupported(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-boolean v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sTimelineIconAdded:Z

    if-nez v1, :cond_1

    invoke-static {p0}, Lcom/amazon/mShop/share/SharableAppInfoManager;->isCnMshopPackage(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 84
    invoke-static {p0, v6}, Lcom/amazon/mShop/share/SocialAppConfig;->buildWechatTimelineInfo(Landroid/content/Context;Landroid/content/pm/ResolveInfo;)Lcom/amazon/mShop/share/SharableAppInfo;

    move-result-object v14

    .line 85
    .local v14, "timelineConfig":Lcom/amazon/mShop/share/SharableAppInfo;
    if-eqz v14, :cond_1

    .line 86
    sget-object v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sAppInfoList:Ljava/util/ArrayList;

    invoke-virtual {v1, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 87
    sget v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sInterestedApps:I

    add-int/lit8 v1, v1, 0x1

    sput v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sInterestedApps:I

    .line 88
    const/4 v1, 0x1

    sput-boolean v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sTimelineIconAdded:Z

    goto/16 :goto_0

    .line 92
    .end local v0    # "appInfo":Lcom/amazon/mShop/share/SharableAppInfo;
    .end local v3    # "packageName":Ljava/lang/String;
    .end local v4    # "refTag":Ljava/lang/String;
    .end local v5    # "priority":I
    .end local v6    # "resolveInfo":Landroid/content/pm/ResolveInfo;
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v14    # "timelineConfig":Lcom/amazon/mShop/share/SharableAppInfo;
    :cond_5
    sget-object v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sAppInfoList:Ljava/util/ArrayList;

    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 93
    sget-object v1, Lcom/amazon/mShop/share/SharableAppInfoManager;->sAppInfoList:Ljava/util/ArrayList;

    return-object v1
.end method

.method public static getNumberOfInterestedApps()I
    .locals 1

    .prologue
    .line 131
    sget v0, Lcom/amazon/mShop/share/SharableAppInfoManager;->sInterestedApps:I

    return v0
.end method

.method public static isCnMshopPackage(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 135
    sget-object v0, Lcom/amazon/mShop/share/SharableAppInfoManager;->sPackageName:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 136
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/share/SharableAppInfoManager;->sPackageName:Ljava/lang/String;

    .line 138
    :cond_0
    sget-object v0, Lcom/amazon/mShop/share/SharableAppInfoManager;->sPackageName:Ljava/lang/String;

    const-string/jumbo v1, "cn.amazon.mShop.android"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static logClickRefMarker(Lcom/amazon/mShop/share/SharableAppInfo;)V
    .locals 4
    .param p0, "appInfo"    # Lcom/amazon/mShop/share/SharableAppInfo;

    .prologue
    .line 121
    const/4 v0, 0x0

    .line 122
    .local v0, "clickRefFormat":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/share/SharableAppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getEmailPackageId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 123
    const-string/jumbo v0, "cm_:sw_em_cl_%1s"

    .line 127
    :goto_0
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/amazon/mShop/share/SharableAppInfo;->getRefTag()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 128
    return-void

    .line 125
    :cond_0
    const-string/jumbo v0, "cm_:sw_cl_%1s"

    goto :goto_0
.end method

.method public static replaceRefMarker(Landroid/content/Intent;Lcom/amazon/mShop/share/SharableAppInfo;)V
    .locals 7
    .param p0, "targetIntent"    # Landroid/content/Intent;
    .param p1, "appInfo"    # Lcom/amazon/mShop/share/SharableAppInfo;

    .prologue
    const/4 v6, 0x0

    .line 98
    const-string/jumbo v4, "android.intent.extra.TEXT"

    invoke-virtual {p0, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 99
    .local v1, "originalContent":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 118
    :cond_0
    :goto_0
    return-void

    .line 102
    :cond_1
    const-string/jumbo v2, "ref=cm_sw_r_"

    .line 103
    .local v2, "refMarkerPattern":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    if-lez v4, :cond_0

    .line 105
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v1, v6, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 107
    .local v0, "newContent":Ljava/lang/StringBuilder;
    const-string/jumbo v4, "ref="

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 108
    const/4 v3, 0x0

    .line 109
    .local v3, "returnRefFormat":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/mShop/share/SharableAppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getEmailPackageId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 110
    const-string/jumbo v3, "cm_sw_em_r_%1s"

    .line 114
    :goto_1
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/amazon/mShop/share/SharableAppInfo;->getRefTag()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    const-string/jumbo v4, "?ie=UTF8"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 116
    const-string/jumbo v4, "android.intent.extra.TEXT"

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 112
    :cond_2
    const-string/jumbo v3, "cm_sw_r_%1s"

    goto :goto_1
.end method
