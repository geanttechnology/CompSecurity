.class public Lcom/aio/downloader/cleaner/ShowCleanActivity1;
.super Landroid/app/Activity;
.source "ShowCleanActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;,
        Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;
    }
.end annotation


# instance fields
.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private animation1:Landroid/view/animation/Animation;

.field private button1:Landroid/widget/Button;

.field private cishu:I

.field private cont:D

.field private fankui:I

.field private finish:Landroid/widget/Button;

.field private flag:Z

.field private handler:Landroid/os/Handler;

.field private header_left_showclean:Lcom/aio/downloader/views/LImageButton;

.field private iv_cleanfinish:Landroid/widget/ImageView;

.field private iv_star:Landroid/widget/ImageView;

.field private lp:Landroid/view/ViewGroup$LayoutParams;

.field private mCenterX:F

.field private mCenterY:F

.field private mContainer:Landroid/view/View;

.field private mDepthZ:F

.field private mDuration:I

.field private mImageView1:Landroid/widget/ImageView;

.field private mImageView2:Landroid/widget/ImageView;

.field private mIndex:I

.field private mStartAnimView:Landroid/widget/ImageView;

.field private maintotop:Lcom/aio/downloader/views/LImageButton;

.field private pingfen:I

.field private rl:Landroid/widget/RelativeLayout;

.field private rl_rub_bottomm:Landroid/widget/RelativeLayout;

.field private roundDouble:Ljava/lang/Double;

.field private roundDouble1:Ljava/lang/Double;

.field private textView1:Landroid/widget/TextView;

.field private tv_jieguo:Landroid/widget/TextView;

.field private tv_junk_title:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 54
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 57
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->flag:Z

    .line 58
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D

    .line 71
    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView1:Landroid/widget/ImageView;

    .line 72
    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView2:Landroid/widget/ImageView;

    .line 73
    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mStartAnimView:Landroid/widget/ImageView;

    .line 74
    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mContainer:Landroid/view/View;

    .line 75
    const/16 v0, 0x1f4

    iput v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mDuration:I

    .line 76
    iput v3, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterX:F

    .line 77
    iput v3, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterY:F

    .line 78
    iput v3, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mDepthZ:F

    .line 79
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mIndex:I

    .line 81
    new-instance v0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$1;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->handler:Landroid/os/Handler;

    .line 95
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 96
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR_FOME:Ljava/io/File;

    .line 97
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 98
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR_TO:Ljava/io/File;

    .line 99
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 100
    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR:Ljava/io/File;

    .line 54
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->button1:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->finish:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)F
    .locals 1

    .prologue
    .line 77
    iget v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterY:F

    return v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)F
    .locals 1

    .prologue
    .line 78
    iget v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mDepthZ:F

    return v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)I
    .locals 1

    .prologue
    .line 75
    iget v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mDuration:I

    return v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/cleaner/ShowCleanActivity1;F)V
    .locals 0

    .prologue
    .line 76
    iput p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterX:F

    return-void
.end method

.method static synthetic access$14(Lcom/aio/downloader/cleaner/ShowCleanActivity1;F)V
    .locals 0

    .prologue
    .line 77
    iput p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterY:F

    return-void
.end method

.method static synthetic access$15(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Landroid/view/View;FF)V
    .locals 0

    .prologue
    .line 332
    invoke-direct {p0, p1, p2, p3}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->applyRotation(Landroid/view/View;FF)V

    return-void
.end method

.method static synthetic access$16(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Z
    .locals 1

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->flag:Z

    return v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)D
    .locals 2

    .prologue
    .line 58
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D

    return-wide v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/cleaner/ShowCleanActivity1;D)V
    .locals 0

    .prologue
    .line 58
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D

    return-void
.end method

.method static synthetic access$19(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->tv_jieguo:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/view/View;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mContainer:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Ljava/lang/Double;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble1:Ljava/lang/Double;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Z)V
    .locals 0

    .prologue
    .line 57
    iput-boolean p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->flag:Z

    return-void
.end method

.method static synthetic access$22(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$23(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$24(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$25(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView1:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView2:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)I
    .locals 1

    .prologue
    .line 79
    iget v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mIndex:I

    return v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/cleaner/ShowCleanActivity1;I)V
    .locals 0

    .prologue
    .line 79
    iput p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mIndex:I

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mStartAnimView:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mStartAnimView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)F
    .locals 1

    .prologue
    .line 76
    iget v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterX:F

    return v0
.end method

.method private applyRotation(Landroid/view/View;FF)V
    .locals 7
    .param p1, "animView"    # Landroid/view/View;
    .param p2, "startAngle"    # F
    .param p3, "toAngle"    # F

    .prologue
    const/4 v6, 0x1

    .line 333
    iget v3, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterX:F

    .line 334
    .local v3, "centerX":F
    iget v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterY:F

    .line 335
    .local v4, "centerY":F
    new-instance v0, Lcom/aio/downloader/views/Rotate3dAnimation;

    .line 336
    iget v5, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mDepthZ:F

    move v1, p2

    move v2, p3

    .line 335
    invoke-direct/range {v0 .. v6}, Lcom/aio/downloader/views/Rotate3dAnimation;-><init>(FFFFFZ)V

    .line 337
    .local v0, "rotation":Lcom/aio/downloader/views/Rotate3dAnimation;
    iget v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mDuration:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/views/Rotate3dAnimation;->setDuration(J)V

    .line 338
    invoke-virtual {v0, v6}, Lcom/aio/downloader/views/Rotate3dAnimation;->setFillAfter(Z)V

    .line 339
    new-instance v1, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/Rotate3dAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 340
    new-instance v1, Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Lcom/aio/downloader/cleaner/ShowCleanActivity1$DisplayNextView;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/Rotate3dAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 341
    invoke-virtual {p1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 342
    return-void
.end method

.method public static getmem_TOLAL()J
    .locals 12

    .prologue
    .line 266
    const-string v9, "/proc/meminfo"

    .line 267
    .local v9, "path":Ljava/lang/String;
    const/4 v3, 0x0

    .line 268
    .local v3, "content":Ljava/lang/String;
    const/4 v1, 0x0

    .line 270
    .local v1, "br":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/FileReader;

    invoke-direct {v10, v9}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    const/16 v11, 0x8

    invoke-direct {v2, v10, v11}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 272
    .end local v1    # "br":Ljava/io/BufferedReader;
    .local v2, "br":Ljava/io/BufferedReader;
    :try_start_1
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v6

    .local v6, "line":Ljava/lang/String;
    if-eqz v6, :cond_0

    .line 273
    move-object v3, v6

    .line 280
    :cond_0
    if-eqz v2, :cond_3

    .line 282
    :try_start_2
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5

    move-object v1, v2

    .line 289
    .end local v2    # "br":Ljava/io/BufferedReader;
    .end local v6    # "line":Ljava/lang/String;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    :cond_1
    :goto_0
    const/16 v10, 0x3a

    invoke-virtual {v3, v10}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 291
    .local v0, "begin":I
    const/16 v10, 0x6b

    invoke-virtual {v3, v10}, Ljava/lang/String;->indexOf(I)I

    move-result v5

    .line 294
    .local v5, "end":I
    add-int/lit8 v10, v0, 0x1

    invoke-virtual {v3, v10, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 295
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    int-to-long v7, v10

    .line 296
    .local v7, "mTotal":J
    return-wide v7

    .line 275
    .end local v0    # "begin":I
    .end local v5    # "end":I
    .end local v7    # "mTotal":J
    :catch_0
    move-exception v4

    .line 276
    .local v4, "e":Ljava/io/FileNotFoundException;
    :goto_1
    :try_start_3
    invoke-virtual {v4}, Ljava/io/FileNotFoundException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 280
    if-eqz v1, :cond_1

    .line 282
    :try_start_4
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_0

    .line 283
    :catch_1
    move-exception v4

    .line 284
    .local v4, "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 277
    .end local v4    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v4

    .line 278
    .restart local v4    # "e":Ljava/io/IOException;
    :goto_2
    :try_start_5
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 280
    if-eqz v1, :cond_1

    .line 282
    :try_start_6
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3

    goto :goto_0

    .line 283
    :catch_3
    move-exception v4

    .line 284
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 279
    .end local v4    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v10

    .line 280
    :goto_3
    if-eqz v1, :cond_2

    .line 282
    :try_start_7
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4

    .line 287
    :cond_2
    :goto_4
    throw v10

    .line 283
    :catch_4
    move-exception v4

    .line 284
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 283
    .end local v1    # "br":Ljava/io/BufferedReader;
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    .restart local v6    # "line":Ljava/lang/String;
    :catch_5
    move-exception v4

    .line 284
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .end local v4    # "e":Ljava/io/IOException;
    :cond_3
    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_0

    .line 279
    .end local v1    # "br":Ljava/io/BufferedReader;
    .end local v6    # "line":Ljava/lang/String;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catchall_1
    move-exception v10

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_3

    .line 277
    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catch_6
    move-exception v4

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_2

    .line 275
    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catch_7
    move-exception v4

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_1
.end method

.method public static roundDouble(DI)Ljava/lang/Double;
    .locals 8
    .param p0, "val"    # D
    .param p2, "precision"    # I

    .prologue
    .line 300
    const/4 v3, 0x0

    .line 302
    .local v3, "ret":Ljava/lang/Double;
    const-wide/high16 v4, 0x4024000000000000L    # 10.0

    int-to-double v6, p2

    :try_start_0
    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v1

    .line 303
    .local v1, "factor":D
    mul-double v4, p0, v1

    const-wide/high16 v6, 0x3fe0000000000000L    # 0.5

    add-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    div-double/2addr v4, v1

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 307
    .end local v1    # "factor":D
    :goto_0
    return-object v3

    .line 304
    :catch_0
    move-exception v0

    .line 305
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 393
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 12
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const v11, 0x7f0b0079

    const v5, 0x7f0702c4

    const/4 v6, 0x0

    const/4 v10, 0x2

    const-wide/high16 v8, 0x4090000000000000L    # 1024.0

    .line 106
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 107
    const v4, 0x7f0300b0

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->setContentView(I)V

    .line 110
    const v4, 0x7f070037

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView1:Landroid/widget/ImageView;

    .line 111
    const v4, 0x7f0703c7

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView2:Landroid/widget/ImageView;

    .line 112
    const v4, 0x7f070075

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mContainer:Landroid/view/View;

    .line 113
    const v4, 0x7f0703ca

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->finish:Landroid/widget/Button;

    .line 114
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView1:Landroid/widget/ImageView;

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mStartAnimView:Landroid/widget/ImageView;

    .line 115
    const-string v4, "input_method"

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 117
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getWindow()Landroid/view/Window;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v4

    .line 116
    invoke-virtual {v0, v4, v10}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 120
    invoke-virtual {p0, v5}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->button1:Landroid/widget/Button;

    .line 121
    invoke-virtual {p0, v5}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 122
    new-instance v5, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;

    invoke-direct {v5, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V

    .line 121
    invoke-virtual {v4, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 132
    const v4, 0x7f0703c3

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/LImageButton;

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->header_left_showclean:Lcom/aio/downloader/views/LImageButton;

    .line 133
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->header_left_showclean:Lcom/aio/downloader/views/LImageButton;

    new-instance v5, Lcom/aio/downloader/cleaner/ShowCleanActivity1$3;

    invoke-direct {v5, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$3;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    const v4, 0x7f0703c4

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->tv_junk_title:Landroid/widget/TextView;

    .line 141
    const v4, 0x7f0703c8

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->tv_jieguo:Landroid/widget/TextView;

    .line 142
    const v4, 0x7f0703c9

    invoke-virtual {p0, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 143
    .local v3, "tv_zongneicun":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "juti"

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    .line 144
    .local v2, "juti":I
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "junk"

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 145
    .local v1, "junk":I
    const/4 v4, 0x1

    if-ne v1, v4, :cond_0

    .line 146
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->tv_junk_title:Landroid/widget/TextView;

    const-string v5, "Junk Files"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 148
    :cond_0
    const-string v4, "fff"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "---0000juti000---"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 149
    int-to-double v4, v2

    div-double/2addr v4, v8

    invoke-static {v4, v5, v10}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble1:Ljava/lang/Double;

    .line 150
    const-string v4, "fff"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble1:Ljava/lang/Double;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "---0000000---"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 151
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble1:Ljava/lang/Double;

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/high16 v6, 0x4034000000000000L    # 20.0

    cmpg-double v4, v4, v6

    if-gez v4, :cond_1

    .line 152
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->tv_jieguo:Landroid/widget/TextView;

    const-string v5, "Very clean!"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 153
    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 156
    :cond_1
    new-instance v4, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V

    .line 191
    invoke-virtual {v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->start()V

    .line 194
    invoke-static {}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getmem_TOLAL()J

    move-result-wide v4

    const-wide/16 v6, 0x400

    div-long/2addr v4, v6

    const-wide/16 v6, 0x400

    div-long/2addr v4, v6

    const-wide/16 v6, 0x1

    cmp-long v4, v4, v6

    if-ltz v4, :cond_2

    .line 196
    invoke-static {}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getmem_TOLAL()J

    move-result-wide v4

    long-to-double v4, v4

    div-double/2addr v4, v8

    div-double/2addr v4, v8

    invoke-static {v4, v5, v10}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble:Ljava/lang/Double;

    .line 197
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 198
    invoke-virtual {v5, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble:Ljava/lang/Double;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "GB"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 197
    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 204
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->finish:Landroid/widget/Button;

    new-instance v5, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;

    invoke-direct {v5, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 262
    return-void

    .line 200
    :cond_2
    invoke-static {}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getmem_TOLAL()J

    move-result-wide v4

    long-to-double v4, v4

    div-double/2addr v4, v8

    invoke-static {v4, v5, v10}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble:Ljava/lang/Double;

    .line 201
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 202
    invoke-virtual {v5, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble:Ljava/lang/Double;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "MB"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 201
    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 385
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 387
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 313
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 327
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 328
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 329
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 320
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 321
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 322
    return-void
.end method
