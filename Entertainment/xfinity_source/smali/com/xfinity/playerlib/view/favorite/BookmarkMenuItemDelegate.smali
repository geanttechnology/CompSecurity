.class public Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;
.super Ljava/lang/Object;
.source "BookmarkMenuItemDelegate.java"


# instance fields
.field private bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field private favoriteToggle:Landroid/view/MenuItem;

.field isChecked:Z

.field isSetup:Z


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;)V
    .locals 0
    .param p1, "bookmarkUtils"    # Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .line 21
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;)Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    .prologue
    .line 12
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    return-object v0
.end method

.method private setFavoriteMenuState(Z)V
    .locals 2
    .param p1, "checked"    # Z

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setChecked(Z)Landroid/view/MenuItem;

    .line 49
    if-eqz p1, :cond_0

    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_bookmark_entity_pressed:I

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 54
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_bookmark_button:I

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 55
    return-void

    .line 52
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_bookmark_entity:I

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    goto :goto_0
.end method


# virtual methods
.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflator"    # Landroid/view/MenuInflater;

    .prologue
    .line 24
    sget v0, Lcom/xfinity/playerlib/R$menu;->bookmark_menu:I

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 25
    sget v0, Lcom/xfinity/playerlib/R$id;->bookmark_toggle:I

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    .line 28
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->isSetup:Z

    if-eqz v0, :cond_1

    .line 29
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->isChecked:Z

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->setFavoriteMenuState(Z)V

    .line 33
    :cond_0
    :goto_0
    return-void

    .line 30
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)Z
    .locals 4
    .param p1, "item"    # Landroid/view/MenuItem;
    .param p2, "context"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
    .param p3, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 36
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    sget v3, Lcom/xfinity/playerlib/R$id;->bookmark_toggle:I

    if-ne v2, v3, :cond_1

    .line 37
    iget-object v2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    invoke-interface {p1}, Landroid/view/MenuItem;->isChecked()Z

    move-result v3

    invoke-virtual {v2, p3, v3, p2}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->executeAddRemove(Lcom/xfinity/playerlib/model/VideoFavorite;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V

    .line 38
    invoke-interface {p1}, Landroid/view/MenuItem;->isChecked()Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    :cond_0
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->setFavoriteMenuState(Z)V

    .line 41
    :goto_0
    return v1

    :cond_1
    move v1, v0

    goto :goto_0
.end method

.method public setupFavorite(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;ZLandroid/widget/CheckBox;Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 4
    .param p1, "authenticatingFragment"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
    .param p2, "isFullScreen"    # Z
    .param p3, "favoriteIndicator"    # Landroid/widget/CheckBox;
    .param p4, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    const/4 v3, 0x1

    .line 62
    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    invoke-virtual {v1, p4}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->isInFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)Z

    move-result v0

    .line 64
    .local v0, "inFavorite":Z
    if-eqz p2, :cond_1

    .line 65
    const/16 v1, 0x8

    invoke-virtual {p3, v1}, Landroid/widget/CheckBox;->setVisibility(I)V

    .line 67
    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    if-eqz v1, :cond_0

    .line 68
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->setFavoriteMenuState(Z)V

    .line 69
    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->favoriteToggle:Landroid/view/MenuItem;

    invoke-interface {v1, v3}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 72
    :cond_0
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->isChecked:Z

    .line 96
    :goto_0
    iput-boolean v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->isSetup:Z

    .line 97
    return-void

    .line 74
    :cond_1
    const/4 v1, 0x0

    invoke-virtual {p3, v1}, Landroid/widget/CheckBox;->setVisibility(I)V

    .line 76
    invoke-virtual {p3, v0}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 78
    if-eqz v0, :cond_2

    .line 80
    invoke-virtual {p3}, Landroid/widget/CheckBox;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_bookmarked_checkbox_selected:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 78
    :goto_1
    invoke-virtual {p3, v1}, Landroid/widget/CheckBox;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 83
    new-instance v1, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;

    invoke-direct {v1, p0, p4, p3, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;Lcom/xfinity/playerlib/model/VideoFavorite;Landroid/widget/CheckBox;Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V

    invoke-virtual {p3, v1}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 81
    :cond_2
    invoke-virtual {p3}, Landroid/widget/CheckBox;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_bookmarked_checkbox_not_selected:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method
