.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCookieStore;
.super Ljava/lang/Object;
.source "BasicCookieStore.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;
.implements Ljava/io/Serializable;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field private final cookies:Ljava/util/TreeSet;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeSet",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    new-instance v0, Ljava/util/TreeSet;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieIdentityComparator;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieIdentityComparator;-><init>()V

    invoke-direct {v0, v1}, Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCookieStore;->cookies:Ljava/util/TreeSet;

    .line 56
    return-void
.end method


# virtual methods
.method public declared-synchronized addCookie(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;)V
    .locals 1
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;

    .prologue
    .line 69
    monitor-enter p0

    if-eqz p1, :cond_0

    .line 71
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCookieStore;->cookies:Ljava/util/TreeSet;

    invoke-virtual {v0, p1}, Ljava/util/TreeSet;->remove(Ljava/lang/Object;)Z

    .line 72
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;->isExpired(Ljava/util/Date;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCookieStore;->cookies:Ljava/util/TreeSet;

    invoke-virtual {v0, p1}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 76
    :cond_0
    monitor-exit p0

    return-void

    .line 69
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCookies()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 104
    monitor-enter p0

    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCookieStore;->cookies:Ljava/util/TreeSet;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCookieStore;->cookies:Ljava/util/TreeSet;

    invoke-virtual {v0}, Ljava/util/TreeSet;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
