.class public final Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "DidYouMeanView$$InjectAdapter.java"

# interfaces
.implements Ldagger/MembersInjector;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;",
        ">;",
        "Ldagger/MembersInjector",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;",
        ">;"
    }
.end annotation


# instance fields
.field private preferencesManager:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;",
            ">;"
        }
    .end annotation
.end field

.field private userInteractionListener:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/retailsearch/interaction/UserInteractionListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 28
    const/4 v0, 0x0

    const-string/jumbo v1, "members/com.amazon.retailsearch.android.ui.results.layout.view.DidYouMeanView"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 29
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 38
    const-string/jumbo v0, "com.amazon.retailsearch.interaction.UserInteractionListener"

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$$InjectAdapter;->userInteractionListener:Ldagger/internal/Binding;

    .line 39
    const-string/jumbo v0, "com.amazon.retailsearch.userpreferences.UserPreferenceManager"

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$$InjectAdapter;->preferencesManager:Ldagger/internal/Binding;

    .line 40
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
    .line 48
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$$InjectAdapter;->userInteractionListener:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 49
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$$InjectAdapter;->preferencesManager:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 50
    return-void
.end method

.method public injectMembers(Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;)V
    .locals 1
    .param p1, "object"    # Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$$InjectAdapter;->userInteractionListener:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iput-object v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    .line 59
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$$InjectAdapter;->preferencesManager:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    iput-object v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    .line 60
    return-void
.end method

.method public bridge synthetic injectMembers(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 22
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$$InjectAdapter;->injectMembers(Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;)V

    return-void
.end method
