.class public abstract Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;
.super Ljava/lang/Object;
.source "SSOIntentFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;
    }
.end annotation


# static fields
.field public static final SERVICE_FINDER:Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;


# instance fields
.field protected final mComponentName:Landroid/content/ComponentName;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    new-instance v0, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$1;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$1;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;->SERVICE_FINDER:Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;

    return-void
.end method

.method public constructor <init>(Landroid/content/ComponentName;)V
    .locals 0
    .param p1, "componentName"    # Landroid/content/ComponentName;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;->mComponentName:Landroid/content/ComponentName;

    .line 40
    return-void
.end method

.method public static findSSOComponent(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;)Landroid/content/ComponentName;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "className"    # Ljava/lang/String;
    .param p2, "finder"    # Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;

    .prologue
    .line 66
    new-instance v6, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v6, p0}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    .line 68
    .local v6, "trustedPackageMan":Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;
    const/4 v7, 0x6

    new-array v0, v7, [Landroid/content/ComponentName;

    const/4 v7, 0x0

    new-instance v8, Landroid/content/ComponentName;

    const-string/jumbo v9, "com.amazon.imp"

    invoke-direct {v8, v9, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v8, v0, v7

    const/4 v7, 0x1

    new-instance v8, Landroid/content/ComponentName;

    const-string/jumbo v9, "com.amazon.sso"

    invoke-direct {v8, v9, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v8, v0, v7

    const/4 v7, 0x2

    new-instance v8, Landroid/content/ComponentName;

    const-string/jumbo v9, "com.amazon.dcp"

    invoke-direct {v8, v9, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v8, v0, v7

    const/4 v7, 0x3

    new-instance v8, Landroid/content/ComponentName;

    const-string/jumbo v9, "com.amazon.fv"

    invoke-direct {v8, v9, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v8, v0, v7

    const/4 v7, 0x4

    new-instance v8, Landroid/content/ComponentName;

    const-string/jumbo v9, "com.amazon.canary"

    invoke-direct {v8, v9, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v8, v0, v7

    const/4 v7, 0x5

    new-instance v8, Landroid/content/ComponentName;

    invoke-direct {v8, p0, p1}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    aput-object v8, v0, v7

    .line 76
    .local v0, "arr$":[Landroid/content/ComponentName;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v2, v0, v3

    .line 78
    .local v2, "componentName":Landroid/content/ComponentName;
    invoke-interface {p2, v6, v2}, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;->componentExists(Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;Landroid/content/ComponentName;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 96
    .end local v2    # "componentName":Landroid/content/ComponentName;
    .end local v3    # "i$":I
    :goto_1
    return-object v2

    .line 76
    .restart local v2    # "componentName":Landroid/content/ComponentName;
    .restart local v3    # "i$":I
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 87
    .end local v2    # "componentName":Landroid/content/ComponentName;
    :cond_1
    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getTrustedInstalledPackages()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 89
    .local v5, "packageName":Ljava/lang/String;
    new-instance v1, Landroid/content/ComponentName;

    invoke-direct {v1, v5, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    .local v1, "compName":Landroid/content/ComponentName;
    invoke-interface {p2, v6, v1}, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;->componentExists(Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;Landroid/content/ComponentName;)Z

    move-result v7

    if-eqz v7, :cond_2

    move-object v2, v1

    .line 92
    goto :goto_1

    .line 96
    .end local v1    # "compName":Landroid/content/ComponentName;
    .end local v5    # "packageName":Ljava/lang/String;
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method


# virtual methods
.method public buildIntent()Landroid/content/Intent;
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;->buildIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public buildIntent(Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 49
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 50
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p1, :cond_0

    .line 52
    invoke-virtual {v0, p1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 55
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;->mComponentName:Landroid/content/ComponentName;

    if-eqz v1, :cond_1

    .line 57
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 59
    :cond_1
    return-object v0
.end method
