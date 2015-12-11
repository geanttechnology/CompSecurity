.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$4;
.super Ljava/lang/Object;
.source "BrowseFilterCategoriesPanel.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 95
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 98
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->downloadableCheckbox:Landroid/widget/CheckBox;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->access$100(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)Landroid/widget/CheckBox;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/CheckBox;->performClick()Z

    .line 99
    return-void
.end method
