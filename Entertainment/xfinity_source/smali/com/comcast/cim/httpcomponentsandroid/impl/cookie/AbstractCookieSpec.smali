.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieSpec;
.super Ljava/lang/Object;
.source "AbstractCookieSpec.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private final attribHandlerMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieSpec;->attribHandlerMap:Ljava/util/Map;

    .line 61
    return-void
.end method


# virtual methods
.method protected findAttribHandler(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieSpec;->attribHandlerMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;

    return-object v0
.end method

.method protected getAttribHandlers()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;",
            ">;"
        }
    .end annotation

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieSpec;->attribHandlerMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

.method public registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "handler"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;

    .prologue
    .line 65
    if-nez p1, :cond_0

    .line 66
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Attribute name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 68
    :cond_0
    if-nez p2, :cond_1

    .line 69
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Attribute handler may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 71
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieSpec;->attribHandlerMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    return-void
.end method
