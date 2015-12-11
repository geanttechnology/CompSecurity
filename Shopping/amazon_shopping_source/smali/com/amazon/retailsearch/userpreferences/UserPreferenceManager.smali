.class public Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
.super Ljava/lang/Object;
.source "UserPreferenceManager.java"


# instance fields
.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private userPreferenceChangeListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;",
            ">;"
        }
    .end annotation
.end field

.field private viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->userPreferenceChangeListeners:Ljava/util/Set;

    .line 23
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getDefaultViewType(Landroid/content/Context;)Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 28
    return-void
.end method

.method private getDefaultViewType(Landroid/content/Context;)Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 68
    const/4 v1, 0x0

    .line 71
    .local v1, "defaultViewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$string;->config_rs_default_viewtype:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 72
    .local v0, "configViewType":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->findByNameIgnoreCase(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 79
    .end local v0    # "configViewType":Ljava/lang/String;
    :goto_0
    if-eqz v1, :cond_0

    .end local v1    # "defaultViewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :goto_1
    return-object v1

    .line 74
    .restart local v1    # "defaultViewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :catch_0
    move-exception v2

    .line 76
    .local v2, "e":Ljava/lang/Exception;
    iget-object v3, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    const-string/jumbo v4, "Failed to set defaultViewType from config_rs_default_viewtype"

    invoke-interface {v3, v4, v2}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 79
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_0
    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ListView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    goto :goto_1
.end method


# virtual methods
.method public addUserPreferenceChangeListener(Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->userPreferenceChangeListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 51
    return-void
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->userPreferenceChangeListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 61
    return-void
.end method

.method public getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    return-object v0
.end method

.method public removeUserPreferenceChangeListener(Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->userPreferenceChangeListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 56
    return-void
.end method

.method public setViewType(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 3
    .param p1, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 32
    iget-object v2, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    if-ne v2, p1, :cond_1

    .line 41
    :cond_0
    return-void

    .line 36
    :cond_1
    iput-object p1, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 37
    iget-object v2, p0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->userPreferenceChangeListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;

    .line 39
    .local v1, "listener":Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;
    invoke-interface {v1, p1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;->onViewTypeUpdated(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    goto :goto_0
.end method
