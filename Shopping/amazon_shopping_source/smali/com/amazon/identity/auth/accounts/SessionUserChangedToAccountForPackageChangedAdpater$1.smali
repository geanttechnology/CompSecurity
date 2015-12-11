.class Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater$1;
.super Ljava/lang/Object;
.source "SessionUserChangedToAccountForPackageChangedAdpater.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater$1;->this$0:Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 33
    # getter for: Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->access$000()Ljava/lang/String;

    .line 35
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater$1;->val$context:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    .line 36
    .local v0, "wrappedContext":Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 39
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 41
    # getter for: Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->access$000()Ljava/lang/String;

    .line 46
    :goto_0
    return-void

    .line 45
    :cond_0
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->sendAccountForPackageChangedBroadcast(Landroid/content/Context;)V

    goto :goto_0
.end method
