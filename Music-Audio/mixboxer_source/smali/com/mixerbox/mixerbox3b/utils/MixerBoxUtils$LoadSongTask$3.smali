.class Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$3;
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
    .line 815
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$3;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 818
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$3;->this$0:Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    .line 819
    return-void
.end method
