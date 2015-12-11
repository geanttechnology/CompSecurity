.class Lco/vine/android/HomeTabActivity$1;
.super Landroid/content/BroadcastReceiver;
.source "HomeTabActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/HomeTabActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/HomeTabActivity;


# direct methods
.method constructor <init>(Lco/vine/android/HomeTabActivity;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lco/vine/android/HomeTabActivity$1;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v3, 0x0

    .line 127
    const-string v2, "messages_count"

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 128
    .local v0, "messageCount":I
    const-string v2, "notifications_count"

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 129
    .local v1, "notificationsCount":I
    iget-object v2, p0, Lco/vine/android/HomeTabActivity$1;->this$0:Lco/vine/android/HomeTabActivity;

    # setter for: Lco/vine/android/HomeTabActivity;->mActivityCount:I
    invoke-static {v2, v1}, Lco/vine/android/HomeTabActivity;->access$002(Lco/vine/android/HomeTabActivity;I)I

    .line 130
    iget-object v2, p0, Lco/vine/android/HomeTabActivity$1;->this$0:Lco/vine/android/HomeTabActivity;

    # setter for: Lco/vine/android/HomeTabActivity;->mMessageCount:I
    invoke-static {v2, v0}, Lco/vine/android/HomeTabActivity;->access$102(Lco/vine/android/HomeTabActivity;I)I

    .line 131
    iget-object v2, p0, Lco/vine/android/HomeTabActivity$1;->this$0:Lco/vine/android/HomeTabActivity;

    # invokes: Lco/vine/android/HomeTabActivity;->invalidateMessagesBadge()V
    invoke-static {v2}, Lco/vine/android/HomeTabActivity;->access$200(Lco/vine/android/HomeTabActivity;)V

    .line 132
    iget-object v2, p0, Lco/vine/android/HomeTabActivity$1;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-virtual {v2}, Lco/vine/android/HomeTabActivity;->invalidateActivityBadge()V

    .line 133
    return-void
.end method
