.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$2;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->setupHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 194
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->CHANGE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    .line 195
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->launchCheckoutForm(Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;)V

    .line 196
    return-void
.end method
