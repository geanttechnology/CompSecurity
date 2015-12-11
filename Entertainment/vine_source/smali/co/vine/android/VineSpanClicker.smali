.class public Lco/vine/android/VineSpanClicker;
.super Ljava/lang/Object;
.source "VineSpanClicker.java"

# interfaces
.implements Lco/vine/android/widget/SpanClickListener;


# static fields
.field public static final FOLLOWERS_SPAN:I = 0x5

.field public static final FOLLOWING_SPAN:I = 0x6

.field public static final MANY_LIKES_SPAN:I = 0x2

.field public static final OLDER_COMMENTS_SPAN:I = 0x3

.field public static final POST_SPAN:I = 0x9

.field public static final REVINED_BY_SPAN:I = 0x8

.field public static final REVINERS_SPAN:I = 0x7

.field public static final SPAN_FLAGS:I = 0x21

.field public static final TAG_SPAN:I = 0x4

.field public static final USERNAME_SPAN:I = 0x1


# instance fields
.field private mActivity:Landroid/support/v4/app/FragmentActivity;

.field private mFlurryEventSource:Ljava/lang/String;

.field private mFragment:Lco/vine/android/BaseFragment;

.field private mUserId:J


# direct methods
.method public constructor <init>(Landroid/support/v4/app/FragmentActivity;)V
    .locals 0
    .param p1, "activity"    # Landroid/support/v4/app/FragmentActivity;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-object p1, p0, Lco/vine/android/VineSpanClicker;->mActivity:Landroid/support/v4/app/FragmentActivity;

    .line 41
    return-void
.end method

.method public constructor <init>(Lco/vine/android/BaseFragment;)V
    .locals 0
    .param p1, "fragment"    # Lco/vine/android/BaseFragment;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lco/vine/android/VineSpanClicker;->mFragment:Lco/vine/android/BaseFragment;

    .line 37
    return-void
.end method


# virtual methods
.method public getActivity()Landroid/support/v4/app/FragmentActivity;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lco/vine/android/VineSpanClicker;->mFragment:Lco/vine/android/BaseFragment;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lco/vine/android/VineSpanClicker;->mFragment:Lco/vine/android/BaseFragment;

    invoke-virtual {v0}, Lco/vine/android/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 55
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/VineSpanClicker;->mActivity:Landroid/support/v4/app/FragmentActivity;

    goto :goto_0
.end method

.method public onFollowersClicked()V
    .locals 5

    .prologue
    .line 68
    invoke-virtual {p0}, Lco/vine/android/VineSpanClicker;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 69
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 70
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lco/vine/android/UsersActivity;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 71
    .local v1, "i":Landroid/content/Intent;
    const-string v2, "p_id"

    iget-wide v3, p0, Lco/vine/android/VineSpanClicker;->mUserId:J

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 72
    const-string v2, "u_type"

    const/4 v3, 0x2

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 74
    invoke-virtual {p0, v1}, Lco/vine/android/VineSpanClicker;->startActivity(Landroid/content/Intent;)V

    .line 76
    .end local v1    # "i":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method public onFollowingClicked()V
    .locals 5

    .prologue
    .line 79
    invoke-virtual {p0}, Lco/vine/android/VineSpanClicker;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 80
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 81
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lco/vine/android/UsersActivity;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 82
    .local v1, "i":Landroid/content/Intent;
    const-string v2, "p_id"

    iget-wide v3, p0, Lco/vine/android/VineSpanClicker;->mUserId:J

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 83
    const-string v2, "u_type"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 85
    invoke-virtual {p0, v1}, Lco/vine/android/VineSpanClicker;->startActivity(Landroid/content/Intent;)V

    .line 87
    .end local v1    # "i":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method public onRevineBySpanClicked(J)V
    .locals 2
    .param p1, "userId"    # J

    .prologue
    .line 153
    invoke-virtual {p0}, Lco/vine/android/VineSpanClicker;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 154
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 155
    iget-object v1, p0, Lco/vine/android/VineSpanClicker;->mFlurryEventSource:Ljava/lang/String;

    invoke-static {v0, p1, p2, v1}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    .line 157
    :cond_0
    return-void
.end method

.method public onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V
    .locals 11
    .param p1, "view"    # Landroid/view/View;
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/Object;

    .prologue
    .line 91
    invoke-virtual {p0}, Lco/vine/android/VineSpanClicker;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 92
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 93
    packed-switch p2, :pswitch_data_0

    .line 150
    .end local p3    # "tag":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-void

    .line 95
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/VineSpanClicker;->onFollowingClicked()V

    goto :goto_0

    .line 99
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/VineSpanClicker;->onFollowersClicked()V

    goto :goto_0

    :pswitch_2
    move-object v7, p3

    .line 103
    check-cast v7, Ljava/lang/Long;

    .line 104
    .local v7, "postId":Ljava/lang/Long;
    new-instance v6, Landroid/content/Intent;

    const-class v1, Lco/vine/android/UsersActivity;

    invoke-direct {v6, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 105
    .local v6, "i":Landroid/content/Intent;
    const-string v1, "post_id"

    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v6, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 106
    const-string v1, "u_type"

    const/4 v2, 0x5

    invoke-virtual {v6, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 107
    invoke-virtual {p0, v6}, Lco/vine/android/VineSpanClicker;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 111
    .end local v6    # "i":Landroid/content/Intent;
    .end local v7    # "postId":Ljava/lang/Long;
    :pswitch_3
    check-cast p3, Ljava/lang/Long;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Lco/vine/android/SingleActivity;->start(Landroid/content/Context;J)V

    goto :goto_0

    .line 115
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_4
    iget-object v1, p0, Lco/vine/android/VineSpanClicker;->mFragment:Lco/vine/android/BaseFragment;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lco/vine/android/VineSpanClicker;->mFragment:Lco/vine/android/BaseFragment;

    instance-of v1, v1, Lco/vine/android/ProfileFragment;

    if-eqz v1, :cond_1

    .line 116
    iget-object v1, p0, Lco/vine/android/VineSpanClicker;->mFragment:Lco/vine/android/BaseFragment;

    check-cast v1, Lco/vine/android/ProfileFragment;

    invoke-virtual {v1}, Lco/vine/android/ProfileFragment;->getUserId()J

    move-result-wide v9

    .line 118
    .local v9, "userId":J
    if-eqz p3, :cond_1

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p3, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 122
    .end local v9    # "userId":J
    :cond_1
    check-cast p3, Ljava/lang/Long;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    iget-object v3, p0, Lco/vine/android/VineSpanClicker;->mFlurryEventSource:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    goto :goto_0

    .line 126
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_5
    check-cast p3, Ljava/lang/String;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-static {v0, p3}, Lco/vine/android/HashtagActivity;->start(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_6
    move-object v8, p3

    .line 130
    check-cast v8, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;

    .line 132
    .local v8, "spanTag":Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;, "Lco/vine/android/widget/GenericVideoAdapter<Lco/vine/android/widget/FeedViewHolder;>.SpanCommentObjectTag;"
    iget-wide v1, v8, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;->postId:J

    iget-wide v3, v8, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;->authorId:J

    const/4 v5, 0x1

    invoke-static/range {v0 .. v5}, Lco/vine/android/CommentsActivity;->start(Landroid/content/Context;JJZ)V

    goto :goto_0

    .end local v8    # "spanTag":Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;, "Lco/vine/android/widget/GenericVideoAdapter<Lco/vine/android/widget/FeedViewHolder;>.SpanCommentObjectTag;"
    :pswitch_7
    move-object v8, p3

    .line 136
    check-cast v8, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;

    .line 138
    .restart local v8    # "spanTag":Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;, "Lco/vine/android/widget/GenericVideoAdapter<Lco/vine/android/widget/FeedViewHolder;>.SpanCommentObjectTag;"
    new-instance v6, Landroid/content/Intent;

    const-class v1, Lco/vine/android/UsersActivity;

    invoke-direct {v6, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 139
    .restart local v6    # "i":Landroid/content/Intent;
    const-string v1, "post_id"

    iget-wide v2, v8, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;->postId:J

    invoke-virtual {v6, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 140
    const-string v1, "u_type"

    const/16 v2, 0x9

    invoke-virtual {v6, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 141
    invoke-virtual {p0, v6}, Lco/vine/android/VineSpanClicker;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 145
    .end local v6    # "i":Landroid/content/Intent;
    .end local v8    # "spanTag":Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;, "Lco/vine/android/widget/GenericVideoAdapter<Lco/vine/android/widget/FeedViewHolder;>.SpanCommentObjectTag;"
    :pswitch_8
    check-cast p3, Ljava/lang/Long;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    invoke-virtual {p0, v1, v2}, Lco/vine/android/VineSpanClicker;->onRevineBySpanClicked(J)V

    goto/16 :goto_0

    .line 93
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_4
        :pswitch_2
        :pswitch_6
        :pswitch_5
        :pswitch_1
        :pswitch_0
        :pswitch_7
        :pswitch_8
        :pswitch_3
    .end packed-switch
.end method

.method public setFlurryEventSource(Ljava/lang/String;)V
    .locals 0
    .param p1, "source"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lco/vine/android/VineSpanClicker;->mFlurryEventSource:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setUserId(J)V
    .locals 0
    .param p1, "userId"    # J

    .prologue
    .line 48
    iput-wide p1, p0, Lco/vine/android/VineSpanClicker;->mUserId:J

    .line 49
    return-void
.end method

.method public startActivity(Landroid/content/Intent;)V
    .locals 1
    .param p1, "i"    # Landroid/content/Intent;

    .prologue
    .line 60
    iget-object v0, p0, Lco/vine/android/VineSpanClicker;->mFragment:Lco/vine/android/BaseFragment;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lco/vine/android/VineSpanClicker;->mFragment:Lco/vine/android/BaseFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/BaseFragment;->startActivity(Landroid/content/Intent;)V

    .line 65
    :goto_0
    return-void

    .line 63
    :cond_0
    iget-object v0, p0, Lco/vine/android/VineSpanClicker;->mActivity:Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method
