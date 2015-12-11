.class Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$5;
.super Ljava/lang/Object;
.source "ListingConditionPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->initViewState(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 194
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 195
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    const-string v3, "https://www.poshmark.com/mapp/nwt_policy"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "nwt_policy_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 198
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 199
    return-void
.end method
