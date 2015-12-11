.class Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;
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
    .line 270
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    .line 274
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/4 v1, 0x5

    if-ne v0, v1, :cond_0

    .line 276
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;-><init>(Landroid/content/Context;I)V

    .line 277
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->show()Landroid/app/AlertDialog;

    .line 298
    :goto_0
    return-void

    .line 283
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v0

    .line 284
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    .line 286
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 287
    const-string v3, "id"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 288
    const-string v3, "action:share_playlist"

    invoke-static {v3, v2}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 289
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "http://www.mixerbox.com/list/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 290
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800ba

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800b8

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 291
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800b9

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 292
    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.intent.action.SEND"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 293
    const-string v5, "text/plain"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 294
    const-string v5, "android.intent.extra.SUBJECT"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 295
    const-string v5, "android.intent.extra.TEXT"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 296
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    const/4 v1, 0x0

    invoke-static {v4, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0
.end method
