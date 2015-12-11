.class public Lcom/comcast/cim/httpcomponentsandroid/MethodNotSupportedException;
.super Lcom/comcast/cim/httpcomponentsandroid/HttpException;
.source "MethodNotSupportedException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 46
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;)V

    .line 47
    return-void
.end method
