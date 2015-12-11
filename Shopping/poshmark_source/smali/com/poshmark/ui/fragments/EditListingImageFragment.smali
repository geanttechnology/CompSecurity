.class public Lcom/poshmark/ui/fragments/EditListingImageFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "EditListingImageFragment.java"


# static fields
.field public static final DELETEIMAGE:I = 0x0

.field public static final EDITIMAGE:I = 0x1

.field public static final NEWIMAGE:I = 0x2


# instance fields
.field private CAPTURE_IMAGE:I

.field private FILTER_IMAGE:I

.field private bIsCovershot:Z

.field private bIsNewListing:Z

.field private cameraButton:Landroid/widget/ImageButton;

.field private editButton:Landroid/widget/ImageButton;

.field image:Lcom/poshmark/ui/customviews/PMListingImageView;

.field imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

.field private imageURI:Landroid/net/Uri;

.field private imageURL:Ljava/lang/String;

.field private originalImageURI:Landroid/net/Uri;

.field private recycleButton:Landroid/widget/ImageButton;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 32
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->bIsCovershot:Z

    .line 33
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->bIsNewListing:Z

    .line 47
    const/4 v0, 0x3

    iput v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->FILTER_IMAGE:I

    .line 48
    const/4 v0, 0x4

    iput v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->CAPTURE_IMAGE:I

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/EditListingImageFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/EditListingImageFragment;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->fireCameraActivity()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/EditListingImageFragment;)Landroid/net/Uri;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/EditListingImageFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->originalImageURI:Landroid/net/Uri;

    return-object v0
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/EditListingImageFragment;Landroid/net/Uri;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/EditListingImageFragment;
    .param p1, "x1"    # Landroid/net/Uri;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->fireCameraFiltersActivity(Landroid/net/Uri;)V

    return-void
.end method

.method private fireCameraActivity()V
    .locals 5

    .prologue
    .line 186
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 187
    .local v2, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 188
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    const-class v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 189
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 190
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "CREATION_MODE"

    sget v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 191
    iget-object v3, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isCovershot()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 192
    const-string v3, "IS_FIRST_IMAGE"

    const/4 v4, 0x1

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 194
    :cond_0
    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 195
    iget v3, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->CAPTURE_IMAGE:I

    invoke-virtual {p0, v1, v3}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 196
    return-void
.end method

.method private fireCameraFiltersActivity(Landroid/net/Uri;)V
    .locals 5
    .param p1, "imageFile"    # Landroid/net/Uri;

    .prologue
    .line 175
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 176
    .local v2, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 177
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    const-class v4, Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 178
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 179
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "FILE"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 180
    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 181
    iget v3, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->FILTER_IMAGE:I

    invoke-virtual {p0, v1, v3}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 182
    return-void
.end method

.method private releaseBitmap()V
    .locals 2

    .prologue
    .line 201
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->image:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMListingImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 202
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 204
    return-void
.end method

.method private setupButtonHandlers()V
    .locals 2

    .prologue
    .line 143
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c00f3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->recycleButton:Landroid/widget/ImageButton;

    .line 144
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c00f4

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->cameraButton:Landroid/widget/ImageButton;

    .line 145
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c00f2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->editButton:Landroid/widget/ImageButton;

    .line 147
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->recycleButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/poshmark/ui/fragments/EditListingImageFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment$1;-><init>(Lcom/poshmark/ui/fragments/EditListingImageFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->cameraButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/poshmark/ui/fragments/EditListingImageFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment$2;-><init>(Lcom/poshmark/ui/fragments/EditListingImageFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 165
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->editButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/poshmark/ui/fragments/EditListingImageFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment$3;-><init>(Lcom/poshmark/ui/fragments/EditListingImageFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 171
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x0

    .line 95
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 96
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->setupButtonHandlers()V

    .line 98
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->bIsNewListing:Z

    if-eqz v0, :cond_2

    .line 99
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->bIsCovershot:Z

    if-eqz v0, :cond_1

    .line 100
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->editButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 110
    :cond_0
    :goto_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->hideAllActionButtons(Z)V

    .line 111
    return-void

    .line 102
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->recycleButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0

    .line 105
    :cond_2
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->bIsCovershot:Z

    if-nez v0, :cond_0

    .line 106
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->recycleButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 5
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v4, -0x1

    .line 115
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 116
    if-ne p2, v4, :cond_1

    .line 117
    iget v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->FILTER_IMAGE:I

    if-eq p1, v2, :cond_0

    iget v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->CAPTURE_IMAGE:I

    if-ne p1, v2, :cond_1

    .line 118
    :cond_0
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 119
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "EDITMODE"

    const/4 v3, 0x2

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 120
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 121
    .local v1, "i":Landroid/content/Intent;
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 122
    invoke-virtual {p0, v4, v1}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 125
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "i":Landroid/content/Intent;
    :cond_1
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 53
    if-nez p1, :cond_2

    .line 54
    const-class v2, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 55
    .local v0, "e":Ljava/lang/Object;
    if-eqz v0, :cond_0

    .line 56
    check-cast v0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .end local v0    # "e":Ljava/lang/Object;
    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 66
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    if-eqz v2, :cond_1

    .line 67
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageUrl()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageURL:Ljava/lang/String;

    .line 68
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageURL:Ljava/lang/String;

    if-nez v2, :cond_1

    .line 69
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getFileUri()Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageURI:Landroid/net/Uri;

    .line 70
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getOriginalFileUri()Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->originalImageURI:Landroid/net/Uri;

    .line 74
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "COVERSHOT"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->bIsCovershot:Z

    .line 75
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "NEWLISTING"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->bIsNewListing:Z

    .line 76
    return-void

    .line 59
    :cond_2
    const-string v2, "EDIT_MODE_IMAGEVIEW"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/os/ParcelUuid;

    .line 60
    .local v1, "key":Landroid/os/ParcelUuid;
    if-eqz v1, :cond_0

    .line 61
    invoke-virtual {v1}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 80
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 81
    const v1, 0x7f030039

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 82
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c00f1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->image:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 83
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageURL:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 84
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->image:Lcom/poshmark/ui/customviews/PMListingImageView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageURL:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    .line 89
    :cond_0
    :goto_0
    const v1, 0x7f0600c3

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->setTitle(I)V

    .line 90
    return-object v0

    .line 85
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageURI:Landroid/net/Uri;

    if-eqz v1, :cond_0

    .line 87
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->image:Lcom/poshmark/ui/customviews/PMListingImageView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageURI:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMListingImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 129
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 130
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    if-eqz v1, :cond_0

    .line 131
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 132
    .local v0, "id":Ljava/util/UUID;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->imageSelectorView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 133
    const-string v1, "EDIT_MODE_IMAGEVIEW"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 135
    .end local v0    # "id":Ljava/util/UUID;
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 139
    const-string v0, "image_preview_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 140
    return-void
.end method
