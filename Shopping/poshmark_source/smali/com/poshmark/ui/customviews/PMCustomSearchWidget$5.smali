.class Lcom/poshmark/ui/customviews/PMCustomSearchWidget$5;
.super Ljava/lang/Object;
.source "PMCustomSearchWidget.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


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
    .line 122
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$5;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "b"    # Z

    .prologue
    .line 125
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$5;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-virtual {v0, p2}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setImeVisibility(Z)V

    .line 126
    if-eqz p2, :cond_0

    .line 127
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$5;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$5;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setText(Ljava/lang/CharSequence;)V

    .line 135
    :cond_0
    return-void
.end method
