.class Lco/vine/android/BaseTimelineFragment$2;
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
    .line 100
    iput-object p1, p0, Lco/vine/android/BaseTimelineFragment$2;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 104
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_1

    .line 105
    :cond_0
    const-string v1, "Something wrong has happened"

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 110
    :goto_0
    return-void

    .line 107
    :cond_1
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_MUTE:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 108
    .local v0, "mute":Z
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$2;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1, v0}, Lco/vine/android/widget/GenericTimelineAdapter;->toggleMute(Z)V

    goto :goto_0
.end method
