.class Lco/vine/android/BaseTimelineFragment$1;
.super Landroid/content/BroadcastReceiver;
.source "BaseTimelineFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/BaseTimelineFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/BaseTimelineFragment;


# direct methods
.method constructor <init>(Lco/vine/android/BaseTimelineFragment;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lco/vine/android/BaseTimelineFragment$1;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 81
    if-eqz p2, :cond_0

    .line 82
    const-string v1, "co.vine.android.service.mergePostFeed"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 83
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "post"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePost;

    .line 84
    .local v0, "post":Lco/vine/android/api/VinePost;
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$1;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    check-cast v1, Lco/vine/android/widget/FeedAdapter;

    invoke-virtual {v1, v0}, Lco/vine/android/widget/FeedAdapter;->mergeMyPost(Lco/vine/android/api/VinePost;)V

    .line 87
    .end local v0    # "post":Lco/vine/android/api/VinePost;
    :cond_0
    return-void
.end method
