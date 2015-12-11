.class public Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;
.super Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
.source "MultipleAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MultipleAccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PackageMappingType"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 160
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.extratokens.account_packages"

    invoke-direct {p0, v0, p1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    return-void
.end method

.method public static createCurrentPackageMapping(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 165
    new-instance v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static isSupportedOnThisPlatform(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 170
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    .line 171
    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 174
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isFullMAPR5()Z

    move-result v0

    return v0
.end method
