.class public Lcom/poshmark/ui/fragments/MetaItemListViewFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "MetaItemListViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/MetaItemListViewFragment$5;,
        Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;
    }
.end annotation


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

.field allowCustomCustomString:Z

.field allowMultiSelect:Z

.field backoutFlag:Z

.field clearAllRowEnabled:Z

.field clearAllTextBox:Lcom/poshmark/ui/customviews/PMTextView;

.field customOptionEnabled:Z

.field dataReturned:Z

.field initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

.field listView:Landroid/widget/ListView;

.field metaItem:Lcom/poshmark/data_model/models/MetaItem;

.field metaItemMode:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

.field multiSelectList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

.field searchBox:Landroid/widget/EditText;

.field searchEnabled:Z

.field showBrandFollowButton:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 39
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 59
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->backoutFlag:Z

    .line 62
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllRowEnabled:Z

    .line 68
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->dataReturned:Z

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->multiSelectList:Ljava/util/ArrayList;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MetaItemListViewFragment;
    .param p1, "x1"    # Landroid/view/View;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->removeCheckMark(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MetaItemListViewFragment;
    .param p1, "x1"    # Landroid/view/View;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->showCheckMark(Landroid/view/View;)V

    return-void
.end method

.method private getMetaItemListFromFilter()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 104
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItemMode:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private launchUrl(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "analyticsPageName"    # Ljava/lang/String;

    .prologue
    .line 434
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 435
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 436
    const-string v2, "ANALYTICS_PAGE_NAME"

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 437
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 438
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 439
    return-void
.end method

.method private removeCheckMark(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 318
    const v1, 0x7f0c0097

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 319
    .local v0, "checkMark":Landroid/widget/ImageView;
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 320
    return-void
.end method

.method private setTitleFromMode()V
    .locals 2

    .prologue
    .line 152
    sget-object v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$5;->$SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES:[I

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItemMode:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 180
    :goto_0
    return-void

    .line 154
    :pswitch_0
    const v0, 0x7f060073

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitle(I)V

    goto :goto_0

    .line 157
    :pswitch_1
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->customOptionEnabled:Z

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 158
    const v0, 0x7f060243

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitle(I)V

    goto :goto_0

    .line 161
    :cond_0
    const v0, 0x7f060282

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitle(I)V

    goto :goto_0

    .line 165
    :pswitch_2
    const v0, 0x7f060061

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitle(I)V

    goto :goto_0

    .line 168
    :pswitch_3
    const v0, 0x7f060091

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitle(I)V

    goto :goto_0

    .line 171
    :pswitch_4
    const v0, 0x7f06026b

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitle(I)V

    goto :goto_0

    .line 174
    :pswitch_5
    const v0, 0x7f06004e

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitle(I)V

    goto :goto_0

    .line 177
    :pswitch_6
    const v0, 0x7f06028d

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitle(I)V

    goto :goto_0

    .line 152
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method private setupAdapter()V
    .locals 8

    .prologue
    .line 92
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    if-eqz v0, :cond_1

    .line 93
    new-instance v0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-direct {v0}, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    .line 94
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getMetaItemListFromFilter()Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 95
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    if-nez v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->allItems:Ljava/util/List;

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItemMode:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getCurrentMetaItemSelection(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    .line 100
    :cond_1
    new-instance v0, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f03008a

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchEnabled:Z

    iget-boolean v5, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->customOptionEnabled:Z

    iget-boolean v6, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->allowCustomCustomString:Z

    iget-boolean v7, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->showBrandFollowButton:Z

    invoke-direct/range {v0 .. v7}, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;-><init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/MetaItemPickerInfo;ZZZZ)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    .line 101
    return-void
.end method

.method private setupFooterView()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/16 v8, 0x11

    const/4 v7, 0x2

    const/high16 v6, 0x41700000    # 15.0f

    const v5, 0x7f090039

    .line 403
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItemMode:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    sget-object v4, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CONDITION_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    if-ne v3, v4, :cond_0

    .line 404
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/high16 v4, 0x41200000    # 10.0f

    invoke-static {v3, v4}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v3

    float-to-int v1, v3

    .line 407
    .local v1, "margin":I
    new-instance v0, Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v0, v3, v9}, Lcom/poshmark/ui/customviews/PMTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 408
    .local v0, "footerView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v0, v1, v1, v1, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setPadding(IIII)V

    .line 409
    invoke-virtual {v0, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setGravity(I)V

    .line 410
    invoke-virtual {v0, v7, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setTextSize(IF)V

    .line 411
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 412
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setLinkTextColor(I)V

    .line 414
    const v3, 0x7f060212

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 415
    .local v2, "poshmarkNWTPolicyText":Ljava/lang/String;
    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 416
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v3, v0}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 419
    new-instance v0, Lcom/poshmark/ui/customviews/PMTextView;

    .end local v0    # "footerView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v0, v3, v9}, Lcom/poshmark/ui/customviews/PMTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 420
    .restart local v0    # "footerView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v0, v1, v1, v1, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setPadding(IIII)V

    .line 421
    invoke-virtual {v0, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setGravity(I)V

    .line 422
    invoke-virtual {v0, v7, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setTextSize(IF)V

    .line 423
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 424
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setLinkTextColor(I)V

    .line 426
    const v3, 0x7f060214

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 427
    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 428
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v3, v0}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 431
    .end local v0    # "footerView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v1    # "margin":I
    .end local v2    # "poshmarkNWTPolicyText":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private setupListItemClickListener()V
    .locals 2

    .prologue
    .line 242
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->listView:Landroid/widget/ListView;

    new-instance v1, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;-><init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 315
    return-void
.end method

.method private setupSearchListener()V
    .locals 2

    .prologue
    .line 328
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    if-nez v0, :cond_0

    .line 358
    :goto_0
    return-void

    .line 331
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    new-instance v1, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$3;-><init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 341
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    new-instance v1, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$4;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$4;-><init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    goto :goto_0
.end method

.method private showCheckMark(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 323
    const v1, 0x7f0c0097

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 324
    .local v0, "checkMark":Landroid/widget/ImageView;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 325
    return-void
.end method


# virtual methods
.method public handleBack()Z
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 183
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->dataReturned:Z

    if-nez v2, :cond_0

    .line 184
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->dataReturned:Z

    .line 186
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 187
    .local v1, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_0

    .line 188
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getTargetRequestCode()I

    move-result v0

    .line 189
    .local v0, "requestCode":I
    const/4 v2, 0x0

    invoke-virtual {v1, v0, v3, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 192
    .end local v0    # "requestCode":I
    .end local v1    # "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_0
    return v3
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 116
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 117
    if-nez p1, :cond_0

    .line 118
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0205

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->listView:Landroid/widget/ListView;

    .line 119
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupHeaderView()V

    .line 120
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupFooterView()V

    .line 121
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->listView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 122
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupListItemClickListener()V

    .line 124
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 75
    if-nez p1, :cond_0

    .line 76
    invoke-static {}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->values()[Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    move-result-object v0

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "META_ITEM_MODE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItemMode:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    .line 77
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "CUSTOM_OPTION_ENABLED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->customOptionEnabled:Z

    .line 78
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SEARCH_ENABLED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchEnabled:Z

    .line 79
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "CLEAR_ALL_ROW_ENABLED"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllRowEnabled:Z

    .line 80
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "CUSTOM_STRING_ENABLED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->allowCustomCustomString:Z

    .line 81
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "BRAND_FOLLOW_BUTTON"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->showBrandFollowButton:Z

    .line 82
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "MULTI_SELECT_ENABLED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->allowMultiSelect:Z

    .line 83
    const-class v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 84
    const-class v0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    .line 85
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupAdapter()V

    .line 89
    :goto_0
    return-void

    .line 87
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->backoutFlag:Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 109
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 110
    const v1, 0x7f030088

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 111
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onPMResume()V
    .locals 1

    .prologue
    .line 128
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 129
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->backoutFlag:Z

    if-eqz v0, :cond_0

    .line 130
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 133
    :cond_0
    return-void
.end method

.method public returnData()V
    .locals 9

    .prologue
    const/4 v8, -0x1

    .line 221
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/fragments/PMFragment;

    .line 222
    .local v5, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    const-class v7, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v6, v7}, Lcom/poshmark/utils/StringUtils;->toJson(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 223
    .local v2, "json":Ljava/lang/String;
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->dataReturned:Z

    .line 224
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 225
    .local v1, "i":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 226
    .local v0, "b":Landroid/os/Bundle;
    const-string v6, "DATA_SELECTED"

    invoke-virtual {v0, v6, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    const-string v6, "RETURNED_RESULTS"

    invoke-virtual {v1, v6, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 229
    if-eqz v5, :cond_1

    .line 230
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getTargetRequestCode()I

    move-result v4

    .line 231
    .local v4, "requestCode":I
    invoke-virtual {v5, v4, v8, v1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 232
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    .line 233
    .local v3, "parent":Landroid/app/Activity;
    if-eqz v3, :cond_0

    .line 234
    invoke-virtual {v3}, Landroid/app/Activity;->onBackPressed()V

    .line 239
    .end local v3    # "parent":Landroid/app/Activity;
    .end local v4    # "requestCode":I
    :cond_0
    :goto_0
    return-void

    .line 237
    :cond_1
    invoke-virtual {p0, v8, v1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public setRecentBrandsLayout(ZLandroid/view/View;)V
    .locals 0
    .param p1, "visibility"    # Z
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 400
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 196
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->backoutFlag:Z

    if-nez v0, :cond_0

    .line 197
    sget-object v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$5;->$SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES:[I

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItemMode:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 217
    :cond_0
    :goto_0
    return-void

    .line 199
    :pswitch_0
    const-string v0, "listing_select_category_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 202
    :pswitch_1
    const-string v0, "listing_select_size_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 205
    :pswitch_2
    const-string v0, "listing_select_brand_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 209
    :pswitch_3
    const-string v0, "listing_select_condition_status_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 197
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_3
    .end packed-switch
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 137
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 138
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->allowMultiSelect:Z

    if-eqz v0, :cond_0

    .line 139
    const-string v0, "DONE"

    new-instance v1, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$1;-><init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 148
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setTitleFromMode()V

    .line 149
    return-void
.end method

.method public setupHeaderView()V
    .locals 8

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 361
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 362
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v4, 0x7f03005b

    invoke-virtual {v1, v4, v7, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 364
    .local v3, "searchView":Landroid/view/View;
    const v4, 0x7f0c0151

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    .line 365
    const v4, 0x7f0c0072

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllTextBox:Lcom/poshmark/ui/customviews/PMTextView;

    .line 366
    const v4, 0x7f0c0166

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 367
    .local v2, "searchBoxLayout":Landroid/widget/LinearLayout;
    const v4, 0x7f0c0071

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 369
    .local v0, "allItemsLayout":Landroid/widget/LinearLayout;
    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchEnabled:Z

    if-eqz v4, :cond_3

    .line 370
    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 378
    :goto_0
    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllRowEnabled:Z

    if-eqz v4, :cond_4

    .line 379
    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 380
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllTextBox:Lcom/poshmark/ui/customviews/PMTextView;

    const-string v5, "All"

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 381
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->initInfo:Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/MetaItemPickerInfo;->currentSelection:Lcom/poshmark/data_model/models/MetaItem;

    if-nez v4, :cond_0

    .line 382
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllTextBox:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f09003c

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 383
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllTextBox:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v5, 0x1

    invoke-virtual {v4, v7, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 384
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllTextBox:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f02007e

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v7, v7, v5, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 391
    :cond_0
    :goto_1
    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchEnabled:Z

    if-nez v4, :cond_1

    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->clearAllRowEnabled:Z

    if-eqz v4, :cond_2

    .line 392
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupSearchListener()V

    .line 393
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v4, v3}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 396
    :cond_2
    return-void

    .line 372
    :cond_3
    invoke-virtual {v2, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 388
    :cond_4
    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1
.end method
