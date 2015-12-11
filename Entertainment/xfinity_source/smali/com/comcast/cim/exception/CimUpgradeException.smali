.class public Lcom/comcast/cim/exception/CimUpgradeException;
.super Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
.source "CimUpgradeException.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>()V

    .line 9
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;
    .param p2, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 17
    return-void
.end method
