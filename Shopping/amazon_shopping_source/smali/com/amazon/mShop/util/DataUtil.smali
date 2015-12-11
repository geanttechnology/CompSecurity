.class public Lcom/amazon/mShop/util/DataUtil;
.super Ljava/lang/Object;
.source "DataUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isEqual(Ljava/lang/Integer;I)Z
    .locals 1
    .param p0, "integerValue"    # Ljava/lang/Integer;
    .param p1, "intValue"    # I

    .prologue
    .line 18
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
