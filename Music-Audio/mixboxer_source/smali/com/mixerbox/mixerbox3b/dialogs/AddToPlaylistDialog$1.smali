.class Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

.field final synthetic val$etName:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$1;->val$etName:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 55
    return-void
.end method
