.class public Lcom/poshmark/ui/fragments/CameraFiltersFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "CameraFiltersFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/CameraFiltersFragment$11;,
        Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;,
        Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;
    }
.end annotation


# instance fields
.field currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

.field fileName:Landroid/net/Uri;

.field filteredDrawable:Landroid/graphics/drawable/Drawable;

.field imageView:Lcom/poshmark/ui/customviews/PMListingImageView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 35
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 48
    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->fileName:Landroid/net/Uri;

    .line 50
    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 243
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/CameraFiltersFragment;Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraFiltersFragment;
    .param p1, "x1"    # Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getFilterNameForType(Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->resetImage()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getDisplayBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method private getDisplayBitmap()Landroid/graphics/Bitmap;
    .locals 3

    .prologue
    .line 124
    new-instance v1, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v1}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 125
    .local v1, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v2, 0x1

    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 126
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->fileName:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 127
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    return-object v0
.end method

.method private getFilterNameForType(Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;
    .locals 2
    .param p1, "type"    # Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .prologue
    .line 287
    sget-object v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$11;->$SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 306
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 289
    :pswitch_0
    const v0, 0x7f060112

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 291
    :pswitch_1
    const v0, 0x7f060113

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 293
    :pswitch_2
    const v0, 0x7f060114

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 295
    :pswitch_3
    const v0, 0x7f060115

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 297
    :pswitch_4
    const v0, 0x7f060118

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 299
    :pswitch_5
    const v0, 0x7f060119

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 301
    :pswitch_6
    const v0, 0x7f06011a

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 303
    :pswitch_7
    const v0, 0x7f06011b

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 287
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
        :pswitch_7
    .end packed-switch
.end method

.method private resetImage()V
    .locals 2

    .prologue
    .line 131
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->imageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getDisplayBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListingImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 132
    return-void
.end method

.method private setupActionBarNextActionButton()V
    .locals 2

    .prologue
    .line 93
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 94
    .local v0, "nextActionButton":Landroid/widget/Button;
    if-nez v0, :cond_0

    .line 121
    :goto_0
    return-void

    .line 97
    :cond_0
    const v1, 0x7f0601cc

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 98
    new-instance v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private setupFilterButtonHandlers()V
    .locals 12

    .prologue
    .line 135
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getView()Landroid/view/View;

    move-result-object v8

    .line 137
    .local v8, "view":Landroid/view/View;
    const v10, 0x7f0c0086

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageButton;

    .line 138
    .local v4, "noFilter":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$2;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$2;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v4, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 146
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c0087

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageButton;

    .line 147
    .local v7, "timelessFilterBtn":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$3;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$3;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v7, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 157
    const v10, 0x7f0c0088

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageButton;

    .line 158
    .local v2, "glamFilterBtn":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$4;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$4;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v2, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 169
    const v10, 0x7f0c0089

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    .line 170
    .local v3, "modernFilterBtn":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$5;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$5;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v3, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 182
    const v10, 0x7f0c008a

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ImageButton;

    .line 183
    .local v9, "vintageFilterBtn":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$6;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$6;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v9, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 194
    const v10, 0x7f0c008b

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageButton;

    .line 195
    .local v5, "retroFilterBtn":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$7;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$7;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v5, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 206
    const v10, 0x7f0c008c

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 207
    .local v0, "chicFilterBtn":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v0, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 218
    const v10, 0x7f0c008d

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageButton;

    .line 219
    .local v6, "streetFilterBtn":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$9;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$9;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v6, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 230
    const v10, 0x7f0c008e

    invoke-virtual {v8, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 231
    .local v1, "classicFilterBtn":Landroid/widget/ImageButton;
    new-instance v10, Lcom/poshmark/ui/fragments/CameraFiltersFragment$10;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$10;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    invoke-virtual {v1, v10}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 241
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 72
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 73
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0084

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->imageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 74
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->resetImage()V

    .line 75
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->setupFilterButtonHandlers()V

    .line 76
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->hideAllActionButtons(Z)V

    .line 77
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->setupActionBarNextActionButton()V

    .line 78
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 55
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 56
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 57
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 58
    const-string v1, "FILE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->fileName:Landroid/net/Uri;

    .line 60
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 64
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 65
    const v1, 0x7f03001d

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 66
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f060099

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->setTitle(I)V

    .line 67
    return-object v0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 82
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onResume()V

    .line 83
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->setupFilterButtonHandlers()V

    .line 84
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->hideAllActionButtons(Z)V

    .line 85
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->setupActionBarNextActionButton()V

    .line 86
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 89
    const-string v0, "image_filters_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 90
    return-void
.end method
