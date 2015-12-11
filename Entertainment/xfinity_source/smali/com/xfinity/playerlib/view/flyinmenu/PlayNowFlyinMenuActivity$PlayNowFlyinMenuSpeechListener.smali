.class public Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$PlayNowFlyinMenuSpeechListener;
.super Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;
.source "PlayNowFlyinMenuActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "PlayNowFlyinMenuSpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;


# direct methods
.method protected constructor <init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 414
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$PlayNowFlyinMenuSpeechListener;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;-><init>(Lcom/comcast/cim/android/view/common/BaseActivity;)V

    return-void
.end method


# virtual methods
.method public onSpeechResponseSearch([Ljava/lang/String;)Z
    .locals 2
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 418
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$PlayNowFlyinMenuSpeechListener;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    move-result-object v0

    const-class v1, Lcom/xfinity/playerlib/view/search/SearchActivity;

    invoke-virtual {v0, v1, p1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->startSearch(Ljava/lang/Class;[Ljava/lang/String;)V

    .line 419
    const/4 v0, 0x0

    return v0
.end method
