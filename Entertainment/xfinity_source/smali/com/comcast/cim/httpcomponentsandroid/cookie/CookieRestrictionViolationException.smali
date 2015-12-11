.class public Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieRestrictionViolationException;
.super Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
.source "CookieRestrictionViolationException.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>()V

    .line 49
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    .line 59
    return-void
.end method
