.class public Lco/vine/android/FindFriendsNUXAddressFragment;
.super Lco/vine/android/FindFriendsBaseFragment;
.source "FindFriendsNUXAddressFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;
    }
.end annotation


# instance fields
.field private mActivity:Lco/vine/android/FindFriendsNUXActivity;

.field private mAddressFriends:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation
.end field

.field private mContactsCountContainer:Landroid/widget/RelativeLayout;

.field private mContactsText:Landroid/widget/TextView;

.field private mFilterLoaderIsReady:Z

.field private mFilterRunnable:Ljava/lang/Runnable;

.field private mHandler:Landroid/os/Handler;

.field private mSelectAllToggle:Landroid/widget/TextView;

.field private mSelected:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lco/vine/android/FindFriendsBaseFragment;-><init>()V

    .line 150
    new-instance v0, Lco/vine/android/FindFriendsNUXAddressFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/FindFriendsNUXAddressFragment$1;-><init>(Lco/vine/android/FindFriendsNUXAddressFragment;)V

    iput-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFilterRunnable:Ljava/lang/Runnable;

    .line 162
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/FindFriendsNUXAddressFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;

    .prologue
    .line 30
    iget-boolean v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFilterLoaderIsReady:Z

    return v0
.end method

.method static synthetic access$102(Lco/vine/android/FindFriendsNUXAddressFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 30
    iput-boolean p1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFilterLoaderIsReady:Z

    return p1
.end method

.method static synthetic access$200(Lco/vine/android/FindFriendsNUXAddressFragment;)Landroid/widget/RelativeLayout;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mContactsCountContainer:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/FindFriendsNUXAddressFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mContactsText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/FindFriendsNUXAddressFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;

    .prologue
    .line 30
    iget-boolean v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelected:Z

    return v0
.end method

.method static synthetic access$500(Lco/vine/android/FindFriendsNUXAddressFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelectAllToggle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/FindFriendsNUXAddressFragment;)Lco/vine/android/FindFriendsNUXActivity;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/FindFriendsNUXAddressFragment;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mAddressFriends:Ljava/util/ArrayList;

    return-object v0
.end method


# virtual methods
.method public getFirstItemPosition()Lcom/twitter/android/widget/ItemPosition;
    .locals 1

    .prologue
    .line 101
    const/4 v0, 0x0

    return-object v0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 43
    invoke-super {p0, p1}, Lco/vine/android/FindFriendsBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 44
    check-cast p1, Lco/vine/android/FindFriendsNUXActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    .line 45
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 106
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 133
    :cond_0
    :goto_0
    return-void

    .line 108
    :sswitch_0
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/FollowButtonViewHolder;

    .line 109
    .local v0, "holder":Lco/vine/android/FollowButtonViewHolder;
    if-eqz v0, :cond_0

    .line 110
    iget-boolean v1, v0, Lco/vine/android/FollowButtonViewHolder;->following:Z

    if-nez v1, :cond_1

    .line 111
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/FindFriendsNUXActivity;->addUserToFollow(J)V

    .line 112
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/Friendships;->addFollowing(J)V

    .line 113
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 115
    :cond_1
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/FindFriendsNUXActivity;->removeUserToFollow(J)V

    .line 116
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/Friendships;->removeFollowing(J)V

    .line 117
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 123
    .end local v0    # "holder":Lco/vine/android/FollowButtonViewHolder;
    :sswitch_1
    iget-boolean v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelected:Z

    if-nez v1, :cond_2

    const/4 v1, 0x1

    :goto_1
    iput-boolean v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelected:Z

    .line 124
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    iget-boolean v2, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelected:Z

    iget-object v3, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mAddressFriends:Ljava/util/ArrayList;

    iget-object v4, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v1, v2, v3, v4}, Lco/vine/android/FindFriendsNUXActivity;->toggleFollowAll(ZLjava/util/ArrayList;Lco/vine/android/Friendships;)V

    .line 125
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelectAllToggle:Landroid/widget/TextView;

    iget-boolean v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelected:Z

    if-eqz v1, :cond_3

    const v1, 0x7f0e00b8

    :goto_2
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(I)V

    .line 126
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 123
    :cond_2
    const/4 v1, 0x0

    goto :goto_1

    .line 125
    :cond_3
    const v1, 0x7f0e01bc

    goto :goto_2

    .line 106
    :sswitch_data_0
    .sparse-switch
        0x7f0a00f0 -> :sswitch_1
        0x7f0a022d -> :sswitch_0
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x1

    .line 49
    invoke-super {p0, p1}, Lco/vine/android/FindFriendsBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 51
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXAddressFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 52
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 53
    const-string v1, "take_focus"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsNUXAddressFragment;->setFocused(Z)V

    .line 56
    :cond_0
    new-instance v1, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;-><init>(Lco/vine/android/FindFriendsNUXAddressFragment;Lco/vine/android/FindFriendsNUXAddressFragment$1;)V

    iput-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 57
    iput-boolean v3, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelected:Z

    .line 58
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mAddressFriends:Ljava/util/ArrayList;

    .line 59
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    iput-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mHandler:Landroid/os/Handler;

    .line 60
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 65
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/FindFriendsBaseFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 66
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0a00ee

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mContactsCountContainer:Landroid/widget/RelativeLayout;

    .line 67
    const v1, 0x7f0a00ef

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mContactsText:Landroid/widget/TextView;

    .line 68
    const v1, 0x7f0a00f0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelectAllToggle:Landroid/widget/TextView;

    .line 69
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSelectAllToggle:Landroid/widget/TextView;

    invoke-virtual {v1, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 70
    return-object v0
.end method

.method public onMoveTo(I)V
    .locals 2
    .param p1, "oldPosition"    # I

    .prologue
    .line 83
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    invoke-virtual {v1}, Lco/vine/android/FindFriendsNUXActivity;->clearSearch()V

    .line 84
    iget-boolean v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFetched:Z

    if-nez v1, :cond_0

    .line 86
    const/4 v1, 0x1

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v0

    .line 88
    .local v0, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v0, p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 89
    const v1, 0x7f0e0234

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 90
    const v1, 0x7f0e0233

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 91
    const v1, 0x7f0e014d

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 92
    const v1, 0x7f0e0163

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 93
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setCancelable(Z)V

    .line 94
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXAddressFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 96
    .end local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 75
    invoke-super {p0}, Lco/vine/android/FindFriendsBaseFragment;->onResume()V

    .line 76
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXAddressFragment;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 77
    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->onMoveTo(I)V

    .line 79
    :cond_0
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 4
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 141
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFilterRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 142
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSearchQuery:Ljava/lang/String;

    .line 143
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mSearchQuery:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 144
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFilterRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 148
    :goto_0
    return-void

    .line 146
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->restartLoader(I)Z

    goto :goto_0
.end method

.method protected startProfileActivity(J)V
    .locals 3
    .param p1, "userId"    # J

    .prologue
    .line 136
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "Find Friends: Address"

    const/4 v2, 0x0

    invoke-static {v0, p1, p2, v1, v2}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;Z)V

    .line 137
    return-void
.end method
