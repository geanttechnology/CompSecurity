.class public Lcom/poshmark/ui/fragments/PartyShowroomListFragment;
.super Lcom/poshmark/ui/fragments/PMDialogFragment;
.source "PartyShowroomListFragment.java"


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;

.field private event:Lcom/poshmark/data_model/models/PartyEvent;

.field private headerView:Landroid/view/View;

.field private listView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMDialogFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->listView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)Lcom/poshmark/data_model/models/PartyEvent;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    return-object v0
.end method

.method private setupList()V
    .locals 2

    .prologue
    .line 83
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->updateList()V

    .line 85
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->listView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    new-instance v1, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$1;-><init>(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)V

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 106
    return-void
.end method

.method private updateHeaderView()V
    .locals 31

    .prologue
    .line 120
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    move-object/from16 v28, v0

    const v29, 0x7f0c024b

    invoke-virtual/range {v28 .. v29}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    .line 121
    .local v6, "covershotImageView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v28

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Lcom/poshmark/data_model/models/PartyEvent;->getCovershot()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    invoke-virtual {v0, v1, v6}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 124
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    move-object/from16 v28, v0

    const v29, 0x7f0c0243

    invoke-virtual/range {v28 .. v29}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Lcom/poshmark/ui/customviews/PMTextView;

    .line 125
    .local v14, "hostLabel":Lcom/poshmark/ui/customviews/PMTextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/poshmark/data_model/models/PartyEvent;->getHosts()Ljava/util/List;

    move-result-object v16

    .line 126
    .local v16, "hosts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Host;>;"
    invoke-interface/range {v16 .. v16}, Ljava/util/List;->size()I

    move-result v28

    const/16 v29, 0x1

    move/from16 v0, v28

    move/from16 v1, v29

    if-gt v0, v1, :cond_0

    .line 127
    const v28, 0x7f060140

    move/from16 v0, v28

    invoke-virtual {v14, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 132
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    move-object/from16 v28, v0

    const v29, 0x7f0c0244

    invoke-virtual/range {v28 .. v29}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/GridLayout;

    .line 133
    .local v13, "hostImagesLayout":Landroid/widget/GridLayout;
    const/16 v25, 0x0

    .line 134
    .local v25, "row":I
    const/4 v5, 0x0

    .line 135
    .local v5, "col":I
    invoke-interface/range {v16 .. v16}, Ljava/util/List;->size()I

    move-result v11

    .line 136
    .local v11, "hostCount":I
    const/16 v17, 0x0

    .local v17, "i":I
    :goto_1
    move/from16 v0, v17

    if-ge v0, v11, :cond_3

    .line 137
    invoke-interface/range {v16 .. v17}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/poshmark/data_model/models/inner_models/Host;

    .line 138
    .local v10, "host":Lcom/poshmark/data_model/models/inner_models/Host;
    iget-object v15, v10, Lcom/poshmark/data_model/models/inner_models/Host;->id:Ljava/lang/String;

    .line 139
    .local v15, "hostUserId":Ljava/lang/String;
    new-instance v12, Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v28

    const/16 v29, 0x0

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    invoke-direct {v12, v0, v1}, Lcom/poshmark/ui/customviews/RoundedImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 140
    .local v12, "hostImageView":Lcom/poshmark/ui/customviews/RoundedImageView;
    invoke-virtual {v10}, Lcom/poshmark/data_model/models/inner_models/Host;->getUsername()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v12, v0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setUser(Ljava/lang/String;)V

    .line 141
    new-instance v28, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$2;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v15}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$2;-><init>(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v12, v0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 154
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v28

    const/high16 v29, 0x41200000    # 10.0f

    invoke-static/range {v28 .. v29}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v28

    move/from16 v0, v28

    float-to-int v0, v0

    move/from16 v22, v0

    .line 155
    .local v22, "margin":I
    mul-int/lit8 v7, v22, 0x3

    .line 157
    .local v7, "dimension":I
    const/16 v28, 0x1

    move/from16 v0, v25

    move/from16 v1, v28

    invoke-static {v0, v1}, Landroid/widget/GridLayout;->spec(II)Landroid/widget/GridLayout$Spec;

    move-result-object v9

    .line 158
    .local v9, "gridRow":Landroid/widget/GridLayout$Spec;
    const/16 v28, 0x1

    move/from16 v0, v28

    invoke-static {v5, v0}, Landroid/widget/GridLayout;->spec(II)Landroid/widget/GridLayout$Spec;

    move-result-object v8

    .line 159
    .local v8, "gridCol":Landroid/widget/GridLayout$Spec;
    new-instance v21, Landroid/widget/GridLayout$LayoutParams;

    move-object/from16 v0, v21

    invoke-direct {v0, v9, v8}, Landroid/widget/GridLayout$LayoutParams;-><init>(Landroid/widget/GridLayout$Spec;Landroid/widget/GridLayout$Spec;)V

    .line 160
    .local v21, "lp":Landroid/widget/GridLayout$LayoutParams;
    move-object/from16 v0, v21

    iput v7, v0, Landroid/widget/GridLayout$LayoutParams;->width:I

    .line 161
    move-object/from16 v0, v21

    iput v7, v0, Landroid/widget/GridLayout$LayoutParams;->height:I

    .line 162
    const/16 v28, 0x0

    div-int/lit8 v29, v22, 0x2

    const/16 v30, 0x0

    move-object/from16 v0, v21

    move/from16 v1, v28

    move/from16 v2, v29

    move/from16 v3, v22

    move/from16 v4, v30

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/GridLayout$LayoutParams;->setMargins(IIII)V

    .line 164
    move-object/from16 v0, v21

    invoke-virtual {v13, v12, v0}, Landroid/widget/GridLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 166
    invoke-virtual {v10}, Lcom/poshmark/data_model/models/inner_models/Host;->getAvataar()Ljava/lang/String;

    move-result-object v24

    .line 167
    .local v24, "pictureUrl":Ljava/lang/String;
    if-eqz v24, :cond_1

    .line 168
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v28

    iget-object v0, v12, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    move-object/from16 v29, v0

    move-object/from16 v0, v28

    move-object/from16 v1, v24

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 174
    :goto_2
    add-int/lit8 v28, v5, 0x1

    const/16 v29, 0x7

    move/from16 v0, v28

    move/from16 v1, v29

    if-ne v0, v1, :cond_2

    .line 175
    add-int/lit8 v25, v25, 0x1

    .line 176
    const/4 v5, 0x0

    .line 136
    :goto_3
    add-int/lit8 v17, v17, 0x1

    goto/16 :goto_1

    .line 130
    .end local v5    # "col":I
    .end local v7    # "dimension":I
    .end local v8    # "gridCol":Landroid/widget/GridLayout$Spec;
    .end local v9    # "gridRow":Landroid/widget/GridLayout$Spec;
    .end local v10    # "host":Lcom/poshmark/data_model/models/inner_models/Host;
    .end local v11    # "hostCount":I
    .end local v12    # "hostImageView":Lcom/poshmark/ui/customviews/RoundedImageView;
    .end local v13    # "hostImagesLayout":Landroid/widget/GridLayout;
    .end local v15    # "hostUserId":Ljava/lang/String;
    .end local v17    # "i":I
    .end local v21    # "lp":Landroid/widget/GridLayout$LayoutParams;
    .end local v22    # "margin":I
    .end local v24    # "pictureUrl":Ljava/lang/String;
    .end local v25    # "row":I
    :cond_0
    const v28, 0x7f060142

    move/from16 v0, v28

    invoke-virtual {v14, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    goto/16 :goto_0

    .line 170
    .restart local v5    # "col":I
    .restart local v7    # "dimension":I
    .restart local v8    # "gridCol":Landroid/widget/GridLayout$Spec;
    .restart local v9    # "gridRow":Landroid/widget/GridLayout$Spec;
    .restart local v10    # "host":Lcom/poshmark/data_model/models/inner_models/Host;
    .restart local v11    # "hostCount":I
    .restart local v12    # "hostImageView":Lcom/poshmark/ui/customviews/RoundedImageView;
    .restart local v13    # "hostImagesLayout":Landroid/widget/GridLayout;
    .restart local v15    # "hostUserId":Ljava/lang/String;
    .restart local v17    # "i":I
    .restart local v21    # "lp":Landroid/widget/GridLayout$LayoutParams;
    .restart local v22    # "margin":I
    .restart local v24    # "pictureUrl":Ljava/lang/String;
    .restart local v25    # "row":I
    :cond_1
    const v28, 0x7f0200d4

    move/from16 v0, v28

    invoke-virtual {v12, v0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap(I)V

    goto :goto_2

    .line 179
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_3

    .line 183
    .end local v7    # "dimension":I
    .end local v8    # "gridCol":Landroid/widget/GridLayout$Spec;
    .end local v9    # "gridRow":Landroid/widget/GridLayout$Spec;
    .end local v10    # "host":Lcom/poshmark/data_model/models/inner_models/Host;
    .end local v12    # "hostImageView":Lcom/poshmark/ui/customviews/RoundedImageView;
    .end local v15    # "hostUserId":Ljava/lang/String;
    .end local v21    # "lp":Landroid/widget/GridLayout$LayoutParams;
    .end local v22    # "margin":I
    .end local v24    # "pictureUrl":Ljava/lang/String;
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    move-object/from16 v28, v0

    const v29, 0x7f0c0245

    invoke-virtual/range {v28 .. v29}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v26

    check-cast v26, Landroid/widget/ImageView;

    .line 184
    .local v26, "timerIconView":Landroid/widget/ImageView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    move-object/from16 v28, v0

    const v29, 0x7f0c0246

    invoke-virtual/range {v28 .. v29}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Landroid/widget/ImageView;

    .line 185
    .local v19, "listingCountIconView":Landroid/widget/ImageView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    move-object/from16 v28, v0

    const v29, 0x7f0c0247

    invoke-virtual/range {v28 .. v29}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v23

    check-cast v23, Lcom/poshmark/ui/customviews/PMTextView;

    .line 187
    .local v23, "partyInfoTextView":Lcom/poshmark/ui/customviews/PMTextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v28

    if-eqz v28, :cond_5

    .line 188
    const/16 v28, 0x0

    move-object/from16 v0, v26

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 189
    const/16 v28, 0x8

    move-object/from16 v0, v19

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 190
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/poshmark/data_model/models/PartyEvent;->getFormattedPendingTime()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v23

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 209
    :cond_4
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    move-object/from16 v28, v0

    const v29, 0x7f0c024a

    invoke-virtual/range {v28 .. v29}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v27

    check-cast v27, Lcom/poshmark/ui/customviews/PMTextView;

    .line 210
    .local v27, "viewDetailsLabel":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v28, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$3;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$3;-><init>(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)V

    invoke-virtual/range {v27 .. v28}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 222
    return-void

    .line 192
    .end local v27    # "viewDetailsLabel":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v28

    if-eqz v28, :cond_4

    .line 193
    const/16 v28, 0x8

    move-object/from16 v0, v26

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 194
    const/16 v28, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 196
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/poshmark/data_model/models/PartyEvent;->getListingCount()I

    move-result v18

    .line 197
    .local v18, "listingCount":I
    if-nez v18, :cond_6

    .line 198
    const v28, 0x7f0601d2

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getString(I)Ljava/lang/String;

    move-result-object v20

    .line 206
    .local v20, "listingCountText":Ljava/lang/String;
    :goto_5
    move-object/from16 v0, v23

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_4

    .line 200
    .end local v20    # "listingCountText":Ljava/lang/String;
    :cond_6
    const/16 v28, 0x1

    move/from16 v0, v18

    move/from16 v1, v28

    if-ne v0, v1, :cond_7

    .line 201
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, " "

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const v29, 0x7f060167

    move-object/from16 v0, p0

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getString(I)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    .restart local v20    # "listingCountText":Ljava/lang/String;
    goto :goto_5

    .line 204
    .end local v20    # "listingCountText":Ljava/lang/String;
    :cond_7
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, " "

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const v29, 0x7f06018f

    move-object/from16 v0, p0

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getString(I)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    .restart local v20    # "listingCountText":Ljava/lang/String;
    goto :goto_5
.end method

.method private updateList()V
    .locals 4

    .prologue
    .line 109
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getUserVisibleHint()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 110
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/controllers/GlobalPartiesController;->isModelPopulated()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 111
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 112
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/PartyEvent;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 113
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->adapter:Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 114
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->adapter:Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->notifyDataSetChanged()V

    .line 117
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    :cond_0
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMDialogFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 68
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->setupList()V

    .line 69
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMDialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 43
    const-class v1, Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 44
    .local v0, "e":Ljava/lang/Object;
    if-eqz v0, :cond_0

    .line 45
    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .end local v0    # "e":Ljava/lang/Object;
    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 48
    :cond_0
    new-instance v1, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    const/high16 v4, -0x80000000

    invoke-direct {v1, v2, p0, v3, v4}, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->adapter:Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;

    .line 49
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->adapter:Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->setEvent(Lcom/poshmark/data_model/models/PartyEvent;)V

    .line 50
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 54
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMDialogFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 55
    const v1, 0x7f03009a

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 56
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c025a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->listView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    .line 58
    const v1, 0x7f03009b

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    .line 59
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->updateHeaderView()V

    .line 60
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->listView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->headerView:Landroid/view/View;

    invoke-virtual {v1, v2}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->addHeaderView(Landroid/view/View;)V

    .line 61
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->listView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->adapter:Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;

    invoke-virtual {v1, v2}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 62
    return-object v0
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 73
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMDialogFragment;->onStop()V

    .line 74
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 79
    const-string v0, "party_showroom_list_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 80
    return-void
.end method
