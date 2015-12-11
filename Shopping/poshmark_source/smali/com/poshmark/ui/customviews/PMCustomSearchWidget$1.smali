.class Lcom/poshmark/ui/customviews/PMCustomSearchWidget$1;
.super Ljava/lang/Object;
.source "PMCustomSearchWidget.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setup()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$1;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 81
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 62
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 66
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 67
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$1;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->clearButton:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 76
    :cond_0
    :goto_0
    return-void

    .line 69
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$1;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->clearButton:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 70
    if-eqz p1, :cond_2

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-nez v0, :cond_0

    .line 71
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$1;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$1;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    invoke-interface {v0}, Lcom/poshmark/utils/PMSearchViewListener;->clearSearchString()V

    goto :goto_0
.end method
