.class public Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
.super Lcom/comcast/cim/httpcomponentsandroid/HttpException;
.source "ProtocolException.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>()V

    .line 46
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 54
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;)V

    .line 55
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 66
    return-void
.end method
