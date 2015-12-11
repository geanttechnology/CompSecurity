.class Lcom/mixerbox/mixerbox3b/MainPage$10;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$windowManager:Landroid/view/WindowManager;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/view/WindowManager;)V
    .locals 0

    .prologue
    .line 1005
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->val$windowManager:Landroid/view/WindowManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const-wide/16 v3, 0xfa0

    const/4 v2, 0x1

    .line 1008
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    if-ne v0, v2, :cond_2

    .line 1009
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putOnboardingFinish(Landroid/content/Context;Z)V

    .line 1040
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->isShown()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1041
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->val$windowManager:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeView(Landroid/view/View;)V

    .line 1042
    :cond_1
    return-void

    .line 1010
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_3

    .line 1011
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstNewsfeed(Landroid/content/Context;Z)V

    goto :goto_0

    .line 1012
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_4

    .line 1013
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstDiscover(Landroid/content/Context;Z)V

    goto :goto_0

    .line 1014
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_5

    .line 1015
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipSecondPlaylist(Landroid/content/Context;Z)V

    goto :goto_0

    .line 1016
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v1, 0x5

    if-ne v0, v1, :cond_6

    .line 1017
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstEmptyPlaylist(Landroid/content/Context;Z)V

    goto :goto_0

    .line 1018
    :cond_6
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v1, 0x6

    if-ne v0, v1, :cond_7

    .line 1019
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstOthersPlaylist(Landroid/content/Context;Z)V

    goto :goto_0

    .line 1020
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v1, 0x7

    if-ne v0, v1, :cond_8

    .line 1021
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstSubscribe(Landroid/content/Context;Z)V

    goto :goto_0

    .line 1022
    :cond_8
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v1, 0x8

    if-ne v0, v1, :cond_9

    .line 1023
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstAddMusic(Landroid/content/Context;Z)V

    goto/16 :goto_0

    .line 1024
    :cond_9
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v1, 0x9

    if-ne v0, v1, :cond_a

    .line 1025
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstNonEmptyPlaylist(Landroid/content/Context;Z)V

    goto/16 :goto_0

    .line 1026
    :cond_a
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v1, 0xa

    if-ne v0, v1, :cond_b

    .line 1027
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstSearch(Landroid/content/Context;Z)V

    goto/16 :goto_0

    .line 1028
    :cond_b
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v1, 0xb

    if-ne v0, v1, :cond_c

    .line 1029
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstArtist(Landroid/content/Context;Z)V

    goto/16 :goto_0

    .line 1030
    :cond_c
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v1, 0xc

    if-ne v0, v1, :cond_d

    .line 1031
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstPlay(Landroid/content/Context;Z)V

    .line 1032
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    invoke-virtual {v0, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_0

    .line 1033
    :cond_d
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v1, 0xd

    if-ne v0, v1, :cond_e

    .line 1034
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipSecondPlay(Landroid/content/Context;)V

    .line 1035
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    invoke-virtual {v0, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_0

    .line 1036
    :cond_e
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v1, 0xe

    if-ne v0, v1, :cond_0

    .line 1037
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipThirdPlay(Landroid/content/Context;Z)V

    .line 1038
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$10;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    invoke-virtual {v0, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_0
.end method
