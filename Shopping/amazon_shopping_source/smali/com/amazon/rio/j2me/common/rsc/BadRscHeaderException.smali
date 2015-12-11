.class public Lcom/amazon/rio/j2me/common/rsc/BadRscHeaderException;
.super Ljava/io/IOException;
.source "BadRscHeaderException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 8
    invoke-direct {p0, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    return-void
.end method
