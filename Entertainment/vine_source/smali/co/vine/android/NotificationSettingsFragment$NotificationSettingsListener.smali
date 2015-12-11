.class public Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;
.super Lco/vine/android/client/AppSessionListener;
.source "NotificationSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/NotificationSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "NotificationSettingsListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/NotificationSettingsFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/NotificationSettingsFragment;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onGetNotificationSettingsComplete(Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 6
    .param p1, "reqId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineNotificationSetting;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "settings":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineNotificationSetting;>;"
    const/4 v5, 0x1

    .line 86
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    # setter for: Lco/vine/android/NotificationSettingsFragment;->mFetched:Z
    invoke-static {v1, v5}, Lco/vine/android/NotificationSettingsFragment;->access$002(Lco/vine/android/NotificationSettingsFragment;Z)Z

    .line 87
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/NotificationSettingsFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 88
    .local v0, "request":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 89
    if-eqz p2, :cond_1

    .line 90
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    new-instance v2, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;

    iget-object v3, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    iget-object v4, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-virtual {v4}, Lco/vine/android/NotificationSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v2, v3, v4, p2}, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;-><init>(Lco/vine/android/NotificationSettingsFragment;Landroid/content/Context;Ljava/util/ArrayList;)V

    iput-object v2, v1, Lco/vine/android/NotificationSettingsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    .line 91
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    iget-object v1, v1, Lco/vine/android/NotificationSettingsFragment;->mListView:Landroid/widget/ListView;

    iget-object v2, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    iget-object v2, v2, Lco/vine/android/NotificationSettingsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 92
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    # setter for: Lco/vine/android/NotificationSettingsFragment;->mSucceeded:Z
    invoke-static {v1, v5}, Lco/vine/android/NotificationSettingsFragment;->access$102(Lco/vine/android/NotificationSettingsFragment;Z)Z

    .line 93
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-virtual {v1}, Lco/vine/android/NotificationSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 99
    :cond_0
    :goto_0
    return-void

    .line 95
    :cond_1
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-virtual {v1, v5}, Lco/vine/android/NotificationSettingsFragment;->showSadface(Z)V

    .line 96
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    const/4 v2, 0x0

    # setter for: Lco/vine/android/NotificationSettingsFragment;->mSucceeded:Z
    invoke-static {v1, v2}, Lco/vine/android/NotificationSettingsFragment;->access$102(Lco/vine/android/NotificationSettingsFragment;Z)Z

    goto :goto_0
.end method

.method public onSaveNotificationSettingsComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 102
    const/16 v0, 0xc8

    if-eq p2, v0, :cond_1

    .line 103
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/NotificationSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0e00cb

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 111
    :goto_0
    return-void

    .line 106
    :cond_0
    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/NotificationSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p3, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 109
    :cond_1
    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/NotificationSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0
.end method
