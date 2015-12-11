.class Lcom/poshmark/ui/fragments/FindPeopleFragment$3;
.super Ljava/lang/Object;
.source "FindPeopleFragment.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindPeopleFragment;->showTwitterFriends()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 3
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 223
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->hideProgressDialog()V

    .line 224
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_TWITTER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, p1, v2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 225
    return-void
.end method

.method public success(ILandroid/os/Bundle;)V
    .locals 1
    .param p1, "accessLevel"    # I
    .param p2, "loginBundle"    # Landroid/os/Bundle;

    .prologue
    .line 229
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->hideProgressDialog()V

    .line 230
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    # invokes: Lcom/poshmark/ui/fragments/FindPeopleFragment;->fetchTwitterFriends()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$100(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    .line 231
    return-void
.end method
