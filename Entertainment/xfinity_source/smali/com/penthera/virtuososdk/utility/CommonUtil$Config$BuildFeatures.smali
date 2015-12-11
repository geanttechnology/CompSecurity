.class public final Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BuildFeatures;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil$Config;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "BuildFeatures"
.end annotation


# direct methods
.method public static isFlagSet(I)Z
    .locals 4
    .param p0, "flags"    # I

    .prologue
    .line 45
    const-wide/16 v0, 0x6

    int-to-long v2, p0

    and-long/2addr v0, v2

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
