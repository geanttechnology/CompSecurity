.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$3;
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
    .line 146
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 149
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->handleDone()V

    .line 150
    return-void
.end method
