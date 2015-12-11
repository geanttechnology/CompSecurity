.class public Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
.super Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
.source "MalformedCookieException.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>()V

    .line 51
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 59
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    .line 60
    return-void
.end method
