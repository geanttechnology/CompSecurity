.class Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "FeaturedSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Option",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public execute()Lcom/comcast/cim/cmasl/utils/container/Option;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iget-object v3, v3, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v3}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v2

    .line 40
    .local v2, "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iget-object v3, v3, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v3}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v1

    .line 43
    .local v1, "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-eqz v2, :cond_1

    if-eqz v1, :cond_0

    .line 44
    invoke-virtual {v2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v3

    if-lez v3, :cond_1

    .line 45
    :cond_0
    move-object v0, v2

    .line 51
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :goto_0
    new-instance v3, Lcom/comcast/cim/cmasl/utils/container/Option;

    invoke-direct {v3, v0}, Lcom/comcast/cim/cmasl/utils/container/Option;-><init>(Ljava/lang/Object;)V

    return-object v3

    .line 48
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_1
    move-object v0, v1

    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    goto :goto_0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 36
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$1;->execute()Lcom/comcast/cim/cmasl/utils/container/Option;

    move-result-object v0

    return-object v0
.end method
