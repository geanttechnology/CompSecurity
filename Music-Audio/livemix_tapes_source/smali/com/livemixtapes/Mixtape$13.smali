.class Lcom/livemixtapes/Mixtape$13;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->setProgressOnUiThreadWithPos(II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;

.field private final synthetic val$pos:I

.field private final synthetic val$progress:I


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;II)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$13;->this$0:Lcom/livemixtapes/Mixtape;

    iput p2, p0, Lcom/livemixtapes/Mixtape$13;->val$pos:I

    iput p3, p0, Lcom/livemixtapes/Mixtape$13;->val$progress:I

    .line 1205
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 1208
    iget v1, p0, Lcom/livemixtapes/Mixtape$13;->val$pos:I

    iget-object v2, p0, Lcom/livemixtapes/Mixtape$13;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v2}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 1216
    :cond_0
    :goto_0
    return-void

    .line 1210
    :cond_1
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$13;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v1

    iget v2, p0, Lcom/livemixtapes/Mixtape$13;->val$pos:I

    .line 1211
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$13;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v3

    sub-int/2addr v2, v3

    .line 1210
    invoke-virtual {v1, v2}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 1212
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 1214
    const v1, 0x7f080138

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    .line 1215
    iget v2, p0, Lcom/livemixtapes/Mixtape$13;->val$progress:I

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setProgress(I)V

    goto :goto_0
.end method
