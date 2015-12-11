.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$2;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment_Offers.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->setupHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 241
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->CHANGE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    .line 242
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->launchCheckoutForm(Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;)V

    .line 243
    return-void
.end method
