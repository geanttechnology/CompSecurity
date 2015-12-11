.class public Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;
.super Landroid/app/Service;
.source "SourceFile"


# static fields
.field private static c:Lcom/bestbuy/android/bbyobjects/BBYTextView;


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 516
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 517
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 509
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->b:Landroid/widget/ImageView;

    return-object v0
.end method

.method public static c()V
    .locals 3

    .prologue
    .line 622
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_0

    .line 623
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->d()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 624
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 626
    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    const/4 v6, -0x2

    .line 545
    const-string v0, "window"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 546
    const-string v1, "layout_inflater"

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    .line 547
    new-instance v2, Landroid/view/WindowManager$LayoutParams;

    invoke-direct {v2}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    .line 548
    const/16 v3, 0x33

    iput v3, v2, Landroid/view/WindowManager$LayoutParams;->gravity:I

    .line 549
    new-instance v3, Landroid/util/DisplayMetrics;

    invoke-direct {v3}, Landroid/util/DisplayMetrics;-><init>()V

    .line 550
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    invoke-virtual {v4, v3}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 551
    iget v4, v3, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v5, v3, Landroid/util/DisplayMetrics;->widthPixels:I

    div-int/lit8 v5, v5, 0x4

    sub-int/2addr v4, v5

    iput v4, v2, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 552
    iget v4, v3, Landroid/util/DisplayMetrics;->heightPixels:I

    iget v3, v3, Landroid/util/DisplayMetrics;->heightPixels:I

    div-int/lit8 v3, v3, 0x4

    sub-int v3, v4, v3

    iput v3, v2, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 553
    const/16 v3, 0x7d3

    iput v3, v2, Landroid/view/WindowManager$LayoutParams;->type:I

    .line 554
    const v3, 0x20108

    iput v3, v2, Landroid/view/WindowManager$LayoutParams;->flags:I

    .line 556
    const/4 v3, -0x3

    iput v3, v2, Landroid/view/WindowManager$LayoutParams;->format:I

    .line 557
    iput v6, v2, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 558
    iput v6, v2, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 560
    const v3, 0x7f030020

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v1, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a:Landroid/view/View;

    .line 561
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a:Landroid/view/View;

    const v3, 0x7f0c009f

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->b:Landroid/widget/ImageView;

    .line 562
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a:Landroid/view/View;

    const v3, 0x7f0c00a0

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 563
    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->d()I

    move-result v1

    if-lez v1, :cond_0

    .line 564
    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->c()V

    .line 566
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a:Landroid/view/View;

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 567
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a:Landroid/view/View;

    new-instance v3, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$1;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$1;-><init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;)V

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 582
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->b:Landroid/widget/ImageView;

    new-instance v3, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;

    invoke-direct {v3, p0, v2, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;-><init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)V

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 612
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 615
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 616
    const-string v0, "window"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 617
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a:Landroid/view/View;

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeView(Landroid/view/View;)V

    .line 619
    :cond_0
    return-void
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 532
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 0

    .prologue
    .line 521
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 522
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 537
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 538
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->b()V

    .line 539
    sput-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 540
    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->b:Landroid/widget/ImageView;

    .line 541
    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a:Landroid/view/View;

    .line 542
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1

    .prologue
    .line 526
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a()V

    .line 527
    invoke-super {p0, p1, p2, p3}, Landroid/app/Service;->onStartCommand(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method
