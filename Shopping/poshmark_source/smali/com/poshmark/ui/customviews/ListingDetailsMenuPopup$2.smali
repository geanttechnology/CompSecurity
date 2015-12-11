.class Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$2;
.super Ljava/lang/Object;
.source "ListingDetailsMenuPopup.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->updateDrawer(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$2;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 134
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$2;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v1, v2, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    check-cast v1, Lcom/poshmark/ui/PMContainerActivity;

    .line 135
    .local v1, "parent":Lcom/poshmark/ui/PMContainerActivity;
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$2;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->dismiss()V

    .line 136
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 137
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "PARENT_ID"

    new-instance v3, Landroid/os/ParcelUuid;

    iget-object v4, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$2;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v4, v4, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 138
    const-string v2, "com.poshmark.intents.VIEW_BUNDLE_ACTION"

    invoke-static {v2, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 139
    return-void
.end method
