.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$2;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;)V
    .locals 0

    .prologue
    .line 185
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    const/4 v1, 0x0

    .line 188
    const-string v0, "fb"

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->unlinkExternalService(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 189
    const/4 v0, 0x0

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->postFacebookTimelineFlag(ZLcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 190
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->clearFacebookInfo()V

    .line 191
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->logout()V

    .line 192
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateFBShareLayout()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$300(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    .line 193
    return-void
.end method
