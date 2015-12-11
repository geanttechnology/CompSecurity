.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$11;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment;->setFacebookPostToTimelineSettings(Z)V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0

    .prologue
    .line 433
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$11;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

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
    .line 436
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$11;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 437
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$11;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->handleChangeSettingsResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$900(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Lcom/poshmark/http/api/PMApiResponse;)V

    .line 439
    :cond_0
    return-void
.end method
