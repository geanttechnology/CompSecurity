.class public Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;
.super Landroid/app/AlertDialog$Builder;
.source "SourceFile"


# instance fields
.field private ctx:Landroid/content/Context;

.field private currentPlaylistId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 22
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;

    .line 23
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->currentPlaylistId:Ljava/lang/String;

    .line 24
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->getContent()V

    .line 25
    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$100(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->currentPlaylistId:Ljava/lang/String;

    return-object v0
.end method

.method private getContent()V
    .locals 4

    .prologue
    .line 29
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 30
    const v1, 0x7f030026

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 31
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 32
    const v1, 0x7f070062

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 33
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v1

    .line 34
    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 35
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setSelection(I)V

    .line 37
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080064

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 38
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08007e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;

    invoke-direct {v3, p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$1;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;Landroid/widget/EditText;Ljava/lang/String;)V

    invoke-virtual {p0, v2, v3}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 68
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080063

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog$2;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 74
    return-void
.end method
