.class final Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$1;
.super Ljava/lang/Object;
.source "SSOIntentFactory.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public componentExists(Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;Landroid/content/ComponentName;)Z
    .locals 2
    .param p1, "trustedPackageMan"    # Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;
    .param p2, "componentName"    # Landroid/content/ComponentName;

    .prologue
    const/4 v0, 0x0

    .line 26
    const/16 v1, 0x80

    :try_start_0
    invoke-virtual {p1, p2, v1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getServiceInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    .line 30
    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method
