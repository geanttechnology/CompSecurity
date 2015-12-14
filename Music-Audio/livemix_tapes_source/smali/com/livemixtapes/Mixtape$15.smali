.class Lcom/livemixtapes/Mixtape$15;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->updatePlayListSelectionBackground(IZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;

.field private final synthetic val$isSelected:Z

.field private final synthetic val$pos:I


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;IZ)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$15;->this$0:Lcom/livemixtapes/Mixtape;

    iput p2, p0, Lcom/livemixtapes/Mixtape$15;->val$pos:I

    iput-boolean p3, p0, Lcom/livemixtapes/Mixtape$15;->val$isSelected:Z

    .line 1242
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 1245
    iget v2, p0, Lcom/livemixtapes/Mixtape$15;->val$pos:I

    if-gez v2, :cond_1

    .line 1261
    :cond_0
    :goto_0
    return-void

    .line 1247
    :cond_1
    iget-object v2, p0, Lcom/livemixtapes/Mixtape$15;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v2}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v2

    iget v3, p0, Lcom/livemixtapes/Mixtape$15;->val$pos:I

    iget-object v4, p0, Lcom/livemixtapes/Mixtape$15;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v4}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v4

    add-int/2addr v3, v4

    iget-object v4, p0, Lcom/livemixtapes/Mixtape$15;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v4}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v4

    sub-int/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1248
    .local v1, "v":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 1251
    const v2, 0x7f080134

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 1252
    .local v0, "selectionView":Landroid/view/View;
    iget-boolean v2, p0, Lcom/livemixtapes/Mixtape$15;->val$isSelected:Z

    if-eqz v2, :cond_2

    .line 1253
    const-string v2, "#000080"

    invoke-static {v2}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundColor(I)V

    .line 1257
    :goto_1
    iget-object v2, p0, Lcom/livemixtapes/Mixtape$15;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v2, v2, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_3

    .line 1258
    iget-object v2, p0, Lcom/livemixtapes/Mixtape$15;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v2, v2, Lcom/livemixtapes/Mixtape;->addTracksButton:Landroid/widget/Button;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Add "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/livemixtapes/Mixtape$15;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v4, v4, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " Track(s)"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 1255
    :cond_2
    const v2, 0x7f020062

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_1

    .line 1260
    :cond_3
    iget-object v2, p0, Lcom/livemixtapes/Mixtape$15;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v2, v2, Lcom/livemixtapes/Mixtape;->addTracksButton:Landroid/widget/Button;

    const-string v3, "Tap the tracks you want to add"

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
