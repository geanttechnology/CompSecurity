.class public final Lcom/adobe/mediacore/qos/DeviceInformation;
.super Ljava/lang/Object;


# instance fields
.field private final _densityDPI:I

.field private final _heightPixels:I

.field private final _id:Ljava/lang/String;

.field private final _manufacturer:Ljava/lang/String;

.field private final _model:Ljava/lang/String;

.field private final _os:Ljava/lang/String;

.field private final _sdk:I

.field private final _widthPixels:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    iput-object v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_os:Ljava/lang/String;

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    iput v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_sdk:I

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    iput-object v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_model:Ljava/lang/String;

    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    iput-object v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_manufacturer:Ljava/lang/String;

    sget-object v0, Landroid/os/Build;->ID:Ljava/lang/String;

    iput-object v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_id:Ljava/lang/String;

    const-string v0, "window"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    invoke-virtual {v1, v2}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    iget v1, v2, Landroid/util/DisplayMetrics;->densityDpi:I

    iput v1, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_densityDPI:I

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/adobe/mediacore/qos/DeviceInformation;->getScreenSize(Landroid/view/WindowManager;Landroid/content/res/Resources;)Landroid/graphics/Point;

    move-result-object v0

    iget v1, v0, Landroid/graphics/Point;->y:I

    iput v1, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_heightPixels:I

    iget v0, v0, Landroid/graphics/Point;->x:I

    iput v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_widthPixels:I

    return-void
.end method

.method private getScreenSize(Landroid/view/WindowManager;Landroid/content/res/Resources;)Landroid/graphics/Point;
    .locals 6

    :try_start_0
    invoke-interface {p1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    const-class v0, Landroid/view/Display;

    const-string v1, "getRawWidth"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Class;

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    const-class v1, Landroid/view/Display;

    const-string v3, "getRawHeight"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Class;

    invoke-virtual {v1, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {v0, v2, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    invoke-virtual {v3, v2, v0}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v2

    iget v2, v2, Landroid/content/res/Configuration;->orientation:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v3, 0x1

    if-ne v2, v3, :cond_1

    if-le v1, v0, :cond_0

    move v5, v1

    move v1, v0

    move v0, v5

    :cond_0
    :goto_0
    new-instance v2, Landroid/graphics/Point;

    invoke-direct {v2, v1, v0}, Landroid/graphics/Point;-><init>(II)V

    return-object v2

    :cond_1
    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    if-ge v1, v0, :cond_0

    move v5, v1

    move v1, v0

    move v0, v5

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-interface {p1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    invoke-virtual {v0, v2}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    iget v1, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v0, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    goto :goto_0
.end method


# virtual methods
.method public getDensityDPI()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_densityDPI:I

    return v0
.end method

.method public getHeightPixels()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_heightPixels:I

    return v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_id:Ljava/lang/String;

    return-object v0
.end method

.method public getManufacturer()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_manufacturer:Ljava/lang/String;

    return-object v0
.end method

.method public getModel()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_model:Ljava/lang/String;

    return-object v0
.end method

.method public getOS()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_os:Ljava/lang/String;

    return-object v0
.end method

.method public getSDK()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_sdk:I

    return v0
.end method

.method public getWidthPixels()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/qos/DeviceInformation;->_widthPixels:I

    return v0
.end method
