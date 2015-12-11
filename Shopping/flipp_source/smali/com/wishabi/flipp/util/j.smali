.class public final Lcom/wishabi/flipp/util/j;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(FFF)F
    .locals 2

    .prologue
    .line 18
    cmpg-float v0, p1, p2

    if-gez v0, :cond_0

    .line 24
    :goto_0
    invoke-static {p0, p1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    invoke-static {v0, p2}, Ljava/lang/Math;->min(FF)F

    move-result v0

    return v0

    :cond_0
    move v1, p2

    move p2, p1

    move p1, v1

    goto :goto_0
.end method
