.class Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$2;
.super Ljava/lang/Object;
.source "ThumbSwitcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->showProgress()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)V
    .locals 0

    .prologue
    .line 326
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$2;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 330
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$2;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressRunning:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$802(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Z)Z

    .line 331
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$2;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->showProgress()V
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$900(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)V

    .line 332
    return-void
.end method
