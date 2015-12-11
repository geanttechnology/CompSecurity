.class public Lcom/comcast/cim/httpcomponentsandroid/TruncatedChunkException;
.super Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;
.source "TruncatedChunkException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;-><init>(Ljava/lang/String;)V

    .line 46
    return-void
.end method
