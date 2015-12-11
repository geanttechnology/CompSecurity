.class Lcom/poshmark/ui/customviews/PMCustomSearchWidget$6;
.super Ljava/lang/Object;
.source "PMCustomSearchWidget.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 140
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$6;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$6;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setText(Ljava/lang/CharSequence;)V

    .line 144
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$6;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->clearButton:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 145
    return-void
.end method
