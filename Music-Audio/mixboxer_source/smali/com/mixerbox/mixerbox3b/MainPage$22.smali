.class Lcom/mixerbox/mixerbox3b/MainPage$22;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1418
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$22;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 1421
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$22;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$22;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V

    .line 1422
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->show()Landroid/app/AlertDialog;

    move-result-object v0

    .line 1423
    invoke-virtual {v0}, Landroid/app/AlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 1424
    return-void
.end method
