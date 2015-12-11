.class final enum Lcom/amazon/identity/auth/device/features/Feature$8;
.super Lcom/amazon/identity/auth/device/features/Feature;
.source "Feature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/features/Feature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 150
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/features/Feature;-><init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/features/Feature$1;)V

    return-void
.end method


# virtual methods
.method fetchValue(Landroid/content/Context;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 155
    invoke-static {p1}, Lcom/amazon/identity/platform/util/PlatformUtils;->isGen6Tablet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Lcom/amazon/identity/platform/util/PlatformUtils;->isGen7Tablet(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 160
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v0

    const-string/jumbo v1, "use_central_local_database"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 162
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
