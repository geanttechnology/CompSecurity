.class public Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionPoolTimeoutException;
.super Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;
.source "ConnectionPoolTimeoutException.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;-><init>()V

    .line 49
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;-><init>(Ljava/lang/String;)V

    .line 58
    return-void
.end method
