.class public Lcom/penthera/virtuososdk/client/ServiceException;
.super Lcom/penthera/virtuososdk/client/ClientException;
.source "ServiceException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/client/ClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/client/ClientException;-><init>(Ljava/lang/Throwable;)V

    .line 15
    return-void
.end method
