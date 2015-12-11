.class public Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;
.super Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
.source "MultipleAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MultipleAccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SessionUserMappingType"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 128
    const-string/jumbo v0, "com.amazon.dcp.sso.property.sessionuser"

    const-string/jumbo v1, "true"

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    return-void
.end method

.method public static isSupportedOnThisPlatform(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 133
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    .line 134
    const-string/jumbo v2, "sso_platform"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 137
    .local v0, "platform":Lcom/amazon/identity/auth/device/framework/PlatformWrapper;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isFullMAPR5()Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "com.amazon.dcp.sso.action.central.session.user.change"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->unSecureCheckHasServiceWithAction(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
