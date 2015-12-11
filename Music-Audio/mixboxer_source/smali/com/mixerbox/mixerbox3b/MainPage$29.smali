.class Lcom/mixerbox/mixerbox3b/MainPage$29;
.super Landroid/telephony/PhoneStateListener;
.source "SourceFile"


# instance fields
.field protected mWasPlayingWhenCalled:Z

.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 1

    .prologue
    .line 1656
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Landroid/telephony/PhoneStateListener;-><init>()V

    .line 1657
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->mWasPlayingWhenCalled:Z

    return-void
.end method


# virtual methods
.method public onCallStateChanged(ILjava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 1661
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 1680
    :goto_0
    return-void

    .line 1663
    :cond_0
    if-ne p1, v3, :cond_3

    .line 1664
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-eq v0, v3, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    .line 1665
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1666
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200ef

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1667
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->mWasPlayingWhenCalled:Z

    .line 1676
    :cond_2
    :goto_1
    invoke-super {p0, p1, p2}, Landroid/telephony/PhoneStateListener;->onCallStateChanged(ILjava/lang/String;)V

    goto :goto_0

    .line 1669
    :cond_3
    if-nez p1, :cond_2

    .line 1670
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->mWasPlayingWhenCalled:Z

    if-eqz v0, :cond_2

    .line 1671
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200ed

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1672
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v3, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 1673
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->mWasPlayingWhenCalled:Z

    .line 1674
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$29;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:playVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_1
.end method
