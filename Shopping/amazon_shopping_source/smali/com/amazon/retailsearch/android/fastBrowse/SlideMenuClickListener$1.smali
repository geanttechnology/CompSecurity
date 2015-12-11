.class Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;
.super Ljava/lang/Object;
.source "SlideMenuClickListener.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fetchRefinements()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 141
    new-instance v0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;

    new-instance v2, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;

    invoke-direct {v2, p0}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;)V

    const-string/jumbo v1, "/s/browse/categories"

    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->browseUrl:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$600(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    invoke-direct {v0, v2, v1}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;Ljava/lang/String;)V

    .line 197
    .local v0, "loader":Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->getRefinements()V

    .line 198
    return-void

    .line 141
    .end local v0    # "loader":Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->browseUrl:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$600(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method
