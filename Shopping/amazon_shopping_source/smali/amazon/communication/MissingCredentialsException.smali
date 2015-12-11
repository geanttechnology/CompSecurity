.class public final Lamazon/communication/MissingCredentialsException;
.super Lamazon/communication/CommunicationBaseException;
.source "MissingCredentialsException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 46
    invoke-direct {p0, p1}, Lamazon/communication/CommunicationBaseException;-><init>(Ljava/lang/String;)V

    .line 47
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Exception;

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Lamazon/communication/CommunicationBaseException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 38
    return-void
.end method
