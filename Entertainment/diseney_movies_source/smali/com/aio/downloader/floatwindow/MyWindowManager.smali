.class public Lcom/aio/downloader/floatwindow/MyWindowManager;
.super Ljava/lang/Object;
.source "MyWindowManager.java"


# static fields
.field private static bigWindow:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

.field private static bigWindowParams:Landroid/view/WindowManager$LayoutParams;

.field private static mActivityManager:Landroid/app/ActivityManager;

.field private static mWindowManager:Landroid/view/WindowManager;

.field private static smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

.field private static smallWindowParams:Landroid/view/WindowManager$LayoutParams;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createBigWindow(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 103
    invoke-static {p0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->getWindowManager(Landroid/content/Context;)Landroid/view/WindowManager;

    move-result-object v2

    .line 104
    .local v2, "windowManager":Landroid/view/WindowManager;
    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Display;->getWidth()I

    move-result v1

    .line 105
    .local v1, "screenWidth":I
    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Display;->getHeight()I

    move-result v0

    .line 107
    .local v0, "screenHeight":I
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindow:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    if-nez v3, :cond_0

    .line 108
    new-instance v3, Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    invoke-direct {v3, p0}, Lcom/aio/downloader/floatwindow/FloatWindowBigView;-><init>(Landroid/content/Context;)V

    sput-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindow:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    .line 109
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    if-nez v3, :cond_0

    .line 110
    new-instance v3, Landroid/view/WindowManager$LayoutParams;

    invoke-direct {v3}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    sput-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    .line 111
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    div-int/lit8 v4, v1, 0x2

    .line 112
    sget v5, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->viewWidth:I

    div-int/lit8 v5, v5, 0x2

    sub-int/2addr v4, v5

    .line 111
    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 113
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    div-int/lit8 v4, v0, 0x2

    .line 114
    sget v5, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->viewHeight:I

    div-int/lit8 v5, v5, 0x2

    sub-int/2addr v4, v5

    .line 113
    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 115
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    const/16 v4, 0x7d2

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->type:I

    .line 116
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    const/4 v4, 0x1

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->format:I

    .line 117
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    const/16 v4, 0x33

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->gravity:I

    .line 118
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    sget v4, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->viewWidth:I

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 119
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    sget v4, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->viewHeight:I

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 122
    :cond_0
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindow:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    sget-object v4, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindowParams:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v2, v3, v4}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 124
    return-void
.end method

.method public static createSmallWindow(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v5, 0x1

    .line 51
    invoke-static {p0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->getWindowManager(Landroid/content/Context;)Landroid/view/WindowManager;

    move-result-object v2

    .line 52
    .local v2, "windowManager":Landroid/view/WindowManager;
    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Display;->getWidth()I

    move-result v1

    .line 53
    .local v1, "screenWidth":I
    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Display;->getHeight()I

    move-result v0

    .line 55
    .local v0, "screenHeight":I
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    if-nez v3, :cond_1

    .line 56
    new-instance v3, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    invoke-direct {v3, p0}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;-><init>(Landroid/content/Context;)V

    sput-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    .line 57
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    if-nez v3, :cond_0

    .line 58
    new-instance v3, Landroid/view/WindowManager$LayoutParams;

    invoke-direct {v3}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    sput-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    .line 59
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    iput v1, v3, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 60
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    div-int/lit8 v4, v0, 0x2

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 61
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    const/16 v4, 0x7d2

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->type:I

    .line 62
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    iput v5, v3, Landroid/view/WindowManager$LayoutParams;->format:I

    .line 63
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    const/16 v4, 0x33

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->gravity:I

    .line 64
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    sget v4, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->viewWidth:I

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 65
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    sget v4, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->viewHeight:I

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 66
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    const/16 v4, 0x28

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->flags:I

    .line 69
    :cond_0
    sget v3, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xLoa:I

    if-nez v3, :cond_2

    .line 70
    sget-object v3, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->percentView:Landroid/widget/TextView;

    const v4, 0x7f0200b2

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 75
    :cond_1
    :goto_0
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v4, "\u6dfb\u52a0\u5c0f\u60ac\u6d6e\u7a97"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 76
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    sget-object v4, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    invoke-virtual {v3, v4}, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->setParams(Landroid/view/WindowManager$LayoutParams;)V

    .line 77
    sget-object v3, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    sget-object v4, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindowParams:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v2, v3, v4}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 79
    return-void

    .line 71
    :cond_2
    sget v3, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->xLoa:I

    if-ne v3, v5, :cond_1

    .line 72
    sget-object v3, Lcom/aio/downloader/floatwindow/FloatWindowSmallView;->percentView:Landroid/widget/TextView;

    const v4, 0x7f0200b3

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setBackgroundResource(I)V

    goto :goto_0
.end method

.method private static getActivityManager(Landroid/content/Context;)Landroid/app/ActivityManager;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 193
    sget-object v0, Lcom/aio/downloader/floatwindow/MyWindowManager;->mActivityManager:Landroid/app/ActivityManager;

    if-nez v0, :cond_0

    .line 195
    const-string v0, "activity"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 194
    check-cast v0, Landroid/app/ActivityManager;

    sput-object v0, Lcom/aio/downloader/floatwindow/MyWindowManager;->mActivityManager:Landroid/app/ActivityManager;

    .line 197
    :cond_0
    sget-object v0, Lcom/aio/downloader/floatwindow/MyWindowManager;->mActivityManager:Landroid/app/ActivityManager;

    return-object v0
.end method

.method private static getAvailableMemory(Landroid/content/Context;)J
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 236
    new-instance v0, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v0}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 237
    .local v0, "mi":Landroid/app/ActivityManager$MemoryInfo;
    invoke-static {p0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->getActivityManager(Landroid/content/Context;)Landroid/app/ActivityManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 238
    iget-wide v1, v0, Landroid/app/ActivityManager$MemoryInfo;->availMem:J

    return-wide v1
.end method

.method public static getUsedPercentValue(Landroid/content/Context;)Ljava/lang/String;
    .locals 15
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 208
    const-string v3, "/proc/meminfo"

    .line 210
    .local v3, "dir":Ljava/lang/String;
    :try_start_0
    new-instance v5, Ljava/io/FileReader;

    invoke-direct {v5, v3}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    .line 211
    .local v5, "fr":Ljava/io/FileReader;
    new-instance v2, Ljava/io/BufferedReader;

    invoke-direct {v2, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 212
    .local v2, "br":Ljava/io/BufferedReader;
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v6

    .line 214
    .local v6, "memoryLine":Ljava/lang/String;
    const-string v11, "MemTotal:"

    invoke-virtual {v6, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v11

    .line 213
    invoke-virtual {v6, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    .line 215
    .local v8, "subMemoryLine":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    .line 217
    const-string v11, "\\D+"

    const-string v12, ""

    .line 216
    invoke-virtual {v8, v11, v12}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v11

    int-to-long v9, v11

    .line 218
    .local v9, "totalMemorySize":J
    invoke-static {p0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->getAvailableMemory(Landroid/content/Context;)J

    move-result-wide v11

    const-wide/16 v13, 0x400

    div-long v0, v11, v13

    .line 219
    .local v0, "availableSize":J
    sub-long v11, v9, v0

    long-to-float v11, v11

    .line 220
    long-to-float v12, v9

    .line 219
    div-float/2addr v11, v12

    .line 220
    const/high16 v12, 0x42c80000    # 100.0f

    .line 219
    mul-float/2addr v11, v12

    float-to-int v7, v11

    .line 221
    .local v7, "percent":I
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "%"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v11

    .line 225
    .end local v0    # "availableSize":J
    .end local v2    # "br":Ljava/io/BufferedReader;
    .end local v5    # "fr":Ljava/io/FileReader;
    .end local v6    # "memoryLine":Ljava/lang/String;
    .end local v7    # "percent":I
    .end local v8    # "subMemoryLine":Ljava/lang/String;
    .end local v9    # "totalMemorySize":J
    :goto_0
    return-object v11

    .line 222
    :catch_0
    move-exception v4

    .line 223
    .local v4, "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 225
    const-string v11, "0%"

    goto :goto_0
.end method

.method private static getWindowManager(Landroid/content/Context;)Landroid/view/WindowManager;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 178
    sget-object v0, Lcom/aio/downloader/floatwindow/MyWindowManager;->mWindowManager:Landroid/view/WindowManager;

    if-nez v0, :cond_0

    .line 180
    const-string v0, "window"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 179
    check-cast v0, Landroid/view/WindowManager;

    sput-object v0, Lcom/aio/downloader/floatwindow/MyWindowManager;->mWindowManager:Landroid/view/WindowManager;

    .line 182
    :cond_0
    sget-object v0, Lcom/aio/downloader/floatwindow/MyWindowManager;->mWindowManager:Landroid/view/WindowManager;

    return-object v0
.end method

.method public static isWindowShowing()Z
    .locals 1

    .prologue
    .line 166
    sget-object v0, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    if-nez v0, :cond_0

    sget-object v0, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindow:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static removeBigWindow(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 133
    sget-object v1, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindow:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    if-eqz v1, :cond_0

    .line 134
    invoke-static {p0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->getWindowManager(Landroid/content/Context;)Landroid/view/WindowManager;

    move-result-object v0

    .line 135
    .local v0, "windowManager":Landroid/view/WindowManager;
    sget-object v1, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindow:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeView(Landroid/view/View;)V

    .line 136
    const/4 v1, 0x0

    sput-object v1, Lcom/aio/downloader/floatwindow/MyWindowManager;->bigWindow:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    .line 139
    .end local v0    # "windowManager":Landroid/view/WindowManager;
    :cond_0
    return-void
.end method

.method public static removeSmallWindow(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 88
    sget-object v1, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    if-eqz v1, :cond_0

    .line 89
    invoke-static {p0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->getWindowManager(Landroid/content/Context;)Landroid/view/WindowManager;

    move-result-object v0

    .line 90
    .local v0, "windowManager":Landroid/view/WindowManager;
    sget-object v1, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeView(Landroid/view/View;)V

    .line 91
    const/4 v1, 0x0

    sput-object v1, Lcom/aio/downloader/floatwindow/MyWindowManager;->smallWindow:Lcom/aio/downloader/floatwindow/FloatWindowSmallView;

    .line 94
    .end local v0    # "windowManager":Landroid/view/WindowManager;
    :cond_0
    return-void
.end method

.method public static updateUsedPercent(Landroid/content/Context;)V
    .locals 0
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 158
    return-void
.end method
