.class public Lco/vine/android/util/ClientFlagsHelper;
.super Ljava/lang/Object;
.source "ClientFlagsHelper.java"


# static fields
.field public static final CLIENTFLAGS_THROTTLE:J = 0x493e0L

.field public static final PREF_API_HOST:Ljava/lang/String; = "client_flags_api_host"

.field public static final PREF_CLIENT_FLAGS_LAST_CHANGED:Ljava/lang/String; = "client_flags_last_changed_millis"

.field public static final PREF_CLIENT_FLAGS_LAST_CHECKED:Ljava/lang/String; = "client_flags_last_checked_millis"

.field public static final PREF_CLIENT_FLAGS_TTL:Ljava/lang/String; = "client_flags_ttl"

.field public static final PREF_EXPLORE_HOST:Ljava/lang/String; = "client_flags_explore_host"

.field public static final PREF_MEDIA_HOST:Ljava/lang/String; = "client_flags_media_host"

.field public static final PREF_MESSAGE_TEXT:Ljava/lang/String; = "client_flags_message_text"

.field public static final PREF_MESSAGE_TITLE:Ljava/lang/String; = "client_flags_message_title"

.field public static final PREF_RTC_HOST:Ljava/lang/String; = "client_flags_rtc_host"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLastCheckMillis(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 50
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "client_flags_last_checked_millis"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public static hostsDidChange(Landroid/content/Context;Lco/vine/android/api/VineClientFlags;)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "clientFlags"    # Lco/vine/android/api/VineClientFlags;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    const/4 v7, 0x0

    const/4 v5, 0x1

    .line 59
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 60
    .local v3, "prefs":Landroid/content/SharedPreferences;
    const-string v6, "client_flags_api_host"

    invoke-interface {v3, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, "apiHost":Ljava/lang/String;
    const-string v6, "client_flags_rtc_host"

    invoke-interface {v3, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 62
    .local v4, "rtcHost":Ljava/lang/String;
    const-string v6, "client_flags_media_host"

    invoke-interface {v3, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 63
    .local v2, "mediaHost":Ljava/lang/String;
    const-string v6, "client_flags_explore_host"

    invoke-interface {v3, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 65
    .local v1, "exploreHost":Ljava/lang/String;
    if-eqz v0, :cond_1

    iget-object v6, p1, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 74
    :cond_0
    :goto_0
    return v5

    .line 65
    :cond_1
    iget-object v6, p1, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    if-nez v6, :cond_0

    .line 67
    :cond_2
    if-eqz v4, :cond_6

    iget-object v6, p1, Lco/vine/android/api/VineClientFlags;->rtcHost:Ljava/lang/String;

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 69
    :cond_3
    if-eqz v2, :cond_7

    iget-object v6, p1, Lco/vine/android/api/VineClientFlags;->mediaHost:Ljava/lang/String;

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 71
    :cond_4
    if-eqz v1, :cond_8

    iget-object v6, p1, Lco/vine/android/api/VineClientFlags;->exploreHost:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 74
    :cond_5
    const/4 v5, 0x0

    goto :goto_0

    .line 67
    :cond_6
    iget-object v6, p1, Lco/vine/android/api/VineClientFlags;->rtcHost:Ljava/lang/String;

    if-eqz v6, :cond_3

    goto :goto_0

    .line 69
    :cond_7
    iget-object v6, p1, Lco/vine/android/api/VineClientFlags;->mediaHost:Ljava/lang/String;

    if-eqz v6, :cond_4

    goto :goto_0

    .line 71
    :cond_8
    iget-object v6, p1, Lco/vine/android/api/VineClientFlags;->exploreHost:Ljava/lang/String;

    if-eqz v6, :cond_5

    goto :goto_0
.end method

.method public static isClientFlagsTtlInRange(Landroid/content/Context;)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const-wide/16 v6, 0x0

    .line 29
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 30
    .local v2, "prefs":Landroid/content/SharedPreferences;
    const-string v5, "client_flags_last_changed_millis"

    invoke-interface {v2, v5, v6, v7}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    .line 31
    .local v0, "lastChangedMillis":J
    const-string v5, "client_flags_ttl"

    invoke-interface {v2, v5, v6, v7}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v3

    .line 32
    .local v3, "ttlMillis":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    sub-long/2addr v5, v0

    cmp-long v5, v5, v3

    if-gez v5, :cond_0

    const/4 v5, 0x1

    :goto_0
    return v5

    :cond_0
    const/4 v5, 0x0

    goto :goto_0
.end method

.method public static setLastCheckMillis(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 54
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "client_flags_last_checked_millis"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 56
    return-void
.end method

.method public static shouldShowClientFlagsBanner(Landroid/content/Context;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x0

    .line 78
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 79
    .local v2, "prefs":Landroid/content/SharedPreferences;
    const-string v3, "client_flags_message_title"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 80
    .local v1, "messageTitle":Ljava/lang/String;
    const-string v3, "client_flags_message_text"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "messageText":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    :cond_0
    const/4 v3, 0x1

    :goto_0
    return v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static updateClientFlags(Landroid/content/Context;Lco/vine/android/api/VineClientFlags;)V
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "clientFlags"    # Lco/vine/android/api/VineClientFlags;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 36
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 37
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    iget-wide v3, p1, Lco/vine/android/api/VineClientFlags;->ttlSeconds:J

    const-wide/16 v5, 0x3e8

    mul-long v1, v3, v5

    .line 38
    .local v1, "ttlMillis":J
    const-string v3, "client_flags_ttl"

    invoke-interface {v0, v3, v1, v2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 39
    const-string v3, "client_flags_last_changed_millis"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-interface {v0, v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 40
    const-string v3, "client_flags_message_title"

    iget-object v4, p1, Lco/vine/android/api/VineClientFlags;->messageTitle:Ljava/lang/String;

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 41
    const-string v3, "client_flags_message_text"

    iget-object v4, p1, Lco/vine/android/api/VineClientFlags;->messageText:Ljava/lang/String;

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 42
    const-string v3, "client_flags_api_host"

    iget-object v4, p1, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 43
    const-string v3, "client_flags_rtc_host"

    iget-object v4, p1, Lco/vine/android/api/VineClientFlags;->rtcHost:Ljava/lang/String;

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 44
    const-string v3, "client_flags_media_host"

    iget-object v4, p1, Lco/vine/android/api/VineClientFlags;->mediaHost:Ljava/lang/String;

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 45
    const-string v3, "client_flags_explore_host"

    iget-object v4, p1, Lco/vine/android/api/VineClientFlags;->exploreHost:Ljava/lang/String;

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 46
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 47
    return-void
.end method

.method public static zeroRatingIsEnabled(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 90
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 91
    .local v1, "prefs":Landroid/content/SharedPreferences;
    const-string v2, "client_flags_api_host"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 92
    .local v0, "apiHost":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method
