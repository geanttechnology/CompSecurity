.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;
.super Landroid/widget/LinearLayout;
.source "ErrorView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Ljava/lang/Exception;",
        ">;"
    }
.end annotation


# instance fields
.field private errorText:Landroid/widget/TextView;

.field private retryBtn:Landroid/widget/Button;

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 29
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 31
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_request_error:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 33
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_request_error_text:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->errorText:Landroid/widget/TextView;

    .line 34
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_request_error_retry:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->retryBtn:Landroid/widget/Button;

    .line 35
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->retryBtn:Landroid/widget/Button;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    return-void
.end method


# virtual methods
.method public build(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "model"    # Ljava/lang/Exception;

    .prologue
    .line 49
    if-nez p1, :cond_1

    const/4 v0, 0x0

    .line 50
    .local v0, "throwable":Ljava/lang/Throwable;
    :goto_0
    const-class v1, Ljava/net/UnknownHostException;

    invoke-virtual {v1, v0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-class v1, Ljava/net/SocketException;

    invoke-virtual {v1, v0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 53
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->errorText:Landroid/widget/TextView;

    sget v2, Lcom/amazon/retailsearch/R$string;->rs_results_error_connectivity:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 59
    :goto_1
    return-void

    .line 49
    .end local v0    # "throwable":Ljava/lang/Throwable;
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    goto :goto_0

    .line 57
    .restart local v0    # "throwable":Ljava/lang/Throwable;
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->errorText:Landroid/widget/TextView;

    sget v2, Lcom/amazon/retailsearch/R$string;->rs_results_error_generic:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 17
    check-cast p1, Ljava/lang/Exception;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->build(Ljava/lang/Exception;)V

    return-void
.end method
