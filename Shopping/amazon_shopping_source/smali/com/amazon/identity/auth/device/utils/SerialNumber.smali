.class public final Lcom/amazon/identity/auth/device/utils/SerialNumber;
.super Ljava/lang/Object;
.source "SerialNumber.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    return-void
.end method

.method public static getAmazonSerial(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 21
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x9

    if-lt v0, v1, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 23
    sget-object v0, Landroid/os/Build;->SERIAL:Ljava/lang/String;

    .line 27
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
