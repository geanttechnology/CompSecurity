.class Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;
.super Landroid/os/CountDownTimer;
.source "ViewPagerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/adapter/ViewPagerAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ReleaseTimer"
.end annotation


# instance fields
.field private dayValue:J

.field private days:Landroid/widget/TextView;

.field private hourValue:J

.field private hours:Landroid/widget/TextView;

.field private mins:Landroid/widget/TextView;

.field private minuteValue:J

.field private secondValue:J

.field private secs:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/livemixtapes/adapter/ViewPagerAdapter;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/adapter/ViewPagerAdapter;Landroid/view/View;J)V
    .locals 4
    .param p2, "parent"    # Landroid/view/View;
    .param p3, "sec"    # J

    .prologue
    const-wide/16 v2, 0x3e8

    .line 143
    iput-object p1, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->this$0:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    .line 144
    mul-long v0, p3, v2

    invoke-direct {p0, v0, v1, v2, v3}, Landroid/os/CountDownTimer;-><init>(JJ)V

    .line 146
    const v0, 0x7f08007b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->days:Landroid/widget/TextView;

    .line 147
    const v0, 0x7f08007c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->hours:Landroid/widget/TextView;

    .line 148
    const v0, 0x7f08007d

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->mins:Landroid/widget/TextView;

    .line 149
    const v0, 0x7f08007e

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->secs:Landroid/widget/TextView;

    .line 151
    invoke-virtual {p0}, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->start()Landroid/os/CountDownTimer;

    .line 152
    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 0

    .prologue
    .line 186
    return-void
.end method

.method public onTick(J)V
    .locals 14
    .param p1, "millisUntilFinished"    # J

    .prologue
    .line 156
    const-wide/32 v8, 0x5265c00

    div-long v0, p1, v8

    .line 157
    .local v0, "day":J
    const-wide/32 v8, 0x36ee80

    div-long v8, p1, v8

    const-wide/16 v10, 0x18

    mul-long/2addr v10, v0

    sub-long v2, v8, v10

    .line 158
    .local v2, "hour":J
    const-wide/32 v8, 0xea60

    div-long v8, p1, v8

    const-wide/16 v10, 0x3c

    mul-long/2addr v10, v2

    sub-long/2addr v8, v10

    const-wide/16 v10, 0x18

    mul-long/2addr v10, v0

    const-wide/16 v12, 0x3c

    mul-long/2addr v10, v12

    sub-long v4, v8, v10

    .line 159
    .local v4, "minute":J
    const-wide/16 v8, 0x3e8

    div-long v8, p1, v8

    const-wide/16 v10, 0x3c

    mul-long/2addr v10, v4

    sub-long/2addr v8, v10

    const-wide/16 v10, 0x3c

    mul-long/2addr v10, v2

    const-wide/16 v12, 0x3c

    mul-long/2addr v10, v12

    sub-long/2addr v8, v10

    const-wide/16 v10, 0x18

    mul-long/2addr v10, v0

    const-wide/16 v12, 0x3c

    mul-long/2addr v10, v12

    const-wide/16 v12, 0x3c

    mul-long/2addr v10, v12

    sub-long v6, v8, v10

    .line 163
    .local v6, "second":J
    iget-wide v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->dayValue:J

    cmp-long v8, v0, v8

    if-eqz v8, :cond_0

    .line 164
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->days:Landroid/widget/TextView;

    const-string v9, "%02d"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 165
    iput-wide v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->dayValue:J

    .line 168
    :cond_0
    iget-wide v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->hourValue:J

    cmp-long v8, v2, v8

    if-eqz v8, :cond_1

    .line 169
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->hours:Landroid/widget/TextView;

    const-string v9, "%02d"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 170
    iput-wide v2, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->hourValue:J

    .line 173
    :cond_1
    iget-wide v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->minuteValue:J

    cmp-long v8, v4, v8

    if-eqz v8, :cond_2

    .line 174
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->mins:Landroid/widget/TextView;

    const-string v9, "%02d"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 175
    iput-wide v4, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->minuteValue:J

    .line 178
    :cond_2
    iget-wide v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->secondValue:J

    cmp-long v8, v6, v8

    if-eqz v8, :cond_3

    .line 179
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->secs:Landroid/widget/TextView;

    const-string v9, "%02d"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 180
    iput-wide v6, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;->secondValue:J

    .line 182
    :cond_3
    return-void
.end method
