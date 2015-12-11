.class Lco/vine/android/HomeTabActivity$HomeTabSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "HomeTabActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/HomeTabActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "HomeTabSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/HomeTabActivity;


# direct methods
.method constructor <init>(Lco/vine/android/HomeTabActivity;)V
    .locals 0

    .prologue
    .line 991
    iput-object p1, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAbortAllRequestsComplete()V
    .locals 1

    .prologue
    .line 1061
    invoke-super {p0}, Lco/vine/android/client/AppSessionListener;->onAbortAllRequestsComplete()V

    .line 1062
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->fetchActivityCounts()Ljava/lang/String;

    .line 1063
    return-void
.end method

.method public onGetMessageCountComplete(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 6
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "messagesCount"    # I

    .prologue
    const/4 v5, 0x0

    .line 1018
    const/16 v3, 0xc8

    if-ne p2, v3, :cond_0

    .line 1019
    iget-object v3, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-static {v3}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 1020
    .local v2, "pref":Landroid/content/SharedPreferences;
    const-string v3, "pref_mrumc"

    invoke-interface {v2, v3, v5}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 1021
    .local v1, "mostRecent":I
    const-string v3, "pref_dismissed"

    invoke-interface {v2, v3, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 1023
    .local v0, "dismissed":Z
    if-eqz v0, :cond_1

    .line 1025
    if-eq v1, p4, :cond_0

    .line 1026
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "pref_dismissed"

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1027
    iget-object v3, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    # setter for: Lco/vine/android/HomeTabActivity;->mMessageCount:I
    invoke-static {v3, p4}, Lco/vine/android/HomeTabActivity;->access$102(Lco/vine/android/HomeTabActivity;I)I

    .line 1028
    iget-object v3, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    # invokes: Lco/vine/android/HomeTabActivity;->invalidateMessagesBadge()V
    invoke-static {v3}, Lco/vine/android/HomeTabActivity;->access$200(Lco/vine/android/HomeTabActivity;)V

    .line 1036
    .end local v0    # "dismissed":Z
    .end local v1    # "mostRecent":I
    .end local v2    # "pref":Landroid/content/SharedPreferences;
    :cond_0
    :goto_0
    return-void

    .line 1032
    .restart local v0    # "dismissed":Z
    .restart local v1    # "mostRecent":I
    .restart local v2    # "pref":Landroid/content/SharedPreferences;
    :cond_1
    iget-object v3, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    # setter for: Lco/vine/android/HomeTabActivity;->mMessageCount:I
    invoke-static {v3, p4}, Lco/vine/android/HomeTabActivity;->access$102(Lco/vine/android/HomeTabActivity;I)I

    .line 1033
    iget-object v3, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    # invokes: Lco/vine/android/HomeTabActivity;->invalidateMessagesBadge()V
    invoke-static {v3}, Lco/vine/android/HomeTabActivity;->access$200(Lco/vine/android/HomeTabActivity;)V

    goto :goto_0
.end method

.method public onGetPendingNotificationCountComplete(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I

    .prologue
    .line 1009
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    .line 1010
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    # setter for: Lco/vine/android/HomeTabActivity;->mActivityCount:I
    invoke-static {v0, p4}, Lco/vine/android/HomeTabActivity;->access$002(Lco/vine/android/HomeTabActivity;I)I

    .line 1011
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-virtual {v0}, Lco/vine/android/HomeTabActivity;->invalidateActivityBadge()V

    .line 1013
    :cond_0
    return-void
.end method

.method public onReceiveRTCMessage(Ljava/util/ArrayList;)V
    .locals 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRTCConversation;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1040
    .local p1, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    invoke-virtual/range {p1 .. p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/api/VineRTCConversation;

    .line 1041
    .local v8, "conversation":Lco/vine/android/api/VineRTCConversation;
    iget-object v0, v8, Lco/vine/android/api/VineRTCConversation;->participants:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lco/vine/android/api/VineRTCParticipant;

    .line 1042
    .local v13, "participant":Lco/vine/android/api/VineRTCParticipant;
    iget-wide v11, v13, Lco/vine/android/api/VineRTCParticipant;->lastMessageId:J

    .line 1043
    .local v11, "lastMessageId":J
    const-wide/16 v0, 0x0

    cmp-long v0, v11, v0

    if-lez v0, :cond_1

    .line 1044
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    # getter for: Lco/vine/android/HomeTabActivity;->mLastMessageMap:Landroid/support/v4/util/LongSparseArray;
    invoke-static {v0}, Lco/vine/android/HomeTabActivity;->access$500(Lco/vine/android/HomeTabActivity;)Landroid/support/v4/util/LongSparseArray;

    move-result-object v0

    iget-wide v1, v13, Lco/vine/android/api/VineRTCParticipant;->userId:J

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/Long;

    .line 1045
    .local v14, "participantLast":Ljava/lang/Long;
    if-eqz v14, :cond_2

    invoke-virtual {v14}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    cmp-long v0, v11, v0

    if-lez v0, :cond_2

    .line 1046
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    const/4 v1, 0x1

    const/4 v2, 0x0

    iget-wide v3, v8, Lco/vine/android/api/VineRTCConversation;->conversationId:J

    const-wide/16 v5, 0x0

    const/4 v7, 0x1

    invoke-virtual/range {v0 .. v7}, Lco/vine/android/client/AppController;->fetchConversation(IZJJZ)Ljava/lang/String;

    .line 1048
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-virtual {v0}, Lco/vine/android/HomeTabActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->isMenuShowing()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1049
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->fetchActivityCounts()Ljava/lang/String;

    goto :goto_0

    .line 1052
    :cond_2
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    # getter for: Lco/vine/android/HomeTabActivity;->mLastMessageMap:Landroid/support/v4/util/LongSparseArray;
    invoke-static {v0}, Lco/vine/android/HomeTabActivity;->access$500(Lco/vine/android/HomeTabActivity;)Landroid/support/v4/util/LongSparseArray;

    move-result-object v0

    iget-wide v1, v13, Lco/vine/android/api/VineRTCParticipant;->userId:J

    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    goto :goto_0

    .line 1057
    .end local v8    # "conversation":Lco/vine/android/api/VineRTCConversation;
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v11    # "lastMessageId":J
    .end local v13    # "participant":Lco/vine/android/api/VineRTCParticipant;
    .end local v14    # "participantLast":Ljava/lang/Long;
    :cond_3
    return-void
.end method

.method public onVerifyEmailComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 995
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_0

    .line 996
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    const-class v2, Lco/vine/android/SettingsActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 997
    .local v0, "intent":Landroid/content/Intent;
    sget-object v1, Lco/vine/android/HomeTabActivity;->ACTION_VERIFICATION_COMPLETE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 998
    iget-object v1, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lco/vine/android/HomeTabActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1003
    .end local v0    # "intent":Landroid/content/Intent;
    .end local p3    # "reasonPhrase":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-virtual {v1}, Lco/vine/android/HomeTabActivity;->dismissDialog()V

    .line 1004
    return-void

    .line 1000
    .restart local p3    # "reasonPhrase":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-virtual {v1}, Lco/vine/android/HomeTabActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    if-eqz p3, :cond_1

    .end local p3    # "reasonPhrase":Ljava/lang/String;
    :goto_1
    invoke-static {v1, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .restart local p3    # "reasonPhrase":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;->this$0:Lco/vine/android/HomeTabActivity;

    const v3, 0x7f0e0105

    invoke-virtual {v2, v3}, Lco/vine/android/HomeTabActivity;->getString(I)Ljava/lang/String;

    move-result-object p3

    goto :goto_1
.end method
