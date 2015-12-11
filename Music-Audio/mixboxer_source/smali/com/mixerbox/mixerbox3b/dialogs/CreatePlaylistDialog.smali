.class public Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;
.super Landroid/app/AlertDialog$Builder;
.source "SourceFile"


# instance fields
.field private ctx:Landroid/content/Context;

.field name:Ljava/lang/String;

.field type:I


# direct methods
.method public constructor <init>(Landroid/content/Context;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 26
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;

    .line 27
    iput p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->type:I

    .line 28
    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->name:Ljava/lang/String;

    .line 29
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->getContent()V

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method private getContent()V
    .locals 3

    .prologue
    .line 34
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 35
    const v1, 0x7f030026

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 36
    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 37
    const v0, 0x7f070062

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 38
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->name:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 39
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->name:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setSelection(I)V

    .line 41
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080067

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 42
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f08007e

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;

    invoke-direct {v2, p0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;Landroid/view/View;)V

    invoke-virtual {p0, v0, v2}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 85
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080063

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$2;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 91
    return-void
.end method
