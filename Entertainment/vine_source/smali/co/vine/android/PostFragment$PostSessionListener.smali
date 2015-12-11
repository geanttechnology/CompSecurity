.class Lco/vine/android/PostFragment$PostSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "PostFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/PostFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PostSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/PostFragment;


# direct methods
.method constructor <init>(Lco/vine/android/PostFragment;)V
    .locals 0

    .prologue
    .line 592
    iput-object p1, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onConnectFacebookComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 595
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    # getter for: Lco/vine/android/PostFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/PostFragment;->access$000(Lco/vine/android/PostFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 596
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    # getter for: Lco/vine/android/PostFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/PostFragment;->access$000(Lco/vine/android/PostFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 598
    :cond_0
    const/16 v0, 0xc8

    if-eq p2, v0, :cond_1

    .line 599
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    invoke-virtual {v0}, Lco/vine/android/PostFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0e00ca

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 601
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    # getter for: Lco/vine/android/PostFragment;->mPostFacebook:Lco/vine/android/views/SwitchInterface;
    invoke-static {v0}, Lco/vine/android/PostFragment;->access$100(Lco/vine/android/PostFragment;)Lco/vine/android/views/SwitchInterface;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    .line 603
    :cond_1
    return-void
.end method

.method public onConnectTwitterComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 7
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "username"    # Ljava/lang/String;
    .param p5, "token"    # Ljava/lang/String;
    .param p6, "secret"    # Ljava/lang/String;
    .param p7, "userId"    # J

    .prologue
    .line 609
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_1

    .line 610
    const-wide/16 v0, 0x0

    cmp-long v0, p7, v0

    if-lez v0, :cond_0

    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 611
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    invoke-virtual {v0}, Lco/vine/android/PostFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    iget-object v1, v1, Lco/vine/android/PostFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v1

    move-object v2, p4

    move-object v3, p5

    move-object v4, p6

    move-wide v5, p7

    invoke-static/range {v0 .. v6}, Lco/vine/android/client/VineAccountHelper;->saveTwitterInfo(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    .line 614
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    # getter for: Lco/vine/android/PostFragment;->mPostTwitter:Lco/vine/android/views/SwitchInterface;
    invoke-static {v0}, Lco/vine/android/PostFragment;->access$200(Lco/vine/android/PostFragment;)Lco/vine/android/views/SwitchInterface;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    .line 620
    :cond_0
    :goto_0
    return-void

    .line 617
    :cond_1
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    invoke-virtual {v0}, Lco/vine/android/PostFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    .line 618
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    # getter for: Lco/vine/android/PostFragment;->mPostTwitter:Lco/vine/android/views/SwitchInterface;
    invoke-static {v0}, Lco/vine/android/PostFragment;->access$200(Lco/vine/android/PostFragment;)Lco/vine/android/views/SwitchInterface;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    goto :goto_0
.end method

.method public onGetTagTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 2
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
            "Lco/vine/android/api/VineTag;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 636
    .local p5, "tags":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineTag;>;"
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    invoke-virtual {p5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 637
    invoke-static {p4, p5}, Lco/vine/android/provider/VineSuggestionsProvider;->addRealtimeTagSuggestions(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 638
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    # getter for: Lco/vine/android/PostFragment;->mCaption:Lco/vine/android/widget/PopupEditText;
    invoke-static {v0}, Lco/vine/android/PostFragment;->access$300(Lco/vine/android/PostFragment;)Lco/vine/android/widget/PopupEditText;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/PopupEditText;->performFilter(Z)V

    .line 640
    :cond_0
    return-void
.end method

.method public onGetUserTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 2
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
    .line 625
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    .line 626
    invoke-virtual {p5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 627
    invoke-static {p4, p5}, Lco/vine/android/provider/VineSuggestionsProvider;->addRealtimeUserSuggestions(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 628
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    # getter for: Lco/vine/android/PostFragment;->mCaption:Lco/vine/android/widget/PopupEditText;
    invoke-static {v0}, Lco/vine/android/PostFragment;->access$300(Lco/vine/android/PostFragment;)Lco/vine/android/widget/PopupEditText;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/PopupEditText;->performFilter(Z)V

    .line 631
    :cond_0
    return-void
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
    .line 644
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    invoke-super {p0, p1}, Lco/vine/android/client/AppSessionListener;->onPhotoImageLoaded(Ljava/util/HashMap;)V

    .line 645
    iget-object v0, p0, Lco/vine/android/PostFragment$PostSessionListener;->this$0:Lco/vine/android/PostFragment;

    # getter for: Lco/vine/android/PostFragment;->mUsersAdapter:Lco/vine/android/UsersAutoCompleteAdapter;
    invoke-static {v0}, Lco/vine/android/PostFragment;->access$400(Lco/vine/android/PostFragment;)Lco/vine/android/UsersAutoCompleteAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/UsersAutoCompleteAdapter;->setUserImages(Ljava/util/HashMap;)V

    .line 646
    return-void
.end method
