.class Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;
.super Lco/vine/android/widget/tabs/TabsAdapter;
.source "HomeTabActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/HomeTabActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HomeTabTabsAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/HomeTabActivity;


# direct methods
.method public constructor <init>(Lco/vine/android/HomeTabActivity;Landroid/widget/TabHost;)V
    .locals 2
    .param p2, "tabHost"    # Landroid/widget/TabHost;

    .prologue
    .line 463
    iput-object p1, p0, Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;->this$0:Lco/vine/android/HomeTabActivity;

    .line 464
    # getter for: Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;
    invoke-static {p1}, Lco/vine/android/HomeTabActivity;->access$400(Lco/vine/android/HomeTabActivity;)Landroid/support/v4/view/ViewPager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lco/vine/android/widget/tabs/TabsAdapter;-><init>(Lco/vine/android/BaseControllerActionBarActivity;Landroid/widget/TabHost;Landroid/support/v4/view/ViewPager;Lco/vine/android/widget/tabs/ViewPagerScrollBar;)V

    .line 465
    return-void
.end method


# virtual methods
.method public onPageSelected(I)V
    .locals 3
    .param p1, "position"    # I

    .prologue
    const/4 v2, 0x0

    .line 469
    invoke-super {p0, p1}, Lco/vine/android/widget/tabs/TabsAdapter;->onPageSelected(I)V

    .line 470
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-virtual {v0}, Lco/vine/android/HomeTabActivity;->resetNav()V

    .line 471
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 472
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-virtual {v0}, Lco/vine/android/HomeTabActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "unread_notification_count"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 474
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;->this$0:Lco/vine/android/HomeTabActivity;

    # setter for: Lco/vine/android/HomeTabActivity;->mActivityCount:I
    invoke-static {v0, v2}, Lco/vine/android/HomeTabActivity;->access$002(Lco/vine/android/HomeTabActivity;I)I

    .line 475
    iget-object v0, p0, Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;->this$0:Lco/vine/android/HomeTabActivity;

    invoke-virtual {v0}, Lco/vine/android/HomeTabActivity;->invalidateActivityBadge()V

    .line 477
    :cond_0
    return-void
.end method
