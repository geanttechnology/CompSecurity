.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$2;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment_Offers.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;)V
    .locals 0

    .prologue
    .line 311
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$2;->this$1:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public dialogDismissed()V
    .locals 2

    .prologue
    .line 314
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$2;->this$1:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->val$order:Lcom/poshmark/data_model/models/PMOrder;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderListingId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingEditedMessage(Ljava/lang/String;)V

    .line 315
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$2;->this$1:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->done(I)V

    .line 316
    return-void
.end method
