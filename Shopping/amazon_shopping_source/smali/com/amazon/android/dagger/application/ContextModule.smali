.class public Lcom/amazon/android/dagger/application/ContextModule;
.super Ljava/lang/Object;
.source "ContextModule.java"


# annotations
.annotation runtime Ldagger/Module;
    library = true
.end annotation


# static fields
.field public static final SHARED_PREFERENCES_NAME:Ljava/lang/String; = "default"


# instance fields
.field private final baseContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    .line 34
    return-void
.end method


# virtual methods
.method public provideActivityManager()Landroid/app/ActivityManager;
    .locals 2
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    const-string/jumbo v1, "activity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    return-object v0
.end method

.method public provideApplication()Landroid/app/Application;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    return-object v0
.end method

.method public provideAssetManager()Landroid/content/res/AssetManager;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    return-object v0
.end method

.method public provideConnectivityManager()Landroid/net/ConnectivityManager;
    .locals 2
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    const-string/jumbo v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    return-object v0
.end method

.method public provideContext()Landroid/content/Context;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public providePackageManager()Landroid/content/pm/PackageManager;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    return-object v0
.end method

.method public provideSharedPreferences()Landroid/content/SharedPreferences;
    .locals 3
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "default"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method public provideWifiManager()Landroid/net/wifi/WifiManager;
    .locals 2
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule;->baseContext:Landroid/content/Context;

    const-string/jumbo v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    return-object v0
.end method
