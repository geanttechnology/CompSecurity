.class public final Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;
.super Ljava/lang/Object;
.source "DeviceAttributeCache.java"


# static fields
.field private static final INSTANCE:Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mCache:Ljava/util/EnumMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/EnumMap",
            "<",
            "Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->LOG_TAG:Ljava/lang/String;

    .line 19
    new-instance v0, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->INSTANCE:Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Ljava/util/EnumMap;

    const-class v1, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-direct {v0, v1}, Ljava/util/EnumMap;-><init>(Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->mCache:Ljava/util/EnumMap;

    .line 25
    return-void
.end method

.method private declared-synchronized fetchAndSetDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/Object;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceAttribute"    # Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    .prologue
    .line 52
    monitor-enter p0

    :try_start_0
    invoke-virtual {p2, p1}, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->fetchValue(Landroid/content/Context;)Ljava/lang/Object;

    move-result-object v1

    .line 59
    .local v1, "value":Ljava/lang/Object;
    instance-of v2, v1, Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 61
    move-object v0, v1

    check-cast v0, Ljava/lang/String;

    move-object v2, v0

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-eqz v2, :cond_0

    .line 71
    :goto_0
    monitor-exit p0

    return-object v1

    .line 68
    :cond_0
    :try_start_1
    sget-object v2, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "Setting device attribute %s to %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    iget-object v2, p0, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->mCache:Ljava/util/EnumMap;

    invoke-virtual {v2, p2, v1}, Ljava/util/EnumMap;->put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 52
    .end local v1    # "value":Ljava/lang/Object;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public static getInstance()Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->INSTANCE:Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;

    return-object v0
.end method


# virtual methods
.method public declared-synchronized get(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/Object;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceAttribute"    # Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    .prologue
    .line 37
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->mCache:Ljava/util/EnumMap;

    invoke-virtual {v1, p2}, Ljava/util/EnumMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 39
    .local v0, "value":Ljava/lang/Object;
    if-eqz v0, :cond_0

    .line 44
    .end local v0    # "value":Ljava/lang/Object;
    :goto_0
    monitor-exit p0

    return-object v0

    .restart local v0    # "value":Ljava/lang/Object;
    :cond_0
    :try_start_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/attribute/DeviceAttributeCache;->fetchAndSetDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_0

    .line 37
    .end local v0    # "value":Ljava/lang/Object;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
