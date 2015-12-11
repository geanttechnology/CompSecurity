.class public abstract Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401
    name = "PlayerUIController"
.end annotation


# instance fields
.field protected allowSeek:Z

.field private clearPlayerControlsRunner:Ljava/lang/Runnable;

.field private clearVolumeControlRunner:Ljava/lang/Runnable;

.field protected hasShownRatingsBug:Z

.field isSeeking:Z

.field protected final mAllowSeekMargin:I

.field protected final mMaxProgress:I

.field private moveUpAdsActionBarRunner:Ljava/lang/Runnable;

.field private parentalControlPinFragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

.field protected ratingsBug:Lcom/xfinity/playerlib/view/videoplay/RatingsBug;

.field protected seekLastProgress:I

.field selectionDialogOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field selectionDialogOnKeyListener:Landroid/content/DialogInterface$OnKeyListener;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V
    .locals 2
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    const/16 v1, 0x3e8

    .line 809
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 798
    iput v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->mMaxProgress:I

    .line 800
    const/16 v0, 0xc8

    iput v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->mAllowSeekMargin:I

    .line 807
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isSeeking:Z

    .line 1111
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$2;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->moveUpAdsActionBarRunner:Ljava/lang/Runnable;

    .line 1118
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$3;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$3;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearPlayerControlsRunner:Ljava/lang/Runnable;

    .line 1126
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$4;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$4;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearVolumeControlRunner:Ljava/lang/Runnable;

    .line 1705
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$10;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$10;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->selectionDialogOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 1714
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$11;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$11;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->selectionDialogOnKeyListener:Landroid/content/DialogInterface$OnKeyListener;

    .line 810
    iget-object v0, p1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->setMax(I)V

    .line 811
    iget-object v0, p1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 812
    return-void
.end method

.method static synthetic access$4100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
    .param p1, "x1"    # Z

    .prologue
    .line 786
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsAndActionBar(Z)V

    return-void
.end method

.method private announceAdState(Ljava/lang/String;)V
    .locals 3
    .param p1, "resumeAnnouncementText"    # Ljava/lang/String;

    .prologue
    .line 934
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v2

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getTitle()Ljava/lang/String;

    move-result-object v1

    .line 936
    .local v1, "title":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isMovie()Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v2

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 938
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 940
    .local v0, "sb":Ljava/lang/StringBuffer;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v2

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v2

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeriesTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 941
    const-string v2, ", episode: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 942
    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 944
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    .line 947
    .end local v0    # "sb":Ljava/lang/StringBuffer;
    :cond_0
    const-string v2, "Your video"

    invoke-virtual {p1, v2, v1}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 949
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v2

    invoke-interface {v2, p1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 951
    return-void
.end method

.method private configureControlsForLiveStream()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/16 v4, 0x8

    .line 1741
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->setVisibility(I)V

    .line 1742
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1743
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->currentTime:Landroid/widget/TextView;

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1744
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogo:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1746
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/ViewGroup;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$id;->play_pause_button_layout:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 1747
    .local v1, "playPauseButtonLayout":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 1748
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 1754
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 1756
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 1757
    .local v0, "params":Landroid/widget/RelativeLayout$LayoutParams;
    const/4 v2, -0x2

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 1758
    const/16 v2, 0xe

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 1759
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1760
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->invalidate()V

    .line 1761
    return-void

    .line 1750
    .end local v0    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playButton:Landroid/widget/ImageView;

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1751
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->pauseButton:Landroid/widget/ImageView;

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method private configureControlsForVOD()V
    .locals 8

    .prologue
    const/16 v7, 0xe

    const/16 v3, 0x8

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1764
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {v2, v5}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->setVisibility(I)V

    .line 1765
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1766
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->currentTime:Landroid/widget/TextView;

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1767
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogo:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1768
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkName:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1770
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$drawable;->scrubber_control_selector_holo:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->setThumb(Landroid/graphics/drawable/Drawable;)V

    .line 1771
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {v2, v6}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->setEnabled(Z)V

    .line 1772
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 1774
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/ViewGroup;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$id;->play_pause_button_layout:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 1775
    .local v1, "playPauseButtonLayout":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 1776
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 1779
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 1780
    .local v0, "params":Landroid/widget/RelativeLayout$LayoutParams;
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x11

    if-lt v2, v3, :cond_1

    .line 1781
    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout$LayoutParams;->removeRule(I)V

    .line 1786
    :goto_0
    const/4 v2, -0x1

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 1787
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->invalidate()V

    .line 1788
    return-void

    .line 1783
    :cond_1
    invoke-virtual {v0, v7, v5}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    goto :goto_0
.end method

.method private getProgressTime(JJ)I
    .locals 7
    .param p1, "progress"    # J
    .param p3, "duration"    # J

    .prologue
    .line 1409
    long-to-double v0, p3

    long-to-double v2, p1

    const-wide v4, 0x408f400000000000L    # 1000.0

    div-double/2addr v2, v4

    mul-double/2addr v0, v2

    double-to-int v0, v0

    return v0
.end method

.method private isDownloadedVideo()Z
    .locals 1

    .prologue
    .line 853
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getDownloadedFile()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setLandscapeOrientation()V
    .locals 2

    .prologue
    .line 1527
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->getLandscapeOrientation()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setRequestedOrientation(I)V

    .line 1528
    return-void
.end method

.method private setThumbTimeView(I)V
    .locals 12
    .param p1, "progress"    # I

    .prologue
    const/4 v3, -0x2

    .line 1413
    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v2, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 1414
    .local v2, "layoutParam":Landroid/widget/RelativeLayout$LayoutParams;
    const-wide/high16 v4, 0x404e000000000000L    # 60.0

    int-to-double v6, p1

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getWidth()I

    move-result v3

    int-to-double v8, v3

    const-wide v10, 0x408f400000000000L    # 1000.0

    div-double/2addr v8, v10

    mul-double/2addr v6, v8

    add-double/2addr v4, v6

    double-to-int v3, v4

    iput v3, v2, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 1415
    const/16 v3, 0xa

    iput v3, v2, Landroid/widget/RelativeLayout$LayoutParams;->bottomMargin:I

    .line 1416
    const/4 v3, 0x2

    sget v4, Lcom/xfinity/playerlib/R$id;->progressbar_layout:I

    invoke-virtual {v2, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 1417
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->thumbTime:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1419
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v0

    .line 1420
    .local v0, "duration":J
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->thumbTime:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/VideoPlayUtil;

    move-result-object v4

    int-to-long v6, p1

    invoke-direct {p0, v6, v7, v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->getProgressTime(JJ)I

    move-result v5

    long-to-int v6, v0

    invoke-virtual {v4, v5, v6}, Lcom/xfinity/playerlib/VideoPlayUtil;->getDisplayTime(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1421
    return-void
.end method

.method private showActionBar()V
    .locals 1

    .prologue
    .line 1201
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showActionBarMenus()V

    .line 1202
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->show()V

    .line 1203
    return-void
.end method

.method private showMainControlsAndActionBar(Z)V
    .locals 2
    .param p1, "showPlayButton"    # Z

    .prologue
    .line 1135
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->turnLightsOn()V

    .line 1136
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControls(Z)V

    .line 1137
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showActionBar()V

    .line 1139
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1140
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1141
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1142
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_toggle_control_instructions_off:I

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->changeAccessibilityControlToggleContentDescription(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)V

    .line 1150
    :cond_0
    :goto_0
    return-void

    .line 1144
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_toggle_control_instructions_on:I

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->changeAccessibilityControlToggleContentDescription(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)V

    goto :goto_0

    .line 1147
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_toggle_controls_are_visible:I

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->changeAccessibilityControlToggleContentDescription(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)V

    goto :goto_0
.end method

.method private updateProgressInfo(JJ)V
    .locals 5
    .param p1, "currentLocation"    # J
    .param p3, "duration"    # J

    .prologue
    .line 1321
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->currentTime:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/VideoPlayUtil;

    move-result-object v2

    long-to-int v3, p1

    long-to-int v4, p3

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/VideoPlayUtil;->getDisplayTime(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1323
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-wide/16 v2, 0x3e8

    div-long v2, p1, v2

    long-to-int v2, v2

    invoke-static {v1, v2}, Lcom/comcast/cim/utils/UIPresentationUtil;->getTimeForPlayer(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 1324
    .local v0, "timeDescription":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->currentTime:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->content_description_time_played:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1326
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 1327
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->getProgress(JJ)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->setProgress(I)V

    .line 1329
    :cond_0
    return-void
.end method


# virtual methods
.method public announceBabyGuideClosed(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)V
    .locals 4
    .param p1, "babyGuideType"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .prologue
    .line 1669
    if-eqz p1, :cond_0

    .line 1670
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->getCaptionResId()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " closed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1671
    .local v0, "babyGuideTypeString":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 1674
    .end local v0    # "babyGuideTypeString":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    const/4 v2, 0x0

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$802(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .line 1675
    return-void
.end method

.method public announceSapAndCcStates(ZZ)V
    .locals 10
    .param p1, "isCcAvail"    # Z
    .param p2, "isSapAvail"    # Z

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 1679
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v4, Lcom/xfinity/playerlib/R$string;->content_description_video_options_announcement:I

    new-array v5, v9, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v6, Lcom/xfinity/playerlib/R$string;->content_description_cc:I

    .line 1680
    invoke-virtual {v1, v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v7

    iget-object v6, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    if-eqz p1, :cond_0

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_available:I

    .line 1681
    :goto_0
    invoke-virtual {v6, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v8

    .line 1679
    invoke-virtual {v3, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v4, Lcom/xfinity/playerlib/R$string;->content_description_video_options_announcement:I

    new-array v5, v9, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v6, Lcom/xfinity/playerlib/R$string;->content_description_sap:I

    .line 1684
    invoke-virtual {v1, v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v7

    iget-object v6, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    if-eqz p2, :cond_1

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_available:I

    .line 1685
    :goto_1
    invoke-virtual {v6, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v8

    .line 1683
    invoke-virtual {v3, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1688
    .local v0, "announcement":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 1689
    return-void

    .line 1680
    .end local v0    # "announcement":Ljava/lang/String;
    :cond_0
    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_not_available:I

    goto :goto_0

    .line 1684
    :cond_1
    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_not_available:I

    goto :goto_1
.end method

.method public clearBackStack()V
    .locals 0

    .prologue
    .line 1647
    return-void
.end method

.method public configurePlaybackControls()V
    .locals 1

    .prologue
    .line 1733
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isLiveStream()Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1734
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->configureControlsForLiveStream()V

    .line 1738
    :goto_0
    return-void

    .line 1736
    :cond_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->configureControlsForVOD()V

    goto :goto_0
.end method

.method public dismissDialog(Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 1215
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Landroid/app/DialogFragment;

    .line 1216
    .local v0, "dialog":Landroid/app/DialogFragment;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/DialogFragment;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1217
    invoke-virtual {v0}, Landroid/app/DialogFragment;->dismiss()V

    .line 1219
    :cond_0
    return-void
.end method

.method public dismissDialogs()V
    .locals 1

    .prologue
    .line 1210
    const-string v0, "ccselectionlistdialog"

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->dismissDialog(Ljava/lang/String;)V

    .line 1211
    const-string v0, "sapselectionlistdialog"

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->dismissDialog(Ljava/lang/String;)V

    .line 1212
    return-void
.end method

.method public getCContainer()Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 1554
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccContainer:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    return-object v0
.end method

.method protected getProgress(JJ)I
    .locals 7
    .param p1, "location"    # J
    .param p3, "duration"    # J

    .prologue
    .line 1309
    const-wide v0, 0x408f400000000000L    # 1000.0

    long-to-double v2, p1

    long-to-double v4, p3

    div-double/2addr v2, v4

    mul-double/2addr v0, v2

    double-to-int v0, v0

    return v0
.end method

.method public hasShownRatingsBug()Z
    .locals 1

    .prologue
    .line 1650
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hasShownRatingsBug:Z

    return v0
.end method

.method public hideActionBar()V
    .locals 1

    .prologue
    .line 1206
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 1207
    return-void
.end method

.method protected hideActionBarMenus()V
    .locals 2

    .prologue
    .line 1238
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->menuTabs:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1239
    return-void
.end method

.method public hideAdControls()V
    .locals 2

    .prologue
    .line 954
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->setVisibility(I)V

    .line 955
    return-void
.end method

.method public hideAdView()V
    .locals 2

    .prologue
    .line 1022
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adView:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/webkit/WebView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 1023
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isClickableAdsButtonVisibile()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1024
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->startMainControlTimeout()V

    .line 1026
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->play()V

    .line 1027
    return-void
.end method

.method public hideAllControls()V
    .locals 2

    .prologue
    .line 1060
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1068
    :goto_0
    return-void

    .line 1064
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_toggle_control_instructions_on:I

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->changeAccessibilityControlToggleContentDescription(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)V

    .line 1065
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideMainControls()V

    .line 1066
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideActionBar()V

    .line 1067
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->turnLightsOut()V

    goto :goto_0
.end method

.method public hideClickableAdButton()V
    .locals 2

    .prologue
    .line 1006
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->clickableAdButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/Button;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 1007
    return-void
.end method

.method public abstract hideInfoPanel()V
.end method

.method public hideLaunchMaturityRating()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 1472
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMatureContentWarning:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1473
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMatureContentRating:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1474
    return-void
.end method

.method public hideLaunchScreen()V
    .locals 2

    .prologue
    .line 1452
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupDialog:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 1453
    return-void
.end method

.method public hideMainControls()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x4

    .line 1182
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1183
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->thumbTime:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1184
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSliderLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1185
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessSliderLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1186
    return-void
.end method

.method public hideMainControlsAndActionBar()V
    .locals 0

    .prologue
    .line 1071
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideMainControls()V

    .line 1072
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideActionBar()V

    .line 1073
    return-void
.end method

.method public hidePinPadFragment(Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 1
    .param p1, "pinValidationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 1642
    const/4 v0, 0x1

    invoke-interface {p1, v0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;->onPinValidationComplete(Z)V

    .line 1643
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLandscapeOrientation()V

    .line 1644
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->parentalControlPinFragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    .line 1645
    return-void
.end method

.method public hideSpinner()V
    .locals 2

    .prologue
    .line 876
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->cancelAllMessages()V

    .line 877
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bufferingProgress:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 878
    return-void
.end method

.method public isAccessibilityModeOn()Z
    .locals 1

    .prologue
    .line 1189
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    return v0
.end method

.method public isAdViewVisible()Z
    .locals 1

    .prologue
    .line 1010
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adView:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAdsActionBarAdjustedForStatusBar()Z
    .locals 1

    .prologue
    .line 1014
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isAdsActionBarAdjustedForStatusBar:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    return v0
.end method

.method public isClickableAdsButtonVisibile()Z
    .locals 1

    .prologue
    .line 1018
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->clickableAdButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Button;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isDialogShowing()Z
    .locals 3

    .prologue
    .line 1728
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "sapselectionlistdialog"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;

    .line 1729
    .local v0, "sapDialog":Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isMainControlShowing()Z
    .locals 1

    .prologue
    .line 1197
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isManualControlToggleOn()Z
    .locals 1

    .prologue
    .line 1193
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    return v0
.end method

.method public moveAdsActionBarDown(Z)V
    .locals 4
    .param p1, "animate"    # Z

    .prologue
    .line 1030
    if-eqz p1, :cond_0

    .line 1031
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->getTranslationY()F

    move-result v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->getStatusBarHeight()I

    move-result v2

    int-to-float v2, v2

    add-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->y(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x96

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    .line 1036
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    const/4 v1, 0x1

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isAdsActionBarAdjustedForStatusBar:Z
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2402(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 1037
    return-void

    .line 1033
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->adjustForStatusBar()V

    goto :goto_0
.end method

.method public moveAdsActionBarUp(Z)V
    .locals 4
    .param p1, "animate"    # Z

    .prologue
    .line 1040
    if-eqz p1, :cond_0

    .line 1041
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->getTranslationY()F

    move-result v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->getStatusBarHeight()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->y(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    .line 1046
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    const/4 v1, 0x0

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isAdsActionBarAdjustedForStatusBar:Z
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2402(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 1047
    return-void

    .line 1043
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->adjustForFullScreen()V

    goto :goto_0
.end method

.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;
    .param p2, "progress"    # I
    .param p3, "fromUser"    # Z

    .prologue
    .line 1370
    if-eqz p3, :cond_1

    .line 1371
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->seekLastProgress:I

    sub-int v0, p2, v0

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    const/16 v1, 0xc8

    if-gt v0, v1, :cond_0

    .line 1372
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->allowSeek:Z

    .line 1374
    :cond_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->allowSeek:Z

    if-eqz v0, :cond_2

    .line 1375
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onUserMovedSeekBar(I)V

    .line 1376
    iput p2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->seekLastProgress:I

    .line 1381
    :cond_1
    :goto_0
    return-void

    .line 1378
    :cond_2
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->seekLastProgress:I

    invoke-virtual {p1, v0}, Landroid/widget/SeekBar;->setProgress(I)V

    goto :goto_0
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 1
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 1390
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onUserSeekStarted()V

    .line 1391
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->allowSeek:Z

    .line 1392
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->seekLastProgress:I

    .line 1393
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 6
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 1397
    iget-boolean v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->allowSeek:Z

    if-eqz v3, :cond_0

    .line 1398
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v0

    .line 1399
    .local v0, "duration":J
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v3

    int-to-long v4, v3

    invoke-direct {p0, v4, v5, v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->getProgressTime(JJ)I

    move-result v2

    .line 1400
    .local v2, "seekToPosition":I
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->thumbTime:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1402
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v3

    int-to-long v4, v2

    invoke-virtual {v3, v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onSeekRequest(J)V

    .line 1405
    .end local v0    # "duration":J
    .end local v2    # "seekToPosition":I
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v3

    iget-boolean v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->allowSeek:Z

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onUserSeekEnded(Z)V

    .line 1406
    return-void
.end method

.method public popFragmentFromBackStack(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 1365
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroid/app/FragmentManager;->popBackStack(Ljava/lang/String;I)V

    .line 1366
    return-void
.end method

.method public removeMainControlTimeout()V
    .locals 2

    .prologue
    .line 1084
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "#@@@UIController: removeMainControlTimeout"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 1085
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearPlayerControlsRunner:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1086
    return-void
.end method

.method public removeVideoView()V
    .locals 1

    .prologue
    .line 1522
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerFrame:Landroid/widget/FrameLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/FrameLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 1523
    return-void
.end method

.method public removeVolumeControlTimeout()V
    .locals 2

    .prologue
    .line 1097
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "#@@@UIController: removeVolumeControlTimeout"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 1098
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearVolumeControlRunner:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1099
    return-void
.end method

.method public reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 815
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->resetProgressInfo()V

    .line 816
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideInfoPanel()V

    .line 817
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAllControls()V

    .line 818
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAdControls()V

    .line 819
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideSpinner()V

    .line 820
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideLaunchMaturityRating()V

    .line 821
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->stopRatingsBug()V

    .line 822
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hasShownRatingsBug:Z

    .line 823
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeVideoView()V

    .line 824
    sget v0, Lcom/xfinity/playerlib/R$string;->player_launch_starting:I

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchScreenMessage(I)V

    .line 825
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showLaunchScreen()V

    .line 826
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setSAPButtonSelected(Z)V

    .line 827
    return-void
.end method

.method public resetProgressInfo()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    const/4 v0, 0x0

    .line 1722
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isSeeking:Z

    .line 1723
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->allowSeek:Z

    .line 1724
    invoke-direct {p0, v2, v3, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateProgressInfo(JJ)V

    .line 1725
    return-void
.end method

.method public setCCButtonEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 1535
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 1536
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setClickable(Z)V

    .line 1537
    return-void
.end method

.method public setCCButtonSelected(Z)V
    .locals 3
    .param p1, "selected"    # Z

    .prologue
    .line 1540
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 1542
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    if-eqz p1, :cond_0

    sget v0, Lcom/xfinity/playerlib/R$string;->content_description_cc_selected:I

    :goto_0
    invoke-virtual {v2, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1546
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    if-eqz p1, :cond_1

    sget v0, Lcom/xfinity/playerlib/R$string;->content_description_cc_on:I

    :goto_1
    invoke-interface {v1, v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(I)V

    .line 1547
    return-void

    .line 1542
    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$string;->content_description_cc_button:I

    goto :goto_0

    .line 1546
    :cond_1
    sget v0, Lcom/xfinity/playerlib/R$string;->content_description_cc_off:I

    goto :goto_1
.end method

.method public setCCButtonVisibility(I)V
    .locals 1
    .param p1, "visibility"    # I

    .prologue
    .line 1550
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1551
    return-void
.end method

.method public setInfoTabIcon()V
    .locals 3

    .prologue
    .line 1269
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->menu_guide_icon:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 1270
    .local v0, "infoTabIcon":Landroid/widget/ImageView;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isLiveStream()Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1271
    sget v1, Lcom/xfinity/playerlib/R$drawable;->ico_guide_streaming:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 1275
    :goto_0
    return-void

    .line 1273
    :cond_0
    sget v1, Lcom/xfinity/playerlib/R$drawable;->ico_guide_playback:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method

.method public setIsSeeking(Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "isSeeking"    # Ljava/lang/Boolean;

    .prologue
    .line 1304
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isSeeking:Z

    .line 1305
    return-void
.end method

.method public setLaunchMaturityRating(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 5
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    const/4 v2, 0x0

    .line 1461
    if-eqz p1, :cond_0

    .line 1462
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v0

    .line 1463
    .local v0, "videoRating":Lcom/comcast/cim/model/Rating;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/comcast/cim/model/Rating;->isMature()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1464
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMatureContentWarning:Landroid/widget/TextView;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1465
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMatureContentRating:Landroid/widget/TextView;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1466
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMatureContentRating:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Video Rated "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/comcast/cim/model/Rating;->getRating()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v3, v4}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1469
    .end local v0    # "videoRating":Lcom/comcast/cim/model/Rating;
    :cond_0
    return-void
.end method

.method public setLaunchScreenMessage(I)V
    .locals 1
    .param p1, "messageId"    # I

    .prologue
    .line 1456
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMessaging:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(I)V

    .line 1457
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(I)V

    .line 1458
    return-void
.end method

.method public setNetworkInfo(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 1278
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkName:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v2, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1279
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkName:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1281
    if-eqz p1, :cond_0

    .line 1282
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$dimen;->network_logo_live_src_width:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 1283
    .local v1, "imageWidth":I
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$dimen;->network_logo_live_src_height:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 1284
    .local v0, "imageHeight":I
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v2

    invoke-static {p1, v1, v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getArtworkUrl(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogo:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v4

    new-instance v5, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$5;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$5;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    invoke-virtual {v2, v3, v4, v5}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 1301
    .end local v0    # "imageHeight":I
    .end local v1    # "imageWidth":I
    :goto_0
    return-void

    .line 1298
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogo:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1299
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkName:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setSAPButtonEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 1558
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 1559
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setClickable(Z)V

    .line 1560
    return-void
.end method

.method public setSAPButtonSelected(Z)V
    .locals 1
    .param p1, "selected"    # Z

    .prologue
    .line 1563
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 1564
    return-void
.end method

.method public setSAPButtonVisibility(I)V
    .locals 1
    .param p1, "visibility"    # I

    .prologue
    .line 1567
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1568
    return-void
.end method

.method public setVideoDuration(J)V
    .locals 7
    .param p1, "duration"    # J

    .prologue
    .line 1332
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1333
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v4, Lcom/xfinity/playerlib/R$string;->placeholder_live:I

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1334
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v4, Lcom/xfinity/playerlib/R$string;->content_description_live:I

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1342
    :goto_0
    return-void

    .line 1336
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/VideoPlayUtil;

    move-result-object v2

    long-to-int v3, p1

    long-to-int v4, p1

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/VideoPlayUtil;->getDisplayTime(II)Ljava/lang/String;

    move-result-object v0

    .line 1337
    .local v0, "displayDuration":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1339
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-wide/16 v4, 0x3e8

    div-long v4, p1, v4

    long-to-int v3, v4

    invoke-static {v2, v3}, Lcom/comcast/cim/utils/UIPresentationUtil;->getTimeForPlayer(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    .line 1340
    .local v1, "durationDescription":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v4, Lcom/xfinity/playerlib/R$string;->content_description_duration:I

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v1, v5, v6

    invoke-virtual {v3, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public setVideoTitle(Ljava/lang/String;)V
    .locals 5
    .param p1, "titleText"    # Ljava/lang/String;

    .prologue
    .line 1247
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isLiveStream()Z
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v2

    .line 1248
    .local v2, "isLiveStream":Z
    if-eqz v2, :cond_0

    .line 1249
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onNow:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->live_tv:I

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(I)V

    .line 1254
    :goto_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->title:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getRootView()Landroid/view/View;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$id;->watching_speech:I

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 1255
    .local v1, "content_description_title":Landroid/view/View;
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onNow:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1256
    .local v0, "contentDescriptionBuilder":Ljava/lang/StringBuilder;
    if-eqz v2, :cond_1

    .line 1257
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->title:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1265
    :goto_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1266
    return-void

    .line 1251
    .end local v0    # "contentDescriptionBuilder":Ljava/lang/StringBuilder;
    .end local v1    # "content_description_title":Landroid/view/View;
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onNow:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->on_now:I

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0

    .line 1259
    .restart local v0    # "contentDescriptionBuilder":Ljava/lang/StringBuilder;
    .restart local v1    # "content_description_title":Landroid/view/View;
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->title:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1260
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->title:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1261
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1
.end method

.method public setWaitingForInternetText()V
    .locals 2

    .prologue
    .line 857
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bufferingText:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->waiting_for_internet:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 858
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->waiting_for_internet:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 859
    return-void
.end method

.method public setupAccessibilityControlToggle()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 1655
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->firstTimePlayed:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1656
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->firstTimePlayed:Z
    invoke-static {v0, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4602(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 1657
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z
    invoke-static {v0, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2502(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 1659
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1660
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 1662
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_toggle_control_instructions_off:I

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->changeAccessibilityControlToggleContentDescription(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)V

    .line 1665
    :cond_1
    return-void
.end method

.method public setupAdBreaks(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;)V
    .locals 8
    .param p1, "timeline"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    .prologue
    .line 1347
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v3

    if-nez v3, :cond_1

    .line 1348
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->getSmil()Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/SMILResource;->getAdsType()Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    move-result-object v0

    .line 1349
    .local v0, "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    sget-object v3, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->C3_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    if-eq v0, v3, :cond_1

    if-eqz p1, :cond_1

    .line 1350
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->timelineMarkers()Ljava/util/Iterator;

    move-result-object v1

    .line 1351
    .local v1, "iter":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1352
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;

    .line 1353
    .local v2, "marker":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->getTime()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-nez v3, :cond_0

    .line 1354
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 1360
    .end local v0    # "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    .end local v1    # "iter":Ljava/util/Iterator;
    .end local v2    # "marker":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v4

    invoke-virtual {v3, p1, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->setMarkersAndDuration(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;J)V

    .line 1361
    return-void
.end method

.method public setupRatingsBug(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 2
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 1425
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1426
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;-><init>(Landroid/app/Activity;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->ratingsBug:Lcom/xfinity/playerlib/view/videoplay/RatingsBug;

    .line 1431
    :goto_0
    return-void

    .line 1428
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->ratingsBug:Lcom/xfinity/playerlib/view/videoplay/RatingsBug;

    goto :goto_0
.end method

.method public setupVideoView()V
    .locals 4

    .prologue
    .line 1478
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    .line 1479
    .local v0, "displayMetrics":Landroid/util/DisplayMetrics;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    .line 1480
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Display;->getRealMetrics(Landroid/util/DisplayMetrics;)V

    .line 1485
    :goto_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    iget v2, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v3, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setDimensionsOfVideo(II)V

    .line 1486
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Dimensions of player are : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "w, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "h"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 1487
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerFrame:Landroid/widget/FrameLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/FrameLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 1488
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerFrame:Landroid/widget/FrameLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/FrameLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerOnClickListener:Landroid/view/View$OnClickListener;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/View$OnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1490
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getView()Landroid/view/View;

    move-result-object v1

    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$6;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$6;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1519
    return-void

    .line 1482
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    goto/16 :goto_0
.end method

.method protected showActionBarMenus()V
    .locals 2

    .prologue
    .line 1242
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->menuTabs:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1243
    return-void
.end method

.method public showAdControls()V
    .locals 2

    .prologue
    .line 958
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->setVisibility(I)V

    .line 959
    return-void
.end method

.method public showAdControlsWithTimeLeft(J)V
    .locals 1
    .param p1, "timeLeft"    # J

    .prologue
    .line 882
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showAdControls()V

    .line 883
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateAdTimeLeft(J)V

    .line 884
    return-void
.end method

.method public showBuffering()V
    .locals 2

    .prologue
    .line 845
    sget v1, Lcom/xfinity/playerlib/R$string;->buffering:I

    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isDownloadedVideo()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v1, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showSpinnerWithText(IZ)V

    .line 846
    return-void

    .line 845
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public showClickableAdButtonForUrl(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "clickTitle"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 962
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->clickableAdButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/Button;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 963
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->clickableAdButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/Button;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;

    invoke-direct {v1, p0, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 998
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 999
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->clickableAdButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 1003
    :goto_0
    return-void

    .line 1001
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->clickableAdButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/Button;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->clickable_ad_more_info:I

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(I)V

    goto :goto_0
.end method

.method public abstract showCurrentVideoInfo(Ljava/lang/String;)Z
.end method

.method public showErrorInPinPadFragment(Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 1
    .param p1, "pinValidationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 1638
    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;->onPinValidationComplete(Z)V

    .line 1639
    return-void
.end method

.method public abstract showFavorite(Ljava/lang/String;)Z
.end method

.method public abstract showFavoriteDetail(Lcom/xfinity/playerlib/model/VideoFavorite;Ljava/lang/String;)V
.end method

.method public abstract showHistory(Ljava/lang/String;)Z
.end method

.method public abstract showHistoryItemDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/String;)V
.end method

.method public showLaunchScreen()V
    .locals 2

    .prologue
    .line 1448
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupDialog:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 1449
    return-void
.end method

.method protected showMainControls(Z)V
    .locals 3
    .param p1, "showPlayButton"    # Z

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 1153
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1155
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsVolumeControl()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1156
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSliderLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1159
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsBrightnessControl()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1160
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessSliderLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1163
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isLiveStream()Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1164
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1165
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->pauseButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1178
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerFrame:Landroid/widget/FrameLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/FrameLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->requestFocus()Z

    .line 1179
    return-void

    .line 1167
    :cond_2
    if-eqz p1, :cond_3

    .line 1168
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1169
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->pauseButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1170
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playButton:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->requestFocus()Z

    goto :goto_0

    .line 1172
    :cond_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1173
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->pauseButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1174
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->pauseButton:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->requestFocus()Z

    goto :goto_0
.end method

.method public showMainControlsWithPauseButton()V
    .locals 1

    .prologue
    .line 1055
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsAndActionBar(Z)V

    .line 1056
    return-void
.end method

.method public showMainControlsWithPlayButton()V
    .locals 1

    .prologue
    .line 1051
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showMainControlsAndActionBar(Z)V

    .line 1052
    return-void
.end method

.method public showPinPadFragment()V
    .locals 4

    .prologue
    .line 1608
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->parentalControlPinFragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    if-nez v2, :cond_0

    .line 1609
    new-instance v2, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    invoke-direct {v2}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;-><init>()V

    iput-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->parentalControlPinFragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    .line 1610
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->parentalControlPinFragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$8;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$8;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->setPinValidator(Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;)V

    .line 1617
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->parentalControlPinFragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$9;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$9;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 1625
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 1626
    .local v1, "ft":Landroid/app/FragmentTransaction;
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 1629
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->parentalControlPinFragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    const-string v3, "dialog"

    invoke-virtual {v2, v1, v3}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->show(Landroid/app/FragmentTransaction;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1635
    .end local v1    # "ft":Landroid/app/FragmentTransaction;
    :cond_0
    :goto_0
    return-void

    .line 1630
    .restart local v1    # "ft":Landroid/app/FragmentTransaction;
    :catch_0
    move-exception v0

    .line 1631
    .local v0, "e":Ljava/lang/IllegalStateException;
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Caught IllegalStateException when trying to show PinKeypadFragment, fragment manager is likely no longer valid because user has moved on"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public showSAPSelectionDialog()V
    .locals 2

    .prologue
    .line 1571
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1605
    return-void
.end method

.method public showSeeking()V
    .locals 2

    .prologue
    .line 849
    sget v1, Lcom/xfinity/playerlib/R$string;->seeking:I

    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isDownloadedVideo()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v1, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showSpinnerWithText(IZ)V

    .line 850
    return-void

    .line 849
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public abstract showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Ljava/lang/String;)V
.end method

.method public showSpinnerWithText(IZ)V
    .locals 2
    .param p1, "resId"    # I
    .param p2, "checkConnection"    # Z

    .prologue
    .line 866
    if-eqz p2, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 867
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bufferingText:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(I)V

    .line 868
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 872
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bufferingProgress:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 873
    return-void

    .line 870
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setWaitingForInternetText()V

    goto :goto_0
.end method

.method public showThumbTimeView(I)V
    .locals 2
    .param p1, "progress"    # I

    .prologue
    .line 1384
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->thumbTime:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1385
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setThumbTimeView(I)V

    .line 1386
    return-void
.end method

.method public startAdsActionBarTimeout()V
    .locals 4

    .prologue
    .line 1102
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "#@@@UIController: startAdsActionBarTimeout"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 1104
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isAdsActionBarAdjustedForStatusBar:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1105
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->moveAdsActionBarDown(Z)V

    .line 1107
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->moveUpAdsActionBarRunner:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1108
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->moveUpAdsActionBarRunner:Ljava/lang/Runnable;

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1109
    return-void
.end method

.method public startMainControlTimeout()V
    .locals 4

    .prologue
    .line 1076
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "#@@@UIController: startMainControlTimeout"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 1077
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1078
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearPlayerControlsRunner:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1079
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearPlayerControlsRunner:Ljava/lang/Runnable;

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1081
    :cond_0
    return-void
.end method

.method public startRatingsBug()V
    .locals 1

    .prologue
    .line 1434
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hasShownRatingsBug:Z

    .line 1435
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->ratingsBug:Lcom/xfinity/playerlib/view/videoplay/RatingsBug;

    if-eqz v0, :cond_0

    .line 1436
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->ratingsBug:Lcom/xfinity/playerlib/view/videoplay/RatingsBug;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->start()V

    .line 1438
    :cond_0
    return-void
.end method

.method public startVolumeControlTimeout()V
    .locals 4

    .prologue
    .line 1089
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "#@@@UIController: startVolumeControlTimeout"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 1090
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1091
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearVolumeControlRunner:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1092
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->clearVolumeControlRunner:Ljava/lang/Runnable;

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1094
    :cond_0
    return-void
.end method

.method public stopRatingsBug()V
    .locals 1

    .prologue
    .line 1441
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->ratingsBug:Lcom/xfinity/playerlib/view/videoplay/RatingsBug;

    if-eqz v0, :cond_0

    .line 1442
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->ratingsBug:Lcom/xfinity/playerlib/view/videoplay/RatingsBug;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->stop()V

    .line 1444
    :cond_0
    return-void
.end method

.method public styleClosedCaptions()V
    .locals 3

    .prologue
    .line 1816
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1817
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x13

    if-lt v1, v2, :cond_1

    .line 1818
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-string v2, "captioning"

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/CaptioningManager;

    .line 1819
    .local v0, "cm":Landroid/view/accessibility/CaptioningManager;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->styleClosedCaptions(Landroid/view/accessibility/CaptioningManager;)V

    .line 1824
    .end local v0    # "cm":Landroid/view/accessibility/CaptioningManager;
    :cond_0
    :goto_0
    return-void

    .line 1821
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v2

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->styleClosedCaptions(Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    goto :goto_0
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 1808
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 1802
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V

    .line 1803
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 1813
    return-void
.end method

.method public toggleStats()V
    .locals 2

    .prologue
    .line 831
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->statsView:Landroid/view/View;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 832
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->statsView:Landroid/view/View;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 836
    :goto_0
    return-void

    .line 834
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->statsView:Landroid/view/View;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public turnLightsOn()V
    .locals 2

    .prologue
    .line 1230
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 1231
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x100

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setSystemUiVisibility(I)V

    .line 1235
    :goto_0
    return-void

    .line 1233
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    goto :goto_0
.end method

.method public turnLightsOut()V
    .locals 2

    .prologue
    .line 1222
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 1223
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x106

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setSystemUiVisibility(I)V

    .line 1227
    :goto_0
    return-void

    .line 1225
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    goto :goto_0
.end method

.method public updateAdTimeLeft(J)V
    .locals 13
    .param p1, "timeLeft"    # J

    .prologue
    const/4 v6, 0x2

    const/4 v12, 0x0

    const/4 v11, 0x1

    .line 887
    iget-boolean v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isSeeking:Z

    if-eqz v3, :cond_1

    .line 888
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 930
    :cond_0
    :goto_0
    return-void

    .line 892
    :cond_1
    const-wide/16 v4, 0x3e8

    div-long v4, p1, v4

    long-to-int v2, v4

    .line 894
    .local v2, "secondsLeft":I
    if-nez v2, :cond_2

    .line 895
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->ad_resuming:I

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(I)V

    .line 896
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adAnnouced:Z
    invoke-static {v3, v12}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1802(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 898
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adZeroSeconds:Z
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 899
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adZeroSeconds:Z
    invoke-static {v3, v11}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1902(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 900
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->announceAdState(Ljava/lang/String;)V

    goto :goto_0

    .line 902
    :cond_2
    if-lez v2, :cond_5

    .line 903
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adZeroSeconds:Z
    invoke-static {v3, v12}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1902(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 905
    const/16 v3, 0x3c

    if-lt v2, v3, :cond_4

    .line 906
    div-int/lit8 v0, v2, 0x3c

    .line 907
    .local v0, "minutesLeft":I
    rem-int/lit8 v1, v2, 0x3c

    .line 908
    .local v1, "seconds":I
    if-nez v1, :cond_3

    .line 909
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$plurals;->ad_minutes_time_left:I

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v12

    const-string v7, ""

    aput-object v7, v6, v11

    invoke-virtual {v4, v5, v0, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 918
    .end local v0    # "minutesLeft":I
    .end local v1    # "seconds":I
    :goto_1
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adAnnouced:Z
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 919
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adAnnouced:Z
    invoke-static {v3, v11}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1802(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 920
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->announceAdState(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 911
    .restart local v0    # "minutesLeft":I
    .restart local v1    # "seconds":I
    :cond_3
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$plurals;->ad_minutes_time_left:I

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v12

    iget-object v7, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 912
    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$plurals;->ad_extra_seconds_left:I

    new-array v9, v11, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-virtual {v7, v8, v1, v9}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v11

    .line 911
    invoke-virtual {v4, v5, v0, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 915
    .end local v0    # "minutesLeft":I
    .end local v1    # "seconds":I
    :cond_4
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$plurals;->ad_time_left:I

    new-array v6, v11, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v12

    invoke-virtual {v4, v5, v2, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 923
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->ad_unknown_time_left:I

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(I)V

    .line 925
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adAnnouced:Z
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 926
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adAnnouced:Z
    invoke-static {v3, v11}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1802(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z

    .line 927
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->announceAdState(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public updateCurrentBitrate(J)V
    .locals 3
    .param p1, "bitrate"    # J

    .prologue
    .line 839
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bitrateTextView:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "bitrate: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 840
    return-void
.end method

.method public updateProgress()V
    .locals 4

    .prologue
    .line 1313
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->isSeeking:Z

    if-nez v0, :cond_0

    .line 1314
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1315
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPosition()J

    move-result-wide v0

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v2

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->updateProgressInfo(JJ)V

    .line 1318
    :cond_0
    return-void
.end method
