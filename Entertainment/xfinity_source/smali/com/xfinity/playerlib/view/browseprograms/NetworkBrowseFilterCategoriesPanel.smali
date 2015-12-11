.class public Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;
.super Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
.source "NetworkBrowseFilterCategoriesPanel.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;-><init>()V

    return-void
.end method

.method public static newInstance(Z)Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;
    .locals 3
    .param p0, "isDualPanel"    # Z

    .prologue
    .line 15
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 16
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "isDualPanel"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 18
    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;

    invoke-direct {v1}, Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;-><init>()V

    .line 19
    .local v1, "browseFilterCategoriesPanel":Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;->setArguments(Landroid/os/Bundle;)V

    .line 21
    return-object v1
.end method


# virtual methods
.method protected addNetworkCategoryView(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 0
    .param p1, "filter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 35
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v1

    .line 27
    .local v1, "view":Landroid/view/View;
    sget v2, Lcom/xfinity/playerlib/R$id;->subscription_only_checkbox_container:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 28
    .local v0, "subscriptionOnlyCheckboxContainer":Landroid/view/View;
    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 29
    return-object v1
.end method
