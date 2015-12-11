.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$7;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->handlePostOrderResponse(Lcom/poshmark/http/api/PMApiResponse;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V
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
    .line 369
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .prologue
    const/4 v1, -0x1

    .line 372
    if-ne p2, v1, :cond_0

    .line 374
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->done(I)V

    .line 376
    :cond_0
    return-void
.end method
