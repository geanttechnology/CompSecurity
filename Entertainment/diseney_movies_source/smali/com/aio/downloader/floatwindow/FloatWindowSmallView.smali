.class public Lcom/aio/downloader/floatwindow/FloatWindowSmallView;
.super Landroid/widget/LinearLayout;
.source "FloatWindowSmallView.java"


# static fields
.field public static percentView:Landroid/widget/TextView;

.field private static statusBarHeight:I

.field public static viewHeight:I

.field public static viewWidth:I

.field public static xLoa:I


# instance fields
.field private height:I

.field private iv_bigview:Landroid/widget/ImageView;

.field private mParams:Landroid/view/WindowManager$LayoutParams;

.field private view:Landroid/view/View;

.field private width:I

.field private windowManager:Landroid/view/WindowManager;

.field private xDownInScreen:F

.field private xInScreen:F

.field private xInView:F

.field private yDownInScreen:F

.field private yInScreen:F

.field private yInView:F


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x0

    sput v0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xLoa:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 94
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 98
    const-string v1, "window"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    .line 97
    iput-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->windowManager:Landroid/view/WindowManager;

    .line 100
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f030046

    invoke-virtual {v1, v2, p0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 101
    const v1, 0x7f0701eb

    invoke-virtual {p0, v1}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->view:Landroid/view/View;

    .line 102
    iget-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->view:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v1, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    sput v1, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->viewWidth:I

    .line 103
    iget-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->view:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v1, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    sput v1, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->viewHeight:I

    .line 104
    const v1, 0x7f0701ec

    invoke-virtual {p0, v1}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    sput-object v1, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->percentView:Landroid/widget/TextView;

    .line 105
    const v1, 0x7f0701ed

    invoke-virtual {p0, v1}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->iv_bigview:Landroid/widget/ImageView;

    .line 108
    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 109
    const-string v2, "window"

    .line 108
    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 110
    .local v0, "wm":Landroid/view/WindowManager;
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Display;->getWidth()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->width:I

    .line 111
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Display;->getHeight()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->height:I

    .line 122
    return-void
.end method

.method private ViewPosition()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 204
    iget v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInScreen:F

    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->width:I

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 205
    sput v2, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xLoa:I

    .line 206
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->width:I

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 207
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInScreen:F

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInView:F

    sub-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 208
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->windowManager:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, p0, v1}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 209
    sget-object v0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->percentView:Landroid/widget/TextView;

    .line 210
    const v1, 0x7f0200b2

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 220
    :goto_0
    return-void

    .line 212
    :cond_0
    const/4 v0, 0x1

    sput v0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xLoa:I

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    iput v2, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 214
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInScreen:F

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInView:F

    sub-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 215
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->windowManager:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, p0, v1}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 216
    sget-object v0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->percentView:Landroid/widget/TextView;

    .line 217
    const v1, 0x7f0200b3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundResource(I)V

    goto :goto_0
.end method

.method private getStatusBarHeight()I
    .locals 6

    .prologue
    .line 234
    sget v5, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->statusBarHeight:I

    if-nez v5, :cond_0

    .line 236
    :try_start_0
    const-string v5, "com.android.internal.R$dimen"

    invoke-static {v5}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 237
    .local v0, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v3

    .line 238
    .local v3, "o":Ljava/lang/Object;
    const-string v5, "status_bar_height"

    invoke-virtual {v0, v5}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    .line 239
    .local v2, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v2, v3}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v4

    .line 240
    .local v4, "x":I
    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    sput v5, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->statusBarHeight:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 245
    .end local v0    # "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "field":Ljava/lang/reflect/Field;
    .end local v3    # "o":Ljava/lang/Object;
    .end local v4    # "x":I
    :cond_0
    :goto_0
    sget v5, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->statusBarHeight:I

    return v5

    .line 241
    :catch_0
    move-exception v1

    .line 242
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private openBigWindow()V
    .locals 1

    .prologue
    .line 224
    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->createBigWindow(Landroid/content/Context;)V

    .line 225
    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->removeSmallWindow(Landroid/content/Context;)V

    .line 226
    return-void
.end method

.method private updateViewPosition()V
    .locals 3

    .prologue
    .line 197
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInScreen:F

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInView:F

    sub-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 198
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInScreen:F

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInView:F

    sub-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 199
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->windowManager:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, p0, v1}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 200
    return-void
.end method


# virtual methods
.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/high16 v5, -0x3e600000    # -20.0f

    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 127
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 182
    :cond_0
    :goto_0
    const/4 v1, 0x1

    return v1

    .line 130
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInView:F

    .line 131
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInView:F

    .line 133
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xDownInScreen:F

    .line 134
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v1

    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getStatusBarHeight()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yDownInScreen:F

    .line 136
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInScreen:F

    .line 137
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v1

    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getStatusBarHeight()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInScreen:F

    goto :goto_0

    .line 142
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInScreen:F

    .line 143
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v1

    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getStatusBarHeight()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    iput v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInScreen:F

    .line 145
    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->updateViewPosition()V

    .line 147
    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInScreen:F

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->width:I

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_1

    .line 148
    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->width:I

    int-to-float v1, v1

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInScreen:F

    sub-float/2addr v1, v2

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->width:I

    div-int/lit8 v2, v2, 0x8

    int-to-float v2, v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    .line 149
    sget-object v1, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->percentView:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 150
    iget-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->iv_bigview:Landroid/widget/ImageView;

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 153
    :cond_1
    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInScreen:F

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->width:I

    div-int/lit8 v2, v2, 0x8

    int-to-float v2, v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    .line 154
    sget-object v1, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->percentView:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 155
    iget-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->iv_bigview:Landroid/widget/ImageView;

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_0

    .line 162
    :pswitch_2
    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xDownInScreen:F

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xInScreen:F

    sub-float/2addr v1, v2

    cmpl-float v1, v1, v5

    if-ltz v1, :cond_2

    .line 163
    iget v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yDownInScreen:F

    iget v2, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->yInScreen:F

    sub-float/2addr v1, v2

    cmpl-float v1, v1, v5

    if-ltz v1, :cond_2

    .line 165
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 166
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 167
    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 170
    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->ViewPosition()V

    .line 171
    invoke-virtual {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "float_click"

    invoke-static {v1, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 177
    .end local v0    # "intent":Landroid/content/Intent;
    :goto_1
    sget-object v1, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->percentView:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 178
    iget-object v1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->iv_bigview:Landroid/widget/ImageView;

    invoke-virtual {v1, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_0

    .line 173
    :cond_2
    invoke-direct {p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->ViewPosition()V

    goto :goto_1

    .line 127
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public setParams(Landroid/view/WindowManager$LayoutParams;)V
    .locals 0
    .param p1, "params"    # Landroid/view/WindowManager$LayoutParams;

    .prologue
    .line 192
    iput-object p1, p0, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->mParams:Landroid/view/WindowManager$LayoutParams;

    .line 193
    return-void
.end method
