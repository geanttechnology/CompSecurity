.class public Lcom/auditude/ads/util/http/PersistentCookieStore;
.super Ljava/lang/Object;
.source "PersistentCookieStore.java"

# interfaces
.implements Lorg/apache/http/client/CookieStore;


# instance fields
.field private final cookiePrefs:Landroid/content/SharedPreferences;

.field private final cookies:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation
.end field

.field private omitNonPersistentCookies:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v10, 0x0

    const/4 v5, 0x0

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-boolean v5, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->omitNonPersistentCookies:Z

    .line 62
    const-string v6, "CookiePrefsFile"

    invoke-virtual {p1, v6, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v6

    iput-object v6, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookiePrefs:Landroid/content/SharedPreferences;

    .line 63
    new-instance v6, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v6}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v6, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    .line 66
    iget-object v6, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookiePrefs:Landroid/content/SharedPreferences;

    const-string v7, "names"

    invoke-interface {v6, v7, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 67
    .local v4, "storedCookieNames":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 68
    const-string v6, ","

    invoke-static {v4, v6}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, "cookieNames":[Ljava/lang/String;
    array-length v6, v0

    :goto_0
    if-lt v5, v6, :cond_1

    .line 80
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    invoke-virtual {p0, v5}, Lcom/auditude/ads/util/http/PersistentCookieStore;->clearExpired(Ljava/util/Date;)Z

    .line 82
    .end local v0    # "cookieNames":[Ljava/lang/String;
    :cond_0
    return-void

    .line 69
    .restart local v0    # "cookieNames":[Ljava/lang/String;
    :cond_1
    aget-object v3, v0, v5

    .line 70
    .local v3, "name":Ljava/lang/String;
    iget-object v7, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookiePrefs:Landroid/content/SharedPreferences;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "cookie_"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 71
    .local v2, "encodedCookie":Ljava/lang/String;
    if-eqz v2, :cond_2

    .line 72
    invoke-virtual {p0, v2}, Lcom/auditude/ads/util/http/PersistentCookieStore;->decodeCookie(Ljava/lang/String;)Lorg/apache/http/cookie/Cookie;

    move-result-object v1

    .line 73
    .local v1, "decodedCookie":Lorg/apache/http/cookie/Cookie;
    if-eqz v1, :cond_2

    .line 74
    iget-object v7, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v7, v3, v1}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    .end local v1    # "decodedCookie":Lorg/apache/http/cookie/Cookie;
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0
.end method


# virtual methods
.method public addCookie(Lorg/apache/http/cookie/Cookie;)V
    .locals 5
    .param p1, "cookie"    # Lorg/apache/http/cookie/Cookie;

    .prologue
    .line 86
    iget-boolean v2, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->omitNonPersistentCookies:Z

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lorg/apache/http/cookie/Cookie;->isPersistent()Z

    move-result v2

    if-nez v2, :cond_0

    .line 102
    :goto_0
    return-void

    .line 88
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-interface {p1}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p1}, Lorg/apache/http/cookie/Cookie;->getDomain()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 91
    .local v0, "name":Ljava/lang/String;
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-interface {p1, v2}, Lorg/apache/http/cookie/Cookie;->isExpired(Ljava/util/Date;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 92
    iget-object v2, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, v0, p1}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    :goto_1
    iget-object v2, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookiePrefs:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 99
    .local v1, "prefsWriter":Landroid/content/SharedPreferences$Editor;
    const-string v2, "names"

    const-string v3, ","

    iget-object v4, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v4}, Ljava/util/concurrent/ConcurrentHashMap;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 100
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "cookie_"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/auditude/ads/util/http/SerializableCookie;

    invoke-direct {v3, p1}, Lcom/auditude/ads/util/http/SerializableCookie;-><init>(Lorg/apache/http/cookie/Cookie;)V

    invoke-virtual {p0, v3}, Lcom/auditude/ads/util/http/PersistentCookieStore;->encodeCookie(Lcom/auditude/ads/util/http/SerializableCookie;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 101
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0

    .line 94
    .end local v1    # "prefsWriter":Landroid/content/SharedPreferences$Editor;
    :cond_1
    iget-object v2, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, v0}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method

.method protected byteArrayToHexString([B)Ljava/lang/String;
    .locals 6
    .param p1, "bytes"    # [B

    .prologue
    .line 223
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v3, p1

    mul-int/lit8 v3, v3, 0x2

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 224
    .local v1, "sb":Ljava/lang/StringBuilder;
    array-length v4, p1

    const/4 v3, 0x0

    :goto_0
    if-lt v3, v4, :cond_0

    .line 231
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v3, v4}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 224
    :cond_0
    aget-byte v0, p1, v3

    .line 225
    .local v0, "element":B
    and-int/lit16 v2, v0, 0xff

    .line 226
    .local v2, "v":I
    const/16 v5, 0x10

    if-ge v2, v5, :cond_1

    .line 227
    const/16 v5, 0x30

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 229
    :cond_1
    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 224
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public clear()V
    .locals 5

    .prologue
    .line 107
    iget-object v2, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookiePrefs:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 108
    .local v1, "prefsWriter":Landroid/content/SharedPreferences$Editor;
    iget-object v2, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentHashMap;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 111
    const-string v2, "names"

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 112
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 115
    iget-object v2, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentHashMap;->clear()V

    .line 116
    return-void

    .line 108
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 109
    .local v0, "name":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "cookie_"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0
.end method

.method public clearExpired(Ljava/util/Date;)Z
    .locals 8
    .param p1, "date"    # Ljava/util/Date;

    .prologue
    .line 120
    const/4 v0, 0x0

    .line 121
    .local v0, "clearedAny":Z
    iget-object v5, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookiePrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    .line 123
    .local v4, "prefsWriter":Landroid/content/SharedPreferences$Editor;
    iget-object v5, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v5}, Ljava/util/concurrent/ConcurrentHashMap;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_2

    .line 139
    if-eqz v0, :cond_1

    .line 140
    const-string v5, "names"

    const-string v6, ","

    iget-object v7, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v7}, Ljava/util/concurrent/ConcurrentHashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 142
    :cond_1
    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 144
    return v0

    .line 123
    :cond_2
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 124
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lorg/apache/http/cookie/Cookie;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 125
    .local v3, "name":Ljava/lang/String;
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/http/cookie/Cookie;

    .line 126
    .local v1, "cookie":Lorg/apache/http/cookie/Cookie;
    invoke-interface {v1, p1}, Lorg/apache/http/cookie/Cookie;->isExpired(Ljava/util/Date;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 128
    iget-object v6, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v6, v3}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "cookie_"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v6}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 134
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected decodeCookie(Ljava/lang/String;)Lorg/apache/http/cookie/Cookie;
    .locals 7
    .param p1, "cookieString"    # Ljava/lang/String;

    .prologue
    .line 202
    invoke-virtual {p0, p1}, Lcom/auditude/ads/util/http/PersistentCookieStore;->hexStringToByteArray(Ljava/lang/String;)[B

    move-result-object v1

    .line 203
    .local v1, "bytes":[B
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, v1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 204
    .local v0, "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    const/4 v2, 0x0

    .line 206
    .local v2, "cookie":Lorg/apache/http/cookie/Cookie;
    :try_start_0
    new-instance v4, Ljava/io/ObjectInputStream;

    invoke-direct {v4, v0}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V

    .line 207
    .local v4, "objectInputStream":Ljava/io/ObjectInputStream;
    invoke-virtual {v4}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/auditude/ads/util/http/SerializableCookie;

    invoke-virtual {v5}, Lcom/auditude/ads/util/http/SerializableCookie;->getCookie()Lorg/apache/http/cookie/Cookie;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 212
    .end local v4    # "objectInputStream":Ljava/io/ObjectInputStream;
    :goto_0
    return-object v2

    .line 208
    :catch_0
    move-exception v3

    .line 209
    .local v3, "exception":Ljava/lang/Exception;
    const-string v5, "PersistentCookieStore"

    const-string v6, "decodeCookie failed"

    invoke-static {v5, v6, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected encodeCookie(Lcom/auditude/ads/util/http/SerializableCookie;)Ljava/lang/String;
    .locals 4
    .param p1, "cookie"    # Lcom/auditude/ads/util/http/SerializableCookie;

    .prologue
    const/4 v3, 0x0

    .line 182
    if-nez p1, :cond_0

    .line 192
    :goto_0
    return-object v3

    .line 184
    :cond_0
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 186
    .local v1, "os":Ljava/io/ByteArrayOutputStream;
    :try_start_0
    new-instance v2, Ljava/io/ObjectOutputStream;

    invoke-direct {v2, v1}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 187
    .local v2, "outputStream":Ljava/io/ObjectOutputStream;
    invoke-virtual {v2, p1}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 192
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/auditude/ads/util/http/PersistentCookieStore;->byteArrayToHexString([B)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 188
    .end local v2    # "outputStream":Ljava/io/ObjectOutputStream;
    :catch_0
    move-exception v0

    .line 189
    .local v0, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method public getCookies()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 149
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/auditude/ads/util/http/PersistentCookieStore;->cookies:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1}, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method protected hexStringToByteArray(Ljava/lang/String;)[B
    .locals 7
    .param p1, "hexString"    # Ljava/lang/String;

    .prologue
    const/16 v6, 0x10

    .line 241
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    .line 242
    .local v2, "len":I
    div-int/lit8 v3, v2, 0x2

    new-array v0, v3, [B

    .line 243
    .local v0, "data":[B
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, v2, :cond_0

    .line 246
    return-object v0

    .line 244
    :cond_0
    div-int/lit8 v3, v1, 0x2

    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4, v6}, Ljava/lang/Character;->digit(CI)I

    move-result v4

    shl-int/lit8 v4, v4, 0x4

    add-int/lit8 v5, v1, 0x1

    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v5

    invoke-static {v5, v6}, Ljava/lang/Character;->digit(CI)I

    move-result v5

    add-int/2addr v4, v5

    int-to-byte v4, v4

    aput-byte v4, v0, v3

    .line 243
    add-int/lit8 v1, v1, 0x2

    goto :goto_0
.end method
