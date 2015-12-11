.class Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$3;
.super Ljava/lang/Object;
.source "ResultsInfoBar.java"

# interfaces
.implements Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->showRefinementDialog(Landroid/support/v4/app/FragmentActivity;Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$3;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClose()V
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$3;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    # getter for: Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->access$400(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->filterMenuClosed()V

    .line 227
    return-void
.end method
