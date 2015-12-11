.class public Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;
.super Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;
.source "SeriesEpisodeListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "SeriesEpisodeListSpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;


# direct methods
.method protected constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 574
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-direct {p0}, Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onSpeechResponseLess()Z
    .locals 2

    .prologue
    .line 578
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->playNowEpisodeListTalkHelper:Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1800(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->getLessResults()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 579
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponseMore()Z
    .locals 3

    .prologue
    .line 584
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getPlayNowEpisodeListTalkHelper(Landroid/content/Context;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1900(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Landroid/content/Context;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->getMoreResults()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 585
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponseOpen([Ljava/lang/String;)Z
    .locals 2
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 602
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListOnLoad:Z
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$2002(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Z)Z

    .line 603
    return v1
.end method

.method public onSpeechResponsePlay([Ljava/lang/String;)Z
    .locals 2
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 596
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListOnLoad:Z
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$2002(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Z)Z

    .line 597
    return v1
.end method

.method public onSpeechResponseRepeat()Z
    .locals 3

    .prologue
    .line 590
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getPlayNowEpisodeListTalkHelper(Landroid/content/Context;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1900(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Landroid/content/Context;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->speakResults()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 591
    const/4 v0, 0x1

    return v0
.end method
