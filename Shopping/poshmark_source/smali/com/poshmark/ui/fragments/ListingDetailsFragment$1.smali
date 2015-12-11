.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setupListItemClickListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0

    .prologue
    .line 186
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 9
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .line 189
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 190
    .local v2, "commentIndex":I
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingDetails;->getComments()Ljava/util/List;

    move-result-object v0

    .line 191
    .local v0, "allComments":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    if-le v5, v2, :cond_0

    .line 192
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 193
    .local v1, "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    iget-object v4, v1, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_display_handle:Ljava/lang/String;

    .line 194
    .local v4, "commentorHandle":Ljava/lang/String;
    iget-object v3, v1, Lcom/poshmark/data_model/models/inner_models/Comment;->comment:Ljava/lang/String;

    .line 196
    .local v3, "commentText":Ljava/lang/String;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const-string v6, "Delete Comment!!"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Are you sure you want to delete this comment by @"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ":\n"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;

    invoke-direct {v8, p0, v1, v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;Lcom/poshmark/data_model/models/inner_models/Comment;I)V

    invoke-virtual {v5, v6, v7, v8}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 217
    .end local v1    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    .end local v3    # "commentText":Ljava/lang/String;
    .end local v4    # "commentorHandle":Ljava/lang/String;
    :cond_0
    const/4 v5, 0x1

    return v5
.end method
