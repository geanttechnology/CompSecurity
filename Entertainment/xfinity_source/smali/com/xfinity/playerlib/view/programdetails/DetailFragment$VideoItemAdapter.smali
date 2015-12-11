.class public Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;
.super Ljava/lang/Object;
.source "DetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "VideoItemAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;


# direct methods
.method protected constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .prologue
    .line 716
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private setupDownloadButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;ZLcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/ViewGroup;Z)V
    .locals 4
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p3, "isEntitled"    # Z
    .param p4, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p5, "layout"    # Landroid/view/ViewGroup;
    .param p6, "shouldShowDownloadButton"    # Z

    .prologue
    .line 958
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isDownloadable()Z

    move-result v2

    if-eqz v2, :cond_0

    if-nez p6, :cond_1

    .line 1002
    :cond_0
    :goto_0
    return-void

    .line 962
    :cond_1
    sget v2, Lcom/xfinity/playerlib/R$id;->d2g_section:I

    invoke-virtual {p5, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 964
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadAvailableState(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)Landroid/widget/LinearLayout;
    invoke-static {v2, p1, p5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)Landroid/widget/LinearLayout;

    move-result-object v1

    .line 965
    .local v1, "downloadButton":Landroid/widget/LinearLayout;
    sget v2, Lcom/xfinity/playerlib/R$id;->button_caption:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 967
    .local v0, "buttonLabel":Landroid/widget/TextView;
    if-eqz p3, :cond_3

    .line 969
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;

    invoke-direct {v2, p0, p2, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 981
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setupCancelDownloadButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)V
    invoke-static {v2, p1, p5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)V

    .line 983
    if-eqz p4, :cond_2

    .line 984
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    const/4 v3, 0x1

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->toggleProgressState(ZLandroid/view/View;)V
    invoke-static {v2, v3, p5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;ZLandroid/view/View;)V

    .line 985
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getEngineStatus()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v3

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V
    invoke-static {v2, p4, p5, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$800(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    .line 988
    :cond_2
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_download_button:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 991
    :cond_3
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->inBabyGuide()Z
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$900(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 993
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$3;

    invoke-direct {v2, p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$3;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    invoke-direct {p0, v1, v0, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->setupUpsellButton(Landroid/widget/LinearLayout;Landroid/widget/TextView;Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private setupPlayButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Lcom/xfinity/playerlib/model/consumable/Watchable;ZLcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;Landroid/view/ViewGroup;)V
    .locals 6
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p3, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p4, "isEntitled"    # Z
    .param p5, "playPressedListener"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;
    .param p6, "layout"    # Landroid/view/ViewGroup;

    .prologue
    .line 915
    sget v2, Lcom/xfinity/playerlib/R$id;->playback_button:I

    invoke-virtual {p6, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 917
    .local v1, "playButton":Landroid/widget/LinearLayout;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_2

    .line 918
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 920
    sget v2, Lcom/xfinity/playerlib/R$id;->button_caption:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 922
    .local v0, "buttonLabel":Landroid/widget/TextView;
    if-eqz p4, :cond_1

    .line 923
    invoke-virtual {p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v2

    if-lez v2, :cond_0

    invoke-virtual {p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isFinished()Z

    move-result v2

    if-nez v2, :cond_0

    .line 924
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .line 925
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->resume:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v2, v3}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    .line 924
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 927
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_resume_button:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 932
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->buildPlayLaunchClickListener(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;)Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;
    invoke-static {v2, p1, p3, p5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;)Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 949
    .end local v0    # "buttonLabel":Landroid/widget/TextView;
    :goto_1
    return-void

    .line 929
    .restart local v0    # "buttonLabel":Landroid/widget/TextView;
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_play_button:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 936
    :cond_1
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$1;

    invoke-direct {v2, p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    invoke-direct {p0, v1, v0, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->setupUpsellButton(Landroid/widget/LinearLayout;Landroid/widget/TextView;Landroid/view/View$OnClickListener;)V

    goto :goto_1

    .line 946
    .end local v0    # "buttonLabel":Landroid/widget/TextView;
    :cond_2
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1
.end method

.method private setupUpsellButton(Landroid/widget/LinearLayout;Landroid/widget/TextView;Landroid/view/View$OnClickListener;)V
    .locals 3
    .param p1, "button"    # Landroid/widget/LinearLayout;
    .param p2, "buttonCaption"    # Landroid/widget/TextView;
    .param p3, "onClickListener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 1006
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1008
    sget v0, Lcom/xfinity/playerlib/R$id;->button_art:I

    invoke-virtual {p1, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_upsell_btn:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 1010
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$color;->white:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 1011
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 1012
    invoke-virtual {p1}, Landroid/widget/LinearLayout;->getId()I

    move-result v0

    sget v2, Lcom/xfinity/playerlib/R$id;->play_button:I

    if-ne v0, v2, :cond_0

    sget v0, Lcom/xfinity/playerlib/R$string;->content_description_play_button_unentitled:I

    .line 1011
    :goto_0
    invoke-virtual {v1, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1016
    sget v0, Lcom/xfinity/playerlib/R$drawable;->play_button_unentitled:I

    invoke-virtual {p1, v0}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 1018
    invoke-virtual {p1, p3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1019
    return-void

    .line 1012
    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$string;->content_description_download_button_unentitled:I

    goto :goto_0
.end method


# virtual methods
.method public createUnavailableView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 719
    sget v0, Lcom/xfinity/playerlib/R$layout;->video_item_unavailable:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public createView(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;ZLandroid/view/LayoutInflater;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;ZZII)Landroid/view/View;
    .locals 30
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p3, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p4, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p5, "isEntitled"    # Z
    .param p6, "inflater"    # Landroid/view/LayoutInflater;
    .param p7, "container"    # Landroid/view/ViewGroup;
    .param p8, "playPressedListener"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;
    .param p9, "shouldShowDownloadButton"    # Z
    .param p10, "shouldShowOnNowInd"    # Z
    .param p11, "videoNumber"    # I
    .param p12, "numberOfVideos"    # I

    .prologue
    .line 728
    sget v2, Lcom/xfinity/playerlib/R$layout;->video_item:I

    const/4 v3, 0x0

    move-object/from16 v0, p6

    move-object/from16 v1, p7

    invoke-virtual {v0, v2, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/view/ViewGroup;

    .line 729
    .local v8, "layout":Landroid/view/ViewGroup;
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v8, v2}, Landroid/view/ViewGroup;->setTag(Ljava/lang/Object;)V

    .line 731
    sget v2, Lcom/xfinity/playerlib/R$id;->network_logo:I

    invoke-virtual {v8, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Landroid/widget/ImageView;

    .line 732
    .local v21, "networkLogo":Landroid/widget/ImageView;
    sget v2, Lcom/xfinity/playerlib/R$id;->network_name:I

    invoke-virtual {v8, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v22

    check-cast v22, Landroid/widget/TextView;

    .line 735
    .local v22, "networkName":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iget-boolean v2, v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->shouldSuppressNetworkLogos:Z

    if-nez v2, :cond_6

    .line 737
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->isPremium()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 738
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v4

    move-object/from16 v0, v21

    invoke-virtual {v2, v4, v5, v0}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadNetworkLogoSmall(JLandroid/widget/ImageView;)V

    .line 739
    const/4 v2, 0x0

    move-object/from16 v0, v21

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 740
    const/16 v2, 0x8

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 753
    :goto_0
    const-string v29, ""

    .line 755
    .local v29, "videoNumberOf":Ljava/lang/String;
    const/4 v2, 0x1

    move/from16 v0, p12

    if-le v0, v2, :cond_0

    .line 756
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_video_number_of:I

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {p11 .. p11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static/range {p12 .. p12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v29

    .line 759
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_on_network:I

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v29, v4, v5

    const/4 v5, 0x1

    .line 761
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v6

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    .line 759
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    .line 763
    .local v20, "networkInfo":Ljava/lang/String;
    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 764
    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 771
    .end local v20    # "networkInfo":Ljava/lang/String;
    .end local v29    # "videoNumberOf":Ljava/lang/String;
    :goto_1
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v24

    .line 773
    .local v24, "rating":Lcom/comcast/cim/model/Rating;
    const/16 v25, 0x0

    .line 775
    .local v25, "ratingContentDescription":Ljava/lang/String;
    if-eqz v24, :cond_1

    .line 776
    invoke-virtual/range {v24 .. v24}, Lcom/comcast/cim/model/Rating;->getRating()Ljava/lang/String;

    move-result-object v26

    .line 777
    .local v26, "speechifyRating":Ljava/lang/String;
    const-string v2, ".(?=.)"

    const-string v3, "$0 "

    move-object/from16 v0, v26

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    .line 778
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_rated:I

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v26, v4, v5

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v25

    .line 782
    .end local v26    # "speechifyRating":Ljava/lang/String;
    :cond_1
    sget v2, Lcom/xfinity/playerlib/R$id;->indicators:I

    invoke-virtual {v8, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    .line 783
    .local v14, "indicators":Landroid/widget/TextView;
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getLanguageCodes()Ljava/util/List;

    move-result-object v16

    .line 784
    .local v16, "languageCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/16 v17, 0x0

    .line 785
    .local v17, "languageContentDescription":Ljava/lang/String;
    if-eqz v16, :cond_8

    invoke-static/range {v16 .. v16}, Lcom/google/common/collect/Sets;->newHashSet(Ljava/lang/Iterable;)Ljava/util/HashSet;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "en"

    aput-object v5, v3, v4

    invoke-static {v3}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/common/collect/Sets;->difference(Ljava/util/Set;Ljava/util/Set;)Lcom/google/common/collect/Sets$SetView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/common/collect/Sets$SetView;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_8

    .line 786
    const-string v18, ""

    .line 787
    .local v18, "languageString":Ljava/lang/String;
    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 788
    .local v15, "language":Ljava/lang/String;
    invoke-static {v15}, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->getDisplayNameForLanguageCode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 789
    .local v13, "displayName":Ljava/lang/String;
    if-nez v13, :cond_2

    .line 790
    move-object v13, v15

    .line 792
    :cond_2
    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_3

    .line 793
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 795
    :cond_3
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 796
    goto :goto_2

    .line 742
    .end local v13    # "displayName":Ljava/lang/String;
    .end local v14    # "indicators":Landroid/widget/TextView;
    .end local v15    # "language":Ljava/lang/String;
    .end local v16    # "languageCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v17    # "languageContentDescription":Ljava/lang/String;
    .end local v18    # "languageString":Ljava/lang/String;
    .end local v24    # "rating":Lcom/comcast/cim/model/Rating;
    .end local v25    # "ratingContentDescription":Ljava/lang/String;
    :cond_4
    const/16 v2, 0x8

    move-object/from16 v0, v21

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 744
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v19

    .line 745
    .local v19, "name":Ljava/lang/String;
    if-eqz v19, :cond_5

    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_5

    .line 746
    move-object/from16 v0, v22

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 747
    const/4 v2, 0x0

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 749
    :cond_5
    const/16 v2, 0x8

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 767
    .end local v19    # "name":Ljava/lang/String;
    :cond_6
    const/16 v2, 0x8

    move-object/from16 v0, v21

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 768
    const/16 v2, 0x8

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 798
    .restart local v14    # "indicators":Landroid/widget/TextView;
    .restart local v16    # "languageCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v17    # "languageContentDescription":Ljava/lang/String;
    .restart local v18    # "languageString":Ljava/lang/String;
    .restart local v24    # "rating":Lcom/comcast/cim/model/Rating;
    .restart local v25    # "ratingContentDescription":Ljava/lang/String;
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_languages:I

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v18, v4, v5

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    .line 801
    .end local v18    # "languageString":Ljava/lang/String;
    :cond_8
    invoke-virtual/range {p0 .. p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->getUnicodeIndicatorString(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Ljava/lang/String;

    move-result-object v28

    .line 803
    .local v28, "unicodeIndicatorString":Ljava/lang/String;
    invoke-virtual/range {v28 .. v28}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_9

    .line 804
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v10

    .line 805
    .local v10, "am":Landroid/content/res/AssetManager;
    const-string v2, "fonts/XFINITYIndicators-Regular.otf"

    invoke-static {v10, v2}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v27

    .line 806
    .local v27, "tf":Landroid/graphics/Typeface;
    move-object/from16 v0, v27

    invoke-virtual {v14, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 807
    move-object/from16 v0, v28

    invoke-virtual {v14, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 808
    const/4 v2, 0x0

    invoke-virtual {v14, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 810
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isCC()Z

    move-result v2

    if-eqz v2, :cond_b

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_video_options_announcement:I

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    sget v7, Lcom/xfinity/playerlib/R$string;->content_description_cc:I

    .line 811
    invoke-virtual {v6, v7}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    sget v7, Lcom/xfinity/playerlib/R$string;->content_description_available:I

    .line 812
    invoke-virtual {v6, v7}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    .line 810
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    .line 815
    .local v11, "ccAnnouncement":Ljava/lang/String;
    :goto_3
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    if-eqz v25, :cond_c

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v25

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "."

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :goto_4
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    if-eqz v17, :cond_d

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "."

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :goto_5
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 819
    .local v12, "contentDescription":Ljava/lang/String;
    invoke-virtual {v14, v12}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 822
    .end local v10    # "am":Landroid/content/res/AssetManager;
    .end local v11    # "ccAnnouncement":Ljava/lang/String;
    .end local v12    # "contentDescription":Ljava/lang/String;
    .end local v27    # "tf":Landroid/graphics/Typeface;
    :cond_9
    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCategories()Ljava/util/List;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RECENT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-interface {v2, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v2

    if-lez v2, :cond_a

    .line 823
    sget v2, Lcom/xfinity/playerlib/R$id;->progressIndicator:I

    invoke-virtual {v8, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v23

    check-cast v23, Landroid/widget/TextView;

    .line 824
    .local v23, "progressIndicator":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v3

    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v4

    invoke-static {v2, v3, v4}, Lcom/comcast/cim/utils/UIPresentationUtil;->getRemainingTime(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v23

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 826
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .line 827
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    .line 828
    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v4

    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v5

    sub-int/2addr v4, v5

    div-int/lit16 v4, v4, 0x3e8

    .line 827
    invoke-static {v3, v4}, Lcom/comcast/cim/utils/UIPresentationUtil;->getTimeForPlayer(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    sget v4, Lcom/xfinity/playerlib/R$string;->content_description_remaining:I

    .line 829
    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 826
    move-object/from16 v0, v23

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 831
    const/4 v2, 0x0

    move-object/from16 v0, v23

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 835
    .end local v23    # "progressIndicator":Landroid/widget/TextView;
    :cond_a
    if-eqz p10, :cond_e

    .line 837
    sget v2, Lcom/xfinity/playerlib/R$id;->on_now_button:I

    invoke-virtual {v8, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    :goto_6
    move-object/from16 v3, p0

    move-object/from16 v4, p1

    move-object/from16 v5, p3

    move/from16 v6, p5

    move-object/from16 v7, p4

    move/from16 v9, p9

    .line 842
    invoke-direct/range {v3 .. v9}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->setupDownloadButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;ZLcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/ViewGroup;Z)V

    .line 844
    return-object v8

    .line 810
    .restart local v10    # "am":Landroid/content/res/AssetManager;
    .restart local v27    # "tf":Landroid/graphics/Typeface;
    :cond_b
    const-string v11, ""

    goto/16 :goto_3

    .line 815
    .restart local v11    # "ccAnnouncement":Ljava/lang/String;
    :cond_c
    const-string v2, ""

    goto/16 :goto_4

    :cond_d
    const-string v2, ""

    goto/16 :goto_5

    .end local v10    # "am":Landroid/content/res/AssetManager;
    .end local v11    # "ccAnnouncement":Ljava/lang/String;
    .end local v27    # "tf":Landroid/graphics/Typeface;
    :cond_e
    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move/from16 v6, p5

    move-object/from16 v7, p8

    .line 839
    invoke-direct/range {v2 .. v8}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->setupPlayButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Lcom/xfinity/playerlib/model/consumable/Watchable;ZLcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;Landroid/view/ViewGroup;)V

    goto :goto_6
.end method

.method getUnicodeIndicatorString(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Ljava/lang/String;
    .locals 8
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    const/4 v7, 0x1

    .line 848
    const-string v3, ""

    .line 849
    .local v3, "unicodeLanguageString":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v1

    .line 850
    .local v1, "rating":Lcom/comcast/cim/model/Rating;
    if-eqz v1, :cond_0

    .line 851
    invoke-virtual {v1}, Lcom/comcast/cim/model/Rating;->getRating()Ljava/lang/String;

    move-result-object v2

    .line 853
    .local v2, "ratingAsString":Ljava/lang/String;
    const-string v4, "g"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 854
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_g:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 884
    .end local v2    # "ratingAsString":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getLanguageCodes()Ljava/util/List;

    move-result-object v0

    .line 885
    .local v0, "languageCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    if-ne v4, v7, :cond_12

    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const-string v5, "es"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_12

    .line 886
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_1

    .line 887
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 890
    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_esp:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 899
    :cond_2
    :goto_1
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isCC()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 900
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_3

    .line 901
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 903
    :cond_3
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_cc:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 906
    :cond_4
    return-object v3

    .line 855
    .end local v0    # "languageCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v2    # "ratingAsString":Ljava/lang/String;
    :cond_5
    const-string v4, "pg"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 856
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_pg:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 857
    :cond_6
    const-string v4, "pg-13"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 858
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_pg13:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 859
    :cond_7
    const-string v4, "r"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 860
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_r:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 861
    :cond_8
    const-string v4, "nr"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 862
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_nr:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 863
    :cond_9
    const-string v4, "tv-y7"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 864
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_tvy7:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 865
    :cond_a
    const-string v4, "tv-y"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_b

    .line 866
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_tvy:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 867
    :cond_b
    const-string v4, "tv-g"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_c

    .line 868
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_tvg:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 869
    :cond_c
    const-string v4, "tv-pg"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_d

    .line 870
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_tvpg:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 871
    :cond_d
    const-string v4, "tv-14"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_e

    .line 872
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_tv14:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 873
    :cond_e
    const-string v4, "tv-ma"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_f

    .line 874
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_tvma:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 875
    :cond_f
    const-string v4, "tv-nr"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_10

    .line 876
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_tvnr:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 877
    :cond_10
    const-string v4, "nc-17"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_11

    .line 878
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_nc17:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 879
    :cond_11
    const-string v4, "adult"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 880
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_adult:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_0

    .line 891
    .end local v2    # "ratingAsString":Ljava/lang/String;
    .restart local v0    # "languageCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_12
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    if-le v4, v7, :cond_2

    .line 892
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_13

    .line 893
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 896
    :cond_13
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->unicode_sap:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_1
.end method
