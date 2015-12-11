.class Lcom/a9/cameralibrary/CameraBgHelper$1;
.super Ljava/lang/Object;
.source "CameraBgHelper.java"

# interfaces
.implements Lcom/a9/cameralibrary/OnSurfaceCreatedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/a9/cameralibrary/CameraBgHelper;->resume(IIIILcom/a9/cameralibrary/CameraOpenMode;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/a9/cameralibrary/CameraBgHelper;


# direct methods
.method constructor <init>(Lcom/a9/cameralibrary/CameraBgHelper;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/a9/cameralibrary/CameraBgHelper$1;->this$0:Lcom/a9/cameralibrary/CameraBgHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public adjustSurfaceSize(DI)Landroid/graphics/Point;
    .locals 15
    .param p1, "a_aspectRatio"    # D
    .param p3, "a_orientation"    # I

    .prologue
    .line 57
    move/from16 v0, p3

    rem-int/lit16 v11, v0, 0xb4

    const/16 v12, 0x5a

    if-ne v11, v12, :cond_4

    const/4 v4, 0x1

    .line 59
    .local v4, "isPortrait":Z
    :goto_0
    iget-object v11, p0, Lcom/a9/cameralibrary/CameraBgHelper$1;->this$0:Lcom/a9/cameralibrary/CameraBgHelper;

    # getter for: Lcom/a9/cameralibrary/CameraBgHelper;->m_activity:Landroid/app/Activity;
    invoke-static {v11}, Lcom/a9/cameralibrary/CameraBgHelper;->access$000(Lcom/a9/cameralibrary/CameraBgHelper;)Landroid/app/Activity;

    move-result-object v11

    invoke-virtual {v11}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v11

    invoke-interface {v11}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    .line 61
    .local v3, "display":Landroid/view/Display;
    sget v11, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v12, 0xd

    if-lt v11, v12, :cond_5

    .line 62
    new-instance v8, Landroid/graphics/Point;

    invoke-direct {v8}, Landroid/graphics/Point;-><init>()V

    .line 63
    .local v8, "size":Landroid/graphics/Point;
    invoke-virtual {v3, v8}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 64
    iget v10, v8, Landroid/graphics/Point;->x:I

    .line 65
    .local v10, "windowWidth":I
    iget v9, v8, Landroid/graphics/Point;->y:I

    .line 71
    .end local v8    # "size":Landroid/graphics/Point;
    .local v9, "windowHeight":I
    :goto_1
    const/4 v5, 0x0

    .line 72
    .local v5, "leftMargin":I
    int-to-double v11, v10

    int-to-double v13, v9

    div-double v1, v11, v13

    .line 74
    .local v1, "currentRatio":D
    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    cmpg-double v11, v1, v11

    if-gez v11, :cond_0

    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    cmpl-double v11, p1, v11

    if-gtz v11, :cond_1

    :cond_0
    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    cmpl-double v11, v1, v11

    if-lez v11, :cond_2

    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    cmpg-double v11, p1, v11

    if-gez v11, :cond_2

    .line 75
    :cond_1
    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    div-double p1, v11, p1

    .line 79
    :cond_2
    cmpl-double v11, v1, p1

    if-lez v11, :cond_6

    .line 81
    int-to-double v11, v10

    div-double v11, v11, p1

    double-to-int v9, v11

    .line 95
    :cond_3
    :goto_2
    iget-object v11, p0, Lcom/a9/cameralibrary/CameraBgHelper$1;->this$0:Lcom/a9/cameralibrary/CameraBgHelper;

    # getter for: Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraPreviewLayout:Landroid/widget/FrameLayout;
    invoke-static {v11}, Lcom/a9/cameralibrary/CameraBgHelper;->access$100(Lcom/a9/cameralibrary/CameraBgHelper;)Landroid/widget/FrameLayout;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/widget/FrameLayout$LayoutParams;

    .line 96
    .local v6, "lp":Landroid/widget/FrameLayout$LayoutParams;
    iput v10, v6, Landroid/widget/FrameLayout$LayoutParams;->width:I

    .line 97
    iput v9, v6, Landroid/widget/FrameLayout$LayoutParams;->height:I

    .line 98
    const/4 v11, 0x0

    iput v11, v6, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    .line 99
    iput v5, v6, Landroid/widget/FrameLayout$LayoutParams;->leftMargin:I

    .line 100
    iget-object v11, p0, Lcom/a9/cameralibrary/CameraBgHelper$1;->this$0:Lcom/a9/cameralibrary/CameraBgHelper;

    # getter for: Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraPreviewLayout:Landroid/widget/FrameLayout;
    invoke-static {v11}, Lcom/a9/cameralibrary/CameraBgHelper;->access$100(Lcom/a9/cameralibrary/CameraBgHelper;)Landroid/widget/FrameLayout;

    move-result-object v11

    invoke-virtual {v11, v6}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 103
    if-eqz v4, :cond_8

    new-instance v11, Landroid/graphics/Point;

    invoke-direct {v11, v9, v10}, Landroid/graphics/Point;-><init>(II)V

    :goto_3
    return-object v11

    .line 57
    .end local v1    # "currentRatio":D
    .end local v3    # "display":Landroid/view/Display;
    .end local v4    # "isPortrait":Z
    .end local v5    # "leftMargin":I
    .end local v6    # "lp":Landroid/widget/FrameLayout$LayoutParams;
    .end local v9    # "windowHeight":I
    .end local v10    # "windowWidth":I
    :cond_4
    const/4 v4, 0x0

    goto :goto_0

    .line 68
    .restart local v3    # "display":Landroid/view/Display;
    .restart local v4    # "isPortrait":Z
    :cond_5
    invoke-virtual {v3}, Landroid/view/Display;->getWidth()I

    move-result v10

    .line 69
    .restart local v10    # "windowWidth":I
    invoke-virtual {v3}, Landroid/view/Display;->getHeight()I

    move-result v9

    .restart local v9    # "windowHeight":I
    goto :goto_1

    .line 82
    .restart local v1    # "currentRatio":D
    .restart local v5    # "leftMargin":I
    :cond_6
    cmpg-double v11, v1, p1

    if-gez v11, :cond_7

    .line 84
    move v7, v10

    .line 85
    .local v7, "oldWindowWidth":I
    int-to-double v11, v9

    mul-double v11, v11, p1

    double-to-int v10, v11

    .line 86
    if-eqz v4, :cond_3

    .line 88
    sub-int v5, v7, v10

    goto :goto_2

    .line 90
    .end local v7    # "oldWindowWidth":I
    :cond_7
    cmpl-double v11, v1, p1

    if-nez v11, :cond_3

    goto :goto_2

    .line 103
    .restart local v6    # "lp":Landroid/widget/FrameLayout$LayoutParams;
    :cond_8
    new-instance v11, Landroid/graphics/Point;

    invoke-direct {v11, v10, v9}, Landroid/graphics/Point;-><init>(II)V

    goto :goto_3
.end method
