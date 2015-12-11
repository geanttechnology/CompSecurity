.class public Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;
.super Ljava/lang/Object;
.source "SoftwareVersion.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mSoftwareVersion:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const-class v0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    const-string/jumbo v0, ""

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;-><init>(Ljava/lang/String;)V

    .line 15
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)V
    .locals 1
    .param p1, "version"    # Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    .prologue
    .line 19
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;-><init>(Ljava/lang/String;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->isValidVersion(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 26
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->mSoftwareVersion:Ljava/lang/String;

    .line 34
    :goto_0
    return-void

    .line 30
    :cond_0
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "SoftwareVersion: constructed with invalid software version. Was not set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->mSoftwareVersion:Ljava/lang/String;

    goto :goto_0
.end method

.method public static isValidVersion(Ljava/lang/String;)Z
    .locals 3
    .param p0, "version"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 38
    if-nez p0, :cond_0

    .line 41
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "SoftwareVersion: isValidVersion: returning false because a null version was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    :goto_0
    return v0

    .line 45
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x25

    if-le v1, v2, :cond_2

    .line 47
    :cond_1
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "SoftwareVersion: isValidVersion: returning false because an invalid length was given (must be between 1 and 37 characters)."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 52
    :cond_2
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNumeric(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 54
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "SoftwareVersion: isValidVersion: returning false because version contains invalid characters (can only contain digits)"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 59
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->mSoftwareVersion:Ljava/lang/String;

    return-object v0
.end method

.method public isValid()Z
    .locals 2

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->mSoftwareVersion:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 66
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "SoftwareVersion: isValid: returning false because a valid software version has not been set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    const/4 v0, 0x0

    .line 71
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method
