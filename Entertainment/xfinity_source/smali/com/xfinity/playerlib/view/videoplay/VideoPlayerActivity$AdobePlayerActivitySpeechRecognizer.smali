.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$AdobePlayerActivitySpeechRecognizer;
.super Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;
.source "VideoPlayerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AdobePlayerActivitySpeechRecognizer"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)V
    .locals 0

    .prologue
    .line 345
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$AdobePlayerActivitySpeechRecognizer;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;-><init>(Lcom/comcast/cim/android/view/common/BaseActivity;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;

    .prologue
    .line 345
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$AdobePlayerActivitySpeechRecognizer;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)V

    return-void
.end method


# virtual methods
.method public onSpeechResponseSearch([Ljava/lang/String;)Z
    .locals 2
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 349
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$AdobePlayerActivitySpeechRecognizer;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    move-result-object v0

    const-class v1, Lcom/xfinity/playerlib/view/search/SearchActivity;

    invoke-virtual {v0, v1, p1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->startSearch(Ljava/lang/Class;[Ljava/lang/String;)V

    .line 350
    const/4 v0, 0x0

    return v0
.end method
