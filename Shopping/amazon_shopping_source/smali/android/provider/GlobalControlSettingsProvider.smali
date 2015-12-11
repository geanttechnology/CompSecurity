.class public Landroid/provider/GlobalControlSettingsProvider;
.super Ljava/lang/Object;
.source "GlobalControlSettingsProvider.java"


# static fields
.field private static final POLICIES:[Ljava/lang/String;


# instance fields
.field private mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 181
    const/16 v0, 0x15

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "device.policy.protect.settings.browser"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "device.policy.protect.deregistration"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "device.policy.protect.kindlestore"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "device.policy.protect.archiveditems"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "device.policy.protect.settings"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "device.policy.force.devicepassword"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "device.policy.protect.allowinstallation"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "device.policy.protect.factoryreset"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "device.policy.protect.wifi"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "device.policy.protect.settings.content_libraries"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "device.policy.content.books"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string/jumbo v2, "device.policy.content.newstand"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "device.policy.content.music"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string/jumbo v2, "device.policy.content.video"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string/jumbo v2, "device.policy.content.docs"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string/jumbo v2, "device.policy.content.apps"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string/jumbo v2, "device.policy.content.games"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string/jumbo v2, "device.policy.content.gallery"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string/jumbo v2, "device.policy.content.messaging"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string/jumbo v2, "device.policy.content.archive"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string/jumbo v2, "device.policy.content.online"

    aput-object v2, v0, v1

    sput-object v0, Landroid/provider/GlobalControlSettingsProvider;->POLICIES:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 209
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 210
    iput-object p1, p0, Landroid/provider/GlobalControlSettingsProvider;->mContext:Landroid/content/Context;

    .line 211
    return-void
.end method

.method private getPermission(Ljava/lang/String;)Z
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 219
    iget-object v2, p0, Landroid/provider/GlobalControlSettingsProvider;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-static {v2, p1, v1}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    if-ne v2, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method


# virtual methods
.method public getPermissionValue(Ljava/lang/String;)Z
    .locals 3
    .param p1, "feature_key"    # Ljava/lang/String;

    .prologue
    .line 265
    invoke-virtual {p0}, Landroid/provider/GlobalControlSettingsProvider;->isDevicePolicyEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 268
    const-string/jumbo v1, "device.policy."

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 269
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "device.policy."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Landroid/provider/GlobalControlSettingsProvider;->getPermission(Ljava/lang/String;)Z

    move-result v1

    .line 277
    :goto_0
    return v1

    .line 271
    :cond_0
    invoke-direct {p0, p1}, Landroid/provider/GlobalControlSettingsProvider;->getPermission(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0

    .line 274
    :cond_1
    new-instance v0, Landroid/provider/ParentalControlSettingsHelper;

    iget-object v1, p0, Landroid/provider/GlobalControlSettingsProvider;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/provider/ParentalControlSettingsHelper;-><init>(Landroid/content/Context;)V

    .line 277
    .local v0, "provider":Landroid/provider/ParentalControlSettingsHelper;
    invoke-direct {p0, p1}, Landroid/provider/GlobalControlSettingsProvider;->getPermission(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method

.method public getPolicyId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 357
    iget-object v0, p0, Landroid/provider/GlobalControlSettingsProvider;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string/jumbo v1, "device.policy.id"

    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isDevicePolicyEnabled()Z
    .locals 1

    .prologue
    .line 289
    invoke-virtual {p0}, Landroid/provider/GlobalControlSettingsProvider;->getPolicyId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPINOn()Z
    .locals 1

    .prologue
    .line 247
    invoke-virtual {p0}, Landroid/provider/GlobalControlSettingsProvider;->isParentalPINOn()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Landroid/provider/GlobalControlSettingsProvider;->isDevicePolicyEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isParentalPINOn()Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 251
    iget-object v1, p0, Landroid/provider/GlobalControlSettingsProvider;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string/jumbo v2, "parental_control"

    const/4 v3, -0x1

    invoke-static {v1, v2, v3}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-ne v1, v0, :cond_0

    .line 254
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
