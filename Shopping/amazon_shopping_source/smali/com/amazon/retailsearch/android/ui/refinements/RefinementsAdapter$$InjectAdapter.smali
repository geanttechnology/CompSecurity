.class public final Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "RefinementsAdapter$$InjectAdapter.java"

# interfaces
.implements Ldagger/MembersInjector;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;",
        ">;",
        "Ldagger/MembersInjector",
        "<",
        "Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;",
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

.field private retailSearchDataProvider:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
            ">;>;"
        }
    .end annotation
.end field

.field private supertype:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 29
    const/4 v0, 0x0

    const-string/jumbo v1, "members/com.amazon.retailsearch.android.ui.refinements.RefinementsAdapter"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 30
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 6
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 39
    const-string/jumbo v0, "dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>"

    const-class v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->retailSearchDataProvider:Ldagger/internal/Binding;

    .line 40
    const-string/jumbo v0, "com.amazon.retailsearch.userpreferences.UserPreferenceManager"

    const-class v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->preferencesManager:Ldagger/internal/Binding;

    .line 41
    const-string/jumbo v1, "members/com.amazon.retailsearch.android.ui.AnimatedExpandableListView$AnimatedExpandableListAdapter"

    const-class v2, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;ZZ)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->supertype:Ldagger/internal/Binding;

    .line 42
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
    .line 50
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->retailSearchDataProvider:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 51
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->preferencesManager:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->supertype:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 53
    return-void
.end method

.method public injectMembers(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;)V
    .locals 1
    .param p1, "object"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->retailSearchDataProvider:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ldagger/Lazy;

    iput-object v0, p1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->retailSearchDataProvider:Ldagger/Lazy;

    .line 62
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->preferencesManager:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    iput-object v0, p1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    .line 63
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->supertype:Ldagger/internal/Binding;

    invoke-virtual {v0, p1}, Ldagger/internal/Binding;->injectMembers(Ljava/lang/Object;)V

    .line 64
    return-void
.end method

.method public bridge synthetic injectMembers(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 22
    check-cast p1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$$InjectAdapter;->injectMembers(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;)V

    return-void
.end method
