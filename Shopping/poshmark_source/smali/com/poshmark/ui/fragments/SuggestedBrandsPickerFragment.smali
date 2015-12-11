.class public Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "SuggestedBrandsPickerFragment.java"


# instance fields
.field allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

.field customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

.field retryButton:Landroid/widget/TextView;

.field serverSuggestedBrandsCount:I

.field suggestedBrandsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/Brand;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 39
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 41
    iput-object v0, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    .line 42
    iput-object v0, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->suggestedBrandsMap:Ljava/util/Map;

    .line 44
    iput-object v0, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->retryButton:Landroid/widget/TextView;

    .line 325
    new-instance v0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;-><init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupBrandList()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupSuggestedBrandMap()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->showSuggestedBrands()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;Landroid/widget/FrameLayout;I)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;
    .param p1, "x1"    # Landroid/widget/FrameLayout;
    .param p2, "x2"    # I

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setOverlay(Landroid/widget/FrameLayout;I)V

    return-void
.end method

.method private getBrandOverlayVisibility(Lcom/poshmark/data_model/models/Brand;)I
    .locals 3
    .param p1, "brand"    # Lcom/poshmark/data_model/models/Brand;

    .prologue
    .line 298
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v1

    iget-object v2, p1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/controllers/GlobalDbController;->isFollowingBrand(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 299
    const/4 v0, 0x0

    .line 303
    .local v0, "visibility":I
    :goto_0
    return v0

    .line 301
    .end local v0    # "visibility":I
    :cond_0
    const/4 v0, 0x4

    .restart local v0    # "visibility":I
    goto :goto_0
.end method

.method private getFollowingOverlay(Landroid/view/ViewGroup;)Landroid/widget/ImageView;
    .locals 4
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 314
    const/4 v2, 0x0

    .line 315
    .local v2, "v":Landroid/widget/ImageView;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 316
    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 317
    .local v1, "nextChild":Landroid/view/View;
    instance-of v3, v1, Lcom/poshmark/ui/customviews/PMClickableImageView;

    if-nez v3, :cond_1

    move-object v2, v1

    .line 318
    check-cast v2, Landroid/widget/ImageView;

    .line 322
    .end local v1    # "nextChild":Landroid/view/View;
    :cond_0
    return-object v2

    .line 315
    .restart local v1    # "nextChild":Landroid/view/View;
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private setOverlay(Landroid/widget/FrameLayout;I)V
    .locals 1
    .param p1, "parentFrame"    # Landroid/widget/FrameLayout;
    .param p2, "visibility"    # I

    .prologue
    .line 307
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getFollowingOverlay(Landroid/view/ViewGroup;)Landroid/widget/ImageView;

    move-result-object v0

    .line 308
    .local v0, "overlay":Landroid/widget/ImageView;
    if-eqz v0, :cond_0

    .line 309
    invoke-virtual {v0, p2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 311
    :cond_0
    return-void
.end method

.method private setupBrandList()V
    .locals 4

    .prologue
    .line 118
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    if-nez v2, :cond_0

    .line 119
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060190

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 120
    new-instance v2, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;-><init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V

    invoke-static {v2}, Lcom/poshmark/http/api/PMApi;->getSuggestedBrandsForUser(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 146
    :goto_0
    return-void

    .line 140
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    iget-object v2, v2, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    .line 141
    .local v0, "currentSize":I
    add-int/lit8 v1, v0, -0x1

    .local v1, "i":I
    :goto_1
    iget v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->serverSuggestedBrandsCount:I

    if-lt v1, v2, :cond_1

    .line 142
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    iget-object v2, v2, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 141
    add-int/lit8 v1, v1, -0x1

    goto :goto_1

    .line 144
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->showSuggestedBrands()V

    goto :goto_0
.end method

.method private setupRetryButton()V
    .locals 3

    .prologue
    .line 66
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 67
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 68
    const v1, 0x7f0c02ec

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->retryButton:Landroid/widget/TextView;

    .line 69
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->retryButton:Landroid/widget/TextView;

    if-eqz v1, :cond_0

    .line 70
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->retryButton:Landroid/widget/TextView;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 71
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->retryButton:Landroid/widget/TextView;

    new-instance v2, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$1;-><init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    :cond_0
    return-void
.end method

.method private setupSuggestedBrandMap()V
    .locals 4

    .prologue
    .line 203
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->suggestedBrandsMap:Ljava/util/Map;

    .line 204
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    iget-object v2, v2, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 205
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/Brand;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 206
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    .line 207
    .local v0, "b":Lcom/poshmark/data_model/models/Brand;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->suggestedBrandsMap:Ljava/util/Map;

    iget-object v3, v0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 209
    .end local v0    # "b":Lcom/poshmark/data_model/models/Brand;
    :cond_0
    return-void
.end method

.method private showCurrentFollowingBrands(ILandroid/widget/LinearLayout;)V
    .locals 15
    .param p1, "colIndex"    # I
    .param p2, "brandRowContainer"    # Landroid/widget/LinearLayout;

    .prologue
    .line 149
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getView()Landroid/view/View;

    move-result-object v11

    .line 150
    .local v11, "v":Landroid/view/View;
    if-eqz v11, :cond_6

    .line 151
    iget-object v12, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    iget-object v12, v12, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v10

    .line 152
    .local v10, "position":I
    const/4 v6, 0x0

    .line 153
    .local v6, "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    const/4 v1, 0x0

    .line 154
    .local v1, "b":Landroid/os/Bundle;
    const/4 v4, 0x0

    .line 155
    .local v4, "frameContainer":Landroid/widget/FrameLayout;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v12

    invoke-static {v12}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v7

    .line 156
    .local v7, "inflater":Landroid/view/LayoutInflater;
    const v12, 0x7f0c02ea

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 157
    .local v2, "container":Landroid/widget/LinearLayout;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v12

    invoke-virtual {v12}, Lcom/poshmark/controllers/GlobalDbController;->getAllFollowingBrands()Ljava/util/List;

    move-result-object v3

    .line 158
    .local v3, "followingBrands":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v3, :cond_6

    .line 159
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_6

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 160
    .local v8, "name":Ljava/lang/String;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->suggestedBrandsMap:Ljava/util/Map;

    invoke-interface {v12, v8}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v12

    if-nez v12, :cond_0

    .line 163
    new-instance v9, Lcom/poshmark/data_model/models/Brand;

    invoke-direct {v9}, Lcom/poshmark/data_model/models/Brand;-><init>()V

    .line 164
    .local v9, "newBrand":Lcom/poshmark/data_model/models/Brand;
    iput-object v8, v9, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    .line 165
    iget-object v12, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    iget-object v12, v12, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v12, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 167
    if-nez p1, :cond_1

    .line 168
    const v12, 0x7f0300c3

    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-virtual {v7, v12, v13, v14}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .end local p2    # "brandRowContainer":Landroid/widget/LinearLayout;
    check-cast p2, Landroid/widget/LinearLayout;

    .line 169
    .restart local p2    # "brandRowContainer":Landroid/widget/LinearLayout;
    invoke-virtual {v2}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v12

    add-int/lit8 v12, v12, -0x1

    move-object/from16 v0, p2

    invoke-virtual {v2, v0, v12}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 172
    :cond_1
    if-nez p1, :cond_3

    .line 173
    const v12, 0x7f0c02ef

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .end local v6    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    check-cast v6, Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 174
    .restart local v6    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    const v12, 0x7f0c02ee

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .end local v4    # "frameContainer":Landroid/widget/FrameLayout;
    check-cast v4, Landroid/widget/FrameLayout;

    .line 182
    .restart local v4    # "frameContainer":Landroid/widget/FrameLayout;
    :cond_2
    :goto_1
    new-instance v1, Landroid/os/Bundle;

    .end local v1    # "b":Landroid/os/Bundle;
    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 183
    .restart local v1    # "b":Landroid/os/Bundle;
    const-string v12, "POSITION"

    invoke-virtual {v1, v12, v10}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 184
    invoke-virtual {v6, v1}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setBundle(Landroid/os/Bundle;)V

    .line 185
    iget-object v12, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    invoke-virtual {v6, v12}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setCustomOnClickListener(Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;)V

    .line 186
    const/4 v12, 0x0

    invoke-virtual {v6, v8, v12}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImageWithString(Ljava/lang/String;Z)V

    .line 188
    const/4 v12, 0x0

    invoke-direct {p0, v4, v12}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setOverlay(Landroid/widget/FrameLayout;I)V

    .line 190
    const/4 v12, 0x2

    move/from16 v0, p1

    if-ne v0, v12, :cond_5

    .line 191
    const/16 p1, 0x0

    .line 195
    :goto_2
    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .line 175
    :cond_3
    const/4 v12, 0x1

    move/from16 v0, p1

    if-ne v0, v12, :cond_4

    .line 176
    const v12, 0x7f0c02f1

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .end local v6    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    check-cast v6, Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 177
    .restart local v6    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    const v12, 0x7f0c02f0

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .end local v4    # "frameContainer":Landroid/widget/FrameLayout;
    check-cast v4, Landroid/widget/FrameLayout;

    .restart local v4    # "frameContainer":Landroid/widget/FrameLayout;
    goto :goto_1

    .line 178
    :cond_4
    const/4 v12, 0x2

    move/from16 v0, p1

    if-ne v0, v12, :cond_2

    .line 179
    const v12, 0x7f0c02f3

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .end local v6    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    check-cast v6, Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 180
    .restart local v6    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    const v12, 0x7f0c02f2

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .end local v4    # "frameContainer":Landroid/widget/FrameLayout;
    check-cast v4, Landroid/widget/FrameLayout;

    .restart local v4    # "frameContainer":Landroid/widget/FrameLayout;
    goto :goto_1

    .line 193
    :cond_5
    add-int/lit8 p1, p1, 0x1

    goto :goto_2

    .line 200
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v2    # "container":Landroid/widget/LinearLayout;
    .end local v3    # "followingBrands":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v4    # "frameContainer":Landroid/widget/FrameLayout;
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v6    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    .end local v7    # "inflater":Landroid/view/LayoutInflater;
    .end local v8    # "name":Ljava/lang/String;
    .end local v9    # "newBrand":Lcom/poshmark/data_model/models/Brand;
    .end local v10    # "position":I
    :cond_6
    return-void
.end method

.method private showSuggestedBrands()V
    .locals 20

    .prologue
    .line 215
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getView()Landroid/view/View;

    move-result-object v15

    .line 216
    .local v15, "v":Landroid/view/View;
    if-eqz v15, :cond_8

    .line 217
    const/4 v14, 0x0

    .line 218
    .local v14, "position":I
    const/4 v7, 0x0

    .line 219
    .local v7, "colIndex":I
    const/4 v5, 0x0

    .line 220
    .local v5, "brandRowContainer":Landroid/widget/LinearLayout;
    const/4 v11, 0x0

    .line 221
    .local v11, "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    const/4 v3, 0x0

    .line 222
    .local v3, "b":Landroid/os/Bundle;
    const/4 v9, 0x0

    .line 223
    .local v9, "frameContainer":Landroid/widget/FrameLayout;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v12

    .line 224
    .local v12, "inflater":Landroid/view/LayoutInflater;
    const v17, 0x7f0c02ea

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/LinearLayout;

    .line 226
    .local v8, "container":Landroid/widget/LinearLayout;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_7

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/Brand;

    .line 228
    .local v4, "brand":Lcom/poshmark/data_model/models/Brand;
    if-nez v7, :cond_0

    .line 229
    const v17, 0x7f0300c3

    const/16 v18, 0x0

    const/16 v19, 0x0

    move/from16 v0, v17

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v12, v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    .end local v5    # "brandRowContainer":Landroid/widget/LinearLayout;
    check-cast v5, Landroid/widget/LinearLayout;

    .line 230
    .restart local v5    # "brandRowContainer":Landroid/widget/LinearLayout;
    invoke-virtual {v8}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v17

    add-int/lit8 v17, v17, -0x1

    move/from16 v0, v17

    invoke-virtual {v8, v5, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 233
    :cond_0
    if-nez v7, :cond_3

    .line 234
    const v17, 0x7f0c02ef

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v11

    .end local v11    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    check-cast v11, Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 235
    .restart local v11    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    const v17, 0x7f0c02ee

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    .end local v9    # "frameContainer":Landroid/widget/FrameLayout;
    check-cast v9, Landroid/widget/FrameLayout;

    .line 243
    .restart local v9    # "frameContainer":Landroid/widget/FrameLayout;
    :cond_1
    :goto_1
    new-instance v3, Landroid/os/Bundle;

    .end local v3    # "b":Landroid/os/Bundle;
    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 244
    .restart local v3    # "b":Landroid/os/Bundle;
    const-string v17, "POSITION"

    move-object/from16 v0, v17

    invoke-virtual {v3, v0, v14}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 245
    invoke-virtual {v11, v3}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setBundle(Landroid/os/Bundle;)V

    .line 246
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setCustomOnClickListener(Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;)V

    .line 247
    iget-object v0, v4, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-object/from16 v17, v0

    if-eqz v17, :cond_5

    iget-object v0, v4, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_5

    .line 248
    iget-object v0, v4, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImage(Ljava/lang/String;)V

    .line 249
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v17

    const/high16 v18, 0x3f000000    # 0.5f

    invoke-static/range {v17 .. v18}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v17

    move/from16 v0, v17

    float-to-int v13, v0

    .line 250
    .local v13, "padding":I
    if-nez v13, :cond_2

    .line 251
    const/4 v13, 0x1

    .line 253
    :cond_2
    invoke-virtual {v11, v13, v13, v13, v13}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setPadding(IIII)V

    .line 254
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    const v18, 0x7f090016

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getColor(I)I

    move-result v17

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setBackgroundColor(I)V

    .line 258
    .end local v13    # "padding":I
    :goto_2
    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getBrandOverlayVisibility(Lcom/poshmark/data_model/models/Brand;)I

    move-result v16

    .line 259
    .local v16, "visibility":I
    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-direct {v0, v9, v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setOverlay(Landroid/widget/FrameLayout;I)V

    .line 261
    const/16 v17, 0x2

    move/from16 v0, v17

    if-ne v7, v0, :cond_6

    .line 262
    const/4 v7, 0x0

    .line 266
    :goto_3
    add-int/lit8 v14, v14, 0x1

    .line 267
    goto/16 :goto_0

    .line 236
    .end local v16    # "visibility":I
    :cond_3
    const/16 v17, 0x1

    move/from16 v0, v17

    if-ne v7, v0, :cond_4

    .line 237
    const v17, 0x7f0c02f1

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v11

    .end local v11    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    check-cast v11, Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 238
    .restart local v11    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    const v17, 0x7f0c02f0

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    .end local v9    # "frameContainer":Landroid/widget/FrameLayout;
    check-cast v9, Landroid/widget/FrameLayout;

    .restart local v9    # "frameContainer":Landroid/widget/FrameLayout;
    goto/16 :goto_1

    .line 239
    :cond_4
    const/16 v17, 0x2

    move/from16 v0, v17

    if-ne v7, v0, :cond_1

    .line 240
    const v17, 0x7f0c02f3

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v11

    .end local v11    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    check-cast v11, Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 241
    .restart local v11    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    const v17, 0x7f0c02f2

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    .end local v9    # "frameContainer":Landroid/widget/FrameLayout;
    check-cast v9, Landroid/widget/FrameLayout;

    .restart local v9    # "frameContainer":Landroid/widget/FrameLayout;
    goto/16 :goto_1

    .line 256
    :cond_5
    iget-object v0, v4, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v11, v0, v1}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImageWithString(Ljava/lang/String;Z)V

    goto :goto_2

    .line 264
    .restart local v16    # "visibility":I
    :cond_6
    add-int/lit8 v7, v7, 0x1

    goto :goto_3

    .line 270
    .end local v4    # "brand":Lcom/poshmark/data_model/models/Brand;
    .end local v16    # "visibility":I
    :cond_7
    move-object/from16 v0, p0

    invoke-direct {v0, v7, v5}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->showCurrentFollowingBrands(ILandroid/widget/LinearLayout;)V

    .line 273
    const v17, 0x7f0c02eb

    move/from16 v0, v17

    invoke-virtual {v8, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/customviews/PMTextView;

    .line 274
    .local v6, "button":Lcom/poshmark/ui/customviews/PMTextView;
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v6, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 275
    new-instance v17, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$4;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$4;-><init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 293
    .end local v3    # "b":Landroid/os/Bundle;
    .end local v5    # "brandRowContainer":Landroid/widget/LinearLayout;
    .end local v6    # "button":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v7    # "colIndex":I
    .end local v8    # "container":Landroid/widget/LinearLayout;
    .end local v9    # "frameContainer":Landroid/widget/FrameLayout;
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v11    # "image":Lcom/poshmark/ui/customviews/PMClickableImageView;
    .end local v12    # "inflater":Landroid/view/LayoutInflater;
    .end local v14    # "position":I
    :cond_8
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 61
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupRetryButton()V

    .line 62
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupBrandList()V

    .line 63
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 48
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 49
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 53
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 54
    const v1, 0x7f0300c2

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 55
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 114
    const-string v0, "suggested_brands_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 115
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 84
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 85
    const v0, 0x7f060290

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setTitle(I)V

    .line 86
    const-string v0, "Next"

    new-instance v1, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$2;-><init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 110
    return-void
.end method
