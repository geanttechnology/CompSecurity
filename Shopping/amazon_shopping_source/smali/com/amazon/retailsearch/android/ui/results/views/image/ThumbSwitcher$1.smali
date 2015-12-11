.class Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;
.super Lcom/amazon/ansel/fetch/AbstractResourceListener;
.source "ThumbSwitcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->setPosition(IZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/ansel/fetch/AbstractResourceListener",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

.field final synthetic val$imageResource:Lcom/amazon/ansel/fetch/ImageRequest;

.field final synthetic val$initialView:Z

.field final synthetic val$pos:I


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;ZILcom/amazon/ansel/fetch/ImageRequest;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    iput-boolean p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$initialView:Z

    iput p3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$pos:I

    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$imageResource:Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-direct {p0}, Lcom/amazon/ansel/fetch/AbstractResourceListener;-><init>()V

    return-void
.end method


# virtual methods
.method public result(Landroid/graphics/Bitmap;)V
    .locals 5
    .param p1, "image"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 162
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageSubscribers:Ljava/util/List;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, p0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 204
    :cond_0
    :goto_0
    return-void

    .line 167
    :cond_1
    const/4 v0, 0x0

    .line 169
    .local v0, "update":Z
    iget-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$initialView:Z

    if-eqz v3, :cond_5

    .line 171
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadedImage:Z
    invoke-static {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Z

    move-result v3

    if-nez v3, :cond_4

    move v0, v1

    .line 177
    :cond_2
    :goto_1
    if-eqz v0, :cond_0

    .line 179
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # setter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->loadedImage:Z
    invoke-static {v3, v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$102(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Z)Z

    .line 180
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$pos:I

    # setter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->position:I
    invoke-static {v1, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$302(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;I)I

    .line 182
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 184
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    move-result-object v1

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$pos:I

    invoke-virtual {v1, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->setDisplayedImage(I)V

    .line 187
    :cond_3
    if-nez p1, :cond_6

    .line 189
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$400(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hideImage()V

    .line 190
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    const/4 v3, 0x0

    # setter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->displayedImageResource:Lcom/amazon/ansel/fetch/ImageRequest;
    invoke-static {v1, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$502(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Lcom/amazon/ansel/fetch/ImageRequest;)Lcom/amazon/ansel/fetch/ImageRequest;

    .line 197
    :goto_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$pos:I

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->setPagerPosition(I)V
    invoke-static {v1, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$600(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;I)V

    .line 199
    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$initialView:Z

    if-nez v1, :cond_0

    .line 201
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # setter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->progressEnabled:Z
    invoke-static {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$702(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Z)Z

    goto :goto_0

    :cond_4
    move v0, v2

    .line 171
    goto :goto_1

    .line 172
    :cond_5
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    move-result-object v3

    if-eqz v3, :cond_2

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$pos:I

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->productState:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->getRequestedImage()I

    move-result v4

    if-ne v3, v4, :cond_2

    .line 174
    const/4 v0, 0x1

    goto :goto_1

    .line 193
    :cond_6
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$400(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;)Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    move-result-object v1

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$imageResource:Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-virtual {v1, v3, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->showImage(Lcom/amazon/ansel/fetch/ImageRequest;Landroid/graphics/Bitmap;)V

    .line 194
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->val$imageResource:Lcom/amazon/ansel/fetch/ImageRequest;

    # setter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->displayedImageResource:Lcom/amazon/ansel/fetch/ImageRequest;
    invoke-static {v1, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->access$502(Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;Lcom/amazon/ansel/fetch/ImageRequest;)Lcom/amazon/ansel/fetch/ImageRequest;

    goto :goto_2
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 158
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher$1;->result(Landroid/graphics/Bitmap;)V

    return-void
.end method
