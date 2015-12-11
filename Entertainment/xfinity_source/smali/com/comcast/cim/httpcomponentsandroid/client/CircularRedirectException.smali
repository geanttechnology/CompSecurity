.class public Lcom/comcast/cim/httpcomponentsandroid/client/CircularRedirectException;
.super Lcom/comcast/cim/httpcomponentsandroid/client/RedirectException;
.source "CircularRedirectException.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/RedirectException;-><init>()V

    .line 47
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/RedirectException;-><init>(Ljava/lang/String;)V

    .line 56
    return-void
.end method
