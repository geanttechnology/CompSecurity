.class Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView$1;
.super Ljava/lang/Object;
.source "PMEditListingImageSelectorView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView$1;->this$0:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 138
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView$1;->this$0:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    # getter for: Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->removeHandler:Lcom/poshmark/utils/RemoveEditListingImageListener;
    invoke-static {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->access$000(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)Lcom/poshmark/utils/RemoveEditListingImageListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 139
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView$1;->this$0:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    # getter for: Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->removeHandler:Lcom/poshmark/utils/RemoveEditListingImageListener;
    invoke-static {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->access$000(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)Lcom/poshmark/utils/RemoveEditListingImageListener;

    move-result-object v1

    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-interface {v1, v0}, Lcom/poshmark/utils/RemoveEditListingImageListener;->onDeleteButtonClick(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V

    .line 141
    :cond_0
    return-void
.end method
