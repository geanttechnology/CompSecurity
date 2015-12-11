.class public Lcom/poshmark/ui/fragments/ListingEditorShareFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ListingEditorShareFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# instance fields
.field bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

.field doFacebookConnect:Landroid/view/View$OnClickListener;

.field doPinterestConnect:Landroid/view/View$OnClickListener;

.field doTumblrConnect:Landroid/view/View$OnClickListener;

.field doTwitterConnect:Landroid/view/View$OnClickListener;

.field private fbShareLayout:Landroid/widget/RelativeLayout;

.field fbSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field isPinterestButtonEnabled:Z

.field isPinterestDialogShowable:Z

.field private listingManager:Lcom/poshmark/utils/ListingManager;

.field private pinShareLayout:Landroid/widget/RelativeLayout;

.field pinterestSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private shareBanner:Ljava/lang/String;

.field share_banner_image:Landroid/widget/ImageView;

.field showBanner:Z

.field tmSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private tumblrShareLayout:Landroid/widget/RelativeLayout;

.field twSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private twitterShareLayout:Landroid/widget/RelativeLayout;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 58
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->shareBanner:Ljava/lang/String;

    .line 61
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showBanner:Z

    .line 287
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->doPinterestConnect:Landroid/view/View$OnClickListener;

    .line 298
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$3;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->doFacebookConnect:Landroid/view/View$OnClickListener;

    .line 305
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->doTwitterConnect:Landroid/view/View$OnClickListener;

    .line 331
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$5;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$5;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->doTumblrConnect:Landroid/view/View$OnClickListener;

    .line 357
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$6;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$6;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinterestSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 364
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$7;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$7;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 378
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$8;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$8;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 386
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$9;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$9;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tmSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    return-object v0
.end method

.method private pinterestLoginComplete()V
    .locals 7

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x1

    .line 197
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01bd

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 198
    .local v1, "connectTextView":Landroid/widget/TextView;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01bc

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Switch;

    .line 199
    .local v2, "optionSwitch":Landroid/widget/Switch;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01be

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 201
    .local v0, "arrowImageView":Landroid/widget/ImageView;
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Switch;->setVisibility(I)V

    .line 202
    invoke-virtual {v1, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 203
    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 206
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 207
    invoke-virtual {v2, v5}, Landroid/widget/Switch;->setChecked(Z)V

    .line 208
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    invoke-virtual {v3, v5}, Lcom/poshmark/utils/ListingManager;->setPinterestShareFlag(Z)V

    .line 209
    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->isPinterestDialogShowable:Z

    if-eqz v3, :cond_0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->isPinterestPostDialogShown()Z

    move-result v3

    if-nez v3, :cond_0

    .line 210
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/application/PMApplicationSession;->setPinterestPostDialogShown(Ljava/lang/Boolean;)V

    .line 211
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showPinterestSuccessConnectDialog()V

    .line 213
    :cond_0
    return-void
.end method

.method private setupActionBarNextActionButton()V
    .locals 2

    .prologue
    .line 658
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 659
    .local v0, "nextActionButton":Landroid/widget/Button;
    if-nez v0, :cond_0

    .line 672
    :goto_0
    return-void

    .line 662
    :cond_0
    const v1, 0x7f060166

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 664
    new-instance v1, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$11;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$11;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private setupFacebookOptionView(Landroid/widget/LinearLayout;)V
    .locals 11
    .param p1, "parentLayout"    # Landroid/widget/LinearLayout;

    .prologue
    const/16 v10, 0x8

    const/4 v9, 0x0

    .line 469
    const v7, 0x7f0c01b7

    invoke-virtual {p1, v7}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/RelativeLayout;

    iput-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    .line 470
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v7}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v5

    .line 471
    .local v5, "padding":I
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v7, v5, v5, v5, v5}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 472
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v8, 0x7f0c01ba

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 473
    .local v6, "textView":Landroid/widget/TextView;
    const v7, 0x7f060108

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(I)V

    .line 474
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v8, 0x7f0c01bd

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 475
    .local v1, "connectTextView":Landroid/widget/TextView;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v8, 0x7f0c01bc

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Switch;

    .line 476
    .local v4, "optionSwitch":Landroid/widget/Switch;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-virtual {v4, v7}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 477
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v8, 0x7f0c01be

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 479
    .local v0, "arrowImageView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 480
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v7

    sget-object v8, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->READ_PERMISSION:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v3

    .line 481
    .local v3, "fbReadPermissionEnabled":Z
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v7

    sget-object v8, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v2

    .line 482
    .local v2, "fbPublishPermissionEnabled":Z
    if-nez v3, :cond_1

    .line 483
    invoke-virtual {v4, v10}, Landroid/widget/Switch;->setVisibility(I)V

    .line 484
    invoke-virtual {v1, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 485
    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 487
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->doFacebookConnect:Landroid/view/View$OnClickListener;

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 500
    .end local v2    # "fbPublishPermissionEnabled":Z
    .end local v3    # "fbReadPermissionEnabled":Z
    :cond_0
    :goto_0
    return-void

    .line 490
    .restart local v2    # "fbPublishPermissionEnabled":Z
    .restart local v3    # "fbReadPermissionEnabled":Z
    :cond_1
    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 491
    invoke-virtual {v0, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 492
    invoke-virtual {v4, v9}, Landroid/widget/Switch;->setVisibility(I)V

    .line 493
    if-eqz v2, :cond_2

    .line 494
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->getFacebookSharingFlag()Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    invoke-virtual {v4, v7}, Landroid/widget/Switch;->setChecked(Z)V

    goto :goto_0

    .line 496
    :cond_2
    invoke-virtual {v4, v9}, Landroid/widget/Switch;->setChecked(Z)V

    goto :goto_0
.end method

.method private setupPartiesShareOptions(Ljava/util/List;Landroid/widget/LinearLayout;)V
    .locals 15
    .param p2, "parentLayout"    # Landroid/widget/LinearLayout;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;",
            "Landroid/widget/LinearLayout;",
            ")V"
        }
    .end annotation

    .prologue
    .line 560
    .local p1, "currentParties":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PartyEvent;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    invoke-static {v11}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 561
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v11, 0x7f0c01b4

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/LinearLayout;

    .line 563
    .local v7, "partyLayoutContainer":Landroid/widget/LinearLayout;
    invoke-virtual {v7}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 564
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v11

    if-ge v2, v11, :cond_4

    .line 565
    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/poshmark/data_model/models/PartyEvent;

    .line 566
    .local v6, "partyEvent":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v1

    .line 568
    .local v1, "eventId":Ljava/lang/String;
    const v11, 0x7f03006f

    const/4 v12, 0x0

    invoke-virtual {v3, v11, v12}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/RelativeLayout;

    .line 569
    .local v9, "partyShareLayout":Landroid/widget/RelativeLayout;
    new-instance v4, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v11, -0x1

    const/4 v12, -0x2

    invoke-direct {v4, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 570
    .local v4, "lp":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    invoke-virtual {v11}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v11

    const/high16 v12, 0x41f00000    # 30.0f

    invoke-static {v11, v12}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v11

    float-to-int v5, v11

    .line 572
    .local v5, "margin":I
    if-nez v2, :cond_0

    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v11

    const/4 v12, 0x1

    if-ne v11, v12, :cond_0

    .line 573
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f020023

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v11

    invoke-virtual {v9, v11}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 574
    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v4, v11, v5, v12, v13}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 585
    :goto_1
    invoke-virtual {v9, v4}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 587
    const v11, 0x7f0c01ba

    invoke-virtual {v9, v11}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/TextView;

    .line 588
    .local v10, "textView":Landroid/widget/TextView;
    div-int/lit8 v11, v5, 0x3

    div-int/lit8 v12, v5, 0x3

    div-int/lit8 v13, v5, 0x3

    div-int/lit8 v14, v5, 0x3

    invoke-virtual {v10, v11, v12, v13, v14}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 589
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 590
    const v11, 0x7f0c01bc

    invoke-virtual {v9, v11}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/Switch;

    .line 591
    .local v8, "partyOptionSwitch":Landroid/widget/Switch;
    div-int/lit8 v11, v5, 0x3

    div-int/lit8 v12, v5, 0x3

    div-int/lit8 v13, v5, 0x3

    div-int/lit8 v14, v5, 0x3

    invoke-virtual {v8, v11, v12, v13, v14}, Landroid/widget/Switch;->setPadding(IIII)V

    .line 592
    invoke-virtual {v8, v1}, Landroid/widget/Switch;->setTag(Ljava/lang/Object;)V

    .line 594
    iget-object v11, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    invoke-virtual {v11}, Lcom/poshmark/utils/ListingManager;->getNewListing()Lcom/poshmark/data_model/models/NewListing;

    move-result-object v11

    invoke-virtual {v6, v11}, Lcom/poshmark/data_model/models/PartyEvent;->isListingEligibleForParty(Lcom/poshmark/data_model/models/NewListing;)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 596
    const/4 v11, 0x1

    invoke-virtual {v8, v11}, Landroid/widget/Switch;->setChecked(Z)V

    .line 597
    iget-object v11, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    invoke-virtual {v11, v1}, Lcom/poshmark/utils/ListingManager;->addEventId(Ljava/lang/String;)V

    .line 602
    :goto_2
    new-instance v11, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;

    invoke-direct {v11, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V

    invoke-virtual {v8, v11}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 653
    invoke-virtual {v7, v9, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 564
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_0

    .line 576
    .end local v8    # "partyOptionSwitch":Landroid/widget/Switch;
    .end local v10    # "textView":Landroid/widget/TextView;
    :cond_0
    if-nez v2, :cond_1

    .line 577
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f020024

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v11

    invoke-virtual {v9, v11}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 578
    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v4, v11, v5, v12, v13}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    goto :goto_1

    .line 579
    :cond_1
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v11

    add-int/lit8 v11, v11, -0x1

    if-ne v2, v11, :cond_2

    .line 580
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f020021

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v11

    invoke-virtual {v9, v11}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_1

    .line 582
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f020022

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v11

    invoke-virtual {v9, v11}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_1

    .line 599
    .restart local v8    # "partyOptionSwitch":Landroid/widget/Switch;
    .restart local v10    # "textView":Landroid/widget/TextView;
    :cond_3
    const/4 v11, 0x0

    invoke-virtual {v8, v11}, Landroid/widget/Switch;->setChecked(Z)V

    goto :goto_2

    .line 655
    .end local v1    # "eventId":Ljava/lang/String;
    .end local v4    # "lp":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v5    # "margin":I
    .end local v6    # "partyEvent":Lcom/poshmark/data_model/models/PartyEvent;
    .end local v8    # "partyOptionSwitch":Landroid/widget/Switch;
    .end local v9    # "partyShareLayout":Landroid/widget/RelativeLayout;
    .end local v10    # "textView":Landroid/widget/TextView;
    :cond_4
    return-void
.end method

.method private setupPinterestOptionView(Landroid/widget/LinearLayout;)V
    .locals 11
    .param p1, "parentLayout"    # Landroid/widget/LinearLayout;

    .prologue
    const/4 v10, 0x0

    const/16 v9, 0x8

    .line 436
    const v6, 0x7f0c01b6

    invoke-virtual {p1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/RelativeLayout;

    iput-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    .line 437
    iget-boolean v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->isPinterestButtonEnabled:Z

    if-nez v6, :cond_1

    .line 438
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v9}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 466
    :cond_0
    :goto_0
    return-void

    .line 441
    :cond_1
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v3

    .line 442
    .local v3, "padding":I
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f020024

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 443
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v3, v3, v3, v3}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 444
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01ba

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 445
    .local v5, "textView":Landroid/widget/TextView;
    const v6, 0x7f060203

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(I)V

    .line 446
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01bd

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 447
    .local v1, "connectTextView":Landroid/widget/TextView;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01bc

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Switch;

    .line 448
    .local v2, "optionSwitch":Landroid/widget/Switch;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinterestSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-virtual {v2, v6}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 449
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01be

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 451
    .local v0, "arrowImageView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 452
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getPinterestToken()Ljava/lang/String;

    move-result-object v4

    .line 453
    .local v4, "pin_Id":Ljava/lang/String;
    if-nez v4, :cond_2

    .line 454
    invoke-virtual {v2, v9}, Landroid/widget/Switch;->setVisibility(I)V

    .line 455
    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 456
    invoke-virtual {v0, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 458
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinShareLayout:Landroid/widget/RelativeLayout;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->doPinterestConnect:Landroid/view/View$OnClickListener;

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 460
    :cond_2
    invoke-virtual {v1, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 461
    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 462
    invoke-virtual {v2, v10}, Landroid/widget/Switch;->setVisibility(I)V

    .line 463
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getPinterestSharingFlag()Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    invoke-virtual {v2, v6}, Landroid/widget/Switch;->setChecked(Z)V

    goto/16 :goto_0
.end method

.method private setupShareBanner(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 424
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showBanner:Z

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;->data:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;->data:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;->image_url:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 425
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;->data:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;->bg_color:Ljava/lang/String;

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v0

    .line 426
    .local v0, "color":I
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;->data:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;->image_url:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;->data:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;

    iget-object v1, v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;->image_url:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 427
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->share_banner_image:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 428
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    iget-object v2, v2, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;->data:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;

    iget-object v2, v2, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;->image_url:Ljava/lang/String;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->share_banner_image:Landroid/widget/ImageView;

    invoke-virtual {v1, v2, v3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 433
    .end local v0    # "color":I
    :cond_0
    :goto_0
    return-void

    .line 431
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->share_banner_image:Landroid/widget/ImageView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method private setupTopBorder(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 412
    const v4, 0x7f0c01b5

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 413
    .local v3, "share_items_layout":Landroid/widget/LinearLayout;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v4

    if-ge v1, v4, :cond_0

    .line 414
    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 415
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-nez v4, :cond_1

    .line 416
    invoke-virtual {v0}, Landroid/view/View;->getPaddingTop()I

    move-result v2

    .line 417
    .local v2, "padding":I
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020024

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 418
    invoke-virtual {v0, v2, v2, v2, v2}, Landroid/view/View;->setPadding(IIII)V

    .line 422
    .end local v0    # "child":Landroid/view/View;
    .end local v2    # "padding":I
    :cond_0
    return-void

    .line 413
    .restart local v0    # "child":Landroid/view/View;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private setupTumblrOptionView(Landroid/widget/LinearLayout;)V
    .locals 11
    .param p1, "parentLayout"    # Landroid/widget/LinearLayout;

    .prologue
    const/16 v10, 0x8

    const/4 v9, 0x0

    .line 530
    const v6, 0x7f0c01b9

    invoke-virtual {p1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/RelativeLayout;

    iput-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    .line 531
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v3

    .line 532
    .local v3, "padding":I
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f020021

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 533
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v3, v3, v3, v3}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 535
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01ba

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 536
    .local v4, "textView":Landroid/widget/TextView;
    const v6, 0x7f06029e

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(I)V

    .line 537
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01bd

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 538
    .local v1, "connectTextView":Landroid/widget/TextView;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01bc

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Switch;

    .line 539
    .local v2, "optionSwitch":Landroid/widget/Switch;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tmSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-virtual {v2, v6}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 540
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01be

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 542
    .local v0, "arrowImageView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 543
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getTumblrToken()Ljava/lang/String;

    move-result-object v5

    .line 544
    .local v5, "tw_Id":Ljava/lang/String;
    if-nez v5, :cond_1

    .line 545
    invoke-virtual {v2, v10}, Landroid/widget/Switch;->setVisibility(I)V

    .line 546
    invoke-virtual {v1, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 547
    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 549
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->doTumblrConnect:Landroid/view/View$OnClickListener;

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 557
    .end local v5    # "tw_Id":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 551
    .restart local v5    # "tw_Id":Ljava/lang/String;
    :cond_1
    invoke-virtual {v2, v9}, Landroid/widget/Switch;->setVisibility(I)V

    .line 552
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getTumblrSharingFlag()Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    invoke-virtual {v2, v6}, Landroid/widget/Switch;->setChecked(Z)V

    .line 553
    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 554
    invoke-virtual {v0, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method private setupTwitterOptionView(Landroid/widget/LinearLayout;)V
    .locals 9
    .param p1, "parentLayout"    # Landroid/widget/LinearLayout;

    .prologue
    const/16 v8, 0x8

    const/4 v7, 0x0

    .line 503
    const v5, 0x7f0c01b8

    invoke-virtual {p1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    .line 505
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v6, 0x7f0c01ba

    invoke-virtual {v5, v6}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 506
    .local v3, "textView":Landroid/widget/TextView;
    const v5, 0x7f0602a0

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(I)V

    .line 507
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v6, 0x7f0c01bd

    invoke-virtual {v5, v6}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 508
    .local v1, "connectTextView":Landroid/widget/TextView;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v6, 0x7f0c01bc

    invoke-virtual {v5, v6}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Switch;

    .line 509
    .local v2, "optionSwitch":Landroid/widget/Switch;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twSwitchToggled:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-virtual {v2, v5}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 510
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v6, 0x7f0c01be

    invoke-virtual {v5, v6}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 512
    .local v0, "arrowImageView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 513
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getTwitterToken()Ljava/lang/String;

    move-result-object v4

    .line 514
    .local v4, "tw_Id":Ljava/lang/String;
    if-nez v4, :cond_1

    .line 515
    invoke-virtual {v2, v8}, Landroid/widget/Switch;->setVisibility(I)V

    .line 516
    invoke-virtual {v1, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 517
    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 519
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->doTwitterConnect:Landroid/view/View$OnClickListener;

    invoke-virtual {v5, v6}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 527
    .end local v4    # "tw_Id":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 521
    .restart local v4    # "tw_Id":Ljava/lang/String;
    :cond_1
    invoke-virtual {v2, v7}, Landroid/widget/Switch;->setVisibility(I)V

    .line 522
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getTwitterSharingFlag()Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    invoke-virtual {v2, v5}, Landroid/widget/Switch;->setChecked(Z)V

    .line 523
    invoke-virtual {v1, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 524
    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method private setupView(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 395
    move-object v2, p1

    check-cast v2, Landroid/widget/LinearLayout;

    .line 396
    .local v2, "shareLayout":Landroid/widget/LinearLayout;
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupPinterestOptionView(Landroid/widget/LinearLayout;)V

    .line 397
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupFacebookOptionView(Landroid/widget/LinearLayout;)V

    .line 398
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupTwitterOptionView(Landroid/widget/LinearLayout;)V

    .line 399
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupTumblrOptionView(Landroid/widget/LinearLayout;)V

    .line 403
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    .line 404
    .local v1, "partiesController":Lcom/poshmark/controllers/GlobalPartiesController;
    invoke-virtual {v1}, Lcom/poshmark/controllers/GlobalPartiesController;->getCurrentParties()Ljava/util/List;

    move-result-object v0

    .line 405
    .local v0, "currentParties":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PartyEvent;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 406
    invoke-direct {p0, v0, v2}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupPartiesShareOptions(Ljava/util/List;Landroid/widget/LinearLayout;)V

    .line 408
    :cond_0
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupTopBorder(Landroid/view/View;)V

    .line 409
    return-void
.end method

.method private showPinterestSuccessConnectDialog()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 216
    new-instance v0, Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-direct {v0}, Lcom/poshmark/utils/view_holders/PinterestDialog;-><init>()V

    .line 217
    .local v0, "dialog":Lcom/poshmark/utils/view_holders/PinterestDialog;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "post_connect_pinterest_dlg_screen"

    invoke-virtual {v1, v2}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 218
    sget-object v1, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->POST_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/view_holders/PinterestDialog;->setCurrent_mode(Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;)V

    .line 219
    new-instance v1, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$1;

    invoke-direct {v1, p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$1;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;Lcom/poshmark/utils/view_holders/PinterestDialog;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/view_holders/PinterestDialog;->setClickListener(Landroid/view/View$OnClickListener;)V

    .line 225
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "pin"

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/view_holders/PinterestDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 226
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplicationSession;->setPinterestPostDialogShown(Ljava/lang/Boolean;)V

    .line 227
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplicationSession;->setPinterestPreDialogShownFlag(Ljava/lang/Boolean;)V

    .line 228
    return-void
.end method


# virtual methods
.method public fbLoginComplete(I)V
    .locals 8
    .param p1, "permissions"    # I

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 231
    and-int/lit8 v3, p1, 0x1

    if-eqz v3, :cond_0

    .line 233
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01bd

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 234
    .local v1, "connectTextView":Landroid/widget/TextView;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01bc

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Switch;

    .line 235
    .local v2, "optionSwitch":Landroid/widget/Switch;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01be

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 237
    .local v0, "arrowImageView":Landroid/widget/ImageView;
    invoke-virtual {v2, v5}, Landroid/widget/Switch;->setVisibility(I)V

    .line 238
    invoke-virtual {v1, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 239
    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 242
    and-int/lit8 v3, p1, 0x8

    if-eqz v3, :cond_1

    .line 243
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getFacebookSharingFlag()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/Switch;->setChecked(Z)V

    .line 249
    :goto_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 250
    invoke-virtual {v2, v6}, Landroid/widget/Switch;->setChecked(Z)V

    .line 251
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    invoke-virtual {v3, v6}, Lcom/poshmark/utils/ListingManager;->setFacebookShareFlag(Z)V

    .line 253
    .end local v0    # "arrowImageView":Landroid/widget/ImageView;
    .end local v1    # "connectTextView":Landroid/widget/TextView;
    .end local v2    # "optionSwitch":Landroid/widget/Switch;
    :cond_0
    return-void

    .line 245
    .restart local v0    # "arrowImageView":Landroid/widget/ImageView;
    .restart local v1    # "connectTextView":Landroid/widget/TextView;
    .restart local v2    # "optionSwitch":Landroid/widget/Switch;
    :cond_1
    invoke-virtual {v2, v5}, Landroid/widget/Switch;->setChecked(Z)V

    goto :goto_0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 676
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 677
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 678
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getView()Landroid/view/View;

    move-result-object v1

    .line 679
    .local v1, "v":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 684
    const v2, 0x7f0c01b2

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 685
    .local v0, "layout":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 686
    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupView(Landroid/view/View;)V

    .line 691
    .end local v0    # "layout":Landroid/view/View;
    .end local v1    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 100
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 101
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupActionBarNextActionButton()V

    .line 102
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 106
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 107
    invoke-static {p1}, Lcom/facebook/FacebookSdk;->isFacebookRequestCode(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 108
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getCallbackManager()Lcom/facebook/CallbackManager;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3}, Lcom/facebook/CallbackManager;->onActivityResult(IILandroid/content/Intent;)Z

    .line 110
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 66
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 67
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 69
    if-eqz p1, :cond_2

    .line 70
    const-string v1, "LISTING_MANAGER_PICKUP_KEY"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/os/ParcelUuid;

    .line 71
    .local v0, "key":Landroid/os/ParcelUuid;
    if-eqz v0, :cond_0

    .line 72
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/ListingManager;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    .line 74
    :cond_0
    const-string v1, "show_banner"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showBanner:Z

    .line 84
    .end local v0    # "key":Landroid/os/ParcelUuid;
    :cond_1
    :goto_0
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FeatureManager;->isPinterestConnectionDialogShowable()Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->isPinterestDialogShowable:Z

    .line 85
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FeatureManager;->isPinterestButtonEnabled()Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->isPinterestButtonEnabled:Z

    .line 86
    return-void

    .line 76
    :cond_2
    const-class v1, Lcom/poshmark/utils/ListingManager;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/ListingManager;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    .line 77
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "share_banner"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->shareBanner:Ljava/lang/String;

    .line 78
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->shareBanner:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 79
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showBanner:Z

    .line 80
    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->shareBanner:Ljava/lang/String;

    const-class v3, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    instance-of v4, v1, Lcom/google/gson/Gson;

    if-nez v4, :cond_3

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    :goto_1
    check-cast v1, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->bannerResponse:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    goto :goto_0

    :cond_3
    check-cast v1, Lcom/google/gson/Gson;

    invoke-static {v1, v2, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 90
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 91
    const v1, 0x7f03006e

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 92
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c01b3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->share_banner_image:Landroid/widget/ImageView;

    .line 93
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupView(Landroid/view/View;)V

    .line 94
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupShareBanner(Landroid/view/View;)V

    .line 95
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 11
    .param p1, "result"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    const/4 v7, 0x0

    .line 114
    const/4 v6, 0x2

    if-ne p2, v6, :cond_1

    .line 115
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    invoke-virtual {v6, p1}, Lcom/poshmark/utils/ListingManager;->handleValidationResult(Landroid/os/Bundle;)V

    .line 171
    :cond_0
    :goto_0
    return-void

    .line 116
    :cond_1
    sget v6, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_READ_REQUEST:I

    if-ne p2, v6, :cond_3

    .line 118
    if-eqz p1, :cond_0

    .line 119
    const-string v6, "HAS_ERROR"

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 120
    .local v2, "hasError":Z
    if-nez v2, :cond_2

    .line 121
    const-string v6, "ACCESS_LEVEL"

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v4

    .line 122
    .local v4, "permissions":I
    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->fbLoginComplete(I)V

    goto :goto_0

    .line 124
    .end local v4    # "permissions":I
    :cond_2
    const-string v6, "ERROR_JSON"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 125
    .local v1, "errorJson":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 126
    invoke-static {v1}, Lcom/poshmark/http/api/PMApiError;->deserialize(Ljava/lang/String;)Lcom/poshmark/http/api/PMApiError;

    move-result-object v0

    .line 127
    .local v0, "error":Lcom/poshmark/http/api/PMApiError;
    invoke-static {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;)V

    goto :goto_0

    .line 131
    .end local v0    # "error":Lcom/poshmark/http/api/PMApiError;
    .end local v1    # "errorJson":Ljava/lang/String;
    .end local v2    # "hasError":Z
    :cond_3
    sget v6, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_PUBLISH_REQUEST:I

    if-ne p2, v6, :cond_5

    .line 132
    if-eqz p1, :cond_0

    .line 133
    const-string v6, "HAS_ERROR"

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 134
    .restart local v2    # "hasError":Z
    if-nez v2, :cond_4

    .line 135
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getView()Landroid/view/View;

    move-result-object v5

    .line 136
    .local v5, "v":Landroid/view/View;
    if-eqz v5, :cond_0

    .line 141
    const v6, 0x7f0c01b2

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 142
    .local v3, "layout":Landroid/view/View;
    if-eqz v3, :cond_0

    .line 143
    check-cast v3, Landroid/widget/LinearLayout;

    .end local v3    # "layout":Landroid/view/View;
    invoke-direct {p0, v3}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupFacebookOptionView(Landroid/widget/LinearLayout;)V

    goto :goto_0

    .line 147
    .end local v5    # "v":Landroid/view/View;
    :cond_4
    const-string v6, "ERROR_JSON"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 148
    .restart local v1    # "errorJson":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 149
    invoke-static {v1}, Lcom/poshmark/http/api/PMApiError;->deserialize(Ljava/lang/String;)Lcom/poshmark/http/api/PMApiError;

    move-result-object v0

    .line 150
    .restart local v0    # "error":Lcom/poshmark/http/api/PMApiError;
    invoke-static {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;)V

    goto :goto_0

    .line 154
    .end local v0    # "error":Lcom/poshmark/http/api/PMApiError;
    .end local v1    # "errorJson":Ljava/lang/String;
    .end local v2    # "hasError":Z
    :cond_5
    const/16 v6, 0x2244

    if-ne p2, v6, :cond_0

    .line 156
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->share_banner_image:Landroid/widget/ImageView;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 158
    if-eqz p1, :cond_0

    .line 159
    const-string v6, "HAS_ERROR"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    .line 160
    .restart local v2    # "hasError":Z
    if-eqz v2, :cond_6

    .line 161
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v7

    const-string v8, "user"

    const-string v9, "connect_pinterest_failed"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v7, v8, v9, v10}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    const v6, 0x7f06022e

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 164
    :cond_6
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v7

    const-string v8, "user"

    const-string v9, "connect_pinterest_complete"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v7, v8, v9, v10}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->hideProgressDialog()V

    .line 166
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->pinterestLoginComplete()V

    goto/16 :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 182
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 183
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    if-eqz v1, :cond_0

    .line 184
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 185
    .local v0, "id":Ljava/util/UUID;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 186
    const-string v1, "LISTING_MANAGER_PICKUP_KEY"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 188
    .end local v0    # "id":Ljava/util/UUID;
    :cond_0
    const-string v1, "show_banner"

    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showBanner:Z

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 189
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 193
    const-string v0, "listing_confirmation_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 194
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 175
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 176
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupActionBarNextActionButton()V

    .line 177
    const v0, 0x7f060253

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setTitle(I)V

    .line 178
    return-void
.end method

.method public tumblrLoginComplete(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x1

    .line 273
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01bd

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 274
    .local v1, "connectTextView":Landroid/widget/TextView;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01bc

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Switch;

    .line 275
    .local v2, "optionSwitch":Landroid/widget/Switch;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01be

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 277
    .local v0, "arrowImageView":Landroid/widget/ImageView;
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Switch;->setVisibility(I)V

    .line 278
    invoke-virtual {v1, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 279
    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 282
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 283
    invoke-virtual {v2, v5}, Landroid/widget/Switch;->setChecked(Z)V

    .line 284
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    invoke-virtual {v3, v5}, Lcom/poshmark/utils/ListingManager;->setTumblrShareFlag(Z)V

    .line 285
    return-void
.end method

.method public twitterLoginComplete(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x1

    .line 257
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01bd

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 258
    .local v1, "connectTextView":Landroid/widget/TextView;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01bc

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Switch;

    .line 259
    .local v2, "optionSwitch":Landroid/widget/Switch;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v4, 0x7f0c01be

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 261
    .local v0, "arrowImageView":Landroid/widget/ImageView;
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Switch;->setVisibility(I)V

    .line 262
    invoke-virtual {v1, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 263
    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 266
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 267
    invoke-virtual {v2, v5}, Landroid/widget/Switch;->setChecked(Z)V

    .line 268
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;

    invoke-virtual {v3, v5}, Lcom/poshmark/utils/ListingManager;->setTwitterShareFlag(Z)V

    .line 269
    return-void
.end method
