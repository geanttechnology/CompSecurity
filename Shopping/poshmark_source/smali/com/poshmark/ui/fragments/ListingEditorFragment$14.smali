.class Lcom/poshmark/ui/fragments/ListingEditorFragment$14;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Lcom/poshmark/utils/RemoveEditListingImageListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V
    .locals 0

    .prologue
    .line 917
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$14;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDeleteButtonClick(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V
    .locals 2
    .param p1, "view"    # Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .prologue
    .line 920
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->resetImageView()V

    .line 921
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 922
    .local v0, "index":I
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$14;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 924
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$14;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageOrder()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->access$400(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    .line 925
    return-void
.end method
