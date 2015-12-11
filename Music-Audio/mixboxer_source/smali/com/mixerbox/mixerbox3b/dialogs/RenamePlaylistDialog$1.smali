.class Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

.field final synthetic val$etName:Landroid/widget/EditText;

.field final synthetic val$strOri:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;Landroid/widget/EditText;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->val$etName:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->val$strOri:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 42
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_2

    .line 43
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08006d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 44
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->currentPlaylistId:Ljava/lang/String;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 45
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->show()Landroid/app/AlertDialog;

    .line 65
    :cond_1
    :goto_0
    return-void

    .line 49
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->val$strOri:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 51
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_3

    .line 52
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->currentPlaylistId:Ljava/lang/String;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->renamePlaylist(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 54
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 55
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->currentPlaylistId:Ljava/lang/String;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->updateMyPlaylist(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "SongFragment"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 57
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->currentPlaylistId:Ljava/lang/String;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 62
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0
.end method
