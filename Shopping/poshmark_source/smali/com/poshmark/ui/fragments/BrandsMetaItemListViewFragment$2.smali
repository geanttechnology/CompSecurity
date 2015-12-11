.class Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;
.super Ljava/lang/Object;
.source "BrandsMetaItemListViewFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setupHeaderView()V
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
    .line 308
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v1, 0x0

    .line 311
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 312
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->brandsMetaItemInfo:Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 313
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    if-eqz v0, :cond_0

    .line 314
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearBrand()V

    .line 316
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->hideKeyboard()V

    .line 317
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->returnData()V

    .line 318
    return-void
.end method
