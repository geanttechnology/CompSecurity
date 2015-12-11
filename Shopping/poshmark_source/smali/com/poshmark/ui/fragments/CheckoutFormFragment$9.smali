.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$9;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CheckoutFormFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0

    .prologue
    .line 550
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$9;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 552
    if-eqz p2, :cond_0

    .line 553
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$9;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingAddressLayout:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 558
    :goto_0
    return-void

    .line 556
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$9;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingAddressLayout:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method
