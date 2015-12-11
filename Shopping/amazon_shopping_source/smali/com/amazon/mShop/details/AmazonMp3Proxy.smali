.class public Lcom/amazon/mShop/details/AmazonMp3Proxy;
.super Lcom/amazon/mShop/details/FriendAppProxy;
.source "AmazonMp3Proxy.java"


# static fields
.field private static final instance:Lcom/amazon/mShop/details/AmazonMp3Proxy;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    new-instance v0, Lcom/amazon/mShop/details/AmazonMp3Proxy;

    invoke-direct {v0}, Lcom/amazon/mShop/details/AmazonMp3Proxy;-><init>()V

    sput-object v0, Lcom/amazon/mShop/details/AmazonMp3Proxy;->instance:Lcom/amazon/mShop/details/AmazonMp3Proxy;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/amazon/mShop/details/FriendAppProxy;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/details/AmazonMp3Proxy;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/amazon/mShop/details/AmazonMp3Proxy;->instance:Lcom/amazon/mShop/details/AmazonMp3Proxy;

    return-object v0
.end method


# virtual methods
.method public getButtonLabel(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 108
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonMp3Proxy;->isFriendAppInstalled(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 109
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonMp3Proxy;->needFriendAppUpdate(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->buy_box_update_amazon_mp3_to_buy:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 115
    :goto_0
    return-object v0

    .line 112
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->buy_box_buy_now_from_amazon_mp3:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 115
    :cond_1
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->buy_box_install_amazon_mp3_to_buy:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected getIntentForStart(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "product"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 51
    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getGroupId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/details/AmazonMp3Proxy;->getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method protected getIntentForStart(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 87
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 88
    .local v3, "uri":Landroid/net/Uri;
    const-string/jumbo v4, "asin"

    invoke-virtual {v3, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 89
    .local v0, "asin":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 91
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->error_can_not_find_product:I

    invoke-static {p1, v4}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 92
    const/4 v4, 0x0

    .line 103
    :goto_0
    return-object v4

    .line 94
    :cond_0
    const-string/jumbo v4, "type"

    invoke-virtual {v3, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 95
    .local v2, "type":Ljava/lang/String;
    const/4 v1, 0x0

    .line 96
    .local v1, "groupId":Ljava/lang/String;
    const-string/jumbo v4, "album"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 97
    const-string/jumbo v1, "digital_music_album_display_on_website"

    .line 103
    :goto_1
    invoke-virtual {p0, p1, v1, v0}, Lcom/amazon/mShop/details/AmazonMp3Proxy;->getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v4

    goto :goto_0

    .line 98
    :cond_1
    const-string/jumbo v4, "track"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 99
    const-string/jumbo v1, "digital_music_track_display_on_website"

    goto :goto_1

    .line 101
    :cond_2
    const-string/jumbo v1, "digital_music_artist_display_on_website"

    goto :goto_1
.end method

.method public getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "groupId"    # Ljava/lang/String;
    .param p3, "asin"    # Ljava/lang/String;

    .prologue
    .line 65
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 66
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "digital_music_album_display_on_website"

    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 68
    const-string/jumbo v1, "com.amazon.mp3.action.EXTERNAL_EVENT"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 69
    const-string/jumbo v1, "com.amazon.mp3.extra.EXTERNAL_EVENT_TYPE"

    const-string/jumbo v2, "com.amazon.mp3.type.SHOW_ALBUM_DETAIL"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 70
    const-string/jumbo v1, "com.amazon.mp3.extra.ALBUM_ASIN"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 78
    :goto_0
    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/details/AmazonMp3Proxy;->addRefTag(Landroid/content/Context;Landroid/content/Intent;)V

    .line 79
    return-object v0

    .line 73
    :cond_0
    const-string/jumbo v1, "com.amazon.mp3.action.EXTERNAL_EVENT"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 74
    const-string/jumbo v1, "com.amazon.mp3.extra.EXTERNAL_EVENT_TYPE"

    const-string/jumbo v2, "com.amazon.mp3.type.SEARCH"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 75
    const-string/jumbo v1, "com.amazon.mp3.extra.SEARCH_STRING"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 76
    const-string/jumbo v1, "com.amazon.mp3.extra.SEARCH_TYPE"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    goto :goto_0
.end method

.method protected getPackageName(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 46
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->amazon_mp3_package_name:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    const-string/jumbo v0, "mp3"

    return-object v0
.end method

.method protected needFriendAppUpdate(Landroid/content/Context;)Z
    .locals 13
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 135
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 136
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonMp3Proxy;->getPackageName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    .line 140
    .local v5, "packageName":Ljava/lang/String;
    const/4 v3, 0x0

    .line 142
    .local v3, "m":Ljava/lang/reflect/Method;
    :try_start_0
    const-class v8, Landroid/content/Intent;

    const-string/jumbo v9, "setPackage"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Class;

    const/4 v11, 0x0

    const-class v12, Ljava/lang/String;

    aput-object v12, v10, v11

    invoke-virtual {v8, v9, v10}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    .line 148
    :goto_0
    if-eqz v3, :cond_0

    .line 150
    const/4 v8, 0x1

    :try_start_1
    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v5, v8, v9

    invoke-virtual {v3, v2, v8}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_1} :catch_4

    .line 159
    :cond_0
    :goto_1
    const-string/jumbo v8, "com.amazon.mp3.action.EXTERNAL_EVENT"

    invoke-virtual {v2, v8}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 160
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 161
    .local v4, "manager":Landroid/content/pm/PackageManager;
    const/16 v8, 0x40

    invoke-virtual {v4, v2, v8}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 162
    .local v0, "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v8

    if-lez v8, :cond_1

    .line 165
    :goto_2
    return v6

    .line 143
    .end local v0    # "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    .end local v4    # "manager":Landroid/content/pm/PackageManager;
    :catch_0
    move-exception v1

    .line 144
    .local v1, "e":Ljava/lang/SecurityException;
    const-string/jumbo v8, "AmazonMp3Proxy.needFriendAppUpdate"

    invoke-virtual {v1}, Ljava/lang/SecurityException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 145
    .end local v1    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v1

    .line 146
    .local v1, "e":Ljava/lang/NoSuchMethodException;
    const-string/jumbo v8, "AmazonMp3Proxy.needFriendAppUpdate"

    invoke-virtual {v1}, Ljava/lang/NoSuchMethodException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 151
    .end local v1    # "e":Ljava/lang/NoSuchMethodException;
    :catch_2
    move-exception v1

    .line 152
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    const-string/jumbo v8, "AmazonMp3Proxy.needFriendAppUpdate"

    invoke-virtual {v1}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 153
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    :catch_3
    move-exception v1

    .line 154
    .local v1, "e":Ljava/lang/IllegalAccessException;
    const-string/jumbo v8, "AmazonMp3Proxy.needFriendAppUpdate"

    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 155
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    :catch_4
    move-exception v1

    .line 156
    .local v1, "e":Ljava/lang/reflect/InvocationTargetException;
    const-string/jumbo v8, "AmazonMp3Proxy.needFriendAppUpdate"

    invoke-virtual {v1}, Ljava/lang/reflect/InvocationTargetException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .end local v1    # "e":Ljava/lang/reflect/InvocationTargetException;
    .restart local v0    # "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    .restart local v4    # "manager":Landroid/content/pm/PackageManager;
    :cond_1
    move v6, v7

    .line 165
    goto :goto_2
.end method
