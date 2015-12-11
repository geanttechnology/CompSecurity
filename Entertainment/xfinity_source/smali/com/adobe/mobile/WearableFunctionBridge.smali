.class final Lcom/adobe/mobile/WearableFunctionBridge;
.super Ljava/lang/Object;
.source "WearableFunctionBridge.java"


# static fields
.field private static configSynchronizerClassLoader:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private static wearableFunctionClassLoader:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getConfigSynchronizerClass()Ljava/lang/Class;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 47
    sget-object v2, Lcom/adobe/mobile/WearableFunctionBridge;->configSynchronizerClassLoader:Ljava/lang/Class;

    if-eqz v2, :cond_0

    .line 48
    sget-object v2, Lcom/adobe/mobile/WearableFunctionBridge;->configSynchronizerClassLoader:Ljava/lang/Class;

    .line 58
    .local v0, "classLoader":Ljava/lang/ClassLoader;
    :goto_0
    return-object v2

    .line 52
    .end local v0    # "classLoader":Ljava/lang/ClassLoader;
    :cond_0
    :try_start_0
    const-class v2, Lcom/adobe/mobile/WearableFunctionBridge;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 53
    .restart local v0    # "classLoader":Ljava/lang/ClassLoader;
    const-string v2, "com.adobe.mobile.ConfigSynchronizer"

    invoke-virtual {v0, v2}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    sput-object v2, Lcom/adobe/mobile/WearableFunctionBridge;->configSynchronizerClassLoader:Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 58
    :goto_1
    sget-object v2, Lcom/adobe/mobile/WearableFunctionBridge;->configSynchronizerClassLoader:Ljava/lang/Class;

    goto :goto_0

    .line 55
    :catch_0
    move-exception v1

    .line 56
    .local v1, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Failed to load class com.adobe.mobile.ConfigSynchronizer"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method private static getWearableFunctionClass()Ljava/lang/Class;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 30
    sget-object v2, Lcom/adobe/mobile/WearableFunctionBridge;->wearableFunctionClassLoader:Ljava/lang/Class;

    if-eqz v2, :cond_0

    .line 31
    sget-object v2, Lcom/adobe/mobile/WearableFunctionBridge;->wearableFunctionClassLoader:Ljava/lang/Class;

    .line 41
    .local v0, "classLoader":Ljava/lang/ClassLoader;
    :goto_0
    return-object v2

    .line 35
    .end local v0    # "classLoader":Ljava/lang/ClassLoader;
    :cond_0
    :try_start_0
    const-class v2, Lcom/adobe/mobile/WearableFunctionBridge;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 36
    .restart local v0    # "classLoader":Ljava/lang/ClassLoader;
    const-string v2, "com.adobe.mobile.WearableFunction"

    invoke-virtual {v0, v2}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    sput-object v2, Lcom/adobe/mobile/WearableFunctionBridge;->wearableFunctionClassLoader:Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    :goto_1
    sget-object v2, Lcom/adobe/mobile/WearableFunctionBridge;->wearableFunctionClassLoader:Ljava/lang/Class;

    goto :goto_0

    .line 38
    :catch_0
    move-exception v1

    .line 39
    .local v1, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Failed to load class com.adobe.mobile.WearableFunction"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method protected static isGooglePlayServicesEnabled()Z
    .locals 14

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 65
    :try_start_0
    const-class v10, Lcom/adobe/mobile/WearableFunctionBridge;

    invoke-virtual {v10}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    .line 66
    .local v2, "classLoader":Ljava/lang/ClassLoader;
    const-string v10, "com.google.android.gms.common.GoogleApiAvailability"

    invoke-virtual {v2, v10}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 67
    .local v0, "GoogleApiAvailabilityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v10, "getInstance"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Class;

    invoke-virtual {v0, v10, v11}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 68
    .local v4, "getInstanceMethod":Ljava/lang/reflect/Method;
    const/4 v10, 0x0

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-virtual {v4, v10, v11}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 69
    .local v5, "instance":Ljava/lang/Object;
    const-string v10, "isGooglePlayServicesAvailable"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Class;

    const/4 v12, 0x0

    const-class v13, Landroid/content/Context;

    aput-object v13, v11, v12

    invoke-virtual {v0, v10, v11}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v6

    .line 70
    .local v6, "isGooglePlayServicesAvailableMethod":Ljava/lang/reflect/Method;
    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedContext()Landroid/content/Context;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v6, v5, v10}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 71
    .local v7, "result":Ljava/lang/Object;
    instance-of v10, v7, Ljava/lang/Integer;

    if-eqz v10, :cond_2

    .line 73
    check-cast v7, Ljava/lang/Integer;

    .end local v7    # "result":Ljava/lang/Object;
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    move-result v10

    if-nez v10, :cond_1

    .line 103
    .end local v0    # "GoogleApiAvailabilityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "getInstanceMethod":Ljava/lang/reflect/Method;
    .end local v5    # "instance":Ljava/lang/Object;
    .end local v6    # "isGooglePlayServicesAvailableMethod":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    return v8

    .restart local v0    # "GoogleApiAvailabilityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v4    # "getInstanceMethod":Ljava/lang/reflect/Method;
    .restart local v5    # "instance":Ljava/lang/Object;
    .restart local v6    # "isGooglePlayServicesAvailableMethod":Ljava/lang/reflect/Method;
    :cond_1
    move v8, v9

    .line 73
    goto :goto_0

    .line 76
    .end local v0    # "GoogleApiAvailabilityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "getInstanceMethod":Ljava/lang/reflect/Method;
    .end local v5    # "instance":Ljava/lang/Object;
    .end local v6    # "isGooglePlayServicesAvailableMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v3

    .line 78
    .local v3, "e":Ljava/lang/IllegalStateException;
    const-string v10, "Wearable - Google Play Services is not enabled in your app\'s AndroidManifest.xml"

    new-array v11, v8, [Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/IllegalStateException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v11, v9

    invoke-static {v10, v11}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 87
    .end local v3    # "e":Ljava/lang/IllegalStateException;
    :cond_2
    :goto_1
    :try_start_1
    const-class v10, Lcom/adobe/mobile/WearableFunctionBridge;

    invoke-virtual {v10}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    .line 88
    const-string v10, "com.google.android.gms.common.GooglePlayServicesUtil"

    invoke-virtual {v2, v10}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 89
    .local v1, "GooglePlayServicesUtilClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v10, "isGooglePlayServicesAvailable"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Class;

    const/4 v12, 0x0

    const-class v13, Landroid/content/Context;

    aput-object v13, v11, v12

    invoke-virtual {v1, v10, v11}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v6

    .line 90
    .restart local v6    # "isGooglePlayServicesAvailableMethod":Ljava/lang/reflect/Method;
    const/4 v10, 0x0

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedContext()Landroid/content/Context;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-virtual {v6, v10, v11}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 91
    .restart local v7    # "result":Ljava/lang/Object;
    instance-of v10, v7, Ljava/lang/Integer;

    if-eqz v10, :cond_3

    .line 93
    check-cast v7, Ljava/lang/Integer;

    .end local v7    # "result":Ljava/lang/Object;
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    move-result v10

    if-eqz v10, :cond_0

    move v8, v9

    goto :goto_0

    .line 96
    .end local v1    # "GooglePlayServicesUtilClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v6    # "isGooglePlayServicesAvailableMethod":Ljava/lang/reflect/Method;
    :catch_1
    move-exception v3

    .line 97
    .restart local v3    # "e":Ljava/lang/IllegalStateException;
    const-string v10, "Wearable - Google Play Services is not enabled in your app\'s AndroidManifest.xml"

    new-array v8, v8, [Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/IllegalStateException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v8, v9

    invoke-static {v10, v8}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .end local v3    # "e":Ljava/lang/IllegalStateException;
    :cond_3
    :goto_2
    move v8, v9

    .line 103
    goto :goto_0

    .line 98
    :catch_2
    move-exception v8

    goto :goto_2

    .line 80
    :catch_3
    move-exception v10

    goto :goto_1
.end method

.method protected static retrieveData(Ljava/lang/String;I)[B
    .locals 11
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "readTimeout"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 136
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getWearableFunctionClass()Ljava/lang/Class;

    move-result-object v4

    const-string v5, "retrieveData"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Class;

    const/4 v7, 0x0

    const-class v8, Ljava/lang/String;

    aput-object v8, v6, v7

    const/4 v7, 0x1

    sget-object v8, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 137
    .local v2, "retrieveDataMethod":Ljava/lang/reflect/Method;
    const/4 v4, 0x0

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p0, v5, v6

    const/4 v6, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v2, v4, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 138
    .local v1, "result":Ljava/lang/Object;
    instance-of v4, v1, [B

    if-eqz v4, :cond_0

    .line 139
    check-cast v1, [B

    .end local v1    # "result":Ljava/lang/Object;
    check-cast v1, [B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 144
    .end local v2    # "retrieveDataMethod":Ljava/lang/reflect/Method;
    :goto_0
    return-object v1

    .line 141
    :catch_0
    move-exception v0

    .line 142
    .local v0, "e":Ljava/lang/Exception;
    const-string v4, "Wearable - Error sending request (%s)"

    new-array v5, v10, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v9

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    move-object v1, v3

    .line 144
    goto :goto_0
.end method

.method protected static sendAnalyticsRequest(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z
    .locals 11
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "postBody"    # Ljava/lang/String;
    .param p2, "timeout"    # I
    .param p3, "logPrefix"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x1

    const/4 v5, 0x0

    .line 149
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getWearableFunctionClass()Ljava/lang/Class;

    move-result-object v4

    const-string v6, "sendAnalyticsRequest"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    const-class v9, Ljava/lang/String;

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-class v9, Ljava/lang/String;

    aput-object v9, v7, v8

    const/4 v8, 0x2

    sget-object v9, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v9, v7, v8

    invoke-virtual {v4, v6, v7}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 150
    .local v3, "sendAnalyticsRequestMethod":Ljava/lang/reflect/Method;
    const/4 v4, 0x0

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p0, v6, v7

    const/4 v7, 0x1

    aput-object p1, v6, v7

    const/4 v7, 0x2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v3, v4, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 151
    .local v2, "result":Ljava/lang/Object;
    instance-of v4, v2, Ljava/lang/Boolean;

    if-eqz v4, :cond_1

    .line 152
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v4, v0

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 153
    const-string v4, "%s - Request Sent(%s)"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p3, v6, v7

    const/4 v7, 0x1

    aput-object p1, v6, v7

    invoke-static {v4, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 157
    :goto_0
    check-cast v2, Ljava/lang/Boolean;

    .end local v2    # "result":Ljava/lang/Object;
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    .line 162
    .end local v3    # "sendAnalyticsRequestMethod":Ljava/lang/reflect/Method;
    :goto_1
    return v4

    .line 155
    .restart local v2    # "result":Ljava/lang/Object;
    .restart local v3    # "sendAnalyticsRequestMethod":Ljava/lang/reflect/Method;
    :cond_0
    const-string v4, "%s - Failed to sent request(%s)"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p3, v6, v7

    const/4 v7, 0x1

    aput-object p1, v6, v7

    invoke-static {v4, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 159
    .end local v2    # "result":Ljava/lang/Object;
    .end local v3    # "sendAnalyticsRequestMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v1

    .line 160
    .local v1, "e":Ljava/lang/Exception;
    const-string v4, "Wearable - Error sending request (%s)"

    new-array v6, v10, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v5

    invoke-static {v4, v6}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    move v4, v5

    .line 162
    goto :goto_1
.end method

.method protected static sendGenericRequest(Ljava/lang/String;ILjava/lang/String;)V
    .locals 9
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "timeout"    # I
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 125
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getWearableFunctionClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "sendGenericRequest"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 126
    .local v1, "sendGenericRequestMethod":Ljava/lang/reflect/Method;
    const/4 v2, 0x0

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    const-string v2, "%s - Request Sent(%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 132
    .end local v1    # "sendGenericRequestMethod":Ljava/lang/reflect/Method;
    :goto_0
    return-void

    .line 128
    :catch_0
    move-exception v0

    .line 129
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Error sending request (%s)"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static sendThirdPartyRequest(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z
    .locals 11
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "postBody"    # Ljava/lang/String;
    .param p2, "timeout"    # I
    .param p3, "postType"    # Ljava/lang/String;
    .param p4, "logPrefix"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x1

    const/4 v5, 0x0

    .line 167
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getWearableFunctionClass()Ljava/lang/Class;

    move-result-object v4

    const-string v6, "sendThirdPartyRequest"

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    const-class v9, Ljava/lang/String;

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-class v9, Ljava/lang/String;

    aput-object v9, v7, v8

    const/4 v8, 0x2

    sget-object v9, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v9, v7, v8

    const/4 v8, 0x3

    const-class v9, Ljava/lang/String;

    aput-object v9, v7, v8

    invoke-virtual {v4, v6, v7}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 168
    .local v3, "sendThirdPartyRequestMethod":Ljava/lang/reflect/Method;
    const/4 v4, 0x0

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p0, v6, v7

    const/4 v7, 0x1

    aput-object p1, v6, v7

    const/4 v7, 0x2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x3

    aput-object p3, v6, v7

    invoke-virtual {v3, v4, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 169
    .local v2, "result":Ljava/lang/Object;
    instance-of v4, v2, Ljava/lang/Boolean;

    if-eqz v4, :cond_1

    .line 170
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v4, v0

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 171
    const-string v4, "%s - Successfully forwarded hit (url:%s body:%s contentType:%s)"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p4, v6, v7

    const/4 v7, 0x1

    aput-object p0, v6, v7

    const/4 v7, 0x2

    aput-object p1, v6, v7

    const/4 v7, 0x3

    aput-object p3, v6, v7

    invoke-static {v4, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 175
    :goto_0
    check-cast v2, Ljava/lang/Boolean;

    .end local v2    # "result":Ljava/lang/Object;
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    .line 181
    .end local v3    # "sendThirdPartyRequestMethod":Ljava/lang/reflect/Method;
    :goto_1
    return v4

    .line 173
    .restart local v2    # "result":Ljava/lang/Object;
    .restart local v3    # "sendThirdPartyRequestMethod":Ljava/lang/reflect/Method;
    :cond_0
    const-string v4, "%s - Failed to forwarded hit (url:%s body:%s contentType:%s)"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p4, v6, v7

    const/4 v7, 0x1

    aput-object p0, v6, v7

    const/4 v7, 0x2

    aput-object p1, v6, v7

    const/4 v7, 0x3

    aput-object p3, v6, v7

    invoke-static {v4, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 178
    .end local v2    # "result":Ljava/lang/Object;
    .end local v3    # "sendThirdPartyRequestMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v1

    .line 179
    .local v1, "e":Ljava/lang/Exception;
    const-string v4, "Wearable - Error sending request (%s)"

    new-array v6, v10, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v5

    invoke-static {v4, v6}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    move v4, v5

    .line 181
    goto :goto_1
.end method

.method protected static shouldSendHit()Z
    .locals 8

    .prologue
    const/4 v3, 0x1

    const/4 v7, 0x0

    .line 108
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v4

    if-nez v4, :cond_1

    .line 120
    .local v2, "shouldSendHitMethod":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    return v3

    .line 112
    .end local v2    # "shouldSendHitMethod":Ljava/lang/reflect/Method;
    :cond_1
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getWearableFunctionClass()Ljava/lang/Class;

    move-result-object v4

    const-string v5, "shouldSendHit"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Class;

    invoke-virtual {v4, v5, v6}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 113
    .restart local v2    # "shouldSendHitMethod":Ljava/lang/reflect/Method;
    const/4 v4, 0x0

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v2, v4, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 114
    .local v1, "result":Ljava/lang/Object;
    instance-of v4, v1, Ljava/lang/Boolean;

    if-eqz v4, :cond_0

    .line 115
    check-cast v1, Ljava/lang/Boolean;

    .end local v1    # "result":Ljava/lang/Object;
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    goto :goto_0

    .line 117
    :catch_0
    move-exception v0

    .line 118
    .local v0, "e":Ljava/lang/Exception;
    const-string v4, "Wearable - Error checking status of handheld app (%s)"

    new-array v5, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static syncAdvertisingIdentifierToWearable(Ljava/lang/String;)V
    .locals 9
    .param p0, "adid"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 198
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->mobileUsingGooglePlayServices()Z

    move-result v2

    if-nez v2, :cond_1

    .line 207
    :cond_0
    :goto_0
    return-void

    .line 202
    :cond_1
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getConfigSynchronizerClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "syncAdvertisingIdentifier"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 203
    .local v1, "syncAdidMethod":Ljava/lang/reflect/Method;
    const/4 v2, 0x0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 204
    .end local v1    # "syncAdidMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v0

    .line 205
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Unable to sync advertisingIdentifier id (%s)"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static syncConfigFromHandheld()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 249
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v2

    if-nez v2, :cond_0

    .line 258
    .local v1, "syncConfigFromHandheldMethod":Ljava/lang/reflect/Method;
    :goto_0
    return-void

    .line 253
    .end local v1    # "syncConfigFromHandheldMethod":Ljava/lang/reflect/Method;
    :cond_0
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getConfigSynchronizerClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "syncConfigFromHandheld"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Class;

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 254
    .restart local v1    # "syncConfigFromHandheldMethod":Ljava/lang/reflect/Method;
    const/4 v2, 0x0

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 255
    :catch_0
    move-exception v0

    .line 256
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Unable to sync config (%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static syncPrivacyStatusToWearable(I)V
    .locals 9
    .param p0, "privacyStatus"    # I

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 236
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->mobileUsingGooglePlayServices()Z

    move-result v2

    if-nez v2, :cond_1

    .line 245
    :cond_0
    :goto_0
    return-void

    .line 240
    :cond_1
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getConfigSynchronizerClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "syncPrivacyStatus"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 241
    .local v1, "syncPrivacyStatusMethod":Ljava/lang/reflect/Method;
    const/4 v2, 0x0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 242
    .end local v1    # "syncPrivacyStatusMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v0

    .line 243
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Unable to sync privacy status (%s)"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static syncPushEnabledToWearable(Z)V
    .locals 9
    .param p0, "enabled"    # Z

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 210
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->mobileUsingGooglePlayServices()Z

    move-result v2

    if-nez v2, :cond_1

    .line 219
    :cond_0
    :goto_0
    return-void

    .line 214
    :cond_1
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getConfigSynchronizerClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "syncPushEnabled"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    sget-object v6, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 215
    .local v1, "syncPushStatusMethod":Ljava/lang/reflect/Method;
    const/4 v2, 0x0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 216
    .end local v1    # "syncPushStatusMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v0

    .line 217
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Unable to sync push enabled status (%s)"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static syncVidServiceToWearable(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V
    .locals 9
    .param p0, "mid"    # Ljava/lang/String;
    .param p1, "hint"    # Ljava/lang/String;
    .param p2, "blob"    # Ljava/lang/String;
    .param p3, "ssl"    # J
    .param p5, "lastSync"    # J

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 223
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->mobileUsingGooglePlayServices()Z

    move-result v2

    if-nez v2, :cond_1

    .line 232
    :cond_0
    :goto_0
    return-void

    .line 227
    :cond_1
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getConfigSynchronizerClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "syncVidService"

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-class v6, Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-class v6, Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x3

    sget-object v6, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    const/4 v5, 0x4

    sget-object v6, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 228
    .local v1, "syncVidServiceMethod":Ljava/lang/reflect/Method;
    const/4 v2, 0x0

    const/4 v3, 0x5

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    const/4 v4, 0x2

    aput-object p2, v3, v4

    const/4 v4, 0x3

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x4

    invoke-static {p5, p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 229
    .end local v1    # "syncVidServiceMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v0

    .line 230
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Unable to sync visitor id service (%s)"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static syncVisitorIDToWearable(Ljava/lang/String;)V
    .locals 9
    .param p0, "vid"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 185
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/MobileConfig;->mobileUsingGooglePlayServices()Z

    move-result v2

    if-nez v2, :cond_1

    .line 195
    :cond_0
    :goto_0
    return-void

    .line 190
    :cond_1
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/WearableFunctionBridge;->getConfigSynchronizerClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "syncVisitorID"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 191
    .local v1, "syncVisitorIDMethod":Ljava/lang/reflect/Method;
    const/4 v2, 0x0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 192
    .end local v1    # "syncVisitorIDMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v0

    .line 193
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Wearable - Unable to sync visitor id (%s)"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
