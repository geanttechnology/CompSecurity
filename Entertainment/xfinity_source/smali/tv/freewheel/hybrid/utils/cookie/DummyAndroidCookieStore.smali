.class public Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;
.super Ljava/lang/Object;
.source "DummyAndroidCookieStore.java"

# interfaces
.implements Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;


# static fields
.field public static MOCK_COOKIE_STRING:Ljava/lang/String;


# instance fields
.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private store:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-string v0, "_uid=b000_5511089179943706094;expires=Dec, 21 Aug 2012 06:40:41 GMT;domain=.fwmrm.net;path=/;"

    sput-object v0, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->MOCK_COOKIE_STRING:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->store:Ljava/util/HashMap;

    .line 16
    return-void
.end method


# virtual methods
.method public getCookie(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 37
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->store:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public removeAllCookie()V
    .locals 3

    .prologue
    .line 25
    iget-object v2, p0, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->store:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 26
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 27
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 28
    .local v1, "key":Ljava/lang/String;
    iget-object v2, p0, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->store:Ljava/util/HashMap;

    invoke-virtual {v2, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 30
    .end local v1    # "key":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public removeExpiredCookie()V
    .locals 0

    .prologue
    .line 33
    invoke-virtual {p0}, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->removeAllCookie()V

    .line 34
    return-void
.end method

.method public setCookie(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "cookie"    # Ljava/lang/String;

    .prologue
    .line 19
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->store:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 20
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "got cookie: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", for url: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 22
    return-void
.end method
