.class public final Lcom/amazon/identity/auth/device/utils/CookieUtils;
.super Ljava/lang/Object;
.source "CookieUtils.java"


# static fields
.field public static final COOKIE_ATTRIBUTE_SEPERATOR:Ljava/lang/String; = ";"

.field public static final COOKIE_NAME_VALUE_SEPERATOR:Ljava/lang/String; = "="

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/amazon/identity/auth/device/utils/CookieUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/CookieUtils;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    return-void
.end method

.method public static extractCookieStringArray(Ljava/util/List;)[Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)[",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 260
    .local p0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    if-eqz p0, :cond_1

    .line 262
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 263
    .local v2, "returnCookies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 266
    .local v0, "cookie":Lorg/apache/http/cookie/Cookie;
    check-cast v0, Lcom/amazon/identity/auth/device/token/MAPCookie;

    .end local v0    # "cookie":Lorg/apache/http/cookie/Cookie;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getSetCookieHeader()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 268
    :cond_0
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    new-array v3, v3, [Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    .line 272
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "returnCookies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_1
    return-object v3

    :cond_1
    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    goto :goto_1
.end method

.method public static formatDate(Ljava/util/Date;)Ljava/lang/String;
    .locals 1
    .param p0, "date"    # Ljava/util/Date;

    .prologue
    .line 285
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getCookieExpireDateFormatter()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static fromJson(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 6
    .param p0, "jsonString"    # Ljava/lang/String;
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 226
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 228
    .local v0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 246
    :cond_0
    :goto_0
    return-object v0

    .line 235
    :cond_1
    :try_start_0
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3, p0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 237
    .local v3, "jsonArray":Lorg/json/JSONArray;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 239
    invoke-virtual {v3, v2}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->parseMapCookieFromSetCookieString(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/MAPCookie;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 237
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 243
    .end local v2    # "i":I
    .end local v3    # "jsonArray":Lorg/json/JSONArray;
    :catch_0
    move-exception v1

    .line 245
    .local v1, "e":Lorg/json/JSONException;
    sget-object v4, Lcom/amazon/identity/auth/device/utils/CookieUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Failed to parse cookies"

    invoke-static {v4, v5, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static fromJsonOrSerializedBundle(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p0, "serializedCookies"    # Ljava/lang/String;
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 120
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 122
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 130
    :goto_0
    return-object v0

    .line 124
    :cond_0
    const-string/jumbo v0, "["

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 126
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromJson(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 130
    :cond_1
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromSerializedBundle(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public static fromSerializedBundle(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 10
    .param p0, "serializedCookieBundle"    # Ljava/lang/String;
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 159
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 161
    .local v3, "cookieList":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->stringToBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 162
    .local v1, "bundle":Landroid/os/Bundle;
    if-nez v1, :cond_1

    .line 188
    :cond_0
    return-object v3

    .line 170
    :cond_1
    :try_start_0
    const-string/jumbo v8, "com.amazon.identity.auth.device.api.cookiekeys.all"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 178
    .local v4, "cookies":[Ljava/lang/String;
    :goto_0
    if-eqz v4, :cond_0

    .line 183
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/String;
    array-length v7, v4

    .local v7, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    :goto_1
    if-ge v6, v7, :cond_0

    aget-object v2, v0, v6

    .line 185
    .local v2, "cookie":Ljava/lang/String;
    invoke-static {v2, p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->parseMapCookieFromSetCookieString(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/MAPCookie;

    move-result-object v8

    invoke-interface {v3, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 183
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 172
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "cookie":Ljava/lang/String;
    .end local v4    # "cookies":[Ljava/lang/String;
    .end local v6    # "i$":I
    .end local v7    # "len$":I
    :catch_0
    move-exception v5

    .line 174
    .local v5, "e":Ljava/lang/Exception;
    sget-object v8, Lcom/amazon/identity/auth/device/utils/CookieUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Failed to deserialize parcel"

    invoke-static {v8, v9, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 175
    const/4 v4, 0x0

    .restart local v4    # "cookies":[Ljava/lang/String;
    goto :goto_0
.end method

.method public static getBundleForCookieList(Ljava/util/List;)Landroid/os/Bundle;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)",
            "Landroid/os/Bundle;"
        }
    .end annotation

    .prologue
    .line 193
    .local p0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 194
    .local v0, "retBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.identity.auth.device.api.cookiekeys.all"

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->extractCookieStringArray(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 196
    return-object v0
.end method

.method public static getCookieExpireDateFormatter()Ljava/text/SimpleDateFormat;
    .locals 3

    .prologue
    .line 297
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string/jumbo v1, "dd MMM yyyy kk:mm:ss \'GMT\'"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 298
    .local v0, "dateFormatter":Ljava/text/SimpleDateFormat;
    const-string/jumbo v1, "GMT"

    invoke-static {v1}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 300
    return-object v0
.end method

.method public static getNonExpiringCookieExpiresString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 309
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 310
    .local v0, "calendar":Ljava/util/Calendar;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    .line 311
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v2}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 312
    const/4 v2, 0x1

    const/16 v3, 0x1e

    invoke-virtual {v0, v2, v3}, Ljava/util/Calendar;->add(II)V

    .line 314
    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v1

    .line 315
    .local v1, "thirtyYearsFromNow":Ljava/util/Date;
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getCookieExpireDateFormatter()Ljava/text/SimpleDateFormat;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static parseMapCookieFromSetCookieString(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/MAPCookie;
    .locals 14
    .param p0, "cookie"    # Ljava/lang/String;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 41
    new-instance v9, Ljava/util/StringTokenizer;

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v6, ";"

    invoke-direct {v9, v0, v6}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    .local v9, "cookieParser":Ljava/util/StringTokenizer;
    const/4 v1, 0x0

    .line 44
    .local v1, "cookieName":Ljava/lang/String;
    const/4 v2, 0x0

    .line 46
    .local v2, "cookieValue":Ljava/lang/String;
    const/4 v3, 0x0

    .line 47
    .local v3, "cookieDomain":Ljava/lang/String;
    const/4 v4, 0x0

    .line 48
    .local v4, "cookieExpires":Ljava/lang/String;
    const/4 v5, 0x0

    .line 49
    .local v5, "cookiePath":Ljava/lang/String;
    const/4 v7, 0x0

    .line 50
    .local v7, "isSecure":Z
    const/4 v8, 0x0

    .line 53
    .local v8, "isHttpOnly":Z
    :goto_0
    invoke-virtual {v9}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 55
    invoke-virtual {v9}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v10

    .line 58
    .local v10, "currentField":Ljava/lang/String;
    const-string/jumbo v0, "="

    invoke-virtual {v10, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v11

    .line 60
    .local v11, "firstEqualsIndex":I
    const/4 v13, 0x0

    .line 63
    .local v13, "value":Ljava/lang/String;
    const/4 v0, -0x1

    if-ne v11, v0, :cond_0

    .line 65
    move-object v12, v10

    .line 73
    .local v12, "key":Ljava/lang/String;
    :goto_1
    const-string/jumbo v0, "domain"

    invoke-virtual {v12, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 75
    move-object v3, v13

    goto :goto_0

    .line 69
    .end local v12    # "key":Ljava/lang/String;
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {v10, v0, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v12

    .line 70
    .restart local v12    # "key":Ljava/lang/String;
    add-int/lit8 v0, v11, 0x1

    invoke-virtual {v10, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v13

    goto :goto_1

    .line 77
    :cond_1
    const-string/jumbo v0, "Expires"

    invoke-virtual {v12, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 79
    move-object v4, v13

    goto :goto_0

    .line 81
    :cond_2
    const-string/jumbo v0, "Path"

    invoke-virtual {v12, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 83
    move-object v5, v13

    goto :goto_0

    .line 85
    :cond_3
    const-string/jumbo v0, "Secure"

    invoke-virtual {v12, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 87
    const/4 v7, 0x1

    goto :goto_0

    .line 89
    :cond_4
    const-string/jumbo v0, "HttpOnly"

    invoke-virtual {v12, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 91
    const/4 v8, 0x1

    goto :goto_0

    .line 96
    :cond_5
    move-object v1, v12

    .line 97
    move-object v2, v13

    .line 100
    goto :goto_0

    .line 102
    .end local v10    # "currentField":Ljava/lang/String;
    .end local v11    # "firstEqualsIndex":I
    .end local v12    # "key":Ljava/lang/String;
    .end local v13    # "value":Ljava/lang/String;
    :cond_6
    new-instance v0, Lcom/amazon/identity/auth/device/token/MAPCookie;

    move-object v6, p1

    invoke-direct/range {v0 .. v8}, Lcom/amazon/identity/auth/device/token/MAPCookie;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    return-object v0
.end method

.method public static toJson(Ljava/util/List;)Ljava/lang/String;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 206
    .local p0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 207
    .local v4, "json":Lorg/json/JSONArray;
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->extractCookieStringArray(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v2

    .line 208
    .local v2, "cookieStrings":[Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 210
    move-object v0, v2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v5, v2

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v1, v0, v3

    .line 212
    .local v1, "cookieString":Ljava/lang/String;
    invoke-virtual {v4, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 210
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 215
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "cookieString":Ljava/lang/String;
    .end local v3    # "i$":I
    .end local v5    # "len$":I
    :cond_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method public static toSerializedBundleString(Ljava/util/List;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 145
    .local p0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getBundleForCookieList(Ljava/util/List;)Landroid/os/Bundle;

    move-result-object v0

    .line 146
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->bundleToString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
