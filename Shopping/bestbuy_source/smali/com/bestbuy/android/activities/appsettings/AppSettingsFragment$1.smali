.class Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment$1;->a:Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 65
    const-string v0, "AppSettingsEnvironmentFragment"

    invoke-static {v0}, Lkb;->a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v1

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment$1;->a:Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;->a(Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v2, 0x7f0c0033

    const-string v3, "AppSettingsEnvironmentFragment"

    invoke-virtual {v0, v2, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 67
    return-void
.end method
