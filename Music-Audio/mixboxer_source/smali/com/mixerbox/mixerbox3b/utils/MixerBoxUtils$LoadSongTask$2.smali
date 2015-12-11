.class Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;)V
    .locals 0

    .prologue
    .line 798
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$2;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 801
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$2;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->frag:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->loadContent()V

    .line 802
    return-void
.end method
