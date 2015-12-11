.class public final Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideAssetManagerProvidesAdapter;
.super Ldagger/internal/ProvidesBinding;
.source "ContextModule$$ModuleAdapter.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ProvideAssetManagerProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Landroid/content/res/AssetManager;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Landroid/content/res/AssetManager;",
        ">;"
    }
.end annotation


# instance fields
.field private final module:Lcom/amazon/android/dagger/application/ContextModule;


# direct methods
.method public constructor <init>(Lcom/amazon/android/dagger/application/ContextModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/android/dagger/application/ContextModule;

    .prologue
    .line 185
    const-string/jumbo v0, "android.content.res.AssetManager"

    const/4 v1, 0x0

    const-string/jumbo v2, "com.amazon.android.dagger.application.ContextModule"

    const-string/jumbo v3, "provideAssetManager"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 186
    iput-object p1, p0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideAssetManagerProvidesAdapter;->module:Lcom/amazon/android/dagger/application/ContextModule;

    .line 187
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideAssetManagerProvidesAdapter;->setLibrary(Z)V

    .line 188
    return-void
.end method


# virtual methods
.method public get()Landroid/content/res/AssetManager;
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideAssetManagerProvidesAdapter;->module:Lcom/amazon/android/dagger/application/ContextModule;

    invoke-virtual {v0}, Lcom/amazon/android/dagger/application/ContextModule;->provideAssetManager()Landroid/content/res/AssetManager;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 180
    invoke-virtual {p0}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideAssetManagerProvidesAdapter;->get()Landroid/content/res/AssetManager;

    move-result-object v0

    return-object v0
.end method
