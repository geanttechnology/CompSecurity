.class public Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;
.super Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;
.source "MultipleAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MultipleAccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProfileMappingType"
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# direct methods
.method public constructor <init>(I)V
    .locals 1
    .param p1, "profileId"    # I

    .prologue
    .line 192
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;-><init>(ILcom/amazon/identity/auth/device/api/MultipleAccountManager$1;)V

    .line 193
    return-void
.end method

.method public static createCurrentProfile(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 198
    new-instance v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;-><init>(I)V

    return-object v0
.end method

.method public static createCurrentViewableProfile(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 204
    new-instance v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;-><init>(I)V

    return-object v0
.end method

.method public static isSupportedOnThisPlatform(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 209
    # getter for: Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "ProfileMappingType is deprecated. Please use PrimaryUserMappingType instead"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    const/4 v0, 0x0

    return v0
.end method
