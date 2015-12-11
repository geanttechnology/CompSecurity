.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2$1;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;->onClick(Landroid/content/DialogInterface;I)V
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
.field final synthetic this$2:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;)V
    .locals 0

    .prologue
    .line 338
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2$1;->this$2:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;

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
    .line 341
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2$1;->this$2:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->hideProgressDialog()V

    .line 342
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 343
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->clearGoogleInfo()V

    .line 344
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2$1;->this$2:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateGoogleShareLayout()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$700(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    .line 346
    :cond_0
    return-void
.end method
