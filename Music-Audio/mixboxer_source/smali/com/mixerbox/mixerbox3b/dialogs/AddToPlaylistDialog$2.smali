.class Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

.field final synthetic val$etName:Landroid/widget/EditText;

.field final synthetic val$iv:Landroid/widget/ImageView;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;Landroid/widget/EditText;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;->val$etName:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;->val$iv:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 105
    if-eqz p2, :cond_0

    .line 107
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setVisibility(I)V

    .line 108
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;->val$iv:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 109
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 115
    :goto_0
    return-void

    .line 112
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setVisibility(I)V

    .line 113
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$2;->val$iv:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method
