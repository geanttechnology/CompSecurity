.class Lcom/mixerbox/mixerbox3b/MainPage$15;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1242
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$15;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 1

    .prologue
    .line 1245
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$15;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->playNextSong()V

    .line 1246
    return-void
.end method
