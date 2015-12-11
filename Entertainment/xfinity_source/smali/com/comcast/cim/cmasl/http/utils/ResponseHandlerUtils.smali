.class public Lcom/comcast/cim/cmasl/http/utils/ResponseHandlerUtils;
.super Ljava/lang/Object;
.source "ResponseHandlerUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static statusCodeIndicatesError(I)Z
    .locals 1
    .param p0, "statusCode"    # I

    .prologue
    .line 7
    const/16 v0, 0xca

    if-eq p0, v0, :cond_0

    const/16 v0, 0xc8

    if-lt p0, v0, :cond_0

    const/16 v0, 0x12c

    if-lt p0, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
