.class public Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;
.super Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
.source "MalformedChallengeException.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>()V

    .line 50
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    .line 59
    return-void
.end method
