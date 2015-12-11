.class public final Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;
.super Ldagger/internal/ModuleAdapter;
.source "ContextModule$$ModuleAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideWifiManagerProvidesAdapter;,
        Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideConnectivityManagerProvidesAdapter;,
        Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideAssetManagerProvidesAdapter;,
        Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideSharedPreferencesProvidesAdapter;,
        Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvidePackageManagerProvidesAdapter;,
        Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideActivityManagerProvidesAdapter;,
        Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideApplicationProvidesAdapter;,
        Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideContextProvidesAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ModuleAdapter",
        "<",
        "Lcom/amazon/android/dagger/application/ContextModule;",
        ">;"
    }
.end annotation


# static fields
.field private static final INCLUDES:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private static final INJECTS:[Ljava/lang/String;

.field private static final STATIC_INJECTIONS:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 14
    new-array v0, v1, [Ljava/lang/String;

    sput-object v0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;->INJECTS:[Ljava/lang/String;

    .line 15
    new-array v0, v1, [Ljava/lang/Class;

    sput-object v0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;->STATIC_INJECTIONS:[Ljava/lang/Class;

    .line 16
    new-array v0, v1, [Ljava/lang/Class;

    sput-object v0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;->INCLUDES:[Ljava/lang/Class;

    return-void
.end method

.method public constructor <init>()V
    .locals 8

    .prologue
    const/4 v6, 0x1

    .line 19
    const-class v1, Lcom/amazon/android/dagger/application/ContextModule;

    sget-object v2, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;->INJECTS:[Ljava/lang/String;

    sget-object v3, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;->STATIC_INJECTIONS:[Ljava/lang/Class;

    const/4 v4, 0x0

    sget-object v5, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;->INCLUDES:[Ljava/lang/Class;

    move-object v0, p0

    move v7, v6

    invoke-direct/range {v0 .. v7}, Ldagger/internal/ModuleAdapter;-><init>(Ljava/lang/Class;[Ljava/lang/String;[Ljava/lang/Class;Z[Ljava/lang/Class;ZZ)V

    .line 20
    return-void
.end method


# virtual methods
.method public getBindings(Ldagger/internal/BindingsGroup;Lcom/amazon/android/dagger/application/ContextModule;)V
    .locals 2
    .param p1, "bindings"    # Ldagger/internal/BindingsGroup;
    .param p2, "module"    # Lcom/amazon/android/dagger/application/ContextModule;

    .prologue
    .line 28
    const-string/jumbo v0, "android.content.Context"

    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideContextProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideContextProvidesAdapter;-><init>(Lcom/amazon/android/dagger/application/ContextModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 29
    const-string/jumbo v0, "android.app.Application"

    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideApplicationProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideApplicationProvidesAdapter;-><init>(Lcom/amazon/android/dagger/application/ContextModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 30
    const-string/jumbo v0, "android.app.ActivityManager"

    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideActivityManagerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideActivityManagerProvidesAdapter;-><init>(Lcom/amazon/android/dagger/application/ContextModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 31
    const-string/jumbo v0, "android.content.pm.PackageManager"

    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvidePackageManagerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvidePackageManagerProvidesAdapter;-><init>(Lcom/amazon/android/dagger/application/ContextModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 32
    const-string/jumbo v0, "android.content.SharedPreferences"

    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideSharedPreferencesProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideSharedPreferencesProvidesAdapter;-><init>(Lcom/amazon/android/dagger/application/ContextModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 33
    const-string/jumbo v0, "android.content.res.AssetManager"

    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideAssetManagerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideAssetManagerProvidesAdapter;-><init>(Lcom/amazon/android/dagger/application/ContextModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 34
    const-string/jumbo v0, "android.net.ConnectivityManager"

    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideConnectivityManagerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideConnectivityManagerProvidesAdapter;-><init>(Lcom/amazon/android/dagger/application/ContextModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 35
    const-string/jumbo v0, "android.net.wifi.WifiManager"

    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideWifiManagerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideWifiManagerProvidesAdapter;-><init>(Lcom/amazon/android/dagger/application/ContextModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 36
    return-void
.end method

.method public bridge synthetic getBindings(Ldagger/internal/BindingsGroup;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ldagger/internal/BindingsGroup;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 13
    check-cast p2, Lcom/amazon/android/dagger/application/ContextModule;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;->getBindings(Ldagger/internal/BindingsGroup;Lcom/amazon/android/dagger/application/ContextModule;)V

    return-void
.end method
