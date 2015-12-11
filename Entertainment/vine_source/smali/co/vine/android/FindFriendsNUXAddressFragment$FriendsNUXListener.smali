.class Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;
.super Lco/vine/android/client/AppSessionListener;
.source "FindFriendsNUXAddressFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/FindFriendsNUXAddressFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FriendsNUXListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/FindFriendsNUXAddressFragment;


# direct methods
.method private constructor <init>(Lco/vine/android/FindFriendsNUXAddressFragment;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/FindFriendsNUXAddressFragment;Lco/vine/android/FindFriendsNUXAddressFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/FindFriendsNUXAddressFragment;
    .param p2, "x1"    # Lco/vine/android/FindFriendsNUXAddressFragment$1;

    .prologue
    .line 162
    invoke-direct {p0, p1}, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;-><init>(Lco/vine/android/FindFriendsNUXAddressFragment;)V

    return-void
.end method


# virtual methods
.method public onFollowComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 204
    if-eqz p1, :cond_0

    const/16 v0, 0xc8

    if-eq p2, v0, :cond_0

    .line 205
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    iget-object v0, v0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v0, p4, p5}, Lco/vine/android/Friendships;->removeFollowing(J)V

    .line 207
    :cond_0
    return-void
.end method

.method public onGetAddressFriendsComplete(Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;)V
    .locals 6
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 167
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lco/vine/android/FindFriendsNUXAddressFragment;->hideProgress(I)V

    .line 168
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->dismissDialog()V

    .line 169
    if-eqz p1, :cond_2

    const/16 v0, 0xc8

    if-ne p2, v0, :cond_2

    .line 170
    if-gtz p4, :cond_0

    .line 171
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v0, v3}, Lco/vine/android/FindFriendsNUXAddressFragment;->showSadface(Z)V

    .line 181
    :goto_0
    invoke-static {p4}, Lco/vine/android/util/FlurryUtils;->trackFindFriendsAddressCount(I)V

    .line 187
    :goto_1
    return-void

    .line 173
    :cond_0
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v0, v5}, Lco/vine/android/FindFriendsNUXAddressFragment;->showSadface(Z)V

    .line 174
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    # getter for: Lco/vine/android/FindFriendsNUXAddressFragment;->mContactsCountContainer:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->access$200(Lco/vine/android/FindFriendsNUXAddressFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 175
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    # getter for: Lco/vine/android/FindFriendsNUXAddressFragment;->mContactsText:Landroid/widget/TextView;
    invoke-static {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->access$300(Lco/vine/android/FindFriendsNUXAddressFragment;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    const v2, 0x7f0e00e3

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Lco/vine/android/FindFriendsNUXAddressFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 176
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    # getter for: Lco/vine/android/FindFriendsNUXAddressFragment;->mSelectAllToggle:Landroid/widget/TextView;
    invoke-static {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->access$500(Lco/vine/android/FindFriendsNUXAddressFragment;)Landroid/widget/TextView;

    move-result-object v1

    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    # getter for: Lco/vine/android/FindFriendsNUXAddressFragment;->mSelected:Z
    invoke-static {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->access$400(Lco/vine/android/FindFriendsNUXAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    const v0, 0x7f0e00b8

    :goto_2
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 177
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    # getter for: Lco/vine/android/FindFriendsNUXAddressFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;
    invoke-static {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->access$600(Lco/vine/android/FindFriendsNUXAddressFragment;)Lco/vine/android/FindFriendsNUXActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    iget-object v1, v1, Lco/vine/android/FindFriendsNUXAddressFragment;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v0, p5, v1}, Lco/vine/android/FindFriendsNUXActivity;->addUsersToFollow(Ljava/util/ArrayList;Lco/vine/android/Friendships;)V

    .line 178
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    # getter for: Lco/vine/android/FindFriendsNUXAddressFragment;->mAddressFriends:Ljava/util/ArrayList;
    invoke-static {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->access$700(Lco/vine/android/FindFriendsNUXAddressFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p5}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 176
    :cond_1
    const v0, 0x7f0e01bc

    goto :goto_2

    .line 183
    :cond_2
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v0, v3}, Lco/vine/android/FindFriendsNUXAddressFragment;->showSadface(Z)V

    .line 184
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0e00e0

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 185
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackFindFriendsAddressFailure()V

    goto :goto_1
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 1
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
    .line 198
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    iget-object v0, v0, Lco/vine/android/FindFriendsNUXAddressFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/UsersAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/UsersAdapter;->setUserImages(Ljava/util/HashMap;)V

    .line 199
    return-void
.end method

.method public onRemoveUsersComplete(Ljava/lang/String;)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 191
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    iget-object v0, v0, Lco/vine/android/FindFriendsNUXAddressFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    if-nez v0, :cond_0

    .line 192
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->initLoader()V

    .line 194
    :cond_0
    return-void
.end method

.method public onUnFollowComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 212
    if-eqz p1, :cond_0

    const/16 v0, 0xc8

    if-eq p2, v0, :cond_0

    .line 213
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$FriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    iget-object v0, v0, Lco/vine/android/FindFriendsNUXAddressFragment;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v0, p4, p5}, Lco/vine/android/Friendships;->addFollowing(J)V

    .line 215
    :cond_0
    return-void
.end method
