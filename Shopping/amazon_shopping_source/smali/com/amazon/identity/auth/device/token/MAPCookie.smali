.class public Lcom/amazon/identity/auth/device/token/MAPCookie;
.super Ljava/lang/Object;
.source "MAPCookie.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/token/Token;
.implements Ljava/io/Serializable;
.implements Lorg/apache/http/cookie/Cookie;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/token/MAPCookie$CookieAttribute;
    }
.end annotation


# static fields
.field public static final KEY_COMMENT:Ljava/lang/String; = "Comment"

.field public static final KEY_COMMENT_URL:Ljava/lang/String; = "CommentUrl"

.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "DirectedId"

.field public static final KEY_DOMAIN:Ljava/lang/String; = "Domain"

.field public static final KEY_EXPIRES:Ljava/lang/String; = "Expires"

.field public static final KEY_HTTP_ONLY:Ljava/lang/String; = "HttpOnly"

.field public static final KEY_NAME:Ljava/lang/String; = "Name"

.field public static final KEY_PATH:Ljava/lang/String; = "Path"

.field public static final KEY_PERSISTANT:Ljava/lang/String; = "Persistant"

.field public static final KEY_SECURE:Ljava/lang/String; = "Secure"

.field public static final KEY_VALUE:Ljava/lang/String; = "Value"

.field public static final KEY_VERSION:Ljava/lang/String; = "Version"

.field private static final LOG_TAG:Ljava/lang/String;

.field public static final NO_VERSION:I = -0x1


# instance fields
.field private final mCookieData:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final transient mLocalCreationTimestamp:Landroid/text/format/Time;

.field private mPorts:[I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    const-class v0, Lcom/amazon/identity/auth/device/token/MAPCookie;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/MAPCookie;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "domain"    # Ljava/lang/String;
    .param p4, "expires"    # Ljava/lang/String;
    .param p5, "path"    # Ljava/lang/String;
    .param p6, "directedId"    # Ljava/lang/String;
    .param p7, "isSecure"    # Z
    .param p8, "isHttpOnly"    # Z

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mLocalCreationTimestamp:Landroid/text/format/Time;

    .line 92
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    .line 94
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Name"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Value"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Domain"

    invoke-interface {v0, v1, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Expires"

    invoke-interface {v0, v1, p4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Path"

    invoke-interface {v0, v1, p5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "DirectedId"

    invoke-interface {v0, v1, p6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    invoke-virtual {p0, p7}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setSecure(Z)V

    .line 103
    invoke-virtual {p0, p8}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setHttpOnly(Z)V

    .line 105
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v0}, Landroid/text/format/Time;->setToNow()V

    .line 107
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->logCookie()V

    .line 108
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "domain"    # Ljava/lang/String;
    .param p4, "directedId"    # Ljava/lang/String;
    .param p5, "isSecure"    # Z

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mLocalCreationTimestamp:Landroid/text/format/Time;

    .line 69
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    .line 71
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Name"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Value"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "DirectedId"

    invoke-interface {v0, v1, p4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Domain"

    invoke-interface {v0, v1, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    invoke-virtual {p0, p5}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setSecure(Z)V

    .line 77
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v0}, Landroid/text/format/Time;->setToNow()V

    .line 79
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->logCookie()V

    .line 80
    return-void
.end method

.method public constructor <init>(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 111
    .local p1, "cookieData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mLocalCreationTimestamp:Landroid/text/format/Time;

    .line 113
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    .line 115
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v0}, Landroid/text/format/Time;->setToNow()V

    .line 117
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->logCookie()V

    .line 118
    return-void
.end method

.method private logCookie()V
    .locals 4

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getValue()Ljava/lang/String;

    move-result-object v0

    .line 131
    .local v0, "logValue":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->isSecure()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 133
    const-string/jumbo v0, "<secure>"

    .line 136
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/token/MAPCookie;->LOG_TAG:Ljava/lang/String;

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getDomain()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object v0, v1, v2

    .line 142
    return-void
.end method


# virtual methods
.method public getAttribute(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 317
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getComment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 191
    const-string/jumbo v0, "Comment"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCommentURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 197
    const-string/jumbo v0, "CommentUrl"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getData()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 158
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    return-object v0
.end method

.method public getDirectedId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 164
    const-string/jumbo v0, "DirectedId"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 203
    const-string/jumbo v0, "Domain"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getExpiryDate()Ljava/util/Date;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 209
    const-string/jumbo v2, "Expires"

    invoke-virtual {p0, v2}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 210
    .local v0, "sExpiryDate":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 214
    :try_start_0
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getCookieExpireDateFormatter()Ljava/text/SimpleDateFormat;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 222
    :cond_0
    :goto_0
    return-object v1

    .line 218
    :catch_0
    move-exception v2

    sget-object v2, Lcom/amazon/identity/auth/device/token/MAPCookie;->LOG_TAG:Ljava/lang/String;

    goto :goto_0
.end method

.method public getLocalTimestamp()Landroid/text/format/Time;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mLocalCreationTimestamp:Landroid/text/format/Time;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 233
    const-string/jumbo v0, "Name"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 239
    const-string/jumbo v0, "Path"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPorts()[I
    .locals 2

    .prologue
    .line 250
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mPorts:[I

    if-nez v0, :cond_0

    .line 252
    const/4 v0, 0x0

    .line 255
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mPorts:[I

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mPorts:[I

    array-length v1, v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/ArrayUtil;->copyOf([II)[I

    move-result-object v0

    goto :goto_0
.end method

.method public getSetCookieHeader()Ljava/lang/String;
    .locals 5

    .prologue
    .line 330
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 333
    .local v0, "cookieSB":Ljava/lang/StringBuilder;
    const-string/jumbo v2, "="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 334
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 335
    const-string/jumbo v2, "; path=/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 336
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "; domain="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getDomain()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 337
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->isSecure()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 339
    const-string/jumbo v2, "; secure"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 345
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getExpiryDate()Ljava/util/Date;

    move-result-object v1

    .line 346
    .local v1, "date":Ljava/util/Date;
    if-eqz v1, :cond_2

    .line 348
    const-string/jumbo v2, "; expires="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 349
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 351
    sget-object v2, Lcom/amazon/identity/auth/device/token/MAPCookie;->LOG_TAG:Ljava/lang/String;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {v1}, Ljava/util/Date;->toGMTString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 353
    :cond_1
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getCookieExpireDateFormatter()Ljava/text/SimpleDateFormat;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 355
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 267
    const-string/jumbo v0, "Value"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .prologue
    .line 273
    const-string/jumbo v0, "Version"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 274
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 276
    const/4 v0, -0x1

    .line 278
    :goto_0
    return v0

    :cond_0
    const-string/jumbo v0, "Version"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public hasExpired()Z
    .locals 1

    .prologue
    .line 146
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->isExpired(Ljava/util/Date;)Z

    move-result v0

    return v0
.end method

.method public isExpired(Ljava/util/Date;)Z
    .locals 2
    .param p1, "date"    # Ljava/util/Date;

    .prologue
    .line 284
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getExpiryDate()Ljava/util/Date;

    move-result-object v1

    if-nez v1, :cond_0

    .line 286
    const/4 v1, 0x0

    .line 295
    :goto_0
    return v1

    .line 290
    :cond_0
    move-object v0, p1

    .local v0, "givenData":Ljava/util/Date;
    if-nez p1, :cond_1

    .line 292
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    .line 295
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getExpiryDate()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v1

    goto :goto_0
.end method

.method public isHttpOnly()Z
    .locals 2

    .prologue
    .line 172
    const-string/jumbo v1, "HttpOnly"

    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 173
    .local v0, "httpOnly":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 175
    const/4 v1, 0x0

    .line 177
    :goto_0
    return v1

    :cond_0
    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method

.method public isPersistent()Z
    .locals 1

    .prologue
    .line 301
    const-string/jumbo v0, "Persistant"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isSecure()Z
    .locals 1

    .prologue
    .line 307
    const-string/jumbo v0, "Secure"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 322
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public setDomain(Ljava/lang/String;)V
    .locals 2
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 360
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "Domain"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 361
    return-void
.end method

.method public setExpiryDate(Ljava/lang/String;)V
    .locals 1
    .param p1, "expiryDate"    # Ljava/lang/String;

    .prologue
    .line 227
    const-string/jumbo v0, "Expires"

    invoke-virtual {p0, v0, p1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 228
    return-void
.end method

.method public setHttpOnly(Z)V
    .locals 3
    .param p1, "httpOnly"    # Z

    .prologue
    .line 185
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mCookieData:Ljava/util/Map;

    const-string/jumbo v1, "HttpOnly"

    invoke-static {p1}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 186
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 244
    const-string/jumbo v0, "Path"

    invoke-virtual {p0, v0, p1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 245
    return-void
.end method

.method public setPorts([I)V
    .locals 3
    .param p1, "ports"    # [I

    .prologue
    const/4 v2, 0x0

    .line 260
    array-length v0, p1

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mPorts:[I

    .line 261
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookie;->mPorts:[I

    array-length v1, p1

    invoke-static {p1, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 262
    return-void
.end method

.method protected setSecure(Z)V
    .locals 2
    .param p1, "isSecure"    # Z

    .prologue
    .line 312
    const-string/jumbo v0, "Secure"

    invoke-static {p1}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 313
    return-void
.end method
