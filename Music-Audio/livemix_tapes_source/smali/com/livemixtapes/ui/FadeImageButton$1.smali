.class Lcom/livemixtapes/ui/FadeImageButton$1;
.super Ljava/lang/Object;
.source "FadeImageButton.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/ui/FadeImageButton;->addEffect()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/ui/FadeImageButton;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ui/FadeImageButton;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ui/FadeImageButton$1;->this$0:Lcom/livemixtapes/ui/FadeImageButton;

    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x0

    .line 36
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 48
    :goto_0
    return v2

    .line 38
    :pswitch_0
    iget-object v0, p0, Lcom/livemixtapes/ui/FadeImageButton$1;->this$0:Lcom/livemixtapes/ui/FadeImageButton;

    const/high16 v1, -0x67000000

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ui/FadeImageButton;->setColorFilter(I)V

    .line 39
    const-string v0, "FadeButton"

    const-string v1, "Darkened"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 43
    :pswitch_1
    iget-object v0, p0, Lcom/livemixtapes/ui/FadeImageButton$1;->this$0:Lcom/livemixtapes/ui/FadeImageButton;

    invoke-virtual {v0, v2}, Lcom/livemixtapes/ui/FadeImageButton;->setColorFilter(I)V

    .line 44
    const-string v0, "FadeButton"

    const-string v1, "Lightened"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 36
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
