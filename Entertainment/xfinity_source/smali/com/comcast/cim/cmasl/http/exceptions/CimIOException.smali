.class public Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;
.super Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
.source "CimIOException.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>()V

    .line 11
    return-void
.end method

.method public constructor <init>(Ljava/io/IOException;)V
    .locals 0
    .param p1, "ioException"    # Ljava/io/IOException;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    .line 15
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/io/IOException;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;
    .param p2, "ioException"    # Ljava/io/IOException;

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 19
    return-void
.end method
