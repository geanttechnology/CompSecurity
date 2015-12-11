.class public final Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;
.super Ljava/lang/Object;
.source "RequestValidationHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-class v0, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    return-void
.end method

.method public static isAlphaNumeric(Ljava/lang/String;)Z
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 67
    if-eqz p0, :cond_0

    const-string/jumbo v0, "[a-zA-Z0-9]*"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isNullOrEmpty(Ljava/lang/String;)Z
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 62
    if-eqz p0, :cond_0

    const-string/jumbo v0, ""

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isNumeric(Ljava/lang/String;)Z
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 72
    if-eqz p0, :cond_0

    const-string/jumbo v0, "[0-9]*"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isValidDeviceSerialNumber(Ljava/lang/String;)Z
    .locals 3
    .param p0, "deviceSerialNumber"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 35
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 38
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValidDeviceSerialNumber: returning false because a null or empty device serial number was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    :goto_0
    return v0

    .line 43
    :cond_0
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isAlphaNumeric(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 45
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValidDeviceSerialNumber: returning false because a non alpha numeric serial number was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 50
    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x33

    if-le v1, v2, :cond_2

    .line 52
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValidDeviceSerialNumber: returning false because a serial number that is too long (more than 51 characters) was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 57
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isValidDeviceType(Ljava/lang/String;)Z
    .locals 3
    .param p0, "deviceType"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 18
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 20
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValidDeviceType: returning false because a null or empty device type was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    :goto_0
    return v0

    .line 24
    :cond_0
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isAlphaNumeric(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 26
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValidDeviceType: returning false because a non alpha numeric device type was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 30
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method
