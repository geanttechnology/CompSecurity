.class Lcom/livemixtapes/Mixtapes$14$1;
.super Ljava/lang/Object;
.source "Mixtapes.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtapes$14;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/Mixtapes$14;

.field private final synthetic val$data:Ljava/util/ArrayList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtapes$14;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$14$1;->this$1:Lcom/livemixtapes/Mixtapes$14;

    iput-object p2, p0, Lcom/livemixtapes/Mixtapes$14$1;->val$data:Ljava/util/ArrayList;

    .line 647
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 650
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$14$1;->this$1:Lcom/livemixtapes/Mixtapes$14;

    # getter for: Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;
    invoke-static {v0}, Lcom/livemixtapes/Mixtapes$14;->access$0(Lcom/livemixtapes/Mixtapes$14;)Lcom/livemixtapes/Mixtapes;

    move-result-object v0

    iget v0, v0, Lcom/livemixtapes/Mixtapes;->pageCount:I

    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$14$1;->val$data:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 651
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$14$1;->this$1:Lcom/livemixtapes/Mixtapes$14;

    # getter for: Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;
    invoke-static {v0}, Lcom/livemixtapes/Mixtapes$14;->access$0(Lcom/livemixtapes/Mixtapes$14;)Lcom/livemixtapes/Mixtapes;

    move-result-object v0

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$14$1;->this$1:Lcom/livemixtapes/Mixtapes$14;

    # getter for: Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;
    invoke-static {v1}, Lcom/livemixtapes/Mixtapes$14;->access$0(Lcom/livemixtapes/Mixtapes$14;)Lcom/livemixtapes/Mixtapes;

    move-result-object v1

    iget v1, v1, Lcom/livemixtapes/Mixtapes;->pageCount:I

    invoke-virtual {v0, v1, v2}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->setCurrentItem(IZ)V

    .line 653
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$14$1;->this$1:Lcom/livemixtapes/Mixtapes$14;

    # getter for: Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;
    invoke-static {v0}, Lcom/livemixtapes/Mixtapes$14;->access$0(Lcom/livemixtapes/Mixtapes$14;)Lcom/livemixtapes/Mixtapes;

    move-result-object v0

    iget v1, v0, Lcom/livemixtapes/Mixtapes;->pageCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/livemixtapes/Mixtapes;->pageCount:I

    .line 659
    :goto_0
    return-void

    .line 655
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$14$1;->this$1:Lcom/livemixtapes/Mixtapes$14;

    # getter for: Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;
    invoke-static {v0}, Lcom/livemixtapes/Mixtapes$14;->access$0(Lcom/livemixtapes/Mixtapes$14;)Lcom/livemixtapes/Mixtapes;

    move-result-object v0

    const/4 v1, 0x0

    iput v1, v0, Lcom/livemixtapes/Mixtapes;->pageCount:I

    .line 657
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$14$1;->this$1:Lcom/livemixtapes/Mixtapes$14;

    # getter for: Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;
    invoke-static {v0}, Lcom/livemixtapes/Mixtapes$14;->access$0(Lcom/livemixtapes/Mixtapes$14;)Lcom/livemixtapes/Mixtapes;

    move-result-object v0

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$14$1;->this$1:Lcom/livemixtapes/Mixtapes$14;

    # getter for: Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;
    invoke-static {v1}, Lcom/livemixtapes/Mixtapes$14;->access$0(Lcom/livemixtapes/Mixtapes$14;)Lcom/livemixtapes/Mixtapes;

    move-result-object v1

    iget v1, v1, Lcom/livemixtapes/Mixtapes;->pageCount:I

    invoke-virtual {v0, v1, v2}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->setCurrentItem(IZ)V

    goto :goto_0
.end method
