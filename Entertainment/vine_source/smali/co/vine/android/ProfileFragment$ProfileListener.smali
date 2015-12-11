.class Lco/vine/android/ProfileFragment$ProfileListener;
.super Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;
.source "ProfileFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ProfileFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ProfileListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ProfileFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ProfileFragment;)V
    .locals 0

    .prologue
    .line 796
    iput-object p1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-direct {p0, p1}, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;-><init>(Lco/vine/android/BaseTimelineFragment;)V

    return-void
.end method

.method private isUsernameValid()Z
    .locals 1

    .prologue
    .line 1078
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v0}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v0}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v0

    iget-object v0, v0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public onAbortAllRequestsComplete()V
    .locals 1

    .prologue
    .line 800
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v0}, Lco/vine/android/ProfileFragment;->refresh()V

    .line 801
    return-void
.end method

.method public onBlockUserComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 8
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userBlocked"    # Z

    .prologue
    const v3, 0x7f0e0265

    const/4 v4, 0x1

    .line 980
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_2

    .line 981
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # setter for: Lco/vine/android/ProfileFragment;->mIsUserBlocked:Z
    invoke-static {v1, p4}, Lco/vine/android/ProfileFragment;->access$1102(Lco/vine/android/ProfileFragment;Z)Z

    .line 982
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->supportInvalidateOptionsMenu()V

    .line 984
    if-eqz p4, :cond_1

    .line 985
    invoke-direct {p0}, Lco/vine/android/ProfileFragment$ProfileListener;->isUsernameValid()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v1

    iget-object v6, v1, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    .line 987
    .local v6, "username":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v3, 0x7f0e0264

    new-array v5, v4, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v6, v5, v7

    invoke-virtual {v2, v3, v5}, Lco/vine/android/ProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    .line 989
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v0

    .line 990
    .local v0, "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUserId:J
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$1000(Lco/vine/android/ProfileFragment;)J

    move-result-wide v1

    const/4 v3, 0x2

    sget-object v5, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FOLLOWERS:Landroid/net/Uri;

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/provider/VineDatabaseHelper;->removeUserWithType(JIZLandroid/net/Uri;)Z

    .line 998
    .end local v0    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .end local v6    # "username":Ljava/lang/String;
    :goto_1
    return-void

    .line 985
    :cond_0
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v2, 0x7f0e026d

    invoke-virtual {v1, v2}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 993
    :cond_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1

    .line 996
    :cond_2
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onDeletePostComplete(Ljava/lang/String;JILjava/lang/String;)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "postId"    # J
    .param p4, "statusCode"    # I
    .param p5, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 1083
    invoke-super/range {p0 .. p5}, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->onDeletePostComplete(Ljava/lang/String;JILjava/lang/String;)V

    .line 1084
    const/16 v0, 0xc8

    if-ne p4, v0, :cond_1

    .line 1085
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, v0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    if-eqz v0, :cond_0

    .line 1086
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, v0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    check-cast v0, Lco/vine/android/widget/FeedAdapter;

    invoke-virtual {v0, p2, p3}, Lco/vine/android/widget/FeedAdapter;->removePost(J)V

    .line 1088
    :cond_0
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;
    invoke-static {v0}, Lco/vine/android/ProfileFragment;->access$200(Lco/vine/android/ProfileFragment;)Lco/vine/android/widget/SectionAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/widget/SectionAdapter;->notifyDataSetChanged()V

    .line 1089
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # invokes: Lco/vine/android/ProfileFragment;->bindProfileDataAndCounts()V
    invoke-static {v0}, Lco/vine/android/ProfileFragment;->access$1200(Lco/vine/android/ProfileFragment;)V

    .line 1091
    :cond_1
    return-void
.end method

.method public onDisableUserRepostsComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 6
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "success"    # Z

    .prologue
    const v5, 0x7f0e01aa

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1046
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/ProfileFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1047
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_4

    .line 1048
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1049
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v4

    if-eqz p4, :cond_1

    move v1, v2

    :goto_0
    iput v1, v4, Lco/vine/android/api/VineUser;->repostsEnabled:I

    .line 1050
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->supportInvalidateOptionsMenu()V

    .line 1052
    if-eqz p4, :cond_3

    .line 1053
    invoke-direct {p0}, Lco/vine/android/ProfileFragment$ProfileListener;->isUsernameValid()Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v1

    iget-object v0, v1, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    .line 1055
    .local v0, "username":Ljava/lang/String;
    :goto_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v4, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v5, 0x7f0e01a9

    new-array v3, v3, [Ljava/lang/Object;

    aput-object v0, v3, v2

    invoke-virtual {v4, v5, v3}, Lco/vine/android/ProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    .line 1064
    .end local v0    # "username":Ljava/lang/String;
    :cond_0
    :goto_2
    return-void

    :cond_1
    move v1, v3

    .line 1049
    goto :goto_0

    .line 1053
    :cond_2
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v4, 0x7f0e026e

    invoke-virtual {v1, v4}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1057
    :cond_3
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, v5}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2

    .line 1061
    :cond_4
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, v5}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2
.end method

.method public onEnableUserRepostsComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 6
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "success"    # Z

    .prologue
    const v5, 0x7f0e01ac

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 1023
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/ProfileFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1024
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_4

    .line 1025
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1026
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v4

    if-eqz p4, :cond_1

    move v1, v2

    :goto_0
    iput v1, v4, Lco/vine/android/api/VineUser;->repostsEnabled:I

    .line 1027
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->supportInvalidateOptionsMenu()V

    .line 1029
    if-eqz p4, :cond_3

    .line 1030
    invoke-direct {p0}, Lco/vine/android/ProfileFragment$ProfileListener;->isUsernameValid()Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v1

    iget-object v0, v1, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    .line 1032
    .local v0, "username":Ljava/lang/String;
    :goto_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v4, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v5, 0x7f0e01ab

    new-array v2, v2, [Ljava/lang/Object;

    aput-object v0, v2, v3

    invoke-virtual {v4, v5, v2}, Lco/vine/android/ProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    .line 1041
    .end local v0    # "username":Ljava/lang/String;
    :cond_0
    :goto_2
    return-void

    :cond_1
    move v1, v3

    .line 1026
    goto :goto_0

    .line 1030
    :cond_2
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v4, 0x7f0e026e

    invoke-virtual {v1, v4}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1034
    :cond_3
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, v5}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2

    .line 1038
    :cond_4
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, v5}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2
.end method

.method public onGetBlockedUsersComplete(Ljava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;)V
    .locals 7
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 955
    .local p4, "blockedUsers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    const/16 v3, 0xc8

    if-ne p2, v3, :cond_2

    .line 956
    invoke-virtual {p4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineUser;

    .line 957
    .local v2, "user":Lco/vine/android/api/VineUser;
    iget-wide v3, v2, Lco/vine/android/api/VineUser;->userId:J

    iget-object v5, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUserId:J
    invoke-static {v5}, Lco/vine/android/ProfileFragment;->access$1000(Lco/vine/android/ProfileFragment;)J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_0

    .line 958
    iget-object v3, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const/4 v4, 0x1

    # setter for: Lco/vine/android/ProfileFragment;->mIsUserBlocked:Z
    invoke-static {v3, v4}, Lco/vine/android/ProfileFragment;->access$1102(Lco/vine/android/ProfileFragment;Z)Z

    .line 962
    .end local v2    # "user":Lco/vine/android/api/VineUser;
    :cond_1
    iget-object v3, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v3}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 963
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_2

    .line 964
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->supportInvalidateOptionsMenu()V

    .line 967
    .end local v0    # "activity":Landroid/support/v4/app/FragmentActivity;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    return-void
.end method

.method public onGetConversationRowIdComplete(JJLjava/lang/String;Z)V
    .locals 9
    .param p1, "recipientId"    # J
    .param p3, "conversationObjectId"    # J
    .param p5, "username"    # Ljava/lang/String;
    .param p6, "amFollowing"    # Z

    .prologue
    .line 806
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mWaitingToStartUserId:J
    invoke-static {v0}, Lco/vine/android/ProfileFragment;->access$100(Lco/vine/android/ProfileFragment;)J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    .line 807
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const-wide/16 v1, -0x1

    # setter for: Lco/vine/android/ProfileFragment;->mWaitingToStartUserId:J
    invoke-static {v0, v1, v2}, Lco/vine/android/ProfileFragment;->access$102(Lco/vine/android/ProfileFragment;J)J

    .line 808
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, v0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0, p3, p4}, Lco/vine/android/client/AppController;->clearUnreadMessageCount(J)V

    .line 809
    iget-object v8, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v7, 0x1

    move-wide v1, p3

    move-object v3, p5

    move-wide v4, p1

    move v6, p6

    invoke-static/range {v0 .. v7}, Lco/vine/android/ConversationActivity;->getIntent(Landroid/content/Context;JLjava/lang/String;JZZ)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v8, v0}, Lco/vine/android/ProfileFragment;->startActivity(Landroid/content/Intent;)V

    .line 812
    :cond_0
    return-void
.end method

.method public onGetTimeLineComplete(Ljava/lang/String;ILjava/lang/String;IIZLjava/util/ArrayList;Ljava/lang/String;IIIJZILjava/lang/String;)V
    .locals 14
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "type"    # I
    .param p5, "count"    # I
    .param p6, "memory"    # Z
    .param p8, "tag"    # Ljava/lang/String;
    .param p9, "pageType"    # I
    .param p10, "next"    # I
    .param p11, "previous"    # I
    .param p12, "anchor"    # J
    .param p14, "userInitiated"    # Z
    .param p15, "size"    # I
    .param p16, "title"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "IIZ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;",
            "Ljava/lang/String;",
            "IIIJZI",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 820
    .local p7, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, p1}, Lco/vine/android/ProfileFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v12

    .line 821
    .local v12, "req":Lco/vine/android/PendingRequest;
    if-eqz v12, :cond_4

    .line 822
    const/16 v2, 0xc8

    move/from16 v0, p2

    if-ne v0, v2, :cond_1

    .line 823
    const/4 v13, 0x0

    .line 824
    .local v13, "tab":I
    const/4 v2, 0x3

    move/from16 v0, p4

    if-ne v0, v2, :cond_0

    .line 825
    const/4 v13, 0x1

    .line 827
    :cond_0
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, v2, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    move/from16 v0, p15

    invoke-virtual {v2, v0, v13}, Lco/vine/android/ProfileHeaderAdapter;->updatePostCount(II)V

    .line 828
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, v2, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    invoke-virtual {v2}, Lco/vine/android/ProfileHeaderAdapter;->notifyDataSetChanged()V

    .line 831
    .end local v13    # "tab":I
    :cond_1
    if-eqz p6, :cond_3

    const/16 v2, 0xc8

    move/from16 v0, p2

    if-ne v0, v2, :cond_3

    .line 832
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    move/from16 v0, p10

    iput v0, v2, Lco/vine/android/ProfileFragment;->mNextPage:I

    .line 833
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    move-wide/from16 v0, p12

    iput-wide v0, v2, Lco/vine/android/ProfileFragment;->mAnchor:J

    .line 834
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, v2, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    check-cast v2, Lco/vine/android/widget/FeedAdapter;

    iget v3, v12, Lco/vine/android/PendingRequest;->fetchType:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_5

    const/4 v3, 0x1

    :goto_0
    move-object/from16 v0, p7

    invoke-virtual {v2, v0, v3}, Lco/vine/android/widget/FeedAdapter;->mergePosts(Ljava/util/ArrayList;Z)V

    .line 835
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;
    invoke-static {v2}, Lco/vine/android/ProfileFragment;->access$200(Lco/vine/android/ProfileFragment;)Lco/vine/android/widget/SectionAdapter;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/widget/SectionAdapter;->getNumberOfAdapters()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_2

    .line 836
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    new-instance v3, Lco/vine/android/widget/SectionAdapter;

    const/4 v4, 0x2

    new-array v4, v4, [Landroid/widget/BaseAdapter;

    const/4 v5, 0x0

    iget-object v6, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v6, v6, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-object v6, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v6, v6, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    aput-object v6, v4, v5

    invoke-direct {v3, v4}, Lco/vine/android/widget/SectionAdapter;-><init>([Landroid/widget/BaseAdapter;)V

    # setter for: Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;
    invoke-static {v2, v3}, Lco/vine/android/ProfileFragment;->access$202(Lco/vine/android/ProfileFragment;Lco/vine/android/widget/SectionAdapter;)Lco/vine/android/widget/SectionAdapter;

    .line 837
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, v2, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    iget-object v3, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;
    invoke-static {v3}, Lco/vine/android/ProfileFragment;->access$200(Lco/vine/android/ProfileFragment;)Lco/vine/android/widget/SectionAdapter;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 840
    :cond_2
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, v2, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v11, 0x0

    move-object/from16 v3, p7

    move/from16 v4, p4

    move-object/from16 v5, p8

    move/from16 v6, p9

    move/from16 v7, p10

    move/from16 v8, p11

    move-wide/from16 v9, p12

    invoke-virtual/range {v2 .. v11}, Lco/vine/android/client/AppController;->saveLoadedPosts(Ljava/util/ArrayList;ILjava/lang/String;IIIJZ)Ljava/lang/String;

    .line 844
    :cond_3
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget v3, v12, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileFragment;->hideProgress(I)V

    .line 846
    :cond_4
    return-void

    .line 834
    :cond_5
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public onGetUserComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineUser;)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 895
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/ProfileFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 897
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_3

    .line 898
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_2

    .line 899
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # setter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1, p4}, Lco/vine/android/ProfileFragment;->access$402(Lco/vine/android/ProfileFragment;Lco/vine/android/api/VineUser;)Lco/vine/android/api/VineUser;

    .line 900
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # invokes: Lco/vine/android/ProfileFragment;->isLocked()Z
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$500(Lco/vine/android/ProfileFragment;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 901
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const/4 v2, 0x0

    # setter for: Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;
    invoke-static {v1, v2}, Lco/vine/android/ProfileFragment;->access$202(Lco/vine/android/ProfileFragment;Lco/vine/android/widget/SectionAdapter;)Lco/vine/android/widget/SectionAdapter;

    .line 902
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->isFocused()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mTakeFocus:Z
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$600(Lco/vine/android/ProfileFragment;)Z

    move-result v1

    if-eqz v1, :cond_4

    :cond_0
    const/4 v1, 0x1

    :goto_0
    # invokes: Lco/vine/android/ProfileFragment;->setup(Z)V
    invoke-static {v2, v1}, Lco/vine/android/ProfileFragment;->access$700(Lco/vine/android/ProfileFragment;Z)V

    .line 904
    :cond_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    if-eqz v1, :cond_2

    .line 905
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v2}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/ProfileFragment;->bindUserData(Lco/vine/android/api/VineUser;)V

    .line 907
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    invoke-virtual {v1}, Lco/vine/android/ProfileHeaderAdapter;->notifyDataSetChanged()V

    .line 910
    :cond_2
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget v2, v0, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v1, v2}, Lco/vine/android/ProfileFragment;->hideProgress(I)V

    .line 912
    :cond_3
    return-void

    .line 902
    :cond_4
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onGetUserIdComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 8
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1116
    const-wide/16 v3, 0x0

    cmp-long v0, p4, v3

    if-lez v0, :cond_4

    .line 1117
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # invokes: Lco/vine/android/ProfileFragment;->setUserId(J)V
    invoke-static {v0, p4, p5}, Lco/vine/android/ProfileFragment;->access$1400(Lco/vine/android/ProfileFragment;J)V

    .line 1118
    iget-object v3, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUserId:J
    invoke-static {v0}, Lco/vine/android/ProfileFragment;->access$1000(Lco/vine/android/ProfileFragment;)J

    move-result-wide v4

    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, v0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v6

    cmp-long v0, v4, v6

    if-nez v0, :cond_2

    move v0, v1

    :goto_0
    # setter for: Lco/vine/android/ProfileFragment;->mIsMe:Z
    invoke-static {v3, v0}, Lco/vine/android/ProfileFragment;->access$302(Lco/vine/android/ProfileFragment;Z)Z

    .line 1119
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mIsMe:Z
    invoke-static {v0}, Lco/vine/android/ProfileFragment;->access$300(Lco/vine/android/ProfileFragment;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1120
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v3, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v3}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "profile_hide_reposts"

    invoke-interface {v3, v4, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    # setter for: Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z
    invoke-static {v0, v3}, Lco/vine/android/ProfileFragment;->access$1502(Lco/vine/android/ProfileFragment;Z)Z

    .line 1122
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v3, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v3}, Lco/vine/android/ProfileFragment;->isFocused()Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mTakeFocus:Z
    invoke-static {v3}, Lco/vine/android/ProfileFragment;->access$600(Lco/vine/android/ProfileFragment;)Z

    move-result v3

    if-eqz v3, :cond_1

    :cond_0
    move v2, v1

    :cond_1
    # invokes: Lco/vine/android/ProfileFragment;->setup(Z)V
    invoke-static {v0, v2}, Lco/vine/android/ProfileFragment;->access$700(Lco/vine/android/ProfileFragment;Z)V

    .line 1123
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # invokes: Lco/vine/android/ProfileFragment;->initProfile()V
    invoke-static {v0}, Lco/vine/android/ProfileFragment;->access$1600(Lco/vine/android/ProfileFragment;)V

    .line 1131
    :goto_1
    return-void

    :cond_2
    move v0, v2

    .line 1118
    goto :goto_0

    .line 1125
    :cond_3
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, v0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getBlockedUsers()Ljava/lang/String;

    goto :goto_1

    .line 1129
    :cond_4
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_1
.end method

.method public onGetUsersMeComplete(Ljava/lang/String;ILjava/lang/String;JLco/vine/android/api/VineUser;)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "sessionOwnerId"    # J
    .param p6, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 860
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, p1}, Lco/vine/android/ProfileFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v1

    .line 862
    .local v1, "req":Lco/vine/android/PendingRequest;
    if-eqz v1, :cond_1

    .line 863
    const/16 v2, 0xc8

    if-ne p2, v2, :cond_0

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mIsMe:Z
    invoke-static {v2}, Lco/vine/android/ProfileFragment;->access$300(Lco/vine/android/ProfileFragment;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 864
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # setter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v2, p6}, Lco/vine/android/ProfileFragment;->access$402(Lco/vine/android/ProfileFragment;Lco/vine/android/api/VineUser;)Lco/vine/android/api/VineUser;

    .line 865
    if-eqz p6, :cond_0

    .line 866
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2, p6}, Lco/vine/android/ProfileFragment;->bindUserData(Lco/vine/android/api/VineUser;)V

    .line 868
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, v2, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    invoke-virtual {v2}, Lco/vine/android/ProfileHeaderAdapter;->notifyDataSetChanged()V

    .line 871
    :cond_0
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget v3, v1, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileFragment;->hideProgress(I)V

    .line 872
    new-instance v0, Landroid/content/Intent;

    const-string v2, "co.vine.android.profileColor"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 873
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-string v3, "co.vine.android.BROADCAST"

    invoke-virtual {v2, v0, v3}, Landroid/support/v4/app/FragmentActivity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 875
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    return-void
.end method

.method public onLikePost(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 930
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/ProfileFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 931
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 932
    const/16 v1, 0xc8

    if-eq p2, v1, :cond_0

    .line 933
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/LikeCache;->removeEntry(J)V

    .line 934
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/widget/GenericTimelineAdapter;->showUnlikedByMe(J)V

    .line 935
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1}, Lco/vine/android/widget/GenericTimelineAdapter;->notifyDataSetChanged()V

    .line 938
    :cond_0
    return-void
.end method

.method public onPhotoImageError(Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V
    .locals 0
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 890
    return-void
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 916
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    if-eqz v1, :cond_0

    .line 917
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    invoke-virtual {v1, p1}, Lco/vine/android/ProfileHeaderAdapter;->onImageLoaded(Ljava/util/HashMap;)V

    .line 918
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1, p1}, Lco/vine/android/widget/GenericTimelineAdapter;->setImages(Ljava/util/HashMap;)V

    .line 920
    :cond_0
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUserProfileImageKeyForShortcut:Lco/vine/android/util/image/ImageKey;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$800(Lco/vine/android/ProfileFragment;)Lco/vine/android/util/image/ImageKey;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 921
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUserProfileImageKeyForShortcut:Lco/vine/android/util/image/ImageKey;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$800(Lco/vine/android/ProfileFragment;)Lco/vine/android/util/image/ImageKey;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/image/UrlImage;

    .line 922
    .local v0, "urlImage":Lco/vine/android/util/image/UrlImage;
    if-eqz v0, :cond_1

    .line 923
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, v0, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    # invokes: Lco/vine/android/ProfileFragment;->addProfileShortCut(Landroid/graphics/Bitmap;)V
    invoke-static {v1, v2}, Lco/vine/android/ProfileFragment;->access$900(Lco/vine/android/ProfileFragment;Landroid/graphics/Bitmap;)V

    .line 926
    .end local v0    # "urlImage":Lco/vine/android/util/image/UrlImage;
    :cond_1
    return-void
.end method

.method public onReportUserComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 6
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 1068
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_1

    .line 1069
    invoke-direct {p0}, Lco/vine/android/ProfileFragment$ProfileListener;->isUsernameValid()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v1

    iget-object v0, v1, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    .line 1071
    .local v0, "username":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v3, 0x7f0e0269

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v2, v3, v4}, Lco/vine/android/ProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    .line 1075
    .end local v0    # "username":Ljava/lang/String;
    :goto_1
    return-void

    .line 1069
    :cond_0
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v2, 0x7f0e026e

    invoke-virtual {v1, v2}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1073
    :cond_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v3, 0x7f0e026a

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onRespondFollowRequestComplete(Ljava/lang/String;ILjava/lang/String;ZJ)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "accept"    # Z
    .param p5, "userId"    # J

    .prologue
    .line 1097
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_1

    .line 1098
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mFollowHeader:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$1300(Lco/vine/android/ProfileFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1099
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mFollowHeader:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$1300(Lco/vine/android/ProfileFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    const v2, 0x7f0a00fa

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 1100
    .local v0, "inner":Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1102
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mFollowHeader:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$1300(Lco/vine/android/ProfileFragment;)Landroid/widget/LinearLayout;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1111
    .end local v0    # "inner":Landroid/view/View;
    :cond_0
    :goto_0
    return-void

    .line 1105
    :cond_1
    if-eqz p4, :cond_2

    .line 1106
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0e003d

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0

    .line 1108
    :cond_2
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0e00b7

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0
.end method

.method public onTrimMemory(I)V
    .locals 2
    .param p1, "level"    # I

    .prologue
    .line 850
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->onTrimMemory(I)V

    .line 851
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, v1, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    .line 852
    .local v0, "adapter":Lco/vine/android/widget/GenericTimelineAdapter;
    if-eqz v0, :cond_0

    .line 853
    invoke-virtual {v0, p1}, Lco/vine/android/widget/GenericTimelineAdapter;->onTrimMemory(I)V

    .line 855
    :cond_0
    return-void
.end method

.method public onUnblockUserComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 6
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userUnblocked"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 1003
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_3

    .line 1004
    iget-object v4, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    if-nez p4, :cond_0

    move v1, v2

    :goto_0
    # setter for: Lco/vine/android/ProfileFragment;->mIsUserBlocked:Z
    invoke-static {v4, v1}, Lco/vine/android/ProfileFragment;->access$1102(Lco/vine/android/ProfileFragment;Z)Z

    .line 1005
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->supportInvalidateOptionsMenu()V

    .line 1007
    if-eqz p4, :cond_2

    .line 1008
    invoke-direct {p0}, Lco/vine/android/ProfileFragment$ProfileListener;->isUsernameValid()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v1}, Lco/vine/android/ProfileFragment;->access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;

    move-result-object v1

    iget-object v0, v1, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    .line 1010
    .local v0, "username":Ljava/lang/String;
    :goto_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v4, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v5, 0x7f0e026b

    new-array v2, v2, [Ljava/lang/Object;

    aput-object v0, v2, v3

    invoke-virtual {v4, v5, v2}, Lco/vine/android/ProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    .line 1011
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v2, v2, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    # getter for: Lco/vine/android/ProfileFragment;->mUserId:J
    invoke-static {v3}, Lco/vine/android/ProfileFragment;->access$1000(Lco/vine/android/ProfileFragment;)J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lco/vine/android/client/AppController;->fetchUser(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 1018
    .end local v0    # "username":Ljava/lang/String;
    :goto_2
    return-void

    :cond_0
    move v1, v3

    .line 1004
    goto :goto_0

    .line 1008
    :cond_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v4, 0x7f0e026d

    invoke-virtual {v1, v4}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1013
    :cond_2
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v3, 0x7f0e0265

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2

    .line 1016
    :cond_3
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    const v3, 0x7f0e026c

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showDefaultToast(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2
.end method

.method public onUnlikePost(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 942
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/ProfileFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 943
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 944
    const/16 v1, 0xc8

    if-eq p2, v1, :cond_0

    .line 945
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/LikeCache;->like(J)V

    .line 946
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/widget/GenericTimelineAdapter;->showLikedByMe(J)V

    .line 947
    iget-object v1, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v1, v1, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1}, Lco/vine/android/widget/GenericTimelineAdapter;->notifyDataSetChanged()V

    .line 950
    :cond_0
    return-void
.end method

.method public onUnrevine(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 971
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    .line 972
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, v0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    check-cast v0, Lco/vine/android/widget/FeedAdapter;

    invoke-virtual {v0, p4, p5}, Lco/vine/android/widget/FeedAdapter;->removePost(J)V

    .line 974
    :cond_0
    invoke-super/range {p0 .. p5}, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->onUnrevine(Ljava/lang/String;ILjava/lang/String;J)V

    .line 975
    return-void
.end method

.method public onVideoPathError(Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V
    .locals 0
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 885
    return-void
.end method

.method public onVideoPathObtained(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Lco/vine/android/util/video/UrlVideo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 879
    .local p1, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    iget-object v0, p0, Lco/vine/android/ProfileFragment$ProfileListener;->this$0:Lco/vine/android/ProfileFragment;

    iget-object v0, v0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/widget/GenericTimelineAdapter;->onVideoPathObtained(Ljava/util/HashMap;)V

    .line 880
    return-void
.end method
