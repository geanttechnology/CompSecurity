.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;
.super Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SearchResultsFragmentSpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V
    .locals 0

    .prologue
    .line 935
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;

    .prologue
    .line 935
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    return-void
.end method


# virtual methods
.method public onSpeechResponseClear()Z
    .locals 4

    .prologue
    .line 972
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_search_cleared:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 973
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    new-instance v1, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;-><init>(Landroid/content/Context;)V

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2602(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;)Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    .line 974
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->clearSearchQuery()V

    .line 975
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    const-string v3, ""

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/lang/String;)V

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 976
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponseLess()Z
    .locals 2

    .prologue
    .line 954
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->getLessResults()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 955
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponseMore()Z
    .locals 2

    .prologue
    .line 960
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->getMoreResults()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 961
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponseRepeat()Z
    .locals 2

    .prologue
    .line 966
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->speakResults()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 967
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponseSearch([Ljava/lang/String;)Z
    .locals 7
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 940
    if-eqz p1, :cond_0

    array-length v1, p1

    if-nez v1, :cond_1

    .line 941
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->speech_search_instructions:I

    invoke-interface {v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(I)V

    .line 942
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->ignoreSearchOnResume:Z
    invoke-static {v1, v6}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2902(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Z)Z

    .line 949
    :goto_0
    return v6

    .line 945
    :cond_1
    const-string v1, " "

    invoke-static {p1, v1}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 946
    .local v0, "searchTermsString":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {v2, v3, v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/lang/String;)V

    const-wide/16 v4, 0xc8

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method
