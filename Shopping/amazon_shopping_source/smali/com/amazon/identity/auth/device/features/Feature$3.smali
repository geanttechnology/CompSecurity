.class final enum Lcom/amazon/identity/auth/device/features/Feature$3;
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
    .line 54
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/features/Feature;-><init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/features/Feature$1;)V

    return-void
.end method


# virtual methods
.method fetchValue(Landroid/content/Context;)Z
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 64
    new-instance v2, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;

    invoke-direct {v2}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;-><init>()V

    .line 65
    const-string/jumbo v3, "com.amazon.map.registration"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 66
    .local v0, "registration":Ljava/lang/String;
    const-string/jumbo v2, "panda"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 71
    :cond_0
    :goto_0
    return v1

    :cond_1
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->hasCentralAPK(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x0

    goto :goto_0
.end method
