.class Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a()V
.end annotation


# instance fields
.field final synthetic a:Landroid/view/WindowManager$LayoutParams;

.field final synthetic b:Landroid/view/WindowManager;

.field final synthetic c:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

.field private d:Landroid/view/WindowManager$LayoutParams;

.field private e:I

.field private f:I

.field private g:F

.field private h:F


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)V
    .locals 1

    .prologue
    .line 582
    iput-object p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->c:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    iput-object p2, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->a:Landroid/view/WindowManager$LayoutParams;

    iput-object p3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->b:Landroid/view/WindowManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 583
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->a:Landroid/view/WindowManager$LayoutParams;

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->d:Landroid/view/WindowManager$LayoutParams;

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 4

    .prologue
    .line 591
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 608
    :goto_0
    :pswitch_0
    const/4 v0, 0x0

    return v0

    .line 593
    :pswitch_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->d:Landroid/view/WindowManager$LayoutParams;

    iget v0, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    iput v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->e:I

    .line 594
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->d:Landroid/view/WindowManager$LayoutParams;

    iget v0, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    iput v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->f:I

    .line 595
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->g:F

    .line 596
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->h:F

    goto :goto_0

    .line 602
    :pswitch_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->d:Landroid/view/WindowManager$LayoutParams;

    iget v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->e:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v2

    iget v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->g:F

    sub-float/2addr v2, v3

    float-to-int v2, v2

    add-int/2addr v1, v2

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 603
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->d:Landroid/view/WindowManager$LayoutParams;

    iget v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->f:I

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v2

    iget v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->h:F

    sub-float/2addr v2, v3

    float-to-int v2, v2

    add-int/2addr v1, v2

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 604
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->b:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->c:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-static {v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;)Landroid/widget/ImageView;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$2;->d:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 591
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
