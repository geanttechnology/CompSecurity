.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicCommentHandler;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieAttributeHandler;
.source "BasicCommentHandler.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieAttributeHandler;-><init>()V

    .line 43
    return-void
.end method


# virtual methods
.method public parse(Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;Ljava/lang/String;)V
    .locals 2
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 47
    if-nez p1, :cond_0

    .line 48
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    invoke-interface {p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;->setComment(Ljava/lang/String;)V

    .line 51
    return-void
.end method
