.class public final Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "ThumbSwitcher$$InjectAdapter.java"

# interfaces
.implements Ldagger/MembersInjector;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;",
        ">;",
        "Ldagger/MembersInjector",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;",
        ">;"
    }
.end annotation


# instance fields
.field private platform:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 27
    const/4 v0, 0x0

    const-string/jumbo v1, "members/com.amazon.retailsearch.android.ui.results.views.image.ThumbSwitcher"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 28
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 37
    const-string/jumbo v0, "com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform"

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$$InjectAdapter;->platform:Ldagger/internal/Binding;

    .line 38
    return-void
.end method

.method public getDependencies(Ljava/util/Set;Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$$InjectAdapter;->platform:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 47
    return-void
.end method

.method public injectMembers(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)V
    .locals 1
    .param p1, "object"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$$InjectAdapter;->platform:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    iput-object v0, p1, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    .line 56
    return-void
.end method

.method public bridge synthetic injectMembers(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 22
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$$InjectAdapter;->injectMembers(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)V

    return-void
.end method
