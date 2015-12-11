.class Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

.field final synthetic val$radioGroup:Landroid/widget/RadioGroup;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;Landroid/widget/RadioGroup;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$3;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$3;->val$radioGroup:Landroid/widget/RadioGroup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 120
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 122
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2

    .prologue
    .line 125
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$3;->val$radioGroup:Landroid/widget/RadioGroup;

    const v1, 0x7f070061

    invoke-virtual {v0, v1}, Landroid/widget/RadioGroup;->check(I)V

    .line 126
    return-void
.end method
