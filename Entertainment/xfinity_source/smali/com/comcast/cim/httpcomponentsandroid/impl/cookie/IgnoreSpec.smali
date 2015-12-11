.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/IgnoreSpec;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;
.source "IgnoreSpec.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;-><init>()V

    return-void
.end method


# virtual methods
.method public formatCookies(Ljava/util/List;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;>;"
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .prologue
    .line 48
    const/4 v0, 0x0

    return v0
.end method

.method public getVersionHeader()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x0

    return-object v0
.end method

.method public parse(Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;
    .locals 1
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 53
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
