.class Lcom/livemixtapes/Mixtape$5;
.super Landroid/os/CountDownTimer;
.source "Mixtape.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;JJ)V
    .locals 0
    .param p2, "$anonymous0"    # J
    .param p4, "$anonymous1"    # J

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    .line 494
    invoke-direct {p0, p2, p3, p4, p5}, Landroid/os/CountDownTimer;-><init>(JJ)V

    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 0

    .prologue
    .line 569
    return-void
.end method

.method public onTick(J)V
    .locals 8
    .param p1, "millisUntilFinished"    # J

    .prologue
    const-wide/16 v6, 0x18

    const-wide/16 v4, 0x3c

    .line 499
    const-wide/32 v0, 0x5265c00

    div-long v0, p1, v0

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$2(J)V

    .line 500
    const-wide/32 v0, 0x36ee80

    div-long v0, p1, v0

    # getter for: Lcom/livemixtapes/Mixtape;->tempDay:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$3()J

    move-result-wide v2

    mul-long/2addr v2, v6

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$4(J)V

    .line 501
    const-wide/32 v0, 0xea60

    div-long v0, p1, v0

    # getter for: Lcom/livemixtapes/Mixtape;->tempHour:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$5()J

    move-result-wide v2

    mul-long/2addr v2, v4

    sub-long/2addr v0, v2

    # getter for: Lcom/livemixtapes/Mixtape;->tempDay:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$3()J

    move-result-wide v2

    mul-long/2addr v2, v6

    mul-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$6(J)V

    .line 502
    const-wide/16 v0, 0x3e8

    div-long v0, p1, v0

    # getter for: Lcom/livemixtapes/Mixtape;->tempMinute:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$7()J

    move-result-wide v2

    mul-long/2addr v2, v4

    sub-long/2addr v0, v2

    # getter for: Lcom/livemixtapes/Mixtape;->tempHour:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$5()J

    move-result-wide v2

    mul-long/2addr v2, v4

    mul-long/2addr v2, v4

    sub-long/2addr v0, v2

    # getter for: Lcom/livemixtapes/Mixtape;->tempDay:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$3()J

    move-result-wide v2

    mul-long/2addr v2, v6

    mul-long/2addr v2, v4

    mul-long/2addr v2, v4

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$8(J)V

    .line 504
    const-string v0, "COUNTER"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "DAYS: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lcom/livemixtapes/Mixtape;->tempDay:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$3()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 505
    const-string v0, "COUNTER"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "HOURS: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lcom/livemixtapes/Mixtape;->tempHour:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$5()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 506
    const-string v0, "COUNTER"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "MINUTES: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lcom/livemixtapes/Mixtape;->tempMinute:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$7()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 507
    const-string v0, "COUNTER"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "SECONDS: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lcom/livemixtapes/Mixtape;->tempSecond:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$9()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 509
    # getter for: Lcom/livemixtapes/Mixtape;->tempDay:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$3()J

    move-result-wide v0

    # getter for: Lcom/livemixtapes/Mixtape;->dayValue:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$10()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 512
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v0, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v0, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v2, 0x7f0800a5

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-static {v1, v0}, Lcom/livemixtapes/Mixtape;->access$11(Lcom/livemixtapes/Mixtape;Landroid/widget/TextView;)V

    .line 514
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->countText:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/livemixtapes/Mixtape;->access$12(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    # getter for: Lcom/livemixtapes/Mixtape;->tempDay:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$3()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 517
    # getter for: Lcom/livemixtapes/Mixtape;->tempDay:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$3()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$13(J)V

    .line 520
    :cond_0
    # getter for: Lcom/livemixtapes/Mixtape;->tempHour:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$5()J

    move-result-wide v0

    # getter for: Lcom/livemixtapes/Mixtape;->hourValue:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$14()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 524
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v0, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v0, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v2, 0x7f0800a6

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-static {v1, v0}, Lcom/livemixtapes/Mixtape;->access$11(Lcom/livemixtapes/Mixtape;Landroid/widget/TextView;)V

    .line 526
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->countText:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/livemixtapes/Mixtape;->access$12(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    # getter for: Lcom/livemixtapes/Mixtape;->tempHour:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$5()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 529
    # getter for: Lcom/livemixtapes/Mixtape;->tempHour:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$5()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$15(J)V

    .line 532
    :cond_1
    # getter for: Lcom/livemixtapes/Mixtape;->tempMinute:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$7()J

    move-result-wide v0

    # getter for: Lcom/livemixtapes/Mixtape;->minuteValue:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$16()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-eqz v0, :cond_2

    .line 536
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v0, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v0, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v2, 0x7f0800a7

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-static {v1, v0}, Lcom/livemixtapes/Mixtape;->access$11(Lcom/livemixtapes/Mixtape;Landroid/widget/TextView;)V

    .line 538
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->countText:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/livemixtapes/Mixtape;->access$12(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    # getter for: Lcom/livemixtapes/Mixtape;->tempMinute:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$7()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 542
    # getter for: Lcom/livemixtapes/Mixtape;->tempMinute:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$7()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$17(J)V

    .line 545
    :cond_2
    # getter for: Lcom/livemixtapes/Mixtape;->tempSecond:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$9()J

    move-result-wide v0

    # getter for: Lcom/livemixtapes/Mixtape;->secondValue:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$18()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-eqz v0, :cond_3

    .line 550
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v0, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v0, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v2, 0x7f0800a8

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-static {v1, v0}, Lcom/livemixtapes/Mixtape;->access$11(Lcom/livemixtapes/Mixtape;Landroid/widget/TextView;)V

    .line 552
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$5;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->countText:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/livemixtapes/Mixtape;->access$12(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    # getter for: Lcom/livemixtapes/Mixtape;->tempSecond:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$9()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 555
    # getter for: Lcom/livemixtapes/Mixtape;->tempSecond:J
    invoke-static {}, Lcom/livemixtapes/Mixtape;->access$9()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtape;->access$19(J)V

    .line 563
    :cond_3
    return-void
.end method
