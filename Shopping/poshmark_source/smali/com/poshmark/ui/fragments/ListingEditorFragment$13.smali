.class Lcom/poshmark/ui/fragments/ListingEditorFragment$13;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


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
    .line 826
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 19
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 828
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 829
    .local v1, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v8, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-direct {v8}, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;-><init>()V

    .line 830
    .local v8, "initInfo":Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;
    const/16 v18, 0x0

    .line 831
    .local v18, "requestCode":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-boolean v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    if-nez v3, :cond_9

    .line 832
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 833
    .local v2, "b":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->categoryEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v0, p1

    if-ne v0, v3, :cond_0

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    const/4 v5, 0x1

    if-ne v3, v5, :cond_0

    .line 834
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v5, 0x1

    iput-boolean v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 835
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_CATEGORY:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 836
    new-instance v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;

    invoke-direct {v4}, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;-><init>()V

    .line 837
    .local v4, "currentSelectionModel":Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllCategories()Ljava/util/List;

    move-result-object v3

    iput-object v3, v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->categoryFacetList:Ljava/util/List;

    .line 838
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v3

    iput-object v3, v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 839
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getSubCategoryList()Ljava/util/List;

    move-result-object v3

    iput-object v3, v4, Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;->currentSubCategorySelection:Ljava/util/List;

    .line 841
    const-string v3, "ENABLE_LISTING_MODE"

    const/4 v5, 0x1

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 842
    const-class v3, Lcom/poshmark/ui/fragments/CategoryListFragment;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget v6, v6, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    invoke-virtual/range {v1 .. v6}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 909
    .end local v4    # "currentSelectionModel":Lcom/poshmark/utils/meta_data/CategorySubCategorySelectionModel;
    :goto_0
    const/4 v3, 0x1

    .line 911
    .end local v2    # "b":Landroid/os/Bundle;
    :goto_1
    return v3

    .line 844
    .restart local v2    # "b":Landroid/os/Bundle;
    :cond_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->sizeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v0, p1

    if-ne v0, v3, :cond_3

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    const/4 v5, 0x1

    if-ne v3, v5, :cond_3

    .line 846
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v16

    .line 847
    .local v16, "category":Lcom/poshmark/data_model/models/MetaItem;
    if-nez v16, :cond_1

    .line 849
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const-string v5, ""

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f060180

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 850
    const/4 v3, 0x1

    goto :goto_1

    .line 852
    :cond_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v5, 0x1

    iput-boolean v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 853
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v3

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/poshmark/controllers/GlobalDbController;->getAllSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    iput-object v3, v8, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 854
    iget-object v3, v8, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    if-nez v3, :cond_2

    .line 855
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v8, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 856
    :cond_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_SIZE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 858
    const-string v3, "META_ITEM_MODE"

    sget-object v5, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->SIZE_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v5

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 859
    const-string v3, "CUSTOM_OPTION_ENABLED"

    const/4 v5, 0x1

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 860
    const-class v7, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget v10, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    move-object v5, v1

    move-object v6, v2

    invoke-virtual/range {v5 .. v10}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    goto/16 :goto_0

    .line 862
    .end local v16    # "category":Lcom/poshmark/data_model/models/MetaItem;
    :cond_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->brandEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v0, p1

    if-ne v0, v3, :cond_4

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    const/4 v5, 0x1

    if-ne v3, v5, :cond_4

    .line 863
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v5, 0x1

    iput-boolean v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 864
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllBrands()Ljava/util/List;

    move-result-object v3

    iput-object v3, v8, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 865
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_BRAND:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 867
    const-string v3, "META_ITEM_MODE"

    sget-object v5, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->BRAND_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v5

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 868
    const-string v3, "SEARCH_ENABLED"

    const/4 v5, 0x1

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 869
    const-string v3, "CUSTOM_STRING_ENABLED"

    const/4 v5, 0x1

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 870
    const-class v7, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget v10, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    move-object v5, v1

    move-object v6, v2

    invoke-virtual/range {v5 .. v10}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    goto/16 :goto_0

    .line 872
    :cond_4
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->nwtEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v0, p1

    if-ne v0, v3, :cond_5

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    const/4 v5, 0x1

    if-ne v3, v5, :cond_5

    .line 873
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v5, 0x1

    iput-boolean v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 874
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_CONDITION_STATUS:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 875
    const-string v3, "META_ITEM_MODE"

    sget-object v5, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->NWT_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v5

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 876
    const-class v11, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getCondition()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getConditionMetaItemForListingFlow(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v12

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget v14, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    move-object v9, v1

    move-object v10, v2

    invoke-virtual/range {v9 .. v14}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    goto/16 :goto_0

    .line 878
    :cond_5
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v0, p1

    if-ne v0, v3, :cond_7

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    const/4 v5, 0x1

    if-ne v3, v5, :cond_7

    .line 880
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/FeatureManager;->getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    move-result-object v17

    .line 881
    .local v17, "feature":Lcom/poshmark/data_model/models/inner_models/ListingFeature;
    const-string v15, "available"

    .line 882
    .local v15, "available":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getPrice()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->isValidSellingPrice(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_6

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getInventoryStatus()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    .line 884
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const-string v5, ""

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const v7, 0x7f06018d

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->getFormattedMinimumSellingPrice()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v7, v10

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 885
    const/4 v3, 0x1

    goto/16 :goto_1

    .line 887
    :cond_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v5, 0x1

    iput-boolean v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 888
    invoke-static {}, Lcom/poshmark/db/DbApi;->getNFSListingOptions()Ljava/util/List;

    move-result-object v3

    iput-object v3, v8, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 889
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_AVAILABILITY_STATUS:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 891
    const-string v3, "META_ITEM_MODE"

    sget-object v5, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->AVAILABILITY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v5

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 892
    const-class v7, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget v10, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    move-object v5, v1

    move-object v6, v2

    invoke-virtual/range {v5 .. v10}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    goto/16 :goto_0

    .line 894
    .end local v15    # "available":Ljava/lang/String;
    .end local v17    # "feature":Lcom/poshmark/data_model/models/inner_models/ListingFeature;
    :cond_7
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->colorDummyEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v0, p1

    if-ne v0, v3, :cond_8

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    const/4 v5, 0x1

    if-ne v3, v5, :cond_8

    .line 895
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v5, 0x1

    iput-boolean v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 896
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_COLOR:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 897
    new-instance v12, Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-direct {v12}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;-><init>()V

    .line 898
    .local v12, "info":Lcom/poshmark/utils/meta_data/ColorPickerInfo;
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllColors()Ljava/util/List;

    move-result-object v3

    iput-object v3, v12, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->allItems:Ljava/util/List;

    .line 899
    iget-object v3, v12, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/NewListing;->getColors()Ljava/util/List;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 900
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/PMActivity;

    .line 901
    .local v9, "activity":Lcom/poshmark/ui/PMActivity;
    new-instance v2, Landroid/os/Bundle;

    .end local v2    # "b":Landroid/os/Bundle;
    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 902
    .restart local v2    # "b":Landroid/os/Bundle;
    const-string v3, "COLOR_PICKER_MODE"

    sget-object v5, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->ordinal()I

    move-result v5

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 903
    const-class v11, Lcom/poshmark/ui/fragments/ColorPickerFragment;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget v14, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    move-object v10, v2

    invoke-virtual/range {v9 .. v14}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 904
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v6, "listing"

    const-string v7, "listing_select_color"

    const/4 v10, 0x0

    invoke-virtual {v3, v5, v6, v7, v10}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 907
    .end local v9    # "activity":Lcom/poshmark/ui/PMActivity;
    .end local v12    # "info":Lcom/poshmark/utils/meta_data/ColorPickerInfo;
    :cond_8
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 911
    .end local v2    # "b":Landroid/os/Bundle;
    :cond_9
    const/4 v3, 0x0

    goto/16 :goto_1
.end method
