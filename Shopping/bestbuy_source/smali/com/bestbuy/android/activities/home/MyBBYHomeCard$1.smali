.class Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/MyBBYHomeCard;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/MyBBYHomeCard;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;->a:Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;->a:Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/activities/home/MyBBYHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 183
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;->a:Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/activities/home/MyBBYHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getLineCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;->a:Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/activities/home/MyBBYHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/text/Layout;->getLineEnd(I)I

    move-result v0

    .line 186
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;->a:Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    invoke-static {v2}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/activities/home/MyBBYHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    add-int/lit8 v3, v0, -0x19

    sub-int/2addr v0, v3

    invoke-interface {v2, v4, v0}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "..."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 187
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;->a:Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/activities/home/MyBBYHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 189
    :cond_0
    return-void
.end method
