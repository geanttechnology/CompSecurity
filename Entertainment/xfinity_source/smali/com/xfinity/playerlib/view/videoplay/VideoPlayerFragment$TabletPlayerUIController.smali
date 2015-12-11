.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;
.super Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
.source "VideoPlayerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TabletPlayerUIController"
.end annotation


# instance fields
.field infoFragment:Landroid/app/Fragment;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V
    .locals 0

    .prologue
    .line 1830
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 1831
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    .line 1832
    return-void
.end method

.method private getMenuLayout(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)Landroid/view/View;
    .locals 2
    .param p1, "babyGuideType"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .prologue
    .line 1984
    const/4 v0, 0x0

    .line 1986
    .local v0, "menuLayout":Landroid/widget/LinearLayout;
    if-eqz p1, :cond_3

    .line 1988
    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->BOOKMARKS:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    invoke-virtual {p1, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1989
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->favoriteMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    .line 1999
    :cond_0
    :goto_0
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 2003
    :goto_1
    return-object v1

    .line 1991
    :cond_1
    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->HISTORY:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    invoke-virtual {p1, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1992
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->historyMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    goto :goto_0

    .line 1994
    :cond_2
    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->INFO:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    invoke-virtual {p1, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1995
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    goto :goto_0

    .line 2003
    :cond_3
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private isFragmentInBackStack(Ljava/lang/String;)Z
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 2082
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 2083
    .local v1, "fragmentManager":Landroid/app/FragmentManager;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {v1}, Landroid/app/FragmentManager;->getBackStackEntryCount()I

    move-result v3

    if-ge v2, v3, :cond_1

    .line 2084
    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->getBackStackEntryAt(I)Landroid/app/FragmentManager$BackStackEntry;

    move-result-object v0

    .line 2085
    .local v0, "entry":Landroid/app/FragmentManager$BackStackEntry;
    invoke-interface {v0}, Landroid/app/FragmentManager$BackStackEntry;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2086
    const/4 v3, 0x1

    .line 2089
    .end local v0    # "entry":Landroid/app/FragmentManager$BackStackEntry;
    :goto_1
    return v3

    .line 2083
    .restart local v0    # "entry":Landroid/app/FragmentManager$BackStackEntry;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 2089
    .end local v0    # "entry":Landroid/app/FragmentManager$BackStackEntry;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method private selectBabyGuideItem(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)V
    .locals 9
    .param p1, "babyGuideType"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 1960
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    invoke-static {v2, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$802(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .line 1961
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1963
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->getMenuLayout(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)Landroid/view/View;

    move-result-object v0

    .line 1965
    .local v0, "menuLayout":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 1966
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_x_button:I

    new-array v4, v8, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 1967
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    move-result-object v6

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->getCaptionResId()I

    move-result v6

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    .line 1966
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1970
    :cond_0
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->getMenuLayout(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)Landroid/view/View;

    move-result-object v0

    .line 1972
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_button_state_selected:I

    new-array v4, v8, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 1973
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    move-result-object v6

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->getCaptionResId()I

    move-result v6

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    .line 1972
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1975
    .local v1, "selected":Ljava/lang/String;
    invoke-virtual {v0, v1}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1977
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v2

    invoke-interface {v2, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 1980
    .end local v0    # "menuLayout":Landroid/view/View;
    .end local v1    # "selected":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private showItem(Ljava/lang/String;Landroid/app/Fragment;)V
    .locals 8
    .param p1, "transactionTag"    # Ljava/lang/String;
    .param p2, "fragment"    # Landroid/app/Fragment;

    .prologue
    .line 2007
    iput-object p2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    .line 2008
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 2009
    .local v1, "fragmentManager":Landroid/app/FragmentManager;
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 2011
    .local v2, "fragmentTransaction":Landroid/app/FragmentTransaction;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    invoke-virtual {v4}, Landroid/app/Fragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 2012
    .local v0, "args":Landroid/os/Bundle;
    if-nez v0, :cond_0

    .line 2013
    new-instance v0, Landroid/os/Bundle;

    .end local v0    # "args":Landroid/os/Bundle;
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 2016
    .restart local v0    # "args":Landroid/os/Bundle;
    :cond_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v3

    .line 2017
    .local v3, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    if-eqz v3, :cond_1

    .line 2018
    const-string v4, "EXTRA_CURRENT_WATCH_VIDEO_ID"

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v6

    invoke-virtual {v0, v4, v6, v7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2021
    :cond_1
    sget-object v4, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->EXTRA_BABY_GUIDE_MODE:Ljava/lang/String;

    const/4 v5, 0x1

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2022
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    invoke-virtual {v4, v0}, Landroid/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 2023
    sget v4, Lcom/xfinity/playerlib/R$id;->info_panel:I

    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    invoke-virtual {v2, v4, v5}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 2024
    invoke-virtual {v2, p1}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 2025
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commit()I

    .line 2026
    invoke-virtual {v1}, Landroid/app/FragmentManager;->executePendingTransactions()Z

    .line 2027
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->infoPanel:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 2029
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 2030
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getView()Landroid/view/View;

    move-result-object v5

    const/4 v6, 0x2

    invoke-virtual {v4, v5, v6}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 2033
    :cond_2
    return-void
.end method

.method private showItemDetail(Ljava/lang/String;Landroid/app/Fragment;)V
    .locals 5
    .param p1, "transactionTag"    # Ljava/lang/String;
    .param p2, "fragment"    # Landroid/app/Fragment;

    .prologue
    .line 2071
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->isFragmentInBackStack(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2072
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 2073
    .local v0, "fragmentTransaction":Landroid/app/FragmentTransaction;
    sget v1, Lcom/xfinity/playerlib/R$anim;->slide_in_right:I

    sget v2, Lcom/xfinity/playerlib/R$anim;->slide_out_left:I

    sget v3, Lcom/xfinity/playerlib/R$anim;->slide_in_left:I

    sget v4, Lcom/xfinity/playerlib/R$anim;->slide_out_right:I

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/app/FragmentTransaction;->setCustomAnimations(IIII)Landroid/app/FragmentTransaction;

    .line 2075
    sget v1, Lcom/xfinity/playerlib/R$id;->info_panel:I

    invoke-virtual {v0, v1, p2}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 2076
    invoke-virtual {v0, p1}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 2077
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 2079
    .end local v0    # "fragmentTransaction":Landroid/app/FragmentTransaction;
    :cond_0
    return-void
.end method


# virtual methods
.method public clearBackStack()V
    .locals 4

    .prologue
    .line 2094
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 2095
    .local v1, "fragmentManager":Landroid/app/FragmentManager;
    sget v2, Lcom/xfinity/playerlib/R$id;->info_panel:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    .line 2096
    .local v0, "fragment":Landroid/app/Fragment;
    instance-of v2, v0, Lcom/xfinity/playerlib/view/AnimatedFragment;

    if-eqz v2, :cond_0

    .line 2097
    check-cast v0, Lcom/xfinity/playerlib/view/AnimatedFragment;

    .end local v0    # "fragment":Landroid/app/Fragment;
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/xfinity/playerlib/view/AnimatedFragment;->setAnimationEnabled(Ljava/lang/Boolean;)V

    .line 2100
    :cond_0
    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/app/FragmentManager;->popBackStack(Ljava/lang/String;I)V

    .line 2101
    return-void
.end method

.method public hideInfoPanel()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 1836
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1837
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->historyMenu:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1838
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->favoriteMenu:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1840
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->clearBackStack()V

    .line 1844
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1858
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1859
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getView()Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 1860
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->announceBabyGuideClosed(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)V

    .line 1863
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    const/4 v1, 0x0

    # setter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$802(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .line 1864
    return-void
.end method

.method public hideMainControls()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 2106
    invoke-super {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideMainControls()V

    .line 2107
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->pauseButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2108
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2109
    return-void
.end method

.method public showCurrentVideoInfo(Ljava/lang/String;)Z
    .locals 10
    .param p1, "transactionTag"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 1927
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v4

    invoke-virtual {v4, v8}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1928
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->historyMenu:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v4

    invoke-virtual {v4, v9}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1929
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->favoriteMenu:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v4

    invoke-virtual {v4, v9}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1931
    sget-object v4, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->INFO:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    invoke-direct {p0, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->selectBabyGuideItem(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)V

    .line 1933
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v3

    .line 1935
    .local v3, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    const/4 v1, 0x0

    .line 1936
    .local v1, "currentVideoFragment":Landroid/app/Fragment;
    if-eqz v3, :cond_2

    .line 1937
    new-instance v4, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v4, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 1938
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v4

    .line 1939
    invoke-virtual {v4, v8}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showPanelFittedLayout(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    .line 1940
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v4

    sget-object v6, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v4, v6}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    sget-object v4, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    :goto_0
    invoke-virtual {v5, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v4

    .line 1941
    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getFragment()Landroid/app/Fragment;

    move-result-object v1

    .line 1950
    :goto_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_info"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1951
    .local v2, "tag":Ljava/lang/String;
    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->isFragmentInBackStack(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 1952
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->clearBackStack()V

    .line 1953
    invoke-direct {p0, v2, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->showItem(Ljava/lang/String;Landroid/app/Fragment;)V

    .line 1956
    :cond_0
    return v9

    .line 1940
    .end local v2    # "tag":Ljava/lang/String;
    :cond_1
    sget-object v4, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    goto :goto_0

    .line 1943
    :cond_2
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1944
    .local v0, "args":Landroid/os/Bundle;
    const-string v4, "numColumns"

    invoke-virtual {v0, v4, v8}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1945
    const-string v4, "inBabyGuide"

    invoke-virtual {v0, v4, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1946
    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .end local v1    # "currentVideoFragment":Landroid/app/Fragment;
    invoke-direct {v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;-><init>()V

    .line 1947
    .restart local v1    # "currentVideoFragment":Landroid/app/Fragment;
    invoke-virtual {v1, v0}, Landroid/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    goto :goto_1
.end method

.method public showFavorite(Ljava/lang/String;)Z
    .locals 4
    .param p1, "transactionTag"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 1911
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->favoriteMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1912
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1913
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->historyMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1915
    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->BOOKMARKS:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->selectBabyGuideItem(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)V

    .line 1917
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_favorites"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1918
    .local v0, "tag":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->isFragmentInBackStack(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1919
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->clearBackStack()V

    .line 1920
    new-instance v1, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    invoke-direct {v1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;-><init>()V

    invoke-direct {p0, v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->showItem(Ljava/lang/String;Landroid/app/Fragment;)V

    .line 1922
    :cond_0
    return v3
.end method

.method public showFavoriteDetail(Lcom/xfinity/playerlib/model/VideoFavorite;Ljava/lang/String;)V
    .locals 4
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;
    .param p2, "transactionTag"    # Ljava/lang/String;

    .prologue
    .line 2037
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    .line 2039
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v2, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/VideoFavorite;)V

    const/4 v3, 0x1

    .line 2040
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showPanelFittedLayout(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v0

    .line 2042
    .local v0, "builder":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    if-eqz v1, :cond_0

    .line 2043
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .line 2046
    :cond_0
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getFragment()Landroid/app/Fragment;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    .line 2047
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    invoke-direct {p0, p2, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->showItemDetail(Ljava/lang/String;Landroid/app/Fragment;)V

    .line 2048
    return-void
.end method

.method public showHistory(Ljava/lang/String;)Z
    .locals 4
    .param p1, "transactionTag"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 1895
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->historyMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1896
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$3500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1897
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->favoriteMenu:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setSelected(Z)V

    .line 1899
    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->HISTORY:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->selectBabyGuideItem(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)V

    .line 1901
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_history"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1902
    .local v0, "tag":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->isFragmentInBackStack(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1903
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->clearBackStack()V

    .line 1904
    new-instance v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-direct {v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;-><init>()V

    invoke-direct {p0, v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->showItem(Ljava/lang/String;Landroid/app/Fragment;)V

    .line 1906
    :cond_0
    return v3
.end method

.method public showHistoryItemDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/String;)V
    .locals 5
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p2, "transactionTag"    # Ljava/lang/String;

    .prologue
    .line 2052
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    .line 2054
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v2, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    const/4 v3, 0x0

    .line 2055
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    const/4 v3, 0x1

    .line 2056
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showPanelFittedLayout(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 2057
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v2

    sget-object v4, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 2058
    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget-object v2, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 2057
    :goto_0
    invoke-virtual {v3, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v0

    .line 2060
    .local v0, "builder":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    if-eqz v1, :cond_0

    .line 2061
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .line 2064
    :cond_0
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getFragment()Landroid/app/Fragment;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    .line 2065
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    invoke-direct {p0, p2, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->showItemDetail(Ljava/lang/String;Landroid/app/Fragment;)V

    .line 2066
    return-void

    .line 2058
    .end local v0    # "builder":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    :cond_1
    sget-object v2, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    goto :goto_0
.end method

.method public showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Ljava/lang/String;)V
    .locals 7
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p2, "transactionTag"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    .line 1868
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->infoPanel:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1870
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 1871
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->infoPanel:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->clearAnimation()V

    .line 1873
    sget v2, Lcom/xfinity/playerlib/R$anim;->slide_in_right:I

    sget v3, Lcom/xfinity/playerlib/R$anim;->slide_out_left:I

    sget v4, Lcom/xfinity/playerlib/R$anim;->slide_in_left:I

    sget v5, Lcom/xfinity/playerlib/R$anim;->slide_out_right:I

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/app/FragmentTransaction;->setCustomAnimations(IIII)Landroid/app/FragmentTransaction;

    .line 1876
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v2, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 1877
    invoke-virtual {v2, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 1878
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v0

    .line 1880
    .local v0, "builder":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 1881
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .line 1886
    :goto_0
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getFragment()Landroid/app/Fragment;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    .line 1887
    sget v2, Lcom/xfinity/playerlib/R$id;->info_panel:I

    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->infoFragment:Landroid/app/Fragment;

    invoke-virtual {v1, v2, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 1888
    invoke-virtual {v1, p2}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 1890
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 1891
    return-void

    .line 1883
    :cond_0
    invoke-virtual {v0, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->isInBabyGuide(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    goto :goto_0
.end method
