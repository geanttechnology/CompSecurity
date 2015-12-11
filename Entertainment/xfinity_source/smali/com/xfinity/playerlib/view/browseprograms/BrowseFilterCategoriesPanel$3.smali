.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$3;
.super Ljava/lang/Object;
.source "BrowseFilterCategoriesPanel.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 1
    .param p1, "compoundButton"    # Landroid/widget/CompoundButton;
    .param p2, "checked"    # Z

    .prologue
    .line 89
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->access$000(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    move-result-object v0

    invoke-interface {v0, p2}, Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;->onDownloadOnlyChanged(Z)V

    .line 90
    return-void
.end method
