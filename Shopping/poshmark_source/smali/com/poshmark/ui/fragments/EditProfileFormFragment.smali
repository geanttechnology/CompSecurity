.class public Lcom/poshmark/ui/fragments/EditProfileFormFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "EditProfileFormFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;
    }
.end annotation


# instance fields
.field private SELECT_PICTURE:I

.field private avataarImageFile:Landroid/net/Uri;

.field private changePasswordListener:Landroid/view/View$OnTouchListener;

.field private focusChangeListener:Landroid/view/View$OnFocusChangeListener;

.field private imageClickListener:Landroid/view/View$OnClickListener;

.field private isAvtaarImageSet:Z

.field metaData:Lcom/poshmark/utils/meta_data/ListingMetaDataController;

.field mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

.field profileUpdated:Z

.field userProfile:Lcom/poshmark/user/UserInfoDetails;

.field private viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 51
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->SELECT_PICTURE:I

    .line 53
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAvtaarImageSet:Z

    .line 65
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->profileUpdated:Z

    .line 198
    new-instance v0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$2;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->changePasswordListener:Landroid/view/View$OnTouchListener;

    .line 211
    new-instance v0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$3;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->imageClickListener:Landroid/view/View$OnClickListener;

    .line 227
    new-instance v0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$4;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->focusChangeListener:Landroid/view/View$OnFocusChangeListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->updateView()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    .prologue
    .line 49
    iget v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->SELECT_PICTURE:I

    return v0
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    return-object v0
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isFormValid()Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAvtaarImageSet:Z

    return v0
.end method

.method private isFormValid()Z
    .locals 3

    .prologue
    .line 510
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 511
    .local v0, "validateTxt":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_1

    .line 512
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 515
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_2

    .line 516
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 519
    :cond_2
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 520
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060148

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 521
    const/4 v1, 0x0

    .line 523
    :goto_0
    return v1

    :cond_3
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private loadUserProfile()V
    .locals 2

    .prologue
    .line 168
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    if-nez v0, :cond_0

    .line 169
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 170
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getUserProfile(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 196
    :goto_0
    return-void

    .line 194
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->updateView()V

    goto :goto_0
.end method

.method private restoreState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 239
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_EDIT:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v2, v3, :cond_2

    .line 240
    if-eqz p1, :cond_1

    .line 241
    const-string v2, "IS_IMAGE_SET"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAvtaarImageSet:Z

    .line 242
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAvtaarImageSet:Z

    if-eqz v2, :cond_0

    .line 243
    const-string v2, "IMAGE_FILE"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 244
    .local v0, "fileName":Ljava/lang/String;
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->avataarImageFile:Landroid/net/Uri;

    .line 247
    .end local v0    # "fileName":Ljava/lang/String;
    :cond_0
    const-string v2, "USER_PROFILE_PICKUP_KEY"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/os/ParcelUuid;

    .line 248
    .local v1, "key":Landroid/os/ParcelUuid;
    if-eqz v1, :cond_1

    .line 249
    invoke-virtual {v1}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/user/UserInfoDetails;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    .line 252
    .end local v1    # "key":Landroid/os/ParcelUuid;
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->loadUserProfile()V

    .line 254
    :cond_2
    return-void
.end method

.method private setupNextActionButton()V
    .locals 2

    .prologue
    .line 327
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->hideAllActionButtons(Z)V

    .line 328
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_CREATE:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v0, v1, :cond_0

    .line 329
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->setupNextActionForCreate()V

    .line 334
    :goto_0
    return-void

    .line 332
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->setupNextActionForUpdate()V

    goto :goto_0
.end method

.method private setupNextActionForCreate()V
    .locals 2

    .prologue
    .line 337
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 338
    .local v0, "nextActionButton":Landroid/widget/Button;
    if-nez v0, :cond_0

    .line 419
    :goto_0
    return-void

    .line 341
    :cond_0
    const v1, 0x7f0601cc

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 342
    new-instance v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private setupNextActionForUpdate()V
    .locals 2

    .prologue
    .line 422
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 423
    .local v0, "nextActionButton":Landroid/widget/Button;
    if-nez v0, :cond_0

    .line 506
    :goto_0
    return-void

    .line 426
    :cond_0
    const v1, 0x7f0602b3

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 427
    new-instance v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private setupView(Landroid/view/View;)V
    .locals 13
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const v12, 0x1090009

    const v2, 0x1090008

    const/4 v5, 0x0

    const/16 v7, 0x8

    .line 287
    new-instance v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    .line 289
    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c0103

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, v6, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->cityEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 290
    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c0104

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, v6, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->websiteEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 292
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v6, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_CREATE:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v1, v6, :cond_1

    .line 293
    const v1, 0x7f0c00fd

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v7}, Landroid/view/View;->setVisibility(I)V

    .line 295
    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c00fc

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Spinner;

    iput-object v1, v6, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->shoeSizeSpinner:Landroid/widget/Spinner;

    .line 296
    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c00fa

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Spinner;

    iput-object v1, v6, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->dressSizeSpinner:Landroid/widget/Spinner;

    .line 297
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->metaData:Lcom/poshmark/utils/meta_data/ListingMetaDataController;

    if-nez v1, :cond_0

    .line 298
    new-instance v1, Lcom/poshmark/utils/meta_data/ListingMetaDataController;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/ListingMetaDataController;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->metaData:Lcom/poshmark/utils/meta_data/ListingMetaDataController;

    .line 300
    :cond_0
    const v1, 0x7f0601e5

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 301
    .local v4, "hintStr":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/db/DbApi;->getShoeSizes()Ljava/util/List;

    move-result-object v3

    .line 302
    .local v3, "shoeSizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    new-instance v0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct/range {v0 .. v5}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;-><init>(Landroid/content/Context;ILjava/util/List;Ljava/lang/String;Z)V

    .line 303
    .local v0, "adapter":Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;
    invoke-virtual {v0, v12}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->setDropDownViewResource(I)V

    .line 304
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->shoeSizeSpinner:Landroid/widget/Spinner;

    invoke-virtual {v1, v0}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 306
    invoke-static {}, Lcom/poshmark/db/DbApi;->getDressSizes()Ljava/util/List;

    move-result-object v9

    .line 307
    .local v9, "dressSizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    new-instance v0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;

    .end local v0    # "adapter":Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    move-object v6, v0

    move v8, v2

    move-object v10, v4

    move v11, v5

    invoke-direct/range {v6 .. v11}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;-><init>(Landroid/content/Context;ILjava/util/List;Ljava/lang/String;Z)V

    .line 308
    .restart local v0    # "adapter":Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;
    invoke-virtual {v0, v12}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->setDropDownViewResource(I)V

    .line 309
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->dressSizeSpinner:Landroid/widget/Spinner;

    invoke-virtual {v1, v0}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 324
    .end local v0    # "adapter":Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;
    .end local v3    # "shoeSizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v4    # "hintStr":Ljava/lang/String;
    .end local v9    # "dressSizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_0
    return-void

    .line 312
    :cond_1
    const v1, 0x7f0c00f8

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v7}, Landroid/view/View;->setVisibility(I)V

    .line 313
    const v1, 0x7f0c00f5

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v7}, Landroid/view/View;->setVisibility(I)V

    .line 315
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c00fe

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 316
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c00ff

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 317
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c0100

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 318
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c0101

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 319
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    const v1, 0x7f0c0102

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 320
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->changePasswordListener:Landroid/view/View$OnTouchListener;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 321
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->focusChangeListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 322
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->imageClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private updateView()V
    .locals 7

    .prologue
    .line 257
    iget-boolean v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAvtaarImageSet:Z

    if-eqz v5, :cond_1

    .line 259
    new-instance v3, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v3}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 260
    .local v3, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v5, 0x1

    iput-boolean v5, v3, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 261
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->avataarImageFile:Landroid/net/Uri;

    invoke-virtual {v5}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v3}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 262
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v5, v0}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 268
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v3    # "options":Landroid/graphics/BitmapFactory$Options;
    :goto_0
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v6}, Lcom/poshmark/user/UserInfoDetails;->getUserEmail()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 269
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v6}, Lcom/poshmark/user/UserInfoDetails;->getUserFirstName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 270
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v6}, Lcom/poshmark/user/UserInfoDetails;->getUserLastName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 271
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getProfile()Lcom/poshmark/data_model/models/inner_models/Profile;

    move-result-object v5

    iget-object v1, v5, Lcom/poshmark/data_model/models/inner_models/Profile;->city:Ljava/lang/String;

    .line 272
    .local v1, "city":Ljava/lang/String;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getProfile()Lcom/poshmark/data_model/models/inner_models/Profile;

    move-result-object v5

    iget-object v4, v5, Lcom/poshmark/data_model/models/inner_models/Profile;->state:Ljava/lang/String;

    .line 274
    .local v4, "state":Ljava/lang/String;
    const/4 v2, 0x0

    .line 275
    .local v2, "location":Ljava/lang/String;
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_2

    if-eqz v4, :cond_2

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_2

    .line 276
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 282
    :cond_0
    :goto_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->cityEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v5, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 283
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->websiteEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v6}, Lcom/poshmark/user/UserInfoDetails;->getProfile()Lcom/poshmark/data_model/models/inner_models/Profile;

    move-result-object v6

    iget-object v6, v6, Lcom/poshmark/data_model/models/inner_models/Profile;->website:Ljava/lang/String;

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 284
    return-void

    .line 266
    .end local v1    # "city":Ljava/lang/String;
    .end local v2    # "location":Ljava/lang/String;
    .end local v4    # "state":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v6}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 277
    .restart local v1    # "city":Ljava/lang/String;
    .restart local v2    # "location":Ljava/lang/String;
    .restart local v4    # "state":Ljava/lang/String;
    :cond_2
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_3

    .line 278
    move-object v2, v1

    goto :goto_1

    .line 279
    :cond_3
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_0

    .line 280
    move-object v2, v4

    goto :goto_1
.end method


# virtual methods
.method public handleBack()Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    .line 140
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->profileUpdated:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_EDIT:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v2, v3, :cond_0

    .line 141
    const-string v2, "com.poshmark.intents.PROFILE_UPDATED"

    invoke-static {v2}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 143
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 144
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->getFragmentStackCount()I

    move-result v2

    if-le v2, v1, :cond_1

    .line 145
    const/4 v1, 0x0

    .line 148
    :goto_0
    return v1

    .line 147
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->finishActivity()V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 101
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 102
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 6
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v5, 0x1

    .line 106
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 107
    const/4 v3, -0x1

    if-ne p2, v3, :cond_0

    .line 108
    iget v3, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->SELECT_PICTURE:I

    if-ne p1, v3, :cond_0

    .line 109
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 110
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "IMAGE_FILE_URI"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Landroid/net/Uri;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->avataarImageFile:Landroid/net/Uri;

    .line 111
    new-instance v2, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v2}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 112
    .local v2, "options":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v5, v2, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 113
    iget-object v3, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->avataarImageFile:Landroid/net/Uri;

    invoke-virtual {v3}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v2}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 114
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v3, v4}, Lcom/nostra13/universalimageloader/core/ImageLoader;->cancelDisplayTask(Landroid/widget/ImageView;)V

    .line 115
    iget-object v3, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v3, v1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 116
    iput-boolean v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAvtaarImageSet:Z

    .line 120
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "options":Landroid/graphics/BitmapFactory$Options;
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 71
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 72
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 73
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 74
    invoke-static {}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->values()[Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    move-result-object v1

    const-string v2, "MODE"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    aget-object v1, v1, v2

    iput-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    .line 79
    :goto_0
    return-void

    .line 77
    :cond_0
    sget-object v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_CREATE:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 83
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 84
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_CREATE:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v1, v2, :cond_0

    .line 85
    const v1, 0x7f0600cf

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->setTitle(I)V

    .line 88
    :goto_0
    const v1, 0x7f03003a

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 89
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->setupView(Landroid/view/View;)V

    .line 90
    invoke-direct {p0, p3}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->restoreState(Landroid/os/Bundle;)V

    .line 91
    return-object v0

    .line 87
    .end local v0    # "v":Landroid/view/View;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "@"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->setTitle(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 96
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 97
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 124
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 125
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAvtaarImageSet:Z

    if-eqz v1, :cond_0

    .line 126
    const-string v1, "IMAGE_FILE"

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->avataarImageFile:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    const-string v1, "IS_IMAGE_SET"

    const/4 v2, 0x1

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 130
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    if-eqz v1, :cond_1

    .line 131
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 132
    .local v0, "id":Ljava/util/UUID;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 133
    const-string v1, "USER_PROFILE_PICKUP_KEY"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 135
    .end local v0    # "id":Ljava/util/UUID;
    :cond_1
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_CREATE:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v0, v1, :cond_1

    .line 160
    const-string v0, "create_user_profile_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 162
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->mode:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_EDIT:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    if-ne v0, v1, :cond_0

    .line 163
    const-string v0, "edit_user_profile_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public setupActionBar()V
    .locals 0

    .prologue
    .line 154
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 155
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->setupNextActionButton()V

    .line 156
    return-void
.end method
