.class public Lcom/amazon/identity/auth/request/NoCredentialsException;
.super Ljava/io/IOException;
.source "NoCredentialsException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-direct {p0, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    .line 13
    return-void
.end method
