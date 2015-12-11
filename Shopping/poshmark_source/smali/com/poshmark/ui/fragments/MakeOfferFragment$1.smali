.class Lcom/poshmark/ui/fragments/MakeOfferFragment$1;
.super Ljava/lang/Object;
.source "MakeOfferFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MakeOfferFragment;->setupView(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MakeOfferFragment;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$1;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 87
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 88
    .local v0, "fragmentData":Landroid/os/Bundle;
    const-string v2, "URL"

    const-string v3, "https://www.poshmark.com/mapp/offers_help"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "offers_help_screen"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$1;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 91
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 92
    return-void
.end method
