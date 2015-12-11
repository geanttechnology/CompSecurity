.class Lcom/poshmark/ui/customviews/PMCustomSearchWidget$2;
.super Ljava/lang/Object;
.source "PMCustomSearchWidget.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


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
    .line 84
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$2;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 87
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 88
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$2;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$2;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->searchView:Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMAutoCompleteSearchView;->setText(Ljava/lang/CharSequence;)V

    .line 90
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
