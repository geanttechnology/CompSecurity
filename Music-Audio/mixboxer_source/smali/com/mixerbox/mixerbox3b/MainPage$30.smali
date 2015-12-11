.class Lcom/mixerbox/mixerbox3b/MainPage$30;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/media/AudioManager$OnAudioFocusChangeListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1743
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$30;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAudioFocusChange(I)V
    .locals 2

    .prologue
    .line 1745
    const/4 v0, -0x2

    if-eq p1, v0, :cond_0

    .line 1747
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    .line 1749
    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 1751
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$30;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->am:Landroid/media/AudioManager;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$30;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->abandonAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;)I

    .line 1754
    :cond_0
    return-void
.end method
