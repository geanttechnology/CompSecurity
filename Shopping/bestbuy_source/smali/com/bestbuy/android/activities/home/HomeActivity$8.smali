.class Lcom/bestbuy/android/activities/home/HomeActivity$8;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeActivity;->showMyBBYData()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field final synthetic b:Lcom/bestbuy/android/activities/home/HomeActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeActivity;Lcom/bestbuy/android/bbyobjects/BBYTextView;)V
    .locals 0

    .prologue
    .line 1611
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$8;->b:Lcom/bestbuy/android/activities/home/HomeActivity;

    iput-object p2, p0, Lcom/bestbuy/android/activities/home/HomeActivity$8;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 4

    .prologue
    .line 1616
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$8;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 1617
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 1618
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$8;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getLineCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 1620
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$8;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineEnd(I)I

    move-result v0

    .line 1621
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity$8;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    const/4 v3, 0x0

    add-int/lit8 v0, v0, -0xa

    invoke-interface {v2, v3, v0}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "..."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1622
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$8;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 1624
    :cond_0
    return-void
.end method
