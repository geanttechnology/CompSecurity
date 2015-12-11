.class public final Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideSharedPreferencesProvidesAdapter;
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
    name = "ProvideSharedPreferencesProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Landroid/content/SharedPreferences;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Landroid/content/SharedPreferences;",
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
    .line 158
    const-string/jumbo v0, "android.content.SharedPreferences"

    const/4 v1, 0x0

    const-string/jumbo v2, "com.amazon.android.dagger.application.ContextModule"

    const-string/jumbo v3, "provideSharedPreferences"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 159
    iput-object p1, p0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideSharedPreferencesProvidesAdapter;->module:Lcom/amazon/android/dagger/application/ContextModule;

    .line 160
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideSharedPreferencesProvidesAdapter;->setLibrary(Z)V

    .line 161
    return-void
.end method


# virtual methods
.method public get()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideSharedPreferencesProvidesAdapter;->module:Lcom/amazon/android/dagger/application/ContextModule;

    invoke-virtual {v0}, Lcom/amazon/android/dagger/application/ContextModule;->provideSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 153
    invoke-virtual {p0}, Lcom/amazon/android/dagger/application/ContextModule$$ModuleAdapter$ProvideSharedPreferencesProvidesAdapter;->get()Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method
