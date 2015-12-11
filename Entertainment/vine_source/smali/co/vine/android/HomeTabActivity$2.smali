.class Lco/vine/android/HomeTabActivity$2;
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
    .line 140
    iput-object p1, p0, Lco/vine/android/HomeTabActivity$2;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 144
    iget-object v2, p0, Lco/vine/android/HomeTabActivity$2;->this$0:Lco/vine/android/HomeTabActivity;

    # getter for: Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;
    invoke-static {v2}, Lco/vine/android/HomeTabActivity;->access$300(Lco/vine/android/HomeTabActivity;)Lco/vine/android/widget/tabs/TabsAdapter;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getTab(I)Lco/vine/android/widget/tabs/TabInfo;

    move-result-object v1

    .line 145
    .local v1, "tab":Lco/vine/android/widget/tabs/TabInfo;
    if-eqz v1, :cond_0

    .line 146
    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 147
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v2, v0, Lco/vine/android/ExploreFragment;

    if-eqz v2, :cond_0

    .line 148
    check-cast v0, Lco/vine/android/ExploreFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0}, Lco/vine/android/ExploreFragment;->reloadWebView()V

    .line 151
    :cond_0
    return-void
.end method
