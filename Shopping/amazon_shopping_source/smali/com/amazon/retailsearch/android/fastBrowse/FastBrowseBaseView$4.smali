.class Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$4;
.super Ljava/lang/Object;
.source "FastBrowseBaseView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fetchAfterInit()V
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
    .line 251
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$4;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 255
    new-instance v0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$4$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$4$1;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$4;)V

    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$4;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->browseUrl:Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$900(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;Ljava/lang/String;)V

    .line 307
    .local v0, "loader":Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->getRefinements()V

    .line 309
    return-void
.end method
