.class Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;
.super Ljava/lang/Object;
.source "BrandsMetaItemListViewFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setupSearchListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;)V
    .locals 0

    .prologue
    .line 371
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 384
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 385
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 386
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->allBrandsTextView:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 388
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/BrandsMetaItemListAdapter;->getFilter()Landroid/widget/Filter;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/Filter;->filter(Ljava/lang/CharSequence;)V

    .line 393
    :goto_0
    return-void

    .line 390
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    # invokes: Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->resetBrandsList()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->access$000(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;)V

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 374
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 378
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    .line 379
    return-void
.end method
