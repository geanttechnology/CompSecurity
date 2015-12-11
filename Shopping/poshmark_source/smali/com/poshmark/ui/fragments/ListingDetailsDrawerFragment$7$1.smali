.class Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7$1;
.super Ljava/lang/Object;
.source "ListingDetailsDrawerFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;)V
    .locals 0

    .prologue
    .line 288
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .prologue
    .line 291
    const/4 v1, -0x1

    if-ne p2, v1, :cond_0

    .line 292
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 293
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "PARENT_ID"

    new-instance v2, Landroid/os/ParcelUuid;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 294
    const-string v1, "com.poshmark.intents.DELETE_LISTING_ACTION"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 296
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method
