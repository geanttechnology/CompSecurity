.class Lnet/singular/sdk/AdvertisingIdHelper;
.super Ljava/lang/Object;
.source "AdvertisingIdHelper.java"


# instance fields
.field advertisingInfo:Ljava/lang/Object;

.field private final context:Landroid/content/Context;

.field getIdMethod:Ljava/lang/reflect/Method;

.field isLimitAdTrackingEnabledMethod:Ljava/lang/reflect/Method;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object v0, p0, Lnet/singular/sdk/AdvertisingIdHelper;->advertisingInfo:Ljava/lang/Object;

    .line 14
    iput-object v0, p0, Lnet/singular/sdk/AdvertisingIdHelper;->isLimitAdTrackingEnabledMethod:Ljava/lang/reflect/Method;

    .line 15
    iput-object v0, p0, Lnet/singular/sdk/AdvertisingIdHelper;->getIdMethod:Ljava/lang/reflect/Method;

    .line 18
    iput-object p1, p0, Lnet/singular/sdk/AdvertisingIdHelper;->context:Landroid/content/Context;

    .line 19
    return-void
.end method


# virtual methods
.method public cleanupClass()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 39
    iput-object v0, p0, Lnet/singular/sdk/AdvertisingIdHelper;->advertisingInfo:Ljava/lang/Object;

    .line 40
    iput-object v0, p0, Lnet/singular/sdk/AdvertisingIdHelper;->isLimitAdTrackingEnabledMethod:Ljava/lang/reflect/Method;

    .line 41
    iput-object v0, p0, Lnet/singular/sdk/AdvertisingIdHelper;->getIdMethod:Ljava/lang/reflect/Method;

    .line 42
    return-void
.end method

.method public getId()Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/reflect/InvocationTargetException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lnet/singular/sdk/AdvertisingIdHelper;->getIdMethod:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lnet/singular/sdk/AdvertisingIdHelper;->advertisingInfo:Ljava/lang/Object;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public initializeClass()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/reflect/InvocationTargetException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 27
    const-string v2, "com.google.android.gms.ads.identifier.AdvertisingIdClient"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 29
    .local v0, "AdvertisingIdClient":Ljava/lang/Class;
    const-string v2, "getAdvertisingIdInfo"

    new-array v3, v6, [Ljava/lang/Class;

    const-class v4, Landroid/content/Context;

    aput-object v4, v3, v5

    invoke-virtual {v0, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 31
    .local v1, "getAdvertisingInfo":Ljava/lang/reflect/Method;
    const/4 v2, 0x0

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lnet/singular/sdk/AdvertisingIdHelper;->context:Landroid/content/Context;

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    iput-object v2, p0, Lnet/singular/sdk/AdvertisingIdHelper;->advertisingInfo:Ljava/lang/Object;

    .line 33
    iget-object v2, p0, Lnet/singular/sdk/AdvertisingIdHelper;->advertisingInfo:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "isLimitAdTrackingEnabled"

    new-array v4, v5, [Ljava/lang/Class;

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    iput-object v2, p0, Lnet/singular/sdk/AdvertisingIdHelper;->isLimitAdTrackingEnabledMethod:Ljava/lang/reflect/Method;

    .line 35
    iget-object v2, p0, Lnet/singular/sdk/AdvertisingIdHelper;->advertisingInfo:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "getId"

    new-array v4, v5, [Ljava/lang/Class;

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    iput-object v2, p0, Lnet/singular/sdk/AdvertisingIdHelper;->getIdMethod:Ljava/lang/reflect/Method;

    .line 36
    return-void
.end method

.method public isLimitAdTrackingEnabled()Z
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/reflect/InvocationTargetException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lnet/singular/sdk/AdvertisingIdHelper;->isLimitAdTrackingEnabledMethod:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lnet/singular/sdk/AdvertisingIdHelper;->advertisingInfo:Ljava/lang/Object;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method
