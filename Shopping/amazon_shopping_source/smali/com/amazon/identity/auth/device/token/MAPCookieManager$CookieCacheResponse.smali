.class Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;
.super Ljava/lang/Object;
.source "MAPCookieManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/token/MAPCookieManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CookieCacheResponse"
.end annotation


# instance fields
.field private final mCookies:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation
.end field

.field private final mShouldReturn:Z


# direct methods
.method constructor <init>(Ljava/util/List;Z)V
    .locals 0
    .param p2, "shouldReturn"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 734
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 735
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;->mCookies:Ljava/util/List;

    .line 736
    iput-boolean p2, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;->mShouldReturn:Z

    .line 737
    return-void
.end method


# virtual methods
.method public getCookies()Ljava/util/List;
    .locals 1
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
    .line 741
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;->mCookies:Ljava/util/List;

    return-object v0
.end method

.method public shouldReturnCookies()Z
    .locals 1

    .prologue
    .line 746
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;->mShouldReturn:Z

    return v0
.end method
