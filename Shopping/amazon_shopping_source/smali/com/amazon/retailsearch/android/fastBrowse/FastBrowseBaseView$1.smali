.class Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;
.super Ljava/lang/Object;
.source "FastBrowseBaseView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->onCreateListView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReturn(Ljava/lang/String;)V
    .locals 1
    .param p1, "browseUrl"    # Ljava/lang/String;

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 136
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;->onReturn(Ljava/lang/String;)V

    .line 137
    :cond_0
    return-void
.end method

.method public onReturnAIV()V
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;->onReturnAIV()V

    .line 144
    :cond_0
    return-void
.end method

.method public onReturnAPP()V
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;->onReturnAPP()V

    .line 151
    :cond_0
    return-void
.end method
