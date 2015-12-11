.class Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "BaseRecipientPickerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/BaseRecipientPickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RecipientPickerSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/BaseRecipientPickerFragment;


# direct methods
.method private constructor <init>(Lco/vine/android/BaseRecipientPickerFragment;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/BaseRecipientPickerFragment;Lco/vine/android/BaseRecipientPickerFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/BaseRecipientPickerFragment;
    .param p2, "x1"    # Lco/vine/android/BaseRecipientPickerFragment$1;

    .prologue
    .line 105
    invoke-direct {p0, p1}, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;-><init>(Lco/vine/android/BaseRecipientPickerFragment;)V

    return-void
.end method


# virtual methods
.method public onGetFriendsTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 109
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    iget-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    invoke-virtual {v0, p4, p5}, Lco/vine/android/BaseRecipientPickerFragment;->onGetFriendsTypeAheadComplete(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 110
    return-void
.end method

.method public onGetUsersComplete(Lco/vine/android/client/Session;Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;IIJ)V
    .locals 3
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "reqId"    # Ljava/lang/String;
    .param p3, "errorCode"    # I
    .param p4, "reasonPhrase"    # Ljava/lang/String;
    .param p5, "count"    # I
    .param p7, "nextPage"    # I
    .param p8, "prevPage"    # I
    .param p9, "anchor"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/client/Session;",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;IIJ)V"
        }
    .end annotation

    .prologue
    .line 116
    .local p6, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    iget-object v1, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    invoke-virtual {v1, p2}, Lco/vine/android/BaseRecipientPickerFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 117
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 118
    iget-object v1, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    invoke-virtual {v1, p3}, Lco/vine/android/BaseRecipientPickerFragment;->onGetFriendsComplete(I)V

    .line 119
    iget-object v1, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    iget v2, v0, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v1, v2}, Lco/vine/android/BaseRecipientPickerFragment;->hideProgress(I)V

    .line 120
    packed-switch p3, :pswitch_data_0

    .line 125
    iget-object v1, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Lco/vine/android/BaseRecipientPickerFragment;->hideProgress(I)V

    .line 126
    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 127
    iget-object v1, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseRecipientPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, p4}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    .line 133
    :cond_0
    :pswitch_0
    return-void

    .line 120
    nop

    :pswitch_data_0
    .packed-switch 0xc8
        :pswitch_0
    .end packed-switch
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
    .line 137
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    iget-object v0, v0, Lco/vine/android/BaseRecipientPickerFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    instance-of v0, v0, Lco/vine/android/FriendsPickerAdapter;

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;->this$0:Lco/vine/android/BaseRecipientPickerFragment;

    iget-object v0, v0, Lco/vine/android/BaseRecipientPickerFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/FriendsPickerAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/FriendsPickerAdapter;->setUserImages(Ljava/util/HashMap;)V

    .line 140
    :cond_0
    return-void
.end method
