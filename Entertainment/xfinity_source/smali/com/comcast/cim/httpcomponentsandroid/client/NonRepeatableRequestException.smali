.class public Lcom/comcast/cim/httpcomponentsandroid/client/NonRepeatableRequestException;
.super Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
.source "NonRepeatableRequestException.java"


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

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 68
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 69
    return-void
.end method
