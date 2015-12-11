.class Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f0800e8

    const v2, 0x7f0800e7

    .line 229
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 231
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    .line 232
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 256
    :cond_0
    :goto_0
    return-void

    .line 234
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 236
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_2

    .line 237
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    .line 243
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 239
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deletePlaylist(Ljava/lang/String;)I

    .line 240
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 241
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto :goto_1

    .line 245
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080097

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 246
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    const/16 v1, 0x3e7

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/Menu;->findItem(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    .line 247
    if-eqz v0, :cond_4

    .line 248
    invoke-interface {v0}, Lcom/actionbarsherlock/view/MenuItem;->expandActionView()Z

    .line 249
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putDefaultAddedPlaylist(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstAddMusic(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 252
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/16 v1, 0x8

    const/4 v2, 0x0

    new-array v2, v2, [Z

    invoke-virtual {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    goto/16 :goto_0
.end method
