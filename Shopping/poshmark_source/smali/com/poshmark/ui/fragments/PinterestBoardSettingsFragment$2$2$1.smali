.class Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2$1;
.super Ljava/lang/Object;
.source "PinterestBoardSettingsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;->onClick(Landroid/content/DialogInterface;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$2:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2$1;->this$2:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 194
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->pinterestUnlink()V

    .line 196
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->unlink()V

    .line 197
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->destroy()V

    .line 199
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2$1;->this$2:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->hideProgressDialog()V

    .line 200
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2$1;->this$2:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 201
    return-void
.end method
