.class public Lcom/bestbuy/android/activities/home/DODHomeCard$1;
.super Landroid/os/CountDownTimer;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/DODHomeCard;->c()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/DODHomeCard;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/DODHomeCard;JJ)V
    .locals 0

    .prologue
    .line 198
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/DODHomeCard$1;->a:Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-direct {p0, p2, p3, p4, p5}, Landroid/os/CountDownTimer;-><init>(JJ)V

    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard$1;->a:Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->b(Lcom/bestbuy/android/activities/home/DODHomeCard;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard$1;->a:Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->b(Lcom/bestbuy/android/activities/home/DODHomeCard;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard$1;->a:Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Lcom/bestbuy/android/activities/home/DODHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v1, "00:00:00"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard$1;->a:Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Lcom/bestbuy/android/activities/home/DODHomeCard;Z)V

    .line 208
    return-void
.end method

.method public onTick(J)V
    .locals 3

    .prologue
    .line 200
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DODHomeCard$1;->a:Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Lcom/bestbuy/android/activities/home/DODHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/DODHomeCard$1;->a:Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-static {v1, p1, p2}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Lcom/bestbuy/android/activities/home/DODHomeCard;J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 201
    return-void
.end method
