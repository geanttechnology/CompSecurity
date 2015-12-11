.class public Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;
.super Ljava/lang/Object;
.source "BookmarkUtils.java"


# instance fields
.field private favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

.field liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/FavoriteDAO;Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;)V
    .locals 0
    .param p1, "favoriteDAO"    # Lcom/xfinity/playerlib/model/database/FavoriteDAO;
    .param p2, "liveStreamBookmarkDAO"    # Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    .line 28
    iput-object p2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 29
    return-void
.end method

.method private showAddRemoveBookmarkDialog(Landroid/app/Fragment;ZLjava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    .locals 9
    .param p1, "fragment"    # Landroid/app/Fragment;
    .param p2, "isAdded"    # Z
    .param p3, "itemName"    # Ljava/lang/String;
    .param p4, "yesButtonOnClickListener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    const/4 v8, 0x1

    .line 66
    if-eqz p2, :cond_0

    sget v5, Lcom/xfinity/playerlib/R$string;->bookmark_remove_title:I

    :goto_0
    invoke-virtual {p1, v5}, Landroid/app/Fragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 67
    .local v4, "dialogTitle":Ljava/lang/String;
    if-eqz p2, :cond_1

    sget v5, Lcom/xfinity/playerlib/R$string;->bookmark_remove_prompt:I

    :goto_1
    new-array v6, v8, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p3, v6, v7

    invoke-virtual {p1, v5, v6}, Landroid/app/Fragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 69
    .local v3, "dialogMessage":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 70
    .local v0, "args":Landroid/os/Bundle;
    const-string v5, "title"

    invoke-virtual {v0, v5, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    const-string v5, "description"

    invoke-virtual {v0, v5, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    const-string v5, "dismissOnOrientationChange"

    invoke-virtual {v0, v5, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 74
    const-string v5, "inputPromptDlg"

    invoke-static {v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .line 75
    .local v2, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v2, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 77
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 78
    .local v1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    new-instance v5, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    sget v6, Lcom/xfinity/playerlib/R$string;->dlg_btn_yes:I

    invoke-virtual {p1, v6}, Landroid/app/Fragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6, p4}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 79
    new-instance v5, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    sget v6, Lcom/xfinity/playerlib/R$string;->dlg_btn_no:I

    invoke-virtual {p1, v6}, Landroid/app/Fragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$3;

    invoke-direct {v7, p0}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$3;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;)V

    invoke-direct {v5, v6, v7}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 86
    invoke-virtual {v2, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setButtonList(Ljava/util/List;)V

    .line 87
    invoke-virtual {p1}, Landroid/app/Fragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v5

    const-string v6, "caldialogfragment"

    invoke-virtual {v2, v5, v6}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 88
    return-void

    .line 66
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    .end local v2    # "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .end local v3    # "dialogMessage":Ljava/lang/String;
    .end local v4    # "dialogTitle":Ljava/lang/String;
    :cond_0
    sget v5, Lcom/xfinity/playerlib/R$string;->bookmark_add_title:I

    goto :goto_0

    .line 67
    .restart local v4    # "dialogTitle":Ljava/lang/String;
    :cond_1
    sget v5, Lcom/xfinity/playerlib/R$string;->bookmark_add_prompt:I

    goto :goto_1
.end method


# virtual methods
.method public executeAddRemove(Lcom/xfinity/playerlib/model/VideoFavorite;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V
    .locals 10
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;
    .param p2, "isAdded"    # Z
    .param p3, "accessibilityFragment"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 93
    invoke-virtual {p3}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 96
    .local v1, "context":Landroid/content/Context;
    if-eqz p2, :cond_1

    .line 97
    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    invoke-virtual {v3, p1}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->deleteFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 98
    sget v3, Lcom/xfinity/playerlib/R$string;->bookmark_removed_toast:I

    new-array v4, v9, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getTitle()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-virtual {v1, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 110
    .local v2, "toastMessage":Ljava/lang/String;
    :goto_0
    invoke-static {v1, v2, v8}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 112
    invoke-virtual {p3}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 113
    .local v0, "alternateInterfaceListener":Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v3

    invoke-interface {v3, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 114
    return-void

    .line 100
    .end local v0    # "alternateInterfaceListener":Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .end local v2    # "toastMessage":Ljava/lang/String;
    :cond_0
    sget v3, Lcom/xfinity/playerlib/R$string;->bookmark_remove_error_toast:I

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "toastMessage":Ljava/lang/String;
    goto :goto_0

    .line 103
    .end local v2    # "toastMessage":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    invoke-virtual {v3, p1}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->addFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-lez v3, :cond_2

    .line 104
    sget v3, Lcom/xfinity/playerlib/R$string;->bookmark_added_toast:I

    new-array v4, v9, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getTitle()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-virtual {v1, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "toastMessage":Ljava/lang/String;
    goto :goto_0

    .line 106
    .end local v2    # "toastMessage":Ljava/lang/String;
    :cond_2
    sget v3, Lcom/xfinity/playerlib/R$string;->bookmark_add_error_toast:I

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "toastMessage":Ljava/lang/String;
    goto :goto_0
.end method

.method public executeAddRemove(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;)V
    .locals 8
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "isAdded"    # Z
    .param p3, "accessibilityFragment"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
    .param p4, "bookmarkEventListener"    # Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 120
    invoke-virtual {p3}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 123
    .local v1, "context":Landroid/content/Context;
    if-eqz p2, :cond_1

    .line 124
    iget-object v4, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->deleteFavorite(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 125
    sget v4, Lcom/xfinity/playerlib/R$string;->bookmark_removed_toast:I

    new-array v5, v6, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v1, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 126
    .local v3, "toastMessage":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p4, v4}, Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;->onLiveStreamBookmarkDeleted(Ljava/lang/String;)V

    .line 142
    :goto_0
    invoke-static {v1, v3, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 143
    invoke-virtual {p3}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 144
    .local v0, "alternateInterfaceListener":Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v4

    invoke-interface {v4, v3}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 145
    return-void

    .line 128
    .end local v0    # "alternateInterfaceListener":Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .end local v3    # "toastMessage":Ljava/lang/String;
    :cond_0
    sget v4, Lcom/xfinity/playerlib/R$string;->bookmark_remove_error_toast:I

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .restart local v3    # "toastMessage":Ljava/lang/String;
    goto :goto_0

    .line 132
    .end local v3    # "toastMessage":Ljava/lang/String;
    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v4, p1}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->addFavorite(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v2

    .line 134
    .local v2, "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-eqz v2, :cond_2

    .line 135
    sget v4, Lcom/xfinity/playerlib/R$string;->bookmark_added_toast:I

    new-array v5, v6, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v1, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 136
    .restart local v3    # "toastMessage":Ljava/lang/String;
    invoke-interface {p4, v2}, Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;->onLiveStreamBookmarkAdded(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    goto :goto_0

    .line 138
    .end local v3    # "toastMessage":Ljava/lang/String;
    :cond_2
    sget v4, Lcom/xfinity/playerlib/R$string;->bookmark_add_error_toast:I

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .restart local v3    # "toastMessage":Ljava/lang/String;
    goto :goto_0
.end method

.method public isInFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)Z
    .locals 1
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->isInFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)Z

    move-result v0

    return v0
.end method

.method public promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 3
    .param p1, "accessibilityFragment"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
    .param p2, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 37
    invoke-virtual {p0, p2}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->isInFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)Z

    move-result v0

    .line 39
    .local v0, "isAdded":Z
    new-instance v1, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;

    invoke-direct {v1, p0, p2, v0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;Lcom/xfinity/playerlib/model/VideoFavorite;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V

    .line 47
    .local v1, "yesButtonOnClickListener":Landroid/content/DialogInterface$OnClickListener;
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/VideoFavorite;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1, v0, v2, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->showAddRemoveBookmarkDialog(Landroid/app/Fragment;ZLjava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 48
    return-void
.end method

.method public promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;ZLcom/xfinity/playerlib/view/favorite/BookmarkEventListener;)V
    .locals 6
    .param p1, "accessibilityFragment"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
    .param p2, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p3, "isAdded"    # Z
    .param p4, "bookmarkEventListener"    # Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;

    .prologue
    .line 54
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;

    move-object v1, p0

    move-object v2, p2

    move v3, p3

    move-object v4, p1

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;)V

    .line 62
    .local v0, "yesButtonOnClickListener":Landroid/content/DialogInterface$OnClickListener;
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p1, p3, v1, v0}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->showAddRemoveBookmarkDialog(Landroid/app/Fragment;ZLjava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 63
    return-void
.end method
