.class public Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;
.super Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
.source "MultipleAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MultipleAccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PrimaryUserMappingType"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 94
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getMyUserId()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;-><init>(I)V

    .line 95
    return-void
.end method

.method private constructor <init>(I)V
    .locals 2
    .param p1, "profileUserId"    # I

    .prologue
    .line 99
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.extratokens.account_profiles"

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    return-void
.end method

.method synthetic constructor <init>(ILcom/amazon/identity/auth/device/api/MultipleAccountManager$1;)V
    .locals 0
    .param p1, "x0"    # I
    .param p2, "x1"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$1;

    .prologue
    .line 90
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;-><init>(I)V

    return-void
.end method

.method public static createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;
    .locals 1
    .param p0, "profileUserId"    # I

    .prologue
    .line 104
    new-instance v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;-><init>(I)V

    return-object v0
.end method

.method public static isSupportedOnThisPlatform(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 109
    const/4 v0, 0x1

    return v0
.end method
