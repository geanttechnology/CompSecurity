.class public Lcom/xfinity/playerlib/view/PlayNowActivity$PlayNowActivitySpeechListener;
.super Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;
.source "PlayNowActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/PlayNowActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "PlayNowActivitySpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/PlayNowActivity;


# direct methods
.method protected constructor <init>(Lcom/xfinity/playerlib/view/PlayNowActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/PlayNowActivity;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/xfinity/playerlib/view/PlayNowActivity$PlayNowActivitySpeechListener;->this$0:Lcom/xfinity/playerlib/view/PlayNowActivity;

    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;-><init>(Lcom/comcast/cim/android/view/common/BaseActivity;)V

    return-void
.end method


# virtual methods
.method public onSpeechResponseSearch([Ljava/lang/String;)Z
    .locals 2
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/xfinity/playerlib/view/PlayNowActivity$PlayNowActivitySpeechListener;->this$0:Lcom/xfinity/playerlib/view/PlayNowActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/PlayNowActivity;->getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    move-result-object v0

    const-class v1, Lcom/xfinity/playerlib/view/search/SearchActivity;

    invoke-virtual {v0, v1, p1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->startSearch(Ljava/lang/Class;[Ljava/lang/String;)V

    .line 68
    const/4 v0, 0x0

    return v0
.end method
