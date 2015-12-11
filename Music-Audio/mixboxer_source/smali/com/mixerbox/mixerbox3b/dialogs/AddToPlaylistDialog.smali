.class public Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;
.super Landroid/app/AlertDialog$Builder;
.source "SourceFile"


# instance fields
.field arrayMyPlaylists:Ljava/util/ArrayList;

.field private ctx:Landroid/content/Context;

.field song:Lcom/mixerbox/mixerbox3b/classes/SongItem;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 38
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    .line 39
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 40
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->getContent()V

    .line 41
    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method private getContent()V
    .locals 13

    .prologue
    const v12, 0x7f070061

    const/4 v5, 0x2

    const/4 v11, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 45
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v9

    .line 46
    const v0, 0x7f030025

    invoke-virtual {v9, v0, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v10

    .line 47
    invoke-virtual {p0, v10}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 48
    const v0, 0x7f070062

    invoke-virtual {v10, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 49
    const v1, 0x7f070060

    invoke-virtual {v10, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RadioGroup;

    .line 50
    const v2, 0x7f07004a

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 51
    new-instance v3, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$1;

    invoke-direct {v3, p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$1;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;Landroid/widget/EditText;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 58
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 59
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 60
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->setSelection(I)V

    .line 63
    :cond_0
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    check-cast v3, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    check-cast v3, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_2

    .line 64
    new-instance v4, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    check-cast v3, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-direct {v4, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v4, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    .line 65
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v3

    const-string v4, "PLAYLISTHISTORYID"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 66
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 73
    :cond_1
    :goto_0
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    if-eqz v3, :cond_4

    .line 75
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    move v8, v3

    move v3, v7

    :goto_1
    if-ltz v8, :cond_5

    .line 76
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v3, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v3

    const-string v4, "-999"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move v3, v5

    .line 75
    :goto_2
    add-int/lit8 v4, v8, -0x1

    move v8, v4

    goto :goto_1

    .line 69
    :cond_2
    iput-object v11, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    goto :goto_0

    .line 81
    :cond_3
    const v3, 0x7f030054

    invoke-virtual {v9, v3, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    .line 82
    invoke-virtual {v3, v8}, Landroid/widget/RadioButton;->setId(I)V

    .line 83
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V

    .line 84
    invoke-virtual {v1, v3, v7}, Landroid/widget/RadioGroup;->addView(Landroid/view/View;I)V

    move v3, v6

    .line 85
    goto :goto_2

    :cond_4
    move v3, v7

    .line 89
    :cond_5
    if-ne v3, v6, :cond_6

    .line 90
    invoke-virtual {v1, v7}, Landroid/widget/RadioGroup;->check(I)V

    .line 101
    :goto_3
    invoke-virtual {v10, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    .line 102
    new-instance v4, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;

    invoke-direct {v4, p0, v0, v2}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;Landroid/widget/EditText;Landroid/widget/ImageView;)V

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 118
    new-instance v2, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$3;

    invoke-direct {v2, p0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$3;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;Landroid/widget/RadioGroup;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 129
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080060

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 130
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08007e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;

    invoke-direct {v3, p0, v1, v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;Landroid/widget/RadioGroup;Landroid/widget/EditText;)V

    invoke-virtual {p0, v2, v3}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 180
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080063

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$5;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$5;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 186
    return-void

    .line 91
    :cond_6
    if-ne v3, v5, :cond_7

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-le v3, v6, :cond_7

    .line 92
    invoke-virtual {v1, v6}, Landroid/widget/RadioGroup;->check(I)V

    goto :goto_3

    .line 95
    :cond_7
    invoke-virtual {v1, v12}, Landroid/widget/RadioGroup;->check(I)V

    .line 96
    invoke-virtual {v0, v7}, Landroid/widget/EditText;->setVisibility(I)V

    .line 97
    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 98
    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    goto :goto_3
.end method
