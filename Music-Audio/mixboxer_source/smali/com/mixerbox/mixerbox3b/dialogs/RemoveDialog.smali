.class public Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;
.super Landroid/app/AlertDialog$Builder;
.source "SourceFile"


# instance fields
.field private ctx:Landroid/content/Context;

.field private dialogType:I

.field order:I

.field playlistId:Ljava/lang/String;

.field song:Lcom/mixerbox/mixerbox3b/classes/SongItem;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILjava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;I)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 28
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    .line 29
    iput p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->dialogType:I

    .line 30
    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->playlistId:Ljava/lang/String;

    .line 31
    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 32
    iput p5, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->order:I

    .line 33
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->getContent()V

    .line 34
    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->dialogType:I

    return v0
.end method

.method static synthetic access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method private getContent()V
    .locals 4

    .prologue
    .line 38
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 39
    const v1, 0x7f03002b

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 40
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 41
    const v1, 0x7f070063

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 43
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v1, :cond_0

    .line 44
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080056

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 50
    :goto_0
    iget v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->dialogType:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 51
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080053

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 55
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08007e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 97
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080063

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$2;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 103
    return-void

    .line 47
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080054

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 53
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080055

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    goto :goto_1
.end method
