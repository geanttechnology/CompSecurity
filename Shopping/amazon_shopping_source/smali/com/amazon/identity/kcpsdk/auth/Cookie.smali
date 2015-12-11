.class public Lcom/amazon/identity/kcpsdk/auth/Cookie;
.super Ljava/lang/Object;
.source "Cookie.java"


# instance fields
.field private mUrl:Ljava/lang/String;

.field private mValue:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    return-void
.end method

.method public static isValidUrl(Ljava/lang/String;)Z
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 63
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isValidValue(Ljava/lang/String;)Z
    .locals 1
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/Cookie;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/Cookie;->mValue:Ljava/lang/String;

    return-object v0
.end method

.method public isValid()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 49
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/Cookie;->mUrl:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->isValidUrl(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 58
    :cond_0
    :goto_0
    return v0

    .line 54
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/Cookie;->mValue:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->isValidValue(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 58
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setUrl(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->isValidUrl(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 19
    const/4 v0, 0x0

    .line 23
    :goto_0
    return v0

    .line 22
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/Cookie;->mUrl:Ljava/lang/String;

    .line 23
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setValue(Ljava/lang/String;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->isValidValue(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 30
    const/4 v0, 0x0

    .line 34
    :goto_0
    return v0

    .line 33
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/Cookie;->mValue:Ljava/lang/String;

    .line 34
    const/4 v0, 0x1

    goto :goto_0
.end method
