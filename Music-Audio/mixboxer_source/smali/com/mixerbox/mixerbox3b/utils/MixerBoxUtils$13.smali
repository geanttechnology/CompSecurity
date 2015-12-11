.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$f:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

.field final synthetic val$hasToGoBack:Z

.field final synthetic val$playIndex:I

.field final synthetic val$type:I


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Context;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    .locals 0

    .prologue
    .line 729
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$ctx:Landroid/content/Context;

    iput-boolean p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$hasToGoBack:Z

    iput p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$type:I

    iput p5, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$playIndex:I

    iput-object p6, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$f:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 732
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 733
    new-instance v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$ctx:Landroid/content/Context;

    iget-boolean v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$hasToGoBack:Z

    iget v3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$type:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$playIndex:I

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;->val$f:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-direct/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;-><init>(Landroid/content/Context;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    .line 734
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 735
    return-void
.end method
