.class Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView$1;
.super Ljava/lang/Object;
.source "ErrorView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->retrySearch()V

    .line 41
    return-void
.end method
