.class public final Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideActivityManagerProvidesAdapter;
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
    name = "ProvideActivityManagerProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Landroid/app/ActivityManager;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Landroid/app/ActivityManager;",
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
    .line 104
    const-string/jumbo v0, "android.app.ActivityManager"

    const/4 v1, 0x0

    const-string/jumbo v2, "com.amazon.android.dagger.application.ContextModule"

    const-string/jumbo v3, "provideActivityManager"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 105
    iput-object p1, p0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideActivityManagerProvidesAdapter;->module:Lcom/amazon/android/dagger/application/ContextModule;

    .line 106
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideActivityManagerProvidesAdapter;->setLibrary(Z)V

    .line 107
    return-void
.end method


# virtual methods
.method public get()Landroid/app/ActivityManager;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideActivityManagerProvidesAdapter;->module:Lcom/amazon/android/dagger/application/ContextModule;

    invoke-virtual {v0}, Lcom/amazon/android/dagger/application/ContextModule;->provideActivityManager()Landroid/app/ActivityManager;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 99
    invoke-virtual {p0}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideActivityManagerProvidesAdapter;->get()Landroid/app/ActivityManager;

    move-result-object v0

    return-object v0
.end method
