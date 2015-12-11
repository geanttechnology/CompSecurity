.class public final Lcom/amazon/identity/auth/device/utils/Platform;
.super Ljava/lang/Object;
.source "Platform.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/amazon/identity/auth/device/utils/Platform;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/Platform;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method

.method public static getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceAttribute"    # Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    .prologue
    .line 37
    invoke-static {}, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->getInstance()Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;

    move-result-object v1

    invoke-virtual {v1, p0, p1}, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->get(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/Object;

    move-result-object v0

    .line 39
    .local v0, "value":Ljava/lang/Object;
    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 41
    check-cast v0, Ljava/lang/String;

    .end local v0    # "value":Ljava/lang/Object;
    return-object v0

    .line 44
    .restart local v0    # "value":Ljava/lang/Object;
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/utils/Platform;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Device Attribute %s is not of type String."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 46
    new-instance v1, Ljava/lang/RuntimeException;

    const-string/jumbo v2, "Incorrectly called getDeviceAttribute in Platform.  Try calling hasDeviceAttribute."

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static hasDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceAttribute"    # Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    .prologue
    .line 55
    invoke-static {}, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->getInstance()Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;

    move-result-object v1

    invoke-virtual {v1, p0, p1}, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->get(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/Object;

    move-result-object v0

    .line 57
    .local v0, "value":Ljava/lang/Object;
    instance-of v1, v0, Ljava/lang/Boolean;

    if-eqz v1, :cond_0

    .line 59
    check-cast v0, Ljava/lang/Boolean;

    .end local v0    # "value":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    return v1

    .line 62
    .restart local v0    # "value":Ljava/lang/Object;
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/utils/Platform;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Device Attribute %s is not of type boolean."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 64
    new-instance v1, Ljava/lang/RuntimeException;

    const-string/jumbo v2, "Incorrectly called hasDeviceAttribute in Platform.  Try calling getDeviceAttribute."

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static hasFeature(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/Feature;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "feature"    # Lcom/amazon/identity/auth/device/features/Feature;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 28
    invoke-static {}, Lcom/amazon/identity/auth/device/features/FeatureCache;->getInstance()Lcom/amazon/identity/auth/device/features/FeatureCache;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/identity/auth/device/features/FeatureCache;->get(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v0

    return v0
.end method
