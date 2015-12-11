.class public final Lcom/amazon/identity/auth/device/utils/IntegerHelpers;
.super Ljava/lang/Object;
.source "IntegerHelpers.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    return-void
.end method

.method public static compare(Ljava/lang/Integer;Ljava/lang/Integer;)I
    .locals 2
    .param p0, "int1"    # Ljava/lang/Integer;
    .param p1, "int2"    # Ljava/lang/Integer;

    .prologue
    .line 16
    if-nez p0, :cond_1

    .line 18
    if-eqz p1, :cond_0

    const/4 v0, -0x1

    .line 26
    :goto_0
    return v0

    .line 18
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 21
    :cond_1
    if-nez p1, :cond_2

    .line 23
    const/4 v0, 0x1

    goto :goto_0

    .line 26
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    sub-int/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Integer;->signum(I)I

    move-result v0

    goto :goto_0
.end method
