.class Lcom/poshmark/ui/fragments/MakeOfferFragment$2;
.super Ljava/lang/Object;
.source "MakeOfferFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MakeOfferFragment;->setupView(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MakeOfferFragment;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$2;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 3
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 108
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 109
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$2;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 110
    .local v0, "newText":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$2;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerText:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 111
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$2;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$2;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v2

    invoke-static {v1, v2}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    .line 113
    .end local v0    # "newText":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 99
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 104
    return-void
.end method
