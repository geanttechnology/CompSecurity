.class final enum Lcom/amazon/identity/auth/device/features/Feature$7;
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
    .line 134
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/features/Feature;-><init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/features/Feature$1;)V

    return-void
.end method


# virtual methods
.method fetchValue(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 139
    invoke-static {p1}, Lcom/amazon/identity/platform/util/PlatformUtils;->isThirdPartyDevice(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 141
    const/4 v0, 0x1

    .line 143
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
