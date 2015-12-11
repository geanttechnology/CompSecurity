.class Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;
.super Ljava/lang/Object;
.source "ListingsFilterWidget.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/ListingsFilterWidget;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ButtonInfo"
.end annotation


# instance fields
.field button:Landroid/widget/Button;

.field buttonText:Lcom/poshmark/ui/customviews/PMTextView;

.field buttonType:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

.field label:Ljava/lang/String;

.field layout:Landroid/widget/LinearLayout;

.field mClickListener:Landroid/view/View$OnClickListener;

.field textView:Lcom/poshmark/ui/customviews/PMTextView;

.field final synthetic this$0:Lcom/poshmark/ui/customviews/ListingsFilterWidget;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V
    .locals 2
    .param p2, "label"    # Ljava/lang/String;
    .param p3, "type"    # Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;
    .param p4, "filter_action"    # I
    .param p5, "buttonLayoutId"    # I
    .param p6, "buttonId"    # I
    .param p7, "labelId"    # I

    .prologue
    .line 346
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->this$0:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 347
    iput-object p2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->label:Ljava/lang/String;

    .line 348
    iput-object p3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->buttonType:Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;

    .line 349
    new-instance v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo$1;

    invoke-direct {v0, p0, p1, p4}, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo$1;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;Lcom/poshmark/ui/customviews/ListingsFilterWidget;I)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->mClickListener:Landroid/view/View$OnClickListener;

    .line 357
    iget-boolean v0, p1, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->isG2FiltersEnabled:Z

    if-eqz v0, :cond_0

    .line 358
    invoke-virtual {p1, p6}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->buttonText:Lcom/poshmark/ui/customviews/PMTextView;

    .line 359
    invoke-virtual {p1, p7}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 360
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->buttonText:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, p2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 361
    invoke-virtual {p1, p5}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->layout:Landroid/widget/LinearLayout;

    .line 362
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->layout:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->mClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 369
    :goto_0
    return-void

    .line 364
    :cond_0
    invoke-virtual {p1, p6}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    .line 365
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    invoke-virtual {v0, p2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 366
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->button:Landroid/widget/Button;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;->mClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method
