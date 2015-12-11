.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$4;
.super Ljava/lang/Object;
.source "BrowseFilterDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->clearAllFilters()V

    .line 158
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    sget v1, Lcom/xfinity/playerlib/R$string;->cleared:I

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->speak(I)V

    .line 159
    return-void
.end method
