.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SpeakResultsRunnable"
.end annotation


# instance fields
.field final results:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 910
    .local p2, "results":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 911
    iput-object p2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;->results:Ljava/util/List;

    .line 912
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 916
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    new-instance v1, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/cmasl/utils/provider/Provider;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;->results:Ljava/util/List;

    invoke-direct {v1, v2, v3, v4}, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/util/List;)V

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2602(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;)Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    .line 917
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$2600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->speakResults()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 918
    return-void
.end method
