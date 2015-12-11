.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showSAPSelectionDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    .prologue
    .line 1571
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    .line 1574
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v11

    .line 1575
    .local v11, "mediaPlayer":Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;
    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7$1;

    invoke-direct {v3, p0, v11}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7$1;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;)V

    .line 1583
    .local v3, "onSelectionChangeListener":Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getAvailableLanguages()Ljava/util/List;

    move-result-object v10

    .line 1584
    .local v10, "languageList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v11}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v10, v2}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 1585
    .local v1, "selectedAudioTrackIndex":I
    new-instance v0, Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 1587
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v2

    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->selectionDialogOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v5, v5, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->selectionDialogOnKeyListener:Landroid/content/DialogInterface$OnKeyListener;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 1591
    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/ActionBar;->getHeight()I

    move-result v6

    invoke-direct/range {v0 .. v6}, Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;-><init>(ILandroid/view/View;Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;Landroid/content/DialogInterface$OnCancelListener;Landroid/content/DialogInterface$OnKeyListener;I)V

    .line 1592
    .local v0, "listDialogFragment":Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v9

    .line 1593
    .local v9, "ft":Landroid/app/FragmentTransaction;
    const/4 v2, 0x0

    invoke-virtual {v9, v2}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 1595
    :try_start_0
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 1596
    .local v7, "args":Landroid/os/Bundle;
    const-string v4, "data"

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v10, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    invoke-virtual {v7, v4, v2}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 1597
    invoke-virtual {v0, v7}, Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 1598
    const-string v2, "sapselectionlistdialog"

    invoke-virtual {v0, v9, v2}, Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;->show(Landroid/app/FragmentTransaction;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1603
    .end local v7    # "args":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 1599
    :catch_0
    move-exception v8

    .line 1600
    .local v8, "e":Ljava/lang/IllegalStateException;
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v4, "Caught IllegalStateException when trying to show SAPSelectionListDialogFragment, fragment manager is likely no longer valid because user has moved on"

    invoke-interface {v2, v4, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
