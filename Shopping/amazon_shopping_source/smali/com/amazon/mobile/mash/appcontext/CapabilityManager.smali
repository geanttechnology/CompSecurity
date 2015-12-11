.class public Lcom/amazon/mobile/mash/appcontext/CapabilityManager;
.super Ljava/lang/Object;
.source "CapabilityManager.java"


# instance fields
.field private mApplicationContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mobile/mash/appcontext/CapabilityManager;->mApplicationContext:Landroid/content/Context;

    .line 32
    invoke-static {p0}, Lcom/amazon/mobile/mash/appcontext/Capability;->init(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V

    .line 33
    return-void
.end method


# virtual methods
.method public formatCapabilities()J
    .locals 11

    .prologue
    .line 43
    const-wide/16 v3, 0x0

    .line 44
    .local v3, "cp":J
    invoke-static {}, Lcom/amazon/mobile/mash/appcontext/Capability;->values()[Lcom/amazon/mobile/mash/appcontext/Capability;

    move-result-object v2

    .line 45
    .local v2, "capabilities":[Lcom/amazon/mobile/mash/appcontext/Capability;
    move-object v0, v2

    .local v0, "arr$":[Lcom/amazon/mobile/mash/appcontext/Capability;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_1

    aget-object v1, v0, v5

    .line 46
    .local v1, "c":Lcom/amazon/mobile/mash/appcontext/Capability;
    invoke-virtual {v1}, Lcom/amazon/mobile/mash/appcontext/Capability;->isAvailable()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 47
    const-wide/high16 v7, 0x4000000000000000L    # 2.0

    invoke-virtual {v1}, Lcom/amazon/mobile/mash/appcontext/Capability;->getCapabilityId()I

    move-result v9

    int-to-double v9, v9

    invoke-static {v7, v8, v9, v10}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v7

    double-to-long v7, v7

    or-long/2addr v3, v7

    .line 45
    :cond_0
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 50
    .end local v1    # "c":Lcom/amazon/mobile/mash/appcontext/Capability;
    :cond_1
    return-wide v3
.end method

.method public isAvailableAivPlayback()Z
    .locals 1

    .prologue
    .line 112
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableAppNavMenu()Z
    .locals 1

    .prologue
    .line 87
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableAppstore()Z
    .locals 1

    .prologue
    .line 136
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableEnforceParentalControls()Z
    .locals 1

    .prologue
    .line 104
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableShowAdsBrowser()Z
    .locals 1

    .prologue
    .line 120
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableShowAmazonPoints()Z
    .locals 1

    .prologue
    .line 69
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableShowCardScannerCredit()Z
    .locals 1

    .prologue
    .line 128
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableShowContactPicker()Z
    .locals 2

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mobile/mash/appcontext/CapabilityManager;->mApplicationContext:Landroid/content/Context;

    const-string/jumbo v1, "android.permission.GET_ACCOUNTS"

    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/util/MASHUtil;->isAndroidPermissionGranted(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mobile/mash/appcontext/CapabilityManager;->mApplicationContext:Landroid/content/Context;

    const-string/jumbo v1, "android.permission.READ_CONTACTS"

    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/util/MASHUtil;->isAndroidPermissionGranted(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAvailableShowDeliveryDestinationPicker()Z
    .locals 1

    .prologue
    .line 78
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableShowNotificationSettings()Z
    .locals 1

    .prologue
    .line 96
    const/4 v0, 0x0

    return v0
.end method

.method public isAvailableSmile()Z
    .locals 1

    .prologue
    .line 143
    const/4 v0, 0x0

    return v0
.end method
