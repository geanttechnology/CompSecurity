.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$2;
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
    .line 137
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 140
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    # invokes: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->handleBackButton()Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->access$200(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Z

    .line 141
    return-void
.end method
