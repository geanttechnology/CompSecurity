.class public final Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers;
.super Ljava/lang/Object;
.source "TokenRequestHelpers.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    return-void
.end method

.method static getRequestUrlAuthority(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "options"    # Landroid/os/Bundle;
    .param p1, "requestDomain"    # Ljava/lang/String;

    .prologue
    .line 48
    .line 49
    move-object v0, p1

    .local v0, "domain":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 51
    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers;->TAG:Ljava/lang/String;

    .line 52
    if-eqz p0, :cond_0

    .line 54
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    .line 57
    :cond_0
    if-nez v0, :cond_1

    .line 59
    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers;->TAG:Ljava/lang/String;

    .line 60
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getDefaultAmazonDomain()Ljava/lang/String;

    move-result-object v1

    .line 63
    :goto_0
    return-object v1

    :cond_1
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static getRequestUrlSchemeAndAuthority(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "options"    # Landroid/os/Bundle;
    .param p1, "protocol"    # Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;
    .param p2, "requestDomain"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-static {p0, p2}, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers;->getRequestUrlAuthority(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 41
    .local v0, "authority":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 43
    return-object v1
.end method
